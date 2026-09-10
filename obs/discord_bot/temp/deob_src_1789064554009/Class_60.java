class Class_60 extends Class_91 {
   public static final float[] table_factor = new float[]{
      0.0F,
      0.6666667F,
      0.2857143F,
      0.13333334F,
      0.06451613F,
      0.031746034F,
      0.015748031F,
      0.007843138F,
      0.0039138943F,
      0.0019550342F,
      9.770396E-4F,
      4.884005E-4F,
      2.4417043E-4F,
      1.2207776E-4F,
      6.103702E-5F
   };
   public static final float[] table_offset = new float[]{
      0.0F,
      -0.6666667F,
      -0.8571429F,
      -0.9333334F,
      -0.9677419F,
      -0.98412704F,
      -0.992126F,
      -0.9960785F,
      -0.99804306F,
      -0.9990225F,
      -0.9995115F,
      -0.99975586F,
      -0.9998779F,
      -0.99993896F,
      -0.9999695F
   };
   protected int subbandnumber;
   protected int samplenumber;
   protected int allocation;
   protected float scalefactor;
   protected int samplelength;
   protected float sample;
   protected float factor;
   protected float offset;

   public Class_60(int subbandnumber) {
      this.subbandnumber = subbandnumber;
      this.samplenumber = 0;
   }

   @Override
   public void read_allocation(Class_371 stream, Class_412 header, Class_273 crc) throws Class_3 {
      if ((this.allocation = stream.method_199(4)) == 15) {
         throw new Class_3(514, null);
      } else {
         if (crc != null) {
            crc.method_372(this.allocation, 4);
         }

         if (this.allocation != 0) {
            this.samplelength = this.allocation + 1;
            this.factor = table_factor[this.allocation];
            this.offset = table_offset[this.allocation];
         }
      }
   }

   @Override
   public void read_scalefactor(Class_371 stream, Class_412 header) {
      if (this.allocation != 0) {
         this.scalefactor = scalefactors[stream.method_199(6)];
      }
   }

   @Override
   public boolean read_sampledata(Class_371 stream) {
      if (this.allocation != 0) {
         this.sample = (float)stream.method_199(this.samplelength);
      }

      if (++this.samplenumber == 12) {
         this.samplenumber = 0;
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean put_next_sample(int channels, Class_18 filter1, Class_18 filter2) {
      if (this.allocation != 0 && channels != 2) {
         float scaled_sample = (this.sample * this.factor + this.offset) * this.scalefactor;
         filter1.method_1342(scaled_sample, this.subbandnumber);
      }

      return true;
   }
}

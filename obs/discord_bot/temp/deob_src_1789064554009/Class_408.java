class Class_408 extends Class_60 {
   // $VF: renamed from: xb int
   protected int field_1356;
   // $VF: renamed from: sux float
   protected float field_1357;
   // $VF: renamed from: ii int
   protected int field_1358;
   // $VF: renamed from: foo float
   protected float field_1359;
   // $VF: renamed from: go float
   protected float field_1360;
   // $VF: renamed from: gcr float
   protected float field_1361;

   public Class_408(int subbandnumber) {
      super(subbandnumber);
   }

   @Override
   public void read_allocation(Class_371 stream, Class_412 header, Class_273 crc) throws Class_3 {
      this.allocation = stream.method_199(4);
      this.field_1356 = stream.method_199(4);
      if (crc != null) {
         crc.method_372(this.allocation, 4);
         crc.method_372(this.field_1356, 4);
      }

      if (this.allocation != 0) {
         this.samplelength = this.allocation + 1;
         this.factor = table_factor[this.allocation];
         this.offset = table_offset[this.allocation];
      }

      if (this.field_1356 != 0) {
         this.field_1358 = this.field_1356 + 1;
         this.field_1360 = table_factor[this.field_1356];
         this.field_1361 = table_offset[this.field_1356];
      }
   }

   @Override
   public void read_scalefactor(Class_371 stream, Class_412 header) {
      if (this.allocation != 0) {
         this.scalefactor = scalefactors[stream.method_199(6)];
      }

      if (this.field_1356 != 0) {
         this.field_1357 = scalefactors[stream.method_199(6)];
      }
   }

   @Override
   public boolean read_sampledata(Class_371 stream) {
      boolean returnvalue = super.read_sampledata(stream);
      if (this.field_1356 != 0) {
         this.field_1359 = (float)stream.method_199(this.field_1358);
      }

      return returnvalue;
   }

   @Override
   public boolean put_next_sample(int channels, Class_18 filter1, Class_18 filter2) {
      super.put_next_sample(channels, filter1, filter2);
      if (this.field_1356 != 0 && channels != 1) {
         float sample2 = (this.field_1359 * this.field_1360 + this.field_1361) * this.field_1357;
         if (channels == 0) {
            filter2.method_1342(sample2, this.subbandnumber);
         } else {
            filter1.method_1342(sample2, this.subbandnumber);
         }
      }

      return true;
   }
}

class Class_82 extends Class_60 {
   // $VF: renamed from: sux float
   protected float field_1362;

   public Class_82(int subbandnumber) {
      super(subbandnumber);
   }

   @Override
   public void read_allocation(Class_371 stream, Class_412 header, Class_273 crc) throws Class_3 {
      super.read_allocation(stream, header, crc);
   }

   @Override
   public void read_scalefactor(Class_371 stream, Class_412 header) {
      if (this.allocation != 0) {
         this.scalefactor = scalefactors[stream.method_199(6)];
         this.field_1362 = scalefactors[stream.method_199(6)];
      }
   }

   @Override
   public boolean read_sampledata(Class_371 stream) {
      return super.read_sampledata(stream);
   }

   @Override
   public boolean put_next_sample(int channels, Class_18 filter1, Class_18 filter2) {
      if (this.allocation != 0) {
         this.sample = this.sample * this.factor + this.offset;
         if (channels == 0) {
            float sample1 = this.sample * this.scalefactor;
            float sample2 = this.sample * this.field_1362;
            filter1.method_1342(sample1, this.subbandnumber);
            filter2.method_1342(sample2, this.subbandnumber);
         } else if (channels == 1) {
            float sample1 = this.sample * this.scalefactor;
            filter1.method_1342(sample1, this.subbandnumber);
         } else {
            float sample2 = this.sample * this.field_1362;
            filter1.method_1342(sample2, this.subbandnumber);
         }
      }

      return true;
   }
}

class Class_406 extends Class_257 {
   // $VF: renamed from: gb int
   protected int field_1403;
   // $VF: renamed from: bos float
   protected float field_1404;
   // $VF: renamed from: hhs float
   protected float field_1405;
   // $VF: renamed from: gen float
   protected float field_1406;

   public Class_406(int subbandnumber) {
      super(subbandnumber);
   }

   @Override
   public void read_allocation(Class_371 stream, Class_412 header, Class_273 crc) {
      super.read_allocation(stream, header, crc);
   }

   // $VF: renamed from: tou (Class_371, Class_273) void
   @Override
   public void method_1315(Class_371 stream, Class_273 crc) {
      if (this.allocation != 0) {
         this.scfsi = stream.method_199(2);
         this.field_1403 = stream.method_199(2);
         if (crc != null) {
            crc.method_372(this.scfsi, 2);
            crc.method_372(this.field_1403, 2);
         }
      }
   }

   @Override
   public void read_scalefactor(Class_371 stream, Class_412 header) {
      if (this.allocation != 0) {
         super.read_scalefactor(stream, header);
         switch (this.field_1403) {
            case 0:
               this.field_1404 = scalefactors[stream.method_199(6)];
               this.field_1405 = scalefactors[stream.method_199(6)];
               this.field_1406 = scalefactors[stream.method_199(6)];
               break;
            case 1:
               this.field_1404 = this.field_1405 = scalefactors[stream.method_199(6)];
               this.field_1406 = scalefactors[stream.method_199(6)];
               break;
            case 2:
               this.field_1404 = this.field_1405 = this.field_1406 = scalefactors[stream.method_199(6)];
               break;
            case 3:
               this.field_1404 = scalefactors[stream.method_199(6)];
               this.field_1405 = this.field_1406 = scalefactors[stream.method_199(6)];
         }
      }
   }

   @Override
   public boolean read_sampledata(Class_371 stream) {
      return super.read_sampledata(stream);
   }

   @Override
   public boolean put_next_sample(int channels, Class_18 filter1, Class_18 filter2) {
      if (this.allocation != 0) {
         float sample = this.samples[this.samplenumber];
         if (this.groupingtable[0] == null) {
            sample = (sample + this.d[0]) * this.c[0];
         }

         if (channels == 0) {
            float var9;
            if (this.groupnumber <= 4) {
               sample *= this.scalefactor1;
               var9 = sample * this.field_1404;
            } else if (this.groupnumber <= 8) {
               sample *= this.scalefactor2;
               var9 = sample * this.field_1405;
            } else {
               sample *= this.scalefactor3;
               var9 = sample * this.field_1406;
            }

            filter1.method_1342(sample, this.subbandnumber);
            filter2.method_1342(var9, this.subbandnumber);
         } else if (channels == 1) {
            if (this.groupnumber <= 4) {
               sample *= this.scalefactor1;
            } else if (this.groupnumber <= 8) {
               sample *= this.scalefactor2;
            } else {
               sample *= this.scalefactor3;
            }

            filter1.method_1342(sample, this.subbandnumber);
         } else {
            if (this.groupnumber <= 4) {
               sample *= this.field_1404;
            } else if (this.groupnumber <= 8) {
               sample *= this.field_1405;
            } else {
               sample *= this.field_1406;
            }

            filter1.method_1342(sample, this.subbandnumber);
         }
      }

      return ++this.samplenumber == 3;
   }
}

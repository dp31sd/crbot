class Class_22 extends Class_257 {
   // $VF: renamed from: xb int
   protected int field_1407;
   // $VF: renamed from: gb int
   protected int field_1408;
   // $VF: renamed from: bos float
   protected float field_1409;
   // $VF: renamed from: hhs float
   protected float field_1410;
   // $VF: renamed from: gen float
   protected float field_1411;
   // $VF: renamed from: pzz int[]
   protected int[] field_1412 = new int[]{0};
   // $VF: renamed from: qe float[]
   protected float[] field_1413 = new float[]{0.0F};
   // $VF: renamed from: gg float[]
   protected float[] field_1414;
   // $VF: renamed from: tqv float[]
   protected float[] field_1415 = new float[]{0.0F};
   // $VF: renamed from: bb float[]
   protected float[] field_1416 = new float[]{0.0F};

   public Class_22(int subbandnumber) {
      super(subbandnumber);
      this.field_1414 = new float[3];
   }

   @Override
   public void read_allocation(Class_371 stream, Class_412 header, Class_273 crc) {
      int length = this.get_allocationlength(header);
      this.allocation = stream.method_199(length);
      this.field_1407 = stream.method_199(length);
      if (crc != null) {
         crc.method_372(this.allocation, length);
         crc.method_372(this.field_1407, length);
      }
   }

   // $VF: renamed from: tou (Class_371, Class_273) void
   @Override
   public void method_1315(Class_371 stream, Class_273 crc) {
      if (this.allocation != 0) {
         this.scfsi = stream.method_199(2);
         if (crc != null) {
            crc.method_372(this.scfsi, 2);
         }
      }

      if (this.field_1407 != 0) {
         this.field_1408 = stream.method_199(2);
         if (crc != null) {
            crc.method_372(this.field_1408, 2);
         }
      }
   }

   @Override
   public void read_scalefactor(Class_371 stream, Class_412 header) {
      super.read_scalefactor(stream, header);
      if (this.field_1407 != 0) {
         switch (this.field_1408) {
            case 0:
               this.field_1409 = scalefactors[stream.method_199(6)];
               this.field_1410 = scalefactors[stream.method_199(6)];
               this.field_1411 = scalefactors[stream.method_199(6)];
               break;
            case 1:
               this.field_1409 = this.field_1410 = scalefactors[stream.method_199(6)];
               this.field_1411 = scalefactors[stream.method_199(6)];
               break;
            case 2:
               this.field_1409 = this.field_1410 = this.field_1411 = scalefactors[stream.method_199(6)];
               break;
            case 3:
               this.field_1409 = scalefactors[stream.method_199(6)];
               this.field_1410 = this.field_1411 = scalefactors[stream.method_199(6)];
         }

         this.prepare_sample_reading(header, this.field_1407, 1, this.field_1413, this.field_1412, this.field_1415, this.field_1416);
      }
   }

   @Override
   public boolean read_sampledata(Class_371 stream) {
      boolean returnvalue = super.read_sampledata(stream);
      if (this.field_1407 != 0) {
         if (this.groupingtable[1] != null) {
            int samplecode = stream.method_199(this.field_1412[0]);
            samplecode += samplecode << 1;
            float[] target = this.field_1414;
            float[] source = this.groupingtable[1];
            int tmp = 0;
            target[tmp] = source[samplecode];
            int temp = samplecode + 1;
            tmp++;
            target[tmp] = source[temp];
            temp++;
            tmp++;
            target[tmp] = source[temp];
         } else {
            this.field_1414[0] = (float)((double)((float)stream.method_199(this.field_1412[0]) * this.field_1413[0]) - 1.0);
            this.field_1414[1] = (float)((double)((float)stream.method_199(this.field_1412[0]) * this.field_1413[0]) - 1.0);
            this.field_1414[2] = (float)((double)((float)stream.method_199(this.field_1412[0]) * this.field_1413[0]) - 1.0);
         }
      }

      return returnvalue;
   }

   @Override
   public boolean put_next_sample(int channels, Class_18 filter1, Class_18 filter2) {
      boolean returnvalue = super.put_next_sample(channels, filter1, filter2);
      if (this.field_1407 != 0 && channels != 1) {
         float sample = this.field_1414[this.samplenumber - 1];
         if (this.groupingtable[1] == null) {
            sample = (sample + this.field_1416[0]) * this.field_1415[0];
         }

         if (this.groupnumber <= 4) {
            sample *= this.field_1409;
         } else if (this.groupnumber <= 8) {
            sample *= this.field_1410;
         } else {
            sample *= this.field_1411;
         }

         if (channels == 0) {
            filter2.method_1342(sample, this.subbandnumber);
         } else {
            filter1.method_1342(sample, this.subbandnumber);
         }
      }

      return returnvalue;
   }
}

class Class_153 implements Class_186 {
   // $VF: renamed from: azr Class_371
   protected Class_371 field_589;
   // $VF: renamed from: zvf Class_412
   protected Class_412 field_590;
   // $VF: renamed from: pcs Class_18
   protected Class_18 field_591;
   // $VF: renamed from: xqf Class_18
   protected Class_18 field_592;
   // $VF: renamed from: jmh Class_278
   protected Class_278 field_593;
   // $VF: renamed from: pcl int
   protected int field_594;
   // $VF: renamed from: ils int
   protected int field_595;
   protected int odhs;
   // $VF: renamed from: jzc Class_91[]
   protected Class_91[] field_596;
   protected Class_273 srtj = null;

   public Class_153() {
      this.srtj = new Class_273();
   }

   public void create(Class_371 stream0, Class_412 header0, Class_18 filtera, Class_18 filterb, Class_278 buffer0, int which_ch0) {
      this.field_589 = stream0;
      this.field_590 = header0;
      this.field_591 = filtera;
      this.field_592 = filterb;
      this.field_593 = buffer0;
      this.field_594 = which_ch0;
   }

   public void decodeFrame() throws Class_3 {
      this.odhs = this.field_590.method_74();
      this.field_596 = new Class_91[32];
      this.field_595 = this.field_590.method_50();
      this.createSubbands();
      this.readAllocation();
      this.readScaleFactorSelection();
      if (this.srtj != null || this.field_590.method_57()) {
         this.readScaleFactors();
         this.readSampleData();
      }
   }

   protected void createSubbands() {
      if (this.field_595 == 3) {
         for (int i = 0; i < this.odhs; i++) {
            this.field_596[i] = new Class_60(i);
         }
      } else if (this.field_595 == 1) {
         int i;
         for (i = 0; i < this.field_590.method_75(); i++) {
            this.field_596[i] = new Class_408(i);
         }

         while (i < this.odhs) {
            this.field_596[i] = new Class_82(i);
            i++;
         }
      } else {
         for (int i = 0; i < this.odhs; i++) {
            this.field_596[i] = new Class_408(i);
         }
      }
   }

   protected void readAllocation() throws Class_3 {
      for (int i = 0; i < this.odhs; i++) {
         this.field_596[i].read_allocation(this.field_589, this.field_590, this.srtj);
      }
   }

   protected void readScaleFactorSelection() {
   }

   protected void readScaleFactors() {
      for (int i = 0; i < this.odhs; i++) {
         this.field_596[i].read_scalefactor(this.field_589, this.field_590);
      }
   }

   protected void readSampleData() {
      boolean read_ready = false;
      boolean write_ready = false;
      int mode = this.field_590.method_50();

      do {
         for (int i = 0; i < this.odhs; i++) {
            read_ready = this.field_596[i].read_sampledata(this.field_589);
         }

         do {
            for (int var5 = 0; var5 < this.odhs; var5++) {
               write_ready = this.field_596[var5].put_next_sample(this.field_594, this.field_591, this.field_592);
            }

            this.field_591.method_1361(this.field_593);
            if (this.field_594 == 0 && mode != 3) {
               this.field_592.method_1361(this.field_593);
            }
         } while (!write_ready);
      } while (!read_ready);
   }
}

class Class_149 {
   // $VF: renamed from: lx short
   public short field_608;
   // $VF: renamed from: ujs short
   public short field_609;
   // $VF: renamed from: inx int
   public int field_610;
   // $VF: renamed from: kf int
   public int field_611;
   // $VF: renamed from: ply short
   public short field_612;
   // $VF: renamed from: zk short
   public short field_613;

   public Class_149(Class_120 var1) {
      this.field_614 = var1;
      this.field_608 = 0;
      this.field_609 = 0;
      this.field_610 = 0;
      this.field_611 = 0;
      this.field_612 = 0;
      this.field_613 = 0;
      this.field_608 = 1;
      this.method_645(44100, (short)16, (short)1);
   }

   // $VF: renamed from: lmw (int, short, short) void
   public void method_645(int NewSamplingRate, short NewBitsPerSample, short NewNumChannels) {
      this.field_610 = NewSamplingRate;
      this.field_609 = NewNumChannels;
      this.field_613 = NewBitsPerSample;
      this.field_611 = this.field_609 * this.field_610 * this.field_613 / 8;
      this.field_612 = (short)(this.field_609 * this.field_613 / 8);
   }
}

class Class_309 {
   // $VF: renamed from: gad Class_102
   public Class_102 field_275;
   // $VF: renamed from: adx Class_149
   public Class_149 field_276;

   public Class_309(Class_120 var1) {
      this.field_277 = var1;
      this.field_275 = new Class_102(var1);
      this.field_276 = new Class_149(var1);
      this.field_275.field_751 = Class_170.method_723("fmt ");
      this.field_275.field_752 = 16;
   }

   // $VF: renamed from: vtv () int
   public int method_313() {
      boolean ret = this.field_275.field_751 == Class_170.method_723("fmt ")
         && (this.field_276.field_609 == 1 || this.field_276.field_609 == 2)
         && this.field_276.field_611 == this.field_276.field_609 * this.field_276.field_610 * this.field_276.field_613 / 8
         && this.field_276.field_612 == this.field_276.field_609 * this.field_276.field_613 / 8;
      return ret ? 1 : 0;
   }
}

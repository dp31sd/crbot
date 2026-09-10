public final class Class_273 {
   // $VF: renamed from: vti short
   private static short field_365 = -32763;
   private short swsf = -1;

   // $VF: renamed from: bdd (int, int) void
   public void method_372(int bitstring, int length) {
      int bitmask = 1 << length - 1;

      do {
         if ((this.swsf & '耀') == 0 ^ (bitstring & bitmask) == 0) {
            this.swsf = (short)(this.swsf << 1);
            this.swsf = (short)(this.swsf ^ field_365);
         } else {
            this.swsf = (short)(this.swsf << 1);
         }
      } while ((bitmask >>>= 1) != 0);
   }

   // $VF: renamed from: uwt () short
   public short method_373() {
      short sum = this.swsf;
      this.swsf = -1;
      return sum;
   }
}

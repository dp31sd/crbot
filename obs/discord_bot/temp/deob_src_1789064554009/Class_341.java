final class Class_341 {
   // $VF: renamed from: bxb int
   private static final int field_191 = 32768;
   // $VF: renamed from: mjc int
   private static final int field_192 = 32767;
   // $VF: renamed from: krs int
   private int field_193;
   // $VF: renamed from: gfg int
   private int field_194;
   // $VF: renamed from: lfg int
   private int field_195;
   // $VF: renamed from: ory int[]
   private final int[] field_196 = new int[32768];
   // $VF: renamed from: ikk int
   private int field_197;

   Class_341() {
      this.field_193 = 0;
      this.field_194 = 0;
      this.field_195 = 0;
   }

   // $VF: renamed from: ugx () int
   public int method_259() {
      return this.field_194;
   }

   // $VF: renamed from: bz (int) int
   public int method_260(int N) {
      this.field_194 += N;
      int val = 0;
      int pos = this.field_195;
      if (pos + N < 32768) {
         while (N-- > 0) {
            val <<= 1;
            val |= this.field_196[pos++] != 0 ? 1 : 0;
         }
      } else {
         while (N-- > 0) {
            val <<= 1;
            val |= this.field_196[pos] != 0 ? 1 : 0;
            pos = pos + 1 & 32767;
         }
      }

      this.field_195 = pos;
      return val;
   }

   // $VF: renamed from: bkn () int
   public int method_261() {
      this.field_194++;
      int val = this.field_196[this.field_195];
      this.field_195 = this.field_195 + 1 & 32767;
      return val;
   }

   // $VF: renamed from: gzm (int) void
   public void method_262(int val) {
      int ofs = this.field_193;
      this.field_196[ofs++] = val & 128;
      this.field_196[ofs++] = val & 64;
      this.field_196[ofs++] = val & 32;
      this.field_196[ofs++] = val & 16;
      this.field_196[ofs++] = val & 8;
      this.field_196[ofs++] = val & 4;
      this.field_196[ofs++] = val & 2;
      this.field_196[ofs++] = val & 1;
      if (ofs == 32768) {
         this.field_193 = 0;
      } else {
         this.field_193 = ofs;
      }
   }

   // $VF: renamed from: xqs (int) void
   public void method_263(int N) {
      this.field_194 -= N;
      this.field_195 -= N;
      if (this.field_195 < 0) {
         this.field_195 += 32768;
      }
   }

   // $VF: renamed from: pm (int) void
   public void method_264(int N) {
      int bits = N << 3;
      this.field_194 -= bits;
      this.field_195 -= bits;
      if (this.field_195 < 0) {
         this.field_195 += 32768;
      }
   }
}

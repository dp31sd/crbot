public final class Class_203 {
   // $VF: renamed from: jyw float
   public static final float field_503 = Float.NEGATIVE_INFINITY;
   // $VF: renamed from: tuh Class_203
   public static final Class_203 field_504 = new Class_203();
   private static final int dlmm = 32;
   // $VF: renamed from: dlu float[]
   private final float[] field_505 = new float[32];

   public Class_203() {
   }

   public Class_203(float[] settings) {
      this.method_551(settings);
   }

   public Class_203(Class_142 eq) {
      this.method_552(eq);
   }

   // $VF: renamed from: ld (float[]) void
   public void method_551(float[] eq) {
      this.method_554();
      int max = eq.length > 32 ? 32 : eq.length;

      for (int i = 0; i < max; i++) {
         this.field_505[i] = this.kdhl(eq[i]);
      }
   }

   // $VF: renamed from: ur (Class_142) void
   public void method_552(Class_142 eq) {
      this.method_554();
      int max = 32;

      for (int i = 0; i < max; i++) {
         this.field_505[i] = this.kdhl(eq.method_649(i));
      }
   }

   // $VF: renamed from: bah (Class_203) void
   public void method_553(Class_203 eq) {
      if (eq != this) {
         this.method_551(eq.field_505);
      }
   }

   // $VF: renamed from: rgk () void
   public void method_554() {
      for (int i = 0; i < 32; i++) {
         this.field_505[i] = 0.0F;
      }
   }

   // $VF: renamed from: lak () int
   public int method_555() {
      return this.field_505.length;
   }

   // $VF: renamed from: utg (int, float) float
   public float method_556(int band, float neweq) {
      float eq = 0.0F;
      if (band >= 0 && band < 32) {
         eq = this.field_505[band];
         this.field_505[band] = this.kdhl(neweq);
      }

      return eq;
   }

   // $VF: renamed from: bcw (int) float
   public float method_557(int band) {
      float eq = 0.0F;
      if (band >= 0 && band < 32) {
         eq = this.field_505[band];
      }

      return eq;
   }

   private float kdhl(float eq) {
      if (eq == Float.NEGATIVE_INFINITY) {
         return eq;
      } else if (eq > 1.0F) {
         return 1.0F;
      } else {
         return eq < -1.0F ? -1.0F : eq;
      }
   }

   // $VF: renamed from: eer () float[]
   float[] method_558() {
      float[] factors = new float[32];
      int i = 0;

      for (int maxCount = 32; i < maxCount; i++) {
         factors[i] = this.mcfp(this.field_505[i]);
      }

      return factors;
   }

   float mcfp(float eq) {
      return eq == Float.NEGATIVE_INFINITY ? 0.0F : (float)Math.pow(2.0, (double)eq);
   }
}

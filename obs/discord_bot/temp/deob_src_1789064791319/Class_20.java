public class Class_20 {
   // $VF: renamed from: ruo (int, int) Class_262
   public static Class_262 method_1316(int var0, int var1) {
      Class_262 var2 = Class_139.field_2104.method_970();
      int var3 = var2.field_380;
      int var4 = var2.field_381;
      int var5 = var2.field_382;
      if (Class_139.field_2107.method_1035()) {
         return method_1317(var1, var0);
      } else {
         return Class_139.field_2106.method_1035() ? method_1318(new Class_262(var3, var4, var5, var0), var1, 20) : new Class_262(var3, var4, var5, var0);
      }
   }

   // $VF: renamed from: qje (int, int) Class_262
   public static Class_262 method_1317(int var0, int var1) {
      Class_262 var2 = Class_262.rqtv((float)((System.currentTimeMillis() * 3L + (long)(var0 * 175)) % 7200L) / 7200.0F, 0.6F, 1.0F);
      return new Class_262(var2.field_380, var2.field_381, var2.field_382, var1);
   }

   // $VF: renamed from: plz (Class_262, int, int) Class_262
   public static Class_262 method_1318(Class_262 var0, int var1, int var2) {
      float[] var3 = new float[3];
      Class_262.method_380(var0.field_380, var0.field_381, var0.field_382, var3);
      float var4 = Math.abs(((float)(System.currentTimeMillis() % 2000L) / 1000.0F + (float)var1 / (float)var2 * 2.0F) % 2.0F - 1.0F);
      var3[2] = 0.25F + 0.75F * var4 % 2.0F;
      int var5 = Class_262.method_381(var3[0], var3[1], var3[2]);
      return new Class_262(var5 >> 16 & 0xFF, var5 >> 8 & 0xFF, var5 & 0xFF, var0.field_383);
   }

   // $VF: renamed from: vb (float, Class_262, Class_262) Class_262
   public static Class_262 method_1319(float var0, Class_262 var1, Class_262 var2) {
      return new Class_262(
         (int)Class_277.method_344(var0, (double)var2.field_380, (double)var1.field_380),
         (int)Class_277.method_344(var0, (double)var2.field_381, (double)var1.field_381),
         (int)Class_277.method_344(var0, (double)var2.field_382, (double)var1.field_382)
      );
   }

   // $VF: renamed from: wzv (float, int, Class_262) Class_262
   public static Class_262 method_1320(float var0, int var1, Class_262 var2) {
      return new Class_262(var2.field_380, var2.field_381, var2.field_382, (int)Class_277.method_344(var0, (double)var2.field_383, (double)var1));
   }

   // $VF: renamed from: jyq (Class_262, Class_262, float) Class_262
   public static Class_262 method_1321(Class_262 var0, Class_262 var1, float var2) {
      int var3 = method_1322(Math.round((float)var0.field_380 + var2 * (float)(var1.field_380 - var0.field_380)), 0, 255);
      int var4 = method_1322(Math.round((float)var0.field_381 + var2 * (float)(var1.field_381 - var0.field_381)), 0, 255);
      int var5 = method_1322(Math.round((float)var0.field_382 + var2 * (float)(var1.field_382 - var0.field_382)), 0, 255);
      int var6 = method_1322(Math.round((float)var0.field_383 + var2 * (float)(var1.field_383 - var0.field_383)), 0, 255);
      return new Class_262(var3, var4, var5, var6);
   }

   // $VF: renamed from: pc (int, int, int) int
   public static int method_1322(int var0, int var1, int var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   // $VF: renamed from: td (int, int, float) int
   public static int method_1323(int var0, int var1, float var2) {
      int var3 = var0 >> 24 & 0xFF;
      int var4 = var1 >> 24 & 0xFF;
      int var5 = var0 >> 16 & 0xFF;
      int var6 = var1 >> 16 & 0xFF;
      int var7 = var0 >> 8 & 0xFF;
      int var8 = var1 >> 8 & 0xFF;
      int var9 = var0 & 0xFF;
      int var10 = var1 & 0xFF;
      int var11 = method_1322(Math.round((float)var3 + var2 * (float)(var4 - var3)), 0, 255);
      int var12 = method_1322(Math.round((float)var5 + var2 * (float)(var6 - var5)), 0, 255);
      int var13 = method_1322(Math.round((float)var7 + var2 * (float)(var8 - var7)), 0, 255);
      int var14 = method_1322(Math.round((float)var9 + var2 * (float)(var10 - var9)), 0, 255);
      return var11 << 24 | var12 << 16 | var13 << 8 | var14;
   }
}

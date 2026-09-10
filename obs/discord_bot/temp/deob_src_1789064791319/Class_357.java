public class Class_357 {
   // $VF: renamed from: jmo (double, double, double, double, double, double, double, double, Class_262, Class_262, double) void
   public static void method_252(
      double var0, double var2, double var4, double var6, double var8, double var10, double var12, double var14, Class_262 var16, Class_262 var17, double var18
   ) {
      if (!(var18 <= 0.0)) {
         if (var4 < var0) {
            double var20 = var0;
            var0 = var4;
            var4 = var20;
         }

         if (var6 < var2) {
            double var70 = var2;
            var2 = var6;
            var6 = var70;
         }

         double var71 = var4 - var0;
         double var22 = var6 - var2;
         if (!(var71 <= 0.0) && !(var22 <= 0.0)) {
            var18 = Math.min(var18, Math.min(var71, var22) / 2.0);
            double var24 = Math.min(var71, var22) / 2.0;
            var8 = Math.max(0.0, Math.min(var8, var24));
            var10 = Math.max(0.0, Math.min(var10, var24));
            var12 = Math.max(0.0, Math.min(var12, var24));
            var14 = Math.max(0.0, Math.min(var14, var24));
            double var26 = var0 + var18;
            double var28 = var2 + var18;
            double var30 = var4 - var18;
            double var32 = var6 - var18;
            double var34 = Math.max(0.0, var8 - var18);
            double var36 = Math.max(0.0, var10 - var18);
            double var38 = Math.max(0.0, var12 - var18);
            double var40 = Math.max(0.0, var14 - var18);
            int var42 = (int)Math.ceil(var2);
            int var43 = (int)Math.floor(var6);
            int var44 = (int)Math.ceil(var28);
            int var45 = (int)Math.floor(var32);
            boolean var46 = RenderEngine_384.field_90.method_142();
            if (!var46) {
               RenderEngine_384.field_90.method_138();
            }

            for (int var47 = var42; var47 < var43; var47++) {
               double var48 = (double)var47 + 0.5;
               double var50 = (var48 - var2) / var22;
               Class_262 var52 = method_254(var16, var17, (float)var50);
               double var53 = method_255(var0, var2, var6, var48, var8, var12);
               double var55 = method_256(var4, var2, var6, var48, var10, var14);
               int var57 = (int)Math.ceil(var53);
               int var58 = (int)Math.floor(var55);
               if (var58 > var57) {
                  if (var47 >= var44 && var47 < var45) {
                     double var59 = method_255(var26, var28, var32, var48, var34, var38);
                     double var61 = method_256(var30, var28, var32, var48, var36, var40);
                     int var63 = (int)Math.ceil(var59);
                     int var64 = (int)Math.floor(var61);
                     if (var63 > var57) {
                        RenderEngine_384.field_90.ejsz((double)var57, (double)var47, (double)(Math.min(var63, var58) - var57), 1.0, var52);
                     }

                     if (var58 > var64) {
                        RenderEngine_384.field_90.ejsz((double)Math.max(var64, var57), (double)var47, (double)(var58 - Math.max(var64, var57)), 1.0, var52);
                     }
                  } else {
                     RenderEngine_384.field_90.ejsz((double)var57, (double)var47, (double)(var58 - var57), 1.0, var52);
                  }
               }
            }

            if (!var46) {
               RenderEngine_384.field_90.method_143();
            }
         }
      }
   }

   // $VF: renamed from: lwi (double, double, double, double, double, Class_262, Class_262, double) void
   public static void method_253(double var0, double var2, double var4, double var6, double var8, Class_262 var10, Class_262 var11, double var12) {
      method_252(var0, var2, var4, var6, var8, var8, var8, var8, var10, var11, var12);
   }

   // $VF: renamed from: bhv (Class_262, Class_262, float) Class_262
   public static Class_262 method_254(Class_262 var0, Class_262 var1, float var2) {
      if (var2 < 0.0F) {
         var2 = 0.0F;
      } else if (var2 > 1.0F) {
         var2 = 1.0F;
      }

      int var3 = (int)((float)var0.field_380 + (float)(var1.field_380 - var0.field_380) * var2);
      int var4 = (int)((float)var0.field_381 + (float)(var1.field_381 - var0.field_381) * var2);
      int var5 = (int)((float)var0.field_382 + (float)(var1.field_382 - var0.field_382) * var2);
      int var6 = (int)((float)var0.field_383 + (float)(var1.field_383 - var0.field_383) * var2);
      return new Class_262(var3, var4, var5, var6);
   }

   // $VF: renamed from: qab (double, double, double, double, double, double) double
   public static double method_255(double var0, double var2, double var4, double var6, double var8, double var10) {
      if (var6 < var2 + var8) {
         double var14 = var2 + var8 - var6;
         return var0 + var8 - Math.sqrt(Math.max(0.0, var8 * var8 - var14 * var14));
      } else if (var6 > var4 - var10) {
         double var12 = var6 - (var4 - var10);
         return var0 + var10 - Math.sqrt(Math.max(0.0, var10 * var10 - var12 * var12));
      } else {
         return var0;
      }
   }

   // $VF: renamed from: lfa (double, double, double, double, double, double) double
   public static double method_256(double var0, double var2, double var4, double var6, double var8, double var10) {
      if (var6 < var2 + var8) {
         double var14 = var2 + var8 - var6;
         return var0 - var8 + Math.sqrt(Math.max(0.0, var8 * var8 - var14 * var14));
      } else if (var6 > var4 - var10) {
         double var12 = var6 - (var4 - var10);
         return var0 - var10 + Math.sqrt(Math.max(0.0, var10 * var10 - var12 * var12));
      } else {
         return var0;
      }
   }
}

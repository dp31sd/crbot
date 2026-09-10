import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import net.minecraft.class_310;
import net.minecraft.class_332;

public class RenderEngine_208 {
   // $VF: renamed from: zhr int
   public static int field_497 = 4;
   // $VF: renamed from: ixd float
   public static float field_498 = 4.0F;
   // $VF: renamed from: zx RenderEngine_386
   public static RenderEngine_386 field_499;

   // $VF: renamed from: sqt (net.minecraft.class_332, double, double, double, double) void
   public static void method_538(class_332 var0, double var1, double var3, double var5, double var7) {
      method_542(var0, var1, var3, var5, var7, 0.0, 0.0, 0.0, 0.0, 1.0F, false);
   }

   // $VF: renamed from: ytl (net.minecraft.class_332, double, double, double, double, double) void
   public static void method_539(class_332 var0, double var1, double var3, double var5, double var7, double var9) {
      method_542(var0, var1, var3, var5, var7, var9, var9, var9, var9, 1.0F, false);
   }

   // $VF: renamed from: tef (net.minecraft.class_332, double, double, double, double, double, float) void
   public static void method_540(class_332 var0, double var1, double var3, double var5, double var7, double var9, float var11) {
      method_542(var0, var1, var3, var5, var7, var9, var9, var9, var9, var11, false);
   }

   // $VF: renamed from: pir (net.minecraft.class_332, double, double, double, double, double, float) void
   public static void method_541(class_332 var0, double var1, double var3, double var5, double var7, double var9, float var11) {
      method_542(var0, var1, var3, var5, var7, var9, var9, var9, var9, var11, true);
   }

   // $VF: renamed from: yes (net.minecraft.class_332, double, double, double, double, double, double, double, double, float, boolean) void
   public static void method_542(
      class_332 var0, double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, float var17, boolean var18
   ) {
      if (var5 < var1) {
         double var19 = var1;
         var1 = var5;
         var5 = var19;
      }

      if (var7 < var3) {
         double var32 = var3;
         var3 = var7;
         var7 = var32;
      }

      double var33 = var5 - var1;
      double var21 = var7 - var3;
      if (!(var33 <= 0.0) && !(var21 <= 0.0)) {
         GpuTextureView var23 = var18 ? RenderEngine_322.method_283() : RenderEngine_322.method_288(field_497, field_498);
         if (var23 == null) {
            var23 = RenderEngine_322.method_284();
         }

         if (var23 != null) {
            class_310 var24 = class_310.method_1551();
            float var25 = (float)var24.method_1522().field_1482;
            float var26 = (float)var24.method_1522().field_1481;
            if (!(var25 <= 0.0F) && !(var26 <= 0.0F)) {
               if (field_499 == null) {
                  field_499 = new RenderEngine_386(Class_420.field_9, class_5596.field_27379, 4, 6);
               }

               field_499.method_105();
               int var27 = field_499.method_107(var1, var3).method_110();
               int var28 = field_499.method_107(var1, var7).method_110();
               int var29 = field_499.method_107(var5, var7).method_110();
               int var30 = field_499.method_107(var5, var3).method_110();
               field_499.method_112(var27, var28, var29, var30);
               field_499.method_119();
               GpuBufferSlice var31 = Class_34.method_1127(
                  (float)var1,
                  (float)var3,
                  (float)var5,
                  (float)var7,
                  (float)var9,
                  (float)var11,
                  (float)var13,
                  (float)var15,
                  var25,
                  var26,
                  Math.max(0.0F, Math.min(1.0F, var17))
               );
               RenderEngine_374 var10000 = RenderEngine_374.method_163()
                  .method_166(var24.method_1522())
                  .method_168(CryptoService_296.field_295)
                  .method_170(field_499);
               int var10001 = 189201651 << 189201651 ^ -409468928;

               StringBuilder var10002;
               for (var10002 = new StringBuilder("叿\udfff췿\uf3ff뇿闿﷿\uf7ff\udfff\uedff俿闿\uefff闿"); var10001 < 14; var10001 += 1) {
                  char var41 = var10002.charAt(var10001);
                  char var42 = (char)((((var41 & '︀') >> 9 | var41 << 7) - 159 ^ 45 ^ 186) + 165);
                  var10002.setCharAt(var10001, (char)((((var41 & '︀') >> 9 | var41 << 7) - 159 ^ 45 ^ 186) + 165));
               }

               var10000 = var10000.method_176(var10002.toString(), var31);
               var10001 = 24697192 ^ 24697192;

               for (var10002 = new StringBuilder("㴈㞈え㫈㴈㱈㓈㤈㷈");
                  var10001 < ((1573383682 & 570869013 | 9) & 2031160107);
                  var10001 += (1505728141 >>> 1505728141 | 1) & 135266307
               ) {
                  int var45 = var10002.charAt(var10001) + '8';
                  char var48 = (char)(
                     (
                           (((((var45 & 65528) >> 3 | var45 << 13) & 65532) >> 2 | ((var45 & 65528) >> 3 | var45 << 13) << 14) & 65534) >> 1
                              | ((((var45 & 65528) >> 3 | var45 << 13) & 65532) >> 2 | ((var45 & 65528) >> 3 | var45 << 13) << 14) << 15
                        )
                        - 128
                  );
                  var10002.setCharAt(
                     var10001,
                     (char)(
                        (
                              (((((var45 & 65528) >> 3 | var45 << 13) & 65532) >> 2 | ((var45 & 65528) >> 3 | var45 << 13) << 14) & 65534) >> 1
                                 | ((((var45 & 65528) >> 3 | var45 << 13) & 65532) >> 2 | ((var45 & 65528) >> 3 | var45 << 13) << 14) << 15
                           )
                           - 128
                     )
                  );
               }

               var10000.method_177(var10002.toString(), var23, RenderEngine_322.method_282()).method_178();
            }
         }
      }
   }
}

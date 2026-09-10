import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import net.minecraft.class_310;
import net.minecraft.class_332;

public class RenderEngine_111 {
   // $VF: renamed from: uol Class_262
   public static Class_262 field_730 = new Class_262(18, 18, 22, 180);
   // $VF: renamed from: fkx Class_262
   public static Class_262 field_731 = new Class_262(255, 255, 255, 140);
   // $VF: renamed from: cm Class_262
   public static Class_262 field_732 = new Class_262(255, 255, 255, 25);
   // $VF: renamed from: zhr int
   public static int field_733 = 4;
   // $VF: renamed from: ixd float
   public static float field_734 = 4.0F;
   // $VF: renamed from: zx RenderEngine_386
   public static RenderEngine_386 field_735;

   // $VF: renamed from: jqv (net.minecraft.class_332, double, double, double, double, double) void
   public static void method_731(class_332 var0, double var1, double var3, double var5, double var7, double var9) {
      method_733(var0, var1, var3, var5, var7, var9, var9, var9, var9, field_730, field_731, field_732, 2.0, true);
   }

   // $VF: renamed from: bnq (net.minecraft.class_332, double, double, double, double, double, Class_262) void
   public static void method_732(class_332 var0, double var1, double var3, double var5, double var7, double var9, Class_262 var11) {
      method_733(var0, var1, var3, var5, var7, var9, var9, var9, var9, var11, field_731, field_732, 2.0, true);
   }

   // $VF: renamed from: vrx (net.minecraft.class_332, double, double, double, double, double, double, double, double, Class_262, Class_262, Class_262, double, boolean) void
   public static void method_733(
      class_332 var0,
      double var1,
      double var3,
      double var5,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15,
      Class_262 var17,
      Class_262 var18,
      Class_262 var19,
      double var20,
      boolean var22
   ) {
      method_735(var0, var1, var3, var5, var7, var9, var11, var13, var15, var17, var18, var19, var20, var22, false);
   }

   // $VF: renamed from: vhu (net.minecraft.class_332, double, double, double, double, double, double, double, double, Class_262, Class_262, Class_262, double) void
   public static void method_734(
      class_332 var0,
      double var1,
      double var3,
      double var5,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15,
      Class_262 var17,
      Class_262 var18,
      Class_262 var19,
      double var20
   ) {
      method_735(var0, var1, var3, var5, var7, var9, var11, var13, var15, var17, var18, var19, var20, true, true);
   }

   // $VF: renamed from: gi (net.minecraft.class_332, double, double, double, double, double, double, double, double, Class_262, Class_262, Class_262, double, boolean, boolean) void
   public static void method_735(
      class_332 var0,
      double var1,
      double var3,
      double var5,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15,
      Class_262 var17,
      Class_262 var18,
      Class_262 var19,
      double var20,
      boolean var22,
      boolean var23
   ) {
      if (var5 < var1) {
         double var24 = var1;
         var1 = var5;
         var5 = var24;
      }

      if (var7 < var3) {
         double var38 = var3;
         var3 = var7;
         var7 = var38;
      }

      double var39 = var5 - var1;
      double var26 = var7 - var3;
      if (!(var39 <= 0.0) && !(var26 <= 0.0)) {
         GpuTextureView var28 = null;
         if (var22) {
            var28 = var23 ? RenderEngine_322.method_283() : RenderEngine_322.method_288(field_733, field_734);
         }

         boolean var29 = var28 != null;
         if (var28 == null) {
            var28 = RenderEngine_322.method_284();
         }

         class_310 var30 = class_310.method_1551();
         float var31 = (float)var30.method_1522().field_1482;
         float var32 = (float)var30.method_1522().field_1481;
         if (!(var31 <= 0.0F) && !(var32 <= 0.0F)) {
            if (field_735 == null) {
               field_735 = new RenderEngine_386(Class_420.field_9, class_5596.field_27379, 4, 6);
            }

            field_735.method_105();
            int var33 = field_735.method_107(var1, var3).method_110();
            int var34 = field_735.method_107(var1, var7).method_110();
            int var35 = field_735.method_107(var5, var7).method_110();
            int var36 = field_735.method_107(var5, var3).method_110();
            field_735.method_112(var33, var34, var35, var36);
            field_735.method_119();
            GpuBufferSlice var37 = Class_345.method_258(
               (float)var1,
               (float)var3,
               (float)var5,
               (float)var7,
               (float)var9,
               (float)var11,
               (float)var13,
               (float)var15,
               var17,
               var18,
               var19,
               (float)var20,
               var31,
               var32,
               var29
            );
            if (var28 != null) {
               RenderEngine_374 var10000 = RenderEngine_374.method_163()
                  .method_166(var30.method_1522())
                  .method_168(CryptoService_296.vrvh)
                  .method_170(field_735);
               int var10001 = 0;

               StringBuilder var10002;
               for (var10002 = new StringBuilder("ᇽᬽ\u187d\u1cfd\u1cfdᄽ\u187dᴽ\u187d");
                  var10001 < ((-2108483811 * -2108483811 * -112183910 | 1) & 956852253);
                  var10001 += (261850977 ^ 261850977 | 1) & 1474188963
               ) {
                  int var47 = var10002.charAt(var10001) + 189 - 241 ^ 9;
                  int var10005 = (var47 & 32768) >> 15;
                  int var48 = (var47 & 32768) >> 15 | var47 << 1;
                  int var59 = (((var47 & 32768) >> 15 | var47 << 1) & 65408) >> 7;
                  char var49 = (char)(((var10005 | var47 << 1) & 65408) >> 7 | ((var47 & 32768) >> 15 | var47 << 1) << 9);
                  var10002.setCharAt(var10001, (char)(var59 | var48 << 9));
               }

               var10000 = var10000.method_176(var10002.toString(), var37);
               var10001 = 0;

               for (var10002 = new StringBuilder("ᰤᚤཤ᧤ᰤ᭤Ꮴᠤ᳤");
                  var10001 < ((910569473 - 51695605 | 9) & 1275338619);
                  var10001 += (-1930129883 | -372486488 >>> -1930129883 + -372486488) ^ -1929916826
               ) {
                  int var52 = var10002.charAt(var10001) - 'l' + 208 + 184;
                  int var60 = (var52 & 63488) >> 11;
                  int var53 = (var52 & 63488) >> 11 | var52 << 5;
                  int var61 = (((var52 & 63488) >> 11 | var52 << 5) & 63488) >> 11;
                  char var54 = (char)(((var60 | var52 << 5) & 63488) >> 11 | ((var52 & 63488) >> 11 | var52 << 5) << 5);
                  var10002.setCharAt(var10001, (char)(var61 | var53 << 5));
               }

               var10000.method_177(var10002.toString(), var28, RenderEngine_322.method_282()).method_178();
            }
         }
      }
   }
}

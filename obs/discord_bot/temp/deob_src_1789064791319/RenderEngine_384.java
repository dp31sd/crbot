import com.mojang.blaze3d.textures.GpuTextureView;
import net.minecraft.class_12137;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3532;

public class RenderEngine_384 {
   // $VF: renamed from: so RenderEngine_384
   public static RenderEngine_384 field_90;
   // $VF: renamed from: tug RenderEngine_384
   public static RenderEngine_384 field_91;
   // $VF: renamed from: sqq RenderEngine_386
   public RenderEngine_386 field_92;
   // $VF: renamed from: rb RenderEngine_386
   public RenderEngine_386 field_93;
   // $VF: renamed from: djk boolean
   public boolean field_94;
   // $VF: renamed from: ron boolean
   public boolean field_95 = false;

   public RenderEngine_384(boolean var1) {
      this.field_94 = var1;
      this.field_92 = new RenderEngine_386(var1 ? CryptoService_296.field_289 : CryptoService_296.field_287);
      this.field_93 = new RenderEngine_386(CryptoService_296.field_288);
   }

   // $VF: renamed from: smv () void
   public static void method_125() {
      field_90 = new RenderEngine_384(false);
      field_91 = new RenderEngine_384(true);
   }

   // $VF: renamed from: scl (double, double, double, double, int) void
   public static void method_126(double var0, double var2, double var4, double var6, int var8) {
      Class_262 var9 = new Class_262(var8);
      if (var9.field_383 != 0) {
         boolean var10 = field_90.method_142();
         if (!var10) {
            field_90.method_138();
         }

         field_90.ejsz(var0, var2, var4 - var0, var6 - var2, var9);
         if (!var10) {
            field_90.method_143();
         }
      }
   }

   // $VF: renamed from: tia (double, double, double, double, Class_262) void
   public static void method_127(double var0, double var2, double var4, double var6, Class_262 var8) {
      method_126(var0, var2, var4, var6, var8.method_396());
   }

   // $VF: renamed from: amr (net.minecraft.class_332, Class_262, double, double, double, double, double) void
   public static void method_128(class_332 var0, Class_262 var1, double var2, double var4, double var6, double var8, double var10) {
      method_129(var0, var1, var2, var4, var6, var8, var10, var10, var10, var10);
   }

   // $VF: renamed from: vsp (net.minecraft.class_332, Class_262, double, double, double, double, double, double, double, double) void
   public static void method_129(
      class_332 var0, Class_262 var1, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16
   ) {
      if (var1.field_383 != 0) {
         if (var6 < var2) {
            double var18 = var2;
            var2 = var6;
            var6 = var18;
         }

         if (var8 < var4) {
            double var41 = var4;
            var4 = var8;
            var8 = var41;
         }

         double var42 = var6 - var2;
         double var20 = var8 - var4;
         if (!(var42 <= 0.0) && !(var20 <= 0.0)) {
            double var22 = Math.min(var42, var20) / 2.0;
            var10 = method_136(var10, var22);
            var12 = method_136(var12, var22);
            var14 = method_136(var14, var22);
            var16 = method_136(var16, var22);
            Class_262 var24 = new Class_262(var1.field_380, var1.field_381, var1.field_382, var1.field_383);
            int var25 = (int)Math.ceil(var4);
            int var26 = (int)Math.floor(var8);
            boolean var27 = field_90.method_142();
            if (!var27) {
               field_90.method_138();
            }

            for (int var28 = var25; var28 < var26; var28++) {
               double var29 = (double)var28 + 0.5;
               double var31 = method_134(var2, var4, var8, var29, var10, var14);
               double var33 = method_135(var6, var4, var8, var29, var12, var16);
               int var35 = (int)Math.ceil(var31);
               int var36 = (int)Math.floor(var33);
               if (var36 > var35) {
                  field_90.ejsz((double)var35, (double)var28, (double)(var36 - var35), 1.0, var24);
               }
            }

            if (!var27) {
               field_90.method_143();
            }
         }
      }
   }

   // $VF: renamed from: rty (net.minecraft.class_332, Class_262, double, double, double, double, double, double, double, double, double) void
   public static void method_130(
      class_332 var0, Class_262 var1, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, double var18
   ) {
      if (var1.field_383 != 0) {
         if (!(var18 <= 0.0)) {
            if (var6 < var2) {
               double var20 = var2;
               var2 = var6;
               var6 = var20;
            }

            if (var8 < var4) {
               double var68 = var4;
               var4 = var8;
               var8 = var68;
            }

            double var69 = var6 - var2;
            double var22 = var8 - var4;
            if (!(var69 <= 0.0) && !(var22 <= 0.0)) {
               var18 = Math.min(var18, Math.min(var69, var22) / 2.0);
               double var24 = Math.min(var69, var22) / 2.0;
               var10 = method_136(var10, var24);
               var12 = method_136(var12, var24);
               var14 = method_136(var14, var24);
               var16 = method_136(var16, var24);
               double var26 = var2 + var18;
               double var28 = var4 + var18;
               double var30 = var6 - var18;
               double var32 = var8 - var18;
               if (!(var30 <= var26) && !(var32 <= var28)) {
                  double var34 = Math.max(0.0, var10 - var18);
                  double var36 = Math.max(0.0, var12 - var18);
                  double var38 = Math.max(0.0, var14 - var18);
                  double var40 = Math.max(0.0, var16 - var18);
                  Class_262 var42 = new Class_262(var1.field_380, var1.field_381, var1.field_382, var1.field_383);
                  int var43 = (int)Math.ceil(var4);
                  int var44 = (int)Math.floor(var8);
                  int var45 = (int)Math.ceil(var28);
                  int var46 = (int)Math.floor(var32);
                  boolean var47 = field_90.method_142();
                  if (!var47) {
                     field_90.method_138();
                  }

                  for (int var48 = var43; var48 < var44; var48++) {
                     double var49 = (double)var48 + 0.5;
                     double var51 = method_134(var2, var4, var8, var49, var10, var14);
                     double var53 = method_135(var6, var4, var8, var49, var12, var16);
                     int var55 = (int)Math.ceil(var51);
                     int var56 = (int)Math.floor(var53);
                     if (var56 > var55) {
                        if (var48 >= var45 && var48 < var46) {
                           double var57 = method_134(var26, var28, var32, var49, var34, var38);
                           double var59 = method_135(var30, var28, var32, var49, var36, var40);
                           int var61 = (int)Math.ceil(var57);
                           int var62 = (int)Math.floor(var59);
                           if (var61 > var55) {
                              field_90.ejsz((double)var55, (double)var48, (double)(Math.min(var61, var56) - var55), 1.0, var42);
                           }

                           if (var56 > var62) {
                              field_90.ejsz((double)Math.max(var62, var55), (double)var48, (double)(var56 - Math.max(var62, var55)), 1.0, var42);
                           }
                        } else {
                           field_90.ejsz((double)var55, (double)var48, (double)(var56 - var55), 1.0, var42);
                        }
                     }
                  }

                  if (!var47) {
                     field_90.method_143();
                  }
               } else {
                  method_129(var0, var1, var2, var4, var6, var8, var10, var12, var14, var16);
               }
            }
         }
      }
   }

   // $VF: renamed from: chs (net.minecraft.class_332, Class_262, double, double, double) void
   public static void method_131(class_332 var0, Class_262 var1, double var2, double var4, double var6) {
      if (var1.field_383 != 0) {
         if (!(var6 <= 0.0)) {
            Class_262 var8 = new Class_262(var1.field_380, var1.field_381, var1.field_382, var1.field_383);
            int var9 = (int)Math.ceil(var4 - var6);
            int var10 = (int)Math.floor(var4 + var6);
            double var11 = var6 * var6;
            boolean var13 = field_90.method_142();
            if (!var13) {
               field_90.method_138();
            }

            for (int var14 = var9; var14 < var10; var14++) {
               double var15 = (double)var14 + 0.5 - var4;
               double var17 = var11 - var15 * var15;
               if (!(var17 <= 0.0)) {
                  double var19 = Math.sqrt(var17);
                  int var21 = (int)Math.ceil(var2 - var19);
                  int var22 = (int)Math.floor(var2 + var19);
                  if (var22 > var21) {
                     field_90.ejsz((double)var21, (double)var14, (double)(var22 - var21), 1.0, var8);
                  }
               }
            }

            if (!var13) {
               field_90.method_143();
            }
         }
      }
   }

   // $VF: renamed from: uiw (net.minecraft.class_332, int, double, double, double, double, double, double, double, double) void
   public static void method_132(
      class_332 var0, int var1, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16
   ) {
      int var18 = var1 >> 24 & 0xFF;
      if (var18 != 0) {
         if (var6 < var2) {
            double var19 = var2;
            var2 = var6;
            var6 = var19;
         }

         if (var8 < var4) {
            double var45 = var4;
            var4 = var8;
            var8 = var45;
         }

         double var46 = var6 - var2;
         double var21 = var8 - var4;
         if (!(var46 <= 0.0) && !(var21 <= 0.0)) {
            double var23 = Math.min(var46, var21) / 2.0;
            var10 = method_136(var10, var23);
            var12 = method_136(var12, var23);
            var14 = method_136(var14, var23);
            var16 = method_136(var16, var23);
            int var25 = var1 >> 16 & 0xFF;
            int var26 = var1 >> 8 & 0xFF;
            int var27 = var1 & 0xFF;
            Class_262 var28 = new Class_262(var25, var26, var27, var18);
            int var29 = (int)Math.ceil(var4);
            int var30 = (int)Math.floor(var8);
            boolean var31 = field_90.method_142();
            if (!var31) {
               field_90.method_138();
            }

            for (int var32 = var29; var32 < var30; var32++) {
               double var33 = (double)var32 + 0.5;
               double var35 = method_134(var2, var4, var8, var33, var10, var14);
               double var37 = method_135(var6, var4, var8, var33, var12, var16);
               int var39 = (int)Math.ceil(var35);
               int var40 = (int)Math.floor(var37);
               if (var40 > var39) {
                  field_90.ejsz((double)var39, (double)var32, (double)(var40 - var39), 1.0, var28);
               }
            }

            if (!var31) {
               field_90.method_143();
            }
         }
      }
   }

   // $VF: renamed from: mhq (net.minecraft.class_332, int, double, double, double) void
   public static void method_133(class_332 var0, int var1, double var2, double var4, double var6) {
      int var8 = var1 >> 24 & 0xFF;
      if (var8 != 0) {
         if (!(var6 <= 0.0)) {
            int var9 = var1 >> 16 & 0xFF;
            int var10 = var1 >> 8 & 0xFF;
            int var11 = var1 & 0xFF;
            Class_262 var12 = new Class_262(var9, var10, var11, var8);
            int var13 = (int)Math.ceil(var4 - var6);
            int var14 = (int)Math.floor(var4 + var6);
            double var15 = var6 * var6;
            boolean var17 = field_90.method_142();
            if (!var17) {
               field_90.method_138();
            }

            for (int var18 = var13; var18 < var14; var18++) {
               double var19 = (double)var18 + 0.5 - var4;
               double var21 = var15 - var19 * var19;
               if (!(var21 <= 0.0)) {
                  double var23 = Math.sqrt(var21);
                  int var25 = (int)Math.ceil(var2 - var23);
                  int var26 = (int)Math.floor(var2 + var23);
                  if (var26 > var25) {
                     field_90.ejsz((double)var25, (double)var18, (double)(var26 - var25), 1.0, var12);
                  }
               }
            }

            if (!var17) {
               field_90.method_143();
            }
         }
      }
   }

   // $VF: renamed from: vev (double, double, double, double, double, double) double
   public static double method_134(double var0, double var2, double var4, double var6, double var8, double var10) {
      if (var8 > 0.0 && var6 < var2 + var8) {
         double var20 = var0 + var8;
         double var21 = var2 + var8;
         double var22 = var6 - var21;
         double var23 = Math.sqrt(Math.max(0.0, var8 * var8 - var22 * var22));
         return var20 - var23;
      } else if (var10 > 0.0 && var6 > var4 - var10) {
         double var12 = var0 + var10;
         double var14 = var4 - var10;
         double var16 = var6 - var14;
         double var18 = Math.sqrt(Math.max(0.0, var10 * var10 - var16 * var16));
         return var12 - var18;
      } else {
         return var0;
      }
   }

   // $VF: renamed from: cjj (double, double, double, double, double, double) double
   public static double method_135(double var0, double var2, double var4, double var6, double var8, double var10) {
      if (var8 > 0.0 && var6 < var2 + var8) {
         double var20 = var0 - var8;
         double var21 = var2 + var8;
         double var22 = var6 - var21;
         double var23 = Math.sqrt(Math.max(0.0, var8 * var8 - var22 * var22));
         return var20 + var23;
      } else if (var10 > 0.0 && var6 > var4 - var10) {
         double var12 = var0 - var10;
         double var14 = var4 - var10;
         double var16 = var6 - var14;
         double var18 = Math.sqrt(Math.max(0.0, var10 * var10 - var16 * var16));
         return var12 + var18;
      } else {
         return var0;
      }
   }

   // $VF: renamed from: rkk (double, double) double
   public static double method_136(double var0, double var2) {
      return Double.isNaN(var0) ? 0.0 : class_3532.method_15350(var0, 0.0, var2);
   }

   // $VF: renamed from: kik (double) void
   public void method_137(double var1) {
      this.field_92.field_79 = var1;
   }

   // $VF: renamed from: ceb () void
   public void method_138() {
      this.field_92.method_105();
      this.field_93.method_105();
   }

   // $VF: renamed from: kgk () void
   public void method_139() {
      this.field_92.method_119();
      this.field_93.method_119();
   }

   // $VF: renamed from: mxl () void
   public void method_140() {
      this.field_95 = true;
      this.method_138();
   }

   // $VF: renamed from: svl () void
   public void method_141() {
      this.field_95 = false;
      this.method_143();
   }

   // $VF: renamed from: bsw () boolean
   public boolean method_142() {
      return this.field_95;
   }

   // $VF: renamed from: xrk () void
   public void method_143() {
      this.method_145(null, null, null);
   }

   // $VF: renamed from: kli (com.mojang.blaze3d.textures.GpuTextureView, net.minecraft.class_12137) void
   public void method_144(GpuTextureView var1, class_12137 var2) {
      if (!this.field_94) {
         IllegalStateException var10000 = new IllegalStateException;
         int var5 = 0;

         StringBuilder var10;
         for (var10 = new StringBuilder("ﾟﾮ羥羧ﾧﾁﾯ羨ﾁﾮ羧ﾨﾧ羧ﾮﾁ羬羥ﾯﾥﾁ羡ﾁﾯ羧ﾭﾯ羯ﾮ羧ﾁ羬羥ﾯﾥﾁ羡ﾁﾨ羨ﾨ羋ﾯ羧ﾭﾯ羯ﾮ羧ﾧﾁﾞ羧ﾨﾧ羧ﾮ羧ﾮﾎﾗ");
            var5 < (-1959706691 & 872431743);
            var5 += (589480767 * 589480767 | 0) & 67678209
         ) {
            char var13 = var10.charAt(var5);
            int var10006 = (var13 & 'ﰀ') >> 10;
            int var14 = ((var13 & 'ﰀ') >> 10 | var13 << 6) ^ 160;
            int var19 = ((((var13 & 'ﰀ') >> 10 | var13 << 6) ^ 160) & 65504) >> 5;
            var13 = (char)(((((var10006 | var13 << 6) ^ 160) & 65504) >> 5 | (((var13 & 'ﰀ') >> 10 | var13 << 6) ^ 160) << 11) + 39 + 243);
            var10.setCharAt(var5, (char)((var19 | var14 << 11) + 39 + 243));
         }

         var10000./* $VF: Unable to resugar constructor */<init>(var10.toString());
         throw var10000;
      } else {
         int var10001 = (777680899 >>> 777680899 | 0) & -1574653915;

         StringBuilder var10002;
         for (var10002 = new StringBuilder("ȺǢƶǺɆȶȺȮǺ");
            var10001 < (-1571036053 + 1797700869 ^ 226664825);
            var10001 += (-190092278 ^ 1466869246 | 1) & 1275081737
         ) {
            int var7 = var10002.charAt(var10001) + 196 - 194;
            char var8 = (char)(((var7 & 65532) >> 2 | var7 << 14) - 113 + 87);
            var10002.setCharAt(var10001, (char)(((var7 & 65532) >> 2 | var7 << 14) - 113 + 87));
         }

         this.method_145(var10002.toString(), var1, var2);
      }
   }

   // $VF: renamed from: fgk (java.lang.String, com.mojang.blaze3d.textures.GpuTextureView, net.minecraft.class_12137) void
   public void method_145(String var1, GpuTextureView var2, class_12137 var3) {
      if (this.field_93.method_120()) {
         this.field_93.method_119();
      }

      if (this.field_92.method_120()) {
         this.field_92.method_119();
      }

      RenderEngine_374.method_163()
         .method_166(class_310.method_1551().method_1522())
         .method_168(CryptoService_296.field_288)
         .method_170(this.field_93)
         .method_178();
      RenderEngine_374.method_163()
         .method_166(class_310.method_1551().method_1522())
         .method_168(this.field_94 ? CryptoService_296.field_289 : CryptoService_296.field_287)
         .method_170(this.field_92)
         .method_177(var1, var2, var3)
         .method_178();
   }

   // $VF: renamed from: hjs (double, double, double, double, double, double, Class_262) void
   public void method_146(double var1, double var3, double var5, double var7, double var9, double var11, Class_262 var13) {
      this.field_92.method_115();
      this.field_92
         .method_113(
            this.field_92.method_107(var1, var3).method_109(var13).method_110(),
            this.field_92.method_107(var5, var7).method_109(var13).method_110(),
            this.field_92.method_107(var9, var11).method_109(var13).method_110()
         );
   }

   // $VF: renamed from: xxr (double, double, double, double, Class_262) void
   public void method_147(double var1, double var3, double var5, double var7, Class_262 var9) {
      this.field_93.method_116();
      this.field_93
         .method_111(this.field_93.method_107(var1, var3).method_109(var9).method_110(), this.field_93.method_107(var5, var7).method_109(var9).method_110());
   }

   // $VF: renamed from: skq (double, double, double, double, Class_262) void
   public void method_148(double var1, double var3, double var5, double var7, Class_262 var9) {
      this.field_93.method_117(4, 8);
      int var10 = this.field_93.method_107(var1, var3).method_109(var9).method_110();
      int var11 = this.field_93.method_107(var1, var3 + var7).method_109(var9).method_110();
      int var12 = this.field_93.method_107(var1 + var5, var3 + var7).method_109(var9).method_110();
      int var13 = this.field_93.method_107(var1 + var5, var3).method_109(var9).method_110();
      this.field_93.method_111(var10, var11);
      this.field_93.method_111(var11, var12);
      this.field_93.method_111(var12, var13);
      this.field_93.method_111(var13, var10);
   }

   // $VF: renamed from: yil (double, double, double, double, Class_262, Class_262, Class_262, Class_262) void
   public void method_149(double var1, double var3, double var5, double var7, Class_262 var9, Class_262 var10, Class_262 var11, Class_262 var12) {
      this.field_92.method_114();
      this.field_92
         .method_112(
            this.field_92.method_107(var1, var3).method_109(var9).method_110(),
            this.field_92.method_107(var1, var3 + var7).method_109(var12).method_110(),
            this.field_92.method_107(var1 + var5, var3 + var7).method_109(var11).method_110(),
            this.field_92.method_107(var1 + var5, var3).method_109(var10).method_110()
         );
   }

   public void ejsz(double var1, double var3, double var5, double var7, Class_262 var9) {
      this.method_149(var1, var3, var5, var7, var9, var9, var9, var9);
   }

   // $VF: renamed from: nyc (double, double, double, double, Class_262) void
   public void method_150(double var1, double var3, double var5, double var7, Class_262 var9) {
      this.field_92.method_114();
      this.field_92
         .method_112(
            this.field_92.method_107(var1, var3).method_107(0.0, 0.0).method_109(var9).method_110(),
            this.field_92.method_107(var1, var3 + var7).method_107(0.0, 1.0).method_109(var9).method_110(),
            this.field_92.method_107(var1 + var5, var3 + var7).method_107(1.0, 1.0).method_109(var9).method_110(),
            this.field_92.method_107(var1 + var5, var3).method_107(1.0, 0.0).method_109(var9).method_110()
         );
   }

   // $VF: renamed from: rfi (double, double, double, double, Class_193, Class_262) void
   public void method_151(double var1, double var3, double var5, double var7, Class_193 var9, Class_262 var10) {
      this.field_92.method_114();
      this.field_92
         .method_112(
            this.field_92.method_107(var1, var3).method_107(var9.field_546, var9.field_547).method_109(var10).method_110(),
            this.field_92.method_107(var1, var3 + var7).method_107(var9.field_546, var9.xqgr).method_109(var10).method_110(),
            this.field_92.method_107(var1 + var5, var3 + var7).method_107(var9.field_548, var9.xqgr).method_109(var10).method_110(),
            this.field_92.method_107(var1 + var5, var3).method_107(var9.field_548, var9.field_547).method_109(var10).method_110()
         );
   }

   // $VF: renamed from: ucz (double, double, double, double, double, double, double, double, double, Class_262) void
   public void method_152(
      double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double var17, Class_262 var19
   ) {
      this.field_92.method_114();
      double var20 = Math.toRadians(var9);
      double var22 = Math.cos(var20);
      double var24 = Math.sin(var20);
      double var26 = var1 + var5 / 2.0;
      double var28 = var3 + var7 / 2.0;
      double var30 = (var1 - var26) * var22 - (var3 - var28) * var24 + var26;
      double var32 = (var3 - var28) * var22 + (var1 - var26) * var24 + var28;
      int var34 = this.field_92.method_107(var30, var32).method_107(var11, var13).method_109(var19).method_110();
      double var35 = (var1 - var26) * var22 - (var3 + var7 - var28) * var24 + var26;
      double var37 = (var3 + var7 - var28) * var22 + (var1 - var26) * var24 + var28;
      int var39 = this.field_92.method_107(var35, var37).method_107(var11, var17).method_109(var19).method_110();
      double var40 = (var1 + var5 - var26) * var22 - (var3 + var7 - var28) * var24 + var26;
      double var42 = (var3 + var7 - var28) * var22 + (var1 + var5 - var26) * var24 + var28;
      int var44 = this.field_92.method_107(var40, var42).method_107(var15, var17).method_109(var19).method_110();
      double var45 = (var1 + var5 - var26) * var22 - (var3 - var28) * var24 + var26;
      double var47 = (var3 - var28) * var22 + (var1 + var5 - var26) * var24 + var28;
      int var49 = this.field_92.method_107(var45, var47).method_107(var15, var13).method_109(var19).method_110();
      this.field_92.method_112(var34, var39, var44, var49);
   }

   // $VF: renamed from: ioi (double, double, double, double, double, Class_193, Class_262) void
   public void method_153(double var1, double var3, double var5, double var7, double var9, Class_193 var11, Class_262 var12) {
      this.method_152(var1, var3, var5, var7, var9, var11.field_546, var11.field_547, var11.field_548, var11.xqgr, var12);
   }
}

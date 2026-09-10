import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.krypton.mixin.ProjectionMatrix2Accessor;
import net.minecraft.class_10366;
import net.minecraft.class_11278;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

public class RenderEngine_104 {
   // $VF: renamed from: rpq org.joml.Matrix4f
   public static Matrix4f field_739 = new Matrix4f();
   // $VF: renamed from: pta net.minecraft.class_11278
   public static class_11278 field_740;
   // $VF: renamed from: vtb org.joml.Matrix4f
   public static Matrix4f field_741;
   // $VF: renamed from: rnn org.joml.Vector4f
   public static Vector4f field_742;
   // $VF: renamed from: oeg net.minecraft.class_243
   public static class_243 field_743;
   // $VF: renamed from: nnb boolean
   public static boolean field_744;
   // $VF: renamed from: rb RenderEngine_386
   public RenderEngine_386 field_745;
   // $VF: renamed from: sqq RenderEngine_386
   public RenderEngine_386 field_746;
   // $VF: renamed from: obe com.mojang.blaze3d.pipeline.RenderPipeline
   public RenderPipeline field_747;
   public RenderPipeline lume;

   public RenderEngine_104(RenderPipeline var1, RenderPipeline var2) {
      this.field_745 = new RenderEngine_386(var1);
      this.field_746 = new RenderEngine_386(var2);
      this.field_747 = var1;
      this.lume = var2;
   }

   // $VF: renamed from: sf () void
   public static void method_749() {
      float var0 = (float)((class_310)ScreenUI_78.field_771).method_22683().method_4489();
      float var1 = (float)((class_310)ScreenUI_78.field_771).method_22683().method_4506();
      RenderSystem.setProjectionMatrix(field_740.method_71092(var0, var1), class_10366.field_54953);
      field_739.set(((ProjectionMatrix2Accessor)field_740).krypton$callGetMatrix(var0, var1));
      field_744 = false;
   }

   // $VF: renamed from: win () void
   public static void method_750() {
      float var0 = (float)(((class_310)ScreenUI_78.field_771).method_22683().method_4489() / ((class_310)ScreenUI_78.field_771).method_22683().method_4495());
      float var1 = (float)(((class_310)ScreenUI_78.field_771).method_22683().method_4506() / ((class_310)ScreenUI_78.field_771).method_22683().method_4495());
      RenderSystem.setProjectionMatrix(field_740.method_71092(var0, var1), class_10366.field_54953);
      field_739.set(((ProjectionMatrix2Accessor)field_740).krypton$callGetMatrix(var0, var1));
      field_744 = true;
   }

   public static Vector3f myky(double var0, double var2, double var4) {
      class_243 var6 = ((class_310)ScreenUI_78.field_771).field_1773.method_19418().method_71156();
      field_742.set((float)(var0 - var6.field_1352), (float)(var2 - var6.field_1351), (float)(var4 - var6.field_1350), 1.0F);
      field_742.mul(field_741);
      field_742.mul(field_739);
      if (field_742.w <= 0.0F) {
         return null;
      } else {
         float var7 = 1.0F / field_742.w;
         float var8 = field_742.x * var7;
         float var9 = field_742.y * var7;
         float var10 = (float)((class_310)ScreenUI_78.field_771).method_22683().method_4495();
         float var11 = (var8 * 0.5F + 0.5F) * (float)((class_310)ScreenUI_78.field_771).method_22683().method_4489() / var10;
         float var12 = (1.0F - (var9 * 0.5F + 0.5F)) * (float)((class_310)ScreenUI_78.field_771).method_22683().method_4506() / var10;
         return new Vector3f(var11, var12, field_742.z * var7);
      }
   }

   // $VF: renamed from: kfv (org.joml.Matrix4f, org.joml.Matrix4f) void
   public static void method_751(Matrix4f var0, Matrix4f var1) {
      field_739.set(var0);
      field_741.set(var1);
      Matrix4f var2 = new Matrix4f(var0).invert();
      Matrix4f var3 = new Matrix4f(var1).invert();
      Vector4f var4 = new Vector4f(0.0F, 0.0F, 0.0F, 1.0F).mul(var2).mul(var3);
      var4.div(var4.w);
      class_243 var5 = ((class_310)ScreenUI_78.field_771).field_1773.method_19418().method_71156();
      field_743 = new class_243(var5.field_1352 + (double)var4.x, var5.field_1351 + (double)var4.y, var5.field_1350 + (double)var4.z);
   }

   // $VF: renamed from: htr () void
   public void method_752() {
      this.field_745.method_105();
      this.field_746.method_105();
   }

   // $VF: renamed from: otr (net.minecraft.class_4587) void
   public void method_753(class_4587 var1) {
      RenderEngine_374.method_163().method_166(class_310.method_1551().method_1522()).method_168(this.field_747).method_172(this.field_745, var1).method_178();
      RenderEngine_374.method_163().method_166(class_310.method_1551().method_1522()).method_168(this.lume).method_172(this.field_746, var1).method_178();
   }

   // $VF: renamed from: fzs (double, double, double, double, double, double, Class_262, Class_262) void
   public void method_754(double var1, double var3, double var5, double var7, double var9, double var11, Class_262 var13, Class_262 var14) {
      this.field_745.method_116();
      this.field_745
         .method_111(
            this.field_745.method_106(var1, var3, var5).method_109(var13).method_110(),
            this.field_745.method_106(var7, var9, var11).method_109(var14).method_110()
         );
   }

   // $VF: renamed from: aen (double, double, double, double, double, double, Class_262) void
   public void method_755(double var1, double var3, double var5, double var7, double var9, double var11, Class_262 var13) {
      this.method_754(var1, var3, var5, var7, var9, var11, var13, var13);
   }

   // $VF: renamed from: kcp (double, double, double, double, double, double, Class_262, int) void
   public void method_756(double var1, double var3, double var5, double var7, double var9, double var11, Class_262 var13, int var14) {
      this.field_745.method_117(8, 24);
      int var15 = this.field_745.method_106(var1, var3, var5).method_109(var13).method_110();
      int var16 = this.field_745.method_106(var1, var3, var11).method_109(var13).method_110();
      int var17 = this.field_745.method_106(var7, var3, var5).method_109(var13).method_110();
      int var18 = this.field_745.method_106(var7, var3, var11).method_109(var13).method_110();
      int var19 = this.field_745.method_106(var1, var9, var5).method_109(var13).method_110();
      int var20 = this.field_745.method_106(var1, var9, var11).method_109(var13).method_110();
      int var21 = this.field_745.method_106(var7, var9, var5).method_109(var13).method_110();
      int var22 = this.field_745.method_106(var7, var9, var11).method_109(var13).method_110();
      if (var14 == 0) {
         this.field_745.method_111(var15, var19);
         this.field_745.method_111(var16, var20);
         this.field_745.method_111(var17, var21);
         this.field_745.method_111(var18, var22);
         this.field_745.method_111(var15, var16);
         this.field_745.method_111(var17, var18);
         this.field_745.method_111(var15, var17);
         this.field_745.method_111(var16, var18);
         this.field_745.method_111(var19, var20);
         this.field_745.method_111(var21, var22);
         this.field_745.method_111(var19, var21);
         this.field_745.method_111(var20, var22);
      } else {
         if (Class_36.method_1119(var14, (byte)32) && Class_36.method_1119(var14, (byte)8)) {
            this.field_745.method_111(var15, var19);
         }

         if (Class_36.method_1119(var14, (byte)32) && Class_36.method_1119(var14, (byte)16)) {
            this.field_745.method_111(var16, var20);
         }

         if (Class_36.method_1119(var14, (byte)64) && Class_36.method_1119(var14, (byte)8)) {
            this.field_745.method_111(var17, var21);
         }

         if (Class_36.method_1119(var14, (byte)64) && Class_36.method_1119(var14, (byte)16)) {
            this.field_745.method_111(var18, var22);
         }

         if (Class_36.method_1119(var14, (byte)32) && Class_36.method_1119(var14, (byte)4)) {
            this.field_745.method_111(var15, var16);
         }

         if (Class_36.method_1119(var14, (byte)64) && Class_36.method_1119(var14, (byte)4)) {
            this.field_745.method_111(var17, var18);
         }

         if (Class_36.method_1119(var14, (byte)8) && Class_36.method_1119(var14, (byte)4)) {
            this.field_745.method_111(var15, var17);
         }

         if (Class_36.method_1119(var14, (byte)16) && Class_36.method_1119(var14, (byte)4)) {
            this.field_745.method_111(var16, var18);
         }

         if (Class_36.method_1119(var14, (byte)32) && Class_36.method_1119(var14, (byte)2)) {
            this.field_745.method_111(var19, var20);
         }

         if (Class_36.method_1119(var14, (byte)64) && Class_36.method_1119(var14, (byte)2)) {
            this.field_745.method_111(var21, var22);
         }

         if (Class_36.method_1119(var14, (byte)8) && Class_36.method_1119(var14, (byte)2)) {
            this.field_745.method_111(var19, var21);
         }

         if (Class_36.method_1119(var14, (byte)16) && Class_36.method_1119(var14, (byte)2)) {
            this.field_745.method_111(var20, var22);
         }
      }
   }

   // $VF: renamed from: qn (int, int, int, Class_262, int) void
   public void method_757(int var1, int var2, int var3, Class_262 var4, int var5) {
      this.method_756((double)var1, (double)var2, (double)var3, (double)(var1 + 1), (double)(var2 + 1), (double)(var3 + 1), var4, var5);
   }

   // $VF: renamed from: jtg (double, double, double, double, double, double, double, double, double, double, double, double, Class_262, Class_262, Class_262, Class_262) void
   public void method_758(
      double var1,
      double var3,
      double var5,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15,
      double var17,
      double var19,
      double var21,
      double var23,
      Class_262 var25,
      Class_262 var26,
      Class_262 var27,
      Class_262 var28
   ) {
      this.field_746.method_114();
      this.field_746
         .method_112(
            this.field_746.method_106(var1, var3, var5).method_109(var28).method_110(),
            this.field_746.method_106(var7, var9, var11).method_109(var25).method_110(),
            this.field_746.method_106(var13, var15, var17).method_109(var26).method_110(),
            this.field_746.method_106(var19, var21, var23).method_109(var27).method_110()
         );
   }

   // $VF: renamed from: mmj (double, double, double, double, double, double, double, double, double, double, double, double, Class_262) void
   public void method_759(
      double var1,
      double var3,
      double var5,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15,
      double var17,
      double var19,
      double var21,
      double var23,
      Class_262 var25
   ) {
      this.method_758(var1, var3, var5, var7, var9, var11, var13, var15, var17, var19, var21, var23, var25, var25, var25, var25);
   }

   // $VF: renamed from: tep (double, double, double, double, double, double, Class_262) void
   public void method_760(double var1, double var3, double var5, double var7, double var9, double var11, Class_262 var13) {
      this.method_759(var1, var3, var5, var1, var9, var5, var7, var9, var11, var7, var3, var11, var13);
   }

   // $VF: renamed from: gvb (double, double, double, double, double, Class_262) void
   public void method_761(double var1, double var3, double var5, double var7, double var9, Class_262 var11) {
      this.method_759(var1, var3, var5, var1, var3, var9, var7, var3, var9, var7, var3, var5, var11);
   }

   // $VF: renamed from: nk (double, double, double, double, double, double, Class_262, Class_262) void
   public void method_762(double var1, double var3, double var5, double var7, double var9, double var11, Class_262 var13, Class_262 var14) {
      this.method_758(var1, var3, var5, var1, var9, var5, var7, var9, var11, var7, var3, var11, var13, var13, var14, var14);
   }

   // $VF: renamed from: uem (double, double, double, double, double, double, double, double, double, double, double, double, Class_262, Class_262, Class_324) void
   public void method_763(
      double var1,
      double var3,
      double var5,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15,
      double var17,
      double var19,
      double var21,
      double var23,
      Class_262 var25,
      Class_262 var26,
      Class_324 var27
   ) {
      if (var27.method_1163()) {
         this.field_745.method_117(4, 8);
         int var28 = this.field_745.method_106(var1, var3, var5).method_109(var26).method_110();
         int var29 = this.field_745.method_106(var7, var9, var11).method_109(var26).method_110();
         int var30 = this.field_745.method_106(var13, var15, var17).method_109(var26).method_110();
         int var31 = this.field_745.method_106(var19, var21, var23).method_109(var26).method_110();
         this.field_745.method_111(var28, var29);
         this.field_745.method_111(var29, var30);
         this.field_745.method_111(var30, var31);
         this.field_745.method_111(var31, var28);
      }

      if (var27.method_1164()) {
         this.method_759(var1, var3, var5, var7, var9, var11, var13, var15, var17, var19, var21, var23, var25);
      }
   }

   // $VF: renamed from: rvr (double, double, double, double, double, double, Class_262, Class_262, Class_324) void
   public void method_764(double var1, double var3, double var5, double var7, double var9, double var11, Class_262 var13, Class_262 var14, Class_324 var15) {
      this.method_763(var1, var3, var5, var1, var9, var5, var7, var9, var11, var7, var3, var11, var13, var14, var15);
   }

   // $VF: renamed from: hx (double, double, double, double, double, Class_262, Class_262, Class_324) void
   public void method_765(double var1, double var3, double var5, double var7, double var9, Class_262 var11, Class_262 var12, Class_324 var13) {
      this.method_763(var1, var3, var5, var1, var3, var9, var7, var3, var9, var7, var3, var5, var11, var12, var13);
   }

   // $VF: renamed from: rcj (double, double, double, double, double, double, Class_262, int) void
   public void method_766(double var1, double var3, double var5, double var7, double var9, double var11, Class_262 var13, int var14) {
      this.field_746.method_117(8, 36);
      int var15 = this.field_746.method_106(var1, var3, var5).method_109(var13).method_110();
      int var16 = this.field_746.method_106(var1, var3, var11).method_109(var13).method_110();
      int var17 = this.field_746.method_106(var7, var3, var5).method_109(var13).method_110();
      int var18 = this.field_746.method_106(var7, var3, var11).method_109(var13).method_110();
      int var19 = this.field_746.method_106(var1, var9, var5).method_109(var13).method_110();
      int var20 = this.field_746.method_106(var1, var9, var11).method_109(var13).method_110();
      int var21 = this.field_746.method_106(var7, var9, var5).method_109(var13).method_110();
      int var22 = this.field_746.method_106(var7, var9, var11).method_109(var13).method_110();
      if (var14 == 0) {
         this.field_746.method_112(var15, var16, var20, var19);
         this.field_746.method_112(var17, var21, var22, var18);
         this.field_746.method_112(var15, var19, var21, var17);
         this.field_746.method_112(var16, var18, var22, var20);
         this.field_746.method_112(var15, var17, var18, var16);
         this.field_746.method_112(var19, var20, var22, var21);
      } else {
         if (Class_36.method_1119(var14, (byte)32)) {
            this.field_746.method_112(var15, var16, var20, var19);
         }

         if (Class_36.method_1119(var14, (byte)64)) {
            this.field_746.method_112(var17, var21, var22, var18);
         }

         if (Class_36.method_1119(var14, (byte)8)) {
            this.field_746.method_112(var15, var19, var21, var17);
         }

         if (Class_36.method_1119(var14, (byte)16)) {
            this.field_746.method_112(var16, var18, var22, var20);
         }

         if (Class_36.method_1119(var14, (byte)4)) {
            this.field_746.method_112(var15, var17, var18, var16);
         }

         if (Class_36.method_1119(var14, (byte)2)) {
            this.field_746.method_112(var19, var20, var22, var21);
         }
      }
   }

   // $VF: renamed from: jr (int, int, int, Class_262, int) void
   public void method_767(int var1, int var2, int var3, Class_262 var4, int var5) {
      this.method_766((double)var1, (double)var2, (double)var3, (double)(var1 + 1), (double)(var2 + 1), (double)(var3 + 1), var4, var5);
   }

   // $VF: renamed from: vqo (double, double, double, double, double, double, Class_262, Class_262, Class_324, int) void
   public void method_768(
      double var1, double var3, double var5, double var7, double var9, double var11, Class_262 var13, Class_262 var14, Class_324 var15, int var16
   ) {
      if (var15.method_1163()) {
         this.method_756(var1, var3, var5, var7, var9, var11, var14, var16);
      }

      if (var15.method_1164()) {
         this.method_766(var1, var3, var5, var7, var9, var11, var13, var16);
      }
   }

   // $VF: renamed from: sqd (net.minecraft.class_2338, Class_262, Class_262, Class_324, int) void
   public void method_769(class_2338 var1, Class_262 var2, Class_262 var3, Class_324 var4, int var5) {
      if (var4.method_1163()) {
         this.method_756(
            (double)var1.method_10263(),
            (double)var1.method_10264(),
            (double)var1.method_10260(),
            (double)(var1.method_10263() + 1),
            (double)(var1.method_10264() + 1),
            (double)(var1.method_10260() + 1),
            var3,
            var5
         );
      }

      if (var4.method_1164()) {
         this.method_766(
            (double)var1.method_10263(),
            (double)var1.method_10264(),
            (double)var1.method_10260(),
            (double)(var1.method_10263() + 1),
            (double)(var1.method_10264() + 1),
            (double)(var1.method_10260() + 1),
            var2,
            var5
         );
      }
   }

   public void tqic(class_238 var1, Class_262 var2, Class_262 var3, Class_324 var4, int var5) {
      if (var4.method_1163()) {
         this.method_756(var1.field_1323, var1.field_1322, var1.field_1321, var1.field_1320, var1.field_1325, var1.field_1324, var3, var5);
      }

      if (var4.method_1164()) {
         this.method_766(var1.field_1323, var1.field_1322, var1.field_1321, var1.field_1320, var1.field_1325, var1.field_1324, var2, var5);
      }
   }

   static {
      class_11278 var10000 = new class_11278;
      int var10002 = 87892600 & 87892600 ^ 87892600;

      StringBuilder var10003;
      for (var10003 = new StringBuilder("\u0ef6࿖Ⴖྖဖྲྀབܶྖ࿖ྲྀ໖ึ\u0df6ဖຶྲྀབܶ༶බဖ࿖ຶ႖"); var10002 < 25; var10002 += 1) {
         int var2 = var10003.charAt(var10002) - 189 - 115 - 102;
         int var10006 = (var2 & 65504) >> 5;
         int var3 = (var2 & 65504) >> 5 | var2 << 11;
         int var7 = (((var2 & 65504) >> 5 | var2 << 11) & 65535) >> 0;
         char var4 = (char)(((var10006 | var2 << 11) & 65535) >> 0 | ((var2 & 65504) >> 5 | var2 << 11) << 16);
         var10003.setCharAt(var10002, (char)(var7 | var3 << 16));
      }

      var10000./* $VF: Unable to resugar constructor */<init>(var10003.toString(), -10.0F, 100.0F, true);
      field_740 = var10000;
      field_741 = new Matrix4f();
      field_742 = new Vector4f();
      field_744 = true;
   }
}

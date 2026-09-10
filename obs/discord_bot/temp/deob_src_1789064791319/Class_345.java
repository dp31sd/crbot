import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import net.minecraft.class_11280;

public class Class_345 {
   // $VF: renamed from: aa int
   public static int field_188 = new Std140SizeCalculator().putVec4().putVec4().putVec4().putVec4().putVec4().putVec4().get();
   // $VF: renamed from: gzz Class_138
   public static Class_138 field_189 = new Class_138();
   // $VF: renamed from: gq net.minecraft.class_11280
   public static class_11280 field_190;

   // $VF: renamed from: ny () void
   public static void method_257() {
      field_190.method_71100();
   }

   // $VF: renamed from: cgk (float, float, float, float, float, float, float, float, Class_262, Class_262, Class_262, float, float, float, boolean) com.mojang.blaze3d.buffers.GpuBufferSlice
   public static GpuBufferSlice method_258(
      float var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      Class_262 var8,
      Class_262 var9,
      Class_262 var10,
      float var11,
      float var12,
      float var13,
      boolean var14
   ) {
      field_189.field_656 = var0;
      field_189.field_657 = var1;
      field_189.field_658 = var2;
      field_189.field_659 = var3;
      field_189.field_660 = var4;
      field_189.field_661 = var5;
      field_189.field_662 = var6;
      field_189.field_663 = var7;
      field_189.field_664 = var8;
      field_189.field_665 = var9;
      field_189.field_666 = var10;
      field_189.field_667 = var11;
      field_189.field_668 = var12;
      field_189.field_669 = var13;
      field_189.field_670 = var14 ? 1.0F : 0.0F;
      return field_190.method_71102(field_189);
   }

   static {
      class_11280 var10000 = new class_11280;
      int var10002 = (1300773025 - 1300773025 | 0) & -1246660922;

      StringBuilder var10003;
      for (var10003 = new StringBuilder("ｼﾕﾮﾗﾫﾐﾑｇｒｇｸﾓﾆﾔﾔｇﾊ･ｰ"); var10002 < 19; var10002 += 395707681 & -1603747705) {
         int var2 = var10003.charAt(var10002) ^ 11;
         char var3 = (char)(((var2 & 65535) >> 0 | var2 << 16) + 219 - 100 + 93);
         var10003.setCharAt(var10002, (char)(((var2 & 65535) >> 0 | var2 << 16) + 219 - 100 + 93));
      }

      var10000./* $VF: Unable to resugar constructor */<init>(var10003.toString(), field_188, 256);
      field_190 = var10000;
   }
}

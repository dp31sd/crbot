import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import net.minecraft.class_11280;

public class Class_212 {
   // $VF: renamed from: aa int
   public static int field_494 = new Std140SizeCalculator().putVec2().putFloat().get();
   // $VF: renamed from: ec Class_351
   public static Class_351 field_495 = new Class_351();
   // $VF: renamed from: gq net.minecraft.class_11280
   public static class_11280 field_496;

   // $VF: renamed from: tw () void
   public static void method_536() {
      field_496.method_71100();
   }

   // $VF: renamed from: ta (float, float, float) com.mojang.blaze3d.buffers.GpuBufferSlice
   public static GpuBufferSlice method_537(float var0, float var1, float var2) {
      field_495.vbqg = var0;
      field_495.field_185 = var1;
      field_495.field_186 = var2;
      return field_496.method_71102(field_495);
   }

   static {
      class_11280 var10000 = new class_11280;
      int var10002 = 0;

      StringBuilder var10003;
      for (var10003 = new StringBuilder("੪ࣺॊࣚࠚު\u07ba\u0bdaஊ\u0bda৺ޚࠊࣺ\u0bdaਊ৺প");
         var10002 < ((1657895582 & (-1117020428 | 1657895582) | 0) & -2127789709);
         var10002 += -991366215 & 587336773
      ) {
         int var2 = (var10003.charAt(var10002) ^ 131 ^ 246) + 177;
         char var3 = (char)(((var2 & 65520) >> 4 | var2 << 12) ^ 230);
         var10003.setCharAt(var10002, (char)(((var2 & 65520) >> 4 | var2 << 12) ^ 230));
      }

      var10000./* $VF: Unable to resugar constructor */<init>(var10003.toString(), field_494, 64);
      field_496 = var10000;
   }
}

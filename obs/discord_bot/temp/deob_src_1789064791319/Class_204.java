import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import net.minecraft.class_11280;
import org.joml.Matrix4f;

public class Class_204 {
   // $VF: renamed from: aa int
   public static int field_500 = new Std140SizeCalculator().putMat4f().putMat4f().get();
   // $VF: renamed from: vfy Class_2
   public static Class_2 field_501 = new Class_2();
   // $VF: renamed from: gq net.minecraft.class_11280
   public static class_11280 field_502;

   public static void axww() {
      field_502.method_71100();
   }

   // $VF: renamed from: ukx (org.joml.Matrix4f, org.joml.Matrix4f) com.mojang.blaze3d.buffers.GpuBufferSlice
   public static GpuBufferSlice method_550(Matrix4f var0, Matrix4f var1) {
      field_501.field_1508 = var0;
      field_501.field_1509 = var1;
      return field_502.method_71102(field_501);
   }

   static {
      class_11280 var10000 = new class_11280;
      int var10002 = (123666535 << (-1264209631 & 123666535) | 0) & -1589585903;

      StringBuilder var10003;
      for (var10003 = new StringBuilder("⏽迾毾韾蟾鏾鿾\ud7fd鯽\ud7fd᯽믾菾럾\ud7fdﯾ俽ᏽ"); var10002 < 18; var10002 += (-577233956 >> -577233956 | 1) & 3) {
         char var2 = var10003.charAt(var10002);
         int var10006 = (var2 & '\uffc0') >> 6;
         int var3 = (var2 & '\uffc0') >> 6 | var2 << '\n';
         int var7 = (((var2 & '\uffc0') >> 6 | var2 << '\n') & 65520) >> 4;
         var2 = (char)(((((var10006 | var2 << '\n') & 65520) >> 4 | ((var2 & '\uffc0') >> 6 | var2 << '\n') << 12) ^ 62) - 38 + 251);
         var10003.setCharAt(var10002, (char)(((var7 | var3 << 12) ^ 62) - 38 + 251));
      }

      var10000./* $VF: Unable to resugar constructor */<init>(var10003.toString(), field_500, 512);
      field_502 = var10000;
   }
}

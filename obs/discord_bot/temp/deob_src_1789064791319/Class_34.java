import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import net.minecraft.class_11280;

public class Class_34 {
   // $VF: renamed from: aa int
   public static int field_989 = new Std140SizeCalculator().putVec4().putVec4().putVec4().get();
   // $VF: renamed from: vs Class_380
   public static Class_380 field_990 = new Class_380();
   // $VF: renamed from: gq net.minecraft.class_11280
   public static class_11280 field_991;

   // $VF: renamed from: kz () void
   public static void method_1126() {
      field_991.method_71100();
   }

   // $VF: renamed from: kh (float, float, float, float, float, float, float, float, float, float, float) com.mojang.blaze3d.buffers.GpuBufferSlice
   public static GpuBufferSlice method_1127(
      float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10
   ) {
      field_990.field_104 = var0;
      field_990.field_105 = var1;
      field_990.field_106 = var2;
      field_990.field_107 = var3;
      field_990.field_108 = var4;
      field_990.field_109 = var5;
      field_990.field_110 = var6;
      field_990.field_111 = var7;
      field_990.field_112 = var8;
      field_990.field_113 = var9;
      field_990.field_114 = var10;
      return field_991.method_71102(field_990);
   }

   static {
      class_11280 var10000 = new class_11280;
      int var10002 = 0;

      StringBuilder var10003;
      for (var10003 = new StringBuilder("ⷠㅠ㓠だ\u2e60㯠㭠ᡠ\u1ae0ᡠ⥠㩠⻠ㅠ⇠㣠㫠だ㩠㛠ᡠỠ⥠⯠");
         var10002 < ((-1520502491 >>> -1520502491 | 24) & 978387004);
         var10002 += 86700752 >>> -1463371047 - (86700752 ^ -1463371047) ^ 1323
      ) {
         char var2 = var10003.charAt(var10002);
         char var5 = (char)(
            ((((((var2 & '\ufff0') >> 4 | var2 << '\f') + 27 ^ 161) & 65535) >> 0 | (((var2 & '\ufff0') >> 4 | var2 << '\f') + 27 ^ 161) << 16) & 65528) >> 3
               | (((((var2 & '\ufff0') >> 4 | var2 << '\f') + 27 ^ 161) & 65535) >> 0 | (((var2 & '\ufff0') >> 4 | var2 << '\f') + 27 ^ 161) << 16) << 13
         );
         var10003.setCharAt(
            var10002,
            (char)(
               ((((((var2 & '\ufff0') >> 4 | var2 << '\f') + 27 ^ 161) & 65535) >> 0 | (((var2 & '\ufff0') >> 4 | var2 << '\f') + 27 ^ 161) << 16) & 65528)
                     >> 3
                  | (((((var2 & '\ufff0') >> 4 | var2 << '\f') + 27 ^ 161) & 65535) >> 0 | (((var2 & '\ufff0') >> 4 | var2 << '\f') + 27 ^ 161) << 16) << 13
            )
         );
      }

      var10000./* $VF: Unable to resugar constructor */<init>(var10003.toString(), field_989, 256);
      field_991 = var10000;
   }
}

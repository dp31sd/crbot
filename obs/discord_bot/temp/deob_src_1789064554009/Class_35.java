import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Class_35 {
   // $VF: renamed from: fvh java.lang.String[]
   public static String[] field_983;
   // $VF: renamed from: exj java.util.List
   public static List field_984;
   // $VF: renamed from: kab java.lang.String
   public static String field_985;
   // $VF: renamed from: stp Class_162
   public static Class_162 field_986;
   // $VF: renamed from: jgt RenderEngine_243
   public static RenderEngine_243 field_987;
   // $VF: renamed from: eck boolean
   public static boolean field_988;

   // $VF: renamed from: ke () void
   public static void method_1122() {
      if (!field_988) {
         field_988 = true;
         method_1123();
      }
   }

   // $VF: renamed from: dqk () void
   public static void method_1123() {
      field_984.clear();

      for (String var3 : field_983) {
         CryptoService_63.method_841(field_984, var3);
      }

      for (String var5 : CryptoService_63.method_838()) {
         CryptoService_63.method_842(field_984, new File(var5), field_983);
      }

      field_984.sort(Comparator.comparing(Class_184::iro));
      field_985 = CryptoService_63.method_836(field_983[0]).method_873();
      field_986 = method_1125(field_985).method_608(Class_388.field_1019);
      method_1124(field_986);
   }

   // $VF: renamed from: jjx (Class_162) void
   public static void method_1124(Class_162 var0) {
      if (field_987 != null) {
         if (field_987.field_447.equals(var0)) {
            return;
         }

         field_987.method_457();
      }

      try {
         field_987 = new RenderEngine_243(var0);
      } catch (Exception var4) {
         if (var0.equals(field_986)) {
            RuntimeException var5 = new RuntimeException;
            String var2 = String.valueOf(var0);
            StringBuilder var7 = new StringBuilder();
            byte var9 = 0;

            StringBuilder var15;
            for (var15 = new StringBuilder("<ĕĝâęĚVêãVâãĕĚVĚęĜĕéâêVĜãäê0V"); var9 < ((526883950 >>> (-1743145747 & -1743145747) | 29) & 335610975); var9 += 1) {
               var15.setCharAt(var9, (char)((var15.charAt(var9) - 154 - 7 ^ 152 ^ 249) + 76));
            }

            var5./* $VF: Unable to resugar constructor */<init>(var7.append(var15.toString()).append((Object)var2).toString(), var4);
            throw var5;
         }

         PrintStream var10000 = System.err;
         String var3 = String.valueOf(var0);
         StringBuilder var10001 = new StringBuilder();
         int var10002 = (1572535216 & 1153903955 | 0) & -1418198910;

         StringBuilder var10003;
         for (var10003 = new StringBuilder("憱ᆳ醳솳决䆳Ư䆴\uf1b3Ư솳\uf1b3ᆳ䆳Ư憳\uf1b3\ue1b3䆴ꆰƯ");
            var10002 < ((691669231 >> -1567104542 | 20) & -1542370283);
            var10002 += 1846875516 & 1846875516 ^ 1846875517
         ) {
            int var11 = var10003.charAt(var10002) - '"' - 147 ^ 248;
            int var10006 = (var11 & 63488) >> 11;
            int var12 = (var11 & 63488) >> 11 | var11 << 5;
            int var20 = (((var11 & 63488) >> 11 | var11 << 5) & 65534) >> 1;
            char var13 = (char)(((var10006 | var11 << 5) & 65534) >> 1 | ((var11 & 63488) >> 11 | var11 << 5) << 15);
            var10003.setCharAt(var10002, (char)(var20 | var12 << 15));
         }

         var10000.println(var10001.append(var10003.toString()).append((Object)var3).toString());
         var4.printStackTrace();
         method_1124(field_986);
      }
   }

   // $VF: renamed from: ypc (java.lang.String) Class_184
   public static Class_184 method_1125(String var0) {
      for (Class_184 var2 : field_984) {
         if (var2.method_609().equalsIgnoreCase(var0)) {
            return var2;
         }
      }

      return null;
   }

   static {
      String[] var10000 = new String[1];
      int var10003 = 0;

      StringBuilder var10004;
      for (var10004 = new StringBuilder("ĉĒđė"); var10003 < 4; var10003 += -813974306 ^ -813974305) {
         int var2 = var10004.charAt(var10003) + 7 - 170;
         char var5 = (char)(
            (((((var2 & 49152) >> 14 | var2 << 2) & 32768) >> 15 | ((var2 & 49152) >> 14 | var2 << 2) << 1) & 65528) >> 3
               | ((((var2 & 49152) >> 14 | var2 << 2) & 32768) >> 15 | ((var2 & 49152) >> 14 | var2 << 2) << 1) << 13
         );
         var10004.setCharAt(
            var10003,
            (char)(
               (((((var2 & 49152) >> 14 | var2 << 2) & 32768) >> 15 | ((var2 & 49152) >> 14 | var2 << 2) << 1) & 65528) >> 3
                  | ((((var2 & 49152) >> 14 | var2 << 2) & 32768) >> 15 | ((var2 & 49152) >> 14 | var2 << 2) << 1) << 13
            )
         );
      }

      var10000[0] = var10004.toString();
      field_983 = var10000;
      field_984 = new ArrayList();
      field_988 = false;
   }
}

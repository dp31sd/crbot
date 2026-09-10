import dev.krypton.native.Loader;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;
import java.lang.invoke.MethodHandles.Lookup;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Class_143 extends LinkedHashMap<Class_219, Boolean> {
   // $VF: renamed from: vrf java.lang.invoke.MethodHandle[]
   public static final MethodHandle[] field_655 = new MethodHandle[1];

   public Class_143(Class_320 var1, int var2, float var3, boolean var4) {
      this.field_654 = var1;
      super(var2, var3, var4);
   }

   @Override
   public boolean removeEldestEntry(Entry var1) {
      return 0<"JNT",2013649179,"댭̭笭⌭","啨卨鍨","뼂뼂",1346994301>(this) > 10000;
   }

   static {
      Loader.init(Class_143.class);
   }

   // $VF: renamed from: 0 (java.lang.invoke.MethodHandles.Lookup, java.lang.String, java.lang.invoke.MethodType, java.lang.Object[]) java.lang.Object
   public static Object method_648(Lookup var0, String var1, MethodType var2, Object... var3) {
      int var10 = (Integer)var3[4];
      int var10001 = ((var10 + 130867565 - 7764245 ^ 905358592) - 1384408020 + 873913677 - 162173000 ^ 42491865) + 364258021 + 889815114;
      MethodHandle var10000 = field_655[((var10 + 130867565 - 7764245 ^ 905358592) - 1384408020 + 873913677 - 162173000 ^ 42491865)
         + 364258021
         + 889815114
         + 2087119858];
      if (field_655[var10001 + 2087119858] == null) {
         int var4 = (Integer)var3[0];
         StringBuilder var13 = new StringBuilder((String)var3[1]);

         for (int var23 = (-1221470012 << -670058439 | 0) & 313650842; var23 < var13.length(); var23 += -2094660179 >> 1213336723 ^ -3995) {
            int var42 = var13.charAt(var23) - '$' + 2;
            char var45 = (char)(
               (
                     ((((((var42 & 65024) >> 9 | var42 << 7) & 49152) >> 14 | ((var42 & 65024) >> 9 | var42 << 7) << 2) + 44 ^ 219 ^ 41) - 192 & 65520) >> 4
                        | (((((var42 & 65024) >> 9 | var42 << 7) & 49152) >> 14 | ((var42 & 65024) >> 9 | var42 << 7) << 2) + 44 ^ 219 ^ 41) - 192 << 12
                  )
                  - 247
            );
            var13.setCharAt(
               var23,
               (char)(
                  (
                        ((((((var42 & 65024) >> 9 | var42 << 7) & 49152) >> 14 | ((var42 & 65024) >> 9 | var42 << 7) << 2) + 44 ^ 219 ^ 41) - 192 & 65520) >> 4
                           | (((((var42 & 65024) >> 9 | var42 << 7) & 49152) >> 14 | ((var42 & 65024) >> 9 | var42 << 7) << 2) + 44 ^ 219 ^ 41) - 192 << 12
                     )
                     - 247
               )
            );
         }

         String var5 = var13.toString();
         StringBuilder var16 = new StringBuilder((String)var3[2]);

         for (int var29 = (-1666858929 & 2025476920 | 0) & 88121220; var29 < var16.length(); var29 += (-637228080 | 1085824068 | 1) & 88080393) {
            int var50 = (var16.charAt(var29) - 186 ^ 24) - 72 - 70;
            int var77 = (var50 & 65532) >> 2;
            int var51 = (((var50 & 65532) >> 2 | var50 << 14) ^ 217 ^ 198) - 82 ^ 195;
            int var78 = (((((var50 & 65532) >> 2 | var50 << 14) ^ 217 ^ 198) - 82 ^ 195) & 65408) >> 7;
            char var52 = (char)(
               ((((var77 | var50 << 14) ^ 217 ^ 198) - 82 ^ 195) & 65408) >> 7 | ((((var50 & 65532) >> 2 | var50 << 14) ^ 217 ^ 198) - 82 ^ 195) << 9
            );
            var16.setCharAt(var29, (char)(var78 | var51 << 9));
         }

         MethodType var6 = MethodType.fromMethodDescriptorString(var16.toString(), Class_143.class.getClassLoader());
         StringBuilder var19 = new StringBuilder((String)var3[3]);

         for (int var35 = 2116868033 + 2116868033 ^ -61231230; var35 < var19.length(); var35 += (-426361047 | -175140180 >>> -1332316641 | 1) & 287408343) {
            int var57 = (var19.charAt(var35) - 'N' ^ 77) + 248 - 237 ^ 242;
            int var79 = (var57 & 65528) >> 3;
            int var58 = (var57 & 65528) >> 3 | var57 << 13;
            int var80 = (((var57 & 65528) >> 3 | var57 << 13) & 64512) >> 10;
            char var59 = (char)((((var79 | var57 << 13) & 64512) >> 10 | ((var57 & 65528) >> 3 | var57 << 13) << 6) + 83 + 90 + 8);
            var19.setCharAt(var35, (char)((var80 | var58 << 6) + 83 + 90 + 8));
         }

         Class var7 = Class.forName(var19.toString(), false, Class_143.class.getClassLoader());
         switch ((((var4 ^ 708974390 ^ 1553588738 ^ 2066099938) - 1332111055 ^ 1682299615 ^ 679033531) + 439774916 + 969107223 ^ 1071687862) - 1709633037) {
            case 459344822:
            case 1509566906:
               var10000 = var0.findVirtual(var7, var5, var6);
               break;
            case 1263072618:
               var10000 = var0.findStatic(var7, var5, var6);
               break;
            case 1378878621:
               var10000 = var0.findSpecial(var7, var5, var6, Class_143.class);
               break;
            case 1925531447:
               var10000 = var0.findConstructor(var7, var6);
               break;
            default:
               throw new UnsupportedOperationException("Unsupported handle type!");
         }
      }

      field_655[((var10 + 130867565 - 7764245 ^ 905358592) - 1384408020 + 873913677 - 162173000 ^ 42491865) + 364258021 + 889815114 + 2087119858] = var10000;
      MethodHandle var11 = var10000.asType(var2);
      return new MutableCallSite(var11);
   }

   public static native void guard();
}

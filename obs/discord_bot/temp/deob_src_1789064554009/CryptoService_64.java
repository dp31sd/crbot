import java.nio.charset.StandardCharsets;

public class CryptoService_64 {
   // $VF: renamed from: wvd (Class_27, byte[][]) byte[]
   public static byte[] method_828(Class_27 var0, byte[]... var1) {
      int var2 = 0;
      if (var1 != null) {
         for (byte[] var6 : var1) {
            var2 += var6 == null ? 0 : var6.length;
         }
      }

      byte[] var9 = new byte[var2];
      int var10 = 0;
      if (var1 != null) {
         for (byte[] var8 : var1) {
            if (var8 != null) {
               System.arraycopy(var8, 0, var9, var10, var8.length);
               var10 += var8.length;
            }
         }
      }

      return var9;
   }

   // $VF: renamed from: fjp (java.lang.String) byte[]
   public static byte[] method_829(String var0) {
      return var0 == null ? new byte[0] : var0.getBytes(StandardCharsets.UTF_8);
   }

   // $VF: renamed from: ezo (byte[], long) Class_27
   public static Class_27 method_830(byte[] var0, long var1) {
      return Class_27.VALUE;
   }

   public static String qbph(byte[] var0, int var1, long var2) {
      if (var0 == null) {
         return "";
      } else {
         int var4 = Math.max(0, Math.min(var1, var0.length));
         return new String(var0, var4, var0.length - var4, StandardCharsets.UTF_8);
      }
   }

   // $VF: renamed from: icr (byte[], int, int, long) java.lang.String
   public static String method_831(byte[] var0, int var1, int var2, long var3) {
      if (var0 == null) {
         return "";
      } else {
         int var5 = Math.max(0, Math.min(var1, var0.length));
         int var6 = Math.max(0, Math.min(var2, var0.length - var5));
         return new String(var0, var5, var6, StandardCharsets.UTF_8);
      }
   }

   // $VF: renamed from: rku (byte[], int[], int) java.lang.String
   public static String method_832(byte[] var0, int[] var1, int var2) {
      return var0 == null ? "" : new String(var0, StandardCharsets.UTF_8);
   }

   // $VF: renamed from: cbq (long) void
   static void method_833(long var0) {
   }

   public void __jnt__init__4027283382148594292__() {
   }

   public static void guard() {
   }
}

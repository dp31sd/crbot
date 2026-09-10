import java.io.InputStream;

public class Class_275 extends Class_162 {
   // $VF: renamed from: nb java.lang.String
   public String field_579;

   public Class_275(RenderEngine_298 var1, String var2) {
      super(var1);
      this.field_579 = var2;
   }

   // $VF: renamed from: xf () java.io.InputStream
   @Override
   public InputStream method_624() {
      InputStream var1 = CryptoService_63.method_845(this.field_579);
      if (var1 != null) {
         return var1;
      } else {
         RuntimeException var10000 = new RuntimeException;
         String var2 = this.field_579;
         StringBuilder var10002 = new StringBuilder();
         int var10003 = 0;

         StringBuilder var10004;
         for (var10004 = new StringBuilder("肻\uf0b9点₹낹ꂹ\ue0a5ꂸႹ\ue0a5₹Ⴙ\uf0b9ꂹ\ue0a5삹낸点₹ꂸ点¹\ue0a5肹Ⴙ¹ꂸ\ue0a5");
            var10003 < (-2080374756 & 1115251135);
            var10003 += 639092376 ^ -140281472 ^ -776683751
         ) {
            int var5 = var10004.charAt(var10003) ^ 156 ^ 56;
            char var6 = (char)((((var5 & 61440) >> 12 | var5 << 4) ^ 254) - 192);
            var10004.setCharAt(var10003, (char)((((var5 & 61440) >> 12 | var5 << 4) ^ 254) - 192));
         }

         var10000./* $VF: Unable to resugar constructor */<init>(var10002.append(var10004.toString()).append((Object)var2).append(".").toString());
         throw var10000;
      }
   }

   @Override
   public String toString() {
      String var1 = super.toString();
      StringBuilder var10000 = new StringBuilder().append((Object)var1);
      byte var10001 = 0;

      StringBuilder var10002;
      for (var10002 = new StringBuilder("瀍\uf00d选쀊\t《뀊\t倊\r"); var10001 < ((1884644119 - -1539684321 | 2) & 816054286); var10001 += 1) {
         int var4 = var10002.charAt(var10001) - 223;
         int var10005 = (var4 & 0) >> 16;
         int var5 = ((var4 & 0) >> 16 | var4 << 0) ^ 214;
         int var9 = ((((var4 & 0) >> 16 | var4 << 0) ^ 214) & 61440) >> 12;
         char var6 = (char)(((((var10005 | var4 << 0) ^ 214) & 61440) >> 12 | (((var4 & 0) >> 16 | var4 << 0) ^ 214) << 4) + 154);
         var10002.setCharAt(var10001, (char)((var9 | var5 << 4) + 154));
      }

      return var10000.append(var10002.toString()).toString();
   }
}

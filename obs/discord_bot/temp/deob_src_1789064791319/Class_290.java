import java.io.InputStream;
import java.nio.file.Path;

public class Class_290 extends Class_162 {
   public Path zeid;

   public Class_290(RenderEngine_298 var1, Path var2) {
      super(var1);
      this.zeid = var2;
   }

   // $VF: renamed from: xf () java.io.InputStream
   @Override
   public InputStream method_624() {
      if (!this.zeid.toFile().exists()) {
         RuntimeException var3 = new RuntimeException;
         int var4 = (-488319195 ^ -488319195 + -488319195 | 0) & -2147318656;

         StringBuilder var7;
         for (var7 = new StringBuilder("祐ﰯﮟﭟﭏ\uf70fﱏﯿ\uf70f\ufbcfﯿײַﭏ\uf70fﭯﯿﯯﱏ\uf70fﱏﮏײַﱏ\uf70fﯯﯿ\uf70f\ufbcfﯿﯯﭿﭟﰯ\uf70fﭟﲏﮟﰿﱏﰿ\uf7ef"); var4 < 41; var4 += 1) {
            char var11 = var7.charAt(var4);
            char var12 = (char)(((var11 & '\ufff0') >> 4 | var11 << '\f') + 104 + 5 + 110 - 43);
            var7.setCharAt(var4, (char)(((var11 & '\ufff0') >> 4 | var11 << '\f') + 104 + 5 + 110 - 43));
         }

         var3./* $VF: Unable to resugar constructor */<init>(var7.toString());
         throw var3;
      } else {
         InputStream var1 = CryptoService_63.method_846(this.zeid.toFile());
         if (var1 != null) {
            return var1;
         } else {
            RuntimeException var10000 = new RuntimeException;
            String var2 = String.valueOf(this.zeid);
            StringBuilder var10002 = new StringBuilder();
            int var10003 = (-1702298118 >> 314429015 | 0) & 200;

            StringBuilder var10004;
            for (var10004 = new StringBuilder("ᚻ芻ꊻ꺻銻躻纼캻못纼꺻못芻躻纼隻못뚻캻纼隻욻못늻纼");
               var10003 < ((-786872876 + (2101778013 << 962162778) | 25) & 838860859);
               var10003 += 341011547 >>> -1540633783 ^ 666039
            ) {
               int var14 = (var10004.charAt(var10003) + 229 + 5 ^ 95) + 7;
               char var15 = (char)((var14 & 64512) >> 10 | var14 << 6);
               var10004.setCharAt(var10003, (char)((var14 & 64512) >> 10 | var14 << 6));
            }

            var10000./* $VF: Unable to resugar constructor */<init>(var10002.append(var10004.toString()).append((Object)var2).append(".").toString());
            throw var10000;
         }
      }
   }

   @Override
   public String toString() {
      String var2 = this.zeid.toString();
      String var1 = super.toString();
      StringBuilder var10000 = new StringBuilder().append((Object)var1);
      int var10001 = 0;

      StringBuilder var10002;
      for (var10002 = new StringBuilder("ƧƯ"); var10001 < ((-1327162548 | 2) & 1243267235); var10001 += (416635265 << -1536545852 | 1) & 805848013) {
         var10002.setCharAt(var10001, (char)((var10002.charAt(var10001) - 135 ^ 166) - 127 - 71 ^ 224));
      }

      return var10000.append(var10002.toString()).append((Object)var2).append(")").toString();
   }
}

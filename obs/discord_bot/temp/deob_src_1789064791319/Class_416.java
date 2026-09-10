import com.mojang.blaze3d.platform.TextureUtil;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.TextureFormat;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

public class Class_416 {
   // $VF: renamed from: tu java.lang.String
   public static String field_13;
   // $VF: renamed from: lc java.lang.String
   public static String field_14;
   // $VF: renamed from: zum java.util.Map
   public static Map field_15;
   // $VF: renamed from: na RenderEngine_297
   public static RenderEngine_297 field_16;
   // $VF: renamed from: eck boolean
   public static boolean field_17;

   // $VF: renamed from: my () void
   public static void method_38() {
      if (!field_17) {
         field_17 = true;

         try {
            method_39();
            method_40();
         } catch (Exception var1) {
            var1.printStackTrace();
         }
      }
   }

   // $VF: renamed from: qx () void
   public static void method_39() throws Exception {
      ClassLoader var10000 = Class_416.class.getClassLoader();
      int var10001 = -2109580797 << (-601184600 >> -2109580797 - -601184600) ^ 402653184;

      StringBuilder var10002;
      for (var10002 = new StringBuilder(
            "\ue9a4\uea44\uea44\ue964\uea74\uea44\ue684\ueac4\uea54\uea24\ueab4\uea74\uea84\uea94\ue684\ue924\ue944\uea84\uea94\ue984\ue9a4\uea74\ueaf4\ue9a4\uea44\ue694\uea74\uea34\uea74"
         );
         var10001 < 29;
         var10001 += 1
      ) {
         int var18 = var10002.charAt(var10001) ^ 219;
         char var19 = (char)(((var18 & 65520) >> 4 | var18 << 12) + 86 + 191 + 181);
         var10002.setCharAt(var10001, (char)(((var18 & 65520) >> 4 | var18 << 12) + 86 + 191 + 181));
      }

      InputStream var0 = var10000.getResourceAsStream(var10002.toString());
      if (var0 == null) {
         RuntimeException var13 = new RuntimeException;
         int var16 = (1297285120 | 0) & -1845428866;

         StringBuilder var21;
         for (var21 = new StringBuilder(
               "\uf6ee\uf8ae漏漏\uf8ae\uf8fe\uf88e\uf61e\uf82e漏漏\uf86e丹漏\uf50e\uf8ce菉瑩爛丹癩\uf8fe\uf50e\uf8ae\uf84e癩\uf8fe\uf80e\uf82e丹\uf8de\uf82e漏\uf4fe丹咽丹"
            );
            var16 < (748193514 >>> 129814116 * 1279500330 ^ 2922659);
            var16 += (-2050792549 * 1983441175 | 0) & -530478573
         ) {
            int var24 = var21.charAt(var16) - 31;
            char var27 = (char)(
               (((((var24 & 65024) >> 9 | var24 << 7) + 7 & 65520) >> 4 | ((var24 & 65024) >> 9 | var24 << 7) + 7 << 12) & 65408) >> 7
                  | ((((var24 & 65024) >> 9 | var24 << 7) + 7 & 65520) >> 4 | ((var24 & 65024) >> 9 | var24 << 7) + 7 << 12) << 9
            );
            var21.setCharAt(
               var16,
               (char)(
                  (((((var24 & 65024) >> 9 | var24 << 7) + 7 & 65520) >> 4 | ((var24 & 65024) >> 9 | var24 << 7) + 7 << 12) & 65408) >> 7
                     | ((((var24 & 65024) >> 9 | var24 << 7) + 7 & 65520) >> 4 | ((var24 & 65024) >> 9 | var24 << 7) + 7 << 12) << 9
               )
            );
         }

         var13./* $VF: Unable to resugar constructor */<init>(var21.toString());
         throw var13;
      } else {
         String var2;
         try (BufferedReader var1 = new BufferedReader(new InputStreamReader(var0))) {
            while ((var2 = var1.readLine()) != null) {
               var2 = var2.trim();
               if (!var2.isEmpty() && !var2.startsWith("#")) {
                  String[] var3 = var2.split(",");
                  String var4 = var3[0];
                  int var5 = Integer.parseInt(var3[1]);
                  int var6 = Integer.parseInt(var3[2]);
                  int var7 = Integer.parseInt(var3[3]);
                  int var8 = Integer.parseInt(var3[4]);
                  Class_193 var9 = new Class_193(1.0, 1.0);
                  var9.field_546 = (double)var5 / (double)var7;
                  var9.field_547 = (double)var6 / (double)var8;
                  var9.field_548 = (double)(var5 + 1) / (double)var7;
                  var9.xqgr = (double)(var6 + 1) / (double)var8;
                  field_15.put(var4, var9);
               }
            }
         }
      }
   }

   // $VF: renamed from: vln () void
   public static void method_40() throws Exception {
      ClassLoader var10000 = Class_416.class.getClassLoader();
      int var10001 = 0;

      StringBuilder var10002;
      for (var10002 = new StringBuilder("ꀗ\ue015\ue015‗\u0015\ue015怞\ue016쀕ꀔ耕\u0015怖䀖怞ꀖ\ue017怖䀖怐ꀗ\u0015\u0016ꀗ\ue015䀞耕䀖怗");
         var10001 < ((9 | 21) & 527820445);
         var10001 += (1961101160 ^ 405487642 - (1961101160 & 405487642) | 1) & 34637957
      ) {
         char var17 = var10002.charAt(var10001);
         char var20 = (char)(
            (
                  ((((((var17 & '\uf000') >> 12 | var17 << 4) ^ 136) & 49152) >> 14 | (((var17 & '\uf000') >> 12 | var17 << 4) ^ 136) << 2) & 65528) >> 3
                     | (((((var17 & '\uf000') >> 12 | var17 << 4) ^ 136) & 49152) >> 14 | (((var17 & '\uf000') >> 12 | var17 << 4) ^ 136) << 2) << 13
               )
               ^ 152
         );
         var10002.setCharAt(
            var10001,
            (char)(
               (
                     ((((((var17 & '\uf000') >> 12 | var17 << 4) ^ 136) & 49152) >> 14 | (((var17 & '\uf000') >> 12 | var17 << 4) ^ 136) << 2) & 65528) >> 3
                        | (((((var17 & '\uf000') >> 12 | var17 << 4) ^ 136) & 49152) >> 14 | (((var17 & '\uf000') >> 12 | var17 << 4) ^ 136) << 2) << 13
                  )
                  ^ 152
            )
         );
      }

      InputStream var0 = var10000.getResourceAsStream(var10002.toString());
      if (var0 == null) {
         RuntimeException var11 = new RuntimeException;
         int var15 = (-1829621975 + 58994224 | 0) & 1611211298;

         StringBuilder var24;
         for (var24 = new StringBuilder("☄㐄㤄㤄㐄㞄㌄ႄ〄㤄㤄㈄㪄㤄ᜄ㔄㦄㰄㢄㪄㜄㞄ᜄ㐄\u3104㜄㞄⼄〄㪄㚄〄㤄ង㢄㞄㌄");
            var15 < (-1139503848 >>> -1868639512 ^ 12326056);
            var15 += (294147053 << 1856532902 | 1) & 79692981
         ) {
            int var31 = var24.charAt(var15) + 't' ^ 206 ^ 54;
            int var47 = (var31 & 57344) >> 13;
            int var32 = (var31 & 57344) >> 13 | var31 << 3;
            int var48 = (((var31 & 57344) >> 13 | var31 << 3) & 64512) >> 10;
            char var33 = (char)(((var47 | var31 << 3) & 64512) >> 10 | ((var31 & 57344) >> 13 | var31 << 3) << 6);
            var24.setCharAt(var15, (char)(var48 | var32 << 6));
         }

         var11./* $VF: Unable to resugar constructor */<init>(var24.toString());
         throw var11;
      } else {
         ByteBuffer var1 = TextureUtil.readResource(var0);
         var1.rewind();
         MemoryStack var2 = MemoryStack.stackPush();

         try {
            IntBuffer var3 = var2.mallocInt(1);
            IntBuffer var4 = var2.mallocInt(1);
            IntBuffer var5 = var2.mallocInt(1);
            ByteBuffer var6 = STBImage.stbi_load_from_memory(var1, var3, var4, var5, 4);
            if (var6 == null) {
               RuntimeException var10 = new RuntimeException;
               String var7 = STBImage.stbi_failure_reason();
               var10002 = new StringBuilder();
               int var22 = 242755264 & 1161743438 ^ 70779968;

               StringBuilder var28;
               for (var28 = new StringBuilder("ḃ☂昂丂\u0602ข⸀踂嘂⸀ข\u0602㘂嘂ข\u0602⸀昂㘂嘂市⸀☂踂丂☂똂︀⸀");
                  var22 < ((1636307045 * 1451415865 | 28) & -1602208737);
                  var22 += (-394814271 >>> -1231972632 | 1) & -184285117
               ) {
                  char var38 = var28.charAt(var22);
                  char var41 = (char)(
                     ((((((var38 & 'ﰀ') >> 10 | var38 << 6) & 32768) >> 15 | ((var38 & 'ﰀ') >> 10 | var38 << 6) << 1) ^ 233 ^ 126) & 65532) >> 2
                        | (((((var38 & 'ﰀ') >> 10 | var38 << 6) & 32768) >> 15 | ((var38 & 'ﰀ') >> 10 | var38 << 6) << 1) ^ 233 ^ 126) << 14
                  );
                  var28.setCharAt(
                     var22,
                     (char)(
                        ((((((var38 & 'ﰀ') >> 10 | var38 << 6) & 32768) >> 15 | ((var38 & 'ﰀ') >> 10 | var38 << 6) << 1) ^ 233 ^ 126) & 65532) >> 2
                           | (((((var38 & 'ﰀ') >> 10 | var38 << 6) & 32768) >> 15 | ((var38 & 'ﰀ') >> 10 | var38 << 6) << 1) ^ 233 ^ 126) << 14
                     )
                  );
               }

               var10./* $VF: Unable to resugar constructor */<init>(var10002.append(var28.toString()).append((Object)var7).toString());
               throw var10;
            }

            field_16 = new RenderEngine_297(var3.get(0), var4.get(0), TextureFormat.RGBA8, FilterMode.LINEAR, FilterMode.LINEAR);
            field_16.method_2097(var6);
            STBImage.stbi_image_free(var6);
         } catch (Throwable var9) {
            if (var2 != null) {
               try {
                  var2.close();
               } catch (Throwable var8) {
                  var9.addSuppressed(var8);
               }
            }

            throw var9;
         }

         if (var2 != null) {
            var2.close();
         }

         MemoryUtil.memFree(var1);
      }
   }

   // $VF: renamed from: uk (java.lang.String, double, double, double, Class_262) void
   public static void method_41(String var0, double var1, double var3, double var5, Class_262 var7) {
      if (field_16 != null) {
         Class_193 var8 = (Class_193)field_15.get(var0);
         if (var8 != null) {
            boolean var9 = RenderEngine_384.field_90.method_142();
            if (var9) {
               RenderEngine_384.field_90.method_141();
            }

            RenderEngine_384.field_91.method_138();
            RenderEngine_384.field_91.method_151(var1, var3, var5, var5, var8, var7);
            RenderEngine_384.field_91.method_144(field_16.method_71659(), field_16.method_75484());
            if (var9) {
               RenderEngine_384.field_90.method_140();
            }
         }
      }
   }

   // $VF: renamed from: kd (java.lang.String) boolean
   public static boolean method_42(String var0) {
      return field_15.containsKey(var0);
   }

   static {
      int var10000 = 0;

      StringBuilder var10001;
      for (var10001 = new StringBuilder("빰뻠뻠빐뻘뻠밀븠뻨뺰뻸뻘븀븈밀븰빠븀븈부빰뻘븘빰뻠밈뻘뺸뻘");
         var10000 < ((-1292262628 | -1052145800 >>> -1052145800) ^ -1292262464);
         var10000 += (1529793708 + 1529793708 | 1) & 1101013505
      ) {
         char var6 = var10001.charAt(var10000);
         int var10004 = (var6 & 'ﾀ') >> 7;
         int var7 = ((var6 & 'ﾀ') >> 7 | var6 << '\t') - 166 ^ 222;
         int var18 = ((((var6 & 'ﾀ') >> 7 | var6 << '\t') - 166 ^ 222) & 61440) >> 12;
         var6 = (char)(((((var10004 | var6 << '\t') - 166 ^ 222) & 61440) >> 12 | (((var6 & 'ﾀ') >> 7 | var6 << '\t') - 166 ^ 222) << 4) ^ 239);
         var10001.setCharAt(var10000, (char)((var18 | var7 << 4) ^ 239));
      }

      field_14 = var10001.toString();
      var10000 = (1099877205 >>> (1099877205 >> 1099877205) | 0) & -529807856;

      for (var10001 = new StringBuilder("玱㎳㎳\uf3b1펳㎳뎪㎲Ꮃ玴厳펳뎲鎲뎪玲㎱뎲鎲뎰玱펳펲玱㎳鎪厳鎲뎱");
         var10000 < 29;
         var10000 += 632540878 ^ -1383654591 + (632540878 << -1383654591) ^ -581077486
      ) {
         int var11 = var10001.charAt(var10000) - 165;
         int var19 = (var11 & 65408) >> 7;
         int var12 = (((var11 & 65408) >> 7 | var11 << 9) ^ 186) - 28;
         int var20 = ((((var11 & 65408) >> 7 | var11 << 9) ^ 186) - 28 & 65472) >> 6;
         char var13 = (char)((((var19 | var11 << 9) ^ 186) - 28 & 65472) >> 6 | (((var11 & 65408) >> 7 | var11 << 9) ^ 186) - 28 << 10);
         var10001.setCharAt(var10000, (char)(var20 | var12 << 10));
      }

      field_13 = var10001.toString();
      field_15 = new HashMap();
      field_17 = false;
   }
}

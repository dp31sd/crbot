import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;
import java.lang.invoke.MethodHandles.Lookup;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_1792;
import net.minecraft.class_1799;

public class Class_188 extends Class_375 {
   // $VF: renamed from: knf Class_105
   public Class_105 field_1314;
   // $VF: renamed from: mr Class_210
   public Class_210 field_1315;
   // $VF: renamed from: loi int
   public int field_1316 = 13;
   // $VF: renamed from: ce float
   public float field_1317 = 3.0F;
   // $VF: renamed from: aet Class_262
   public Class_262 field_1318 = (Class_262)0<"JNT",-1039361262,"홮\ufdeeｮ\ufdee\uf26e흮","톒짒짒짒퇒찒","黼\u0efc",-144663963>(100, 100, 110);
   // $VF: renamed from: yq Class_262
   public Class_262 field_1319 = (Class_262)0<"JNT",-1039361262,"홮\ufdeeｮ\ufdee\uf26e흮","톒짒짒짒퇒찒","黼\u0efc",-144663942>(40, 40, 45);
   // $VF: renamed from: wsl Class_262
   public Class_262 field_1320 = (Class_262)0<"JNT",-1039361262,"홮\ufdeeｮ\ufdee\uf26e흮","톒짒짒짒퇒찒","黼\u0efc",-144663937>(30, 30, 35);
   // $VF: renamed from: ajn Class_262
   public Class_262 field_1321 = (Class_262)0<"JNT",-1039361262,"홮\ufdeeｮ\ufdee\uf26e흮","톒짒짒짒퇒찒","黼\u0efc",-144663940>(60, 60, 65);
   // $VF: renamed from: lb float
   public float field_1322 = 0.002F;
   // $VF: renamed from: yf float
   public float field_1323 = 0.0F;
   // $VF: renamed from: thl java.lang.invoke.MethodHandle[]
   public static final MethodHandle[] field_1324 = new MethodHandle[(30409629 & 30409629 | 108) & 741111918];

   public Class_188(Class_199 var1, Class_105 var2, Class_210 var3, int var4) {
      super(var1, var2, var4);
      this.field_1314 = var2;
      this.field_1315 = var3;
      this.field_1323 = 0<"JNT",37406501,"燐\uf46e","톒퇒촒","\u0efd뻼",-144663943>(var2) ? 1.0F : 0.0F;
   }

   // $VF: renamed from: vk (RenderEngine_216, int, int, float) void
   @Override
   public void method_1268(RenderEngine_216 var1, int var2, int var3, float var4) {
      float var5 = var4 * 0.05F;
      float var6 = 0<"JNT",37406501,"燐\uf46e","톒퇒촒","\u0efd뻼",-144663949>(
            1<"JNT",-1530474827,"\ue6c5\ue785\ue585","\uf04e\uf1ce","젃좃\uda03\ue783\ued03톃",-1658159918>(this)
         )
         ? 1.0F
         : 0.0F;
      1<"JNT",1432655406,"\uea45\ue585","\uf04e\uf1ce","젃좃휃",-1658159866>(
         this,
         (float)0<"JNT",-1675249403,"\uf4ee\uf36eﻮ","톒좒좒좒좒퇒좒","껼軼份",-144663939>(
            (double)1<"JNT",-1530474827,"\uea45\ue585","\uf04e\uf1ce","젃좃휃",-1658159872>(this), (double)var6, 0.002F, (double)var5
         )
      );
      1<"JNT",1432655406,"\uea45\ue585","\uf04e\uf1ce","젃좃휃",-1658159869>(
         this,
         (float)0<"JNT",-1675249403,"\uf36e\uf4ee\uf16e","톒좒좒좒퇒좒","껼軼份",-144663948>(
            (double)1<"JNT",-1530474827,"\uea45\ue585","\uf04e\uf1ce","젃좃휃",-1658159867>(this), 0.0, 1.0
         )
      );
      int var7 = 0<"JNT",37406501,"\uf1ee\uf16eｮ","톒퇒짒","廽\udefc",-144663946>(this)
         + 0<"JNT",37406501,"\uffef\uffefﭮ","톒퇒짒","廽\udefc",-144664053>(this)
         + 1<"JNT",-1530474827,"\ue6c5\ue885\ue8c5","\uf04e\uf1ce","젃좃\ud883",-1658159784>(this)
         + 0<"JNT",37406501,"\uf0ee\uf1ee","톒퇒짒","廽\udefc",-144663947>(this) / 2
         - 6;
      0<"JNT",37406501,"ﳮﱮ","톒쪒섒뿒쐒뿒퉒슒뿒숒쁒퉒쭒쒒쌒쇒숒쁒핒좒좒쪒쎒쑒핒퇒좒","滽\ufefd",-144664050>(
         var1,
         0<"JNT",37406501,"ﭮ\ufa6e\uf5ee","톒퇒쪒섒뿒쐒뿒퉒슒뿒숒쁒퉒쭒쒒쌒쇒숒쁒핒","\u0efd뻼",-144664049>(
            1<"JNT",-1530474827,"\ue6c5\ue785\ue585","\uf04e\uf1ce","젃좃\uda03\ue783\ued03톃",-1658159778>(this)
         ),
         (double)(0<"JNT",37406501,"\uf46e\uf06e\uf46e","톒퇒짒","廽\udefc",-144664052>(this) + 27),
         (double)var7,
         1<"JNT",1392392704,"\ue6c5\ue445","\uf04e\uf1ce","젃좃\uda03\uec03\uef83톃",-1658159781>()
      );
      0<"JNT",37406501,"\uf26e\uf46e\uf1ee","톒쪒싒쐒핒퇒찒","廽\udefc",-144664061>(this, var1);
      0<"JNT",37406501,"\uf1ee\uf56e\ufa6e","톒쪒싒쐒핒퇒찒","廽\udefc",-144664064>(this, var1);
   }

   // $VF: renamed from: txq (RenderEngine_216) void
   public void method_1306(RenderEngine_216 var1) {
      int var2 = 0<"JNT",37406501,"\uf46e\uf06e\uf46e","톒퇒짒","廽\udefc",-144664051>(this) + 8;
      int var3 = 0<"JNT",37406501,"\uf1ee\uf16eｮ","톒퇒짒","廽\udefc",-144664062>(this)
         + 0<"JNT",37406501,"\uffef\uffefﭮ","톒퇒짒","廽\udefc",-144664057>(this)
         + 1<"JNT",-1530474827,"\ue6c5\ue885\ue8c5","\uf04e\uf1ce","젃좃\ud883",-1658159788>(this)
         + 0<"JNT",37406501,"\uf0ee\uf1ee","톒퇒짒","廽\udefc",-144664063>(this) / 2
         - 6;
      0<"JNT",37406501,"ｮ\ufaee\ufa6e","톒쪒쎒쑒핒좒좒좒좒좒좒좒좒퇒찒","滽\ufefd",-144664037>(
         var1,
         1<"JNT",-1530474827,"\ue445\ue545\ue905","\uf04e\uf1ce","젃좃\uda03\uec03\uef83톃",-1658159782>(this),
         (double)var2,
         (double)var3,
         (double)(var2 + 13),
         (double)(var3 + 13),
         3.0,
         3.0,
         3.0,
         3.0
      );
      0<"JNT",37406501,"ｮ\ufaee\ufa6e","톒쪒쎒쑒핒좒좒좒좒좒좒좒좒퇒찒","滽\ufefd",-144664059>(
         var1,
         1<"JNT",-1530474827,"\uea45\ue845","\uf04e\uf1ce","젃좃\uda03\uec03\uef83톃",-1658159768>(this),
         (double)(var2 + 1),
         (double)(var3 + 1),
         (double)(var2 + 13 - 1),
         (double)(var3 + 13 - 1),
         2.5,
         2.5,
         2.5,
         2.5
      );
      if (1<"JNT",-1530474827,"\uea45\ue585","\uf04e\uf1ce","젃좃휃",-1658159954>(this) > 0.01F) {
         Class_262 var4 = (Class_262)0<"JNT",-1039361262,"홮\ufdeeｮ\ufdee\uf26e흮","톒짒짒짒짒퇒찒","黼\u0efc",-144664046>(
            0<"JNT",37406501,"ﵮ\uf26e\uf16e","톒퇒짒","黼\u0efc",-144664036>(
               1<"JNT",-1530474827,"\ue6c5\ue985\ue6c5","\uf04e\uf1ce","젃좃\uda03\uec03\uef83톃",-1658159955>(this)
            ),
            0<"JNT",37406501,"ﻮﵮ","톒퇒짒","黼\u0efc",-144664034>(
               1<"JNT",-1530474827,"\ue6c5\ue985\ue6c5","\uf04e\uf1ce","젃좃\uda03\uec03\uef83톃",-1658159957>(this)
            ),
            0<"JNT",37406501,"\ufe6eﳮ\uf36e","톒퇒짒","黼\u0efc",-144664048>(
               1<"JNT",-1530474827,"\ue6c5\ue985\ue6c5","\uf04e\uf1ce","젃좃\uda03\uec03\uef83톃",-1658159951>(this)
            ),
            (int)(255.0F * 1<"JNT",-1530474827,"\uea45\ue585","\uf04e\uf1ce","젃좃휃",-1658159777>(this))
         );
         float var5 = 9.0F;
         float var6 = (float)(var2 + 2) + var5 * (1.0F - 1<"JNT",-1530474827,"\uea45\ue585","\uf04e\uf1ce","젃좃휃",-1658159771>(this)) / 2.0F;
         float var7 = (float)(var3 + 2) + var5 * (1.0F - 1<"JNT",-1530474827,"\uea45\ue585","\uf04e\uf1ce","젃좃휃",-1658159772>(this)) / 2.0F;
         0<"JNT",37406501,"ｮ\ufaee\ufa6e","톒쪒쎒쑒핒좒좒좒좒좒좒좒좒퇒찒","滽\ufefd",-144664021>(
            var1,
            var4,
            (double)var6,
            (double)var7,
            (double)(var6 + var5 * 1<"JNT",-1530474827,"\uea45\ue585","\uf04e\uf1ce","젃좃휃",-1658159773>(this)),
            (double)(var7 + var5 * 1<"JNT",-1530474827,"\uea45\ue585","\uf04e\uf1ce","젃좃휃",-1658159766>(this)),
            1.5,
            1.5,
            1.5,
            1.5
         );
         if (1<"JNT",-1530474827,"\uea45\ue585","\uf04e\uf1ce","젃좃휃",-1658159944>(this) > 0.7F) {
            float var8 = (1<"JNT",-1530474827,"\uea45\ue585","\uf04e\uf1ce","젃좃휃",-1658159945>(this) - 0.7F) * 3.33F;
            0<"JNT",37406501,"ｮ\ufaee\ufa6e","톒쪒쎒쑒핒좒좒좒좒좒좒좒좒퇒찒","滽\ufefd",-144664019>(
               var1,
               (Class_262)0<"JNT",-1039361262,"홮\ufdeeｮ\ufdee\uf26e흮","톒짒짒짒짒퇒찒","黼\u0efc",-144664032>(
                  0<"JNT",37406501,"ﵮ\uf26e\uf16e","톒퇒짒","黼\u0efc",-144664017>(
                     1<"JNT",-1530474827,"\ue6c5\ue985\ue6c5","\uf04e\uf1ce","젃좃\uda03\uec03\uef83톃",-1658159938>(this)
                  ),
                  0<"JNT",37406501,"ﻮﵮ","톒퇒짒","黼\u0efc",-144664023>(
                     1<"JNT",-1530474827,"\ue6c5\ue985\ue6c5","\uf04e\uf1ce","젃좃\uda03\uec03\uef83톃",-1658159940>(this)
                  ),
                  0<"JNT",37406501,"\ufe6eﳮ\uf36e","톒퇒짒","黼\u0efc",-144664029>(
                     1<"JNT",-1530474827,"\ue6c5\ue985\ue6c5","\uf04e\uf1ce","젃좃\uda03\uec03\uef83톃",-1658159934>(this)
                  ),
                  (int)(40.0F * var8)
               ),
               (double)(var2 - 1),
               (double)(var3 - 1),
               (double)(var2 + 13 + 1),
               (double)(var3 + 13 + 1),
               3.5,
               3.5,
               3.5,
               3.5
            );
         }
      }
   }

   // $VF: renamed from: qzd (RenderEngine_216) void
   // $VF: Irreducible bytecode was duplicated to produce valid code
   public void method_1307(RenderEngine_216 var1) {
      int var7 = -737500679;
      byte var2 = 22;
      int var3 = 0<"JNT",37406501,"\uf46e\uf06e\uf46e","톒퇒짒","廽\udefc",-144664030>(this) + 0<"JNT",37406501,"ﵮﱮ","톒퇒짒","廽\udefc",-144664025>(this) - var2 - 8;
      int var4 = 0<"JNT",37406501,"\uf1ee\uf16eｮ","톒퇒짒","廽\udefc",-144664028>(this)
         + 0<"JNT",37406501,"\uffef\uffefﭮ","톒퇒짒","廽\udefc",-144664031>(this)
         + 1<"JNT",-1530474827,"\ue6c5\ue885\ue8c5","\uf04e\uf1ce","젃좃\ud883",-1658159942>(this)
         + 0<"JNT",37406501,"\uf0ee\uf1ee","톒퇒짒","廽\udefc",-144664005>(this) / 2;
      int var5 = var4 - var2 / 2;
      0<"JNT",37406501,"ﭮﱮ\uf06e","톒쪒쎒쑒핒좒좒좒좒좒퇒찒","滽\ufefd",-144664027>(
         var1,
         1<"JNT",-1530474827,"\ue9c5\ue8c5\ue705","\uf04e\uf1ce","젃좃\uda03\uec03\uef83톃",-1658159928>(this),
         (double)var3,
         (double)var5,
         (double)(var3 + var2),
         (double)(var5 + var2),
         6.0
      );
      0<"JNT",37406501,"ﭮ\uf56e\uf1ee","톒쪒쎒쑒핒좒좒좒좒좒좒좒좒좒퇒찒","滽\ufefd",-144664001>(
         var1,
         1<"JNT",-1530474827,"\ue445\ue685\ue785","\uf04e\uf1ce","젃좃\uda03\uec03\uef83톃",-1658159986>(this),
         (double)var3,
         (double)var5,
         (double)(var3 + var2),
         (double)(var5 + var2),
         6.0,
         6.0,
         6.0,
         6.0,
         1.0
      );
      class_1792 var6 = 0<"JNT",37406501,"\ufe6e\uf06e\uf4ee","톒퇒쪒숒샒쒒퉒싒쇒숒샒뽒쌒뿒쀒쒒퉒뽒슒뿒썒썒칒폒푒헒팒핒","滽軼",-144664007>(
         1<"JNT",-1530474827,"\ue745\ue885","\uf04e\uf1ce","젃좃\uda03\uea83\ueb83톃",-1658159988>(this)
      );
      if (var6 != null
         && var6
            != 1<"JNT",1392392704,"\ue585\ue645\ue545\ue705\ue505\uf3c5洞\uf845礪\uf885","\uf06e\uf0de\uf1ce\uec6e\uf05e\uf09e\uf06e\uf0de\uef3e\uf02e\uef1e\uf0ee\uf1ce\uec6e\uef3e\uf04e\uef1e\uf03e\uf03e\uef7e\uec1e\ued8e\uec0e\uec2e","젃좃\uda03\ueb03\ue683\uee03쮃\uea83\ue883\ueb03\ue683\ue583\ued03\ue483\ue703\uee03쮃\ue583\uea03\ue483\ued83\ued83\ue383첃쾃킃촃톃",-1658159982>()
         )
       {
         0<"JNT",-1675249403,"\uf5ee\uf16e\uf36e","톒쪒숒샒쒒퉒싒쇒숒샒뽒쌒뿒쀒쒒퉒뽒슒뿒썒썒칒퍒퍒팒핒쪒숒샒쒒퉒싒쇒숒샒뽒쌒뿒쀒쒒퉒뽒슒뿒썒썒칒폒푒헒헒핒짒짒퇒찒","滽\ufefd",-144663491>(
            0<"JNT",37406501,"\uf2ee\ufa6e\uf2ee","톒퇒쪒숒샒쒒퉒싒쇒숒샒뽒쌒뿒쀒쒒퉒뽒슒뿒썒썒칒퍒퍒팒핒","滽\ufefd",-144663501>(var1),
            (class_1799)0<"JNT",-1039361262,"홮\ufdeeｮ\ufdee\uf26e흮","톒쪒숒샒쒒퉒싒쇒숒샒뽒쌒뿒쀒쒒퉒뽒슒뿒썒썒칒폒헒퍒퓒핒퇒찒","综\ueefd\udefc纨滽\u2efd综\ueefd컽뻼껽ﻼ\udefc纨컽廽껽컼컼軽꺨ຨ⺨⺨",-144663504>(
               var6
            ),
            var3 + 3,
            var5 + 3
         );
         var7 = 925296517;
      } else {
         var7 = (-1707371615 & -1810829274 | 1216621278) & 1575381982;
      }

      while (true) {
         switch ((var7 + 256899663 + 1569741542 ^ 826866685 ^ 2035094042) + 202322399 - 1636720025) {
            case -1769756253:
            default:
               return;
            case 937573946:
               0<"JNT",37406501,"ﳮﱮ","톒쪒섒뿒쐒뿒퉒슒뿒숒쁒퉒쭒쒒쌒쇒숒쁒핒좒좒쪒쎒쑒핒퇒좒","滽\ufefd",-144663497>(
                  var1,
                  "?",
                  (double)(var3 + var2 / 2 - 3),
                  (double)(var5 + 4),
                  (Class_262)0<"JNT",-1039361262,"홮\ufdeeｮ\ufdee\uf26e흮","톒짒짒짒짒퇒찒","黼\u0efc",-144663502>(150, 150, 150, 200)
               );
         }

         var7 = 925296517;
      }
   }

   // $VF: renamed from: ibh (double, double) boolean
   public boolean method_1308(double var1, double var3) {
      byte var5 = 22;
      int var6 = 0<"JNT",37406501,"\uf46e\uf06e\uf46e","톒퇒짒","廽\udefc",-144663500>(this) + 0<"JNT",37406501,"ﵮﱮ","톒퇒짒","廽\udefc",-144663503>(this) - var5 - 8;
      int var7 = 0<"JNT",37406501,"\uf1ee\uf16eｮ","톒퇒짒","廽\udefc",-144663498>(this)
         + 0<"JNT",37406501,"\uffef\uffefﭮ","톒퇒짒","廽\udefc",-144663349>(this)
         + 1<"JNT",-1530474827,"\ue6c5\ue885\ue8c5","\uf04e\uf1ce","젃좃\ud883",-1658159592>(this)
         + 0<"JNT",37406501,"\uf0ee\uf1ee","톒퇒짒","廽\udefc",-144663499>(this) / 2;
      int var8 = var7 - var5 / 2;
      return var1 >= (double)var6 && var1 <= (double)(var6 + var5) && var3 >= (double)var8 && var3 <= (double)(var8 + var5);
   }

   // $VF: renamed from: yz (net.minecraft.class_11908) void
   @Override
   public void method_1271(class_11908 var1) {
      if (1<"JNT",-1530474827,"\uea85\ue605\ue6c5","\uf04e\uf1ce","젃좃\ue103",-1658159587>(this)
         && 1<"JNT",-1530474827,"\uea85\ue7c5","\uf05e\uef2e","젃좃\ue103",-1658159589>(
            1<"JNT",-1530474827,"\ue705\ue945\ue945","\uf04e\uf1ce","젃좃\uda03\uea83\ue503톃",-1658159588>(this)
         )
         && 0<"JNT",37406501,"\uffefﯮ\uf26eﱮ\uf0ee\ufa6e\uf8ee퓮퉮텮텮푮","톒퇒짒","综\ueefd\udefc纨滽\u2efd综\ueefd컽뻼껽ﻼ\udefc纨컽廽껽컼컼軽꺨꺨⺨麨Ẩ",-144663346>(var1) == 259) {
         0<"JNT",37406501,"\uf0ee葉\ufdee","톒촒퇒찒","\u0efd뻼",-144663358>(
            1<"JNT",-1530474827,"\ue6c5\ue785\ue585","\uf04e\uf1ce","젃좃\uda03\ue783\ued03톃",-1658159583>(this),
            0<"JNT",37406501,"\uf46e\uf06eｮ","톒퇒촒","\u0efd뻼",-144663347>(
               1<"JNT",-1530474827,"\ue6c5\ue785\ue585","\uf04e\uf1ce","젃좃\uda03\ue783\ued03톃",-1658159600>(this)
            )
         );
      }

      0<"JNT",-594454016,"\uf5ee\uf56e","톒쪒숒샒쒒퉒싒쇒숒샒뽒쌒뿒쀒쒒퉒뽒슒뿒썒썒칒폒폒헒펒햒핒퇒찒","\u0efc㻽",-144663350>(this, var1);
   }

   // $VF: renamed from: yr (net.minecraft.class_11909, boolean) void
   // $VF: Irreducible bytecode was duplicated to produce valid code
   @Override
   public void method_1272(class_11909 var1, boolean var2) {
      int var3 = -711214076;
      if (0<"JNT",37406501,"ﳮ\uf46e\uf3ee","톒좒좒퇒촒","廽\udefc",-144663359>(
         this,
         0<"JNT",37406501,"\ufaee\uf0ee\uffef\uf06e\uf8ee퉮퓮헮푮","톒퇒좒","综\ueefd\udefc纨滽\u2efd综\ueefd컽뻼껽ﻼ\udefc纨컽廽껽컼컼軽꺨꺨⺨麨⺨",-144663353>(var1),
         0<"JNT",37406501,"\ufaee\uf0ee\uffef\uf06e\uf8ee퉮퓮헮헮","톒퇒좒","综\ueefd\udefc纨滽\u2efd综\ueefd컽뻼껽ﻼ\udefc纨컽廽껽컼컼軽꺨꺨⺨麨⺨",-144663356>(var1)
      )) {
         if (0<"JNT",37406501,"\uffefﯮ\uf26eﱮ\uf0ee\ufa6e\uf8ee퓮퉮텮퉮폮","톒퇒짒","综\ueefd\udefc纨滽\u2efd综\ueefd컽뻼껽ﻼ\udefc纨컽廽껽컼컼軽꺨꺨⺨麨⺨",-144663354>(var1) == 0) {
            if (0<"JNT",37406501,"\ufdee葉ﱮ","톒좒좒퇒촒","廽\udefc",-144663355>(
               this,
               0<"JNT",37406501,"\ufaee\uf0ee\uffef\uf06e\uf8ee퉮퓮헮푮","톒퇒좒","综\ueefd\udefc纨滽\u2efd综\ueefd컽뻼껽ﻼ\udefc纨컽廽껽컼컼軽꺨꺨⺨麨⺨",-144663333>(var1),
               0<"JNT",37406501,"\ufaee\uf0ee\uffef\uf06e\uf8ee퉮퓮헮헮","톒퇒좒","综\ueefd\udefc纨滽\u2efd综\ueefd컽뻼껽ﻼ\udefc纨컽廽껽컼컼軽꺨꺨⺨麨⺨",-144663336>(var1)
            )) {
               0<"JNT",37406501,"\uffefﯮ\uf26eﱮ\uf0ee\ufa6e\uf8ee퇮폮큮퓮","톒쪒숒샒쒒퉒싒쇒숒샒뽒쌒뿒쀒쒒퉒뽒슒뿒썒썒칒풒퍒푒핒퇒찒","综\ueefd\udefc纨滽\u2efd综\ueefd컽뻼껽ﻼ\udefc纨컽廽껽컼컼軽캨꺨麨",-144663335>(
                  1<"JNT",-1530474827,"\ue705\ue885","\uf04e\uf1ce","젃좃\uda03\ueb03\ue683\uee03쮃\uea83\ue883\ueb03\ue683\ue583\ued03\ue483\ue703\uee03쮃\ue583\uea03\ue483\ued83\ued83\ue383춃첃찃톃",-1658159506>(
                     this
                  ),
                  0<"JNT",-1675249403,"ﱮ\uf3ee\ufe6e","톒쪒싒쉒핒퇒쪒숒샒쒒퉒싒쇒숒샒뽒쌒뿒쀒쒒퉒뽒슒뿒썒썒칒풒퍒푒핒","\ueefc\ufefd",-144663332>(
                     1<"JNT",-1530474827,"\ue745\ue885","\uf04e\uf1ce","젃좃\uda03\uea83\ueb83톃",-1658159507>(this)
                  )
               );
               var3 = 874904450;
            } else {
               var3 = 2091038589 + (2091038589 << 2091038589) ^ -384524042;
            }
         } else {
            var3 = 874904450;
         }
      } else {
         var3 = 874904450;
      }

      while (true) {
         switch (((var3 + 787432291 ^ 2089351612) + 506901281 - 539830975 ^ 1867607130) + 1939817601) {
            case -1392145297:
            default:
               0<"JNT",37406501,"\uf2ee\uffef\ufdee","톒퇒찒","\u0efd뻼",-144663344>(
                  1<"JNT",-1530474827,"\ue6c5\ue785\ue585","\uf04e\uf1ce","젃좃\uda03\ue783\ued03톃",-1658159503>(this)
               );
               var3 = 874904450;
               break;
            case -426416030:
               0<"JNT",-594454016,"\uf5ee\uf16e","톒쪒숒샒쒒퉒싒쇒숒샒뽒쌒뿒쀒쒒퉒뽒슒뿒썒썒칒폒폒헒펒헒핒촒퇒찒","\u0efc㻽",-144663330>(this, var1, var2);
               return;
         }
      }
   }

   // $VF: renamed from: zxs () void
   @Override
   public void method_1270() {
      0<"JNT",-594454016,"\uf56e\uf46e\uf2ee","톒퇒찒","\u0efc㻽",-144663331>(this);
      1<"JNT",1432655406,"\uea45\ue585","\uf04e\uf1ce","젃좃휃",-1658159580>(
         this,
         0<"JNT",37406501,"燐\uf46e","톒퇒촒","\u0efd뻼",-144663337>(
               1<"JNT",-1530474827,"\ue6c5\ue785\ue585","\uf04e\uf1ce","젃좃\uda03\ue783\ued03톃",-1658159578>(this)
            )
            ? 1.0F
            : 0.0F
      );
   }

   // $VF: renamed from: 0 (java.lang.invoke.MethodHandles.Lookup, java.lang.String, java.lang.invoke.MethodType, java.lang.Object[]) java.lang.Object
   public static Object method_1293(Lookup var0, String var1, MethodType var2, Object... var3) {
      int var10 = (Integer)var3[4];
      int var10001 = ((var10 ^ 857104053) - 415065434 - 875853871 ^ 1586351869) - 1909310339 + 745242837 + 773534668 + 563248891 - 222990467;
      MethodHandle var10000 = field_1324[((var10 ^ 857104053) - 415065434 - 875853871 ^ 1586351869)
         - 1909310339
         + 745242837
         + 773534668
         + 563248891
         - 222990467
         - 638191952];
      if (field_1324[var10001 - 638191952] == null) {
         int var4 = (Integer)var3[0];
         StringBuilder var13 = new StringBuilder((String)var3[1]);

         for (int var23 = (-1997702797 << -1236218492 | 0) & 1630011584; var23 < var13.length(); var23 += (-1809657491 * 1282513015 | 1) & -1605868975) {
            int var42 = var13.charAt(var23) + 244 - 186;
            int var10004 = (var42 & 65528) >> 3;
            int var43 = ((var42 & 65528) >> 3 | var42 << 13) - 244 ^ 17;
            int var85 = ((((var42 & 65528) >> 3 | var42 << 13) - 244 ^ 17) & 65520) >> 4;
            char var44 = (char)(
               (((((var10004 | var42 << 13) - 244 ^ 17) & 65520) >> 4 | (((var42 & 65528) >> 3 | var42 << 13) - 244 ^ 17) << 12) - 2 ^ 225 ^ 81) - 241
            );
            var13.setCharAt(var23, (char)(((var85 | var43 << 12) - 2 ^ 225 ^ 81) - 241));
         }

         String var5 = var13.toString();
         StringBuilder var16 = new StringBuilder((String)var3[2]);

         for (int var29 = (432114998 | 576809325 & 576809325 | 0) & -1005453184; var29 < var16.length(); var29 += (2043334228 - 1141191922 | 1) & 1108362753) {
            int var49 = var16.charAt(var29) ^ 160;
            char var54 = (char)(
               (
                        (
                              (
                                    (
                                             (
                                                   (
                                                            (
                                                                     (
                                                                           (((var49 & 32768) >> 15 | var49 << 1) & 65534) >> 1
                                                                              | ((var49 & 32768) >> 15 | var49 << 1) << 15
                                                                        )
                                                                        ^ 59
                                                                  )
                                                                  + 248
                                                               & 65532
                                                         )
                                                         >> 2
                                                      | (
                                                               (
                                                                     (((var49 & 32768) >> 15 | var49 << 1) & 65534) >> 1
                                                                        | ((var49 & 32768) >> 15 | var49 << 1) << 15
                                                                  )
                                                                  ^ 59
                                                            )
                                                            + 248
                                                         << 14
                                                )
                                                & 65408
                                          )
                                          >> 7
                                       | (
                                             (
                                                      (((((var49 & 32768) >> 15 | var49 << 1) & 65534) >> 1 | ((var49 & 32768) >> 15 | var49 << 1) << 15) ^ 59)
                                                            + 248
                                                         & 65532
                                                   )
                                                   >> 2
                                                | (((((var49 & 32768) >> 15 | var49 << 1) & 65534) >> 1 | ((var49 & 32768) >> 15 | var49 << 1) << 15) ^ 59)
                                                      + 248
                                                   << 14
                                          )
                                          << 9
                                 )
                                 ^ 133
                                 ^ 105
                           )
                           & 57344
                     )
                     >> 13
                  | (
                        (
                              (
                                       (
                                             (
                                                      (((((var49 & 32768) >> 15 | var49 << 1) & 65534) >> 1 | ((var49 & 32768) >> 15 | var49 << 1) << 15) ^ 59)
                                                            + 248
                                                         & 65532
                                                   )
                                                   >> 2
                                                | (((((var49 & 32768) >> 15 | var49 << 1) & 65534) >> 1 | ((var49 & 32768) >> 15 | var49 << 1) << 15) ^ 59)
                                                      + 248
                                                   << 14
                                          )
                                          & 65408
                                    )
                                    >> 7
                                 | (
                                       ((((((var49 & 32768) >> 15 | var49 << 1) & 65534) >> 1 | ((var49 & 32768) >> 15 | var49 << 1) << 15) ^ 59) + 248 & 65532)
                                             >> 2
                                          | (((((var49 & 32768) >> 15 | var49 << 1) & 65534) >> 1 | ((var49 & 32768) >> 15 | var49 << 1) << 15) ^ 59) + 248
                                             << 14
                                    )
                                    << 9
                           )
                           ^ 133
                           ^ 105
                     )
                     << 3
            );
            var16.setCharAt(
               var29,
               (char)(
                  (
                           (
                                 (
                                       (
                                                (
                                                      (
                                                               (
                                                                        (
                                                                              (((var49 & 32768) >> 15 | var49 << 1) & 65534) >> 1
                                                                                 | ((var49 & 32768) >> 15 | var49 << 1) << 15
                                                                           )
                                                                           ^ 59
                                                                     )
                                                                     + 248
                                                                  & 65532
                                                            )
                                                            >> 2
                                                         | (
                                                                  (
                                                                        (((var49 & 32768) >> 15 | var49 << 1) & 65534) >> 1
                                                                           | ((var49 & 32768) >> 15 | var49 << 1) << 15
                                                                     )
                                                                     ^ 59
                                                               )
                                                               + 248
                                                            << 14
                                                   )
                                                   & 65408
                                             )
                                             >> 7
                                          | (
                                                (
                                                         (
                                                                  (
                                                                        (((var49 & 32768) >> 15 | var49 << 1) & 65534) >> 1
                                                                           | ((var49 & 32768) >> 15 | var49 << 1) << 15
                                                                     )
                                                                     ^ 59
                                                               )
                                                               + 248
                                                            & 65532
                                                      )
                                                      >> 2
                                                   | (((((var49 & 32768) >> 15 | var49 << 1) & 65534) >> 1 | ((var49 & 32768) >> 15 | var49 << 1) << 15) ^ 59)
                                                         + 248
                                                      << 14
                                             )
                                             << 9
                                    )
                                    ^ 133
                                    ^ 105
                              )
                              & 57344
                        )
                        >> 13
                     | (
                           (
                                 (
                                          (
                                                (
                                                         (
                                                                  (
                                                                        (((var49 & 32768) >> 15 | var49 << 1) & 65534) >> 1
                                                                           | ((var49 & 32768) >> 15 | var49 << 1) << 15
                                                                     )
                                                                     ^ 59
                                                               )
                                                               + 248
                                                            & 65532
                                                      )
                                                      >> 2
                                                   | (((((var49 & 32768) >> 15 | var49 << 1) & 65534) >> 1 | ((var49 & 32768) >> 15 | var49 << 1) << 15) ^ 59)
                                                         + 248
                                                      << 14
                                             )
                                             & 65408
                                       )
                                       >> 7
                                    | (
                                          (
                                                   (((((var49 & 32768) >> 15 | var49 << 1) & 65534) >> 1 | ((var49 & 32768) >> 15 | var49 << 1) << 15) ^ 59)
                                                         + 248
                                                      & 65532
                                                )
                                                >> 2
                                             | (((((var49 & 32768) >> 15 | var49 << 1) & 65534) >> 1 | ((var49 & 32768) >> 15 | var49 << 1) << 15) ^ 59) + 248
                                                << 14
                                       )
                                       << 9
                              )
                              ^ 133
                              ^ 105
                        )
                        << 3
               )
            );
         }

         MethodType var6 = MethodType.fromMethodDescriptorString(var16.toString(), Class_188.class.getClassLoader());
         StringBuilder var19 = new StringBuilder((String)var3[3]);

         for (int var35 = (-1125003147 >>> -20168408 | 0) & 1224737807; var35 < var19.length(); var35 += (-634870703 & 93992544 | 1) & 204902681) {
            char var59 = var19.charAt(var35);
            char var64 = (char)(
               (
                     (
                           (
                                    (
                                          (
                                                   (
                                                            (
                                                                  (
                                                                           (
                                                                                    (((var59 & '￼') >> 2 | var59 << 14) & 32768) >> 15
                                                                                       | ((var59 & '￼') >> 2 | var59 << 14) << 1
                                                                                 )
                                                                                 + 120
                                                                              & 65535
                                                                        )
                                                                        >> 0
                                                                     | (
                                                                              (((var59 & '￼') >> 2 | var59 << 14) & 32768) >> 15
                                                                                 | ((var59 & '￼') >> 2 | var59 << 14) << 1
                                                                           )
                                                                           + 120
                                                                        << 16
                                                               )
                                                               ^ 210
                                                         )
                                                         + 227
                                                      & 63488
                                                )
                                                >> 11
                                             | (
                                                      (
                                                            (
                                                                     (
                                                                              (((var59 & '￼') >> 2 | var59 << 14) & 32768) >> 15
                                                                                 | ((var59 & '￼') >> 2 | var59 << 14) << 1
                                                                           )
                                                                           + 120
                                                                        & 65535
                                                                  )
                                                                  >> 0
                                                               | ((((var59 & '￼') >> 2 | var59 << 14) & 32768) >> 15 | ((var59 & '￼') >> 2 | var59 << 14) << 1)
                                                                     + 120
                                                                  << 16
                                                         )
                                                         ^ 210
                                                   )
                                                   + 227
                                                << 5
                                       )
                                       & 0
                                 )
                                 >> 16
                              | (
                                    (
                                             (
                                                      (
                                                            (
                                                                     (
                                                                              (((var59 & '￼') >> 2 | var59 << 14) & 32768) >> 15
                                                                                 | ((var59 & '￼') >> 2 | var59 << 14) << 1
                                                                           )
                                                                           + 120
                                                                        & 65535
                                                                  )
                                                                  >> 0
                                                               | ((((var59 & '￼') >> 2 | var59 << 14) & 32768) >> 15 | ((var59 & '￼') >> 2 | var59 << 14) << 1)
                                                                     + 120
                                                                  << 16
                                                         )
                                                         ^ 210
                                                   )
                                                   + 227
                                                & 63488
                                          )
                                          >> 11
                                       | (
                                                (
                                                      (
                                                               ((((var59 & '￼') >> 2 | var59 << 14) & 32768) >> 15 | ((var59 & '￼') >> 2 | var59 << 14) << 1)
                                                                     + 120
                                                                  & 65535
                                                            )
                                                            >> 0
                                                         | ((((var59 & '￼') >> 2 | var59 << 14) & 32768) >> 15 | ((var59 & '￼') >> 2 | var59 << 14) << 1) + 120
                                                            << 16
                                                   )
                                                   ^ 210
                                             )
                                             + 227
                                          << 5
                                 )
                                 << 0
                        )
                        ^ 120
                  )
                  - 34
            );
            var19.setCharAt(
               var35,
               (char)(
                  (
                        (
                              (
                                       (
                                             (
                                                      (
                                                               (
                                                                     (
                                                                              (
                                                                                       (((var59 & '￼') >> 2 | var59 << 14) & 32768) >> 15
                                                                                          | ((var59 & '￼') >> 2 | var59 << 14) << 1
                                                                                    )
                                                                                    + 120
                                                                                 & 65535
                                                                           )
                                                                           >> 0
                                                                        | (
                                                                                 (((var59 & '￼') >> 2 | var59 << 14) & 32768) >> 15
                                                                                    | ((var59 & '￼') >> 2 | var59 << 14) << 1
                                                                              )
                                                                              + 120
                                                                           << 16
                                                                  )
                                                                  ^ 210
                                                            )
                                                            + 227
                                                         & 63488
                                                   )
                                                   >> 11
                                                | (
                                                         (
                                                               (
                                                                        (
                                                                                 (((var59 & '￼') >> 2 | var59 << 14) & 32768) >> 15
                                                                                    | ((var59 & '￼') >> 2 | var59 << 14) << 1
                                                                              )
                                                                              + 120
                                                                           & 65535
                                                                     )
                                                                     >> 0
                                                                  | (
                                                                           (((var59 & '￼') >> 2 | var59 << 14) & 32768) >> 15
                                                                              | ((var59 & '￼') >> 2 | var59 << 14) << 1
                                                                        )
                                                                        + 120
                                                                     << 16
                                                            )
                                                            ^ 210
                                                      )
                                                      + 227
                                                   << 5
                                          )
                                          & 0
                                    )
                                    >> 16
                                 | (
                                       (
                                                (
                                                         (
                                                               (
                                                                        (
                                                                                 (((var59 & '￼') >> 2 | var59 << 14) & 32768) >> 15
                                                                                    | ((var59 & '￼') >> 2 | var59 << 14) << 1
                                                                              )
                                                                              + 120
                                                                           & 65535
                                                                     )
                                                                     >> 0
                                                                  | (
                                                                           (((var59 & '￼') >> 2 | var59 << 14) & 32768) >> 15
                                                                              | ((var59 & '￼') >> 2 | var59 << 14) << 1
                                                                        )
                                                                        + 120
                                                                     << 16
                                                            )
                                                            ^ 210
                                                      )
                                                      + 227
                                                   & 63488
                                             )
                                             >> 11
                                          | (
                                                   (
                                                         (
                                                                  ((((var59 & '￼') >> 2 | var59 << 14) & 32768) >> 15 | ((var59 & '￼') >> 2 | var59 << 14) << 1)
                                                                        + 120
                                                                     & 65535
                                                               )
                                                               >> 0
                                                            | ((((var59 & '￼') >> 2 | var59 << 14) & 32768) >> 15 | ((var59 & '￼') >> 2 | var59 << 14) << 1)
                                                                  + 120
                                                               << 16
                                                      )
                                                      ^ 210
                                                )
                                                + 227
                                             << 5
                                    )
                                    << 0
                           )
                           ^ 120
                     )
                     - 34
               )
            );
         }

         Class var7 = Class.forName(var19.toString(), false, Class_188.class.getClassLoader());
         switch (((var4 - 1132146061 ^ 951351207) - 1188925927 - 1036011194 - 1555919275 - 550519061 - 190909205 ^ 1759526169 ^ 1927778498) - 262199448) {
            case 318658015:
               var10000 = var0.findConstructor(var7, var6);
               break;
            case 810350338:
            case 1389896058:
               var10000 = var0.findVirtual(var7, var5, var6);
               break;
            case 955577114:
               var10000 = var0.findStatic(var7, var5, var6);
               break;
            case 2121371629:
               var10000 = var0.findSpecial(var7, var5, var6, Class_188.class);
               break;
            default:
               throw new UnsupportedOperationException("Unsupported handle type!");
         }
      }

      field_1324[((var10 ^ 857104053) - 415065434 - 875853871 ^ 1586351869) - 1909310339 + 745242837 + 773534668 + 563248891 - 222990467 - 638191952] = var10000;
      MethodHandle var11 = var10000.asType(var2);
      return new MutableCallSite(var11);
   }

   // $VF: renamed from: 1 (java.lang.invoke.MethodHandles.Lookup, java.lang.String, java.lang.invoke.MethodType, java.lang.Object[]) java.lang.Object
   public static Object method_1294(Lookup var0, String var1, MethodType var2, Object... var3) {
      boolean var11 = false;
      int var10 = (Integer)var3[4];
      int var10001 = (var10 - 382069698 - 1744821449 ^ 228702883) - 1564282816 + 261626283 + 2104714053 + 1549365240 - 1179354510 ^ 315908424;
      MethodHandle var10000 = field_1324[(
            (var10 - 382069698 - 1744821449 ^ 228702883) - 1564282816 + 261626283 + 2104714053 + 1549365240 - 1179354510 ^ 315908424
         )
         - 1265960753];
      if (field_1324[var10001 - 1265960753] == null) {
         int var4 = (Integer)var3[0];
         StringBuilder var14 = new StringBuilder((String)var3[1]);

         for (int var24 = 528856571 - -104998262 ^ 633854833; var24 < var14.length(); var24 += (892465688 + 892465688 | 1) & 18092423) {
            int var43 = var14.charAt(var24);
            int var10004 = (var43 & 65024) >> 9;
            int var44 = (var43 & 65024) >> 9 | var43 << 7;
            int var94 = (((var43 & 65024) >> 9 | var43 << 7) & 57344) >> 13;
            var43 = ((var10004 | var43 << 7) & 57344) >> 13 | ((var43 & 65024) >> 9 | var43 << 7) << 3;
            var10004 = ((var94 | var44 << 3) & 65520) >> 4;
            int var46 = (((var94 | var44 << 3) & 65520) >> 4 | var43 << 12) + 244 - 11 - 186;
            int var96 = ((((var94 | var44 << 3) & 65520) >> 4 | var43 << 12) + 244 - 11 - 186 & 65534) >> 1;
            var43 = (((var10004 | var43 << 12) + 244 - 11 - 186 & 65534) >> 1 | (((var94 | var44 << 3) & 65520) >> 4 | var43 << 12) + 244 - 11 - 186 << 15)
               ^ 215;
            var10004 = (((var96 | var46 << 15) ^ 215) & 57344) >> 13;
            int var48 = (((var96 | var46 << 15) ^ 215) & 57344) >> 13 | var43 << 3;
            int var98 = (((((var96 | var46 << 15) ^ 215) & 57344) >> 13 | var43 << 3) & 49152) >> 14;
            char var49 = (char)(((var10004 | var43 << 3) & 49152) >> 14 | ((((var96 | var46 << 15) ^ 215) & 57344) >> 13 | var43 << 3) << 2);
            var14.setCharAt(var24, (char)(var98 | var48 << 2));
         }

         String var5 = var14.toString();
         StringBuilder var17 = new StringBuilder((String)var3[2]);

         for (int var30 = (1319458772 >>> 1115311168 | 0) & 541229058; var30 < var17.length(); var30 += (-933604558 - -581980396 | 1) & 69228609) {
            int var54 = (var17.charAt(var30) ^ 196) - 27;
            int var99 = (var54 & 61440) >> 12;
            int var55 = (var54 & 61440) >> 12 | var54 << 4;
            int var100 = (((var54 & 61440) >> 12 | var54 << 4) & 65535) >> 0;
            var54 = ((var99 | var54 << 4) & 65535) >> 0 | ((var54 & 61440) >> 12 | var54 << 4) << 16;
            var99 = ((var100 | var55 << 16) & 65520) >> 4;
            int var57 = ((var100 | var55 << 16) & 65520) >> 4 | var54 << 12;
            int var102 = ((((var100 | var55 << 16) & 65520) >> 4 | var54 << 12) & 0) >> 16;
            var54 = ((var99 | var54 << 12) & 0) >> 16 | (((var100 | var55 << 16) & 65520) >> 4 | var54 << 12) << 0;
            var99 = ((var102 | var57 << 0) & 65520) >> 4;
            int var59 = (((var102 | var57 << 0) & 65520) >> 4 | var54 << 12) + 246;
            int var104 = ((((var102 | var57 << 0) & 65520) >> 4 | var54 << 12) + 246 & 0) >> 16;
            char var60 = (char)((((var99 | var54 << 12) + 246 & 0) >> 16 | (((var102 | var57 << 0) & 65520) >> 4 | var54 << 12) + 246 << 0) + 112);
            var17.setCharAt(var30, (char)((var104 | var59 << 0) + 112));
         }

         Class var6 = Class.forName(var17.toString(), false, Class_188.class.getClassLoader());
         StringBuilder var20 = new StringBuilder((String)var3[3]);

         for (int var36 = (278933712 | 1704211281 | 0) & 38291488; var36 < var20.length(); var36 += (-368544662 & -92570999 >> -92570999 | 1) & 358796039) {
            int var65 = var20.charAt(var36);
            int var105 = (var65 & 65408) >> 7;
            int var66 = ((var65 & 65408) >> 7 | var65 << 9) - 137;
            int var106 = (((var65 & 65408) >> 7 | var65 << 9) - 137 & 65472) >> 6;
            var65 = ((((var105 | var65 << 9) - 137 & 65472) >> 6 | ((var65 & 65408) >> 7 | var65 << 9) - 137 << 10) ^ 76) - 18 - 59;
            var105 = (((var106 | var66 << 10) ^ 76) - 18 - 59 & 32768) >> 15;
            int var68 = (((var106 | var66 << 10) ^ 76) - 18 - 59 & 32768) >> 15 | var65 << 1;
            int var108 = (((((var106 | var66 << 10) ^ 76) - 18 - 59 & 32768) >> 15 | var65 << 1) & 63488) >> 11;
            char var69 = (char)(
               (((var105 | var65 << 1) & 63488) >> 11 | ((((var106 | var66 << 10) ^ 76) - 18 - 59 & 32768) >> 15 | var65 << 1) << 5) - 220 + 61
            );
            var20.setCharAt(var36, (char)((var108 | var68 << 5) - 220 + 61));
         }

         Class var7 = MethodType.fromMethodDescriptorString(var20.toString(), Class_188.class.getClassLoader()).returnType();
         switch ((var4 + 1246730554 - 1207383288 + 1534730484 ^ 2053550387) - 1236181003 + 1432846922 + 1722133444 - 2126366051 - 1354470833 + 239876228) {
            case 707874379:
               var10000 = var0.findGetter(var6, var5, var7);
               break;
            case 1350725404:
               var10000 = var0.findStaticSetter(var6, var5, var7);
               break;
            case 2055411146:
               var10000 = var0.findSetter(var6, var5, var7);
               break;
            case 2078767480:
               var10000 = var0.findStaticGetter(var6, var5, var7);
               break;
            default:
               throw new UnsupportedOperationException("Unsupported handle type!");
         }
      }

      if (!var11) {
         field_1324[((var10 - 382069698 - 1744821449 ^ 228702883) - 1564282816 + 261626283 + 2104714053 + 1549365240 - 1179354510 ^ 315908424) - 1265960753] = var10000;
      }

      MethodHandle var12 = var10000.asType(var2);
      return new MutableCallSite(var12);
   }
}

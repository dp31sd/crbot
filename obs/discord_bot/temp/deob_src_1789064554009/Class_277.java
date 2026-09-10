import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;
import java.lang.invoke.MethodHandles.Lookup;
import net.minecraft.class_243;
import net.minecraft.class_310;
import org.joml.Vector3d;

public class Class_277 {
   // $VF: renamed from: hzc java.lang.invoke.MethodHandle[]
   public static final MethodHandle[] field_313 = new MethodHandle[43];

   // $VF: renamed from: mte (double, double) double
   public static double method_343(double var0, double var2) {
      return var2 * (double)0<"JNT",417105568,"挨掰挀捈掘","\ue79d\ue95d\ue7ad\ue9bd","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ッ\uf0c2ꃅ情",-584069155>(var0 / var2);
   }

   // $VF: renamed from: vep (float, double, double) double
   public static double method_344(float var0, double var1, double var3) {
      int var5 = (int)0<"JNT",417105568,"掐掀捠捘","\ue79d\ue95d\ue7ad\ue95d","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ッ\uf0c2ꃅ情",-584069153>(
         0<"JNT",417105568,"掠推挐","\ue79d\ue95d\ue7ad\ue95d","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ッ\uf0c2ꃅ情",-584069156>(var3 - var1) * (double)var0
      );
      return var1 < var3
         ? 0<"JNT",417105568,"捀捠捈","\ue79d\ue95d\ue95d\ue7ad\ue95d","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ッ\uf0c2ꃅ情",-584069154>(var1 + (double)var5, var3)
         : 0<"JNT",417105568,"捀掠擸","\ue79d\ue95d\ue95d\ue7ad\ue95d","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ッ\uf0c2ꃅ情",-584069167>(var1 - (double)var5, var3);
   }

   // $VF: renamed from: bfd (double, double, double) double
   public static double method_345(double var0, double var2, double var4) {
      return var2 + (var4 - var2) * var0;
   }

   // $VF: renamed from: uaq (double, double, double) double
   public static double method_346(double var0, double var2, double var4) {
      double var6 = 0<"JNT",417105568,"挈捰挨","\ue79d\ue95d\ue95d\ue95d\ue7ad\ue95d","\uf0c5僅郅",-584069168>(var0, 0.0, 1.0);
      var6 = var6 * var6 * (3.0 - 2.0 * var6);
      return var2 + (var4 - var2) * var6;
   }

   // $VF: renamed from: wvk (double, double, double, double) double
   public static double method_347(double var0, double var2, double var4, double var6) {
      return 0<"JNT",417105568,"推授掘","\ue79d\ue95d\ue95d\ue95d\ue7ad\ue95d","\uf0c5僅郅",-584069166>(
         (double)(1.0F - (float)0<"JNT",417105568,"挸掰捰","\ue79d\ue95d\ue95d\ue7ad\ue95d","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ッ\uf0c2ꃅ情",-584069165>(var4, var6)),
         var0,
         var2
      );
   }

   // $VF: renamed from: vwr (double, double, double) double
   public static double method_348(double var0, double var2, double var4) {
      return 0<"JNT",417105568,"捀掠擸","\ue79d\ue95d\ue95d\ue7ad\ue95d","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ッ\uf0c2ꃅ情",-584069164>(
         var2, 0<"JNT",417105568,"捀捠捈","\ue79d\ue95d\ue95d\ue7ad\ue95d","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ッ\uf0c2ꃅ情",-584069163>(var0, var4)
      );
   }

   // $VF: renamed from: ofv (int, int, int) int
   public static int method_349(int var0, int var1, int var2) {
      return 0<"JNT",417105568,"捀掠擸","\ue79d\ue9ad\ue9ad\ue7ad\ue9ad","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ッ\uf0c2ꃅ情",-584069162>(
         var1, 0<"JNT",417105568,"捀捠捈","\ue79d\ue9ad\ue9ad\ue7ad\ue9ad","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ッ\uf0c2ꃅ情",-584069161>(var0, var2)
      );
   }

   // $VF: renamed from: qpr (float, float, float) float
   public static float method_350(float var0, float var1, float var2) {
      return (float)(
         (
                  1.0
                     - 0<"JNT",417105568,"挈捰挨","\ue79d\ue95d\ue95d\ue95d\ue7ad\ue95d","\uf0c5僅郅",-584069176>(
                        (double)((float)(0<"JNT",417105568,"挨擨掘","\ue79d\ue7ad\ue95d","\uf0c5僅郅",-584069175>() * (double)var2)), 0.0, 1.0
                     )
               )
               * (double)var0
            + 0<"JNT",417105568,"挈捰挨","\ue79d\ue95d\ue95d\ue95d\ue7ad\ue95d","\uf0c5僅郅",-584069174>(
                  (double)((float)(0<"JNT",417105568,"挨擨掘","\ue79d\ue7ad\ue95d","\uf0c5僅郅",-584069173>() * (double)var2)), 0.0, 1.0
               )
               * (double)var1
      );
   }

   // $VF: renamed from: rzd () double
   public static double method_351() {
      return 0<"JNT",1252720338,"捀掀挘捸掰掘戰愘慰愀拠拠","\ue79d\ue7ad\ue9ad","䃅냂ꃅ䃁ヅ烅䃅냂ჅÄ\uf0c2샂ꃅ䃁Ⴥ\u20c5\uf0c2ჄჄ僂Ⴠ\uf0c1\ue0c1",-584069172>(
               (class_310)1<"JNT",1527517843,"侼枼","拸拈","至臲膗膱膺膭膺致膷膺膵膼致膔膹膱膾膸膯臠",430730172>()
            )
            > 0
         ? 1.0
            / (double)0<"JNT",1252720338,"捀掀挘捸掰掘戰愘慰愀拠拠","\ue79d\ue7ad\ue9ad","䃅냂ꃅ䃁ヅ烅䃅냂ჅÄ\uf0c2샂ꃅ䃁Ⴥ\u20c5\uf0c2ჄჄ僂Ⴠ\uf0c1\ue0c1",-584069170>(
               (class_310)1<"JNT",1527517843,"侼枼","拸拈","至臲膗膱膺膭膺致膷膺膵膼致膔膹膱膾膸膯臠",430729850>()
            )
         : 1.0;
   }

   // $VF: renamed from: dns (java.lang.String) double
   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Inserted dummy exception handlers to handle obfuscated exceptions
   // $VF: Irreducible bytecode was duplicated to produce valid code
   public static double method_352(String var0) {
      int var5 = 862793168;
      if (var0 != null && !0<"JNT",1252720338,"捠挐技捀挸挘擠","\ue79d\ue7ad\ueabd","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ჂꃅÄ烅䃅탂",-584069327>(var0)) {
         var5 = 1638510850 + 1638510850 ^ 75083624;
      } else {
         var5 = (-881227579 >>> -514316334 | -541733827) & -541721027;
      }

      switch ((var5 - 1691406119 ^ 1533711004 ^ 1476815773 ^ 615139673) + 1888461143 ^ 491515592) {
         case -1419443780:
         default:
            String var1 = 0<"JNT",1252720338,"挘掰戀挸挸掀挨抐掠挐掀","\ue79d\ue7ad\ue9dd\uebbd\ueb2d\uec7d\ueb2d\ue80d\uebdd\ueb2d\uebfd\ueb8d\ue80d\uea4d\uec5d\uec3d\uebad\uebfd\ueb8d\ue8cd","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ჂꃅÄ烅䃅탂",-584069320>(
               0<"JNT",1252720338,"挘挨捠捀","\ue79d\ue7ad\ue9dd\uebbd\ueb2d\uec7d\ueb2d\ue80d\uebdd\ueb2d\uebfd\ueb8d\ue80d\uea4d\uec5d\uec3d\uebad\uebfd\ueb8d\ue8cd","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ჂꃅÄ烅䃅탂",-584069319>(
                  0<"JNT",1252720338,"挨掀挸捘掠掐掀","\ue79d\ue9dd\uebbd\ueb2d\uec7d\ueb2d\ue80d\uebdd\ueb2d\uebfd\ueb8d\ue80d\ue94d\ueb9d\ueb2d\uec3d\uea4d\ueb6d\uec2d\uec6d\ueb6d\uebfd\ueb4d\ueb6d\ue8cd\ue9dd\uebbd\ueb2d\uec7d\ueb2d\ue80d\uebdd\ueb2d\uebfd\ueb8d\ue80d\ue94d\ueb9d\ueb2d\uec3d\uea4d\ueb6d\uec2d\uec6d\ueb6d\uebfd\ueb4d\ueb6d\ue8cd\ue7ad\ue9dd\uebbd\ueb2d\uec7d\ueb2d\ue80d\uebdd\ueb2d\uebfd\ueb8d\ue80d\uea4d\uec5d\uec3d\uebad\uebfd\ueb8d\ue8cd","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ჂꃅÄ烅䃅탂",-584069178>(
                     var0, ",", ""
                  )
               )
            );
            double var2 = 1.0;
            if (0<"JNT",1252720338,"掀捈掘挐扰捠挘捸","\ue79d\ue9dd\uebbd\ueb2d\uec7d\ueb2d\ue80d\uebdd\ueb2d\uebfd\ueb8d\ue80d\uea4d\uec5d\uec3d\uebad\uebfd\ueb8d\ue8cd\ue7ad\ueabd","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ჂꃅÄ烅䃅탂",-584069317>(
               var1, "T"
            )) {
               var2 = 1.0E12;
               var1 = 0<"JNT",1252720338,"挐挀推挐挘挨捠捈揰","\ue79d\ue9ad\ue9ad\ue7ad\ue9dd\uebbd\ueb2d\uec7d\ueb2d\ue80d\uebdd\ueb2d\uebfd\ueb8d\ue80d\uea4d\uec5d\uec3d\uebad\uebfd\ueb8d\ue8cd","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ჂꃅÄ烅䃅탂",-584069315>(
                  var1, 0, 0<"JNT",1252720338,"捘掀捈揰挘捸","\ue79d\ue7ad\ue9ad","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ჂꃅÄ烅䃅탂",-584069318>(var1) - 1
               );

               try {
                  var5 = 740123527;
               } catch (NumberFormatException var9) {
                  boolean var10001 = false;
                  return -1.0;
               }
            } else {
               var5 = 92870272 & 92870272 ^ 1317227112;
            }

            while (true) {
               switch ((var5 + 1014199152 + 549965331 - 1894016131 ^ 195369508 ^ 716469988) + 2096242149) {
                  case -1822264563:
                     if (0<"JNT",1252720338,"掀捈掘挐扰捠挘捸","\ue79d\ue9dd\uebbd\ueb2d\uec7d\ueb2d\ue80d\uebdd\ueb2d\uebfd\ueb8d\ue80d\uea4d\uec5d\uec3d\uebad\uebfd\ueb8d\ue8cd\ue7ad\ueabd","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ჂꃅÄ烅䃅탂",-584069179>(
                        var1, "B"
                     )) {
                        var2 = 1.0E9;
                        var1 = 0<"JNT",1252720338,"挐挀推挐挘挨捠捈揰","\ue79d\ue9ad\ue9ad\ue7ad\ue9dd\uebbd\ueb2d\uec7d\ueb2d\ue80d\uebdd\ueb2d\uebfd\ueb8d\ue80d\uea4d\uec5d\uec3d\uebad\uebfd\ueb8d\ue8cd","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ჂꃅÄ烅䃅탂",-584069177>(
                           var1, 0, 0<"JNT",1252720338,"捘掀捈揰挘捸","\ue79d\ue7ad\ue9ad","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ჂꃅÄ烅䃅탂",-584069180>(var1) - 1
                        );

                        try {
                           var5 = 740123527;
                        } catch (NumberFormatException var8) {
                           boolean var14 = false;
                           return -1.0;
                        }
                     } else {
                        var5 = (-175133561 ^ 1646420966 - -175133561 | 1711358980) & 1852439623;
                     }
                     continue;
                  case -1235793364:
                     try {
                        return 0<"JNT",417105568,"挸掠挨挐掀折掰挀推捘掀","\ue79d\ue9dd\uebbd\ueb2d\uec7d\ueb2d\ue80d\uebdd\ueb2d\uebfd\ueb8d\ue80d\uea4d\uec5d\uec3d\uebad\uebfd\ueb8d\ue8cd\ue7ad\ue95d","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ꃀ僅냅Å\u20c5냂",-584069183>(
                              var1
                           )
                           * var2;
                     } catch (NumberFormatException var6) {
                        boolean var13 = false;
                        return -1.0;
                     }
                  case -127700119:
                     if (!0<"JNT",1252720338,"掀捈掘挐扰捠挘捸","\ue79d\ue9dd\uebbd\ueb2d\uec7d\ueb2d\ue80d\uebdd\ueb2d\uebfd\ueb8d\ue80d\uea4d\uec5d\uec3d\uebad\uebfd\ueb8d\ue8cd\ue7ad\ueabd","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ჂꃅÄ烅䃅탂",-584069316>(
                        var1, "M"
                     )) {
                        var5 = 301608249;
                        continue;
                     }

                     var2 = 1000000.0;
                     var1 = 0<"JNT",1252720338,"挐挀推挐挘挨捠捈揰","\ue79d\ue9ad\ue9ad\ue7ad\ue9dd\uebbd\ueb2d\uec7d\ueb2d\ue80d\uebdd\ueb2d\uebfd\ueb8d\ue80d\uea4d\uec5d\uec3d\uebad\uebfd\ueb8d\ue8cd","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ჂꃅÄ烅䃅탂",-584069314>(
                        var1, 0, 0<"JNT",1252720338,"捘掀捈揰挘捸","\ue79d\ue7ad\ue9ad","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ჂꃅÄ烅䃅탂",-584069313>(var1) - 1
                     );
                     break;
                  case 1546814686:
                  default:
                     if (0<"JNT",1252720338,"掀捈掘挐扰捠挘捸","\ue79d\ue9dd\uebbd\ueb2d\uec7d\ueb2d\ue80d\uebdd\ueb2d\uebfd\ueb8d\ue80d\uea4d\uec5d\uec3d\uebad\uebfd\ueb8d\ue8cd\ue7ad\ueabd","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ჂꃅÄ烅䃅탂",-584069184>(
                        var1, "K"
                     )) {
                        var2 = 1000.0;
                        var1 = 0<"JNT",1252720338,"挐挀推挐挘挨捠捈揰","\ue79d\ue9ad\ue9ad\ue7ad\ue9dd\uebbd\ueb2d\uec7d\ueb2d\ue80d\uebdd\ueb2d\uebfd\ueb8d\ue80d\uea4d\uec5d\uec3d\uebad\uebfd\ueb8d\ue8cd","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ჂꃅÄ烅䃅탂",-584069182>(
                           var1, 0, 0<"JNT",1252720338,"捘掀捈揰挘捸","\ue79d\ue7ad\ue9ad","胅\uf0c2샅\uf0c2䃁\u20c5\uf0c2䃅탂䃁ჂꃅÄ烅䃅탂",-584069181>(var1) - 1
                        );
                     }
               }

               try {
                  var5 = 740123527;
               } catch (NumberFormatException var7) {
                  boolean var12 = false;
                  return -1.0;
               }
            }
         case -789008787:
            return -1.0;
      }
   }

   // $VF: renamed from: ytb (org.joml.Vector3d, net.minecraft.class_243) org.joml.Vector3d
   public static Vector3d method_353(Vector3d var0, class_243 var1) {
      1<"JNT",-828839245,"羼","揨挸捨彸抸揨授掘彸懸挈挨搘揨挸怨挘","至臲膟",430729846>(var0, 1<"JNT",1716153770,"㞼䎼㎼侼⾼ᮼ掻殻玻枻","捸挈搘彸授捈捸挈挨挸拈拸搘彸挨掘拈搨搨拨弸怘怨","至臲膟",430729847>(var1));
      1<"JNT",-828839245,"莼","揨挸捨彸抸揨授掘彸懸挈挨搘揨挸怨挘","至臲膟",430729828>(var0, 1<"JNT",1716153770,"㞼䎼㎼侼⾼ᮼ掻殻玻掻","捸挈搘彸授捈捸挈挨挸拈拸搘彸挨掘拈搨搨拨弸怘怨","至臲膟",430730229>(var1));
      1<"JNT",-828839245,"螼","揨挸捨彸抸揨授掘彸懸挈挨搘揨挸怨挘","至臲膟",430729826>(var0, 1<"JNT",1716153770,"㞼䎼㎼侼⾼ᮼ掻殻玻徻","捸挈搘彸授捈捸挈挨挸拈拸搘彸挨掘拈搨搨拨弸怘怨","至臲膟",430729827>(var1));
      return var0;
   }

   // $VF: renamed from: 0 (java.lang.invoke.MethodHandles.Lookup, java.lang.String, java.lang.invoke.MethodType, java.lang.Object[]) java.lang.Object
   public static Object method_354(Lookup var0, String var1, MethodType var2, Object... var3) {
      int var10 = (Integer)var3[4];
      int var10001 = (var10 ^ 1729040048) - 9720920 + 860779712 - 1059580165 + 1464739896 - 584441431 + 92309745 - 273258117 ^ 2039446153;
      MethodHandle var10000 = field_313[((var10 ^ 1729040048) - 9720920 + 860779712 - 1059580165 + 1464739896 - 584441431 + 92309745 - 273258117 ^ 2039446153)
         + 1360179308];
      if (field_313[var10001 + 1360179308] == null) {
         int var4 = (Integer)var3[0];
         StringBuilder var13 = new StringBuilder((String)var3[1]);

         for (int var23 = (1438532122 ^ 1349286368 | 0) & -1878786043; var23 < var13.length(); var23 += (730829315 - 730829315 | 1) & 1122745519) {
            int var42 = (var13.charAt(var23) ^ 236 ^ 32) + 60 - 118;
            int var10004 = (var42 & 64512) >> 10;
            int var43 = ((var42 & 64512) >> 10 | var42 << 6) ^ 200;
            int var85 = ((((var42 & 64512) >> 10 | var42 << 6) ^ 200) & 65520) >> 4;
            var42 = (((var10004 | var42 << 6) ^ 200) & 65520) >> 4 | (((var42 & 64512) >> 10 | var42 << 6) ^ 200) << 12;
            var10004 = ((var85 | var43 << 12) & 65535) >> 0;
            int var45 = (((var85 | var43 << 12) & 65535) >> 0 | var42 << 16) ^ 229;
            int var87 = (((((var85 | var43 << 12) & 65535) >> 0 | var42 << 16) ^ 229) & 65504) >> 5;
            char var46 = (char)((((var10004 | var42 << 16) ^ 229) & 65504) >> 5 | ((((var85 | var43 << 12) & 65535) >> 0 | var42 << 16) ^ 229) << 11);
            var13.setCharAt(var23, (char)(var87 | var45 << 11));
         }

         String var5 = var13.toString();
         StringBuilder var16 = new StringBuilder((String)var3[2]);

         for (int var29 = (260305910 & -29012009 << 539956001 | 0) & 1651074121; var29 < var16.length(); var29 += (2051450180 << 2051450180 | 1) & 1350673197) {
            char var51 = var16.charAt(var29);
            char var56 = (char)(
               (
                     (
                              (
                                    (
                                             (
                                                      (
                                                               (
                                                                     (((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 & 65534) >> 1
                                                                        | ((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 << 15
                                                                  )
                                                                  & 65408
                                                            )
                                                            >> 7
                                                         | (
                                                               (((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 & 65534) >> 1
                                                                  | ((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 << 15
                                                            )
                                                            << 9
                                                   )
                                                   - 219
                                                & 65408
                                          )
                                          >> 7
                                       | (
                                                (
                                                         (
                                                               (((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 & 65534) >> 1
                                                                  | ((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 << 15
                                                            )
                                                            & 65408
                                                      )
                                                      >> 7
                                                   | (
                                                         (((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 & 65534) >> 1
                                                            | ((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 << 15
                                                      )
                                                      << 9
                                             )
                                             - 219
                                          << 9
                                 )
                                 & 65504
                           )
                           >> 5
                        | (
                              (
                                       (
                                                (
                                                         (
                                                               (((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 & 65534) >> 1
                                                                  | ((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 << 15
                                                            )
                                                            & 65408
                                                      )
                                                      >> 7
                                                   | (
                                                         (((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 & 65534) >> 1
                                                            | ((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 << 15
                                                      )
                                                      << 9
                                             )
                                             - 219
                                          & 65408
                                    )
                                    >> 7
                                 | (
                                          (
                                                   (
                                                         (((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 & 65534) >> 1
                                                            | ((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 << 15
                                                      )
                                                      & 65408
                                                )
                                                >> 7
                                             | (
                                                   (((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 & 65534) >> 1
                                                      | ((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 << 15
                                                )
                                                << 9
                                       )
                                       - 219
                                    << 9
                           )
                           << 11
                  )
                  - 171
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
                                                                        (((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 & 65534) >> 1
                                                                           | ((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 << 15
                                                                     )
                                                                     & 65408
                                                               )
                                                               >> 7
                                                            | (
                                                                  (((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 & 65534) >> 1
                                                                     | ((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 << 15
                                                               )
                                                               << 9
                                                      )
                                                      - 219
                                                   & 65408
                                             )
                                             >> 7
                                          | (
                                                   (
                                                            (
                                                                  (((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 & 65534) >> 1
                                                                     | ((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 << 15
                                                               )
                                                               & 65408
                                                         )
                                                         >> 7
                                                      | (
                                                            (((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 & 65534) >> 1
                                                               | ((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 << 15
                                                         )
                                                         << 9
                                                )
                                                - 219
                                             << 9
                                    )
                                    & 65504
                              )
                              >> 5
                           | (
                                 (
                                          (
                                                   (
                                                            (
                                                                  (((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 & 65534) >> 1
                                                                     | ((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 << 15
                                                               )
                                                               & 65408
                                                         )
                                                         >> 7
                                                      | (
                                                            (((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 & 65534) >> 1
                                                               | ((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 << 15
                                                         )
                                                         << 9
                                                )
                                                - 219
                                             & 65408
                                       )
                                       >> 7
                                    | (
                                             (
                                                      (
                                                            (((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 & 65534) >> 1
                                                               | ((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 << 15
                                                         )
                                                         & 65408
                                                   )
                                                   >> 7
                                                | (
                                                      (((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 & 65534) >> 1
                                                         | ((var51 & '\uffff') >> 0 | var51 << 16) + 48 - 41 + 140 << 15
                                                   )
                                                   << 9
                                          )
                                          - 219
                                       << 9
                              )
                              << 11
                     )
                     - 171
               )
            );
         }

         MethodType var6 = MethodType.fromMethodDescriptorString(var16.toString(), Class_277.class.getClassLoader());
         StringBuilder var19 = new StringBuilder((String)var3[3]);

         for (int var35 = 322759831 & 1784859071 - 1807248995 ^ 304629780; var35 < var19.length(); var35 += (930333626 << -2102275494 | 1) & 306912187) {
            int var61 = var19.charAt(var35) ^ 129;
            char var64 = (char)(
               (
                     (
                           ((((((var61 & 61440) >> 12 | var61 << 4) + 14 & 64512) >> 10 | ((var61 & 61440) >> 12 | var61 << 4) + 14 << 6) ^ 65) & 65472) >> 6
                              | (((((var61 & 61440) >> 12 | var61 << 4) + 14 & 64512) >> 10 | ((var61 & 61440) >> 12 | var61 << 4) + 14 << 6) ^ 65) << 10
                        )
                        ^ 18
                        ^ 23
                  )
                  + 52
                  - 28
            );
            var19.setCharAt(
               var35,
               (char)(
                  (
                        (
                              ((((((var61 & 61440) >> 12 | var61 << 4) + 14 & 64512) >> 10 | ((var61 & 61440) >> 12 | var61 << 4) + 14 << 6) ^ 65) & 65472)
                                    >> 6
                                 | (((((var61 & 61440) >> 12 | var61 << 4) + 14 & 64512) >> 10 | ((var61 & 61440) >> 12 | var61 << 4) + 14 << 6) ^ 65) << 10
                           )
                           ^ 18
                           ^ 23
                     )
                     + 52
                     - 28
               )
            );
         }

         Class var7 = Class.forName(var19.toString(), false, Class_277.class.getClassLoader());
         switch ((var4 + 475026441 + 298962134 + 1332565856 + 1862045428 - 333578321 - 1784290820 ^ 1450143839 ^ 21698729) + 1699902372 - 695126594) {
            case 199995626:
               var10000 = var0.findStatic(var7, var5, var6);
               break;
            case 621216898:
               var10000 = var0.findConstructor(var7, var6);
               break;
            case 734148776:
            case 958829049:
               var10000 = var0.findVirtual(var7, var5, var6);
               break;
            case 1755952664:
               var10000 = var0.findSpecial(var7, var5, var6, Class_277.class);
               break;
            default:
               throw new UnsupportedOperationException("Unsupported handle type!");
         }
      }

      field_313[((var10 ^ 1729040048) - 9720920 + 860779712 - 1059580165 + 1464739896 - 584441431 + 92309745 - 273258117 ^ 2039446153) + 1360179308] = var10000;
      MethodHandle var11 = var10000.asType(var2);
      return new MutableCallSite(var11);
   }

   // $VF: renamed from: 1 (java.lang.invoke.MethodHandles.Lookup, java.lang.String, java.lang.invoke.MethodType, java.lang.Object[]) java.lang.Object
   public static Object method_355(Lookup var0, String var1, MethodType var2, Object... var3) {
      boolean var11 = false;
      int var10 = (Integer)var3[4];
      int var10001 = (((var10 ^ 1628034392) + 181073245 ^ 1467570144) + 1155563688 - 1773369157 - 1968250446 ^ 1342241087) - 347225665 ^ 1621424401;
      MethodHandle var10000 = field_313[(((var10 ^ 1628034392) + 181073245 ^ 1467570144) + 1155563688 - 1773369157 - 1968250446 ^ 1342241087) - 347225665
         ^ 1621424401
         ^ 899022921];
      if (field_313[var10001 ^ 899022921] == null) {
         int var4 = (Integer)var3[0];
         StringBuilder var14 = new StringBuilder((String)var3[1]);

         for (int var24 = (-1834235277 >>> 309144435 | 0) & 844868778; var24 < var14.length(); var24 += (2045285948 * 930420836 | 1) & 25366541) {
            int var43 = var14.charAt(var24) - 'h' + 172 + 4;
            char var44 = (char)(((var43 & 64512) >> 10 | var43 << 6) - 39 - 202 - 46 - 190 + 102 + 207);
            var14.setCharAt(var24, (char)(((var43 & 64512) >> 10 | var43 << 6) - 39 - 202 - 46 - 190 + 102 + 207));
         }

         String var5 = var14.toString();
         StringBuilder var17 = new StringBuilder((String)var3[2]);

         for (int var30 = -709030704 ^ -1031851942 ^ 398605450; var30 < var17.length(); var30 += -883366106 >>> -1313897370 ^ 53306269) {
            char var49 = var17.charAt(var30);
            char var52 = (char)(
               (
                     (
                              (
                                       ((((var49 & '\ufff8') >> 3 | var49 << '\r') + 41 & 65520) >> 4 | ((var49 & '\ufff8') >> 3 | var49 << '\r') + 41 << 12)
                                             - 209
                                          & 57344
                                    )
                                    >> 13
                                 | ((((var49 & '\ufff8') >> 3 | var49 << '\r') + 41 & 65520) >> 4 | ((var49 & '\ufff8') >> 3 | var49 << '\r') + 41 << 12) - 209
                                    << 3
                           )
                           + 21
                        ^ 3
                  )
                  - 193
                  + 234
                  + 106
            );
            var17.setCharAt(
               var30,
               (char)(
                  (
                        (
                                 (
                                          ((((var49 & '\ufff8') >> 3 | var49 << '\r') + 41 & 65520) >> 4 | ((var49 & '\ufff8') >> 3 | var49 << '\r') + 41 << 12)
                                                - 209
                                             & 57344
                                       )
                                       >> 13
                                    | ((((var49 & '\ufff8') >> 3 | var49 << '\r') + 41 & 65520) >> 4 | ((var49 & '\ufff8') >> 3 | var49 << '\r') + 41 << 12)
                                          - 209
                                       << 3
                              )
                              + 21
                           ^ 3
                     )
                     - 193
                     + 234
                     + 106
               )
            );
         }

         Class var6 = Class.forName(var17.toString(), false, Class_277.class.getClassLoader());
         StringBuilder var20 = new StringBuilder((String)var3[3]);

         for (int var36 = (-1770649332 >>> 824098501 | 0) & -1996468720; var36 < var20.length(); var36 += (1115024584 * 49162630 | 1) & -2130704889) {
            int var57 = var20.charAt(var36) ^ 'Z';
            int var81 = (var57 & 65024) >> 9;
            int var58 = (((var57 & 65024) >> 9 | var57 << 7) ^ 48) - 14 ^ 211;
            int var82 = (((((var57 & 65024) >> 9 | var57 << 7) ^ 48) - 14 ^ 211) & 49152) >> 14;
            var57 = (((((var81 | var57 << 7) ^ 48) - 14 ^ 211) & 49152) >> 14 | ((((var57 & 65024) >> 9 | var57 << 7) ^ 48) - 14 ^ 211) << 2) ^ 202;
            var81 = (((var82 | var58 << 2) ^ 202) & 57344) >> 13;
            int var60 = ((((var82 | var58 << 2) ^ 202) & 57344) >> 13 | var57 << 3) ^ 104;
            int var84 = ((((((var82 | var58 << 2) ^ 202) & 57344) >> 13 | var57 << 3) ^ 104) & 61440) >> 12;
            char var61 = (char)((((var81 | var57 << 3) ^ 104) & 61440) >> 12 | (((((var82 | var58 << 2) ^ 202) & 57344) >> 13 | var57 << 3) ^ 104) << 4);
            var20.setCharAt(var36, (char)(var84 | var60 << 4));
         }

         Class var7 = MethodType.fromMethodDescriptorString(var20.toString(), Class_277.class.getClassLoader()).returnType();
         switch (((var4 - 1490050858 ^ 2050844941) + 1489212019 ^ 1503358107) + 1334091275 + 1300558029 - 1101908603 - 570677406 - 1340944888 ^ 1362048709) {
            case 537798641:
               var10000 = var0.findStaticSetter(var6, var5, var7);
               break;
            case 596937942:
               var10000 = var0.findStaticGetter(var6, var5, var7);
               break;
            case 601056935:
               var10000 = var0.findGetter(var6, var5, var7);
               break;
            case 1269032182:
               var10000 = var0.findSetter(var6, var5, var7);
               break;
            default:
               throw new UnsupportedOperationException("Unsupported handle type!");
         }
      }

      if (!var11) {
         field_313[(((var10 ^ 1628034392) + 181073245 ^ 1467570144) + 1155563688 - 1773369157 - 1968250446 ^ 1342241087) - 347225665 ^ 1621424401 ^ 899022921] = var10000;
      }

      MethodHandle var12 = var10000.asType(var2);
      return new MutableCallSite(var12);
   }
}

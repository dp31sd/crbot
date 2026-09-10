import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;
import java.lang.invoke.MethodHandles.Lookup;

// $VF: synthetic class
public class Class_29 {
   // $VF: renamed from: ibx java.lang.invoke.MethodHandle[]
   public static final MethodHandle[] field_998;

   static {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: ldc 19
      // 002: anewarray 17
      // 005: putstatic Class_29.ibx [Ljava/lang/invoke/MethodHandle;
      // 008: goto 289
      // 00b: ldc -956301312
      // 00d: ldc 424372588
      // 00f: ior
      // 010: ldc 459271662
      // 012: iand
      // 013: istore 1
      // 014: goto 23b
      // 017: invokedynamic JNT ()[I bsm=Class_29.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -1225435988, "カ⦫㐫", "阡ꠡ", "ꈦꨦ㨧ꨧ", -188794816 ]
      // 01c: invokedynamic JNT ()Lnet/minecraft/class_2350; bsm=Class_29.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -1225435988, "㈫㎫ㆫ㔫ㄫẫޫޫܫࢫਫ", "ꈡ鴡갡\ue221ꔡꄡꈡ鴡霡꘡餡騡갡\ue221霡ꐡ餡꜡꜡錡\ue621\ue721\ued21\ue821", "ꈦꨦ숧툨\u0a29舨\uda26쨨ꨨ툨\u0a29﨨爨\uea28ሩ舨\uda26﨨숨\uea28稨稨娧爦稦訦戦㨦", -188794815 ]
      // 021: invokedynamic JNT (Ljava/lang/Object;)I bsm=Class_29.0 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ 867735061, "㣺탹惹ࣺヺ䣹\u20fa", "\ue6c4\ue704\uef04", "ڨ˨ب\uf563ӨϨڨ˨ɨިǨҨب\uf563ɨШǨ٨٨Ũ\uf663\uf623\uf8a3\uf5e3", 1520342125 ]
      // 026: bipush 1
      // 027: iastore
      // 028: goto 02e
      // 02b: goto 040
      // 02e: ldc -1542154118
      // 030: ldc 1402938651
      // 032: ldc 712966344
      // 034: ishl
      // 035: ior
      // 036: ldc 416306316
      // 038: ior
      // 039: ldc 2077285565
      // 03b: iand
      // 03c: istore 1
      // 03d: goto 23b
      // 040: ldc 1284391469
      // 042: dup
      // 043: iushr
      // 044: ldc -2117893151
      // 046: ixor
      // 047: istore 1
      // 048: goto 165
      // 04b: invokedynamic JNT ()[I bsm=Class_29.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -1225435988, "カ⦫㐫", "阡ꠡ", "ꈦꨦ㨧ꨧ", -188794813 ]
      // 050: invokedynamic JNT ()Lnet/minecraft/class_2350; bsm=Class_29.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -1225435988, "㈫㎫ㆫ㔫ㄫẫޫޫܫࢫࢫ", "ꈡ鴡갡\ue221ꔡꄡꈡ鴡霡꘡餡騡갡\ue221霡ꐡ餡꜡꜡錡\ue621\ue721\ued21\ue821", "ꈦꨦ숧툨\u0a29舨\uda26쨨ꨨ툨\u0a29﨨爨\uea28ሩ舨\uda26﨨숨\uea28稨稨娧爦稦訦戦㨦", -188794812 ]
      // 055: invokedynamic JNT (Ljava/lang/Object;)I bsm=Class_29.0 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ 867735061, "㣺탹惹ࣺヺ䣹\u20fa", "\ue6c4\ue704\uef04", "ڨ˨ب\uf563ӨϨڨ˨ɨިǨҨب\uf563ɨШǨ٨٨Ũ\uf663\uf623\uf8a3\uf5e3", 1520342132 ]
      // 05a: bipush 2
      // 05b: iastore
      // 05c: goto 062
      // 05f: goto 06e
      // 062: ldc -1880176135
      // 064: ldc -257390309
      // 066: ior
      // 067: ldc -1498017273
      // 069: ixor
      // 06a: istore 1
      // 06b: goto 165
      // 06e: ldc -1375131471
      // 070: ldc 323065761
      // 072: iand
      // 073: ldc -684410519
      // 075: ixor
      // 076: istore 1
      // 077: goto 165
      // 07a: goto 09f
      // 07d: invokedynamic JNT ()[I bsm=Class_29.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -1225435988, "カ⦫㐫", "阡ꠡ", "ꈦꨦ㨧ꨧ", -188794810 ]
      // 082: invokedynamic JNT ()Lnet/minecraft/class_2350; bsm=Class_29.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -1225435988, "㈫㎫ㆫ㔫ㄫẫޫޫܫफࢫ", "ꈡ鴡갡\ue221ꔡꄡꈡ鴡霡꘡餡騡갡\ue221霡ꐡ餡꜡꜡錡\ue621\ue721\ued21\ue821", "ꈦꨦ숧툨\u0a29舨\uda26쨨ꨨ툨\u0a29﨨爨\uea28ሩ舨\uda26﨨숨\uea28稨稨娧爦稦訦戦㨦", -188794809 ]
      // 087: invokedynamic JNT (Ljava/lang/Object;)I bsm=Class_29.0 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ 867735061, "㣺탹惹ࣺヺ䣹\u20fa", "\ue6c4\ue704\uef04", "ڨ˨ب\uf563ӨϨڨ˨ɨިǨҨب\uf563ɨШǨ٨٨Ũ\uf663\uf623\uf8a3\uf5e3", 1520342131 ]
      // 08c: bipush 3
      // 08d: iastore
      // 08e: goto 091
      // 091: ldc -2078622282
      // 093: dup
      // 094: ior
      // 095: ldc 1698784077
      // 097: ior
      // 098: ldc -403444881
      // 09a: iand
      // 09b: istore 1
      // 09c: goto 165
      // 09f: ldc 218352647
      // 0a1: ldc -769035702
      // 0a3: ixor
      // 0a4: ldc -1907022693
      // 0a6: ixor
      // 0a7: istore 1
      // 0a8: goto 165
      // 0ab: invokedynamic JNT ()[I bsm=Class_29.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -1225435988, "カ⦫㐫", "阡ꠡ", "ꈦꨦ㨧ꨧ", -188794807 ]
      // 0b0: invokedynamic JNT ()Lnet/minecraft/class_2350; bsm=Class_29.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -1225435988, "㈫㎫ㆫ㔫ㄫẫޫޫܫࢫফ", "ꈡ鴡갡\ue221ꔡꄡꈡ鴡霡꘡餡騡갡\ue221霡ꐡ餡꜡꜡錡\ue621\ue721\ued21\ue821", "ꈦꨦ숧툨\u0a29舨\uda26쨨ꨨ툨\u0a29﨨爨\uea28ሩ舨\uda26﨨숨\uea28稨稨娧爦稦訦戦㨦", -188794806 ]
      // 0b5: invokedynamic JNT (Ljava/lang/Object;)I bsm=Class_29.0 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ 867735061, "㣺탹惹ࣺヺ䣹\u20fa", "\ue6c4\ue704\uef04", "ڨ˨ب\uf563ӨϨڨ˨ɨިǨҨب\uf563ɨШǨ٨٨Ũ\uf663\uf623\uf8a3\uf5e3", 1520342138 ]
      // 0ba: bipush 4
      // 0bb: iastore
      // 0bc: goto 0c2
      // 0bf: goto 0ce
      // 0c2: ldc 925879258
      // 0c4: ldc -1800614591
      // 0c6: iadd
      // 0c7: ldc -1432399045
      // 0c9: ixor
      // 0ca: istore 1
      // 0cb: goto 165
      // 0ce: ldc 1401488944
      // 0d0: dup
      // 0d1: ixor
      // 0d2: ldc -1970421824
      // 0d4: ixor
      // 0d5: istore 1
      // 0d6: goto 165
      // 0d9: invokedynamic JNT ()[I bsm=Class_29.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -1225435988, "カ⦫㐫", "阡ꠡ", "ꈦꨦ㨧ꨧ", -188794804 ]
      // 0de: invokedynamic JNT ()Lnet/minecraft/class_2350; bsm=Class_29.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -1225435988, "㈫㎫ㆫ㔫ㄫẫޫޫܫࢫ\u0bab", "ꈡ鴡갡\ue221ꔡꄡꈡ鴡霡꘡餡騡갡\ue221霡ꐡ餡꜡꜡錡\ue621\ue721\ued21\ue821", "ꈦꨦ숧툨\u0a29舨\uda26쨨ꨨ툨\u0a29﨨爨\uea28ሩ舨\uda26﨨숨\uea28稨稨娧爦稦訦戦㨦", -188794803 ]
      // 0e3: invokedynamic JNT (Ljava/lang/Object;)I bsm=Class_29.0 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ 867735061, "㣺탹惹ࣺヺ䣹\u20fa", "\ue6c4\ue704\uef04", "ڨ˨ب\uf563ӨϨڨ˨ɨިǨҨب\uf563ɨШǨ٨٨Ũ\uf663\uf623\uf8a3\uf5e3", 1520342137 ]
      // 0e8: bipush 5
      // 0e9: iastore
      // 0ea: goto 0f0
      // 0ed: goto 0fc
      // 0f0: ldc 878216617
      // 0f2: ldc 666798108
      // 0f4: ixor
      // 0f5: ldc -2012189458
      // 0f7: ixor
      // 0f8: istore 1
      // 0f9: goto 165
      // 0fc: ldc 805118352
      // 0fe: ldc -723170241
      // 100: ishl
      // 101: ldc 995862238
      // 103: ior
      // 104: ldc -1076107298
      // 106: iand
      // 107: istore 1
      // 108: goto 165
      // 10b: invokedynamic JNT ()[I bsm=Class_29.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -1225435988, "カ⦫㐫", "阡ꠡ", "ꈦꨦ㨧ꨧ", -188794801 ]
      // 110: invokedynamic JNT ()Lnet/minecraft/class_2350; bsm=Class_29.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -1225435988, "㈫㎫ㆫ㔫ㄫẫޫޫܫࢫफ", "ꈡ鴡갡\ue221ꔡꄡꈡ鴡霡꘡餡騡갡\ue221霡ꐡ餡꜡꜡錡\ue621\ue721\ued21\ue821", "ꈦꨦ숧툨\u0a29舨\uda26쨨ꨨ툨\u0a29﨨爨\uea28ሩ舨\uda26﨨숨\uea28稨稨娧爦稦訦戦㨦", -188794800 ]
      // 115: invokedynamic JNT (Ljava/lang/Object;)I bsm=Class_29.0 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ 867735061, "㣺탹惹ࣺヺ䣹\u20fa", "\ue6c4\ue704\uef04", "ڨ˨ب\uf563ӨϨڨ˨ɨިǨҨب\uf563ɨШǨ٨٨Ũ\uf663\uf623\uf8a3\uf5e3", 1520342048 ]
      // 11a: bipush 6
      // 11c: iastore
      // 11d: goto 123
      // 120: goto 132
      // 123: ldc -1170014909
      // 125: ldc 66252634
      // 127: iand
      // 128: ldc 1693519909
      // 12a: ior
      // 12b: ldc 1878342631
      // 12d: iand
      // 12e: istore 1
      // 12f: goto 165
      // 132: ldc -1472606331
      // 134: ldc -909560487
      // 136: ishl
      // 137: ldc -1275651596
      // 139: ixor
      // 13a: istore 1
      // 13b: goto 165
      // 13e: invokedynamic JNT ()[Lnet/minecraft/class_2350; bsm=Class_29.0 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -2055525469, "\uf0f9䣹\u20fa\ue8f9棹\ud8f9", "\ue6c4\ue704\uf384\uefc4\uf844\uf604龍\ue884\uf804\uf704\uf844\uf604\uf584籠\uf504\uf644龍\ue884\uf584\uf7c4\uf504濾濾\uf484\ue944\ue984\uea04\ue8c4\ueb84", "ڨ˨ب\uf563ӨϨڨ˨ɨިǨҨب\uf563ɨШǨ٨٨Ũ\uf663\uf623\uf8a3\uf5e3", 1520342045 ]
      // 143: checkcast [Lnet/minecraft/class_2350;
      // 146: arraylength
      // 147: newarray 10
      // 149: putstatic Class_29.cuj [I
      // 14c: goto 00b
      // 14f: return
      // 150: ldc 2024247280
      // 152: ldc -944033918
      // 154: dup_x1
      // 155: isub
      // 156: ishl
      // 157: ldc -211924940
      // 159: ior
      // 15a: ldc -8500418
      // 15c: iand
      // 15d: istore 1
      // 15e: goto 1e4
      // 161: astore 0
      // 162: goto 09f
      // 165: iload 1
      // 166: ldc 377610913
      // 168: ixor
      // 169: ldc 258739665
      // 16b: ixor
      // 16c: ldc 1947179342
      // 16e: ixor
      // 16f: ldc 513800820
      // 171: isub
      // 172: ldc 889963632
      // 174: iadd
      // 175: ldc 128103653
      // 177: ixor
      // 178: lookupswitch -251 11 -1732258904 -254 -924766953 -251 -316437213 -41 -92723425 -159 86896460 -301 199054724 -139 615461631 -185 652062128 -88 1283769179 -281 1420493313 -205 1787244089 -109
      // 1dc: astore 0
      // 1dd: goto 0ce
      // 1e0: astore 0
      // 1e1: goto 040
      // 1e4: iload 1
      // 1e5: ldc 1577687052
      // 1e7: iadd
      // 1e8: ldc 1473405385
      // 1ea: ixor
      // 1eb: ldc 450791988
      // 1ed: iadd
      // 1ee: ldc 558216735
      // 1f0: iadd
      // 1f1: ldc 277713620
      // 1f3: isub
      // 1f4: ldc 1902317137
      // 1f6: iadd
      // 1f7: lookupswitch 64 5 -1420870311 -27 -1133695416 164 -1026778114 -150 510198579 64 910070147 127
      // 228: ldc -1967800588
      // 22a: ldc -1328087770
      // 22c: isub
      // 22d: ldc 1612811802
      // 22f: ior
      // 230: ldc 2125708990
      // 232: iand
      // 233: istore 1
      // 234: goto 1e4
      // 237: astore 0
      // 238: goto 132
      // 23b: iload 1
      // 23c: ldc 768237184
      // 23e: isub
      // 23f: ldc 657503249
      // 241: iadd
      // 242: ldc 1482241742
      // 244: ixor
      // 245: ldc 1370243101
      // 247: iadd
      // 248: ldc 370110627
      // 24a: isub
      // 24b: ldc 2082913164
      // 24d: iadd
      // 24e: lookupswitch -547 2 78385977 -567 624005001 -547
      // 268: ldc -439029969
      // 26a: dup
      // 26b: imul
      // 26c: ldc -359188219
      // 26e: ior
      // 26f: ldc -289440835
      // 271: iand
      // 272: istore 1
      // 273: goto 1e4
      // 276: astore 0
      // 277: goto 06e
      // 27a: ldc -213116962
      // 27c: ldc -130619020
      // 27e: ishl
      // 27f: ldc 1074601070
      // 281: ior
      // 282: ldc -225476737
      // 284: iand
      // 285: istore 1
      // 286: goto 1e4
      // 289: ldc -1155304034
      // 28b: istore 1
      // 28c: goto 13e
      // 28f: ldc 1688134830
      // 291: ldc 1112349391
      // 293: iushr
      // 294: ldc 334897382
      // 296: ixor
      // 297: istore 1
      // 298: goto 1e4
      // 29b: astore 0
      // 29c: goto 0fc
   }

   // $VF: renamed from: 0 (java.lang.invoke.MethodHandles.Lookup, java.lang.String, java.lang.invoke.MethodType, java.lang.Object[]) java.lang.Object
   public static Object method_1134(Lookup var0, String var1, MethodType var2, Object... var3) {
      int var10 = (Integer)var3[4];
      int var10001 = (((var10 - 799948821 ^ 271305297 ^ 438191172 ^ 319101868) - 1058169448 ^ 775825000) + 1840662105 ^ 1106343361) + 2114116618;
      MethodHandle var10000 = field_998[(((var10 - 799948821 ^ 271305297 ^ 438191172 ^ 319101868) - 1058169448 ^ 775825000) + 1840662105 ^ 1106343361)
         + 2114116618
         + 2017810765];
      if (field_998[var10001 + 2017810765] == null) {
         int var4 = (Integer)var3[0];
         StringBuilder var13 = new StringBuilder((String)var3[1]);

         for (int var23 = (-2120158475 + (631084160 | -1245945881) | 0) & 1216416768;
            var23 < var13.length();
            var23 += (-763553020 + -680911912 | 1) & 100698115
         ) {
            char var42 = var13.charAt(var23);
            char var47 = (char)(
               (
                     (
                              (
                                       (
                                             (
                                                      (
                                                            (
                                                                     (
                                                                              (((var42 & '￼') >> 2 | var42 << 14) & 65472) >> 6
                                                                                 | ((var42 & '￼') >> 2 | var42 << 14) << 10
                                                                           )
                                                                           - 253
                                                                           + 252
                                                                        & 65532
                                                                  )
                                                                  >> 2
                                                               | ((((var42 & '￼') >> 2 | var42 << 14) & 65472) >> 6 | ((var42 & '￼') >> 2 | var42 << 14) << 10)
                                                                     - 253
                                                                     + 252
                                                                  << 14
                                                         )
                                                         & 65532
                                                   )
                                                   >> 2
                                                | (
                                                      (
                                                               ((((var42 & '￼') >> 2 | var42 << 14) & 65472) >> 6 | ((var42 & '￼') >> 2 | var42 << 14) << 10)
                                                                     - 253
                                                                     + 252
                                                                  & 65532
                                                            )
                                                            >> 2
                                                         | ((((var42 & '￼') >> 2 | var42 << 14) & 65472) >> 6 | ((var42 & '￼') >> 2 | var42 << 14) << 10)
                                                               - 253
                                                               + 252
                                                            << 14
                                                   )
                                                   << 14
                                          )
                                          & 32768
                                    )
                                    >> 15
                                 | (
                                       (
                                                (
                                                      (
                                                               ((((var42 & '￼') >> 2 | var42 << 14) & 65472) >> 6 | ((var42 & '￼') >> 2 | var42 << 14) << 10)
                                                                     - 253
                                                                     + 252
                                                                  & 65532
                                                            )
                                                            >> 2
                                                         | ((((var42 & '￼') >> 2 | var42 << 14) & 65472) >> 6 | ((var42 & '￼') >> 2 | var42 << 14) << 10)
                                                               - 253
                                                               + 252
                                                            << 14
                                                   )
                                                   & 65532
                                             )
                                             >> 2
                                          | (
                                                (
                                                         ((((var42 & '￼') >> 2 | var42 << 14) & 65472) >> 6 | ((var42 & '￼') >> 2 | var42 << 14) << 10)
                                                               - 253
                                                               + 252
                                                            & 65532
                                                      )
                                                      >> 2
                                                   | ((((var42 & '￼') >> 2 | var42 << 14) & 65472) >> 6 | ((var42 & '￼') >> 2 | var42 << 14) << 10) - 253 + 252
                                                      << 14
                                             )
                                             << 14
                                    )
                                    << 1
                           )
                           - 39
                        ^ 136
                  )
                  + 216
            );
            var13.setCharAt(
               var23,
               (char)(
                  (
                        (
                                 (
                                          (
                                                (
                                                         (
                                                               (
                                                                        (
                                                                                 (((var42 & '￼') >> 2 | var42 << 14) & 65472) >> 6
                                                                                    | ((var42 & '￼') >> 2 | var42 << 14) << 10
                                                                              )
                                                                              - 253
                                                                              + 252
                                                                           & 65532
                                                                     )
                                                                     >> 2
                                                                  | (
                                                                           (((var42 & '￼') >> 2 | var42 << 14) & 65472) >> 6
                                                                              | ((var42 & '￼') >> 2 | var42 << 14) << 10
                                                                        )
                                                                        - 253
                                                                        + 252
                                                                     << 14
                                                            )
                                                            & 65532
                                                      )
                                                      >> 2
                                                   | (
                                                         (
                                                                  ((((var42 & '￼') >> 2 | var42 << 14) & 65472) >> 6 | ((var42 & '￼') >> 2 | var42 << 14) << 10)
                                                                        - 253
                                                                        + 252
                                                                     & 65532
                                                               )
                                                               >> 2
                                                            | ((((var42 & '￼') >> 2 | var42 << 14) & 65472) >> 6 | ((var42 & '￼') >> 2 | var42 << 14) << 10)
                                                                  - 253
                                                                  + 252
                                                               << 14
                                                      )
                                                      << 14
                                             )
                                             & 32768
                                       )
                                       >> 15
                                    | (
                                          (
                                                   (
                                                         (
                                                                  ((((var42 & '￼') >> 2 | var42 << 14) & 65472) >> 6 | ((var42 & '￼') >> 2 | var42 << 14) << 10)
                                                                        - 253
                                                                        + 252
                                                                     & 65532
                                                               )
                                                               >> 2
                                                            | ((((var42 & '￼') >> 2 | var42 << 14) & 65472) >> 6 | ((var42 & '￼') >> 2 | var42 << 14) << 10)
                                                                  - 253
                                                                  + 252
                                                               << 14
                                                      )
                                                      & 65532
                                                )
                                                >> 2
                                             | (
                                                   (
                                                            ((((var42 & '￼') >> 2 | var42 << 14) & 65472) >> 6 | ((var42 & '￼') >> 2 | var42 << 14) << 10)
                                                                  - 253
                                                                  + 252
                                                               & 65532
                                                         )
                                                         >> 2
                                                      | ((((var42 & '￼') >> 2 | var42 << 14) & 65472) >> 6 | ((var42 & '￼') >> 2 | var42 << 14) << 10)
                                                            - 253
                                                            + 252
                                                         << 14
                                                )
                                                << 14
                                       )
                                       << 1
                              )
                              - 39
                           ^ 136
                     )
                     + 216
               )
            );
         }

         String var5 = var13.toString();
         StringBuilder var16 = new StringBuilder((String)var3[2]);

         for (int var29 = (415566782 + 514180643 | 0) & 1082459662; var29 < var16.length(); var29 += (-880560730 * 1349630622 | 1) & -1536883455) {
            int var52 = var16.charAt(var29) + 179;
            char var55 = (char)(
               (
                        (
                              ((((var52 & 65472) >> 6 | var52 << 10) + 142 & 63488) >> 11 | ((var52 & 65472) >> 6 | var52 << 10) + 142 << 5)
                                    + 10
                                    - 17
                                    + 53
                                    - 147
                                 ^ 23
                           )
                           & 65504
                     )
                     >> 5
                  | (((((var52 & 65472) >> 6 | var52 << 10) + 142 & 63488) >> 11 | ((var52 & 65472) >> 6 | var52 << 10) + 142 << 5) + 10 - 17 + 53 - 147 ^ 23)
                     << 11
            );
            var16.setCharAt(
               var29,
               (char)(
                  (
                           (
                                 ((((var52 & 65472) >> 6 | var52 << 10) + 142 & 63488) >> 11 | ((var52 & 65472) >> 6 | var52 << 10) + 142 << 5)
                                       + 10
                                       - 17
                                       + 53
                                       - 147
                                    ^ 23
                              )
                              & 65504
                        )
                        >> 5
                     | (
                           ((((var52 & 65472) >> 6 | var52 << 10) + 142 & 63488) >> 11 | ((var52 & 65472) >> 6 | var52 << 10) + 142 << 5) + 10 - 17 + 53 - 147
                              ^ 23
                        )
                        << 11
               )
            );
         }

         MethodType var6 = MethodType.fromMethodDescriptorString(var16.toString(), Class_29.class.getClassLoader());
         StringBuilder var19 = new StringBuilder((String)var3[3]);

         for (int var35 = (211495326 ^ 211495326 | 0) & 805358174; var35 < var19.length(); var35 += -772226102 * 1190917145 ^ -822761797) {
            int var60 = ((var19.charAt(var35) ^ 180) + 170 ^ 191 ^ 26 ^ 209 ^ 166) - 20;
            int var88 = (var60 & 32768) >> 15;
            int var61 = (var60 & 32768) >> 15 | var60 << 1;
            int var89 = (((var60 & 32768) >> 15 | var60 << 1) & 65408) >> 7;
            char var62 = (char)((((var88 | var60 << 1) & 65408) >> 7 | ((var60 & 32768) >> 15 | var60 << 1) << 9) + 86);
            var19.setCharAt(var35, (char)((var89 | var61 << 9) + 86));
         }

         Class var7 = Class.forName(var19.toString(), false, Class_29.class.getClassLoader());
         switch (((var4 - 1711725411 ^ 1067678758 ^ 726405927) + 98453730 ^ 859705261 ^ 1475246191) - 1567877250 + 433743483 ^ 1379878624 ^ 850535240) {
            case 5482781:
               var10000 = var0.findSpecial(var7, var5, var6, Class_29.class);
               break;
            case 417235704:
            case 581814175:
               var10000 = var0.findVirtual(var7, var5, var6);
               break;
            case 1386027122:
               var10000 = var0.findStatic(var7, var5, var6);
               break;
            case 1741971469:
               var10000 = var0.findConstructor(var7, var6);
               break;
            default:
               throw new UnsupportedOperationException("Unsupported handle type!");
         }
      }

      field_998[(((var10 - 799948821 ^ 271305297 ^ 438191172 ^ 319101868) - 1058169448 ^ 775825000) + 1840662105 ^ 1106343361) + 2114116618 + 2017810765] = var10000;
      MethodHandle var11 = var10000.asType(var2);
      return new MutableCallSite(var11);
   }

   // $VF: renamed from: 1 (java.lang.invoke.MethodHandles.Lookup, java.lang.String, java.lang.invoke.MethodType, java.lang.Object[]) java.lang.Object
   public static Object method_1135(Lookup var0, String var1, MethodType var2, Object... var3) {
      boolean var11 = false;
      int var10 = (Integer)var3[4];
      int var10001 = var10 + 525921924 - 1924436274 - 536618410 + 1367356846 - 936380030 + 54302435 - 574148302 + 1307075099 + 1285949069;
      MethodHandle var10000 = field_998[var10
         + 525921924
         - 1924436274
         - 536618410
         + 1367356846
         - 936380030
         + 54302435
         - 574148302
         + 1307075099
         + 1285949069
         - 380227541];
      if (field_998[var10001 - 380227541] == null) {
         int var4 = (Integer)var3[0];
         StringBuilder var14 = new StringBuilder((String)var3[1]);

         for (int var24 = 1110023334 * 1077568429 ^ -884011474; var24 < var14.length(); var24 += (413181677 >> 413181677 | 0) & 2070952539) {
            int var43 = var14.charAt(var24) + 149;
            int var10004 = (var43 & 65472) >> 6;
            int var44 = ((var43 & 65472) >> 6 | var43 << 10) + 33 ^ 29 ^ 61;
            int var92 = ((((var43 & 65472) >> 6 | var43 << 10) + 33 ^ 29 ^ 61) & 0) >> 16;
            var43 = (((var10004 | var43 << 10) + 33 ^ 29 ^ 61) & 0) >> 16 | (((var43 & 65472) >> 6 | var43 << 10) + 33 ^ 29 ^ 61) << 0;
            var10004 = ((var92 | var44 << 0) & 65528) >> 3;
            int var46 = ((var92 | var44 << 0) & 65528) >> 3 | var43 << 13;
            int var94 = ((((var92 | var44 << 0) & 65528) >> 3 | var43 << 13) & 61440) >> 12;
            var43 = ((var10004 | var43 << 13) & 61440) >> 12 | (((var92 | var44 << 0) & 65528) >> 3 | var43 << 13) << 4;
            var10004 = ((var94 | var46 << 4) & 65504) >> 5;
            int var48 = ((var94 | var46 << 4) & 65504) >> 5 | var43 << 11;
            int var96 = ((((var94 | var46 << 4) & 65504) >> 5 | var43 << 11) & 57344) >> 13;
            char var49 = (char)(((var10004 | var43 << 11) & 57344) >> 13 | (((var94 | var46 << 4) & 65504) >> 5 | var43 << 11) << 3);
            var14.setCharAt(var24, (char)(var96 | var48 << 3));
         }

         String var5 = var14.toString();
         StringBuilder var17 = new StringBuilder((String)var3[2]);

         for (int var30 = (-2099071543 | -2099071543) ^ -2099071543; var30 < var17.length(); var30 += -2081317685 & -1559721449 ^ -2097117182) {
            int var54 = var17.charAt(var30) + 146;
            char var59 = (char)(
               (
                     (
                              (
                                    (
                                             (
                                                      (
                                                               (
                                                                        (((var54 & 32768) >> 15 | var54 << 1) - 161 & 65534) >> 1
                                                                           | ((var54 & 32768) >> 15 | var54 << 1) - 161 << 15
                                                                     )
                                                                     + 221
                                                                  & 65520
                                                            )
                                                            >> 4
                                                         | (
                                                                  (((var54 & 32768) >> 15 | var54 << 1) - 161 & 65534) >> 1
                                                                     | ((var54 & 32768) >> 15 | var54 << 1) - 161 << 15
                                                               )
                                                               + 221
                                                            << 12
                                                   )
                                                   + 140
                                                & 32768
                                          )
                                          >> 15
                                       | (
                                                (
                                                         (
                                                                  (((var54 & 32768) >> 15 | var54 << 1) - 161 & 65534) >> 1
                                                                     | ((var54 & 32768) >> 15 | var54 << 1) - 161 << 15
                                                               )
                                                               + 221
                                                            & 65520
                                                      )
                                                      >> 4
                                                   | (
                                                            (((var54 & 32768) >> 15 | var54 << 1) - 161 & 65534) >> 1
                                                               | ((var54 & 32768) >> 15 | var54 << 1) - 161 << 15
                                                         )
                                                         + 221
                                                      << 12
                                             )
                                             + 140
                                          << 1
                                 )
                                 & 65504
                           )
                           >> 5
                        | (
                              (
                                       (
                                                (
                                                         (
                                                                  (((var54 & 32768) >> 15 | var54 << 1) - 161 & 65534) >> 1
                                                                     | ((var54 & 32768) >> 15 | var54 << 1) - 161 << 15
                                                               )
                                                               + 221
                                                            & 65520
                                                      )
                                                      >> 4
                                                   | (
                                                            (((var54 & 32768) >> 15 | var54 << 1) - 161 & 65534) >> 1
                                                               | ((var54 & 32768) >> 15 | var54 << 1) - 161 << 15
                                                         )
                                                         + 221
                                                      << 12
                                             )
                                             + 140
                                          & 32768
                                    )
                                    >> 15
                                 | (
                                          (
                                                   (
                                                            (((var54 & 32768) >> 15 | var54 << 1) - 161 & 65534) >> 1
                                                               | ((var54 & 32768) >> 15 | var54 << 1) - 161 << 15
                                                         )
                                                         + 221
                                                      & 65520
                                                )
                                                >> 4
                                             | ((((var54 & 32768) >> 15 | var54 << 1) - 161 & 65534) >> 1 | ((var54 & 32768) >> 15 | var54 << 1) - 161 << 15)
                                                   + 221
                                                << 12
                                       )
                                       + 140
                                    << 1
                           )
                           << 11
                  )
                  ^ 66
            );
            var17.setCharAt(
               var30,
               (char)(
                  (
                        (
                                 (
                                       (
                                                (
                                                         (
                                                                  (
                                                                           (((var54 & 32768) >> 15 | var54 << 1) - 161 & 65534) >> 1
                                                                              | ((var54 & 32768) >> 15 | var54 << 1) - 161 << 15
                                                                        )
                                                                        + 221
                                                                     & 65520
                                                               )
                                                               >> 4
                                                            | (
                                                                     (((var54 & 32768) >> 15 | var54 << 1) - 161 & 65534) >> 1
                                                                        | ((var54 & 32768) >> 15 | var54 << 1) - 161 << 15
                                                                  )
                                                                  + 221
                                                               << 12
                                                      )
                                                      + 140
                                                   & 32768
                                             )
                                             >> 15
                                          | (
                                                   (
                                                            (
                                                                     (((var54 & 32768) >> 15 | var54 << 1) - 161 & 65534) >> 1
                                                                        | ((var54 & 32768) >> 15 | var54 << 1) - 161 << 15
                                                                  )
                                                                  + 221
                                                               & 65520
                                                         )
                                                         >> 4
                                                      | (
                                                               (((var54 & 32768) >> 15 | var54 << 1) - 161 & 65534) >> 1
                                                                  | ((var54 & 32768) >> 15 | var54 << 1) - 161 << 15
                                                            )
                                                            + 221
                                                         << 12
                                                )
                                                + 140
                                             << 1
                                    )
                                    & 65504
                              )
                              >> 5
                           | (
                                 (
                                          (
                                                   (
                                                            (
                                                                     (((var54 & 32768) >> 15 | var54 << 1) - 161 & 65534) >> 1
                                                                        | ((var54 & 32768) >> 15 | var54 << 1) - 161 << 15
                                                                  )
                                                                  + 221
                                                               & 65520
                                                         )
                                                         >> 4
                                                      | (
                                                               (((var54 & 32768) >> 15 | var54 << 1) - 161 & 65534) >> 1
                                                                  | ((var54 & 32768) >> 15 | var54 << 1) - 161 << 15
                                                            )
                                                            + 221
                                                         << 12
                                                )
                                                + 140
                                             & 32768
                                       )
                                       >> 15
                                    | (
                                             (
                                                      (
                                                               (((var54 & 32768) >> 15 | var54 << 1) - 161 & 65534) >> 1
                                                                  | ((var54 & 32768) >> 15 | var54 << 1) - 161 << 15
                                                            )
                                                            + 221
                                                         & 65520
                                                   )
                                                   >> 4
                                                | ((((var54 & 32768) >> 15 | var54 << 1) - 161 & 65534) >> 1 | ((var54 & 32768) >> 15 | var54 << 1) - 161 << 15)
                                                      + 221
                                                   << 12
                                          )
                                          + 140
                                       << 1
                              )
                              << 11
                     )
                     ^ 66
               )
            );
         }

         Class var6 = Class.forName(var17.toString(), false, Class_29.class.getClassLoader());
         StringBuilder var20 = new StringBuilder((String)var3[3]);

         for (int var36 = 690938630 - 690938630 ^ 0; var36 < var20.length(); var36 += -732841157 & (-821950143 | 1352659571) ^ -737035470) {
            int var64 = var20.charAt(var36) - 31;
            int var102 = (var64 & 65024) >> 9;
            int var65 = (var64 & 65024) >> 9 | var64 << 7;
            int var103 = (((var64 & 65024) >> 9 | var64 << 7) & 65535) >> 0;
            var64 = (((var102 | var64 << 7) & 65535) >> 0 | ((var64 & 65024) >> 9 | var64 << 7) << 16) + 76 - 213 + 133 + 243;
            var102 = ((var103 | var65 << 16) + 76 - 213 + 133 + 243 & 65504) >> 5;
            int var67 = (((var103 | var65 << 16) + 76 - 213 + 133 + 243 & 65504) >> 5 | var64 << 11) ^ 35;
            int var105 = (((((var103 | var65 << 16) + 76 - 213 + 133 + 243 & 65504) >> 5 | var64 << 11) ^ 35) & 57344) >> 13;
            char var68 = (char)(
               (((var102 | var64 << 11) ^ 35) & 57344) >> 13 | ((((var103 | var65 << 16) + 76 - 213 + 133 + 243 & 65504) >> 5 | var64 << 11) ^ 35) << 3
            );
            var20.setCharAt(var36, (char)(var105 | var67 << 3));
         }

         Class var7 = MethodType.fromMethodDescriptorString(var20.toString(), Class_29.class.getClassLoader()).returnType();
         switch ((var4 + 1715316656 - 1557912608 + 1025889244 - 1707483013 + 322824351 ^ 108975296) - 2088824408 + 1428995656 - 1929913222 ^ 1647104489) {
            case 1331845652:
               var10000 = var0.findGetter(var6, var5, var7);
               break;
            case 1639730922:
               var10000 = var0.findStaticSetter(var6, var5, var7);
               break;
            case 1744307767:
               var10000 = var0.findSetter(var6, var5, var7);
               break;
            case 1879230389:
               var10000 = var0.findStaticGetter(var6, var5, var7);
               break;
            default:
               throw new UnsupportedOperationException("Unsupported handle type!");
         }
      }

      if (!var11) {
         field_998[var10 + 525921924 - 1924436274 - 536618410 + 1367356846 - 936380030 + 54302435 - 574148302 + 1307075099 + 1285949069 - 380227541] = var10000;
      }

      MethodHandle var12 = var10000.asType(var2);
      return new MutableCallSite(var12);
   }
}

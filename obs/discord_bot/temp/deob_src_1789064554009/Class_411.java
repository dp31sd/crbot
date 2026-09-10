import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;
import java.lang.invoke.MethodHandles.Lookup;

// $VF: synthetic class
public class Class_411 {
   // $VF: renamed from: vxo java.lang.invoke.MethodHandle[]
   public static final MethodHandle[] field_55;

   static {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: ldc 16
      // 002: anewarray 17
      // 005: putstatic Class_411.vxo [Ljava/lang/invoke/MethodHandle;
      // 008: goto 200
      // 00b: ldc -786689
      // 00d: ldc -1683507292
      // 00f: iand
      // 010: istore 1
      // 011: goto 227
      // 014: goto 03b
      // 017: invokedynamic JNT ()[I bsm=Class_411.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -359792806, "都ჾ郹", "퀀", "尚\udc1b\udc2c\udc2b", 601389701 ]
      // 01c: invokedynamic JNT ()LClass_400; bsm=Class_411.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -359792806, "탾ჼ", "\ud800င", "尚\udc1b尨\udc43尷\udc1c", 601389706 ]
      // 021: invokedynamic JNT (Ljava/lang/Object;)I bsm=Class_411.0 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ 437046093, "*5Bz\u0012ﺺ\u0002", "ꕥꖅꦅ", "豒げ", -740498429 ]
      // 026: bipush 1
      // 027: iastore
      // 028: goto 02b
      // 02b: ldc -274532910
      // 02d: ldc 1867511718
      // 02f: swap
      // 030: imul
      // 031: ldc -209029600
      // 033: ior
      // 034: ldc -136677584
      // 036: iand
      // 037: istore 1
      // 038: goto 227
      // 03b: ldc -1226276400
      // 03d: ldc 1807614638
      // 03f: iand
      // 040: ldc 202491153
      // 042: ior
      // 043: ldc 1544672663
      // 045: iand
      // 046: istore 1
      // 047: goto 15e
      // 04a: goto 073
      // 04d: invokedynamic JNT ()[I bsm=Class_411.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -359792806, "都ჾ郹", "퀀", "尚\udc1b\udc2c\udc2b", 601389708 ]
      // 052: invokedynamic JNT ()LClass_400; bsm=Class_411.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -359792806, "僺탼郾", "\ud800င", "尚\udc1b尨\udc43尷\udc1c", 601389705 ]
      // 057: invokedynamic JNT (Ljava/lang/Object;)I bsm=Class_411.0 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ 437046093, "*5Bz\u0012ﺺ\u0002", "ꕥꖅꦅ", "豒げ", -740498422 ]
      // 05c: bipush 2
      // 05d: iastore
      // 05e: goto 061
      // 061: ldc 581316130
      // 063: ldc -1024020882
      // 065: dup2
      // 066: ior
      // 067: imul
      // 068: ixor
      // 069: ldc -1273478907
      // 06b: ior
      // 06c: ldc -191209059
      // 06e: iand
      // 06f: istore 1
      // 070: goto 15e
      // 073: ldc -579911827
      // 075: ldc 420533618
      // 077: dup2
      // 078: isub
      // 079: imul
      // 07a: iushr
      // 07b: ldc 1127661886
      // 07d: ixor
      // 07e: istore 1
      // 07f: goto 15e
      // 082: goto 0a8
      // 085: invokedynamic JNT ()[I bsm=Class_411.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -359792806, "都ჾ郹", "퀀", "尚\udc1b\udc2c\udc2b", 601388699 ]
      // 08a: invokedynamic JNT ()LClass_400; bsm=Class_411.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -359792806, "郼價僾", "\ud800င", "尚\udc1b尨\udc43尷\udc1c", 601389712 ]
      // 08f: invokedynamic JNT (Ljava/lang/Object;)I bsm=Class_411.0 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ 437046093, "*5Bz\u0012ﺺ\u0002", "ꕥꖅꦅ", "豒げ", -740498467 ]
      // 094: bipush 3
      // 095: iastore
      // 096: goto 099
      // 099: ldc -349786671
      // 09b: ldc 2118196747
      // 09d: iadd
      // 09e: ldc -1073705943
      // 0a0: ior
      // 0a1: ldc -289542599
      // 0a3: iand
      // 0a4: istore 1
      // 0a5: goto 15e
      // 0a8: ldc 576054344
      // 0aa: ldc 2041401284
      // 0ac: iand
      // 0ad: ldc 654769354
      // 0af: ixor
      // 0b0: istore 1
      // 0b1: goto 15e
      // 0b4: invokedynamic JNT ()[I bsm=Class_411.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -359792806, "都ჾ郹", "퀀", "尚\udc1b\udc2c\udc2b", 601389714 ]
      // 0b9: invokedynamic JNT ()LClass_400; bsm=Class_411.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -359792806, "탺탻", "\ud800င", "尚\udc1b尨\udc43尷\udc1c", 601389711 ]
      // 0be: invokedynamic JNT (Ljava/lang/Object;)I bsm=Class_411.0 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ 437046093, "*5Bz\u0012ﺺ\u0002", "ꕥꖅꦅ", "豒げ", -740498460 ]
      // 0c3: bipush 4
      // 0c4: iastore
      // 0c5: goto 0cb
      // 0c8: goto 0d7
      // 0cb: ldc 2101589526
      // 0cd: ldc -1260649677
      // 0cf: ixor
      // 0d0: ldc 1689536533
      // 0d2: ixor
      // 0d3: istore 1
      // 0d4: goto 15e
      // 0d7: ldc 749086167
      // 0d9: ldc -512015231
      // 0db: isub
      // 0dc: ldc 932518731
      // 0de: ior
      // 0df: ldc -1210770613
      // 0e1: iand
      // 0e2: istore 1
      // 0e3: goto 15e
      // 0e6: invokedynamic JNT ()[I bsm=Class_411.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -359792806, "都ჾ郹", "퀀", "尚\udc1b\udc2c\udc2b", 601389713 ]
      // 0eb: invokedynamic JNT ()LClass_400; bsm=Class_411.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -359792806, "჻탺탽", "\ud800င", "尚\udc1b尨\udc43尷\udc1c", 601388694 ]
      // 0f0: invokedynamic JNT (Ljava/lang/Object;)I bsm=Class_411.0 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ 437046093, "*5Bz\u0012ﺺ\u0002", "ꕥꖅꦅ", "豒げ", -740498465 ]
      // 0f5: bipush 5
      // 0f6: iastore
      // 0f7: goto 0fd
      // 0fa: goto 110
      // 0fd: ldc -231507198
      // 0ff: ldc -942637802
      // 101: ishl
      // 102: ldc -635158277
      // 104: ior
      // 105: ldc -545460225
      // 107: iand
      // 108: istore 1
      // 109: goto 15e
      // 10c: astore 0
      // 10d: goto 073
      // 110: ldc -216039396
      // 112: ldc -2049277968
      // 114: iand
      // 115: ldc 1669873491
      // 117: ixor
      // 118: istore 1
      // 119: goto 15e
      // 11c: astore 0
      // 11d: goto 110
      // 120: astore 0
      // 121: goto 03b
      // 124: ldc -777329335
      // 126: ldc 369770675
      // 128: ldc -800045720
      // 12a: iadd
      // 12b: ior
      // 12c: ldc 420743589
      // 12e: ior
      // 12f: ldc -646136403
      // 131: iand
      // 132: istore 1
      // 133: goto 1c4
      // 136: ldc -648065059
      // 138: ldc -1439560496
      // 13a: iand
      // 13b: ldc 1405399813
      // 13d: ior
      // 13e: ldc 1943909253
      // 140: iand
      // 141: istore 1
      // 142: goto 1c4
      // 145: astore 0
      // 146: goto 0a8
      // 149: invokedynamic JNT ()[LClass_400; bsm=Class_411.0 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -267506997, "ￕﺺ\u0002ￍZﾽ", "ꕥꖅꯅ꣥꾅겥Ʂ", "豒げ", -740498472 ]
      // 14e: checkcast [LClass_400;
      // 151: arraylength
      // 152: newarray 10
      // 154: putstatic Class_411.tvd [I
      // 157: goto 00b
      // 15a: astore 0
      // 15b: goto 0d7
      // 15e: iload 1
      // 15f: ldc 795062897
      // 161: ixor
      // 162: ldc 1030491776
      // 164: iadd
      // 165: ldc 1906511319
      // 167: ixor
      // 168: ldc 566632817
      // 16a: iadd
      // 16b: ldc 109933245
      // 16d: iadd
      // 16e: ldc 129433618
      // 170: ixor
      // 171: lookupswitch -119 9 -1697506465 -239 -1528485247 181 -693133245 -295 -237116330 -169 36988929 -236 997566664 -189 1046880247 -292 1470254729 -139 1826464025 -119
      // 1c4: iload 1
      // 1c5: ldc 1055917785
      // 1c7: ixor
      // 1c8: ldc 1024595437
      // 1ca: iadd
      // 1cb: ldc 448008980
      // 1cd: isub
      // 1ce: ldc 896111534
      // 1d0: iadd
      // 1d1: ldc 1128124089
      // 1d3: isub
      // 1d4: ldc 1607046579
      // 1d6: iadd
      // 1d7: lookupswitch -187 4 -1902216551 -203 -512224547 -146 577563195 -187 1541409013 -125
      // 200: ldc -188840893
      // 202: istore 1
      // 203: goto 149
      // 206: ldc -1915045080
      // 208: dup
      // 209: ldc -753903066
      // 20b: ishl
      // 20c: ixor
      // 20d: ldc -540054807
      // 20f: ixor
      // 210: istore 1
      // 211: goto 1c4
      // 214: ldc -784167460
      // 216: ldc -715933464
      // 218: ldc -127247700
      // 21a: ishl
      // 21b: ior
      // 21c: ldc -1876882909
      // 21e: ior
      // 21f: ldc -1796613533
      // 221: iand
      // 222: istore 1
      // 223: goto 1c4
      // 226: return
      // 227: iload 1
      // 228: ldc 1636821333
      // 22a: iadd
      // 22b: ldc 382316721
      // 22d: ixor
      // 22e: ldc 1258426014
      // 230: ixor
      // 231: ldc 1586235499
      // 233: ixor
      // 234: ldc 890742110
      // 236: iadd
      // 237: ldc 891206291
      // 239: iadd
      // 23a: lookupswitch -550 2 -1064023774 -550 1756006830 -547
   }

   // $VF: renamed from: 0 (java.lang.invoke.MethodHandles.Lookup, java.lang.String, java.lang.invoke.MethodType, java.lang.Object[]) java.lang.Object
   public static Object method_76(Lookup var0, String var1, MethodType var2, Object... var3) {
      int var10 = (Integer)var3[4];
      int var10001 = ((var10 - 1839291001 - 1690423134 ^ 2107432446) - 2114567207 + 2042731812 ^ 983361748) + 435743637 + 1513257950 - 1668837637;
      MethodHandle var10000 = field_55[((var10 - 1839291001 - 1690423134 ^ 2107432446) - 2114567207 + 2042731812 ^ 983361748)
         + 435743637
         + 1513257950
         - 1668837637
         - 1387566727];
      if (field_55[var10001 - 1387566727] == null) {
         int var4 = (Integer)var3[0];
         StringBuilder var13 = new StringBuilder((String)var3[1]);

         for (int var23 = ~(-1181474885 >> (-92947404 | -1181474885)); var23 < var13.length(); var23 += (1541235752 << 1541235752 | 1) & 1688587) {
            int var42 = (var13.charAt(var23) + 133 ^ 207) - 111 ^ 6;
            int var10004 = (var42 & 65520) >> 4;
            int var43 = ((var42 & 65520) >> 4 | var42 << 12) - 171;
            int var83 = (((var42 & 65520) >> 4 | var42 << 12) - 171 & 32768) >> 15;
            char var44 = (char)((((var10004 | var42 << 12) - 171 & 32768) >> 15 | ((var42 & 65520) >> 4 | var42 << 12) - 171 << 1) + 242 + 208 + 5);
            var13.setCharAt(var23, (char)((var83 | var43 << 1) + 242 + 208 + 5));
         }

         String var5 = var13.toString();
         StringBuilder var16 = new StringBuilder((String)var3[2]);

         for (int var29 = (-1411925806 << -1411925806 | 0) & 338760885; var29 < var16.length(); var29 += 1959397519 >> 1756114179 ^ 244924688) {
            int var49 = var16.charAt(var29);
            int var84 = (var49 & 65472) >> 6;
            int var50 = (var49 & 65472) >> 6 | var49 << 10;
            int var85 = (((var49 & 65472) >> 6 | var49 << 10) & 65504) >> 5;
            var49 = (((var84 | var49 << 10) & 65504) >> 5 | ((var49 & 65472) >> 6 | var49 << 10) << 11) ^ 188 ^ 107 ^ 194;
            var84 = (((var85 | var50 << 11) ^ 188 ^ 107 ^ 194) & 65520) >> 4;
            int var52 = ((((var85 | var50 << 11) ^ 188 ^ 107 ^ 194) & 65520) >> 4 | var49 << 12) + 54;
            int var87 = (((((var85 | var50 << 11) ^ 188 ^ 107 ^ 194) & 65520) >> 4 | var49 << 12) + 54 & 65472) >> 6;
            char var53 = (char)(
               (((var84 | var49 << 12) + 54 & 65472) >> 6 | ((((var85 | var50 << 11) ^ 188 ^ 107 ^ 194) & 65520) >> 4 | var49 << 12) + 54 << 10) ^ 40 ^ 108
            );
            var16.setCharAt(var29, (char)((var87 | var52 << 10) ^ 40 ^ 108));
         }

         MethodType var6 = MethodType.fromMethodDescriptorString(var16.toString(), Class_411.class.getClassLoader());
         StringBuilder var19 = new StringBuilder((String)var3[3]);

         for (int var35 = 1356257674 >>> 290035701 ^ 646; var35 < var19.length(); var35 += (-698589975 - -369079044 | 0) & 16994323) {
            int var58 = (var19.charAt(var35) ^ 248) + 244;
            char var63 = (char)(
               (
                        (
                              (
                                       (
                                                (
                                                         (
                                                               (((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 & 63488) >> 11
                                                                  | ((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 << 5
                                                            )
                                                            & 64512
                                                      )
                                                      >> 10
                                                   | (
                                                         (((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 & 63488) >> 11
                                                            | ((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 << 5
                                                      )
                                                      << 6
                                             )
                                             + 226
                                          & 49152
                                    )
                                    >> 14
                                 | (
                                          (
                                                   (
                                                         (((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 & 63488) >> 11
                                                            | ((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 << 5
                                                      )
                                                      & 64512
                                                )
                                                >> 10
                                             | (
                                                   (((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 & 63488) >> 11
                                                      | ((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 << 5
                                                )
                                                << 6
                                       )
                                       + 226
                                    << 2
                           )
                           & 65532
                     )
                     >> 2
                  | (
                        (
                                 (
                                          (
                                                   (
                                                         (((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 & 63488) >> 11
                                                            | ((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 << 5
                                                      )
                                                      & 64512
                                                )
                                                >> 10
                                             | (
                                                   (((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 & 63488) >> 11
                                                      | ((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 << 5
                                                )
                                                << 6
                                       )
                                       + 226
                                    & 49152
                              )
                              >> 14
                           | (
                                    (
                                             (
                                                   (((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 & 63488) >> 11
                                                      | ((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 << 5
                                                )
                                                & 64512
                                          )
                                          >> 10
                                       | (
                                             (((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 & 63488) >> 11
                                                | ((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 << 5
                                          )
                                          << 6
                                 )
                                 + 226
                              << 2
                     )
                     << 14
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
                                                                  (((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 & 63488) >> 11
                                                                     | ((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 << 5
                                                               )
                                                               & 64512
                                                         )
                                                         >> 10
                                                      | (
                                                            (((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 & 63488) >> 11
                                                               | ((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 << 5
                                                         )
                                                         << 6
                                                )
                                                + 226
                                             & 49152
                                       )
                                       >> 14
                                    | (
                                             (
                                                      (
                                                            (((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 & 63488) >> 11
                                                               | ((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 << 5
                                                         )
                                                         & 64512
                                                   )
                                                   >> 10
                                                | (
                                                      (((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 & 63488) >> 11
                                                         | ((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 << 5
                                                   )
                                                   << 6
                                          )
                                          + 226
                                       << 2
                              )
                              & 65532
                        )
                        >> 2
                     | (
                           (
                                    (
                                             (
                                                      (
                                                            (((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 & 63488) >> 11
                                                               | ((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 << 5
                                                         )
                                                         & 64512
                                                   )
                                                   >> 10
                                                | (
                                                      (((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 & 63488) >> 11
                                                         | ((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 << 5
                                                   )
                                                   << 6
                                          )
                                          + 226
                                       & 49152
                                 )
                                 >> 14
                              | (
                                       (
                                                (
                                                      (((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 & 63488) >> 11
                                                         | ((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 << 5
                                                   )
                                                   & 64512
                                             )
                                             >> 10
                                          | (
                                                (((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 & 63488) >> 11
                                                   | ((var58 & 65504) >> 5 | var58 << 11) - 201 - 164 << 5
                                             )
                                             << 6
                                    )
                                    + 226
                                 << 2
                        )
                        << 14
               )
            );
         }

         Class var7 = Class.forName(var19.toString(), false, Class_411.class.getClassLoader());
         switch (((var4 + 1602062046 ^ 1864899201 ^ 1152436379 ^ 1985274464 ^ 1688004393 ^ 1176655105) - 1260155928 ^ 158152861) + 1497747362 + 175209825) {
            case 230403561:
            case 375960063:
               var10000 = var0.findVirtual(var7, var5, var6);
               break;
            case 328032267:
               var10000 = var0.findConstructor(var7, var6);
               break;
            case 1349047425:
               var10000 = var0.findStatic(var7, var5, var6);
               break;
            case 1454302916:
               var10000 = var0.findSpecial(var7, var5, var6, Class_411.class);
               break;
            default:
               throw new UnsupportedOperationException("Unsupported handle type!");
         }
      }

      field_55[((var10 - 1839291001 - 1690423134 ^ 2107432446) - 2114567207 + 2042731812 ^ 983361748) + 435743637 + 1513257950 - 1668837637 - 1387566727] = var10000;
      MethodHandle var11 = var10000.asType(var2);
      return new MutableCallSite(var11);
   }

   // $VF: renamed from: 1 (java.lang.invoke.MethodHandles.Lookup, java.lang.String, java.lang.invoke.MethodType, java.lang.Object[]) java.lang.Object
   public static Object method_77(Lookup var0, String var1, MethodType var2, Object... var3) {
      boolean var11 = false;
      int var10 = (Integer)var3[4];
      int var10001 = (var10 + 2102539154 - 1845061671 ^ 1255197021 ^ 1453596507) - 14581962 + 2092712203 + 1888484781 - 1284645647 ^ 1356238214;
      MethodHandle var10000 = field_55[(
            (var10 + 2102539154 - 1845061671 ^ 1255197021 ^ 1453596507) - 14581962 + 2092712203 + 1888484781 - 1284645647 ^ 1356238214
         )
         + 1611160749];
      if (field_55[var10001 + 1611160749] == null) {
         int var4 = (Integer)var3[0];
         StringBuilder var14 = new StringBuilder((String)var3[1]);

         for (int var24 = 194427698 & -1758419783 << 2046851101 ^ 0; var24 < var14.length(); var24 += (1049576134 ^ -1103100378 * -179974031 | 1) & -2080300143) {
            int var43 = var14.charAt(var24);
            int var10004 = (var43 & 65532) >> 2;
            int var44 = (var43 & 65532) >> 2 | var43 << 14;
            int var94 = (((var43 & 65532) >> 2 | var43 << 14) & 65408) >> 7;
            var43 = (((var10004 | var43 << 14) & 65408) >> 7 | ((var43 & 65532) >> 2 | var43 << 14) << 9) + 126 + 10 - 202;
            var10004 = ((var94 | var44 << 9) + 126 + 10 - 202 & 63488) >> 11;
            int var46 = (((var94 | var44 << 9) + 126 + 10 - 202 & 63488) >> 11 | var43 << 5) ^ 206;
            int var96 = (((((var94 | var44 << 9) + 126 + 10 - 202 & 63488) >> 11 | var43 << 5) ^ 206) & 32768) >> 15;
            var43 = (((var10004 | var43 << 5) ^ 206) & 32768) >> 15 | ((((var94 | var44 << 9) + 126 + 10 - 202 & 63488) >> 11 | var43 << 5) ^ 206) << 1;
            var10004 = ((var96 | var46 << 1) & 61440) >> 12;
            int var48 = ((var96 | var46 << 1) & 61440) >> 12 | var43 << 4;
            int var98 = ((((var96 | var46 << 1) & 61440) >> 12 | var43 << 4) & 32768) >> 15;
            char var49 = (char)(((var10004 | var43 << 4) & 32768) >> 15 | (((var96 | var46 << 1) & 61440) >> 12 | var43 << 4) << 1);
            var14.setCharAt(var24, (char)(var98 | var48 << 1));
         }

         String var5 = var14.toString();
         StringBuilder var17 = new StringBuilder((String)var3[2]);

         for (int var30 = (-871110482 | 1629061821) ^ -316937537; var30 < var17.length(); var30 += (-1692898546 & -1151031494 | 1) & 1144750277) {
            int var54 = var17.charAt(var30);
            int var99 = (var54 & 65408) >> 7;
            int var55 = (var54 & 65408) >> 7 | var54 << 9;
            int var100 = (((var54 & 65408) >> 7 | var54 << 9) & 63488) >> 11;
            var54 = ((var99 | var54 << 9) & 63488) >> 11 | ((var54 & 65408) >> 7 | var54 << 9) << 5;
            var99 = ((var100 | var55 << 5) & 65532) >> 2;
            int var57 = ((var100 | var55 << 5) & 65532) >> 2 | var54 << 14;
            int var102 = ((((var100 | var55 << 5) & 65532) >> 2 | var54 << 14) & 65534) >> 1;
            var54 = ((var99 | var54 << 14) & 65534) >> 1 | (((var100 | var55 << 5) & 65532) >> 2 | var54 << 14) << 15;
            var99 = ((var102 | var57 << 15) & 65472) >> 6;
            int var59 = (((var102 | var57 << 15) & 65472) >> 6 | var54 << 10) + 104;
            int var104 = ((((var102 | var57 << 15) & 65472) >> 6 | var54 << 10) + 104 & 0) >> 16;
            char var60 = (char)(
               ((((var99 | var54 << 10) + 104 & 0) >> 16 | (((var102 | var57 << 15) & 65472) >> 6 | var54 << 10) + 104 << 0) ^ 209) - 201 + 240
            );
            var17.setCharAt(var30, (char)(((var104 | var59 << 0) ^ 209) - 201 + 240));
         }

         Class var6 = Class.forName(var17.toString(), false, Class_411.class.getClassLoader());
         StringBuilder var20 = new StringBuilder((String)var3[3]);

         for (int var36 = -800907411 >>> -1046214618 ^ 54594685; var36 < var20.length(); var36 += (-688901015 + -688901015 | 1) & 1074730285) {
            int var65 = var20.charAt(var36);
            int var105 = (var65 & 64512) >> 10;
            int var66 = (((var65 & 64512) >> 10 | var65 << 6) ^ 146 ^ 69) - 19 - 189 ^ 48;
            int var106 = (((((var65 & 64512) >> 10 | var65 << 6) ^ 146 ^ 69) - 19 - 189 ^ 48) & 65520) >> 4;
            var65 = ((((var105 | var65 << 6) ^ 146 ^ 69) - 19 - 189 ^ 48) & 65520) >> 4
               | ((((var65 & 64512) >> 10 | var65 << 6) ^ 146 ^ 69) - 19 - 189 ^ 48) << 12;
            var105 = ((var106 | var66 << 12) & 61440) >> 12;
            int var68 = (((var106 | var66 << 12) & 61440) >> 12 | var65 << 4) ^ 64;
            int var108 = (((((var106 | var66 << 12) & 61440) >> 12 | var65 << 4) ^ 64) & 65504) >> 5;
            char var69 = (char)((((var105 | var65 << 4) ^ 64) & 65504) >> 5 | ((((var106 | var66 << 12) & 61440) >> 12 | var65 << 4) ^ 64) << 11);
            var20.setCharAt(var36, (char)(var108 | var68 << 11));
         }

         Class var7 = MethodType.fromMethodDescriptorString(var20.toString(), Class_411.class.getClassLoader()).returnType();
         switch ((((var4 ^ 1229092570) - 85599242 - 2118202579 + 9211211 ^ 617029118) - 885979324 + 1976685462 ^ 766089989) - 477762391 + 391407803) {
            case 97584709:
               var10000 = var0.findStaticSetter(var6, var5, var7);
               break;
            case 935835557:
               var10000 = var0.findSetter(var6, var5, var7);
               break;
            case 1275403242:
               var10000 = var0.findGetter(var6, var5, var7);
               break;
            case 1715353427:
               var10000 = var0.findStaticGetter(var6, var5, var7);
               break;
            default:
               throw new UnsupportedOperationException("Unsupported handle type!");
         }
      }

      if (!var11) {
         field_55[((var10 + 2102539154 - 1845061671 ^ 1255197021 ^ 1453596507) - 14581962 + 2092712203 + 1888484781 - 1284645647 ^ 1356238214) + 1611160749] = var10000;
      }

      MethodHandle var12 = var10000.asType(var2);
      return new MutableCallSite(var12);
   }
}

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;
import java.lang.invoke.MethodHandles.Lookup;

// $VF: synthetic class
public class Class_310 {
   // $VF: renamed from: iao java.lang.invoke.MethodHandle[]
   public static final MethodHandle[] field_274;

   static {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc -1619242203
      // 02: dup
      // 03: ior
      // 04: ldc -1619242206
      // 06: ixor
      // 07: anewarray 18
      // 0a: putstatic Class_310.iao [Ljava/lang/invoke/MethodHandle;
      // 0d: goto db
      // 10: ldc 1786717532
      // 12: dup
      // 13: dup2
      // 14: iadd
      // 15: iand
      // 16: iadd
      // 17: ldc -736051131
      // 19: ior
      // 1a: ldc -597503033
      // 1c: iand
      // 1d: istore 1
      // 1e: goto 67
      // 21: invokedynamic JNT ()[I bsm=Class_310.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -1239619790, "㋷ㄗ㋷", "ۃ", "繸幸鹾幼", 543087707 ]
      // 26: invokedynamic JNT ()Lnet/minecraft/class_239$class_240; bsm=Class_310.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -1239619790, "㋗ㄷ㊷㎗㊗ㇷ﨨難難難", "ܓ\u074bۃԓ܋ګܓ\u074bۻٳ۫ݓۃԓۻ܃۫ٻٻ֛ѳѻЫՃۻ܃۫ٻٻ֛ѳӃѣ", "繸幸ﹾ⺃컿\uee81ṻ캂亀⺃컿躁꺃亁⺀\uee81ṻ躁\uee82亁躃躃ກ빻鹻幺ﹷ躁\uee82亁躃躃ກ빻ﹹ繻鹺", 543087710 ]
      // 2b: invokedynamic JNT (Ljava/lang/Object;)I bsm=Class_310.0 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ 114912911, "圤咤䆤䀤嚤㰤喤", "Ð胐胀", "㧘㲘㡘⧘㪘㦘㧘㲘㬘㛘㮘㯘㡘⧘㬘㩘㮘㜘㜘⸘⛘✘▘ⱘ㬘㩘㮘㜘㜘⸘⛘⡘❘", -620936690 ]
      // 30: bipush 1
      // 31: iastore
      // 32: goto 38
      // 35: goto 3e
      // 38: ldc -180793807
      // 3a: istore 1
      // 3b: goto 67
      // 3e: ldc -1130489409
      // 40: istore 1
      // 41: goto 98
      // 44: invokedynamic JNT ()[I bsm=Class_310.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -1239619790, "㋷ㄗ㋷", "ۃ", "繸幸鹾幼", 543087712 ]
      // 49: invokedynamic JNT ()Lnet/minecraft/class_239$class_240; bsm=Class_310.1 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ -1239619790, "㋗ㄷ㊷㎗㊗ㇷ﨨難難煮", "ܓ\u074bۃԓ܋ګܓ\u074bۻٳ۫ݓۃԓۻ܃۫ٻٻ֛ѳѻЫՃۻ܃۫ٻٻ֛ѳӃѣ", "繸幸ﹾ⺃컿\uee81ṻ캂亀⺃컿躁꺃亁⺀\uee81ṻ躁\uee82亁躃躃ກ빻鹻幺ﹷ躁\uee82亁躃躃ກ빻ﹹ繻鹺", 543087711 ]
      // 4e: invokedynamic JNT (Ljava/lang/Object;)I bsm=Class_310.0 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ 114912911, "圤咤䆤䀤嚤㰤喤", "Ð胐胀", "㧘㲘㡘⧘㪘㦘㧘㲘㬘㛘㮘㯘㡘⧘㬘㩘㮘㜘㜘⸘⛘✘▘ⱘ㬘㩘㮘㜘㜘⸘⛘⡘❘", -620936701 ]
      // 53: bipush 2
      // 54: iastore
      // 55: goto 5b
      // 58: goto cc
      // 5b: ldc 545409370
      // 5d: ldc 1433958026
      // 5f: ior
      // 60: ldc 1602057903
      // 62: iand
      // 63: istore 1
      // 64: goto 98
      // 67: iload 1
      // 68: ldc 1970108111
      // 6a: iadd
      // 6b: ldc 2122423841
      // 6d: ixor
      // 6e: ldc 1408978563
      // 70: iadd
      // 71: ldc 428862717
      // 73: ixor
      // 74: ldc 833956048
      // 76: isub
      // 77: ldc 2087196661
      // 79: iadd
      // 7a: lookupswitch -69 2 -1134545794 -69 -445118614 -89
      // 94: astore 0
      // 95: goto cc
      // 98: iload 1
      // 99: ldc 1093193219
      // 9b: isub
      // 9c: ldc 238789716
      // 9e: iadd
      // 9f: ldc 754747179
      // a1: isub
      // a2: ldc 167613045
      // a4: isub
      // a5: ldc 1044409931
      // a7: iadd
      // a8: ldc 1040102242
      // aa: iadd
      // ab: lookupswitch -103 3 -822740963 -103 1741706472 -83 2119138162 47
      // cc: ldc -1395467184
      // ce: dup
      // cf: iushr
      // d0: ldc 1811386628
      // d2: ior
      // d3: ldc 2080366389
      // d5: iand
      // d6: istore 1
      // d7: goto 98
      // da: return
      // db: ldc 1291228492
      // dd: istore 1
      // de: goto e1
      // e1: invokedynamic JNT ()[Lnet/minecraft/class_239$class_240; bsm=Class_310.0 (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/Object; args=[ 112340992, "媤㰤喤娤䈤唤", "Ð胐胻Âõ胾ö胕胲胰õ胾胿÷胼ñö胕胿ò胼胷胷能×胗胈Þ胿ò胼胷胷能×ÖÔ胋", "㧘㲘㡘⧘㪘㦘㧘㲘㬘㛘㮘㯘㡘⧘㬘㩘㮘㜘㜘⸘⛘✘▘ⱘ㬘㩘㮘㜘㜘⸘⛘⡘❘", -620936694 ]
      // e6: checkcast [Lnet/minecraft/class_239$class_240;
      // e9: arraylength
      // ea: newarray 10
      // ec: putstatic Class_310.ghg [I
      // ef: goto 10
      // f2: astore 0
      // f3: goto 3e
   }

   // $VF: renamed from: 0 (java.lang.invoke.MethodHandles.Lookup, java.lang.String, java.lang.invoke.MethodType, java.lang.Object[]) java.lang.Object
   public static Object method_311(Lookup var0, String var1, MethodType var2, Object... var3) {
      int var10 = (Integer)var3[4];
      int var10001 = ((var10 + 211352391 - 2057967578 + 1948261012 ^ 1801374877) + 889693733 + 1162036053 ^ 85613602) + 1247200461 + 1215948613;
      MethodHandle var10000 = field_274[((var10 + 211352391 - 2057967578 + 1948261012 ^ 1801374877) + 889693733 + 1162036053 ^ 85613602)
         + 1247200461
         + 1215948613
         + 1806182850];
      if (field_274[var10001 + 1806182850] == null) {
         int var4 = (Integer)var3[0];
         StringBuilder var13 = new StringBuilder((String)var3[1]);

         for (int var23 = (-1519678243 & -1519678243 | 0) & 1511289378;
            var23 < var13.length();
            var23 += (274695298 & 971058233 >>> (274695298 >> 971058233) | 1) & -219801759
         ) {
            int var42 = var13.charAt(var23) + 179;
            int var10004 = (var42 & 0) >> 16;
            int var43 = ((var42 & 0) >> 16 | var42 << 0) + 144 + 249 + 160;
            int var79 = (((var42 & 0) >> 16 | var42 << 0) + 144 + 249 + 160 & 65408) >> 7;
            char var44 = (char)(
               ((((var10004 | var42 << 0) + 144 + 249 + 160 & 65408) >> 7 | ((var42 & 0) >> 16 | var42 << 0) + 144 + 249 + 160 << 9) - 183 + 122 ^ 20) + 12
            );
            var13.setCharAt(var23, (char)(((var79 | var43 << 9) - 183 + 122 ^ 20) + 12));
         }

         String var5 = var13.toString();
         StringBuilder var16 = new StringBuilder((String)var3[2]);

         for (int var29 = -1145826064 >>> -291739664 ^ 48052; var29 < var16.length(); var29 += (-688740788 & -688740788 | 1) & 688472369) {
            char var49 = var16.charAt(var29);
            char var54 = (char)(
               (
                     (
                              (
                                       (
                                                (
                                                      (
                                                               (
                                                                        (
                                                                              (((var49 & '\uffff') >> 0 | var49 << 16) & 57344) >> 13
                                                                                 | ((var49 & '\uffff') >> 0 | var49 << 16) << 3
                                                                           )
                                                                           ^ 203
                                                                     )
                                                                     + 191
                                                                     - 134
                                                                  & 65408
                                                            )
                                                            >> 7
                                                         | (
                                                                  (
                                                                        (((var49 & '\uffff') >> 0 | var49 << 16) & 57344) >> 13
                                                                           | ((var49 & '\uffff') >> 0 | var49 << 16) << 3
                                                                     )
                                                                     ^ 203
                                                               )
                                                               + 191
                                                               - 134
                                                            << 9
                                                   )
                                                   & 57344
                                             )
                                             >> 13
                                          | (
                                                (
                                                         (
                                                                  (
                                                                        (((var49 & '\uffff') >> 0 | var49 << 16) & 57344) >> 13
                                                                           | ((var49 & '\uffff') >> 0 | var49 << 16) << 3
                                                                     )
                                                                     ^ 203
                                                               )
                                                               + 191
                                                               - 134
                                                            & 65408
                                                      )
                                                      >> 7
                                                   | (
                                                            (
                                                                  (((var49 & '\uffff') >> 0 | var49 << 16) & 57344) >> 13
                                                                     | ((var49 & '\uffff') >> 0 | var49 << 16) << 3
                                                               )
                                                               ^ 203
                                                         )
                                                         + 191
                                                         - 134
                                                      << 9
                                             )
                                             << 3
                                    )
                                    - 71
                                 & 49152
                           )
                           >> 14
                        | (
                                 (
                                          (
                                                (
                                                         (
                                                                  (
                                                                        (((var49 & '\uffff') >> 0 | var49 << 16) & 57344) >> 13
                                                                           | ((var49 & '\uffff') >> 0 | var49 << 16) << 3
                                                                     )
                                                                     ^ 203
                                                               )
                                                               + 191
                                                               - 134
                                                            & 65408
                                                      )
                                                      >> 7
                                                   | (
                                                            (
                                                                  (((var49 & '\uffff') >> 0 | var49 << 16) & 57344) >> 13
                                                                     | ((var49 & '\uffff') >> 0 | var49 << 16) << 3
                                                               )
                                                               ^ 203
                                                         )
                                                         + 191
                                                         - 134
                                                      << 9
                                             )
                                             & 57344
                                       )
                                       >> 13
                                    | (
                                          (
                                                   (
                                                            (
                                                                  (((var49 & '\uffff') >> 0 | var49 << 16) & 57344) >> 13
                                                                     | ((var49 & '\uffff') >> 0 | var49 << 16) << 3
                                                               )
                                                               ^ 203
                                                         )
                                                         + 191
                                                         - 134
                                                      & 65408
                                                )
                                                >> 7
                                             | (((((var49 & '\uffff') >> 0 | var49 << 16) & 57344) >> 13 | ((var49 & '\uffff') >> 0 | var49 << 16) << 3) ^ 203)
                                                   + 191
                                                   - 134
                                                << 9
                                       )
                                       << 3
                              )
                              - 71
                           << 2
                  )
                  - 93
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
                                                                                 (((var49 & '\uffff') >> 0 | var49 << 16) & 57344) >> 13
                                                                                    | ((var49 & '\uffff') >> 0 | var49 << 16) << 3
                                                                              )
                                                                              ^ 203
                                                                        )
                                                                        + 191
                                                                        - 134
                                                                     & 65408
                                                               )
                                                               >> 7
                                                            | (
                                                                     (
                                                                           (((var49 & '\uffff') >> 0 | var49 << 16) & 57344) >> 13
                                                                              | ((var49 & '\uffff') >> 0 | var49 << 16) << 3
                                                                        )
                                                                        ^ 203
                                                                  )
                                                                  + 191
                                                                  - 134
                                                               << 9
                                                      )
                                                      & 57344
                                                )
                                                >> 13
                                             | (
                                                   (
                                                            (
                                                                     (
                                                                           (((var49 & '\uffff') >> 0 | var49 << 16) & 57344) >> 13
                                                                              | ((var49 & '\uffff') >> 0 | var49 << 16) << 3
                                                                        )
                                                                        ^ 203
                                                                  )
                                                                  + 191
                                                                  - 134
                                                               & 65408
                                                         )
                                                         >> 7
                                                      | (
                                                               (
                                                                     (((var49 & '\uffff') >> 0 | var49 << 16) & 57344) >> 13
                                                                        | ((var49 & '\uffff') >> 0 | var49 << 16) << 3
                                                                  )
                                                                  ^ 203
                                                            )
                                                            + 191
                                                            - 134
                                                         << 9
                                                )
                                                << 3
                                       )
                                       - 71
                                    & 49152
                              )
                              >> 14
                           | (
                                    (
                                             (
                                                   (
                                                            (
                                                                     (
                                                                           (((var49 & '\uffff') >> 0 | var49 << 16) & 57344) >> 13
                                                                              | ((var49 & '\uffff') >> 0 | var49 << 16) << 3
                                                                        )
                                                                        ^ 203
                                                                  )
                                                                  + 191
                                                                  - 134
                                                               & 65408
                                                         )
                                                         >> 7
                                                      | (
                                                               (
                                                                     (((var49 & '\uffff') >> 0 | var49 << 16) & 57344) >> 13
                                                                        | ((var49 & '\uffff') >> 0 | var49 << 16) << 3
                                                                  )
                                                                  ^ 203
                                                            )
                                                            + 191
                                                            - 134
                                                         << 9
                                                )
                                                & 57344
                                          )
                                          >> 13
                                       | (
                                             (
                                                      (
                                                               (
                                                                     (((var49 & '\uffff') >> 0 | var49 << 16) & 57344) >> 13
                                                                        | ((var49 & '\uffff') >> 0 | var49 << 16) << 3
                                                                  )
                                                                  ^ 203
                                                            )
                                                            + 191
                                                            - 134
                                                         & 65408
                                                   )
                                                   >> 7
                                                | (
                                                         (
                                                               (((var49 & '\uffff') >> 0 | var49 << 16) & 57344) >> 13
                                                                  | ((var49 & '\uffff') >> 0 | var49 << 16) << 3
                                                            )
                                                            ^ 203
                                                      )
                                                      + 191
                                                      - 134
                                                   << 9
                                          )
                                          << 3
                                 )
                                 - 71
                              << 2
                     )
                     - 93
               )
            );
         }

         MethodType var6 = MethodType.fromMethodDescriptorString(var16.toString(), Class_310.class.getClassLoader());
         StringBuilder var19 = new StringBuilder((String)var3[3]);

         for (int var35 = (-39191114 >> -616613710 | 0) & 149; var35 < var19.length(); var35 += (854151486 >>> 854151486 | 1) & -490145535) {
            char var59 = var19.charAt(var35);
            int var85 = (var59 & '\ufffe') >> 1;
            int var60 = ((var59 & '\ufffe') >> 1 | var59 << 15) + 91 + 52 + 57 + 221 ^ 32 ^ 248 ^ 137;
            int var86 = ((((var59 & '\ufffe') >> 1 | var59 << 15) + 91 + 52 + 57 + 221 ^ 32 ^ 248 ^ 137) & 65504) >> 5;
            var59 = (char)(
               (
                     (((var85 | var59 << 15) + 91 + 52 + 57 + 221 ^ 32 ^ 248 ^ 137) & 65504) >> 5
                        | (((var59 & '\ufffe') >> 1 | var59 << 15) + 91 + 52 + 57 + 221 ^ 32 ^ 248 ^ 137) << 11
                  )
                  ^ 152
            );
            var19.setCharAt(var35, (char)((var86 | var60 << 11) ^ 152));
         }

         Class var7 = Class.forName(var19.toString(), false, Class_310.class.getClassLoader());
         switch ((((var4 ^ 165318692) - 1774643764 ^ 337932092) - 1291485003 + 1639368797 ^ 1789954472 ^ 269911113 ^ 683353896) - 1454480357 ^ 475724040) {
            case 569873466:
               var10000 = var0.findStatic(var7, var5, var6);
               break;
            case 1455340375:
               var10000 = var0.findSpecial(var7, var5, var6, Class_310.class);
               break;
            case 1513188026:
               var10000 = var0.findConstructor(var7, var6);
               break;
            case 1565371303:
            case 1695952566:
               var10000 = var0.findVirtual(var7, var5, var6);
               break;
            default:
               throw new UnsupportedOperationException("Unsupported handle type!");
         }
      }

      field_274[((var10 + 211352391 - 2057967578 + 1948261012 ^ 1801374877) + 889693733 + 1162036053 ^ 85613602) + 1247200461 + 1215948613 + 1806182850] = var10000;
      MethodHandle var11 = var10000.asType(var2);
      return new MutableCallSite(var11);
   }

   // $VF: renamed from: 1 (java.lang.invoke.MethodHandles.Lookup, java.lang.String, java.lang.invoke.MethodType, java.lang.Object[]) java.lang.Object
   public static Object method_312(Lookup var0, String var1, MethodType var2, Object... var3) {
      boolean var11 = false;
      int var10 = (Integer)var3[4];
      int var10001 = (var10 + 1024364239 - 931308158 + 1508169910 ^ 566183345) + 484276062 + 463036622 - 1980376837 - 1611906926 + 1960354871;
      MethodHandle var10000 = field_274[(var10 + 1024364239 - 931308158 + 1508169910 ^ 566183345)
         + 484276062
         + 463036622
         - 1980376837
         - 1611906926
         + 1960354871
         - 899840707];
      if (field_274[var10001 - 899840707] == null) {
         int var4 = (Integer)var3[0];
         StringBuilder var14 = new StringBuilder((String)var3[1]);

         for (int var24 = (-1126344427 >>> (-1126344427 >> (-1126344427 | -1126344427)) | 0) & -1677164399;
            var24 < var14.length();
            var24 += 379780326 + 1149570301 ^ 1529350626
         ) {
            int var43 = var14.charAt(var24) ^ 144 ^ 103;
            char var46 = (char)(
               (
                     (
                              (((((var43 & 49152) >> 14 | var43 << 2) & 65532) >> 2 | ((var43 & 49152) >> 14 | var43 << 2) << 14) & 65504) >> 5
                                 | ((((var43 & 49152) >> 14 | var43 << 2) & 65532) >> 2 | ((var43 & 49152) >> 14 | var43 << 2) << 14) << 11
                           )
                           + 232
                           - 140
                        ^ 231
                  )
                  + 57
                  - 221
            );
            var14.setCharAt(
               var24,
               (char)(
                  (
                        (
                                 (((((var43 & 49152) >> 14 | var43 << 2) & 65532) >> 2 | ((var43 & 49152) >> 14 | var43 << 2) << 14) & 65504) >> 5
                                    | ((((var43 & 49152) >> 14 | var43 << 2) & 65532) >> 2 | ((var43 & 49152) >> 14 | var43 << 2) << 14) << 11
                              )
                              + 232
                              - 140
                           ^ 231
                     )
                     + 57
                     - 221
               )
            );
         }

         String var5 = var14.toString();
         StringBuilder var17 = new StringBuilder((String)var3[2]);

         for (int var30 = 52619197 >> 580486961 ^ 401; var30 < var17.length(); var30 += (-1210402501 * -1210402501 | 0) & -2109436921) {
            int var51 = (var17.charAt(var30) - 'n' - 126 ^ 1) - 246;
            char var54 = (char)(
               (
                        ((((((var51 & 65535) >> 0 | var51 << 16) ^ 40) & 65528) >> 3 | (((var51 & 65535) >> 0 | var51 << 16) ^ 40) << 13) & 65535) >> 0
                           | (((((var51 & 65535) >> 0 | var51 << 16) ^ 40) & 65528) >> 3 | (((var51 & 65535) >> 0 | var51 << 16) ^ 40) << 13) << 16
                     )
                     + 84
                  ^ 153
            );
            var17.setCharAt(
               var30,
               (char)(
                  (
                           ((((((var51 & 65535) >> 0 | var51 << 16) ^ 40) & 65528) >> 3 | (((var51 & 65535) >> 0 | var51 << 16) ^ 40) << 13) & 65535) >> 0
                              | (((((var51 & 65535) >> 0 | var51 << 16) ^ 40) & 65528) >> 3 | (((var51 & 65535) >> 0 | var51 << 16) ^ 40) << 13) << 16
                        )
                        + 84
                     ^ 153
               )
            );
         }

         Class var6 = Class.forName(var17.toString(), false, Class_310.class.getClassLoader());
         StringBuilder var20 = new StringBuilder((String)var3[3]);

         for (int var36 = 1489716424 ^ -1924779399 ^ -712149327; var36 < var20.length(); var36 += (-1589590859 & -1750750314 | 1) & 1291455081) {
            char var59 = var20.charAt(var36);
            char var66 = (char)(
               (
                     (
                              (
                                    (
                                             (
                                                   (
                                                            (
                                                                  (
                                                                        (
                                                                                 (
                                                                                       (
                                                                                                (
                                                                                                         (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                            | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                                      )
                                                                                                      + 115
                                                                                                   & 65535
                                                                                             )
                                                                                             >> 0
                                                                                          | (
                                                                                                   (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                      | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                                )
                                                                                                + 115
                                                                                             << 16
                                                                                    )
                                                                                    & 65520
                                                                              )
                                                                              >> 4
                                                                           | (
                                                                                 (
                                                                                          (
                                                                                                   (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                      | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                                )
                                                                                                + 115
                                                                                             & 65535
                                                                                       )
                                                                                       >> 0
                                                                                    | (
                                                                                             (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                          )
                                                                                          + 115
                                                                                       << 16
                                                                              )
                                                                              << 12
                                                                     )
                                                                     ^ 37
                                                               )
                                                               & 65535
                                                         )
                                                         >> 0
                                                      | (
                                                            (
                                                                  (
                                                                           (
                                                                                 (
                                                                                          (
                                                                                                   (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                      | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                                )
                                                                                                + 115
                                                                                             & 65535
                                                                                       )
                                                                                       >> 0
                                                                                    | (
                                                                                             (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                          )
                                                                                          + 115
                                                                                       << 16
                                                                              )
                                                                              & 65520
                                                                        )
                                                                        >> 4
                                                                     | (
                                                                           (
                                                                                    (
                                                                                             (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                          )
                                                                                          + 115
                                                                                       & 65535
                                                                                 )
                                                                                 >> 0
                                                                              | (
                                                                                       (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                          | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                    )
                                                                                    + 115
                                                                                 << 16
                                                                        )
                                                                        << 12
                                                               )
                                                               ^ 37
                                                         )
                                                         << 16
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
                                                                                          (
                                                                                                   (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                      | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                                )
                                                                                                + 115
                                                                                             & 65535
                                                                                       )
                                                                                       >> 0
                                                                                    | (
                                                                                             (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                          )
                                                                                          + 115
                                                                                       << 16
                                                                              )
                                                                              & 65520
                                                                        )
                                                                        >> 4
                                                                     | (
                                                                           (
                                                                                    (
                                                                                             (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                          )
                                                                                          + 115
                                                                                       & 65535
                                                                                 )
                                                                                 >> 0
                                                                              | (
                                                                                       (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                          | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                    )
                                                                                    + 115
                                                                                 << 16
                                                                        )
                                                                        << 12
                                                               )
                                                               ^ 37
                                                         )
                                                         & 65535
                                                   )
                                                   >> 0
                                                | (
                                                      (
                                                            (
                                                                     (
                                                                           (
                                                                                    (
                                                                                             (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                          )
                                                                                          + 115
                                                                                       & 65535
                                                                                 )
                                                                                 >> 0
                                                                              | (
                                                                                       (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                          | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                    )
                                                                                    + 115
                                                                                 << 16
                                                                        )
                                                                        & 65520
                                                                  )
                                                                  >> 4
                                                               | (
                                                                     (
                                                                              (
                                                                                       (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                          | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                    )
                                                                                    + 115
                                                                                 & 65535
                                                                           )
                                                                           >> 0
                                                                        | (
                                                                                 (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                    | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                              )
                                                                              + 115
                                                                           << 16
                                                                  )
                                                                  << 12
                                                         )
                                                         ^ 37
                                                   )
                                                   << 16
                                          )
                                          << 3
                                 )
                                 & 65504
                           )
                           >> 5
                        | (
                              (
                                       (
                                             (
                                                      (
                                                            (
                                                                  (
                                                                           (
                                                                                 (
                                                                                          (
                                                                                                   (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                      | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                                )
                                                                                                + 115
                                                                                             & 65535
                                                                                       )
                                                                                       >> 0
                                                                                    | (
                                                                                             (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                          )
                                                                                          + 115
                                                                                       << 16
                                                                              )
                                                                              & 65520
                                                                        )
                                                                        >> 4
                                                                     | (
                                                                           (
                                                                                    (
                                                                                             (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                          )
                                                                                          + 115
                                                                                       & 65535
                                                                                 )
                                                                                 >> 0
                                                                              | (
                                                                                       (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                          | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                    )
                                                                                    + 115
                                                                                 << 16
                                                                        )
                                                                        << 12
                                                               )
                                                               ^ 37
                                                         )
                                                         & 65535
                                                   )
                                                   >> 0
                                                | (
                                                      (
                                                            (
                                                                     (
                                                                           (
                                                                                    (
                                                                                             (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                          )
                                                                                          + 115
                                                                                       & 65535
                                                                                 )
                                                                                 >> 0
                                                                              | (
                                                                                       (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                          | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                    )
                                                                                    + 115
                                                                                 << 16
                                                                        )
                                                                        & 65520
                                                                  )
                                                                  >> 4
                                                               | (
                                                                     (
                                                                              (
                                                                                       (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                          | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                    )
                                                                                    + 115
                                                                                 & 65535
                                                                           )
                                                                           >> 0
                                                                        | (
                                                                                 (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                    | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                              )
                                                                              + 115
                                                                           << 16
                                                                  )
                                                                  << 12
                                                         )
                                                         ^ 37
                                                   )
                                                   << 16
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
                                                                                    (
                                                                                             (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                          )
                                                                                          + 115
                                                                                       & 65535
                                                                                 )
                                                                                 >> 0
                                                                              | (
                                                                                       (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                          | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                    )
                                                                                    + 115
                                                                                 << 16
                                                                        )
                                                                        & 65520
                                                                  )
                                                                  >> 4
                                                               | (
                                                                     (
                                                                              (
                                                                                       (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                          | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                    )
                                                                                    + 115
                                                                                 & 65535
                                                                           )
                                                                           >> 0
                                                                        | (
                                                                                 (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                    | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                              )
                                                                              + 115
                                                                           << 16
                                                                  )
                                                                  << 12
                                                         )
                                                         ^ 37
                                                   )
                                                   & 65535
                                             )
                                             >> 0
                                          | (
                                                (
                                                      (
                                                               (
                                                                     (
                                                                              (
                                                                                       (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                          | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                    )
                                                                                    + 115
                                                                                 & 65535
                                                                           )
                                                                           >> 0
                                                                        | (
                                                                                 (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                    | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                              )
                                                                              + 115
                                                                           << 16
                                                                  )
                                                                  & 65520
                                                            )
                                                            >> 4
                                                         | (
                                                               (
                                                                        (
                                                                                 (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                    | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                              )
                                                                              + 115
                                                                           & 65535
                                                                     )
                                                                     >> 0
                                                                  | ((((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7 | ((var59 & 0) >> 16 | var59 << 0) << 9)
                                                                        + 115
                                                                     << 16
                                                            )
                                                            << 12
                                                   )
                                                   ^ 37
                                             )
                                             << 16
                                    )
                                    << 3
                           )
                           << 11
                  )
                  + 92
            );
            var20.setCharAt(
               var36,
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
                                                                                    (
                                                                                          (
                                                                                                   (
                                                                                                            (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                               | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                                         )
                                                                                                         + 115
                                                                                                      & 65535
                                                                                                )
                                                                                                >> 0
                                                                                             | (
                                                                                                      (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                         | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                                   )
                                                                                                   + 115
                                                                                                << 16
                                                                                       )
                                                                                       & 65520
                                                                                 )
                                                                                 >> 4
                                                                              | (
                                                                                    (
                                                                                             (
                                                                                                      (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                         | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                                   )
                                                                                                   + 115
                                                                                                & 65535
                                                                                          )
                                                                                          >> 0
                                                                                       | (
                                                                                                (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                   | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                             )
                                                                                             + 115
                                                                                          << 16
                                                                                 )
                                                                                 << 12
                                                                        )
                                                                        ^ 37
                                                                  )
                                                                  & 65535
                                                            )
                                                            >> 0
                                                         | (
                                                               (
                                                                     (
                                                                              (
                                                                                    (
                                                                                             (
                                                                                                      (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                         | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                                   )
                                                                                                   + 115
                                                                                                & 65535
                                                                                          )
                                                                                          >> 0
                                                                                       | (
                                                                                                (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                   | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                             )
                                                                                             + 115
                                                                                          << 16
                                                                                 )
                                                                                 & 65520
                                                                           )
                                                                           >> 4
                                                                        | (
                                                                              (
                                                                                       (
                                                                                                (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                   | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                             )
                                                                                             + 115
                                                                                          & 65535
                                                                                    )
                                                                                    >> 0
                                                                                 | (
                                                                                          (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                             | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                       )
                                                                                       + 115
                                                                                    << 16
                                                                           )
                                                                           << 12
                                                                  )
                                                                  ^ 37
                                                            )
                                                            << 16
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
                                                                                             (
                                                                                                      (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                         | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                                   )
                                                                                                   + 115
                                                                                                & 65535
                                                                                          )
                                                                                          >> 0
                                                                                       | (
                                                                                                (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                   | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                             )
                                                                                             + 115
                                                                                          << 16
                                                                                 )
                                                                                 & 65520
                                                                           )
                                                                           >> 4
                                                                        | (
                                                                              (
                                                                                       (
                                                                                                (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                   | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                             )
                                                                                             + 115
                                                                                          & 65535
                                                                                    )
                                                                                    >> 0
                                                                                 | (
                                                                                          (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                             | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                       )
                                                                                       + 115
                                                                                    << 16
                                                                           )
                                                                           << 12
                                                                  )
                                                                  ^ 37
                                                            )
                                                            & 65535
                                                      )
                                                      >> 0
                                                   | (
                                                         (
                                                               (
                                                                        (
                                                                              (
                                                                                       (
                                                                                                (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                   | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                             )
                                                                                             + 115
                                                                                          & 65535
                                                                                    )
                                                                                    >> 0
                                                                                 | (
                                                                                          (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                             | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                       )
                                                                                       + 115
                                                                                    << 16
                                                                           )
                                                                           & 65520
                                                                     )
                                                                     >> 4
                                                                  | (
                                                                        (
                                                                                 (
                                                                                          (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                             | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                       )
                                                                                       + 115
                                                                                    & 65535
                                                                              )
                                                                              >> 0
                                                                           | (
                                                                                    (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                       | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                 )
                                                                                 + 115
                                                                              << 16
                                                                     )
                                                                     << 12
                                                            )
                                                            ^ 37
                                                      )
                                                      << 16
                                             )
                                             << 3
                                    )
                                    & 65504
                              )
                              >> 5
                           | (
                                 (
                                          (
                                                (
                                                         (
                                                               (
                                                                     (
                                                                              (
                                                                                    (
                                                                                             (
                                                                                                      (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                         | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                                   )
                                                                                                   + 115
                                                                                                & 65535
                                                                                          )
                                                                                          >> 0
                                                                                       | (
                                                                                                (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                   | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                             )
                                                                                             + 115
                                                                                          << 16
                                                                                 )
                                                                                 & 65520
                                                                           )
                                                                           >> 4
                                                                        | (
                                                                              (
                                                                                       (
                                                                                                (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                   | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                             )
                                                                                             + 115
                                                                                          & 65535
                                                                                    )
                                                                                    >> 0
                                                                                 | (
                                                                                          (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                             | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                       )
                                                                                       + 115
                                                                                    << 16
                                                                           )
                                                                           << 12
                                                                  )
                                                                  ^ 37
                                                            )
                                                            & 65535
                                                      )
                                                      >> 0
                                                   | (
                                                         (
                                                               (
                                                                        (
                                                                              (
                                                                                       (
                                                                                                (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                   | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                             )
                                                                                             + 115
                                                                                          & 65535
                                                                                    )
                                                                                    >> 0
                                                                                 | (
                                                                                          (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                             | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                       )
                                                                                       + 115
                                                                                    << 16
                                                                           )
                                                                           & 65520
                                                                     )
                                                                     >> 4
                                                                  | (
                                                                        (
                                                                                 (
                                                                                          (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                             | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                       )
                                                                                       + 115
                                                                                    & 65535
                                                                              )
                                                                              >> 0
                                                                           | (
                                                                                    (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                       | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                 )
                                                                                 + 115
                                                                              << 16
                                                                     )
                                                                     << 12
                                                            )
                                                            ^ 37
                                                      )
                                                      << 16
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
                                                                                       (
                                                                                                (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                                   | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                             )
                                                                                             + 115
                                                                                          & 65535
                                                                                    )
                                                                                    >> 0
                                                                                 | (
                                                                                          (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                             | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                       )
                                                                                       + 115
                                                                                    << 16
                                                                           )
                                                                           & 65520
                                                                     )
                                                                     >> 4
                                                                  | (
                                                                        (
                                                                                 (
                                                                                          (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                             | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                       )
                                                                                       + 115
                                                                                    & 65535
                                                                              )
                                                                              >> 0
                                                                           | (
                                                                                    (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                       | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                 )
                                                                                 + 115
                                                                              << 16
                                                                     )
                                                                     << 12
                                                            )
                                                            ^ 37
                                                      )
                                                      & 65535
                                                )
                                                >> 0
                                             | (
                                                   (
                                                         (
                                                                  (
                                                                        (
                                                                                 (
                                                                                          (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                             | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                       )
                                                                                       + 115
                                                                                    & 65535
                                                                              )
                                                                              >> 0
                                                                           | (
                                                                                    (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                       | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                 )
                                                                                 + 115
                                                                              << 16
                                                                     )
                                                                     & 65520
                                                               )
                                                               >> 4
                                                            | (
                                                                  (
                                                                           (
                                                                                    (((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7
                                                                                       | ((var59 & 0) >> 16 | var59 << 0) << 9
                                                                                 )
                                                                                 + 115
                                                                              & 65535
                                                                        )
                                                                        >> 0
                                                                     | ((((var59 & 0) >> 16 | var59 << 0) & 65408) >> 7 | ((var59 & 0) >> 16 | var59 << 0) << 9)
                                                                           + 115
                                                                        << 16
                                                               )
                                                               << 12
                                                      )
                                                      ^ 37
                                                )
                                                << 16
                                       )
                                       << 3
                              )
                              << 11
                     )
                     + 92
               )
            );
         }

         Class var7 = MethodType.fromMethodDescriptorString(var20.toString(), Class_310.class.getClassLoader()).returnType();
         switch (var4 - 1018882651 + 1576735090 - 1231993358 - 902468911 + 293373543 + 323222 + 1362814788 - 1132366020 - 602298637 ^ 1090588919) {
            case 309995915:
               var10000 = var0.findStaticGetter(var6, var5, var7);
               break;
            case 843637374:
               var10000 = var0.findGetter(var6, var5, var7);
               break;
            case 1561889997:
               var10000 = var0.findStaticSetter(var6, var5, var7);
               break;
            case 1616975112:
               var10000 = var0.findSetter(var6, var5, var7);
               break;
            default:
               throw new UnsupportedOperationException("Unsupported handle type!");
         }
      }

      if (!var11) {
         field_274[(var10 + 1024364239 - 931308158 + 1508169910 ^ 566183345) + 484276062 + 463036622 - 1980376837 - 1611906926 + 1960354871 - 899840707] = var10000;
      }

      MethodHandle var12 = var10000.asType(var2);
      return new MutableCallSite(var12);
   }
}

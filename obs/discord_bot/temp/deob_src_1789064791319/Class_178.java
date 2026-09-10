import dev.krypton.mixin.ChunkLightProviderAccessor;
import dev.krypton.mixin.ChunkToNibbleArrayMapAccessor;
import dev.krypton.mixin.LightStorageAccessor;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;
import java.lang.invoke.MethodHandles.Lookup;
import net.minecraft.class_2338;
import net.minecraft.class_2804;
import net.minecraft.class_3556;
import net.minecraft.class_3558;
import net.minecraft.class_3560;
import net.minecraft.class_4076;

public class Class_178 extends Class_342 {
   // $VF: renamed from: pvz java.lang.invoke.MethodHandle[]
   public static final MethodHandle[] field_2040 = new MethodHandle[46];

   public Class_178() {
      int var10001 = 0;

      StringBuilder var10002;
      for (var10002 = (StringBuilder)0<"JNT",-52669483,"氤\uec1a氝\uec1a\uf68f氥","\udc46\ude86\ue066\udfd6\ue126\udfd6\udcb6\ue086\udfd6\ue0a6\ue036\udcb6\udef6\ue106\ue0e6\ue056\ue0a6\ue036\udd76\udc56\udf26","䟌䞄䠬䞄䗬䟜䞄䟬䞴䗬䜔䠜䠌䟄䟬䞴䚌䠤䟄䟜䞜䞤䠌",-683702276>(
            "\ue804搅尅堅蠅㠄퀄搅瀅䠅吅者"
         );
         var10001 < ((374156196 ^ 374156196 | 12) & -1000819266);
         var10001 += (652137353 >>> (1345027976 & 652137353 >>> 1345027976) | 0) & 285222949
      ) {
         char var6 = 0<"JNT",209230708,"\uec17氚\uec16氟\uec26\uf68f","\udc46\ude56\udc56\uddf6","䟌䞄䠬䞄䗬䟜䞄䟬䞴䗬䜔䠜䠌䟄䟬䞴䚌䠤䟄䟜䞜䞤䠌",-683702277>(var10002, var10001);
         int var10005 = (var6 & '\uf800') >> 11;
         int var7 = ((var6 & '\uf800') >> 11 | var6 << 5) - 184;
         int var18 = (((var6 & '\uf800') >> 11 | var6 << 5) - 184 & 32768) >> 15;
         var6 = (char)((((var10005 | var6 << 5) - 184 & 32768) >> 15 | ((var6 & '\uf800') >> 11 | var6 << 5) - 184 << 1) + 91 + 38);
         0<"JNT",209230708,"\uec1f\uec18\uf68f\uec27氚\uec16氟\uec26\uf68f","\udc46\ude56\uddf6\udc56\udf26","䟌䞄䠬䞄䗬䟜䞄䟬䞴䗬䜔䠜䠌䟄䟬䞴䚌䠤䟄䟜䞜䞤䠌",-683702278>(
            var10002, var10001, (char)((var18 | var7 << 1) + 91 + 38)
         );
      }

      String var2 = 0<"JNT",209230708,"\uf68f\uec1d\uec2f\uf68f氟\uec1a氝\uec19","\udc46\udc56\ude86\ue066\udfd6\ue126\udfd6\udcb6\ue086\udfd6\ue0a6\ue036\udcb6\udef6\ue106\ue0e6\ue056\ue0a6\ue036\udd76","䟌䞄䠬䞄䗬䟜䞄䟬䞴䗬䜔䠜䠌䟄䟬䞴䚌䠤䟄䟜䞜䞤䠌",-683702329>(
         var10002
      );
      int var4 = (-1083590198 & 1357924541 | 0) & -895970443;

      StringBuilder var10;
      for (var10 = (StringBuilder)0<"JNT",-52669483,"氤\uec1a氝\uec1a\uf68f氥","\udc46\ude86\ue066\udfd6\ue126\udfd6\udcb6\ue086\udfd6\ue0a6\ue036\udcb6\udef6\ue106\ue0e6\ue056\ue0a6\ue036\udd76\udc56\udf26","䟌䞄䠬䞄䗬䟜䞄䟬䞴䗬䜔䠜䠌䟄䟬䞴䚌䠤䟄䟜䞜䞤䠌",-683702330>(
            "@ØĠÐØŀňﺷ¸ĐĐﺷĐøèðŐﺷňØÈŐøĨĠňﺷàĨŀﺷÀ¸ňØﺷàøĠÐøĠè"
         );
         var4 < 43;
         var4 += (-1625895307 | 1938072240) ^ -6885644
      ) {
         char var14 = 0<"JNT",209230708,"\uec17氚\uec16氟\uec26\uf68f","\udc46\ude56\udc56\uddf6","䟌䞄䠬䞄䗬䟜䞄䟬䞴䗬䜔䠜䠌䟄䟬䞴䚌䠤䟄䟜䞜䞤䠌",-683702279>(var10, var4);
         int var10006 = (var14 & '￠') >> 5;
         int var15 = (var14 & '￠') >> 5 | var14 << 11;
         int var21 = (((var14 & '￠') >> 5 | var14 << 11) & 49152) >> 14;
         var14 = (char)((((var10006 | var14 << 11) & 49152) >> 14 | ((var14 & '￠') >> 5 | var14 << 11) << 2) - 13 + 89 - 2);
         0<"JNT",209230708,"\uec1f\uec18\uf68f\uec27氚\uec16氟\uec26\uf68f","\udc46\ude56\uddf6\udc56\udf26","䟌䞄䠬䞄䗬䟜䞄䟬䞴䗬䜔䠜䠌䟄䟬䞴䚌䠤䟄䟜䞜䞤䠌",-683702280>(
            var10, var4, (char)((var21 | var15 << 2) - 13 + 89 - 2)
         );
      }

      super(
         var2,
         0<"JNT",209230708,"\uf68f\uec1d\uec2f\uf68f氟\uec1a氝\uec19","\udc46\udc56\ude86\ue066\udfd6\ue126\udfd6\udcb6\ue086\udfd6\ue0a6\ue036\udcb6\udef6\ue106\ue0e6\ue056\ue0a6\ue036\udd76","䟌䞄䠬䞄䗬䟜䞄䟬䞴䗬䜔䠜䠌䟄䟬䞴䚌䠤䟄䟜䞜䞤䠌",-683702331>(
            var10
         ),
         -1,
         1<"JNT",-583573823,"苕船苁","䭭摭","ՀԠી⌠Ḁೠ",-2091256157>()
      );
   }

   // $VF: renamed from: jw (Class_381) void
   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Inserted dummy exception handlers to handle obfuscated exceptions
   @Class_21
   public void method_1761(Class_381 var1) {
      Exception var10000;
      label153: {
         int var22 = -832086472;
         if (1<"JNT",-1866065875,"舕舙舉苭舍舱臹臕臝臑","恭杭噭\u206d彭孭恭杭敭呭捭桭噭\u206d敭幭捭啭啭煭ᕭ፭ቭ","ՀԠીẀᶠ⏀٠ẠᴠẀᶠᷠ␀†ᶀ⏀٠ᷠỀ†⏠⏠\u2060\u0b80\u0be0ୀೠ",-2091256064>(
                  1<"JNT",-1866065875,"苭苅","幭晭","ՀԠીẀᶠ⏀٠ẠᴠẀᶠᷠ␀†ᶀ⏀٠ᷠỀ†⏠⏠\u2060\u0be0ؠـೠ",-2091256067>(this)
               )
               != null
            && 1<"JNT",-1866065875,"舕舙舉苭舍舱臹臑臅臍","恭杭噭\u206d彭孭恭杭敭呭捭桭噭\u206d敭幭捭啭啭煭ᕭ፭ቭ","ՀԠીẀᶠ⏀٠ẠᴠẀᶠᷠ␀†ᶀ⏀٠ᷠỀ†⏠⏠\u2060ୠீ\u0b80ೠ",-2091256070>(
                  1<"JNT",-1866065875,"苭苅","幭晭","ՀԠીẀᶠ⏀٠ẠᴠẀᶠᷠ␀†ᶀ⏀٠ᷠỀ†⏠⏠\u2060\u0be0ؠـೠ",-2091256065>(this)
               )
               != null) {
            try {
               var22 = -429694029;
            } catch (Exception var34) {
               var10000 = var34;
               boolean var10001 = false;
               break label153;
            }
         } else {
            var22 = -1740844559 + -1490657482 ^ -100132774;
         }

         label135:
         switch (((var22 - 503757383 ^ 362087326 ^ 1727582651) - 853697046 ^ 453282987) - 2008258821) {
            case 462945427:
               ObjectIterator var6;
               try {
                  class_3558 var2 = (class_3558)0<"JNT",209230708,"\uec1c\uec18\uf68f氚\uec1d氘\uec15\uec3e\uec20\uec20氡氿","\udc46\ude86\ue0a6\ue016\ue106\udcb6\ue096\ue056\ue0a6\ue016\udff6\ue0e6\udfd6\ue026\ue106\udcb6\udff6\ue086\udfd6\ue0f6\ue0f6\udfb6\udcd6\udd56\udd06\udd06\udd76\udc56\ude86\ue0a6\ue016\ue106\udcb6\ue096\ue056\ue0a6\ue016\udff6\ue0e6\udfd6\ue026\ue106\udcb6\udff6\ue086\udfd6\ue0f6\ue0f6\udfb6\udcf6\udd16\udd26\udce6\udd76","䟬䞤䠜䗬䟤䟄䟬䞤䞔䠌䞄䞬䠜䗬䞔䟜䞄䠔䠔䝴䘔䘤䘬䘼",-683702500>(
                     0<"JNT",209230708,"\uec1c\uec18\uf68f氚\uec1d氘\uec15氿氿\uec3f\uec3f氡","\udc46\udc56\ude86\ue0a6\ue016\ue106\udcb6\ue096\ue056\ue0a6\ue016\udff6\ue0e6\udfd6\ue026\ue106\udcb6\udff6\ue086\udfd6\ue0f6\ue0f6\udfb6\udcf6\udd16\udd26\udd46\udd76","䟬䞤䠜䗬䟤䟄䟬䞤䞔䠌䞄䞬䠜䗬䞔䟜䞄䠔䠔䝴䘬䘔䘼",-683702306>(
                        1<"JNT",-1866065875,"舕舙舉苭舍舱臹臕臝臑","恭杭噭\u206d彭孭恭杭敭呭捭桭噭\u206d敭幭捭啭啭煭ᕭ፭ቭ","ՀԠીẀᶠ⏀٠ẠᴠẀᶠᷠ␀†ᶀ⏀٠ᷠỀ†⏠⏠\u2060\u0b80\u0be0ୀೠ",-2091256054>(
                           1<"JNT",-1866065875,"苭苅","幭晭","ՀԠીẀᶠ⏀٠ẠᴠẀᶠᷠ␀†ᶀ⏀٠ᷠỀ†⏠⏠\u2060\u0be0ؠـೠ",-2091256049>(this)
                        )
                     ),
                     1<"JNT",-583573823,"舕舙舉苭舍舱臙臅臝臅","恭杭噭\u206d彭孭恭杭敭呭捭桭噭\u206d敭幭捭啭啭煭፭୭᙭᙭","ՀԠીẀᶠ⏀٠ẠᴠẀᶠᷠ␀†ᶀ⏀٠ᷠỀ†⏠⏠\u2060ؠଠீீೠ",-2091256052>()
                  );
                  class_3560 var3 = 0<"JNT",-805733157,"\uec19\uec18\uf68f氬\uec1a\uec19氚\uf68f\uec2f\uf68f\uec1d氟\uec16\uec19\uec18","\udc46\udc56\ude86\ue0a6\ue016\ue106\udcb6\ue096\ue056\ue0a6\ue016\udff6\ue0e6\udfd6\ue026\ue106\udcb6\udff6\ue086\udfd6\ue0f6\ue0f6\udfb6\udcf6\udd16\udd26\udcc6\udd76","䞜䞤䠬䗬䟔䠌䡄䟼䠜䟴䟬䗬䟤䟄䠼䟄䟬䗬䚔䞼䠤䟬䟔䛜䟄䞴䞼䠜䛼䠌䟴䠬䟄䞜䞤䠌䚄䞔䞔䞤䠔䠔䟴䠌",-683702501>(
                     (ChunkLightProviderAccessor)var2
                  );
                  class_3556 var4 = 0<"JNT",-805733157,"\uec19\uec18\uf68f\uec2f\uf68f\uec1d氟\uec16\uec19\uec18","\udc46\udc56\ude86\ue0a6\ue016\ue106\udcb6\ue096\ue056\ue0a6\ue016\udff6\ue0e6\udfd6\ue026\ue106\udcb6\udff6\ue086\udfd6\ue0f6\ue0f6\udfb6\udcf6\udd16\udd16\udd26\udd76","䞜䞤䠬䗬䟔䠌䡄䟼䠜䟴䟬䗬䟤䟄䠼䟄䟬䗬䛜䟄䞴䞼䠜䜔䠜䟴䠌䞄䞴䞤䚄䞔䞔䞤䠔䠔䟴䠌",-683702502>(
                     (LightStorageAccessor)var3
                  );
                  Long2ObjectOpenHashMap var5 = 0<"JNT",-805733157,"\uec19\uec18\uf68f\uec26氟氟\uec16皂\uec1f","\udc46\udc56\ude86\ue056\ue106\udcb6\ue116\ue0a6\ue056\ue096\ue056\udcb6\ue006\ue0f6\ue056\udcb6\ue026\udfd6\ue0f6\ue106\ue116\ue106\ue056\ue086\udcb6\ue086\ue0b6\ue0a6\ue036\ue0f6\udcb6\ude86\ue0b6\ue0a6\ue036\udce6\udeb6\udfe6\ue066\ue016\udff6\ue106\udeb6\ue0c6\ue016\ue0a6\ude46\udfd6\ue0f6\ue046\ude96\udfd6\ue0c6\udd76","䞜䞤䠬䗬䟔䠌䡄䟼䠜䟴䟬䗬䟤䟄䠼䟄䟬䗬䚔䞼䠤䟬䟔䜜䟴䛬䟄䞌䞌䟜䞤䚄䠌䠌䞄䡄䛤䞄䟼䚄䞔䞔䞤䠔䠔䟴䠌",-683702503>(
                     (ChunkToNibbleArrayMapAccessor)var4
                  );
                  var6 = 0<"JNT",-805733157,"\uec1a\uf68f\uec18氟\uec16\uf68f\uec1d氟","\udc46\udc56\ude86\ue056\ue106\udcb6\ue116\ue0a6\ue056\ue096\ue056\udcb6\ue006\ue0f6\ue056\udcb6\ue026\udfd6\ue0f6\ue106\ue116\ue106\ue056\ue086\udcb6\ue0b6\udfe6\ue066\ue016\udff6\ue106\ue0f6\udcb6\udeb6\udfe6\ue066\ue016\udff6\ue106\ude56\ue106\ue016\ue0e6\udfd6\ue106\ue0b6\ue0e6\udd76","䟄䠜䗬䠤䟬䟄䟤䟄䗬䞜䠔䟄䗬䞬䞄䠔䠜䠤䠜䟄䟜䗬䟜䟴䟬䞴䠔䗬䛜䟴䟬䞴䘌䛴䞌䟌䞤䞔䠜䛤䞄䟼䖜䚬䞄䠔䠜䚤䟬䠜䠌䡄䜔䞤䠜",-683702297>(
                     0<"JNT",209230708,"氜\uec1d氝\uec19氿\uec2d気氛\uec18\uec17\uf68f\uec28氝\uf68f氟皂\uec2f\uec18\uf68f","\udc46\udc56\ude86\ue056\ue106\udcb6\ue116\ue0a6\ue056\ue096\ue056\udcb6\ue006\ue0f6\ue056\udcb6\ue026\udfd6\ue0f6\ue106\ue116\ue106\ue056\ue086\udcb6\ue086\ue0b6\ue0a6\ue036\ue0f6\udcb6\ude86\ue0b6\ue0a6\ue036\udce6\udeb6\udfe6\ue066\ue016\udff6\ue106\ude96\udfd6\ue0c6\udc06\ude26\udfd6\ue0f6\ue106\ude16\ue0a6\ue106\ue0e6\ue156\udef6\ue016\ue106\udd76","䟄䠜䗬䠤䟬䟄䟤䟄䗬䞜䠔䟄䗬䞬䞄䠔䠜䠤䠜䟄䟜䗬䟜䟴䟬䞴䠔䗬䛜䟴䟬䞴䘌䛴䞌䟌䞤䞔䠜䛴䟼䞤䟬䚼䞄䠔䞼䛤䞄䟼",-683702504>(
                        var5
                     )
                  );
               } catch (Exception var33) {
                  var10000 = var33;
                  boolean var41 = false;
                  break;
               }

               label131:
               while (true) {
                  try {
                     var22 = (370763155 >> 684006670 | -366408416) & -97575434;
                  } catch (Exception var28) {
                     var10000 = var28;
                     boolean var42 = false;
                     break label135;
                  }

                  class_2804 var10;
                  int var12;
                  int var13;
                  int var14;
                  int var15;
                  label128:
                  while (true) {
                     switch (((var22 ^ 909388744) - 437801675 ^ 2056159806) - 25415668 + 592234414 - 1185235971) {
                        case -1817307754:
                        default:
                           try {
                              if (0<"JNT",-805733157,"氚\uec16\uec1f氭\uec18\uf681\uf68f","\udc46\udc56\udf66","䟌䞄䠬䞄䗬䠤䠜䟄䟜䗬䛄䠜䞤䠌䞄䠜䟴䠌",-683702315>(var6)) {
                                 Entry var7 = (Entry)0<"JNT",-805733157,"氝\uec18\uf681\uf68f","\udc46\udc56\ude86\ue066\udfd6\ue126\udfd6\udcb6\ue086\udfd6\ue0a6\ue036\udcb6\udeb6\udfe6\ue066\ue016\udff6\ue106\udd76","䟌䞄䠬䞄䗬䠤䠜䟄䟜䗬䛄䠜䞤䠌䞄䠜䟴䠌",-683702316>(
                                    var6
                                 );
                                 long var8 = 0<"JNT",-805733157,"\uec19\uec18\uf68f氬\uec1d氝\uec19\uec2b\uec18皂","\udc46\udc56\ude66","䟄䠜䗬䠤䟬䟄䟤䟄䗬䞜䠔䟄䗬䞬䞄䠔䠜䠤䠜䟄䟜䗬䟜䟴䟬䞴䠔䗬䛜䟴䟬䞴䘌䛴䞌䟌䞤䞔䠜䛤䞄䟼䖜䚤䟬䠜䠌䡄",-683702317>(
                                    var7
                                 );
                                 var10 = (class_2804)0<"JNT",-805733157,"\uec19\uec18\uf68f民\uec16氜皀\uec18","\udc46\udc56\ude86\ue066\udfd6\ue126\udfd6\udcb6\ue086\udfd6\ue0a6\ue036\udcb6\udeb6\udfe6\ue066\ue016\udff6\ue106\udd76","䟄䠜䗬䠤䟬䟄䟤䟄䗬䞜䠔䟄䗬䞬䞄䠔䠜䠤䠜䟄䟜䗬䟜䟴䟬䞴䠔䗬䛜䟴䟬䞴䘌䛴䞌䟌䞤䞔䠜䛤䞄䟼䖜䚤䟬䠜䠌䡄",-683702318>(
                                    var7
                                 );
                                 if (var10 == null
                                    || 0<"JNT",209230708,"\uec1c\uec18\uf68f氚\uec1d氘\uec15\uec20\uec3e\uec3f氢氾","\udc46\udc56\udf66","䟬䞤䠜䗬䟤䟄䟬䞤䞔䠌䞄䞬䠜䗬䞔䟜䞄䠔䠔䝴䘌䘼䗼䘜",-683702319>(
                                       var10
                                    )) {
                                    continue label131;
                                 }

                                 class_4076 var11 = 0<"JNT",-1063269978,"\uec1c\uec18\uf68f氚\uec1d氘\uec15\uec3e氢氡\uec21\uec21","\udc46\ude66\udc56\ude86\ue0a6\ue016\ue106\udcb6\ue096\ue056\ue0a6\ue016\udff6\ue0e6\udfd6\ue026\ue106\udcb6\udff6\ue086\udfd6\ue0f6\ue0f6\udfb6\udd06\udcc6\udd36\udd26\udd76","䟬䞤䠜䗬䟤䟄䟬䞤䞔䠌䞄䞬䠜䗬䞔䟜䞄䠔䠔䝴䘜䗼䘴䘬",-683702327>(
                                    var8
                                 );
                                 var12 = 0<"JNT",209230708,"\uec1c\uec18\uf68f氚\uec1d氘\uec15\uec3e\uec22\uec20氿\uec21","\udc46\udc56\ude56","䟬䞤䠜䗬䟤䟄䟬䞤䞔䠌䞄䞬䠜䗬䞔䟜䞄䠔䠔䝴䘜䗼䘴䘬",-683702328>(
                                    var11
                                 );
                                 var13 = 0<"JNT",209230708,"\uec1c\uec18\uf68f氚\uec1d氘\uec15\uec3e\uec22\uec20氿氢","\udc46\udc56\ude56","䟬䞤䠜䗬䟤䟄䟬䞤䞔䠌䞄䞬䠜䗬䞔䟜䞄䠔䠔䝴䘜䗼䘴䘬",-683702313>(
                                    var11
                                 );
                                 var14 = 0<"JNT",209230708,"\uec1c\uec18\uf68f氚\uec1d氘\uec15\uec3e\uec22\uec20氿\uec22","\udc46\udc56\ude56","䟬䞤䠜䗬䟤䟄䟬䞤䞔䠌䞄䞬䠜䗬䞔䟜䞄䠔䠔䝴䘜䗼䘴䘬",-683702314>(
                                    var11
                                 );
                                 var15 = 0;
                                 break label128;
                              }
                           } catch (Exception var32) {
                              var10000 = var32;
                              boolean var43 = false;
                              break label135;
                           }

                           var22 = -389349324 + -855622149 ^ 1653671844;
                           break;
                        case -1728122627:
                           return;
                     }
                  }

                  label119:
                  while (true) {
                     try {
                        var22 = -1723042273 >>> -1328613510 ^ 46371079;
                     } catch (Exception var26) {
                        var10000 = var26;
                        boolean var44 = false;
                        break label135;
                     }

                     int var16;
                     while (true) {
                        switch ((var22 - 648508783 ^ 762868207) - 2093430980 + 1101288219 - 1902468464 ^ 859949715) {
                           case -734209562:
                           default:
                              continue label131;
                           case 2006838743:
                        }

                        try {
                           if (var15 < 16) {
                              var16 = 0;
                              break;
                           }

                           var22 = -534471472;
                        } catch (Exception var29) {
                           var10000 = var29;
                           boolean var45 = false;
                           break label135;
                        }
                     }

                     label116:
                     while (true) {
                        try {
                           var22 = 1292650289 << 1292650289 ^ -1778192431;
                        } catch (Exception var25) {
                           var10000 = var25;
                           boolean var46 = false;
                           break label135;
                        }

                        int var17;
                        while (true) {
                           switch (var22 + 1295300502 - 1157538114 + 2129262403 - 464352362 - 630489673 ^ 319662530) {
                              case -705483951:
                              default:
                                 try {
                                    var15++;
                                    continue label119;
                                 } catch (Exception var27) {
                                    var10000 = var27;
                                    boolean var51 = false;
                                    break label135;
                                 }
                              case 1295167351:
                           }

                           try {
                              if (var16 < 16) {
                                 var17 = 0;
                                 break;
                              }

                              var22 = (-1538327205 ^ 952410384 | 18899887) & -513774657;
                           } catch (Exception var30) {
                              var10000 = var30;
                              boolean var47 = false;
                              break label135;
                           }
                        }

                        label113:
                        while (true) {
                           try {
                              var22 = (-728363071 - -1568783559 | -914279913) & -840058249;
                           } catch (Exception var24) {
                              var10000 = var24;
                              boolean var48 = false;
                              break label135;
                           }

                           while (true) {
                              switch (var22 - 496551327 - 1559199484 - 2036555483 - 1052627957 - 93908356 + 704817076) {
                                 case -1153041188:
                                 default:
                                    try {
                                       if (var17 < 16) {
                                          int var18 = 0<"JNT",209230708,"\uec1c\uec18\uf68f氚\uec1d氘\uec15\uec3e氿\uec3e\uec3f\uec22","\udc46\ude56\ude56\ude56\udc56\ude56","䟬䞤䠜䗬䟤䟄䟬䞤䞔䠌䞄䞬䠜䗬䞔䟜䞄䠔䠔䝴䘌䘼䗼䘜",-683702326>(
                                             var10, var15, var16, var17
                                          );
                                          if (var18 != 0) {
                                             float var19 = (float)var18 / 15.0F;
                                             Class_262 var20 = (Class_262)0<"JNT",-52669483,"氤\uec1a氝\uec1a\uf68f氥","\udc46\ude26\ude26\ude26\ude26\udc56\udf26","䟼䠴",-683702298>(
                                                var19, var19, 0.2F, 0.3F
                                             );
                                             class_2338 var21 = (class_2338)0<"JNT",-52669483,"氤\uec1a氝\uec1a\uf68f氥","\udc46\ude56\ude56\ude56\udc56\udf26","䟬䞤䠜䗬䟤䟄䟬䞤䞔䠌䞄䞬䠜䗬䞔䟜䞄䠔䠔䝴䘌䘔䘔䘼",-683702299>(
                                                var12 + var15, var13 + var16, var14 + var17
                                             );
                                             if (0<"JNT",209230708,"\uec1c\uec18\uf68f氚\uec1d氘\uec15\uec3e氾氿氡氠","\udc46\udc56\ude56","䟬䞤䠜䗬䟤䟄䟬䞤䞔䠌䞄䞬䠜䗬䞔䟜䞄䠔䠔䝴䘌䘔䘔䘼",-683702300>(
                                                   var21
                                                )
                                                < 0) {
                                                0<"JNT",209230708,"\uf680\uec1e\uec1d","\udc46\ude06\ude06\ude06\ude06\ude06\ude06\ude86\ue0c6\ue136\udd76\ude86\ue0c6\ue136\udd76\ude86\ue106\ue106\udd76\ude56\udc56\udf26","䞴䟼䡌",-683702325>(
                                                   1<"JNT",-1866065875,"苝舝舙","奭䭭","ՀԠીᵠṀ─ೠ",-2091256162>(var1),
                                                   (double)0<"JNT",209230708,"\uec1c\uec18\uf68f氚\uec1d氘\uec15\uec3e氾氿氡\uec3f","\udc46\udc56\ude56","䟬䞤䠜䗬䟤䟄䟬䞤䞔䠌䞄䞬䠜䗬䞔䟜䞄䠔䠔䝴䘌䘔䘔䘼",-683702334>(
                                                      var21
                                                   ),
                                                   (double)0<"JNT",209230708,"\uec1c\uec18\uf68f氚\uec1d氘\uec15\uec3e氾氿氡氠","\udc46\udc56\ude56","䟬䞤䠜䗬䟤䟄䟬䞤䞔䠌䞄䞬䠜䗬䞔䟜䞄䠔䠔䝴䘌䘔䘔䘼",-683702335>(
                                                      var21
                                                   ),
                                                   (double)0<"JNT",209230708,"\uec1c\uec18\uf68f氚\uec1d氘\uec15\uec3e氾氿氡氾","\udc46\udc56\ude56","䟬䞤䠜䗬䟤䟄䟬䞤䞔䠌䞄䞬䠜䗬䞔䟜䞄䠔䠔䝴䘌䘔䘔䘼",-683702336>(
                                                      var21
                                                   ),
                                                   (double)(
                                                      0<"JNT",209230708,"\uec1c\uec18\uf68f氚\uec1d氘\uec15\uec3e氾氿氡\uec3f","\udc46\udc56\ude56","䟬䞤䠜䗬䟤䟄䟬䞤䞔䠌䞄䞬䠜䗬䞔䟜䞄䠔䠔䝴䘌䘔䘔䘼",-683702321>(
                                                            var21
                                                         )
                                                         + 1
                                                   ),
                                                   (double)(
                                                      0<"JNT",209230708,"\uec1c\uec18\uf68f氚\uec1d氘\uec15\uec3e氾氿氡氠","\udc46\udc56\ude56","䟬䞤䠜䗬䟤䟄䟬䞤䞔䠌䞄䞬䠜䗬䞔䟜䞄䠔䠔䝴䘌䘔䘔䘼",-683702322>(
                                                            var21
                                                         )
                                                         + 1
                                                   ),
                                                   (double)(
                                                      0<"JNT",209230708,"\uec1c\uec18\uf68f氚\uec1d氘\uec15\uec3e氾氿氡氾","\udc46\udc56\ude56","䟬䞤䠜䗬䟤䟄䟬䞤䞔䠌䞄䞬䠜䗬䞔䟜䞄䠔䠔䝴䘌䘔䘔䘼",-683702323>(
                                                            var21
                                                         )
                                                         + 1
                                                   ),
                                                   var20,
                                                   var20,
                                                   1<"JNT",-583573823,"苡舑","噭噭","ՀԠી⏀⏀ೠ",-2091256037>(),
                                                   0
                                                );
                                             }
                                          }

                                          var17++;
                                          continue label113;
                                       }

                                       var22 = -1582075326 & 1475235317 ^ 785481292;
                                       break;
                                    } catch (Exception var31) {
                                       var10000 = var31;
                                       boolean var50 = false;
                                       break label135;
                                    }
                                 case 557023441:
                                    try {
                                       var16++;
                                       continue label116;
                                    } catch (Exception var23) {
                                       var10000 = var23;
                                       boolean var49 = false;
                                       break label135;
                                    }
                              }
                           }
                        }
                     }
                  }
               }
            case 1114651985:
            default:
               return;
         }
      }

      Exception var35 = var10000;
      0<"JNT",209230708,"氞氟\uec1a氝\uf68f\uec2f\uf68f\uec16\uec17\uec1b氐氟\uec16\uec17\uec18","\udc46\udc56\udf26","䟌䞄䠬䞄䗬䟜䞄䟬䞴䗬䚤䠼䞔䞤䟼䠜䟄䟴䟬",-683702301>(var35);
   }

   // $VF: renamed from: 0 (java.lang.invoke.MethodHandles.Lookup, java.lang.String, java.lang.invoke.MethodType, java.lang.Object[]) java.lang.Object
   public static Object method_1413(Lookup var0, String var1, MethodType var2, Object... var3) {
      int var10 = (Integer)var3[4];
      int var10001 = ((var10 ^ 1525535397 ^ 575087421) + 1589386938 ^ 228855903) - 513333120 + 309642219 - 105299192 + 2098869322 + 1770132960;
      MethodHandle var10000 = field_2040[((var10 ^ 1525535397 ^ 575087421) + 1589386938 ^ 228855903)
         - 513333120
         + 309642219
         - 105299192
         + 2098869322
         + 1770132960
         + 668533026];
      if (field_2040[var10001 + 668533026] == null) {
         int var4 = (Integer)var3[0];
         StringBuilder var13 = new StringBuilder((String)var3[1]);

         for (int var23 = -1216647787 >>> 1163163343 ^ 93942; var23 < var13.length(); var23 += (-325133951 ^ 75059 | 1) & 18874689) {
            char var42 = var13.charAt(var23);
            char var49 = (char)(
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
                                                                                                ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534)
                                                                                                      >> 1
                                                                                                   | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83)
                                                                                                      << 15
                                                                                             )
                                                                                             & 32768
                                                                                       )
                                                                                       >> 15
                                                                                    | (
                                                                                          ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                             | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                       )
                                                                                       << 1
                                                                              )
                                                                              & 65528
                                                                        )
                                                                        >> 3
                                                                     | (
                                                                           (
                                                                                    (
                                                                                          ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                             | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                       )
                                                                                       & 32768
                                                                                 )
                                                                                 >> 15
                                                                              | (
                                                                                    ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                       | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                 )
                                                                                 << 1
                                                                        )
                                                                        << 13
                                                               )
                                                               & 65520
                                                         )
                                                         >> 4
                                                      | (
                                                            (
                                                                     (
                                                                           (
                                                                                    (
                                                                                          ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                             | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                       )
                                                                                       & 32768
                                                                                 )
                                                                                 >> 15
                                                                              | (
                                                                                    ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                       | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                 )
                                                                                 << 1
                                                                        )
                                                                        & 65528
                                                                  )
                                                                  >> 3
                                                               | (
                                                                     (
                                                                              (
                                                                                    ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                       | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                 )
                                                                                 & 32768
                                                                           )
                                                                           >> 15
                                                                        | (
                                                                              ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                 | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                           )
                                                                           << 1
                                                                  )
                                                                  << 13
                                                         )
                                                         << 12
                                                )
                                                & 65534
                                          )
                                          >> 1
                                       | (
                                             (
                                                      (
                                                            (
                                                                     (
                                                                           (
                                                                                    (
                                                                                          ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                             | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                       )
                                                                                       & 32768
                                                                                 )
                                                                                 >> 15
                                                                              | (
                                                                                    ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                       | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                 )
                                                                                 << 1
                                                                        )
                                                                        & 65528
                                                                  )
                                                                  >> 3
                                                               | (
                                                                     (
                                                                              (
                                                                                    ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                       | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                 )
                                                                                 & 32768
                                                                           )
                                                                           >> 15
                                                                        | (
                                                                              ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                 | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                           )
                                                                           << 1
                                                                  )
                                                                  << 13
                                                         )
                                                         & 65520
                                                   )
                                                   >> 4
                                                | (
                                                      (
                                                               (
                                                                     (
                                                                              (
                                                                                    ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                       | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                 )
                                                                                 & 32768
                                                                           )
                                                                           >> 15
                                                                        | (
                                                                              ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                 | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                           )
                                                                           << 1
                                                                  )
                                                                  & 65528
                                                            )
                                                            >> 3
                                                         | (
                                                               (
                                                                        (
                                                                              ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                 | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                           )
                                                                           & 32768
                                                                     )
                                                                     >> 15
                                                                  | (
                                                                        ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                           | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                     )
                                                                     << 1
                                                            )
                                                            << 13
                                                   )
                                                   << 12
                                          )
                                          << 15
                                 )
                                 & 65528
                           )
                           >> 3
                        | (
                              (
                                       (
                                             (
                                                      (
                                                            (
                                                                     (
                                                                           (
                                                                                    (
                                                                                          ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                             | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                       )
                                                                                       & 32768
                                                                                 )
                                                                                 >> 15
                                                                              | (
                                                                                    ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                       | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                 )
                                                                                 << 1
                                                                        )
                                                                        & 65528
                                                                  )
                                                                  >> 3
                                                               | (
                                                                     (
                                                                              (
                                                                                    ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                       | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                 )
                                                                                 & 32768
                                                                           )
                                                                           >> 15
                                                                        | (
                                                                              ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                 | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                           )
                                                                           << 1
                                                                  )
                                                                  << 13
                                                         )
                                                         & 65520
                                                   )
                                                   >> 4
                                                | (
                                                      (
                                                               (
                                                                     (
                                                                              (
                                                                                    ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                       | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                 )
                                                                                 & 32768
                                                                           )
                                                                           >> 15
                                                                        | (
                                                                              ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                 | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                           )
                                                                           << 1
                                                                  )
                                                                  & 65528
                                                            )
                                                            >> 3
                                                         | (
                                                               (
                                                                        (
                                                                              ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                 | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                           )
                                                                           & 32768
                                                                     )
                                                                     >> 15
                                                                  | (
                                                                        ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                           | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                     )
                                                                     << 1
                                                            )
                                                            << 13
                                                   )
                                                   << 12
                                          )
                                          & 65534
                                    )
                                    >> 1
                                 | (
                                       (
                                                (
                                                      (
                                                               (
                                                                     (
                                                                              (
                                                                                    ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                       | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                 )
                                                                                 & 32768
                                                                           )
                                                                           >> 15
                                                                        | (
                                                                              ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                 | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                           )
                                                                           << 1
                                                                  )
                                                                  & 65528
                                                            )
                                                            >> 3
                                                         | (
                                                               (
                                                                        (
                                                                              ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                 | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                           )
                                                                           & 32768
                                                                     )
                                                                     >> 15
                                                                  | (
                                                                        ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                           | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                     )
                                                                     << 1
                                                            )
                                                            << 13
                                                   )
                                                   & 65520
                                             )
                                             >> 4
                                          | (
                                                (
                                                         (
                                                               (
                                                                        (
                                                                              ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                 | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                           )
                                                                           & 32768
                                                                     )
                                                                     >> 15
                                                                  | (
                                                                        ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                           | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                     )
                                                                     << 1
                                                            )
                                                            & 65528
                                                      )
                                                      >> 3
                                                   | (
                                                         (
                                                                  (
                                                                        ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                           | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                     )
                                                                     & 32768
                                                               )
                                                               >> 15
                                                            | (
                                                                  ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                     | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                               )
                                                               << 1
                                                      )
                                                      << 13
                                             )
                                             << 12
                                    )
                                    << 15
                           )
                           << 13
                  )
                  + 116
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
                                                                              (
                                                                                    (
                                                                                             (
                                                                                                   (
                                                                                                            (
                                                                                                                  ((var42 & '\ufff0') >> 4 | var42 << '\f')
                                                                                                                        + 235
                                                                                                                     ^ 83
                                                                                                               )
                                                                                                               & 65534
                                                                                                         )
                                                                                                         >> 1
                                                                                                      | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83)
                                                                                                         << 15
                                                                                                )
                                                                                                & 32768
                                                                                          )
                                                                                          >> 15
                                                                                       | (
                                                                                             ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534)
                                                                                                   >> 1
                                                                                                | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                          )
                                                                                          << 1
                                                                                 )
                                                                                 & 65528
                                                                           )
                                                                           >> 3
                                                                        | (
                                                                              (
                                                                                       (
                                                                                             ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534)
                                                                                                   >> 1
                                                                                                | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                          )
                                                                                          & 32768
                                                                                    )
                                                                                    >> 15
                                                                                 | (
                                                                                       ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                          | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                    )
                                                                                    << 1
                                                                           )
                                                                           << 13
                                                                  )
                                                                  & 65520
                                                            )
                                                            >> 4
                                                         | (
                                                               (
                                                                        (
                                                                              (
                                                                                       (
                                                                                             ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534)
                                                                                                   >> 1
                                                                                                | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                          )
                                                                                          & 32768
                                                                                    )
                                                                                    >> 15
                                                                                 | (
                                                                                       ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                          | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                    )
                                                                                    << 1
                                                                           )
                                                                           & 65528
                                                                     )
                                                                     >> 3
                                                                  | (
                                                                        (
                                                                                 (
                                                                                       ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                          | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                    )
                                                                                    & 32768
                                                                              )
                                                                              >> 15
                                                                           | (
                                                                                 ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                    | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                              )
                                                                              << 1
                                                                     )
                                                                     << 13
                                                            )
                                                            << 12
                                                   )
                                                   & 65534
                                             )
                                             >> 1
                                          | (
                                                (
                                                         (
                                                               (
                                                                        (
                                                                              (
                                                                                       (
                                                                                             ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534)
                                                                                                   >> 1
                                                                                                | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                          )
                                                                                          & 32768
                                                                                    )
                                                                                    >> 15
                                                                                 | (
                                                                                       ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                          | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                    )
                                                                                    << 1
                                                                           )
                                                                           & 65528
                                                                     )
                                                                     >> 3
                                                                  | (
                                                                        (
                                                                                 (
                                                                                       ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                          | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                    )
                                                                                    & 32768
                                                                              )
                                                                              >> 15
                                                                           | (
                                                                                 ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                    | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                              )
                                                                              << 1
                                                                     )
                                                                     << 13
                                                            )
                                                            & 65520
                                                      )
                                                      >> 4
                                                   | (
                                                         (
                                                                  (
                                                                        (
                                                                                 (
                                                                                       ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                          | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                    )
                                                                                    & 32768
                                                                              )
                                                                              >> 15
                                                                           | (
                                                                                 ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                    | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                              )
                                                                              << 1
                                                                     )
                                                                     & 65528
                                                               )
                                                               >> 3
                                                            | (
                                                                  (
                                                                           (
                                                                                 ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                    | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                              )
                                                                              & 32768
                                                                        )
                                                                        >> 15
                                                                     | (
                                                                           ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                              | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                        )
                                                                        << 1
                                                               )
                                                               << 13
                                                      )
                                                      << 12
                                             )
                                             << 15
                                    )
                                    & 65528
                              )
                              >> 3
                           | (
                                 (
                                          (
                                                (
                                                         (
                                                               (
                                                                        (
                                                                              (
                                                                                       (
                                                                                             ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534)
                                                                                                   >> 1
                                                                                                | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                          )
                                                                                          & 32768
                                                                                    )
                                                                                    >> 15
                                                                                 | (
                                                                                       ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                          | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                    )
                                                                                    << 1
                                                                           )
                                                                           & 65528
                                                                     )
                                                                     >> 3
                                                                  | (
                                                                        (
                                                                                 (
                                                                                       ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                          | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                    )
                                                                                    & 32768
                                                                              )
                                                                              >> 15
                                                                           | (
                                                                                 ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                    | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                              )
                                                                              << 1
                                                                     )
                                                                     << 13
                                                            )
                                                            & 65520
                                                      )
                                                      >> 4
                                                   | (
                                                         (
                                                                  (
                                                                        (
                                                                                 (
                                                                                       ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                          | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                    )
                                                                                    & 32768
                                                                              )
                                                                              >> 15
                                                                           | (
                                                                                 ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                    | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                              )
                                                                              << 1
                                                                     )
                                                                     & 65528
                                                               )
                                                               >> 3
                                                            | (
                                                                  (
                                                                           (
                                                                                 ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                    | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                              )
                                                                              & 32768
                                                                        )
                                                                        >> 15
                                                                     | (
                                                                           ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                              | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                        )
                                                                        << 1
                                                               )
                                                               << 13
                                                      )
                                                      << 12
                                             )
                                             & 65534
                                       )
                                       >> 1
                                    | (
                                          (
                                                   (
                                                         (
                                                                  (
                                                                        (
                                                                                 (
                                                                                       ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                          | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                                    )
                                                                                    & 32768
                                                                              )
                                                                              >> 15
                                                                           | (
                                                                                 ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                    | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                              )
                                                                              << 1
                                                                     )
                                                                     & 65528
                                                               )
                                                               >> 3
                                                            | (
                                                                  (
                                                                           (
                                                                                 ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                    | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                              )
                                                                              & 32768
                                                                        )
                                                                        >> 15
                                                                     | (
                                                                           ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                              | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                        )
                                                                        << 1
                                                               )
                                                               << 13
                                                      )
                                                      & 65520
                                                )
                                                >> 4
                                             | (
                                                   (
                                                            (
                                                                  (
                                                                           (
                                                                                 ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                                    | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                              )
                                                                              & 32768
                                                                        )
                                                                        >> 15
                                                                     | (
                                                                           ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                              | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                        )
                                                                        << 1
                                                               )
                                                               & 65528
                                                         )
                                                         >> 3
                                                      | (
                                                            (
                                                                     (
                                                                           ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                              | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                        )
                                                                        & 32768
                                                                  )
                                                                  >> 15
                                                               | (
                                                                     ((((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) & 65534) >> 1
                                                                        | (((var42 & '\ufff0') >> 4 | var42 << '\f') + 235 ^ 83) << 15
                                                                  )
                                                                  << 1
                                                         )
                                                         << 13
                                                )
                                                << 12
                                       )
                                       << 15
                              )
                              << 13
                     )
                     + 116
               )
            );
         }

         String var5 = var13.toString();
         StringBuilder var16 = new StringBuilder((String)var3[2]);

         for (int var29 = 299923016 + 1615757246 ^ 1915680262; var29 < var16.length(); var29 += 2115414883 >>> 2115414883 ^ 264426861) {
            int var54 = var16.charAt(var29) - 152;
            int var99 = (var54 & 61440) >> 12;
            int var55 = (var54 & 61440) >> 12 | var54 << 4;
            int var100 = (((var54 & 61440) >> 12 | var54 << 4) & 65024) >> 9;
            var54 = ((var99 | var54 << 4) & 65024) >> 9 | ((var54 & 61440) >> 12 | var54 << 4) << 7;
            var99 = ((var100 | var55 << 7) & 65535) >> 0;
            int var57 = (((var100 | var55 << 7) & 65535) >> 0 | var54 << 16) - 23;
            int var102 = ((((var100 | var55 << 7) & 65535) >> 0 | var54 << 16) - 23 & 65504) >> 5;
            var54 = (((var99 | var54 << 16) - 23 & 65504) >> 5 | (((var100 | var55 << 7) & 65535) >> 0 | var54 << 16) - 23 << 11) + 78;
            var99 = ((var102 | var57 << 11) + 78 & 49152) >> 14;
            int var59 = ((var102 | var57 << 11) + 78 & 49152) >> 14 | var54 << 2;
            int var104 = ((((var102 | var57 << 11) + 78 & 49152) >> 14 | var54 << 2) & 61440) >> 12;
            char var60 = (char)((((var99 | var54 << 2) & 61440) >> 12 | (((var102 | var57 << 11) + 78 & 49152) >> 14 | var54 << 2) << 4) - 229);
            var16.setCharAt(var29, (char)((var104 | var59 << 4) - 229));
         }

         MethodType var6 = MethodType.fromMethodDescriptorString(var16.toString(), Class_178.class.getClassLoader());
         StringBuilder var19 = new StringBuilder((String)var3[3]);

         for (int var35 = (-530334727 ^ -606873011 | 0) & -1073308597; var35 < var19.length(); var35 += (1446099186 + -1159224329 | 1) & 1076109317) {
            int var65 = var19.charAt(var35) + 199 - 212 + 158 + 19;
            char var68 = (char)(
               (((((var65 & 65528) >> 3 | var65 << 13) + 57 - 29 & 65504) >> 5 | ((var65 & 65528) >> 3 | var65 << 13) + 57 - 29 << 11) - 70 & 63488) >> 11
                  | ((((var65 & 65528) >> 3 | var65 << 13) + 57 - 29 & 65504) >> 5 | ((var65 & 65528) >> 3 | var65 << 13) + 57 - 29 << 11) - 70 << 5
            );
            var19.setCharAt(
               var35,
               (char)(
                  (((((var65 & 65528) >> 3 | var65 << 13) + 57 - 29 & 65504) >> 5 | ((var65 & 65528) >> 3 | var65 << 13) + 57 - 29 << 11) - 70 & 63488) >> 11
                     | ((((var65 & 65528) >> 3 | var65 << 13) + 57 - 29 & 65504) >> 5 | ((var65 & 65528) >> 3 | var65 << 13) + 57 - 29 << 11) - 70 << 5
               )
            );
         }

         Class var7 = Class.forName(var19.toString(), false, Class_178.class.getClassLoader());
         switch ((var4 + 642371956 - 1781258862 + 825145058 - 278107637 ^ 255759569) + 1410991670 + 589164116 - 207996435 + 698953305 - 378497369) {
            case 273836223:
               var10000 = var0.findStatic(var7, var5, var6);
               break;
            case 527984184:
               var10000 = var0.findSpecial(var7, var5, var6, Class_178.class);
               break;
            case 561509270:
            case 1677400877:
               var10000 = var0.findVirtual(var7, var5, var6);
               break;
            case 1419244176:
               var10000 = var0.findConstructor(var7, var6);
               break;
            default:
               throw new UnsupportedOperationException("Unsupported handle type!");
         }
      }

      field_2040[((var10 ^ 1525535397 ^ 575087421) + 1589386938 ^ 228855903) - 513333120 + 309642219 - 105299192 + 2098869322 + 1770132960 + 668533026] = var10000;
      MethodHandle var11 = var10000.asType(var2);
      return new MutableCallSite(var11);
   }

   // $VF: renamed from: 1 (java.lang.invoke.MethodHandles.Lookup, java.lang.String, java.lang.invoke.MethodType, java.lang.Object[]) java.lang.Object
   public static Object method_1414(Lookup var0, String var1, MethodType var2, Object... var3) {
      boolean var11 = false;
      int var10 = (Integer)var3[4];
      int var10001 = (var10 + 1530578339 ^ 436484206 ^ 48114515) - 1916942131 - 38494338 - 458427885 - 1867366769 - 37386993 + 2061569304;
      MethodHandle var10000 = field_2040[(var10 + 1530578339 ^ 436484206 ^ 48114515)
         - 1916942131
         - 38494338
         - 458427885
         - 1867366769
         - 37386993
         + 2061569304
         - 1069996679];
      if (field_2040[var10001 - 1069996679] == null) {
         int var4 = (Integer)var3[0];
         StringBuilder var14 = new StringBuilder((String)var3[1]);

         for (int var24 = (680749603 << (-407881236 & 680749603 & -407881236) | 0) & -771488684;
            var24 < var14.length();
            var24 += 758841701 << -1546401230 ^ 93585409
         ) {
            int var43 = var14.charAt(var24) ^ 'f';
            int var10004 = (var43 & 0) >> 16;
            int var44 = (var43 & 0) >> 16 | var43 << 0;
            int var90 = (((var43 & 0) >> 16 | var43 << 0) & 65535) >> 0;
            var43 = (((var10004 | var43 << 0) & 65535) >> 0 | ((var43 & 0) >> 16 | var43 << 0) << 16) - 130;
            var10004 = ((var90 | var44 << 16) - 130 & 32768) >> 15;
            int var46 = (((var90 | var44 << 16) - 130 & 32768) >> 15 | var43 << 1) - 63 - 116;
            int var92 = ((((var90 | var44 << 16) - 130 & 32768) >> 15 | var43 << 1) - 63 - 116 & 65532) >> 2;
            var43 = ((var10004 | var43 << 1) - 63 - 116 & 65532) >> 2 | (((var90 | var44 << 16) - 130 & 32768) >> 15 | var43 << 1) - 63 - 116 << 14;
            var10004 = ((var92 | var46 << 14) & 65528) >> 3;
            int var48 = ((var92 | var46 << 14) & 65528) >> 3 | var43 << 13;
            int var94 = ((((var92 | var46 << 14) & 65528) >> 3 | var43 << 13) & 49152) >> 14;
            char var49 = (char)(((var10004 | var43 << 13) & 49152) >> 14 | (((var92 | var46 << 14) & 65528) >> 3 | var43 << 13) << 2);
            var14.setCharAt(var24, (char)(var94 | var48 << 2));
         }

         String var5 = var14.toString();
         StringBuilder var17 = new StringBuilder((String)var3[2]);

         for (int var30 = (-1766143603 + 1436898570 | 0) & 327360840; var30 < var17.length(); var30 += (-79015219 >>> 1581582293 | 1) & -2122190815) {
            int var54 = var17.charAt(var30) - 6;
            char var59 = (char)(
               (
                        (
                              (
                                    (
                                             (
                                                      (
                                                               (
                                                                        (((var54 & 65520) >> 4 | var54 << 12) - 235 & 61440) >> 12
                                                                           | ((var54 & 65520) >> 4 | var54 << 12) - 235 << 4
                                                                     )
                                                                     + 74
                                                                  & 64512
                                                            )
                                                            >> 10
                                                         | (
                                                                  (((var54 & 65520) >> 4 | var54 << 12) - 235 & 61440) >> 12
                                                                     | ((var54 & 65520) >> 4 | var54 << 12) - 235 << 4
                                                               )
                                                               + 74
                                                            << 6
                                                   )
                                                   - 63
                                                & 65535
                                          )
                                          >> 0
                                       | (
                                                (
                                                         (
                                                                  (((var54 & 65520) >> 4 | var54 << 12) - 235 & 61440) >> 12
                                                                     | ((var54 & 65520) >> 4 | var54 << 12) - 235 << 4
                                                               )
                                                               + 74
                                                            & 64512
                                                      )
                                                      >> 10
                                                   | (
                                                            (((var54 & 65520) >> 4 | var54 << 12) - 235 & 61440) >> 12
                                                               | ((var54 & 65520) >> 4 | var54 << 12) - 235 << 4
                                                         )
                                                         + 74
                                                      << 6
                                             )
                                             - 63
                                          << 16
                                 )
                                 ^ 14
                           )
                           & 49152
                     )
                     >> 14
                  | (
                        (
                              (
                                       (
                                                (
                                                         (
                                                                  (((var54 & 65520) >> 4 | var54 << 12) - 235 & 61440) >> 12
                                                                     | ((var54 & 65520) >> 4 | var54 << 12) - 235 << 4
                                                               )
                                                               + 74
                                                            & 64512
                                                      )
                                                      >> 10
                                                   | (
                                                            (((var54 & 65520) >> 4 | var54 << 12) - 235 & 61440) >> 12
                                                               | ((var54 & 65520) >> 4 | var54 << 12) - 235 << 4
                                                         )
                                                         + 74
                                                      << 6
                                             )
                                             - 63
                                          & 65535
                                    )
                                    >> 0
                                 | (
                                          (
                                                   (
                                                            (((var54 & 65520) >> 4 | var54 << 12) - 235 & 61440) >> 12
                                                               | ((var54 & 65520) >> 4 | var54 << 12) - 235 << 4
                                                         )
                                                         + 74
                                                      & 64512
                                                )
                                                >> 10
                                             | ((((var54 & 65520) >> 4 | var54 << 12) - 235 & 61440) >> 12 | ((var54 & 65520) >> 4 | var54 << 12) - 235 << 4)
                                                   + 74
                                                << 6
                                       )
                                       - 63
                                    << 16
                           )
                           ^ 14
                     )
                     << 2
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
                                                                           (((var54 & 65520) >> 4 | var54 << 12) - 235 & 61440) >> 12
                                                                              | ((var54 & 65520) >> 4 | var54 << 12) - 235 << 4
                                                                        )
                                                                        + 74
                                                                     & 64512
                                                               )
                                                               >> 10
                                                            | (
                                                                     (((var54 & 65520) >> 4 | var54 << 12) - 235 & 61440) >> 12
                                                                        | ((var54 & 65520) >> 4 | var54 << 12) - 235 << 4
                                                                  )
                                                                  + 74
                                                               << 6
                                                      )
                                                      - 63
                                                   & 65535
                                             )
                                             >> 0
                                          | (
                                                   (
                                                            (
                                                                     (((var54 & 65520) >> 4 | var54 << 12) - 235 & 61440) >> 12
                                                                        | ((var54 & 65520) >> 4 | var54 << 12) - 235 << 4
                                                                  )
                                                                  + 74
                                                               & 64512
                                                         )
                                                         >> 10
                                                      | (
                                                               (((var54 & 65520) >> 4 | var54 << 12) - 235 & 61440) >> 12
                                                                  | ((var54 & 65520) >> 4 | var54 << 12) - 235 << 4
                                                            )
                                                            + 74
                                                         << 6
                                                )
                                                - 63
                                             << 16
                                    )
                                    ^ 14
                              )
                              & 49152
                        )
                        >> 14
                     | (
                           (
                                 (
                                          (
                                                   (
                                                            (
                                                                     (((var54 & 65520) >> 4 | var54 << 12) - 235 & 61440) >> 12
                                                                        | ((var54 & 65520) >> 4 | var54 << 12) - 235 << 4
                                                                  )
                                                                  + 74
                                                               & 64512
                                                         )
                                                         >> 10
                                                      | (
                                                               (((var54 & 65520) >> 4 | var54 << 12) - 235 & 61440) >> 12
                                                                  | ((var54 & 65520) >> 4 | var54 << 12) - 235 << 4
                                                            )
                                                            + 74
                                                         << 6
                                                )
                                                - 63
                                             & 65535
                                       )
                                       >> 0
                                    | (
                                             (
                                                      (
                                                               (((var54 & 65520) >> 4 | var54 << 12) - 235 & 61440) >> 12
                                                                  | ((var54 & 65520) >> 4 | var54 << 12) - 235 << 4
                                                            )
                                                            + 74
                                                         & 64512
                                                   )
                                                   >> 10
                                                | ((((var54 & 65520) >> 4 | var54 << 12) - 235 & 61440) >> 12 | ((var54 & 65520) >> 4 | var54 << 12) - 235 << 4)
                                                      + 74
                                                   << 6
                                          )
                                          - 63
                                       << 16
                              )
                              ^ 14
                        )
                        << 2
               )
            );
         }

         Class var6 = Class.forName(var17.toString(), false, Class_178.class.getClassLoader());
         StringBuilder var20 = new StringBuilder((String)var3[3]);

         for (int var36 = (733017910 - -1456115434 | 0) & 1283741777; var36 < var20.length(); var36 += (550055081 - -776561762 | 0) & 805645921) {
            char var64 = var20.charAt(var36);
            char var67 = (char)(
               ((((((var64 & '￼') >> 2 | var64 << 14) & 65532) >> 2 | ((var64 & '￼') >> 2 | var64 << 14) << 14) - 82 ^ 174) + 13 - 218 + 133 + 27 - 47 & 65534)
                     >> 1
                  | (((((var64 & '￼') >> 2 | var64 << 14) & 65532) >> 2 | ((var64 & '￼') >> 2 | var64 << 14) << 14) - 82 ^ 174) + 13 - 218 + 133 + 27 - 47
                     << 15
            );
            var20.setCharAt(
               var36,
               (char)(
                  (
                           (((((var64 & '￼') >> 2 | var64 << 14) & 65532) >> 2 | ((var64 & '￼') >> 2 | var64 << 14) << 14) - 82 ^ 174)
                                 + 13
                                 - 218
                                 + 133
                                 + 27
                                 - 47
                              & 65534
                        )
                        >> 1
                     | (((((var64 & '￼') >> 2 | var64 << 14) & 65532) >> 2 | ((var64 & '￼') >> 2 | var64 << 14) << 14) - 82 ^ 174) + 13 - 218 + 133 + 27 - 47
                        << 15
               )
            );
         }

         Class var7 = MethodType.fromMethodDescriptorString(var20.toString(), Class_178.class.getClassLoader()).returnType();
         switch (((var4 ^ 606077971) + 613035136 ^ 1308690570) + 613457680 + 1529183523 + 1241016085 - 807483049 + 1281002154 - 966478470 + 604946553) {
            case 603708692:
               var10000 = var0.findStaticGetter(var6, var5, var7);
               break;
            case 896433639:
               var10000 = var0.findSetter(var6, var5, var7);
               break;
            case 1613156081:
               var10000 = var0.findStaticSetter(var6, var5, var7);
               break;
            case 1741458800:
               var10000 = var0.findGetter(var6, var5, var7);
               break;
            default:
               throw new UnsupportedOperationException("Unsupported handle type!");
         }
      }

      if (!var11) {
         field_2040[(var10 + 1530578339 ^ 436484206 ^ 48114515) - 1916942131 - 38494338 - 458427885 - 1867366769 - 37386993 + 2061569304 - 1069996679] = var10000;
      }

      MethodHandle var12 = var10000.asType(var2);
      return new MutableCallSite(var12);
   }
}

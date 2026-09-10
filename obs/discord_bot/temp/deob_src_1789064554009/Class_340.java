import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.TextureFormat;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.stb.STBTTFontinfo;
import org.lwjgl.stb.STBTTPackContext;
import org.lwjgl.stb.STBTTPackRange;
import org.lwjgl.stb.STBTTPackedchar;
import org.lwjgl.stb.STBTruetype;
import org.lwjgl.stb.STBTTPackedchar.Buffer;
import org.lwjgl.system.MemoryStack;

public class Class_340 {
   // $VF: renamed from: xbn int
   public static int field_198 = 2048;
   // $VF: renamed from: txx RenderEngine_297
   public RenderEngine_297 field_199;
   // $VF: renamed from: rf int
   public int field_200;
   // $VF: renamed from: jwn float
   public float field_201;
   // $VF: renamed from: aij float
   public float field_202;
   // $VF: renamed from: yii it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
   public Int2ObjectOpenHashMap field_203 = new Int2ObjectOpenHashMap();

   public Class_340(ByteBuffer var1, int var2) {
      this.field_200 = var2;
      STBTTFontinfo var3 = STBTTFontinfo.create();
      STBTruetype.stbtt_InitFont(var3, var1);
      ByteBuffer var4 = BufferUtils.createByteBuffer(4194304);
      Buffer[] var5 = new Buffer[]{
         STBTTPackedchar.create(95),
         STBTTPackedchar.create(96),
         STBTTPackedchar.create(128),
         STBTTPackedchar.create(144),
         STBTTPackedchar.create(256),
         STBTTPackedchar.create(1)
      };
      STBTTPackContext var6 = STBTTPackContext.create();
      STBTruetype.stbtt_PackBegin(var6, var4, 2048, 2048, 0, 1);
      org.lwjgl.stb.STBTTPackRange.Buffer var7 = STBTTPackRange.create(var5.length);
      var7.put(STBTTPackRange.create().set((float)var2, 32, null, 95, var5[0], (byte)2, (byte)2));
      var7.put(STBTTPackRange.create().set((float)var2, 160, null, 96, var5[1], (byte)2, (byte)2));
      var7.put(STBTTPackRange.create().set((float)var2, 256, null, 128, var5[2], (byte)2, (byte)2));
      var7.put(STBTTPackRange.create().set((float)var2, 880, null, 144, var5[3], (byte)2, (byte)2));
      var7.put(STBTTPackRange.create().set((float)var2, 1024, null, 256, var5[4], (byte)2, (byte)2));
      var7.put(STBTTPackRange.create().set((float)var2, 8734, null, 1, var5[5], (byte)2, (byte)2));
      var7.flip();
      STBTruetype.stbtt_PackFontRanges(var6, var1, 0, var7);
      STBTruetype.stbtt_PackEnd(var6);
      this.field_199 = new RenderEngine_297(2048, 2048, TextureFormat.RED8, FilterMode.LINEAR, FilterMode.LINEAR);
      this.field_199.method_2097(var4);
      this.field_201 = STBTruetype.stbtt_ScaleForPixelHeight(var3, (float)var2);
      MemoryStack var8 = MemoryStack.stackPush();

      try {
         IntBuffer var9 = var8.mallocInt(1);
         STBTruetype.stbtt_GetFontVMetrics(var3, var9, null, null);
         this.field_202 = (float)var9.get(0);
      } catch (Throwable var16) {
         if (var8 != null) {
            try {
               var8.close();
            } catch (Throwable var15) {
               var16.addSuppressed(var15);
            }
         }

         throw var16;
      }

      if (var8 != null) {
         var8.close();
      }

      for (int var17 = 0; var17 < var5.length; var17++) {
         Buffer var18 = var5[var17];
         int var10 = ((STBTTPackRange)var7.get(var17)).first_unicode_codepoint_in_range();

         for (int var11 = 0; var11 < var18.capacity(); var11++) {
            STBTTPackedchar var12 = (STBTTPackedchar)var18.get(var11);
            float var13 = 4.8828125E-4F;
            float var14 = 4.8828125E-4F;
            this.field_203
               .put(
                  var11 + var10,
                  new Class_194(
                     var12.xoff(),
                     var12.yoff(),
                     var12.xoff2(),
                     var12.yoff2(),
                     (float)var12.x0() * var13,
                     (float)var12.y0() * var14,
                     (float)var12.x1() * var13,
                     (float)var12.y1() * var14,
                     var12.xadvance()
                  )
               );
         }
      }
   }

   // $VF: renamed from: uwz (java.lang.String, int) double
   public double method_265(String var1, int var2) {
      double var3 = 0.0;

      for (int var5 = 0; var5 < var2; var5++) {
         char var6 = var1.charAt(var5);
         Class_194 var7 = (Class_194)this.field_203.get(var6);
         if (var7 == null) {
            var7 = (Class_194)this.field_203.get(32);
         }

         var3 += (double)var7.field_838;
      }

      return var3;
   }

   // $VF: renamed from: aul () int
   public int method_266() {
      return this.field_200;
   }

   // $VF: renamed from: xdg (RenderEngine_386, java.lang.String, double, double, Class_262, double) double
   public double method_267(RenderEngine_386 var1, String var2, double var3, double var5, Class_262 var7, double var8) {
      var5 += (double)(this.field_202 * this.field_201) * var8;
      int var10 = var2.length();
      var1.method_117(var10 * 4, var10 * 6);

      for (int var11 = 0; var11 < var10; var11++) {
         char var12 = var2.charAt(var11);
         Class_194 var13 = (Class_194)this.field_203.get(var12);
         if (var13 == null) {
            var13 = (Class_194)this.field_203.get(32);
         }

         var1.method_112(
            var1.method_107(var3 + (double)var13.field_830 * var8, var5 + (double)var13.field_831 * var8)
               .method_107((double)var13.field_834, (double)var13.field_835)
               .method_109(var7)
               .method_110(),
            var1.method_107(var3 + (double)var13.field_830 * var8, var5 + (double)var13.field_833 * var8)
               .method_107((double)var13.field_834, (double)var13.field_837)
               .method_109(var7)
               .method_110(),
            var1.method_107(var3 + (double)var13.field_832 * var8, var5 + (double)var13.field_833 * var8)
               .method_107((double)var13.field_836, (double)var13.field_837)
               .method_109(var7)
               .method_110(),
            var1.method_107(var3 + (double)var13.field_832 * var8, var5 + (double)var13.field_831 * var8)
               .method_107((double)var13.field_836, (double)var13.field_835)
               .method_109(var7)
               .method_110()
         );
         var3 += (double)var13.field_838 * var8;
      }

      return var3;
   }
}

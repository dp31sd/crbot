import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import java.nio.ByteBuffer;
import net.minecraft.class_243;
import net.minecraft.class_310;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryUtil;

public class RenderEngine_386 {
   // $VF: renamed from: pbv com.mojang.blaze3d.vertex.VertexFormat
   public VertexFormat field_78;
   public int rpqv;
   // $VF: renamed from: htv double
   public double field_79 = 1.0;
   // $VF: renamed from: wc java.nio.ByteBuffer
   public ByteBuffer field_80 = null;
   // $VF: renamed from: vte long
   public long field_81;
   // $VF: renamed from: zkv long
   public long field_82;
   // $VF: renamed from: pbx java.nio.ByteBuffer
   public ByteBuffer field_83 = null;
   // $VF: renamed from: hwf long
   public long field_84;
   // $VF: renamed from: noh int
   public int field_85;
   // $VF: renamed from: jfp int
   public int field_86;
   // $VF: renamed from: us boolean
   public boolean field_87;
   // $VF: renamed from: onm double
   public double field_88;
   // $VF: renamed from: hlj double
   public double field_89;

   public RenderEngine_386(RenderPipeline var1) {
      this(var1.getVertexFormat(), var1.getVertexFormatMode());
   }

   public RenderEngine_386(VertexFormat var1, class_5596 var2) {
      this.field_78 = var1;
      this.rpqv = var1.getVertexSize();
   }

   public RenderEngine_386(VertexFormat var1, class_5596 var2, int var3, int var4) {
      this(var1, var2);
      this.method_118(var3, var4);
   }

   // $VF: renamed from: zag () void
   public void method_105() {
      if (!this.field_87) {
         this.field_82 = this.field_81;
         this.field_85 = 0;
         this.field_86 = 0;
         this.field_87 = true;
         if (RenderEngine_104.field_744) {
            class_243 var1 = ((class_310)ScreenUI_78.field_771).field_1773.method_19418().method_71156();
            this.field_88 = var1.field_1352;
            this.field_89 = var1.field_1350;
         } else {
            this.field_88 = 0.0;
            this.field_89 = 0.0;
         }
      } else {
         IllegalStateException var10000 = new IllegalStateException;
         int var10002 = 0;

         StringBuilder var10003;
         for (var10003 = new StringBuilder(
               "\u208fₕꂐ\ue095悇悔ₕꂕₖ悗\ue085₆\ue0bbꂔₔ\ue096\ue096ₕ\ue094\ue0bbꂑ\ue095ₖ\ue096ₕ\ue0bbₔ\ue096悐ₕₔ\ue094ₒ\ue0bb悔ₑₖ\ue096\ue094ₖ悗ꂕ悇"
            );
            var10002 < ((-10 | 41) & 43);
            var10002 += (2119793981 ^ 2119793981 | 1) & -1796522563
         ) {
            int var4 = (var10003.charAt(var10002) ^ 'd') - 205;
            int var10006 = (var4 & 61440) >> 12;
            int var5 = ((var4 & 61440) >> 12 | var4 << 4) - 174;
            int var9 = (((var4 & 61440) >> 12 | var4 << 4) - 174 & 65532) >> 2;
            char var6 = (char)(((var10006 | var4 << 4) - 174 & 65532) >> 2 | ((var4 & 61440) >> 12 | var4 << 4) - 174 << 14);
            var10003.setCharAt(var10002, (char)(var9 | var5 << 14));
         }

         var10000./* $VF: Unable to resugar constructor */<init>(var10003.toString());
         throw var10000;
      }
   }

   // $VF: renamed from: gqf (double, double, double) RenderEngine_386
   public RenderEngine_386 method_106(double var1, double var3, double var5) {
      long var7 = this.field_82;
      MemoryUtil.memPutFloat(var7, (float)(var1 - this.field_88));
      MemoryUtil.memPutFloat(var7 + 4L, (float)var3);
      MemoryUtil.memPutFloat(var7 + 8L, (float)(var5 - this.field_89));
      this.field_82 += 12L;
      return this;
   }

   // $VF: renamed from: dky (double, double) RenderEngine_386
   public RenderEngine_386 method_107(double var1, double var3) {
      long var5 = this.field_82;
      MemoryUtil.memPutFloat(var5, (float)var1);
      MemoryUtil.memPutFloat(var5 + 4L, (float)var3);
      this.field_82 += 8L;
      return this;
   }

   // $VF: renamed from: cmk (float, float) RenderEngine_386
   public RenderEngine_386 method_108(float var1, float var2) {
      long var3 = this.field_82;
      MemoryUtil.memPutFloat(var3, var1);
      MemoryUtil.memPutFloat(var3 + 4L, var2);
      this.field_82 += 8L;
      return this;
   }

   // $VF: renamed from: arf (Class_262) RenderEngine_386
   public RenderEngine_386 method_109(Class_262 var1) {
      long var2 = this.field_82;
      MemoryUtil.memPutByte(var2, (byte)var1.field_380);
      MemoryUtil.memPutByte(var2 + 1L, (byte)var1.field_381);
      MemoryUtil.memPutByte(var2 + 2L, (byte)var1.field_382);
      MemoryUtil.memPutByte(var2 + 3L, (byte)((int)((float)var1.field_383 * (float)this.field_79)));
      this.field_82 += 4L;
      return this;
   }

   // $VF: renamed from: zea () int
   public int method_110() {
      return this.field_85++;
   }

   // $VF: renamed from: rlw (int, int) void
   public void method_111(int var1, int var2) {
      long var3 = this.field_84 + (long)this.field_86 * 4L;
      MemoryUtil.memPutInt(var3, var1);
      MemoryUtil.memPutInt(var3 + 4L, var2);
      this.field_86 += 2;
   }

   // $VF: renamed from: uhx (int, int, int, int) void
   public void method_112(int var1, int var2, int var3, int var4) {
      long var5 = this.field_84 + (long)this.field_86 * 4L;
      MemoryUtil.memPutInt(var5, var1);
      MemoryUtil.memPutInt(var5 + 4L, var2);
      MemoryUtil.memPutInt(var5 + 8L, var3);
      MemoryUtil.memPutInt(var5 + 12L, var3);
      MemoryUtil.memPutInt(var5 + 16L, var4);
      MemoryUtil.memPutInt(var5 + 20L, var1);
      this.field_86 += 6;
   }

   // $VF: renamed from: jj (int, int, int) void
   public void method_113(int var1, int var2, int var3) {
      long var4 = this.field_84 + (long)this.field_86 * 4L;
      MemoryUtil.memPutInt(var4, var1);
      MemoryUtil.memPutInt(var4 + 4L, var2);
      MemoryUtil.memPutInt(var4 + 8L, var3);
      this.field_86 += 3;
   }

   // $VF: renamed from: asd () void
   public void method_114() {
      this.method_117(4, 6);
   }

   // $VF: renamed from: hks () void
   public void method_115() {
      this.method_117(3, 3);
   }

   // $VF: renamed from: nc () void
   public void method_116() {
      this.method_117(2, 2);
   }

   // $VF: renamed from: fyg (int, int) void
   public void method_117(int var1, int var2) {
      if (this.field_80 != null && this.field_83 != null) {
         if ((this.field_85 + var1) * this.rpqv >= this.field_80.capacity()) {
            int var3 = this.method_124();
            int var4 = Math.max(this.field_80.capacity() * 2, this.field_80.capacity() + var1 * this.rpqv);
            ByteBuffer var5 = BufferUtils.createByteBuffer(var4);
            MemoryUtil.memCopy(MemoryUtil.memAddress0(this.field_80), MemoryUtil.memAddress0(var5), (long)var3);
            this.field_80 = var5;
            this.field_81 = MemoryUtil.memAddress0(this.field_80);
            this.field_82 = this.field_81 + (long)var3;
         }

         if ((this.field_86 + var2) * 4 >= this.field_83.capacity()) {
            int var6 = Math.max(this.field_83.capacity() * 2, this.field_83.capacity() + var2 * 4);
            ByteBuffer var7 = BufferUtils.createByteBuffer(var6);
            MemoryUtil.memCopy(MemoryUtil.memAddress0(this.field_83), MemoryUtil.memAddress0(var7), (long)this.field_86 * 4L);
            this.field_83 = var7;
            this.field_84 = MemoryUtil.memAddress0(this.field_83);
         }
      } else {
         this.method_118(1024, 2048);
      }
   }

   // $VF: renamed from: hpa (int, int) void
   public void method_118(int var1, int var2) {
      this.field_80 = BufferUtils.createByteBuffer(this.rpqv * var1);
      this.field_82 = this.field_81 = MemoryUtil.memAddress0(this.field_80);
      this.field_83 = BufferUtils.createByteBuffer(var2 * 4);
      this.field_84 = MemoryUtil.memAddress0(this.field_83);
   }

   // $VF: renamed from: zfy () void
   public void method_119() {
      if (this.field_87) {
         this.field_87 = false;
      } else {
         IllegalStateException var10000 = new IllegalStateException;
         byte var10002 = 0;

         StringBuilder var10003;
         for (var10003 = new StringBuilder("濡\uefe3迢ΰ翟\uefe3翣\udfe3῟\u2fdf鿟迣꿣忣忣\uefe3\udfe3鿟쿢ΰ\u2fe3忣\uefe3鿟翣俣\udfe2鿟뿣\uefe2\u2fe3忣\udfe3\u2fe3翣쿣翟");
            var10002 < ((76485429 - 76485429 | 37) & -1752862235);
            var10002 += 1
         ) {
            char var3 = var10003.charAt(var10002);
            char var6 = (char)(
               (
                     (((((var3 & '쀀') >> 14 | var3 << 2) + 176 & 0) >> 16 | ((var3 & '쀀') >> 14 | var3 << 2) + 176 << 0) & 49152) >> 14
                        | ((((var3 & '쀀') >> 14 | var3 << 2) + 176 & 0) >> 16 | ((var3 & '쀀') >> 14 | var3 << 2) + 176 << 0) << 2
                  )
                  ^ 154
            );
            var10003.setCharAt(
               var10002,
               (char)(
                  (
                        (((((var3 & '쀀') >> 14 | var3 << 2) + 176 & 0) >> 16 | ((var3 & '쀀') >> 14 | var3 << 2) + 176 << 0) & 49152) >> 14
                           | ((((var3 & '쀀') >> 14 | var3 << 2) + 176 & 0) >> 16 | ((var3 & '쀀') >> 14 | var3 << 2) + 176 << 0) << 2
                     )
                     ^ 154
               )
            );
         }

         var10000./* $VF: Unable to resugar constructor */<init>(var10003.toString());
         throw var10000;
      }
   }

   // $VF: renamed from: qsw () boolean
   public boolean method_120() {
      return this.field_87;
   }

   // $VF: renamed from: oxq () com.mojang.blaze3d.buffers.GpuBuffer
   public GpuBuffer method_121() {
      this.field_80.limit(this.method_124());
      return this.field_78.uploadImmediateVertexBuffer(this.field_80);
   }

   // $VF: renamed from: voj () com.mojang.blaze3d.buffers.GpuBuffer
   public GpuBuffer method_122() {
      this.field_83.limit(this.field_86 * 4);
      return this.field_78.uploadImmediateIndexBuffer(this.field_83);
   }

   // $VF: renamed from: nni () int
   public int method_123() {
      return this.field_86;
   }

   // $VF: renamed from: bnb () int
   public int method_124() {
      return (int)(this.field_82 - this.field_81);
   }
}

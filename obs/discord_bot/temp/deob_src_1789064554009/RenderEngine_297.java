import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.AddressMode;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.TextureFormat;
import java.nio.ByteBuffer;
import net.minecraft.class_1011;
import net.minecraft.class_1044;
import net.minecraft.class_1011.class_1012;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryUtil;

public class RenderEngine_297 extends class_1044 {
   public RenderEngine_297(int var1, int var2, TextureFormat var3, FilterMode var4, FilterMode var5) {
      this.field_56974 = RenderSystem.getDevice().createTexture("", 15, var3, var1, var2, 1, 1);
      this.field_63613 = RenderSystem.getSamplerCache().method_75293(AddressMode.REPEAT, AddressMode.REPEAT, var4, var5, false);
      this.field_60597 = RenderSystem.getDevice().createTextureView(this.field_56974);
   }

   // $VF: renamed from: qxv () int
   public int method_2094() {
      return this.method_68004().getWidth(0);
   }

   // $VF: renamed from: nb () int
   public int method_2095() {
      return this.method_68004().getHeight(0);
   }

   // $VF: renamed from: rp (byte[]) void
   public void method_2096(byte[] var1) {
      this.method_2097(BufferUtils.createByteBuffer(var1.length).put(var1));
   }

   // $VF: renamed from: plc (java.nio.ByteBuffer) void
   public void method_2097(ByteBuffer var1) {
      class_1011 var2 = this.method_2098();
      var1.rewind();
      MemoryUtil.memCopy(MemoryUtil.memAddress(var1), var2.method_67769(), (long)var1.remaining());
      RenderSystem.getDevice().createCommandEncoder().writeToTexture(this.field_56974, var2);
      var2.close();
   }

   // $VF: renamed from: vug () net.minecraft.class_1011
   @NotNull
   public class_1011 method_2098() {
      class_1012 var1 = switch (Class_363.field_177[this.field_56974.getFormat().ordinal()]) {
         case 1 -> class_1012.field_4997;
         case 2 -> class_1012.field_4998;
         default -> throw new IllegalArgumentException();
      };
      return new class_1011(var1, this.method_2094(), this.method_2095(), false);
   }
}

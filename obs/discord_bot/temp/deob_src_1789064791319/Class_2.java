import com.mojang.blaze3d.buffers.Std140Builder;
import java.nio.ByteBuffer;
import net.minecraft.class_11280.class_11281;
import org.joml.Matrix4f;

public class Class_2 implements class_11281 {
   // $VF: renamed from: zl org.joml.Matrix4f
   public Matrix4f field_1508;
   // $VF: renamed from: vtb org.joml.Matrix4f
   public Matrix4f field_1509;

   public void method_71104(ByteBuffer var1) {
      Std140Builder.intoBuffer(var1).putMat4f(this.field_1508).putMat4f(this.field_1509);
   }

   @Override
   public boolean equals(Object var1) {
      return false;
   }
}

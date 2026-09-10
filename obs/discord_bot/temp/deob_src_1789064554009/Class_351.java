import com.mojang.blaze3d.buffers.Std140Builder;
import java.nio.ByteBuffer;
import net.minecraft.class_11280.class_11281;

public class Class_351 implements class_11281 {
   public float vbqg;
   // $VF: renamed from: dsl float
   public float field_185;
   // $VF: renamed from: reo float
   public float field_186;

   public void method_71104(ByteBuffer var1) {
      Std140Builder.intoBuffer(var1).putVec2(this.vbqg, this.field_185).putFloat(this.field_186);
   }

   @Override
   public boolean equals(Object var1) {
      return false;
   }
}

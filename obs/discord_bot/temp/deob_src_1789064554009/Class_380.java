import com.mojang.blaze3d.buffers.Std140Builder;
import java.nio.ByteBuffer;
import net.minecraft.class_11280.class_11281;

public class Class_380 implements class_11281 {
   // $VF: renamed from: sto float
   public float field_104;
   // $VF: renamed from: wo float
   public float field_105;
   // $VF: renamed from: ljs float
   public float field_106;
   // $VF: renamed from: gdj float
   public float field_107;
   // $VF: renamed from: amx float
   public float field_108;
   // $VF: renamed from: gwt float
   public float field_109;
   // $VF: renamed from: ifj float
   public float field_110;
   // $VF: renamed from: agn float
   public float field_111;
   // $VF: renamed from: cju float
   public float field_112;
   // $VF: renamed from: hml float
   public float field_113;
   // $VF: renamed from: mhf float
   public float field_114;

   public void method_71104(ByteBuffer var1) {
      Std140Builder.intoBuffer(var1)
         .putVec4(this.field_104, this.field_105, this.field_106, this.field_107)
         .putVec4(this.field_108, this.field_109, this.field_110, this.field_111)
         .putVec4(this.field_112, this.field_113, this.field_114, 0.0F);
   }

   @Override
   public boolean equals(Object var1) {
      return false;
   }
}

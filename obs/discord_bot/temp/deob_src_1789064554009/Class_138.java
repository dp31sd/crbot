import com.mojang.blaze3d.buffers.Std140Builder;
import java.nio.ByteBuffer;
import net.minecraft.class_11280.class_11281;

public class Class_138 implements class_11281 {
   // $VF: renamed from: sto float
   public float field_656;
   // $VF: renamed from: wo float
   public float field_657;
   // $VF: renamed from: ljs float
   public float field_658;
   // $VF: renamed from: gdj float
   public float field_659;
   // $VF: renamed from: amx float
   public float field_660;
   // $VF: renamed from: gwt float
   public float field_661;
   // $VF: renamed from: ifj float
   public float field_662;
   // $VF: renamed from: agn float
   public float field_663;
   // $VF: renamed from: sji Class_262
   public Class_262 field_664;
   // $VF: renamed from: rax Class_262
   public Class_262 field_665;
   // $VF: renamed from: tgl Class_262
   public Class_262 field_666;
   // $VF: renamed from: ga float
   public float field_667;
   // $VF: renamed from: cju float
   public float field_668;
   // $VF: renamed from: hml float
   public float field_669;
   // $VF: renamed from: hua float
   public float field_670;

   public void method_71104(ByteBuffer var1) {
      Std140Builder.intoBuffer(var1)
         .putVec4(this.field_656, this.field_657, this.field_658, this.field_659)
         .putVec4(this.field_660, this.field_661, this.field_662, this.field_663)
         .putVec4(
            (float)this.field_664.field_380 / 255.0F,
            (float)this.field_664.field_381 / 255.0F,
            (float)this.field_664.field_382 / 255.0F,
            (float)this.field_664.field_383 / 255.0F
         )
         .putVec4(
            (float)this.field_665.field_380 / 255.0F,
            (float)this.field_665.field_381 / 255.0F,
            (float)this.field_665.field_382 / 255.0F,
            (float)this.field_665.field_383 / 255.0F
         )
         .putVec4(
            (float)this.field_666.field_380 / 255.0F,
            (float)this.field_666.field_381 / 255.0F,
            (float)this.field_666.field_382 / 255.0F,
            (float)this.field_666.field_383 / 255.0F
         )
         .putVec4(this.field_667, this.field_668, this.field_669, this.field_670);
   }

   @Override
   public boolean equals(Object var1) {
      return false;
   }
}

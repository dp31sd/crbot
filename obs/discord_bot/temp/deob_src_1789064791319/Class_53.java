import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;

public class Class_53 {
   // $VF: renamed from: tps com.mojang.blaze3d.buffers.GpuBuffer
   public static GpuBuffer field_866;
   // $VF: renamed from: xq com.mojang.blaze3d.buffers.GpuBuffer
   public static GpuBuffer field_867;
   // $VF: renamed from: zx RenderEngine_386
   public static RenderEngine_386 field_868;

   // $VF: renamed from: nup () void
   public static void method_917() {
      field_868 = new RenderEngine_386(Class_420.field_9, class_5596.field_27379, 4, 6);
      field_868.method_105();
      field_868.method_112(
         field_868.method_107(-1.0, -1.0).method_110(),
         field_868.method_107(-1.0, 1.0).method_110(),
         field_868.method_107(1.0, 1.0).method_110(),
         field_868.method_107(1.0, -1.0).method_110()
      );
      field_868.method_119();
      field_866 = field_868.method_121();
      field_867 = field_868.method_122();
   }
}

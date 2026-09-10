import com.mojang.blaze3d.vertex.VertexFormatElement;
import com.mojang.blaze3d.vertex.VertexFormatElement.Type;
import com.mojang.blaze3d.vertex.VertexFormatElement.Usage;

public abstract class Class_303 {
   // $VF: renamed from: xxk com.mojang.blaze3d.vertex.VertexFormatElement
   public static VertexFormatElement field_278 = VertexFormatElement.register(method_314(), 0, Type.FLOAT, Usage.POSITION, 2);

   // $VF: renamed from: dpj () int
   public static int method_314() {
      int var0 = 0;

      while (VertexFormatElement.byId(var0) != null) {
         if (++var0 >= 32) {
            RuntimeException var10000 = new RuntimeException;
            int var10002 = 0;

            StringBuilder var10003;
            for (var10003 = new StringBuilder("缤６６绮７－缗９绮７６缌４绮缕３２１４缔３缕１缗２绮缫３缕缔３缚缣６缕７－缔Ｃ缐３７３缗缔４");
               var10002 < (517836 ^ 517858);
               var10002 += (213473256 & -526404075 * 1987654040 | 1) & -211786221
            ) {
               char var3 = var10003.charAt(var10002);
               char var4 = (char)((((var3 & '耀') >> 15 | var3 << 1) + 239 + 57 ^ 39) + 253);
               var10003.setCharAt(var10002, (char)((((var3 & '耀') >> 15 | var3 << 1) + 239 + 57 ^ 39) + 253));
            }

            var10000./* $VF: Unable to resugar constructor */<init>(var10003.toString());
            throw var10000;
         }
      }

      return var0;
   }
}

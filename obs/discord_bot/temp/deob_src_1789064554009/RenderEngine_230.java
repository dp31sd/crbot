import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_9799;
import net.minecraft.class_327.class_6415;
import net.minecraft.class_4597.class_4598;
import org.joml.Matrix4f;
import org.joml.Matrix4fStack;

public class RenderEngine_230 implements Class_43 {
   // $VF: renamed from: oei RenderEngine_230
   public static RenderEngine_230 field_464 = new RenderEngine_230();
   // $VF: renamed from: zt net.minecraft.class_9799
   public class_9799 field_465 = new class_9799(2048);
   // $VF: renamed from: ody net.minecraft.class_4597.class_4598
   public class_4598 field_466 = class_4597.method_22991(this.field_465);
   // $VF: renamed from: vtg net.minecraft.class_4587
   public class_4587 field_467 = new class_4587();
   // $VF: renamed from: bio org.joml.Matrix4f
   public Matrix4f field_468 = new Matrix4f();
   // $VF: renamed from: ix double
   public double field_469 = 2.0;
   // $VF: renamed from: suo boolean
   public boolean field_470;
   // $VF: renamed from: us boolean
   public boolean field_471;
   // $VF: renamed from: htv double
   public double field_472 = 1.0;

   // $VF: renamed from: oc (double) void
   @Override
   public void method_3(double var1) {
      this.field_472 = var1;
   }

   // $VF: renamed from: ua (java.lang.String, int, boolean) double
   @Override
   public double method_8(String var1, int var2, boolean var3) {
      if (var1.isEmpty()) {
         return 0.0;
      } else {
         if (var2 != var1.length()) {
            var1 = var1.substring(0, var2);
         }

         return (double)(((class_310)ScreenUI_78.field_771).field_1772.method_1727(var1) + (var3 ? 1 : 0)) * this.field_469;
      }
   }

   // $VF: renamed from: nlr (boolean) double
   @Override
   public double method_11(boolean var1) {
      return (double)(9 + (var1 ? 1 : 0)) * this.field_469;
   }

   // $VF: renamed from: dk (double, boolean, boolean) void
   @Override
   public void method_4(double var1, boolean var3, boolean var4) {
      if (!this.field_471) {
         this.field_469 = var1 * 2.0;
         this.field_471 = true;
      } else {
         RuntimeException var10000 = new RuntimeException;
         int var10002 = -979322582 >>> (-592481633 >>> -592481633) ^ 1657822357;

         StringBuilder var10003;
         for (var10003 = new StringBuilder("ʪ˶͊˖˒˒˶ʲ˦̢̲ʺ˦͊˲˦̺˦̺Ɋ˺˦˞˖͊ǢǖȂˮ˶˒˒˦˲Ȃ̲̞˖ˮ˦");
            var10002 < 40;
            var10002 += 1406192106 ^ -1796271608 ^ 1406192106 >>> -1796271608 ^ -949220566
         ) {
            int var7 = var10003.charAt(var10002) - 140 ^ 251 ^ 193;
            char var8 = (char)(((var7 & 65532) >> 2 | var7 << 14) - 51);
            var10003.setCharAt(var10002, (char)(((var7 & 65532) >> 2 | var7 << 14) - 51));
         }

         var10000./* $VF: Unable to resugar constructor */<init>(var10003.toString());
         throw var10000;
      }
   }

   // $VF: renamed from: jq (java.lang.String, double, double, Class_262, boolean) double
   @Override
   public double method_13(String var1, double var2, double var4, Class_262 var6, boolean var7) {
      boolean var8 = this.field_471;
      if (!var8) {
         this.znx();
      }

      var2 += 0.5 * this.field_469;
      var4 += 0.5 * this.field_469;
      int var9 = var6.field_383;
      var6.field_383 = (int)((double)var6.field_383 / 255.0 * this.field_472 * 255.0);
      Matrix4f var10 = this.field_468;
      if (this.field_470) {
         this.field_467.method_22903();
         this.field_467.method_22905((float)this.field_469, (float)this.field_469, 1.0F);
         var10 = this.field_467.method_23760().method_23761();
      }

      ((class_310)ScreenUI_78.field_771)
         .field_1772
         .method_27521(
            var1,
            (float)(var2 / this.field_469),
            (float)(var4 / this.field_469),
            var6.method_401(),
            var7,
            var10,
            this.field_466,
            class_6415.field_33993,
            0,
            15728880
         );
      double var11 = var2 / this.field_469 + (double)((class_310)ScreenUI_78.field_771).field_1772.method_1727(var1);
      if (this.field_470) {
         this.field_467.method_22909();
      }

      var6.field_383 = var9;
      if (!var8) {
         this.method_16();
      }

      return (var11 - 1.0) * this.field_469;
   }

   // $VF: renamed from: to () boolean
   @Override
   public boolean method_15() {
      return this.field_471;
   }

   // $VF: renamed from: bj () void
   @Override
   public void method_16() {
      if (this.field_471) {
         Matrix4fStack var1 = RenderSystem.getModelViewStack();
         var1.pushMatrix();
         if (!this.field_470) {
            var1.scale((float)this.field_469, (float)this.field_469, 1.0F);
         }

         this.field_466.method_22993();
         var1.popMatrix();
         this.field_469 = 2.0;
         this.field_471 = false;
      } else {
         RuntimeException var10000 = new RuntimeException;
         int var10002 = 0;

         StringBuilder var10003;
         for (var10003 = new StringBuilder(
               "\ue218\ue558\ue818\ue758\ue798\ue798\ue558\ue198\ue658\uea98\ue998\ue118\ue658\ue818\ue598\ue658\ue918\ue658\ue918\ud818\ue658\ue818\ue598횘흘풘\ue5d8\ue558\ue798\ue798\ue658\ue598풘\uead8\ue758\ue998\ue698\ue8d8\uea58\ue998풘\ue5d8\ue558\ue798\ue798\ue758\ue818\ue6d8풘\ue518\ue658\ue6d8\ue758\ue818횘흘"
            );
            var10002 < ((1964645794 & 1964645794 | 56) & -2147409796);
            var10002 += 1699204120 << 1699204120 ^ 402653185
         ) {
            int var4 = (var10003.charAt(var10002) ^ '|') + 192 + 155;
            char var5 = (char)(((var4 & 65472) >> 6 | var4 << 10) + 200);
            var10003.setCharAt(var10002, (char)(((var4 & 65472) >> 6 | var4 << 10) + 200));
         }

         var10000./* $VF: Unable to resugar constructor */<init>(var10003.toString());
         throw var10000;
      }
   }
}

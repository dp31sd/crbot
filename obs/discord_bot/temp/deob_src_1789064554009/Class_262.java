import net.minecraft.class_124;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2583;
import net.minecraft.class_5251;
import org.joml.Vector3f;
import org.joml.Vector4f;

public class Class_262 {
   // $VF: renamed from: olz Class_262
   public static Class_262 field_367 = new Class_262(255, 255, 255);
   // $VF: renamed from: iig Class_262
   public static Class_262 field_368 = new Class_262(192, 192, 192);
   // $VF: renamed from: qpu Class_262
   public static Class_262 field_369 = new Class_262(128, 128, 128);
   // $VF: renamed from: ixb Class_262
   public static Class_262 field_370 = new Class_262(64, 64, 64);
   // $VF: renamed from: vdw Class_262
   public static Class_262 field_371 = new Class_262(0, 0, 0);
   // $VF: renamed from: qnj Class_262
   public static Class_262 field_372 = new Class_262(255, 0, 0);
   // $VF: renamed from: hip Class_262
   public static Class_262 field_373 = new Class_262(255, 175, 175);
   // $VF: renamed from: nzx Class_262
   public static Class_262 field_374 = new Class_262(255, 200, 0);
   // $VF: renamed from: sgs Class_262
   public static Class_262 field_375 = new Class_262(255, 255, 0);
   // $VF: renamed from: ojp Class_262
   public static Class_262 field_376 = new Class_262(0, 255, 0);
   // $VF: renamed from: enh Class_262
   public static Class_262 field_377 = new Class_262(255, 0, 255);
   // $VF: renamed from: wdi Class_262
   public static Class_262 field_378 = new Class_262(0, 255, 255);
   // $VF: renamed from: pfw Class_262
   public static Class_262 field_379 = new Class_262(0, 0, 255);
   // $VF: renamed from: kfl int
   public int field_380;
   // $VF: renamed from: smq int
   public int field_381;
   // $VF: renamed from: gx int
   public int field_382;
   // $VF: renamed from: qg int
   public int field_383;

   public Class_262() {
      this(255, 255, 255, 255);
   }

   public Class_262(int var1, int var2, int var3) {
      this.field_380 = var1;
      this.field_381 = var2;
      this.field_382 = var3;
      this.field_383 = 255;
      this.fpuo();
   }

   public Class_262(int var1, int var2, int var3, int var4) {
      this.field_380 = var1;
      this.field_381 = var2;
      this.field_382 = var3;
      this.field_383 = var4;
      this.fpuo();
   }

   public Class_262(float var1, float var2, float var3, float var4) {
      this.field_380 = (int)(var1 * 255.0F);
      this.field_381 = (int)(var2 * 255.0F);
      this.field_382 = (int)(var3 * 255.0F);
      this.field_383 = (int)(var4 * 255.0F);
      this.fpuo();
   }

   public Class_262(int var1) {
      this.field_380 = method_375(var1);
      this.field_381 = method_376(var1);
      this.field_382 = method_377(var1);
      this.field_383 = method_378(var1);
   }

   public Class_262(Class_262 var1) {
      this.field_380 = var1.field_380;
      this.field_381 = var1.field_381;
      this.field_382 = var1.field_382;
      this.field_383 = var1.field_383;
   }

   public Class_262(class_124 var1) {
      if (var1.method_543()) {
         this.field_380 = method_375(var1.method_532());
         this.field_381 = method_376(var1.method_532());
         this.field_382 = method_377(var1.method_532());
         this.field_383 = method_378(var1.method_532());
      } else {
         this.field_380 = 255;
         this.field_381 = 255;
         this.field_382 = 255;
         this.field_383 = 255;
      }
   }

   public Class_262(class_5251 var1) {
      this.field_380 = method_375(var1.method_27716());
      this.field_381 = method_376(var1.method_27716());
      this.field_382 = method_377(var1.method_27716());
      this.field_383 = method_378(var1.method_27716());
   }

   public Class_262(class_2583 var1) {
      class_5251 var2 = var1.method_10973();
      if (var2 == null) {
         this.field_380 = 255;
         this.field_381 = 255;
         this.field_382 = 255;
         this.field_383 = 255;
      } else {
         this.field_380 = method_375(var2.method_27716());
         this.field_381 = method_376(var2.method_27716());
         this.field_382 = method_377(var2.method_27716());
         this.field_383 = method_378(var2.method_27716());
      }
   }

   // $VF: renamed from: fam (int, int, int, int) int
   public static int method_374(int var0, int var1, int var2, int var3) {
      return (var0 << 16) + (var1 << 8) + var2 + (var3 << 24);
   }

   // $VF: renamed from: bdn (int) int
   public static int method_375(int var0) {
      return var0 >> 16 & 0xFF;
   }

   // $VF: renamed from: xsw (int) int
   public static int method_376(int var0) {
      return var0 >> 8 & 0xFF;
   }

   // $VF: renamed from: xd (int) int
   public static int method_377(int var0) {
      return var0 & 0xFF;
   }

   // $VF: renamed from: moq (int) int
   public static int method_378(int var0) {
      return var0 >> 24 & 0xFF;
   }

   // $VF: renamed from: ppe (double, double, double) Class_262
   public static Class_262 method_379(double var0, double var2, double var4) {
      if (var2 <= 0.0) {
         return new Class_262((int)(var4 * 255.0), (int)(var4 * 255.0), (int)(var4 * 255.0), 255);
      } else {
         double var6 = var0;
         if (var0 >= 360.0) {
            var6 = 0.0;
         }

         var6 /= 60.0;
         int var16 = (int)var6;
         double var14 = var6 - (double)var16;
         double var8 = var4 * (1.0 - var2);
         double var10 = var4 * (1.0 - var2 * var14);
         double var12 = var4 * (1.0 - var2 * (1.0 - var14));
         double var17;
         double var19;
         double var21;
         switch (var16) {
            case 0:
               var17 = var4;
               var19 = var12;
               var21 = var8;
               break;
            case 1:
               var17 = var10;
               var19 = var4;
               var21 = var8;
               break;
            case 2:
               var17 = var8;
               var19 = var4;
               var21 = var12;
               break;
            case 3:
               var17 = var8;
               var19 = var10;
               var21 = var4;
               break;
            case 4:
               var17 = var12;
               var19 = var8;
               var21 = var4;
               break;
            case 5:
            default:
               var17 = var4;
               var19 = var8;
               var21 = var10;
         }

         return new Class_262((int)(var17 * 255.0), (int)(var19 * 255.0), (int)(var21 * 255.0), 255);
      }
   }

   // $VF: renamed from: xxy (int, int, int, float[]) float[]
   public static float[] method_380(int var0, int var1, int var2, float[] var3) {
      if (var3 == null) {
         var3 = new float[3];
      }

      int var4 = Math.max(var0, Math.max(var1, var2));
      int var5 = Math.min(var0, Math.min(var1, var2));
      float var6 = (float)var4 / 255.0F;
      float var7;
      if (var4 != 0) {
         var7 = (float)(var4 - var5) / (float)var4;
      } else {
         var7 = 0.0F;
      }

      float var8;
      if (var7 == 0.0F) {
         var8 = 0.0F;
      } else {
         float var9 = (float)(var4 - var0) / (float)(var4 - var5);
         float var10 = (float)(var4 - var1) / (float)(var4 - var5);
         float var11 = (float)(var4 - var2) / (float)(var4 - var5);
         if (var0 == var4) {
            var8 = var11 - var10;
         } else if (var1 == var4) {
            var8 = 2.0F + var9 - var11;
         } else {
            var8 = 4.0F + var10 - var9;
         }

         var8 /= 6.0F;
         if (var8 < 0.0F) {
            var8++;
         }
      }

      var3[0] = var8;
      var3[1] = var7;
      var3[2] = var6;
      return var3;
   }

   // $VF: renamed from: dag (float, float, float) int
   public static int method_381(float var0, float var1, float var2) {
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      if (var1 == 0.0F) {
         var3 = var4 = var5 = (int)(var2 * 255.0F + 0.5F);
      } else {
         float var6 = (var0 - (float)Math.floor((double)var0)) * 6.0F;
         float var7 = var6 - (float)Math.floor((double)var6);
         float var8 = var2 * (1.0F - var1);
         float var9 = var2 * (1.0F - var1 * var7);
         float var10 = var2 * (1.0F - var1 * (1.0F - var7));
         switch ((int)var6) {
            case 0:
               var3 = (int)(var2 * 255.0F + 0.5F);
               var4 = (int)(var10 * 255.0F + 0.5F);
               var5 = (int)(var8 * 255.0F + 0.5F);
               break;
            case 1:
               var3 = (int)(var9 * 255.0F + 0.5F);
               var4 = (int)(var2 * 255.0F + 0.5F);
               var5 = (int)(var8 * 255.0F + 0.5F);
               break;
            case 2:
               var3 = (int)(var8 * 255.0F + 0.5F);
               var4 = (int)(var2 * 255.0F + 0.5F);
               var5 = (int)(var10 * 255.0F + 0.5F);
               break;
            case 3:
               var3 = (int)(var8 * 255.0F + 0.5F);
               var4 = (int)(var9 * 255.0F + 0.5F);
               var5 = (int)(var2 * 255.0F + 0.5F);
               break;
            case 4:
               var3 = (int)(var10 * 255.0F + 0.5F);
               var4 = (int)(var8 * 255.0F + 0.5F);
               var5 = (int)(var2 * 255.0F + 0.5F);
               break;
            case 5:
               var3 = (int)(var2 * 255.0F + 0.5F);
               var4 = (int)(var8 * 255.0F + 0.5F);
               var5 = (int)(var9 * 255.0F + 0.5F);
         }
      }

      return 0xFF000000 | var3 << 16 | var4 << 8 | var5;
   }

   public static Class_262 rqtv(float var0, float var1, float var2) {
      int var3 = method_381(var0, var1, var2);
      return new Class_262(var3 >> 16 & 0xFF, var3 >> 8 & 0xFF, var3 & 0xFF, 255);
   }

   // $VF: renamed from: ojk (int, int, int, int) Class_262
   public Class_262 method_382(int var1, int var2, int var3, int var4) {
      this.field_380 = var1;
      this.field_381 = var2;
      this.field_382 = var3;
      this.field_383 = var4;
      this.fpuo();
      return this;
   }

   // $VF: renamed from: kbs (int) Class_262
   public Class_262 method_383(int var1) {
      this.field_380 = var1;
      this.fpuo();
      return this;
   }

   // $VF: renamed from: ocm (int) Class_262
   public Class_262 method_384(int var1) {
      this.field_381 = var1;
      this.fpuo();
      return this;
   }

   // $VF: renamed from: hoh (int) Class_262
   public Class_262 method_385(int var1) {
      this.field_382 = var1;
      this.fpuo();
      return this;
   }

   // $VF: renamed from: pd (int) Class_262
   public Class_262 method_386(int var1) {
      this.field_383 = var1;
      this.fpuo();
      return this;
   }

   // $VF: renamed from: tu (Class_262) Class_262
   public Class_262 method_387(Class_262 var1) {
      this.field_380 = var1.field_380;
      this.field_381 = var1.field_381;
      this.field_382 = var1.field_382;
      this.field_383 = var1.field_383;
      this.fpuo();
      return this;
   }

   // $VF: renamed from: tbw (java.lang.String) boolean
   public boolean method_388(String var1) {
      String[] var2 = var1.split(",");
      if (var2.length != 3 && var2.length != 4) {
         return false;
      } else {
         try {
            int var3 = Integer.parseInt(var2[0]);
            int var4 = Integer.parseInt(var2[1]);
            int var5 = Integer.parseInt(var2[2]);
            int var6 = var2.length == 4 ? Integer.parseInt(var2[3]) : this.field_383;
            this.field_380 = var3;
            this.field_381 = var4;
            this.field_382 = var5;
            this.field_383 = var6;
            return true;
         } catch (NumberFormatException var7) {
            return false;
         }
      }
   }

   public Class_262 cbaa() {
      return new Class_262(this.field_380, this.field_381, this.field_382, this.field_383);
   }

   // $VF: renamed from: zgo () net.minecraft.class_5251
   public class_5251 method_389() {
      return class_5251.method_27717(this.method_401());
   }

   // $VF: renamed from: ezy () net.minecraft.class_2583
   public class_2583 method_390() {
      return class_2583.field_24360.method_27703(this.method_389());
   }

   // $VF: renamed from: ivf (net.minecraft.class_2583) net.minecraft.class_2583
   public class_2583 method_391(class_2583 var1) {
      return var1.method_27703(this.method_389());
   }

   // $VF: renamed from: jtr () int
   public int method_392() {
      return this.field_380;
   }

   // $VF: renamed from: kj () int
   public int method_393() {
      return this.field_381;
   }

   // $VF: renamed from: lgv () int
   public int method_394() {
      return this.field_382;
   }

   // $VF: renamed from: ly () int
   public int method_395() {
      return this.field_383;
   }

   // $VF: renamed from: lil () int
   public int method_396() {
      return this.method_401();
   }

   // $VF: renamed from: rhj () Class_262
   public Class_262 method_397() {
      byte var1 = 3;
      int var2 = this.field_380;
      int var3 = this.field_381;
      int var4 = this.field_382;
      if (var2 == 0 && var3 == 0 && var4 == 0) {
         return new Class_262(var1, var1, var1, this.field_383);
      } else {
         if (var2 > 0 && var2 < var1) {
            var2 = var1;
         }

         if (var3 > 0 && var3 < var1) {
            var3 = var1;
         }

         if (var4 > 0 && var4 < var1) {
            var4 = var1;
         }

         return new Class_262(
            Math.min((int)((double)var2 / 0.7), 255), Math.min((int)((double)var3 / 0.7), 255), Math.min((int)((double)var4 / 0.7), 255), this.field_383
         );
      }
   }

   // $VF: renamed from: iz () Class_262
   public Class_262 method_398() {
      return new Class_262(
         Math.max((int)((double)this.field_380 * 0.7), 0),
         Math.max((int)((double)this.field_381 * 0.7), 0),
         Math.max((int)((double)this.field_382 * 0.7), 0),
         this.field_383
      );
   }

   public void fpuo() {
      if (this.field_380 < 0) {
         this.field_380 = 0;
      } else if (this.field_380 > 255) {
         this.field_380 = 255;
      }

      if (this.field_381 < 0) {
         this.field_381 = 0;
      } else if (this.field_381 > 255) {
         this.field_381 = 255;
      }

      if (this.field_382 < 0) {
         this.field_382 = 0;
      } else if (this.field_382 > 255) {
         this.field_382 = 255;
      }

      if (this.field_383 < 0) {
         this.field_383 = 0;
      } else if (this.field_383 > 255) {
         this.field_383 = 255;
      }
   }

   // $VF: renamed from: vsn () net.minecraft.class_243
   public class_243 method_399() {
      return new class_243((double)this.field_380 / 255.0, (double)this.field_381 / 255.0, (double)this.field_382 / 255.0);
   }

   // $VF: renamed from: yzi () org.joml.Vector3f
   public Vector3f method_400() {
      return new Vector3f((float)this.field_380 / 255.0F, (float)this.field_381 / 255.0F, (float)this.field_382 / 255.0F);
   }

   public Vector4f gava() {
      return new Vector4f((float)this.field_380 / 255.0F, (float)this.field_381 / 255.0F, (float)this.field_382 / 255.0F, (float)this.field_383 / 255.0F);
   }

   // $VF: renamed from: jrs () int
   public int method_401() {
      return method_374(this.field_380, this.field_381, this.field_382, this.field_383);
   }

   // $VF: renamed from: cbx () net.minecraft.class_2487
   public class_2487 method_402() {
      class_2487 var1 = new class_2487();
      var1.method_10569("r", this.field_380);
      var1.method_10569("g", this.field_381);
      var1.method_10569("b", this.field_382);
      var1.method_10569("a", this.field_383);
      return var1;
   }

   // $VF: renamed from: wwr (net.minecraft.class_2487) Class_262
   public Class_262 method_403(class_2487 var1) {
      this.field_380 = var1.method_68083("r", 0);
      this.field_381 = var1.method_68083("g", 0);
      this.field_382 = var1.method_68083("b", 0);
      this.field_383 = var1.method_68083("a", 0);
      this.fpuo();
      return this;
   }

   @Override
   public String toString() {
      int var4 = this.field_383;
      int var3 = this.field_382;
      int var2 = this.field_381;
      int var1 = this.field_380;
      return var1 + " " + var2 + " " + var3 + " " + var4;
   }

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         Class_262 var2 = (Class_262)var1;
         return this.field_380 == var2.field_380 && this.field_381 == var2.field_381 && this.field_382 == var2.field_382 && this.field_383 == var2.field_383;
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      int var1 = this.field_380;
      var1 = 31 * var1 + this.field_381;
      var1 = 31 * var1 + this.field_382;
      return 31 * var1 + this.field_383;
   }
}

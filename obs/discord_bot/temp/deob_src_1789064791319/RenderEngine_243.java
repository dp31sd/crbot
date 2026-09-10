import java.nio.ByteBuffer;
import net.minecraft.class_310;
import org.lwjgl.BufferUtils;

public class RenderEngine_243 implements Class_43 {
   // $VF: renamed from: dxi Class_262
   public static Class_262 field_446 = new Class_262(60, 60, 60, 180);
   // $VF: renamed from: kj Class_162
   public Class_162 field_447;
   // $VF: renamed from: zx RenderEngine_386
   public RenderEngine_386 field_448 = new RenderEngine_386(CryptoService_296.field_291);
   // $VF: renamed from: cl Class_340[]
   public Class_340[] field_449;
   // $VF: renamed from: frc Class_340
   public Class_340 field_450;
   // $VF: renamed from: us boolean
   public boolean field_451;
   // $VF: renamed from: uv boolean
   public boolean field_452;
   // $VF: renamed from: le double
   public double field_453 = 1.0;
   // $VF: renamed from: ix double
   public double field_454 = 1.0;

   public RenderEngine_243(Class_162 var1) {
      this.field_447 = var1;
      byte[] var2 = CryptoService_63.method_834(var1.method_624());
      ByteBuffer var3 = BufferUtils.createByteBuffer(var2.length).put(var2).flip();
      this.field_449 = new Class_340[5];

      for (int var4 = 0; var4 < this.field_449.length; var4++) {
         this.field_449[var4] = new Class_340(var3, (int)Math.round(27.0 * ((double)var4 * 0.5 + 1.0)));
      }
   }

   // $VF: renamed from: oc (double) void
   @Override
   public void method_3(double var1) {
      this.field_448.field_79 = var1;
   }

   // $VF: renamed from: dk (double, boolean, boolean) void
   @Override
   public void method_4(double var1, boolean var3, boolean var4) {
      if (!this.field_451) {
         if (!var3) {
            this.field_448.method_105();
         }

         if (var4) {
            this.field_450 = this.field_449[this.field_449.length - 1];
         } else {
            double var5 = Math.floor(var1 * 10.0) / 10.0;
            byte var7;
            if (var5 >= 3.0) {
               var7 = 5;
            } else if (var5 >= 2.5) {
               var7 = 4;
            } else if (var5 >= 2.0) {
               var7 = 3;
            } else if (var5 >= 1.5) {
               var7 = 2;
            } else {
               var7 = 1;
            }

            this.field_450 = this.field_449[var7 - 1];
         }

         this.field_451 = true;
         this.field_452 = var3;
         this.field_453 = (double)this.field_450.method_266() / 27.0;
         this.field_454 = 1.0 + (var1 - this.field_453) / this.field_453;
      } else {
         RuntimeException var10000 = new RuntimeException;
         int var10002 = (-1298929883 - -1298929883 | 0) & 2080620898;

         StringBuilder var10003;
         for (var10003 = new StringBuilder("᠐ꠏ頏ꀏ砏栏ꀐ⠏쀏ꀏ逐⠏瀏\u200f⠏透⠏透瀑ဏ⠏㠏䠏瀏䀑䠑\u0011᠏ࠏ怏怏⠏\u200f\u0011ꀏ렏䠏᠏⠏"); var10002 < 39; var10002 += -2010510039 ^ -2010510040) {
            char var10 = var10003.charAt(var10002);
            int var10006 = (var10 & 0) >> 16;
            int var11 = (((var10 & 0) >> 16 | var10 << 0) - 157 ^ 63) + 182;
            int var15 = ((((var10 & 0) >> 16 | var10 << 0) - 157 ^ 63) + 182 & 63488) >> 11;
            var10 = (char)((((var10006 | var10 << 0) - 157 ^ 63) + 182 & 63488) >> 11 | (((var10 & 0) >> 16 | var10 << 0) - 157 ^ 63) + 182 << 5);
            var10003.setCharAt(var10002, (char)(var15 | var11 << 5));
         }

         var10000./* $VF: Unable to resugar constructor */<init>(var10003.toString());
         throw var10000;
      }
   }

   // $VF: renamed from: ua (java.lang.String, int, boolean) double
   @Override
   public double method_8(String var1, int var2, boolean var3) {
      if (var1.isEmpty()) {
         return 0.0;
      } else {
         Class_340 var4 = this.field_451 ? this.field_450 : this.field_449[0];
         return (var4.method_265(var1, var2) + (double)(var3 ? 1 : 0)) * this.field_454 / 1.5;
      }
   }

   // $VF: renamed from: nlr (boolean) double
   @Override
   public double method_11(boolean var1) {
      Class_340 var2 = this.field_451 ? this.field_450 : this.field_449[0];
      return (double)(var2.method_266() + 1 + (var1 ? 1 : 0)) * this.field_454 / 1.5;
   }

   // $VF: renamed from: jq (java.lang.String, double, double, Class_262, boolean) double
   @Override
   public double method_13(String var1, double var2, double var4, Class_262 var6, boolean var7) {
      boolean var8 = this.field_451;
      if (!var8) {
         this.znx();
      }

      double var9;
      if (var7) {
         int var11 = field_446.field_383;
         field_446.field_383 = (int)((double)var6.field_383 / 255.0 * (double)var11);
         var9 = this.field_450
            .method_267(
               this.field_448,
               var1,
               var2 + this.field_453 * this.field_454 / 1.5,
               var4 + this.field_453 * this.field_454 / 1.5,
               field_446,
               this.field_454 / 1.5
            );
         this.field_450.method_267(this.field_448, var1, var2, var4, var6, this.field_454 / 1.5);
         field_446.field_383 = var11;
      } else {
         var9 = this.field_450.method_267(this.field_448, var1, var2, var4, var6, this.field_454 / 1.5);
      }

      if (!var8) {
         this.method_16();
      }

      return var9;
   }

   // $VF: renamed from: to () boolean
   @Override
   public boolean method_15() {
      return this.field_451;
   }

   // $VF: renamed from: bj () void
   @Override
   public void method_16() {
      if (!this.field_451) {
         RuntimeException var1 = new RuntimeException;
         int var4 = 0;

         StringBuilder var11;
         for (var11 = new StringBuilder(
               "虺\uea7a\ue67a\ue87a\ude7a\uda7a\ua87a쩺\uf07a\ue87aꑺ쩺\udc7a졺쩺\ue47a쩺\ue47a屺쩺\udc7a졺偺剺䁺왺쉺\ud87a\ud87a쩺졺䁺\uee7a퉺\ue87a큺\ude7a\uea7a\ue87a䁺왺쉺\ud87a\ud87a퉺\udc7a칺䁺쑺쩺칺퉺\udc7a偺剺"
            );
            var4 < (-29362249 & 29362231);
            var4 += (-782073544 >> -1283767159 | 1) & 149159
         ) {
            int var16 = var11.charAt(var4) ^ 162 ^ 216;
            char var19 = (char)(
               (((((var16 & 65534) >> 1 | var16 << 15) & 49152) >> 14 | ((var16 & 65534) >> 1 | var16 << 15) << 2) & 64512) >> 10
                  | ((((var16 & 65534) >> 1 | var16 << 15) & 49152) >> 14 | ((var16 & 65534) >> 1 | var16 << 15) << 2) << 6
            );
            var11.setCharAt(
               var4,
               (char)(
                  (((((var16 & 65534) >> 1 | var16 << 15) & 49152) >> 14 | ((var16 & 65534) >> 1 | var16 << 15) << 2) & 64512) >> 10
                     | ((((var16 & 65534) >> 1 | var16 << 15) & 49152) >> 14 | ((var16 & 65534) >> 1 | var16 << 15) << 2) << 6
               )
            );
         }

         var1./* $VF: Unable to resugar constructor */<init>(var11.toString());
         throw var1;
      } else {
         if (!this.field_452) {
            this.field_448.method_119();
            RenderEngine_374 var10000 = RenderEngine_374.method_163()
               .method_166(class_310.method_1551().method_1522())
               .method_168(CryptoService_296.field_291)
               .method_170(this.field_448);
            int var10001 = (133620386 | 61508519 | 0) & -939518960;

            StringBuilder var10002;
            for (var10002 = new StringBuilder("毸歈櫰歸氈毰毸毠歸");
               var10001 < ((-106605211 << 1475610209 | 9) & 2167085);
               var10001 += (-552502775 << 477000024 | 1) & -522581255
            ) {
               char var6 = var10002.charAt(var10001);
               char var9 = (char)(
                  (((((var6 & '︀') >> 9 | var6 << 7) - 54 & 64512) >> 10 | ((var6 & '︀') >> 9 | var6 << 7) - 54 << 6) + 119 & 0) >> 16
                     | ((((var6 & '︀') >> 9 | var6 << 7) - 54 & 64512) >> 10 | ((var6 & '︀') >> 9 | var6 << 7) - 54 << 6) + 119 << 0
               );
               var10002.setCharAt(
                  var10001,
                  (char)(
                     (((((var6 & '︀') >> 9 | var6 << 7) - 54 & 64512) >> 10 | ((var6 & '︀') >> 9 | var6 << 7) - 54 << 6) + 119 & 0) >> 16
                        | ((((var6 & '︀') >> 9 | var6 << 7) - 54 & 64512) >> 10 | ((var6 & '︀') >> 9 | var6 << 7) - 54 << 6) + 119 << 0
                  )
               );
            }

            var10000.method_177(var10002.toString(), this.field_450.field_199.method_71659(), this.field_450.field_199.method_75484()).method_178();
         }

         this.field_451 = false;
         this.field_454 = 1.0;
      }
   }

   // $VF: renamed from: sue () void
   public void method_457() {
      for (Class_340 var4 : this.field_449) {
         var4.field_199.close();
      }
   }
}

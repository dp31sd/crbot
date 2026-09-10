import dev.krypton.render.text.FontInfo.Type;

public record RenderEngine_298(
   String family,
   Type type,
   String family,
   Type type,
   String family,
   Type type,
   String family,
   Type type,
   String family,
   Class_388 type,
   String family,
   Class_388 type,
   String family,
   Class_388 type,
   String family,
   Class_388 type,
   String family,
   Type type,
   String family,
   Type type,
   String family,
   Type type,
   String family,
   Type type,
   String family,
   Class_388 type,
   String family,
   Class_388 type,
   String family,
   Class_388 type,
   String family,
   Class_388 type
) {
   // $VF: renamed from: yen java.lang.String
   public String field_818;
   // $VF: renamed from: wyh Class_388
   public Class_388 field_819;

   public RenderEngine_298(String var1, Class_388 var2) {
      this.field_818 = var1;
      this.field_819 = var2;
   }

   @Override
   public String toString() {
      String var10000 = this.field_818;
      String var2 = String.valueOf(this.field_819);
      String var1 = var10000;
      return var1 + " " + var2;
   }

   // $VF: renamed from: cfo (RenderEngine_298) boolean
   public boolean method_872(RenderEngine_298 var1) {
      if (this == var1) {
         return true;
      } else {
         return var1 != null && this.field_818 != null && this.field_819 != null
            ? this.field_818.equals(var1.field_818) && this.field_819 == var1.field_819
            : false;
      }
   }

   // $VF: renamed from: ker () java.lang.String
   public String method_873() {
      return this.field_818;
   }

   // $VF: renamed from: hps () Class_388
   public Class_388 method_874() {
      return this.field_819;
   }
}

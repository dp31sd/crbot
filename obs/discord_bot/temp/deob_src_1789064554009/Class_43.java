public interface Class_43 {
   // $VF: renamed from: nkq () Class_43
   static Class_43 method_2() {
      return (Class_43)(Class_139.field_2109.method_1035() ? Class_35.field_987 : RenderEngine_230.field_464);
   }

   // $VF: renamed from: oc (double) void
   void method_3(double var1);

   // $VF: renamed from: dk (double, boolean, boolean) void
   void method_4(double var1, boolean var3, boolean var4);

   // $VF: renamed from: rzn (double) void
   default void method_5(double var1) {
      this.method_4(var1, false, false);
   }

   // $VF: renamed from: znx () void
   default void method_6() {
      this.method_4(1.0, false, false);
   }

   // $VF: renamed from: bsn () void
   default void method_7() {
      this.method_4(1.0, false, true);
   }

   // $VF: renamed from: ua (java.lang.String, int, boolean) double
   double method_8(String var1, int var2, boolean var3);

   // $VF: renamed from: vy (java.lang.String, boolean) double
   default double method_9(String var1, boolean var2) {
      return this.method_8(var1, var1.length(), var2);
   }

   // $VF: renamed from: vzf (java.lang.String) double
   default double method_10(String var1) {
      return this.method_8(var1, var1.length(), false);
   }

   // $VF: renamed from: nlr (boolean) double
   double method_11(boolean var1);

   // $VF: renamed from: jcx () double
   default double method_12() {
      return this.method_11(false);
   }

   // $VF: renamed from: jq (java.lang.String, double, double, Class_262, boolean) double
   double method_13(String var1, double var2, double var4, Class_262 var6, boolean var7);

   // $VF: renamed from: ghq (java.lang.String, double, double, Class_262) double
   default double method_14(String var1, double var2, double var4, Class_262 var6) {
      return this.method_13(var1, var2, var4, var6, false);
   }

   // $VF: renamed from: to () boolean
   boolean method_15();

   // $VF: renamed from: bj () void
   void method_16();
}

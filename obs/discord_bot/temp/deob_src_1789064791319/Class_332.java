public class Class_332 implements Cloneable {
   // $VF: renamed from: vq Class_14
   private Class_14 field_209 = Class_14.field_1483;
   // $VF: renamed from: mh Class_203
   private Class_203 field_210 = new Class_203();

   @Override
   public Object clone() {
      try {
         return super.clone();
      } catch (CloneNotSupportedException var2) {
         throw new InternalError(this + ": " + var2);
      }
   }

   // $VF: renamed from: uq (Class_14) void
   public void method_268(Class_14 out) {
      if (out == null) {
         throw new NullPointerException("out");
      } else {
         this.field_209 = out;
      }
   }

   // $VF: renamed from: pk () Class_14
   public Class_14 method_269() {
      return this.field_209;
   }

   // $VF: renamed from: iu () Class_203
   public Class_203 method_270() {
      return this.field_210;
   }
}

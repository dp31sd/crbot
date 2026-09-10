public class Class_356 extends Class_235 implements Class_79 {
   // $VF: renamed from: tt int
   private int field_1506 = 256;

   public Class_356(String msg, Throwable t) {
      super(msg, t);
   }

   public Class_356(int errorcode, Throwable t) {
      this(method_1395(errorcode), t);
      this.field_1506 = errorcode;
   }

   // $VF: renamed from: zjy () int
   public int method_1394() {
      return this.field_1506;
   }

   // $VF: renamed from: bjd (int) java.lang.String
   public static String method_1395(int errorcode) {
      return "Bitstream errorcode " + Integer.toHexString(errorcode);
   }
}

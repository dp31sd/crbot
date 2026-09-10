public class Class_3 extends Class_235 implements Class_393 {
   // $VF: renamed from: tt int
   private int field_1507 = 512;

   public Class_3(String msg, Throwable t) {
      super(msg, t);
   }

   public Class_3(int errorcode, Throwable t) {
      this(method_1397(errorcode), t);
      this.field_1507 = errorcode;
   }

   // $VF: renamed from: wa () int
   public int method_1396() {
      return this.field_1507;
   }

   // $VF: renamed from: utq (int) java.lang.String
   public static String method_1397(int errorcode) {
      return "Decoder errorcode " + Integer.toHexString(errorcode);
   }
}

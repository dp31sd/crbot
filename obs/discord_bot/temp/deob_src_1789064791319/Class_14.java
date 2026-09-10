public class Class_14 {
   // $VF: renamed from: yr int
   public static final int field_1477 = 0;
   // $VF: renamed from: j int
   public static final int field_1478 = 1;
   // $VF: renamed from: tp int
   public static final int field_1479 = 2;
   // $VF: renamed from: pi int
   public static final int field_1480 = 3;
   // $VF: renamed from: jy Class_14
   public static final Class_14 field_1481 = new Class_14(1);
   // $VF: renamed from: xn Class_14
   public static final Class_14 field_1482 = new Class_14(2);
   // $VF: renamed from: pk Class_14
   public static final Class_14 field_1483 = new Class_14(0);
   // $VF: renamed from: l Class_14
   public static final Class_14 field_1484 = new Class_14(3);
   // $VF: renamed from: du int
   private int field_1485;

   // $VF: renamed from: w (int) Class_14
   public static Class_14 method_1366(int code) {
      switch (code) {
         case 0:
            return field_1483;
         case 1:
            return field_1481;
         case 2:
            return field_1482;
         case 3:
            return field_1484;
         default:
            throw new IllegalArgumentException("Invalid channel code: " + code);
      }
   }

   private Class_14(int channels) {
      this.field_1485 = channels;
      if (channels < 0 || channels > 3) {
         throw new IllegalArgumentException("channels");
      }
   }

   // $VF: renamed from: bp () int
   public int method_1367() {
      return this.field_1485;
   }

   // $VF: renamed from: af () int
   public int method_1368() {
      return this.field_1485 == 0 ? 2 : 1;
   }

   @Override
   public boolean equals(Object o) {
      boolean equals = false;
      if (o instanceof Class_14) {
         Class_14 oc = (Class_14)o;
         equals = oc.field_1485 == this.field_1485;
      }

      return equals;
   }

   @Override
   public int hashCode() {
      return this.field_1485;
   }
}

public class Class_32 {
   // $VF: renamed from: mqt int
   public static int field_992 = 1;
   // $VF: renamed from: lhr int
   public static int field_993 = 2;
   // $VF: renamed from: cxv EventHandler_288
   private EventHandler_288 field_994;
   // $VF: renamed from: bxf int
   private int field_995;
   // $VF: renamed from: sl int
   private int field_996;

   public Class_32(EventHandler_288 source, int id, int frame) {
      this.field_996 = id;
      this.field_994 = source;
      this.field_995 = frame;
   }

   // $VF: renamed from: igj () int
   public int method_1128() {
      return this.field_996;
   }

   // $VF: renamed from: ogt (int) void
   public void method_1129(int id) {
      this.field_996 = id;
   }

   // $VF: renamed from: qcj () int
   public int method_1130() {
      return this.field_995;
   }

   // $VF: renamed from: emr (int) void
   public void method_1131(int frame) {
      this.field_995 = frame;
   }

   // $VF: renamed from: ozq () EventHandler_288
   public EventHandler_288 method_1132() {
      return this.field_994;
   }

   // $VF: renamed from: ai (EventHandler_288) void
   public void method_1133(EventHandler_288 source) {
      this.field_994 = source;
   }
}

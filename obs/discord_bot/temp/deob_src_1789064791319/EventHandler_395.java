public class EventHandler_395 extends Class_283 {
   public EventHandler_395(EventHandler_318 var1) {
      this.field_508 = var1;
   }

   // $VF: renamed from: wmb (Class_32) void
   @Override
   public void method_564(Class_32 evt) {
      System.out.println("Play started from frame " + evt.method_1130());
   }

   // $VF: renamed from: hm (Class_32) void
   @Override
   public void method_565(Class_32 evt) {
      System.out.println("Play completed at frame " + evt.method_1130());
      System.exit(0);
   }
}

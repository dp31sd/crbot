import java.io.PrintStream;

public class Class_235 extends Exception {
   // $VF: renamed from: buk java.lang.Throwable
   private Throwable field_1505;

   public Class_235() {
   }

   public Class_235(String msg) {
      super(msg);
   }

   public Class_235(String msg, Throwable t) {
      super(msg);
      this.field_1505 = t;
   }

   public Throwable getException() {
      return this.field_1505;
   }

   @Override
   public void printStackTrace() {
      this.printStackTrace(System.err);
   }

   @Override
   public void printStackTrace(PrintStream ps) {
      if (this.field_1505 == null) {
         super.printStackTrace(ps);
      } else {
         this.field_1505.printStackTrace();
      }
   }
}

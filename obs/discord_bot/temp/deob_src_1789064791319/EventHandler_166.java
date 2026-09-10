import java.io.PrintWriter;

public class EventHandler_166 {
   public static void main(String[] args) {
      long start = System.currentTimeMillis();
      int argc = args.length + 1;
      String[] argv = new String[argc];
      argv[0] = "jlc";

      for (int i = 0; i < args.length; i++) {
         argv[i + 1] = args[i];
      }

      Class_175 ma = new Class_175();
      if (!ma.method_617(argv)) {
         System.exit(1);
      }

      EventHandler_37 conv = new EventHandler_37();
      int detail = ma.field_572 ? ma.field_573 : 0;
      EventHandler_174 listener = new EventHandler_317(new PrintWriter(System.out, true), detail);

      try {
         conv.method_1112(ma.field_571, ma.field_570, listener);
      } catch (Class_235 var10) {
         System.err.println("Convertion failure: " + var10);
      }

      System.exit(0);
   }
}

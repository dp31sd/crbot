import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class NetworkHandler_232 {
   // $VF: renamed from: nw java.lang.String
   private String field_462 = null;
   // $VF: renamed from: uzk boolean
   private boolean field_463 = false;

   public static void main(String[] args) {
      int retval = 0;

      try {
         NetworkHandler_232 player = method_463(args);
         if (player != null) {
            player.method_467();
         }
      } catch (Exception var3) {
         System.err.println(var3);
         var3.printStackTrace(System.err);
         retval = 1;
      }

      System.exit(retval);
   }

   // $VF: renamed from: dlv (java.lang.String[]) NetworkHandler_232
   public static NetworkHandler_232 method_463(String[] args) {
      NetworkHandler_232 player = new NetworkHandler_232();
      if (!player.method_465(args)) {
         player = null;
      }

      return player;
   }

   private NetworkHandler_232() {
   }

   public NetworkHandler_232(String filename) {
      this.method_464(filename);
   }

   // $VF: renamed from: eur (java.lang.String) void
   protected void method_464(String filename) {
      this.field_462 = filename;
   }

   // $VF: renamed from: nww (java.lang.String[]) boolean
   protected boolean method_465(String[] args) {
      boolean parsed = false;
      if (args.length == 1) {
         this.method_464(args[0]);
         parsed = true;
         this.field_463 = false;
      } else if (args.length == 2) {
         if (!args[0].equals("-url")) {
            this.method_466();
         } else {
            this.method_464(args[1]);
            parsed = true;
            this.field_463 = true;
         }
      } else {
         this.method_466();
      }

      return parsed;
   }

   // $VF: renamed from: mlu () void
   public void method_466() {
      System.out.println("Usage: jlp [-url] <filename>");
      System.out.println("");
      System.out.println(" e.g. : java javazoom.jl.player.jlp localfile.mp3");
      System.out.println("        java javazoom.jl.player.jlp -url http://www.server.com/remotefile.mp3");
      System.out.println("        java javazoom.jl.player.jlp -url http://www.shoutcastserver.com:8000");
   }

   // $VF: renamed from: tc () void
   public void method_467() throws Class_235 {
      try {
         System.out.println("playing " + this.field_462 + "...");
         InputStream in = null;
         if (this.field_463) {
            in = this.method_468();
         } else {
            in = this.method_469();
         }

         Class_200 dev = this.method_470();
         Class_370 player = new Class_370(in, dev);
         player.method_203();
      } catch (IOException var4) {
         throw new Class_235("Problem playing file " + this.field_462, var4);
      } catch (Exception var5) {
         throw new Class_235("Problem playing file " + this.field_462, var5);
      }
   }

   // $VF: renamed from: tkh () java.io.InputStream
   protected InputStream method_468() throws Exception {
      URL url = new URL(this.field_462);
      InputStream fin = url.openStream();
      return new BufferedInputStream(fin);
   }

   // $VF: renamed from: hv () java.io.InputStream
   protected InputStream method_469() throws IOException {
      FileInputStream fin = new FileInputStream(this.field_462);
      return new BufferedInputStream(fin);
   }

   // $VF: renamed from: wj () Class_200
   protected Class_200 method_470() throws Class_235 {
      return Class_379.method_821().createAudioDevice();
   }
}

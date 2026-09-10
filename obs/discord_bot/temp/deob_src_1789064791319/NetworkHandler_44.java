import java.applet.Applet;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class NetworkHandler_44 extends Applet implements Runnable {
   // $VF: renamed from: eu java.lang.String
   public static final String field_965 = "audioURL";
   // $VF: renamed from: hsj Class_370
   private Class_370 field_966 = null;
   // $VF: renamed from: jak java.lang.Thread
   private Thread field_967 = null;
   // $VF: renamed from: fvc java.lang.String
   private String field_968 = null;

   // $VF: renamed from: zi () Class_200
   protected Class_200 method_1089() throws Class_235 {
      return Class_379.method_821().createAudioDevice();
   }

   // $VF: renamed from: dzw () java.io.InputStream
   protected InputStream method_1090() {
      InputStream in = null;

      try {
         URL url = this.method_1092();
         if (url != null) {
            in = url.openStream();
         }
      } catch (IOException var3) {
         System.err.println(var3);
      }

      return in;
   }

   // $VF: renamed from: dq () java.lang.String
   protected String method_1091() {
      String urlString = this.field_968;
      if (urlString == null) {
         urlString = "j�b�DK";
      }

      return urlString;
   }

   // $VF: renamed from: trq () java.net.URL
   protected URL method_1092() {
      String urlString = this.method_1091();
      URL url = null;
      if (urlString != null) {
         try {
            url = new URL(this.getDocumentBase(), urlString);
         } catch (Exception var4) {
            System.err.println(var4);
         }
      }

      return url;
   }

   // $VF: renamed from: cn (java.lang.String) void
   public void method_1093(String name) {
      this.field_968 = name;
   }

   // $VF: renamed from: ue () java.lang.String
   public String method_1094() {
      return this.field_968;
   }

   // $VF: renamed from: xa () void
   protected void method_1095() throws Class_235 {
      if (this.field_966 != null) {
         this.field_966.method_205();
         this.field_966 = null;
         this.field_967 = null;
      }
   }

   // $VF: renamed from: pj (java.io.InputStream, Class_200) void
   protected void method_1096(InputStream in, Class_200 dev) throws Class_235 {
      this.method_1095();
      if (in != null && dev != null) {
         this.field_966 = new Class_370(in, dev);
         this.field_967 = this.method_1097();
         this.field_967.start();
      }
   }

   // $VF: renamed from: mt () java.lang.Thread
   protected Thread method_1097() {
      return new Thread(this, "Audio player thread");
   }

   @Override
   public void init() {
   }

   @Override
   public void start() {
      String name = this.method_1091();

      try {
         InputStream in = this.method_1090();
         Class_200 dev = this.method_1089();
         this.method_1096(in, dev);
      } catch (Class_235 var6) {
         Class_235 ex = var6;
         synchronized (System.err) {
            System.err.println("Unable to play " + name);
            ex.printStackTrace(System.err);
         }
      }
   }

   @Override
   public void stop() {
      try {
         this.method_1095();
      } catch (Class_235 var2) {
         System.err.println(var2);
      }
   }

   @Override
   public void destroy() {
   }

   // $VF: renamed from: run () void
   @Override
   public void run() {
      if (this.field_966 != null) {
         try {
            this.field_966.method_203();
         } catch (Class_235 var2) {
            System.err.println("Problem playing audio: " + var2);
         }
      }
   }
}

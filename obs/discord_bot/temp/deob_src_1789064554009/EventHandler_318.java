import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EventHandler_318 {
   public static void main(String[] args) {
      EventHandler_318 test = new EventHandler_318();
      if (args.length != 1) {
         test.method_294();
         System.exit(0);
      } else {
         try {
            test.method_293(args[0]);
         } catch (Exception var3) {
            System.err.println(var3.getMessage());
            System.exit(0);
         }
      }
   }

   // $VF: renamed from: pvu (java.lang.String) void
   public void method_293(String filename) throws Class_235, IOException {
      EventHandler_395 lst = new EventHandler_395(this);
      method_295(new File(filename), lst);
   }

   // $VF: renamed from: nfb () void
   public void method_294() {
      System.out.println("Usage: jla <filename>");
      System.out.println("");
      System.out.println(" e.g. : java javazoom.jl.player.advanced.jlap localfile.mp3");
   }

   // $VF: renamed from: nnk (java.io.File, Class_283) EventHandler_288
   public static EventHandler_288 method_295(File mp3, Class_283 listener) throws IOException, Class_235 {
      return method_296(mp3, 0, Integer.MAX_VALUE, listener);
   }

   // $VF: renamed from: hxx (java.io.File, int, int, Class_283) EventHandler_288
   public static EventHandler_288 method_296(File mp3, int start, int end, Class_283 listener) throws IOException, Class_235 {
      return method_297(new BufferedInputStream(new FileInputStream(mp3)), start, end, listener);
   }

   // $VF: renamed from: cr (java.io.InputStream, int, int, Class_283) EventHandler_288
   public static EventHandler_288 method_297(InputStream is, int start, int end, Class_283 listener) throws Class_235 {
      final EventHandler_288 player = new EventHandler_288(is);
      player.method_340(listener);
      (new Thread() {
         // $VF: renamed from: run () void
         @Override
         public void run() {
            try {
               player.method_338(start, end);
            } catch (Exception var2) {
               throw new RuntimeException(var2.getMessage());
            }
         }
      }).start();
      return player;
   }
}

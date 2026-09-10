import java.io.PrintWriter;

public class EventHandler_317 implements EventHandler_174 {
   // $VF: renamed from: rm int
   public static final int field_246 = 0;
   // $VF: renamed from: jyv int
   public static final int field_247 = 1;
   // $VF: renamed from: tw int
   public static final int field_248 = 2;
   // $VF: renamed from: fst int
   public static final int field_249 = 7;
   // $VF: renamed from: xsk int
   public static final int field_250 = 10;
   // $VF: renamed from: gsb java.io.PrintWriter
   private PrintWriter field_251;
   // $VF: renamed from: dpq int
   private int field_252;

   // $VF: renamed from: twz (int) EventHandler_317
   public static EventHandler_317 method_298(int detail) {
      return new EventHandler_317(new PrintWriter(System.out, true), detail);
   }

   public EventHandler_317(PrintWriter writer, int detailLevel) {
      this.field_251 = writer;
      this.field_252 = detailLevel;
   }

   // $VF: renamed from: huu (int) boolean
   public boolean method_299(int detail) {
      return this.field_252 >= detail;
   }

   @Override
   public void converterUpdate(int updateID, int param1, int param2) {
      if (this.method_299(2)) {
         switch (updateID) {
            case 2:
               if (param2 == 0) {
                  param2 = 1;
               }

               this.field_251.println();
               this.field_251.println("Converted " + param2 + " frames in " + param1 + " ms (" + param1 / param2 + " ms per frame.)");
         }
      }
   }

   @Override
   public void parsedFrame(int frameNo, Class_412 header) {
      if (frameNo == 0 && this.method_299(2)) {
         String headerString = header.toString();
         this.field_251.println("File is a " + headerString);
      } else if (this.method_299(10)) {
         String headerString = header.toString();
         this.field_251.println("Prased frame " + frameNo + ": " + headerString);
      }
   }

   @Override
   public void readFrame(int frameNo, Class_412 header) {
      if (frameNo == 0 && this.method_299(2)) {
         String headerString = header.toString();
         this.field_251.println("File is a " + headerString);
      } else if (this.method_299(10)) {
         String headerString = header.toString();
         this.field_251.println("Read frame " + frameNo + ": " + headerString);
      }
   }

   @Override
   public void decodedFrame(int frameNo, Class_412 header, Class_278 o) {
      if (this.method_299(10)) {
         String headerString = header.toString();
         this.field_251.println("Decoded frame " + frameNo + ": " + headerString);
         this.field_251.println("Output: " + o);
      } else if (this.method_299(2)) {
         if (frameNo == 0) {
            this.field_251.print("Converting.");
            this.field_251.flush();
         }

         if (frameNo % 10 == 0) {
            this.field_251.print('.');
            this.field_251.flush();
         }
      }
   }

   @Override
   public boolean converterException(Throwable t) {
      if (this.field_252 > 0) {
         t.printStackTrace(this.field_251);
         this.field_251.flush();
      }

      return false;
   }
}

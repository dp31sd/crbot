public interface EventHandler_174 {
   int UPDATE_FRAME_COUNT = 1;
   int UPDATE_CONVERT_COMPLETE = 2;

   void converterUpdate(int var1, int var2, int var3);

   void parsedFrame(int var1, Class_412 var2);

   void readFrame(int var1, Class_412 var2);

   void decodedFrame(int var1, Class_412 var2, Class_278 var3);

   boolean converterException(Throwable var1);
}

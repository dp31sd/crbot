import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EventHandler_37 {
   // $VF: renamed from: kuv (java.lang.String, java.lang.String) void
   public synchronized void method_1111(String sourceName, String destName) throws Class_235 {
      this.method_1113(sourceName, destName, null, null);
   }

   // $VF: renamed from: hig (java.lang.String, java.lang.String, EventHandler_174) void
   public synchronized void method_1112(String sourceName, String destName, EventHandler_174 progressListener) throws Class_235 {
      this.method_1113(sourceName, destName, progressListener, null);
   }

   // $VF: renamed from: tq (java.lang.String, java.lang.String, EventHandler_174, Class_332) void
   public void method_1113(String sourceName, String destName, EventHandler_174 progressListener, Class_332 decoderParams) throws Class_235 {
      if (destName.length() == 0) {
         destName = null;
      }

      try {
         InputStream in = this.method_1116(sourceName);
         this.method_1114(in, destName, progressListener, decoderParams);
         in.close();
      } catch (IOException var6) {
         throw new Class_235(var6.getLocalizedMessage(), var6);
      }
   }

   // $VF: renamed from: zkh (java.io.InputStream, java.lang.String, EventHandler_174, Class_332) void
   public synchronized void method_1114(InputStream sourceStream, String destName, EventHandler_174 progressListener, Class_332 decoderParams) throws Class_235 {
      if (progressListener == null) {
         progressListener = EventHandler_317.method_298(0);
      }

      try {
         if (!(sourceStream instanceof BufferedInputStream)) {
            sourceStream = new BufferedInputStream(sourceStream);
         }

         int frameCount = -1;
         if (sourceStream.markSupported()) {
            sourceStream.mark(-1);
            frameCount = this.method_1115(sourceStream);
            sourceStream.reset();
         }

         progressListener.converterUpdate(1, frameCount, 0);
         Class_278 output = null;
         Class_331 decoder = new Class_331(decoderParams);
         Class_371 stream = new Class_371(sourceStream);
         if (frameCount == -1) {
            frameCount = Integer.MAX_VALUE;
         }

         int frame = 0;
         long startTime = System.currentTimeMillis();

         try {
            for (; frame < frameCount; frame++) {
               try {
                  Class_412 header = stream.method_185();
                  if (header == null) {
                     break;
                  }

                  progressListener.readFrame(frame, header);
                  if (output == null) {
                     int channels = header.method_50() == 3 ? 1 : 2;
                     int freq = header.method_49();
                     output = new Class_301(channels, freq, destName);
                     decoder.method_274(output);
                  }

                  Class_278 decoderOutput = decoder.method_273(header, stream);
                  if (decoderOutput != output) {
                     throw new InternalError("Output buffers are different.");
                  }

                  progressListener.decodedFrame(frame, header, output);
                  stream.method_189();
               } catch (Exception var19) {
                  boolean stop = !progressListener.converterException(var19);
                  if (stop) {
                     throw new Class_235(var19.getLocalizedMessage(), var19);
                  }
               }
            }
         } finally {
            if (output != null) {
               output.close();
            }
         }

         int time = (int)(System.currentTimeMillis() - startTime);
         progressListener.converterUpdate(2, time, frame);
      } catch (IOException var21) {
         throw new Class_235(var21.getLocalizedMessage(), var21);
      }
   }

   // $VF: renamed from: amg (java.io.InputStream) int
   protected int method_1115(InputStream in) {
      return -1;
   }

   // $VF: renamed from: khh (java.lang.String) java.io.InputStream
   protected InputStream method_1116(String fileName) throws IOException {
      File file = new File(fileName);
      InputStream fileIn = new FileInputStream(file);
      return new BufferedInputStream(fileIn);
   }
}

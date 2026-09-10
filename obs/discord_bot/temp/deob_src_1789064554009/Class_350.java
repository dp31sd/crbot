import java.io.IOException;
import java.io.InputStream;

public class Class_350 implements Class_118 {
   // $VF: renamed from: gda java.io.InputStream
   private final InputStream field_187;

   public Class_350(InputStream in) {
      if (in == null) {
         throw new NullPointerException("in");
      } else {
         this.field_187 = in;
      }
   }

   @Override
   public int read(byte[] b, int offs, int len) throws IOException {
      return this.field_187.read(b, offs, len);
   }

   @Override
   public boolean willReadBlock() {
      return true;
   }

   @Override
   public boolean isSeekable() {
      return false;
   }

   @Override
   public long tell() {
      return -1L;
   }

   @Override
   public long seek(long to) {
      return -1L;
   }

   @Override
   public long length() {
      return -1L;
   }
}

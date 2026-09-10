import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

public final class Class_371 implements Class_79 {
   // $VF: renamed from: yv byte
   static byte field_130 = 0;
   // $VF: renamed from: py byte
   static byte field_131 = 1;
   // $VF: renamed from: uje int
   private static final int field_132 = 433;
   // $VF: renamed from: lrz int[]
   private final int[] field_133 = new int[433];
   // $VF: renamed from: hbl int
   private int field_134;
   // $VF: renamed from: fe byte[]
   private byte[] field_135 = new byte[1732];
   // $VF: renamed from: wbr int
   private int field_136;
   // $VF: renamed from: gnc int
   private int field_137;
   // $VF: renamed from: yry int
   private int field_138;
   // $VF: renamed from: kb int
   private int field_139 = 0;
   // $VF: renamed from: bck boolean
   private boolean field_140;
   // $VF: renamed from: ybc int[]
   private final int[] field_141 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071};
   // $VF: renamed from: oly java.io.PushbackInputStream
   private final PushbackInputStream field_142;
   // $VF: renamed from: zvf Class_412
   private final Class_412 field_143 = new Class_412();
   // $VF: renamed from: rp byte[]
   private final byte[] field_144 = new byte[4];
   // $VF: renamed from: mbq Class_273[]
   private Class_273[] field_145 = new Class_273[1];
   // $VF: renamed from: xm byte[]
   private byte[] field_146 = null;
   // $VF: renamed from: ge boolean
   private boolean field_147 = true;

   public Class_371(InputStream in) {
      if (in == null) {
         throw new NullPointerException("in");
      } else {
         InputStream var2 = new BufferedInputStream(in);
         this.method_181(var2);
         this.field_147 = true;
         this.field_142 = new PushbackInputStream(var2, 1732);
         this.method_189();
      }
   }

   // $VF: renamed from: xs () int
   public int method_180() {
      return this.field_139;
   }

   // $VF: renamed from: ifj (java.io.InputStream) void
   private void method_181(InputStream in) {
      int size = -1;

      try {
         in.mark(10);
         size = this.method_182(in);
         this.field_139 = size;
      } catch (IOException var14) {
      } finally {
         try {
            in.reset();
         } catch (IOException var12) {
         }
      }

      try {
         if (size > 0) {
            this.field_146 = new byte[size];
            in.read(this.field_146, 0, this.field_146.length);
         }
      } catch (IOException var13) {
      }
   }

   // $VF: renamed from: tud (java.io.InputStream) int
   private int method_182(InputStream in) throws IOException {
      byte[] id3header = new byte[4];
      int size = -10;
      in.read(id3header, 0, 3);
      if (id3header[0] == 73 && id3header[1] == 68 && id3header[2] == 51) {
         in.read(id3header, 0, 3);
         int majorVersion = id3header[0];
         int revision = id3header[1];
         in.read(id3header, 0, 4);
         size = (id3header[0] << 21) + (id3header[1] << 14) + (id3header[2] << 7) + id3header[3];
      }

      return size + 10;
   }

   // $VF: renamed from: qt () java.io.InputStream
   public InputStream method_183() {
      return this.field_146 == null ? null : new ByteArrayInputStream(this.field_146);
   }

   // $VF: renamed from: ble () void
   public void method_184() throws Class_356 {
      try {
         this.field_142.close();
      } catch (IOException var2) {
         throw this.method_194(258, var2);
      }
   }

   // $VF: renamed from: lno () Class_412
   public Class_412 method_185() throws Class_356 {
      Class_412 result = null;

      try {
         result = this.method_186();
         if (this.field_147) {
            result.method_44(this.field_135);
            this.field_147 = false;
         }
      } catch (Class_356 var5) {
         if (var5.method_1394() == 261) {
            try {
               this.method_189();
               result = this.method_186();
            } catch (Class_356 var4) {
               if (var4.method_1394() != 260) {
                  throw this.method_194(var4.method_1394(), var4);
               }
            }
         } else if (var5.method_1394() != 260) {
            throw this.method_194(var5.method_1394(), var5);
         }
      }

      return result;
   }

   // $VF: renamed from: ivg () Class_412
   private Class_412 method_186() throws Class_356 {
      if (this.field_134 == -1) {
         this.method_187();
      }

      return this.field_143;
   }

   // $VF: renamed from: npk () void
   private void method_187() throws Class_356 {
      this.field_143.method_43(this, this.field_145);
   }

   // $VF: renamed from: bh () void
   public void method_188() throws Class_356 {
      if (this.field_136 == -1 && this.field_137 == -1 && this.field_134 > 0) {
         try {
            this.field_142.unread(this.field_135, 0, this.field_134);
         } catch (IOException var2) {
            throw this.method_193(258);
         }
      }
   }

   // $VF: renamed from: web () void
   public void method_189() {
      this.field_134 = -1;
      this.field_136 = -1;
      this.field_137 = -1;
   }

   // $VF: renamed from: wrq (int) boolean
   public boolean method_190(int syncmode) throws Class_356 {
      int read = this.method_202(this.field_144, 0, 4);
      int headerstring = this.field_144[0] << 24 & 0xFF000000
         | this.field_144[1] << 16 & 0xFF0000
         | this.field_144[2] << 8 & 0xFF00
         | this.field_144[3] << 0 & 0xFF;

      try {
         this.field_142.unread(this.field_144, 0, read);
      } catch (IOException var5) {
      }

      boolean sync = false;
      switch (read) {
         case 0:
            sync = true;
            break;
         case 4:
            sync = this.method_196(headerstring, syncmode, this.field_138);
      }

      return sync;
   }

   // $VF: renamed from: xdh (int) int
   public int method_191(int n) {
      return this.method_199(n);
   }

   // $VF: renamed from: ck (int) int
   public int method_192(int n) {
      return this.method_199(n);
   }

   // $VF: renamed from: gqb (int) Class_356
   protected Class_356 method_193(int errorcode) {
      return new Class_356(errorcode, null);
   }

   // $VF: renamed from: ku (int, java.lang.Throwable) Class_356
   protected Class_356 method_194(int errorcode, Throwable throwable) {
      return new Class_356(errorcode, throwable);
   }

   // $VF: renamed from: xry (byte) int
   int method_195(byte syncmode) throws Class_356 {
      int bytesRead = this.method_202(this.field_144, 0, 3);
      if (bytesRead != 3) {
         throw this.method_194(260, null);
      } else {
         int headerstring = this.field_144[0] << 16 & 0xFF0000 | this.field_144[1] << 8 & 0xFF00 | this.field_144[2] << 0 & 0xFF;

         boolean sync;
         do {
            headerstring <<= 8;
            if (this.method_202(this.field_144, 3, 1) != 1) {
               throw this.method_194(260, null);
            }

            headerstring |= this.field_144[3] & 255;
            sync = this.method_196(headerstring, syncmode, this.field_138);
         } while (!sync);

         return headerstring;
      }
   }

   // $VF: renamed from: wch (int, int, int) boolean
   public boolean method_196(int headerstring, int syncmode, int word) {
      boolean sync = false;
      if (syncmode == field_130) {
         sync = (headerstring & -2097152) == -2097152;
      } else {
         sync = (headerstring & -521216) == word && (headerstring & 192) == 192 == this.field_140;
      }

      if (sync) {
         sync = (headerstring >>> 10 & 3) != 3;
      }

      if (sync) {
         sync = (headerstring >>> 17 & 3) != 0;
      }

      if (sync) {
         sync = (headerstring >>> 19 & 3) != 1;
      }

      return sync;
   }

   // $VF: renamed from: lx (int) int
   int method_197(int bytesize) throws Class_356 {
      int numread = 0;
      numread = this.method_201(this.field_135, 0, bytesize);
      this.field_134 = bytesize;
      this.field_136 = -1;
      this.field_137 = -1;
      return numread;
   }

   // $VF: renamed from: mtb () void
   void method_198() throws Class_356 {
      int b = 0;
      byte[] byteread = this.field_135;
      int bytesize = this.field_134;

      for (int k = 0; k < bytesize; k += 4) {
         int convert = 0;
         byte b0 = 0;
         byte b1 = 0;
         byte b2 = 0;
         byte b3 = 0;
         b0 = byteread[k];
         if (k + 1 < bytesize) {
            b1 = byteread[k + 1];
         }

         if (k + 2 < bytesize) {
            b2 = byteread[k + 2];
         }

         if (k + 3 < bytesize) {
            b3 = byteread[k + 3];
         }

         this.field_133[b++] = b0 << 24 & 0xFF000000 | b1 << 16 & 0xFF0000 | b2 << 8 & 0xFF00 | b3 & 255;
      }

      this.field_136 = 0;
      this.field_137 = 0;
   }

   // $VF: renamed from: um (int) int
   public int method_199(int number_of_bits) {
      int returnvalue = 0;
      int sum = this.field_137 + number_of_bits;
      if (this.field_136 < 0) {
         this.field_136 = 0;
      }

      if (sum <= 32) {
         returnvalue = this.field_133[this.field_136] >>> 32 - sum & this.field_141[number_of_bits];
         if ((this.field_137 += number_of_bits) == 32) {
            this.field_137 = 0;
            this.field_136++;
         }

         return returnvalue;
      } else {
         int Right = this.field_133[this.field_136] & 65535;
         this.field_136++;
         int Left = this.field_133[this.field_136] & -65536;
         returnvalue = Right << 16 & -65536 | Left >>> 16 & 65535;
         returnvalue >>>= 48 - sum;
         returnvalue &= this.field_141[number_of_bits];
         this.field_137 = sum - 32;
         return returnvalue;
      }
   }

   // $VF: renamed from: cw (int) void
   void method_200(int syncword0) {
      this.field_138 = syncword0 & -193;
      this.field_140 = (syncword0 & 192) == 192;
   }

   // $VF: renamed from: gtc (byte[], int, int) int
   private int method_201(byte[] b, int offs, int len) throws Class_356 {
      int nRead = 0;

      try {
         while (len > 0) {
            int bytesread = this.field_142.read(b, offs, len);
            if (bytesread == -1) {
               while (len-- > 0) {
                  b[offs++] = 0;
               }
               break;
            }

            nRead += bytesread;
            offs += bytesread;
            len -= bytesread;
         }

         return nRead;
      } catch (IOException var6) {
         throw this.method_194(258, var6);
      }
   }

   // $VF: renamed from: uz (byte[], int, int) int
   private int method_202(byte[] b, int offs, int len) throws Class_356 {
      int totalBytesRead = 0;

      try {
         while (len > 0) {
            int bytesread = this.field_142.read(b, offs, len);
            if (bytesread == -1) {
               break;
            }

            totalBytesRead += bytesread;
            offs += bytesread;
            len -= bytesread;
         }

         return totalBytesRead;
      } catch (IOException var6) {
         throw this.method_194(258, var6);
      }
   }
}

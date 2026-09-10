import java.io.IOException;
import java.io.RandomAccessFile;

public class Class_170 {
   // $VF: renamed from: yqv int
   public static final int field_712 = 0;
   // $VF: renamed from: xmk int
   public static final int field_713 = 1;
   // $VF: renamed from: pd int
   public static final int field_714 = 2;
   // $VF: renamed from: kme int
   public static final int field_715 = 3;
   // $VF: renamed from: was int
   public static final int field_716 = 4;
   // $VF: renamed from: abb int
   public static final int field_717 = 5;
   // $VF: renamed from: tdd int
   public static final int field_718 = 6;
   // $VF: renamed from: fpa int
   public static final int field_719 = 0;
   // $VF: renamed from: oga int
   public static final int field_720 = 1;
   public static final int xcdl = 2;
   // $VF: renamed from: ylc Class_102
   private Class_102 field_721;
   // $VF: renamed from: vuj int
   protected int field_722;
   // $VF: renamed from: klk java.io.RandomAccessFile
   protected RandomAccessFile field_723 = null;

   public Class_170() {
      this.field_722 = 0;
      this.field_721 = new Class_102(this);
      this.field_721.field_751 = method_723("RIFF");
      this.field_721.field_752 = 0;
   }

   // $VF: renamed from: va () int
   public int method_708() {
      return this.field_722;
   }

   // $VF: renamed from: lr (java.lang.String, int) int
   public int method_709(String Filename, int NewMode) {
      int retcode = 0;
      if (this.field_722 != 0) {
         retcode = this.method_717();
      }

      if (retcode == 0) {
         switch (NewMode) {
            case 1:
               try {
                  this.field_723 = new RandomAccessFile(Filename, "rw");

                  try {
                     byte[] br = new byte[8];
                     br[0] = (byte)(this.field_721.field_751 >>> 24 & 0xFF);
                     br[1] = (byte)(this.field_721.field_751 >>> 16 & 0xFF);
                     br[2] = (byte)(this.field_721.field_751 >>> 8 & 0xFF);
                     br[3] = (byte)(this.field_721.field_751 & 0xFF);
                     byte br4 = (byte)(this.field_721.field_752 >>> 24 & 0xFF);
                     byte br5 = (byte)(this.field_721.field_752 >>> 16 & 0xFF);
                     byte br6 = (byte)(this.field_721.field_752 >>> 8 & 0xFF);
                     byte br7 = (byte)(this.field_721.field_752 & 0xFF);
                     br[4] = br7;
                     br[5] = br6;
                     br[6] = br5;
                     br[7] = br4;
                     this.field_723.write(br, 0, 8);
                     this.field_722 = 1;
                  } catch (IOException var11) {
                     this.field_723.close();
                     this.field_722 = 0;
                  }
               } catch (IOException var12) {
                  this.field_722 = 0;
                  retcode = 3;
               }
               break;
            case 2:
               try {
                  this.field_723 = new RandomAccessFile(Filename, "r");

                  try {
                     byte[] br = new byte[8];
                     this.field_723.read(br, 0, 8);
                     this.field_722 = 2;
                     this.field_721.field_751 = br[0] << 24 & 0xFF000000 | br[1] << 16 & 0xFF0000 | br[2] << 8 & 0xFF00 | br[3] & 255;
                     this.field_721.field_752 = br[4] << 24 & 0xFF000000 | br[5] << 16 & 0xFF0000 | br[6] << 8 & 0xFF00 | br[7] & 255;
                  } catch (IOException var9) {
                     this.field_723.close();
                     this.field_722 = 0;
                  }
               } catch (IOException var10) {
                  this.field_722 = 0;
                  retcode = 3;
               }
               break;
            default:
               retcode = 4;
         }
      }

      return retcode;
   }

   // $VF: renamed from: hvd (byte[], int) int
   public int method_710(byte[] Data, int NumBytes) {
      if (this.field_722 != 1) {
         return 4;
      } else {
         try {
            this.field_723.write(Data, 0, NumBytes);
            this.field_722 = 1;
         } catch (IOException var4) {
            return 3;
         }

         this.field_721.field_752 += NumBytes;
         return 0;
      }
   }

   // $VF: renamed from: dpk (short[], int) int
   public int method_711(short[] Data, int NumBytes) {
      byte[] theData = new byte[NumBytes];
      int yc = 0;

      for (int y = 0; y < NumBytes; y += 2) {
         theData[y] = (byte)(Data[yc] & 255);
         theData[y + 1] = (byte)(Data[yc++] >>> 8 & 0xFF);
      }

      if (this.field_722 != 1) {
         return 4;
      } else {
         try {
            this.field_723.write(theData, 0, NumBytes);
            this.field_722 = 1;
         } catch (IOException var6) {
            return 3;
         }

         this.field_721.field_752 += NumBytes;
         return 0;
      }
   }

   // $VF: renamed from: tur (Class_102, int) int
   public int method_712(Class_102 Triff_header, int NumBytes) {
      byte[] br = new byte[8];
      br[0] = (byte)(Triff_header.field_751 >>> 24 & 0xFF);
      br[1] = (byte)(Triff_header.field_751 >>> 16 & 0xFF);
      br[2] = (byte)(Triff_header.field_751 >>> 8 & 0xFF);
      br[3] = (byte)(Triff_header.field_751 & 0xFF);
      byte br4 = (byte)(Triff_header.field_752 >>> 24 & 0xFF);
      byte br5 = (byte)(Triff_header.field_752 >>> 16 & 0xFF);
      byte br6 = (byte)(Triff_header.field_752 >>> 8 & 0xFF);
      byte br7 = (byte)(Triff_header.field_752 & 0xFF);
      br[4] = br7;
      br[5] = br6;
      br[6] = br5;
      br[7] = br4;
      if (this.field_722 != 1) {
         return 4;
      } else {
         try {
            this.field_723.write(br, 0, NumBytes);
            this.field_722 = 1;
         } catch (IOException var9) {
            return 3;
         }

         this.field_721.field_752 += NumBytes;
         return 0;
      }
   }

   // $VF: renamed from: lw (short, int) int
   public int method_713(short Data, int NumBytes) {
      short theData = (short)(Data >>> 8 & 0xFF | Data << 8 & 0xFF00);
      if (this.field_722 != 1) {
         return 4;
      } else {
         try {
            this.field_723.writeShort(theData);
            this.field_722 = 1;
         } catch (IOException var5) {
            return 3;
         }

         this.field_721.field_752 += NumBytes;
         return 0;
      }
   }

   // $VF: renamed from: gg (int, int) int
   public int method_714(int Data, int NumBytes) {
      short theDataL = (short)(Data >>> 16 & 65535);
      short theDataR = (short)(Data & 65535);
      short theDataLI = (short)(theDataL >>> 8 & 0xFF | theDataL << 8 & 0xFF00);
      short theDataRI = (short)(theDataR >>> 8 & 0xFF | theDataR << 8 & 0xFF00);
      int theData = theDataRI << 16 & -65536 | theDataLI & '\uffff';
      if (this.field_722 != 1) {
         return 4;
      } else {
         try {
            this.field_723.writeInt(theData);
            this.field_722 = 1;
         } catch (IOException var9) {
            return 3;
         }

         this.field_721.field_752 += NumBytes;
         return 0;
      }
   }

   // $VF: renamed from: quh (byte[], int) int
   public int method_715(byte[] Data, int NumBytes) {
      int retcode = 0;

      try {
         this.field_723.read(Data, 0, NumBytes);
      } catch (IOException var5) {
         retcode = 3;
      }

      return retcode;
   }

   // $VF: renamed from: ncr (java.lang.String, int) int
   public int method_716(String Data, int NumBytes) {
      byte target = 0;
      int cnt = 0;

      try {
         while (NumBytes-- != 0) {
            target = this.field_723.readByte();
            if (target != Data.charAt(cnt++)) {
               return 3;
            }
         }

         return 0;
      } catch (IOException var6) {
         return 3;
      }
   }

   // $VF: renamed from: xi () int
   public int method_717() {
      int retcode = 0;
      switch (this.field_722) {
         case 1:
            try {
               this.field_723.seek(0L);

               try {
                  byte[] br = new byte[8];
                  br[0] = (byte)(this.field_721.field_751 >>> 24 & 0xFF);
                  br[1] = (byte)(this.field_721.field_751 >>> 16 & 0xFF);
                  br[2] = (byte)(this.field_721.field_751 >>> 8 & 0xFF);
                  br[3] = (byte)(this.field_721.field_751 & 0xFF);
                  br[7] = (byte)(this.field_721.field_752 >>> 24 & 0xFF);
                  br[6] = (byte)(this.field_721.field_752 >>> 16 & 0xFF);
                  br[5] = (byte)(this.field_721.field_752 >>> 8 & 0xFF);
                  br[4] = (byte)(this.field_721.field_752 & 0xFF);
                  this.field_723.write(br, 0, 8);
                  this.field_723.close();
               } catch (IOException var4) {
                  retcode = 3;
               }
            } catch (IOException var5) {
               retcode = 3;
            }
            break;
         case 2:
            try {
               this.field_723.close();
            } catch (IOException var3) {
               retcode = 3;
            }
      }

      this.field_723 = null;
      this.field_722 = 0;
      return retcode;
   }

   // $VF: renamed from: hwo () long
   public long method_718() {
      long position;
      try {
         position = this.field_723.getFilePointer();
      } catch (IOException var4) {
         position = -1L;
      }

      return position;
   }

   // $VF: renamed from: bm (long, Class_102, int) int
   public int method_719(long FileOffset, Class_102 Data, int NumBytes) {
      if (this.field_723 == null) {
         return 4;
      } else {
         try {
            this.field_723.seek(FileOffset);
         } catch (IOException var6) {
            return 3;
         }

         return this.method_712(Data, NumBytes);
      }
   }

   // $VF: renamed from: vlv (long, byte[], int) int
   public int method_720(long FileOffset, byte[] Data, int NumBytes) {
      if (this.field_723 == null) {
         return 4;
      } else {
         try {
            this.field_723.seek(FileOffset);
         } catch (IOException var6) {
            return 3;
         }

         return this.method_710(Data, NumBytes);
      }
   }

   // $VF: renamed from: dmg (long) int
   protected int method_721(long offset) {
      int rc;
      try {
         this.field_723.seek(offset);
         rc = 0;
      } catch (IOException var5) {
         rc = 3;
      }

      return rc;
   }

   // $VF: renamed from: omr (int) java.lang.String
   private String method_722(int retcode) {
      switch (retcode) {
         case 0:
            return "DDC_SUCCESS";
         case 1:
            return "DDC_FAILURE";
         case 2:
            return "DDC_OUT_OF_MEMORY";
         case 3:
            return "DDC_FILE_ERROR";
         case 4:
            return "DDC_INVALID_CALL";
         case 5:
            return "DDC_USER_ABORT";
         case 6:
            return "DDC_INVALID_FILE";
         default:
            return "Unknown Error";
      }
   }

   // $VF: renamed from: ls (java.lang.String) int
   public static int method_723(String ChunkName) {
      byte[] p = new byte[]{32, 32, 32, 32};
      ChunkName.getBytes(0, 4, p, 0);
      return p[0] << 24 & 0xFF000000 | p[1] << 16 & 0xFF0000 | p[2] << 8 & 0xFF00 | p[3] & 0xFF;
   }
}

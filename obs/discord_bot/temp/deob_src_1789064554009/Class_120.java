public class Class_120 extends Class_170 {
   // $VF: renamed from: ftq int
   public static final int field_724 = 2;
   // $VF: renamed from: ldu Class_309
   private Class_309 field_725;
   // $VF: renamed from: ngl Class_102
   private Class_102 field_726;
   // $VF: renamed from: ja long
   private long field_727 = 0L;
   // $VF: renamed from: oap int
   private int field_728 = 0;

   public Class_120() {
      this.field_726 = new Class_102(this);
      this.field_725 = new Class_309(this);
      this.field_726.field_751 = FourCC("data");
      this.field_726.field_752 = 0;
      this.field_728 = 0;
   }

   // $VF: renamed from: os (java.lang.String, int, short, short) int
   public int method_724(String Filename, int SamplingRate, short BitsPerSample, short NumChannels) {
      if (Filename != null && (BitsPerSample == 8 || BitsPerSample == 16) && NumChannels >= 1 && NumChannels <= 2) {
         this.field_725.field_276.method_645(SamplingRate, BitsPerSample, NumChannels);
         int retcode = this.Open(Filename, 1);
         if (retcode == 0) {
            byte[] theWave = new byte[]{87, 65, 86, 69};
            retcode = this.Write(theWave, 4);
            if (retcode == 0) {
               retcode = this.Write(this.field_725.field_275, 8);
               retcode = this.Write(this.field_725.field_276.field_608, 2);
               retcode = this.Write(this.field_725.field_276.field_609, 2);
               retcode = this.Write(this.field_725.field_276.field_610, 4);
               retcode = this.Write(this.field_725.field_276.field_611, 4);
               retcode = this.Write(this.field_725.field_276.field_612, 2);
               retcode = this.Write(this.field_725.field_276.field_613, 2);
               if (retcode == 0) {
                  this.field_727 = this.method_718();
                  retcode = this.Write(this.field_726, 8);
               }
            }
         }

         return retcode;
      } else {
         return 4;
      }
   }

   // $VF: renamed from: ebf (short[], int) int
   public int method_725(short[] data, int numData) {
      int extraBytes = numData * 2;
      this.field_726.field_752 += extraBytes;
      return super.method_711(data, extraBytes);
   }

   // $VF: renamed from: xi () int
   @Override
   public int method_717() {
      int rc = 0;
      if (this.fmode == 1) {
         rc = this.Backpatch(this.field_727, this.field_726, 8);
      }

      if (rc == 0) {
         rc = super.method_717();
      }

      return rc;
   }

   // $VF: renamed from: mvy () int
   public int method_726() {
      return this.field_725.field_276.field_610;
   }

   // $VF: renamed from: sdt () short
   public short method_727() {
      return this.field_725.field_276.field_613;
   }

   // $VF: renamed from: pwn () short
   public short method_728() {
      return this.field_725.field_276.field_609;
   }

   // $VF: renamed from: aun () int
   public int method_729() {
      return this.field_728;
   }

   // $VF: renamed from: tn (java.lang.String, Class_120) int
   public int method_730(String Filename, Class_120 OtherWave) {
      return this.method_724(Filename, OtherWave.method_726(), OtherWave.method_727(), OtherWave.method_728());
   }

   // $VF: renamed from: hwo () long
   @Override
   public long method_718() {
      return super.method_718();
   }
}

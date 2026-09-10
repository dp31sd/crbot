import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;

public class Class_59 extends Class_401 {
   // $VF: renamed from: ei javax.sound.sampled.SourceDataLine
   private SourceDataLine field_857 = null;
   // $VF: renamed from: mpi javax.sound.sampled.AudioFormat
   private AudioFormat field_858 = null;
   // $VF: renamed from: joo byte[]
   private byte[] field_859 = new byte[4096];

   // $VF: renamed from: cva (javax.sound.sampled.AudioFormat) void
   protected void method_909(AudioFormat fmt0) {
      this.field_858 = fmt0;
   }

   // $VF: renamed from: vmb () javax.sound.sampled.AudioFormat
   protected AudioFormat method_910() {
      if (this.field_858 == null) {
         Class_331 decoder = this.getDecoder();
         this.field_858 = new AudioFormat((float)decoder.method_275(), 16, decoder.method_276(), true, false);
      }

      return this.field_858;
   }

   // $VF: renamed from: mmp () javax.sound.sampled.DataLine.Info
   protected Info method_911() {
      AudioFormat fmt = this.method_910();
      return new Info(SourceDataLine.class, fmt);
   }

   // $VF: renamed from: lkf (javax.sound.sampled.AudioFormat) void
   public void method_912(AudioFormat fmt) throws Class_235 {
      if (!this.isOpen()) {
         this.method_909(fmt);
         this.openImpl();
         this.setOpen(true);
      }
   }

   @Override
   protected void openImpl() throws Class_235 {
   }

   // $VF: renamed from: tru () void
   protected void method_913() throws Class_235 {
      Throwable t = null;

      try {
         Line line = AudioSystem.getLine(this.method_911());
         if (line instanceof SourceDataLine) {
            this.field_857 = (SourceDataLine)line;
            this.field_857.open(this.field_858);
            this.field_857.start();
         }
      } catch (RuntimeException var3) {
         t = var3;
      } catch (LinkageError var4) {
         t = var4;
      } catch (LineUnavailableException var5) {
         t = var5;
      }

      if (this.field_857 == null) {
         throw new Class_235("cannot obtain source audio line", t);
      }
   }

   // $VF: renamed from: pul (javax.sound.sampled.AudioFormat, int) int
   public int method_914(AudioFormat fmt, int time) {
      return (int)((double)((float)time * fmt.getSampleRate() * (float)fmt.getChannels() * (float)fmt.getSampleSizeInBits()) / 8000.0);
   }

   @Override
   protected void closeImpl() {
      if (this.field_857 != null) {
         this.field_857.close();
      }
   }

   @Override
   protected void writeImpl(short[] samples, int offs, int len) throws Class_235 {
      if (this.field_857 == null) {
         this.method_913();
      }

      byte[] b = this.pmqa(samples, offs, len);
      this.field_857.write(b, 0, len * 2);
   }

   // $VF: renamed from: gqr (int) byte[]
   protected byte[] method_915(int length) {
      if (this.field_859.length < length) {
         this.field_859 = new byte[length + 1024];
      }

      return this.field_859;
   }

   protected byte[] pmqa(short[] samples, int offs, int len) {
      byte[] b = this.method_915(len * 2);
      int idx = 0;

      while (len-- > 0) {
         short s = samples[offs++];
         b[idx++] = (byte)s;
         b[idx++] = (byte)(s >>> 8);
      }

      return b;
   }

   @Override
   protected void flushImpl() {
      if (this.field_857 != null) {
         this.field_857.drain();
      }
   }

   @Override
   public int getPosition() {
      int pos = 0;
      if (this.field_857 != null) {
         pos = (int)(this.field_857.getMicrosecondPosition() / 1000L);
      }

      return pos;
   }

   // $VF: renamed from: ujt () void
   public void method_916() throws Class_235 {
      try {
         this.method_912(new AudioFormat(22050.0F, 16, 1, true, false));
         short[] data = new short[2205];
         this.write(data, 0, data.length);
         this.flush();
         this.close();
      } catch (RuntimeException var2) {
         throw new Class_235("Device test failed: " + var2);
      }
   }
}

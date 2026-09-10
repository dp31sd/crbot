import java.io.InputStream;

public class Class_370 {
   // $VF: renamed from: bxf int
   private int field_148 = 0;
   // $VF: renamed from: hdc Class_371
   private Class_371 field_149;
   // $VF: renamed from: nzg Class_331
   private Class_331 field_150;
   // $VF: renamed from: kxq Class_200
   private Class_200 field_151;
   // $VF: renamed from: rmq boolean
   private boolean field_152 = false;
   // $VF: renamed from: ot boolean
   private boolean field_153 = false;
   // $VF: renamed from: rt int
   private int field_154 = 0;

   public Class_370(InputStream stream) throws Class_235 {
      this(stream, null);
   }

   public Class_370(InputStream stream, Class_200 device) throws Class_235 {
      this.field_149 = new Class_371(stream);
      this.field_150 = new Class_331();
      if (device != null) {
         this.field_151 = device;
      } else {
         Class_379 r = Class_379.method_821();
         this.field_151 = r.createAudioDevice();
      }

      this.field_151.open(this.field_150);
   }

   // $VF: renamed from: xho () void
   public void method_203() throws Class_235 {
      this.method_204(Integer.MAX_VALUE);
   }

   // $VF: renamed from: xo (int) boolean
   public boolean method_204(int frames) throws Class_235 {
      boolean ret = true;

      while (frames-- > 0 && ret) {
         ret = this.method_208();
      }

      if (!ret) {
         Class_200 out = this.field_151;
         if (out != null) {
            out.flush();
            synchronized (this) {
               this.field_153 = !this.field_152;
               this.method_205();
            }
         }
      }

      return ret;
   }

   // $VF: renamed from: tjv () void
   public synchronized void method_205() {
      Class_200 out = this.field_151;
      if (out != null) {
         this.field_152 = true;
         this.field_151 = null;
         out.close();
         this.field_154 = out.getPosition();

         try {
            this.field_149.method_184();
         } catch (Class_356 var3) {
         }
      }
   }

   // $VF: renamed from: hbf () boolean
   public synchronized boolean method_206() {
      return this.field_153;
   }

   // $VF: renamed from: qb () int
   public int method_207() {
      int position = this.field_154;
      Class_200 out = this.field_151;
      if (out != null) {
         position = out.getPosition();
      }

      return position;
   }

   // $VF: renamed from: cun () boolean
   protected boolean method_208() throws Class_235 {
      try {
         Class_200 out = this.field_151;
         if (out == null) {
            return false;
         } else {
            Class_412 h = this.field_149.method_185();
            if (h == null) {
               return false;
            } else {
               Class_197 output = (Class_197)this.field_150.method_273(h, this.field_149);
               synchronized (this) {
                  out = this.field_151;
                  if (out != null) {
                     out.write(output.method_591(), 0, output.method_592());
                  }
               }

               this.field_149.method_189();
               return true;
            }
         }
      } catch (RuntimeException var7) {
         throw new Class_235("Exception decoding audio frame", var7);
      }
   }
}

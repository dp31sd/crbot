import java.io.InputStream;

public class EventHandler_288 {
   // $VF: renamed from: hdc Class_371
   private Class_371 field_306;
   // $VF: renamed from: nzg Class_331
   private Class_331 field_307;
   // $VF: renamed from: kxq Class_200
   private Class_200 field_308;
   // $VF: renamed from: rmq boolean
   private boolean field_309 = false;
   // $VF: renamed from: ot boolean
   private boolean field_310 = false;
   // $VF: renamed from: rt int
   private int field_311 = 0;
   // $VF: renamed from: sdt Class_283
   private Class_283 field_312;

   public EventHandler_288(InputStream stream) throws Class_235 {
      this(stream, null);
   }

   public EventHandler_288(InputStream stream, Class_200 device) throws Class_235 {
      this.field_306 = new Class_371(stream);
      if (device != null) {
         this.field_308 = device;
      } else {
         this.field_308 = Class_379.method_821().createAudioDevice();
      }

      this.field_308.open(this.field_307 = new Class_331());
   }

   // $VF: renamed from: es () void
   public void method_334() throws Class_235 {
      this.uvxd(Integer.MAX_VALUE);
   }

   public boolean uvxd(int frames) throws Class_235 {
      boolean ret = true;
      if (this.field_312 != null) {
         this.field_312.method_564(this.pbvg(Class_32.field_993));
      }

      while (frames-- > 0 && ret) {
         ret = this.method_336();
      }

      Class_200 out = this.field_308;
      if (out != null) {
         out.flush();
         synchronized (this) {
            this.field_310 = !this.field_309;
            this.method_335();
         }

         if (this.field_312 != null) {
            this.field_312.method_565(this.method_339(out, Class_32.field_992));
         }
      }

      return ret;
   }

   // $VF: renamed from: faj () void
   public synchronized void method_335() {
      Class_200 out = this.field_308;
      if (out != null) {
         this.field_309 = true;
         this.field_308 = null;
         out.close();
         this.field_311 = out.getPosition();

         try {
            this.field_306.method_184();
         } catch (Class_356 var3) {
         }
      }
   }

   // $VF: renamed from: hfw () boolean
   protected boolean method_336() throws Class_235 {
      try {
         Class_200 out = this.field_308;
         if (out == null) {
            return false;
         } else {
            Class_412 h = this.field_306.method_185();
            if (h == null) {
               return false;
            } else {
               Class_197 output = (Class_197)this.field_307.method_273(h, this.field_306);
               synchronized (this) {
                  out = this.field_308;
                  if (out != null) {
                     out.write(output.method_591(), 0, output.method_592());
                  }
               }

               this.field_306.method_189();
               return true;
            }
         }
      } catch (RuntimeException var7) {
         throw new Class_235("Exception decoding audio frame", var7);
      }
   }

   // $VF: renamed from: iwn () boolean
   protected boolean method_337() throws Class_235 {
      Class_412 h = this.field_306.method_185();
      if (h == null) {
         return false;
      } else {
         this.field_306.method_189();
         return true;
      }
   }

   // $VF: renamed from: mmu (int, int) boolean
   public boolean method_338(int start, int end) throws Class_235 {
      boolean ret = true;
      int offset = start;

      while (offset-- > 0 && ret) {
         ret = this.method_337();
      }

      return this.uvxd(end - start);
   }

   private Class_32 pbvg(int id) {
      return this.method_339(this.field_308, id);
   }

   // $VF: renamed from: okl (Class_200, int) Class_32
   private Class_32 method_339(Class_200 dev, int id) {
      return new Class_32(this, id, dev.getPosition());
   }

   // $VF: renamed from: ibm (Class_283) void
   public void method_340(Class_283 listener) {
      this.field_312 = listener;
   }

   // $VF: renamed from: sgx () Class_283
   public Class_283 method_341() {
      return this.field_312;
   }

   // $VF: renamed from: oeq () void
   public void method_342() {
      this.field_312.method_565(this.pbvg(Class_32.field_992));
      this.method_335();
   }
}

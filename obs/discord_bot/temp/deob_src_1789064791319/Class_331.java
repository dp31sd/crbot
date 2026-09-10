public class Class_331 implements Class_393 {
   // $VF: renamed from: gyl Class_332
   private static final Class_332 field_211 = new Class_332();
   // $VF: renamed from: lxl Class_278
   private Class_278 field_212;
   // $VF: renamed from: pcs Class_18
   private Class_18 field_213;
   // $VF: renamed from: xqf Class_18
   private Class_18 field_214;
   // $VF: renamed from: nzt Class_276
   private Class_276 field_215;
   // $VF: renamed from: kdg Class_323
   private Class_323 field_216;
   // $VF: renamed from: ooe Class_153
   private Class_153 field_217;
   // $VF: renamed from: qoj int
   private int field_218;
   // $VF: renamed from: du int
   private int field_219;
   // $VF: renamed from: mh Class_203
   private Class_203 field_220 = new Class_203();
   // $VF: renamed from: qxi Class_332
   private Class_332 field_221;
   // $VF: renamed from: eck boolean
   private boolean field_222;

   public Class_331() {
      this(null);
   }

   public Class_331(Class_332 params0) {
      if (params0 == null) {
         params0 = field_211;
      }

      this.field_221 = params0;
      Class_203 eq = this.field_221.method_270();
      if (eq != null) {
         this.field_220.method_553(eq);
      }
   }

   // $VF: renamed from: ofz () Class_332
   public static Class_332 method_271() {
      return (Class_332)field_211.clone();
   }

   // $VF: renamed from: wup (Class_203) void
   public void method_272(Class_203 eq) {
      if (eq == null) {
         eq = Class_203.field_504;
      }

      this.field_220.method_553(eq);
      float[] factors = this.field_220.method_558();
      if (this.field_213 != null) {
         this.field_213.method_1340(factors);
      }

      if (this.field_214 != null) {
         this.field_214.method_1340(factors);
      }
   }

   // $VF: renamed from: vey (Class_412, Class_371) Class_278
   public Class_278 method_273(Class_412 header, Class_371 stream) throws Class_3 {
      if (!this.field_222) {
         this.method_280(header);
      }

      int layer = header.method_46();
      this.field_212.clear_buffer();
      Class_186 decoder = this.method_279(header, stream, layer);
      decoder.method_29();
      this.field_212.write_buffer(1);
      return this.field_212;
   }

   // $VF: renamed from: bjv (Class_278) void
   public void method_274(Class_278 out) {
      this.field_212 = out;
   }

   // $VF: renamed from: adi () int
   public int method_275() {
      return this.field_218;
   }

   // $VF: renamed from: kp () int
   public int method_276() {
      return this.field_219;
   }

   // $VF: renamed from: ggy () int
   public int method_277() {
      return 2304;
   }

   // $VF: renamed from: jne (int) Class_3
   protected Class_3 method_278(int errorcode) {
      return new Class_3(errorcode, null);
   }

   protected Class_3 hgio(int errorcode, Throwable throwable) {
      return new Class_3(errorcode, throwable);
   }

   // $VF: renamed from: crk (Class_412, Class_371, int) Class_186
   protected Class_186 method_279(Class_412 header, Class_371 stream, int layer) throws Class_3 {
      Class_186 decoder = null;
      switch (layer) {
         case 1:
            if (this.field_217 == null) {
               this.field_217 = new Class_153();
               this.field_217.create(stream, header, this.field_213, this.field_214, this.field_212, 0);
            }

            decoder = this.field_217;
            break;
         case 2:
            if (this.field_216 == null) {
               this.field_216 = new Class_323();
               this.field_216.create(stream, header, this.field_213, this.field_214, this.field_212, 0);
            }

            decoder = this.field_216;
            break;
         case 3:
            if (this.field_215 == null) {
               this.field_215 = new Class_276(stream, header, this.field_213, this.field_214, this.field_212, 0);
            }

            decoder = this.field_215;
      }

      if (decoder == null) {
         throw this.hgio(513, null);
      } else {
         return decoder;
      }
   }

   // $VF: renamed from: dft (Class_412) void
   private void method_280(Class_412 header) throws Class_3 {
      float scalefactor = 32700.0F;
      int mode = header.method_50();
      int layer = header.method_46();
      int channels = mode == 3 ? 1 : 2;
      if (this.field_212 == null) {
         this.field_212 = new Class_197(header.method_49(), channels);
      }

      float[] factors = this.field_220.method_558();
      this.field_213 = new Class_18(0, scalefactor, factors);
      if (channels == 2) {
         this.field_214 = new Class_18(1, scalefactor, factors);
      }

      this.field_219 = channels;
      this.field_218 = header.method_49();
      this.field_222 = true;
   }
}

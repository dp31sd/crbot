public abstract class Class_401 implements Class_200 {
   // $VF: renamed from: hy boolean
   private boolean field_855 = false;
   // $VF: renamed from: nzg Class_331
   private Class_331 field_856 = null;

   @Override
   public synchronized void open(Class_331 decoder) throws Class_235 {
      if (!this.isOpen()) {
         this.field_856 = decoder;
         this.openImpl();
         this.setOpen(true);
      }
   }

   protected void openImpl() throws Class_235 {
   }

   protected void setOpen(boolean open) {
      this.field_855 = open;
   }

   @Override
   public synchronized boolean isOpen() {
      return this.field_855;
   }

   @Override
   public synchronized void close() {
      if (this.isOpen()) {
         this.closeImpl();
         this.setOpen(false);
         this.field_856 = null;
      }
   }

   protected void closeImpl() {
   }

   @Override
   public void write(short[] samples, int offs, int len) throws Class_235 {
      if (this.isOpen()) {
         this.writeImpl(samples, offs, len);
      }
   }

   protected void writeImpl(short[] samples, int offs, int len) throws Class_235 {
   }

   @Override
   public void flush() {
      if (this.isOpen()) {
         this.flushImpl();
      }
   }

   protected void flushImpl() {
   }

   protected Class_331 getDecoder() {
      return this.field_856;
   }
}

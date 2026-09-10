public class Class_72 extends Class_140 {
   // $VF: renamed from: uwo boolean
   private boolean field_798 = false;
   // $VF: renamed from: wg java.lang.String
   private static final String field_799 = "javazoom.jl.player.JavaSoundAudioDevice";

   @Override
   public synchronized Class_200 createAudioDevice() throws Class_235 {
      if (!this.field_798) {
         this.method_827();
         this.field_798 = true;
      }

      try {
         return this.method_826();
      } catch (Exception var2) {
         throw new Class_235("unable to create JavaSound device: " + var2);
      } catch (LinkageError var3) {
         throw new Class_235("unable to create JavaSound device: " + var3);
      }
   }

   // $VF: renamed from: zby () Class_59
   protected Class_59 method_826() throws Class_235 {
      ClassLoader loader = this.getClass().getClassLoader();

      try {
         return (Class_59)this.instantiate(loader, "javazoom.jl.player.JavaSoundAudioDevice");
      } catch (Exception var3) {
         throw new Class_235("Cannot create JavaSound device", var3);
      } catch (LinkageError var4) {
         throw new Class_235("Cannot create JavaSound device", var4);
      }
   }

   // $VF: renamed from: hvr () void
   public void method_827() throws Class_235 {
      Class_59 dev = this.method_826();
      dev.method_916();
   }
}

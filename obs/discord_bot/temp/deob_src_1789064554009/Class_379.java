import java.util.Enumeration;
import java.util.Hashtable;

public class Class_379 extends Class_140 {
   // $VF: renamed from: bwi Class_379
   private static Class_379 field_796 = null;
   // $VF: renamed from: rrj java.util.Hashtable
   protected Hashtable field_797 = new Hashtable();

   // $VF: renamed from: igh () Class_379
   public static synchronized Class_379 method_821() {
      if (field_796 == null) {
         field_796 = new Class_379();
         field_796.method_825();
      }

      return field_796;
   }

   public void vtcw(Class_140 factory) {
      this.field_797.put(factory.getClass(), factory);
   }

   // $VF: renamed from: olk (java.lang.Class) void
   public void method_822(Class cls) {
      this.field_797.remove(cls);
   }

   // $VF: renamed from: mcr (Class_140) void
   public void method_823(Class_140 factory) {
      this.field_797.remove(factory.getClass());
   }

   @Override
   public Class_200 createAudioDevice() throws Class_235 {
      Class_200 device = null;
      Class_140[] factories = this.method_824();
      if (factories == null) {
         throw new Class_235(this + ": no factories registered");
      } else {
         Class_235 lastEx = null;

         for (int i = 0; device == null && i < factories.length; i++) {
            try {
               device = factories[i].createAudioDevice();
            } catch (Class_235 var6) {
               lastEx = var6;
            }
         }

         if (device == null && lastEx != null) {
            throw new Class_235("Cannot create AudioDevice", lastEx);
         } else {
            return device;
         }
      }
   }

   // $VF: renamed from: aqn () Class_140[]
   protected Class_140[] method_824() {
      Class_140[] fa = null;
      synchronized (this.field_797) {
         int size = this.field_797.size();
         if (size != 0) {
            fa = new Class_140[size];
            int idx = 0;
            Enumeration e = this.field_797.elements();

            while (e.hasMoreElements()) {
               Class_140 factory = (Class_140)e.nextElement();
               fa[idx++] = factory;
            }
         }

         return fa;
      }
   }

   // $VF: renamed from: rpl () void
   protected void method_825() {
      this.vtcw(new Class_72());
   }
}

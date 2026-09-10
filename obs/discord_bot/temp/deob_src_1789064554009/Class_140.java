public abstract class Class_140 {
   public abstract Class_200 createAudioDevice() throws Class_235;

   protected Class_200 instantiate(ClassLoader loader, String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
      Class_200 dev = null;
      Class cls = null;
      if (loader == null) {
         cls = Class.forName(name);
      } else {
         cls = loader.loadClass(name);
      }

      Object o = cls.newInstance();
      return (Class_200)o;
   }
}

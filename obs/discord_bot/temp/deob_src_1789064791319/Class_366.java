import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;

public class Class_366 {
   // $VF: renamed from: cx Class_244
   private static Class_244 field_176 = null;

   // $VF: renamed from: txn (java.io.InputStream, java.lang.Class) java.lang.Object
   public static Object method_244(InputStream in, Class cls) throws IOException {
      if (cls == null) {
         throw new NullPointerException("cls");
      } else {
         Object obj = method_244(in, cls);
         if (!cls.isInstance(obj)) {
            throw new InvalidObjectException("type of deserialized instance not of required class.");
         } else {
            return obj;
         }
      }
   }

   // $VF: renamed from: en (java.io.InputStream) java.lang.Object
   public static Object method_245(InputStream in) throws IOException {
      if (in == null) {
         throw new NullPointerException("in");
      } else {
         ObjectInputStream objIn = new ObjectInputStream(in);

         try {
            return objIn.readObject();
         } catch (ClassNotFoundException var4) {
            throw new InvalidClassException(var4.toString());
         }
      }
   }

   // $VF: renamed from: dnb (java.io.InputStream, java.lang.Class, int) java.lang.Object
   public static Object method_246(InputStream in, Class elemType, int length) throws IOException {
      if (elemType == null) {
         throw new NullPointerException("elemType");
      } else if (length < -1) {
         throw new IllegalArgumentException("length");
      } else {
         Object obj = method_245(in);
         Class cls = obj.getClass();
         if (!cls.isArray()) {
            throw new InvalidObjectException("object is not an array");
         } else {
            Class arrayElemType = cls.getComponentType();
            if (arrayElemType != elemType) {
               throw new InvalidObjectException("unexpected array component type");
            } else {
               if (length != -1) {
                  int arrayLength = Array.getLength(obj);
                  if (arrayLength != length) {
                     throw new InvalidObjectException("array length mismatch");
                  }
               }

               return obj;
            }
         }
      }
   }

   // $VF: renamed from: obr (java.lang.String, java.lang.Class, int) java.lang.Object
   public static Object method_247(String name, Class elemType, int length) throws IOException {
      InputStream str = method_251(name);
      if (str == null) {
         throw new IOException("unable to load resource '" + name + "'");
      } else {
         return method_246(str, elemType, length);
      }
   }

   // $VF: renamed from: gns (java.io.OutputStream, java.lang.Object) void
   public static void method_248(OutputStream out, Object obj) throws IOException {
      if (out == null) {
         throw new NullPointerException("out");
      } else if (obj == null) {
         throw new NullPointerException("obj");
      } else {
         ObjectOutputStream objOut = new ObjectOutputStream(out);
         objOut.writeObject(obj);
      }
   }

   // $VF: renamed from: iuh (Class_244) void
   public static synchronized void method_249(Class_244 hook0) {
      field_176 = hook0;
   }

   // $VF: renamed from: nef () Class_244
   public static synchronized Class_244 method_250() {
      return field_176;
   }

   // $VF: renamed from: rfg (java.lang.String) java.io.InputStream
   public static synchronized InputStream method_251(String name) {
      InputStream is = null;
      if (field_176 != null) {
         is = field_176.method_30(name);
      } else {
         Class cls = Class_366.class;
         is = cls.getResourceAsStream(name);
      }

      return is;
   }
}

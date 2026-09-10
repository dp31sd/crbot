import java.util.ArrayList;
import java.util.List;

public class Class_184 {
   // $VF: renamed from: nb java.lang.String
   public String field_560;
   // $VF: renamed from: wvm java.util.List
   public List field_561 = new ArrayList();

   public Class_184(String var1) {
      this.field_560 = var1;
   }

   // $VF: renamed from: djx (Class_162) boolean
   public boolean method_606(Class_162 var1) {
      return this.field_561.add(var1);
   }

   // $VF: renamed from: kjy (Class_388) boolean
   public boolean method_607(Class_388 var1) {
      return this.method_608(var1) != null;
   }

   // $VF: renamed from: fg (Class_388) Class_162
   public Class_162 method_608(Class_388 var1) {
      if (var1 == null) {
         return null;
      } else {
         for (Class_162 var3 : this.field_561) {
            if (var3.field_578.method_874().equals(var1)) {
               return var3;
            }
         }

         return null;
      }
   }

   // $VF: renamed from: iro () java.lang.String
   public String method_609() {
      return this.field_560;
   }
}

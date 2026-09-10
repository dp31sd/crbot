import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;

public final class Class_133 {
   // $VF: renamed from: crf java.lang.String
   private final String field_677;
   // $VF: renamed from: syv java.lang.String
   private final String field_678;
   // $VF: renamed from: aqs java.net.SocketAddress
   private final SocketAddress field_679;
   // $VF: renamed from: rkl java.net.SocketAddress
   private final SocketAddress field_680;
   // $VF: renamed from: yid java.lang.String
   private String field_681;

   public Class_133(String protocol, String authScheme, SocketAddress proxyAddress, SocketAddress destinationAddress) {
      this.field_677 = (String)ObjectUtil.checkNotNull(protocol, "protocol");
      this.field_678 = (String)ObjectUtil.checkNotNull(authScheme, "authScheme");
      this.field_679 = (SocketAddress)ObjectUtil.checkNotNull(proxyAddress, "proxyAddress");
      this.field_680 = (SocketAddress)ObjectUtil.checkNotNull(destinationAddress, "destinationAddress");
   }

   // $VF: renamed from: dzt () java.lang.String
   public String method_668() {
      return this.field_677;
   }

   // $VF: renamed from: rl () java.lang.String
   public String method_669() {
      return this.field_678;
   }

   // $VF: renamed from: sqi () java.net.SocketAddress
   public SocketAddress method_670() {
      return this.field_679;
   }

   // $VF: renamed from: ts () java.net.SocketAddress
   public SocketAddress method_671() {
      return this.field_680;
   }

   @Override
   public String toString() {
      if (this.field_681 != null) {
         return this.field_681;
      } else {
         StringBuilder buf = new StringBuilder(128)
            .append(StringUtil.simpleClassName(this))
            .append('(')
            .append(this.field_677)
            .append(", ")
            .append(this.field_678)
            .append(", ")
            .append(this.field_679)
            .append(" => ")
            .append(this.field_680)
            .append(')');
         return this.field_681 = buf.toString();
      }
   }
}

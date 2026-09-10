import io.netty.handler.codec.http.HttpHeaders;

public final class Class_260 extends Class_121 {
   // $VF: renamed from: d long
   private static final long field_1503 = -8824334609292146066L;
   // $VF: renamed from: b io.netty.handler.codec.http.HttpHeaders
   private final HttpHeaders field_1504;

   public Class_260(String message, HttpHeaders headers) {
      super(message);
      this.field_1504 = headers;
   }

   // $VF: renamed from: z () io.netty.handler.codec.http.HttpHeaders
   public HttpHeaders method_1393() {
      return this.field_1504;
   }
}

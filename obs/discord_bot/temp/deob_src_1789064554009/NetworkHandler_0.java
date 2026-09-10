import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.base64.Base64;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public final class NetworkHandler_0 extends EventHandler_196 {
   // $VF: renamed from: ln java.lang.String
   private static final String field_2400 = "http";
   // $VF: renamed from: sy java.lang.String
   private static final String field_2401 = "basic";
   // $VF: renamed from: lg NetworkHandler_249
   private final NetworkHandler_249 field_2402 = new NetworkHandler_249();
   // $VF: renamed from: qdq java.lang.String
   private final String field_2403;
   // $VF: renamed from: sx java.lang.String
   private final String field_2404;
   // $VF: renamed from: kc java.lang.CharSequence
   private final CharSequence field_2405;
   // $VF: renamed from: we io.netty.handler.codec.http.HttpHeaders
   private final HttpHeaders field_2406;
   // $VF: renamed from: kzm boolean
   private final boolean field_2407;
   // $VF: renamed from: dj io.netty.handler.codec.http.HttpResponseStatus
   private HttpResponseStatus field_2408;
   // $VF: renamed from: xe io.netty.handler.codec.http.HttpHeaders
   private HttpHeaders field_2409;

   public NetworkHandler_0(SocketAddress proxyAddress) {
      this(proxyAddress, null);
   }

   public NetworkHandler_0(SocketAddress proxyAddress, HttpHeaders headers) {
      this(proxyAddress, headers, false);
   }

   public NetworkHandler_0(SocketAddress proxyAddress, HttpHeaders headers, boolean ignoreDefaultPortsInConnectHostHeader) {
      super(proxyAddress);
      this.field_2403 = null;
      this.field_2404 = null;
      this.field_2405 = null;
      this.field_2406 = headers;
      this.field_2407 = ignoreDefaultPortsInConnectHostHeader;
   }

   public NetworkHandler_0(SocketAddress proxyAddress, String username, String password) {
      this(proxyAddress, username, password, null);
   }

   public NetworkHandler_0(SocketAddress proxyAddress, String username, String password, HttpHeaders headers) {
      this(proxyAddress, username, password, headers, false);
   }

   public NetworkHandler_0(SocketAddress proxyAddress, String username, String password, HttpHeaders headers, boolean ignoreDefaultPortsInConnectHostHeader) {
      super(proxyAddress);
      this.field_2403 = (String)ObjectUtil.checkNotNull(username, "username");
      this.field_2404 = (String)ObjectUtil.checkNotNull(password, "password");
      ByteBuf authz = Unpooled.copiedBuffer(username + ':' + password, CharsetUtil.UTF_8);

      ByteBuf authzBase64;
      try {
         authzBase64 = Base64.encode(authz, false);
      } finally {
         authz.release();
      }

      try {
         this.field_2405 = new AsciiString("Basic " + authzBase64.toString(CharsetUtil.US_ASCII));
      } finally {
         authzBase64.release();
      }

      this.field_2406 = headers;
      this.field_2407 = ignoreDefaultPortsInConnectHostHeader;
   }

   @Override
   public String protocol() {
      return "http";
   }

   @Override
   public String authScheme() {
      return this.field_2405 != null ? "basic" : "none";
   }

   // $VF: renamed from: mx () java.lang.String
   public String method_2004() {
      return this.field_2403;
   }

   // $VF: renamed from: ek () java.lang.String
   public String method_2005() {
      return this.field_2404;
   }

   @Override
   protected void addCodec(ChannelHandlerContext ctx) throws Exception {
      ChannelPipeline p = ctx.pipeline();
      String name = ctx.name();
      p.addBefore(name, null, this.field_2402);
   }

   @Override
   protected void removeEncoder(ChannelHandlerContext ctx) throws Exception {
      this.field_2402.field_445.removeOutboundHandler();
   }

   @Override
   protected void removeDecoder(ChannelHandlerContext ctx) throws Exception {
      this.field_2402.field_445.removeInboundHandler();
   }

   @Override
   protected Object newInitialMessage(ChannelHandlerContext ctx) throws Exception {
      InetSocketAddress raddr = this.destinationAddress();
      String hostString = HttpUtil.formatHostnameForHttp(raddr);
      int port = raddr.getPort();
      String url = hostString + ":" + port;
      String hostHeader = !this.field_2407 || port != 80 && port != 443 ? url : hostString;
      FullHttpRequest req = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.CONNECT, url, Unpooled.EMPTY_BUFFER, false);
      req.headers().set(HttpHeaderNames.HOST, hostHeader);
      if (this.field_2405 != null) {
         req.headers().set(HttpHeaderNames.PROXY_AUTHORIZATION, this.field_2405);
      }

      if (this.field_2406 != null) {
         req.headers().add(this.field_2406);
      }

      return req;
   }

   @Override
   protected boolean handleResponse(ChannelHandlerContext ctx, Object response) throws Exception {
      if (response instanceof HttpResponse) {
         if (this.field_2408 != null) {
            Class_260 var5 = new Class_260;
            super("unn!l`ox!sdrqnordr", null);
            throw var5;
         }

         HttpResponse res = (HttpResponse)response;
         this.field_2408 = res.status();
         this.field_2409 = res.headers();
      }

      boolean finished = response instanceof LastHttpContent;
      if (finished) {
         if (this.field_2408 == null) {
            Class_260 var10001 = new Class_260;
            super("lhrrhof!sdrqnord", this.field_2409);
            throw var10001;
         }

         if (this.field_2408.code() != 200) {
            throw new Class_260(this.exceptionMessage("status: " + this.field_2408), this.field_2409);
         }
      }

      return finished;
   }
}

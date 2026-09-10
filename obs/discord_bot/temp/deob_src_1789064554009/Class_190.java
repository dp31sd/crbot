import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.socksx.v4.DefaultSocks4CommandRequest;
import io.netty.handler.codec.socksx.v4.Socks4ClientDecoder;
import io.netty.handler.codec.socksx.v4.Socks4ClientEncoder;
import io.netty.handler.codec.socksx.v4.Socks4CommandResponse;
import io.netty.handler.codec.socksx.v4.Socks4CommandStatus;
import io.netty.handler.codec.socksx.v4.Socks4CommandType;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public final class Class_190 extends EventHandler_196 {
   // $VF: renamed from: ln java.lang.String
   private static final String field_2395 = "socks4";
   // $VF: renamed from: oek java.lang.String
   private static final String field_2396 = "username";
   // $VF: renamed from: qdq java.lang.String
   private final String field_2397;
   // $VF: renamed from: yd java.lang.String
   private String field_2398;
   // $VF: renamed from: xmh java.lang.String
   private String field_2399;

   public Class_190(SocketAddress proxyAddress) {
      this(proxyAddress, null);
   }

   public Class_190(SocketAddress proxyAddress, String username) {
      super(proxyAddress);
      if (username != null && username.isEmpty()) {
         username = null;
      }

      this.field_2397 = username;
   }

   @Override
   public String protocol() {
      return "socks4";
   }

   @Override
   public String authScheme() {
      return this.field_2397 != null ? "username" : "none";
   }

   // $VF: renamed from: njd () java.lang.String
   public String method_2003() {
      return this.field_2397;
   }

   @Override
   protected void addCodec(ChannelHandlerContext ctx) throws Exception {
      ChannelPipeline p = ctx.pipeline();
      String name = ctx.name();
      Socks4ClientDecoder decoder = new Socks4ClientDecoder();
      p.addBefore(name, null, decoder);
      this.field_2398 = p.context(decoder).name();
      this.field_2399 = this.field_2398 + ".encoder";
      p.addBefore(name, this.field_2399, Socks4ClientEncoder.INSTANCE);
   }

   @Override
   protected void removeEncoder(ChannelHandlerContext ctx) throws Exception {
      ChannelPipeline p = ctx.pipeline();
      p.remove(this.field_2399);
   }

   @Override
   protected void removeDecoder(ChannelHandlerContext ctx) throws Exception {
      ChannelPipeline p = ctx.pipeline();
      p.remove(this.field_2398);
   }

   @Override
   protected Object newInitialMessage(ChannelHandlerContext ctx) throws Exception {
      InetSocketAddress raddr = this.destinationAddress();
      String rhost;
      if (raddr.isUnresolved()) {
         rhost = raddr.getHostString();
      } else {
         rhost = raddr.getAddress().getHostAddress();
      }

      return new DefaultSocks4CommandRequest(Socks4CommandType.CONNECT, rhost, raddr.getPort(), this.field_2397 != null ? this.field_2397 : "");
   }

   @Override
   protected boolean handleResponse(ChannelHandlerContext ctx, Object response) throws Exception {
      Socks4CommandResponse res = (Socks4CommandResponse)response;
      Socks4CommandStatus status = res.status();
      if (status == Socks4CommandStatus.SUCCESS) {
         return true;
      } else {
         throw new Class_121(this.exceptionMessage("status: " + status));
      }
   }
}

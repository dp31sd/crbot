import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.socksx.v5.DefaultSocks5CommandRequest;
import io.netty.handler.codec.socksx.v5.DefaultSocks5InitialRequest;
import io.netty.handler.codec.socksx.v5.DefaultSocks5PasswordAuthRequest;
import io.netty.handler.codec.socksx.v5.Socks5AddressType;
import io.netty.handler.codec.socksx.v5.Socks5AuthMethod;
import io.netty.handler.codec.socksx.v5.Socks5ClientEncoder;
import io.netty.handler.codec.socksx.v5.Socks5CommandResponse;
import io.netty.handler.codec.socksx.v5.Socks5CommandResponseDecoder;
import io.netty.handler.codec.socksx.v5.Socks5CommandStatus;
import io.netty.handler.codec.socksx.v5.Socks5CommandType;
import io.netty.handler.codec.socksx.v5.Socks5InitialRequest;
import io.netty.handler.codec.socksx.v5.Socks5InitialResponse;
import io.netty.handler.codec.socksx.v5.Socks5InitialResponseDecoder;
import io.netty.handler.codec.socksx.v5.Socks5PasswordAuthResponse;
import io.netty.handler.codec.socksx.v5.Socks5PasswordAuthResponseDecoder;
import io.netty.handler.codec.socksx.v5.Socks5PasswordAuthStatus;
import io.netty.util.NetUtil;
import io.netty.util.internal.StringUtil;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.Collections;

public final class Class_336 extends EventHandler_196 {
   // $VF: renamed from: ln java.lang.String
   private static final String field_2387 = "socks5";
   // $VF: renamed from: goj java.lang.String
   private static final String field_2388 = "password";
   // $VF: renamed from: zm io.netty.handler.codec.socksx.v5.Socks5InitialRequest
   private static final Socks5InitialRequest field_2389 = new DefaultSocks5InitialRequest(Collections.singletonList(Socks5AuthMethod.NO_AUTH));
   // $VF: renamed from: cdt io.netty.handler.codec.socksx.v5.Socks5InitialRequest
   private static final Socks5InitialRequest field_2390 = new DefaultSocks5InitialRequest(Arrays.asList(Socks5AuthMethod.NO_AUTH, Socks5AuthMethod.PASSWORD));
   // $VF: renamed from: qdq java.lang.String
   private final String field_2391;
   // $VF: renamed from: sx java.lang.String
   private final String field_2392;
   // $VF: renamed from: yd java.lang.String
   private String field_2393;
   // $VF: renamed from: xmh java.lang.String
   private String field_2394;

   public Class_336(SocketAddress proxyAddress) {
      this(proxyAddress, null, null);
   }

   public Class_336(SocketAddress proxyAddress, String username, String password) {
      super(proxyAddress);
      if (username != null && username.isEmpty()) {
         username = null;
      }

      if (password != null && password.isEmpty()) {
         password = null;
      }

      this.field_2391 = username;
      this.field_2392 = password;
   }

   @Override
   public String protocol() {
      return "socks5";
   }

   @Override
   public String authScheme() {
      return this.method_2001() == Socks5AuthMethod.PASSWORD ? "password" : "none";
   }

   // $VF: renamed from: wd () java.lang.String
   public String method_1999() {
      return this.field_2391;
   }

   // $VF: renamed from: cmf () java.lang.String
   public String method_2000() {
      return this.field_2392;
   }

   @Override
   protected void addCodec(ChannelHandlerContext ctx) throws Exception {
      ChannelPipeline p = ctx.pipeline();
      String name = ctx.name();
      Socks5InitialResponseDecoder decoder = new Socks5InitialResponseDecoder();
      p.addBefore(name, null, decoder);
      this.field_2393 = p.context(decoder).name();
      this.field_2394 = this.field_2393 + ".encoder";
      p.addBefore(name, this.field_2394, Socks5ClientEncoder.DEFAULT);
   }

   @Override
   protected void removeEncoder(ChannelHandlerContext ctx) throws Exception {
      ctx.pipeline().remove(this.field_2394);
   }

   @Override
   protected void removeDecoder(ChannelHandlerContext ctx) throws Exception {
      ChannelPipeline p = ctx.pipeline();
      if (p.context(this.field_2393) != null) {
         p.remove(this.field_2393);
      }
   }

   @Override
   protected Object newInitialMessage(ChannelHandlerContext ctx) throws Exception {
      return this.method_2001() == Socks5AuthMethod.PASSWORD ? field_2390 : field_2389;
   }

   @Override
   protected boolean handleResponse(ChannelHandlerContext ctx, Object response) throws Exception {
      if (response instanceof Socks5InitialResponse) {
         Socks5InitialResponse res = (Socks5InitialResponse)response;
         Socks5AuthMethod authMethod = this.method_2001();
         Socks5AuthMethod resAuthMethod = res.authMethod();
         if (resAuthMethod != Socks5AuthMethod.NO_AUTH && resAuthMethod != authMethod) {
            throw new Class_121(this.exceptionMessage("unexpected authMethod: " + res.authMethod()));
         } else {
            if (resAuthMethod == Socks5AuthMethod.NO_AUTH) {
               this.method_2002(ctx);
            } else {
               if (resAuthMethod != Socks5AuthMethod.PASSWORD) {
                  throw new Error();
               }

               ctx.pipeline().replace(this.field_2393, this.field_2393, new Socks5PasswordAuthResponseDecoder());
               this.sendToProxyServer(
                  new DefaultSocks5PasswordAuthRequest(this.field_2391 != null ? this.field_2391 : "", this.field_2392 != null ? this.field_2392 : "")
               );
            }

            return false;
         }
      } else if (response instanceof Socks5PasswordAuthResponse) {
         Socks5PasswordAuthResponse res = (Socks5PasswordAuthResponse)response;
         if (res.status() != Socks5PasswordAuthStatus.SUCCESS) {
            throw new Class_121(this.exceptionMessage("authStatus: " + res.status()));
         } else {
            this.method_2002(ctx);
            return false;
         }
      } else {
         Socks5CommandResponse res = (Socks5CommandResponse)response;
         if (res.status() != Socks5CommandStatus.SUCCESS) {
            throw new Class_121(this.exceptionMessage("status: " + res.status()));
         } else {
            return true;
         }
      }
   }

   // $VF: renamed from: pxe () io.netty.handler.codec.socksx.v5.Socks5AuthMethod
   private Socks5AuthMethod method_2001() {
      Socks5AuthMethod authMethod;
      if (this.field_2391 == null && this.field_2392 == null) {
         authMethod = Socks5AuthMethod.NO_AUTH;
      } else {
         authMethod = Socks5AuthMethod.PASSWORD;
      }

      return authMethod;
   }

   // $VF: renamed from: ju (io.netty.channel.ChannelHandlerContext) void
   private void method_2002(ChannelHandlerContext ctx) throws Exception {
      InetSocketAddress raddr = this.destinationAddress();
      Socks5AddressType addrType;
      String rhost;
      if (raddr.isUnresolved()) {
         addrType = Socks5AddressType.DOMAIN;
         rhost = raddr.getHostString();
      } else {
         rhost = raddr.getAddress().getHostAddress();
         if (NetUtil.isValidIpV4Address(rhost)) {
            addrType = Socks5AddressType.IPv4;
         } else {
            if (!NetUtil.isValidIpV6Address(rhost)) {
               throw new Class_121(this.exceptionMessage("unknown address type: " + StringUtil.simpleClassName(rhost)));
            }

            addrType = Socks5AddressType.IPv6;
         }
      }

      ctx.pipeline().replace(this.field_2393, this.field_2393, new Socks5CommandResponseDecoder());
      this.sendToProxyServer(new DefaultSocks5CommandRequest(Socks5CommandType.CONNECT, addrType, rhost, raddr.getPort()));
   }
}

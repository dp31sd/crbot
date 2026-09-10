import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.HttpClientCodec;
import java.net.SocketAddress;

final class NetworkHandler_249 implements ChannelInboundHandler, ChannelOutboundHandler {
   // $VF: renamed from: wu io.netty.handler.codec.http.HttpClientCodec
   final HttpClientCodec field_445 = new HttpClientCodec();

   private NetworkHandler_249() {
   }

   public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
      this.field_445.handlerAdded(ctx);
   }

   public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
      this.field_445.handlerRemoved(ctx);
   }

   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
      this.field_445.exceptionCaught(ctx, cause);
   }

   public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
      this.field_445.channelRegistered(ctx);
   }

   public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
      this.field_445.channelUnregistered(ctx);
   }

   public void channelActive(ChannelHandlerContext ctx) throws Exception {
      this.field_445.channelActive(ctx);
   }

   public void channelInactive(ChannelHandlerContext ctx) throws Exception {
      this.field_445.channelInactive(ctx);
   }

   public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
      this.field_445.channelRead(ctx, msg);
   }

   public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
      this.field_445.channelReadComplete(ctx);
   }

   public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
      this.field_445.userEventTriggered(ctx, evt);
   }

   public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
      this.field_445.channelWritabilityChanged(ctx);
   }

   public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) throws Exception {
      this.field_445.bind(ctx, localAddress, promise);
   }

   public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
      this.field_445.connect(ctx, remoteAddress, localAddress, promise);
   }

   public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
      this.field_445.disconnect(ctx, promise);
   }

   public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
      this.field_445.close(ctx, promise);
   }

   public void deregister(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
      this.field_445.deregister(ctx, promise);
   }

   public void read(ChannelHandlerContext ctx) throws Exception {
      this.field_445.read(ctx);
   }

   public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
      this.field_445.write(ctx, msg, promise);
   }

   public void flush(ChannelHandlerContext ctx) throws Exception {
      this.field_445.flush(ctx);
   }
}

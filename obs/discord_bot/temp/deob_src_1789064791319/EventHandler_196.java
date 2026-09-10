import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.PendingWriteQueue;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.nio.channels.ConnectionPendingException;
import java.util.concurrent.TimeUnit;

public abstract class EventHandler_196 extends ChannelDuplexHandler {
   // $VF: renamed from: vxr io.netty.util.internal.logging.InternalLogger
   private static final InternalLogger field_2375 = InternalLoggerFactory.getInstance(EventHandler_196.class);
   // $VF: renamed from: ayc long
   private static final long field_2376 = 10000L;
   static final String AUTH_NONE = "none";
   // $VF: renamed from: aqs java.net.SocketAddress
   private final SocketAddress field_2377;
   // $VF: renamed from: rkl java.net.SocketAddress
   private volatile SocketAddress field_2378;
   // $VF: renamed from: gv long
   private volatile long field_2379 = 10000L;
   // $VF: renamed from: mmc io.netty.channel.ChannelHandlerContext
   private volatile ChannelHandlerContext field_2380;
   // $VF: renamed from: cq io.netty.channel.PendingWriteQueue
   private PendingWriteQueue field_2381;
   // $VF: renamed from: ycx boolean
   private boolean field_2382;
   // $VF: renamed from: ao boolean
   private boolean field_2383;
   // $VF: renamed from: khi boolean
   private boolean field_2384;
   // $VF: renamed from: hsw EventHandler_238
   private final EventHandler_238 field_2385 = new EventHandler_238(this);
   private Future<?> fqfx;
   // $VF: renamed from: zxa io.netty.channel.ChannelFutureListener
   private final ChannelFutureListener field_2386 = new ChannelFutureListener() {
      // $VF: renamed from: pr (io.netty.channel.ChannelFuture) void
      public void method_412(ChannelFuture future) throws Exception {
         if (!future.isSuccess()) {
            EventHandler_196.this.method_1990(future.cause());
         }
      }
   };

   protected EventHandler_196(SocketAddress proxyAddress) {
      this.field_2377 = (SocketAddress)ObjectUtil.checkNotNull(proxyAddress, "proxyAddress");
   }

   public abstract String protocol();

   public abstract String authScheme();

   public final <T extends SocketAddress> T proxyAddress() {
      return (T)this.field_2377;
   }

   public final <T extends SocketAddress> T destinationAddress() {
      return (T)this.field_2378;
   }

   public final boolean isConnected() {
      return this.field_2385.isSuccess();
   }

   public final Future<Channel> connectFuture() {
      return this.field_2385;
   }

   public final long connectTimeoutMillis() {
      return this.field_2379;
   }

   public final void setConnectTimeoutMillis(long connectTimeoutMillis) {
      if (connectTimeoutMillis <= 0L) {
         connectTimeoutMillis = 0L;
      }

      this.field_2379 = connectTimeoutMillis;
   }

   public final void handlerAdded(ChannelHandlerContext ctx) throws Exception {
      this.field_2380 = ctx;
      this.addCodec(ctx);
      if (ctx.channel().isActive()) {
         this.method_1986(ctx);
      }
   }

   protected abstract void addCodec(ChannelHandlerContext var1) throws Exception;

   protected abstract void removeEncoder(ChannelHandlerContext var1) throws Exception;

   protected abstract void removeDecoder(ChannelHandlerContext var1) throws Exception;

   public final void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
      if (this.field_2378 != null) {
         promise.setFailure(new ConnectionPendingException());
      } else {
         this.field_2378 = remoteAddress;
         ctx.connect(this.field_2377, localAddress, promise);
      }
   }

   public final void channelActive(ChannelHandlerContext ctx) throws Exception {
      this.method_1986(ctx);
      ctx.fireChannelActive();
   }

   // $VF: renamed from: iiu (io.netty.channel.ChannelHandlerContext) void
   private void method_1986(ChannelHandlerContext ctx) throws Exception {
      long connectTimeoutMillis = this.field_2379;
      if (connectTimeoutMillis > 0L) {
         this.fqfx = ctx.executor().schedule(new Runnable() {
            // $VF: renamed from: run () void
            @Override
            public void run() {
               if (!EventHandler_196.this.field_2385.isDone()) {
                  Class_121 var10001 = new Class_121;
                  super("�s���");
                  var10001.method_1990(var10001);
               }
            }
         }, connectTimeoutMillis, TimeUnit.MILLISECONDS);
      }

      Object initialMessage = this.newInitialMessage(ctx);
      if (initialMessage != null) {
         this.sendToProxyServer(initialMessage);
      }

      method_1993(ctx);
   }

   protected abstract Object newInitialMessage(ChannelHandlerContext var1) throws Exception;

   protected final void sendToProxyServer(Object msg) {
      this.field_2380.writeAndFlush(msg).addListener(this.field_2386);
   }

   public final void channelInactive(ChannelHandlerContext ctx) throws Exception {
      if (this.field_2382) {
         ctx.fireChannelInactive();
      } else {
         Class_121 var10001 = new Class_121;
         super(",qF�#�(��");
         var10001.method_1990(var10001);
      }
   }

   public final void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
      if (this.field_2382) {
         ctx.fireExceptionCaught(cause);
      } else {
         this.method_1990(cause);
      }
   }

   public final void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
      if (this.field_2382) {
         this.field_2383 = false;
         ctx.fireChannelRead(msg);
      } else {
         this.field_2383 = true;
         Throwable cause = null;

         try {
            boolean done = this.handleResponse(ctx, msg);
            if (done) {
               this.method_1987();
            }
         } catch (Throwable var8) {
            cause = var8;
         } finally {
            ReferenceCountUtil.release(msg);
            if (cause != null) {
               this.method_1990(cause);
            }
         }
      }
   }

   protected abstract boolean handleResponse(ChannelHandlerContext var1, Object var2) throws Exception;

   // $VF: renamed from: zg () void
   private void method_1987() {
      this.field_2382 = true;
      this.method_1992();
      if (!this.field_2385.isDone()) {
         boolean removedCodec = true;
         removedCodec &= this.method_1989();
         this.field_2380.fireUserEventTriggered(new Class_133(this.protocol(), this.authScheme(), this.field_2377, this.field_2378));
         removedCodec &= this.method_1988();
         if (removedCodec) {
            this.method_1994();
            if (this.field_2384) {
               this.field_2380.flush();
            }

            this.field_2385.trySuccess(this.field_2380.channel());
         } else {
            Exception cause = new Class_121("failed to remove all codec handlers added by the proxy handler; bug?");
            this.method_1991(cause);
         }
      }
   }

   // $VF: renamed from: qjz () boolean
   private boolean method_1988() {
      try {
         this.removeDecoder(this.field_2380);
         return true;
      } catch (Exception var2) {
         field_2375.warn("Failed to remove proxy decoders:", var2);
         return false;
      }
   }

   // $VF: renamed from: ceq () boolean
   private boolean method_1989() {
      try {
         this.removeEncoder(this.field_2380);
         return true;
      } catch (Exception var2) {
         field_2375.warn("Failed to remove proxy encoders:", var2);
         return false;
      }
   }

   // $VF: renamed from: ywo (java.lang.Throwable) void
   private void method_1990(Throwable cause) {
      this.field_2382 = true;
      this.method_1992();
      if (!this.field_2385.isDone()) {
         if (!(cause instanceof Class_121)) {
            cause = new Class_121(this.exceptionMessage(cause.toString()), cause);
         }

         this.method_1988();
         this.method_1989();
         this.method_1991(cause);
      }
   }

   // $VF: renamed from: whm (java.lang.Throwable) void
   private void method_1991(Throwable cause) {
      this.method_1995(cause);
      this.field_2385.tryFailure(cause);
      this.field_2380.fireExceptionCaught(cause);
      this.field_2380.close();
   }

   // $VF: renamed from: lue () void
   private void method_1992() {
      if (this.fqfx != null) {
         this.fqfx.cancel(false);
         this.fqfx = null;
      }
   }

   protected final String exceptionMessage(String msg) {
      if (msg == null) {
         msg = "";
      }

      StringBuilder buf = new StringBuilder(128 + msg.length())
         .append(this.protocol())
         .append(", ")
         .append(this.authScheme())
         .append(", ")
         .append(this.field_2377)
         .append(" => ")
         .append(this.field_2378);
      if (!msg.isEmpty()) {
         buf.append(", ").append(msg);
      }

      return buf.toString();
   }

   public final void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
      if (this.field_2383) {
         this.field_2383 = false;
         method_1993(ctx);
      } else {
         ctx.fireChannelReadComplete();
      }
   }

   public final void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
      if (this.field_2382) {
         this.method_1994();
         ctx.write(msg, promise);
      } else {
         this.wsgw(ctx, msg, promise);
      }
   }

   public final void flush(ChannelHandlerContext ctx) throws Exception {
      if (this.field_2382) {
         this.method_1994();
         ctx.flush();
      } else {
         this.field_2384 = true;
      }
   }

   // $VF: renamed from: vum (io.netty.channel.ChannelHandlerContext) void
   private static void method_1993(ChannelHandlerContext ctx) {
      if (!ctx.channel().config().isAutoRead()) {
         ctx.read();
      }
   }

   // $VF: renamed from: mqj () void
   private void method_1994() {
      if (this.field_2381 != null) {
         this.field_2381.removeAndWriteAll();
         this.field_2381 = null;
      }
   }

   // $VF: renamed from: ivd (java.lang.Throwable) void
   private void method_1995(Throwable cause) {
      if (this.field_2381 != null) {
         this.field_2381.removeAndFailAll(cause);
         this.field_2381 = null;
      }
   }

   private void wsgw(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
      PendingWriteQueue pendingWrites = this.field_2381;
      if (pendingWrites == null) {
         this.field_2381 = pendingWrites = new PendingWriteQueue(ctx);
      }

      pendingWrites.add(msg, promise);
   }
}

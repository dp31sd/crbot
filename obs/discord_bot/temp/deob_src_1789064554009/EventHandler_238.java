import io.netty.channel.Channel;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;

final class EventHandler_238 extends DefaultPromise<Channel> {
   private EventHandler_238(EventHandler_196 var1) {
      this.field_2607 = var1;
   }

   protected EventExecutor executor() {
      if (EventHandler_196.method_1998(this.field_2607) == null) {
         throw new IllegalStateException();
      } else {
         return EventHandler_196.method_1998(this.field_2607).executor();
      }
   }
}

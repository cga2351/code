package com.swmansion.gesturehandler.react;

import android.support.v4.util.Pools.SynchronizedPool;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.swmansion.gesturehandler.b;
import javax.annotation.Nullable;

public class i extends Event<i>
{
  private static final Pools.SynchronizedPool<i> a = new Pools.SynchronizedPool(7);
  private WritableMap b;

  public static i a(b paramb, int paramInt1, int paramInt2, @Nullable c paramc)
  {
    i locali = (i)a.acquire();
    if (locali == null)
      locali = new i();
    locali.b(paramb, paramInt1, paramInt2, paramc);
    return locali;
  }

  private void b(b paramb, int paramInt1, int paramInt2, @Nullable c paramc)
  {
    super.init(paramb.e().getId());
    this.b = Arguments.createMap();
    if (paramc != null)
      paramc.a(paramb, this.b);
    this.b.putInt("handlerTag", paramb.d());
    this.b.putInt("state", paramInt1);
    this.b.putInt("oldState", paramInt2);
  }

  public boolean canCoalesce()
  {
    return false;
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), "onGestureHandlerStateChange", this.b);
  }

  public short getCoalescingKey()
  {
    return 0;
  }

  public String getEventName()
  {
    return "onGestureHandlerStateChange";
  }

  public void onDispose()
  {
    this.b = null;
    a.release(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.react.i
 * JD-Core Version:    0.6.2
 */
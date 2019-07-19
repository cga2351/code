package com.swmansion.gesturehandler.react;

import android.support.v4.util.Pools.SynchronizedPool;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import javax.annotation.Nullable;

public class b extends Event<b>
{
  private static final Pools.SynchronizedPool<b> a = new Pools.SynchronizedPool(7);
  private WritableMap b;

  public static b a(com.swmansion.gesturehandler.b paramb, @Nullable c paramc)
  {
    b localb = (b)a.acquire();
    if (localb == null)
      localb = new b();
    localb.b(paramb, paramc);
    return localb;
  }

  private void b(com.swmansion.gesturehandler.b paramb, @Nullable c paramc)
  {
    super.init(paramb.e().getId());
    this.b = Arguments.createMap();
    if (paramc != null)
      paramc.a(paramb, this.b);
    this.b.putInt("handlerTag", paramb.d());
    this.b.putInt("state", paramb.i());
  }

  public boolean canCoalesce()
  {
    return false;
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), "onGestureHandlerEvent", this.b);
  }

  public short getCoalescingKey()
  {
    return 0;
  }

  public String getEventName()
  {
    return "onGestureHandlerEvent";
  }

  public void onDispose()
  {
    this.b = null;
    a.release(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.react.b
 * JD-Core Version:    0.6.2
 */
package com.reactnativecommunity.webview.a;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import d.d.b.h;
import org.jetbrains.annotations.NotNull;

public final class c extends Event<c>
{
  public static final a a = new a(null);
  private final WritableMap b;

  public c(int paramInt, @NotNull WritableMap paramWritableMap)
  {
    super(paramInt);
    this.b = paramWritableMap;
  }

  public boolean canCoalesce()
  {
    return false;
  }

  public void dispatch(@NotNull RCTEventEmitter paramRCTEventEmitter)
  {
    h.b(paramRCTEventEmitter, "rctEventEmitter");
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), this.b);
  }

  public short getCoalescingKey()
  {
    return 0;
  }

  @NotNull
  public String getEventName()
  {
    return "topLoadingProgress";
  }

  public static final class a
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.reactnativecommunity.webview.a.c
 * JD-Core Version:    0.6.2
 */
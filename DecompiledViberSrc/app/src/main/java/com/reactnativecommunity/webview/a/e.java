package com.reactnativecommunity.webview.a;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import d.d.b.h;
import org.jetbrains.annotations.NotNull;

public final class e extends Event<e>
{
  public static final a a = new a(null);
  private final String b;

  public e(int paramInt, @NotNull String paramString)
  {
    super(paramInt);
    this.b = paramString;
  }

  public boolean canCoalesce()
  {
    return false;
  }

  public void dispatch(@NotNull RCTEventEmitter paramRCTEventEmitter)
  {
    h.b(paramRCTEventEmitter, "rctEventEmitter");
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putString("data", this.b);
    paramRCTEventEmitter.receiveEvent(getViewTag(), "topMessage", localWritableMap);
  }

  public short getCoalescingKey()
  {
    return 0;
  }

  @NotNull
  public String getEventName()
  {
    return "topMessage";
  }

  public static final class a
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.reactnativecommunity.webview.a.e
 * JD-Core Version:    0.6.2
 */
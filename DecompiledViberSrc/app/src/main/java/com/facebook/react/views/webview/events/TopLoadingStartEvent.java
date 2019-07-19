package com.facebook.react.views.webview.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class TopLoadingStartEvent extends Event<TopLoadingStartEvent>
{
  public static final String EVENT_NAME = "topLoadingStart";
  private WritableMap mEventData;

  public TopLoadingStartEvent(int paramInt, WritableMap paramWritableMap)
  {
    super(paramInt);
    this.mEventData = paramWritableMap;
  }

  public boolean canCoalesce()
  {
    return false;
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), this.mEventData);
  }

  public short getCoalescingKey()
  {
    return 0;
  }

  public String getEventName()
  {
    return "topLoadingStart";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.webview.events.TopLoadingStartEvent
 * JD-Core Version:    0.6.2
 */
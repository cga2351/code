package com.facebook.react.views.checkbox;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

class ReactCheckBoxEvent extends Event<ReactCheckBoxEvent>
{
  public static final String EVENT_NAME = "topChange";
  private final boolean mIsChecked;

  public ReactCheckBoxEvent(int paramInt, boolean paramBoolean)
  {
    super(paramInt);
    this.mIsChecked = paramBoolean;
  }

  private WritableMap serializeEventData()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putInt("target", getViewTag());
    localWritableMap.putBoolean("value", getIsChecked());
    return localWritableMap;
  }

  public void dispatch(RCTEventEmitter paramRCTEventEmitter)
  {
    paramRCTEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }

  public short getCoalescingKey()
  {
    return 0;
  }

  public String getEventName()
  {
    return "topChange";
  }

  public boolean getIsChecked()
  {
    return this.mIsChecked;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.checkbox.ReactCheckBoxEvent
 * JD-Core Version:    0.6.2
 */
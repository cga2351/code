package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.util.List;
import javax.annotation.Nullable;

class EventAnimationDriver
  implements RCTEventEmitter
{
  private List<String> mEventPath;
  ValueAnimatedNode mValueNode;

  public EventAnimationDriver(List<String> paramList, ValueAnimatedNode paramValueAnimatedNode)
  {
    this.mEventPath = paramList;
    this.mValueNode = paramValueAnimatedNode;
  }

  public void receiveEvent(int paramInt, String paramString, @Nullable WritableMap paramWritableMap)
  {
    if (paramWritableMap == null)
      throw new IllegalArgumentException("Native animated events must have event data.");
    for (int i = 0; i < -1 + this.mEventPath.size(); i++)
      paramWritableMap = paramWritableMap.getMap((String)this.mEventPath.get(i));
    this.mValueNode.mValue = paramWritableMap.getDouble((String)this.mEventPath.get(-1 + this.mEventPath.size()));
  }

  public void receiveTouches(String paramString, WritableArray paramWritableArray1, WritableArray paramWritableArray2)
  {
    throw new RuntimeException("receiveTouches is not support by native animated events");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.EventAnimationDriver
 * JD-Core Version:    0.6.2
 */
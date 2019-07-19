package com.facebook.react.uimanager.events;

import android.util.SparseArray;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.common.ViewUtil;
import javax.annotation.Nullable;

public class ReactEventEmitter
  implements RCTEventEmitter
{
  private static final String TAG = ReactEventEmitter.class.getSimpleName();
  private final SparseArray<RCTEventEmitter> mEventEmitters = new SparseArray();
  private final ReactApplicationContext mReactContext;

  public ReactEventEmitter(ReactApplicationContext paramReactApplicationContext)
  {
    this.mReactContext = paramReactApplicationContext;
  }

  private RCTEventEmitter getEventEmitter(int paramInt)
  {
    int i = ViewUtil.getUIManagerType(paramInt);
    RCTEventEmitter localRCTEventEmitter = (RCTEventEmitter)this.mEventEmitters.get(i);
    if (localRCTEventEmitter == null)
      localRCTEventEmitter = (RCTEventEmitter)this.mReactContext.getJSModule(RCTEventEmitter.class);
    return localRCTEventEmitter;
  }

  public void receiveEvent(int paramInt, String paramString, @Nullable WritableMap paramWritableMap)
  {
    getEventEmitter(paramInt).receiveEvent(paramInt, paramString, paramWritableMap);
  }

  public void receiveTouches(String paramString, WritableArray paramWritableArray1, WritableArray paramWritableArray2)
  {
    if (paramWritableArray1.size() > 0);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool);
      getEventEmitter(paramWritableArray1.getMap(0).getInt("target")).receiveTouches(paramString, paramWritableArray1, paramWritableArray2);
      return;
    }
  }

  public void register(int paramInt, RCTEventEmitter paramRCTEventEmitter)
  {
    this.mEventEmitters.put(paramInt, paramRCTEventEmitter);
  }

  public void unregister(int paramInt)
  {
    this.mEventEmitters.remove(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.events.ReactEventEmitter
 * JD-Core Version:    0.6.2
 */
package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import javax.annotation.Nullable;

@DoNotStrip
public class WritableNativeArray extends ReadableNativeArray
  implements WritableArray
{
  static
  {
    ReactBridge.staticInit();
  }

  public WritableNativeArray()
  {
    super(initHybrid());
  }

  private static native HybridData initHybrid();

  private native void pushNativeArray(WritableNativeArray paramWritableNativeArray);

  private native void pushNativeMap(WritableNativeMap paramWritableNativeMap);

  public void pushArray(@Nullable WritableArray paramWritableArray)
  {
    if ((paramWritableArray == null) || ((paramWritableArray instanceof WritableNativeArray)));
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool, "Illegal type provided");
      pushNativeArray((WritableNativeArray)paramWritableArray);
      return;
    }
  }

  public native void pushBoolean(boolean paramBoolean);

  public native void pushDouble(double paramDouble);

  public native void pushInt(int paramInt);

  public void pushMap(@Nullable WritableMap paramWritableMap)
  {
    if ((paramWritableMap == null) || ((paramWritableMap instanceof WritableNativeMap)));
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool, "Illegal type provided");
      pushNativeMap((WritableNativeMap)paramWritableMap);
      return;
    }
  }

  public native void pushNull();

  public native void pushString(@Nullable String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.WritableNativeArray
 * JD-Core Version:    0.6.2
 */
package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@DoNotStrip
public class WritableNativeMap extends ReadableNativeMap
  implements WritableMap
{
  static
  {
    ReactBridge.staticInit();
  }

  public WritableNativeMap()
  {
    super(initHybrid());
  }

  private static native HybridData initHybrid();

  private native void mergeNativeMap(ReadableNativeMap paramReadableNativeMap);

  private native void putNativeArray(String paramString, WritableNativeArray paramWritableNativeArray);

  private native void putNativeMap(String paramString, WritableNativeMap paramWritableNativeMap);

  public void merge(@Nonnull ReadableMap paramReadableMap)
  {
    Assertions.assertCondition(paramReadableMap instanceof ReadableNativeMap, "Illegal type provided");
    mergeNativeMap((ReadableNativeMap)paramReadableMap);
  }

  public void putArray(@Nonnull String paramString, @Nullable WritableArray paramWritableArray)
  {
    if ((paramWritableArray == null) || ((paramWritableArray instanceof WritableNativeArray)));
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool, "Illegal type provided");
      putNativeArray(paramString, (WritableNativeArray)paramWritableArray);
      return;
    }
  }

  public native void putBoolean(@Nonnull String paramString, boolean paramBoolean);

  public native void putDouble(@Nonnull String paramString, double paramDouble);

  public native void putInt(@Nonnull String paramString, int paramInt);

  public void putMap(@Nonnull String paramString, @Nullable WritableMap paramWritableMap)
  {
    if ((paramWritableMap == null) || ((paramWritableMap instanceof WritableNativeMap)));
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool, "Illegal type provided");
      putNativeMap(paramString, (WritableNativeMap)paramWritableMap);
      return;
    }
  }

  public native void putNull(String paramString);

  public native void putString(@Nonnull String paramString1, @Nullable String paramString2);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.WritableNativeMap
 * JD-Core Version:    0.6.2
 */
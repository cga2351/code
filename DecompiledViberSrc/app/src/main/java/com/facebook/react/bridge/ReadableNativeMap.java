package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.config.ReactFeatureFlags;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@DoNotStrip
public class ReadableNativeMap extends NativeMap
  implements ReadableMap
{
  private static int mJniCallCounter;

  @Nullable
  private String[] mKeys;

  @Nullable
  private HashMap<String, Object> mLocalMap;

  @Nullable
  private HashMap<String, ReadableType> mLocalTypeMap;

  static
  {
    ReactBridge.staticInit();
  }

  protected ReadableNativeMap(HybridData paramHybridData)
  {
    super(paramHybridData);
  }

  private void checkInstance(String paramString, Object paramObject, Class paramClass)
  {
    if ((paramObject != null) && (!paramClass.isInstance(paramObject)))
      throw new ClassCastException("Value for " + paramString + " cannot be cast from " + paramObject.getClass().getSimpleName() + " to " + paramClass.getSimpleName());
  }

  private native ReadableNativeArray getArrayNative(String paramString);

  private native boolean getBooleanNative(String paramString);

  private native double getDoubleNative(String paramString);

  private native int getIntNative(String paramString);

  public static int getJNIPassCounter()
  {
    return mJniCallCounter;
  }

  private HashMap<String, Object> getLocalMap()
  {
    if (this.mLocalMap != null)
      return this.mLocalMap;
    try
    {
      if (this.mKeys == null)
      {
        this.mKeys = ((String[])Assertions.assertNotNull(importKeys()));
        mJniCallCounter = 1 + mJniCallCounter;
      }
      if (this.mLocalMap == null)
      {
        Object[] arrayOfObject = (Object[])Assertions.assertNotNull(importValues());
        mJniCallCounter = 1 + mJniCallCounter;
        int i = this.mKeys.length;
        this.mLocalMap = new HashMap(i);
        for (int j = 0; j < i; j++)
          this.mLocalMap.put(this.mKeys[j], arrayOfObject[j]);
      }
      return this.mLocalMap;
    }
    finally
    {
    }
  }

  @Nonnull
  private HashMap<String, ReadableType> getLocalTypeMap()
  {
    if (this.mLocalTypeMap != null)
      return this.mLocalTypeMap;
    try
    {
      if (this.mKeys == null)
      {
        this.mKeys = ((String[])Assertions.assertNotNull(importKeys()));
        mJniCallCounter = 1 + mJniCallCounter;
      }
      if (this.mLocalTypeMap == null)
      {
        Object[] arrayOfObject = (Object[])Assertions.assertNotNull(importTypes());
        mJniCallCounter = 1 + mJniCallCounter;
        int i = this.mKeys.length;
        this.mLocalTypeMap = new HashMap(i);
        for (int j = 0; j < i; j++)
          this.mLocalTypeMap.put(this.mKeys[j], (ReadableType)arrayOfObject[j]);
      }
      return this.mLocalTypeMap;
    }
    finally
    {
    }
  }

  private native ReadableNativeMap getMapNative(String paramString);

  @Nullable
  private Object getNullableValue(String paramString)
  {
    if (hasKey(paramString))
      return getLocalMap().get(paramString);
    throw new NoSuchKeyException(paramString);
  }

  @Nullable
  private <T> T getNullableValue(String paramString, Class<T> paramClass)
  {
    Object localObject = getNullableValue(paramString);
    checkInstance(paramString, localObject, paramClass);
    return localObject;
  }

  private native String getStringNative(String paramString);

  private native ReadableType getTypeNative(String paramString);

  @Nonnull
  private Object getValue(@Nonnull String paramString)
  {
    if ((hasKey(paramString)) && (!isNull(paramString)))
      return Assertions.assertNotNull(getLocalMap().get(paramString));
    throw new NoSuchKeyException(paramString);
  }

  private <T> T getValue(String paramString, Class<T> paramClass)
  {
    Object localObject = getValue(paramString);
    checkInstance(paramString, localObject, paramClass);
    return localObject;
  }

  private native boolean hasKeyNative(String paramString);

  private native String[] importKeys();

  private native Object[] importTypes();

  private native Object[] importValues();

  private native boolean isNullNative(@Nonnull String paramString);

  public static void setUseNativeAccessor(boolean paramBoolean)
  {
    ReactFeatureFlags.useMapNativeAccessor = paramBoolean;
  }

  @Nullable
  public ReadableArray getArray(@Nonnull String paramString)
  {
    if (ReactFeatureFlags.useMapNativeAccessor)
    {
      mJniCallCounter = 1 + mJniCallCounter;
      return getArrayNative(paramString);
    }
    return (ReadableArray)getNullableValue(paramString, ReadableArray.class);
  }

  public boolean getBoolean(@Nonnull String paramString)
  {
    if (ReactFeatureFlags.useMapNativeAccessor)
    {
      mJniCallCounter = 1 + mJniCallCounter;
      return getBooleanNative(paramString);
    }
    return ((Boolean)getValue(paramString, Boolean.class)).booleanValue();
  }

  public double getDouble(@Nonnull String paramString)
  {
    if (ReactFeatureFlags.useMapNativeAccessor)
    {
      mJniCallCounter = 1 + mJniCallCounter;
      return getDoubleNative(paramString);
    }
    return ((Double)getValue(paramString, Double.class)).doubleValue();
  }

  @Nonnull
  public Dynamic getDynamic(@Nonnull String paramString)
  {
    return DynamicFromMap.create(this, paramString);
  }

  public int getInt(@Nonnull String paramString)
  {
    if (ReactFeatureFlags.useMapNativeAccessor)
    {
      mJniCallCounter = 1 + mJniCallCounter;
      return getIntNative(paramString);
    }
    return ((Double)getValue(paramString, Double.class)).intValue();
  }

  @Nullable
  public ReadableNativeMap getMap(@Nonnull String paramString)
  {
    if (ReactFeatureFlags.useMapNativeAccessor)
    {
      mJniCallCounter = 1 + mJniCallCounter;
      return getMapNative(paramString);
    }
    return (ReadableNativeMap)getNullableValue(paramString, ReadableNativeMap.class);
  }

  @Nullable
  public String getString(@Nonnull String paramString)
  {
    if (ReactFeatureFlags.useMapNativeAccessor)
    {
      mJniCallCounter = 1 + mJniCallCounter;
      return getStringNative(paramString);
    }
    return (String)getNullableValue(paramString, String.class);
  }

  @Nonnull
  public ReadableType getType(@Nonnull String paramString)
  {
    if (ReactFeatureFlags.useMapNativeAccessor)
    {
      mJniCallCounter = 1 + mJniCallCounter;
      return getTypeNative(paramString);
    }
    if (getLocalTypeMap().containsKey(paramString))
      return (ReadableType)Assertions.assertNotNull(getLocalTypeMap().get(paramString));
    throw new NoSuchKeyException(paramString);
  }

  public boolean hasKey(@Nonnull String paramString)
  {
    if (ReactFeatureFlags.useMapNativeAccessor)
    {
      mJniCallCounter = 1 + mJniCallCounter;
      return hasKeyNative(paramString);
    }
    return getLocalMap().containsKey(paramString);
  }

  public boolean isNull(@Nonnull String paramString)
  {
    if (ReactFeatureFlags.useMapNativeAccessor)
    {
      mJniCallCounter = 1 + mJniCallCounter;
      return isNullNative(paramString);
    }
    if (getLocalMap().containsKey(paramString))
      return getLocalMap().get(paramString) == null;
    throw new NoSuchKeyException(paramString);
  }

  @Nonnull
  public ReadableMapKeySetIterator keySetIterator()
  {
    return new ReadableNativeMapKeySetIterator(this);
  }

  @Nonnull
  public HashMap<String, Object> toHashMap()
  {
    if (ReactFeatureFlags.useMapNativeAccessor)
    {
      ReadableMapKeySetIterator localReadableMapKeySetIterator = keySetIterator();
      HashMap localHashMap2 = new HashMap();
      while (localReadableMapKeySetIterator.hasNextKey())
      {
        mJniCallCounter = 1 + mJniCallCounter;
        String str2 = localReadableMapKeySetIterator.nextKey();
        mJniCallCounter = 1 + mJniCallCounter;
        switch (1.$SwitchMap$com$facebook$react$bridge$ReadableType[getType(str2).ordinal()])
        {
        default:
          throw new IllegalArgumentException("Could not convert object with key: " + str2 + ".");
        case 1:
          localHashMap2.put(str2, null);
          break;
        case 2:
          localHashMap2.put(str2, Boolean.valueOf(getBoolean(str2)));
          break;
        case 3:
          localHashMap2.put(str2, Double.valueOf(getDouble(str2)));
          break;
        case 4:
          localHashMap2.put(str2, getString(str2));
          break;
        case 5:
          localHashMap2.put(str2, ((ReadableNativeMap)Assertions.assertNotNull(getMap(str2))).toHashMap());
          break;
        case 6:
          localHashMap2.put(str2, ((ReadableArray)Assertions.assertNotNull(getArray(str2))).toArrayList());
        }
      }
      return localHashMap2;
    }
    HashMap localHashMap1 = new HashMap(getLocalMap());
    Iterator localIterator = localHashMap1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      switch (1.$SwitchMap$com$facebook$react$bridge$ReadableType[getType(str1).ordinal()])
      {
      case 1:
      case 2:
      case 3:
      case 4:
      default:
        throw new IllegalArgumentException("Could not convert object with key: " + str1 + ".");
      case 5:
        localHashMap1.put(str1, ((ReadableNativeMap)Assertions.assertNotNull(getMap(str1))).toHashMap());
        break;
      case 6:
        localHashMap1.put(str1, ((ReadableArray)Assertions.assertNotNull(getArray(str1))).toArrayList());
      }
    }
    return localHashMap1;
  }

  @DoNotStrip
  private static class ReadableNativeMapKeySetIterator
    implements ReadableMapKeySetIterator
  {

    @DoNotStrip
    private final HybridData mHybridData;

    @DoNotStrip
    private final ReadableNativeMap mMap;

    public ReadableNativeMapKeySetIterator(ReadableNativeMap paramReadableNativeMap)
    {
      this.mMap = paramReadableNativeMap;
      this.mHybridData = initHybrid(paramReadableNativeMap);
    }

    private static native HybridData initHybrid(ReadableNativeMap paramReadableNativeMap);

    public native boolean hasNextKey();

    public native String nextKey();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReadableNativeMap
 * JD-Core Version:    0.6.2
 */
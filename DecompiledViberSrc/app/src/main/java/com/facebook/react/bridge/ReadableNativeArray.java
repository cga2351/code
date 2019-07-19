package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.config.ReactFeatureFlags;
import java.util.ArrayList;
import java.util.Arrays;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@DoNotStrip
public class ReadableNativeArray extends NativeArray
  implements ReadableArray
{
  private static int jniPassCounter = 0;

  @Nullable
  private Object[] mLocalArray;

  @Nullable
  private ReadableType[] mLocalTypeArray;

  static
  {
    ReactBridge.staticInit();
  }

  protected ReadableNativeArray(HybridData paramHybridData)
  {
    super(paramHybridData);
  }

  private native ReadableNativeArray getArrayNative(int paramInt);

  private native boolean getBooleanNative(int paramInt);

  private native double getDoubleNative(int paramInt);

  private native int getIntNative(int paramInt);

  public static int getJNIPassCounter()
  {
    return jniPassCounter;
  }

  private Object[] getLocalArray()
  {
    if (this.mLocalArray != null)
      return this.mLocalArray;
    try
    {
      if (this.mLocalArray == null)
      {
        jniPassCounter = 1 + jniPassCounter;
        this.mLocalArray = ((Object[])Assertions.assertNotNull(importArray()));
      }
      return this.mLocalArray;
    }
    finally
    {
    }
  }

  private ReadableType[] getLocalTypeArray()
  {
    if (this.mLocalTypeArray != null)
      return this.mLocalTypeArray;
    try
    {
      if (this.mLocalTypeArray == null)
      {
        jniPassCounter = 1 + jniPassCounter;
        Object[] arrayOfObject = (Object[])Assertions.assertNotNull(importTypeArray());
        this.mLocalTypeArray = ((ReadableType[])Arrays.copyOf(arrayOfObject, arrayOfObject.length, [Lcom.facebook.react.bridge.ReadableType.class));
      }
      return this.mLocalTypeArray;
    }
    finally
    {
    }
  }

  private native ReadableNativeMap getMapNative(int paramInt);

  private native String getStringNative(int paramInt);

  private native ReadableType getTypeNative(int paramInt);

  private native Object[] importArray();

  private native Object[] importTypeArray();

  private native boolean isNullNative(int paramInt);

  public static void setUseNativeAccessor(boolean paramBoolean)
  {
    ReactFeatureFlags.useArrayNativeAccessor = paramBoolean;
  }

  private native int sizeNative();

  @Nullable
  public ReadableNativeArray getArray(int paramInt)
  {
    if (ReactFeatureFlags.useArrayNativeAccessor)
    {
      jniPassCounter = 1 + jniPassCounter;
      return getArrayNative(paramInt);
    }
    return (ReadableNativeArray)getLocalArray()[paramInt];
  }

  public boolean getBoolean(int paramInt)
  {
    if (ReactFeatureFlags.useArrayNativeAccessor)
    {
      jniPassCounter = 1 + jniPassCounter;
      return getBooleanNative(paramInt);
    }
    return ((Boolean)getLocalArray()[paramInt]).booleanValue();
  }

  public double getDouble(int paramInt)
  {
    if (ReactFeatureFlags.useArrayNativeAccessor)
    {
      jniPassCounter = 1 + jniPassCounter;
      return getDoubleNative(paramInt);
    }
    return ((Double)getLocalArray()[paramInt]).doubleValue();
  }

  @Nonnull
  public Dynamic getDynamic(int paramInt)
  {
    return DynamicFromArray.create(this, paramInt);
  }

  public int getInt(int paramInt)
  {
    if (ReactFeatureFlags.useArrayNativeAccessor)
    {
      jniPassCounter = 1 + jniPassCounter;
      return getIntNative(paramInt);
    }
    return ((Double)getLocalArray()[paramInt]).intValue();
  }

  @Nullable
  public ReadableNativeMap getMap(int paramInt)
  {
    if (ReactFeatureFlags.useArrayNativeAccessor)
    {
      jniPassCounter = 1 + jniPassCounter;
      return getMapNative(paramInt);
    }
    return (ReadableNativeMap)getLocalArray()[paramInt];
  }

  @Nullable
  public String getString(int paramInt)
  {
    if (ReactFeatureFlags.useArrayNativeAccessor)
    {
      jniPassCounter = 1 + jniPassCounter;
      return getStringNative(paramInt);
    }
    return (String)getLocalArray()[paramInt];
  }

  @Nonnull
  public ReadableType getType(int paramInt)
  {
    if (ReactFeatureFlags.useArrayNativeAccessor)
    {
      jniPassCounter = 1 + jniPassCounter;
      return getTypeNative(paramInt);
    }
    return getLocalTypeArray()[paramInt];
  }

  public boolean isNull(int paramInt)
  {
    if (ReactFeatureFlags.useArrayNativeAccessor)
    {
      jniPassCounter = 1 + jniPassCounter;
      return isNullNative(paramInt);
    }
    return getLocalArray()[paramInt] == null;
  }

  public int size()
  {
    if (ReactFeatureFlags.useArrayNativeAccessor)
    {
      jniPassCounter = 1 + jniPassCounter;
      return sizeNative();
    }
    return getLocalArray().length;
  }

  @Nonnull
  public ArrayList<Object> toArrayList()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < size())
    {
      switch (1.$SwitchMap$com$facebook$react$bridge$ReadableType[getType(i).ordinal()])
      {
      default:
        throw new IllegalArgumentException("Could not convert object at index: " + i + ".");
      case 1:
        localArrayList.add(null);
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      }
      while (true)
      {
        i++;
        break;
        localArrayList.add(Boolean.valueOf(getBoolean(i)));
        continue;
        localArrayList.add(Double.valueOf(getDouble(i)));
        continue;
        localArrayList.add(getString(i));
        continue;
        localArrayList.add(getMap(i).toHashMap());
        continue;
        localArrayList.add(getArray(i).toArrayList());
      }
    }
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReadableNativeArray
 * JD-Core Version:    0.6.2
 */
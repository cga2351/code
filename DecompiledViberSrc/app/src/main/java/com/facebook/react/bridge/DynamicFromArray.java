package com.facebook.react.bridge;

import android.support.v4.util.Pools.SimplePool;
import javax.annotation.Nullable;

public class DynamicFromArray
  implements Dynamic
{
  private static final Pools.SimplePool<DynamicFromArray> sPool = new Pools.SimplePool(10);

  @Nullable
  private ReadableArray mArray;
  private int mIndex = -1;

  public static DynamicFromArray create(ReadableArray paramReadableArray, int paramInt)
  {
    DynamicFromArray localDynamicFromArray = (DynamicFromArray)sPool.acquire();
    if (localDynamicFromArray == null)
      localDynamicFromArray = new DynamicFromArray();
    localDynamicFromArray.mArray = paramReadableArray;
    localDynamicFromArray.mIndex = paramInt;
    return localDynamicFromArray;
  }

  public ReadableArray asArray()
  {
    if (this.mArray == null)
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mArray.getArray(this.mIndex);
  }

  public boolean asBoolean()
  {
    if (this.mArray == null)
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mArray.getBoolean(this.mIndex);
  }

  public double asDouble()
  {
    if (this.mArray == null)
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mArray.getDouble(this.mIndex);
  }

  public int asInt()
  {
    if (this.mArray == null)
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mArray.getInt(this.mIndex);
  }

  public ReadableMap asMap()
  {
    if (this.mArray == null)
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mArray.getMap(this.mIndex);
  }

  public String asString()
  {
    if (this.mArray == null)
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mArray.getString(this.mIndex);
  }

  public ReadableType getType()
  {
    if (this.mArray == null)
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mArray.getType(this.mIndex);
  }

  public boolean isNull()
  {
    if (this.mArray == null)
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mArray.isNull(this.mIndex);
  }

  public void recycle()
  {
    this.mArray = null;
    this.mIndex = -1;
    sPool.release(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.DynamicFromArray
 * JD-Core Version:    0.6.2
 */
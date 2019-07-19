package com.facebook.react.bridge;

import android.support.v4.util.Pools.SimplePool;
import javax.annotation.Nullable;

public class DynamicFromMap
  implements Dynamic
{
  private static final ThreadLocal<Pools.SimplePool<DynamicFromMap>> sPool = new ThreadLocal()
  {
    protected Pools.SimplePool<DynamicFromMap> initialValue()
    {
      return new Pools.SimplePool(10);
    }
  };

  @Nullable
  private ReadableMap mMap;

  @Nullable
  private String mName;

  public static DynamicFromMap create(ReadableMap paramReadableMap, String paramString)
  {
    DynamicFromMap localDynamicFromMap = (DynamicFromMap)((Pools.SimplePool)sPool.get()).acquire();
    if (localDynamicFromMap == null)
      localDynamicFromMap = new DynamicFromMap();
    localDynamicFromMap.mMap = paramReadableMap;
    localDynamicFromMap.mName = paramString;
    return localDynamicFromMap;
  }

  public ReadableArray asArray()
  {
    if ((this.mMap == null) || (this.mName == null))
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mMap.getArray(this.mName);
  }

  public boolean asBoolean()
  {
    if ((this.mMap == null) || (this.mName == null))
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mMap.getBoolean(this.mName);
  }

  public double asDouble()
  {
    if ((this.mMap == null) || (this.mName == null))
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mMap.getDouble(this.mName);
  }

  public int asInt()
  {
    if ((this.mMap == null) || (this.mName == null))
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mMap.getInt(this.mName);
  }

  public ReadableMap asMap()
  {
    if ((this.mMap == null) || (this.mName == null))
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mMap.getMap(this.mName);
  }

  public String asString()
  {
    if ((this.mMap == null) || (this.mName == null))
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mMap.getString(this.mName);
  }

  public ReadableType getType()
  {
    if ((this.mMap == null) || (this.mName == null))
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mMap.getType(this.mName);
  }

  public boolean isNull()
  {
    if ((this.mMap == null) || (this.mName == null))
      throw new IllegalStateException("This dynamic value has been recycled");
    return this.mMap.isNull(this.mName);
  }

  public void recycle()
  {
    this.mMap = null;
    this.mName = null;
    ((Pools.SimplePool)sPool.get()).release(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.DynamicFromMap
 * JD-Core Version:    0.6.2
 */
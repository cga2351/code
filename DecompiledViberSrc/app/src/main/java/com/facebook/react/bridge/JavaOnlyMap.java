package com.facebook.react.bridge;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class JavaOnlyMap
  implements ReadableMap, WritableMap
{
  private final Map mBackingMap;

  public JavaOnlyMap()
  {
    this.mBackingMap = new HashMap();
  }

  private JavaOnlyMap(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length % 2 != 0)
      throw new IllegalArgumentException("You must provide the same number of keys and values");
    this.mBackingMap = new HashMap();
    for (int i = 0; i < paramArrayOfObject.length; i += 2)
      this.mBackingMap.put(paramArrayOfObject[i], paramArrayOfObject[(i + 1)]);
  }

  public static JavaOnlyMap deepClone(ReadableMap paramReadableMap)
  {
    JavaOnlyMap localJavaOnlyMap = new JavaOnlyMap();
    ReadableMapKeySetIterator localReadableMapKeySetIterator = paramReadableMap.keySetIterator();
    while (localReadableMapKeySetIterator.hasNextKey())
    {
      String str = localReadableMapKeySetIterator.nextKey();
      ReadableType localReadableType = paramReadableMap.getType(str);
      switch (2.$SwitchMap$com$facebook$react$bridge$ReadableType[localReadableType.ordinal()])
      {
      default:
        break;
      case 1:
        localJavaOnlyMap.putNull(str);
        break;
      case 2:
        localJavaOnlyMap.putBoolean(str, paramReadableMap.getBoolean(str));
        break;
      case 3:
        localJavaOnlyMap.putDouble(str, paramReadableMap.getDouble(str));
        break;
      case 4:
        localJavaOnlyMap.putString(str, paramReadableMap.getString(str));
        break;
      case 5:
        localJavaOnlyMap.putMap(str, deepClone(paramReadableMap.getMap(str)));
        break;
      case 6:
        localJavaOnlyMap.putArray(str, JavaOnlyArray.deepClone(paramReadableMap.getArray(str)));
      }
    }
    return localJavaOnlyMap;
  }

  public static JavaOnlyMap of(Object[] paramArrayOfObject)
  {
    return new JavaOnlyMap(paramArrayOfObject);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    JavaOnlyMap localJavaOnlyMap;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localJavaOnlyMap = (JavaOnlyMap)paramObject;
      if (this.mBackingMap == null)
        break;
    }
    while (this.mBackingMap.equals(localJavaOnlyMap.mBackingMap));
    while (true)
    {
      return false;
      if (localJavaOnlyMap.mBackingMap == null)
        break;
    }
  }

  public JavaOnlyArray getArray(@Nonnull String paramString)
  {
    return (JavaOnlyArray)this.mBackingMap.get(paramString);
  }

  public boolean getBoolean(@Nonnull String paramString)
  {
    return ((Boolean)this.mBackingMap.get(paramString)).booleanValue();
  }

  public double getDouble(@Nonnull String paramString)
  {
    return ((Number)this.mBackingMap.get(paramString)).doubleValue();
  }

  @Nonnull
  public Dynamic getDynamic(@Nonnull String paramString)
  {
    return DynamicFromMap.create(this, paramString);
  }

  public int getInt(@Nonnull String paramString)
  {
    return ((Number)this.mBackingMap.get(paramString)).intValue();
  }

  public ReadableMap getMap(@Nonnull String paramString)
  {
    return (WritableMap)this.mBackingMap.get(paramString);
  }

  public String getString(@Nonnull String paramString)
  {
    return (String)this.mBackingMap.get(paramString);
  }

  @Nonnull
  public ReadableType getType(@Nonnull String paramString)
  {
    Object localObject = this.mBackingMap.get(paramString);
    if (localObject == null)
      return ReadableType.Null;
    if ((localObject instanceof Number))
      return ReadableType.Number;
    if ((localObject instanceof String))
      return ReadableType.String;
    if ((localObject instanceof Boolean))
      return ReadableType.Boolean;
    if ((localObject instanceof WritableMap))
      return ReadableType.Map;
    if ((localObject instanceof ReadableArray))
      return ReadableType.Array;
    if ((localObject instanceof Dynamic))
      return ((Dynamic)localObject).getType();
    throw new IllegalArgumentException("Invalid value " + localObject.toString() + " for key " + paramString + "contained in JavaOnlyMap");
  }

  public boolean hasKey(@Nonnull String paramString)
  {
    return this.mBackingMap.containsKey(paramString);
  }

  public int hashCode()
  {
    if (this.mBackingMap != null)
      return this.mBackingMap.hashCode();
    return 0;
  }

  public boolean isNull(@Nonnull String paramString)
  {
    return this.mBackingMap.get(paramString) == null;
  }

  @Nonnull
  public ReadableMapKeySetIterator keySetIterator()
  {
    return new ReadableMapKeySetIterator()
    {
      Iterator<String> mIterator = JavaOnlyMap.this.mBackingMap.keySet().iterator();

      public boolean hasNextKey()
      {
        return this.mIterator.hasNext();
      }

      public String nextKey()
      {
        return (String)this.mIterator.next();
      }
    };
  }

  public void merge(@Nonnull ReadableMap paramReadableMap)
  {
    this.mBackingMap.putAll(((JavaOnlyMap)paramReadableMap).mBackingMap);
  }

  public void putArray(@Nonnull String paramString, @Nullable WritableArray paramWritableArray)
  {
    this.mBackingMap.put(paramString, paramWritableArray);
  }

  public void putBoolean(@Nonnull String paramString, boolean paramBoolean)
  {
    this.mBackingMap.put(paramString, Boolean.valueOf(paramBoolean));
  }

  public void putDouble(@Nonnull String paramString, double paramDouble)
  {
    this.mBackingMap.put(paramString, Double.valueOf(paramDouble));
  }

  public void putInt(@Nonnull String paramString, int paramInt)
  {
    this.mBackingMap.put(paramString, Integer.valueOf(paramInt));
  }

  public void putMap(@Nonnull String paramString, @Nullable WritableMap paramWritableMap)
  {
    this.mBackingMap.put(paramString, paramWritableMap);
  }

  public void putNull(@Nonnull String paramString)
  {
    this.mBackingMap.put(paramString, null);
  }

  public void putString(@Nonnull String paramString1, @Nullable String paramString2)
  {
    this.mBackingMap.put(paramString1, paramString2);
  }

  @Nonnull
  public HashMap<String, Object> toHashMap()
  {
    return new HashMap(this.mBackingMap);
  }

  public String toString()
  {
    return this.mBackingMap.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JavaOnlyMap
 * JD-Core Version:    0.6.2
 */
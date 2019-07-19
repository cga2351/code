package com.facebook.react.bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class JavaOnlyArray
  implements ReadableArray, WritableArray
{
  private final List mBackingList;

  public JavaOnlyArray()
  {
    this.mBackingList = new ArrayList();
  }

  private JavaOnlyArray(List paramList)
  {
    this.mBackingList = new ArrayList(paramList);
  }

  private JavaOnlyArray(Object[] paramArrayOfObject)
  {
    this.mBackingList = Arrays.asList(paramArrayOfObject);
  }

  public static JavaOnlyArray deepClone(ReadableArray paramReadableArray)
  {
    JavaOnlyArray localJavaOnlyArray = new JavaOnlyArray();
    int i = 0;
    int j = paramReadableArray.size();
    if (i < j)
    {
      ReadableType localReadableType = paramReadableArray.getType(i);
      switch (1.$SwitchMap$com$facebook$react$bridge$ReadableType[localReadableType.ordinal()])
      {
      default:
      case 1:
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
        localJavaOnlyArray.pushNull();
        continue;
        localJavaOnlyArray.pushBoolean(paramReadableArray.getBoolean(i));
        continue;
        localJavaOnlyArray.pushDouble(paramReadableArray.getDouble(i));
        continue;
        localJavaOnlyArray.pushString(paramReadableArray.getString(i));
        continue;
        localJavaOnlyArray.pushMap(JavaOnlyMap.deepClone(paramReadableArray.getMap(i)));
        continue;
        localJavaOnlyArray.pushArray(deepClone(paramReadableArray.getArray(i)));
      }
    }
    return localJavaOnlyArray;
  }

  public static JavaOnlyArray from(List paramList)
  {
    return new JavaOnlyArray(paramList);
  }

  public static JavaOnlyArray of(Object[] paramArrayOfObject)
  {
    return new JavaOnlyArray(paramArrayOfObject);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    JavaOnlyArray localJavaOnlyArray;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localJavaOnlyArray = (JavaOnlyArray)paramObject;
      if (this.mBackingList == null)
        break;
    }
    while (this.mBackingList.equals(localJavaOnlyArray.mBackingList));
    while (true)
    {
      return false;
      if (localJavaOnlyArray.mBackingList == null)
        break;
    }
  }

  public JavaOnlyArray getArray(int paramInt)
  {
    return (JavaOnlyArray)this.mBackingList.get(paramInt);
  }

  public boolean getBoolean(int paramInt)
  {
    return ((Boolean)this.mBackingList.get(paramInt)).booleanValue();
  }

  public double getDouble(int paramInt)
  {
    return ((Number)this.mBackingList.get(paramInt)).doubleValue();
  }

  @Nonnull
  public Dynamic getDynamic(int paramInt)
  {
    return DynamicFromArray.create(this, paramInt);
  }

  public int getInt(int paramInt)
  {
    return ((Number)this.mBackingList.get(paramInt)).intValue();
  }

  public JavaOnlyMap getMap(int paramInt)
  {
    return (JavaOnlyMap)this.mBackingList.get(paramInt);
  }

  @Nullable
  public String getString(int paramInt)
  {
    return (String)this.mBackingList.get(paramInt);
  }

  @Nonnull
  public ReadableType getType(int paramInt)
  {
    Object localObject = this.mBackingList.get(paramInt);
    if (localObject == null)
      return ReadableType.Null;
    if ((localObject instanceof Boolean))
      return ReadableType.Boolean;
    if (((localObject instanceof Double)) || ((localObject instanceof Float)) || ((localObject instanceof Integer)))
      return ReadableType.Number;
    if ((localObject instanceof String))
      return ReadableType.String;
    if ((localObject instanceof WritableArray))
      return ReadableType.Array;
    if ((localObject instanceof ReadableMap))
      return ReadableType.Map;
    return null;
  }

  public int hashCode()
  {
    if (this.mBackingList != null)
      return this.mBackingList.hashCode();
    return 0;
  }

  public boolean isNull(int paramInt)
  {
    return this.mBackingList.get(paramInt) == null;
  }

  public void pushArray(@Nullable WritableArray paramWritableArray)
  {
    this.mBackingList.add(paramWritableArray);
  }

  public void pushBoolean(boolean paramBoolean)
  {
    this.mBackingList.add(Boolean.valueOf(paramBoolean));
  }

  public void pushDouble(double paramDouble)
  {
    this.mBackingList.add(Double.valueOf(paramDouble));
  }

  public void pushInt(int paramInt)
  {
    this.mBackingList.add(Integer.valueOf(paramInt));
  }

  public void pushMap(@Nullable WritableMap paramWritableMap)
  {
    this.mBackingList.add(paramWritableMap);
  }

  public void pushNull()
  {
    this.mBackingList.add(null);
  }

  public void pushString(@Nullable String paramString)
  {
    this.mBackingList.add(paramString);
  }

  public int size()
  {
    return this.mBackingList.size();
  }

  @Nonnull
  public ArrayList<Object> toArrayList()
  {
    return new ArrayList(this.mBackingList);
  }

  public String toString()
  {
    return this.mBackingList.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JavaOnlyArray
 * JD-Core Version:    0.6.2
 */
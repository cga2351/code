package com.facebook.react.bridge;

import android.os.Bundle;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

public class Arguments
{
  private static void addEntry(WritableNativeMap paramWritableNativeMap, String paramString, Object paramObject)
  {
    Object localObject = makeNativeObject(paramObject);
    if (localObject == null)
    {
      paramWritableNativeMap.putNull(paramString);
      return;
    }
    if ((localObject instanceof Boolean))
    {
      paramWritableNativeMap.putBoolean(paramString, ((Boolean)localObject).booleanValue());
      return;
    }
    if ((localObject instanceof Integer))
    {
      paramWritableNativeMap.putInt(paramString, ((Integer)localObject).intValue());
      return;
    }
    if ((localObject instanceof Number))
    {
      paramWritableNativeMap.putDouble(paramString, ((Number)localObject).doubleValue());
      return;
    }
    if ((localObject instanceof String))
    {
      paramWritableNativeMap.putString(paramString, (String)localObject);
      return;
    }
    if ((localObject instanceof WritableNativeArray))
    {
      paramWritableNativeMap.putArray(paramString, (WritableNativeArray)localObject);
      return;
    }
    if ((localObject instanceof WritableNativeMap))
    {
      paramWritableNativeMap.putMap(paramString, (WritableNativeMap)localObject);
      return;
    }
    throw new IllegalArgumentException("Could not convert " + localObject.getClass());
  }

  public static WritableArray createArray()
  {
    return new WritableNativeArray();
  }

  public static WritableMap createMap()
  {
    return new WritableNativeMap();
  }

  public static WritableArray fromArray(Object paramObject)
  {
    int i = 0;
    WritableArray localWritableArray = createArray();
    if ((paramObject instanceof String[]))
    {
      String[] arrayOfString = (String[])paramObject;
      int i2 = arrayOfString.length;
      while (i < i2)
      {
        localWritableArray.pushString(arrayOfString[i]);
        i++;
      }
    }
    if ((paramObject instanceof Bundle[]))
    {
      Bundle[] arrayOfBundle = (Bundle[])paramObject;
      int i1 = arrayOfBundle.length;
      while (i < i1)
      {
        localWritableArray.pushMap(fromBundle(arrayOfBundle[i]));
        i++;
      }
    }
    if ((paramObject instanceof int[]))
    {
      int[] arrayOfInt = (int[])paramObject;
      int n = arrayOfInt.length;
      while (i < n)
      {
        localWritableArray.pushInt(arrayOfInt[i]);
        i++;
      }
    }
    if ((paramObject instanceof float[]))
    {
      float[] arrayOfFloat = (float[])paramObject;
      int m = arrayOfFloat.length;
      while (i < m)
      {
        localWritableArray.pushDouble(arrayOfFloat[i]);
        i++;
      }
    }
    if ((paramObject instanceof double[]))
    {
      double[] arrayOfDouble = (double[])paramObject;
      int k = arrayOfDouble.length;
      while (i < k)
      {
        localWritableArray.pushDouble(arrayOfDouble[i]);
        i++;
      }
    }
    if ((paramObject instanceof boolean[]))
    {
      boolean[] arrayOfBoolean = (boolean[])paramObject;
      int j = arrayOfBoolean.length;
      while (i < j)
      {
        localWritableArray.pushBoolean(arrayOfBoolean[i]);
        i++;
      }
    }
    throw new IllegalArgumentException("Unknown array type " + paramObject.getClass());
    return localWritableArray;
  }

  public static WritableMap fromBundle(Bundle paramBundle)
  {
    WritableMap localWritableMap = createMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if (localObject == null)
        localWritableMap.putNull(str);
      else if (localObject.getClass().isArray())
        localWritableMap.putArray(str, fromArray(localObject));
      else if ((localObject instanceof String))
        localWritableMap.putString(str, (String)localObject);
      else if ((localObject instanceof Number))
      {
        if ((localObject instanceof Integer))
          localWritableMap.putInt(str, ((Integer)localObject).intValue());
        else
          localWritableMap.putDouble(str, ((Number)localObject).doubleValue());
      }
      else if ((localObject instanceof Boolean))
        localWritableMap.putBoolean(str, ((Boolean)localObject).booleanValue());
      else if ((localObject instanceof Bundle))
        localWritableMap.putMap(str, fromBundle((Bundle)localObject));
      else if ((localObject instanceof List))
        localWritableMap.putArray(str, fromList((List)localObject));
      else
        throw new IllegalArgumentException("Could not convert " + localObject.getClass());
    }
    return localWritableMap;
  }

  public static WritableNativeArray fromJavaArgs(Object[] paramArrayOfObject)
  {
    WritableNativeArray localWritableNativeArray = new WritableNativeArray();
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      Object localObject = paramArrayOfObject[i];
      if (localObject == null)
        localWritableNativeArray.pushNull();
      Class localClass;
      while (true)
      {
        i++;
        break;
        localClass = localObject.getClass();
        if (localClass == Boolean.class)
        {
          localWritableNativeArray.pushBoolean(((Boolean)localObject).booleanValue());
        }
        else if (localClass == Integer.class)
        {
          localWritableNativeArray.pushDouble(((Integer)localObject).doubleValue());
        }
        else if (localClass == Double.class)
        {
          localWritableNativeArray.pushDouble(((Double)localObject).doubleValue());
        }
        else if (localClass == Float.class)
        {
          localWritableNativeArray.pushDouble(((Float)localObject).doubleValue());
        }
        else if (localClass == String.class)
        {
          localWritableNativeArray.pushString(localObject.toString());
        }
        else if (localClass == WritableNativeMap.class)
        {
          localWritableNativeArray.pushMap((WritableNativeMap)localObject);
        }
        else
        {
          if (localClass != WritableNativeArray.class)
            break label178;
          localWritableNativeArray.pushArray((WritableNativeArray)localObject);
        }
      }
      label178: throw new RuntimeException("Cannot convert argument of type " + localClass);
    }
    return localWritableNativeArray;
  }

  public static WritableArray fromList(List paramList)
  {
    WritableArray localWritableArray = createArray();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (localObject == null)
        localWritableArray.pushNull();
      else if (localObject.getClass().isArray())
        localWritableArray.pushArray(fromArray(localObject));
      else if ((localObject instanceof Bundle))
        localWritableArray.pushMap(fromBundle((Bundle)localObject));
      else if ((localObject instanceof List))
        localWritableArray.pushArray(fromList((List)localObject));
      else if ((localObject instanceof String))
        localWritableArray.pushString((String)localObject);
      else if ((localObject instanceof Integer))
        localWritableArray.pushInt(((Integer)localObject).intValue());
      else if ((localObject instanceof Number))
        localWritableArray.pushDouble(((Number)localObject).doubleValue());
      else if ((localObject instanceof Boolean))
        localWritableArray.pushBoolean(((Boolean)localObject).booleanValue());
      else
        throw new IllegalArgumentException("Unknown value type " + localObject.getClass());
    }
    return localWritableArray;
  }

  public static <T> WritableNativeArray makeNativeArray(Object paramObject)
  {
    if (paramObject == null)
      return new WritableNativeArray();
    return makeNativeArray(new AbstractList()
    {
      public Object get(int paramAnonymousInt)
      {
        return Array.get(this.val$objects, paramAnonymousInt);
      }

      public int size()
      {
        return Array.getLength(this.val$objects);
      }
    });
  }

  public static WritableNativeArray makeNativeArray(List paramList)
  {
    WritableNativeArray localWritableNativeArray = new WritableNativeArray();
    if (paramList == null)
      return localWritableNativeArray;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = makeNativeObject(localIterator.next());
      if (localObject == null)
        localWritableNativeArray.pushNull();
      else if ((localObject instanceof Boolean))
        localWritableNativeArray.pushBoolean(((Boolean)localObject).booleanValue());
      else if ((localObject instanceof Integer))
        localWritableNativeArray.pushInt(((Integer)localObject).intValue());
      else if ((localObject instanceof Double))
        localWritableNativeArray.pushDouble(((Double)localObject).doubleValue());
      else if ((localObject instanceof String))
        localWritableNativeArray.pushString((String)localObject);
      else if ((localObject instanceof WritableNativeArray))
        localWritableNativeArray.pushArray((WritableNativeArray)localObject);
      else if ((localObject instanceof WritableNativeMap))
        localWritableNativeArray.pushMap((WritableNativeMap)localObject);
      else
        throw new IllegalArgumentException("Could not convert " + localObject.getClass());
    }
    return localWritableNativeArray;
  }

  public static WritableNativeMap makeNativeMap(Bundle paramBundle)
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    if (paramBundle == null)
      return localWritableNativeMap;
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      addEntry(localWritableNativeMap, str, paramBundle.get(str));
    }
    return localWritableNativeMap;
  }

  public static WritableNativeMap makeNativeMap(Map<String, Object> paramMap)
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    if (paramMap == null)
      return localWritableNativeMap;
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      addEntry(localWritableNativeMap, (String)localEntry.getKey(), localEntry.getValue());
    }
    return localWritableNativeMap;
  }

  private static Object makeNativeObject(Object paramObject)
  {
    if (paramObject == null)
      paramObject = null;
    do
    {
      return paramObject;
      if (((paramObject instanceof Float)) || ((paramObject instanceof Long)) || ((paramObject instanceof Byte)) || ((paramObject instanceof Short)))
        return Double.valueOf(((Number)paramObject).doubleValue());
      if (paramObject.getClass().isArray())
        return makeNativeArray(paramObject);
      if ((paramObject instanceof List))
        return makeNativeArray((List)paramObject);
      if ((paramObject instanceof Map))
        return makeNativeMap((Map)paramObject);
    }
    while (!(paramObject instanceof Bundle));
    return makeNativeMap((Bundle)paramObject);
  }

  @Nullable
  public static Bundle toBundle(@Nullable ReadableMap paramReadableMap)
  {
    if (paramReadableMap == null)
      return null;
    ReadableMapKeySetIterator localReadableMapKeySetIterator = paramReadableMap.keySetIterator();
    Bundle localBundle = new Bundle();
    while (localReadableMapKeySetIterator.hasNextKey())
    {
      String str = localReadableMapKeySetIterator.nextKey();
      ReadableType localReadableType = paramReadableMap.getType(str);
      switch (2.$SwitchMap$com$facebook$react$bridge$ReadableType[localReadableType.ordinal()])
      {
      default:
        throw new IllegalArgumentException("Could not convert object with key: " + str + ".");
      case 1:
        localBundle.putString(str, null);
        break;
      case 2:
        localBundle.putBoolean(str, paramReadableMap.getBoolean(str));
        break;
      case 3:
        localBundle.putDouble(str, paramReadableMap.getDouble(str));
        break;
      case 4:
        localBundle.putString(str, paramReadableMap.getString(str));
        break;
      case 5:
        localBundle.putBundle(str, toBundle(paramReadableMap.getMap(str)));
        break;
      case 6:
        localBundle.putSerializable(str, toList(paramReadableMap.getArray(str)));
      }
    }
    return localBundle;
  }

  @Nullable
  public static ArrayList toList(@Nullable ReadableArray paramReadableArray)
  {
    if (paramReadableArray == null)
      return null;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramReadableArray.size())
    {
      switch (2.$SwitchMap$com$facebook$react$bridge$ReadableType[paramReadableArray.getType(i).ordinal()])
      {
      default:
        throw new IllegalArgumentException("Could not convert object in array.");
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
        localArrayList.add(Boolean.valueOf(paramReadableArray.getBoolean(i)));
        continue;
        double d = paramReadableArray.getDouble(i);
        if (d == Math.rint(d))
        {
          localArrayList.add(Integer.valueOf((int)d));
        }
        else
        {
          localArrayList.add(Double.valueOf(d));
          continue;
          localArrayList.add(paramReadableArray.getString(i));
          continue;
          localArrayList.add(toBundle(paramReadableArray.getMap(i)));
          continue;
          localArrayList.add(toList(paramReadableArray.getArray(i)));
        }
      }
    }
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.Arguments
 * JD-Core Version:    0.6.2
 */
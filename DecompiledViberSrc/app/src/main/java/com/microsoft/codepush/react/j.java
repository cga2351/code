package com.microsoft.codepush.react;

import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j
{
  public static WritableArray a(JSONArray paramJSONArray)
  {
    WritableArray localWritableArray = Arguments.createArray();
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject;
      while (true)
      {
        try
        {
          localObject = paramJSONArray.get(i);
          if ((localObject instanceof JSONObject))
          {
            localWritableArray.pushMap(a((JSONObject)localObject));
            i++;
          }
        }
        catch (JSONException localJSONException)
        {
          throw new f(i + " should be within bounds of array " + paramJSONArray.toString(), localJSONException);
        }
        if ((localObject instanceof JSONArray))
        {
          localWritableArray.pushArray(a((JSONArray)localObject));
        }
        else if ((localObject instanceof String))
        {
          localWritableArray.pushString((String)localObject);
        }
        else if ((localObject instanceof Double))
        {
          localWritableArray.pushDouble(((Double)localObject).doubleValue());
        }
        else if ((localObject instanceof Integer))
        {
          localWritableArray.pushInt(((Integer)localObject).intValue());
        }
        else if ((localObject instanceof Boolean))
        {
          localWritableArray.pushBoolean(((Boolean)localObject).booleanValue());
        }
        else
        {
          if (localObject != null)
            break label221;
          localWritableArray.pushNull();
        }
      }
      label221: throw new f("Unrecognized object: " + localObject);
    }
    return localWritableArray;
  }

  public static WritableMap a(JSONObject paramJSONObject)
  {
    WritableMap localWritableMap = Arguments.createMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject;
      try
      {
        localObject = paramJSONObject.get(str);
        if ((localObject instanceof JSONObject))
          localWritableMap.putMap(str, a((JSONObject)localObject));
      }
      catch (JSONException localJSONException)
      {
        throw new f("Key " + str + " should exist in " + paramJSONObject.toString() + ".", localJSONException);
      }
      if ((localObject instanceof JSONArray))
        localWritableMap.putArray(str, a((JSONArray)localObject));
      else if ((localObject instanceof String))
        localWritableMap.putString(str, (String)localObject);
      else if ((localObject instanceof Double))
        localWritableMap.putDouble(str, ((Double)localObject).doubleValue());
      else if ((localObject instanceof Long))
        localWritableMap.putDouble(str, ((Long)localObject).doubleValue());
      else if ((localObject instanceof Integer))
        localWritableMap.putInt(str, ((Integer)localObject).intValue());
      else if ((localObject instanceof Boolean))
        localWritableMap.putBoolean(str, ((Boolean)localObject).booleanValue());
      else if (localObject == null)
        localWritableMap.putNull(str);
      else
        throw new f("Unrecognized object: " + localObject);
    }
    return localWritableMap;
  }

  public static String a(ReadableMap paramReadableMap, String paramString)
  {
    try
    {
      String str = paramReadableMap.getString(paramString);
      return str;
    }
    catch (NoSuchKeyException localNoSuchKeyException)
    {
    }
    return null;
  }

  public static String a(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
      try
      {
        while (true)
        {
          String str1 = localBufferedReader.readLine();
          if (str1 == null)
            break;
          localStringBuilder.append(str1);
          localStringBuilder.append("\n");
        }
      }
      finally
      {
      }
      if (localBufferedReader != null)
        localBufferedReader.close();
      if (paramInputStream != null)
        paramInputStream.close();
      throw localObject1;
      String str2 = localStringBuilder.toString().trim();
      if (localBufferedReader != null)
        localBufferedReader.close();
      if (paramInputStream != null)
        paramInputStream.close();
      return str2;
    }
    finally
    {
      while (true)
        BufferedReader localBufferedReader = null;
    }
  }

  public static String a(String paramString1, String paramString2)
  {
    return new File(paramString1, paramString2).getAbsolutePath();
  }

  public static JSONArray a(ReadableArray paramReadableArray)
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    if (i < paramReadableArray.size())
    {
      ReadableType localReadableType = paramReadableArray.getType(i);
      switch (1.a[localReadableType.ordinal()])
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
        localJSONArray.put(a(paramReadableArray.getMap(i)));
        continue;
        localJSONArray.put(a(paramReadableArray.getArray(i)));
        continue;
        localJSONArray.put(paramReadableArray.getString(i));
        continue;
        Double localDouble = Double.valueOf(paramReadableArray.getDouble(i));
        if ((localDouble.doubleValue() == Math.floor(localDouble.doubleValue())) && (!Double.isInfinite(localDouble.doubleValue())))
        {
          localJSONArray.put(localDouble.longValue());
        }
        else
        {
          try
          {
            localJSONArray.put(localDouble.doubleValue());
          }
          catch (JSONException localJSONException)
          {
            throw new f("Unable to put value " + paramReadableArray.getDouble(i) + " in JSONArray");
          }
          localJSONArray.put(paramReadableArray.getBoolean(i));
          continue;
          localJSONArray.put(null);
        }
      }
    }
    return localJSONArray;
  }

  public static JSONObject a(ReadableMap paramReadableMap)
  {
    JSONObject localJSONObject = new JSONObject();
    ReadableMapKeySetIterator localReadableMapKeySetIterator = paramReadableMap.keySetIterator();
    while (localReadableMapKeySetIterator.hasNextKey())
    {
      String str = localReadableMapKeySetIterator.nextKey();
      ReadableType localReadableType = paramReadableMap.getType(str);
      try
      {
        switch (1.a[localReadableType.ordinal()])
        {
        default:
          throw new f("Unrecognized type: " + localReadableType + " of key: " + str);
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        }
      }
      catch (JSONException localJSONException)
      {
        throw new f("Error setting key: " + str + " in JSONObject", localJSONException);
      }
      localJSONObject.put(str, a(paramReadableMap.getMap(str)));
      continue;
      localJSONObject.put(str, a(paramReadableMap.getArray(str)));
      continue;
      localJSONObject.put(str, paramReadableMap.getString(str));
      continue;
      localJSONObject.put(str, paramReadableMap.getDouble(str));
      continue;
      localJSONObject.put(str, paramReadableMap.getBoolean(str));
      continue;
      localJSONObject.put(str, null);
    }
    return localJSONObject;
  }

  public static JSONObject a(String paramString)
    throws IOException
  {
    String str = m.d(paramString);
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new d(paramString, localJSONException);
    }
  }

  public static void a(Throwable paramThrowable)
  {
    Log.e("ReactNative", "[CodePush] Exception", paramThrowable);
  }

  public static void a(JSONObject paramJSONObject, String paramString)
    throws IOException
  {
    m.b(paramJSONObject.toString(), paramString);
  }

  public static void a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    try
    {
      paramJSONObject.put(paramString, paramObject);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
    throw new f("Unable to set value " + paramObject + " for key " + paramString + " to JSONObject");
  }

  public static void b(String paramString)
  {
    Log.d("ReactNative", "[CodePush] " + paramString);
  }

  public static void c(String paramString)
  {
    b("Loading JS bundle from \"" + paramString + "\"");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.microsoft.codepush.react.j
 * JD-Core Version:    0.6.2
 */
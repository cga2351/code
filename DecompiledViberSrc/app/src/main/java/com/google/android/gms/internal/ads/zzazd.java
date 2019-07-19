package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzare
public final class zzazd
{
  private static final zzazf<Map<String, ?>> zzdxt = new zzaze();

  public static String zza(zzazg paramzzazg)
  {
    return zzl(paramzzazg);
  }

  public static List<String> zza(JsonReader paramJsonReader)
    throws IllegalStateException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext())
      localArrayList.add(paramJsonReader.nextString());
    paramJsonReader.endArray();
    return localArrayList;
  }

  public static List<String> zza(JSONArray paramJSONArray, List<String> paramList)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray == null)
      return localArrayList;
    for (int i = 0; i < paramJSONArray.length(); i++)
      localArrayList.add(paramJSONArray.getString(i));
    return localArrayList;
  }

  public static JSONObject zza(String paramString, Object paramObject)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put(paramString, paramObject);
    return localJSONObject;
  }

  public static JSONObject zza(JSONObject paramJSONObject, String[] paramArrayOfString)
  {
    JSONObject localJSONObject = zzb(paramJSONObject, paramArrayOfString);
    if (localJSONObject == null)
      return null;
    return localJSONObject.optJSONObject(paramArrayOfString[(-1 + paramArrayOfString.length)]);
  }

  private static void zza(JsonWriter paramJsonWriter, Object paramObject)
    throws IOException
  {
    if (paramObject == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    if ((paramObject instanceof Number))
    {
      paramJsonWriter.value((Number)paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      paramJsonWriter.value(((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof String))
    {
      paramJsonWriter.value((String)paramObject);
      return;
    }
    if ((paramObject instanceof zzazg))
    {
      ((zzazg)paramObject).zza(paramJsonWriter);
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramJsonWriter.beginObject();
      Iterator localIterator2 = ((Map)paramObject).entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator2.next();
        Object localObject1 = localEntry.getKey();
        if ((localObject1 instanceof String))
        {
          Object localObject2 = localEntry.getValue();
          zza(paramJsonWriter.name((String)localObject1), localObject2);
        }
      }
      paramJsonWriter.endObject();
      return;
    }
    if ((paramObject instanceof List))
    {
      paramJsonWriter.beginArray();
      Iterator localIterator1 = ((List)paramObject).iterator();
      while (localIterator1.hasNext())
        zza(paramJsonWriter, localIterator1.next());
      paramJsonWriter.endArray();
      return;
    }
    paramJsonWriter.nullValue();
  }

  private static void zza(JsonWriter paramJsonWriter, JSONArray paramJSONArray)
    throws IOException
  {
    while (true)
    {
      int i;
      Object localObject;
      try
      {
        paramJsonWriter.beginArray();
        i = 0;
        if (i >= paramJSONArray.length())
          break label187;
        localObject = paramJSONArray.get(i);
        if ((localObject instanceof String))
          paramJsonWriter.value((String)localObject);
        else if ((localObject instanceof Number))
          paramJsonWriter.value((Number)localObject);
      }
      catch (JSONException localJSONException)
      {
        throw new IOException(localJSONException);
      }
      if ((localObject instanceof Boolean))
      {
        paramJsonWriter.value(((Boolean)localObject).booleanValue());
      }
      else if ((localObject instanceof JSONObject))
      {
        zza(paramJsonWriter, (JSONObject)localObject);
      }
      else if ((localObject instanceof JSONArray))
      {
        zza(paramJsonWriter, (JSONArray)localObject);
      }
      else
      {
        String str = String.valueOf(localObject);
        throw new JSONException(23 + String.valueOf(str).length() + "unable to write field: " + str);
        label187: paramJsonWriter.endArray();
        return;
      }
      i++;
    }
  }

  public static void zza(JsonWriter paramJsonWriter, JSONObject paramJSONObject)
    throws IOException
  {
    while (true)
    {
      String str1;
      Object localObject;
      try
      {
        paramJsonWriter.beginObject();
        Iterator localIterator = paramJSONObject.keys();
        if (!localIterator.hasNext())
          break;
        str1 = (String)localIterator.next();
        localObject = paramJSONObject.get(str1);
        if ((localObject instanceof String))
        {
          paramJsonWriter.name(str1).value((String)localObject);
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        throw new IOException(localJSONException);
      }
      if ((localObject instanceof Number))
      {
        paramJsonWriter.name(str1).value((Number)localObject);
      }
      else if ((localObject instanceof Boolean))
      {
        paramJsonWriter.name(str1).value(((Boolean)localObject).booleanValue());
      }
      else if ((localObject instanceof JSONObject))
      {
        zza(paramJsonWriter.name(str1), (JSONObject)localObject);
      }
      else if ((localObject instanceof JSONArray))
      {
        zza(paramJsonWriter.name(str1), (JSONArray)localObject);
      }
      else
      {
        String str2 = String.valueOf(localObject);
        throw new JSONException(23 + String.valueOf(str2).length() + "unable to write field: " + str2);
      }
    }
    paramJsonWriter.endObject();
  }

  public static boolean zza(boolean paramBoolean, JSONObject paramJSONObject, String[] paramArrayOfString)
  {
    JSONObject localJSONObject = zzb(paramJSONObject, paramArrayOfString);
    if (localJSONObject == null)
      return false;
    return localJSONObject.optBoolean(paramArrayOfString[(-1 + paramArrayOfString.length)], false);
  }

  public static Map<String, String> zzb(JsonReader paramJsonReader)
    throws IllegalStateException, IOException
  {
    HashMap localHashMap = new HashMap();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
      localHashMap.put(paramJsonReader.nextName(), paramJsonReader.nextString());
    paramJsonReader.endObject();
    return localHashMap;
  }

  public static JSONObject zzb(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    try
    {
      JSONObject localJSONObject2 = paramJSONObject.getJSONObject(paramString);
      return localJSONObject2;
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject1 = new JSONObject();
      paramJSONObject.put(paramString, localJSONObject1);
      return localJSONObject1;
    }
  }

  private static JSONObject zzb(JSONObject paramJSONObject, String[] paramArrayOfString)
  {
    for (int i = 0; ; i++)
    {
      if (i < -1 + paramArrayOfString.length)
      {
        if (paramJSONObject == null)
          paramJSONObject = null;
      }
      else
        return paramJSONObject;
      paramJSONObject = paramJSONObject.optJSONObject(paramArrayOfString[i]);
    }
  }

  public static JSONObject zzc(JsonReader paramJsonReader)
    throws IllegalStateException, IOException, JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    paramJsonReader.beginObject();
    while (paramJsonReader.hasNext())
    {
      String str1 = paramJsonReader.nextName();
      JsonToken localJsonToken = paramJsonReader.peek();
      if (JsonToken.BEGIN_ARRAY.equals(localJsonToken))
      {
        localJSONObject.put(str1, zzd(paramJsonReader));
      }
      else if (JsonToken.BEGIN_OBJECT.equals(localJsonToken))
      {
        localJSONObject.put(str1, zzc(paramJsonReader));
      }
      else if (JsonToken.BOOLEAN.equals(localJsonToken))
      {
        localJSONObject.put(str1, paramJsonReader.nextBoolean());
      }
      else if (JsonToken.NUMBER.equals(localJsonToken))
      {
        localJSONObject.put(str1, paramJsonReader.nextDouble());
      }
      else if (JsonToken.STRING.equals(localJsonToken))
      {
        localJSONObject.put(str1, paramJsonReader.nextString());
      }
      else
      {
        String str2 = String.valueOf(localJsonToken);
        throw new IllegalStateException(23 + String.valueOf(str2).length() + "unexpected json token: " + str2);
      }
    }
    paramJsonReader.endObject();
    return localJSONObject;
  }

  public static JSONArray zzd(JsonReader paramJsonReader)
    throws IllegalStateException, IOException, JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext())
    {
      JsonToken localJsonToken = paramJsonReader.peek();
      if (JsonToken.BEGIN_ARRAY.equals(localJsonToken))
      {
        localJSONArray.put(zzd(paramJsonReader));
      }
      else if (JsonToken.BEGIN_OBJECT.equals(localJsonToken))
      {
        localJSONArray.put(zzc(paramJsonReader));
      }
      else if (JsonToken.BOOLEAN.equals(localJsonToken))
      {
        localJSONArray.put(paramJsonReader.nextBoolean());
      }
      else if (JsonToken.NUMBER.equals(localJsonToken))
      {
        localJSONArray.put(paramJsonReader.nextDouble());
      }
      else if (JsonToken.STRING.equals(localJsonToken))
      {
        localJSONArray.put(paramJsonReader.nextString());
      }
      else
      {
        String str = String.valueOf(localJsonToken);
        throw new IllegalStateException(23 + String.valueOf(str).length() + "unexpected json token: " + str);
      }
    }
    paramJsonReader.endArray();
    return localJSONArray;
  }

  private static String zzl(Object paramObject)
  {
    if (paramObject == null)
      return null;
    StringWriter localStringWriter = new StringWriter();
    try
    {
      JsonWriter localJsonWriter = new JsonWriter(localStringWriter);
      zza(localJsonWriter, paramObject);
      localJsonWriter.close();
      return localStringWriter.toString();
    }
    catch (IOException localIOException)
    {
      zzaxa.zzc("Error when writing JSON.", localIOException);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzazd
 * JD-Core Version:    0.6.2
 */
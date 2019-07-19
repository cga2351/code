package com.facebook.react.bridge;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class JsonWriterHelper
{
  private static void listValue(JsonWriter paramJsonWriter, List<?> paramList)
    throws IOException
  {
    paramJsonWriter.beginArray();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      objectValue(paramJsonWriter, localIterator.next());
    paramJsonWriter.endArray();
  }

  private static void mapValue(JsonWriter paramJsonWriter, Map<?, ?> paramMap)
    throws IOException
  {
    paramJsonWriter.beginObject();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramJsonWriter.name(localEntry.getKey().toString());
      value(paramJsonWriter, localEntry.getValue());
    }
    paramJsonWriter.endObject();
  }

  private static void objectValue(JsonWriter paramJsonWriter, Object paramObject)
    throws IOException
  {
    if (paramObject == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    if ((paramObject instanceof String))
    {
      paramJsonWriter.value((String)paramObject);
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
    throw new IllegalArgumentException("Unknown value: " + paramObject);
  }

  public static void value(JsonWriter paramJsonWriter, Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof Map))
    {
      mapValue(paramJsonWriter, (Map)paramObject);
      return;
    }
    if ((paramObject instanceof List))
    {
      listValue(paramJsonWriter, (List)paramObject);
      return;
    }
    objectValue(paramJsonWriter, paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JsonWriterHelper
 * JD-Core Version:    0.6.2
 */
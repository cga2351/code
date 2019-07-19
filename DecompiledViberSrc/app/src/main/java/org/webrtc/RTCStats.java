package org.webrtc;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RTCStats
{
  private final String id;
  private final Map<String, Object> members;
  private final long timestampUs;
  private final String type;

  public RTCStats(long paramLong, String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    this.timestampUs = paramLong;
    this.type = paramString1;
    this.id = paramString2;
    this.members = paramMap;
  }

  private static void appendValue(StringBuilder paramStringBuilder, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      paramStringBuilder.append('[');
      for (int i = 0; i < arrayOfObject.length; i++)
      {
        if (i != 0)
          paramStringBuilder.append(", ");
        appendValue(paramStringBuilder, arrayOfObject[i]);
      }
      paramStringBuilder.append(']');
      return;
    }
    if ((paramObject instanceof String))
    {
      paramStringBuilder.append('"').append(paramObject).append('"');
      return;
    }
    paramStringBuilder.append(paramObject);
  }

  @CalledByNative
  static RTCStats create(long paramLong, String paramString1, String paramString2, Map paramMap)
  {
    return new RTCStats(paramLong, paramString1, paramString2, paramMap);
  }

  public String getId()
  {
    return this.id;
  }

  public Map<String, Object> getMembers()
  {
    return this.members;
  }

  public double getTimestampUs()
  {
    return this.timestampUs;
  }

  public String getType()
  {
    return this.type;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{ timestampUs: ").append(this.timestampUs).append(", type: ").append(this.type).append(", id: ").append(this.id);
    Iterator localIterator = this.members.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append(", ").append((String)localEntry.getKey()).append(": ");
      appendValue(localStringBuilder, localEntry.getValue());
    }
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.RTCStats
 * JD-Core Version:    0.6.2
 */
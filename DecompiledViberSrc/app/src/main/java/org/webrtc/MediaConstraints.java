package org.webrtc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class MediaConstraints
{
  public final List<KeyValuePair> mandatory = new ArrayList();
  public final List<KeyValuePair> optional = new ArrayList();

  private static String stringifyKeyValuePairList(List<KeyValuePair> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      KeyValuePair localKeyValuePair = (KeyValuePair)localIterator.next();
      if (localStringBuilder.length() > 1)
        localStringBuilder.append(", ");
      localStringBuilder.append(localKeyValuePair.toString());
    }
    return "]";
  }

  @CalledByNative
  List<KeyValuePair> getMandatory()
  {
    return this.mandatory;
  }

  @CalledByNative
  List<KeyValuePair> getOptional()
  {
    return this.optional;
  }

  public String toString()
  {
    return "mandatory: " + stringifyKeyValuePairList(this.mandatory) + ", optional: " + stringifyKeyValuePairList(this.optional);
  }

  public static class KeyValuePair
  {
    private final String key;
    private final String value;

    public KeyValuePair(String paramString1, String paramString2)
    {
      this.key = paramString1;
      this.value = paramString2;
    }

    public boolean equals(@Nullable Object paramObject)
    {
      if (this == paramObject);
      KeyValuePair localKeyValuePair;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        localKeyValuePair = (KeyValuePair)paramObject;
      }
      while ((this.key.equals(localKeyValuePair.key)) && (this.value.equals(localKeyValuePair.value)));
      return false;
    }

    @CalledByNative("KeyValuePair")
    public String getKey()
    {
      return this.key;
    }

    @CalledByNative("KeyValuePair")
    public String getValue()
    {
      return this.value;
    }

    public int hashCode()
    {
      return this.key.hashCode() + this.value.hashCode();
    }

    public String toString()
    {
      return this.key + ": " + this.value;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.MediaConstraints
 * JD-Core Version:    0.6.2
 */
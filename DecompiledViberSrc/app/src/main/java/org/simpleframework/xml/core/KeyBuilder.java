package org.simpleframework.xml.core;

import java.util.Arrays;

class KeyBuilder
{
  private final Label label;

  public KeyBuilder(Label paramLabel)
  {
    this.label = paramLabel;
  }

  private Object getKey(KeyType paramKeyType)
    throws Exception
  {
    String str = getKey(this.label.getPaths());
    if (paramKeyType == null)
      return str;
    return new Key(paramKeyType, str);
  }

  private String getKey(String[] paramArrayOfString)
    throws Exception
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayOfString.length > 0)
    {
      Arrays.sort(paramArrayOfString);
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        localStringBuilder.append(paramArrayOfString[j]);
        localStringBuilder.append('>');
      }
    }
    return localStringBuilder.toString();
  }

  public Object getKey()
    throws Exception
  {
    if (this.label.isAttribute())
      return getKey(KeyType.ATTRIBUTE);
    return getKey(KeyType.ELEMENT);
  }

  private static class Key
  {
    private final KeyBuilder.KeyType type;
    private final String value;

    public Key(KeyBuilder.KeyType paramKeyType, String paramString)
      throws Exception
    {
      this.value = paramString;
      this.type = paramKeyType;
    }

    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof Key))
        return equals((Key)paramObject);
      return false;
    }

    public boolean equals(Key paramKey)
    {
      if (this.type == paramKey.type)
        return paramKey.value.equals(this.value);
      return false;
    }

    public int hashCode()
    {
      return this.value.hashCode();
    }

    public String toString()
    {
      return this.value;
    }
  }

  private static enum KeyType
  {
    static
    {
      ATTRIBUTE = new KeyType("ATTRIBUTE", 1);
      ELEMENT = new KeyType("ELEMENT", 2);
      KeyType[] arrayOfKeyType = new KeyType[3];
      arrayOfKeyType[0] = TEXT;
      arrayOfKeyType[1] = ATTRIBUTE;
      arrayOfKeyType[2] = ELEMENT;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.KeyBuilder
 * JD-Core Version:    0.6.2
 */
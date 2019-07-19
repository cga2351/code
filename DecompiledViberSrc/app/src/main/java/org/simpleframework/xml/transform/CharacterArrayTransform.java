package org.simpleframework.xml.transform;

import java.lang.reflect.Array;

class CharacterArrayTransform
  implements Transform
{
  private final Class entry;

  public CharacterArrayTransform(Class paramClass)
  {
    this.entry = paramClass;
  }

  private Object read(char[] paramArrayOfChar, int paramInt)
    throws Exception
  {
    Object localObject = Array.newInstance(this.entry, paramInt);
    for (int i = 0; i < paramInt; i++)
      Array.set(localObject, i, Character.valueOf(paramArrayOfChar[i]));
    return localObject;
  }

  private String write(Object paramObject, int paramInt)
    throws Exception
  {
    StringBuilder localStringBuilder = new StringBuilder(paramInt);
    for (int i = 0; i < paramInt; i++)
    {
      Object localObject = Array.get(paramObject, i);
      if (localObject != null)
        localStringBuilder.append(localObject);
    }
    return localStringBuilder.toString();
  }

  public Object read(String paramString)
    throws Exception
  {
    char[] arrayOfChar = paramString.toCharArray();
    int i = arrayOfChar.length;
    if (this.entry == Character.TYPE)
      return arrayOfChar;
    return read(arrayOfChar, i);
  }

  public String write(Object paramObject)
    throws Exception
  {
    int i = Array.getLength(paramObject);
    if (this.entry == Character.TYPE)
      return new String((char[])paramObject);
    return write(paramObject, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.CharacterArrayTransform
 * JD-Core Version:    0.6.2
 */
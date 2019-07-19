package org.simpleframework.xml.transform;

import java.lang.reflect.Array;

class ArrayTransform
  implements Transform
{
  private final Transform delegate;
  private final Class entry;
  private final StringArrayTransform split = new StringArrayTransform();

  public ArrayTransform(Transform paramTransform, Class paramClass)
  {
    this.delegate = paramTransform;
    this.entry = paramClass;
  }

  private Object read(String[] paramArrayOfString, int paramInt)
    throws Exception
  {
    Object localObject1 = Array.newInstance(this.entry, paramInt);
    for (int i = 0; i < paramInt; i++)
    {
      Object localObject2 = this.delegate.read(paramArrayOfString[i]);
      if (localObject2 != null)
        Array.set(localObject1, i, localObject2);
    }
    return localObject1;
  }

  private String write(Object paramObject, int paramInt)
    throws Exception
  {
    String[] arrayOfString = new String[paramInt];
    for (int i = 0; i < paramInt; i++)
    {
      Object localObject = Array.get(paramObject, i);
      if (localObject != null)
        arrayOfString[i] = this.delegate.write(localObject);
    }
    return this.split.write(arrayOfString);
  }

  public Object read(String paramString)
    throws Exception
  {
    String[] arrayOfString = this.split.read(paramString);
    return read(arrayOfString, arrayOfString.length);
  }

  public String write(Object paramObject)
    throws Exception
  {
    return write(paramObject, Array.getLength(paramObject));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.ArrayTransform
 * JD-Core Version:    0.6.2
 */
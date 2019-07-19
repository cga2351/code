package org.simpleframework.xml.transform;

class ByteTransform
  implements Transform<Byte>
{
  public Byte read(String paramString)
  {
    return Byte.valueOf(paramString);
  }

  public String write(Byte paramByte)
  {
    return paramByte.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.ByteTransform
 * JD-Core Version:    0.6.2
 */
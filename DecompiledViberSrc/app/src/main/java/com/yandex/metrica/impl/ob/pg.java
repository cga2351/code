package com.yandex.metrica.impl.ob;

public class pg extends pf<byte[]>
{
  public pg(int paramInt, String paramString, of paramof)
  {
    super(paramInt, paramString, paramof);
  }

  public byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length > a())
    {
      byte[] arrayOfByte = new byte[a()];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, a());
      if (this.a.c())
      {
        of localof = this.a;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = b();
        arrayOfObject[1] = paramArrayOfByte;
        arrayOfObject[2] = Integer.valueOf(a());
        localof.b("\"%s\" %s exceeded limit of %d bytes", arrayOfObject);
      }
      paramArrayOfByte = arrayOfByte;
    }
    return paramArrayOfByte;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.pg
 * JD-Core Version:    0.6.2
 */
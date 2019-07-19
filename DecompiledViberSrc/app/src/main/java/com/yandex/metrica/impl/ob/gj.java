package com.yandex.metrica.impl.ob;

import java.io.IOException;

public class gj<T>
  implements gk<T>
{
  private final gk<T> a;
  private final ot b;

  public gj(gk<T> paramgk, ot paramot)
  {
    this.a = paramgk;
    this.b = paramot;
  }

  public byte[] a(T paramT)
  {
    try
    {
      byte[] arrayOfByte = this.b.a(this.a.a(paramT));
      return arrayOfByte;
    }
    catch (Exception localException)
    {
    }
    return new byte[0];
  }

  public T b(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      byte[] arrayOfByte = this.b.b(paramArrayOfByte);
      return this.a.b(arrayOfByte);
    }
    catch (Exception localException)
    {
      throw new IOException(localException);
    }
  }

  public T c()
  {
    return this.a.c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.gj
 * JD-Core Version:    0.6.2
 */
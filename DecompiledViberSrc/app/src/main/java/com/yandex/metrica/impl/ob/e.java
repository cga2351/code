package com.yandex.metrica.impl.ob;

import java.io.IOException;

public abstract class e
{
  protected volatile int a = -1;

  public static final <T extends e> T a(T paramT, byte[] paramArrayOfByte)
    throws d
  {
    return a(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static final <T extends e> T a(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws d
  {
    try
    {
      a locala = a.a(paramArrayOfByte, paramInt1, paramInt2);
      paramT.a(locala);
      locala.a(0);
      return paramT;
    }
    catch (d locald)
    {
      throw locald;
    }
    catch (IOException localIOException)
    {
    }
    throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
  }

  public static final byte[] a(e parame)
  {
    byte[] arrayOfByte = new byte[parame.b()];
    int i = arrayOfByte.length;
    try
    {
      b localb = b.a(arrayOfByte, 0, i);
      parame.a(localb);
      localb.b();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
    }
  }

  public int a()
  {
    if (this.a < 0)
      b();
    return this.a;
  }

  public abstract e a(a parama)
    throws IOException;

  public void a(b paramb)
    throws IOException
  {
  }

  public int b()
  {
    int i = c();
    this.a = i;
    return i;
  }

  protected int c()
  {
    return 0;
  }

  public String toString()
  {
    return f.a(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.e
 * JD-Core Version:    0.6.2
 */
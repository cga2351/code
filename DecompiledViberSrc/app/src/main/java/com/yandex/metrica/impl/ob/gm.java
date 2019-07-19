package com.yandex.metrica.impl.ob;

import java.util.Arrays;

public class gm
{
  private final a a;
  private final nx b;

  public gm()
  {
    this(new a(), new nx());
  }

  public gm(a parama, nx paramnx)
  {
    this.a = parama;
    this.b = paramnx;
  }

  public byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      byte[] arrayOfByte1 = Arrays.copyOfRange(paramArrayOfByte, 0, 16);
      byte[] arrayOfByte2 = this.a.a(paramString.getBytes(), arrayOfByte1).a(paramArrayOfByte, 16, -16 + paramArrayOfByte.length);
      byte[] arrayOfByte3 = this.b.b(arrayOfByte2);
      return arrayOfByte3;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static class a
  {
    ot a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      return new ot("AES/CBC/PKCS5Padding", paramArrayOfByte1, paramArrayOfByte2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.gm
 * JD-Core Version:    0.6.2
 */
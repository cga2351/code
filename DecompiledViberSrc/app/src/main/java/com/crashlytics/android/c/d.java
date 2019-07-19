package com.crashlytics.android.c;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

final class d
{
  public static final d a = new d(new byte[0]);
  private final byte[] b;
  private volatile int c = 0;

  private d(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
  }

  public static d a(String paramString)
  {
    try
    {
      d locald = new d(paramString.getBytes("UTF-8"));
      return locald;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported.", localUnsupportedEncodingException);
    }
  }

  public static d a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new d(arrayOfByte);
  }

  public int a()
  {
    return this.b.length;
  }

  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.b, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }

  public InputStream b()
  {
    return new ByteArrayInputStream(this.b);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    while (true)
    {
      return true;
      if (!(paramObject instanceof d))
        return false;
      d locald = (d)paramObject;
      int i = this.b.length;
      if (i != locald.b.length)
        return false;
      byte[] arrayOfByte1 = this.b;
      byte[] arrayOfByte2 = locald.b;
      for (int j = 0; j < i; j++)
        if (arrayOfByte1[j] != arrayOfByte2[j])
          return false;
    }
  }

  public int hashCode()
  {
    int i = this.c;
    if (i == 0)
    {
      byte[] arrayOfByte = this.b;
      int j = this.b.length;
      int k = 0;
      int m;
      for (i = j; k < j; i = m)
      {
        m = i * 31 + arrayOfByte[k];
        k++;
      }
      if (i == 0)
        i = 1;
      this.c = i;
    }
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.d
 * JD-Core Version:    0.6.2
 */
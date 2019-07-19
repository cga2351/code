package com.yandex.metrica.impl.ob;

import android.content.Context;

public class os
{
  private final String a;

  public os(Context paramContext)
  {
    this(paramContext.getPackageName());
  }

  os(String paramString)
  {
    this.a = paramString;
  }

  public byte[] a()
  {
    try
    {
      byte[] arrayOfByte = oj.a(this.a);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
    }
    return new byte[16];
  }

  public byte[] b()
  {
    try
    {
      byte[] arrayOfByte = oj.a(new StringBuilder(this.a).reverse().toString());
      return arrayOfByte;
    }
    catch (Exception localException)
    {
    }
    return new byte[16];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.os
 * JD-Core Version:    0.6.2
 */
package com.yandex.metrica.impl.ob;

import android.os.Bundle;

public enum mq
{
  private int d;

  static
  {
    mq[] arrayOfmq = new mq[3];
    arrayOfmq[0] = a;
    arrayOfmq[1] = b;
    arrayOfmq[2] = c;
  }

  private mq(int paramInt)
  {
    this.d = paramInt;
  }

  public static mq b(Bundle paramBundle)
  {
    int i = paramBundle.getInt("startup_error_key_code");
    mq localmq = a;
    switch (i)
    {
    default:
      return localmq;
    case 1:
      return b;
    case 2:
    }
    return c;
  }

  public int a()
  {
    return this.d;
  }

  public Bundle a(Bundle paramBundle)
  {
    paramBundle.putInt("startup_error_key_code", a());
    return paramBundle;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.mq
 * JD-Core Version:    0.6.2
 */
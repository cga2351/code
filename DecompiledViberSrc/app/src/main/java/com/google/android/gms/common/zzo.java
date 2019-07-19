package com.google.android.gms.common;

import java.util.concurrent.Callable;

final class zzo extends zzm
{
  private final Callable<String> zzae;

  private zzo(Callable<String> paramCallable)
  {
    super(false, null, null);
    this.zzae = paramCallable;
  }

  final String getErrorMessage()
  {
    try
    {
      String str = (String)this.zzae.call();
      return str;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.zzo
 * JD-Core Version:    0.6.2
 */
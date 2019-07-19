package com.google.android.gms.internal.ads;

import java.util.Random;

@zzare
public final class zzys extends zzzx
{
  private final Object lock = new Object();
  private final Random zzcim = new Random();
  private long zzcio;

  public zzys()
  {
    zzpi();
  }

  public final long getValue()
  {
    return this.zzcio;
  }

  public final void zzpi()
  {
    Object localObject1 = this.lock;
    int i = 3;
    long l = 0L;
    while (true)
    {
      i--;
      if (i > 0);
      try
      {
        l = 2147483648L + this.zzcim.nextInt();
        if ((l == this.zzcio) || (l == 0L))
          continue;
        this.zzcio = l;
        return;
      }
      finally
      {
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzys
 * JD-Core Version:    0.6.2
 */
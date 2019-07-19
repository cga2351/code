package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

final class zzkr
  implements ThreadFactory
{
  zzkr(String paramString)
  {
  }

  public final Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, this.zzaqz);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzkr
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

class zzgm<T> extends zza
{
  private BaseImplementation.ResultHolder<T> zzet;

  public zzgm(BaseImplementation.ResultHolder<T> paramResultHolder)
  {
    this.zzet = paramResultHolder;
  }

  public final void zza(T paramT)
  {
    BaseImplementation.ResultHolder localResultHolder = this.zzet;
    if (localResultHolder != null)
    {
      localResultHolder.setResult(paramT);
      this.zzet = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgm
 * JD-Core Version:    0.6.2
 */
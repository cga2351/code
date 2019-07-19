package com.google.android.gms.internal.ads;

import android.provider.Settings.SettingNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzel extends zzfk
{
  public zzel(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 49);
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    this.zzzm.zzf(zzbz.zzkr);
    try
    {
      Method localMethod = this.zzzw;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.zzvd.getContext();
      boolean bool = ((Boolean)localMethod.invoke(null, arrayOfObject)).booleanValue();
      zzbp.zza.zza localzza = this.zzzm;
      if (bool);
      for (zzbz localzzbz = zzbz.zzkq; ; localzzbz = zzbz.zzkp)
      {
        localzza.zzf(localzzbz);
        return;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      if (!(localInvocationTargetException.getTargetException() instanceof Settings.SettingNotFoundException))
        throw localInvocationTargetException;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzel
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzfh extends zzfk
{
  private final View zzze;

  public zzfh(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2, View paramView)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 57);
    this.zzze = paramView;
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    if (this.zzze != null)
    {
      zzaci localzzaci = zzact.zzcrs;
      Boolean localBoolean = (Boolean)zzyr.zzpe().zzd(localzzaci);
      DisplayMetrics localDisplayMetrics = this.zzvd.getContext().getResources().getDisplayMetrics();
      Method localMethod = this.zzzw;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = this.zzze;
      arrayOfObject[1] = localDisplayMetrics;
      arrayOfObject[2] = localBoolean;
      zzeg localzzeg = new zzeg((String)localMethod.invoke(null, arrayOfObject));
      zzbp.zza.zzf.zza localzza = zzbp.zza.zzf.zzat();
      localzza.zzdc(localzzeg.zzyn.longValue()).zzdd(localzzeg.zzyo.longValue()).zzde(localzzeg.zzyp.longValue());
      if (localBoolean.booleanValue())
        localzza.zzdf(localzzeg.zzyq.longValue());
      this.zzzm.zzb((zzbp.zza.zzf)localzza.zzaya());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzfh
 * JD-Core Version:    0.6.2
 */
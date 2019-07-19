package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzek extends zzfk
{
  private final Activity zzzd;
  private final View zzze;

  public zzek(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2, View paramView, Activity paramActivity)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 62);
    this.zzze = paramView;
    this.zzzd = paramActivity;
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    if (this.zzze == null)
      return;
    zzaci localzzaci = zzact.zzcrg;
    boolean bool = ((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue();
    Method localMethod = this.zzzw;
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = this.zzze;
    arrayOfObject1[1] = this.zzzd;
    arrayOfObject1[2] = Boolean.valueOf(bool);
    Object[] arrayOfObject2 = (Object[])localMethod.invoke(null, arrayOfObject1);
    synchronized (this.zzzm)
    {
      this.zzzm.zzbp(((Long)arrayOfObject2[0]).longValue());
      this.zzzm.zzbq(((Long)arrayOfObject2[1]).longValue());
      if (bool)
        this.zzzm.zzae((String)arrayOfObject2[2]);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzek
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcnv
  implements zzcjz<zzcda, zzamt, zzcla>
{
  private final Executor zzffu;
  private final zzcde zzgbq;
  private final Context zzlj;

  public zzcnv(Context paramContext, Executor paramExecutor, zzcde paramzzcde)
  {
    this.zzlj = paramContext;
    this.zzffu = paramExecutor;
    this.zzgbq = paramzzcde;
  }

  private static void zzc(zzcxt paramzzcxt, zzcxl paramzzcxl, zzcjx<zzamt, zzcla> paramzzcjx)
  {
    String str1;
    try
    {
      ((zzamt)paramzzcjx.zzdge).zza(paramzzcxt.zzgkx.zzfjp.zzghg, paramzzcxl.zzgkh.toString());
      return;
    }
    catch (Exception localException)
    {
      str1 = String.valueOf(paramzzcjx.zzfir);
      if (str1.length() == 0);
    }
    for (String str2 = "Fail to load ad from adapter ".concat(str1); ; str2 = new String("Fail to load ad from adapter "))
    {
      zzaxa.zzd(str2, localException);
      return;
    }
  }

  public final void zza(zzcxt paramzzcxt, zzcxl paramzzcxl, zzcjx<zzamt, zzcla> paramzzcjx)
    throws RemoteException
  {
    if (!((zzamt)paramzzcjx.zzdge).isInitialized())
    {
      zzcnx localzzcnx = new zzcnx(this, paramzzcxt, paramzzcxl, paramzzcjx);
      ((zzcla)paramzzcjx.zzfzn).zza(localzzcnx);
      ((zzamt)paramzzcjx.zzdge).zza(ObjectWrapper.wrap(this.zzlj), paramzzcxt.zzgkx.zzfjp.zzghg, null, (zzatl)paramzzcjx.zzfzn, paramzzcxl.zzgkh.toString());
      return;
    }
    zzc(paramzzcxt, paramzzcxl, paramzzcjx);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcnv
 * JD-Core Version:    0.6.2
 */
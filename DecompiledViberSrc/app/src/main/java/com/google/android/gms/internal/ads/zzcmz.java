package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcmz
  implements zzcjz<zzcda, zzamt, zzckz>
{
  private final Executor zzffu;
  private final zzcde zzgbq;
  private final Context zzlj;

  public zzcmz(Context paramContext, Executor paramExecutor, zzcde paramzzcde)
  {
    this.zzlj = paramContext;
    this.zzffu = paramExecutor;
    this.zzgbq = paramzzcde;
  }

  public final void zza(zzcxt paramzzcxt, zzcxl paramzzcxl, zzcjx<zzamt, zzckz> paramzzcjx)
    throws RemoteException
  {
    String str1;
    try
    {
      ((zzamt)paramzzcjx.zzdge).zzb(ObjectWrapper.wrap(this.zzlj), paramzzcxt.zzgkx.zzfjp.zzghg, paramzzcxl.zzgkh.toString(), (zzamw)paramzzcjx.zzfzn);
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
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcmz
 * JD-Core Version:    0.6.2
 */
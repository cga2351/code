package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import org.json.JSONObject;

public final class zzcnc
  implements zzcjz<zzcda, zzaow, zzckz>
{
  private final zzcde zzgbq;
  private final Context zzlj;

  public zzcnc(Context paramContext, zzcde paramzzcde)
  {
    this.zzlj = paramContext;
    this.zzgbq = paramzzcde;
  }

  public final void zza(zzcxt paramzzcxt, zzcxl paramzzcxl, zzcjx<zzaow, zzckz> paramzzcjx)
    throws RemoteException
  {
    ((zzaow)paramzzcjx.zzdge).zza(paramzzcxl.zzemw, paramzzcxl.zzgkh.toString(), paramzzcxt.zzgkx.zzfjp.zzghg, ObjectWrapper.wrap(this.zzlj), new zzcnf(this, paramzzcjx, null), (zzamw)paramzzcjx.zzfzn);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcnc
 * JD-Core Version:    0.6.2
 */
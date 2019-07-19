package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import org.json.JSONObject;

public final class zzcmf
  implements zzcjz<zzbym, zzaow, zzckz>
{
  private final zzbxn zzgav;
  private zzanh zzgba;
  private final Context zzlj;

  public zzcmf(Context paramContext, zzbxn paramzzbxn)
  {
    this.zzlj = paramContext;
    this.zzgav = paramzzbxn;
  }

  public final void zza(zzcxt paramzzcxt, zzcxl paramzzcxl, zzcjx<zzaow, zzckz> paramzzcjx)
    throws RemoteException
  {
    ((zzaow)paramzzcjx.zzdge).zza(paramzzcxl.zzemw, paramzzcxl.zzgkh.toString(), paramzzcxt.zzgkx.zzfjp.zzghg, ObjectWrapper.wrap(this.zzlj), new zzcmh(this, paramzzcjx, null), (zzamw)paramzzcjx.zzfzn);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcmf
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import org.json.JSONObject;

public final class zzclm
  implements zzcjz<zzbvw, zzamt, zzckz>
{
  private final zzbaj zzbrd;
  private final zzbwr zzfzy;
  private final Context zzlj;

  public zzclm(Context paramContext, zzbaj paramzzbaj, zzbwr paramzzbwr)
  {
    this.zzlj = paramContext;
    this.zzbrd = paramzzbaj;
    this.zzfzy = paramzzbwr;
  }

  public final void zza(zzcxt paramzzcxt, zzcxl paramzzcxl, zzcjx<zzamt, zzckz> paramzzcjx)
    throws RemoteException
  {
    if (this.zzbrd.zzdzf < 4100000)
    {
      ((zzamt)paramzzcjx.zzdge).zza(ObjectWrapper.wrap(this.zzlj), paramzzcxt.zzgkx.zzfjp.zzghg, paramzzcxl.zzgkh.toString(), (zzamw)paramzzcjx.zzfzn);
      return;
    }
    ((zzamt)paramzzcjx.zzdge).zza(ObjectWrapper.wrap(this.zzlj), paramzzcxt.zzgkx.zzfjp.zzghg, paramzzcxl.zzgkh.toString(), zzazd.zza(paramzzcxl.zzgke), (zzamw)paramzzcjx.zzfzn);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzclm
 * JD-Core Version:    0.6.2
 */
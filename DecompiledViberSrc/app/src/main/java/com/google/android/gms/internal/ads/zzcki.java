package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import org.json.JSONObject;

public final class zzcki
  implements zzcjz<zzbne, zzamt, zzckz>
{
  private final zzbaj zzbrd;
  private final zzbob zzfzo;
  private final Context zzlj;

  public zzcki(Context paramContext, zzbaj paramzzbaj, zzbob paramzzbob)
  {
    this.zzlj = paramContext;
    this.zzbrd = paramzzbaj;
    this.zzfzo = paramzzbob;
  }

  public final void zza(zzcxt paramzzcxt, zzcxl paramzzcxl, zzcjx<zzamt, zzckz> paramzzcjx)
    throws RemoteException
  {
    zzyb localzzyb = zzcxx.zza(this.zzlj, paramzzcxl.zzgkg);
    if (this.zzbrd.zzdzf < 4100000)
    {
      ((zzamt)paramzzcjx.zzdge).zza(ObjectWrapper.wrap(this.zzlj), localzzyb, paramzzcxt.zzgkx.zzfjp.zzghg, paramzzcxl.zzgkh.toString(), (zzamw)paramzzcjx.zzfzn);
      return;
    }
    ((zzamt)paramzzcjx.zzdge).zza(ObjectWrapper.wrap(this.zzlj), localzzyb, paramzzcxt.zzgkx.zzfjp.zzghg, paramzzcxl.zzgkh.toString(), zzazd.zza(paramzzcxl.zzgke), (zzamw)paramzzcjx.zzfzn);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcki
 * JD-Core Version:    0.6.2
 */
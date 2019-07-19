package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import org.json.JSONObject;

public final class zzckl
  implements zzcjz<zzbne, zzaow, zzckz>
{
  private View view;
  private final zzbob zzfzo;
  private final Context zzlj;

  public zzckl(Context paramContext, zzbob paramzzbob)
  {
    this.zzlj = paramContext;
    this.zzfzo = paramzzbob;
  }

  public final void zza(zzcxt paramzzcxt, zzcxl paramzzcxl, zzcjx<zzaow, zzckz> paramzzcjx)
    throws RemoteException
  {
    ((zzaow)paramzzcjx.zzdge).zza(paramzzcxl.zzemw, paramzzcxl.zzgkh.toString(), paramzzcxt.zzgkx.zzfjp.zzghg, ObjectWrapper.wrap(this.zzlj), new zzcko(this, paramzzcjx, null), (zzamw)paramzzcjx.zzfzn, paramzzcxt.zzgkx.zzfjp.zzdln);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzckl
 * JD-Core Version:    0.6.2
 */
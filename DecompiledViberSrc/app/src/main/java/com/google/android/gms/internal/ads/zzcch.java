package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

public final class zzcch
  implements zzahn<Object>
{
  private final zzdtd<zzccc> zzfnv;
  private final zzcci zzfpz;
  private final zzafn zzfsg;

  public zzcch(zzbzb paramzzbzb, zzbys paramzzbys, zzcci paramzzcci, zzdtd<zzccc> paramzzdtd)
  {
    this.zzfsg = paramzzbzb.zzfo(paramzzbys.getCustomTemplateId());
    this.zzfpz = paramzzcci;
    this.zzfnv = paramzzdtd;
  }

  public final void zza(Object paramObject, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("asset");
    try
    {
      this.zzfsg.zza((zzafd)this.zzfnv.get(), str);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzd(40 + String.valueOf(str).length() + "Failed to call onCustomClick for asset " + str + ".", localRemoteException);
    }
  }

  public final void zzaji()
  {
    if (this.zzfsg == null)
      return;
    this.zzfpz.zza("/nativeAdCustomClick", this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcch
 * JD-Core Version:    0.6.2
 */
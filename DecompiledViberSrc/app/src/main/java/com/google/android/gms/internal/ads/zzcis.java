package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcis
  implements zzdth<zzcif>
{
  private final zzdtt<Context> zzeol;
  private final zzdtt<Executor> zzfhh;
  private final zzdtt<zzasn> zzfxw;
  private final zzdtt<zzblq> zzfxx;
  private final zzdtt<zzasm> zzfxy;

  private zzcis(zzdtt<Context> paramzzdtt, zzdtt<Executor> paramzzdtt1, zzdtt<zzasn> paramzzdtt2, zzdtt<zzblq> paramzzdtt3, zzdtt<zzasm> paramzzdtt4)
  {
    this.zzeol = paramzzdtt;
    this.zzfhh = paramzzdtt1;
    this.zzfxw = paramzzdtt2;
    this.zzfxx = paramzzdtt3;
    this.zzfxy = paramzzdtt4;
  }

  public static zzcis zzg(zzdtt<Context> paramzzdtt, zzdtt<Executor> paramzzdtt1, zzdtt<zzasn> paramzzdtt2, zzdtt<zzblq> paramzzdtt3, zzdtt<zzasm> paramzzdtt4)
  {
    return new zzcis(paramzzdtt, paramzzdtt1, paramzzdtt2, paramzzdtt3, paramzzdtt4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcis
 * JD-Core Version:    0.6.2
 */
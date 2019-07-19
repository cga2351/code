package com.google.android.gms.internal.ads;

public final class zzcwi
  implements zzcuz<zzcwh>
{
  private String packageName;
  private zzbbm zzfqw;
  private zzawf zzgjh;

  public zzcwi(zzawf paramzzawf, zzbbm paramzzbbm, String paramString)
  {
    this.zzgjh = paramzzawf;
    this.zzfqw = paramzzbbm;
    this.packageName = paramString;
  }

  public final zzbbi<zzcwh> zzalm()
  {
    new zzbbs();
    zzbbh localzzbbh = zzbas.zzm(null);
    zzaci localzzaci = zzact.zzcvx;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue());
    for (Object localObject = this.zzgjh.zzdq(this.packageName); ; localObject = localzzbbh)
    {
      zzbbi localzzbbi = this.zzgjh.zzdr(this.packageName);
      return zzbas.zza(new zzbbi[] { localObject, localzzbbi }).zza(new zzcwj((zzbbi)localObject, localzzbbi), zzaxh.zzdvr);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcwi
 * JD-Core Version:    0.6.2
 */
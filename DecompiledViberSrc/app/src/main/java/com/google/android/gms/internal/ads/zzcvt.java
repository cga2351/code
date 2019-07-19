package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public final class zzcvt
  implements zzcuz<zzcvs>
{

  @Nullable
  private final PackageInfo zzdlo;
  private final Executor zzfiv;
  private final zzawj zzgir;
  private final String zzgiv;

  public zzcvt(zzawj paramzzawj, Executor paramExecutor, String paramString, @Nullable PackageInfo paramPackageInfo)
  {
    this.zzgir = paramzzawj;
    this.zzfiv = paramExecutor;
    this.zzgiv = paramString;
    this.zzdlo = paramPackageInfo;
  }

  public final zzbbi<zzcvs> zzalm()
  {
    return zzbas.zza(zzbas.zza(this.zzgir.zza(this.zzgiv, this.zzdlo), zzcvu.zzdrp, this.zzfiv), Throwable.class, new zzcvv(this), this.zzfiv);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcvt
 * JD-Core Version:    0.6.2
 */
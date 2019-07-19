package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.Nullable;

public final class zzcvx
  implements zzcuz<zzcvw>
{
  private final String packageName;
  private final zzbbm zzfqw;
  private final zzasd zzgiy;
  private final Context zzlj;

  public zzcvx(@Nullable zzasd paramzzasd, Context paramContext, String paramString, zzbbm paramzzbbm)
  {
    this.zzgiy = paramzzasd;
    this.zzlj = paramContext;
    this.packageName = paramString;
    this.zzfqw = paramzzbbm;
  }

  public final zzbbi<zzcvw> zzalm()
  {
    return this.zzfqw.zza(new zzcvy(this));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcvx
 * JD-Core Version:    0.6.2
 */
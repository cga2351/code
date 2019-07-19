package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzals
{

  @VisibleForTesting
  private static final zzayq<zzajx> zzddn = new zzalt();

  @VisibleForTesting
  private static final zzayq<zzajx> zzddo = new zzalu();
  private final zzaki zzddp;

  public zzals(Context paramContext, zzbaj paramzzbaj, String paramString)
  {
    this.zzddp = new zzaki(paramContext, paramzzbaj, paramString, zzddn, zzddo);
  }

  public final <I, O> zzalk<I, O> zza(String paramString, zzaln<I> paramzzaln, zzalm<O> paramzzalm)
  {
    return new zzalv(this.zzddp, paramString, paramzzaln, paramzzalm);
  }

  public final zzalz zzsc()
  {
    return new zzalz(this.zzddp);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzals
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;
import javax.annotation.Nullable;

public final class zzcww
{
  private final zzary zzfxh;

  public zzcww(zzary paramzzary)
  {
    this.zzfxh = paramzzary;
  }

  public final String zzamc()
  {
    return this.zzfxh.packageName;
  }

  public final String zzamd()
  {
    return this.zzfxh.zzdov.getString("ms");
  }

  @Nullable
  public final PackageInfo zzame()
  {
    return this.zzfxh.zzdlo;
  }

  public final boolean zzamf()
  {
    return this.zzfxh.zzdow;
  }

  public final List<String> zzamg()
  {
    return this.zzfxh.zzdma;
  }

  public final ApplicationInfo zzamh()
  {
    return this.zzfxh.applicationInfo;
  }

  public final String zzami()
  {
    return this.zzfxh.zzdox;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcww
 * JD-Core Version:    0.6.2
 */
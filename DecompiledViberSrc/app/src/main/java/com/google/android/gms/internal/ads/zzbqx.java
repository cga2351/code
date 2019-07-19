package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import javax.annotation.Nullable;

public class zzbqx
{
  private final zzcxu zzfjp;

  @Nullable
  private final String zzfju;
  private Bundle zzfjv;
  private final Context zzlj;

  private zzbqx(zza paramzza)
  {
    this.zzlj = zza.zza(paramzza);
    this.zzfjp = zza.zzb(paramzza);
    this.zzfjv = zza.zzc(paramzza);
    this.zzfju = zza.zzd(paramzza);
  }

  final zza zzagd()
  {
    return new zza().zzbt(this.zzlj).zza(this.zzfjp).zzfg(this.zzfju).zze(this.zzfjv);
  }

  final zzcxu zzage()
  {
    return this.zzfjp;
  }

  @Nullable
  final Bundle zzagf()
  {
    return this.zzfjv;
  }

  @Nullable
  final String zzagg()
  {
    return this.zzfju;
  }

  final Context zzbs(Context paramContext)
  {
    if (this.zzfju != null)
      return paramContext;
    return this.zzlj;
  }

  public static final class zza
  {
    private zzcxu zzfjp;

    @Nullable
    private String zzfju;
    private Bundle zzfjv;
    private Context zzlj;

    public final zza zza(zzcxu paramzzcxu)
    {
      this.zzfjp = paramzzcxu;
      return this;
    }

    public final zzbqx zzagh()
    {
      return new zzbqx(this, null);
    }

    public final zza zzbt(Context paramContext)
    {
      this.zzlj = paramContext;
      return this;
    }

    public final zza zze(Bundle paramBundle)
    {
      this.zzfjv = paramBundle;
      return this;
    }

    public final zza zzfg(String paramString)
    {
      this.zzfju = paramString;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbqx
 * JD-Core Version:    0.6.2
 */
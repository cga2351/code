package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.lang.ref.WeakReference;

public class zzbjo
{
  private final zzbaj zzbrd;
  private final WeakReference<Context> zzeog;
  private final Context zzlj;

  private zzbjo(zza paramzza)
  {
    this.zzbrd = zza.zza(paramzza);
    this.zzlj = zza.zzb(paramzza);
    this.zzeog = zza.zzc(paramzza);
  }

  final Context zzaco()
  {
    return this.zzlj;
  }

  final Context zzacp()
  {
    if (this.zzeog.get() != null)
      return (Context)this.zzeog.get();
    return this.zzlj;
  }

  final zzbaj zzacq()
  {
    return this.zzbrd;
  }

  final String zzacr()
  {
    return zzk.zzlg().zzq(this.zzlj, this.zzbrd.zzbsy);
  }

  public static final class zza
  {
    private zzbaj zzbrd;
    private WeakReference<Context> zzeog;
    private Context zzlj;

    public final zza zza(zzbaj paramzzbaj)
    {
      this.zzbrd = paramzzbaj;
      return this;
    }

    public final zza zzbo(Context paramContext)
    {
      this.zzeog = new WeakReference(paramContext);
      if (paramContext.getApplicationContext() != null)
        paramContext = paramContext.getApplicationContext();
      this.zzlj = paramContext;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbjo
 * JD-Core Version:    0.6.2
 */
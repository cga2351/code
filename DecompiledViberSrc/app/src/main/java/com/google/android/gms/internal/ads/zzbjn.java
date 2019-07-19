package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public abstract class zzbjn
  implements zzblq
{

  @GuardedBy("AppComponent.class")
  private static zzbjn zzeof;

  public static zzbjn zza(Context paramContext, zzamq paramzzamq, int paramInt)
  {
    zzbjn localzzbjn = zzd(paramContext, paramInt);
    localzzbjn.zzach().zzb(paramzzamq);
    return localzzbjn;
  }

  @Deprecated
  private static zzbjn zza(zzbaj paramzzbaj, Context paramContext, zzbkx.zza paramzza)
  {
    try
    {
      if (zzeof == null)
      {
        zzeof = new zzbko(null).zzc(new zzbjo(new zzbjo.zza().zza(paramzzbaj).zzbo(paramContext), null)).zza(new zzbkx(paramzza)).zzaec();
        zzact.initialize(paramContext);
        zzk.zzlk().zzd(paramContext, paramzzbaj);
        zzk.zzlm().initialize(paramContext);
        zzk.zzlg().zzak(paramContext);
        zzk.zzlg().zzal(paramContext);
        zzawy.zzaj(paramContext);
        zzk.zzlj().initialize(paramContext);
        zzk.zzmb().initialize(paramContext);
        zzaci localzzaci = zzact.zzcwt;
        if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
          new zzcjq(paramContext, paramzzbaj, new zzwh(new zzwm(paramContext)), new zzcjb(new zzciz(paramContext), zzeof.zzacf())).zzakp();
      }
      zzbjn localzzbjn = zzeof;
      return localzzbjn;
    }
    finally
    {
    }
  }

  @Deprecated
  public static zzbjn zzd(Context paramContext, int paramInt)
  {
    try
    {
      if (zzeof != null)
      {
        zzbjn localzzbjn = zzeof;
        return localzzbjn;
      }
      return zza(new zzbaj(15000000, paramInt, true, false), paramContext, new zzbkc());
    }
    finally
    {
    }
  }

  public final zzcvr zza(zzary paramzzary)
  {
    return zza(new zzcww(paramzzary));
  }

  protected abstract zzcvr zza(zzcww paramzzcww);

  public abstract Executor zzace();

  public abstract zzbbm zzacf();

  public abstract zzbta zzacg();

  public abstract zzclb zzach();

  public abstract zzbla zzaci();

  public abstract zzboc zzacj();

  public abstract zzbws zzack();

  public abstract zzbxo zzacl();

  public abstract zzcdf zzacm();

  public abstract zzcqo zzacn();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbjn
 * JD-Core Version:    0.6.2
 */
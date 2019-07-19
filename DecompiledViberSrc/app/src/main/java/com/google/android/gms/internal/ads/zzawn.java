package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzawn
{
  private final Object lock = new Object();
  private zzbaj zzbtd;
  private final zzawv zzdsy = new zzawv(zzyr.zzpf(), this.zzdtr);
  private zztx zzdtq;
  private final zzaxd zzdtr = new zzaxd();

  @Nullable
  private zzacx zzdts = null;

  @Nullable
  private Boolean zzdtt = null;
  private final AtomicInteger zzdtu = new AtomicInteger(0);
  private final zzawq zzdtv = new zzawq(null);
  private final Object zzdtw = new Object();
  private zzbbi<ArrayList<String>> zzdtx;
  private Context zzlj;
  private boolean zzxs = false;

  @TargetApi(16)
  private static ArrayList<String> zzah(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    PackageInfo localPackageInfo;
    try
    {
      localPackageInfo = Wrappers.packageManager(paramContext).getPackageInfo(paramContext.getApplicationInfo().packageName, 4096);
      if ((localPackageInfo.requestedPermissions == null) || (localPackageInfo.requestedPermissionsFlags == null))
        return localArrayList;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      return localArrayList;
    }
    for (int i = 0; i < localPackageInfo.requestedPermissions.length; i++)
      if ((0x2 & localPackageInfo.requestedPermissionsFlags[i]) != 0)
        localArrayList.add(localPackageInfo.requestedPermissions[i]);
    return localArrayList;
  }

  @Nullable
  public final Context getApplicationContext()
  {
    return this.zzlj;
  }

  @Nullable
  public final Resources getResources()
  {
    if (this.zzbtd.zzdzg)
      return this.zzlj.getResources();
    try
    {
      zzbaf.zzbl(this.zzlj).getResources();
      return null;
    }
    catch (zzbah localzzbah)
    {
      zzaxa.zzd("Cannot load resource from dynamite apk or local jar", localzzbah);
    }
    return null;
  }

  public final void zza(Boolean paramBoolean)
  {
    synchronized (this.lock)
    {
      this.zzdtt = paramBoolean;
      return;
    }
  }

  public final void zza(Throwable paramThrowable, String paramString)
  {
    zzaqy.zzc(this.zzlj, this.zzbtd).zza(paramThrowable, paramString);
  }

  public final void zzb(Throwable paramThrowable, String paramString)
  {
    zzarc localzzarc = zzaqy.zzc(this.zzlj, this.zzbtd);
    zzaci localzzaci = zzact.zzclj;
    localzzarc.zza(paramThrowable, paramString, ((Float)zzyr.zzpe().zzd(localzzaci)).floatValue());
  }

  @TargetApi(23)
  public final void zzd(Context paramContext, zzbaj paramzzbaj)
  {
    synchronized (this.lock)
    {
      if (!this.zzxs)
      {
        this.zzlj = paramContext.getApplicationContext();
        this.zzbtd = paramzzbaj;
        zzk.zzlj().zza(this.zzdsy);
        this.zzdtr.zza(this.zzlj, null, true);
        zzaqy.zzc(this.zzlj, this.zzbtd);
        this.zzdtq = new zztx(paramContext.getApplicationContext(), this.zzbtd);
        zzk.zzlp();
        zzaci localzzaci = zzact.zzcmy;
        if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
        {
          zzaxa.zzds("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
          localzzacx = null;
          this.zzdts = localzzacx;
          if (this.zzdts != null)
            zzbap.zza(new zzawp(this).zzvi(), "AppState.registerCsiReporter");
          this.zzxs = true;
          zzvd();
        }
      }
      else
      {
        zzk.zzlg().zzq(paramContext, paramzzbaj.zzbsy);
        return;
      }
      zzacx localzzacx = new zzacx();
    }
  }

  @Nullable
  public final zzacx zzuw()
  {
    synchronized (this.lock)
    {
      zzacx localzzacx = this.zzdts;
      return localzzacx;
    }
  }

  public final Boolean zzux()
  {
    synchronized (this.lock)
    {
      Boolean localBoolean = this.zzdtt;
      return localBoolean;
    }
  }

  public final void zzuy()
  {
    this.zzdtv.zzuy();
  }

  public final void zzuz()
  {
    this.zzdtu.incrementAndGet();
  }

  public final void zzva()
  {
    this.zzdtu.decrementAndGet();
  }

  public final int zzvb()
  {
    return this.zzdtu.get();
  }

  public final zzaxc zzvc()
  {
    synchronized (this.lock)
    {
      zzaxd localzzaxd = this.zzdtr;
      return localzzaxd;
    }
  }

  public final zzbbi<ArrayList<String>> zzvd()
  {
    if ((PlatformVersion.isAtLeastJellyBean()) && (this.zzlj != null))
    {
      zzaci localzzaci = zzact.zzcrj;
      if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue());
    }
    else
    {
      return zzbas.zzm(new ArrayList());
    }
    synchronized (this.zzdtw)
    {
      if (this.zzdtx != null)
      {
        zzbbi localzzbbi2 = this.zzdtx;
        return localzzbbi2;
      }
    }
    zzbbi localzzbbi1 = zzaxh.zza(new zzawo(this));
    this.zzdtx = localzzbbi1;
    return localzzbbi1;
  }

  public final zzawv zzve()
  {
    return this.zzdsy;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzawn
 * JD-Core Version:    0.6.2
 */
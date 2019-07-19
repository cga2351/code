package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzare
@ParametersAreNonnullByDefault
public final class zzaur
  implements zzavc
{
  private static List<Future<Void>> zzdrb = Collections.synchronizedList(new ArrayList());
  private static ScheduledExecutorService zzdrc = Executors.newSingleThreadScheduledExecutor();
  private final Object lock = new Object();
  private final zzauz zzdoe;

  @GuardedBy("lock")
  private final zzdsi zzdrd;

  @GuardedBy("lock")
  private final LinkedHashMap<String, zzdso> zzdre;

  @GuardedBy("lock")
  private final List<String> zzdrf = new ArrayList();

  @GuardedBy("lock")
  private final List<String> zzdrg = new ArrayList();
  private final zzave zzdrh;
  private boolean zzdri;
  private final zzavf zzdrj;
  private HashSet<String> zzdrk = new HashSet();
  private boolean zzdrl = false;
  private boolean zzdrm = false;
  private boolean zzdrn = false;
  private final Context zzlj;

  public zzaur(Context paramContext, zzbaj paramzzbaj, zzauz paramzzauz, String paramString, zzave paramzzave)
  {
    Preconditions.checkNotNull(paramzzauz, "SafeBrowsing config is not present.");
    if (paramContext.getApplicationContext() != null)
      paramContext = paramContext.getApplicationContext();
    this.zzlj = paramContext;
    this.zzdre = new LinkedHashMap();
    this.zzdrh = paramzzave;
    this.zzdoe = paramzzauz;
    Iterator localIterator = this.zzdoe.zzdrx.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.zzdrk.add(str.toLowerCase(Locale.ENGLISH));
    }
    this.zzdrk.remove("cookie".toLowerCase(Locale.ENGLISH));
    zzdsi localzzdsi = new zzdsi();
    localzzdsi.zzhrv = Integer.valueOf(8);
    localzzdsi.url = paramString;
    localzzdsi.zzhrx = paramString;
    localzzdsi.zzhrz = new zzdsj();
    localzzdsi.zzhrz.zzdrt = this.zzdoe.zzdrt;
    zzdsp localzzdsp = new zzdsp();
    localzzdsp.zzhte = paramzzbaj.zzbsy;
    localzzdsp.zzhtg = Boolean.valueOf(Wrappers.packageManager(this.zzlj).isCallerInstantApp());
    long l = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzlj);
    if (l > 0L)
      localzzdsp.zzhtf = Long.valueOf(l);
    localzzdsi.zzhsj = localzzdsp;
    this.zzdrd = localzzdsi;
    this.zzdrj = new zzavf(this.zzlj, this.zzdoe.zzdsa, this);
  }

  private final zzdso zzdn(String paramString)
  {
    synchronized (this.lock)
    {
      zzdso localzzdso = (zzdso)this.zzdre.get(paramString);
      return localzzdso;
    }
  }

  private final zzbbi<Void> zzug()
  {
    int i = 1;
    if (((this.zzdri) && (this.zzdoe.zzdrz)) || ((this.zzdrn) && (this.zzdoe.zzdry)) || ((!this.zzdri) && (this.zzdoe.zzdrw)));
    while (i == 0)
    {
      return zzbas.zzm(null);
      i = 0;
    }
    synchronized (this.lock)
    {
      this.zzdrd.zzhsa = new zzdso[this.zzdre.size()];
      this.zzdre.values().toArray(this.zzdrd.zzhsa);
      this.zzdrd.zzhsk = ((String[])this.zzdrf.toArray(new String[0]));
      this.zzdrd.zzhsl = ((String[])this.zzdrg.toArray(new String[0]));
      if (zzavb.isEnabled())
      {
        String str2 = this.zzdrd.url;
        String str3 = this.zzdrd.zzhsb;
        StringBuilder localStringBuilder = new StringBuilder(53 + String.valueOf(str2).length() + String.valueOf(str3).length() + "Sending SB report\n  url: " + str2 + "\n  clickUrl: " + str3 + "\n  resources: \n");
        for (zzdso localzzdso : this.zzdrd.zzhsa)
        {
          localStringBuilder.append("    [");
          localStringBuilder.append(localzzdso.zzhtd.length);
          localStringBuilder.append("] ");
          localStringBuilder.append(localzzdso.url);
        }
        zzavb.zzdp(localStringBuilder.toString());
      }
      byte[] arrayOfByte = zzdrv.zza(this.zzdrd);
      String str1 = this.zzdoe.zzdru;
      zzbbi localzzbbi1 = new zzayv(this.zzlj).zza(1, str1, null, arrayOfByte);
      if (zzavb.isEnabled())
        localzzbbi1.zza(new zzauw(this), zzaxh.zzdvr);
      zzbbi localzzbbi2 = zzbas.zza(localzzbbi1, zzaut.zzdrp, zzbbn.zzeah);
      return localzzbbi2;
    }
  }

  public final void zza(String paramString, Map<String, String> paramMap, int paramInt)
  {
    Object localObject1 = this.lock;
    if (paramInt == 3);
    zzdso localzzdso;
    ArrayList localArrayList;
    while (true)
    {
      try
      {
        this.zzdrn = true;
        if (this.zzdre.containsKey(paramString))
        {
          if (paramInt == 3)
            ((zzdso)this.zzdre.get(paramString)).zzhtc = Integer.valueOf(paramInt);
          return;
        }
        localzzdso = new zzdso();
        localzzdso.zzhtc = Integer.valueOf(paramInt);
        localzzdso.zzhsw = Integer.valueOf(this.zzdre.size());
        localzzdso.url = paramString;
        localzzdso.zzhsx = new zzdsl();
        if ((this.zzdrk.size() <= 0) || (paramMap == null))
          break label347;
        localArrayList = new ArrayList();
        Iterator localIterator = paramMap.entrySet().iterator();
        if (!localIterator.hasNext())
          break;
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        try
        {
          if (localEntry.getKey() == null)
            break label299;
          str1 = (String)localEntry.getKey();
          if (localEntry.getValue() == null)
            break label307;
          str2 = (String)localEntry.getValue();
          String str3 = str1.toLowerCase(Locale.ENGLISH);
          if (!this.zzdrk.contains(str3))
            continue;
          zzdsk localzzdsk = new zzdsk();
          localzzdsk.zzhsn = str1.getBytes("UTF-8");
          localzzdsk.zzhso = str2.getBytes("UTF-8");
          localArrayList.add(localzzdsk);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          zzavb.zzdp("Cannot convert string to bytes, skip header.");
        }
        continue;
      }
      finally
      {
      }
      label299: String str1 = "";
      continue;
      label307: String str2 = "";
    }
    zzdsk[] arrayOfzzdsk = new zzdsk[localArrayList.size()];
    localArrayList.toArray(arrayOfzzdsk);
    localzzdso.zzhsx.zzhsq = arrayOfzzdsk;
    label347: this.zzdre.put(paramString, localzzdso);
  }

  public final String[] zza(String[] paramArrayOfString)
  {
    return (String[])this.zzdrj.zzb(paramArrayOfString).toArray(new String[0]);
  }

  public final void zzdk(String paramString)
  {
    synchronized (this.lock)
    {
      this.zzdrd.zzhsb = paramString;
      return;
    }
  }

  final void zzdl(String paramString)
  {
    synchronized (this.lock)
    {
      this.zzdrf.add(paramString);
      return;
    }
  }

  final void zzdm(String paramString)
  {
    synchronized (this.lock)
    {
      this.zzdrg.add(paramString);
      return;
    }
  }

  public final void zzj(View paramView)
  {
    if (!this.zzdoe.zzdrv);
    while (this.zzdrm)
      return;
    zzk.zzlg();
    Bitmap localBitmap = zzaxj.zzl(paramView);
    if (localBitmap == null)
    {
      zzavb.zzdp("Failed to capture the webview bitmap.");
      return;
    }
    this.zzdrm = true;
    zzaxj.zzd(new zzauu(this, localBitmap));
  }

  public final zzauz zzuc()
  {
    return this.zzdoe;
  }

  public final boolean zzud()
  {
    return (PlatformVersion.isAtLeastKitKat()) && (this.zzdoe.zzdrv) && (!this.zzdrm);
  }

  public final void zzue()
  {
    this.zzdrl = true;
  }

  public final void zzuf()
  {
    synchronized (this.lock)
    {
      zzbbi localzzbbi1 = zzbas.zza(this.zzdrh.zza(this.zzlj, this.zzdre.keySet()), new zzaus(this), zzbbn.zzeah);
      zzbbi localzzbbi2 = zzbas.zza(localzzbbi1, 10L, TimeUnit.SECONDS, zzdrc);
      zzbas.zza(localzzbbi1, new zzauv(this, localzzbbi2), zzbbn.zzeah);
      zzdrb.add(localzzbbi2);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaur
 * JD-Core Version:    0.6.2
 */
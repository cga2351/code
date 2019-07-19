package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.net.NetworkInfo.DetailedState;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class zzcjl
{
  private static final SparseArray<zzwr.zzi.zzc> zzfyz;
  private final zzcjh zzfww;
  private final zzbbi<Bundle> zzfyv;
  private final TelephonyManager zzfyw;
  private final zzcjb zzfyx;
  private zzwv zzfyy;
  private final Context zzlj;

  static
  {
    SparseArray localSparseArray = new SparseArray();
    zzfyz = localSparseArray;
    localSparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzwr.zzi.zzc.zzcci);
    zzfyz.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzwr.zzi.zzc.zzcch);
    zzfyz.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzwr.zzi.zzc.zzcch);
    zzfyz.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzwr.zzi.zzc.zzcch);
    zzfyz.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzwr.zzi.zzc.zzccj);
    zzfyz.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzwr.zzi.zzc.zzcck);
    zzfyz.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzwr.zzi.zzc.zzcck);
    zzfyz.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzwr.zzi.zzc.zzcck);
    zzfyz.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzwr.zzi.zzc.zzcck);
    zzfyz.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzwr.zzi.zzc.zzcck);
    zzfyz.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzwr.zzi.zzc.zzccl);
    if (Build.VERSION.SDK_INT >= 17)
      zzfyz.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzwr.zzi.zzc.zzcch);
    if (Build.VERSION.SDK_INT >= 16)
      zzfyz.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzwr.zzi.zzc.zzcch);
  }

  zzcjl(Context paramContext, zzbbi<Bundle> paramzzbbi, zzcjh paramzzcjh, zzcjb paramzzcjb)
  {
    this.zzlj = paramContext;
    this.zzfyv = paramzzbbi;
    this.zzfww = paramzzcjh;
    this.zzfyx = paramzzcjb;
    this.zzfyw = ((TelephonyManager)paramContext.getSystemService("phone"));
  }

  private final byte[] zza(boolean paramBoolean, ArrayList<zzwr.zza.zza> paramArrayList, zzwr.zzg paramzzg, zzwr.zzi.zzc paramzzc)
  {
    boolean bool1 = true;
    zzwr.zzi.zza.zza localzza1 = zzwr.zzi.zza.zzoa().zzc(paramArrayList);
    ContentResolver localContentResolver1 = this.zzlj.getContentResolver();
    boolean bool2;
    zzwr.zzi.zza.zza localzza2;
    if (zzk.zzli().zzb(localContentResolver1) != 0)
    {
      bool2 = bool1;
      localzza2 = localzza1.zzh(zzaz(bool2)).zzi(zzk.zzli().zza(this.zzlj, this.zzfyw)).zzex(this.zzfww.zzakl()).zzey(this.zzfww.zzakn()).zzcg(this.zzfww.getResponseCode()).zzb(paramzzc).zzb(paramzzg).zzj(this.zzfyy).zzf(zzaz(paramBoolean)).zzew(zzk.zzln().currentTimeMillis());
      ContentResolver localContentResolver2 = this.zzlj.getContentResolver();
      if (zzk.zzli().zza(localContentResolver2) == 0)
        break label178;
    }
    while (true)
    {
      return ((zzwr.zzi.zza)localzza2.zzg(zzaz(bool1)).zzaya()).toByteArray();
      bool2 = false;
      break;
      label178: bool1 = false;
    }
  }

  private static zzwv zzaz(boolean paramBoolean)
  {
    if (paramBoolean)
      return zzwv.zzcak;
    return zzwv.zzcaj;
  }

  private final zzwr.zzg zzj(Bundle paramBundle)
  {
    zzwr.zzg.zza localzza = zzwr.zzg.zznv();
    int i = paramBundle.getInt("cnt", -2);
    int j = paramBundle.getInt("gnt", 0);
    if (i == -1)
    {
      this.zzfyy = zzwv.zzcak;
      return (zzwr.zzg)localzza.zzaya();
    }
    this.zzfyy = zzwv.zzcaj;
    label84: zzwr.zzg.zzb localzzb;
    switch (i)
    {
    default:
      localzza.zzb(zzwr.zzg.zzc.zzcbe);
      switch (j)
      {
      default:
        localzzb = zzwr.zzg.zzb.zzcaz;
      case 1:
      case 2:
      case 4:
      case 7:
      case 11:
      case 16:
      case 13:
      case 3:
      case 5:
      case 6:
      case 8:
      case 9:
      case 10:
      case 12:
      case 14:
      case 15:
      case 17:
      }
      break;
    case 1:
    case 0:
    }
    while (true)
    {
      localzza.zzb(localzzb);
      break;
      localzza.zzb(zzwr.zzg.zzc.zzcbg);
      break label84;
      localzza.zzb(zzwr.zzg.zzc.zzcbf);
      break label84;
      localzzb = zzwr.zzg.zzb.zzcba;
      continue;
      localzzb = zzwr.zzg.zzb.zzcbc;
      continue;
      localzzb = zzwr.zzg.zzb.zzcbb;
    }
  }

  private static zzwr.zzi.zzc zzk(Bundle paramBundle)
  {
    int i = zzcxy.zza(zzcxy.zza(paramBundle, "device"), "network").getInt("active_network_state", -1);
    return (zzwr.zzi.zzc)zzfyz.get(i, zzwr.zzi.zzc.zzccg);
  }

  private static ArrayList<zzwr.zza.zza> zzl(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.get("ad_types");
    if ((localObject1 instanceof List));
    ArrayList localArrayList2;
    for (List localList2 = (List)localObject1; ; localList2 = Arrays.asList((String[])localObject1))
    {
      localArrayList2 = new ArrayList(localList2.size());
      Iterator localIterator2 = localList2.iterator();
      while (localIterator2.hasNext())
      {
        Object localObject2 = localIterator2.next();
        if ((localObject2 instanceof String))
          localArrayList2.add((String)localObject2);
      }
      if (!(localObject1 instanceof String[]))
        break;
    }
    List localList1 = Collections.emptyList();
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator1 = localList1.iterator();
    label128: if (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      label196: int i;
      label199: zzwr.zza.zza localzza;
      switch (str.hashCode())
      {
      default:
        i = -1;
        switch (i)
        {
        default:
          localzza = zzwr.zza.zza.zzbzm;
        case 0:
        case 1:
        case 2:
        case 3:
        }
        break;
      case -1396342996:
      case 604727084:
      case -1052618729:
      case -239580146:
      }
      while (true)
      {
        localArrayList1.add(localzza);
        break label128;
        localList1 = Collections.unmodifiableList(localArrayList2);
        break;
        if (!str.equals("banner"))
          break label196;
        i = 0;
        break label199;
        if (!str.equals("interstitial"))
          break label196;
        i = 1;
        break label199;
        if (!str.equals("native"))
          break label196;
        i = 2;
        break label199;
        if (!str.equals("rewarded"))
          break label196;
        i = 3;
        break label199;
        localzza = zzwr.zza.zza.zzbzn;
        continue;
        localzza = zzwr.zza.zza.zzbzo;
        continue;
        localzza = zzwr.zza.zza.zzbzr;
        continue;
        localzza = zzwr.zza.zza.zzbzv;
      }
    }
    return localArrayList1;
  }

  public final void zzba(boolean paramBoolean)
  {
    zzbas.zza(this.zzfyv, new zzcjm(this, paramBoolean), zzbbn.zzeah);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcjl
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class zzcxu
{
  public final zzadx zzdgu;
  public final zzyb zzdln;
  public final zzaiz zzdng;
  public final zzxx zzghg;
  public final zzzw zzgkz;
  public final zzacc zzgla;
  public final String zzglb;
  public final ArrayList<String> zzglc;
  public final ArrayList<String> zzgld;
  public final String zzgle;
  public final String zzglf;
  public final int zzglg;
  public final PublisherAdViewOptions zzglh;
  public final zzzq zzgli;
  public final Set<String> zzglj;

  private zzcxu(zzcxw paramzzcxw)
  {
    this.zzdln = zzcxw.zza(paramzzcxw);
    this.zzglb = zzcxw.zzb(paramzzcxw);
    this.zzgkz = zzcxw.zzc(paramzzcxw);
    int i = zzcxw.zzl(paramzzcxw).versionCode;
    long l = zzcxw.zzl(paramzzcxw).zzcgo;
    Bundle localBundle = zzcxw.zzl(paramzzcxw).extras;
    int j = zzcxw.zzl(paramzzcxw).zzcgp;
    List localList = zzcxw.zzl(paramzzcxw).zzcgq;
    boolean bool1 = zzcxw.zzl(paramzzcxw).zzcgr;
    int k = zzcxw.zzl(paramzzcxw).zzcgs;
    boolean bool2;
    zzacc localzzacc;
    label238: zzadx localzzadx;
    if ((zzcxw.zzl(paramzzcxw).zzbqn) || (zzcxw.zzm(paramzzcxw)))
    {
      bool2 = true;
      this.zzghg = new zzxx(i, l, localBundle, j, localList, bool1, k, bool2, zzcxw.zzl(paramzzcxw).zzcgt, zzcxw.zzl(paramzzcxw).zzcgu, zzcxw.zzl(paramzzcxw).zzmw, zzcxw.zzl(paramzzcxw).zzcgv, zzcxw.zzl(paramzzcxw).zzcgw, zzcxw.zzl(paramzzcxw).zzcgx, zzcxw.zzl(paramzzcxw).zzcgy, zzcxw.zzl(paramzzcxw).zzcgz, zzcxw.zzl(paramzzcxw).zzcha, zzcxw.zzl(paramzzcxw).zzchb, zzcxw.zzl(paramzzcxw).zzchc, zzcxw.zzl(paramzzcxw).zzchd, zzcxw.zzl(paramzzcxw).zzche);
      if (zzcxw.zzn(paramzzcxw) == null)
        break label339;
      localzzacc = zzcxw.zzn(paramzzcxw);
      this.zzgla = localzzacc;
      this.zzglc = zzcxw.zzd(paramzzcxw);
      this.zzgld = zzcxw.zze(paramzzcxw);
      if (zzcxw.zzd(paramzzcxw) != null)
        break label364;
      localzzadx = null;
    }
    while (true)
    {
      this.zzdgu = localzzadx;
      this.zzgle = zzcxw.zzf(paramzzcxw);
      this.zzglf = zzcxw.zzg(paramzzcxw);
      this.zzglg = zzcxw.zzh(paramzzcxw);
      this.zzglh = zzcxw.zzi(paramzzcxw);
      this.zzgli = zzcxw.zzj(paramzzcxw);
      this.zzdng = zzcxw.zzk(paramzzcxw);
      this.zzglj = paramzzcxw.zzglj;
      return;
      bool2 = false;
      break;
      label339: if (zzcxw.zzo(paramzzcxw) != null)
      {
        localzzacc = zzcxw.zzo(paramzzcxw).zzcyn;
        break label238;
      }
      localzzacc = null;
      break label238;
      label364: if (zzcxw.zzo(paramzzcxw) == null)
        localzzadx = new zzadx(new NativeAdOptions.Builder().build());
      else
        localzzadx = zzcxw.zzo(paramzzcxw);
    }
  }

  public final zzafz zzamn()
  {
    if (this.zzglh == null)
      return null;
    return this.zzglh.zzku();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcxu
 * JD-Core Version:    0.6.2
 */
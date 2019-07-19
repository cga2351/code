package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

public abstract class zzr<T>
  implements Comparable<zzr<T>>
{
  private final Object mLock;
  private final zzag.zza zzae;
  private final int zzaf;
  private final String zzag;
  private final int zzah;
  private zzz zzai;
  private Integer zzaj;
  private zzv zzak;
  private boolean zzal;
  private boolean zzam;
  private boolean zzan;
  private boolean zzao;
  private zzac zzap;
  private zzc zzaq;
  private zzt zzar;

  public zzr(int paramInt, String paramString, zzz paramzzz)
  {
    zzag.zza localzza;
    String str;
    if (zzag.zza.zzbl)
    {
      localzza = new zzag.zza();
      this.zzae = localzza;
      this.mLock = new Object();
      this.zzal = true;
      this.zzam = false;
      this.zzan = false;
      this.zzao = false;
      this.zzaq = null;
      this.zzaf = paramInt;
      this.zzag = paramString;
      this.zzai = paramzzz;
      this.zzap = new zzh();
      if (TextUtils.isEmpty(paramString))
        break label137;
      Uri localUri = Uri.parse(paramString);
      if (localUri == null)
        break label137;
      str = localUri.getHost();
      if (str == null)
        break label137;
    }
    label137: for (int i = str.hashCode(); ; i = 0)
    {
      this.zzah = i;
      return;
      localzza = null;
      break;
    }
  }

  public Map<String, String> getHeaders()
    throws zza
  {
    return Collections.emptyMap();
  }

  public final int getMethod()
  {
    return this.zzaf;
  }

  public final String getUrl()
  {
    return this.zzag;
  }

  public final boolean isCanceled()
  {
    synchronized (this.mLock)
    {
      return false;
    }
  }

  public String toString()
  {
    String str1 = String.valueOf(Integer.toHexString(this.zzah));
    if (str1.length() != 0);
    for (String str2 = "0x".concat(str1); ; str2 = new String("0x"))
    {
      isCanceled();
      String str3 = this.zzag;
      String str4 = String.valueOf(zzu.zzaw);
      String str5 = String.valueOf(this.zzaj);
      return 3 + String.valueOf("[ ] ").length() + String.valueOf(str3).length() + String.valueOf(str2).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + "[ ] " + str3 + " " + str2 + " " + str4 + " " + str5;
    }
  }

  public final zzr<?> zza(zzc paramzzc)
  {
    this.zzaq = paramzzc;
    return this;
  }

  public final zzr<?> zza(zzv paramzzv)
  {
    this.zzak = paramzzv;
    return this;
  }

  protected abstract zzy<T> zza(zzp paramzzp);

  final void zza(int paramInt)
  {
    if (this.zzak != null)
      this.zzak.zza(this, paramInt);
  }

  final void zza(zzt paramzzt)
  {
    synchronized (this.mLock)
    {
      this.zzar = paramzzt;
      return;
    }
  }

  final void zza(zzy<?> paramzzy)
  {
    synchronized (this.mLock)
    {
      zzt localzzt = this.zzar;
      if (localzzt != null)
        localzzt.zza(this, paramzzy);
      return;
    }
  }

  protected abstract void zza(T paramT);

  public final zzr<?> zzb(int paramInt)
  {
    this.zzaj = Integer.valueOf(paramInt);
    return this;
  }

  public final void zzb(zzaf paramzzaf)
  {
    synchronized (this.mLock)
    {
      zzz localzzz = this.zzai;
      if (localzzz != null)
        localzzz.zzd(paramzzaf);
      return;
    }
  }

  public final void zzb(String paramString)
  {
    if (zzag.zza.zzbl)
      this.zzae.zza(paramString, Thread.currentThread().getId());
  }

  final void zzc(String paramString)
  {
    if (this.zzak != null)
      this.zzak.zzf(this);
    long l;
    if (zzag.zza.zzbl)
    {
      l = Thread.currentThread().getId();
      if (Looper.myLooper() != Looper.getMainLooper())
        new Handler(Looper.getMainLooper()).post(new zzs(this, paramString, l));
    }
    else
    {
      return;
    }
    this.zzae.zza(paramString, l);
    this.zzae.zzc(toString());
  }

  public final int zzd()
  {
    return this.zzah;
  }

  public final String zze()
  {
    String str1 = this.zzag;
    int i = this.zzaf;
    if ((i == 0) || (i == -1))
      return str1;
    String str2 = Integer.toString(i);
    return 1 + String.valueOf(str2).length() + String.valueOf(str1).length() + str2 + '-' + str1;
  }

  public final zzc zzf()
  {
    return this.zzaq;
  }

  public byte[] zzg()
    throws zza
  {
    return null;
  }

  public final boolean zzh()
  {
    return this.zzal;
  }

  public final int zzi()
  {
    return this.zzap.zzb();
  }

  public final zzac zzj()
  {
    return this.zzap;
  }

  public final void zzk()
  {
    synchronized (this.mLock)
    {
      this.zzan = true;
      return;
    }
  }

  public final boolean zzl()
  {
    synchronized (this.mLock)
    {
      boolean bool = this.zzan;
      return bool;
    }
  }

  final void zzm()
  {
    synchronized (this.mLock)
    {
      zzt localzzt = this.zzar;
      if (localzzt != null)
        localzzt.zza(this);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzr
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import java.io.IOException;

final class zzpz
  implements zznp, zzqj, zzqv, zzsf<zzqe>
{
  private final Handler handler;
  private final Uri uri;
  private final Handler zzabq;
  private boolean zzacf;
  private long zzack;
  private boolean zzacs;
  private final SparseArray<zzqt> zzaif;
  private final int zzaig;
  private boolean zzaii;
  private int zzaik;
  private boolean[] zzain;
  private long zzaip;
  private long zzaiq;
  private boolean zzaiz;
  private final zzrv zzazi;
  private final zzqi zzbia;
  private final zzqm zzbib;
  private final zzrt zzbic;
  private final String zzbid;
  private final long zzbie;
  private final zzse zzbif;
  private final zzqf zzbig;
  private final zzsm zzbih;
  private final Runnable zzbii;
  private final Runnable zzbij;
  private zzqk zzbik;
  private zznu zzbil;
  private boolean zzbim;
  private boolean zzbin;
  private zzrb zzbio;
  private boolean[] zzbip;
  private boolean zzbiq;
  private int zzbir;
  private long zzcd;

  public zzpz(Uri paramUri, zzrv paramzzrv, zznn[] paramArrayOfzznn, int paramInt1, Handler paramHandler, zzqi paramzzqi, zzqm paramzzqm, zzrt paramzzrt, String paramString, int paramInt2)
  {
    this.uri = paramUri;
    this.zzazi = paramzzrv;
    this.zzaig = paramInt1;
    this.zzabq = paramHandler;
    this.zzbia = paramzzqi;
    this.zzbib = paramzzqm;
    this.zzbic = paramzzrt;
    this.zzbid = paramString;
    this.zzbie = paramInt2;
    this.zzbif = new zzse("Loader:ExtractorMediaPeriod");
    this.zzbig = new zzqf(paramArrayOfzznn, this);
    this.zzbih = new zzsm();
    this.zzbii = new zzqa(this);
    this.zzbij = new zzqb(this);
    this.handler = new Handler();
    this.zzaiq = -9223372036854775807L;
    this.zzaif = new SparseArray();
    this.zzcd = -1L;
  }

  private final void startLoading()
  {
    zzqe localzzqe = new zzqe(this, this.uri, this.zzazi, this.zzbig, this.zzbih);
    if (this.zzacs)
    {
      zzsk.checkState(zzfo());
      if ((this.zzack != -9223372036854775807L) && (this.zzaiq >= this.zzack))
      {
        this.zzaiz = true;
        this.zzaiq = -9223372036854775807L;
        return;
      }
      localzzqe.zzf(this.zzbil.zzdq(this.zzaiq), this.zzaiq);
      this.zzaiq = -9223372036854775807L;
    }
    this.zzbir = zzjd();
    int i = this.zzaig;
    if (i == -1)
      if ((this.zzacs) && (this.zzcd == -1L) && ((this.zzbil == null) || (this.zzbil.getDurationUs() == -9223372036854775807L)))
        break label176;
    label176: for (i = 3; ; i = 6)
    {
      this.zzbif.zza(localzzqe, this, i);
      return;
    }
  }

  private final void zza(zzqe paramzzqe)
  {
    if (this.zzcd == -1L)
      this.zzcd = zzqe.zzb(paramzzqe);
  }

  private final boolean zzfo()
  {
    return this.zzaiq != -9223372036854775807L;
  }

  private final void zzjc()
  {
    if ((this.zzacf) || (this.zzacs) || (this.zzbil == null) || (!this.zzaii))
      return;
    int i = this.zzaif.size();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label67;
      if (((zzqt)this.zzaif.valueAt(j)).zzjl() == null)
        break;
    }
    label67: this.zzbih.zzjy();
    zzra[] arrayOfzzra = new zzra[i];
    this.zzbip = new boolean[i];
    this.zzain = new boolean[i];
    this.zzack = this.zzbil.getDurationUs();
    int k = 0;
    if (k < i)
    {
      zzlh localzzlh = ((zzqt)this.zzaif.valueAt(k)).zzjl();
      arrayOfzzra[k] = new zzra(new zzlh[] { localzzlh });
      String str = localzzlh.zzatq;
      if ((zzsp.zzbf(str)) || (zzsp.zzav(str)));
      for (int m = 1; ; m = 0)
      {
        this.zzbip[k] = m;
        this.zzbiq = (m | this.zzbiq);
        k++;
        break;
      }
    }
    this.zzbio = new zzrb(arrayOfzzra);
    this.zzacs = true;
    this.zzbib.zzb(new zzqz(this.zzack, this.zzbil.zzfc()), null);
    this.zzbik.zza(this);
  }

  private final int zzjd()
  {
    int i = this.zzaif.size();
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += ((zzqt)this.zzaif.valueAt(j)).zzjj();
      j++;
    }
    return k;
  }

  private final long zzje()
  {
    long l = -9223372036854775808L;
    int i = this.zzaif.size();
    for (int j = 0; j < i; j++)
      l = Math.max(l, ((zzqt)this.zzaif.valueAt(j)).zzje());
    return l;
  }

  public final void release()
  {
    zzqf localzzqf = this.zzbig;
    this.zzbif.zza(new zzqc(this, localzzqf));
    this.handler.removeCallbacksAndMessages(null);
    this.zzacf = true;
  }

  final int zza(int paramInt, zzlj paramzzlj, zznd paramzznd, boolean paramBoolean)
  {
    if ((this.zzbin) || (zzfo()))
      return -3;
    return ((zzqt)this.zzaif.valueAt(paramInt)).zza(paramzzlj, paramzznd, paramBoolean, this.zzaiz, this.zzaip);
  }

  public final long zza(zzrm[] paramArrayOfzzrm, boolean[] paramArrayOfBoolean1, zzqw[] paramArrayOfzzqw, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    int i = 0;
    zzsk.checkState(this.zzacs);
    for (int j = 0; j < paramArrayOfzzrm.length; j++)
      if ((paramArrayOfzzqw[j] != null) && ((paramArrayOfzzrm[j] == null) || (paramArrayOfBoolean1[j] == 0)))
      {
        int i3 = zzqg.zza((zzqg)paramArrayOfzzqw[j]);
        zzsk.checkState(this.zzain[i3]);
        this.zzaik = (-1 + this.zzaik);
        this.zzain[i3] = false;
        ((zzqt)this.zzaif.valueAt(i3)).disable();
        paramArrayOfzzqw[j] = null;
      }
    int k = 0;
    int m = 0;
    if (k < paramArrayOfzzrm.length)
    {
      boolean bool1;
      label154: boolean bool2;
      label173: int i2;
      if ((paramArrayOfzzqw[k] == null) && (paramArrayOfzzrm[k] != null))
      {
        zzrm localzzrm = paramArrayOfzzrm[k];
        if (localzzrm.length() != 1)
          break label259;
        bool1 = true;
        zzsk.checkState(bool1);
        if (localzzrm.zzbh(0) != 0)
          break label265;
        bool2 = true;
        zzsk.checkState(bool2);
        i2 = this.zzbio.zza(localzzrm.zzjr());
        if (this.zzain[i2] != 0)
          break label271;
      }
      label259: label265: label271: for (boolean bool3 = true; ; bool3 = false)
      {
        zzsk.checkState(bool3);
        this.zzaik = (1 + this.zzaik);
        this.zzain[i2] = true;
        paramArrayOfzzqw[k] = new zzqg(this, i2);
        paramArrayOfBoolean2[k] = true;
        m = 1;
        k++;
        break;
        bool1 = false;
        break label154;
        bool2 = false;
        break label173;
      }
    }
    if (!this.zzbim)
    {
      int n = this.zzaif.size();
      for (int i1 = 0; i1 < n; i1++)
        if (this.zzain[i1] == 0)
          ((zzqt)this.zzaif.valueAt(i1)).disable();
    }
    if (this.zzaik == 0)
    {
      this.zzbin = false;
      if (this.zzbif.isLoading())
        this.zzbif.zzgb();
    }
    do
    {
      this.zzbim = true;
      return paramLong;
      if (!this.zzbim)
        break;
    }
    while (m == 0);
    while (true)
    {
      paramLong = zzen(paramLong);
      while (i < paramArrayOfzzqw.length)
      {
        if (paramArrayOfzzqw[i] != null)
          paramArrayOfBoolean2[i] = true;
        i++;
      }
      break;
      if (paramLong == 0L)
        break;
    }
  }

  public final void zza(zznu paramzznu)
  {
    this.zzbil = paramzznu;
    this.handler.post(this.zzbii);
  }

  public final void zza(zzqk paramzzqk, long paramLong)
  {
    this.zzbik = paramzzqk;
    this.zzbih.zzjx();
    startLoading();
  }

  final boolean zzbd(int paramInt)
  {
    return (this.zzaiz) || ((!zzfo()) && (((zzqt)this.zzaif.valueAt(paramInt)).zzjk()));
  }

  public final zznw zzd(int paramInt1, int paramInt2)
  {
    zzqt localzzqt = (zzqt)this.zzaif.get(paramInt1);
    if (localzzqt == null)
    {
      localzzqt = new zzqt(this.zzbic);
      localzzqt.zza(this);
      this.zzaif.put(paramInt1, localzzqt);
    }
    return localzzqt;
  }

  public final long zzdu()
  {
    long l1;
    if (this.zzaiz)
    {
      l1 = -9223372036854775808L;
      return l1;
    }
    if (zzfo())
      return this.zzaiq;
    long l2;
    int j;
    if (this.zzbiq)
    {
      l2 = 9223372036854775807L;
      int i = this.zzaif.size();
      j = 0;
      label48: if (j < i)
        if (this.zzbip[j] == 0)
          break label118;
    }
    label118: for (long l3 = Math.min(l2, ((zzqt)this.zzaif.valueAt(j)).zzje()); ; l3 = l2)
    {
      j++;
      l2 = l3;
      break label48;
      for (l1 = l2; l1 == -9223372036854775808L; l1 = zzje())
        return this.zzaip;
      break;
    }
  }

  public final boolean zzel(long paramLong)
  {
    boolean bool;
    if ((this.zzaiz) || ((this.zzacs) && (this.zzaik == 0)))
      bool = false;
    do
    {
      return bool;
      bool = this.zzbih.zzjx();
    }
    while (this.zzbif.isLoading());
    startLoading();
    return true;
  }

  public final void zzem(long paramLong)
  {
  }

  public final long zzen(long paramLong)
  {
    int i;
    if (this.zzbil.zzfc())
    {
      this.zzaip = paramLong;
      i = this.zzaif.size();
      if (zzfo())
        break label89;
    }
    label89: for (boolean bool = true; ; bool = false)
    {
      for (int j = 0; (bool) && (j < i); j++)
        if (this.zzain[j] != 0)
          bool = ((zzqt)this.zzaif.valueAt(j)).zzh(paramLong, false);
      paramLong = 0L;
      break;
    }
    if (!bool)
    {
      this.zzaiq = paramLong;
      this.zzaiz = false;
      if (!this.zzbif.isLoading())
        break label134;
      this.zzbif.zzgb();
    }
    while (true)
    {
      this.zzbin = false;
      return paramLong;
      label134: for (int k = 0; k < i; k++)
        ((zzqt)this.zzaif.valueAt(k)).zzk(this.zzain[k]);
    }
  }

  final void zzf(int paramInt, long paramLong)
  {
    zzqt localzzqt = (zzqt)this.zzaif.valueAt(paramInt);
    if ((this.zzaiz) && (paramLong > localzzqt.zzje()))
    {
      localzzqt.zzjn();
      return;
    }
    localzzqt.zzh(paramLong, true);
  }

  public final void zzf(zzlh paramzzlh)
  {
    this.handler.post(this.zzbii);
  }

  public final void zzfi()
  {
    this.zzaii = true;
    this.handler.post(this.zzbii);
  }

  public final long zzix()
  {
    if (this.zzaik == 0)
      return -9223372036854775808L;
    return zzdu();
  }

  public final void zziy()
    throws IOException
  {
    this.zzbif.zzbm(-2147483648);
  }

  public final zzrb zziz()
  {
    return this.zzbio;
  }

  public final long zzja()
  {
    if (this.zzbin)
    {
      this.zzbin = false;
      return this.zzaip;
    }
    return -9223372036854775807L;
  }

  final void zzjb()
    throws IOException
  {
    this.zzbif.zzbm(-2147483648);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzpz
 * JD-Core Version:    0.6.2
 */
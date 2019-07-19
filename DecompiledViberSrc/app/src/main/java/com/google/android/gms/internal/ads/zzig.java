package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.SystemClock;
import android.util.SparseArray;
import java.io.IOException;

public final class zzig
  implements zzhn, zzif, zzka
{
  private final Uri uri;
  private zzho[] zzacr;
  private boolean zzacs;
  private int zzact;
  private boolean[] zzacv;
  private volatile zzhw zzadp;
  private final zzjp zzahu;
  private final zzid zzaic;
  private final zzjr zzaid;
  private final int zzaie;
  private final SparseArray<zzii> zzaif;
  private final int zzaig;
  private final boolean zzaih;
  private volatile boolean zzaii;
  private volatile zzio zzaij;
  private int zzaik;
  private long zzail;
  private boolean[] zzaim;
  private boolean[] zzain;
  private long zzaio;
  private long zzaip;
  private long zzaiq;
  private boolean zzair;
  private long zzais;
  private zzjz zzait;
  private zzih zzaiu;
  private IOException zzaiv;
  private boolean zzaiw;
  private int zzaix;
  private long zzaiy;
  private boolean zzaiz;
  private int zzaja;
  private int zzajb;

  public zzig(Uri paramUri, zzjp paramzzjp, zzid paramzzid, int paramInt1, int paramInt2)
  {
    this(paramUri, paramzzjp, paramzzid, 2, paramInt2, -1);
  }

  private zzig(Uri paramUri, zzjp paramzzjp, zzid paramzzid, int paramInt1, int paramInt2, int paramInt3)
  {
    this.uri = paramUri;
    this.zzahu = paramzzjp;
    this.zzaic = paramzzid;
    this.zzact = 2;
    this.zzaie = paramInt2;
    this.zzaig = -1;
    this.zzaif = new SparseArray();
    this.zzaid = new zzjr(262144);
    this.zzaiq = -1L;
    this.zzaih = true;
    paramzzid.zza(this);
  }

  private final void zzdt(long paramLong)
  {
    this.zzaiq = paramLong;
    this.zzaiz = false;
    if (this.zzait.isLoading())
    {
      this.zzait.zzgb();
      return;
    }
    zzfn();
    zzfk();
  }

  private final boolean zzfj()
    throws IOException
  {
    zzfk();
    boolean bool1 = zzfo();
    boolean bool2 = false;
    if (bool1)
      return bool2;
    boolean bool3 = this.zzacs;
    bool2 = false;
    int i;
    if (bool3)
    {
      i = 0;
      label31: if (i >= this.zzain.length)
        break label97;
      if ((this.zzain[i] == 0) || (((zzii)this.zzaif.valueAt(i)).isEmpty()))
        break label91;
    }
    label91: label97: for (int j = 1; ; j = 0)
    {
      bool2 = false;
      if (j != 0)
        bool2 = true;
      if (bool2)
        break;
      zzfl();
      return bool2;
      i++;
      break label31;
    }
  }

  private final void zzfk()
  {
    boolean bool1 = true;
    if ((this.zzaiz) || (this.zzait.isLoading()))
      return;
    if (this.zzaiv != null)
    {
      if (this.zzaiu != null);
      while (true)
      {
        zzkh.checkState(bool1);
        if (SystemClock.elapsedRealtime() - this.zzaiy < Math.min(1000L * (this.zzaix - 1L), 5000L))
          break;
        this.zzaiv = null;
        boolean bool2 = this.zzacs;
        int i = 0;
        if (bool2)
          break label153;
        while (i < this.zzaif.size())
        {
          ((zzii)this.zzaif.valueAt(i)).clear();
          i++;
        }
        bool1 = false;
      }
      this.zzaiu = zzfm();
      while (true)
      {
        this.zzajb = this.zzaja;
        this.zzait.zza(this.zzaiu, this);
        return;
        label153: this.zzaij.zzfc();
      }
    }
    this.zzais = 0L;
    this.zzair = false;
    if (!this.zzacs)
      this.zzaiu = zzfm();
    while (true)
    {
      this.zzajb = this.zzaja;
      this.zzait.zza(this.zzaiu, this);
      return;
      zzkh.checkState(zzfo());
      if ((this.zzail != -1L) && (this.zzaiq >= this.zzail))
      {
        this.zzaiz = bool1;
        this.zzaiq = -1L;
        return;
      }
      long l = this.zzaiq;
      this.zzaiu = new zzih(this.uri, this.zzahu, this.zzaic, this.zzaid, this.zzaie, this.zzaij.zzdq(l));
      this.zzaiq = -1L;
    }
  }

  private final void zzfl()
    throws IOException
  {
    if (this.zzaiv == null);
    while (true)
    {
      return;
      if (this.zzaig != -1);
      for (int i = this.zzaig; this.zzaix > i; i = 3)
      {
        throw this.zzaiv;
        if (this.zzaij != null)
          this.zzaij.zzfc();
      }
    }
  }

  private final zzih zzfm()
  {
    return new zzih(this.uri, this.zzahu, this.zzaic, this.zzaid, this.zzaie, 0L);
  }

  private final void zzfn()
  {
    for (int i = 0; i < this.zzaif.size(); i++)
      ((zzii)this.zzaif.valueAt(i)).clear();
    this.zzaiu = null;
    this.zzaiv = null;
    this.zzaix = 0;
    this.zzaiw = false;
  }

  private final boolean zzfo()
  {
    return this.zzaiq != -1L;
  }

  public final int getTrackCount()
  {
    return this.zzaif.size();
  }

  public final void release()
  {
    if (this.zzact > 0);
    for (boolean bool = true; ; bool = false)
    {
      zzkh.checkState(bool);
      int i = -1 + this.zzact;
      this.zzact = i;
      if ((i == 0) && (this.zzait != null))
      {
        this.zzait.release();
        this.zzait = null;
      }
      return;
    }
  }

  public final int zza(int paramInt, long paramLong, zzhk paramzzhk, zzhm paramzzhm, boolean paramBoolean)
    throws IOException
  {
    this.zzaio = paramLong;
    if (this.zzacv[paramInt] != 0)
    {
      this.zzacv[paramInt] = false;
      return -5;
    }
    if ((paramBoolean) || (zzfo()))
    {
      zzfl();
      return -2;
    }
    zzii localzzii = (zzii)this.zzaif.valueAt(paramInt);
    if (this.zzaim[paramInt] != 0)
    {
      paramzzhk.zzado = localzzii.zzfe();
      paramzzhk.zzadp = this.zzadp;
      this.zzaim[paramInt] = false;
      return -4;
    }
    if (localzzii.zza(paramzzhm))
    {
      if ((this.zzaih) && (paramzzhm.zzaga < this.zzaip));
      for (int i = 1; ; i = 0)
      {
        int j = paramzzhm.flags;
        int k = 0;
        if (i != 0)
          k = 134217728;
        paramzzhm.flags = (j | k);
        paramzzhm.zzaga += this.zzais;
        return -3;
      }
    }
    if (this.zzaiz)
      return -1;
    zzfl();
    return -2;
  }

  public final void zza(int paramInt, long paramLong)
  {
    zzkh.checkState(this.zzacs);
    if (this.zzain[paramInt] == 0);
    for (boolean bool = true; ; bool = false)
    {
      zzkh.checkState(bool);
      this.zzaik = (1 + this.zzaik);
      this.zzain[paramInt] = true;
      this.zzaim[paramInt] = true;
      if (this.zzaik == 1)
        zzdi(paramLong);
      return;
    }
  }

  public final void zza(zzio paramzzio)
  {
    this.zzaij = paramzzio;
  }

  public final void zza(zzkc paramzzkc)
  {
    this.zzaiz = true;
  }

  public final void zza(zzkc paramzzkc, IOException paramIOException)
  {
    this.zzaiv = paramIOException;
    if (this.zzaja > this.zzajb);
    for (int i = 1; ; i = 1 + this.zzaix)
    {
      this.zzaix = i;
      this.zzaiy = SystemClock.elapsedRealtime();
      zzfk();
      return;
    }
  }

  public final void zzb(zzhw paramzzhw)
  {
    this.zzadp = paramzzhw;
  }

  public final void zzb(zzkc paramzzkc)
  {
    if (this.zzaik > 0)
    {
      zzdt(this.zzaiq);
      return;
    }
    zzfn();
    this.zzaid.zzz(0);
  }

  public final boolean zzdg(long paramLong)
    throws IOException
  {
    int i = 0;
    if (this.zzacs)
      return true;
    if (this.zzait == null)
      this.zzait = new zzjz("Loader:ExtractorSampleSource");
    zzfj();
    if ((this.zzaij != null) && (this.zzaii))
    {
      int j = 0;
      int k;
      if (j < this.zzaif.size())
        if (!((zzii)this.zzaif.valueAt(j)).zzfd())
          k = 0;
      while (true)
        label87: if (k != 0)
        {
          int m = this.zzaif.size();
          this.zzain = new boolean[m];
          this.zzacv = new boolean[m];
          this.zzaim = new boolean[m];
          this.zzacr = new zzho[m];
          this.zzail = -1L;
          while (true)
            if (i < m)
            {
              zzhj localzzhj = ((zzii)this.zzaif.valueAt(i)).zzfe();
              this.zzacr[i] = new zzho(localzzhj.mimeType, localzzhj.zzack);
              if ((localzzhj.zzack != -1L) && (localzzhj.zzack > this.zzail))
                this.zzail = localzzhj.zzack;
              i++;
              continue;
              j++;
              break;
              k = 1;
              break label87;
            }
          this.zzacs = true;
          return true;
        }
    }
    zzfl();
    return false;
  }

  public final boolean zzdh(long paramLong)
    throws IOException
  {
    zzkh.checkState(this.zzacs);
    if (this.zzaik > 0);
    for (boolean bool1 = true; ; bool1 = false)
    {
      zzkh.checkState(bool1);
      this.zzaio = paramLong;
      long l = this.zzaio;
      for (int i = 0; i < this.zzain.length; i++)
        if (this.zzain[i] == 0)
          ((zzii)this.zzaif.valueAt(i)).zzdr(l);
    }
    boolean bool2;
    if (!this.zzaiz)
    {
      boolean bool3 = zzfj();
      bool2 = false;
      if (!bool3);
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }

  public final void zzdi(long paramLong)
  {
    zzkh.checkState(this.zzacs);
    boolean bool1;
    long l;
    if (this.zzaik > 0)
    {
      bool1 = true;
      zzkh.checkState(bool1);
      this.zzaij.zzfc();
      this.zzaip = paramLong;
      if (!zzfo())
        break label61;
      l = this.zzaiq;
      label48: if (l != paramLong)
        break label70;
    }
    while (true)
    {
      return;
      bool1 = false;
      break;
      label61: l = this.zzaio;
      break label48;
      label70: this.zzaio = paramLong;
      if (!zzfo());
      boolean bool3;
      for (boolean bool2 = true; ; bool2 = false)
      {
        int i = 0;
        bool3 = bool2;
        while ((bool3) && (i < this.zzaif.size()))
        {
          bool3 &= ((zzii)this.zzaif.valueAt(i)).zzds(paramLong);
          i++;
        }
      }
      int j = 0;
      if (!bool3)
        zzdt(paramLong);
      while (j < this.zzacv.length)
      {
        this.zzacv[j] = true;
        j++;
      }
    }
  }

  public final long zzdu()
  {
    long l;
    if (this.zzaiz)
      l = -3L;
    do
    {
      return l;
      if (zzfo())
        return this.zzaiq;
      int i = 0;
      l = -9223372036854775808L;
      while (i < this.zzaif.size())
      {
        l = Math.max(l, ((zzii)this.zzaif.valueAt(i)).zzff());
        i++;
      }
    }
    while (l != -9223372036854775808L);
    return this.zzaio;
  }

  public final void zzfi()
  {
    this.zzaii = true;
  }

  public final zzho zzo(int paramInt)
  {
    zzkh.checkState(this.zzacs);
    return this.zzacr[paramInt];
  }

  public final void zzp(int paramInt)
  {
    zzkh.checkState(this.zzacs);
    zzkh.checkState(this.zzain[paramInt]);
    this.zzaik = (-1 + this.zzaik);
    this.zzain[paramInt] = false;
    this.zzacv[paramInt] = false;
    if (this.zzaik == 0)
    {
      if (this.zzait.isLoading())
        this.zzait.zzgb();
    }
    else
      return;
    zzfn();
    this.zzaid.zzz(0);
  }

  public final zzip zzs(int paramInt)
  {
    zzii localzzii = (zzii)this.zzaif.get(paramInt);
    if (localzzii == null)
    {
      localzzii = new zzii(this, this.zzaid);
      this.zzaif.put(paramInt, localzzii);
    }
    return localzzii;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzig
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;

final class zzqn
  implements zzqj, zzqk
{
  private zzrb zzasa;
  private zzqk zzbik;
  public final zzqj[] zzbjd;
  private final IdentityHashMap<zzqw, Integer> zzbje;
  private int zzbjf;
  private zzqj[] zzbjg;
  private zzqx zzbjh;

  public zzqn(zzqj[] paramArrayOfzzqj)
  {
    this.zzbjd = paramArrayOfzzqj;
    this.zzbje = new IdentityHashMap();
  }

  public final long zza(zzrm[] paramArrayOfzzrm, boolean[] paramArrayOfBoolean1, zzqw[] paramArrayOfzzqw, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    int[] arrayOfInt1 = new int[paramArrayOfzzrm.length];
    int[] arrayOfInt2 = new int[paramArrayOfzzrm.length];
    int i = 0;
    if (i < paramArrayOfzzrm.length)
    {
      int i1;
      label32: zzra localzzra;
      if (paramArrayOfzzqw[i] == null)
      {
        i1 = -1;
        arrayOfInt1[i] = i1;
        arrayOfInt2[i] = -1;
        if (paramArrayOfzzrm[i] != null)
          localzzra = paramArrayOfzzrm[i].zzjr();
      }
      for (int i2 = 0; ; i2++)
        if (i2 < this.zzbjd.length)
        {
          if (this.zzbjd[i2].zziz().zza(localzzra) != -1)
            arrayOfInt2[i] = i2;
        }
        else
        {
          i++;
          break;
          i1 = ((Integer)this.zzbje.get(paramArrayOfzzqw[i])).intValue();
          break label32;
        }
    }
    this.zzbje.clear();
    zzqw[] arrayOfzzqw1 = new zzqw[paramArrayOfzzrm.length];
    zzqw[] arrayOfzzqw2 = new zzqw[paramArrayOfzzrm.length];
    zzrm[] arrayOfzzrm = new zzrm[paramArrayOfzzrm.length];
    ArrayList localArrayList = new ArrayList(this.zzbjd.length);
    int j = 0;
    long l1 = paramLong;
    while (j < this.zzbjd.length)
    {
      int k = 0;
      if (k < paramArrayOfzzrm.length)
      {
        zzqw localzzqw;
        if (arrayOfInt1[k] == j)
        {
          localzzqw = paramArrayOfzzqw[k];
          label223: arrayOfzzqw2[k] = localzzqw;
          if (arrayOfInt2[k] != j)
            break label265;
        }
        label265: for (zzrm localzzrm = paramArrayOfzzrm[k]; ; localzzrm = null)
        {
          arrayOfzzrm[k] = localzzrm;
          k++;
          break;
          localzzqw = null;
          break label223;
        }
      }
      long l2 = this.zzbjd[j].zza(arrayOfzzrm, paramArrayOfBoolean1, arrayOfzzqw2, paramArrayOfBoolean2, l1);
      int m;
      int n;
      if (j == 0)
      {
        l1 = l2;
        m = 0;
        n = 0;
        label309: if (n >= paramArrayOfzzrm.length)
          break label438;
        if (arrayOfInt2[n] != j)
          break label403;
        if (arrayOfzzqw2[n] == null)
          break label397;
        bool2 = true;
        zzsk.checkState(bool2);
        arrayOfzzqw1[n] = arrayOfzzqw2[n];
        m = 1;
        this.zzbje.put(arrayOfzzqw2[n], Integer.valueOf(j));
      }
      label397: label403: 
      while (arrayOfInt1[n] != j)
        while (true)
        {
          n++;
          break label309;
          if (l2 == l1)
            break;
          throw new IllegalStateException("Children enabled at different positions");
          boolean bool2 = false;
        }
      if (arrayOfzzqw2[n] == null);
      for (boolean bool1 = true; ; bool1 = false)
      {
        zzsk.checkState(bool1);
        break;
      }
      label438: if (m != 0)
        localArrayList.add(this.zzbjd[j]);
      j++;
    }
    System.arraycopy(arrayOfzzqw1, 0, paramArrayOfzzqw, 0, arrayOfzzqw1.length);
    this.zzbjg = new zzqk[localArrayList.size()];
    localArrayList.toArray(this.zzbjg);
    this.zzbjh = new zzpy(this.zzbjg);
    return l1;
  }

  public final void zza(zzqj paramzzqj)
  {
    int i = -1 + this.zzbjf;
    this.zzbjf = i;
    if (i > 0)
      return;
    zzqj[] arrayOfzzqj1 = this.zzbjd;
    int j = arrayOfzzqj1.length;
    int k = 0;
    int m = 0;
    while (k < j)
    {
      m += arrayOfzzqj1[k].zziz().length;
      k++;
    }
    zzra[] arrayOfzzra = new zzra[m];
    zzqj[] arrayOfzzqj2 = this.zzbjd;
    int n = arrayOfzzqj2.length;
    int i1 = 0;
    int i4;
    for (int i2 = 0; i1 < n; i2 = i4)
    {
      zzrb localzzrb = arrayOfzzqj2[i1].zziz();
      int i3 = localzzrb.length;
      i4 = i2;
      int i5 = 0;
      while (i5 < i3)
      {
        int i6 = i4 + 1;
        arrayOfzzra[i4] = localzzrb.zzbg(i5);
        i5++;
        i4 = i6;
      }
      i1++;
    }
    this.zzasa = new zzrb(arrayOfzzra);
    this.zzbik.zza(this);
  }

  public final void zza(zzqk paramzzqk, long paramLong)
  {
    this.zzbik = paramzzqk;
    this.zzbjf = this.zzbjd.length;
    zzqj[] arrayOfzzqj = this.zzbjd;
    int i = arrayOfzzqj.length;
    for (int j = 0; j < i; j++)
      arrayOfzzqj[j].zza(this, paramLong);
  }

  public final long zzdu()
  {
    zzqj[] arrayOfzzqj = this.zzbjg;
    int i = arrayOfzzqj.length;
    int j = 0;
    long l1 = 9223372036854775807L;
    while (j < i)
    {
      long l2 = arrayOfzzqj[j].zzdu();
      if (l2 != -9223372036854775808L)
        l1 = Math.min(l1, l2);
      j++;
    }
    if (l1 == 9223372036854775807L)
      l1 = -9223372036854775808L;
    return l1;
  }

  public final boolean zzel(long paramLong)
  {
    return this.zzbjh.zzel(paramLong);
  }

  public final void zzem(long paramLong)
  {
    zzqj[] arrayOfzzqj = this.zzbjg;
    int i = arrayOfzzqj.length;
    for (int j = 0; j < i; j++)
      arrayOfzzqj[j].zzem(paramLong);
  }

  public final long zzen(long paramLong)
  {
    long l = this.zzbjg[0].zzen(paramLong);
    for (int i = 1; i < this.zzbjg.length; i++)
      if (this.zzbjg[i].zzen(l) != l)
        throw new IllegalStateException("Children seeked to different positions");
    return l;
  }

  public final long zzix()
  {
    return this.zzbjh.zzix();
  }

  public final void zziy()
    throws IOException
  {
    zzqj[] arrayOfzzqj = this.zzbjd;
    int i = arrayOfzzqj.length;
    for (int j = 0; j < i; j++)
      arrayOfzzqj[j].zziy();
  }

  public final zzrb zziz()
  {
    return this.zzasa;
  }

  public final long zzja()
  {
    long l = this.zzbjd[0].zzja();
    for (int i = 1; i < this.zzbjd.length; i++)
      if (this.zzbjd[i].zzja() != -9223372036854775807L)
        throw new IllegalStateException("Child reported discontinuity");
    if (l != -9223372036854775807L)
      for (zzqj localzzqj : this.zzbjg)
        if ((localzzqj != this.zzbjd[0]) && (localzzqj.zzen(l) != l))
          throw new IllegalStateException("Children seeked to different positions");
    return l;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzqn
 * JD-Core Version:    0.6.2
 */
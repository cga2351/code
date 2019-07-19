package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class zzow
  implements zznn, zznu
{
  private static final zznq zzazt = new zzox();
  private static final int zzbfz = zzsy.zzay("qt  ");
  private long zzack;
  private final Stack<zzok> zzamj = new Stack();
  private int zzamk;
  private int zzamm;
  private long zzamn;
  private int zzamr;
  private int zzams;
  private final zzst zzbaa = new zzst(zzsq.zzaqt);
  private final zzst zzbab = new zzst(4);
  private zznp zzbbf;
  private final zzst zzbga = new zzst(16);
  private int zzbgb;
  private zzst zzbgc;
  private zzoy[] zzbgd;
  private boolean zzbge;

  private final void zzei(long paramLong)
    throws zzlm
  {
    zzok localzzok1;
    ArrayList localArrayList;
    zznr localzznr;
    zzpo localzzpo2;
    if ((!this.zzamj.isEmpty()) && (((zzok)this.zzamj.peek()).zzbdz == paramLong))
    {
      localzzok1 = (zzok)this.zzamj.pop();
      if (localzzok1.type == zzoj.zzako)
      {
        localArrayList = new ArrayList();
        localzznr = new zznr();
        zzol localzzol = localzzok1.zzay(zzoj.zzbdk);
        if (localzzol == null)
          break label479;
        localzzpo2 = zzom.zza(localzzol, this.zzbge);
        if (localzzpo2 != null)
          localzznr.zzb(localzzpo2);
      }
    }
    label479: for (zzpo localzzpo1 = localzzpo2; ; localzzpo1 = null)
    {
      int i = 0;
      long l2;
      for (long l1 = -9223372036854775807L; i < localzzok1.zzamb.size(); l1 = l2)
      {
        zzok localzzok2 = (zzok)localzzok1.zzamb.get(i);
        if (localzzok2.type == zzoj.zzakq)
        {
          zzpa localzzpa = zzom.zza(localzzok2, localzzok1.zzay(zzoj.zzakp), -9223372036854775807L, null, this.zzbge);
          if (localzzpa != null)
          {
            zzpc localzzpc = zzom.zza(localzzpa, localzzok2.zzaz(zzoj.zzakr).zzaz(zzoj.zzaks).zzaz(zzoj.zzakt), localzznr);
            if (localzzpc.zzand != 0)
            {
              zzoy localzzoy = new zzoy(localzzpa, localzzpc, this.zzbbf.zzd(i, localzzpa.type));
              int j = 30 + localzzpc.zzbet;
              zzlh localzzlh = localzzpa.zzaue.zzae(j);
              if (localzzpa.type == 1)
              {
                if (localzznr.zzii())
                  localzzlh = localzzlh.zzc(localzznr.zzaty, localzznr.zzatz);
                if (localzzpo1 != null)
                  localzzlh = localzzlh.zza(localzzpo1);
              }
              localzzoy.zzbgh.zze(localzzlh);
              l1 = Math.max(l1, localzzpa.zzack);
              localArrayList.add(localzzoy);
            }
          }
        }
        l2 = l1;
        i++;
      }
      this.zzack = l1;
      this.zzbgd = ((zzoy[])localArrayList.toArray(new zzoy[localArrayList.size()]));
      this.zzbbf.zzfi();
      this.zzbbf.zza(this);
      this.zzamj.clear();
      this.zzamk = 2;
      break;
      if (this.zzamj.isEmpty())
        break;
      ((zzok)this.zzamj.peek()).zzamb.add(localzzok1);
      break;
      if (this.zzamk != 2)
        zzip();
      return;
    }
  }

  private final void zzip()
  {
    this.zzamk = 0;
    this.zzbgb = 0;
  }

  public final long getDurationUs()
  {
    return this.zzack;
  }

  public final void release()
  {
  }

  public final int zza(zzno paramzzno, zznt paramzznt)
    throws IOException, InterruptedException
  {
    int i12;
    do
      switch (this.zzamk)
      {
      default:
        throw new IllegalStateException();
      case 0:
        if (this.zzbgb != 0)
          break label113;
        if (paramzzno.zza(this.zzbga.data, 0, 8, true))
          break label77;
        i12 = 0;
      case 1:
      case 2:
      }
    while (i12 != 0);
    return -1;
    label77: this.zzbgb = 8;
    this.zzbga.setPosition(0);
    this.zzamn = this.zzbga.zzge();
    this.zzamm = this.zzbga.readInt();
    label113: if (this.zzamn == 1L)
    {
      paramzzno.readFully(this.zzbga.data, 8, 8);
      this.zzbgb = (8 + this.zzbgb);
      this.zzamn = this.zzbga.zzgh();
    }
    int i8 = this.zzamm;
    int i9;
    if ((i8 == zzoj.zzako) || (i8 == zzoj.zzakq) || (i8 == zzoj.zzakr) || (i8 == zzoj.zzaks) || (i8 == zzoj.zzakt) || (i8 == zzoj.zzbcy))
    {
      i9 = 1;
      label218: if (i9 == 0)
        break label301;
      long l7 = paramzzno.getPosition() + this.zzamn - this.zzbgb;
      this.zzamj.add(new zzok(this.zzamm, l7));
      if (this.zzamn != this.zzbgb)
        break label294;
      zzei(l7);
    }
    while (true)
    {
      i12 = 1;
      break;
      i9 = 0;
      break label218;
      label294: zzip();
      continue;
      label301: int i10 = this.zzamm;
      int i11;
      label438: boolean bool2;
      if ((i10 == zzoj.zzakz) || (i10 == zzoj.zzakp) || (i10 == zzoj.zzala) || (i10 == zzoj.zzalb) || (i10 == zzoj.zzals) || (i10 == zzoj.zzalt) || (i10 == zzoj.zzalu) || (i10 == zzoj.zzbcz) || (i10 == zzoj.zzalv) || (i10 == zzoj.zzalw) || (i10 == zzoj.zzbdd) || (i10 == zzoj.zzalx) || (i10 == zzoj.zzaly) || (i10 == zzoj.zzaky) || (i10 == zzoj.zzajz) || (i10 == zzoj.zzbdk))
      {
        i11 = 1;
        if (i11 == 0)
          break label542;
        if (this.zzbgb != 8)
          break label530;
        bool2 = true;
        label455: zzsk.checkState(bool2);
        if (this.zzamn > 2147483647L)
          break label536;
      }
      label530: label536: for (boolean bool3 = true; ; bool3 = false)
      {
        zzsk.checkState(bool3);
        this.zzbgc = new zzst((int)this.zzamn);
        System.arraycopy(this.zzbga.data, 0, this.zzbgc.data, 0, 8);
        this.zzamk = 1;
        break;
        i11 = 0;
        break label438;
        bool2 = false;
        break label455;
      }
      label542: this.zzbgc = null;
      this.zzamk = 1;
    }
    long l5 = this.zzamn - this.zzbgb;
    long l6 = l5 + paramzzno.getPosition();
    zzst localzzst;
    boolean bool1;
    label642: int i6;
    if (this.zzbgc != null)
    {
      paramzzno.readFully(this.zzbgc.data, this.zzbgb, (int)l5);
      if (this.zzamm == zzoj.zzajz)
      {
        localzzst = this.zzbgc;
        localzzst.setPosition(8);
        if (localzzst.readInt() == zzbfz)
        {
          bool1 = true;
          this.zzbge = bool1;
          i6 = 0;
        }
      }
    }
    while (true)
    {
      label651: zzei(l6);
      if ((i6 != 0) && (this.zzamk != 2));
      for (int i7 = 1; i7 != 0; i7 = 0)
      {
        return 1;
        localzzst.zzac(4);
        while (true)
          if (localzzst.zzjz() > 0)
            if (localzzst.readInt() == zzbfz)
            {
              bool1 = true;
              break;
            }
        bool1 = false;
        break label642;
        if (this.zzamj.isEmpty())
          break label1344;
        zzok localzzok = (zzok)this.zzamj.peek();
        zzol localzzol = new zzol(this.zzamm, this.zzbgc);
        localzzok.zzama.add(localzzol);
        i6 = 0;
        break label651;
        if (l5 < 262144L)
        {
          paramzzno.zzr((int)l5);
          i6 = 0;
          break label651;
        }
        paramzznt.zzahv = (l5 + paramzzno.getPosition());
        i6 = 1;
        break label651;
      }
      int i = -1;
      long l1 = 9223372036854775807L;
      for (int j = 0; j < this.zzbgd.length; j++)
      {
        zzoy localzzoy2 = this.zzbgd[j];
        int i5 = localzzoy2.zzamy;
        if (i5 != localzzoy2.zzbgg.zzand)
        {
          long l4 = localzzoy2.zzbgg.zzahq[i5];
          if (l4 < l1)
          {
            l1 = l4;
            i = j;
          }
        }
      }
      if (i == -1)
        return -1;
      zzoy localzzoy1 = this.zzbgd[i];
      zznw localzznw = localzzoy1.zzbgh;
      int k = localzzoy1.zzamy;
      long l2 = localzzoy1.zzbgg.zzahq[k];
      int m = localzzoy1.zzbgg.zzahp[k];
      if (localzzoy1.zzbgf.zzbgk == 1)
      {
        l2 += 8L;
        m -= 8;
      }
      long l3 = l2 - paramzzno.getPosition() + this.zzamr;
      if ((l3 < 0L) || (l3 >= 262144L))
      {
        paramzznt.zzahv = l2;
        return 1;
      }
      paramzzno.zzr((int)l3);
      if (localzzoy1.zzbgf.zzamf != 0)
      {
        byte[] arrayOfByte = this.zzbab.data;
        arrayOfByte[0] = 0;
        arrayOfByte[1] = 0;
        arrayOfByte[2] = 0;
        int i2 = localzzoy1.zzbgf.zzamf;
        int i3 = 4 - localzzoy1.zzbgf.zzamf;
        while (this.zzamr < m)
          if (this.zzams == 0)
          {
            paramzzno.readFully(this.zzbab.data, i3, i2);
            this.zzbab.setPosition(0);
            this.zzams = this.zzbab.zzgg();
            this.zzbaa.setPosition(0);
            localzznw.zza(this.zzbaa, 4);
            this.zzamr = (4 + this.zzamr);
            m += i3;
          }
          else
          {
            int i4 = localzznw.zza(paramzzno, this.zzams, false);
            this.zzamr = (i4 + this.zzamr);
            this.zzams -= i4;
          }
      }
      for (int n = m; ; n = m)
      {
        localzznw.zza(localzzoy1.zzbgg.zzane[k], localzzoy1.zzbgg.zzajr[k], n, 0, null);
        localzzoy1.zzamy = (1 + localzzoy1.zzamy);
        this.zzamr = 0;
        this.zzams = 0;
        return 0;
        while (this.zzamr < m)
        {
          int i1 = localzznw.zza(paramzzno, m - this.zzamr, false);
          this.zzamr = (i1 + this.zzamr);
          this.zzams -= i1;
        }
      }
      label1344: i6 = 0;
    }
  }

  public final void zza(zznp paramzznp)
  {
    this.zzbbf = paramzznp;
  }

  public final boolean zza(zzno paramzzno)
    throws IOException, InterruptedException
  {
    return zzoz.zzd(paramzzno);
  }

  public final void zzd(long paramLong1, long paramLong2)
  {
    this.zzamj.clear();
    this.zzbgb = 0;
    this.zzamr = 0;
    this.zzams = 0;
    if (paramLong1 == 0L)
      zzip();
    while (true)
    {
      return;
      if (this.zzbgd != null)
        for (zzoy localzzoy : this.zzbgd)
        {
          zzpc localzzpc = localzzoy.zzbgg;
          int k = localzzpc.zzej(paramLong2);
          if (k == -1)
            k = localzzpc.zzek(paramLong2);
          localzzoy.zzamy = k;
        }
    }
  }

  public final long zzdq(long paramLong)
  {
    long l1 = 9223372036854775807L;
    zzoy[] arrayOfzzoy = this.zzbgd;
    int i = arrayOfzzoy.length;
    int j = 0;
    long l2;
    if (j < i)
    {
      zzpc localzzpc = arrayOfzzoy[j].zzbgg;
      int k = localzzpc.zzej(paramLong);
      if (k == -1)
        k = localzzpc.zzek(paramLong);
      l2 = localzzpc.zzahq[k];
      if (l2 >= l1)
        break label85;
    }
    while (true)
    {
      j++;
      l1 = l2;
      break;
      return l1;
      label85: l2 = l1;
    }
  }

  public final boolean zzfc()
  {
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzow
 * JD-Core Version:    0.6.2
 */
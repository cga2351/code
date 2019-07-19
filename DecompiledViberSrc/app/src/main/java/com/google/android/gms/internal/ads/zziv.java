package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class zziv
  implements zzid, zzio
{
  private final zzkm zzamg = new zzkm(zzkj.zzaqt);
  private final zzkm zzamh = new zzkm(4);
  private final zzkm zzami = new zzkm(16);
  private final Stack<zzir> zzamj = new Stack();
  private int zzamk = 0;
  private long zzaml;
  private int zzamm;
  private long zzamn;
  private int zzamo;
  private zzkm zzamp;
  private int zzamq;
  private int zzamr;
  private int zzams;
  private zzif zzamt;
  private zziw[] zzamu;

  public final int zza(zzie paramzzie, zzij paramzzij)
    throws IOException, InterruptedException
  {
    int i59;
    int i58;
    do
      switch (this.zzamk)
      {
      default:
        i59 = -1;
        long l5 = 9223372036854775807L;
        for (int i60 = 0; i60 < this.zzamu.length; i60++)
        {
          zziw localzziw3 = this.zzamu[i60];
          int i66 = localzziw3.zzamy;
          if (i66 != localzziw3.zzamw.zzand)
          {
            long l8 = localzziw3.zzamw.zzahq[i66];
            if (l8 < l5)
            {
              l5 = l8;
              i59 = i60;
            }
          }
        }
      case 0:
        if (paramzzie.zza(this.zzami.data, 0, 8, true))
          break label143;
        i58 = 0;
      case 1:
      }
    while (i58 != 0);
    return -1;
    label143: this.zzami.setPosition(0);
    this.zzamn = this.zzami.zzge();
    this.zzamm = this.zzami.readInt();
    label228: int i55;
    if (this.zzamn == 1L)
    {
      paramzzie.readFully(this.zzami.data, 8, 8);
      this.zzamn = this.zzami.readLong();
      this.zzaml = (16L + this.zzaml);
      this.zzamo = 16;
      int i54 = this.zzamm;
      if ((i54 != zziq.zzako) && (i54 != zziq.zzakq) && (i54 != zziq.zzakr) && (i54 != zziq.zzaks) && (i54 != zziq.zzakt))
        break label357;
      i55 = 1;
      label277: if (i55 == 0)
        break label400;
      if (this.zzamn != 1L)
        break label363;
      this.zzamj.add(new zzir(this.zzamm, this.zzaml + this.zzamn - this.zzamo));
      label325: this.zzamk = 0;
    }
    while (true)
    {
      i58 = 1;
      break;
      this.zzaml = (8L + this.zzaml);
      this.zzamo = 8;
      break label228;
      label357: i55 = 0;
      break label277;
      label363: this.zzamj.add(new zzir(this.zzamm, this.zzaml + this.zzamn - this.zzamo));
      break label325;
      label400: int i56 = this.zzamm;
      int i57;
      if ((i56 == zziq.zzakz) || (i56 == zziq.zzakp) || (i56 == zziq.zzala) || (i56 == zziq.zzalp) || (i56 == zziq.zzalq) || (i56 == zziq.zzalb) || (i56 == zziq.zzaka) || (i56 == zziq.zzaku) || (i56 == zziq.zzake) || (i56 == zziq.zzakc) || (i56 == zziq.zzals) || (i56 == zziq.zzalt) || (i56 == zziq.zzalu) || (i56 == zziq.zzalv) || (i56 == zziq.zzalw) || (i56 == zziq.zzalx) || (i56 == zziq.zzaly) || (i56 == zziq.zzaky))
      {
        i57 = 1;
        label553: if (i57 == 0)
          break label634;
        if (this.zzamn >= 2147483647L)
          break label628;
      }
      label628: for (boolean bool6 = true; ; bool6 = false)
      {
        zzkh.checkState(bool6);
        this.zzamp = new zzkm((int)this.zzamn);
        System.arraycopy(this.zzami.data, 0, this.zzamp.data, 0, 8);
        this.zzamk = 1;
        break;
        i57 = 0;
        break label553;
      }
      label634: this.zzamp = null;
      this.zzamk = 1;
    }
    this.zzamk = 0;
    this.zzaml += this.zzamn - this.zzamo;
    long l1 = this.zzamn - this.zzamo;
    int i;
    label727: zzir localzzir1;
    ArrayList localArrayList;
    int j;
    zzix localzzix;
    zzkm localzzkm1;
    zzis localzzis1;
    zzkm localzzkm2;
    zzkm localzzkm3;
    zzkm localzzkm4;
    zzkm localzzkm5;
    label993: zzkm localzzkm6;
    label1015: int k;
    int m;
    int[] arrayOfInt1;
    long[] arrayOfLong1;
    long[] arrayOfLong2;
    int[] arrayOfInt2;
    int n;
    int i1;
    if ((this.zzamp == null) && ((this.zzamn >= 262144L) || (this.zzamn > 2147483647L)))
    {
      i = 1;
      if (i == 0)
        break label1127;
      paramzzij.zzahv = this.zzaml;
      if ((this.zzamj.isEmpty()) || (((zzir)this.zzamj.peek()).zzalz != this.zzaml))
        break label2156;
      localzzir1 = (zzir)this.zzamj.pop();
      if (localzzir1.type != zziq.zzako)
        break label2122;
      localArrayList = new ArrayList();
      j = 0;
      if (j >= localzzir1.zzamb.size())
        break label2077;
      zzir localzzir2 = (zzir)localzzir1.zzamb.get(j);
      if (localzzir2.type != zziq.zzakq)
        break label2041;
      localzzix = zzit.zza(localzzir2, localzzir1.zzv(zziq.zzakp));
      if ((localzzix == null) || ((localzzix.type != 1936684398) && (localzzix.type != 1986618469)))
        break label2041;
      zzir localzzir3 = localzzir2.zzw(zziq.zzakr).zzw(zziq.zzaks).zzw(zziq.zzakt);
      localzzkm1 = localzzir3.zzv(zziq.zzalw).zzamc;
      localzzis1 = localzzir3.zzv(zziq.zzalx);
      if (localzzis1 == null)
        localzzis1 = localzzir3.zzv(zziq.zzaly);
      localzzkm2 = localzzis1.zzamc;
      localzzkm3 = localzzir3.zzv(zziq.zzalv).zzamc;
      localzzkm4 = localzzir3.zzv(zziq.zzals).zzamc;
      zzis localzzis2 = localzzir3.zzv(zziq.zzalt);
      if (localzzis2 == null)
        break label1219;
      localzzkm5 = localzzis2.zzamc;
      zzis localzzis3 = localzzir3.zzv(zziq.zzalu);
      if (localzzis3 == null)
        break label1225;
      localzzkm6 = localzzis3.zzamc;
      localzzkm1.setPosition(12);
      k = localzzkm1.zzgg();
      m = localzzkm1.zzgg();
      arrayOfInt1 = new int[m];
      arrayOfLong1 = new long[m];
      arrayOfLong2 = new long[m];
      arrayOfInt2 = new int[m];
      localzzkm2.setPosition(12);
      n = localzzkm2.zzgg();
      localzzkm3.setPosition(12);
      i1 = -1 + localzzkm3.zzgg();
      if (localzzkm3.readInt() != 1)
        break label1231;
    }
    label1219: label1225: label1231: for (int i2 = 1; ; i2 = 0)
    {
      if (i2 != 0)
        break label1237;
      throw new IllegalStateException(String.valueOf("stsc first chunk must be 1"));
      i = 0;
      break;
      label1127: if (this.zzamp != null)
      {
        paramzzie.readFully(this.zzamp.data, this.zzamo, (int)l1);
        if (this.zzamj.isEmpty())
          break label727;
        zzir localzzir4 = (zzir)this.zzamj.peek();
        zzis localzzis4 = new zzis(this.zzamm, this.zzamp);
        localzzir4.zzama.add(localzzis4);
        break label727;
      }
      paramzzie.zzr((int)l1);
      break label727;
      localzzkm5 = null;
      break label993;
      localzzkm6 = null;
      break label1015;
    }
    label1237: int i3 = localzzkm3.zzgg();
    localzzkm3.zzac(4);
    int i4 = -1;
    if (i1 > 0)
      i4 = -1 + localzzkm3.zzgg();
    localzzkm4.setPosition(12);
    int i5 = -1 + localzzkm4.zzgg();
    int i6 = localzzkm4.zzgg();
    int i7 = localzzkm4.zzgg();
    int i8 = 0;
    int i9 = 0;
    int i10 = 0;
    if (localzzkm6 != null)
    {
      localzzkm6.setPosition(12);
      i9 = -1 + localzzkm6.zzgg();
      i10 = localzzkm6.zzgg();
      i8 = localzzkm6.readInt();
    }
    int i11 = -1;
    int i12 = 0;
    if (localzzkm5 != null)
    {
      localzzkm5.setPosition(12);
      i12 = localzzkm5.zzgg();
      i11 = -1 + localzzkm5.zzgg();
    }
    long l2;
    label1393: long l3;
    int i13;
    int i14;
    int i15;
    int i16;
    int i17;
    int i18;
    int i19;
    int i20;
    int i21;
    long l4;
    int i22;
    int i23;
    int i24;
    int i25;
    int i26;
    label1454: int i27;
    label1480: int i28;
    label1506: int i52;
    int i29;
    int i30;
    if (localzzis1.type == zziq.zzalx)
    {
      l2 = localzzkm2.zzge();
      l3 = 0L;
      i13 = i6;
      i14 = i3;
      i15 = i12;
      i16 = i3;
      i17 = i1;
      i18 = 0;
      i19 = i4;
      i20 = i5;
      i21 = i11;
      l4 = l2;
      i22 = 0;
      i23 = i8;
      i24 = i9;
      i25 = i10;
      i26 = i7;
      if (i18 >= m)
        break label1889;
      arrayOfLong2[i18] = l4;
      if (k != 0)
        break label1832;
      i27 = localzzkm1.zzgg();
      arrayOfInt1[i18] = i27;
      arrayOfLong1[i18] = (l3 + i23);
      if (localzzkm5 != null)
        break label1839;
      i28 = 1;
      arrayOfInt2[i18] = i28;
      if (i18 != i21)
        break label2672;
      arrayOfInt2[i18] = 1;
      i52 = i15 - 1;
      if (i52 <= 0)
        break label2661;
      int i53 = -1 + localzzkm5.zzgg();
      i29 = i52;
      i30 = i53;
    }
    while (true)
    {
      l3 += i26;
      int i31 = i13 - 1;
      int i50;
      int i32;
      int i33;
      if ((i31 == 0) && (i20 > 0))
      {
        int i49 = localzzkm4.zzgg();
        i50 = localzzkm4.zzgg();
        int i51 = i20 - 1;
        i32 = i49;
        i33 = i51;
      }
      for (int i34 = i50; ; i34 = i26)
      {
        int i45;
        int i37;
        int i35;
        int i36;
        if (localzzkm6 != null)
        {
          i45 = i25 - 1;
          if ((i45 == 0) && (i24 > 0))
          {
            int i46 = localzzkm6.zzgg();
            int i47 = localzzkm6.readInt();
            int i48 = i24 - 1;
            i37 = i47;
            i35 = i46;
            i36 = i48;
          }
        }
        while (true)
        {
          int i38 = i14 - 1;
          int i44;
          label1705: int i39;
          int i43;
          if (i38 == 0)
          {
            i44 = i22 + 1;
            if (i44 < n)
            {
              if (localzzis1.type == zziq.zzalx)
                l4 = localzzkm2.zzge();
            }
            else
            {
              if (i44 != i19)
                break label2605;
              i39 = localzzkm3.zzgg();
              localzzkm3.zzac(4);
              i43 = i17 - 1;
              if (i43 > 0)
                i19 = -1 + localzzkm3.zzgg();
            }
          }
          while (true)
          {
            int i40;
            int i41;
            int i42;
            if (i44 < n)
            {
              i40 = i44;
              i41 = i19;
              i42 = i39;
            }
            while (true)
            {
              i18++;
              i13 = i32;
              i14 = i39;
              i15 = i29;
              i17 = i43;
              i16 = i42;
              i19 = i41;
              i22 = i40;
              i23 = i37;
              i24 = i36;
              i25 = i35;
              i26 = i34;
              i20 = i33;
              i21 = i30;
              break label1454;
              l2 = localzzkm2.zzgh();
              break label1393;
              label1832: i27 = k;
              break label1480;
              label1839: i28 = 0;
              break label1506;
              l4 = localzzkm2.zzgh();
              break label1705;
              l4 += arrayOfInt1[i18];
              i39 = i38;
              i40 = i22;
              i41 = i19;
              i42 = i16;
              i43 = i17;
              continue;
              label1889: zzkq.zza(arrayOfLong1, 1000000L, localzzix.zzcs);
              boolean bool1;
              label1910: boolean bool2;
              label1923: boolean bool3;
              label1936: boolean bool4;
              if (i15 == 0)
              {
                bool1 = true;
                zzkh.checkArgument(bool1);
                if (i13 != 0)
                  break label2053;
                bool2 = true;
                zzkh.checkArgument(bool2);
                if (i14 != 0)
                  break label2059;
                bool3 = true;
                zzkh.checkArgument(bool3);
                if (i20 != 0)
                  break label2065;
                bool4 = true;
                label1949: zzkh.checkArgument(bool4);
                if (i24 != 0)
                  break label2071;
              }
              label2053: label2059: label2065: label2071: for (boolean bool5 = true; ; bool5 = false)
              {
                zzkh.checkArgument(bool5);
                zziz localzziz = new zziz(arrayOfLong2, arrayOfInt1, arrayOfLong1, arrayOfInt2);
                if (localzziz.zzand != 0)
                {
                  zziw localzziw1 = new zziw(localzzix, localzziz, this.zzamt.zzs(j));
                  localzziw1.zzamx.zza(localzzix.zzame);
                  localArrayList.add(localzziw1);
                }
                label2041: j++;
                break;
                bool1 = false;
                break label1910;
                bool2 = false;
                break label1923;
                bool3 = false;
                break label1936;
                bool4 = false;
                break label1949;
              }
              label2077: this.zzamu = ((zziw[])localArrayList.toArray(new zziw[0]));
              this.zzamt.zzfi();
              this.zzamt.zza(this);
              this.zzamk = 2;
              break label727;
              label2122: if (this.zzamj.isEmpty())
                break label727;
              ((zzir)this.zzamj.peek()).zzamb.add(localzzir1);
              break label727;
              label2156: if (i == 0)
                break;
              return 1;
              if (i59 == -1)
                return -1;
              zziw localzziw2 = this.zzamu[i59];
              int i61 = localzziw2.zzamy;
              long l6 = localzziw2.zzamw.zzahq[i61];
              long l7 = l6 - paramzzie.getPosition() + this.zzamr;
              if ((l7 < 0L) || (l7 >= 262144L))
              {
                paramzzij.zzahv = l6;
                return 1;
              }
              paramzzie.zzr((int)l7);
              this.zzamq = localzziw2.zzamw.zzahp[i61];
              if (localzziw2.zzamv.zzamf != -1)
              {
                byte[] arrayOfByte = this.zzamh.data;
                arrayOfByte[0] = 0;
                arrayOfByte[1] = 0;
                arrayOfByte[2] = 0;
                int i63 = localzziw2.zzamv.zzamf;
                int i64 = 4 - localzziw2.zzamv.zzamf;
                while (this.zzamr < this.zzamq)
                  if (this.zzams == 0)
                  {
                    paramzzie.readFully(this.zzamh.data, i64, i63);
                    this.zzamh.setPosition(0);
                    this.zzams = this.zzamh.zzgg();
                    this.zzamg.setPosition(0);
                    localzziw2.zzamx.zza(this.zzamg, 4);
                    this.zzamr = (4 + this.zzamr);
                    this.zzamq = (i64 + this.zzamq);
                  }
                  else
                  {
                    int i65 = localzziw2.zzamx.zza(paramzzie, this.zzams);
                    this.zzamr = (i65 + this.zzamr);
                    this.zzams -= i65;
                  }
              }
              while (this.zzamr < this.zzamq)
              {
                int i62 = localzziw2.zzamx.zza(paramzzie, this.zzamq - this.zzamr);
                this.zzamr = (i62 + this.zzamr);
                this.zzams -= i62;
              }
              localzziw2.zzamx.zza(localzziw2.zzamw.zzane[i61], localzziw2.zzamw.zzajr[i61], this.zzamq, 0, null);
              localzziw2.zzamy = (1 + localzziw2.zzamy);
              this.zzamr = 0;
              this.zzams = 0;
              return 0;
              i40 = i44;
              i41 = i19;
              i42 = i39;
              i39 = i38;
            }
            label2605: i39 = i16;
            i43 = i17;
          }
          i36 = i24;
          i35 = i45;
          i37 = i23;
          continue;
          i35 = i25;
          i36 = i24;
          i37 = i23;
        }
        i32 = i31;
        i33 = i20;
      }
      label2661: i29 = i52;
      i30 = i21;
      continue;
      label2672: i29 = i15;
      i30 = i21;
    }
  }

  public final void zza(zzif paramzzif)
  {
    this.zzamt = paramzzif;
  }

  public final long zzdq(long paramLong)
  {
    long l1 = 9223372036854775807L;
    int i = 0;
    if (i < this.zzamu.length)
    {
      zziz localzziz = this.zzamu[i].zzamw;
      int j = zzkq.zza(localzziz.zzane, paramLong, true, false);
      label42: if (j >= 0)
        if ((localzziz.zzane[j] <= paramLong) && ((0x1 & localzziz.zzajr[j]) != 0))
          label73: if (j == -1)
          {
            j = zzkq.zzb(localzziz.zzane, paramLong, true, false);
            label92: if (j >= localzziz.zzane.length)
              break label193;
            if ((localzziz.zzane[j] < paramLong) || ((0x1 & localzziz.zzajr[j]) == 0))
              break label187;
          }
      while (true)
      {
        this.zzamu[i].zzamy = j;
        long l2 = localzziz.zzahq[this.zzamu[i].zzamy];
        if (l2 < l1)
          l1 = l2;
        i++;
        break;
        j--;
        break label42;
        j = -1;
        break label73;
        label187: j++;
        break label92;
        label193: j = -1;
      }
    }
    return l1;
  }

  public final boolean zzfc()
  {
    return true;
  }

  public final void zzfh()
  {
    this.zzaml = 0L;
    this.zzamr = 0;
    this.zzams = 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zziv
 * JD-Core Version:    0.6.2
 */
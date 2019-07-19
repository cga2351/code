package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;

final class zzik
{
  private final zzjl zzajg;
  private final int zzajh;
  private final zzim zzaji;
  private final LinkedBlockingDeque<zzjk> zzajj;
  private final zzin zzajk;
  private final zzkm zzajl;
  private long zzajm;
  private long zzajn;
  private zzjk zzajo;
  private int zzajp;

  public zzik(zzjl paramzzjl)
  {
    this.zzajg = paramzzjl;
    this.zzajh = paramzzjl.zzfz();
    this.zzaji = new zzim();
    this.zzajj = new LinkedBlockingDeque();
    this.zzajk = new zzin(null);
    this.zzajl = new zzkm(32);
    this.zzajp = this.zzajh;
  }

  private final void zza(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      zzdu(paramLong);
      int j = (int)(paramLong - this.zzajm);
      int k = Math.min(paramInt - i, this.zzajh - j);
      System.arraycopy(((zzjk)this.zzajj.peek()).data, j + 0, paramArrayOfByte, i, k);
      paramLong += k;
      i += k;
    }
  }

  private final void zzdu(long paramLong)
  {
    int i = (int)(paramLong - this.zzajm) / this.zzajh;
    for (int j = 0; j < i; j++)
    {
      this.zzajg.zza((zzjk)this.zzajj.remove());
      this.zzajm += this.zzajh;
    }
  }

  private final void zzfu()
  {
    if (this.zzajp == this.zzajh)
    {
      this.zzajp = 0;
      this.zzajo = this.zzajg.zzfy();
      this.zzajj.add(this.zzajo);
    }
  }

  public final void clear()
  {
    this.zzaji.clear();
    while (!this.zzajj.isEmpty())
      this.zzajg.zza((zzjk)this.zzajj.remove());
    this.zzajm = 0L;
    this.zzajn = 0L;
    this.zzajo = null;
    this.zzajp = this.zzajh;
  }

  public final void zza(long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte)
  {
    this.zzaji.zza(paramLong1, paramInt1, paramLong2, paramInt2, paramArrayOfByte);
  }

  public final int zzb(zzie paramzzie, int paramInt)
    throws IOException, InterruptedException
  {
    zzfu();
    int i = Math.min(paramInt, this.zzajh - this.zzajp);
    byte[] arrayOfByte = this.zzajo.data;
    paramzzie.readFully(arrayOfByte, 0 + this.zzajp, i);
    this.zzajp = (i + this.zzajp);
    this.zzajn += i;
    return i;
  }

  public final void zzb(zzkm paramzzkm, int paramInt)
  {
    int i = paramInt;
    while (i > 0)
    {
      zzfu();
      int j = Math.min(i, this.zzajh - this.zzajp);
      byte[] arrayOfByte = this.zzajo.data;
      paramzzkm.zzb(arrayOfByte, 0 + this.zzajp, j);
      this.zzajp = (j + this.zzajp);
      i -= j;
    }
    this.zzajn += paramInt;
  }

  public final boolean zzb(zzhm paramzzhm)
  {
    return this.zzaji.zza(paramzzhm, this.zzajk);
  }

  public final boolean zzc(zzhm paramzzhm)
  {
    int i = 0;
    if (!this.zzaji.zza(paramzzhm, this.zzajk))
      return false;
    if (paramzzhm.zzeo())
    {
      zzin localzzin = this.zzajk;
      long l2 = localzzin.zzajx;
      zza(l2, this.zzajl.data, 1);
      long l3 = 1L + l2;
      int n = this.zzajl.data[0];
      int i1;
      long l4;
      long l6;
      int i3;
      if ((n & 0x80) != 0)
      {
        i1 = 1;
        int i2 = n & 0x7F;
        if (paramzzhm.zzafz.iv == null)
          paramzzhm.zzafz.iv = new byte[16];
        zza(l3, paramzzhm.zzafz.iv, i2);
        l4 = l3 + i2;
        if (i1 == 0)
          break label347;
        zza(l4, this.zzajl.data, 2);
        l6 = l4 + 2L;
        this.zzajl.setPosition(0);
        i3 = this.zzajl.readUnsignedShort();
      }
      int[] arrayOfInt1;
      int[] arrayOfInt2;
      for (long l5 = l6; ; l5 = l4)
      {
        arrayOfInt1 = paramzzhm.zzafz.numBytesOfClearData;
        if ((arrayOfInt1 == null) || (arrayOfInt1.length < i3))
          arrayOfInt1 = new int[i3];
        arrayOfInt2 = paramzzhm.zzafz.numBytesOfEncryptedData;
        if ((arrayOfInt2 == null) || (arrayOfInt2.length < i3))
          arrayOfInt2 = new int[i3];
        if (i1 == 0)
          break label357;
        int i5 = i3 * 6;
        zzkm localzzkm = this.zzajl;
        if (localzzkm.limit() < i5)
          localzzkm.zzb(new byte[i5], i5);
        zza(l5, this.zzajl.data, i5);
        l5 += i5;
        this.zzajl.setPosition(0);
        while (i < i3)
        {
          arrayOfInt1[i] = this.zzajl.readUnsignedShort();
          arrayOfInt2[i] = this.zzajl.zzgg();
          i++;
        }
        i1 = 0;
        break;
        label347: i3 = 1;
      }
      label357: arrayOfInt1[0] = 0;
      arrayOfInt2[0] = (paramzzhm.size - (int)(l5 - localzzin.zzajx));
      paramzzhm.zzafz.set(i3, arrayOfInt1, arrayOfInt2, localzzin.zzajy, paramzzhm.zzafz.iv, 1);
      int i4 = (int)(l5 - localzzin.zzajx);
      localzzin.zzajx += i4;
      paramzzhm.size -= i4;
    }
    if (((paramzzhm.zzde != null) && (paramzzhm.zzde.capacity() >= paramzzhm.size)) || (paramzzhm.zzde != null))
    {
      long l1 = this.zzajk.zzajx;
      ByteBuffer localByteBuffer = paramzzhm.zzde;
      int j = paramzzhm.size;
      while (j > 0)
      {
        zzdu(l1);
        int k = (int)(l1 - this.zzajm);
        int m = Math.min(j, this.zzajh - k);
        localByteBuffer.put(((zzjk)this.zzajj.peek()).data, k + 0, m);
        l1 += m;
        j -= m;
      }
    }
    zzdu(this.zzaji.zzfv());
    return true;
  }

  public final boolean zzds(long paramLong)
  {
    long l = this.zzaji.zzdv(paramLong);
    if (l == -1L)
      return false;
    zzdu(l);
    return true;
  }

  public final void zzfs()
  {
    zzdu(this.zzaji.zzfv());
  }

  public final long zzft()
  {
    return this.zzajn;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzik
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzqt
  implements zznw
{
  private final int zzajh;
  private long zzajn;
  private int zzajp;
  private final zzst zzbac;
  private final zzrt zzbic;
  private final zzqr zzbke;
  private final zzqs zzbkf;
  private final AtomicInteger zzbkg;
  private zzqu zzbkh;
  private zzqu zzbki;
  private zzlh zzbkj;
  private boolean zzbkk;
  private zzlh zzbkl;
  private zzqv zzbkm;

  public zzqt(zzrt paramzzrt)
  {
    this.zzbic = paramzzrt;
    this.zzajh = paramzzrt.zzfz();
    this.zzbke = new zzqr();
    this.zzbkf = new zzqs();
    this.zzbac = new zzst(32);
    this.zzbkg = new AtomicInteger();
    this.zzajp = this.zzajh;
    this.zzbkh = new zzqu(0L, this.zzajh);
    this.zzbki = this.zzbkh;
  }

  private final void zza(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    zzdu(paramLong);
    while (i < paramInt)
    {
      int j = (int)(paramLong - this.zzbkh.zzbkn);
      int k = Math.min(paramInt - i, this.zzajh - j);
      zzrs localzzrs = this.zzbkh.zzbkp;
      System.arraycopy(localzzrs.data, localzzrs.zzbj(j), paramArrayOfByte, i, k);
      paramLong += k;
      i += k;
      if (paramLong == this.zzbkh.zzbdz)
      {
        this.zzbic.zza(localzzrs);
        this.zzbkh = this.zzbkh.zzjq();
      }
    }
  }

  private final int zzbe(int paramInt)
  {
    if (this.zzajp == this.zzajh)
    {
      this.zzajp = 0;
      if (this.zzbki.zzbko)
        this.zzbki = this.zzbki.zzbkq;
      zzqu localzzqu1 = this.zzbki;
      zzrs localzzrs = this.zzbic.zzjt();
      zzqu localzzqu2 = new zzqu(this.zzbki.zzbdz, this.zzajh);
      localzzqu1.zzbkp = localzzrs;
      localzzqu1.zzbkq = localzzqu2;
      localzzqu1.zzbko = true;
    }
    return Math.min(paramInt, this.zzajh - this.zzajp);
  }

  private final void zzdu(long paramLong)
  {
    while (paramLong >= this.zzbkh.zzbdz)
    {
      this.zzbic.zza(this.zzbkh.zzbkp);
      this.zzbkh = this.zzbkh.zzjq();
    }
  }

  private final void zzjh()
  {
    int i = 0;
    this.zzbke.zzjh();
    zzqu localzzqu1 = this.zzbkh;
    if (localzzqu1.zzbko)
    {
      if (this.zzbki.zzbko);
      zzrs[] arrayOfzzrs;
      for (int j = 1; ; j = 0)
      {
        arrayOfzzrs = new zzrs[j + (int)(this.zzbki.zzbkn - localzzqu1.zzbkn) / this.zzajh];
        zzqu localzzqu2 = localzzqu1;
        while (i < arrayOfzzrs.length)
        {
          arrayOfzzrs[i] = localzzqu2.zzbkp;
          localzzqu2 = localzzqu2.zzjq();
          i++;
        }
      }
      this.zzbic.zza(arrayOfzzrs);
    }
    this.zzbkh = new zzqu(0L, this.zzajh);
    this.zzbki = this.zzbkh;
    this.zzajn = 0L;
    this.zzajp = this.zzajh;
    this.zzbic.zzn();
  }

  private final boolean zzjo()
  {
    return this.zzbkg.compareAndSet(0, 1);
  }

  private final void zzjp()
  {
    if (!this.zzbkg.compareAndSet(1, 0))
      zzjh();
  }

  public final void disable()
  {
    if (this.zzbkg.getAndSet(2) == 0)
      zzjh();
  }

  public final int zza(zzlj paramzzlj, zznd paramzznd, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    switch (this.zzbke.zza(paramzzlj, paramzznd, paramBoolean1, paramBoolean2, this.zzbkj, this.zzbkf))
    {
    default:
      throw new IllegalStateException();
    case -5:
      this.zzbkj = paramzzlj.zzaue;
      return -5;
    case -4:
      if (!paramzznd.zzic())
      {
        if (paramzznd.zzaga < paramLong)
          paramzznd.zzal(-2147483648);
        zzqs localzzqs;
        int i2;
        long l5;
        int[] arrayOfInt1;
        int[] arrayOfInt2;
        long l7;
        if (paramzznd.zzeo())
        {
          localzzqs = this.zzbkf;
          long l2 = localzzqs.zzajx;
          this.zzbac.reset(1);
          zza(l2, this.zzbac.data, 1);
          long l3 = 1L + l2;
          int m = this.zzbac.data[0];
          int n;
          long l4;
          long l8;
          if ((m & 0x80) != 0)
          {
            n = 1;
            int i1 = m & 0x7F;
            if (paramzznd.zzaze.iv == null)
              paramzznd.zzaze.iv = new byte[16];
            zza(l3, paramzznd.zzaze.iv, i1);
            l4 = l3 + i1;
            if (n == 0)
              break label414;
            this.zzbac.reset(2);
            zza(l4, this.zzbac.data, 2);
            l8 = l4 + 2L;
            i2 = this.zzbac.readUnsignedShort();
          }
          for (l5 = l8; ; l5 = l4)
          {
            arrayOfInt1 = paramzznd.zzaze.numBytesOfClearData;
            if ((arrayOfInt1 == null) || (arrayOfInt1.length < i2))
              arrayOfInt1 = new int[i2];
            arrayOfInt2 = paramzznd.zzaze.numBytesOfEncryptedData;
            if ((arrayOfInt2 == null) || (arrayOfInt2.length < i2))
              arrayOfInt2 = new int[i2];
            if (n == 0)
              break label658;
            int i4 = i2 * 6;
            this.zzbac.reset(i4);
            zza(l5, this.zzbac.data, i4);
            l7 = l5 + i4;
            this.zzbac.setPosition(0);
            for (int i5 = 0; i5 < i2; i5++)
            {
              arrayOfInt1[i5] = this.zzbac.readUnsignedShort();
              arrayOfInt2[i5] = this.zzbac.zzgg();
            }
            n = 0;
            break;
            label414: i2 = 1;
          }
        }
        for (long l6 = l7; ; l6 = l5)
        {
          zznx localzznx = localzzqs.zzbbj;
          paramzznd.zzaze.set(i2, arrayOfInt1, arrayOfInt2, localzznx.zzazq, paramzznd.zzaze.iv, localzznx.zzazp);
          int i3 = (int)(l6 - localzzqs.zzajx);
          localzzqs.zzajx += i3;
          localzzqs.size -= i3;
          paramzznd.zzan(this.zzbkf.size);
          long l1 = this.zzbkf.zzajx;
          ByteBuffer localByteBuffer = paramzznd.zzde;
          int i = this.zzbkf.size;
          zzdu(l1);
          while (i > 0)
          {
            int j = (int)(l1 - this.zzbkh.zzbkn);
            int k = Math.min(i, this.zzajh - j);
            zzrs localzzrs = this.zzbkh.zzbkp;
            localByteBuffer.put(localzzrs.data, localzzrs.zzbj(j), k);
            l1 += k;
            i -= k;
            if (l1 == this.zzbkh.zzbdz)
            {
              this.zzbic.zza(localzzrs);
              this.zzbkh = this.zzbkh.zzjq();
            }
          }
          label658: arrayOfInt1[0] = 0;
          arrayOfInt2[0] = (localzzqs.size - (int)(l5 - localzzqs.zzajx));
        }
        zzdu(this.zzbkf.zzbkd);
      }
      return -4;
    case -3:
    }
    return -3;
  }

  public final int zza(zzno paramzzno, int paramInt, boolean paramBoolean)
    throws IOException, InterruptedException
  {
    int j;
    if (!zzjo())
    {
      j = paramzzno.zzaq(paramInt);
      if (j == -1)
        throw new EOFException();
    }
    else
    {
      try
      {
        int i = zzbe(paramInt);
        zzrs localzzrs = this.zzbki.zzbkp;
        j = paramzzno.read(localzzrs.data, localzzrs.zzbj(this.zzajp), i);
        if (j == -1)
          throw new EOFException();
      }
      finally
      {
        zzjp();
      }
      this.zzajp = (j + this.zzajp);
      this.zzajn += j;
      zzjp();
    }
    return j;
  }

  public final void zza(long paramLong, int paramInt1, int paramInt2, int paramInt3, zznx paramzznx)
  {
    if (!zzjo())
    {
      this.zzbke.zzep(paramLong);
      return;
    }
    try
    {
      long l = this.zzajn - paramInt2;
      this.zzbke.zza(paramLong, paramInt1, l, paramInt2, paramzznx);
      return;
    }
    finally
    {
      zzjp();
    }
  }

  public final void zza(zzqv paramzzqv)
  {
    this.zzbkm = paramzzqv;
  }

  public final void zza(zzst paramzzst, int paramInt)
  {
    if (!zzjo())
    {
      paramzzst.zzac(paramInt);
      return;
    }
    while (paramInt > 0)
    {
      int i = zzbe(paramInt);
      zzrs localzzrs = this.zzbki.zzbkp;
      paramzzst.zzb(localzzrs.data, localzzrs.zzbj(this.zzajp), i);
      this.zzajp = (i + this.zzajp);
      this.zzajn += i;
      paramInt -= i;
    }
    zzjp();
  }

  public final void zze(zzlh paramzzlh)
  {
    zzlh localzzlh;
    if (paramzzlh == null)
      localzzlh = null;
    while (true)
    {
      boolean bool = this.zzbke.zzg(localzzlh);
      this.zzbkl = paramzzlh;
      this.zzbkk = false;
      if ((this.zzbkm != null) && (bool))
        this.zzbkm.zzf(localzzlh);
      return;
      if ((0L != 0L) && (paramzzlh.zzaua != 9223372036854775807L))
        localzzlh = paramzzlh.zzed(paramzzlh.zzaua);
      else
        localzzlh = paramzzlh;
    }
  }

  public final boolean zzh(long paramLong, boolean paramBoolean)
  {
    long l = this.zzbke.zzg(paramLong, paramBoolean);
    if (l == -1L)
      return false;
    zzdu(l);
    return true;
  }

  public final long zzje()
  {
    return this.zzbke.zzje();
  }

  public final int zzjj()
  {
    return this.zzbke.zzjj();
  }

  public final boolean zzjk()
  {
    return this.zzbke.zzjk();
  }

  public final zzlh zzjl()
  {
    return this.zzbke.zzjl();
  }

  public final void zzjn()
  {
    long l = this.zzbke.zzjm();
    if (l != -1L)
      zzdu(l);
  }

  public final void zzk(boolean paramBoolean)
  {
    AtomicInteger localAtomicInteger = this.zzbkg;
    if (paramBoolean);
    for (int i = 0; ; i = 2)
    {
      int j = localAtomicInteger.getAndSet(i);
      zzjh();
      this.zzbke.zzji();
      if (j == 2)
        this.zzbkj = null;
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzqt
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

final class zzts extends zztq
{
  private final byte[] buffer;
  private int limit;
  private int pos;
  private final boolean zzbuf;
  private int zzbug;
  private int zzbuh;
  private int zzbui;
  private int zzbuj = 2147483647;

  private zzts(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(null);
    this.buffer = paramArrayOfByte;
    this.limit = (paramInt1 + paramInt2);
    this.pos = paramInt1;
    this.zzbuh = this.pos;
    this.zzbuf = paramBoolean;
  }

  private final int zzvb()
    throws IOException
  {
    int i = this.pos;
    byte[] arrayOfByte;
    int m;
    int n;
    int i6;
    if (this.limit != i)
    {
      arrayOfByte = this.buffer;
      int j = i + 1;
      int k = arrayOfByte[i];
      if (k >= 0)
      {
        this.pos = j;
        return k;
      }
      if (this.limit - j >= 9)
      {
        m = j + 1;
        n = k ^ arrayOfByte[j] << 7;
        if (n < 0)
          i6 = n ^ 0xFFFFFF80;
      }
    }
    while (true)
    {
      this.pos = m;
      return i6;
      int i1 = m + 1;
      int i2 = n ^ arrayOfByte[m] << 14;
      if (i2 >= 0)
      {
        i6 = i2 ^ 0x3F80;
        m = i1;
      }
      else
      {
        m = i1 + 1;
        int i3 = i2 ^ arrayOfByte[i1] << 21;
        if (i3 < 0)
        {
          i6 = i3 ^ 0xFFE03F80;
        }
        else
        {
          int i4 = m + 1;
          int i5 = arrayOfByte[m];
          i6 = 0xFE03F80 ^ (i3 ^ i5 << 28);
          if (i5 < 0)
          {
            m = i4 + 1;
            if (arrayOfByte[i4] < 0)
            {
              i4 = m + 1;
              if (arrayOfByte[m] < 0)
              {
                m = i4 + 1;
                if (arrayOfByte[i4] >= 0)
                  continue;
                i4 = m + 1;
                if (arrayOfByte[m] < 0)
                {
                  m = i4 + 1;
                  if (arrayOfByte[i4] >= 0)
                    continue;
                  return (int)zzuy();
                }
              }
            }
          }
          else
          {
            m = i4;
          }
        }
      }
    }
  }

  private final long zzvc()
    throws IOException
  {
    int i = this.pos;
    byte[] arrayOfByte;
    int m;
    int n;
    long l6;
    if (this.limit != i)
    {
      arrayOfByte = this.buffer;
      int j = i + 1;
      int k = arrayOfByte[i];
      if (k >= 0)
      {
        this.pos = j;
        return k;
      }
      if (this.limit - j >= 9)
      {
        m = j + 1;
        n = k ^ arrayOfByte[j] << 7;
        if (n < 0)
          l6 = n ^ 0xFFFFFF80;
      }
    }
    while (true)
    {
      this.pos = m;
      return l6;
      int i1 = m + 1;
      int i2 = n ^ arrayOfByte[m] << 14;
      if (i2 >= 0)
      {
        l6 = i2 ^ 0x3F80;
        m = i1;
      }
      else
      {
        m = i1 + 1;
        int i3 = i2 ^ arrayOfByte[i1] << 21;
        if (i3 < 0)
        {
          l6 = i3 ^ 0xFFE03F80;
        }
        else
        {
          long l1 = i3;
          int i4 = m + 1;
          long l2 = l1 ^ arrayOfByte[m] << 28;
          if (l2 >= 0L)
          {
            l6 = l2 ^ 0xFE03F80;
            m = i4;
          }
          else
          {
            m = i4 + 1;
            long l3 = l2 ^ arrayOfByte[i4] << 35;
            if (l3 < 0L)
            {
              l6 = l3 ^ 0xFE03F80;
            }
            else
            {
              int i5 = m + 1;
              long l4 = l3 ^ arrayOfByte[m] << 42;
              if (l4 >= 0L)
              {
                l6 = l4 ^ 0xFE03F80;
                m = i5;
              }
              else
              {
                m = i5 + 1;
                long l5 = l4 ^ arrayOfByte[i5] << 49;
                if (l5 < 0L)
                {
                  l6 = l5 ^ 0xFE03F80;
                }
                else
                {
                  int i6 = m + 1;
                  l6 = 0xFE03F80 ^ (l5 ^ arrayOfByte[m] << 56);
                  if (l6 < 0L)
                  {
                    m = i6 + 1;
                    if (arrayOfByte[i6] < 0L)
                      return zzuy();
                  }
                  else
                  {
                    m = i6;
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  private final int zzvd()
    throws IOException
  {
    int i = this.pos;
    if (this.limit - i < 4)
      throw zzuv.zzwq();
    byte[] arrayOfByte = this.buffer;
    this.pos = (i + 4);
    return 0xFF & arrayOfByte[i] | (0xFF & arrayOfByte[(i + 1)]) << 8 | (0xFF & arrayOfByte[(i + 2)]) << 16 | (0xFF & arrayOfByte[(i + 3)]) << 24;
  }

  private final long zzve()
    throws IOException
  {
    int i = this.pos;
    if (this.limit - i < 8)
      throw zzuv.zzwq();
    byte[] arrayOfByte = this.buffer;
    this.pos = (i + 8);
    return 0xFF & arrayOfByte[i] | (0xFF & arrayOfByte[(i + 1)]) << 8 | (0xFF & arrayOfByte[(i + 2)]) << 16 | (0xFF & arrayOfByte[(i + 3)]) << 24 | (0xFF & arrayOfByte[(i + 4)]) << 32 | (0xFF & arrayOfByte[(i + 5)]) << 40 | (0xFF & arrayOfByte[(i + 6)]) << 48 | (0xFF & arrayOfByte[(i + 7)]) << 56;
  }

  private final void zzvf()
  {
    this.limit += this.zzbug;
    int i = this.limit - this.zzbuh;
    if (i > this.zzbuj)
    {
      this.zzbug = (i - this.zzbuj);
      this.limit -= this.zzbug;
      return;
    }
    this.zzbug = 0;
  }

  private final byte zzvg()
    throws IOException
  {
    if (this.pos == this.limit)
      throw zzuv.zzwq();
    byte[] arrayOfByte = this.buffer;
    int i = this.pos;
    this.pos = (i + 1);
    return arrayOfByte[i];
  }

  public final double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(zzve());
  }

  public final float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(zzvd());
  }

  public final String readString()
    throws IOException
  {
    int i = zzvb();
    if ((i > 0) && (i <= this.limit - this.pos))
    {
      String str = new String(this.buffer, this.pos, i, zzuq.UTF_8);
      this.pos = (i + this.pos);
      return str;
    }
    if (i == 0)
      return "";
    if (i < 0)
      throw zzuv.zzwr();
    throw zzuv.zzwq();
  }

  public final <T extends zzvv> T zza(zzwf<T> paramzzwf, zzub paramzzub)
    throws IOException
  {
    int i = zzvb();
    if (this.zzbua >= this.zzbub)
      throw zzuv.zzwv();
    int j = zzas(i);
    this.zzbua = (1 + this.zzbua);
    zzvv localzzvv = (zzvv)paramzzwf.zza(this, paramzzub);
    zzap(0);
    this.zzbua = (-1 + this.zzbua);
    zzat(j);
    return localzzvv;
  }

  public final void zzap(int paramInt)
    throws zzuv
  {
    if (this.zzbui != paramInt)
      throw zzuv.zzwt();
  }

  public final boolean zzaq(int paramInt)
    throws IOException
  {
    switch (paramInt & 0x7)
    {
    default:
      throw zzuv.zzwu();
    case 0:
      int j = this.limit - this.pos;
      int k = 0;
      if (j >= 10)
      {
        while (k < 10)
        {
          byte[] arrayOfByte = this.buffer;
          int m = this.pos;
          this.pos = (m + 1);
          if (arrayOfByte[m] >= 0)
            break label142;
          k++;
        }
        throw zzuv.zzws();
      }
      while (k < 10)
      {
        if (zzvg() >= 0)
          break label142;
        k++;
      }
      throw zzuv.zzws();
    case 1:
      zzau(8);
      return true;
    case 2:
      zzau(zzvb());
      return true;
    case 3:
      int i;
      do
        i = zzuj();
      while ((i != 0) && (zzaq(i)));
      zzap(0x4 | paramInt >>> 3 << 3);
      return true;
    case 4:
      label142: return false;
    case 5:
    }
    zzau(4);
    return true;
  }

  public final int zzas(int paramInt)
    throws zzuv
  {
    if (paramInt < 0)
      throw zzuv.zzwr();
    int i = paramInt + zzva();
    int j = this.zzbuj;
    if (i > j)
      throw zzuv.zzwq();
    this.zzbuj = i;
    zzvf();
    return j;
  }

  public final void zzat(int paramInt)
  {
    this.zzbuj = paramInt;
    zzvf();
  }

  public final void zzau(int paramInt)
    throws IOException
  {
    if ((paramInt >= 0) && (paramInt <= this.limit - this.pos))
    {
      this.pos = (paramInt + this.pos);
      return;
    }
    if (paramInt < 0)
      throw zzuv.zzwr();
    throw zzuv.zzwq();
  }

  public final int zzuj()
    throws IOException
  {
    if (zzuz())
    {
      this.zzbui = 0;
      return 0;
    }
    this.zzbui = zzvb();
    if (this.zzbui >>> 3 == 0)
      throw new zzuv("Protocol message contained an invalid tag (zero).");
    return this.zzbui;
  }

  public final long zzuk()
    throws IOException
  {
    return zzvc();
  }

  public final long zzul()
    throws IOException
  {
    return zzvc();
  }

  public final int zzum()
    throws IOException
  {
    return zzvb();
  }

  public final long zzun()
    throws IOException
  {
    return zzve();
  }

  public final int zzuo()
    throws IOException
  {
    return zzvd();
  }

  public final boolean zzup()
    throws IOException
  {
    return zzvc() != 0L;
  }

  public final String zzuq()
    throws IOException
  {
    int i = zzvb();
    if ((i > 0) && (i <= this.limit - this.pos))
    {
      String str = zzxl.zzh(this.buffer, this.pos, i);
      this.pos = (i + this.pos);
      return str;
    }
    if (i == 0)
      return "";
    if (i <= 0)
      throw zzuv.zzwr();
    throw zzuv.zzwq();
  }

  public final zzte zzur()
    throws IOException
  {
    int i = zzvb();
    if ((i > 0) && (i <= this.limit - this.pos))
    {
      zzte localzzte = zzte.zzb(this.buffer, this.pos, i);
      this.pos = (i + this.pos);
      return localzzte;
    }
    if (i == 0)
      return zzte.zzbts;
    int j;
    if ((i > 0) && (i <= this.limit - this.pos))
    {
      j = this.pos;
      this.pos = (i + this.pos);
    }
    for (byte[] arrayOfByte = Arrays.copyOfRange(this.buffer, j, this.pos); ; arrayOfByte = zzuq.zzbzc)
    {
      return zzte.zzi(arrayOfByte);
      if (i > 0)
        break label126;
      if (i != 0)
        break;
    }
    throw zzuv.zzwr();
    label126: throw zzuv.zzwq();
  }

  public final int zzus()
    throws IOException
  {
    return zzvb();
  }

  public final int zzut()
    throws IOException
  {
    return zzvb();
  }

  public final int zzuu()
    throws IOException
  {
    return zzvd();
  }

  public final long zzuv()
    throws IOException
  {
    return zzve();
  }

  public final int zzuw()
    throws IOException
  {
    int i = zzvb();
    return i >>> 1 ^ -(i & 0x1);
  }

  public final long zzux()
    throws IOException
  {
    long l = zzvc();
    return l >>> 1 ^ -(l & 1L);
  }

  final long zzuy()
    throws IOException
  {
    long l = 0L;
    for (int i = 0; i < 64; i += 7)
    {
      int j = zzvg();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
        return l;
    }
    throw zzuv.zzws();
  }

  public final boolean zzuz()
    throws IOException
  {
    return this.pos == this.limit;
  }

  public final int zzva()
  {
    return this.pos - this.zzbuh;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzts
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

final class zzdne extends zzdnc
{
  private final byte[] buffer;
  private int limit;
  private int pos;
  private final boolean zzhde;
  private int zzhdf;
  private int zzhdg;
  private int zzhdh;
  private int zzhdi = 2147483647;

  private zzdne(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(null);
    this.buffer = paramArrayOfByte;
    this.limit = (paramInt1 + paramInt2);
    this.pos = paramInt1;
    this.zzhdg = this.pos;
    this.zzhde = paramBoolean;
  }

  private final int zzawm()
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
                  return (int)zzawj();
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

  private final long zzawn()
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
                      return zzawj();
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

  private final int zzawo()
    throws IOException
  {
    int i = this.pos;
    if (this.limit - i < 4)
      throw zzdoj.zzayd();
    byte[] arrayOfByte = this.buffer;
    this.pos = (i + 4);
    return 0xFF & arrayOfByte[i] | (0xFF & arrayOfByte[(i + 1)]) << 8 | (0xFF & arrayOfByte[(i + 2)]) << 16 | (0xFF & arrayOfByte[(i + 3)]) << 24;
  }

  private final long zzawp()
    throws IOException
  {
    int i = this.pos;
    if (this.limit - i < 8)
      throw zzdoj.zzayd();
    byte[] arrayOfByte = this.buffer;
    this.pos = (i + 8);
    return 0xFF & arrayOfByte[i] | (0xFF & arrayOfByte[(i + 1)]) << 8 | (0xFF & arrayOfByte[(i + 2)]) << 16 | (0xFF & arrayOfByte[(i + 3)]) << 24 | (0xFF & arrayOfByte[(i + 4)]) << 32 | (0xFF & arrayOfByte[(i + 5)]) << 40 | (0xFF & arrayOfByte[(i + 6)]) << 48 | (0xFF & arrayOfByte[(i + 7)]) << 56;
  }

  private final void zzawq()
  {
    this.limit += this.zzhdf;
    int i = this.limit - this.zzhdg;
    if (i > this.zzhdi)
    {
      this.zzhdf = (i - this.zzhdi);
      this.limit -= this.zzhdf;
      return;
    }
    this.zzhdf = 0;
  }

  private final byte zzawr()
    throws IOException
  {
    if (this.pos == this.limit)
      throw zzdoj.zzayd();
    byte[] arrayOfByte = this.buffer;
    int i = this.pos;
    this.pos = (i + 1);
    return arrayOfByte[i];
  }

  private final void zzfu(int paramInt)
    throws IOException
  {
    if ((paramInt >= 0) && (paramInt <= this.limit - this.pos))
    {
      this.pos = (paramInt + this.pos);
      return;
    }
    if (paramInt < 0)
      throw zzdoj.zzaye();
    throw zzdoj.zzayd();
  }

  public final double readDouble()
    throws IOException
  {
    return Double.longBitsToDouble(zzawp());
  }

  public final float readFloat()
    throws IOException
  {
    return Float.intBitsToFloat(zzawo());
  }

  public final String readString()
    throws IOException
  {
    int i = zzawm();
    if ((i > 0) && (i <= this.limit - this.pos))
    {
      String str = new String(this.buffer, this.pos, i, zzdoc.UTF_8);
      this.pos = (i + this.pos);
      return str;
    }
    if (i == 0)
      return "";
    if (i < 0)
      throw zzdoj.zzaye();
    throw zzdoj.zzayd();
  }

  public final int zzavu()
    throws IOException
  {
    if (zzawk())
    {
      this.zzhdh = 0;
      return 0;
    }
    this.zzhdh = zzawm();
    if (this.zzhdh >>> 3 == 0)
      throw zzdoj.zzayg();
    return this.zzhdh;
  }

  public final long zzavv()
    throws IOException
  {
    return zzawn();
  }

  public final long zzavw()
    throws IOException
  {
    return zzawn();
  }

  public final int zzavx()
    throws IOException
  {
    return zzawm();
  }

  public final long zzavy()
    throws IOException
  {
    return zzawp();
  }

  public final int zzavz()
    throws IOException
  {
    return zzawo();
  }

  public final boolean zzawa()
    throws IOException
  {
    return zzawn() != 0L;
  }

  public final String zzawb()
    throws IOException
  {
    int i = zzawm();
    if ((i > 0) && (i <= this.limit - this.pos))
    {
      String str = zzdra.zzn(this.buffer, this.pos, i);
      this.pos = (i + this.pos);
      return str;
    }
    if (i == 0)
      return "";
    if (i <= 0)
      throw zzdoj.zzaye();
    throw zzdoj.zzayd();
  }

  public final zzdmq zzawc()
    throws IOException
  {
    int i = zzawm();
    if ((i > 0) && (i <= this.limit - this.pos))
    {
      zzdmq localzzdmq = zzdmq.zzi(this.buffer, this.pos, i);
      this.pos = (i + this.pos);
      return localzzdmq;
    }
    if (i == 0)
      return zzdmq.zzhcr;
    int j;
    if ((i > 0) && (i <= this.limit - this.pos))
    {
      j = this.pos;
      this.pos = (i + this.pos);
    }
    for (byte[] arrayOfByte = Arrays.copyOfRange(this.buffer, j, this.pos); ; arrayOfByte = zzdoc.zzhia)
    {
      return zzdmq.zzaa(arrayOfByte);
      if (i > 0)
        break label126;
      if (i != 0)
        break;
    }
    throw zzdoj.zzaye();
    label126: throw zzdoj.zzayd();
  }

  public final int zzawd()
    throws IOException
  {
    return zzawm();
  }

  public final int zzawe()
    throws IOException
  {
    return zzawm();
  }

  public final int zzawf()
    throws IOException
  {
    return zzawo();
  }

  public final long zzawg()
    throws IOException
  {
    return zzawp();
  }

  public final int zzawh()
    throws IOException
  {
    return zzft(zzawm());
  }

  public final long zzawi()
    throws IOException
  {
    return zzfi(zzawn());
  }

  final long zzawj()
    throws IOException
  {
    long l = 0L;
    for (int i = 0; i < 64; i += 7)
    {
      int j = zzawr();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
        return l;
    }
    throw zzdoj.zzayf();
  }

  public final boolean zzawk()
    throws IOException
  {
    return this.pos == this.limit;
  }

  public final int zzawl()
  {
    return this.pos - this.zzhdg;
  }

  public final void zzfp(int paramInt)
    throws zzdoj
  {
    if (this.zzhdh != paramInt)
      throw zzdoj.zzayh();
  }

  public final boolean zzfq(int paramInt)
    throws IOException
  {
    switch (paramInt & 0x7)
    {
    default:
      throw zzdoj.zzayi();
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
        throw zzdoj.zzayf();
      }
      while (k < 10)
      {
        if (zzawr() >= 0)
          break label142;
        k++;
      }
      throw zzdoj.zzayf();
    case 1:
      zzfu(8);
      return true;
    case 2:
      zzfu(zzawm());
      return true;
    case 3:
      int i;
      do
        i = zzavu();
      while ((i != 0) && (zzfq(i)));
      zzfp(0x4 | paramInt >>> 3 << 3);
      return true;
    case 4:
      label142: return false;
    case 5:
    }
    zzfu(4);
    return true;
  }

  public final int zzfr(int paramInt)
    throws zzdoj
  {
    if (paramInt < 0)
      throw zzdoj.zzaye();
    int i = paramInt + zzawl();
    int j = this.zzhdi;
    if (i > j)
      throw zzdoj.zzayd();
    this.zzhdi = i;
    zzawq();
    return j;
  }

  public final void zzfs(int paramInt)
  {
    this.zzhdi = paramInt;
    zzawq();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdne
 * JD-Core Version:    0.6.2
 */
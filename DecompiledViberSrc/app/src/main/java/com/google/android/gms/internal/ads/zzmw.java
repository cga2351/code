package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

final class zzmw
{
  private final int zzafv;
  private float zzauh;
  private float zzaui;
  private final int zzaxx;
  private final int zzaxy;
  private final int zzaxz;
  private final int zzaya;
  private final short[] zzayb;
  private int zzayc;
  private short[] zzayd;
  private int zzaye;
  private short[] zzayf;
  private int zzayg;
  private short[] zzayh;
  private int zzayi;
  private int zzayj;
  private int zzayk;
  private int zzayl;
  private int zzaym;
  private int zzayn;
  private int zzayo;
  private int zzayp;
  private int zzayq;
  private int zzayr;

  public zzmw(int paramInt1, int paramInt2)
  {
    this.zzafv = paramInt1;
    this.zzaxx = paramInt2;
    this.zzaxy = (paramInt1 / 400);
    this.zzaxz = (paramInt1 / 65);
    this.zzaya = (2 * this.zzaxz);
    this.zzayb = new short[this.zzaya];
    this.zzayc = this.zzaya;
    this.zzayd = new short[paramInt2 * this.zzaya];
    this.zzaye = this.zzaya;
    this.zzayf = new short[paramInt2 * this.zzaya];
    this.zzayg = this.zzaya;
    this.zzayh = new short[paramInt2 * this.zzaya];
    this.zzayi = 0;
    this.zzayj = 0;
    this.zzayo = 0;
    this.zzauh = 1.0F;
    this.zzaui = 1.0F;
  }

  private final int zza(short[] paramArrayOfShort, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 255;
    int j = 1;
    int k = paramInt1 * this.zzaxx;
    int m = paramInt2;
    int n = 0;
    int i1 = 0;
    int i4;
    if (m <= paramInt3)
    {
      int i2 = 0;
      int i3 = 0;
      if (i2 < m)
      {
        int i6 = paramArrayOfShort[(k + i2)];
        int i7 = paramArrayOfShort[(i2 + (k + m))];
        if (i6 >= i7);
        for (int i8 = i6 - i7; ; i8 = i7 - i6)
        {
          i3 += i8;
          i2++;
          break;
        }
      }
      if (i3 * i1 < j * m)
      {
        j = i3;
        i1 = m;
      }
      if (i3 * i <= n * m)
        break label180;
      i4 = i3;
    }
    for (int i5 = m; ; i5 = i)
    {
      m++;
      n = i4;
      i = i5;
      break;
      this.zzayq = (j / i1);
      this.zzayr = (n / i);
      return i1;
      label180: i4 = n;
    }
  }

  private static void zza(int paramInt1, int paramInt2, short[] paramArrayOfShort1, int paramInt3, short[] paramArrayOfShort2, int paramInt4, short[] paramArrayOfShort3, int paramInt5)
  {
    for (int i = 0; i < paramInt2; i++)
    {
      int j = i + paramInt3 * paramInt2;
      int k = i + paramInt5 * paramInt2;
      int m = i + paramInt4 * paramInt2;
      int n = j;
      int i1 = k;
      int i2 = m;
      for (int i3 = 0; i3 < paramInt1; i3++)
      {
        paramArrayOfShort1[n] = ((short)((paramArrayOfShort2[i2] * (paramInt1 - i3) + i3 * paramArrayOfShort3[i1]) / paramInt1));
        n += paramInt2;
        i2 += paramInt2;
        i1 += paramInt2;
      }
    }
  }

  private final void zza(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    zzaj(paramInt2);
    System.arraycopy(paramArrayOfShort, paramInt1 * this.zzaxx, this.zzayf, this.zzayl * this.zzaxx, paramInt2 * this.zzaxx);
    this.zzayl = (paramInt2 + this.zzayl);
  }

  private final void zzaj(int paramInt)
  {
    if (paramInt + this.zzayl > this.zzaye)
    {
      this.zzaye += paramInt + this.zzaye / 2;
      this.zzayf = Arrays.copyOf(this.zzayf, this.zzaye * this.zzaxx);
    }
  }

  private final void zzak(int paramInt)
  {
    if (paramInt + this.zzayk > this.zzayc)
    {
      this.zzayc += paramInt + this.zzayc / 2;
      this.zzayd = Arrays.copyOf(this.zzayd, this.zzayc * this.zzaxx);
    }
  }

  private final void zzb(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    int i = this.zzaya / paramInt2;
    int j = paramInt2 * this.zzaxx;
    int k = paramInt1 * this.zzaxx;
    for (int m = 0; m < i; m++)
    {
      int n = 0;
      int i1 = 0;
      while (n < j)
      {
        i1 += paramArrayOfShort[(n + (k + m * j))];
        n++;
      }
      int i2 = i1 / j;
      this.zzayb[m] = ((short)i2);
    }
  }

  private final void zzhy()
  {
    int i = this.zzayl;
    float f1 = this.zzauh / this.zzaui;
    int i15;
    label103: int k;
    label156: int m;
    short[] arrayOfShort3;
    int i16;
    label259: int i18;
    if ((f1 > 1.00001D) || (f1 < 0.9999900000000001D))
    {
      if (this.zzayk >= this.zzaya)
      {
        int i14 = this.zzayk;
        i15 = 0;
        if (this.zzayn > 0)
        {
          int i31 = Math.min(this.zzaya, this.zzayn);
          zza(this.zzayd, i15, i31);
          this.zzayn -= i31;
          i15 += i31;
          if (i15 + this.zzaya <= i14)
            break label773;
          int i24 = this.zzayk - i15;
          System.arraycopy(this.zzayd, i15 * this.zzaxx, this.zzayd, 0, i24 * this.zzaxx);
          this.zzayk = i24;
        }
      }
      else
      {
        if (this.zzaui == 1.0F)
          break label1245;
        float f2 = this.zzaui;
        if (this.zzayl == i)
          break label1245;
        int j = (int)(this.zzafv / f2);
        k = this.zzafv;
        int n;
        for (m = j; (m > 16384) || (k > 16384); m = n)
        {
          n = m / 2;
          k /= 2;
        }
      }
      arrayOfShort3 = this.zzayd;
      if (this.zzafv > 4000)
      {
        i16 = this.zzafv / 4000;
        if ((this.zzaxx != 1) || (i16 != 1))
          break label436;
        i18 = zza(arrayOfShort3, i15, this.zzaxy, this.zzaxz);
      }
    }
    while (true)
    {
      label291: int i19 = this.zzayq;
      int i20 = this.zzayr;
      int i21;
      label318: int i22;
      label329: int i25;
      label372: int i17;
      label436: int i27;
      int i28;
      if ((i19 == 0) || (this.zzayo == 0))
      {
        i21 = 0;
        if (i21 == 0)
          break label624;
        i22 = this.zzayo;
        this.zzayp = this.zzayq;
        this.zzayo = i18;
        if (f1 <= 1.0D)
          break label654;
        short[] arrayOfShort5 = this.zzayd;
        if (f1 < 2.0F)
          break label631;
        i25 = (int)(i22 / (f1 - 1.0F));
        zzaj(i25);
        zza(i25, this.zzaxx, this.zzayf, this.zzayl, arrayOfShort5, i15, arrayOfShort5, i15 + i22);
        this.zzayl = (i25 + this.zzayl);
        i15 += i25 + i22;
        break label103;
        i16 = 1;
        break label259;
        zzb(arrayOfShort3, i15, i16);
        i17 = zza(this.zzayb, 0, this.zzaxy / i16, this.zzaxz / i16);
        if (i16 == 1)
          break label1260;
        int i26 = i17 * i16;
        i27 = i26 - (i16 << 2);
        i28 = i26 + (i16 << 2);
        if (i27 >= this.zzaxy)
          break label1253;
      }
      label654: label1184: label1245: label1253: for (int i29 = this.zzaxy; ; i29 = i27)
      {
        if (i28 > this.zzaxz);
        for (int i30 = this.zzaxz; ; i30 = i28)
        {
          if (this.zzaxx == 1)
          {
            i18 = zza(arrayOfShort3, i15, i29, i30);
            break label291;
          }
          zzb(arrayOfShort3, i15, 1);
          i18 = zza(this.zzayb, 0, i29, i30);
          break label291;
          if (i20 > i19 * 3)
          {
            i21 = 0;
            break label318;
          }
          if (i19 << 1 <= 3 * this.zzayp)
          {
            i21 = 0;
            break label318;
          }
          i21 = 1;
          break label318;
          label624: i22 = i18;
          break label329;
          label631: this.zzayn = ((int)(i22 * (2.0F - f1) / (f1 - 1.0F)));
          i25 = i22;
          break label372;
          short[] arrayOfShort4 = this.zzayd;
          if (f1 < 0.5F);
          for (int i23 = (int)(f1 * i22 / (1.0F - f1)); ; i23 = i22)
          {
            zzaj(i22 + i23);
            System.arraycopy(arrayOfShort4, i15 * this.zzaxx, this.zzayf, this.zzayl * this.zzaxx, i22 * this.zzaxx);
            zza(i23, this.zzaxx, this.zzayf, i22 + this.zzayl, arrayOfShort4, i15 + i22, arrayOfShort4, i15);
            this.zzayl += i22 + i23;
            i15 += i23;
            break label103;
            break;
            this.zzayn = ((int)(i22 * (2.0F * f1 - 1.0F) / (1.0F - f1)));
          }
          zza(this.zzayd, 0, this.zzayk);
          this.zzayk = 0;
          break label156;
          int i1 = this.zzayl - i;
          if (i1 + this.zzaym > this.zzayg)
          {
            this.zzayg += i1 + this.zzayg / 2;
            this.zzayh = Arrays.copyOf(this.zzayh, this.zzayg * this.zzaxx);
          }
          System.arraycopy(this.zzayf, i * this.zzaxx, this.zzayh, this.zzaym * this.zzaxx, i1 * this.zzaxx);
          this.zzayl = i;
          this.zzaym = (i1 + this.zzaym);
          int i2 = 0;
          if (i2 < -1 + this.zzaym)
          {
            while (m * (1 + this.zzayi) > k * this.zzayj)
            {
              zzaj(1);
              for (int i4 = 0; i4 < this.zzaxx; i4++)
              {
                short[] arrayOfShort1 = this.zzayf;
                int i5 = i4 + this.zzayl * this.zzaxx;
                short[] arrayOfShort2 = this.zzayh;
                int i6 = i4 + i2 * this.zzaxx;
                int i7 = arrayOfShort2[i6];
                int i8 = arrayOfShort2[(i6 + this.zzaxx)];
                int i9 = k * this.zzayj;
                int i10 = m * this.zzayi;
                int i11 = m * (1 + this.zzayi);
                int i12 = i11 - i9;
                int i13 = i11 - i10;
                arrayOfShort1[i5] = ((short)((i7 * i12 + i8 * (i13 - i12)) / i13));
              }
              this.zzayj = (1 + this.zzayj);
              this.zzayl = (1 + this.zzayl);
            }
            this.zzayi = (1 + this.zzayi);
            if (this.zzayi == k)
            {
              this.zzayi = 0;
              if (this.zzayj != m)
                break label1184;
            }
            for (boolean bool = true; ; bool = false)
            {
              zzsk.checkState(bool);
              this.zzayj = 0;
              i2++;
              break;
            }
          }
          int i3 = -1 + this.zzaym;
          if (i3 != 0)
          {
            System.arraycopy(this.zzayh, i3 * this.zzaxx, this.zzayh, 0, (this.zzaym - i3) * this.zzaxx);
            this.zzaym -= i3;
          }
          return;
        }
      }
      label773: label1260: i18 = i17;
    }
  }

  public final void setSpeed(float paramFloat)
  {
    this.zzauh = paramFloat;
  }

  public final void zza(float paramFloat)
  {
    this.zzaui = paramFloat;
  }

  public final void zza(ShortBuffer paramShortBuffer)
  {
    int i = paramShortBuffer.remaining() / this.zzaxx;
    int j = i * this.zzaxx << 1;
    zzak(i);
    paramShortBuffer.get(this.zzayd, this.zzayk * this.zzaxx, j / 2);
    this.zzayk = (i + this.zzayk);
    zzhy();
  }

  public final void zzb(ShortBuffer paramShortBuffer)
  {
    int i = Math.min(paramShortBuffer.remaining() / this.zzaxx, this.zzayl);
    paramShortBuffer.put(this.zzayf, 0, i * this.zzaxx);
    this.zzayl -= i;
    System.arraycopy(this.zzayf, i * this.zzaxx, this.zzayf, 0, this.zzayl * this.zzaxx);
  }

  public final void zzhl()
  {
    int i = this.zzayk;
    float f = this.zzauh / this.zzaui;
    int j = this.zzayl + (int)(0.5F + (i / f + this.zzaym) / this.zzaui);
    zzak(i + 2 * this.zzaya);
    for (int k = 0; k < 2 * this.zzaya * this.zzaxx; k++)
      this.zzayd[(k + i * this.zzaxx)] = 0;
    this.zzayk += 2 * this.zzaya;
    zzhy();
    if (this.zzayl > j)
      this.zzayl = j;
    this.zzayk = 0;
    this.zzayn = 0;
    this.zzaym = 0;
  }

  public final int zzhx()
  {
    return this.zzayl;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzmw
 * JD-Core Version:    0.6.2
 */
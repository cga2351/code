package com.google.android.gms.internal.ads;

import android.util.Log;
import java.nio.ByteBuffer;

public final class zzsq
{
  public static final byte[] zzaqt = { 0, 0, 0, 1 };
  private static final float[] zzbna = { 1.0F, 1.0F, 1.090909F, 0.9090909F, 1.454546F, 1.212121F, 2.181818F, 1.818182F, 2.909091F, 2.424243F, 1.636364F, 1.363636F, 1.939394F, 1.616162F, 1.333333F, 1.5F, 2.0F };
  private static final Object zzbnb = new Object();
  private static int[] zzbnc = new int[10];

  public static zzsr zze(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    zzsu localzzsu = new zzsu(paramArrayOfByte, paramInt1, paramInt2);
    localzzsu.zzbq(8);
    int i = localzzsu.zzbn(8);
    localzzsu.zzbq(16);
    int j = localzzsu.zzkd();
    label191: label202: boolean bool2;
    label256: label269: int m;
    if ((i == 100) || (i == 110) || (i == 122) || (i == 244) || (i == 44) || (i == 83) || (i == 86) || (i == 118) || (i == 128) || (i == 138))
    {
      int k = localzzsu.zzkd();
      boolean bool1 = false;
      if (k == 3)
        bool1 = localzzsu.zzkc();
      localzzsu.zzkd();
      localzzsu.zzkd();
      localzzsu.zzbq(1);
      if (localzzsu.zzkc())
      {
        int i23;
        if (k != 3)
          i23 = 8;
        for (int i24 = 0; ; i24++)
        {
          if (i24 >= i23)
            break label269;
          if (localzzsu.zzkc())
          {
            int i25;
            int i26;
            int i27;
            int i28;
            if (i24 < 6)
            {
              i25 = 16;
              i26 = 8;
              i27 = 8;
              i28 = 0;
              if (i28 >= i25)
                continue;
              if (i26 != 0)
                i26 = (256 + (i27 + localzzsu.zzke())) % 256;
              if (i26 != 0)
                break label256;
            }
            while (true)
            {
              i28++;
              break label202;
              i23 = 12;
              break;
              i25 = 64;
              break label191;
              i27 = i26;
            }
          }
        }
      }
      bool2 = bool1;
      m = k;
    }
    while (true)
    {
      int n = 4 + localzzsu.zzkd();
      int i1 = localzzsu.zzkd();
      boolean bool3 = false;
      int i2;
      boolean bool5;
      int i6;
      label347: int i8;
      int i9;
      int i18;
      int i22;
      label430: int i21;
      int i10;
      if (i1 == 0)
      {
        i2 = 4 + localzzsu.zzkd();
        localzzsu.zzkd();
        localzzsu.zzbq(1);
        int i4 = 1 + localzzsu.zzkd();
        int i5 = 1 + localzzsu.zzkd();
        bool5 = localzzsu.zzkc();
        if (!bool5)
          break label627;
        i6 = 1;
        int i7 = i5 * (2 - i6);
        if (!bool5)
          localzzsu.zzbq(1);
        localzzsu.zzbq(1);
        i8 = i4 << 4;
        i9 = i7 << 4;
        if (!localzzsu.zzkc())
          break label754;
        int i14 = localzzsu.zzkd();
        int i15 = localzzsu.zzkd();
        int i16 = localzzsu.zzkd();
        int i17 = localzzsu.zzkd();
        if (m != 0)
          break label639;
        i18 = 1;
        if (!bool5)
          break label633;
        i22 = 1;
        i21 = 2 - i22;
        i10 = i8 - i18 * (i14 + i15);
        i9 -= i21 * (i16 + i17);
      }
      while (true)
      {
        float f1 = 1.0F;
        int i11;
        float f2;
        if ((localzzsu.zzkc()) && (localzzsu.zzkc()))
        {
          i11 = localzzsu.zzbn(8);
          if (i11 == 255)
          {
            int i12 = localzzsu.zzbn(16);
            int i13 = localzzsu.zzbn(16);
            if ((i12 != 0) && (i13 != 0))
              f1 = i12 / i13;
            f2 = f1;
          }
        }
        while (true)
        {
          return new zzsr(j, i10, i9, f2, bool2, bool5, n, i1, i2, bool3);
          i2 = 0;
          bool3 = false;
          if (i1 != 1)
            break;
          bool3 = localzzsu.zzkc();
          localzzsu.zzke();
          localzzsu.zzke();
          long l = localzzsu.zzkd();
          for (int i3 = 0; ; i3++)
          {
            boolean bool4 = i3 < l;
            i2 = 0;
            if (!bool4)
              break;
            localzzsu.zzkd();
          }
          label627: i6 = 0;
          break label347;
          label633: i22 = 0;
          break label430;
          label639: int i19;
          if (m == 3)
          {
            i18 = 1;
            label648: if (m != 1)
              break label683;
            i19 = 2;
            label657: if (!bool5)
              break label689;
          }
          label683: label689: for (int i20 = 1; ; i20 = 0)
          {
            i21 = i19 * (2 - i20);
            break;
            i18 = 2;
            break label648;
            i19 = 1;
            break label657;
          }
          if (i11 < zzbna.length)
          {
            f2 = zzbna[i11];
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder(46);
            Log.w("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + i11);
            f2 = f1;
          }
        }
        label754: i10 = i8;
      }
      m = 1;
      bool2 = false;
    }
  }

  public static void zzk(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    int j = 0;
    int k = 0;
    while (j + 1 < i)
    {
      int m = 0xFF & paramByteBuffer.get(j);
      if (k == 3)
      {
        if ((m == 1) && ((0x1F & paramByteBuffer.get(j + 1)) == 7))
        {
          ByteBuffer localByteBuffer = paramByteBuffer.duplicate();
          localByteBuffer.position(j - 3);
          localByteBuffer.limit(i);
          paramByteBuffer.position(0);
          paramByteBuffer.put(localByteBuffer);
        }
      }
      else if (m == 0)
        k++;
      if (m != 0)
        k = 0;
      j++;
    }
    paramByteBuffer.clear();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzsq
 * JD-Core Version:    0.6.2
 */
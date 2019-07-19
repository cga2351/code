package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import java.nio.ByteBuffer;

public final class a
{
  private static final int[] a = { 1, 2, 3, 6 };
  private static final int[] b = { 48000, 44100, 32000 };
  private static final int[] c = { 24000, 22050, 16000 };
  private static final int[] d = { 2, 1, 2, 3, 3, 4, 4, 5 };
  private static final int[] e = { 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640 };
  private static final int[] f = { 69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393 };

  public static int a()
  {
    return 1536;
  }

  private static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt2 / 2;
    if ((paramInt1 < 0) || (paramInt1 >= b.length) || (paramInt2 < 0) || (i >= f.length))
      return -1;
    int j = b[paramInt1];
    if (j == 44100)
      return 2 * (f[i] + paramInt2 % 2);
    int k = e[i];
    if (j == 32000)
      return k * 6;
    return k * 4;
  }

  public static int a(ByteBuffer paramByteBuffer)
  {
    if ((0xC0 & paramByteBuffer.get(4 + paramByteBuffer.position())) >> 6 == 3);
    for (int i = 6; ; i = a[((0x30 & paramByteBuffer.get(4 + paramByteBuffer.position())) >> 4)])
      return i * 256;
  }

  public static int a(ByteBuffer paramByteBuffer, int paramInt)
  {
    int i;
    int j;
    if ((0xFF & paramByteBuffer.get(7 + (paramInt + paramByteBuffer.position()))) == 187)
    {
      i = 1;
      j = paramInt + paramByteBuffer.position();
      if (i == 0)
        break label62;
    }
    label62: for (int k = 9; ; k = 8)
    {
      return 40 << (0x7 & paramByteBuffer.get(k + j) >> 4);
      i = 0;
      break;
    }
  }

  public static int a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 6)
      return -1;
    if ((0xFF & paramArrayOfByte[5]) >> 3 == 16);
    for (int i = 1; i != 0; i = 0)
      return 2 * (1 + ((0x7 & paramArrayOfByte[2]) << 8 | 0xFF & paramArrayOfByte[3]));
    return a((0xC0 & paramArrayOfByte[4]) >> 6, 0x3F & paramArrayOfByte[4]);
  }

  public static Format a(r paramr, String paramString1, String paramString2, DrmInitData paramDrmInitData)
  {
    int i = (0xC0 & paramr.h()) >> 6;
    int j = b[i];
    int k = paramr.h();
    int m = d[((k & 0x38) >> 3)];
    if ((k & 0x4) != 0)
      m++;
    return Format.createAudioSampleFormat(paramString1, "audio/ac3", null, -1, -1, m, j, null, paramDrmInitData, 0, paramString2);
  }

  public static a a(q paramq)
  {
    int i = paramq.b();
    paramq.b(40);
    int j;
    int k;
    int i7;
    label75: int i8;
    int i9;
    int i11;
    int i10;
    label123: int i12;
    int i14;
    label160: int i15;
    int i17;
    if (paramq.c(5) == 16)
    {
      j = 1;
      paramq.a(i);
      k = -1;
      if (j == 0)
        break label896;
      paramq.b(16);
      switch (paramq.c(2))
      {
      default:
        i7 = -1;
        paramq.b(3);
        n = 2 * (1 + paramq.c(11));
        i8 = paramq.c(2);
        if (i8 == 3)
        {
          i9 = 3;
          i11 = c[paramq.c(2)];
          i10 = 6;
          i3 = i10 * 256;
          i12 = paramq.c(3);
          boolean bool2 = paramq.e();
          int i13 = d[i12];
          if (!bool2)
            break label651;
          i14 = 1;
          i15 = i14 + i13;
          paramq.b(10);
          if (paramq.e())
            paramq.b(8);
          if (i12 == 0)
          {
            paramq.b(5);
            if (paramq.e())
              paramq.b(8);
          }
          if ((i7 == 1) && (paramq.e()))
            paramq.b(16);
          if (paramq.e())
          {
            if (i12 > 2)
              paramq.b(2);
            if (((i12 & 0x1) != 0) && (i12 > 2))
              paramq.b(6);
            if ((i12 & 0x4) != 0)
              paramq.b(6);
            if ((bool2) && (paramq.e()))
              paramq.b(5);
            if (i7 == 0)
            {
              if (paramq.e())
                paramq.b(6);
              if ((i12 == 0) && (paramq.e()))
                paramq.b(6);
              if (paramq.e())
                paramq.b(6);
              i17 = paramq.c(2);
              if (i17 != 1)
                break label657;
              paramq.b(5);
              label362: if (i12 < 2)
              {
                if (paramq.e())
                  paramq.b(14);
                if ((i12 == 0) && (paramq.e()))
                  paramq.b(14);
              }
              if (paramq.e())
              {
                if (i9 != 0)
                  break label868;
                paramq.b(5);
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      }
    }
    int i6;
    while (true)
    {
      if (paramq.e())
      {
        paramq.b(5);
        if (i12 == 2)
          paramq.b(4);
        if (i12 >= 6)
          paramq.b(2);
        if (paramq.e())
          paramq.b(8);
        if ((i12 == 0) && (paramq.e()))
          paramq.b(8);
        if (i8 < 3)
          paramq.d();
      }
      if ((i7 == 0) && (i9 != 3))
        paramq.d();
      if ((i7 == 2) && ((i9 == 3) || (paramq.e())))
        paramq.b(6);
      str = "audio/eac3";
      if ((paramq.e()) && (paramq.c(6) == 1) && (paramq.c(8) == 1))
        str = "audio/eac3-joc";
      k = i7;
      int i16 = i11;
      i6 = i15;
      i2 = i16;
      return new a(str, k, i6, i2, n, i3, null);
      j = 0;
      break;
      i7 = 0;
      break label75;
      i7 = 1;
      break label75;
      i7 = 2;
      break label75;
      i9 = paramq.c(2);
      i10 = a[i9];
      i11 = b[i8];
      break label123;
      label651: i14 = 0;
      break label160;
      label657: if (i17 == 2)
      {
        paramq.b(12);
        break label362;
      }
      if (i17 != 3)
        break label362;
      int i18 = paramq.c(5);
      if (paramq.e())
      {
        paramq.b(5);
        if (paramq.e())
          paramq.b(4);
        if (paramq.e())
          paramq.b(4);
        if (paramq.e())
          paramq.b(4);
        if (paramq.e())
          paramq.b(4);
        if (paramq.e())
          paramq.b(4);
        if (paramq.e())
          paramq.b(4);
        if (paramq.e())
          paramq.b(4);
        if (paramq.e())
        {
          if (paramq.e())
            paramq.b(4);
          if (paramq.e())
            paramq.b(4);
        }
      }
      if (paramq.e())
      {
        paramq.b(5);
        if (paramq.e())
        {
          paramq.b(7);
          if (paramq.e())
            paramq.b(8);
        }
      }
      paramq.b(8 * (i18 + 2));
      paramq.f();
      break label362;
      label868: for (int i19 = 0; i19 < i10; i19++)
        if (paramq.e())
          paramq.b(5);
    }
    label896: String str = "audio/ac3";
    paramq.b(32);
    int m = paramq.c(2);
    int n = a(m, paramq.c(6));
    paramq.b(8);
    int i1 = paramq.c(3);
    if (((i1 & 0x1) != 0) && (i1 != 1))
      paramq.b(2);
    if ((i1 & 0x4) != 0)
      paramq.b(2);
    if (i1 == 2)
      paramq.b(2);
    int i2 = b[m];
    int i3 = 1536;
    boolean bool1 = paramq.e();
    int i4 = d[i1];
    if (bool1);
    for (int i5 = 1; ; i5 = 0)
    {
      i6 = i4 + i5;
      break;
    }
  }

  public static int b(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    int j = -10 + paramByteBuffer.limit();
    for (int k = i; k <= j; k++)
      if ((0xFEFFFFFF & paramByteBuffer.getInt(k + 4)) == -1167101192)
        return k - i;
    return -1;
  }

  public static int b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte[4] != -8) || (paramArrayOfByte[5] != 114) || (paramArrayOfByte[6] != 111) || ((0xFE & paramArrayOfByte[7]) != 186))
      return 0;
    int i = 0xFF & paramArrayOfByte[7];
    int j = 0;
    if (i == 187)
      j = 1;
    if (j != 0);
    for (int k = 9; ; k = 8)
      return 40 << (0x7 & paramArrayOfByte[k] >> 4);
  }

  public static Format b(r paramr, String paramString1, String paramString2, DrmInitData paramDrmInitData)
  {
    paramr.d(2);
    int i = (0xC0 & paramr.h()) >> 6;
    int j = b[i];
    int k = paramr.h();
    int m = d[((k & 0xE) >> 1)];
    if ((k & 0x1) != 0)
      m++;
    if (((0x1E & paramr.h()) >> 1 > 0) && ((0x2 & paramr.h()) != 0));
    for (int n = m + 2; ; n = m)
    {
      String str = "audio/eac3";
      if ((paramr.b() > 0) && ((0x1 & paramr.h()) != 0))
        str = "audio/eac3-joc";
      return Format.createAudioSampleFormat(paramString1, str, null, -1, -1, n, j, null, paramDrmInitData, 0, paramString2);
    }
  }

  public static final class a
  {
    public final String a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    private a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      this.a = paramString;
      this.b = paramInt1;
      this.d = paramInt2;
      this.c = paramInt3;
      this.e = paramInt4;
      this.f = paramInt5;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.a
 * JD-Core Version:    0.6.2
 */
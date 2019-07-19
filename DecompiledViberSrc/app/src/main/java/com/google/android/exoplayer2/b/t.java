package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.g.q;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class t
{
  private static final int[] a = { 1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8 };
  private static final int[] b = { -1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1 };
  private static final int[] c = { 64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680 };

  public static int a(ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.position();
    int j;
    switch (paramByteBuffer.get(i))
    {
    default:
      j = (0x1 & paramByteBuffer.get(i + 4)) << 6 | (0xFC & paramByteBuffer.get(i + 5)) >> 2;
    case -2:
    case -1:
    case 31:
    }
    while (true)
    {
      return 32 * (j + 1);
      j = (0x1 & paramByteBuffer.get(i + 5)) << 6 | (0xFC & paramByteBuffer.get(i + 4)) >> 2;
      continue;
      j = (0x7 & paramByteBuffer.get(i + 4)) << 4 | (0x3C & paramByteBuffer.get(i + 7)) >> 2;
      continue;
      j = (0x7 & paramByteBuffer.get(i + 5)) << 4 | (0x3C & paramByteBuffer.get(i + 6)) >> 2;
    }
  }

  public static int a(byte[] paramArrayOfByte)
  {
    int i;
    switch (paramArrayOfByte[0])
    {
    default:
      i = (0x1 & paramArrayOfByte[4]) << 6 | (0xFC & paramArrayOfByte[5]) >> 2;
    case -2:
    case -1:
    case 31:
    }
    while (true)
    {
      return 32 * (i + 1);
      i = (0x1 & paramArrayOfByte[5]) << 6 | (0xFC & paramArrayOfByte[4]) >> 2;
      continue;
      i = (0x7 & paramArrayOfByte[4]) << 4 | (0x3C & paramArrayOfByte[7]) >> 2;
      continue;
      i = (0x7 & paramArrayOfByte[5]) << 4 | (0x3C & paramArrayOfByte[6]) >> 2;
    }
  }

  public static Format a(byte[] paramArrayOfByte, String paramString1, String paramString2, DrmInitData paramDrmInitData)
  {
    q localq = c(paramArrayOfByte);
    localq.b(60);
    int i = localq.c(6);
    int j = a[i];
    int k = localq.c(4);
    int m = b[k];
    int n = localq.c(5);
    int i1;
    if (n >= c.length)
    {
      i1 = -1;
      localq.b(10);
      if (localq.c(2) <= 0)
        break label124;
    }
    label124: for (int i2 = 1; ; i2 = 0)
    {
      return Format.createAudioSampleFormat(paramString1, "audio/vnd.dts", null, i1, -1, j + i2, m, null, paramDrmInitData, 0, paramString2);
      i1 = 1000 * c[n] / 2;
      break;
    }
  }

  public static boolean a(int paramInt)
  {
    return (paramInt == 2147385345) || (paramInt == -25230976) || (paramInt == 536864768) || (paramInt == -14745368);
  }

  public static int b(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j;
    switch (paramArrayOfByte[0])
    {
    default:
      j = 1 + ((0x3 & paramArrayOfByte[5]) << 12 | (0xFF & paramArrayOfByte[6]) << 4 | (0xF0 & paramArrayOfByte[7]) >> 4);
    case 31:
    case -2:
    case -1:
    }
    while (true)
    {
      if (i != 0)
        j = j * 16 / 14;
      return j;
      j = 1 + ((0x3 & paramArrayOfByte[6]) << 12 | (0xFF & paramArrayOfByte[7]) << 4 | (0x3C & paramArrayOfByte[8]) >> 2);
      i = 1;
      continue;
      j = 1 + ((0x3 & paramArrayOfByte[4]) << 12 | (0xFF & paramArrayOfByte[7]) << 4 | (0xF0 & paramArrayOfByte[6]) >> 4);
      i = 0;
      continue;
      j = 1 + ((0x3 & paramArrayOfByte[7]) << 12 | (0xFF & paramArrayOfByte[6]) << 4 | (0x3C & paramArrayOfByte[9]) >> 2);
      i = 1;
    }
  }

  private static q c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte[0] == 127)
      return new q(paramArrayOfByte);
    byte[] arrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    if (d(arrayOfByte))
      for (int i = 0; i < -1 + arrayOfByte.length; i += 2)
      {
        int j = arrayOfByte[i];
        arrayOfByte[i] = arrayOfByte[(i + 1)];
        arrayOfByte[(i + 1)] = j;
      }
    q localq1 = new q(arrayOfByte);
    if (arrayOfByte[0] == 31)
    {
      q localq2 = new q(arrayOfByte);
      while (localq2.a() >= 16)
      {
        localq2.b(2);
        localq1.a(localq2.c(14), 14);
      }
    }
    localq1.a(arrayOfByte);
    return localq1;
  }

  private static boolean d(byte[] paramArrayOfByte)
  {
    boolean bool;
    if (paramArrayOfByte[0] != -2)
    {
      int i = paramArrayOfByte[0];
      bool = false;
      if (i != -1);
    }
    else
    {
      bool = true;
    }
    return bool;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.b.t
 * JD-Core Version:    0.6.2
 */
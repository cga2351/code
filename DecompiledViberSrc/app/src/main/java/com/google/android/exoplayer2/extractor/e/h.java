package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class h extends i
{
  private static final int a = ag.g("Opus");
  private static final byte[] b = { 79, 112, 117, 115, 72, 101, 97, 100 };
  private boolean c;

  private long a(byte[] paramArrayOfByte)
  {
    int i = 0xFF & paramArrayOfByte[0];
    int j;
    int k;
    int m;
    int n;
    switch (i & 0x3)
    {
    default:
      j = 0x3F & paramArrayOfByte[1];
      k = i >> 3;
      m = k & 0x3;
      if (k >= 16)
        n = 2500 << m;
      break;
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      return j * n;
      j = 1;
      break;
      j = 2;
      break;
      if (k >= 12)
        n = 10000 << (m & 0x1);
      else if (m == 3)
        n = 60000;
      else
        n = 10000 << m;
    }
  }

  private void a(List<byte[]> paramList, int paramInt)
  {
    long l = 1000000000L * paramInt / 48000L;
    paramList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(l).array());
  }

  public static boolean a(r paramr)
  {
    if (paramr.b() < b.length)
      return false;
    byte[] arrayOfByte = new byte[b.length];
    paramr.a(arrayOfByte, 0, b.length);
    return Arrays.equals(arrayOfByte, b);
  }

  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
      this.c = false;
  }

  protected boolean a(r paramr, long paramLong, i.a parama)
  {
    if (!this.c)
    {
      byte[] arrayOfByte = Arrays.copyOf(paramr.a, paramr.c());
      int i = 0xFF & arrayOfByte[9];
      int j = (0xFF & arrayOfByte[11]) << 8 | 0xFF & arrayOfByte[10];
      ArrayList localArrayList = new ArrayList(3);
      localArrayList.add(arrayOfByte);
      a(localArrayList, j);
      a(localArrayList, 3840);
      parama.a = Format.createAudioSampleFormat(null, "audio/opus", null, -1, -1, i, 48000, localArrayList, null, 0, null);
      this.c = true;
      return true;
    }
    if (paramr.p() == a);
    for (boolean bool = true; ; bool = false)
    {
      paramr.c(0);
      return bool;
    }
  }

  protected long b(r paramr)
  {
    return b(a(paramr.a));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.e.h
 * JD-Core Version:    0.6.2
 */
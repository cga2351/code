package com.google.android.exoplayer2.c;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import com.google.android.exoplayer2.g.ag;

public final class b
{
  public byte[] a;
  public byte[] b;
  public int c;
  public int[] d;
  public int[] e;
  public int f;
  public int g;
  public int h;
  private final MediaCodec.CryptoInfo i;
  private final a j;

  public b()
  {
    if (ag.a >= 16);
    for (MediaCodec.CryptoInfo localCryptoInfo = b(); ; localCryptoInfo = null)
    {
      this.i = localCryptoInfo;
      int k = ag.a;
      a locala = null;
      if (k >= 24)
        locala = new a(this.i, null);
      this.j = locala;
      return;
    }
  }

  @TargetApi(16)
  private MediaCodec.CryptoInfo b()
  {
    return new MediaCodec.CryptoInfo();
  }

  @TargetApi(16)
  private void c()
  {
    this.i.numSubSamples = this.f;
    this.i.numBytesOfClearData = this.d;
    this.i.numBytesOfEncryptedData = this.e;
    this.i.key = this.b;
    this.i.iv = this.a;
    this.i.mode = this.c;
    if (ag.a >= 24)
      a.a(this.j, this.g, this.h);
  }

  @TargetApi(16)
  public MediaCodec.CryptoInfo a()
  {
    return this.i;
  }

  public void a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = paramInt1;
    this.d = paramArrayOfInt1;
    this.e = paramArrayOfInt2;
    this.b = paramArrayOfByte1;
    this.a = paramArrayOfByte2;
    this.c = paramInt2;
    this.g = paramInt3;
    this.h = paramInt4;
    if (ag.a >= 16)
      c();
  }

  @TargetApi(24)
  private static final class a
  {
    private final MediaCodec.CryptoInfo a;
    private final MediaCodec.CryptoInfo.Pattern b;

    private a(MediaCodec.CryptoInfo paramCryptoInfo)
    {
      this.a = paramCryptoInfo;
      this.b = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    private void a(int paramInt1, int paramInt2)
    {
      this.b.set(paramInt1, paramInt2);
      this.a.setPattern(this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b
 * JD-Core Version:    0.6.2
 */
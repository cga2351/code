package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzoi
{
  private static final long[] zzbci = { 128L, 64L, 32L, 16L, 8L, 4L, 2L, 1L };
  private int length;
  private int state;
  private final byte[] zzanf = new byte[8];

  public static long zza(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    long l1 = 0xFF & paramArrayOfByte[0];
    if (paramBoolean)
      l1 &= (0xFFFFFFFF ^ zzbci[(paramInt - 1)]);
    long l2 = l1;
    for (int i = 1; i < paramInt; i++)
      l2 = l2 << 8 | 0xFF & paramArrayOfByte[i];
    return l2;
  }

  public static int zzaw(int paramInt)
  {
    for (int i = 0; i < zzbci.length; i++)
      if ((zzbci[i] & paramInt) != 0L)
        return i + 1;
    return -1;
  }

  public final void reset()
  {
    this.state = 0;
    this.length = 0;
  }

  public final long zza(zzno paramzzno, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
    throws IOException, InterruptedException
  {
    if (this.state == 0)
    {
      if (!paramzzno.zza(this.zzanf, 0, 1, paramBoolean1))
        return -1L;
      this.length = zzaw(0xFF & this.zzanf[0]);
      if (this.length == -1)
        throw new IllegalStateException("No valid varint length mask found");
      this.state = 1;
    }
    if (this.length > paramInt)
    {
      this.state = 0;
      return -2L;
    }
    if (this.length != 1)
      paramzzno.readFully(this.zzanf, 1, -1 + this.length);
    this.state = 0;
    return zza(this.zzanf, this.length, paramBoolean2);
  }

  public final int zzfw()
  {
    return this.length;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzoi
 * JD-Core Version:    0.6.2
 */
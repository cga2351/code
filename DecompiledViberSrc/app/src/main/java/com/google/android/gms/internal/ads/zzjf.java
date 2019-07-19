package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzjf
{
  private static final int[] zzann = { 128, 64, 32, 16, 8, 4, 2, 1 };
  private int length;
  private int state;
  private final byte[] zzanf = new byte[8];

  public final void reset()
  {
    this.state = 0;
    this.length = 0;
  }

  public final long zza(zzie paramzzie, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException, InterruptedException
  {
    if (this.state == 0)
    {
      if (!paramzzie.zza(this.zzanf, 0, 1, paramBoolean1))
        return -1L;
      int j = 0xFF & this.zzanf[0];
      this.length = -1;
      for (int k = 0; ; k++)
        if (k < zzann.length)
        {
          if ((j & zzann[k]) != 0)
            this.length = (k + 1);
        }
        else
        {
          if (this.length != -1)
            break;
          throw new IllegalStateException("No valid varint length mask found");
        }
      this.state = 1;
    }
    paramzzie.readFully(this.zzanf, 1, -1 + this.length);
    if (paramBoolean2)
    {
      byte[] arrayOfByte = this.zzanf;
      arrayOfByte[0] = ((byte)(arrayOfByte[0] & (0xFFFFFFFF ^ zzann[(-1 + this.length)])));
    }
    long l = 0L;
    for (int i = 0; i < this.length; i++)
      l = l << 8 | 0xFF & this.zzanf[i];
    this.state = 0;
    return l;
  }

  public final int zzfw()
  {
    return this.length;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzjf
 * JD-Core Version:    0.6.2
 */
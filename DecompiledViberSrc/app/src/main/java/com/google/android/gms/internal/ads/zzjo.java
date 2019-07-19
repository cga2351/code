package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzjo
  implements zzjp
{
  private final byte[] data;
  private int zzape;
  private int zzapf;

  public zzjo(byte[] paramArrayOfByte)
  {
    zzkh.checkNotNull(paramArrayOfByte);
    if (paramArrayOfByte.length > 0);
    for (boolean bool = true; ; bool = false)
    {
      zzkh.checkArgument(bool);
      this.data = paramArrayOfByte;
      return;
    }
  }

  public final void close()
    throws IOException
  {
  }

  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.zzapf == 0)
      return -1;
    int i = Math.min(paramInt2, this.zzapf);
    System.arraycopy(this.data, this.zzape, paramArrayOfByte, paramInt1, i);
    this.zzape = (i + this.zzape);
    this.zzapf -= i;
    return i;
  }

  public final long zza(zzjq paramzzjq)
    throws IOException
  {
    this.zzape = ((int)paramzzjq.zzahv);
    if (paramzzjq.zzcd == -1L);
    for (long l1 = this.data.length - paramzzjq.zzahv; ; l1 = paramzzjq.zzcd)
    {
      this.zzapf = ((int)l1);
      if ((this.zzapf > 0) && (this.zzape + this.zzapf <= this.data.length))
        break;
      int i = this.zzape;
      long l2 = paramzzjq.zzcd;
      int j = this.data.length;
      throw new IOException(77 + "Unsatisfiable range: [" + i + ", " + l2 + "], length: " + j);
    }
    return this.zzapf;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzjo
 * JD-Core Version:    0.6.2
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

public final class zzru
  implements zzrv
{
  private final byte[] data;
  private Uri uri;
  private int zzape;
  private int zzbmc;

  public zzru(byte[] paramArrayOfByte)
  {
    zzsk.checkNotNull(paramArrayOfByte);
    if (paramArrayOfByte.length > 0);
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkArgument(bool);
      this.data = paramArrayOfByte;
      return;
    }
  }

  public final void close()
    throws IOException
  {
    this.uri = null;
  }

  public final Uri getUri()
  {
    return this.uri;
  }

  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 == 0)
      return 0;
    if (this.zzbmc == 0)
      return -1;
    int i = Math.min(paramInt2, this.zzbmc);
    System.arraycopy(this.data, this.zzape, paramArrayOfByte, paramInt1, i);
    this.zzape = (i + this.zzape);
    this.zzbmc -= i;
    return i;
  }

  public final long zza(zzry paramzzry)
    throws IOException
  {
    this.uri = paramzzry.uri;
    this.zzape = ((int)paramzzry.zzahv);
    if (paramzzry.zzcd == -1L);
    for (long l1 = this.data.length - paramzzry.zzahv; ; l1 = paramzzry.zzcd)
    {
      this.zzbmc = ((int)l1);
      if ((this.zzbmc > 0) && (this.zzape + this.zzbmc <= this.data.length))
        break;
      int i = this.zzape;
      long l2 = paramzzry.zzcd;
      int j = this.data.length;
      throw new IOException(77 + "Unsatisfiable range: [" + i + ", " + l2 + "], length: " + j);
    }
    return this.zzbmc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzru
 * JD-Core Version:    0.6.2
 */
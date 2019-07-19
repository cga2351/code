package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class zzjv
  implements zzkf
{
  private final zzke zzaoz;
  private long zzapc;
  private boolean zzapd;
  private RandomAccessFile zzaqe;
  private String zzaqf;

  public zzjv()
  {
    this(null);
  }

  public zzjv(zzke paramzzke)
  {
    this.zzaoz = paramzzke;
  }

  public final void close()
    throws zzjw
  {
    if (this.zzaqe != null);
    try
    {
      this.zzaqe.close();
      return;
    }
    catch (IOException localIOException)
    {
      throw new zzjw(localIOException);
    }
    finally
    {
      this.zzaqe = null;
      this.zzaqf = null;
      if (this.zzapd)
      {
        this.zzapd = false;
        if (this.zzaoz != null)
          this.zzaoz.zzgd();
      }
    }
  }

  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzjw
  {
    int j;
    if (this.zzapc == 0L)
      j = -1;
    while (true)
    {
      return j;
      try
      {
        int i = this.zzaqe.read(paramArrayOfByte, paramInt1, (int)Math.min(this.zzapc, paramInt2));
        j = i;
        if (j <= 0)
          continue;
        this.zzapc -= j;
        if (this.zzaoz == null)
          continue;
        this.zzaoz.zzab(j);
        return j;
      }
      catch (IOException localIOException)
      {
        throw new zzjw(localIOException);
      }
    }
  }

  public final long zza(zzjq paramzzjq)
    throws zzjw
  {
    while (true)
    {
      try
      {
        this.zzaqf = paramzzjq.uri.toString();
        this.zzaqe = new RandomAccessFile(paramzzjq.uri.getPath(), "r");
        this.zzaqe.seek(paramzzjq.zzahv);
        if (paramzzjq.zzcd == -1L)
        {
          l = this.zzaqe.length() - paramzzjq.zzahv;
          this.zzapc = l;
          if (this.zzapc >= 0L)
            break;
          throw new EOFException();
        }
      }
      catch (IOException localIOException)
      {
        throw new zzjw(localIOException);
      }
      long l = paramzzjq.zzcd;
    }
    this.zzapd = true;
    if (this.zzaoz != null)
      this.zzaoz.zzgc();
    return this.zzapc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzjv
 * JD-Core Version:    0.6.2
 */
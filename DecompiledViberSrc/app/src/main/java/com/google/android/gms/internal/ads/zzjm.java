package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class zzjm
  implements zzkf
{
  private final AssetManager zzaoy;
  private final zzke zzaoz;
  private String zzapa;
  private InputStream zzapb;
  private long zzapc;
  private boolean zzapd;

  public zzjm(Context paramContext, zzke paramzzke)
  {
    this.zzaoy = paramContext.getAssets();
    this.zzaoz = paramzzke;
  }

  public final void close()
    throws zzjn
  {
    if (this.zzapb != null);
    try
    {
      this.zzapb.close();
      return;
    }
    catch (IOException localIOException)
    {
      throw new zzjn(localIOException);
    }
    finally
    {
      this.zzapb = null;
      if (this.zzapd)
      {
        this.zzapd = false;
        if (this.zzaoz != null)
          this.zzaoz.zzgd();
      }
    }
  }

  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws zzjn
  {
    int j;
    if (this.zzapc == 0L)
      j = -1;
    while (true)
    {
      return j;
      try
      {
        int i = this.zzapb.read(paramArrayOfByte, paramInt1, (int)Math.min(this.zzapc, paramInt2));
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
        throw new zzjn(localIOException);
      }
    }
  }

  public final long zza(zzjq paramzzjq)
    throws zzjn
  {
    while (true)
    {
      String str;
      boolean bool;
      long l;
      try
      {
        this.zzapa = paramzzjq.uri.toString();
        str = paramzzjq.uri.getPath();
        if (str.startsWith("/android_asset/"))
        {
          str = str.substring(15);
          this.zzapb = this.zzaoy.open(str, 1);
          if (this.zzapb.skip(paramzzjq.zzahv) != paramzzjq.zzahv)
            break label182;
          bool = true;
          zzkh.checkState(bool);
          if (paramzzjq.zzcd != -1L)
            break label147;
          l = this.zzapb.available();
          this.zzapc = l;
          if (this.zzapc >= 0L)
            break label156;
          throw new EOFException();
        }
      }
      catch (IOException localIOException)
      {
        throw new zzjn(localIOException);
      }
      if (str.startsWith("/"))
      {
        str = str.substring(1);
        continue;
        label147: l = paramzzjq.zzcd;
        continue;
        label156: this.zzapd = true;
        if (this.zzaoz != null)
          this.zzaoz.zzgc();
        return this.zzapc;
        label182: bool = false;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzjm
 * JD-Core Version:    0.6.2
 */
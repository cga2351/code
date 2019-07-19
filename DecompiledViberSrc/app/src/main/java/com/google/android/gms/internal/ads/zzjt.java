package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import java.io.IOException;

public final class zzjt
  implements zzkf
{
  private final zzkf zzapz;
  private final zzkf zzaqa;
  private final zzkf zzaqb;
  private zzkf zzaqc;

  private zzjt(Context paramContext, zzke paramzzke, zzkf paramzzkf)
  {
    this.zzapz = ((zzkf)zzkh.checkNotNull(paramzzkf));
    this.zzaqa = new zzjv(null);
    this.zzaqb = new zzjm(paramContext, null);
  }

  private zzjt(Context paramContext, zzke paramzzke, String paramString, boolean paramBoolean)
  {
    this(paramContext, null, new zzjs(paramString, null, null, 8000, 8000, false));
  }

  public zzjt(Context paramContext, String paramString)
  {
    this(paramContext, null, paramString, false);
  }

  public final void close()
    throws IOException
  {
    if (this.zzaqc != null);
    try
    {
      this.zzaqc.close();
      return;
    }
    finally
    {
      this.zzaqc = null;
    }
  }

  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.zzaqc.read(paramArrayOfByte, paramInt1, paramInt2);
  }

  public final long zza(zzjq paramzzjq)
    throws IOException
  {
    boolean bool;
    String str;
    if (this.zzaqc == null)
    {
      bool = true;
      zzkh.checkState(bool);
      str = paramzzjq.uri.getScheme();
      if ((!"http".equals(str)) && (!"https".equals(str)))
        break label63;
      this.zzaqc = this.zzapz;
    }
    while (true)
    {
      return this.zzaqc.zza(paramzzjq);
      bool = false;
      break;
      label63: if ("file".equals(str))
      {
        if (paramzzjq.uri.getPath().startsWith("/android_asset/"))
          this.zzaqc = this.zzaqb;
        else
          this.zzaqc = this.zzaqa;
      }
      else
      {
        if (!"asset".equals(str))
          break label129;
        this.zzaqc = this.zzaqb;
      }
    }
    label129: throw new zzju(str);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzjt
 * JD-Core Version:    0.6.2
 */
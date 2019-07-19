package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzaki
{
  private final Object lock = new Object();
  private int status = 1;
  private final zzbaj zzbtd;
  private final String zzdcc;
  private zzayq<zzajx> zzdcd;
  private zzayq<zzajx> zzdce;
  private zzalb zzdcf;
  private final Context zzlj;

  public zzaki(Context paramContext, zzbaj paramzzbaj, String paramString)
  {
    this.zzdcc = paramString;
    this.zzlj = paramContext.getApplicationContext();
    this.zzbtd = paramzzbaj;
    this.zzdcd = new zzakw();
    this.zzdce = new zzakw();
  }

  public zzaki(Context paramContext, zzbaj paramzzbaj, String paramString, zzayq<zzajx> paramzzayq1, zzayq<zzajx> paramzzayq2)
  {
    this(paramContext, paramzzbaj, paramString);
    this.zzdcd = paramzzayq1;
    this.zzdce = paramzzayq2;
  }

  protected final zzalb zza(zzdh paramzzdh)
  {
    zzalb localzzalb = new zzalb(this.zzdce);
    zzbbn.zzeag.execute(new zzakj(this, paramzzdh, localzzalb));
    localzzalb.zza(new zzakt(this, localzzalb), new zzaku(this, localzzalb));
    return localzzalb;
  }

  public final zzakx zzb(zzdh paramzzdh)
  {
    synchronized (this.lock)
    {
      synchronized (this.lock)
      {
        if ((this.zzdcf != null) && (this.status == 0))
        {
          zzaci localzzaci = zzact.zzclc;
          if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
            this.zzdcf.zza(new zzakk(this), zzakl.zzdcj);
        }
        if ((this.zzdcf == null) || (this.zzdcf.getStatus() == -1))
        {
          this.status = 2;
          this.zzdcf = zza(null);
          zzakx localzzakx1 = this.zzdcf.zzrx();
          return localzzakx1;
        }
      }
    }
    if (this.status == 0)
    {
      zzakx localzzakx5 = this.zzdcf.zzrx();
      return localzzakx5;
    }
    if (this.status == 1)
    {
      this.status = 2;
      zza(null);
      zzakx localzzakx4 = this.zzdcf.zzrx();
      return localzzakx4;
    }
    if (this.status == 2)
    {
      zzakx localzzakx3 = this.zzdcf.zzrx();
      return localzzakx3;
    }
    zzakx localzzakx2 = this.zzdcf.zzrx();
    return localzzakx2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaki
 * JD-Core Version:    0.6.2
 */
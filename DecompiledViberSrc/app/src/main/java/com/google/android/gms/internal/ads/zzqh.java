package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;

public final class zzqh
  implements zzql, zzqm
{
  private final Uri uri;
  private final Handler zzabq;
  private final int zzaig;
  private final zzlt zzart;
  private zzlr zzary;
  private final zzqi zzbia;
  private zzqm zzbib;
  private final String zzbid;
  private final zzrw zzbiz;
  private final zznq zzbja;
  private final int zzbjb;
  private boolean zzbjc;

  public zzqh(Uri paramUri, zzrw paramzzrw, zznq paramzznq, int paramInt1, Handler paramHandler, zzqi paramzzqi, String paramString, int paramInt2)
  {
    this.uri = paramUri;
    this.zzbiz = paramzzrw;
    this.zzbja = paramzznq;
    this.zzaig = -1;
    this.zzabq = paramHandler;
    this.zzbia = paramzzqi;
    this.zzbid = null;
    this.zzbjb = paramInt2;
    this.zzart = new zzlt();
  }

  public final zzqj zza(int paramInt, zzrt paramzzrt)
  {
    if (paramInt == 0);
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkArgument(bool);
      return new zzpz(this.uri, this.zzbiz.zzju(), this.zzbja.zzih(), this.zzaig, this.zzabq, this.zzbia, this, paramzzrt, null, this.zzbjb);
    }
  }

  public final void zza(zzkv paramzzkv, boolean paramBoolean, zzqm paramzzqm)
  {
    this.zzbib = paramzzqm;
    this.zzary = new zzqz(-9223372036854775807L, false);
    paramzzqm.zzb(this.zzary, null);
  }

  public final void zzb(zzlr paramzzlr, Object paramObject)
  {
    boolean bool1 = paramzzlr.zza(0, this.zzart, false).zzack < -9223372036854775807L;
    boolean bool2 = false;
    if (bool1)
      bool2 = true;
    if ((this.zzbjc) && (!bool2))
      return;
    this.zzary = paramzzlr;
    this.zzbjc = bool2;
    this.zzbib.zzb(this.zzary, null);
  }

  public final void zzb(zzqj paramzzqj)
  {
    ((zzpz)paramzzqj).release();
  }

  public final void zzjf()
    throws IOException
  {
  }

  public final void zzjg()
  {
    this.zzbib = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzqh
 * JD-Core Version:    0.6.2
 */
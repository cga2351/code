package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.concurrent.Future;
import javax.annotation.concurrent.GuardedBy;

@zzare
public final class zzvz
{
  private final Object lock = new Object();

  @GuardedBy("lock")
  private zzvs zzbwp;

  @GuardedBy("lock")
  private boolean zzbxa;
  private final Context zzlj;

  zzvz(Context paramContext)
  {
    this.zzlj = paramContext;
  }

  private final void disconnect()
  {
    synchronized (this.lock)
    {
      if (this.zzbwp == null)
        return;
      this.zzbwp.disconnect();
      this.zzbwp = null;
      Binder.flushPendingCommands();
      return;
    }
  }

  final Future<InputStream> zzb(zzvt paramzzvt)
  {
    zzwa localzzwa = new zzwa(this);
    zzwb localzzwb = new zzwb(this, paramzzvt, localzzwa);
    zzwf localzzwf = new zzwf(this, localzzwa);
    synchronized (this.lock)
    {
      this.zzbwp = new zzvs(this.zzlj, zzk.zzlu().zzwr(), localzzwb, localzzwf);
      this.zzbwp.checkAvailabilityAndConnect();
      return localzzwa;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzvz
 * JD-Core Version:    0.6.2
 */
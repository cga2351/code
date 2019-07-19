package com.google.android.gms.gcm;

import android.annotation.TargetApi;
import android.os.Trace;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.iid.zzai;
import com.google.android.gms.iid.zzaj;
import java.io.Closeable;

public final class zzp
  implements Closeable
{
  private static final zzaj<Boolean> zzba = zzai.zzy().zzd("nts.enable_tracing", true);
  private final boolean enabled;

  @TargetApi(18)
  public zzp(String paramString)
  {
    boolean bool;
    if ((PlatformVersion.isAtLeastJellyBeanMR2()) && (((Boolean)zzba.get()).booleanValue()))
    {
      bool = true;
      this.enabled = bool;
      if (this.enabled)
        if (paramString.length() > 127)
          break label60;
    }
    while (true)
    {
      Trace.beginSection(paramString);
      return;
      bool = false;
      break;
      label60: paramString = paramString.substring(0, 127);
    }
  }

  @TargetApi(18)
  public final void close()
  {
    if (this.enabled)
      Trace.endSection();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.zzp
 * JD-Core Version:    0.6.2
 */
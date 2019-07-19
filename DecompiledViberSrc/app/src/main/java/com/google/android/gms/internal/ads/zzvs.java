package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;

@zzare
public final class zzvs extends zzc<zzvw>
{
  zzvs(Context paramContext, Looper paramLooper, BaseGmsClient.BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener)
  {
    super(zzasr.zzw(paramContext), paramLooper, 123, paramBaseConnectionCallbacks, paramBaseOnConnectionFailedListener, null);
  }

  @VisibleForTesting
  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.ads.internal.cache.ICacheService";
  }

  @VisibleForTesting
  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.ads.service.CACHE";
  }

  public final zzvw zznk()
    throws DeadObjectException
  {
    return (zzvw)super.getService();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzvs
 * JD-Core Version:    0.6.2
 */
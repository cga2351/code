package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;

@zzare
public final class zzarg extends zzc<zzarn>
{
  public zzarg(Context paramContext, Looper paramLooper, BaseGmsClient.BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener)
  {
    super(zzasr.zzw(paramContext), paramLooper, 8, paramBaseConnectionCallbacks, paramBaseOnConnectionFailedListener, null);
  }

  @VisibleForTesting
  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.ads.internal.request.IAdRequestService";
  }

  @VisibleForTesting
  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.ads.service.START";
  }

  public final zzarn zztr()
    throws DeadObjectException
  {
    return (zzarn)super.getService();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzarg
 * JD-Core Version:    0.6.2
 */
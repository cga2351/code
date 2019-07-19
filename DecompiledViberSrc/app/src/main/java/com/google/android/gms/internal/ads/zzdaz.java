package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

public final class zzdaz extends zzc<zzdbe>
{
  public zzdaz(Context paramContext, Looper paramLooper, BaseGmsClient.BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 116, paramBaseConnectionCallbacks, paramBaseOnConnectionFailedListener, null);
  }

  protected final String getServiceDescriptor()
  {
    return "com.google.android.gms.gass.internal.IGassService";
  }

  protected final String getStartServiceAction()
  {
    return "com.google.android.gms.gass.START";
  }

  public final zzdbe zzanm()
    throws DeadObjectException
  {
    return (zzdbe)super.getService();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdaz
 * JD-Core Version:    0.6.2
 */
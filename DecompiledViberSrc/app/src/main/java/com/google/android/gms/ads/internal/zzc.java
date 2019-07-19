package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;

public abstract class zzc<T extends IInterface> extends BaseGmsClient<T>
{
  protected zzc(Context paramContext, Looper paramLooper, int paramInt, BaseGmsClient.BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener, String paramString)
  {
    super(paramContext, paramLooper, paramInt, paramBaseConnectionCallbacks, paramBaseOnConnectionFailedListener, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.zzc
 * JD-Core Version:    0.6.2
 */
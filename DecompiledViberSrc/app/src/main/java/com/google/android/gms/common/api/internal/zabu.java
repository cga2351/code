package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public class zabu extends zal
{
  private TaskCompletionSource<Void> zajo = new TaskCompletionSource();

  private zabu(LifecycleFragment paramLifecycleFragment)
  {
    super(paramLifecycleFragment);
    this.mLifecycleFragment.addCallback("GmsAvailabilityHelper", this);
  }

  public static zabu zac(Activity paramActivity)
  {
    LifecycleFragment localLifecycleFragment = getFragment(paramActivity);
    zabu localzabu = (zabu)localLifecycleFragment.getCallbackOrNull("GmsAvailabilityHelper", zabu.class);
    if (localzabu != null)
    {
      if (localzabu.zajo.getTask().isComplete())
        localzabu.zajo = new TaskCompletionSource();
      return localzabu;
    }
    return new zabu(localLifecycleFragment);
  }

  public final Task<Void> getTask()
  {
    return this.zajo.getTask();
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.zajo.trySetException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
  }

  protected final void zaa(ConnectionResult paramConnectionResult, int paramInt)
  {
    this.zajo.setException(ApiExceptionUtil.fromStatus(new Status(paramConnectionResult.getErrorCode(), paramConnectionResult.getErrorMessage(), paramConnectionResult.getResolution())));
  }

  protected final void zao()
  {
    int i = this.zacc.isGooglePlayServicesAvailable(this.mLifecycleFragment.getLifecycleActivity());
    if (i == 0)
      this.zajo.setResult(null);
    while (this.zajo.getTask().isComplete())
      return;
    zab(new ConnectionResult(i, null), 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zabu
 * JD-Core Version:    0.6.2
 */
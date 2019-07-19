package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import javax.annotation.concurrent.GuardedBy;

final class zaap extends zabf
{
  zaap(zaan paramzaan, zabd paramzabd, BaseGmsClient.ConnectionProgressReportCallbacks paramConnectionProgressReportCallbacks)
  {
    super(paramzabd);
  }

  @GuardedBy("mLock")
  public final void zaan()
  {
    this.zagn.onReportServiceBinding(new ConnectionResult(16, null));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zaap
 * JD-Core Version:    0.6.2
 */
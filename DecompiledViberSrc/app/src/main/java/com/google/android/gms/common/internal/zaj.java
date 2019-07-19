package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

final class zaj
  implements PendingResult.StatusListener
{
  zaj(PendingResult paramPendingResult, TaskCompletionSource paramTaskCompletionSource, PendingResultUtil.ResultConverter paramResultConverter, PendingResultUtil.zaa paramzaa)
  {
  }

  public final void onComplete(Status paramStatus)
  {
    if (paramStatus.isSuccess())
    {
      Result localResult = this.zaou.await(0L, TimeUnit.MILLISECONDS);
      this.zaov.setResult(this.zaow.convert(localResult));
      return;
    }
    this.zaov.setException(this.zaox.zaf(paramStatus));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zaj
 * JD-Core Version:    0.6.2
 */
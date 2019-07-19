package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

final class zaa
  implements PendingResult.StatusListener
{
  zaa(Batch paramBatch)
  {
  }

  public final void onComplete(Status paramStatus)
  {
    while (true)
    {
      synchronized (Batch.zaa(this.zabd))
      {
        if (this.zabd.isCanceled())
          return;
        if (paramStatus.isCanceled())
        {
          Batch.zaa(this.zabd, true);
          Batch.zab(this.zabd);
          if (Batch.zac(this.zabd) == 0)
          {
            if (!Batch.zad(this.zabd))
              break;
            Batch.zae(this.zabd);
          }
          return;
        }
      }
      if (!paramStatus.isSuccess())
        Batch.zab(this.zabd, true);
    }
    if (Batch.zaf(this.zabd));
    for (Status localStatus = new Status(13); ; localStatus = Status.RESULT_SUCCESS)
    {
      this.zabd.setResult(new BatchResult(localStatus, Batch.zag(this.zabd)));
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.zaa
 * JD-Core Version:    0.6.2
 */
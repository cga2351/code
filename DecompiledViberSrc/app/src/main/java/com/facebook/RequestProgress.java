package com.facebook;

import android.os.Handler;

class RequestProgress
{
  private final Handler callbackHandler;
  private long lastReportedProgress;
  private long maxProgress;
  private long progress;
  private final Request request;
  private final long threshold;

  RequestProgress(Handler paramHandler, Request paramRequest)
  {
    this.request = paramRequest;
    this.callbackHandler = paramHandler;
    this.threshold = Settings.getOnProgressThreshold();
  }

  void addProgress(long paramLong)
  {
    this.progress = (paramLong + this.progress);
    if ((this.progress >= this.lastReportedProgress + this.threshold) || (this.progress >= this.maxProgress))
      reportProgress();
  }

  void addToMax(long paramLong)
  {
    this.maxProgress = (paramLong + this.maxProgress);
  }

  long getMaxProgress()
  {
    return this.maxProgress;
  }

  long getProgress()
  {
    return this.progress;
  }

  void reportProgress()
  {
    final long l1;
    long l2;
    final Request.OnProgressCallback localOnProgressCallback;
    if (this.progress > this.lastReportedProgress)
    {
      Request.Callback localCallback = this.request.getCallback();
      if ((this.maxProgress > 0L) && ((localCallback instanceof Request.OnProgressCallback)))
      {
        l1 = this.progress;
        l2 = this.maxProgress;
        localOnProgressCallback = (Request.OnProgressCallback)localCallback;
        if (this.callbackHandler != null)
          break label79;
        localOnProgressCallback.onProgress(l1, l2);
      }
    }
    while (true)
    {
      this.lastReportedProgress = this.progress;
      return;
      label79: this.callbackHandler.post(new Runnable()
      {
        public void run()
        {
          localOnProgressCallback.onProgress(l1, this.val$maxProgressCopy);
        }
      });
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.RequestProgress
 * JD-Core Version:    0.6.2
 */
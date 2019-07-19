package com.viber.voip.phone.vptt;

import android.os.Handler;
import android.os.Looper;

public final class VideoPttRecordProxy
  implements VideoPttRecord
{
  private final Handler mHandler;
  private final VideoPttRecord mImpl;

  public VideoPttRecordProxy(VideoPttRecord paramVideoPttRecord, Handler paramHandler)
  {
    this.mImpl = paramVideoPttRecord;
    this.mHandler = paramHandler;
  }

  private void executeOrPostToHandler(Runnable paramRunnable)
  {
    if (Thread.currentThread() != this.mHandler.getLooper().getThread())
    {
      this.mHandler.post(paramRunnable);
      return;
    }
    paramRunnable.run();
  }

  public void dispose()
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        VideoPttRecordProxy.this.mImpl.dispose();
      }
    });
  }

  public byte[] getJpegPreview()
  {
    return this.mImpl.getJpegPreview();
  }

  public boolean isRecording()
  {
    return this.mImpl.isRecording();
  }

  public void startVideoPttRecord(final String paramString, final VideoPttRecord.Completion paramCompletion)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        VideoPttRecordProxy.this.mImpl.startVideoPttRecord(paramString, paramCompletion);
      }
    });
  }

  public void stopVideoPttRecord(final VideoPttRecord.StopCompletion paramStopCompletion)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        VideoPttRecordProxy.this.mImpl.stopVideoPttRecord(paramStopCompletion);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.vptt.VideoPttRecordProxy
 * JD-Core Version:    0.6.2
 */
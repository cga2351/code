package com.facebook.react.bridge.queue;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class MessageQueueThreadHandler extends Handler
{
  private final QueueThreadExceptionHandler mExceptionHandler;

  public MessageQueueThreadHandler(Looper paramLooper, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    super(paramLooper);
    this.mExceptionHandler = paramQueueThreadExceptionHandler;
  }

  public void dispatchMessage(Message paramMessage)
  {
    try
    {
      super.dispatchMessage(paramMessage);
      return;
    }
    catch (Exception localException)
    {
      this.mExceptionHandler.handleException(localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.queue.MessageQueueThreadHandler
 * JD-Core Version:    0.6.2
 */
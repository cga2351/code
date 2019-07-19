package com.vk.sdk.api;

class VKSyncRequestUtil
{
  public static void executeSyncWithListener(VKRequest paramVKRequest, VKRequest.VKRequestListener paramVKRequestListener)
  {
    Listener localListener = new Listener(paramVKRequestListener);
    paramVKRequest.setUseLooperForCallListener(false);
    paramVKRequest.executeWithListener(localListener);
    synchronized (localListener.syncObj)
    {
      while (true)
      {
        boolean bool = localListener.isFinish;
        if (!bool)
          try
          {
            localListener.syncObj.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
      }
    }
  }

  private static class Listener extends VKRequest.VKRequestListener
  {
    private volatile boolean isFinish = false;
    private VKRequest.VKRequestListener listener;
    private final Object syncObj = new Object();

    public Listener(VKRequest.VKRequestListener paramVKRequestListener)
    {
      this.listener = paramVKRequestListener;
    }

    public void onComplete(VKResponse paramVKResponse)
    {
      try
      {
        synchronized (this.syncObj)
        {
          this.listener.onComplete(paramVKResponse);
          label15: this.isFinish = true;
          this.syncObj.notifyAll();
          return;
        }
      }
      catch (Exception localException)
      {
        break label15;
      }
    }

    public void onError(VKError paramVKError)
    {
      try
      {
        synchronized (this.syncObj)
        {
          this.listener.onError(paramVKError);
          label15: this.isFinish = true;
          this.syncObj.notifyAll();
          return;
        }
      }
      catch (Exception localException)
      {
        break label15;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.api.VKSyncRequestUtil
 * JD-Core Version:    0.6.2
 */
package org.greenrobot.eventbus;

import android.os.Looper;

public abstract interface MainThreadSupport
{
  public abstract Poster createPoster(EventBus paramEventBus);

  public abstract boolean isMainThread();

  public static class AndroidHandlerMainThreadSupport
    implements MainThreadSupport
  {
    private final Looper looper;

    public AndroidHandlerMainThreadSupport(Looper paramLooper)
    {
      this.looper = paramLooper;
    }

    public Poster createPoster(EventBus paramEventBus)
    {
      return new HandlerPoster(paramEventBus, this.looper, 10);
    }

    public boolean isMainThread()
    {
      return this.looper == Looper.myLooper();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.MainThreadSupport
 * JD-Core Version:    0.6.2
 */
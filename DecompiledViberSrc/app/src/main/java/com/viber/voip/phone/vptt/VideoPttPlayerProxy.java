package com.viber.voip.phone.vptt;

import android.os.Handler;
import android.os.Looper;
import com.viber.voip.widget.d.a;

public final class VideoPttPlayerProxy
  implements VideoPttPlayer
{
  private final Handler handler;
  private final VideoPttPlayer impl;

  public VideoPttPlayerProxy(VideoPttPlayer paramVideoPttPlayer, Handler paramHandler)
  {
    this.impl = paramVideoPttPlayer;
    this.handler = paramHandler;
  }

  private void executeOrPostToHandler(Runnable paramRunnable)
  {
    if (Thread.currentThread() != this.handler.getLooper().getThread())
    {
      this.handler.post(paramRunnable);
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
        VideoPttPlayerProxy.this.impl.dispose();
      }
    });
  }

  public void restartUnmuted(final VideoPttPlayer.Completion paramCompletion)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        VideoPttPlayerProxy.this.impl.restartUnmuted(paramCompletion);
      }
    });
  }

  public void startVideoPttPlay(final int paramInt, final String paramString, final a parama, final boolean paramBoolean, final VideoPttPlayer.Completion paramCompletion1, final VideoPttPlayer.Completion paramCompletion2)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        VideoPttPlayerProxy.this.impl.startVideoPttPlay(paramInt, paramString, parama, paramBoolean, paramCompletion1, paramCompletion2);
      }
    });
  }

  public void stopVideoPttPlay(final VideoPttPlayer.Completion paramCompletion)
  {
    executeOrPostToHandler(new Runnable()
    {
      public void run()
      {
        VideoPttPlayerProxy.this.impl.stopVideoPttPlay(paramCompletion);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.vptt.VideoPttPlayerProxy
 * JD-Core Version:    0.6.2
 */
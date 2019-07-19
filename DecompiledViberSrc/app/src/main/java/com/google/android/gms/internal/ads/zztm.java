package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

final class zztm
  implements Handler.Callback, Choreographer.FrameCallback
{
  private static final zztm zzbpp = new zztm();
  private final Handler handler;
  public volatile long zzbpo;
  private final HandlerThread zzbpq = new HandlerThread("ChoreographerOwner:Handler");
  private Choreographer zzbpr;
  private int zzbps;

  private zztm()
  {
    this.zzbpq.start();
    this.handler = new Handler(this.zzbpq.getLooper(), this);
    this.handler.sendEmptyMessage(0);
  }

  public static zztm zzkn()
  {
    return zzbpp;
  }

  public final void doFrame(long paramLong)
  {
    this.zzbpo = paramLong;
    this.zzbpr.postFrameCallbackDelayed(this, 500L);
  }

  public final boolean handleMessage(Message paramMessage)
  {
    int i = 1;
    switch (paramMessage.what)
    {
    default:
      i = 0;
    case 0:
    case 1:
    case 2:
    }
    do
    {
      do
      {
        return i;
        this.zzbpr = Choreographer.getInstance();
        return i;
        this.zzbps = (1 + this.zzbps);
      }
      while (this.zzbps != i);
      this.zzbpr.postFrameCallback(this);
      return i;
      this.zzbps = (-1 + this.zzbps);
    }
    while (this.zzbps != 0);
    this.zzbpr.removeFrameCallback(this);
    this.zzbpo = 0L;
    return i;
  }

  public final void zzko()
  {
    this.handler.sendEmptyMessage(1);
  }

  public final void zzkp()
  {
    this.handler.sendEmptyMessage(2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zztm
 * JD-Core Version:    0.6.2
 */
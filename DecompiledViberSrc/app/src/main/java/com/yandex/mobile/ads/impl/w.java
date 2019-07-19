package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;

public final class w extends ResultReceiver
{
  private WeakReference<a> a = new WeakReference(null);

  public w(Handler paramHandler)
  {
    super(paramHandler);
  }

  public final void a(a parama)
  {
    this.a = new WeakReference(parama);
  }

  protected final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if (this.a != null)
    {
      a locala = (a)this.a.get();
      if (locala != null)
      {
        locala.a(paramInt, paramBundle);
        new Object[1][0] = Integer.valueOf(paramInt);
      }
    }
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt, Bundle paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.w
 * JD-Core Version:    0.6.2
 */
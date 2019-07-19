package com.firebase.jobdispatcher;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.lang.ref.WeakReference;

class d
{
  static final SimpleArrayMap<o, q> a = new SimpleArrayMap();
  private final b b = new b(Looper.getMainLooper(), new WeakReference(this));
  private final Context c;
  private final a d;

  d(Context paramContext, a parama)
  {
    this.c = paramContext;
    this.d = parama;
  }

  private Intent a(p paramp)
  {
    Intent localIntent = new Intent("com.firebase.jobdispatcher.ACTION_EXECUTE");
    localIntent.setClassName(this.c, paramp.i());
    return localIntent;
  }

  private void a(o paramo, int paramInt)
  {
    synchronized (a)
    {
      q localq = (q)a.remove(paramo);
      if (localq != null)
        localq.b();
      this.d.a(paramo, paramInt);
      return;
    }
  }

  static void a(o paramo, boolean paramBoolean)
  {
    synchronized (a)
    {
      q localq = (q)a.remove(paramo);
      if (localq != null)
        localq.a(paramBoolean);
      return;
    }
  }

  boolean a(o paramo)
  {
    if (paramo == null)
      return false;
    q localq = new q(paramo, this.b.obtainMessage(1), this.c);
    synchronized (a)
    {
      if ((q)a.put(paramo, localq) != null)
        Log.e("FJD.ExternalReceiver", "Received execution request for already running job");
      boolean bool = this.c.bindService(a(paramo), localq, 1);
      return bool;
    }
  }

  static abstract interface a
  {
    public abstract void a(o paramo, int paramInt);
  }

  private static class b extends Handler
  {
    private final WeakReference<d> a;

    b(Looper paramLooper, WeakReference<d> paramWeakReference)
    {
      super();
      this.a = paramWeakReference;
    }

    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        Log.wtf("FJD.ExternalReceiver", "handleMessage: unknown message type received: " + paramMessage.what);
        return;
      case 1:
      }
      if ((paramMessage.obj instanceof o))
      {
        d locald = (d)this.a.get();
        if (locald == null)
        {
          Log.wtf("FJD.ExternalReceiver", "handleMessage: service was unexpectedly GC'd, can't send job result");
          return;
        }
        d.a(locald, (o)paramMessage.obj, paramMessage.arg1);
        return;
      }
      Log.wtf("FJD.ExternalReceiver", "handleMessage: unknown obj returned");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.firebase.jobdispatcher.d
 * JD-Core Version:    0.6.2
 */
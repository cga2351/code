package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import android.util.Pair;

public class GooglePlayReceiver extends Service
  implements d.a
{
  private static final n d = new n("com.firebase.jobdispatcher.", true);
  private static final SimpleArrayMap<String, SimpleArrayMap<String, m>> h = new SimpleArrayMap(1);
  Messenger a;
  c b;
  x c;
  private final f e = new f();
  private d f;
  private int g;

  static void a(l paraml)
  {
    synchronized (h)
    {
      SimpleArrayMap localSimpleArrayMap2 = (SimpleArrayMap)h.get(paraml.i());
      if (localSimpleArrayMap2 == null)
        return;
      if ((m)localSimpleArrayMap2.get(paraml.e()) == null)
        return;
    }
    d.a(new o.a().a(paraml.e()).b(paraml.i()).a(paraml.f()).a(), false);
  }

  private static void a(m paramm, int paramInt)
  {
    try
    {
      paramm.a(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("FJD.GooglePlayReceiver", "Encountered error running callback", localThrowable.getCause());
    }
  }

  private void a(o paramo)
  {
    l locall = new l.a(e(), paramo).a(true).j();
    d().a(locall);
  }

  private static boolean a(p paramp, int paramInt)
  {
    return (paramp.h()) && ((paramp.f() instanceof r.a)) && (paramInt != 1);
  }

  static n b()
  {
    return d;
  }

  private Messenger c()
  {
    try
    {
      if (this.a == null)
        this.a = new Messenger(new j(Looper.getMainLooper(), this));
      Messenger localMessenger = this.a;
      return localMessenger;
    }
    finally
    {
    }
  }

  private c d()
  {
    try
    {
      if (this.b == null)
        this.b = new g(getApplicationContext());
      c localc = this.b;
      return localc;
    }
    finally
    {
    }
  }

  private x e()
  {
    try
    {
      if (this.c == null)
        this.c = new x(d().a());
      x localx = this.c;
      return localx;
    }
    finally
    {
    }
  }

  d a()
  {
    try
    {
      if (this.f == null)
        this.f = new d(this, this);
      d locald = this.f;
      return locald;
    }
    finally
    {
    }
  }

  o a(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null)
    {
      Log.e("FJD.GooglePlayReceiver", "No data provided, terminating");
      return null;
    }
    Pair localPair = this.e.a(localBundle);
    if (localPair == null)
    {
      Log.i("FJD.GooglePlayReceiver", "no callback found");
      return null;
    }
    return a((m)localPair.first, (Bundle)localPair.second);
  }

  o a(m paramm, Bundle paramBundle)
  {
    try
    {
      o localo1 = d.a(paramBundle);
      if (localo1 == null)
      {
        Log.e("FJD.GooglePlayReceiver", "unable to decode job");
        a(paramm, 2);
      }
      for (o localo2 = null; ; localo2 = localo1)
      {
        return localo2;
        SimpleArrayMap localSimpleArrayMap = (SimpleArrayMap)h.get(localo1.i());
        if (localSimpleArrayMap == null)
        {
          localSimpleArrayMap = new SimpleArrayMap(1);
          h.put(localo1.i(), localSimpleArrayMap);
        }
        localSimpleArrayMap.put(localo1.e(), paramm);
      }
    }
    finally
    {
    }
  }

  public void a(o paramo, int paramInt)
  {
    try
    {
      SimpleArrayMap localSimpleArrayMap = (SimpleArrayMap)h.get(paramo.i());
      if (localSimpleArrayMap == null);
      label195: 
      while (true)
      {
        m localm;
        try
        {
          return;
          localm = (m)localSimpleArrayMap.remove(paramo.e());
          if (localm == null)
          {
            if (!h.isEmpty())
              continue;
            stopSelf(this.g);
            continue;
          }
        }
        finally
        {
        }
        if (localSimpleArrayMap.isEmpty())
          h.remove(paramo.i());
        if (a(paramo, paramInt))
          a(paramo);
        while (true)
        {
          if (!h.isEmpty())
            break label195;
          stopSelf(this.g);
          break;
          if (Log.isLoggable("FJD.GooglePlayReceiver", 2))
            Log.v("FJD.GooglePlayReceiver", "sending jobFinished for " + paramo.e() + " = " + paramInt);
          a(localm, paramInt);
        }
      }
    }
    finally
    {
      if (h.isEmpty())
        stopSelf(this.g);
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    if ((paramIntent == null) || (Build.VERSION.SDK_INT < 21) || (!"com.google.android.gms.gcm.ACTION_TASK_READY".equals(paramIntent.getAction())))
      return null;
    return c().getBinder();
  }

  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    try
    {
      super.onStartCommand(paramIntent, paramInt1, paramInt2);
      if (paramIntent == null)
      {
        Log.w("FJD.GooglePlayReceiver", "Null Intent passed, terminating");
        try
        {
          this.g = paramInt2;
          if (h.isEmpty())
            stopSelf(this.g);
          return 2;
        }
        finally
        {
        }
      }
      String str = paramIntent.getAction();
      if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(str))
      {
        a().a(a(paramIntent));
        try
        {
          this.g = paramInt2;
          if (h.isEmpty())
            stopSelf(this.g);
          return 2;
        }
        finally
        {
        }
      }
      boolean bool = "com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(str);
      if (bool)
        try
        {
          this.g = paramInt2;
          if (h.isEmpty())
            stopSelf(this.g);
          return 2;
        }
        finally
        {
        }
      Log.e("FJD.GooglePlayReceiver", "Unknown action received, terminating");
      try
      {
        this.g = paramInt2;
        if (h.isEmpty())
          stopSelf(this.g);
        return 2;
      }
      finally
      {
      }
    }
    finally
    {
      try
      {
        this.g = paramInt2;
        if (h.isEmpty())
          stopSelf(this.g);
        throw localObject1;
      }
      finally
      {
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.firebase.jobdispatcher.GooglePlayReceiver
 * JD-Core Version:    0.6.2
 */
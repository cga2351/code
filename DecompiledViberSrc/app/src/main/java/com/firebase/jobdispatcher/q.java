package com.firebase.jobdispatcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

class q
  implements ServiceConnection
{
  private final o a;
  private final Message b;
  private boolean c = false;
  private final Context d;
  private JobService.b e;

  q(o paramo, Message paramMessage, Context paramContext)
  {
    this.b = paramMessage;
    this.a = paramo;
    this.b.obj = this.a;
    this.d = paramContext;
  }

  void a(boolean paramBoolean)
  {
    try
    {
      if (a())
      {
        this.e.a().a(this.a, paramBoolean);
        b();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  boolean a()
  {
    try
    {
      JobService.b localb = this.e;
      if (localb != null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  void b()
  {
    try
    {
      if (a())
        this.e = null;
      try
      {
        this.d.unbindService(this);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        while (true)
          Log.w("FJD.ExternalReceiver", "Error unbinding service: " + localIllegalArgumentException.getMessage());
      }
    }
    finally
    {
    }
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    while (true)
    {
      try
      {
        if (!(paramIBinder instanceof JobService.b))
        {
          Log.w("FJD.ExternalReceiver", "Unknown service connected");
          return;
        }
        if (this.c)
        {
          Log.w("FJD.ExternalReceiver", "onServiceConnected Duplicate calls. Ignored.");
          continue;
        }
      }
      finally
      {
      }
      this.c = true;
      this.e = ((JobService.b)paramIBinder);
      this.e.a().a(this.a, this.b);
    }
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    try
    {
      this.e = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.firebase.jobdispatcher.q
 * JD-Core Version:    0.6.2
 */
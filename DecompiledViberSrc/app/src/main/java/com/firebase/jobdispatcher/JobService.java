package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Locale;

public abstract class JobService extends Service
{
  private final SimpleArrayMap<String, a> a = new SimpleArrayMap(1);
  private final b b = new b();

  void a(o paramo, boolean paramBoolean)
  {
    while (true)
    {
      synchronized (this.a)
      {
        a locala = (a)this.a.remove(paramo.e());
        if (locala == null)
        {
          if (Log.isLoggable("FJD.JobService", 3))
            Log.d("FJD.JobService", "Provided job has already been executed.");
          return;
        }
        boolean bool = b(paramo);
        if (paramBoolean)
        {
          if (bool)
          {
            i = 1;
            locala.a(i);
          }
        }
        else
          return;
      }
      int i = 0;
    }
  }

  void a(p paramp, Message paramMessage)
  {
    synchronized (this.a)
    {
      if (this.a.containsKey(paramp.e()))
      {
        Locale localLocale = Locale.US;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramp.e();
        Log.w("FJD.JobService", String.format(localLocale, "Job with tag = %s was already running.", arrayOfObject));
        return;
      }
      this.a.put(paramp.e(), new a(paramMessage, null));
      if (!a(paramp))
      {
        a locala = (a)this.a.remove(paramp.e());
        if (locala != null)
          locala.a(0);
      }
      return;
    }
  }

  public final void a(p paramp, boolean paramBoolean)
  {
    if (paramp == null)
    {
      Log.e("FJD.JobService", "jobFinished called with a null JobParameters");
      return;
    }
    while (true)
    {
      synchronized (this.a)
      {
        a locala = (a)this.a.remove(paramp.e());
        if (locala != null)
        {
          if (paramBoolean)
          {
            i = 1;
            locala.a(i);
          }
        }
        else
          return;
      }
      int i = 0;
    }
  }

  public abstract boolean a(p paramp);

  public abstract boolean b(p paramp);

  protected final void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }

  public final IBinder onBind(Intent paramIntent)
  {
    return this.b;
  }

  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }

  public final void onRebind(Intent paramIntent)
  {
    super.onRebind(paramIntent);
  }

  public final void onStart(Intent paramIntent, int paramInt)
  {
  }

  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    stopSelf(paramInt2);
    return 2;
  }

  public final void onTaskRemoved(Intent paramIntent)
  {
    super.onTaskRemoved(paramIntent);
  }

  public final boolean onUnbind(Intent paramIntent)
  {
    while (true)
    {
      int i;
      synchronized (this.a)
      {
        i = -1 + this.a.size();
        if (i >= 0)
        {
          a locala = (a)this.a.remove(this.a.keyAt(i));
          if (locala != null)
          {
            if (!b((p)locala.a.obj))
              break label99;
            j = 1;
            locala.a(j);
          }
        }
        else
        {
          return super.onUnbind(paramIntent);
        }
      }
      i--;
      continue;
      label99: int j = 2;
    }
  }

  private static final class a
  {
    public final Message a;

    private a(Message paramMessage)
    {
      this.a = paramMessage;
    }

    void a(int paramInt)
    {
      this.a.arg1 = paramInt;
      this.a.sendToTarget();
    }
  }

  class b extends Binder
  {
    b()
    {
    }

    JobService a()
    {
      return JobService.this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.firebase.jobdispatcher.JobService
 * JD-Core Version:    0.6.2
 */
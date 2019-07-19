package com.viber.voip.qrcode;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

final class f
{
  private static final Logger a = ViberEnv.getLogger();
  private final Activity b;
  private final BroadcastReceiver c;
  private boolean d;
  private AsyncTask<Object, Object, Object> e;

  f(Activity paramActivity)
  {
    this.b = paramActivity;
    this.c = new b(null);
    this.d = false;
    a();
  }

  private void e()
  {
    try
    {
      AsyncTask localAsyncTask = this.e;
      if (localAsyncTask != null)
      {
        localAsyncTask.cancel(true);
        this.e = null;
      }
      return;
    }
    finally
    {
    }
  }

  void a()
  {
    try
    {
      e();
      this.e = new a(null);
      this.e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b()
  {
    try
    {
      e();
      if (this.d)
      {
        this.b.unregisterReceiver(this.c);
        this.d = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void c()
  {
    try
    {
      if (this.d);
      while (true)
      {
        a();
        return;
        this.b.registerReceiver(this.c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.d = true;
      }
    }
    finally
    {
    }
  }

  void d()
  {
    e();
  }

  private final class a extends AsyncTask<Object, Object, Object>
  {
    private a()
    {
    }

    protected Object doInBackground(Object[] paramArrayOfObject)
    {
      try
      {
        Thread.sleep(300000L);
        f.b(f.this).finish();
        label16: return null;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label16;
      }
    }
  }

  private final class b extends BroadcastReceiver
  {
    private b()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("android.intent.action.BATTERY_CHANGED".equals(paramIntent.getAction()))
        if (paramIntent.getIntExtra("plugged", -1) > 0)
          break label36;
      label36: for (int i = 1; i != 0; i = 0)
      {
        f.this.a();
        return;
      }
      f.a(f.this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.qrcode.f
 * JD-Core Version:    0.6.2
 */
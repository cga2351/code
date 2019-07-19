package com.crashlytics.android.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

class x
{
  private static final IntentFilter a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
  private static final IntentFilter b = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
  private static final IntentFilter c = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
  private final AtomicBoolean d;
  private final Context e;
  private final BroadcastReceiver f;
  private final BroadcastReceiver g;
  private boolean h;

  public x(Context paramContext)
  {
    this.e = paramContext;
    this.g = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        x.a(x.this, true);
      }
    };
    this.f = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        x.a(x.this, false);
      }
    };
    this.d = new AtomicBoolean(false);
  }

  public void a()
  {
    boolean bool = true;
    int i = -1;
    if (this.d.getAndSet(bool))
      return;
    Intent localIntent = this.e.registerReceiver(null, a);
    if (localIntent != null)
      i = localIntent.getIntExtra("status", i);
    if ((i == 2) || (i == 5));
    while (true)
    {
      this.h = bool;
      this.e.registerReceiver(this.g, b);
      this.e.registerReceiver(this.f, c);
      return;
      bool = false;
    }
  }

  public boolean b()
  {
    return this.h;
  }

  public void c()
  {
    if (!this.d.getAndSet(false))
      return;
    this.e.unregisterReceiver(this.g);
    this.e.unregisterReceiver(this.f);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.x
 * JD-Core Version:    0.6.2
 */
package com.iab.omid.library.appnexus.b;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.iab.omid.library.appnexus.publisher.AdSessionStatePublisher;
import java.util.Collection;
import java.util.Iterator;

public class b
{

  @SuppressLint({"StaticFieldLeak"})
  private static b a = new b();
  private Context b;
  private BroadcastReceiver c;
  private boolean d;
  private boolean e;
  private a f;

  public static b a()
  {
    return a;
  }

  private void a(boolean paramBoolean)
  {
    if (this.e != paramBoolean)
    {
      this.e = paramBoolean;
      if (this.d)
      {
        g();
        if (this.f != null)
          this.f.a(d());
      }
    }
  }

  private void e()
  {
    this.c = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if (paramAnonymousIntent == null);
        KeyguardManager localKeyguardManager;
        do
        {
          do
          {
            return;
            if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent.getAction()))
            {
              b.a(b.this, true);
              return;
            }
            if ("android.intent.action.USER_PRESENT".equals(paramAnonymousIntent.getAction()))
            {
              b.a(b.this, false);
              return;
            }
          }
          while (!"android.intent.action.SCREEN_ON".equals(paramAnonymousIntent.getAction()));
          localKeyguardManager = (KeyguardManager)paramAnonymousContext.getSystemService("keyguard");
        }
        while ((localKeyguardManager == null) || (localKeyguardManager.inKeyguardRestrictedInputMode()));
        b.a(b.this, false);
      }
    };
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.USER_PRESENT");
    this.b.registerReceiver(this.c, localIntentFilter);
  }

  private void f()
  {
    if ((this.b != null) && (this.c != null))
    {
      this.b.unregisterReceiver(this.c);
      this.c = null;
    }
  }

  private void g()
  {
    if (!this.e);
    for (boolean bool = true; ; bool = false)
    {
      Iterator localIterator = a.a().b().iterator();
      while (localIterator.hasNext())
        ((com.iab.omid.library.appnexus.adsession.a)localIterator.next()).getAdSessionStatePublisher().a(bool);
    }
  }

  public void a(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
  }

  public void a(a parama)
  {
    this.f = parama;
  }

  public void b()
  {
    e();
    this.d = true;
    g();
  }

  public void c()
  {
    f();
    this.d = false;
    this.e = false;
    this.f = null;
  }

  public boolean d()
  {
    return !this.e;
  }

  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.b.b
 * JD-Core Version:    0.6.2
 */
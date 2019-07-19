package com.viber.voip.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.notif.f;
import com.viber.voip.schedule.o;
import dagger.a;

public class ba
{
  private static final Logger a = ViberEnv.getLogger();
  private Context b;
  private boolean c;
  private BroadcastReceiver d;
  private o e;
  private a<f> f;
  private a g;

  public ba(Context paramContext, a<f> parama, o paramo)
  {
    this.b = paramContext;
    this.f = parama;
    this.c = ((f)parama.get()).b();
    this.e = paramo;
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    if (this.g != null)
      this.g.a(paramInt, paramBoolean);
  }

  public int a()
  {
    return this.e.h();
  }

  public void a(a parama)
  {
    this.g = parama;
    if ((this.d == null) && (this.b != null))
    {
      this.d = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          ba.a(ba.this, ba.this.a(), ba.this.b());
        }
      };
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.viber.voip.stickers.notification.UPDATE_STICKER_PACKAGES_COUNT_ACTION");
      this.b.registerReceiver(this.d, localIntentFilter);
    }
  }

  public boolean b()
  {
    return this.c;
  }

  public void c()
  {
    if ((this.d != null) && (this.b != null))
    {
      this.b.unregisterReceiver(this.d);
      this.d = null;
    }
    this.g = null;
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt, boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ba
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.ui.media.player.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class k extends BroadcastReceiver
{
  private final Context a;
  private final a b;
  private final IntentFilter c;
  private boolean d;

  public k(Context paramContext, a parama)
  {
    this.a = paramContext;
    this.b = parama;
    this.c = new IntentFilter("android.intent.action.SCREEN_OFF");
  }

  public void a()
  {
    if (!this.d)
    {
      this.d = true;
      this.a.registerReceiver(this, this.c);
    }
  }

  public void b()
  {
    if (this.d)
    {
      this.d = false;
      this.a.unregisterReceiver(this);
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((this.d) && ("android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())))
      this.b.a();
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.d.k
 * JD-Core Version:    0.6.2
 */
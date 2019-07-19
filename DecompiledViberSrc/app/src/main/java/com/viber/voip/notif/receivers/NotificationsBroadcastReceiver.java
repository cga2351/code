package com.viber.voip.notif.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.CircularArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.k;
import com.viber.voip.notif.g;

public class NotificationsBroadcastReceiver extends BroadcastReceiver
{
  private static final Logger a = ViberEnv.getLogger();
  private CircularArray<d> b;

  private ai a()
  {
    return ViberApplication.getInstance().getMessagesManager().c();
  }

  private void a(Context paramContext)
  {
    ai localai = a();
    g localg = g.a(paramContext);
    this.b = new CircularArray(4);
    this.b.addFirst(new a(localg));
    this.b.addFirst(new b(localai, localg));
    this.b.addFirst(new c(localai, localg));
    this.b.addFirst(new e(localai, localg));
  }

  private void a(String paramString, Context paramContext, Intent paramIntent)
  {
    if (this.b == null)
      a(paramContext);
    for (int i = 0; ; i++)
      if (i < this.b.size())
      {
        d locald = (d)this.b.get(i);
        if (locald.a(paramString))
          locald.a(paramIntent);
      }
      else
      {
        return;
      }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str != null)
      a(str, paramContext, paramIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.receivers.NotificationsBroadcastReceiver
 * JD-Core Version:    0.6.2
 */
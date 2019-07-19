package com.viber.voip.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.viber.common.b.b;
import com.viber.common.b.e;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.bf;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ax;
import com.viber.voip.ui.dialogs.t;

public class UpdateLastOnlineStatusReceiver extends BroadcastReceiver
  implements d.b
{
  public static final IntentFilter a = new IntentFilter("com.viber.voip.action.SETTINGS_CHANGE_CHECK");
  private static final Logger b = ViberEnv.getLogger();
  private Handler c;

  public UpdateLastOnlineStatusReceiver(Handler paramHandler)
  {
    this.c = paramHandler;
    d.b(this, this.c);
  }

  public void a()
  {
    boolean bool = d.bf.j.d();
    if (!d.bf.h.d())
      return;
    d.bf.h.a(false);
    ViberDialogHandlers.ax localax = new ViberDialogHandlers.ax();
    localax.a = bool;
    if (bool)
    {
      t.h().a(localax).d();
      return;
    }
    t.g().a(localax).d();
  }

  public void onAppStopped()
  {
    i.c(this);
  }

  public void onBackground()
  {
    i.a(this);
  }

  public void onForeground()
  {
    if (d.bf.i.d())
    {
      d.bf.i.a(false);
      a();
    }
    while ((!d.bf.h.d()) || (86400000L + d.bf.g.d() >= System.currentTimeMillis()))
      return;
    a();
  }

  public void onForegroundStateChanged(boolean paramBoolean)
  {
    i.a(this, paramBoolean);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.viber.voip.action.SETTINGS_CHANGE_CHECK".equals(paramIntent.getAction()))
      this.c.post(new Runnable()
      {
        public void run()
        {
          if (ViberApplication.getInstance().isOnForeground())
          {
            UpdateLastOnlineStatusReceiver.this.a();
            return;
          }
          d.bf.i.a(true);
        }
      });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.UpdateLastOnlineStatusReceiver
 * JD-Core Version:    0.6.2
 */
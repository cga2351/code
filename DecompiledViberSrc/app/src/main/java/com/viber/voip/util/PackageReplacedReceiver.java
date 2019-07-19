package com.viber.voip.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.av;
import com.viber.voip.settings.d.ax;
import com.viber.voip.settings.d.bm;
import com.viber.voip.stickers.i;
import com.viber.voip.user.ProfileNotification;
import com.viber.voip.user.UserManager;

public class PackageReplacedReceiver extends BroadcastReceiver
{
  private static final Logger a = ViberEnv.getLogger();

  private void a()
  {
    d.ad.j.a(true);
    d.av.a.b();
    d.av.b.b();
    d.av.c.b();
    d.av.d.b();
    d.av.m.b();
    d.av.l.b();
    d.av.j.b();
    d.av.k.b();
    d.av.i.b();
    d.av.f.b();
    d.av.e.b();
    d.av.g.b();
    d.ax.u.b();
    d.bm.d.b();
    d.bm.k.b();
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.MY_PACKAGE_REPLACED".equals(paramIntent.getAction()))
    {
      ViberApplication localViberApplication = ViberApplication.getInstance();
      localViberApplication.initApplication();
      a();
      localViberApplication.getFacebookManager().c();
      i.a().c();
      i.a().b(true);
      com.viber.voip.notif.g.a(paramContext).h();
      com.viber.voip.analytics.g.a().b().c(true);
      UserManager.from(paramContext).getProfileNotification().updateState();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.PackageReplacedReceiver
 * JD-Core Version:    0.6.2
 */
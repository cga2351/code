package com.viber.voip.g.a;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationManagerCompat;
import com.viber.voip.ViberApplication;
import com.viber.voip.notif.e.m;
import com.viber.voip.notif.f;
import com.viber.voip.notif.g;
import javax.inject.Singleton;

public abstract class em
{
  static m a(g paramg)
  {
    return paramg.a();
  }

  @Singleton
  static f a(Context paramContext, ViberApplication paramViberApplication)
  {
    return new f((NotificationManager)paramContext.getSystemService("notification"), NotificationManagerCompat.from(paramContext), paramViberApplication);
  }

  static g a(Context paramContext)
  {
    return g.a(paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.em
 * JD-Core Version:    0.6.2
 */
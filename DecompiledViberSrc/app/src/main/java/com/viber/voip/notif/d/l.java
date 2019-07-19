package com.viber.voip.notif.d;

import android.app.Notification;
import android.support.v4.app.NotificationCompat.Extender;
import android.support.v4.util.CircularArray;
import com.viber.voip.notif.c;
import com.viber.voip.notif.c.o;

public abstract class l
{
  CharSequence c;
  CharSequence d;
  int e;
  CircularArray<NotificationCompat.Extender> f;
  b g;

  abstract Notification a(c paramc, h paramh, o paramo);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.d.l
 * JD-Core Version:    0.6.2
 */
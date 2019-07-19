package com.viber.voip.notif.c;

import android.support.v4.app.NotificationCompat.Builder;
import com.viber.voip.notif.f.g;

public class m extends n
{
  final g a;

  m(g paramg)
  {
    this.a = paramg;
  }

  public x a()
  {
    return new w(this);
  }

  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
  {
    return paramBuilder.setLargeIcon(this.a.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.c.m
 * JD-Core Version:    0.6.2
 */
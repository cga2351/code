package com.viber.voip.notif.c;

import android.content.Context;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.util.CircularArray;

public class a extends n
{
  CircularArray<com.viber.voip.notif.a.a.a> a;
  final Context b;
  final com.viber.voip.notif.d.a c;

  a(CircularArray<com.viber.voip.notif.a.a.a> paramCircularArray, Context paramContext, com.viber.voip.notif.d.a parama)
  {
    this.a = paramCircularArray;
    this.b = paramContext;
    this.c = parama;
  }

  public x a()
  {
    return new u(this);
  }

  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
  {
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      paramBuilder.addAction(((com.viber.voip.notif.a.a.a)this.a.get(j)).a(this.b, this.c));
    return paramBuilder;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.c.a
 * JD-Core Version:    0.6.2
 */
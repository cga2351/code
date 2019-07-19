package com.viber.voip.notif.c;

import android.content.Context;
import android.support.v4.app.NotificationCompat.WearableExtender;
import android.support.v4.util.CircularArray;

public class u
  implements x
{
  final com.viber.voip.notif.d.a a;
  private final CircularArray<com.viber.voip.notif.a.a.a> b;
  private final Context c;

  u(CircularArray<com.viber.voip.notif.a.a.a> paramCircularArray, Context paramContext, com.viber.voip.notif.d.a parama)
  {
    this.b = paramCircularArray;
    this.c = paramContext;
    this.a = parama;
  }

  u(a parama)
  {
    this.b = parama.a;
    this.c = parama.b;
    this.a = parama.c;
  }

  public static u a(CircularArray<com.viber.voip.notif.a.a.a> paramCircularArray, Context paramContext, com.viber.voip.notif.d.a parama)
  {
    return new u(paramCircularArray, paramContext, parama);
  }

  public NotificationCompat.WearableExtender a(NotificationCompat.WearableExtender paramWearableExtender)
  {
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      paramWearableExtender.addAction(((com.viber.voip.notif.a.a.a)this.b.get(j)).b(this.c, this.a));
    return paramWearableExtender;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.c.u
 * JD-Core Version:    0.6.2
 */
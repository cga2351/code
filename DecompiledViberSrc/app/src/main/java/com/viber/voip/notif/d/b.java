package com.viber.voip.notif.d;

import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.Extender;
import android.support.v4.app.NotificationCompat.WearableExtender;
import android.support.v4.util.CircularArray;
import com.viber.common.d.a;
import com.viber.voip.notif.c.x;

class b
  implements NotificationCompat.Extender
{
  CircularArray<x> a;

  void a(x paramx)
  {
    if (paramx == null)
      return;
    if (this.a == null)
      this.a = new CircularArray();
    this.a.addLast(paramx);
  }

  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
  {
    if ((!a.c()) || (this.a == null))
      return paramBuilder;
    NotificationCompat.WearableExtender localWearableExtender = new NotificationCompat.WearableExtender();
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      ((x)this.a.get(j)).a(localWearableExtender);
    return paramBuilder.extend(localWearableExtender);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.d.b
 * JD-Core Version:    0.6.2
 */
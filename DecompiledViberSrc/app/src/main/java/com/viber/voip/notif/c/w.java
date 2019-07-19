package com.viber.voip.notif.c;

import android.support.v4.app.NotificationCompat.WearableExtender;
import com.viber.voip.notif.f.g;

public class w
  implements x
{
  private final g a;

  w(m paramm)
  {
    this.a = paramm.a;
  }

  public NotificationCompat.WearableExtender a(NotificationCompat.WearableExtender paramWearableExtender)
  {
    paramWearableExtender.setBackground(this.a.b());
    return paramWearableExtender;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.c.w
 * JD-Core Version:    0.6.2
 */
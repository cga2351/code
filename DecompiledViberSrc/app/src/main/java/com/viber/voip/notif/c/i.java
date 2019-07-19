package com.viber.voip.notif.c;

import android.support.v4.app.NotificationCompat.Builder;

public class i extends n
{
  private long a;

  i(long paramLong)
  {
    this.a = paramLong;
  }

  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
  {
    return paramBuilder.setWhen(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.c.i
 * JD-Core Version:    0.6.2
 */
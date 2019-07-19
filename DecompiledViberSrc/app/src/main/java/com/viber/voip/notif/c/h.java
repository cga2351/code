package com.viber.voip.notif.c;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import com.viber.voip.notif.i.i;

public class h extends q
{
  private h(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3)
  {
    super(paramContext, i.a(paramInt1), paramIntent, paramInt2, paramInt3);
    a(paramIntent);
  }

  static h a(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2)
  {
    return new h(paramContext, paramInt1, paramIntent, paramInt2, 2);
  }

  private void a(Intent paramIntent)
  {
    paramIntent.putExtra("from_notification", 1);
  }

  void a(NotificationCompat.Builder paramBuilder, PendingIntent paramPendingIntent)
  {
    paramBuilder.setContentIntent(paramPendingIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.c.h
 * JD-Core Version:    0.6.2
 */
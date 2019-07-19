package com.viber.voip.notif.c;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import com.viber.voip.util.ViberActionRunner.am;

abstract class q extends n
{
  private final Context a;
  private final int b;
  private final Intent c;
  private final int d;
  private final int e;

  q(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3)
  {
    this.a = paramContext;
    this.b = paramInt1;
    this.c = paramIntent;
    this.d = paramInt2;
    this.e = paramInt3;
  }

  abstract void a(NotificationCompat.Builder paramBuilder, PendingIntent paramPendingIntent);

  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
  {
    Intent localIntent = ViberActionRunner.am.a(this.a, this.c, this.e);
    a(paramBuilder, PendingIntent.getBroadcast(this.a, this.b, localIntent, this.d));
    return paramBuilder;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.c.q
 * JD-Core Version:    0.6.2
 */
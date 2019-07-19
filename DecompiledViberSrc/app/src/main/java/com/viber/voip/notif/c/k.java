package com.viber.voip.notif.c;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import com.viber.voip.notif.i.i;

public class k extends q
{
  private boolean a;

  private k(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramContext, i.b(paramInt1), paramIntent, paramInt2, paramInt3);
    this.a = paramBoolean;
  }

  static k a(Context paramContext, int paramInt1, Intent paramIntent, int paramInt2, boolean paramBoolean)
  {
    return new k(paramContext, paramInt1, paramIntent, paramInt2, 2, paramBoolean);
  }

  void a(NotificationCompat.Builder paramBuilder, PendingIntent paramPendingIntent)
  {
    paramBuilder.setFullScreenIntent(paramPendingIntent, this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.c.k
 * JD-Core Version:    0.6.2
 */
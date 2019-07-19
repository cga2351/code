package com.appboy.push;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Builder;
import com.appboy.i;

public class b
  implements i
{
  private static volatile b a = null;

  public static b a()
  {
    if (a == null);
    try
    {
      if (a == null)
        a = new b();
      return a;
    }
    finally
    {
    }
  }

  public Notification a(com.appboy.a.b paramb, Context paramContext, Bundle paramBundle1, Bundle paramBundle2)
  {
    return b(paramb, paramContext, paramBundle1, paramBundle2).build();
  }

  public NotificationCompat.Builder b(com.appboy.a.b paramb, Context paramContext, Bundle paramBundle1, Bundle paramBundle2)
  {
    d.c(paramContext, paramBundle1);
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext, d.b(paramContext, paramb, paramBundle1)).setAutoCancel(true);
    d.a(paramb, localBuilder, paramBundle1);
    d.b(paramb, localBuilder, paramBundle1);
    d.a(localBuilder, paramBundle1);
    d.b(localBuilder, paramBundle1);
    d.a(paramContext, localBuilder, paramBundle1);
    d.b(paramContext, localBuilder, paramBundle1);
    d.a(paramb, localBuilder);
    d.a(paramContext, paramb, localBuilder, paramBundle1);
    d.c(localBuilder, paramBundle1);
    d.d(localBuilder, paramBundle1);
    d.e(localBuilder, paramBundle1);
    d.a(paramContext, localBuilder, paramBundle1, paramBundle2);
    a.a(paramContext, localBuilder, paramBundle1);
    d.c(paramb, localBuilder, paramBundle1);
    d.f(localBuilder, paramBundle1);
    d.g(localBuilder, paramBundle1);
    d.b(paramContext, paramb, localBuilder, paramBundle1);
    d.h(localBuilder, paramBundle1);
    return localBuilder;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.push.b
 * JD-Core Version:    0.6.2
 */
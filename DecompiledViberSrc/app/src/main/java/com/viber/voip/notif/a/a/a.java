package com.viber.voip.notif.a.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Action;
import android.support.v4.app.NotificationCompat.Action.Builder;
import android.support.v4.app.NotificationCompat.Action.Extender;
import android.support.v4.util.CircularArray;
import com.viber.voip.notif.i.i;
import com.viber.voip.util.ViberActionRunner.am;

public abstract class a
{
  CircularArray<NotificationCompat.Action.Extender> a;
  CircularArray<NotificationCompat.Action.Extender> b;

  private PendingIntent a(Intent paramIntent, int paramInt, Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = ViberActionRunner.am.a(paramContext, paramIntent, paramInt);
    if (paramBoolean);
    for (int i = i.g(d()); ; i = i.d(d()))
      return PendingIntent.getBroadcast(paramContext, i, localIntent, i());
  }

  private void a(Intent paramIntent)
  {
    paramIntent.putExtra("from_notification", 1);
  }

  private PendingIntent e(Context paramContext)
  {
    Intent localIntent = a(paramContext);
    a(localIntent);
    return a(localIntent, e(), paramContext, false);
  }

  private PendingIntent f(Context paramContext)
  {
    Intent localIntent = b(paramContext);
    a(localIntent);
    return a(localIntent, g(), paramContext, true);
  }

  protected abstract int a();

  protected abstract Intent a(Context paramContext);

  public final NotificationCompat.Action a(Context paramContext, com.viber.voip.notif.d.a parama)
  {
    NotificationCompat.Action.Builder localBuilder = parama.a(a(), b(), c(), e(paramContext));
    c(paramContext);
    if (this.a != null)
    {
      int i = this.a.size();
      for (int j = 0; j < i; j++)
        localBuilder.extend((NotificationCompat.Action.Extender)this.a.get(j));
    }
    return localBuilder.build();
  }

  protected final void a(NotificationCompat.Action.Extender[] paramArrayOfExtender)
  {
    if (this.a == null)
      this.a = new CircularArray();
    int i = paramArrayOfExtender.length;
    for (int j = 0; j < i; j++)
    {
      NotificationCompat.Action.Extender localExtender = paramArrayOfExtender[j];
      this.a.addLast(localExtender);
    }
  }

  protected abstract int b();

  protected Intent b(Context paramContext)
  {
    return a(paramContext);
  }

  public final NotificationCompat.Action b(Context paramContext, com.viber.voip.notif.d.a parama)
  {
    NotificationCompat.Action.Builder localBuilder = parama.a(f(), h(), f(paramContext));
    d(paramContext);
    if (this.b != null);
    for (CircularArray localCircularArray = this.b; localCircularArray != null; localCircularArray = this.a)
    {
      int i = localCircularArray.size();
      for (int j = 0; j < i; j++)
        localBuilder.extend((NotificationCompat.Action.Extender)localCircularArray.get(j));
    }
    return localBuilder.build();
  }

  protected final void b(NotificationCompat.Action.Extender[] paramArrayOfExtender)
  {
    if (this.b == null)
      this.b = new CircularArray();
    int i = paramArrayOfExtender.length;
    for (int j = 0; j < i; j++)
    {
      NotificationCompat.Action.Extender localExtender = paramArrayOfExtender[j];
      this.b.addLast(localExtender);
    }
  }

  protected int c()
  {
    return -1;
  }

  protected void c(Context paramContext)
  {
  }

  protected abstract int d();

  protected void d(Context paramContext)
  {
  }

  protected int e()
  {
    return 2;
  }

  protected int f()
  {
    return a();
  }

  protected int g()
  {
    return e();
  }

  protected int h()
  {
    return b();
  }

  protected int i()
  {
    return 134217728;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.a.a.a
 * JD-Core Version:    0.6.2
 */
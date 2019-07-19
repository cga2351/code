package com.viber.voip.notif;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.support.v4.app.NotificationManagerCompat;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;

public class f
{
  private static final Logger a = ViberEnv.getLogger();
  private final NotificationManager b;
  private final NotificationManagerCompat c;
  private final ViberApplication d;

  public f(NotificationManager paramNotificationManager, NotificationManagerCompat paramNotificationManagerCompat, ViberApplication paramViberApplication)
  {
    this.b = paramNotificationManager;
    this.c = paramNotificationManagerCompat;
    this.d = paramViberApplication;
  }

  public void a()
  {
    try
    {
      this.c.cancelAll();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
    }
  }

  public void a(int paramInt)
  {
    try
    {
      this.c.cancel(paramInt);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
    }
  }

  public void a(NotificationChannel paramNotificationChannel)
  {
    if (!a.m())
      return;
    this.b.createNotificationChannel(paramNotificationChannel);
  }

  public void a(String paramString)
  {
    if (!a.m())
      return;
    this.b.deleteNotificationChannel(paramString);
  }

  public void a(String paramString, int paramInt)
  {
    try
    {
      this.c.cancel(paramString, paramInt);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
    }
  }

  public void a(String paramString, int paramInt, Notification paramNotification)
  {
    if (!this.d.shouldBlockAllActivities())
      b(paramString, paramInt, paramNotification);
  }

  public NotificationChannel b(String paramString)
  {
    if (!a.m())
      return null;
    return this.b.getNotificationChannel(paramString);
  }

  public void b(String paramString, int paramInt, Notification paramNotification)
  {
    try
    {
      this.c.notify(paramString, paramInt, paramNotification);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      a.a(localOutOfMemoryError, "Not enough memory to notification");
      ViberApplication.getInstance().onOutOfMemory();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public boolean b()
  {
    try
    {
      boolean bool = this.c.areNotificationsEnabled();
      return bool;
    }
    catch (Exception localException)
    {
      a.a(new Exception("areNotificationsEnabled() is not available", localException), "areNotificationsEnabled() is not available");
    }
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.f
 * JD-Core Version:    0.6.2
 */
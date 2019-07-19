package com.viber.voip.notif.c;

import android.support.v4.app.NotificationCompat.Builder;

public class e extends n
{
  private final String a;
  private final boolean b;

  e(String paramString)
  {
    this(paramString, false);
  }

  e(String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramBoolean;
  }

  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
  {
    return paramBuilder.setGroup(this.a).setGroupSummary(this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.c.e
 * JD-Core Version:    0.6.2
 */
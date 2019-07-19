package com.viber.voip.notif.c;

import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;

public class d extends n
{
  private CharSequence a;
  private CharSequence b;

  d(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    this.a = paramCharSequence1;
    this.b = paramCharSequence2;
  }

  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
  {
    NotificationCompat.BigTextStyle localBigTextStyle = new NotificationCompat.BigTextStyle();
    localBigTextStyle.bigText(this.a);
    if (this.b != null)
      localBigTextStyle.setSummaryText(this.b);
    paramBuilder.setStyle(localBigTextStyle);
    return paramBuilder;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.c.d
 * JD-Core Version:    0.6.2
 */
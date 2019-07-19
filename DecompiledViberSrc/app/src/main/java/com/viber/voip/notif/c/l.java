package com.viber.voip.notif.c;

import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.InboxStyle;
import android.support.v4.util.CircularArray;

public class l extends n
{
  private CircularArray<CharSequence> a;
  private CharSequence b;

  l(CircularArray<CharSequence> paramCircularArray, CharSequence paramCharSequence)
  {
    this.a = paramCircularArray;
    this.b = paramCharSequence;
  }

  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
  {
    NotificationCompat.InboxStyle localInboxStyle = new NotificationCompat.InboxStyle();
    int i = this.a.size();
    for (int j = 0; j < i; j++)
      localInboxStyle.addLine((CharSequence)this.a.get(j));
    if (this.b != null)
      localInboxStyle.setSummaryText(this.b);
    paramBuilder.setStyle(localInboxStyle);
    return paramBuilder;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.c.l
 * JD-Core Version:    0.6.2
 */
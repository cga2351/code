package com.viber.voip.notif.c;

import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;

public class t extends n
{
  private CharSequence a;

  t(CharSequence paramCharSequence)
  {
    this.a = paramCharSequence;
  }

  t(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((TextUtils.isEmpty(paramCharSequence1)) && (TextUtils.isEmpty(paramCharSequence2)))
    {
      this.a = null;
      return;
    }
    if (TextUtils.isEmpty(paramCharSequence1))
    {
      this.a = paramCharSequence2;
      return;
    }
    if (TextUtils.isEmpty(paramCharSequence2))
    {
      this.a = paramCharSequence1;
      return;
    }
    this.a = (paramCharSequence1 + ": " + paramCharSequence2);
  }

  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
  {
    return paramBuilder.setTicker(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.c.t
 * JD-Core Version:    0.6.2
 */
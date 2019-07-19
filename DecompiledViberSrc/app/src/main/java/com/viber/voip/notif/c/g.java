package com.viber.voip.notif.c;

import android.support.v4.app.NotificationCompat.Builder;
import com.viber.common.d.a;
import com.viber.voip.util.da;

public class g extends n
{
  private final CharSequence a;

  g(CharSequence paramCharSequence)
  {
    this.a = paramCharSequence;
  }

  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
  {
    if (da.a(this.a))
      return paramBuilder;
    if (a.k())
    {
      paramBuilder.setSubText(this.a);
      return paramBuilder;
    }
    paramBuilder.setContentInfo(this.a);
    return paramBuilder;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.c.g
 * JD-Core Version:    0.6.2
 */
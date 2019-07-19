package com.viber.voip.notif.i;

import android.app.Notification;
import com.viber.voip.notif.d.e.a;

public class g
  implements e.a
{
  private final boolean a;

  public g(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public void a(Notification paramNotification)
  {
    if (this.a)
      paramNotification.tickerText = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.i.g
 * JD-Core Version:    0.6.2
 */
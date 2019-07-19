package com.viber.voip.notif.c;

import android.support.v4.app.NotificationCompat.Builder;

public class s extends n
{
  private final int a;
  private final int b;
  private final boolean c;

  private s(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramBoolean;
  }

  static s a(int paramInt1, int paramInt2)
  {
    return new s(paramInt1, paramInt2, false);
  }

  static s b()
  {
    return new s(0, 0, true);
  }

  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
  {
    return paramBuilder.setProgress(this.a, this.b, this.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.c.s
 * JD-Core Version:    0.6.2
 */
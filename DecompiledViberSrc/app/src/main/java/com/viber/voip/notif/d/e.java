package com.viber.voip.notif.d;

import android.app.Notification;
import android.content.Context;
import com.viber.voip.notif.c;
import com.viber.voip.notif.f;

public abstract interface e
{
  public abstract String R_();

  public abstract int a();

  public abstract b a(Context paramContext, j paramj);

  public abstract b a(Context paramContext, j paramj, c paramc);

  public abstract c d();

  public static abstract interface a
  {
    public abstract void a(Notification paramNotification);
  }

  public static abstract interface b
  {
    public abstract k a(f paramf);

    public abstract k a(f paramf, e.a parama);

    public abstract k a(f paramf, e.a parama, String paramString, int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.d.e
 * JD-Core Version:    0.6.2
 */
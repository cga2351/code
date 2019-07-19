package com.viber.voip.notif.d;

import android.app.Notification;
import android.content.Context;
import android.support.v4.app.NotificationCompat.Builder;
import com.viber.voip.notif.c;
import com.viber.voip.notif.c.o;

public class m extends l
{
  final CharSequence a;
  final CharSequence b;

  private m(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    this.a = paramCharSequence1;
    this.b = paramCharSequence2;
  }

  public static m a(a parama, Context paramContext)
  {
    return new m(parama.f(paramContext), parama.d(paramContext));
  }

  Notification a(c paramc, h paramh, o paramo)
  {
    return paramh.a(paramc, this, paramo).build();
  }

  public static abstract interface a
  {
    public abstract CharSequence d(Context paramContext);

    public abstract CharSequence f(Context paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.d.m
 * JD-Core Version:    0.6.2
 */
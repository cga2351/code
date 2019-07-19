package com.viber.voip.notif.d;

import android.app.Notification;
import android.content.Context;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.util.CircularArray;
import com.viber.voip.notif.c;
import com.viber.voip.notif.c.o;

public class g extends l
{
  final CircularArray<CharSequence> a;
  final CharSequence b;

  private g(CircularArray<CharSequence> paramCircularArray, CharSequence paramCharSequence)
  {
    this.a = paramCircularArray;
    this.b = paramCharSequence;
  }

  public static g a(a parama, Context paramContext)
  {
    b localb = new b(null);
    parama.a(paramContext, localb);
    return new g(localb.a, parama.d(paramContext));
  }

  Notification a(c paramc, h paramh, o paramo)
  {
    return paramh.a(paramc, this, paramo).build();
  }

  public static abstract interface a
  {
    public abstract void a(Context paramContext, g.b paramb);

    public abstract CharSequence d(Context paramContext);
  }

  public static class b
  {
    final CircularArray<CharSequence> a = new CircularArray(5);

    private void b(CharSequence paramCharSequence)
    {
      if (this.a.size() == 5)
        this.a.popFirst();
      this.a.addLast(paramCharSequence);
    }

    public void a(CharSequence paramCharSequence)
    {
      b(paramCharSequence);
    }

    public void a(CharSequence[] paramArrayOfCharSequence)
    {
      int i = paramArrayOfCharSequence.length;
      for (int j = 0; j < i; j++)
        b(paramArrayOfCharSequence[j]);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.d.g
 * JD-Core Version:    0.6.2
 */
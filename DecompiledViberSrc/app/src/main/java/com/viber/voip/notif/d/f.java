package com.viber.voip.notif.d;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.Builder;
import com.viber.voip.notif.c;
import com.viber.voip.notif.c.o;

public class f extends l
{
  final a a;
  final CharSequence b;

  private f(a parama, CharSequence paramCharSequence)
  {
    this.a = parama;
    this.b = paramCharSequence;
  }

  public static f a(b paramb, Context paramContext)
  {
    return new f(paramb.a(paramContext), paramb.f(paramContext));
  }

  Notification a(c paramc, h paramh, o paramo)
  {
    return paramh.a(paramc, this, paramo).build();
  }

  public static class a
  {
    final Bitmap a;
    final Bitmap b;
    final boolean c;

    public a(Bitmap paramBitmap)
    {
      this(paramBitmap, true);
    }

    public a(Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      this(paramBitmap1, paramBitmap2, true);
    }

    public a(Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean)
    {
      this.a = paramBitmap1;
      this.b = paramBitmap2;
      this.c = paramBoolean;
    }

    public a(Bitmap paramBitmap, boolean paramBoolean)
    {
      this(paramBitmap, paramBitmap, paramBoolean);
    }
  }

  public static abstract interface b
  {
    public abstract f.a a(Context paramContext);

    public abstract CharSequence f(Context paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.d.f
 * JD-Core Version:    0.6.2
 */
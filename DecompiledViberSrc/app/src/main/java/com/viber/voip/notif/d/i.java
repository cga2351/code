package com.viber.voip.notif.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.Extender;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.CircularArray;
import com.viber.voip.R.color;
import com.viber.voip.notif.a;
import com.viber.voip.notif.c.n;
import com.viber.voip.notif.c.o;
import com.viber.voip.notif.c.v;
import com.viber.voip.notif.c.x;
import com.viber.voip.settings.d.ag;
import com.viber.voip.util.e.j.c;

public class i
  implements h
{
  private final Context a;
  private final a b;
  private final com.viber.voip.notif.i.l c;
  private Bitmap d;

  public i(Context paramContext, com.viber.voip.notif.i.l paraml)
  {
    this.a = paramContext;
    this.b = new a(paramContext);
    this.c = paraml;
  }

  private Bitmap a(f paramf)
  {
    f.a locala = paramf.a;
    Bitmap localBitmap;
    if ((locala == null) || (locala.a == null))
      localBitmap = null;
    int[] arrayOfInt;
    do
    {
      return localBitmap;
      localBitmap = locala.a;
      arrayOfInt = this.b.a();
    }
    while ((localBitmap.getWidth() > arrayOfInt[0]) || (localBitmap.getHeight() > arrayOfInt[1]) || (!locala.c));
    if (this.d == null)
      this.d = Bitmap.createBitmap(arrayOfInt[0], arrayOfInt[1], Bitmap.Config.ARGB_8888);
    return new j.c(localBitmap, -2, -2).a(this.d);
  }

  private NotificationCompat.Builder a(Context paramContext, com.viber.voip.notif.c paramc)
  {
    return new NotificationCompat.Builder(paramContext, paramc.h.b()).setDefaults(0).setOngoing(false).setAutoCancel(true);
  }

  private NotificationCompat.Builder a(Context paramContext, com.viber.voip.notif.c paramc, l paraml, o paramo)
  {
    NotificationCompat.Builder localBuilder = a(paramContext, paramc);
    if (paraml.f != null)
    {
      int i = paraml.f.size();
      for (int j = 0; j < i; j++)
        localBuilder.extend((NotificationCompat.Extender)paraml.f.get(j));
    }
    if (paraml.g != null)
      localBuilder.extend(paraml.g);
    localBuilder.setContentText(com.viber.common.d.c.a(paraml.d)).setContentTitle(paraml.c).setSmallIcon(paraml.e).setColor(ContextCompat.getColor(paramContext, R.color.main));
    if (paramc.j != 0)
      localBuilder.setLights(paramc.j, 2000, 6000);
    if ((paramc.k != 0) && (this.c.a()))
      localBuilder.setSound(paramc.a(this.a));
    if ((paramc.a() != null) && (this.c.b()))
      localBuilder.setVibrate(paramc.a());
    localBuilder.setPriority(paramc.b());
    if (d.ag.k.d())
      paramo.a(paramc.h.a()).extend(localBuilder);
    return localBuilder;
  }

  private static void a(n paramn, l paraml)
  {
    if (paraml.f == null)
      paraml.f = new CircularArray();
    paraml.f.addLast(paramn);
    x localx = paramn.a();
    if (localx != null)
      a(localx, paraml);
  }

  private static void a(x paramx, l paraml)
  {
    if (paraml.g == null)
      paraml.g = new b();
    paraml.g.a(paramx);
  }

  public NotificationCompat.Builder a(com.viber.voip.notif.c paramc, f paramf, o paramo)
  {
    Bitmap localBitmap = a(paramf);
    if (localBitmap != null)
      a(paramo.a(localBitmap, paramf.b), paramf);
    if ((paramf.a != null) && (paramf.a.b != null))
      a(new v(paramf.a.b, this.b, this.a), paramf);
    return a(this.a, paramc, paramf, paramo);
  }

  public NotificationCompat.Builder a(com.viber.voip.notif.c paramc, g paramg, o paramo)
  {
    if (paramg.a.size() > 0)
      a(paramo.a(paramg.a, paramg.b), paramg);
    return a(this.a, paramc, paramg, paramo);
  }

  public NotificationCompat.Builder a(com.viber.voip.notif.c paramc, m paramm, o paramo)
  {
    if (paramm.a != null);
    for (CharSequence localCharSequence = paramm.a; ; localCharSequence = paramm.d)
    {
      a(paramo.b(localCharSequence, paramm.b), paramm);
      return a(this.a, paramc, paramm, paramo);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.d.i
 * JD-Core Version:    0.6.2
 */
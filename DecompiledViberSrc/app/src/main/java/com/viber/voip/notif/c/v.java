package com.viber.voip.notif.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.NotificationCompat.WearableExtender;
import com.viber.voip.notif.a;
import com.viber.voip.notif.b;
import com.viber.voip.notif.c;
import com.viber.voip.util.e.j;

public class v
  implements x
{
  private final Bitmap a;
  private final a b;
  private final Context c;

  public v(Bitmap paramBitmap, a parama, Context paramContext)
  {
    this.a = paramBitmap;
    this.b = parama;
    this.c = paramContext;
  }

  private Bitmap a()
  {
    if (this.a.isRecycled())
      return null;
    int i = this.a.getWidth();
    int j = this.a.getHeight();
    int[] arrayOfInt = this.b.b();
    if ((i <= arrayOfInt[0]) && (j <= arrayOfInt[1]))
      return this.a;
    return j.a(j.a(this.a.copy(Bitmap.Config.ARGB_8888, false)), arrayOfInt[0], arrayOfInt[1], false);
  }

  public NotificationCompat.WearableExtender a(NotificationCompat.WearableExtender paramWearableExtender)
  {
    Bitmap localBitmap = a();
    if (localBitmap == null)
      return paramWearableExtender;
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(this.c, c.d.h.b());
    localBuilder.extend(new NotificationCompat.WearableExtender().setBackground(localBitmap).setHintShowBackgroundOnly(true));
    return paramWearableExtender.addPage(localBuilder.build());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.c.v
 * JD-Core Version:    0.6.2
 */
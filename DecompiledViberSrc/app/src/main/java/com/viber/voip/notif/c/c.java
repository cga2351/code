package com.viber.voip.notif.c;

import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat.BigPictureStyle;
import android.support.v4.app.NotificationCompat.Builder;

public class c extends n
{
  private final Bitmap a;
  private final CharSequence b;

  c(Bitmap paramBitmap, CharSequence paramCharSequence)
  {
    this.a = paramBitmap;
    this.b = paramCharSequence;
  }

  public NotificationCompat.Builder extend(NotificationCompat.Builder paramBuilder)
  {
    NotificationCompat.BigPictureStyle localBigPictureStyle = new NotificationCompat.BigPictureStyle();
    localBigPictureStyle.bigPicture(this.a);
    if (this.b != null)
      localBigPictureStyle.setSummaryText(this.b);
    paramBuilder.setStyle(localBigPictureStyle);
    return paramBuilder;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.c.c
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.model.entity;

import android.database.Cursor;
import android.net.Uri;
import com.viber.voip.gallery.GalleryItem;
import com.viber.voip.util.e.j;

public class i extends b
{
  public static final String[] a = { "_id", "media_type", "mime_type", "duration" };
  private GalleryItem b;

  public i(Cursor paramCursor)
  {
    a(this, paramCursor);
  }

  private static void a(i parami, Cursor paramCursor)
  {
    parami.id = paramCursor.getLong(0);
    int i = paramCursor.getInt(1);
    String str = paramCursor.getString(2);
    long l = paramCursor.getLong(3);
    if (i == 3);
    for (Uri localUri = j.b(parami.id); ; localUri = j.a(parami.id))
    {
      parami.b = GalleryItem.from(localUri, str);
      parami.b.setDuration(l);
      return;
    }
  }

  public GalleryItem a()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.i
 * JD-Core Version:    0.6.2
 */
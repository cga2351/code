package com.viber.voip.model.entity;

import android.database.Cursor;
import android.net.Uri;
import com.viber.voip.util.e.j;

public class a extends b
{
  public static final String[] a = { "_id", "bucket_id", "bucket_display_name", "media_type", "COUNT(*)" };
  private String b;
  private String c;
  private Uri d;
  private int e;
  private int f;

  public a(Cursor paramCursor)
  {
    a(this, paramCursor);
  }

  private static void a(a parama, Cursor paramCursor)
  {
    parama.id = paramCursor.getLong(0);
    parama.b = paramCursor.getString(1);
    parama.c = paramCursor.getString(2);
    parama.e = paramCursor.getInt(3);
    parama.f = paramCursor.getInt(4);
    if (parama.e == 3);
    for (Uri localUri = j.b(parama.id); ; localUri = j.a(parama.id))
    {
      parama.d = localUri;
      return;
    }
  }

  public String a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public Uri c()
  {
    return this.d;
  }

  public int d()
  {
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.a
 * JD-Core Version:    0.6.2
 */
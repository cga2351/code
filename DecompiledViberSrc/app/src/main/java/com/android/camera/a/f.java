package com.android.camera.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;

public class f extends b
  implements d
{
  static final String[] g = { "_id", "_data", "datetaken", "mini_thumb_magic", "orientation", "title", "mime_type", "date_modified" };
  private static final String[] h = { "image/jpeg", "image/png", "image/gif" };

  public f(ContentResolver paramContentResolver, Uri paramUri, int paramInt, String paramString)
  {
    super(paramContentResolver, paramUri, paramInt, paramString);
  }

  protected a a(Cursor paramCursor)
  {
    long l1 = paramCursor.getLong(0);
    String str1 = paramCursor.getString(1);
    long l2 = paramCursor.getLong(2);
    if (l2 == 0L)
      l2 = 1000L * paramCursor.getLong(7);
    long l3 = paramCursor.getLong(3);
    int i = paramCursor.getInt(4);
    String str2 = paramCursor.getString(5);
    String str3 = paramCursor.getString(6);
    if ((str2 == null) || (str2.length() == 0))
      str2 = str1;
    return new e(this, this.a, l1, paramCursor.getPosition(), a(l1), str1, l3, str3, l2, str2, str2, i);
  }

  protected long b(Cursor paramCursor)
  {
    return paramCursor.getLong(0);
  }

  protected Cursor d()
  {
    return MediaStore.Images.Media.query(this.a, this.c, g, g(), h(), f());
  }

  protected String g()
  {
    if (this.e == null)
      return "(mime_type in (?, ?, ?))";
    return "(mime_type in (?, ?, ?)) AND bucket_id = ?";
  }

  protected String[] h()
  {
    if (this.e != null)
    {
      int i = h.length;
      String[] arrayOfString = new String[i + 1];
      System.arraycopy(h, 0, arrayOfString, 0, i);
      arrayOfString[i] = this.e;
      return arrayOfString;
    }
    return h;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.camera.a.f
 * JD-Core Version:    0.6.2
 */
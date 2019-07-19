package com.viber.voip.analytics.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.viber.provider.b;
import com.viber.provider.messages.b.d;
import com.viber.voip.ViberApplication;

public class g
{
  private static final String[] a = { "_id", "event_name", "last_tracked" };

  public long a(h paramh)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("last_tracked", Long.valueOf(System.currentTimeMillis()));
    b localb = a();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramh.a();
    long l = localb.a("adx", localContentValues, "event_name=?", arrayOfString);
    if (l == 0L)
    {
      localContentValues.put("event_name", paramh.a());
      l = localb.a("adx", null, localContentValues);
    }
    return l;
  }

  protected b a()
  {
    return d.a(ViberApplication.getApplication());
  }

  public long b(h paramh)
  {
    b localb = a();
    String[] arrayOfString1 = a;
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = paramh.a();
    Cursor localCursor = localb.a("adx", arrayOfString1, "event_name=?", arrayOfString2, null, null, null);
    long l = 0L;
    if (localCursor.moveToFirst())
      l = localCursor.getLong(2);
    localCursor.close();
    return l;
  }

  public void b()
  {
    b localb = a();
    localb.a();
    try
    {
      localb.a("adx", null, null);
      localb.c();
      return;
    }
    finally
    {
      localb.b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.a.g
 * JD-Core Version:    0.6.2
 */
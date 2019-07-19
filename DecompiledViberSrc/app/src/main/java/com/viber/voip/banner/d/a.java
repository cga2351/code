package com.viber.voip.banner.d;

import android.content.ContentValues;
import android.database.Cursor;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class a
{
  public static final String[] a = { "_id", "token", "type", "position", "end_time", "location", "meta", "tag", "dummy", "flags" };
  private static final Logger b = ViberEnv.getLogger();

  public static ContentValues a(d paramd)
  {
    return b(paramd);
  }

  public static ContentValues a(f paramf)
  {
    ContentValues localContentValues = b(paramf);
    localContentValues.put("location", paramf.i().toString());
    localContentValues.put("position", paramf.h().toString());
    return localContentValues;
  }

  public static ContentValues a(h paramh)
  {
    ContentValues localContentValues = b(paramh);
    localContentValues.put("location", paramh.h().toString());
    return localContentValues;
  }

  public static h a(Cursor paramCursor)
  {
    g localg = g.valueOf(paramCursor.getString(2));
    if (!localg.b())
      return null;
    h localh = (h)localg.c();
    localh.a(j.valueOf(paramCursor.getString(5)));
    a(paramCursor, localh);
    return localh;
  }

  private static void a(Cursor paramCursor, d paramd)
  {
    int i = 1;
    paramd.setId(paramCursor.getLong(0));
    paramd.a(paramCursor.getLong(i));
    paramd.b(paramCursor.getLong(4));
    paramd.a(paramCursor.getString(6));
    paramd.b(paramCursor.getString(7));
    if (paramCursor.getShort(8) > 0);
    while (true)
    {
      paramd.a(i);
      paramd.a(paramCursor.getInt(9));
      return;
      int j = 0;
    }
  }

  private static ContentValues b(d paramd)
  {
    ContentValues localContentValues = new ContentValues();
    if (paramd.getId() > 0L)
      localContentValues.put("_id", Long.valueOf(paramd.getId()));
    localContentValues.put("token", Long.valueOf(paramd.b()));
    localContentValues.put("type", paramd.a().toString());
    if (paramd.f());
    for (int i = 1; ; i = 0)
    {
      localContentValues.put("dummy", Integer.valueOf(i));
      localContentValues.put("end_time", Long.valueOf(paramd.d()));
      localContentValues.put("tag", paramd.e());
      localContentValues.put("meta", paramd.c());
      localContentValues.put("flags", Integer.valueOf(paramd.g()));
      return localContentValues;
    }
  }

  public static f b(Cursor paramCursor)
  {
    g localg = g.valueOf(paramCursor.getString(2));
    if (!localg.a())
      return null;
    f localf = (f)localg.c();
    localf.a(b.valueOf(paramCursor.getString(5)));
    localf.a(c.valueOf(paramCursor.getString(3)));
    a(paramCursor, localf);
    return localf;
  }

  public static d c(Cursor paramCursor)
  {
    g localg = g.valueOf(paramCursor.getString(2));
    if (!localg.a())
      return null;
    d locald = localg.c();
    a(paramCursor, locald);
    return locald;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.d.a
 * JD-Core Version:    0.6.2
 */
package com.viber.provider.messages.b.a;

import android.database.Cursor;
import com.crashlytics.android.a.m;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.provider.messages.c;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.af;
import java.util.ArrayList;
import java.util.Iterator;
import org.sqlite.database.sqlite.SQLiteDatabase;

public class a
{
  private Logger a;
  private b b;

  public a(SQLiteDatabase paramSQLiteDatabase, Logger paramLogger)
  {
    this.a = ViberEnv.getLogger(paramLogger);
    this.b = c.a(paramSQLiteDatabase);
  }

  private void a(int paramInt)
  {
    b(paramInt);
  }

  private ArrayList<Integer> b()
  {
    Cursor localCursor = this.b.a("SELECT _id FROM stickers_packages sp WHERE sp.flags & (1 << 2) <> 0 AND EXISTS (SELECT _id FROM stickers WHERE _id / 100 * 100 = sp._id AND package_id = 0) LIMIT 5", null);
    ArrayList localArrayList = new ArrayList();
    int i = localCursor.getColumnIndex("_id");
    if ((!af.b(localCursor)) && (localCursor.moveToFirst()))
    {
      do
        localArrayList.add(Integer.valueOf(localCursor.getInt(i)));
      while (localCursor.moveToNext());
      af.a(localCursor);
    }
    return localArrayList;
  }

  private void b(int paramInt)
  {
    this.b.a("UPDATE stickers_packages SET flags = flags | (1 << 9) WHERE _id = " + paramInt);
  }

  public void a()
  {
    Iterator localIterator = b().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      m localm = new m("broken_sticker_package");
      localm.a("package", Integer.valueOf(i));
      com.viber.voip.analytics.f.a.a(localm);
      a(i);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.messages.b.a.a
 * JD-Core Version:    0.6.2
 */
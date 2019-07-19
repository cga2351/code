package com.viber.voip.engagement.d;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.RawContacts;
import android.support.v4.util.LongSparseArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.af;

class d extends l
{
  private static final Logger a = ViberEnv.getLogger();
  private final a b;

  public d(a parama)
  {
    this.b = parama;
  }

  private final int a(int paramInt)
  {
    if (paramInt < 51)
      return 3;
    if (paramInt < 101)
      return 4;
    return 5;
  }

  public void a(k paramk)
  {
    int i = 0;
    Cursor localCursor = this.b.a();
    try
    {
      if (af.c(localCursor))
      {
        LongSparseArray localLongSparseArray = new LongSparseArray(Math.min(100, localCursor.getCount()));
        do
        {
          long l = localCursor.getLong(0);
          localLongSparseArray.put(l, Integer.valueOf(localCursor.getInt(1) + ((Integer)localLongSparseArray.get(l, Integer.valueOf(0))).intValue()));
        }
        while (localCursor.moveToNext());
        int j = localLongSparseArray.size();
        while (i < j)
        {
          paramk.a(localLongSparseArray.keyAt(i), a(((Integer)localLongSparseArray.valueAt(i)).intValue()));
          i++;
        }
      }
      return;
    }
    finally
    {
      af.a(localCursor);
    }
  }

  public static class a
  {
    private static final Uri a = ContactsContract.RawContacts.CONTENT_URI;
    private static final String[] b = { "contact_id", "times_contacted" };
    private static String c = "times_contacted > 0";
    private final ContentResolver d;

    public a(ContentResolver paramContentResolver)
    {
      this.d = paramContentResolver;
    }

    public Cursor a()
    {
      return this.d.query(a, b, c, null, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.d.d
 * JD-Core Version:    0.6.2
 */
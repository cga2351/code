package com.viber.voip.shareviber.invitescreen.b;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Data;
import android.support.v4.util.ArrayMap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.af;

class b
  implements j
{
  private static final Logger a = ViberEnv.getLogger();
  private final a b;

  public b(a parama)
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

  public void a(h paramh)
  {
    int i = 0;
    Cursor localCursor = this.b.a();
    try
    {
      if (af.c(localCursor))
      {
        ArrayMap localArrayMap = new ArrayMap(Math.min(100, localCursor.getCount()));
        long l = localCursor.getLong(0);
        int j = localCursor.getInt(1);
        String str = i.a(l, localCursor.getString(2));
        Integer localInteger = (Integer)localArrayMap.get(str);
        if (localInteger == null);
        int k;
        for (int m = 0; ; m = k)
        {
          localArrayMap.put(str, Integer.valueOf(m + j));
          if (localCursor.moveToNext())
            break;
          int n = localArrayMap.size();
          while (i < n)
          {
            int i1 = a(((Integer)localArrayMap.valueAt(i)).intValue());
            paramh.a((String)localArrayMap.keyAt(i), i1);
            i++;
          }
          k = localInteger.intValue();
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
    private static final Uri a = ContactsContract.Data.CONTENT_URI;
    private static final String[] b = { "contact_id", "times_contacted", "data1" };
    private static String c = "times_contacted > 0 AND mimetype=?";
    private final ContentResolver d;

    public a(ContentResolver paramContentResolver)
    {
      this.d = paramContentResolver;
    }

    public Cursor a()
    {
      return this.d.query(a, b, c, new String[] { "vnd.android.cursor.item/phone_v2" }, null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.shareviber.invitescreen.b.b
 * JD-Core Version:    0.6.2
 */
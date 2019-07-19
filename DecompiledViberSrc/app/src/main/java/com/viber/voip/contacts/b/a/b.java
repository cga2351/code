package com.viber.voip.contacts.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.provider.contacts.a.c;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.orm.creator.CreatorHelper;
import com.viber.voip.model.d;
import com.viber.voip.model.entity.e;

public class b extends CreatorHelper
{
  private static final Logger a = ViberEnv.getLogger();
  private static final String[] b = { "phonebookcontact._id", "phonebookcontact.native_id", "phonebookcontact.display_name", "phonebookcontact.low_display_name", "phonebookcontact.numbers_name", "phonebookcontact.starred", "phonebookcontact.viber", "phonebookcontact.contact_lookup_key", "phonebookcontact.contact_hash", "phonebookcontact.has_number", "phonebookcontact.has_name", "phonebookcontact.native_photo_id", "phonebookcontact.recently_joined_date", "phonebookcontact.joined_date", "phonebookcontact.version", "phonebookcontact.flags", "phonebookcontact.phone_label", "phonebookcontact.phonetic_name" };

  public b()
  {
    super(e.class);
  }

  public e a()
  {
    return new e();
  }

  public d createInstance(Cursor paramCursor)
  {
    return createInstance(paramCursor, 0);
  }

  public d createInstance(Cursor paramCursor, int paramInt)
  {
    int i = 1;
    e locale = a();
    int k = paramInt + 0;
    try
    {
      locale.setId(paramCursor.getLong(k));
      locale.a(paramCursor.getLong(paramInt + 1));
      if (paramCursor.getInt(paramInt + 5) == i)
      {
        int m = i;
        locale.b(m);
        locale.i(paramCursor.getString(paramInt + 2));
        locale.m(paramCursor.getString(paramInt + 3));
        if (paramCursor.getInt(paramInt + 6) != i)
          break label318;
        int i1 = i;
        label109: locale.c(i1);
        locale.n(paramCursor.getString(paramInt + 7));
        if (paramCursor.getInt(paramInt + 9) != i)
          break label324;
        int i3 = i;
        label148: locale.d(i3);
        if (paramCursor.getInt(paramInt + 10) != i)
          break label330;
      }
      while (true)
      {
        locale.e(i);
        locale.b(paramCursor.getLong(paramInt + 11));
        locale.b(paramCursor.getInt(paramInt + 8));
        locale.d(paramCursor.getLong(paramInt + 13));
        locale.c(paramCursor.getLong(paramInt + 12));
        locale.l(paramCursor.getString(paramInt + 4));
        locale.d(paramCursor.getInt(paramInt + 15));
        locale.c(paramCursor.getInt(paramInt + 14));
        locale.k(paramCursor.getString(paramInt + 16));
        locale.j(paramCursor.getString(paramInt + 17));
        return locale;
        int n = 0;
        break;
        label318: int i2 = 0;
        break label109;
        label324: int i4 = 0;
        break label148;
        label330: int j = 0;
      }
    }
    catch (Exception localException)
    {
    }
    return locale;
  }

  public Uri getContentUri()
  {
    return a.c.a;
  }

  public ContentValues getContentValues(d paramd)
  {
    return paramd.getContentValues();
  }

  public String[] getProjections()
  {
    return b;
  }

  public String getTable()
  {
    return "";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.b.a.b
 * JD-Core Version:    0.6.2
 */
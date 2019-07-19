package com.viber.voip.contacts.b.a;

import android.database.Cursor;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.provider.contacts.a.c;
import com.viber.voip.ViberEnv;

public class e extends h
{
  private static final Logger c = ViberEnv.getLogger();
  protected String[] a = { "phonebookcontact._id", "phonebookcontact.native_id", "phonebookcontact.display_name", "phonebookcontact.low_display_name", "phonebookcontact.contact_lookup_key", "phonebookcontact.viber", "phonebookcontact.starred", "phonebookcontact.native_photo_id", "phonebookcontact.version", "phonebookcontact.phone_label", "GROUP_CONCAT(vibernumbers.member_id||'!:!'||vibernumbers.canonized_number||'!:!'||COALESCE(vibernumbers.photo,'')||'!:!'||vibernumbers.encrypted_member_id) AS viber_data", "GROUP_CONCAT(phonebookdata.data2||'!:!'||phonebookdata.int_data2) AS locale_numbers", "GROUP_CONCAT(phonebookdata.data2||'!:!'||phonebookdata.data3||'!:!'||phonebookdata.data1||'!:!'||ifnull(phonebookdata.data4, '')) AS all_numbers" };

  public com.viber.voip.model.d createInstance(Cursor paramCursor)
  {
    return createInstance(paramCursor, 0);
  }

  public com.viber.voip.model.d createInstance(Cursor paramCursor, int paramInt)
  {
    int i = 1;
    com.viber.voip.model.entity.d locald = new com.viber.voip.model.entity.d();
    try
    {
      locald.setId(paramCursor.getLong(0));
      locald.a(paramCursor.getLong(1));
      locald.i(paramCursor.getString(2));
      locald.m(paramCursor.getString(3));
      locald.n(paramCursor.getString(4));
      if (paramCursor.getInt(5) == i)
      {
        int k = i;
        locald.c(k);
        if (paramCursor.getInt(6) != i)
          break label204;
      }
      while (true)
      {
        locald.b(i);
        locald.b(paramCursor.getLong(7));
        locald.k(paramCursor.getString(9));
        locald.f(paramCursor.getString(10));
        locald.g(paramCursor.getString(11));
        locald.c(paramCursor.getInt(8));
        locald.c(paramCursor.getString(paramCursor.getColumnIndex("all_numbers")));
        return locald;
        int m = 0;
        break;
        label204: int j = 0;
      }
    }
    catch (Exception localException)
    {
    }
    return locald;
  }

  public Uri getContentUri()
  {
    return a.c.c;
  }

  public String[] getProjections()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.b.a.e
 * JD-Core Version:    0.6.2
 */
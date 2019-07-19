package com.viber.voip.contacts.b.a;

import android.database.Cursor;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.provider.contacts.a.c;
import com.viber.voip.ViberEnv;

public class f extends h
{
  private static final Logger c = ViberEnv.getLogger();
  protected String[] a = { "phonebookcontact._id", "phonebookcontact.native_id", "phonebookcontact.native_photo_id", "phonebookcontact.display_name", "phonebookcontact.viber", "GROUP_CONCAT(vibernumbers.member_id||'!:!'||vibernumbers.canonized_number||'!:!'||COALESCE(vibernumbers.photo,'')||'!:!'||vibernumbers.encrypted_member_id) AS viber_data", "GROUP_CONCAT(phonebookdata.data2) AS canonized_numbers" };

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
      locald.b(paramCursor.getLong(2));
      locald.i(paramCursor.getString(3));
      if (paramCursor.getInt(4) == i);
      while (true)
      {
        locald.c(i);
        locald.f(paramCursor.getString(5));
        locald.b(paramCursor.getString(6));
        return locald;
        int j = 0;
      }
    }
    catch (Exception localException)
    {
    }
    return locald;
  }

  public Uri getContentUri()
  {
    return a.c.f;
  }

  public String[] getProjections()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.b.a.f
 * JD-Core Version:    0.6.2
 */
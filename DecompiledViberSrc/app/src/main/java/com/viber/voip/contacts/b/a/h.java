package com.viber.voip.contacts.b.a;

import android.database.Cursor;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.provider.contacts.a.c;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.orm.creator.CreatorHelper;
import com.viber.voip.model.entity.e;

public class h extends CreatorHelper
{
  private static final Logger a = ViberEnv.getLogger();
  protected static final String[] b = addProjections(c.getProjections(), new String[] { "GROUP_CONCAT(vibernumbers.member_id||'!:!'||vibernumbers.canonized_number||'!:!'||COALESCE(vibernumbers.photo,'')||'!:!'||vibernumbers.encrypted_member_id) AS viber_data", "GROUP_CONCAT(phonebookdata.data2||'!:!'||phonebookdata.data3||'!:!'||phonebookdata.data1||'!:!'||ifnull(phonebookdata.data4, '')) AS all_numbers", "GROUP_CONCAT(phonebookdata.data2||'!:!'||ifnull(phonebookdata.data5,phonebookdata.data2)) AS numbers_labels" });
  private static final b c = new b()
  {
    public e a()
    {
      return new com.viber.voip.model.entity.d();
    }
  };

  public h()
  {
    super(e.class);
  }

  public com.viber.voip.model.entity.d a()
  {
    return new com.viber.voip.model.entity.d();
  }

  public com.viber.voip.model.d createInstance(Cursor paramCursor)
  {
    return createInstance(paramCursor, 0);
  }

  public com.viber.voip.model.d createInstance(Cursor paramCursor, int paramInt)
  {
    com.viber.voip.model.entity.d locald = (com.viber.voip.model.entity.d)c.createInstance(paramCursor, paramInt);
    try
    {
      locald.f(paramCursor.getString(paramCursor.getColumnIndex("viber_data")));
      locald.c(paramCursor.getString(paramCursor.getColumnIndex("all_numbers")));
      locald.e(paramCursor.getString(paramCursor.getColumnIndex("numbers_labels")));
      return locald;
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
    return b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.b.a.h
 * JD-Core Version:    0.6.2
 */
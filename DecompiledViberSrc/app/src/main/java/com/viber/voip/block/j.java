package com.viber.voip.block;

import android.database.Cursor;
import android.text.TextUtils;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.d.c;
import com.viber.voip.model.entity.m;

public class j
{
  public static final String[] a = { "blockednumbers._id", "blockednumbers.canonized_number", "vibernumbers.canonized_number", "phonebookdata.data2", "blockednumbers.blocked_date", "GROUP_CONCAT(phonebookcontact.display_name, ', ')", "phonebookcontact._id", "phonebookcontact.contact_lookup_key" };
  private long b;
  private String c;
  private String d;
  private long e;
  private String f;
  private long g;
  private String h;

  public j(Cursor paramCursor)
  {
    a(this, paramCursor);
  }

  private static void a(j paramj, Cursor paramCursor)
  {
    paramj.b = paramCursor.getLong(0);
    paramj.c = paramCursor.getString(1);
    paramj.d = paramCursor.getString(2);
    if (TextUtils.isEmpty(paramj.d))
    {
      paramj.d = c.c().b(paramj.a(), 1);
      if (TextUtils.isEmpty(paramj.d))
      {
        paramj.d = paramCursor.getString(3);
        if (TextUtils.isEmpty(paramj.d))
          paramj.d = paramCursor.getString(1);
      }
    }
    paramj.e = paramCursor.getLong(4);
    paramj.f = paramCursor.getString(5);
    if (TextUtils.isEmpty(paramj.f))
    {
      m localm = c.c().c(paramj.a(), 1);
      if (localm != null)
        paramj.f = localm.o();
    }
    paramj.g = paramCursor.getLong(6);
    paramj.h = paramCursor.getString(7);
  }

  public String a()
  {
    return this.c;
  }

  public String b()
  {
    return this.d;
  }

  public String c()
  {
    return this.f;
  }

  public boolean d()
  {
    return !TextUtils.isEmpty(this.f);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.block.j
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.contacts.b.a;

import android.database.Cursor;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.provider.contacts.a.c;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.orm.creator.Creator;
import com.viber.voip.messages.orm.creator.CreatorHelper;
import com.viber.voip.model.entity.e;

public class g extends CreatorHelper
{
  public static final int a = 18;
  public static final int b = 1 + a;
  public static final int c = 1 + b;
  public static final int d = 1 + c;
  public static final int e = 1 + d;
  public static final int f = 1 + e;
  public static final int g = 1 + f;
  public static final int h = 1 + g;
  protected static final String[] i = addProjections(k.getProjections(), new String[] { "vibernumbers.member_id", "vibernumbers.canonized_number", "vibernumbers.photo", "phonebookdata.data2", "phonebookdata.data3", "phonebookdata.data1", "phonebookdata.data4", "phonebookdata.data5" });
  private static final Logger j = ViberEnv.getLogger();
  private static final b k = new b()
  {
    public e a()
    {
      return new com.viber.voip.model.entity.d();
    }
  };

  public g()
  {
    super(e.class);
  }

  public com.viber.voip.model.entity.d a()
  {
    return new com.viber.voip.model.entity.d();
  }

  protected Creator b()
  {
    return k;
  }

  public com.viber.voip.model.d createInstance(Cursor paramCursor)
  {
    return createInstance(paramCursor, 0);
  }

  public com.viber.voip.model.d createInstance(Cursor paramCursor, int paramInt)
  {
    com.viber.voip.model.entity.d locald = (com.viber.voip.model.entity.d)b().createInstance(paramCursor, paramInt);
    try
    {
      locald.f(paramCursor.getString(paramInt + a) + "!:!" + paramCursor.getString(paramInt + d) + "!:!" + paramCursor.getString(paramInt + c));
      locald.c(paramCursor.getString(paramInt + d) + "!:!" + paramCursor.getString(paramInt + e) + "!:!" + paramCursor.getString(paramInt + f) + "!:!" + paramCursor.getString(paramInt + g));
      locald.e(paramCursor.getString(paramInt + a) + "!:!" + paramCursor.getString(paramInt + h));
      locald.d(paramCursor.getString(g));
      return locald;
    }
    catch (Exception localException)
    {
    }
    return locald;
  }

  public Uri getContentUri()
  {
    return a.c.g;
  }

  public String[] getProjections()
  {
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.b.a.g
 * JD-Core Version:    0.6.2
 */
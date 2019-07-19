package com.viber.voip.backgrounds.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.backgrounds.p;
import com.viber.voip.settings.d.i;
import com.viber.voip.util.af;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private static final String[] b = { "background_id", "color" };

  private p a(Cursor paramCursor)
  {
    int i = d.i.a.d();
    int j = paramCursor.getInt(0);
    String str = paramCursor.getString(1);
    p localp = new p(j, i, true, str);
    localp.c = str;
    return localp;
  }

  private b c()
  {
    return com.viber.provider.messages.b.d.a(ViberApplication.getApplication());
  }

  public List<p> a()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Cursor localCursor2 = c().a("backgrounds", b, null, null, null, null, null);
      localCursor1 = localCursor2;
      try
      {
        if (af.b(localCursor1))
          break label68;
        while (localCursor1.moveToNext())
          localArrayList.add(a(localCursor1));
      }
      finally
      {
      }
      af.a(localCursor1);
      throw localObject1;
      label68: af.a(localCursor1);
      return localArrayList;
    }
    finally
    {
      while (true)
        Cursor localCursor1 = null;
    }
  }

  public void a(com.viber.voip.backgrounds.a parama)
  {
    b localb = c();
    localb.a();
    try
    {
      b();
      List localList = parama.c();
      int i = localList.size();
      for (int j = 0; j < i; j++)
      {
        p localp = (p)localList.get(j);
        ContentValues localContentValues = new ContentValues(2);
        localContentValues.put("background_id", Integer.valueOf(localp.a));
        localContentValues.put("color", localp.c);
        c().a("backgrounds", null, localContentValues);
      }
      localb.c();
      return;
    }
    finally
    {
      localb.b();
    }
  }

  public int b()
  {
    return c().a("backgrounds", null, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.b.a
 * JD-Core Version:    0.6.2
 */
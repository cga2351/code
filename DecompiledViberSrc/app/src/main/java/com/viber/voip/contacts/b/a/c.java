package com.viber.voip.contacts.b.a;

import android.database.Cursor;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.orm.creator.Creator;
import com.viber.voip.messages.orm.creator.JoinCreator;
import com.viber.voip.model.d;
import com.viber.voip.model.entity.e;
import com.viber.voip.model.entity.f;
import com.viber.voip.model.entity.s;
import com.viber.voip.model.entity.t;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class c extends JoinCreator
{
  private static final Logger a = ViberEnv.getLogger();
  private static final b b = new b()
  {
    public e a()
    {
      return new f();
    }
  };
  private int c = 0;

  public c()
  {
    super(localUri, e.class, arrayOfCreator);
  }

  private boolean a(long paramLong, Cursor paramCursor)
  {
    try
    {
      boolean bool1 = paramCursor.moveToNext();
      boolean bool2 = false;
      if (bool1)
      {
        long l = paramCursor.getLong(this.c);
        boolean bool3 = paramLong < l;
        bool2 = false;
        if (!bool3)
          bool2 = true;
      }
      return bool2;
    }
    catch (Exception localException)
    {
      a.a(localException, "moveToNextAndCheckEqualId error!");
    }
    return false;
  }

  public d createInstance(Cursor paramCursor)
  {
    f localf;
    try
    {
      HashMap localHashMap = new HashMap();
      long l = paramCursor.getLong(this.c);
      localf = null;
      do
      {
        s locals1 = (s)createInstancesInternal(paramCursor, s.a);
        t localt = (t)createInstancesInternal(paramCursor, t.j);
        if (localf == null)
          localf = (f)createInstancesInternal(paramCursor, b);
        if (!localHashMap.containsKey(locals1))
        {
          locals1.a(localf);
          localHashMap.put(locals1, new HashSet());
        }
        if ((localt != null) && (localt.getId() != 0L))
        {
          localt.a(locals1);
          localt.a(localf);
          ((Set)localHashMap.get(locals1)).add(localt);
        }
      }
      while (a(l, paramCursor));
      localf.a(new HashSet(localHashMap.keySet()));
      Iterator localIterator = localf.a().iterator();
      while (localIterator.hasNext())
      {
        s locals2 = (s)localIterator.next();
        locals2.a((Set)localHashMap.get(locals2));
      }
    }
    finally
    {
    }
    return localf;
  }

  public int getAggregateField()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.b.a.c
 * JD-Core Version:    0.6.2
 */
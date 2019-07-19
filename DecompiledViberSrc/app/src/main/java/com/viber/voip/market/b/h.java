package com.viber.voip.market.b;

import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.m;
import com.viber.voip.contacts.c.d.m.c;
import com.viber.voip.model.a;
import com.viber.voip.util.dd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class h
{
  private static final Logger a = ViberEnv.getLogger();

  public void a(ArrayList<String> paramArrayList, final a parama)
  {
    if (paramArrayList.isEmpty())
    {
      parama.a(new HashMap());
      return;
    }
    new Bundle().putStringArrayList("numbers", paramArrayList);
    ViberApplication.getInstance().getContactManager().c().a(new HashSet(paramArrayList), new m.c()
    {
      public void a(Map<String, List<a>> paramAnonymousMap, Map<Long, a> paramAnonymousMap1)
      {
        final HashMap localHashMap = new HashMap();
        Iterator localIterator = paramAnonymousMap.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (localEntry.getValue() != null);
          for (String str = ((a)((List)localEntry.getValue()).iterator().next()).k(); ; str = null)
          {
            localHashMap.put(localEntry.getKey(), str);
            break;
          }
        }
        dd.a(new Runnable()
        {
          public void run()
          {
            h.1.this.a.a(localHashMap);
          }
        });
      }
    });
  }

  public static abstract interface a
  {
    public abstract void a(Map<String, String> paramMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.b.h
 * JD-Core Version:    0.6.2
 */
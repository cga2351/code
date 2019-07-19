package com.viber.voip.analytics.f;

import android.support.v4.util.ArrayMap;
import com.crashlytics.android.a.m;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.e;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class b
  implements e.b
{
  private static final Logger a = ViberEnv.getLogger();

  public void a()
  {
  }

  public void a(e parame)
  {
    Map.Entry localEntry1 = parame.a(d.class);
    if (localEntry1 == null)
      return;
    m localm = new m((String)localEntry1.getValue());
    Iterator localIterator = parame.a(d.class, new String[] { "key_property_name" }).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator.next();
      if ((localEntry2.getValue() instanceof String))
        localm.a((String)localEntry2.getKey(), (String)localEntry2.getValue());
    }
    a.a(localm);
  }

  public void b()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.f.b
 * JD-Core Version:    0.6.2
 */
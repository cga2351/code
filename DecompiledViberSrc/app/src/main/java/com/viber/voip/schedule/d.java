package com.viber.voip.schedule;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class d
{
  private static final Logger a = ViberEnv.getLogger();
  private o b = new o(ViberApplication.getApplication(), this.c);
  private a c = new a();

  public static d a()
  {
    return b.a();
  }

  public void a(JSONObject paramJSONObject)
  {
    a.a(this.c, paramJSONObject);
  }

  public a b()
  {
    return this.c;
  }

  public o c()
  {
    return this.b;
  }

  public void d()
  {
    this.b.f();
  }

  public static class a
  {
    Set<d.c> a = new HashSet();

    private void a(JSONObject paramJSONObject)
    {
      synchronized (this.a)
      {
        Iterator localIterator = this.a.iterator();
        if (localIterator.hasNext())
          ((d.c)localIterator.next()).a(paramJSONObject);
      }
    }

    public void a(d.c paramc)
    {
      synchronized (this.a)
      {
        this.a.add(paramc);
        return;
      }
    }
  }

  private static final class b
  {
    private static final d a = new d(null);
  }

  public static abstract interface c
  {
    public abstract void a(JSONObject paramJSONObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.schedule.d
 * JD-Core Version:    0.6.2
 */
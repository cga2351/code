package com.appboy.e.a;

import a.a.au;
import a.a.bc;
import a.a.cz;
import a.a.di;
import a.a.dr;
import com.appboy.b.b;
import com.appboy.b.c.a;
import com.appboy.b.d;
import com.appboy.e.e;
import com.appboy.f.i;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import org.json.JSONArray;
import org.json.JSONObject;

public class c extends Observable
  implements e<JSONObject>
{
  private static final String a = com.appboy.f.c.a(c.class);
  private final JSONObject b;
  private final Map<String, String> c;
  private final String d;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private final long k;
  private final long l;
  private final long m;
  private boolean n = false;
  private final EnumSet<b> o;
  private boolean p;
  private final au q;
  private final cz r;
  private final bc s;

  public c(JSONObject paramJSONObject, c.a parama, au paramau, cz paramcz, bc parambc)
  {
    this.b = paramJSONObject;
    this.q = paramau;
    this.r = paramcz;
    this.s = parambc;
    this.c = dr.a(paramJSONObject.optJSONObject(parama.a(com.appboy.b.c.e)), new HashMap());
    this.d = paramJSONObject.getString(parama.a(com.appboy.b.c.a));
    this.e = paramJSONObject.optBoolean(parama.a(com.appboy.b.c.b));
    this.g = paramJSONObject.optBoolean(parama.a(com.appboy.b.c.j), false);
    this.i = paramJSONObject.optBoolean(parama.a(com.appboy.b.c.l), false);
    this.k = paramJSONObject.getLong(parama.a(com.appboy.b.c.c));
    this.m = paramJSONObject.optLong(parama.a(com.appboy.b.c.d), -1L);
    this.n = paramJSONObject.optBoolean(parama.a(com.appboy.b.c.f), false);
    this.h = paramJSONObject.optBoolean(parama.a(com.appboy.b.c.k), false);
    JSONArray localJSONArray = paramJSONObject.optJSONArray(parama.a(com.appboy.b.c.h));
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
      this.o = EnumSet.of(b.e);
    while (true)
    {
      this.l = paramJSONObject.optLong(parama.a(com.appboy.b.c.i), this.k);
      this.p = paramJSONObject.optBoolean(parama.a(com.appboy.b.c.m), false);
      this.f = paramJSONObject.optBoolean(parama.a(com.appboy.b.c.n), this.e);
      this.j = paramJSONObject.optBoolean(parama.a(com.appboy.b.c.o), false);
      return;
      this.o = EnumSet.noneOf(b.class);
      for (int i1 = 0; i1 < localJSONArray.length(); i1++)
      {
        b localb = b.a(localJSONArray.getString(i1));
        if (localb != null)
          this.o.add(localb);
      }
    }
  }

  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    setChanged();
    notifyObservers();
    if ((paramBoolean) && (this.r != null));
    try
    {
      this.r.a(this.d);
      return;
    }
    catch (Exception localException)
    {
      com.appboy.f.c.a(a, "Failed to mark card indicator as highlighted.", localException);
    }
  }

  public boolean a(c paramc)
  {
    return (this.d.equals(paramc.m())) && (this.l == paramc.q()) && (this.q == paramc.q);
  }

  public boolean a(EnumSet<b> paramEnumSet)
  {
    Iterator localIterator = paramEnumSet.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (this.o.contains(localb))
        return true;
    }
    return false;
  }

  public String b()
  {
    return null;
  }

  public void b(boolean paramBoolean)
  {
    if ((this.g) && (paramBoolean))
      com.appboy.f.c.d(a, "Cannot dismiss a card more than once. Doing nothing.");
    while (true)
    {
      return;
      this.g = paramBoolean;
      if (this.r != null)
        this.r.d(this.d);
      if (paramBoolean)
        try
        {
          if ((this.q != null) && (this.s != null) && (w()))
          {
            this.q.a(this.s.c(this.d));
            return;
          }
        }
        catch (Exception localException)
        {
          com.appboy.f.c.c(a, "Failed to log card dismissed.", localException);
        }
    }
  }

  public void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (this.r != null)
      this.r.b(this.d);
  }

  public d d()
  {
    return d.c;
  }

  public boolean i()
  {
    try
    {
      if ((this.q != null) && (this.s != null) && (this.r != null) && (w()))
      {
        if (!u())
        {
          com.appboy.f.c.a(a, "Logging impression event for card with id: " + this.d);
          this.q.a(this.s.a(this.d));
        }
        while (true)
        {
          this.r.b(this.d);
          return true;
          com.appboy.f.c.a(a, "Logging control impression event for card with id: " + this.d);
          this.q.a(this.s.d(this.d));
        }
      }
    }
    catch (Exception localException)
    {
      com.appboy.f.c.c(a, "Failed to log card impression for card id: " + this.d, localException);
    }
    return false;
  }

  public boolean j()
  {
    try
    {
      this.j = true;
      if ((this.q != null) && (this.s != null) && (this.r != null) && (w()))
      {
        this.q.a(this.s.e(this.d));
        this.r.c(this.d);
        return true;
      }
      com.appboy.f.c.d(a, "Failed to log card clicked.");
      return false;
    }
    catch (Exception localException)
    {
      while (true)
        com.appboy.f.c.c(a, "Failed to log card as clicked.", localException);
    }
  }

  public boolean k()
  {
    return this.f;
  }

  public boolean l()
  {
    return this.e;
  }

  public String m()
  {
    return this.d;
  }

  public Map<String, String> n()
  {
    return this.c;
  }

  public boolean o()
  {
    return this.i;
  }

  public boolean p()
  {
    return this.n;
  }

  public long q()
  {
    return this.l;
  }

  public boolean r()
  {
    return this.p;
  }

  public long s()
  {
    return this.m;
  }

  public boolean t()
  {
    return (s() != -1L) && (s() <= di.a());
  }

  public String toString()
  {
    return "mId='" + this.d + '\'' + ", mViewed='" + this.e + '\'' + ", mCreated='" + this.k + '\'' + ", mUpdated='" + this.l + '\'' + ", mIsClicked='" + this.j + '\'';
  }

  public boolean u()
  {
    return d() == d.f;
  }

  public JSONObject v()
  {
    return this.b;
  }

  boolean w()
  {
    if (i.c(this.d))
    {
      com.appboy.f.c.e(a, "Card ID cannot be null");
      return false;
    }
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.e.a.c
 * JD-Core Version:    0.6.2
 */
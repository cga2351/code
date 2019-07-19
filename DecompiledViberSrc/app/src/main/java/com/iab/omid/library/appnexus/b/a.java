package com.iab.omid.library.appnexus.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class a
{
  private static a a = new a();
  private final ArrayList<com.iab.omid.library.appnexus.adsession.a> b = new ArrayList();
  private final ArrayList<com.iab.omid.library.appnexus.adsession.a> c = new ArrayList();

  public static a a()
  {
    return a;
  }

  public void a(com.iab.omid.library.appnexus.adsession.a parama)
  {
    this.b.add(parama);
  }

  public Collection<com.iab.omid.library.appnexus.adsession.a> b()
  {
    return Collections.unmodifiableCollection(this.b);
  }

  public void b(com.iab.omid.library.appnexus.adsession.a parama)
  {
    boolean bool = d();
    this.c.add(parama);
    if (!bool)
      e.a().b();
  }

  public Collection<com.iab.omid.library.appnexus.adsession.a> c()
  {
    return Collections.unmodifiableCollection(this.c);
  }

  public void c(com.iab.omid.library.appnexus.adsession.a parama)
  {
    boolean bool = d();
    this.b.remove(parama);
    this.c.remove(parama);
    if ((bool) && (!d()))
      e.a().c();
  }

  public boolean d()
  {
    return this.c.size() > 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.b.a
 * JD-Core Version:    0.6.2
 */
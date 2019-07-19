package com.iab.omid.library.appnexus.b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.appnexus.a.c;
import com.iab.omid.library.appnexus.a.d;
import com.iab.omid.library.appnexus.publisher.AdSessionStatePublisher;
import com.iab.omid.library.appnexus.walking.TreeWalker;
import java.util.Collection;
import java.util.Iterator;

public class e
  implements c, b.a
{
  private static e a;
  private float b = 0.0F;
  private final com.iab.omid.library.appnexus.a.e c;
  private final com.iab.omid.library.appnexus.a.b d;
  private d e;
  private a f;

  public e(com.iab.omid.library.appnexus.a.e parame, com.iab.omid.library.appnexus.a.b paramb)
  {
    this.c = parame;
    this.d = paramb;
  }

  public static e a()
  {
    if (a == null)
    {
      com.iab.omid.library.appnexus.a.b localb = new com.iab.omid.library.appnexus.a.b();
      a = new e(new com.iab.omid.library.appnexus.a.e(), localb);
    }
    return a;
  }

  private a e()
  {
    if (this.f == null)
      this.f = a.a();
    return this.f;
  }

  public void a(float paramFloat)
  {
    this.b = paramFloat;
    Iterator localIterator = e().c().iterator();
    while (localIterator.hasNext())
      ((com.iab.omid.library.appnexus.adsession.a)localIterator.next()).getAdSessionStatePublisher().a(paramFloat);
  }

  public void a(Context paramContext)
  {
    com.iab.omid.library.appnexus.a.a locala = this.d.a();
    this.e = this.c.a(new Handler(), paramContext, locala, this);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      TreeWalker.getInstance().a();
      return;
    }
    TreeWalker.getInstance().c();
  }

  public void b()
  {
    b.a().a(this);
    b.a().b();
    if (b.a().d())
      TreeWalker.getInstance().a();
    this.e.a();
  }

  public void c()
  {
    TreeWalker.getInstance().b();
    b.a().c();
    this.e.b();
  }

  public float d()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.b.e
 * JD-Core Version:    0.6.2
 */
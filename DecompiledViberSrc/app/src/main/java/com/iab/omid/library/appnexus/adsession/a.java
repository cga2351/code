package com.iab.omid.library.appnexus.adsession;

import android.view.View;
import com.iab.omid.library.appnexus.publisher.AdSessionStatePublisher;
import com.iab.omid.library.appnexus.publisher.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class a extends AdSession
{
  private final AdSessionContext a;
  private final AdSessionConfiguration b;
  private final List<com.iab.omid.library.appnexus.e.a> c = new ArrayList();
  private com.iab.omid.library.appnexus.e.a d;
  private AdSessionStatePublisher e;
  private boolean f = false;
  private boolean g = false;
  private String h;
  private boolean i;

  a(AdSessionConfiguration paramAdSessionConfiguration, AdSessionContext paramAdSessionContext)
  {
    this.b = paramAdSessionConfiguration;
    this.a = paramAdSessionContext;
    this.h = UUID.randomUUID().toString();
    c(null);
    if (paramAdSessionContext.getAdSessionContextType() == AdSessionContextType.HTML);
    for (this.e = new com.iab.omid.library.appnexus.publisher.a(paramAdSessionContext.getWebView()); ; this.e = new b(paramAdSessionContext.getVerificationScriptResources(), paramAdSessionContext.getOmidJsScriptContent()))
    {
      this.e.a();
      com.iab.omid.library.appnexus.b.a.a().a(this);
      this.e.a(paramAdSessionConfiguration);
      return;
    }
  }

  private com.iab.omid.library.appnexus.e.a a(View paramView)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      com.iab.omid.library.appnexus.e.a locala = (com.iab.omid.library.appnexus.e.a)localIterator.next();
      if (locala.get() == paramView)
        return locala;
    }
    return null;
  }

  private void b(View paramView)
  {
    if (paramView == null)
      throw new IllegalArgumentException("FriendlyObstruction is null");
  }

  private void c(View paramView)
  {
    this.d = new com.iab.omid.library.appnexus.e.a(paramView);
  }

  private void d(View paramView)
  {
    Collection localCollection = com.iab.omid.library.appnexus.b.a.a().b();
    if ((localCollection != null) && (localCollection.size() > 0))
    {
      Iterator localIterator = localCollection.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if ((locala != this) && (locala.c() == paramView))
          locala.d.clear();
      }
    }
  }

  private void i()
  {
    if (this.i)
      throw new IllegalStateException("Impression event can only be sent once");
  }

  public List<com.iab.omid.library.appnexus.e.a> a()
  {
    return this.c;
  }

  public void addFriendlyObstruction(View paramView)
  {
    if (this.g);
    do
    {
      return;
      b(paramView);
    }
    while (a(paramView) != null);
    this.c.add(new com.iab.omid.library.appnexus.e.a(paramView));
  }

  void b()
  {
    i();
    getAdSessionStatePublisher().g();
    this.i = true;
  }

  public View c()
  {
    return (View)this.d.get();
  }

  public boolean d()
  {
    return (this.f) && (!this.g);
  }

  public boolean e()
  {
    return this.f;
  }

  public void error(ErrorType paramErrorType, String paramString)
  {
    if (this.g)
      throw new IllegalStateException("AdSession is finished");
    com.iab.omid.library.appnexus.d.e.a(paramErrorType, "Error type is null");
    com.iab.omid.library.appnexus.d.e.a(paramString, "Message is null");
    getAdSessionStatePublisher().a(paramErrorType, paramString);
  }

  public boolean f()
  {
    return this.g;
  }

  public void finish()
  {
    if (this.g)
      return;
    this.d.clear();
    removeAllFriendlyObstructions();
    this.g = true;
    getAdSessionStatePublisher().f();
    com.iab.omid.library.appnexus.b.a.a().c(this);
    getAdSessionStatePublisher().b();
    this.e = null;
  }

  public boolean g()
  {
    return this.b.isNativeImpressionOwner();
  }

  public String getAdSessionId()
  {
    return this.h;
  }

  public AdSessionStatePublisher getAdSessionStatePublisher()
  {
    return this.e;
  }

  public boolean h()
  {
    return this.b.isNativeVideoEventsOwner();
  }

  public void registerAdView(View paramView)
  {
    if (this.g);
    do
    {
      return;
      com.iab.omid.library.appnexus.d.e.a(paramView, "AdView is null");
    }
    while (c() == paramView);
    c(paramView);
    getAdSessionStatePublisher().h();
    d(paramView);
  }

  public void removeAllFriendlyObstructions()
  {
    if (this.g)
      return;
    this.c.clear();
  }

  public void removeFriendlyObstruction(View paramView)
  {
    if (this.g);
    com.iab.omid.library.appnexus.e.a locala;
    do
    {
      return;
      b(paramView);
      locala = a(paramView);
    }
    while (locala == null);
    this.c.remove(locala);
  }

  public void start()
  {
    if (this.f)
      return;
    this.f = true;
    com.iab.omid.library.appnexus.b.a.a().b(this);
    float f1 = com.iab.omid.library.appnexus.b.e.a().d();
    this.e.a(f1);
    this.e.a(this, this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.adsession.a
 * JD-Core Version:    0.6.2
 */
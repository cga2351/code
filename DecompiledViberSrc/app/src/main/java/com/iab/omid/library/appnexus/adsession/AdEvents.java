package com.iab.omid.library.appnexus.adsession;

import com.iab.omid.library.appnexus.d.e;
import com.iab.omid.library.appnexus.publisher.AdSessionStatePublisher;

public final class AdEvents
{
  private final a a;

  private AdEvents(a parama)
  {
    this.a = parama;
  }

  public static AdEvents createAdEvents(AdSession paramAdSession)
  {
    a locala = (a)paramAdSession;
    e.a(paramAdSession, "AdSession is null");
    e.d(locala);
    e.b(locala);
    AdEvents localAdEvents = new AdEvents(locala);
    locala.getAdSessionStatePublisher().a(localAdEvents);
    return localAdEvents;
  }

  public void impressionOccurred()
  {
    e.b(this.a);
    e.f(this.a);
    if (!this.a.d());
    try
    {
      this.a.start();
      label31: if (this.a.d())
        this.a.b();
      return;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.adsession.AdEvents
 * JD-Core Version:    0.6.2
 */
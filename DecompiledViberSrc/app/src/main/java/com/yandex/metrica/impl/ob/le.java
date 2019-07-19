package com.yandex.metrica.impl.ob;

import com.yandex.metrica.IReporter;
import com.yandex.metrica.Revenue;
import com.yandex.metrica.a.a;
import java.util.Map;

public class le
  implements IReporter
{
  static final px<String> a = new pt(new pr("Event name"));
  static final px<String> b = new pt(new pr("Error message"));
  static final px<Throwable> c = new pt(new ps("Unhandled exception"));
  static final px<a> d = new pt(new ps("User profile"));
  static final px<Revenue> e = new pt(new ps("Revenue"));

  public void pauseSession()
  {
  }

  public void reportError(String paramString, Throwable paramThrowable)
    throws pu
  {
    b.a(paramString);
  }

  public void reportEvent(String paramString)
    throws pu
  {
    a.a(paramString);
  }

  public void reportEvent(String paramString1, String paramString2)
    throws pu
  {
    a.a(paramString1);
  }

  public void reportEvent(String paramString, Map<String, Object> paramMap)
    throws pu
  {
    a.a(paramString);
  }

  public void reportRevenue(Revenue paramRevenue)
    throws pu
  {
    e.a(paramRevenue);
  }

  public void reportUnhandledException(Throwable paramThrowable)
    throws pu
  {
    c.a(paramThrowable);
  }

  public void reportUserProfile(a parama)
    throws pu
  {
    d.a(parama);
  }

  public void resumeSession()
  {
  }

  public void sendEventsBuffer()
  {
  }

  public void setStatisticsSending(boolean paramBoolean)
  {
  }

  public void setUserProfileID(String paramString)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.le
 * JD-Core Version:    0.6.2
 */
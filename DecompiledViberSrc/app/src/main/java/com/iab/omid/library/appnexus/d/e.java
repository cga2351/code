package com.iab.omid.library.appnexus.d;

import android.text.TextUtils;
import com.iab.omid.library.appnexus.Omid;
import com.iab.omid.library.appnexus.adsession.Owner;
import com.iab.omid.library.appnexus.adsession.a;
import com.iab.omid.library.appnexus.publisher.AdSessionStatePublisher;

public class e
{
  public static void a()
  {
    if (!Omid.isActive())
      throw new IllegalStateException("Method called before OMID activation");
  }

  public static void a(Owner paramOwner)
  {
    if (paramOwner.equals(Owner.NONE))
      throw new IllegalArgumentException("Impression owner is none");
  }

  public static void a(a parama)
  {
    if (parama.e())
      throw new IllegalStateException("AdSession is started");
  }

  public static void a(Object paramObject, String paramString)
  {
    if (paramObject == null)
      throw new IllegalArgumentException(paramString);
  }

  public static void a(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.length() > paramInt)
      throw new IllegalArgumentException(paramString2);
  }

  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
      throw new IllegalArgumentException(paramString2);
  }

  public static void b(a parama)
  {
    if (parama.f())
      throw new IllegalStateException("AdSession is finished");
  }

  public static void c(a parama)
  {
    h(parama);
    b(parama);
  }

  public static void d(a parama)
  {
    if (parama.getAdSessionStatePublisher().c() != null)
      throw new IllegalStateException("AdEvents already exists for AdSession");
  }

  public static void e(a parama)
  {
    if (parama.getAdSessionStatePublisher().d() != null)
      throw new IllegalStateException("VideoEvents already exists for AdSession");
  }

  public static void f(a parama)
  {
    if (!parama.g())
      throw new IllegalStateException("Impression event is not expected from the Native AdSession");
  }

  public static void g(a parama)
  {
    if (!parama.h())
      throw new IllegalStateException("Cannot create VideoEvents for JavaScript AdSession");
  }

  private static void h(a parama)
  {
    if (!parama.e())
      throw new IllegalStateException("AdSession is not started");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.d.e
 * JD-Core Version:    0.6.2
 */
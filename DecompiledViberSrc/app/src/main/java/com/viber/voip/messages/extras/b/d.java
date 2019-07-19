package com.viber.voip.messages.extras.b;

import android.app.Application;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.LocationEx;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.location.ViberLocationDelegate;
import com.viber.jni.location.ViberLocationListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.extras.map.b.f;
import com.viber.voip.p;
import com.viber.voip.settings.d.al;
import com.viber.voip.settings.d.bf;
import com.viber.voip.settings.d.r;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class d
  implements ViberLocationDelegate, a
{
  private static final Logger a = ViberEnv.getLogger();
  private static final long b = p.b();
  private long c;
  private long d;
  private boolean e;
  private Location f;
  private final LocationManager g;
  private final Map<Long, e> h = new HashMap();
  private final Handler i = av.a(av.e.j);
  private Address j;
  private Address k;
  private final d.al l;
  private final a.a m;
  private final com.viber.common.b.b n;

  public d(com.viber.common.b.b paramb)
  {
    com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[1];
    arrayOfa[0] = d.r.b;
    this.l = new d.al(arrayOfa)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        d.a(d.this, d.r.b.d());
        if (!d.a(d.this))
          d.b(d.this);
      }
    };
    this.m = e.a;
    this.n = paramb;
    this.g = ((LocationManager)ViberApplication.getApplication().getSystemService("location"));
    if (com.viber.voip.o.a.a() == com.viber.voip.o.a.a)
      c();
  }

  private double a(int paramInt, double paramDouble)
  {
    return b.a(paramInt, paramDouble, this.n.d());
  }

  private Address a(double paramDouble1, double paramDouble2)
  {
    Application localApplication = ViberApplication.getApplication();
    Locale localLocale = Locale.getDefault();
    if (TextUtils.isEmpty(localLocale.getCountry()))
      localLocale = Locale.ENGLISH;
    Geocoder localGeocoder = new Geocoder(localApplication, localLocale);
    while (true)
    {
      try
      {
        List localList = localGeocoder.getFromLocation(paramDouble1, paramDouble2, 1);
        if (localList.size() > 0)
        {
          localAddress = (Address)localList.get(0);
          return localAddress;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        return null;
      }
      catch (IOException localIOException)
      {
        return null;
      }
      Address localAddress = null;
    }
  }

  private Location a(int paramInt, Location paramLocation)
  {
    return b.a(paramInt, paramLocation, this.n.d());
  }

  private c a(double paramDouble1, double paramDouble2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Address localAddress = null;
    try
    {
      localAddress = a(paramDouble1, paramDouble2);
      if (localAddress != null)
        if (!paramBoolean)
          break label122;
      label107: label122: String str1;
      for (Object localObject = ""; ; localObject = str1)
      {
        String str2 = localAddress.getAddressLine(1);
        if (!TextUtils.isEmpty((CharSequence)localObject))
          localStringBuilder.append((String)localObject);
        if ((!TextUtils.isEmpty(str2)) && (!((String)localObject).equals(str2)))
        {
          a(localStringBuilder);
          localStringBuilder.append(str2);
        }
        a(localStringBuilder);
        localStringBuilder.append(localAddress.getCountryName());
        return new c(localAddress, localStringBuilder.toString());
        str1 = localAddress.getAddressLine(0);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label107;
    }
  }

  private String a(Address paramAddress, String paramString)
  {
    if ((paramAddress == null) || (paramAddress.getCountryName() == null));
    String str2;
    do
    {
      return paramString;
      if (TextUtils.isEmpty(paramString))
        return "";
      if ((TextUtils.isEmpty(paramAddress.getCountryName())) && (paramString.indexOf(",") != -1))
        return paramString.substring(0, paramString.indexOf(","));
      String str1 = paramString.replace(paramAddress.getCountryName(), " ");
      if (!TextUtils.isEmpty(paramAddress.getAddressLine(1)))
        str1 = str1.replace(paramAddress.getAddressLine(1), " ");
      str2 = str1.replace(",  ", "");
    }
    while (TextUtils.isEmpty(str2.trim()));
    return str2;
  }

  private void a(int paramInt, Address paramAddress)
  {
    if (2 == paramInt)
    {
      this.j = paramAddress;
      return;
    }
    this.k = paramAddress;
  }

  private void a(long paramLong, a.a parama)
  {
    Location localLocation = e();
    if (localLocation != null)
      parama.a(localLocation, c.b);
    do
    {
      do
      {
        return;
        if ((paramLong <= 0L) || (!this.g.isProviderEnabled("network")))
          break;
      }
      while (b(Long.valueOf(paramLong)));
      e locale = new e(parama, paramLong);
      try
      {
        this.g.requestLocationUpdates("network", 2000L, 1000.0F, locale);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        locale.a();
        return;
      }
    }
    while (b(20000L, parama));
    c(parama);
  }

  private void a(long paramLong, e parame)
  {
    synchronized (this.h)
    {
      this.h.put(Long.valueOf(paramLong), parame);
      return;
    }
  }

  private void a(Address paramAddress, String paramString, boolean paramBoolean, a.b paramb)
  {
    if (!paramBoolean)
    {
      paramb.a(paramAddress, paramString);
      return;
    }
    av.a(av.e.a).post(new m(paramb, paramAddress, paramString));
  }

  private void a(Location paramLocation)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.d > 120000L)
      c(paramLocation);
    this.d = l1;
  }

  private void a(LocationEx paramLocationEx)
  {
    try
    {
      ViberApplication.getInstance().getEngine(true).getPhoneController().handleSetLocation(paramLocationEx);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
    }
  }

  private void a(b.f paramf, boolean paramBoolean, a.b paramb)
  {
    Locale localLocale = Locale.getDefault();
    if (TextUtils.isEmpty(localLocale.getCountry()))
      localLocale = Locale.ENGLISH;
    Address localAddress = new Address(localLocale);
    localAddress.setLongitude(com.viber.voip.messages.extras.map.b.a(paramf.b().b()));
    localAddress.setLatitude(com.viber.voip.messages.extras.map.b.a(paramf.b().a()));
    localAddress.setLocality(paramf.d());
    a(localAddress, paramf.d(), paramBoolean, paramb);
  }

  private void a(StringBuilder paramStringBuilder)
  {
    if (paramStringBuilder.length() > 0)
      paramStringBuilder.append(", ");
  }

  private void b(int paramInt, double paramDouble1, double paramDouble2, boolean paramBoolean, a.b paramb)
  {
    int i1 = e(paramInt);
    if (c(i1))
    {
      b(new j(this, i1, paramBoolean, paramDouble1, paramDouble2, paramb));
      return;
    }
    c(i1, paramDouble1, paramDouble2, paramBoolean, paramb);
  }

  private void b(Location paramLocation)
  {
    if (paramLocation != null)
    {
      int i1 = (int)(10000000.0D * paramLocation.getAltitude());
      int i2 = (int)(10000000.0D * paramLocation.getLatitude());
      a(new LocationEx((int)(10000000.0D * paramLocation.getLongitude()), i2, i1, (int)(10000000.0D * paramLocation.getAccuracy()), 0, 0));
    }
  }

  private void b(a.a parama)
  {
    a(-1L, parama);
  }

  private boolean b(long paramLong, a.a parama)
  {
    if (this.g.isProviderEnabled("network"))
    {
      a locala = new a(new h(parama), (int)paramLong, null);
      try
      {
        this.g.requestLocationUpdates("network", 0L, 0.0F, locala);
        return true;
      }
      catch (SecurityException localSecurityException)
      {
        while (true)
          locala.a();
      }
    }
    return false;
  }

  private void c()
  {
    ViberApplication.getInstance().getEngine(false).getDelegatesManager().getViberLocationListener().registerDelegate(this, av.a(av.e.g));
    com.viber.voip.settings.d.a(this.l);
  }

  private void c(int paramInt, double paramDouble1, double paramDouble2, boolean paramBoolean, a.b paramb)
  {
    c(paramInt, paramDouble1, paramDouble2, paramBoolean, true, new k(this, paramb, paramBoolean, paramInt));
  }

  private void c(int paramInt, double paramDouble1, double paramDouble2, boolean paramBoolean1, boolean paramBoolean2, a.b paramb)
  {
    this.i.post(new l(this, paramInt, paramDouble1, paramDouble2, paramBoolean1, paramBoolean2, paramb));
  }

  private void c(long paramLong, a.a parama)
  {
    if (b(Long.valueOf(paramLong)))
    {
      a(Long.valueOf(paramLong));
      parama.a(null, c.a);
    }
  }

  private void c(Location paramLocation)
  {
    this.d = System.currentTimeMillis();
    this.f = paramLocation;
  }

  private void c(a.a parama)
  {
    this.i.post(new i(this, parama));
  }

  private boolean c(int paramInt)
  {
    if (2 == paramInt)
      if (this.j != null);
    while (this.k == null)
    {
      return true;
      return false;
    }
    return false;
  }

  private Address d(int paramInt)
  {
    if (2 == paramInt)
      return this.j;
    return this.k;
  }

  private void d()
  {
    a(new LocationEx(0, 0, 0, 0, 0, 0));
  }

  private int e(int paramInt)
  {
    return b.a(paramInt, this.n.d());
  }

  private Location e()
  {
    if (System.currentTimeMillis() - this.d > 120000L)
      this.f = null;
    return this.f;
  }

  private Location f()
    throws SecurityException
  {
    List localList = this.g.getAllProviders();
    Object localObject1 = null;
    Object localObject2;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localObject2 = this.g.getLastKnownLocation(str);
        if ((localObject2 == null) || ((localObject1 != null) && (((Location)localObject2).getTime() <= localObject1.getTime())))
          break label82;
      }
    }
    while (true)
    {
      localObject1 = localObject2;
      break;
      return localObject1;
      label82: localObject2 = localObject1;
    }
  }

  public Location a(int paramInt)
  {
    if (e() == null)
    {
      b(this.m);
      return null;
    }
    return a(paramInt, e());
  }

  public String a()
  {
    Location localLocation = b(0);
    String str = null;
    if (localLocation != null)
    {
      Address localAddress = a(localLocation.getLatitude(), localLocation.getLongitude());
      str = null;
      if (localAddress != null)
        str = localAddress.getCountryCode();
    }
    return str;
  }

  public void a(int paramInt, double paramDouble1, double paramDouble2, boolean paramBoolean, a.b paramb)
  {
    b(paramInt, paramDouble1, paramDouble2, paramBoolean, new d(paramb, paramInt, null));
  }

  public void a(int paramInt, double paramDouble1, double paramDouble2, boolean paramBoolean1, boolean paramBoolean2, a.b paramb)
  {
    c(paramInt, paramDouble1, paramDouble2, paramBoolean1, paramBoolean2, new d(paramb, paramInt, null));
  }

  public void a(int paramInt, long paramLong, a.a parama)
  {
    a(paramLong, new b(parama, paramInt, null));
  }

  public void a(int paramInt, a.a parama)
  {
    a(paramInt, -1L, parama);
  }

  public void a(Long paramLong)
  {
    if ((e)this.h.get(paramLong) != null)
      synchronized (this.h)
      {
        this.h.remove(paramLong);
        return;
      }
  }

  public boolean a(String paramString)
  {
    return this.g.isProviderEnabled(paramString);
  }

  public Location b(int paramInt)
  {
    try
    {
      Location localLocation = a(paramInt, f());
      return localLocation;
    }
    catch (SecurityException localSecurityException)
    {
    }
    return null;
  }

  public void b()
  {
    long l1 = System.currentTimeMillis();
    if ((this.e) && (l1 - this.c >= b))
      a(1, new f(this, l1));
  }

  public void b(int paramInt, long paramLong, a.a parama)
  {
    b localb = new b(parama, paramInt, null);
    if (!b(paramLong, localb))
      localb.a(null, c.a);
  }

  public boolean b(Long paramLong)
  {
    return this.h.containsKey(paramLong);
  }

  public void onSendLocation()
  {
    if (this.c == 0L)
    {
      d.bf.k.a(true);
      this.e = d.r.b.d();
    }
    b();
  }

  private class a
    implements LocationListener
  {
    private a.a b;
    private final Runnable c = new Runnable()
    {
      public void run()
      {
        d.c(d.this).removeUpdates(d.a.this);
        try
        {
          Location localLocation2 = d.this.b(2);
          localLocation1 = localLocation2;
          if (localLocation1 != null)
            d.a(d.this, localLocation1);
          if (d.d(d.this) == null)
            d.a.this.a();
          while (d.a.a(d.a.this) == null)
            return;
          d.a.a(d.a.this).a(d.d(d.this), d.c.a);
          return;
        }
        catch (SecurityException localSecurityException)
        {
          while (true)
            Location localLocation1 = null;
        }
      }
    };

    private a(a.a paramInt, int arg3)
    {
      this.b = paramInt;
      int i;
      d.e(d.this).postDelayed(this.c, i);
    }

    protected void a()
    {
      if (this.b != null)
        this.b.a(null, d.c.a);
    }

    public void onLocationChanged(Location paramLocation)
    {
      d.e(d.this).removeCallbacks(this.c);
      d.c(d.this).removeUpdates(this);
      d.b(d.this, paramLocation);
      if (this.b != null)
        this.b.a(paramLocation, d.c.b);
    }

    public void onProviderDisabled(String paramString)
    {
      d.e(d.this).removeCallbacks(this.c);
      d.c(d.this).removeUpdates(this);
      if (this.b != null)
        this.b.a(null, d.c.d);
    }

    public void onProviderEnabled(String paramString)
    {
    }

    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
    {
    }
  }

  class b
    implements a.a
  {
    private final a.a b;
    private final int c;

    private b(a.a paramInt, int arg3)
    {
      this.b = paramInt;
      int i;
      this.c = i;
    }

    public void a(Location paramLocation, d.c paramc)
    {
      if (this.b != null)
      {
        if ((this.c == 0) || ((1 == this.c) && (!d.f(d.this).d())))
          paramLocation = b.a(paramLocation);
        this.b.a(paramLocation, paramc);
      }
    }
  }

  public static enum c
  {
    static
    {
      c[] arrayOfc = new c[4];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
      arrayOfc[2] = c;
      arrayOfc[3] = d;
    }
  }

  class d
    implements a.b
  {
    private final a.b b;
    private final int c;

    private d(a.b paramInt, int arg3)
    {
      this.b = paramInt;
      int i;
      this.c = i;
    }

    public void a(Address paramAddress, String paramString)
    {
      if (this.b != null)
        this.b.a(paramAddress, paramString);
    }
  }

  private class e extends d.a
  {
    private long c;
    private a.a d;

    public e(a.a paramLong, long arg3)
    {
      super(paramLong, 20000, null);
      Object localObject;
      this.c = localObject;
      this.d = paramLong;
      d.a(d.this, localObject, this);
    }

    protected void a()
    {
      d.a(d.this, this.c, this.d);
    }

    public void onLocationChanged(Location paramLocation)
    {
      super.onLocationChanged(paramLocation);
      d.this.a(Long.valueOf(this.c));
    }

    public void onProviderDisabled(String paramString)
    {
      super.onProviderDisabled(paramString);
      d.this.a(Long.valueOf(this.c));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extras.b.d
 * JD-Core Version:    0.6.2
 */
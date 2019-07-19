package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.Location;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.yandex.metrica.impl.ac.GoogleAdvertisingIdGetter.b;
import com.yandex.metrica.impl.at;
import com.yandex.metrica.impl.az;
import com.yandex.metrica.impl.bt;
import com.yandex.metrica.impl.bw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

class hz extends at
{
  private Context a;
  private ig b;
  private final bt c;
  private hp l;
  private fm m;
  private fl n;
  private ho o;
  private fy p;
  private long q;
  private long r = -9223372036854775808L;
  private long s = -9223372036854775808L;

  public hz(Context paramContext, ig paramig, bt parambt)
  {
    this(paramContext, paramig, parambt, fj.a(paramContext).g(), fj.a(paramContext).h(), new ho(paramContext), new fy(fj.a(paramContext).c()));
  }

  hz(Context paramContext, ig paramig, bt parambt, fm paramfm, fl paramfl, ho paramho, fy paramfy)
  {
    this.a = paramContext;
    this.b = paramig;
    this.c = parambt;
    this.l = this.b.a();
    this.m = paramfm;
    this.n = paramfl;
    this.o = paramho;
    this.p = paramfy;
    this.q = (1L + this.p.b(-1L));
    a(this.b.b());
  }

  private kk.b.a[] b(List<hv> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(a((hv)localIterator.next()));
    return (kk.b.a[])localArrayList.toArray(new kk.b.a[localArrayList.size()]);
  }

  protected String E()
  {
    return "location";
  }

  protected void G()
  {
    this.m.c(this.r);
    this.n.c(this.s);
  }

  public void H()
  {
    if (this.r > -1L)
      this.m.c(this.r);
  }

  kk.b.a a(hv paramhv)
  {
    kk.b.a locala = new kk.b.a();
    locala.b = paramhv.a().longValue();
    locala.c = paramhv.b();
    JSONArray localJSONArray1 = paramhv.d();
    if (localJSONArray1 != null)
      locala.d = az.b(localJSONArray1);
    JSONArray localJSONArray2 = paramhv.c();
    if (localJSONArray2 != null)
      locala.e = az.a(localJSONArray2);
    return locala;
  }

  kk.b.b a(ic paramic)
  {
    int i = 1;
    kk.b.b localb = new kk.b.b();
    Location localLocation = paramic.c();
    localb.b = paramic.a().longValue();
    localb.d = localLocation.getTime();
    hp.a locala = paramic.a;
    int j;
    String str;
    switch (1.a[locala.ordinal()])
    {
    default:
      j = 0;
      localb.l = j;
      localb.c = paramic.b();
      localb.e = localLocation.getLatitude();
      localb.f = localLocation.getLongitude();
      localb.g = Math.round(localLocation.getAccuracy());
      localb.h = Math.round(localLocation.getBearing());
      localb.i = Math.round(localLocation.getSpeed());
      localb.j = ((int)Math.round(localLocation.getAltitude()));
      str = localLocation.getProvider();
      if (!"gps".equals(str))
        break;
    case 1:
    case 2:
    }
    while (true)
    {
      localb.k = i;
      return localb;
      j = 0;
      break;
      j = i;
      break;
      if ("network".equals(str))
        i = 2;
      else
        i = 0;
    }
  }

  kk.b a(List<ic> paramList, List<hv> paramList1)
  {
    kk.b localb = new kk.b();
    if (paramList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
        localArrayList.add(a((ic)localIterator.next()));
      localb.b = ((kk.b.b[])localArrayList.toArray(new kk.b.b[localArrayList.size()]));
    }
    if (paramList1.size() > 0)
      localb.c = b(paramList1);
    return localb;
  }

  protected void a(Uri.Builder paramBuilder)
  {
    super.a(paramBuilder);
    paramBuilder.appendPath("location");
    paramBuilder.appendQueryParameter("deviceid", this.b.q());
    paramBuilder.appendQueryParameter("device_type", this.b.A());
    paramBuilder.appendQueryParameter("uuid", this.b.r());
    paramBuilder.appendQueryParameter("analytics_sdk_version_name", this.b.h());
    paramBuilder.appendQueryParameter("analytics_sdk_build_number", this.b.i());
    paramBuilder.appendQueryParameter("analytics_sdk_build_type", this.b.j());
    paramBuilder.appendQueryParameter("app_version_name", this.b.p());
    paramBuilder.appendQueryParameter("app_build_number", this.b.o());
    paramBuilder.appendQueryParameter("os_version", this.b.m());
    paramBuilder.appendQueryParameter("os_api_level", String.valueOf(this.b.n()));
    paramBuilder.appendQueryParameter("is_rooted", this.b.s());
    paramBuilder.appendQueryParameter("app_framework", this.b.t());
    paramBuilder.appendQueryParameter("app_id", this.b.c());
    paramBuilder.appendQueryParameter("app_platform", this.b.k());
    paramBuilder.appendQueryParameter("android_id", this.b.z());
    paramBuilder.appendQueryParameter("request_id", String.valueOf(this.q));
    GoogleAdvertisingIdGetter.b localb = this.b.B();
    String str1;
    if (localb == null)
    {
      str1 = "";
      if (str1 == null)
        str1 = "";
      paramBuilder.appendQueryParameter("adv_id", str1);
      if (localb != null)
        break label325;
    }
    label325: for (String str2 = ""; ; str2 = a(localb.b))
    {
      paramBuilder.appendQueryParameter("limit_ad_tracking", str2);
      return;
      str1 = localb.a;
      break;
    }
  }

  List<ic> b(Map<Long, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.entrySet().iterator();
    label106: 
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Long localLong = (Long)localEntry.getKey();
      String str = (String)localEntry.getValue();
      if (str == null);
      for (Object localObject = null; ; localObject = this.o.a(localLong.longValue(), str))
      {
        if (localObject == null)
          break label106;
        localArrayList.add(localObject);
        break;
      }
    }
    return localArrayList;
  }

  public boolean b()
  {
    if (this.c.d());
    while ((TextUtils.isEmpty(this.b.q())) || (TextUtils.isEmpty(this.b.r())) || (bw.a(v())))
      return false;
    Map localMap1 = this.m.b(this.l.h);
    Map localMap2 = this.n.b(this.l.h);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (localMap1.size() > 0)
      this.r = ((Long)Collections.max(localMap1.keySet())).longValue();
    for (Object localObject1 = b(localMap1); ; localObject1 = localArrayList1)
    {
      if (localMap2.size() > 0)
        this.s = ((Long)Collections.max(localMap2.keySet())).longValue();
      for (Object localObject2 = c(localMap2); ; localObject2 = localArrayList2)
      {
        if ((((List)localObject1).size() != 0) || (((List)localObject2).size() != 0));
        for (boolean bool = c(e.a(a((List)localObject1, (List)localObject2))); ; bool = false)
          return bool;
      }
    }
  }

  List<hv> c(Map<Long, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.entrySet().iterator();
    label106: 
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Long localLong = (Long)localEntry.getKey();
      String str = (String)localEntry.getValue();
      if (str == null);
      for (Object localObject = null; ; localObject = this.o.b(localLong.longValue(), str))
      {
        if (localObject == null)
          break label106;
        localArrayList.add(localObject);
        break;
      }
    }
    return localArrayList;
  }

  public boolean c()
  {
    boolean bool = super.c();
    this.p.c(this.q).i();
    return bool;
  }

  public boolean w()
  {
    boolean bool1 = super.w();
    if (400 != n());
    for (boolean bool2 = true; ; bool2 = false)
      return bool2 & bool1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hz
 * JD-Core Version:    0.6.2
 */
package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.text.TextUtils;
import com.yandex.metrica.impl.interact.DeviceInfo;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.MobileAds;
import com.yandex.mobile.ads.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ab
{
  private final String A;
  private final Map<String, String> B;
  private final Long C;
  private final String D;
  private final String E;
  private final String F;
  private final String G;
  private final String H;
  private final String I;
  private final String J;
  private final String K;
  private final String L;
  private final String M;
  private final String N;
  private final String O;
  private final String P;
  private final String Q;
  private final Integer R;
  private final String S;
  private final String T;
  private final Boolean U;
  private final String V;
  private StringBuilder W;
  private final String a;
  private final String b;
  private final String c;
  private final Integer d;
  private final Integer e;
  private final String f;
  private final Integer g;
  private final Integer h;
  private final Float i;
  private final Location j;
  private final Integer k;
  private final Integer l;
  private final String m;
  private final String n;
  private final AdRequest o;
  private final Integer p;
  private final Integer q;
  private final String r;
  private final Boolean s;
  private final String t;
  private final Integer u;
  private final String v;
  private final String w;
  private final String x;
  private final String y;
  private final String z;

  private ab(a<?> parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama);
    this.g = a.g(parama);
    this.h = a.h(parama);
    this.i = a.i(parama);
    this.j = a.j(parama);
    this.k = a.k(parama);
    this.l = a.l(parama);
    this.m = a.m(parama);
    this.n = a.n(parama);
    this.o = a.o(parama);
    this.p = a.p(parama);
    this.q = a.q(parama);
    this.r = a.r(parama);
    this.s = a.s(parama);
    this.t = a.t(parama);
    this.u = a.u(parama);
    this.v = a.v(parama);
    this.w = a.w(parama);
    this.x = a.x(parama);
    this.y = a.y(parama);
    this.z = a.z(parama);
    this.A = a.A(parama);
    this.B = a.B(parama);
    this.C = a.C(parama);
    this.D = a.D(parama);
    this.E = a.E(parama);
    this.F = a.F(parama);
    this.G = a.G(parama);
    this.H = a.H(parama);
    this.I = a.I(parama);
    this.J = a.J(parama);
    this.K = a.K(parama);
    this.L = a.L(parama);
    this.M = a.M(parama);
    this.O = a.N(parama);
    this.P = a.O(parama);
    this.N = a.P(parama);
    this.Q = a.Q(parama);
    this.R = Integer.valueOf(a.R(parama));
    this.S = a.S(parama);
    this.T = a.T(parama);
    this.U = a.U(parama);
    this.V = a.V(parama);
  }

  public static a a(Context paramContext, eo parameo)
  {
    a locala = a(er.a(paramContext)).a(parameo.c()).a(parameo.a()).c().f(paramContext).a(dd.h(paramContext)).a(parameo.e()).e("UTF-8").c(parameo.h()).a(paramContext, parameo.g()).a(parameo.m()).e(paramContext).a(paramContext).c(paramContext).d(paramContext).a(parameo.n()).b(paramContext).a().a(cw.a);
    aj localaj = parameo.b();
    if (localaj != null)
      locala = locala.a(localaj.b(paramContext), localaj.a(paramContext));
    return locala.a(parameo.o()).b(parameo.q()).d(parameo.r()).b(parameo.d());
  }

  public static a<?> a(boolean paramBoolean)
  {
    return new a(paramBoolean, (byte)0);
  }

  public static String a(eo parameo)
  {
    String str1 = parameo.f();
    if (!TextUtils.isEmpty(str1))
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str1);
      if (str1.endsWith("/"));
      for (String str2 = ""; ; str2 = "/")
        return str2 + "v4/ad";
    }
    return null;
  }

  private void a()
  {
    StringBuilder localStringBuilder = this.W;
    if (TextUtils.isEmpty(this.W));
    for (String str = ""; ; str = "&")
    {
      localStringBuilder.append(str);
      return;
    }
  }

  private void a(Location paramLocation)
  {
    if (paramLocation != null)
    {
      a("lat", String.valueOf(paramLocation.getLatitude()));
      a("lon", String.valueOf(paramLocation.getLongitude()));
      a("precision", String.valueOf((int)paramLocation.getAccuracy()));
    }
  }

  private void a(String paramString, Boolean paramBoolean)
  {
    if (paramBoolean != null)
      if (!paramBoolean.booleanValue())
        break label23;
    label23: for (int i1 = 1; ; i1 = 0)
    {
      a(paramString, Integer.valueOf(i1));
      return;
    }
  }

  private void a(String paramString, Object paramObject)
  {
    if (paramObject != null)
    {
      a();
      this.W.append(Uri.encode(paramString)).append("=").append(Uri.encode(paramObject.toString()));
    }
  }

  private void a(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        a((String)localEntry.getKey(), localEntry.getValue());
      }
    }
  }

  public final String toString()
  {
    if (!TextUtils.isEmpty(this.W))
      return this.W.toString();
    this.W = new StringBuilder();
    a("ad_unit_id", this.a);
    a("uuid", this.b);
    a("width", this.d);
    a("height", this.e);
    a("orientation", this.f);
    a("screen_width", this.g);
    a("screen_height", this.h);
    a("scalefactor", this.i);
    a("mcc", this.k);
    a("mnc", this.l);
    a("ad_type", this.c);
    a("network_type", this.m);
    a("carrier", this.n);
    a("cellid", this.p);
    a("lac", this.q);
    a("wifi", this.r);
    a("dnt", this.s);
    a("google_aid", this.t);
    a("battery_charge", this.u);
    a("context_query", this.v);
    a("context_taglist", this.w);
    a("image_sizes", this.x);
    a("app_supported_features", this.y);
    a("response_ad_format", this.z);
    a("ad_source", this.A);
    a("debug_yandexuid", this.E);
    a("user_id", this.F);
    a("session_random", this.C);
    a("charset", this.D);
    a("device_type", this.G);
    a("os_name", this.H);
    a("os_version", this.I);
    a("manufacturer", this.J);
    a("model", this.K);
    a("locale", this.L);
    a("app_id", this.M);
    a("app_version", this.O);
    a("app_version_name", this.P);
    a("android_id", this.N);
    a("device-id", this.Q);
    a("screen_dpi", this.R);
    a("age", this.S);
    a("gender", this.T);
    a("user_consent", this.U);
    a("sdk_version", this.V);
    a(this.B);
    AdRequest localAdRequest = this.o;
    if (localAdRequest != null)
      a(localAdRequest.getLocation());
    if ((this.o == null) || (this.o.getLocation() == null))
      a(this.j);
    return this.W.toString();
  }

  public static final class a<T>
  {
    private String A;
    private String B;
    private String C;
    private String D;
    private Long E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private String O;
    private String P;
    private String Q;
    private String R;
    private String S;
    private int T;
    private String U;
    private String V;
    private String W;
    private final boolean a;
    private final Map<String, String> b = new HashMap();
    private Boolean c;
    private String d;
    private String e;
    private String f;
    private Integer g;
    private Integer h;
    private String i;
    private Location j;
    private Integer k;
    private Integer l;
    private Float m;
    private Integer n;
    private Integer o;
    private String p;
    private String q;
    private AdRequest r;
    private Integer s;
    private Integer t;
    private String u;
    private Boolean v;
    private String w;
    private Integer x;
    private String y;
    private String z;

    private a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }

    private static String c(String[] paramArrayOfString)
    {
      if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int i1 = paramArrayOfString.length;
        String str1 = "";
        for (int i2 = 0; i2 < i1; i2++)
        {
          String str2 = paramArrayOfString[i2];
          if (!TextUtils.isEmpty(str2))
          {
            localStringBuilder.append(str1);
            localStringBuilder.append(str2);
            str1 = ",";
          }
        }
        return localStringBuilder.toString();
      }
      return null;
    }

    final a<T> a()
    {
      this.W = MobileAds.getLibraryVersion();
      return this;
    }

    final a<T> a(int paramInt1, int paramInt2)
    {
      this.g = Integer.valueOf(paramInt1);
      this.h = Integer.valueOf(paramInt2);
      return this;
    }

    final a<T> a(long paramLong)
    {
      this.E = Long.valueOf(paramLong);
      return this;
    }

    final a<T> a(Context paramContext)
    {
      if (this.a);
      for (Location localLocation = null; ; localLocation = ep.a(paramContext))
      {
        this.j = localLocation;
        return this;
      }
    }

    final a<T> a(Context paramContext, String paramString)
    {
      DeviceInfo localDeviceInfo = ep.b(paramContext);
      String str2;
      String str1;
      if (localDeviceInfo != null)
      {
        if (this.a)
        {
          str2 = null;
          this.R = str2;
          this.I = localDeviceInfo.deviceType;
          this.J = localDeviceInfo.appPlatform;
          this.K = localDeviceInfo.osVersion;
          this.L = localDeviceInfo.manufacturer;
          this.M = localDeviceInfo.model;
          this.N = localDeviceInfo.locale;
        }
      }
      else
      {
        boolean bool = this.a;
        str1 = null;
        if (!bool)
          break label104;
      }
      while (true)
      {
        this.S = str1;
        return this;
        str2 = localDeviceInfo.platformDeviceId;
        break;
        label104: str1 = paramString;
      }
    }

    final a<T> a(AdRequest paramAdRequest)
    {
      AdRequest localAdRequest;
      String str8;
      String str10;
      String str9;
      if (paramAdRequest != null)
        if (this.a)
        {
          localAdRequest = null;
          this.r = localAdRequest;
          new bw();
          String str1 = paramAdRequest.getContextQuery();
          if (TextUtils.isEmpty(str1))
            break label260;
          str8 = Uri.encode(str1);
          if (str8.length() <= 1024)
            break label659;
          Object[] arrayOfObject3 = new Object[2];
          arrayOfObject3[0] = Integer.valueOf(1024);
          arrayOfObject3[1] = Integer.valueOf(1024);
          fq.b("Exceeded the length of the parameter! The maximum size of the parameter is %s bytes. First %s bytes of the parameter will be used", arrayOfObject3);
          str10 = Uri.encode(" ");
          str9 = str8.substring(0, 1024);
          if (!str8.startsWith(str10, 1024))
            break label242;
        }
      while (true)
      {
        label124: String str2 = Uri.decode(str9);
        label131: this.y = str2;
        List localList = paramAdRequest.getContextTags();
        StringBuilder localStringBuilder1 = new StringBuilder();
        Object localObject2;
        if (localList != null)
        {
          localObject2 = "";
          Iterator localIterator2 = localList.iterator();
          label170: if (localIterator2.hasNext())
          {
            String str7 = (String)localIterator2.next();
            if (TextUtils.isEmpty(str7))
              break label652;
            localStringBuilder1.append((String)localObject2);
            localStringBuilder1.append(str7);
            localStringBuilder1.append("\n");
          }
        }
        label260: label645: label652: for (Object localObject3 = "3"; ; localObject3 = localObject2)
        {
          localObject2 = localObject3;
          break label170;
          localAdRequest = paramAdRequest;
          break;
          label242: str9 = str9.substring(0, str9.lastIndexOf(str10));
          break label124;
          str2 = null;
          break label131;
          String str3 = localStringBuilder1.toString();
          String str5;
          String str6;
          String str4;
          label369: HashMap localHashMap;
          label460: Map.Entry localEntry;
          if (!TextUtils.isEmpty(str3))
          {
            str5 = Uri.encode(str3);
            if (str5.length() > 2048)
            {
              Object[] arrayOfObject2 = new Object[2];
              arrayOfObject2[0] = Integer.valueOf(2048);
              arrayOfObject2[1] = Integer.valueOf(2048);
              fq.b("Exceeded the length of the parameter! The maximum size of the parameter is %s bytes. First %s bytes of the parameter will be used", arrayOfObject2);
              str6 = Uri.encode("\n");
              str5 = str5.substring(0, 2048);
              if (!str5.endsWith(str6));
            }
            else
            {
              str4 = Uri.decode(str5);
              this.z = str4;
              this.U = bw.a(paramAdRequest.getAge());
              this.V = bw.a(paramAdRequest.getGender());
              Map localMap = paramAdRequest.getParameters();
              localObject1 = null;
              if (localMap != null)
              {
                boolean bool = localMap.isEmpty();
                localObject1 = null;
                if (!bool)
                {
                  localHashMap = new HashMap();
                  StringBuilder localStringBuilder2 = new StringBuilder();
                  Iterator localIterator1 = localMap.entrySet().iterator();
                  if (!localIterator1.hasNext())
                    break label645;
                  localEntry = (Map.Entry)localIterator1.next();
                  localStringBuilder2.append("&");
                  localStringBuilder2.append(Uri.encode((String)localEntry.getKey()));
                  localStringBuilder2.append("=");
                  localStringBuilder2.append(Uri.encode((String)localEntry.getValue()));
                  if (localStringBuilder2.length() <= 61440)
                    break label620;
                  Object[] arrayOfObject1 = new Object[2];
                  arrayOfObject1[0] = Integer.valueOf(61440);
                  arrayOfObject1[1] = Integer.valueOf(61440);
                  fq.b("Exceeded the length of the parameter! The maximum size of the parameter is %s bytes. First %s bytes of the parameter will be used", arrayOfObject1);
                }
              }
            }
          }
          for (Object localObject1 = localHashMap; ; localObject1 = localHashMap)
          {
            a(localObject1);
            return this;
            str5 = str5.substring(0, str5.lastIndexOf(str6));
            break;
            str4 = null;
            break label369;
            label620: localHashMap.put(localEntry.getKey(), localEntry.getValue());
            break label460;
          }
        }
        label659: str9 = str8;
      }
    }

    final a<T> a(b paramb)
    {
      if (paramb != null)
        this.f = paramb.a();
      return this;
    }

    final a<T> a(ac paramac)
    {
      if (paramac != null)
        this.C = paramac.a();
      return this;
    }

    final a<T> a(ad paramad)
    {
      if ((paramad != null) && (ad.b == paramad))
        this.D = paramad.a();
      return this;
    }

    final a<T> a(Integer paramInteger)
    {
      this.x = paramInteger;
      return this;
    }

    final a<T> a(String paramString)
    {
      this.d = paramString;
      return this;
    }

    public final a<T> a(Map<String, String> paramMap)
    {
      if (paramMap != null)
        this.b.putAll(paramMap);
      return this;
    }

    final a<T> a(String[] paramArrayOfString)
    {
      this.A = c(paramArrayOfString);
      return this;
    }

    final a<T> b()
    {
      this.c = es.a().e();
      return this;
    }

    final a<T> b(Context paramContext)
    {
      this.k = Integer.valueOf(dh.c(paramContext));
      this.l = Integer.valueOf(dh.d(paramContext));
      this.m = Float.valueOf(dh.e(paramContext));
      this.T = dh.f(paramContext);
      return this;
    }

    final a<T> b(String paramString)
    {
      this.e = paramString;
      return this;
    }

    final a<T> b(String[] paramArrayOfString)
    {
      this.B = c(paramArrayOfString);
      return this;
    }

    final a<T> c()
    {
      Boolean localBoolean = ep.a();
      this.v = localBoolean;
      if ((!this.a) && (localBoolean != null) && (!localBoolean.booleanValue()))
        this.w = ep.b();
      return this;
    }

    final a<T> c(Context paramContext)
    {
      if (1 == paramContext.getResources().getConfiguration().orientation)
      {
        this.i = "portrait";
        return this;
      }
      this.i = "landscape";
      return this;
    }

    final a<T> c(String paramString)
    {
      this.G = paramString;
      return this;
    }

    final a<T> d(Context paramContext)
    {
      this.n = dd.a(paramContext);
      this.o = dd.b(paramContext);
      this.p = dd.d(paramContext);
      this.q = dd.c(paramContext);
      return this;
    }

    final a<T> d(String paramString)
    {
      this.H = paramString;
      return this;
    }

    public final String d()
    {
      return new ab(this, (byte)0).toString();
    }

    final a<T> e(Context paramContext)
    {
      this.s = dd.e(paramContext);
      this.t = dd.f(paramContext);
      this.u = dd.g(paramContext);
      return this;
    }

    final a<T> e(String paramString)
    {
      this.F = paramString;
      return this;
    }

    final a<T> f(Context paramContext)
    {
      this.O = paramContext.getPackageName();
      this.P = cx.a(paramContext);
      this.Q = cx.b(paramContext);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ab
 * JD-Core Version:    0.6.2
 */
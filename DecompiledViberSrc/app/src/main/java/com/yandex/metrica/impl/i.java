package com.yandex.metrica.impl;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.yandex.metrica.impl.ob.ab;
import com.yandex.metrica.impl.ob.hw;
import com.yandex.metrica.impl.ob.iy;
import com.yandex.metrica.impl.ob.lr;
import com.yandex.metrica.impl.ob.om;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class i
{
  String a;
  String b;
  int c;
  int d;
  int e;
  private a f = new a((byte)0);
  private String g;
  private String h;
  private String i;
  private Pair<String, String> j;
  private int k = 2;
  private String l;
  private String m;
  private long n;
  private long o;
  private t p = t.a;

  public i()
  {
    this("", 0);
  }

  public i(i parami)
  {
    if (parami != null)
    {
      this.a = parami.b();
      this.b = parami.c();
      this.c = parami.e();
      this.d = parami.f();
      this.g = parami.m();
      this.i = parami.n();
      this.h = parami.k();
      this.f.a = parami.g();
      this.f.b = parami.h();
      this.f.c = parami.j();
      this.j = parami.l();
      this.e = parami.q();
      this.k = parami.r();
      this.l = parami.s();
      this.m = parami.m;
      this.n = parami.v();
      this.o = parami.w();
      this.p = parami.p;
    }
  }

  public i(String paramString, int paramInt)
  {
    this("", paramString, paramInt);
  }

  public i(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2, paramInt, new om());
  }

  public i(String paramString1, String paramString2, int paramInt, om paramom)
  {
    this.a = paramString2;
    this.c = paramInt;
    this.b = paramString1;
    this.n = paramom.c();
    this.o = paramom.a();
  }

  public static i a(i parami, s.a parama)
  {
    i locali = new i(parami);
    locali.b("");
    locali.a(parama.a());
    return locali;
  }

  public static i a(i parami, List<iy> paramList)
  {
    i locali = new i(parami);
    JSONArray localJSONArray;
    Object localObject;
    try
    {
      localJSONArray = new JSONArray();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        iy localiy = (iy)localIterator.next();
        localJSONArray.put(new JSONObject().put("name", localiy.a).put("granted", localiy.b));
      }
    }
    catch (JSONException localJSONException)
    {
      localObject = "";
    }
    while (true)
    {
      return locali.a(s.a.G.a()).c((String)localObject);
      String str = new JSONObject().put("permissions", localJSONArray).toString();
      localObject = str;
    }
  }

  public static i a(ab paramab, i parami)
  {
    Context localContext = paramab.c();
    y localy = new y().a();
    try
    {
      if (paramab.E())
        localy.a(localContext);
      if (paramab.l().E())
        localy.a(localContext, paramab.l().F());
      label52: i locali = new i(parami);
      locali.a(s.a.p.a()).c(localy.d());
      return locali;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }

  public static i b(Bundle paramBundle)
  {
    Bundle localBundle;
    i locali;
    if (paramBundle.containsKey("CounterReport.Object"))
    {
      localBundle = paramBundle.getBundle("CounterReport.Object");
      locali = new i().a(localBundle.getInt("CounterReport.Type", s.a.a.a())).b(localBundle.getInt("CounterReport.CustomType")).a(hw.a(localBundle.getByteArray("CounterReport.GeoLocation"))).c(bu.b(localBundle.getString("CounterReport.Value"), "")).a(localBundle.getString("CounterReport.UserInfo")).f(localBundle.getString("CounterReport.Environment")).e(localBundle.getString("CounterReport.Wifi")).a((Integer)localBundle.get("CounterReport.CellId")).b(localBundle.getString("CounterReport.Event")).g(localBundle.getString("CounterReport.PackageName"));
      if ((!localBundle.containsKey("CounterReport.AppEnvironmentDiffKey")) || (!localBundle.containsKey("CounterReport.AppEnvironmentDiffValue")))
        break label277;
    }
    label277: for (Pair localPair = new Pair(localBundle.getString("CounterReport.AppEnvironmentDiffKey"), localBundle.getString("CounterReport.AppEnvironmentDiffValue")); ; localPair = null)
    {
      locali.j = localPair;
      return locali.c(localBundle.getInt("CounterReport.TRUNCATED")).d(localBundle.getInt("CounterReport.ConnectionType")).h(localBundle.getString("CounterReport.CellularConnectionType")).d(localBundle.getString("CounterReport.ProfileID")).a(localBundle.getLong("CounterReport.CreationElapsedRealtime")).b(localBundle.getLong("CounterReport.CreationTimestamp")).a(t.a(Integer.valueOf(localBundle.getInt("CounterReport.UniquenessStatus"))));
      localBundle = new Bundle();
      break;
    }
  }

  Bundle a(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("CounterReport.Event", this.a);
    localBundle.putString("CounterReport.Value", this.b);
    localBundle.putInt("CounterReport.Type", this.c);
    localBundle.putInt("CounterReport.CustomType", this.d);
    localBundle.putString("CounterReport.Wifi", this.f.b);
    localBundle.putInt("CounterReport.TRUNCATED", this.e);
    localBundle.putInt("CounterReport.ConnectionType", this.k);
    localBundle.putString("CounterReport.CellularConnectionType", this.l);
    localBundle.putString("CounterReport.ProfileID", this.m);
    localBundle.putInt("CounterReport.UniquenessStatus", this.p.d);
    if (this.f.a != null)
      localBundle.putByteArray("CounterReport.GeoLocation", hw.a(this.f.a));
    if (this.f.c != null)
      localBundle.putInt("CounterReport.CellId", this.f.c.intValue());
    if (this.h != null)
      localBundle.putString("CounterReport.Environment", this.h);
    if (this.g != null)
      localBundle.putString("CounterReport.UserInfo", this.g);
    if (this.i != null)
      localBundle.putString("CounterReport.PackageName", this.i);
    if (this.j != null)
    {
      Pair localPair = this.j;
      localBundle.putString("CounterReport.AppEnvironmentDiffKey", (String)localPair.first);
      localBundle.putString("CounterReport.AppEnvironmentDiffValue", (String)localPair.second);
    }
    localBundle.putLong("CounterReport.CreationElapsedRealtime", this.n);
    localBundle.putLong("CounterReport.CreationTimestamp", this.o);
    if (paramBundle != null);
    while (true)
    {
      paramBundle.putBundle("CounterReport.Object", localBundle);
      return paramBundle;
      paramBundle = new Bundle();
    }
  }

  public i a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }

  protected i a(long paramLong)
  {
    this.n = paramLong;
    return this;
  }

  i a(Location paramLocation)
  {
    this.f.a = paramLocation;
    return this;
  }

  public i a(t paramt)
  {
    this.p = paramt;
    return this;
  }

  i a(Integer paramInteger)
  {
    this.f.c = paramInteger;
    return this;
  }

  public i a(String paramString)
  {
    this.g = paramString;
    return this;
  }

  i a(String paramString1, String paramString2)
  {
    if (this.j == null)
      this.j = new Pair(paramString1, paramString2);
    return this;
  }

  public i a(byte[] paramArrayOfByte)
  {
    this.b = new String(Base64.encode(paramArrayOfByte, 0));
    return this;
  }

  public i b(int paramInt)
  {
    this.d = paramInt;
    return this;
  }

  protected i b(long paramLong)
  {
    this.o = paramLong;
    return this;
  }

  public i b(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public String b()
  {
    return this.a;
  }

  protected i c(int paramInt)
  {
    this.e = paramInt;
    return this;
  }

  public i c(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public String c()
  {
    return this.b;
  }

  protected i d(int paramInt)
  {
    this.k = paramInt;
    return this;
  }

  public i d(String paramString)
  {
    this.m = paramString;
    return this;
  }

  public byte[] d()
  {
    return Base64.decode(this.b, 0);
  }

  public int e()
  {
    return this.c;
  }

  i e(String paramString)
  {
    this.f.b = paramString;
    return this;
  }

  public int f()
  {
    return this.d;
  }

  i f(String paramString)
  {
    this.h = paramString;
    return this;
  }

  public Location g()
  {
    return this.f.a;
  }

  public i g(String paramString)
  {
    this.i = paramString;
    return this;
  }

  protected i h(String paramString)
  {
    this.l = paramString;
    return this;
  }

  String h()
  {
    return this.f.b;
  }

  JSONArray i()
  {
    if (!TextUtils.isEmpty(this.f.b))
      try
      {
        JSONArray localJSONArray = new JSONArray(this.f.b);
        return localJSONArray;
      }
      catch (Exception localException)
      {
      }
    return new JSONArray();
  }

  Integer j()
  {
    return this.f.c;
  }

  String k()
  {
    return this.h;
  }

  public Pair<String, String> l()
  {
    return this.j;
  }

  public String m()
  {
    return this.g;
  }

  public String n()
  {
    return this.i;
  }

  public boolean o()
  {
    return this.a == null;
  }

  public boolean p()
  {
    return s.a.a.a() == this.c;
  }

  public int q()
  {
    return this.e;
  }

  public int r()
  {
    return this.k;
  }

  public String s()
  {
    return this.l;
  }

  public String t()
  {
    return this.m;
  }

  public String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = s.a.a(this.c).b();
    arrayOfObject[2] = this.b;
    return String.format(localLocale, "[event: %s, type: %s, value: %s]", arrayOfObject);
  }

  public t u()
  {
    return this.p;
  }

  public long v()
  {
    return this.n;
  }

  public long w()
  {
    return this.o;
  }

  private static final class a
  {
    Location a;
    String b;
    Integer c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.i
 * JD-Core Version:    0.6.2
 */
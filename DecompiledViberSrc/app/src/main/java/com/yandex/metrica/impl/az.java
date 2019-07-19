package com.yandex.metrica.impl;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.yandex.metrica.f;
import com.yandex.metrica.impl.ob.d;
import com.yandex.metrica.impl.ob.e;
import com.yandex.metrica.impl.ob.ek;
import com.yandex.metrica.impl.ob.kk.a;
import com.yandex.metrica.impl.ob.kk.c.b;
import com.yandex.metrica.impl.ob.kk.c.c;
import com.yandex.metrica.impl.ob.kk.c.e.a;
import com.yandex.metrica.impl.ob.kk.c.e.a.a;
import com.yandex.metrica.impl.ob.kk.c.e.a.b;
import com.yandex.metrica.impl.ob.kk.c.e.a.b.a;
import com.yandex.metrica.impl.ob.kk.c.e.b;
import com.yandex.metrica.impl.ob.kk.c.f;
import com.yandex.metrica.impl.ob.kk.c.g;
import com.yandex.metrica.impl.ob.kk.d;
import com.yandex.metrica.impl.ob.kl;
import com.yandex.metrica.impl.ob.lj;
import com.yandex.metrica.impl.ob.nn;
import com.yandex.metrica.impl.ob.nz;
import com.yandex.metrica.impl.ob.nz.a;
import com.yandex.metrica.impl.ob.oo;
import com.yandex.metrica.impl.ob.op;
import com.yandex.metrica.impl.ob.oz;
import com.yandex.metrica.impl.ob.pa;
import com.yandex.metrica.impl.ob.pb;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class az
{
  private static Map<ek, Integer> a;
  private static SparseArray<ek> b;
  private static Map<t, Integer> c = Collections.unmodifiableMap(localHashMap2);

  static
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put(ek.a, Integer.valueOf(0));
    localHashMap1.put(ek.b, Integer.valueOf(1));
    a = Collections.unmodifiableMap(localHashMap1);
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(0, ek.a);
    localSparseArray.put(1, ek.b);
    b = localSparseArray;
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put(t.b, Integer.valueOf(1));
    localHashMap2.put(t.c, Integer.valueOf(0));
    localHashMap2.put(t.a, Integer.valueOf(-1));
  }

  static int a(ek paramek)
  {
    return ((Integer)a.get(paramek)).intValue();
  }

  public static ek a(int paramInt)
  {
    return (ek)b.get(paramInt);
  }

  public static kk.c.e.a.b a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    kk.c.e.a.b localb = new kk.c.e.a.b();
    localb.d = paramInt;
    if (paramString1 != null)
      localb.e = paramString1;
    kk.a[] arrayOfa = c(paramString3);
    if (arrayOfa != null)
      localb.b = arrayOfa;
    localb.c = a(paramString2);
    if (!TextUtils.isEmpty(paramString4))
      localb.f = b(paramString4);
    return localb;
  }

  public static kk.c.e.b a(String paramString, int paramInt, kk.c.g paramg)
  {
    kk.c.e.b localb = new kk.c.e.b();
    localb.b = paramg;
    localb.c = paramString;
    localb.d = paramInt;
    return localb;
  }

  public static kk.c.f a(nn paramnn)
  {
    kk.c.f localf = new kk.c.f();
    if (paramnn.a() != null)
      localf.b = paramnn.a().intValue();
    if (paramnn.b() != null)
      localf.c = paramnn.b().intValue();
    if (!TextUtils.isEmpty(paramnn.d()))
      localf.d = paramnn.d();
    localf.e = paramnn.c();
    if (!TextUtils.isEmpty(paramnn.e()))
      localf.f = paramnn.e();
    return localf;
  }

  public static kk.c.g a(ContentValues paramContentValues)
  {
    Long localLong1 = paramContentValues.getAsLong("start_time");
    Long localLong2 = paramContentValues.getAsLong("server_time_offset");
    Boolean localBoolean = paramContentValues.getAsBoolean("obtained_before_first_sync");
    long l = localLong1.longValue();
    kk.c.g localg = new kk.c.g();
    localg.b = l;
    localg.c = oo.a(l);
    if (localLong2 != null)
      localg.d = localLong2.longValue();
    if (localBoolean != null)
      localg.e = localBoolean.booleanValue();
    return localg;
  }

  public static kk.d a(JSONObject paramJSONObject)
    throws JSONException
  {
    try
    {
      kk.d locald1 = new kk.d();
      locald1.b = paramJSONObject.getString("mac");
      locald1.c = paramJSONObject.getInt("signal_strength");
      locald1.d = paramJSONObject.getString("ssid");
      locald1.e = paramJSONObject.optBoolean("is_connected");
      return locald1;
    }
    catch (Exception localException)
    {
      kk.d locald2 = new kk.d();
      locald2.b = paramJSONObject.getString("mac");
      return locald2;
    }
  }

  public static void a()
  {
  }

  public static kk.c.c[] a(Context paramContext)
  {
    List localList = bx.a(paramContext).b();
    if (!bw.a(localList))
    {
      kk.c.c[] arrayOfc = new kk.c.c[localList.size()];
      for (int i = 0; i < localList.size(); i++)
      {
        kk.c.c localc = new kk.c.c();
        bx.a locala = (bx.a)localList.get(i);
        localc.b = locala.a;
        localc.c = locala.b;
        arrayOfc[i] = localc;
      }
      return arrayOfc;
    }
    return null;
  }

  public static kk.d[] a(String paramString)
  {
    try
    {
      kk.d[] arrayOfd = a(new JSONArray(paramString));
      return arrayOfd;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static kk.d[] a(JSONArray paramJSONArray)
  {
    kk.d[] arrayOfd = null;
    try
    {
      arrayOfd = new kk.d[paramJSONArray.length()];
      for (int i = 0; i < paramJSONArray.length(); i++)
        arrayOfd[i] = a(paramJSONArray.getJSONObject(i));
    }
    catch (Exception localException)
    {
    }
    return arrayOfd;
  }

  static kk.a b(JSONObject paramJSONObject)
  {
    kk.a locala = new kk.a();
    if (paramJSONObject.has("signal_strength"))
    {
      int i = paramJSONObject.optInt("signal_strength");
      if (i != -1)
        locala.c = i;
    }
    if (paramJSONObject.has("cell_id"))
      locala.b = paramJSONObject.optInt("cell_id");
    if (paramJSONObject.has("lac"))
      locala.d = paramJSONObject.optInt("lac");
    if (paramJSONObject.has("country_code"))
      locala.e = paramJSONObject.optInt("country_code");
    if (paramJSONObject.has("operator_id"))
      locala.f = paramJSONObject.optInt("operator_id");
    if (paramJSONObject.has("operator_name"))
      locala.g = paramJSONObject.optString("operator_name");
    if (paramJSONObject.has("is_connected"))
      locala.h = paramJSONObject.optBoolean("is_connected");
    locala.i = paramJSONObject.optInt("cell_type", 0);
    if (paramJSONObject.has("pci"))
      locala.j = paramJSONObject.optInt("pci");
    return locala;
  }

  static kk.c.e.a.b.a b(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        kk.c.e.a.b.a locala = new kk.c.e.a.b.a();
        locala.b = localJSONObject.optString("ssid");
        switch (localJSONObject.optInt("state", -1))
        {
        case 0:
        case 1:
        case 2:
        case 4:
          locala.c = 1;
          return locala;
        case 3:
          locala.c = 2;
        }
        return locala;
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static kk.a[] b(JSONArray paramJSONArray)
  {
    kk.a[] arrayOfa = null;
    try
    {
      arrayOfa = new kk.a[paramJSONArray.length()];
      for (int i = 0; i < paramJSONArray.length(); i++)
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        if (localJSONObject != null)
          arrayOfa[i] = b(localJSONObject);
      }
    }
    catch (Exception localException)
    {
    }
    return arrayOfa;
  }

  public static kk.a[] c(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      Object localObject = null;
      if (!bool)
      {
        kk.a[] arrayOfa2 = b(new JSONArray(paramString));
        localObject = arrayOfa2;
      }
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      kk.a[] arrayOfa1 = new kk.a[1];
      arrayOfa1[0] = b(localJSONObject);
      return arrayOfa1;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static kk.c.b d(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        nz.a locala = new nz.a(paramString);
        if ((locala.b("lon")) && (locala.b("lat")))
        {
          localb = new kk.c.b();
          try
          {
            localb.c = locala.getDouble("lon");
            localb.b = locala.getDouble("lat");
            localb.h = locala.optInt("altitude");
            localb.f = locala.optInt("direction");
            localb.e = locala.optInt("precision");
            localb.g = locala.optInt("speed");
            localb.d = (locala.optLong("timestamp") / 1000L);
            if (!locala.b("provider"))
              break label189;
            String str = locala.a("provider");
            if ("gps".equals(str))
            {
              localb.i = 1;
              return localb;
            }
            if (!"network".equals(str))
              break label189;
            localb.i = 2;
            return localb;
          }
          catch (Exception localException2)
          {
            return localb;
          }
        }
      }
    }
    catch (Exception localException1)
    {
      return null;
    }
    kk.c.b localb = null;
    label189: return localb;
  }

  static int e(String paramString)
  {
    int i = -1;
    try
    {
      nz.a locala = new nz.a(paramString);
      if (locala.b("enabled"))
      {
        boolean bool = locala.getBoolean("enabled");
        if (bool)
          i = 1;
      }
      else
      {
        return i;
      }
      return 0;
    }
    catch (Exception localException)
    {
    }
    return i;
  }

  public static kk.c.e.a.a f(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        f localf = op.a(paramString);
        kk.c.e.a.a locala = new kk.c.e.a.a();
        locala.b = localf.a();
        if (!TextUtils.isEmpty(localf.b()))
          locala.c = localf.b();
        if (!bw.a(localf.c()))
          locala.d = nz.a(localf.c());
        return locala;
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  static class a extends az.e
  {
    protected String a()
    {
      return "";
    }
  }

  static class b extends az.c
  {
    protected byte[] b()
    {
      return Base64.decode(this.b, 0);
    }
  }

  static class c
  {
    private static final Map<s.a, Class<?>> s;
    private static final Map<s.a, Integer> t = Collections.unmodifiableMap(localHashMap2);
    protected String a;
    protected String b;
    protected int c;
    protected long d;
    protected String e;
    protected String f;
    protected String g;
    protected Integer h;
    protected Integer i;
    protected String j;
    protected String k;
    protected int l;
    protected int m;
    protected String n;
    protected String o;
    protected String p;
    protected pb q;
    protected t r;

    static
    {
      HashMap localHashMap1 = new HashMap();
      localHashMap1.put(s.a.c, az.e.class);
      localHashMap1.put(s.a.v, az.j.class);
      localHashMap1.put(s.a.f, az.f.class);
      localHashMap1.put(s.a.n, az.i.class);
      localHashMap1.put(s.a.e, az.e.class);
      localHashMap1.put(s.a.p, az.h.class);
      localHashMap1.put(s.a.t, az.e.class);
      localHashMap1.put(s.a.h, az.e.class);
      localHashMap1.put(s.a.i, az.e.class);
      localHashMap1.put(s.a.z, az.e.class);
      localHashMap1.put(s.a.C, az.f.class);
      localHashMap1.put(s.a.D, az.d.class);
      localHashMap1.put(s.a.E, az.e.class);
      localHashMap1.put(s.a.G, az.a.class);
      localHashMap1.put(s.a.H, az.a.class);
      localHashMap1.put(s.a.j, az.b.class);
      localHashMap1.put(s.a.l, az.b.class);
      s = Collections.unmodifiableMap(localHashMap1);
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put(s.a.b, Integer.valueOf(1));
      localHashMap2.put(s.a.c, Integer.valueOf(4));
      localHashMap2.put(s.a.v, Integer.valueOf(5));
      localHashMap2.put(s.a.f, Integer.valueOf(7));
      localHashMap2.put(s.a.z, Integer.valueOf(3));
      localHashMap2.put(s.a.n, Integer.valueOf(3));
      localHashMap2.put(s.a.e, Integer.valueOf(6));
      localHashMap2.put(s.a.p, Integer.valueOf(8));
      localHashMap2.put(s.a.t, Integer.valueOf(11));
      localHashMap2.put(s.a.h, Integer.valueOf(12));
      localHashMap2.put(s.a.i, Integer.valueOf(12));
      localHashMap2.put(s.a.B, Integer.valueOf(13));
      localHashMap2.put(s.a.C, Integer.valueOf(2));
      localHashMap2.put(s.a.E, Integer.valueOf(16));
      localHashMap2.put(s.a.F, Integer.valueOf(17));
      localHashMap2.put(s.a.G, Integer.valueOf(18));
      localHashMap2.put(s.a.H, Integer.valueOf(19));
      localHashMap2.put(s.a.j, Integer.valueOf(20));
      localHashMap2.put(s.a.l, Integer.valueOf(21));
    }

    static c a(int paramInt, boolean paramBoolean)
    {
      s.a locala = s.a.a(paramInt);
      Object localObject;
      switch (az.1.a[locala.ordinal()])
      {
      default:
        localObject = (Class)s.get(locala);
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        Integer localInteger = (Integer)t.get(locala);
        try
        {
          localc = (c)((Class)localObject).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
          return localc.a(localInteger);
          if (paramBoolean)
          {
            localObject = az.e.class;
            continue;
          }
          localObject = az.g.class;
        }
        catch (Exception localException)
        {
          while (true)
            c localc = new c();
        }
      }
    }

    c a(int paramInt)
    {
      this.c = paramInt;
      return this;
    }

    c a(long paramLong)
    {
      this.d = paramLong;
      return this;
    }

    c a(pb parampb)
    {
      this.q = parampb;
      return this;
    }

    c a(t paramt)
    {
      this.r = paramt;
      return this;
    }

    c a(Integer paramInteger)
    {
      this.h = paramInteger;
      return this;
    }

    c a(String paramString)
    {
      this.a = paramString;
      return this;
    }

    protected String a()
    {
      return this.a;
    }

    c b(int paramInt)
    {
      this.l = paramInt;
      return this;
    }

    c b(Integer paramInteger)
    {
      this.i = paramInteger;
      return this;
    }

    c b(String paramString)
    {
      this.b = paramString;
      return this;
    }

    protected byte[] b()
    {
      if (this.b == null)
        return new byte[0];
      return bu.c(this.b);
    }

    c c(int paramInt)
    {
      this.m = paramInt;
      return this;
    }

    c c(String paramString)
    {
      this.e = paramString;
      return this;
    }

    protected Integer c()
    {
      return this.h;
    }

    c d(String paramString)
    {
      this.g = paramString;
      return this;
    }

    protected String d()
    {
      return this.j;
    }

    c e(String paramString)
    {
      this.f = paramString;
      return this;
    }

    kk.c.e.a e()
    {
      kk.c.e.a locala = new kk.c.e.a();
      kk.c.e.a.b localb = az.a(this.m, this.n, this.g, this.f, this.o);
      kk.c.b localb1 = az.d(this.e);
      kk.c.e.a.a locala1 = az.f(this.k);
      if (localb != null)
        locala.h = localb;
      if (localb1 != null)
        locala.g = localb1;
      if (a() != null)
        locala.e = a();
      if (b() != null)
        locala.f = b();
      if (d() != null)
        locala.i = d();
      if (locala1 != null)
        locala.j = locala1;
      locala.d = c().intValue();
      locala.b = this.c;
      locala.c = this.d;
      locala.k = this.l;
      locala.l = f();
      locala.m = az.e(this.e);
      if (this.p == null);
      for (byte[] arrayOfByte = new byte[0]; ; arrayOfByte = this.p.getBytes())
      {
        locala.n = arrayOfByte;
        Integer localInteger = (Integer)az.b().get(this.r);
        if (localInteger != null)
          locala.o = localInteger.intValue();
        return locala;
      }
    }

    protected int f()
    {
      return 0;
    }

    c f(String paramString)
    {
      this.o = paramString;
      return this;
    }

    c g(String paramString)
    {
      this.j = paramString;
      return this;
    }

    c h(String paramString)
    {
      this.k = paramString;
      return this;
    }

    c i(String paramString)
    {
      this.n = paramString;
      return this;
    }

    public c j(String paramString)
    {
      this.p = paramString;
      return this;
    }
  }

  static class d extends az.e
  {
    protected Integer c()
    {
      return this.i;
    }
  }

  static class e extends az.c
  {
    private pa s;

    e()
    {
      this(new pa(v.a().b()));
    }

    e(pa parampa)
    {
      this.s = parampa;
    }

    protected byte[] b()
    {
      byte[] arrayOfByte = super.b();
      return this.s.a(this.q).a(arrayOfByte);
    }
  }

  static class f extends az.c
  {
    protected String a()
    {
      return "";
    }

    protected byte[] b()
    {
      return new byte[0];
    }
  }

  static class g extends az.c
  {
    protected byte[] b()
    {
      return new byte[0];
    }
  }

  static class h extends az.e
  {
    public int f()
    {
      if (this.q == pb.b)
        return 1;
      return 0;
    }
  }

  static class i extends az.c
  {
    protected byte[] b()
    {
      return bu.c(w.c(this.b));
    }
  }

  static class j extends az.c
  {
    protected byte[] b()
    {
      try
      {
        lj locallj = lj.a(Base64.decode(this.b, 0));
        kl localkl = new kl();
        if (locallj.a == null);
        byte[] arrayOfByte;
        for (Object localObject = new byte[0]; ; localObject = arrayOfByte)
        {
          localkl.b = ((byte[])localObject);
          localkl.d = locallj.b;
          localkl.c = locallj.c;
          return e.a(localkl);
          arrayOfByte = locallj.a.getBytes();
        }
      }
      catch (d locald)
      {
      }
      return new byte[0];
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.az
 * JD-Core Version:    0.6.2
 */
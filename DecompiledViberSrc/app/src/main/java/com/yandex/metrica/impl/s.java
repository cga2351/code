package com.yandex.metrica.impl;

import android.annotation.SuppressLint;
import com.yandex.metrica.impl.ob.lj;
import com.yandex.metrica.impl.ob.nz;
import com.yandex.metrica.impl.ob.of;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class s
{
  public static final EnumSet<a> a = EnumSet.of(locala3, arrayOfa3);
  private static final EnumSet<a> b;
  private static final EnumSet<a> c;
  private static final EnumSet<a> d;
  private static final EnumSet<a> e = EnumSet.of(a.z, a.e, a.n, a.c);
  private static final EnumSet<a> f = EnumSet.of(a.q, a.r, a.s);
  private static final EnumSet<a> g = EnumSet.of(a.c);

  static
  {
    a locala1 = a.a;
    a[] arrayOfa1 = new a[7];
    arrayOfa1[0] = a.m;
    arrayOfa1[1] = a.g;
    arrayOfa1[2] = a.u;
    arrayOfa1[3] = a.v;
    arrayOfa1[4] = a.x;
    arrayOfa1[5] = a.y;
    arrayOfa1[6] = a.A;
    b = EnumSet.of(locala1, arrayOfa1);
    a locala2 = a.h;
    a[] arrayOfa2 = new a[12];
    arrayOfa2[0] = a.i;
    arrayOfa2[1] = a.p;
    arrayOfa2[2] = a.g;
    arrayOfa2[3] = a.a;
    arrayOfa2[4] = a.b;
    arrayOfa2[5] = a.F;
    arrayOfa2[6] = a.v;
    arrayOfa2[7] = a.f;
    arrayOfa2[8] = a.o;
    arrayOfa2[9] = a.x;
    arrayOfa2[10] = a.y;
    arrayOfa2[11] = a.A;
    c = EnumSet.of(locala2, arrayOfa2);
    d = EnumSet.of(a.d, a.h, a.i);
    a locala3 = a.b;
    a[] arrayOfa3 = new a[5];
    arrayOfa3[0] = a.D;
    arrayOfa3[1] = a.B;
    arrayOfa3[2] = a.u;
    arrayOfa3[3] = a.v;
    arrayOfa3[4] = a.F;
  }

  public static i a()
  {
    i locali = new i().a(a.s.a());
    try
    {
      locali.c(new JSONObject().put("stat_sending", new JSONObject().put("disabled", true)).toString());
      return locali;
    }
    catch (JSONException localJSONException)
    {
    }
    return locali;
  }

  static i a(int paramInt, String paramString1, String paramString2, Map<String, Object> paramMap, of paramof)
  {
    return new e(paramString2, paramString1, a.D.a(), paramInt, paramof).f(nz.a(paramMap));
  }

  public static i a(ax paramax, of paramof)
  {
    if (paramax == null);
    for (String str = ""; ; str = paramax.a())
      return new e(str, "", a.A.a(), paramof);
  }

  public static i a(lj paramlj, of paramof)
  {
    if (paramlj == null)
      return new e("", a.w.a(), paramof);
    return new e(paramlj.a, a.w.a(), paramof).a(paramlj.a());
  }

  public static i a(a parama, of paramof)
  {
    return new e("", parama.a(), paramof);
  }

  static i a(a parama, String paramString, of paramof)
  {
    return new e(paramString, "", parama.a(), paramof);
  }

  public static i a(String paramString, of paramof)
  {
    return new e(paramString, a.c.a(), paramof);
  }

  static i a(String paramString1, String paramString2, of paramof)
  {
    return new e(paramString2, paramString1, a.c.a(), paramof);
  }

  public static boolean a(int paramInt)
  {
    return d.contains(a.a(paramInt));
  }

  public static boolean a(a parama)
  {
    return !b.contains(parama);
  }

  static i b(String paramString, of paramof)
  {
    return new e(paramString, a.C.a(), paramof);
  }

  static i b(String paramString1, String paramString2, of paramof)
  {
    return new e(paramString2, paramString1, a.t.a(), paramof);
  }

  public static boolean b(int paramInt)
  {
    return e.contains(a.a(paramInt));
  }

  public static boolean b(a parama)
  {
    return !c.contains(parama);
  }

  static i c(String paramString, of paramof)
  {
    return new e(paramString, a.d.a(), paramof);
  }

  static i c(String paramString1, String paramString2, of paramof)
  {
    return new e(paramString2, paramString1, a.e.a(), paramof);
  }

  public static boolean c(int paramInt)
  {
    return g.contains(a.a(paramInt));
  }

  public static i d(String paramString, of paramof)
  {
    return new e("", paramString, a.u.a(), paramof);
  }

  static i d(String paramString1, String paramString2, of paramof)
  {
    return new e(paramString2, paramString1, a.z.a(), paramof);
  }

  public static boolean d(int paramInt)
  {
    return f.contains(a.a(paramInt));
  }

  static i e(String paramString, of paramof)
  {
    return e("open", paramString, paramof);
  }

  static i e(String paramString1, String paramString2, of paramof)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", paramString1);
    localHashMap.put("link", paramString2);
    return new e(nz.a(localHashMap), "", a.E.a(), paramof);
  }

  static i f(String paramString, of paramof)
  {
    return e("referral", paramString, paramof);
  }

  @SuppressLint({"UseSparseArrays"})
  public static enum a
  {
    static final HashMap<Integer, a> J;
    private final int K;
    private final String L;

    static
    {
      int i1 = 0;
      a = new a("EVENT_TYPE_UNDEFINED", 0, -1, "Unrecognized action");
      b = new a("EVENT_TYPE_INIT", 1, 0, "First initialization event");
      c = new a("EVENT_TYPE_REGULAR", 2, 1, "Regular event");
      d = new a("EVENT_TYPE_UPDATE_FOREGROUND_TIME", 3, 3, "Update foreground time");
      e = new a("EVENT_TYPE_EXCEPTION_USER", 4, 5, "Error from developer");
      f = new a("EVENT_TYPE_ALIVE", 5, 7, "App is still alive");
      g = new a("EVENT_TYPE_UPDATE_COLLECT_INSTALLED_APPS", 6, 8, "Update collect apps");
      h = new a("EVENT_TYPE_SET_USER_INFO", 7, 9, "User info");
      i = new a("EVENT_TYPE_REPORT_USER_INFO", 8, 10, "Report user info");
      j = new a("EVENT_TYPE_SEND_USER_PROFILE", 9, 40961, "Send user profile");
      k = new a("EVENT_TYPE_SET_USER_PROFILE_ID", 10, 40962, "Set user profile ID");
      l = new a("EVENT_TYPE_SEND_REVENUE_EVENT", 11, 40976, "Send revenue event");
      m = new a("EVENT_TYPE_PURGE_BUFFER", 12, 256, "Forcible buffer clearing");
      n = new a("EVENT_TYPE_NATIVE_CRASH", 13, 768, "Native crash of App");
      o = new a("EVENT_TYPE_STARTUP", 14, 1536, "Sending the startup due to lack of data");
      p = new a("EVENT_TYPE_IDENTITY", 15, 1792, "System identification");
      q = new a("EVENT_TYPE_DIAGNOSTIC", 16, 2048, "Diagnostic event");
      r = new a("EVENT_TYPE_DIAGNOSTIC_STATBOX", 17, 2049, "Diagnostic statbox event");
      s = new a("EVENT_TYPE_DIAGNOSTIC_DISABLE_STAT_SENDING", 18, 2050, "Disable stat send");
      t = new a("EVENT_TYPE_STATBOX", 19, 2304, "Event with statistical data");
      u = new a("EVENT_TYPE_REFERRER_RECEIVED_FROM_BROADCAST", 20, 4096, "Referrer received");
      v = new a("EVENT_TYPE_SEND_REFERRER", 21, 4097, "Send referrer");
      w = new a("EVENT_TYPE_REFERRER_OBTAINED_FROM_SERVICES", 22, 4098, "Referrer obtained");
      x = new a("EVENT_TYPE_APP_ENVIRONMENT_UPDATED", 23, 5376, "App Environment Updated");
      y = new a("EVENT_TYPE_APP_ENVIRONMENT_CLEARED", 24, 5632, "App Environment Cleared");
      z = new a("EVENT_TYPE_EXCEPTION_UNHANDLED", 25, 5888, "Crash of App");
      A = new a("EVENT_TYPE_ACTIVATION", 26, 6144, "Activation of metrica");
      B = new a("EVENT_TYPE_FIRST_ACTIVATION", 27, 6145, "First activation of metrica");
      C = new a("EVENT_TYPE_START", 28, 6400, "Start of new session");
      D = new a("EVENT_TYPE_CUSTOM_EVENT", 29, 8192, "Custom event");
      E = new a("EVENT_TYPE_APP_OPEN", 30, 8208, "App open event");
      F = new a("EVENT_TYPE_APP_UPDATE", 31, 8224, "App update event");
      G = new a("EVENT_TYPE_PERMISSIONS", 32, 12288, "Permissions changed event");
      H = new a("EVENT_TYPE_APP_FEATURES", 33, 12289, "Features, required by application");
      I = new a("EVENT_TYPE_UPDATE_PRE_ACTIVATION_CONFIG", 34, 16384, "Update pre-activation config");
      a[] arrayOfa1 = new a[35];
      arrayOfa1[0] = a;
      arrayOfa1[1] = b;
      arrayOfa1[2] = c;
      arrayOfa1[3] = d;
      arrayOfa1[4] = e;
      arrayOfa1[5] = f;
      arrayOfa1[6] = g;
      arrayOfa1[7] = h;
      arrayOfa1[8] = i;
      arrayOfa1[9] = j;
      arrayOfa1[10] = k;
      arrayOfa1[11] = l;
      arrayOfa1[12] = m;
      arrayOfa1[13] = n;
      arrayOfa1[14] = o;
      arrayOfa1[15] = p;
      arrayOfa1[16] = q;
      arrayOfa1[17] = r;
      arrayOfa1[18] = s;
      arrayOfa1[19] = t;
      arrayOfa1[20] = u;
      arrayOfa1[21] = v;
      arrayOfa1[22] = w;
      arrayOfa1[23] = x;
      arrayOfa1[24] = y;
      arrayOfa1[25] = z;
      arrayOfa1[26] = A;
      arrayOfa1[27] = B;
      arrayOfa1[28] = C;
      arrayOfa1[29] = D;
      arrayOfa1[30] = E;
      arrayOfa1[31] = F;
      arrayOfa1[32] = G;
      arrayOfa1[33] = H;
      arrayOfa1[34] = I;
      M = arrayOfa1;
      J = new HashMap();
      a[] arrayOfa2 = values();
      int i2 = arrayOfa2.length;
      while (i1 < i2)
      {
        a locala = arrayOfa2[i1];
        J.put(Integer.valueOf(locala.a()), locala);
        i1++;
      }
    }

    private a(int paramInt, String paramString)
    {
      this.K = paramInt;
      this.L = paramString;
    }

    public static a a(int paramInt)
    {
      a locala = (a)J.get(Integer.valueOf(paramInt));
      if (locala == null)
        locala = a;
      return locala;
    }

    public int a()
    {
      return this.K;
    }

    public String b()
    {
      return this.L;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.s
 * JD-Core Version:    0.6.2
 */
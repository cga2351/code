package a.a;

import com.appboy.b.a.e;
import com.appboy.e.b.a;
import com.appboy.e.n;
import com.appboy.f.c;
import com.appboy.f.i;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bp
  implements be
{
  private static final String a = c.a(bp.class);
  private final gs b;
  private final JSONObject c;
  private final double d;
  private final String e;
  private String f = null;
  private bi g = null;

  protected bp(gs paramgs, JSONObject paramJSONObject)
  {
    this(paramgs, paramJSONObject, di.b());
  }

  protected bp(gs paramgs, JSONObject paramJSONObject, double paramDouble)
  {
    this(paramgs, paramJSONObject, paramDouble, UUID.randomUUID().toString());
  }

  protected bp(gs paramgs, JSONObject paramJSONObject, double paramDouble, String paramString)
  {
    if (paramJSONObject == null)
      throw new NullPointerException("Event data cannot be null");
    if (paramgs.a() == null)
      throw new NullPointerException("Event type cannot be null");
    this.b = paramgs;
    this.c = paramJSONObject;
    this.d = paramDouble;
    this.e = paramString;
  }

  protected bp(gs paramgs, JSONObject paramJSONObject, double paramDouble, String paramString1, String paramString2, String paramString3)
  {
    if (paramJSONObject == null)
      throw new NullPointerException("Event data cannot be null");
    if (paramgs.a() == null)
      throw new NullPointerException("Event type cannot be null");
    this.b = paramgs;
    this.c = paramJSONObject;
    this.d = paramDouble;
    this.e = paramString1;
    this.f = paramString2;
    if (paramString3 != null)
      this.g = bi.a(paramString3);
  }

  public static bp a(long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("d", paramLong);
    return new bp(gs.A, localJSONObject);
  }

  public static bp a(bf parambf)
  {
    return new bp(gs.a, (JSONObject)parambf.h());
  }

  public static bp a(String paramString, double paramDouble1, double paramDouble2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("key", paramString);
    localJSONObject.put("latitude", paramDouble1);
    localJSONObject.put("longitude", paramDouble2);
    return new bp(gs.D, localJSONObject);
  }

  public static bp a(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("key", paramString);
    localJSONObject.put("value", paramInt);
    return new bp(gs.p, localJSONObject);
  }

  public static bp a(String paramString, a parama)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("n", i.a(paramString));
    if ((parama != null) && (parama.a() > 0))
      localJSONObject.put("p", parama.b());
    return new bp(gs.b, localJSONObject);
  }

  public static bp a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("geo_id", paramString1);
    localJSONObject.put("event_type", paramString2);
    return new bp(gs.k, localJSONObject);
  }

  public static bp a(String paramString1, String paramString2, double paramDouble, String paramString3, String paramString4, String paramString5)
  {
    gs localgs = gs.a(paramString1);
    if (localgs == null)
      throw new IllegalArgumentException("Cannot parse eventType " + paramString1);
    return new bp(localgs, new JSONObject(paramString2), paramDouble, paramString3, paramString4, paramString5);
  }

  public static bp a(String paramString1, String paramString2, String paramString3)
  {
    return new bp(gs.u, d(paramString1, paramString2, paramString3));
  }

  public static bp a(String paramString1, String paramString2, String paramString3, e parame)
  {
    JSONObject localJSONObject = b(paramString1, paramString2, paramString3, parame);
    return new bp(gs.x, localJSONObject);
  }

  public static bp a(String paramString1, String paramString2, String paramString3, n paramn)
  {
    return new bp(gs.w, a(paramString1, paramString2, paramString3, a(paramn), null));
  }

  public static bp a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return new bp(gs.w, a(paramString1, paramString2, paramString3, paramString4, null));
  }

  public static bp a(String paramString1, String paramString2, BigDecimal paramBigDecimal, int paramInt, a parama)
  {
    BigDecimal localBigDecimal = dt.a(paramBigDecimal);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("pid", paramString1);
    localJSONObject.put("c", paramString2);
    localJSONObject.put("p", localBigDecimal.doubleValue());
    localJSONObject.put("q", paramInt);
    if ((parama != null) && (parama.a() > 0))
      localJSONObject.put("pr", parama.b());
    return new bp(gs.c, localJSONObject);
  }

  public static bp a(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString == null);
    for (JSONArray localJSONArray = null; paramArrayOfString != null; localJSONArray = new JSONArray())
    {
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
        localJSONArray.put(paramArrayOfString[j]);
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("key", paramString);
    if (paramArrayOfString == null)
      localJSONObject.put("value", JSONObject.NULL);
    while (true)
    {
      return new bp(gs.s, localJSONObject);
      localJSONObject.put("value", localJSONArray);
    }
  }

  public static bp a(Throwable paramThrowable, bi parambi, boolean paramBoolean)
  {
    String str1 = a(paramThrowable, parambi);
    String str2 = a(paramThrowable);
    StringBuilder localStringBuilder = new StringBuilder(str1).append("\n").append(str2);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("e", localStringBuilder.toString());
    if (!paramBoolean)
      localJSONObject.put("nop", true);
    return new bp(gs.h, localJSONObject);
  }

  public static String a(n paramn)
  {
    if (paramn != null)
      return String.valueOf(paramn.a());
    return null;
  }

  static String a(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    String str = localStringWriter.toString();
    if (str.length() > 5000)
      str = str.substring(0, 5000);
    return str;
  }

  static String a(Throwable paramThrowable, bi parambi)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = paramThrowable.toString();
    if (str1.length() > 5000)
      str1 = str1.substring(0, 5000);
    localStringBuilder1.append("exception_class: ").append(str1).append(",");
    StringBuilder localStringBuilder2 = localStringBuilder1.append("session_id: ");
    if (parambi != null);
    for (String str2 = parambi.toString(); ; str2 = null)
    {
      localStringBuilder2.append(str2);
      return localStringBuilder1.toString();
    }
  }

  static JSONObject a(String paramString1, String paramString2, String paramString3, String paramString4, e parame)
  {
    JSONObject localJSONObject = new JSONObject();
    if (!i.b(paramString1))
    {
      JSONArray localJSONArray1 = new JSONArray();
      localJSONArray1.put(paramString1);
      localJSONObject.put("campaign_ids", localJSONArray1);
    }
    if (!i.b(paramString2))
    {
      JSONArray localJSONArray2 = new JSONArray();
      localJSONArray2.put(paramString2);
      localJSONObject.put("card_ids", localJSONArray2);
    }
    if (!i.b(paramString3))
    {
      JSONArray localJSONArray3 = new JSONArray();
      localJSONArray3.put(paramString3);
      localJSONObject.put("trigger_ids", localJSONArray3);
    }
    if (!i.b(paramString4))
      localJSONObject.put("bid", paramString4);
    if (parame != null)
    {
      String str = parame.a();
      if (!i.b(str))
        localJSONObject.put("error_code", str);
    }
    return localJSONObject;
  }

  public static bp b(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString);
    localJSONObject.put("ids", localJSONArray);
    return new bp(gs.i, localJSONObject);
  }

  public static bp b(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("key", paramString1);
    localJSONObject.put("value", paramString2);
    return new bp(gs.q, localJSONObject);
  }

  public static bp b(String paramString1, String paramString2, String paramString3)
  {
    return new bp(gs.t, d(paramString1, paramString2, paramString3));
  }

  static JSONObject b(String paramString1, String paramString2, String paramString3, e parame)
  {
    return a(paramString1, paramString2, paramString3, null, parame);
  }

  public static bp c(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString);
    localJSONObject.put("ids", localJSONArray);
    return new bp(gs.j, localJSONObject);
  }

  public static bp c(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("key", paramString1);
    localJSONObject.put("value", paramString2);
    return new bp(gs.r, localJSONObject);
  }

  public static bp c(String paramString1, String paramString2, String paramString3)
  {
    return new bp(gs.v, d(paramString1, paramString2, paramString3));
  }

  public static be d(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject(paramString1);
    String str = localJSONObject.getString("name");
    gs localgs = gs.a(str);
    if (localgs == null)
      throw new IllegalArgumentException("Cannot parse eventType " + str + ". Event json: " + localJSONObject);
    return new bp(localgs, localJSONObject.getJSONObject("data"), localJSONObject.getDouble("time"), paramString2, localJSONObject.optString("user_id", null), localJSONObject.optString("session_id", null));
  }

  public static bp d(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString);
    localJSONObject.put("ids", localJSONArray);
    return new bp(gs.m, localJSONObject);
  }

  static JSONObject d(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, null, null);
  }

  public static bp e(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString);
    localJSONObject.put("ids", localJSONArray);
    return new bp(gs.n, localJSONObject);
  }

  public static bp f(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString);
    localJSONObject.put("ids", localJSONArray);
    return new bp(gs.l, localJSONObject);
  }

  public static bp g(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString);
    localJSONObject.put("ids", localJSONArray);
    return new bp(gs.o, localJSONObject);
  }

  public static bp h(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("n", paramString);
    return new bp(gs.g, localJSONObject);
  }

  public static bp i()
  {
    return h("content_cards_displayed");
  }

  public static bp i(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("cid", paramString);
    return new bp(gs.C, localJSONObject);
  }

  public static bp j()
  {
    return h("feed_displayed");
  }

  public static bp k()
  {
    return h("feedback_displayed");
  }

  public static bp l()
  {
    JSONObject localJSONObject = new JSONObject();
    return new bp(gs.z, localJSONObject);
  }

  public double a()
  {
    return this.d;
  }

  public void a(bi parambi)
  {
    if (this.g == null)
    {
      this.g = parambi;
      return;
    }
    c.b(a, "Session id can only be set once. Doing nothing. Given session id: " + parambi);
  }

  public void a(String paramString)
  {
    if (this.f == null)
    {
      this.f = paramString;
      return;
    }
    c.b(a, "User id can only be set once. Doing nothing. Given user id: " + paramString);
  }

  public gs b()
  {
    return this.b;
  }

  public JSONObject c()
  {
    return this.c;
  }

  public String d()
  {
    return this.e;
  }

  public String e()
  {
    return m().toString();
  }

  public boolean e_()
  {
    gs localgs1 = this.b;
    gs localgs2 = gs.h;
    boolean bool1 = false;
    if (localgs1 == localgs2)
    {
      boolean bool2 = this.c.optBoolean("nop", false);
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    return bool1;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    bp localbp = (bp)paramObject;
    return this.e.equals(localbp.e);
  }

  public String f()
  {
    return this.f;
  }

  public bi g()
  {
    return this.g;
  }

  public int hashCode()
  {
    return this.e.hashCode();
  }

  public JSONObject m()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", this.b.a());
      localJSONObject.put("data", this.c);
      localJSONObject.put("time", this.d);
      if (!i.b(this.f))
        localJSONObject.put("user_id", this.f);
      if (this.g != null)
        localJSONObject.put("session_id", this.g.b());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      c.d(a, "Caught exception creating Braze event Json.", localJSONException);
    }
    return localJSONObject;
  }

  public String toString()
  {
    JSONObject localJSONObject = m();
    if ((localJSONObject != null) && (localJSONObject.length() > 0))
      return localJSONObject.toString();
    return "";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.bp
 * JD-Core Version:    0.6.2
 */
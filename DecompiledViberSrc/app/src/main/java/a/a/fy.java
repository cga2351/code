package a.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class fy
{
  private boolean a;
  private StringBuilder b;
  private String c;
  private Object d;
  private Object e;
  private final List<fu> f = new ArrayList();
  private final List<fu> g = new ArrayList();
  private final List<fu> h = new ArrayList();

  public fy()
  {
    this(true, null);
  }

  private fy(boolean paramBoolean, String paramString)
  {
    this.a = paramBoolean;
    if (paramString == null)
      paramString = "";
    this.b = new StringBuilder(paramString);
  }

  private static String a(Object paramObject)
  {
    if ((paramObject instanceof JSONArray))
      return "a JSON array";
    if ((paramObject instanceof JSONObject))
      return "a JSON object";
    return paramObject.toString();
  }

  private String b(String paramString, Object paramObject1, Object paramObject2)
  {
    return paramString + "\nExpected: " + a(paramObject1) + "\n     got: " + a(paramObject2) + "\n";
  }

  private String c(String paramString, Object paramObject)
  {
    return paramString + "\nExpected: " + a(paramObject) + "\n     but none found\n";
  }

  private String d(String paramString, Object paramObject)
  {
    return paramString + "\nUnexpected: " + a(paramObject) + "\n";
  }

  public fy a(String paramString, Object paramObject)
  {
    this.g.add(new fu(paramString, paramObject, null));
    a(c(paramString, paramObject));
    return this;
  }

  public fy a(String paramString, Object paramObject1, Object paramObject2)
  {
    this.f.add(new fu(paramString, paramObject1, paramObject2));
    this.c = paramString;
    this.d = paramObject1;
    this.e = paramObject2;
    a(b(paramString, paramObject1, paramObject2));
    return this;
  }

  public void a(String paramString)
  {
    this.a = false;
    if (this.b.length() == 0)
    {
      this.b.append(paramString);
      return;
    }
    this.b.append(" ; ").append(paramString);
  }

  public boolean a()
  {
    return this.a;
  }

  public fy b(String paramString, Object paramObject)
  {
    this.h.add(new fu(paramString, null, paramObject));
    a(d(paramString, paramObject));
    return this;
  }

  public boolean b()
  {
    return !this.a;
  }

  public String c()
  {
    return this.b.toString();
  }

  public String toString()
  {
    return this.b.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.fy
 * JD-Core Version:    0.6.2
 */
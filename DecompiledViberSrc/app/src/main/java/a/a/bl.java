package a.a;

import com.appboy.a.b;
import com.appboy.b.f;
import com.appboy.e.e;
import com.appboy.f.c;
import com.appboy.f.i;
import java.util.EnumSet;
import org.json.JSONException;
import org.json.JSONObject;

public class bl
  implements bg, e<JSONObject>
{
  private static final String a = c.a(bl.class);
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private String g;
  private final Boolean h;
  private final Boolean i;
  private final b j;

  public bl(b paramb, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    this.j = paramb;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.g = paramString5;
    this.f = paramString6;
    this.h = paramBoolean1;
    this.i = paramBoolean2;
  }

  public static bl a(b paramb, JSONObject paramJSONObject)
  {
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    Boolean localBoolean1 = null;
    Boolean localBoolean2 = null;
    f[] arrayOff = f.values();
    int k = arrayOff.length;
    int m = 0;
    if (m < k)
    {
      f localf = arrayOff[m];
      switch (1.a[localf.ordinal()])
      {
      default:
        c.e(a, "Unknown key encountered in Device createFromJson " + localf);
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      }
      while (true)
      {
        m++;
        break;
        str6 = i.d(paramJSONObject.optString(localf.a()));
        continue;
        str2 = i.d(paramJSONObject.optString(localf.a()));
        continue;
        str1 = i.d(paramJSONObject.optString(localf.a()));
        continue;
        str5 = i.d(paramJSONObject.optString(localf.a()));
        continue;
        str4 = i.d(paramJSONObject.optString(localf.a()));
        continue;
        str3 = i.d(paramJSONObject.optString(localf.a()));
        continue;
        if (paramJSONObject.has(localf.a()))
        {
          localBoolean1 = Boolean.valueOf(paramJSONObject.optBoolean(localf.a(), true));
          continue;
          if (paramJSONObject.has(localf.a()))
            localBoolean2 = Boolean.valueOf(paramJSONObject.optBoolean(localf.a(), false));
        }
      }
    }
    return new bl(paramb, str1, str2, str3, str4, str6, str5, localBoolean1, localBoolean2);
  }

  static void a(b paramb, JSONObject paramJSONObject, f paramf, Object paramObject)
  {
    if ((!paramb.y()) || (paramb.x().contains(paramf)))
    {
      paramJSONObject.putOpt(paramf.a(), paramObject);
      return;
    }
    c.a(a, "Not adding device key <" + paramf + "> to export due to whitelist restrictions.");
  }

  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      a(this.j, localJSONObject, f.a, this.b);
      a(this.j, localJSONObject, f.b, this.c);
      a(this.j, localJSONObject, f.c, this.d);
      a(this.j, localJSONObject, f.d, this.f);
      a(this.j, localJSONObject, f.e, this.e);
      a(this.j, localJSONObject, f.g, this.h);
      a(this.j, localJSONObject, f.h, this.i);
      if (!i.c(this.g))
        a(this.j, localJSONObject, f.f, this.g);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      c.d(a, "Caught exception creating device Json.", localJSONException);
    }
    return localJSONObject;
  }

  public boolean b()
  {
    return a().length() == 0;
  }

  public boolean c()
  {
    return a().has(f.g.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.bl
 * JD-Core Version:    0.6.2
 */
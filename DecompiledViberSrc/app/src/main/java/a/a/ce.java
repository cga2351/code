package a.a;

import android.net.Uri;
import com.appboy.c.e;
import com.appboy.c.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ce extends bz
{
  private static final String b = com.appboy.f.c.a(ce.class);
  private final com.appboy.e.b.c c;

  public ce(String paramString, com.appboy.e.b.c paramc)
  {
    super(Uri.parse(paramString + "data"), null);
    this.c = paramc;
  }

  public void a(d paramd, bu parambu)
  {
    paramd.a(new f(this.c), f.class);
  }

  public void a(d paramd1, d paramd2, bw parambw)
  {
    super.a(paramd1, paramd2, parambw);
    paramd2.a(new e(this.c, parambw), e.class);
  }

  public JSONObject g()
  {
    JSONObject localJSONObject = super.g();
    if (localJSONObject == null)
      return null;
    try
    {
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(this.c.a());
      localJSONObject.put("feedback", localJSONArray);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      com.appboy.f.c.c(b, "Experienced JSONException while retrieving parameters. Returning null.", localJSONException);
    }
    return null;
  }

  public boolean h()
  {
    return false;
  }

  public gu i()
  {
    return gu.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ce
 * JD-Core Version:    0.6.2
 */
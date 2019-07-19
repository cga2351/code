package a.a;

import android.net.Uri;
import com.appboy.f.c;
import com.appboy.f.i;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class co extends bz
{
  private static final String b = c.a(co.class);
  private final long c;
  private final List<String> d;
  private final String e;

  public co(String paramString1, List<String> paramList, long paramLong, String paramString2)
  {
    super(Uri.parse(paramString1 + "data"), null);
    this.c = paramLong;
    this.d = paramList;
    this.e = paramString2;
  }

  public void a(d paramd, bu parambu)
  {
  }

  public JSONObject g()
  {
    JSONObject localJSONObject1 = super.g();
    if (localJSONObject1 == null)
      return null;
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("time", this.c);
      if (!i.c(this.e))
        localJSONObject2.put("user_id", this.e);
      if (!this.d.isEmpty())
        localJSONObject2.put("device_logs", new JSONArray(this.d));
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(localJSONObject2);
      localJSONObject1.put("test_user_data", localJSONArray);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      c.d(b, "Experienced JSONException while retrieving parameters. Returning null.", localJSONException);
    }
    return null;
  }

  public boolean h()
  {
    return (this.d.isEmpty()) && (super.h());
  }

  public gu i()
  {
    return gu.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.co
 * JD-Core Version:    0.6.2
 */
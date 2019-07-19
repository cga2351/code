package a.a;

import android.net.Uri;
import com.appboy.f.c;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class cc extends bz
{
  private static final String b = c.a(cc.class);
  private final bn c;

  public cc(String paramString)
  {
    this(paramString, new bn.a().c());
  }

  public cc(String paramString, bn parambn)
  {
    super(Uri.parse(paramString + "data"), null);
    this.c = parambn;
    a(parambn);
  }

  public void a(d paramd, bu parambu)
  {
  }

  public void a(Map<String, String> paramMap)
  {
    int i = 1;
    super.a(paramMap);
    if (this.c.b());
    while (true)
    {
      return;
      boolean bool = this.c.e();
      int j = 0;
      if (bool)
      {
        paramMap.put("X-Braze-FeedRequest", "true");
        j = i;
      }
      if (this.c.d())
        paramMap.put("X-Braze-TriggersRequest", "true");
      while (i != 0)
      {
        paramMap.put("X-Braze-DataRequest", "true");
        return;
        i = j;
      }
    }
  }

  public JSONObject g()
  {
    JSONObject localJSONObject = super.g();
    if (localJSONObject == null)
      return null;
    try
    {
      if (!this.c.b())
        localJSONObject.put("respond_with", this.c.a());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      c.c(b, "Experienced JSONException while retrieving parameters. Returning null.", localJSONException);
    }
    return null;
  }

  public boolean h()
  {
    return (this.c.b()) && (super.h());
  }

  public gu i()
  {
    return gu.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.cc
 * JD-Core Version:    0.6.2
 */
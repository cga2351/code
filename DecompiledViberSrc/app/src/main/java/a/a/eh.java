package a.a;

import com.appboy.f.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class eh
  implements eg
{
  private String a;
  private Set<String> b = new HashSet();

  public eh(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.getJSONObject("data");
    this.a = localJSONObject.getString("id");
    JSONArray localJSONArray = localJSONObject.optJSONArray("buttons");
    if (localJSONArray != null)
      for (int i = 0; i < localJSONArray.length(); i++)
        this.b.add(localJSONArray.getString(i));
  }

  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("type", "iam_click");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("id", this.a);
      if (this.b.size() > 0)
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext())
          localJSONArray.put((String)localIterator.next());
        localJSONObject2.put("buttons", localJSONArray);
      }
      localJSONObject1.put("data", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public boolean a(ez paramez)
  {
    boolean bool1 = paramez instanceof fb;
    boolean bool2 = false;
    fb localfb;
    if (bool1)
    {
      localfb = (fb)paramez;
      boolean bool3 = i.c(localfb.a());
      bool2 = false;
      if (!bool3)
      {
        boolean bool4 = localfb.a().equals(this.a);
        bool2 = false;
        if (bool4)
        {
          if (this.b.size() <= 0)
            break label111;
          boolean bool5 = i.c(localfb.f());
          bool2 = false;
          if (!bool5)
          {
            boolean bool6 = this.b.contains(localfb.f());
            bool2 = false;
            if (bool6)
              bool2 = true;
          }
        }
      }
    }
    return bool2;
    label111: return i.c(localfb.f());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.eh
 * JD-Core Version:    0.6.2
 */
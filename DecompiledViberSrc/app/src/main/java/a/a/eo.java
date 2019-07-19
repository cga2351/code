package a.a;

import com.appboy.f.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class eo
  implements eg
{
  private static final String b = c.a(eo.class);
  ep a;

  public eo(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray1 = paramJSONObject.getJSONObject("data").getJSONArray("property_filters");
    ArrayList localArrayList1 = new ArrayList();
    for (int i = 0; i < localJSONArray1.length(); i++)
    {
      JSONArray localJSONArray2 = localJSONArray1.getJSONArray(i);
      ArrayList localArrayList2 = new ArrayList();
      for (int j = 0; j < localJSONArray2.length(); j++)
        localArrayList2.add(new ej(localJSONArray2.getJSONObject(j)));
      localArrayList1.add(new er(localArrayList2));
    }
    this.a = new ep(localArrayList1);
  }

  public JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("property_filters", this.a.a());
      localJSONObject1.put("data", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      c.d(b, "Caught exception creating Json.", localJSONException);
    }
    return localJSONObject1;
  }

  public boolean a(ez paramez)
  {
    return this.a.a(paramez);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.eo
 * JD-Core Version:    0.6.2
 */
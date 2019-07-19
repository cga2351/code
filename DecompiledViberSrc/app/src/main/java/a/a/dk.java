package a.a;

import com.appboy.e.a;
import com.appboy.f.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dk
{
  private static final String a = c.a(dk.class);

  public static List<a> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null)
      return null;
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; ; i++)
      if (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject == null);
        try
        {
          c.d(a, "Received null or blank geofence Json. Not parsing.");
          continue;
          localArrayList.add(new a(localJSONObject));
        }
        catch (JSONException localJSONException)
        {
          c.c(a, "Failed to deserialize geofence Json due to JSONException: " + localJSONObject, localJSONException);
        }
        catch (Exception localException)
        {
          c.d(a, "Failed to deserialize geofence Json:" + localJSONObject, localException);
        }
      }
      else
      {
        return localArrayList;
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.dk
 * JD-Core Version:    0.6.2
 */
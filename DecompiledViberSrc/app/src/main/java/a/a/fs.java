package a.a;

import com.appboy.e.b;
import com.appboy.f.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fs
{
  private static final String a = c.a(fs.class);

  public static b a(JSONObject paramJSONObject, au paramau)
  {
    if (paramJSONObject == null);
    try
    {
      c.b(a, "Templated message Json was null. Not de-serializing templated message.");
      return null;
      String str = paramJSONObject.getString("type");
      if (str.equals("inapp"))
        return dq.a(paramJSONObject.getJSONObject("data"), paramau);
      c.d(a, "Received templated message Json with unknown type: " + str + ". Not parsing.");
      return null;
    }
    catch (JSONException localJSONException)
    {
      c.c(a, "Encountered JSONException processing templated message: " + paramJSONObject, localJSONException);
      return null;
    }
    catch (Exception localException)
    {
      c.c(a, "Encountered general exception processing templated message: " + paramJSONObject, localException);
    }
    return null;
  }

  public static List<eg> a(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null)
      return null;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramJSONArray.length())
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      if (localJSONObject == null)
        c.d(a, "Received null or blank trigger condition Json. Not parsing.");
      while (true)
      {
        i++;
        break;
        String str = localJSONObject.getString("type");
        if (str.equals("purchase"))
          localArrayList.add(new ek(localJSONObject));
        else if (str.equals("custom_event"))
          localArrayList.add(new ec(localJSONObject));
        else if (str.equals("push_click"))
          localArrayList.add(new em(localJSONObject));
        else if (str.equals("open"))
          localArrayList.add(new ei());
        else if (str.equals("iam_click"))
          localArrayList.add(new eh(localJSONObject));
        else if (str.equals("test"))
          localArrayList.add(new en());
        else if (str.equals("custom_event_property"))
          localArrayList.add(new ed(localJSONObject));
        else if (str.equals("purchase_property"))
          localArrayList.add(new el(localJSONObject));
        else
          c.d(a, "Received triggered condition Json with unknown type: " + str + ". Not parsing.");
      }
    }
    return localArrayList;
  }

  public static List<dy> a(JSONArray paramJSONArray, au paramau)
  {
    if (paramJSONArray == null);
    try
    {
      c.b(a, "Triggered actions Json array was null. Not de-serializing triggered actions.");
      return null;
      ArrayList localArrayList = new ArrayList();
      for (int i = 0; i < paramJSONArray.length(); i++)
      {
        dy localdy = b(paramJSONArray.getJSONObject(i), paramau);
        if (localdy != null)
          localArrayList.add(localdy);
      }
      return localArrayList;
    }
    catch (JSONException localJSONException)
    {
      c.c(a, "Encountered JSONException processing triggered actions Json array: " + paramJSONArray, localJSONException);
      return null;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to deserialize triggered actions Json array: " + paramJSONArray, localException);
    }
    return null;
  }

  public static dy b(JSONObject paramJSONObject, au paramau)
  {
    Object localObject;
    try
    {
      str = paramJSONObject.getString("type");
      if (str.equals("inapp"))
        localObject = new dz(paramJSONObject, paramau);
      else if (str.equals("templated_iam"))
        localObject = new ea(paramJSONObject, paramau);
    }
    catch (JSONException localJSONException)
    {
      String str;
      c.c(a, "Encountered JSONException processing triggered action Json: " + paramJSONObject, localJSONException);
      return null;
      c.c(a, "Received unknown trigger type: " + str);
      localObject = null;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to deserialize triggered action Json: " + paramJSONObject, localException);
      return null;
    }
    return localObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.fs
 * JD-Core Version:    0.6.2
 */
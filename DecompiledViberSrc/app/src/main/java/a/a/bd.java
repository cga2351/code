package a.a;

import com.appboy.b.c.a;
import com.appboy.e.a.a;
import com.appboy.e.a.b;
import com.appboy.e.a.e;
import com.appboy.e.a.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bd
{
  private static final String a = com.appboy.f.c.a(bd.class);

  private static com.appboy.e.a.c a(String paramString, c.a parama, ap paramap, cz paramcz, bc parambc)
  {
    return a(new JSONObject(paramString), parama, paramap, paramcz, parambc);
  }

  static com.appboy.e.a.c a(JSONObject paramJSONObject, c.a parama, ap paramap, cz paramcz, bc parambc)
  {
    com.appboy.b.d locald = parama.a(paramJSONObject);
    switch (1.a[locald.ordinal()])
    {
    default:
      throw new JSONException("Failed to construct java object from JSON [" + paramJSONObject.toString() + "]");
    case 1:
      return new a(paramJSONObject, parama, paramap, paramcz, parambc);
    case 2:
      return new b(paramJSONObject, parama, paramap, paramcz, parambc);
    case 3:
      return new e(paramJSONObject, parama, paramap, paramcz, parambc);
    case 4:
      return new f(paramJSONObject, parama, paramap, paramcz, parambc);
    case 5:
    }
    return new com.appboy.e.a.d(paramJSONObject, parama, paramap, paramcz, parambc);
  }

  public static List<com.appboy.e.a.c> a(JSONArray paramJSONArray, c.a parama, ap paramap, cz paramcz, bc parambc)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (true)
      if (i < paramJSONArray.length())
        try
        {
          com.appboy.e.a.c localc = a(paramJSONArray.optString(i), parama, paramap, paramcz, parambc);
          if (localc != null)
            localArrayList.add(localc);
          i++;
        }
        catch (Exception localException)
        {
          while (true)
            com.appboy.f.c.d(a, "Unable to create Card JSON in array. Ignoring. Was on element index: " + i + " of json array: " + paramJSONArray.toString(), localException);
        }
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.bd
 * JD-Core Version:    0.6.2
 */
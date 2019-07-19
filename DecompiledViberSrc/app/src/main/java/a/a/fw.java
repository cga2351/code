package a.a;

import org.json.JSONArray;
import org.json.JSONObject;

public final class fw
{
  public static fy a(ft paramft1, ft paramft2)
  {
    fy localfy = new fy();
    if (!paramft1.a().equals(paramft2.a()))
      localfy.a("");
    return localfy;
  }

  public static fy a(String paramString1, String paramString2, fx paramfx)
  {
    return a(paramString1, paramString2, a(paramfx));
  }

  public static fy a(String paramString1, String paramString2, gc paramgc)
  {
    Object localObject1 = fz.a(paramString1);
    Object localObject2 = fz.a(paramString2);
    if (((localObject1 instanceof JSONObject)) && ((localObject2 instanceof JSONObject)))
      return a((JSONObject)localObject1, (JSONObject)localObject2, paramgc);
    if (((localObject1 instanceof JSONArray)) && ((localObject2 instanceof JSONArray)))
      return a((JSONArray)localObject1, (JSONArray)localObject2, paramgc);
    if (((localObject1 instanceof ft)) && ((localObject2 instanceof ft)))
      return a((ft)localObject1, (ft)localObject2);
    if ((localObject1 instanceof JSONObject))
      return new fy().a("", localObject1, localObject2);
    return new fy().a("", localObject1, localObject2);
  }

  public static fy a(JSONArray paramJSONArray1, JSONArray paramJSONArray2, gc paramgc)
  {
    return paramgc.a(paramJSONArray1, paramJSONArray2);
  }

  public static fy a(JSONObject paramJSONObject1, JSONObject paramJSONObject2, fx paramfx)
  {
    return a(paramJSONObject1, paramJSONObject2, a(paramfx));
  }

  public static fy a(JSONObject paramJSONObject1, JSONObject paramJSONObject2, gc paramgc)
  {
    return paramgc.a(paramJSONObject1, paramJSONObject2);
  }

  private static gc a(fx paramfx)
  {
    return new gb(paramfx);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.fw
 * JD-Core Version:    0.6.2
 */
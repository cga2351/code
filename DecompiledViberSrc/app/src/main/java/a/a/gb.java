package a.a;

import org.json.JSONArray;
import org.json.JSONObject;

public class gb extends ga
{
  fx a;

  public gb(fx paramfx)
  {
    this.a = paramfx;
  }

  public void a(String paramString, Object paramObject1, Object paramObject2, fy paramfy)
  {
    if (((paramObject1 instanceof Number)) && ((paramObject2 instanceof Number)))
      if (((Number)paramObject1).doubleValue() != ((Number)paramObject2).doubleValue())
        paramfy.a(paramString, paramObject1, paramObject2);
    do
    {
      return;
      if (!paramObject1.getClass().isAssignableFrom(paramObject2.getClass()))
        break;
      if ((paramObject1 instanceof JSONArray))
      {
        e(paramString, (JSONArray)paramObject1, (JSONArray)paramObject2, paramfy);
        return;
      }
      if ((paramObject1 instanceof JSONObject))
      {
        c(paramString, (JSONObject)paramObject1, (JSONObject)paramObject2, paramfy);
        return;
      }
    }
    while (paramObject1.equals(paramObject2));
    paramfy.a(paramString, paramObject1, paramObject2);
    return;
    paramfy.a(paramString, paramObject1, paramObject2);
  }

  public void c(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2, fy paramfy)
  {
    b(paramString, paramJSONObject1, paramJSONObject2, paramfy);
    if (!this.a.a())
      a(paramString, paramJSONObject1, paramJSONObject2, paramfy);
  }

  public void e(String paramString, JSONArray paramJSONArray1, JSONArray paramJSONArray2, fy paramfy)
  {
    if (paramJSONArray1.length() != paramJSONArray2.length())
      paramfy.a(paramString + "[]: Expected " + paramJSONArray1.length() + " values but got " + paramJSONArray2.length());
    while (paramJSONArray1.length() == 0)
      return;
    if (this.a.b())
    {
      c(paramString, paramJSONArray1, paramJSONArray2, paramfy);
      return;
    }
    if (gd.c(paramJSONArray1))
    {
      b(paramString, paramJSONArray1, paramJSONArray2, paramfy);
      return;
    }
    if (gd.d(paramJSONArray1))
    {
      a(paramString, paramJSONArray1, paramJSONArray2, paramfy);
      return;
    }
    d(paramString, paramJSONArray1, paramJSONArray2, paramfy);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.gb
 * JD-Core Version:    0.6.2
 */
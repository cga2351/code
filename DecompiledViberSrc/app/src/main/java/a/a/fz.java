package a.a;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fz
{
  public static Object a(String paramString)
  {
    if (paramString.trim().startsWith("{"))
      return new JSONObject(paramString);
    if (paramString.trim().startsWith("["))
      return new JSONArray(paramString);
    if ((paramString.trim().startsWith("\"")) || (paramString.trim().matches("-?(?:0|[1-9]\\d*)(?:\\.\\d+)?(?:[eE][+-]?\\d+)?")))
      return new ft()
      {
        public String a()
        {
          return this.a;
        }
      };
    throw new JSONException("Unparsable JSON string: " + paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.fz
 * JD-Core Version:    0.6.2
 */
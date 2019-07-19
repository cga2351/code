package a.a;

import com.appboy.f.c;
import org.json.JSONException;

public class ab
  implements bc
{
  private static final String a = c.a(ab.class);

  public be a(String paramString)
  {
    try
    {
      bp localbp = bp.b(paramString);
      return localbp;
    }
    catch (JSONException localJSONException)
    {
      c.c(a, "Failed to create feed card impression event for card: " + paramString, localJSONException);
    }
    return null;
  }

  public be c(String paramString)
  {
    c.d(a, "Cannot create card dismissed event for Feed card. Returning null. Card id: " + paramString);
    return null;
  }

  public be d(String paramString)
  {
    c.d(a, "Cannot create card control event for Feed card. Returning null. Card id: " + paramString);
    return null;
  }

  public be e(String paramString)
  {
    try
    {
      bp localbp = bp.c(paramString);
      return localbp;
    }
    catch (JSONException localJSONException)
    {
      c.c(a, "Failed to create feed card click event for card: " + paramString, localJSONException);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ab
 * JD-Core Version:    0.6.2
 */
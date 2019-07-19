package a.a;

import com.appboy.f.c;
import org.json.JSONException;

public class a
  implements bc
{
  private static final String a = c.a(a.class);

  public be a(String paramString)
  {
    try
    {
      bp localbp = bp.d(paramString);
      return localbp;
    }
    catch (JSONException localJSONException)
    {
      c.c(a, "Failed to create Content Cards impression event for card: " + paramString, localJSONException);
    }
    return null;
  }

  public bp b(String paramString)
  {
    try
    {
      bp localbp = bp.f(paramString);
      return localbp;
    }
    catch (JSONException localJSONException)
    {
      c.c(a, "Failed to create Content Cards click event for card: " + paramString, localJSONException);
    }
    return null;
  }

  public be c(String paramString)
  {
    try
    {
      bp localbp = bp.g(paramString);
      return localbp;
    }
    catch (JSONException localJSONException)
    {
      c.c(a, "Failed to create Content Cards dismissed event for card: " + paramString, localJSONException);
    }
    return null;
  }

  public be d(String paramString)
  {
    try
    {
      bp localbp = bp.e(paramString);
      return localbp;
    }
    catch (JSONException localJSONException)
    {
      c.c(a, "Failed to create Content Cards control impression event for card: " + paramString, localJSONException);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.a
 * JD-Core Version:    0.6.2
 */
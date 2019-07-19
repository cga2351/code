package a.a;

import com.appboy.e.b;
import org.json.JSONObject;

public final class k
{
  private final b a;
  private final String b;
  private final dy c;

  public k(dy paramdy, b paramb, String paramString)
  {
    this.b = paramString;
    if (paramb == null)
      throw new NullPointerException();
    this.a = paramb;
    this.c = paramdy;
  }

  public dy a()
  {
    return this.c;
  }

  public b b()
  {
    return this.a;
  }

  public String c()
  {
    return this.b;
  }

  public String toString()
  {
    return dr.a((JSONObject)this.a.h()) + "\nTriggered Action Id: " + this.c.b() + "\nUser Id: " + this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.k
 * JD-Core Version:    0.6.2
 */
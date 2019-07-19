package a.a;

import com.appboy.f.c;
import com.appboy.f.i;

public abstract class fh
  implements ez
{
  private static final String a = c.a(fh.class);
  private long b = this.c / 1000L;
  private long c = di.c();
  private be d;

  protected fh()
  {
  }

  protected fh(be parambe)
  {
    this();
    this.d = parambe;
  }

  protected String a(String paramString)
  {
    if (i.c(paramString))
      return null;
    try
    {
      String str = new String(android.util.Base64.decode(paramString, 0)).split("_")[0];
      return str;
    }
    catch (Exception localException)
    {
      c.d(a, "Unexpected error decoding Base64 encoded campaign Id " + paramString, localException);
    }
    return null;
  }

  public long c()
  {
    return this.b;
  }

  public long d()
  {
    return this.c;
  }

  public be e()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.fh
 * JD-Core Version:    0.6.2
 */
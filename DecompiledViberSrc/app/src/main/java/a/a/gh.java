package a.a;

import com.appboy.f.c;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class gh
{
  private static final String a = c.a(gh.class);
  private static gf b;

  static
  {
    try
    {
      b = new gf();
      return;
    }
    catch (Exception localException)
    {
      c.d(a, "Exception initializing static TLS socket factory.", localException);
    }
  }

  public static URLConnection a(URL paramURL)
  {
    URLConnection localURLConnection = paramURL.openConnection();
    if (paramURL.getProtocol().equals("https"));
    try
    {
      ((HttpsURLConnection)localURLConnection).setSSLSocketFactory(b);
      return localURLConnection;
    }
    catch (Exception localException)
    {
      c.d(a, "Exception setting TLS socket factory on url connection.", localException);
    }
    return localURLConnection;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.gh
 * JD-Core Version:    0.6.2
 */
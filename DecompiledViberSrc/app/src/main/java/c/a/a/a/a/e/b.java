package c.a.a.a.a.e;

import c.a.a.a.l;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class b
  implements e
{
  private final l a;
  private g b;
  private SSLSocketFactory c;
  private boolean d;

  public b()
  {
    this(new c.a.a.a.b());
  }

  public b(l paraml)
  {
    this.a = paraml;
  }

  private void a()
  {
    try
    {
      this.d = false;
      this.c = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private boolean a(String paramString)
  {
    return (paramString != null) && (paramString.toLowerCase(Locale.US).startsWith("https"));
  }

  private SSLSocketFactory b()
  {
    try
    {
      if ((this.c == null) && (!this.d))
        this.c = c();
      SSLSocketFactory localSSLSocketFactory = this.c;
      return localSSLSocketFactory;
    }
    finally
    {
    }
  }

  private SSLSocketFactory c()
  {
    try
    {
      this.d = true;
      try
      {
        localSSLSocketFactory = f.a(this.b);
        this.a.a("Fabric", "Custom SSL pinning enabled");
        return localSSLSocketFactory;
      }
      catch (Exception localException)
      {
        while (true)
        {
          this.a.e("Fabric", "Exception while validating pinned certs", localException);
          SSLSocketFactory localSSLSocketFactory = null;
        }
      }
    }
    finally
    {
    }
  }

  public d a(c paramc, String paramString, Map<String, String> paramMap)
  {
    d locald;
    switch (1.a[paramc.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unsupported HTTP method!");
    case 1:
      locald = d.a(paramString, paramMap, true);
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      if ((a(paramString)) && (this.b != null))
      {
        SSLSocketFactory localSSLSocketFactory = b();
        if (localSSLSocketFactory != null)
          ((HttpsURLConnection)locald.a()).setSSLSocketFactory(localSSLSocketFactory);
      }
      return locald;
      locald = d.b(paramString, paramMap, true);
      continue;
      locald = d.d(paramString);
      continue;
      locald = d.e(paramString);
    }
  }

  public void a(g paramg)
  {
    if (this.b != paramg)
    {
      this.b = paramg;
      a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.e.b
 * JD-Core Version:    0.6.2
 */
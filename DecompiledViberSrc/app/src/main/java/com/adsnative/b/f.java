package com.adsnative.b;

import android.content.Context;
import com.adsnative.c.b;
import java.io.IOException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class f
{
  private static f a = null;
  private Context b = null;
  private b c = null;

  private f(Context paramContext)
  {
    if (paramContext != null)
      this.b = paramContext;
    if ((this.c == null) && (this.b != null))
      this.c = new b(this.b);
  }

  public static f a(Context paramContext)
  {
    if (a == null);
    try
    {
      if (a == null)
        a = new f(paramContext);
      return a;
    }
    finally
    {
    }
  }

  public boolean a(Context paramContext, String paramString)
    throws IOException
  {
    HttpsURLConnection localHttpsURLConnection = (HttpsURLConnection)new URL(paramString).openConnection();
    if (localHttpsURLConnection.getResponseCode() == 200);
    for (boolean bool = true; ; bool = false)
    {
      localHttpsURLConnection.disconnect();
      return bool;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.b.f
 * JD-Core Version:    0.6.2
 */
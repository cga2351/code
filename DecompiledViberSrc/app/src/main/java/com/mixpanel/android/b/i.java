package com.mixpanel.android.b;

import android.content.Context;
import java.io.IOException;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

public abstract interface i
{
  public abstract void a();

  public abstract boolean a(Context paramContext, h paramh);

  public abstract byte[] a(String paramString, Map<String, Object> paramMap, SSLSocketFactory paramSSLSocketFactory)
    throws i.a, IOException;

  public static class a extends Exception
  {
    private final int a;

    public a(String paramString1, String paramString2)
    {
      super();
      try
      {
        int j = Integer.parseInt(paramString2);
        i = j;
        this.a = i;
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
          int i = 0;
      }
    }

    public int a()
    {
      return this.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.b.i
 * JD-Core Version:    0.6.2
 */
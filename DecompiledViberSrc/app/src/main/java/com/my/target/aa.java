package com.my.target;

import android.content.Context;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class aa
{
  private static volatile aa a;
  private final CookieHandler b;

  public aa(Context paramContext)
  {
    this.b = new CookieManager(new ab(paramContext), null);
  }

  public static aa a(Context paramContext)
  {
    aa localaa1 = a;
    if (localaa1 == null)
      try
      {
        aa localaa2 = a;
        if (localaa2 == null)
        {
          localaa2 = new aa(paramContext);
          a = localaa2;
        }
        return localaa2;
      }
      finally
      {
      }
    return localaa1;
  }

  public void a(URLConnection paramURLConnection)
    throws IOException
  {
    Map localMap = paramURLConnection.getHeaderFields();
    URI localURI = URI.create(paramURLConnection.getURL().toString());
    this.b.put(localURI, localMap);
  }

  public void b(URLConnection paramURLConnection)
    throws IOException
  {
    HashMap localHashMap = new HashMap();
    URI localURI = URI.create(paramURLConnection.getURL().toString());
    Iterator localIterator1 = this.b.get(localURI, localHashMap).entrySet().iterator();
    for (boolean bool1 = localIterator1.hasNext(); bool1; bool1 = localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      String str = (String)localEntry.getKey();
      Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
      for (boolean bool2 = localIterator2.hasNext(); bool2; bool2 = localIterator2.hasNext())
        paramURLConnection.addRequestProperty(str, (String)localIterator2.next());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.aa
 * JD-Core Version:    0.6.2
 */
package okhttp3;

import java.io.IOException;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

public final class JavaNetCookieJar
  implements CookieJar
{
  private final CookieHandler cookieHandler;

  public JavaNetCookieJar(CookieHandler paramCookieHandler)
  {
    this.cookieHandler = paramCookieHandler;
  }

  private List<Cookie> decodeHeaderAsJavaNetCookies(HttpUrl paramHttpUrl, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = paramString.length();
    while (i < j)
    {
      int k = Util.delimiterOffset(paramString, i, j, ";,");
      int m = Util.delimiterOffset(paramString, i, k, '=');
      String str1 = Util.trimSubstring(paramString, i, m);
      if (str1.startsWith("$"))
      {
        i = k + 1;
      }
      else
      {
        if (m < k);
        for (String str2 = Util.trimSubstring(paramString, m + 1, k); ; str2 = "")
        {
          if ((str2.startsWith("\"")) && (str2.endsWith("\"")))
            str2 = str2.substring(1, -1 + str2.length());
          localArrayList.add(new Cookie.Builder().name(str1).value(str2).domain(paramHttpUrl.host()).build());
          break;
        }
      }
    }
    return localArrayList;
  }

  public List<Cookie> loadForRequest(HttpUrl paramHttpUrl)
  {
    Map localMap1 = Collections.emptyMap();
    while (true)
    {
      Object localObject2;
      try
      {
        Map localMap2 = this.cookieHandler.get(paramHttpUrl.uri(), localMap1);
        localObject1 = null;
        Iterator localIterator1 = localMap2.entrySet().iterator();
        if (localIterator1.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator1.next();
          String str1 = (String)localEntry.getKey();
          if (((!"Cookie".equalsIgnoreCase(str1)) && (!"Cookie2".equalsIgnoreCase(str1))) || (((List)localEntry.getValue()).isEmpty()))
            continue;
          Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
          localObject2 = localObject1;
          if (!localIterator2.hasNext())
            break label234;
          String str2 = (String)localIterator2.next();
          if (localObject2 == null)
            localObject2 = new ArrayList();
          ((List)localObject2).addAll(decodeHeaderAsJavaNetCookies(paramHttpUrl, str2));
          continue;
        }
      }
      catch (IOException localIOException)
      {
        Platform.get().log(5, "Loading cookies failed for " + paramHttpUrl.resolve("/..."), localIOException);
        return Collections.emptyList();
      }
      if (localObject1 != null)
        return Collections.unmodifiableList((List)localObject1);
      return Collections.emptyList();
      label234: Object localObject1 = localObject2;
    }
  }

  public void saveFromResponse(HttpUrl paramHttpUrl, List<Cookie> paramList)
  {
    Map localMap;
    if (this.cookieHandler != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
        localArrayList.add(((Cookie)localIterator.next()).toString(true));
      localMap = Collections.singletonMap("Set-Cookie", localArrayList);
    }
    try
    {
      this.cookieHandler.put(paramHttpUrl.uri(), localMap);
      return;
    }
    catch (IOException localIOException)
    {
      Platform.get().log(5, "Saving cookies failed for " + paramHttpUrl.resolve("/..."), localIOException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.JavaNetCookieJar
 * JD-Core Version:    0.6.2
 */
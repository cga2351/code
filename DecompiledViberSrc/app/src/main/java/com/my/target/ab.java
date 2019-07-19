package com.my.target;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@TargetApi(9)
class ab
  implements CookieStore
{
  private final SharedPreferences a;
  private final Map<URI, Set<HttpCookie>> b;

  ab(Context paramContext)
  {
    this.a = paramContext.getSharedPreferences("mytarget_httpcookie_prefs", 0);
    this.b = new HashMap();
    a();
  }

  private static URI a(URI paramURI, HttpCookie paramHttpCookie)
  {
    if (paramHttpCookie.getDomain() != null)
    {
      String str1 = paramHttpCookie.getDomain();
      if (str1.charAt(0) == '.');
      for (String str2 = str1.substring(1); ; str2 = str1)
        try
        {
          String str3;
          if (paramURI.getScheme() == null)
          {
            str3 = "http";
            if (paramHttpCookie.getPath() != null)
              break label73;
          }
          label73: String str4;
          for (Object localObject = "/"; ; localObject = str4)
          {
            return new URI(str3, str2, (String)localObject, null);
            str3 = paramURI.getScheme();
            break;
            str4 = paramHttpCookie.getPath();
          }
        }
        catch (URISyntaxException localURISyntaxException)
        {
          dp.a(localURISyntaxException.getMessage());
          return paramURI;
        }
    }
    return paramURI;
  }

  private List<HttpCookie> a(URI paramURI)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator1 = this.b.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      URI localURI = (URI)localEntry.getKey();
      if ((a(localURI.getHost(), paramURI.getHost())) && (b(localURI.getPath(), paramURI.getPath())))
        localHashSet.addAll((Collection)localEntry.getValue());
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator2 = localHashSet.iterator();
    while (localIterator2.hasNext())
    {
      HttpCookie localHttpCookie = (HttpCookie)localIterator2.next();
      if (localHttpCookie.hasExpired())
      {
        localArrayList.add(localHttpCookie);
        localIterator2.remove();
      }
    }
    if (!localArrayList.isEmpty())
      a(paramURI, localArrayList);
    return new ArrayList(localHashSet);
  }

  private void a()
  {
    Iterator localIterator = this.a.getAll().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String[] arrayOfString = ((String)localEntry.getKey()).split("\\|", 2);
      try
      {
        URI localURI = new URI(arrayOfString[0]);
        String str = (String)localEntry.getValue();
        HttpCookie localHttpCookie = new ac().a(str);
        Object localObject = (Set)this.b.get(localURI);
        if (localObject == null)
        {
          localObject = new HashSet();
          this.b.put(localURI, localObject);
        }
        ((Set)localObject).add(localHttpCookie);
      }
      catch (URISyntaxException localURISyntaxException)
      {
        dp.a(localURISyntaxException.getMessage());
      }
    }
  }

  private void a(URI paramURI, List<HttpCookie> paramList)
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      HttpCookie localHttpCookie = (HttpCookie)localIterator.next();
      localEditor.remove(paramURI.toString() + "|" + localHttpCookie.getName());
    }
    localEditor.apply();
  }

  private boolean a(String paramString1, String paramString2)
  {
    return (paramString2.equals(paramString1)) || (paramString2.endsWith("." + paramString1));
  }

  private void b()
  {
    this.a.edit().clear().apply();
  }

  private void b(URI paramURI, HttpCookie paramHttpCookie)
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putString(paramURI.toString() + "|" + paramHttpCookie.getName(), new ac().a(paramHttpCookie));
    localEditor.apply();
  }

  private boolean b(String paramString1, String paramString2)
  {
    boolean bool1;
    if ((!paramString2.equals(paramString1)) && ((!paramString2.startsWith(paramString1)) || (paramString1.charAt(-1 + paramString1.length()) != '/')))
    {
      boolean bool2 = paramString2.startsWith(paramString1);
      bool1 = false;
      if (bool2)
      {
        int i = paramString2.substring(paramString1.length()).charAt(0);
        bool1 = false;
        if (i != 47);
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }

  private void c(URI paramURI, HttpCookie paramHttpCookie)
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.remove(paramURI.toString() + "|" + paramHttpCookie.getName());
    localEditor.apply();
  }

  public void add(URI paramURI, HttpCookie paramHttpCookie)
  {
    try
    {
      URI localURI = a(paramURI, paramHttpCookie);
      Object localObject2 = (Set)this.b.get(localURI);
      if (localObject2 == null)
      {
        localObject2 = new HashSet();
        this.b.put(localURI, localObject2);
      }
      ((Set)localObject2).remove(paramHttpCookie);
      ((Set)localObject2).add(paramHttpCookie);
      b(localURI, paramHttpCookie);
      return;
    }
    finally
    {
    }
  }

  public List<HttpCookie> get(URI paramURI)
  {
    try
    {
      List localList = a(paramURI);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public List<HttpCookie> getCookies()
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.b.keySet().iterator();
      while (localIterator.hasNext())
        localArrayList.addAll(a((URI)localIterator.next()));
    }
    finally
    {
    }
    return localArrayList;
  }

  public List<URI> getURIs()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.b.keySet());
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean remove(URI paramURI, HttpCookie paramHttpCookie)
  {
    try
    {
      Set localSet = (Set)this.b.get(paramURI);
      if ((localSet != null) && (localSet.remove(paramHttpCookie)));
      for (boolean bool = true; ; bool = false)
      {
        if (bool)
          c(paramURI, paramHttpCookie);
        return bool;
      }
    }
    finally
    {
    }
  }

  public boolean removeAll()
  {
    try
    {
      this.b.clear();
      b();
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ab
 * JD-Core Version:    0.6.2
 */
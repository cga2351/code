package com.google.a.a.c;

import com.google.a.a.f.a.a;
import com.google.a.a.f.a.b;
import com.google.a.a.f.a.c;
import com.google.a.a.f.n;
import com.google.a.a.f.z;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class h extends n
{
  private static final b c = new c("=&-_.!~*'()@:$,;/?:", false);
  private String d;
  private String e;
  private String f;
  private int g = -1;
  private List<String> h;
  private String i;

  public h()
  {
  }

  public h(String paramString)
  {
    this(d(paramString));
  }

  private h(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.d = paramString1.toLowerCase();
    this.e = paramString2;
    this.g = paramInt;
    this.h = c(paramString3);
    if (paramString4 != null);
    for (String str1 = a.b(paramString4); ; str1 = null)
    {
      this.i = str1;
      if (paramString5 != null)
        ae.a(paramString5, this);
      String str2 = null;
      if (paramString6 != null)
        str2 = a.b(paramString6);
      this.f = str2;
      return;
    }
  }

  public h(URL paramURL)
  {
    this(paramURL.getProtocol(), paramURL.getHost(), paramURL.getPort(), paramURL.getPath(), paramURL.getRef(), paramURL.getQuery(), paramURL.getUserInfo());
  }

  private void a(StringBuilder paramStringBuilder)
  {
    int j = this.h.size();
    for (int k = 0; k < j; k++)
    {
      String str = (String)this.h.get(k);
      if (k != 0)
        paramStringBuilder.append('/');
      if (str.length() != 0)
        paramStringBuilder.append(a.c(str));
    }
  }

  static void a(Set<Map.Entry<String, Object>> paramSet, StringBuilder paramStringBuilder)
  {
    Iterator localIterator1 = paramSet.iterator();
    boolean bool1 = true;
    Object localObject;
    String str;
    boolean bool2;
    if (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      localObject = localEntry.getValue();
      if (localObject == null)
        break label130;
      str = a.f((String)localEntry.getKey());
      if ((localObject instanceof Collection))
      {
        Iterator localIterator2 = ((Collection)localObject).iterator();
        while (localIterator2.hasNext())
          bool1 = a(bool1, paramStringBuilder, str, localIterator2.next());
        bool2 = bool1;
      }
    }
    while (true)
    {
      bool1 = bool2;
      break;
      bool2 = a(bool1, paramStringBuilder, str, localObject);
      continue;
      return;
      label130: bool2 = bool1;
    }
  }

  private static boolean a(boolean paramBoolean, StringBuilder paramStringBuilder, String paramString, Object paramObject)
  {
    if (paramBoolean)
    {
      paramBoolean = false;
      paramStringBuilder.append('?');
    }
    while (true)
    {
      paramStringBuilder.append(paramString);
      String str = a.f(paramObject.toString());
      if (str.length() != 0)
        paramStringBuilder.append('=').append(str);
      return paramBoolean;
      paramStringBuilder.append('&');
    }
  }

  public static List<String> c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return null;
    ArrayList localArrayList = new ArrayList();
    int j = 1;
    int k = 0;
    if (j != 0)
    {
      int m = paramString.indexOf('/', k);
      if (m != -1)
      {
        j = 1;
        label46: if (j == 0)
          break label84;
      }
      label84: for (String str = paramString.substring(k, m); ; str = paramString.substring(k))
      {
        localArrayList.add(a.b(str));
        k = m + 1;
        break;
        j = 0;
        break label46;
      }
    }
    return localArrayList;
  }

  private static URL d(String paramString)
  {
    try
    {
      URL localURL = new URL(paramString);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new IllegalArgumentException(localMalformedURLException);
    }
  }

  public h a()
  {
    h localh = (h)super.c();
    if (this.h != null)
      localh.h = new ArrayList(this.h);
    return localh;
  }

  public h a(String paramString, Object paramObject)
  {
    return (h)super.c(paramString, paramObject);
  }

  public final URL a(String paramString)
  {
    try
    {
      URL localURL = new URL(f(), paramString);
      return localURL;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      throw new IllegalArgumentException(localMalformedURLException);
    }
  }

  public final String b()
  {
    String str1 = String.valueOf(d());
    String str2 = String.valueOf(e());
    if (str2.length() != 0)
      return str1.concat(str2);
    return new String(str1);
  }

  public void b(String paramString)
  {
    this.h = c(paramString);
  }

  public final String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)z.a(this.d));
    localStringBuilder.append("://");
    if (this.f != null)
      localStringBuilder.append(a.e(this.f)).append('@');
    localStringBuilder.append((String)z.a(this.e));
    int j = this.g;
    if (j != -1)
      localStringBuilder.append(':').append(j);
    return localStringBuilder.toString();
  }

  public final String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.h != null)
      a(localStringBuilder);
    a(entrySet(), localStringBuilder);
    String str = this.i;
    if (str != null)
      localStringBuilder.append('#').append(c.a(str));
    return localStringBuilder.toString();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((!super.equals(paramObject)) || (!(paramObject instanceof h)))
      return false;
    h localh = (h)paramObject;
    return b().equals(localh.toString());
  }

  public final URL f()
  {
    return d(b());
  }

  public int hashCode()
  {
    return b().hashCode();
  }

  public String toString()
  {
    return b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.h
 * JD-Core Version:    0.6.2
 */
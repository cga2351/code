package com.google.a.a.c;

import com.google.a.a.f.ad;
import com.google.a.a.f.af;
import com.google.a.a.f.ag;
import com.google.a.a.f.b;
import com.google.a.a.f.h;
import com.google.a.a.f.i;
import com.google.a.a.f.n;
import com.google.a.a.f.n.c;
import com.google.a.a.f.q;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class m extends n
{

  @q(a="Accept")
  private List<String> accept;

  @q(a="Accept-Encoding")
  private List<String> acceptEncoding = new ArrayList(Collections.singleton("gzip"));

  @q(a="Age")
  private List<Long> age;

  @q(a="WWW-Authenticate")
  private List<String> authenticate;

  @q(a="Authorization")
  private List<String> authorization;

  @q(a="Cache-Control")
  private List<String> cacheControl;

  @q(a="Content-Encoding")
  private List<String> contentEncoding;

  @q(a="Content-Length")
  private List<Long> contentLength;

  @q(a="Content-MD5")
  private List<String> contentMD5;

  @q(a="Content-Range")
  private List<String> contentRange;

  @q(a="Content-Type")
  private List<String> contentType;

  @q(a="Cookie")
  private List<String> cookie;

  @q(a="Date")
  private List<String> date;

  @q(a="ETag")
  private List<String> etag;

  @q(a="Expires")
  private List<String> expires;

  @q(a="If-Match")
  private List<String> ifMatch;

  @q(a="If-Modified-Since")
  private List<String> ifModifiedSince;

  @q(a="If-None-Match")
  private List<String> ifNoneMatch;

  @q(a="If-Range")
  private List<String> ifRange;

  @q(a="If-Unmodified-Since")
  private List<String> ifUnmodifiedSince;

  @q(a="Last-Modified")
  private List<String> lastModified;

  @q(a="Location")
  private List<String> location;

  @q(a="MIME-Version")
  private List<String> mimeVersion;

  @q(a="Range")
  private List<String> range;

  @q(a="Retry-After")
  private List<String> retryAfter;

  @q(a="User-Agent")
  private List<String> userAgent;

  public m()
  {
    super(EnumSet.of(n.c.a));
  }

  private static Object a(Type paramType, List<Type> paramList, String paramString)
  {
    return i.a(i.a(paramList, paramType), paramString);
  }

  private static String a(Object paramObject)
  {
    if ((paramObject instanceof Enum))
      return com.google.a.a.f.m.a((Enum)paramObject).b();
    return paramObject.toString();
  }

  static void a(m paramm, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, Logger paramLogger, z paramz)
    throws IOException
  {
    a(paramm, paramStringBuilder1, paramStringBuilder2, paramLogger, paramz, null);
  }

  static void a(m paramm, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, Logger paramLogger, z paramz, Writer paramWriter)
    throws IOException
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator1 = paramm.entrySet().iterator();
    String str1;
    Object localObject;
    com.google.a.a.f.m localm;
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      str1 = (String)localEntry.getKey();
      com.google.a.a.f.z.a(localHashSet.add(str1), "multiple headers of the same name (headers are case insensitive): %s", new Object[] { str1 });
      localObject = localEntry.getValue();
      if (localObject != null)
      {
        localm = paramm.k().a(str1);
        if (localm == null)
          break label207;
      }
    }
    label207: for (String str2 = localm.b(); ; str2 = str1)
    {
      Class localClass = localObject.getClass();
      if (((localObject instanceof Iterable)) || (localClass.isArray()))
      {
        Iterator localIterator2 = ag.a(localObject).iterator();
        while (localIterator2.hasNext())
          a(paramLogger, paramStringBuilder1, paramStringBuilder2, paramz, str2, localIterator2.next(), paramWriter);
        break;
      }
      a(paramLogger, paramStringBuilder1, paramStringBuilder2, paramz, str2, localObject, paramWriter);
      break;
      if (paramWriter != null)
        paramWriter.flush();
      return;
    }
  }

  public static void a(m paramm, StringBuilder paramStringBuilder, Logger paramLogger, Writer paramWriter)
    throws IOException
  {
    a(paramm, paramStringBuilder, null, paramLogger, null, paramWriter);
  }

  private static void a(Logger paramLogger, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, z paramz, String paramString, Object paramObject, Writer paramWriter)
    throws IOException
  {
    if ((paramObject == null) || (i.a(paramObject)))
      return;
    String str1 = a(paramObject);
    if ((("Authorization".equalsIgnoreCase(paramString)) || ("Cookie".equalsIgnoreCase(paramString))) && ((paramLogger == null) || (!paramLogger.isLoggable(Level.ALL))));
    for (String str2 = "<Not Logged>"; ; str2 = str1)
    {
      if (paramStringBuilder1 != null)
      {
        paramStringBuilder1.append(paramString).append(": ");
        paramStringBuilder1.append(str2);
        paramStringBuilder1.append(ad.a);
      }
      if (paramStringBuilder2 != null)
        paramStringBuilder2.append(" -H '").append(paramString).append(": ").append(str2).append("'");
      if (paramz != null)
        paramz.a(paramString, str1);
      if (paramWriter == null)
        break;
      paramWriter.write(paramString);
      paramWriter.write(": ");
      paramWriter.write(str1);
      paramWriter.write("\r\n");
      return;
    }
  }

  private <T> T b(List<T> paramList)
  {
    if (paramList == null)
      return null;
    return paramList.get(0);
  }

  private <T> List<T> b(T paramT)
  {
    if (paramT == null)
      return null;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramT);
    return localArrayList;
  }

  public m a()
  {
    return (m)super.c();
  }

  public m a(Long paramLong)
  {
    this.contentLength = b(paramLong);
    return this;
  }

  public m a(String paramString)
  {
    this.acceptEncoding = b(paramString);
    return this;
  }

  public m a(String paramString, Object paramObject)
  {
    return (m)super.c(paramString, paramObject);
  }

  public m a(List<String> paramList)
  {
    this.authorization = paramList;
    return this;
  }

  public final void a(aa paramaa, StringBuilder paramStringBuilder)
    throws IOException
  {
    clear();
    b localb = new b(this, paramStringBuilder);
    int i = paramaa.g();
    for (int j = 0; j < i; j++)
      a(paramaa.a(j), paramaa.b(j), localb);
    localb.a();
  }

  public final void a(m paramm)
  {
    try
    {
      b localb = new b(this, null);
      a(paramm, null, null, null, new a(this, localb));
      localb.a();
      return;
    }
    catch (IOException localIOException)
    {
      throw af.a(localIOException);
    }
  }

  void a(String paramString1, String paramString2, b paramb)
  {
    List localList = paramb.d;
    h localh = paramb.c;
    b localb = paramb.a;
    StringBuilder localStringBuilder = paramb.b;
    if (localStringBuilder != null)
    {
      String str1 = String.valueOf(String.valueOf(paramString1));
      String str2 = String.valueOf(String.valueOf(paramString2));
      localStringBuilder.append(2 + str1.length() + str2.length() + str1 + ": " + str2).append(ad.a);
    }
    com.google.a.a.f.m localm = localh.a(paramString1);
    if (localm != null)
    {
      Type localType1 = i.a(localList, localm.d());
      if (ag.a(localType1))
      {
        Class localClass = ag.a(localList, ag.b(localType1));
        localb.a(localm.a(), localClass, a(localClass, localList, paramString2));
        return;
      }
      if (ag.a(ag.a(localList, localType1), Iterable.class))
      {
        Collection localCollection = (Collection)localm.a(this);
        if (localCollection == null)
        {
          localCollection = i.b(localType1);
          localm.a(this, localCollection);
        }
        if (localType1 == Object.class);
        for (Type localType2 = null; ; localType2 = ag.c(localType1))
        {
          localCollection.add(a(localType2, localList, paramString2));
          return;
        }
      }
      localm.a(this, a(localType1, localList, paramString2));
      return;
    }
    ArrayList localArrayList = (ArrayList)get(paramString1);
    if (localArrayList == null)
    {
      localArrayList = new ArrayList();
      a(paramString1, localArrayList);
    }
    localArrayList.add(paramString2);
  }

  public m b(String paramString)
  {
    return a(b(paramString));
  }

  public final Long b()
  {
    return (Long)b(this.contentLength);
  }

  public m c(String paramString)
  {
    this.contentEncoding = b(paramString);
    return this;
  }

  public m d(String paramString)
  {
    this.contentRange = b(paramString);
    return this;
  }

  public final String d()
  {
    return (String)b(this.contentType);
  }

  public m e(String paramString)
  {
    this.contentType = b(paramString);
    return this;
  }

  public final String e()
  {
    return (String)b(this.location);
  }

  public m f(String paramString)
  {
    this.ifModifiedSince = b(paramString);
    return this;
  }

  public final String f()
  {
    return (String)b(this.range);
  }

  public m g(String paramString)
  {
    this.ifMatch = b(paramString);
    return this;
  }

  public final String g()
  {
    return (String)b(this.userAgent);
  }

  public m h(String paramString)
  {
    this.ifNoneMatch = b(paramString);
    return this;
  }

  public m i(String paramString)
  {
    this.ifUnmodifiedSince = b(paramString);
    return this;
  }

  public m j(String paramString)
  {
    this.ifRange = b(paramString);
    return this;
  }

  public m k(String paramString)
  {
    this.userAgent = b(paramString);
    return this;
  }

  private static class a extends z
  {
    private final m a;
    private final m.b b;

    a(m paramm, m.b paramb)
    {
      this.a = paramm;
      this.b = paramb;
    }

    public aa a()
      throws IOException
    {
      throw new UnsupportedOperationException();
    }

    public void a(String paramString1, String paramString2)
    {
      this.a.a(paramString1, paramString2, this.b);
    }
  }

  private static final class b
  {
    final b a;
    final StringBuilder b;
    final h c;
    final List<Type> d;

    public b(m paramm, StringBuilder paramStringBuilder)
    {
      Class localClass = paramm.getClass();
      this.d = Arrays.asList(new Type[] { localClass });
      this.c = h.a(localClass, true);
      this.b = paramStringBuilder;
      this.a = new b(paramm);
    }

    void a()
    {
      this.a.a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.m
 * JD-Core Version:    0.6.2
 */
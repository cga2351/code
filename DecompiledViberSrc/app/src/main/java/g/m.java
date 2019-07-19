package g;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Call.Factory;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public final class m
{
  final Call.Factory a;
  final HttpUrl b;
  final List<e.a> c;
  final List<c.a> d;

  @Nullable
  final Executor e;
  final boolean f;
  private final Map<Method, n<?, ?>> g = new ConcurrentHashMap();

  m(Call.Factory paramFactory, HttpUrl paramHttpUrl, List<e.a> paramList, List<c.a> paramList1, @Nullable Executor paramExecutor, boolean paramBoolean)
  {
    this.a = paramFactory;
    this.b = paramHttpUrl;
    this.c = Collections.unmodifiableList(paramList);
    this.d = Collections.unmodifiableList(paramList1);
    this.e = paramExecutor;
    this.f = paramBoolean;
  }

  private void b(Class<?> paramClass)
  {
    j localj = j.a();
    for (Method localMethod : paramClass.getDeclaredMethods())
      if (!localj.a(localMethod))
        a(localMethod);
  }

  public c<?, ?> a(@Nullable c.a parama, Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    o.a(paramType, "returnType == null");
    o.a(paramArrayOfAnnotation, "annotations == null");
    int i = 1 + this.d.indexOf(parama);
    int j = this.d.size();
    for (int k = i; k < j; k++)
    {
      c localc = ((c.a)this.d.get(k)).a(paramType, paramArrayOfAnnotation, this);
      if (localc != null)
        return localc;
    }
    StringBuilder localStringBuilder = new StringBuilder("Could not locate call adapter for ").append(paramType).append(".\n");
    if (parama != null)
    {
      localStringBuilder.append("  Skipped:");
      for (int n = 0; n < i; n++)
        localStringBuilder.append("\n   * ").append(((c.a)this.d.get(n)).getClass().getName());
      localStringBuilder.append('\n');
    }
    localStringBuilder.append("  Tried:");
    int m = this.d.size();
    while (i < m)
    {
      localStringBuilder.append("\n   * ").append(((c.a)this.d.get(i)).getClass().getName());
      i++;
    }
    throw new IllegalArgumentException(localStringBuilder.toString());
  }

  public c<?, ?> a(Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    return a(null, paramType, paramArrayOfAnnotation);
  }

  public <T> e<ResponseBody, T> a(@Nullable e.a parama, Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    o.a(paramType, "type == null");
    o.a(paramArrayOfAnnotation, "annotations == null");
    int i = 1 + this.c.indexOf(parama);
    int j = this.c.size();
    for (int k = i; k < j; k++)
    {
      e locale = ((e.a)this.c.get(k)).a(paramType, paramArrayOfAnnotation, this);
      if (locale != null)
        return locale;
    }
    StringBuilder localStringBuilder = new StringBuilder("Could not locate ResponseBody converter for ").append(paramType).append(".\n");
    if (parama != null)
    {
      localStringBuilder.append("  Skipped:");
      for (int n = 0; n < i; n++)
        localStringBuilder.append("\n   * ").append(((e.a)this.c.get(n)).getClass().getName());
      localStringBuilder.append('\n');
    }
    localStringBuilder.append("  Tried:");
    int m = this.c.size();
    while (i < m)
    {
      localStringBuilder.append("\n   * ").append(((e.a)this.c.get(i)).getClass().getName());
      i++;
    }
    throw new IllegalArgumentException(localStringBuilder.toString());
  }

  public <T> e<T, RequestBody> a(@Nullable e.a parama, Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2)
  {
    o.a(paramType, "type == null");
    o.a(paramArrayOfAnnotation1, "parameterAnnotations == null");
    o.a(paramArrayOfAnnotation2, "methodAnnotations == null");
    int i = 1 + this.c.indexOf(parama);
    int j = this.c.size();
    for (int k = i; k < j; k++)
    {
      e locale = ((e.a)this.c.get(k)).a(paramType, paramArrayOfAnnotation1, paramArrayOfAnnotation2, this);
      if (locale != null)
        return locale;
    }
    StringBuilder localStringBuilder = new StringBuilder("Could not locate RequestBody converter for ").append(paramType).append(".\n");
    if (parama != null)
    {
      localStringBuilder.append("  Skipped:");
      for (int n = 0; n < i; n++)
        localStringBuilder.append("\n   * ").append(((e.a)this.c.get(n)).getClass().getName());
      localStringBuilder.append('\n');
    }
    localStringBuilder.append("  Tried:");
    int m = this.c.size();
    while (i < m)
    {
      localStringBuilder.append("\n   * ").append(((e.a)this.c.get(i)).getClass().getName());
      i++;
    }
    throw new IllegalArgumentException(localStringBuilder.toString());
  }

  public <T> e<T, RequestBody> a(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2)
  {
    return a(null, paramType, paramArrayOfAnnotation1, paramArrayOfAnnotation2);
  }

  n<?, ?> a(Method paramMethod)
  {
    n localn1 = (n)this.g.get(paramMethod);
    if (localn1 != null)
      return localn1;
    synchronized (this.g)
    {
      n localn2 = (n)this.g.get(paramMethod);
      if (localn2 == null)
      {
        localn2 = new n.a(this, paramMethod).a();
        this.g.put(paramMethod, localn2);
      }
      return localn2;
    }
  }

  public <T> T a(final Class<T> paramClass)
  {
    o.a(paramClass);
    if (this.f)
      b(paramClass);
    return Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, new InvocationHandler()
    {
      private final j c = j.a();

      public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, @Nullable Object[] paramAnonymousArrayOfObject)
        throws Throwable
      {
        if (paramAnonymousMethod.getDeclaringClass() == Object.class)
          return paramAnonymousMethod.invoke(this, paramAnonymousArrayOfObject);
        if (this.c.a(paramAnonymousMethod))
          return this.c.a(paramAnonymousMethod, paramClass, paramAnonymousObject, paramAnonymousArrayOfObject);
        n localn = m.this.a(paramAnonymousMethod);
        h localh = new h(localn, paramAnonymousArrayOfObject);
        return localn.d.a(localh);
      }
    });
  }

  public Call.Factory a()
  {
    return this.a;
  }

  public <T> e<ResponseBody, T> b(Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    return a(null, paramType, paramArrayOfAnnotation);
  }

  public HttpUrl b()
  {
    return this.b;
  }

  public <T> e<T, String> c(Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    o.a(paramType, "type == null");
    o.a(paramArrayOfAnnotation, "annotations == null");
    int i = this.c.size();
    for (int j = 0; j < i; j++)
    {
      e locale = ((e.a)this.c.get(j)).b(paramType, paramArrayOfAnnotation, this);
      if (locale != null)
        return locale;
    }
    return a.d.a;
  }

  public static final class a
  {
    private final j a;

    @Nullable
    private Call.Factory b;
    private HttpUrl c;
    private final List<e.a> d = new ArrayList();
    private final List<c.a> e = new ArrayList();

    @Nullable
    private Executor f;
    private boolean g;

    public a()
    {
      this(j.a());
    }

    a(j paramj)
    {
      this.a = paramj;
      this.d.add(new a());
    }

    public a a(e.a parama)
    {
      this.d.add(o.a(parama, "factory == null"));
      return this;
    }

    public a a(String paramString)
    {
      o.a(paramString, "baseUrl == null");
      HttpUrl localHttpUrl = HttpUrl.parse(paramString);
      if (localHttpUrl == null)
        throw new IllegalArgumentException("Illegal URL: " + paramString);
      return a(localHttpUrl);
    }

    public a a(Call.Factory paramFactory)
    {
      this.b = ((Call.Factory)o.a(paramFactory, "factory == null"));
      return this;
    }

    public a a(HttpUrl paramHttpUrl)
    {
      o.a(paramHttpUrl, "baseUrl == null");
      List localList = paramHttpUrl.pathSegments();
      if (!"".equals(localList.get(-1 + localList.size())))
        throw new IllegalArgumentException("baseUrl must end in /: " + paramHttpUrl);
      this.c = paramHttpUrl;
      return this;
    }

    public a a(OkHttpClient paramOkHttpClient)
    {
      return a((Call.Factory)o.a(paramOkHttpClient, "client == null"));
    }

    public m a()
    {
      if (this.c == null)
        throw new IllegalStateException("Base URL required.");
      Object localObject = this.b;
      if (localObject == null)
        localObject = new OkHttpClient();
      Executor localExecutor = this.f;
      if (localExecutor == null)
        localExecutor = this.a.b();
      ArrayList localArrayList1 = new ArrayList(this.e);
      localArrayList1.add(this.a.a(localExecutor));
      ArrayList localArrayList2 = new ArrayList(this.d);
      return new m((Call.Factory)localObject, this.c, localArrayList2, localArrayList1, localExecutor, this.g);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     g.m
 * JD-Core Version:    0.6.2
 */
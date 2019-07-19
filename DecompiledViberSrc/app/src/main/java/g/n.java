package g;

import g.b.a;
import g.b.b;
import g.b.d;
import g.b.f;
import g.b.g;
import g.b.h;
import g.b.j;
import g.b.p;
import g.b.q;
import g.b.r;
import g.b.s;
import g.b.t;
import g.b.u;
import g.b.v;
import g.b.x;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.Call.Factory;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

final class n<R, T>
{
  static final Pattern a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
  static final Pattern b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
  final Call.Factory c;
  final c<R, T> d;
  private final HttpUrl e;
  private final e<ResponseBody, R> f;
  private final String g;
  private final String h;
  private final Headers i;
  private final MediaType j;
  private final boolean k;
  private final boolean l;
  private final boolean m;
  private final i<?>[] n;

  n(a<R, T> parama)
  {
    this.c = parama.a.a();
    this.d = parama.w;
    this.e = parama.a.b();
    this.f = parama.v;
    this.g = parama.m;
    this.h = parama.q;
    this.i = parama.r;
    this.j = parama.s;
    this.k = parama.n;
    this.l = parama.o;
    this.m = parama.p;
    this.n = parama.u;
  }

  static Class<?> a(Class<?> paramClass)
  {
    if (Boolean.TYPE == paramClass)
      paramClass = Boolean.class;
    do
    {
      return paramClass;
      if (Byte.TYPE == paramClass)
        return Byte.class;
      if (Character.TYPE == paramClass)
        return Character.class;
      if (Double.TYPE == paramClass)
        return Double.class;
      if (Float.TYPE == paramClass)
        return Float.class;
      if (Integer.TYPE == paramClass)
        return Integer.class;
      if (Long.TYPE == paramClass)
        return Long.class;
    }
    while (Short.TYPE != paramClass);
    return Short.class;
  }

  static Set<String> a(String paramString)
  {
    Matcher localMatcher = a.matcher(paramString);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    while (localMatcher.find())
      localLinkedHashSet.add(localMatcher.group(1));
    return localLinkedHashSet;
  }

  R a(ResponseBody paramResponseBody)
    throws IOException
  {
    return this.f.a(paramResponseBody);
  }

  Request a(@Nullable Object[] paramArrayOfObject)
    throws IOException
  {
    k localk = new k(this.g, this.e, this.h, this.i, this.j, this.k, this.l, this.m);
    i[] arrayOfi = this.n;
    if (paramArrayOfObject != null);
    int i3;
    for (int i1 = paramArrayOfObject.length; ; i1 = 0)
    {
      int i2 = arrayOfi.length;
      i3 = 0;
      if (i1 == i2)
        break;
      throw new IllegalArgumentException("Argument count (" + i1 + ") doesn't match expected count (" + arrayOfi.length + ")");
    }
    while (i3 < i1)
    {
      arrayOfi[i3].a(localk, paramArrayOfObject[i3]);
      i3++;
    }
    return localk.a();
  }

  static final class a<T, R>
  {
    final m a;
    final Method b;
    final Annotation[] c;
    final Annotation[][] d;
    final Type[] e;
    Type f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    String m;
    boolean n;
    boolean o;
    boolean p;
    String q;
    Headers r;
    MediaType s;
    Set<String> t;
    i<?>[] u;
    e<ResponseBody, T> v;
    c<T, R> w;

    a(m paramm, Method paramMethod)
    {
      this.a = paramm;
      this.b = paramMethod;
      this.c = paramMethod.getAnnotations();
      this.e = paramMethod.getGenericParameterTypes();
      this.d = paramMethod.getParameterAnnotations();
    }

    private i<?> a(int paramInt, Type paramType, Annotation[] paramArrayOfAnnotation)
    {
      Object localObject = null;
      int i1 = paramArrayOfAnnotation.length;
      int i2 = 0;
      if (i2 < i1)
      {
        i locali = a(paramInt, paramType, paramArrayOfAnnotation, paramArrayOfAnnotation[i2]);
        if (locali == null);
        while (true)
        {
          i2++;
          break;
          if (localObject != null)
            throw a(paramInt, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
          localObject = locali;
        }
      }
      if (localObject == null)
        throw a(paramInt, "No Retrofit annotation found.", new Object[0]);
      return localObject;
    }

    private i<?> a(int paramInt, Type paramType, Annotation[] paramArrayOfAnnotation, Annotation paramAnnotation)
    {
      if ((paramAnnotation instanceof x))
      {
        if (this.l)
          throw a(paramInt, "Multiple @Url method annotations found.", new Object[0]);
        if (this.j)
          throw a(paramInt, "@Path parameters may not be used with @Url.", new Object[0]);
        if (this.k)
          throw a(paramInt, "A @Url parameter must not come after a @Query", new Object[0]);
        if (this.q != null)
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = this.m;
          throw a(paramInt, "@Url cannot be used with @%s URL", arrayOfObject2);
        }
        this.l = true;
        if ((paramType == HttpUrl.class) || (paramType == String.class) || (paramType == URI.class) || (((paramType instanceof Class)) && ("android.net.Uri".equals(((Class)paramType).getName()))))
          return new i.m();
        throw a(paramInt, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
      }
      if ((paramAnnotation instanceof s))
      {
        if (this.k)
          throw a(paramInt, "A @Path parameter must not come after a @Query.", new Object[0]);
        if (this.l)
          throw a(paramInt, "@Path parameters may not be used with @Url.", new Object[0]);
        if (this.q == null)
        {
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = this.m;
          throw a(paramInt, "@Path can only be used with relative url on @%s", arrayOfObject1);
        }
        this.j = true;
        s locals = (s)paramAnnotation;
        String str5 = locals.a();
        a(paramInt, str5);
        return new i.h(str5, this.a.c(paramType, paramArrayOfAnnotation), locals.b());
      }
      if ((paramAnnotation instanceof t))
      {
        t localt = (t)paramAnnotation;
        String str4 = localt.a();
        boolean bool3 = localt.b();
        Class localClass13 = o.a(paramType);
        this.k = true;
        if (Iterable.class.isAssignableFrom(localClass13))
        {
          if (!(paramType instanceof ParameterizedType))
            throw a(paramInt, localClass13.getSimpleName() + " must include generic type (e.g., " + localClass13.getSimpleName() + "<String>)", new Object[0]);
          Type localType17 = o.a(0, (ParameterizedType)paramType);
          return new i.i(str4, this.a.c(localType17, paramArrayOfAnnotation), bool3).a();
        }
        if (localClass13.isArray())
        {
          Class localClass14 = n.a(localClass13.getComponentType());
          return new i.i(str4, this.a.c(localClass14, paramArrayOfAnnotation), bool3).b();
        }
        return new i.i(str4, this.a.c(paramType, paramArrayOfAnnotation), bool3);
      }
      if ((paramAnnotation instanceof v))
      {
        boolean bool2 = ((v)paramAnnotation).a();
        Class localClass11 = o.a(paramType);
        this.k = true;
        if (Iterable.class.isAssignableFrom(localClass11))
        {
          if (!(paramType instanceof ParameterizedType))
            throw a(paramInt, localClass11.getSimpleName() + " must include generic type (e.g., " + localClass11.getSimpleName() + "<String>)", new Object[0]);
          Type localType16 = o.a(0, (ParameterizedType)paramType);
          return new i.k(this.a.c(localType16, paramArrayOfAnnotation), bool2).a();
        }
        if (localClass11.isArray())
        {
          Class localClass12 = n.a(localClass11.getComponentType());
          return new i.k(this.a.c(localClass12, paramArrayOfAnnotation), bool2).b();
        }
        return new i.k(this.a.c(paramType, paramArrayOfAnnotation), bool2);
      }
      if ((paramAnnotation instanceof u))
      {
        Class localClass10 = o.a(paramType);
        if (!Map.class.isAssignableFrom(localClass10))
          throw a(paramInt, "@QueryMap parameter type must be Map.", new Object[0]);
        Type localType13 = o.b(paramType, localClass10, Map.class);
        if (!(localType13 instanceof ParameterizedType))
          throw a(paramInt, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        ParameterizedType localParameterizedType4 = (ParameterizedType)localType13;
        Type localType14 = o.a(0, localParameterizedType4);
        if (String.class != localType14)
          throw a(paramInt, "@QueryMap keys must be of type String: " + localType14, new Object[0]);
        Type localType15 = o.a(1, localParameterizedType4);
        return new i.j(this.a.c(localType15, paramArrayOfAnnotation), ((u)paramAnnotation).a());
      }
      if ((paramAnnotation instanceof g.b.i))
      {
        String str3 = ((g.b.i)paramAnnotation).a();
        Class localClass8 = o.a(paramType);
        if (Iterable.class.isAssignableFrom(localClass8))
        {
          if (!(paramType instanceof ParameterizedType))
            throw a(paramInt, localClass8.getSimpleName() + " must include generic type (e.g., " + localClass8.getSimpleName() + "<String>)", new Object[0]);
          Type localType12 = o.a(0, (ParameterizedType)paramType);
          return new i.d(str3, this.a.c(localType12, paramArrayOfAnnotation)).a();
        }
        if (localClass8.isArray())
        {
          Class localClass9 = n.a(localClass8.getComponentType());
          return new i.d(str3, this.a.c(localClass9, paramArrayOfAnnotation)).b();
        }
        return new i.d(str3, this.a.c(paramType, paramArrayOfAnnotation));
      }
      if ((paramAnnotation instanceof j))
      {
        Class localClass7 = o.a(paramType);
        if (!Map.class.isAssignableFrom(localClass7))
          throw a(paramInt, "@HeaderMap parameter type must be Map.", new Object[0]);
        Type localType9 = o.b(paramType, localClass7, Map.class);
        if (!(localType9 instanceof ParameterizedType))
          throw a(paramInt, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        ParameterizedType localParameterizedType3 = (ParameterizedType)localType9;
        Type localType10 = o.a(0, localParameterizedType3);
        if (String.class != localType10)
          throw a(paramInt, "@HeaderMap keys must be of type String: " + localType10, new Object[0]);
        Type localType11 = o.a(1, localParameterizedType3);
        return new i.e(this.a.c(localType11, paramArrayOfAnnotation));
      }
      if ((paramAnnotation instanceof g.b.c))
      {
        if (!this.o)
          throw a(paramInt, "@Field parameters can only be used with form encoding.", new Object[0]);
        g.b.c localc = (g.b.c)paramAnnotation;
        String str2 = localc.a();
        boolean bool1 = localc.b();
        this.g = true;
        Class localClass5 = o.a(paramType);
        if (Iterable.class.isAssignableFrom(localClass5))
        {
          if (!(paramType instanceof ParameterizedType))
            throw a(paramInt, localClass5.getSimpleName() + " must include generic type (e.g., " + localClass5.getSimpleName() + "<String>)", new Object[0]);
          Type localType8 = o.a(0, (ParameterizedType)paramType);
          return new i.b(str2, this.a.c(localType8, paramArrayOfAnnotation), bool1).a();
        }
        if (localClass5.isArray())
        {
          Class localClass6 = n.a(localClass5.getComponentType());
          return new i.b(str2, this.a.c(localClass6, paramArrayOfAnnotation), bool1).b();
        }
        return new i.b(str2, this.a.c(paramType, paramArrayOfAnnotation), bool1);
      }
      if ((paramAnnotation instanceof d))
      {
        if (!this.o)
          throw a(paramInt, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        Class localClass4 = o.a(paramType);
        if (!Map.class.isAssignableFrom(localClass4))
          throw a(paramInt, "@FieldMap parameter type must be Map.", new Object[0]);
        Type localType5 = o.b(paramType, localClass4, Map.class);
        if (!(localType5 instanceof ParameterizedType))
          throw a(paramInt, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        ParameterizedType localParameterizedType2 = (ParameterizedType)localType5;
        Type localType6 = o.a(0, localParameterizedType2);
        if (String.class != localType6)
          throw a(paramInt, "@FieldMap keys must be of type String: " + localType6, new Object[0]);
        Type localType7 = o.a(1, localParameterizedType2);
        e locale2 = this.a.c(localType7, paramArrayOfAnnotation);
        this.g = true;
        return new i.c(locale2, ((d)paramAnnotation).a());
      }
      if ((paramAnnotation instanceof q))
      {
        if (!this.p)
          throw a(paramInt, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        q localq = (q)paramAnnotation;
        this.h = true;
        String str1 = localq.a();
        Class localClass2 = o.a(paramType);
        if (str1.isEmpty())
        {
          if (Iterable.class.isAssignableFrom(localClass2))
          {
            if (!(paramType instanceof ParameterizedType))
              throw a(paramInt, localClass2.getSimpleName() + " must include generic type (e.g., " + localClass2.getSimpleName() + "<String>)", new Object[0]);
            if (!MultipartBody.Part.class.isAssignableFrom(o.a(o.a(0, (ParameterizedType)paramType))))
              throw a(paramInt, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
            return i.l.a.a();
          }
          if (localClass2.isArray())
          {
            if (!MultipartBody.Part.class.isAssignableFrom(localClass2.getComponentType()))
              throw a(paramInt, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
            return i.l.a.b();
          }
          if (MultipartBody.Part.class.isAssignableFrom(localClass2))
            return i.l.a;
          throw a(paramInt, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
        }
        String[] arrayOfString = new String[4];
        arrayOfString[0] = "Content-Disposition";
        arrayOfString[1] = ("form-data; name=\"" + str1 + "\"");
        arrayOfString[2] = "Content-Transfer-Encoding";
        arrayOfString[3] = localq.b();
        Headers localHeaders = Headers.of(arrayOfString);
        if (Iterable.class.isAssignableFrom(localClass2))
        {
          if (!(paramType instanceof ParameterizedType))
            throw a(paramInt, localClass2.getSimpleName() + " must include generic type (e.g., " + localClass2.getSimpleName() + "<String>)", new Object[0]);
          Type localType4 = o.a(0, (ParameterizedType)paramType);
          if (MultipartBody.Part.class.isAssignableFrom(o.a(localType4)))
            throw a(paramInt, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
          return new i.f(localHeaders, this.a.a(localType4, paramArrayOfAnnotation, this.c)).a();
        }
        if (localClass2.isArray())
        {
          Class localClass3 = n.a(localClass2.getComponentType());
          if (MultipartBody.Part.class.isAssignableFrom(localClass3))
            throw a(paramInt, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
          return new i.f(localHeaders, this.a.a(localClass3, paramArrayOfAnnotation, this.c)).b();
        }
        if (MultipartBody.Part.class.isAssignableFrom(localClass2))
          throw a(paramInt, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
        return new i.f(localHeaders, this.a.a(paramType, paramArrayOfAnnotation, this.c));
      }
      if ((paramAnnotation instanceof r))
      {
        if (!this.p)
          throw a(paramInt, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        this.h = true;
        Class localClass1 = o.a(paramType);
        if (!Map.class.isAssignableFrom(localClass1))
          throw a(paramInt, "@PartMap parameter type must be Map.", new Object[0]);
        Type localType1 = o.b(paramType, localClass1, Map.class);
        if (!(localType1 instanceof ParameterizedType))
          throw a(paramInt, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        ParameterizedType localParameterizedType1 = (ParameterizedType)localType1;
        Type localType2 = o.a(0, localParameterizedType1);
        if (String.class != localType2)
          throw a(paramInt, "@PartMap keys must be of type String: " + localType2, new Object[0]);
        Type localType3 = o.a(1, localParameterizedType1);
        if (MultipartBody.Part.class.isAssignableFrom(o.a(localType3)))
          throw a(paramInt, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
        return new i.g(this.a.a(localType3, paramArrayOfAnnotation, this.c), ((r)paramAnnotation).a());
      }
      if ((paramAnnotation instanceof a))
      {
        if ((this.o) || (this.p))
          throw a(paramInt, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        if (this.i)
          throw a(paramInt, "Multiple @Body method annotations found.", new Object[0]);
        try
        {
          e locale1 = this.a.a(paramType, paramArrayOfAnnotation, this.c);
          this.i = true;
          return new i.a(locale1);
        }
        catch (RuntimeException localRuntimeException)
        {
          throw a(localRuntimeException, paramInt, "Unable to create @Body converter for %s", new Object[] { paramType });
        }
      }
      return null;
    }

    private RuntimeException a(int paramInt, String paramString, Object[] paramArrayOfObject)
    {
      return a(paramString + " (parameter #" + (paramInt + 1) + ")", paramArrayOfObject);
    }

    private RuntimeException a(String paramString, Object[] paramArrayOfObject)
    {
      return a(null, paramString, paramArrayOfObject);
    }

    private RuntimeException a(Throwable paramThrowable, int paramInt, String paramString, Object[] paramArrayOfObject)
    {
      return a(paramThrowable, paramString + " (parameter #" + (paramInt + 1) + ")", paramArrayOfObject);
    }

    private RuntimeException a(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
    {
      String str = String.format(paramString, paramArrayOfObject);
      return new IllegalArgumentException(str + "\n    for method " + this.b.getDeclaringClass().getSimpleName() + "." + this.b.getName(), paramThrowable);
    }

    private Headers a(String[] paramArrayOfString)
    {
      Headers.Builder localBuilder = new Headers.Builder();
      int i1 = paramArrayOfString.length;
      int i2 = 0;
      if (i2 < i1)
      {
        String str1 = paramArrayOfString[i2];
        int i3 = str1.indexOf(':');
        if ((i3 == -1) || (i3 == 0) || (i3 == -1 + str1.length()))
          throw a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[] { str1 });
        String str2 = str1.substring(0, i3);
        String str3 = str1.substring(i3 + 1).trim();
        if ("Content-Type".equalsIgnoreCase(str2))
        {
          MediaType localMediaType = MediaType.parse(str3);
          if (localMediaType == null)
            throw a("Malformed content type: %s", new Object[] { str3 });
          this.s = localMediaType;
        }
        while (true)
        {
          i2++;
          break;
          localBuilder.add(str2, str3);
        }
      }
      return localBuilder.build();
    }

    private void a(int paramInt, String paramString)
    {
      if (!n.b.matcher(paramString).matches())
      {
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = n.a.pattern();
        arrayOfObject2[1] = paramString;
        throw a(paramInt, "@Path parameter name must match %s. Found: %s", arrayOfObject2);
      }
      if (!this.t.contains(paramString))
      {
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = this.q;
        arrayOfObject1[1] = paramString;
        throw a(paramInt, "URL \"%s\" does not contain \"{%s}\".", arrayOfObject1);
      }
    }

    private void a(String paramString1, String paramString2, boolean paramBoolean)
    {
      if (this.m != null)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = this.m;
        arrayOfObject[1] = paramString1;
        throw a("Only one HTTP method is allowed. Found: %s and %s.", arrayOfObject);
      }
      this.m = paramString1;
      this.n = paramBoolean;
      if (paramString2.isEmpty())
        return;
      int i1 = paramString2.indexOf('?');
      if ((i1 != -1) && (i1 < -1 + paramString2.length()))
      {
        String str = paramString2.substring(i1 + 1);
        if (n.a.matcher(str).find())
          throw a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[] { str });
      }
      this.q = paramString2;
      this.t = n.a(paramString2);
    }

    private void a(Annotation paramAnnotation)
    {
      if ((paramAnnotation instanceof b))
        a("DELETE", ((b)paramAnnotation).a(), false);
      do
      {
        do
        {
          return;
          if ((paramAnnotation instanceof f))
          {
            a("GET", ((f)paramAnnotation).a(), false);
            return;
          }
          if (!(paramAnnotation instanceof g))
            break;
          a("HEAD", ((g)paramAnnotation).a(), false);
        }
        while (Void.class.equals(this.f));
        throw a("HEAD method must use Void as response type.", new Object[0]);
        if ((paramAnnotation instanceof g.b.n))
        {
          a("PATCH", ((g.b.n)paramAnnotation).a(), true);
          return;
        }
        if ((paramAnnotation instanceof g.b.o))
        {
          a("POST", ((g.b.o)paramAnnotation).a(), true);
          return;
        }
        if ((paramAnnotation instanceof p))
        {
          a("PUT", ((p)paramAnnotation).a(), true);
          return;
        }
        if ((paramAnnotation instanceof g.b.m))
        {
          a("OPTIONS", ((g.b.m)paramAnnotation).a(), false);
          return;
        }
        if ((paramAnnotation instanceof h))
        {
          h localh = (h)paramAnnotation;
          a(localh.a(), localh.b(), localh.c());
          return;
        }
        if ((paramAnnotation instanceof g.b.k))
        {
          String[] arrayOfString = ((g.b.k)paramAnnotation).a();
          if (arrayOfString.length == 0)
            throw a("@Headers annotation is empty.", new Object[0]);
          this.r = a(arrayOfString);
          return;
        }
        if ((paramAnnotation instanceof g.b.l))
        {
          if (this.o)
            throw a("Only one encoding annotation is allowed.", new Object[0]);
          this.p = true;
          return;
        }
      }
      while (!(paramAnnotation instanceof g.b.e));
      if (this.p)
        throw a("Only one encoding annotation is allowed.", new Object[0]);
      this.o = true;
    }

    private c<T, R> b()
    {
      Type localType = this.b.getGenericReturnType();
      if (o.d(localType))
        throw a("Method return type must not include a type variable or wildcard: %s", new Object[] { localType });
      if (localType == Void.TYPE)
        throw a("Service methods cannot return void.", new Object[0]);
      Annotation[] arrayOfAnnotation = this.b.getAnnotations();
      try
      {
        c localc = this.a.a(localType, arrayOfAnnotation);
        return localc;
      }
      catch (RuntimeException localRuntimeException)
      {
        throw a(localRuntimeException, "Unable to create call adapter for %s", new Object[] { localType });
      }
    }

    private e<ResponseBody, T> c()
    {
      Annotation[] arrayOfAnnotation = this.b.getAnnotations();
      try
      {
        e locale = this.a.b(this.f, arrayOfAnnotation);
        return locale;
      }
      catch (RuntimeException localRuntimeException)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.f;
        throw a(localRuntimeException, "Unable to create converter for %s", arrayOfObject);
      }
    }

    public n a()
    {
      this.w = b();
      this.f = this.w.a();
      if ((this.f == l.class) || (this.f == Response.class))
        throw a("'" + o.a(this.f).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
      this.v = c();
      Annotation[] arrayOfAnnotation1 = this.c;
      int i1 = arrayOfAnnotation1.length;
      for (int i2 = 0; i2 < i1; i2++)
        a(arrayOfAnnotation1[i2]);
      if (this.m == null)
        throw a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
      if (!this.n)
      {
        if (this.p)
          throw a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        if (this.o)
          throw a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
      }
      int i3 = this.d.length;
      this.u = new i[i3];
      for (int i4 = 0; i4 < i3; i4++)
      {
        Type localType = this.e[i4];
        if (o.d(localType))
          throw a(i4, "Parameter type must not include a type variable or wildcard: %s", new Object[] { localType });
        Annotation[] arrayOfAnnotation2 = this.d[i4];
        if (arrayOfAnnotation2 == null)
          throw a(i4, "No Retrofit annotation found.", new Object[0]);
        this.u[i4] = a(i4, localType, arrayOfAnnotation2);
      }
      if ((this.q == null) && (!this.l))
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.m;
        throw a("Missing either @%s URL or @Url parameter.", arrayOfObject);
      }
      if ((!this.o) && (!this.p) && (!this.n) && (this.i))
        throw a("Non-body HTTP method cannot contain @Body.", new Object[0]);
      if ((this.o) && (!this.g))
        throw a("Form-encoded method must contain at least one @Field.", new Object[0]);
      if ((this.p) && (!this.h))
        throw a("Multipart method must contain at least one @Part.", new Object[0]);
      return new n(this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     g.n
 * JD-Core Version:    0.6.2
 */
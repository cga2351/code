package g;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

abstract class i<T>
{
  final i<Iterable<T>> a()
  {
    return new i()
    {
      void a(k paramAnonymousk, @Nullable Iterable<T> paramAnonymousIterable)
        throws IOException
      {
        if (paramAnonymousIterable == null);
        while (true)
        {
          return;
          Iterator localIterator = paramAnonymousIterable.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = localIterator.next();
            i.this.a(paramAnonymousk, localObject);
          }
        }
      }
    };
  }

  abstract void a(k paramk, @Nullable T paramT)
    throws IOException;

  final i<Object> b()
  {
    return new i()
    {
      void a(k paramAnonymousk, @Nullable Object paramAnonymousObject)
        throws IOException
      {
        if (paramAnonymousObject == null);
        while (true)
        {
          return;
          int i = 0;
          int j = Array.getLength(paramAnonymousObject);
          while (i < j)
          {
            i.this.a(paramAnonymousk, Array.get(paramAnonymousObject, i));
            i++;
          }
        }
      }
    };
  }

  static final class a<T> extends i<T>
  {
    private final e<T, RequestBody> a;

    a(e<T, RequestBody> parame)
    {
      this.a = parame;
    }

    void a(k paramk, @Nullable T paramT)
    {
      if (paramT == null)
        throw new IllegalArgumentException("Body parameter value must not be null.");
      try
      {
        RequestBody localRequestBody = (RequestBody)this.a.a(paramT);
        paramk.a(localRequestBody);
        return;
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException("Unable to convert " + paramT + " to RequestBody", localIOException);
      }
    }
  }

  static final class b<T> extends i<T>
  {
    private final String a;
    private final e<T, String> b;
    private final boolean c;

    b(String paramString, e<T, String> parame, boolean paramBoolean)
    {
      this.a = ((String)o.a(paramString, "name == null"));
      this.b = parame;
      this.c = paramBoolean;
    }

    void a(k paramk, @Nullable T paramT)
      throws IOException
    {
      if (paramT == null);
      String str;
      do
      {
        return;
        str = (String)this.b.a(paramT);
      }
      while (str == null);
      paramk.c(this.a, str, this.c);
    }
  }

  static final class c<T> extends i<Map<String, T>>
  {
    private final e<T, String> a;
    private final boolean b;

    c(e<T, String> parame, boolean paramBoolean)
    {
      this.a = parame;
      this.b = paramBoolean;
    }

    void a(k paramk, @Nullable Map<String, T> paramMap)
      throws IOException
    {
      if (paramMap == null)
        throw new IllegalArgumentException("Field map was null.");
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str1 = (String)localEntry.getKey();
        if (str1 == null)
          throw new IllegalArgumentException("Field map contained null key.");
        Object localObject = localEntry.getValue();
        if (localObject == null)
          throw new IllegalArgumentException("Field map contained null value for key '" + str1 + "'.");
        String str2 = (String)this.a.a(localObject);
        if (str2 == null)
          throw new IllegalArgumentException("Field map value '" + localObject + "' converted to null by " + this.a.getClass().getName() + " for key '" + str1 + "'.");
        paramk.c(str1, str2, this.b);
      }
    }
  }

  static final class d<T> extends i<T>
  {
    private final String a;
    private final e<T, String> b;

    d(String paramString, e<T, String> parame)
    {
      this.a = ((String)o.a(paramString, "name == null"));
      this.b = parame;
    }

    void a(k paramk, @Nullable T paramT)
      throws IOException
    {
      if (paramT == null);
      String str;
      do
      {
        return;
        str = (String)this.b.a(paramT);
      }
      while (str == null);
      paramk.a(this.a, str);
    }
  }

  static final class e<T> extends i<Map<String, T>>
  {
    private final e<T, String> a;

    e(e<T, String> parame)
    {
      this.a = parame;
    }

    void a(k paramk, @Nullable Map<String, T> paramMap)
      throws IOException
    {
      if (paramMap == null)
        throw new IllegalArgumentException("Header map was null.");
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getKey();
        if (str == null)
          throw new IllegalArgumentException("Header map contained null key.");
        Object localObject = localEntry.getValue();
        if (localObject == null)
          throw new IllegalArgumentException("Header map contained null value for key '" + str + "'.");
        paramk.a(str, (String)this.a.a(localObject));
      }
    }
  }

  static final class f<T> extends i<T>
  {
    private final Headers a;
    private final e<T, RequestBody> b;

    f(Headers paramHeaders, e<T, RequestBody> parame)
    {
      this.a = paramHeaders;
      this.b = parame;
    }

    void a(k paramk, @Nullable T paramT)
    {
      if (paramT == null)
        return;
      try
      {
        RequestBody localRequestBody = (RequestBody)this.b.a(paramT);
        paramk.a(this.a, localRequestBody);
        return;
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException("Unable to convert " + paramT + " to RequestBody", localIOException);
      }
    }
  }

  static final class g<T> extends i<Map<String, T>>
  {
    private final e<T, RequestBody> a;
    private final String b;

    g(e<T, RequestBody> parame, String paramString)
    {
      this.a = parame;
      this.b = paramString;
    }

    void a(k paramk, @Nullable Map<String, T> paramMap)
      throws IOException
    {
      if (paramMap == null)
        throw new IllegalArgumentException("Part map was null.");
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getKey();
        if (str == null)
          throw new IllegalArgumentException("Part map contained null key.");
        Object localObject = localEntry.getValue();
        if (localObject == null)
          throw new IllegalArgumentException("Part map contained null value for key '" + str + "'.");
        String[] arrayOfString = new String[4];
        arrayOfString[0] = "Content-Disposition";
        arrayOfString[1] = ("form-data; name=\"" + str + "\"");
        arrayOfString[2] = "Content-Transfer-Encoding";
        arrayOfString[3] = this.b;
        paramk.a(Headers.of(arrayOfString), (RequestBody)this.a.a(localObject));
      }
    }
  }

  static final class h<T> extends i<T>
  {
    private final String a;
    private final e<T, String> b;
    private final boolean c;

    h(String paramString, e<T, String> parame, boolean paramBoolean)
    {
      this.a = ((String)o.a(paramString, "name == null"));
      this.b = parame;
      this.c = paramBoolean;
    }

    void a(k paramk, @Nullable T paramT)
      throws IOException
    {
      if (paramT == null)
        throw new IllegalArgumentException("Path parameter \"" + this.a + "\" value must not be null.");
      paramk.a(this.a, (String)this.b.a(paramT), this.c);
    }
  }

  static final class i<T> extends i<T>
  {
    private final String a;
    private final e<T, String> b;
    private final boolean c;

    i(String paramString, e<T, String> parame, boolean paramBoolean)
    {
      this.a = ((String)o.a(paramString, "name == null"));
      this.b = parame;
      this.c = paramBoolean;
    }

    void a(k paramk, @Nullable T paramT)
      throws IOException
    {
      if (paramT == null);
      String str;
      do
      {
        return;
        str = (String)this.b.a(paramT);
      }
      while (str == null);
      paramk.b(this.a, str, this.c);
    }
  }

  static final class j<T> extends i<Map<String, T>>
  {
    private final e<T, String> a;
    private final boolean b;

    j(e<T, String> parame, boolean paramBoolean)
    {
      this.a = parame;
      this.b = paramBoolean;
    }

    void a(k paramk, @Nullable Map<String, T> paramMap)
      throws IOException
    {
      if (paramMap == null)
        throw new IllegalArgumentException("Query map was null.");
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str1 = (String)localEntry.getKey();
        if (str1 == null)
          throw new IllegalArgumentException("Query map contained null key.");
        Object localObject = localEntry.getValue();
        if (localObject == null)
          throw new IllegalArgumentException("Query map contained null value for key '" + str1 + "'.");
        String str2 = (String)this.a.a(localObject);
        if (str2 == null)
          throw new IllegalArgumentException("Query map value '" + localObject + "' converted to null by " + this.a.getClass().getName() + " for key '" + str1 + "'.");
        paramk.b(str1, str2, this.b);
      }
    }
  }

  static final class k<T> extends i<T>
  {
    private final e<T, String> a;
    private final boolean b;

    k(e<T, String> parame, boolean paramBoolean)
    {
      this.a = parame;
      this.b = paramBoolean;
    }

    void a(k paramk, @Nullable T paramT)
      throws IOException
    {
      if (paramT == null)
        return;
      paramk.b((String)this.a.a(paramT), null, this.b);
    }
  }

  static final class l extends i<MultipartBody.Part>
  {
    static final l a = new l();

    void a(k paramk, @Nullable MultipartBody.Part paramPart)
      throws IOException
    {
      if (paramPart != null)
        paramk.a(paramPart);
    }
  }

  static final class m extends i<Object>
  {
    void a(k paramk, @Nullable Object paramObject)
    {
      o.a(paramObject, "@Url parameter is null.");
      paramk.a(paramObject);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     g.i
 * JD-Core Version:    0.6.2
 */
package com.google.a.a.c;

import com.google.a.a.e.a.a.a.a.f;
import com.google.a.a.f.a.a;
import com.google.a.a.f.ag;
import com.google.a.a.f.i;
import com.google.a.a.f.m;
import com.google.a.a.f.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ac
{
  static final Map<Character, a> a = new HashMap();

  static
  {
    a.values();
  }

  static a a(String paramString)
  {
    a locala = (a)a.get(Character.valueOf(paramString.charAt(0)));
    if (locala == null)
      locala = a.h;
    return locala;
  }

  public static String a(String paramString, Object paramObject, boolean paramBoolean)
  {
    Map localMap = a(paramObject);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int j = paramString.length();
    while (true)
    {
      int k;
      if (i < j)
      {
        k = paramString.indexOf('{', i);
        if (k == -1)
        {
          if ((i == 0) && (!paramBoolean))
            return paramString;
          localStringBuilder.append(paramString.substring(i));
        }
      }
      else
      {
        if (paramBoolean)
          h.a(localMap.entrySet(), localStringBuilder);
        return localStringBuilder.toString();
      }
      localStringBuilder.append(paramString.substring(i, k));
      int m = paramString.indexOf('}', k + 2);
      int n = m + 1;
      String str1 = paramString.substring(k + 1, m);
      a locala = a(str1);
      ListIterator localListIterator = f.a(',').a(str1).listIterator();
      int i1 = 1;
      while (localListIterator.hasNext())
      {
        String str2 = (String)localListIterator.next();
        boolean bool = str2.endsWith("*");
        int i2;
        label210: String str3;
        Object localObject;
        int i4;
        if (localListIterator.nextIndex() == 1)
        {
          i2 = locala.d();
          int i3 = str2.length();
          if (bool)
            i3--;
          str3 = str2.substring(i2, i3);
          localObject = localMap.remove(str3);
          if (localObject != null)
            if (i1 == 0)
            {
              localStringBuilder.append(locala.b());
              i4 = i1;
              label271: if (!(localObject instanceof Iterator))
                break label333;
              localObject = a(str3, (Iterator)localObject, bool, locala);
            }
        }
        else
        {
          while (true)
          {
            localStringBuilder.append(localObject);
            i1 = i4;
            break;
            i2 = 0;
            break label210;
            localStringBuilder.append(locala.a());
            i4 = 0;
            break label271;
            label333: if (((localObject instanceof Iterable)) || (localObject.getClass().isArray()))
            {
              localObject = a(str3, ag.a(localObject).iterator(), bool, locala);
            }
            else if (localObject.getClass().isEnum())
            {
              if (m.a((Enum)localObject).b() != null)
              {
                if (locala.c())
                  localObject = String.format("%s=%s", new Object[] { str3, localObject });
                localObject = a.c(localObject.toString());
              }
            }
            else if (!i.d(localObject))
            {
              localObject = a(str3, a(localObject), bool, locala);
            }
            else
            {
              if (locala.c())
                localObject = String.format("%s=%s", new Object[] { str3, localObject });
              if (locala.e())
                localObject = a.d(localObject.toString());
              else
                localObject = a.c(localObject.toString());
            }
          }
        }
      }
      i = n;
    }
  }

  public static String a(String paramString1, String paramString2, Object paramObject, boolean paramBoolean)
  {
    String str1;
    String str3;
    if (paramString2.startsWith("/"))
    {
      h localh = new h(paramString1);
      localh.b(null);
      str1 = String.valueOf(localh.b());
      String str2 = String.valueOf(paramString2);
      if (str2.length() != 0)
        str3 = str1.concat(str2);
    }
    while (true)
    {
      return a(str3, paramObject, paramBoolean);
      str3 = new String(str1);
      continue;
      if ((paramString2.startsWith("http://")) || (paramString2.startsWith("https://")))
      {
        str3 = paramString2;
      }
      else
      {
        String str4 = String.valueOf(paramString1);
        String str5 = String.valueOf(paramString2);
        if (str5.length() != 0)
          str3 = str4.concat(str5);
        else
          str3 = new String(str4);
      }
    }
  }

  private static String a(String paramString, Iterator<?> paramIterator, boolean paramBoolean, a parama)
  {
    if (!paramIterator.hasNext())
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (paramBoolean)
      str = parama.b();
    while (paramIterator.hasNext())
    {
      if ((paramBoolean) && (parama.c()))
      {
        localStringBuilder.append(a.c(paramString));
        localStringBuilder.append("=");
      }
      localStringBuilder.append(parama.a(paramIterator.next().toString()));
      if (paramIterator.hasNext())
      {
        localStringBuilder.append(str);
        continue;
        str = ",";
        if (parama.c())
        {
          localStringBuilder.append(a.c(paramString));
          localStringBuilder.append("=");
        }
      }
    }
    return localStringBuilder.toString();
  }

  private static String a(String paramString, Map<String, Object> paramMap, boolean paramBoolean, a parama)
  {
    if (paramMap.isEmpty())
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    String str5;
    String str1;
    if (paramBoolean)
    {
      str5 = parama.b();
      str1 = "=";
    }
    for (String str2 = str5; ; str2 = ",")
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str3 = parama.a((String)localEntry.getKey());
        String str4 = parama.a(localEntry.getValue().toString());
        localStringBuilder.append(str3);
        localStringBuilder.append(str1);
        localStringBuilder.append(str4);
        if (localIterator.hasNext())
          localStringBuilder.append(str2);
      }
      if (parama.c())
      {
        localStringBuilder.append(a.c(paramString));
        localStringBuilder.append("=");
      }
      str1 = ",";
    }
    return localStringBuilder.toString();
  }

  private static Map<String, Object> a(Object paramObject)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Iterator localIterator = i.b(paramObject).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = localEntry.getValue();
      if ((localObject != null) && (!i.a(localObject)))
        localLinkedHashMap.put(localEntry.getKey(), localObject);
    }
    return localLinkedHashMap;
  }

  private static enum a
  {
    private final Character i;
    private final String j;
    private final String k;
    private final boolean l;
    private final boolean m;

    static
    {
      a[] arrayOfa = new a[8];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
    }

    private a(Character paramCharacter, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.i = paramCharacter;
      this.j = ((String)z.a(paramString1));
      this.k = ((String)z.a(paramString2));
      this.l = paramBoolean1;
      this.m = paramBoolean2;
      if (paramCharacter != null)
        ac.a.put(paramCharacter, this);
    }

    String a()
    {
      return this.j;
    }

    String a(String paramString)
    {
      if (this.m)
        return a.c(paramString);
      return a.a(paramString);
    }

    String b()
    {
      return this.k;
    }

    boolean c()
    {
      return this.l;
    }

    int d()
    {
      if (this.i == null)
        return 0;
      return 1;
    }

    boolean e()
    {
      return this.m;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.c.ac
 * JD-Core Version:    0.6.2
 */
package com.e.b;

import com.e.a.d.e;
import e.a.b.a;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  implements Serializable
{
  private static final Set<String> a = Collections.unmodifiableSet(localHashSet);
  private final Map<String, Object> b = new LinkedHashMap();

  static
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("iss");
    localHashSet.add("sub");
    localHashSet.add("aud");
    localHashSet.add("exp");
    localHashSet.add("nbf");
    localHashSet.add("iat");
    localHashSet.add("jti");
  }

  private b(Map<String, Object> paramMap)
  {
    this.b.putAll(paramMap);
  }

  public static b a(e.a.b.d paramd)
    throws ParseException
  {
    a locala = new a();
    Iterator localIterator = paramd.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return locala.a();
      String str = (String)localIterator.next();
      if (str.equals("iss"))
      {
        locala.a(e.b(paramd, "iss"));
      }
      else if (str.equals("sub"))
      {
        locala.b(e.b(paramd, "sub"));
      }
      else if (str.equals("aud"))
      {
        Object localObject = paramd.get("aud");
        if ((localObject instanceof String))
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(e.b(paramd, "aud"));
          locala.a(localArrayList);
        }
        else if ((localObject instanceof List))
        {
          locala.a(e.f(paramd, "aud"));
        }
      }
      else if (str.equals("exp"))
      {
        locala.a(new Date(1000L * e.a(paramd, "exp")));
      }
      else if (str.equals("nbf"))
      {
        locala.b(new Date(1000L * e.a(paramd, "nbf")));
      }
      else if (str.equals("iat"))
      {
        locala.c(new Date(1000L * e.a(paramd, "iat")));
      }
      else if (str.equals("jti"))
      {
        locala.c(e.b(paramd, "jti"));
      }
      else
      {
        locala.a(str, paramd.get(str));
      }
    }
  }

  public Object a(String paramString)
  {
    return this.b.get(paramString);
  }

  public List<String> a()
  {
    Object localObject = a("aud");
    if ((localObject instanceof String))
      return Collections.singletonList((String)localObject);
    try
    {
      List localList = c("aud");
      if (localList != null)
        return Collections.unmodifiableList(localList);
    }
    catch (ParseException localParseException)
    {
      return Collections.emptyList();
    }
    return Collections.emptyList();
  }

  public Map<String, Object> b()
  {
    return Collections.unmodifiableMap(this.b);
  }

  public String[] b(String paramString)
    throws ParseException
  {
    if (a(paramString) == null)
      return null;
    while (true)
    {
      List localList;
      String[] arrayOfString;
      int i;
      try
      {
        localList = (List)a(paramString);
        arrayOfString = new String[localList.size()];
        i = 0;
        if (i >= arrayOfString.length)
          return arrayOfString;
      }
      catch (ClassCastException localClassCastException1)
      {
        throw new ParseException("The \"" + paramString + "\" claim is not a list / JSON array", 0);
      }
      try
      {
        arrayOfString[i] = ((String)localList.get(i));
        i++;
      }
      catch (ClassCastException localClassCastException2)
      {
      }
    }
    throw new ParseException("The \"" + paramString + "\" claim is not a list / JSON array of strings", 0);
  }

  public e.a.b.d c()
  {
    e.a.b.d locald = new e.a.b.d();
    Iterator localIterator = this.b.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return locald;
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() instanceof Date))
      {
        Date localDate = (Date)localEntry.getValue();
        locald.put((String)localEntry.getKey(), Long.valueOf(com.e.a.d.d.a(localDate)));
      }
      else if ("aud".equals(localEntry.getKey()))
      {
        List localList = a();
        if ((localList != null) && (!localList.isEmpty()))
          if (localList.size() == 1)
          {
            locald.put("aud", localList.get(0));
          }
          else
          {
            a locala = new a();
            locala.addAll(localList);
            locald.put("aud", locala);
          }
      }
      else if (localEntry.getValue() != null)
      {
        locald.put((String)localEntry.getKey(), localEntry.getValue());
      }
    }
  }

  public List<String> c(String paramString)
    throws ParseException
  {
    String[] arrayOfString = b(paramString);
    if (arrayOfString == null)
      return null;
    return Collections.unmodifiableList(Arrays.asList(arrayOfString));
  }

  public String toString()
  {
    return c().b();
  }

  public static class a
  {
    private final Map<String, Object> a = new LinkedHashMap();

    public a a(String paramString)
    {
      this.a.put("iss", paramString);
      return this;
    }

    public a a(String paramString, Object paramObject)
    {
      this.a.put(paramString, paramObject);
      return this;
    }

    public a a(Date paramDate)
    {
      this.a.put("exp", paramDate);
      return this;
    }

    public a a(List<String> paramList)
    {
      this.a.put("aud", paramList);
      return this;
    }

    public b a()
    {
      return new b(this.a, null);
    }

    public a b(String paramString)
    {
      this.a.put("sub", paramString);
      return this;
    }

    public a b(Date paramDate)
    {
      this.a.put("nbf", paramDate);
      return this;
    }

    public a c(String paramString)
    {
      this.a.put("jti", paramString);
      return this;
    }

    public a c(Date paramDate)
    {
      this.a.put("iat", paramDate);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.e.b.b
 * JD-Core Version:    0.6.2
 */
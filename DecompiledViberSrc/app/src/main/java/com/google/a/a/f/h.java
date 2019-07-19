package com.google.a.a.f;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.WeakHashMap;

public final class h
{
  private static final Map<Class<?>, h> b = new WeakHashMap();
  private static final Map<Class<?>, h> c = new WeakHashMap();
  final List<String> a;
  private final Class<?> d;
  private final boolean e;
  private final IdentityHashMap<String, m> f = new IdentityHashMap();

  private h(Class<?> paramClass, boolean paramBoolean)
  {
    this.d = paramClass;
    this.e = paramBoolean;
    if ((!paramBoolean) || (!paramClass.isEnum()));
    TreeSet localTreeSet;
    Field localField1;
    m localm1;
    for (boolean bool1 = true; ; bool1 = false)
    {
      String str1 = String.valueOf(String.valueOf(paramClass));
      z.a(bool1, 31 + str1.length() + "cannot ignore case on an enum: " + str1);
      localTreeSet = new TreeSet(new Comparator()
      {
        public int a(String paramAnonymousString1, String paramAnonymousString2)
        {
          if (paramAnonymousString1 == paramAnonymousString2)
            return 0;
          if (paramAnonymousString1 == null)
            return -1;
          if (paramAnonymousString2 == null)
            return 1;
          return paramAnonymousString1.compareTo(paramAnonymousString2);
        }
      });
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int i = arrayOfField.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label291;
        localField1 = arrayOfField[j];
        localm1 = m.a(localField1);
        if (localm1 != null)
          break;
      }
    }
    String str3 = localm1.b();
    if (paramBoolean);
    for (String str4 = str3.toLowerCase().intern(); ; str4 = str3)
    {
      m localm2 = (m)this.f.get(str4);
      boolean bool2;
      label190: Object[] arrayOfObject;
      String str5;
      if (localm2 == null)
      {
        bool2 = true;
        arrayOfObject = new Object[4];
        if (!paramBoolean)
          break label274;
        str5 = "case-insensitive ";
        label204: arrayOfObject[0] = str5;
        arrayOfObject[1] = str4;
        arrayOfObject[2] = localField1;
        if (localm2 != null)
          break label281;
      }
      label274: label281: for (Field localField2 = null; ; localField2 = localm2.a())
      {
        arrayOfObject[3] = localField2;
        z.a(bool2, "two fields have the same %sname <%s>: %s and %s", arrayOfObject);
        this.f.put(str4, localm1);
        localTreeSet.add(str4);
        break;
        bool2 = false;
        break label190;
        str5 = "";
        break label204;
      }
      label291: Class localClass = paramClass.getSuperclass();
      if (localClass != null)
      {
        h localh = a(localClass, paramBoolean);
        localTreeSet.addAll(localh.a);
        Iterator localIterator = localh.f.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str2 = (String)localEntry.getKey();
          if (!this.f.containsKey(str2))
            this.f.put(str2, localEntry.getValue());
        }
      }
      if (localTreeSet.isEmpty());
      for (List localList = Collections.emptyList(); ; localList = Collections.unmodifiableList(new ArrayList(localTreeSet)))
      {
        this.a = localList;
        return;
      }
    }
  }

  public static h a(Class<?> paramClass)
  {
    return a(paramClass, false);
  }

  public static h a(Class<?> paramClass, boolean paramBoolean)
  {
    if (paramClass == null)
      return null;
    if (paramBoolean);
    while (true)
    {
      synchronized (c)
      {
        h localh = (h)???.get(paramClass);
        if (localh == null)
        {
          localh = new h(paramClass, paramBoolean);
          ???.put(paramClass, localh);
        }
        return localh;
      }
      ??? = b;
    }
  }

  public m a(String paramString)
  {
    if (paramString != null)
    {
      if (this.e)
        paramString = paramString.toLowerCase();
      paramString = paramString.intern();
    }
    return (m)this.f.get(paramString);
  }

  public final boolean a()
  {
    return this.e;
  }

  public Field b(String paramString)
  {
    m localm = a(paramString);
    if (localm == null)
      return null;
    return localm.a();
  }

  public boolean b()
  {
    return this.d.isEnum();
  }

  public Collection<m> c()
  {
    return Collections.unmodifiableCollection(this.f.values());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.h
 * JD-Core Version:    0.6.2
 */
package com.google.a.a.d;

import com.google.a.a.f.aa;
import com.google.a.a.f.ag;
import com.google.a.a.f.m;
import com.google.a.a.f.n;
import com.google.a.a.f.z;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class f
{
  private static WeakHashMap<Class<?>, Field> a = new WeakHashMap();
  private static final Lock b = new ReentrantLock();

  private final Object a(Field paramField, Type paramType, ArrayList<Type> paramArrayList, Object paramObject, a parama, boolean paramBoolean)
    throws IOException
  {
    Type localType1 = com.google.a.a.f.i.a(paramArrayList, paramType);
    Class localClass1;
    Object localObject2;
    if ((localType1 instanceof Class))
    {
      localClass1 = (Class)localType1;
      if ((localType1 instanceof ParameterizedType))
        localClass1 = ag.a((ParameterizedType)localType1);
      if (localClass1 != Void.class)
        break label64;
      f();
      localObject2 = null;
    }
    label64: i locali;
    boolean bool9;
    Collection localCollection;
    Type localType3;
    label365: boolean bool5;
    label438: Field localField;
    label466: int i;
    label511: Type localType2;
    label525: label575: label598: label608: 
    do
    {
      return localObject2;
      localClass1 = null;
      break;
      locali = d();
      try
      {
        switch (1.a[d().ordinal()])
        {
        default:
          String str7 = String.valueOf(String.valueOf(locali));
          throw new IllegalArgumentException(27 + str7.length() + "unexpected JSON node type: " + str7);
        case 2:
        case 3:
        case 1:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str1 = e();
        if (str1 != null)
          localStringBuilder.append("key ").append(str1);
        if (paramField != null)
        {
          if (str1 != null)
            localStringBuilder.append(", ");
          localStringBuilder.append("field ").append(paramField);
        }
        throw new IllegalArgumentException(localStringBuilder.toString(), localIllegalArgumentException);
      }
      boolean bool8 = ag.a(localType1);
      if ((localType1 == null) || (bool8))
        break label1392;
      if ((localClass1 == null) || (!ag.a(localClass1, Collection.class)))
        break label1398;
      break label1392;
      z.a(bool9, "expected collection or array type but got %s", new Object[] { localType1 });
      localCollection = null;
      if (parama != null)
      {
        localCollection = null;
        if (paramField != null)
          localCollection = parama.a(paramObject, paramField);
      }
      if (localCollection == null)
        localCollection = com.google.a.a.f.i.b(localType1);
      if (bool8);
      for (localType3 = ag.b(localType1); ; localType3 = ag.c(localType1))
      {
        Type localType4 = com.google.a.a.f.i.a(paramArrayList, localType3);
        a(paramField, localCollection, localType4, paramArrayList, parama);
        if (!bool8)
          break label1404;
        return ag.a(localCollection, ag.a(paramArrayList, localType4));
        if ((localClass1 == null) || (!Iterable.class.isAssignableFrom(localClass1)))
          break;
      }
      if (ag.a(localType1))
        break label1407;
      bool5 = true;
      z.a(bool5, "expected object or map type but got %s", new Object[] { localType1 });
      if (!paramBoolean)
        break label1413;
      localField = b(localClass1);
      localObject2 = null;
      if (localClass1 != null)
      {
        localObject2 = null;
        if (parama != null)
          localObject2 = parama.a(paramObject, localClass1);
      }
      if ((localClass1 == null) || (!ag.a(localClass1, Map.class)))
        break label1419;
      i = 1;
      if (localField == null)
        break label1425;
      localObject2 = new b();
      int j;
      while (true)
      {
        j = paramArrayList.size();
        if (localType1 != null)
          paramArrayList.add(localType1);
        if ((i == 0) || (n.class.isAssignableFrom(localClass1)))
          break;
        if (!Map.class.isAssignableFrom(localClass1))
          break label1443;
        localType2 = ag.d(localType1);
        if (localType2 == null)
          break;
        a(paramField, (Map)localObject2, localType2, paramArrayList, parama);
        return localObject2;
        localObject2 = com.google.a.a.f.i.b(localClass1);
        continue;
        localObject2 = ag.a(localClass1);
      }
      a(paramArrayList, localObject2, parama);
      if (localType1 != null)
        paramArrayList.remove(j);
    }
    while (localField == null);
    Object localObject3 = ((b)localObject2).get(localField.getName());
    boolean bool6;
    label667: int m;
    label706: Class localClass2;
    label750: boolean bool7;
    label865: boolean bool4;
    Boolean localBoolean;
    label923: boolean bool3;
    label1269: boolean bool2;
    if (localObject3 != null)
    {
      bool6 = true;
      z.a(bool6, "No value specified for @JsonPolymorphicTypeMap field");
      String str4 = localObject3.toString();
      g.a[] arrayOfa = ((g)localField.getAnnotation(g.class)).a();
      int k = arrayOfa.length;
      m = 0;
      localClass2 = null;
      if (m < k)
      {
        g.a locala = arrayOfa[m];
        if (!locala.a().equals(str4))
          break label1466;
        localClass2 = locala.b();
        break label1449;
        String str5 = String.valueOf(str4);
        if (str5.length() != 0);
        for (String str6 = "No TypeDef annotation found with key: ".concat(str5); ; str6 = new String("No TypeDef annotation found with key: "))
        {
          z.a(bool7, str6);
          c localc = a();
          f localf = localc.a(localc.a(localObject2));
          localf.p();
          return localf.a(paramField, localClass2, paramArrayList, null, null, false);
        }
        if ((localType1 == null) || (localClass1 == Boolean.TYPE))
          break label1478;
        if ((localClass1 == null) || (!localClass1.isAssignableFrom(Boolean.class)))
          break label1487;
        break label1478;
        z.a(bool4, "expected type Boolean or boolean but got %s", new Object[] { localType1 });
        if (locali == i.i)
        {
          localBoolean = Boolean.TRUE;
          break label1484;
        }
        localBoolean = Boolean.FALSE;
        break label1484;
        if (paramField == null)
          break label1493;
        if (paramField.getAnnotation(h.class) != null)
          break label1499;
        break label1493;
        z.a(bool3, "number type formatted as a JSON number cannot use @JsonString annotation");
        if ((localClass1 == null) || (localClass1.isAssignableFrom(BigDecimal.class)))
          return o();
        if (localClass1 == BigInteger.class)
          return n();
        if ((localClass1 == Double.class) || (localClass1 == Double.TYPE))
          return Double.valueOf(m());
        if ((localClass1 == Long.class) || (localClass1 == Long.TYPE))
          return Long.valueOf(l());
        if ((localClass1 == Float.class) || (localClass1 == Float.TYPE))
          return Float.valueOf(k());
        if ((localClass1 == Integer.class) || (localClass1 == Integer.TYPE))
          return Integer.valueOf(j());
        if ((localClass1 == Short.class) || (localClass1 == Short.TYPE))
          return Short.valueOf(i());
        if ((localClass1 == Byte.class) || (localClass1 == Byte.TYPE))
          return Byte.valueOf(h());
        String str3 = String.valueOf(String.valueOf(localType1));
        throw new IllegalArgumentException(30 + str3.length() + "expected numeric type but got " + str3);
        String str2 = g().trim().toLowerCase(Locale.US);
        if (((localClass1 != Float.TYPE) && (localClass1 != Float.class) && (localClass1 != Double.TYPE) && (localClass1 != Double.class)) || ((!str2.equals("nan")) && (!str2.equals("infinity")) && (!str2.equals("-infinity"))))
        {
          if ((localClass1 == null) || (!Number.class.isAssignableFrom(localClass1)))
            break label1505;
          if ((paramField == null) || (paramField.getAnnotation(h.class) == null))
            break label1511;
          break label1505;
          z.a(bool2, "number field formatted as a JSON string must use the @JsonString annotation");
        }
        return com.google.a.a.f.i.a(localType1, g());
        if (localClass1 == null)
          break label1517;
        if (localClass1.isPrimitive())
          break label1523;
        break label1517;
      }
    }
    while (true)
    {
      z.a(bool1, "primitive number field but found a JSON null");
      if ((localClass1 != null) && ((0x600 & localClass1.getModifiers()) != 0))
      {
        if (ag.a(localClass1, Collection.class))
          return com.google.a.a.f.i.a(com.google.a.a.f.i.b(localType1).getClass());
        if (ag.a(localClass1, Map.class))
          return com.google.a.a.f.i.a(com.google.a.a.f.i.b(localClass1).getClass());
      }
      Object localObject1 = com.google.a.a.f.i.a(ag.a(paramArrayList, localType1));
      return localObject1;
      localType3 = null;
      break label365;
      label1392: bool9 = true;
      break;
      label1398: bool9 = false;
      break;
      label1404: return localCollection;
      label1407: bool5 = false;
      break label438;
      label1413: localField = null;
      break label466;
      label1419: i = 0;
      break label511;
      label1425: if (localObject2 != null)
        break label525;
      if (i != 0)
        break label598;
      if (localClass1 != null)
        break label608;
      break label598;
      label1443: localType2 = null;
      break label575;
      label1449: if (localClass2 != null)
      {
        bool7 = true;
        break label750;
        bool6 = false;
        break label667;
        label1466: m++;
        break label706;
      }
      bool7 = false;
      break label750;
      label1478: bool4 = true;
      break label865;
      label1484: return localBoolean;
      label1487: bool4 = false;
      break label865;
      label1493: bool3 = true;
      break label923;
      label1499: bool3 = false;
      break label923;
      label1505: bool2 = true;
      break label1269;
      label1511: bool2 = false;
      break label1269;
      label1517: boolean bool1 = true;
      continue;
      label1523: bool1 = false;
    }
  }

  private <T> void a(Field paramField, Collection<T> paramCollection, Type paramType, ArrayList<Type> paramArrayList, a parama)
    throws IOException
  {
    for (i locali = q(); locali != i.b; locali = c())
      paramCollection.add(a(paramField, paramType, paramArrayList, paramCollection, parama, true));
  }

  private void a(Field paramField, Map<String, Object> paramMap, Type paramType, ArrayList<Type> paramArrayList, a parama)
    throws IOException
  {
    for (i locali = q(); ; locali = c())
    {
      String str;
      if (locali == i.e)
      {
        str = g();
        c();
        if ((parama == null) || (!parama.a(paramMap, str)));
      }
      else
      {
        return;
      }
      paramMap.put(str, a(paramField, paramType, paramArrayList, paramMap, parama, true));
    }
  }

  private void a(ArrayList<Type> paramArrayList, Object paramObject, a parama)
    throws IOException
  {
    if ((paramObject instanceof b))
      ((b)paramObject).a(a());
    i locali = q();
    Class localClass = paramObject.getClass();
    com.google.a.a.f.h localh = com.google.a.a.f.h.a(localClass);
    boolean bool = n.class.isAssignableFrom(localClass);
    label78: m localm;
    if ((!bool) && (Map.class.isAssignableFrom(localClass)))
    {
      a(null, (Map)paramObject, ag.d(localClass), paramArrayList, parama);
      return;
      Field localField = localm.a();
      int i = paramArrayList.size();
      paramArrayList.add(localField.getGenericType());
      Object localObject = a(localField, localm.d(), paramArrayList, paramObject, parama, true);
      paramArrayList.remove(i);
      localm.a(paramObject, localObject);
    }
    while (true)
    {
      locali = c();
      if (locali != i.e)
        break;
      String str = g();
      c();
      if ((parama != null) && (parama.a(paramObject, str)))
        break;
      localm = localh.a(str);
      if (localm != null)
      {
        if ((!localm.e()) || (localm.f()))
          break label78;
        throw new IllegalArgumentException("final array/object fields are not supported");
      }
      if (bool)
      {
        ((n)paramObject).c(str, a(null, null, paramArrayList, paramObject, parama, true));
      }
      else
      {
        if (parama != null)
          parama.b(paramObject, str);
        f();
      }
    }
  }

  private static Field b(Class<?> paramClass)
  {
    if (paramClass == null)
      return null;
    b.lock();
    while (true)
    {
      Field localField1;
      try
      {
        if (a.containsKey(paramClass))
        {
          Field localField2 = (Field)a.get(paramClass);
          return localField2;
        }
        Iterator localIterator = com.google.a.a.f.h.a(paramClass).c().iterator();
        localObject2 = null;
        if (localIterator.hasNext())
        {
          localField1 = ((m)localIterator.next()).a();
          g localg = (g)localField1.getAnnotation(g.class);
          if (localg == null)
            break label314;
          if (localObject2 != null)
            break label302;
          bool1 = true;
          z.a(bool1, "Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", new Object[] { paramClass });
          boolean bool2 = com.google.a.a.f.i.a(localField1.getType());
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = paramClass;
          arrayOfObject1[1] = localField1.getType();
          z.a(bool2, "Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", arrayOfObject1);
          g.a[] arrayOfa = localg.a();
          HashSet localHashSet = aa.a();
          if (arrayOfa.length <= 0)
            break label308;
          bool3 = true;
          z.a(bool3, "@JsonPolymorphicTypeMap must have at least one @TypeDef");
          int i = arrayOfa.length;
          int j = 0;
          if (j < i)
          {
            g.a locala = arrayOfa[j];
            boolean bool4 = localHashSet.add(locala.a());
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = locala.a();
            z.a(bool4, "Class contains two @TypeDef annotations with identical key: %s", arrayOfObject2);
            j++;
            continue;
          }
        }
        else
        {
          a.put(paramClass, localObject2);
          return localObject2;
        }
      }
      finally
      {
        b.unlock();
      }
      Object localObject3 = localField1;
      break label317;
      label302: boolean bool1 = false;
      continue;
      label308: boolean bool3 = false;
      continue;
      label314: localObject3 = localObject2;
      label317: Object localObject2 = localObject3;
    }
  }

  private i p()
    throws IOException
  {
    i locali1 = d();
    if (locali1 == null);
    for (i locali2 = c(); ; locali2 = locali1)
    {
      if (locali2 != null);
      for (boolean bool = true; ; bool = false)
      {
        z.a(bool, "no JSON input found");
        return locali2;
      }
    }
  }

  private i q()
    throws IOException
  {
    i locali1 = p();
    switch (1.a[locali1.ordinal()])
    {
    default:
      return locali1;
    case 1:
      i locali2 = c();
      if ((locali2 == i.e) || (locali2 == i.d));
      for (boolean bool = true; ; bool = false)
      {
        z.a(bool, locali2);
        return locali2;
      }
    case 2:
    }
    return c();
  }

  public abstract c a();

  public final <T> T a(Class<T> paramClass)
    throws IOException
  {
    return a(paramClass, null);
  }

  public final <T> T a(Class<T> paramClass, a parama)
    throws IOException
  {
    try
    {
      Object localObject2 = b(paramClass, parama);
      return localObject2;
    }
    finally
    {
      b();
    }
  }

  public Object a(Type paramType, boolean paramBoolean)
    throws IOException
  {
    return a(paramType, paramBoolean, null);
  }

  public Object a(Type paramType, boolean paramBoolean, a parama)
    throws IOException
  {
    try
    {
      if (!Void.class.equals(paramType))
        p();
      Object localObject2 = a(null, paramType, new ArrayList(), null, parama, true);
      return localObject2;
    }
    finally
    {
      if (paramBoolean)
        b();
    }
  }

  public final String a(Set<String> paramSet)
    throws IOException
  {
    for (i locali = q(); locali == i.e; locali = c())
    {
      String str = g();
      c();
      if (paramSet.contains(str))
        return str;
      f();
    }
    return null;
  }

  public final void a(String paramString)
    throws IOException
  {
    a(Collections.singleton(paramString));
  }

  public final <T> T b(Class<T> paramClass, a parama)
    throws IOException
  {
    return a(paramClass, false, parama);
  }

  public abstract void b()
    throws IOException;

  public abstract i c()
    throws IOException;

  public abstract i d();

  public abstract String e()
    throws IOException;

  public abstract f f()
    throws IOException;

  public abstract String g()
    throws IOException;

  public abstract byte h()
    throws IOException;

  public abstract short i()
    throws IOException;

  public abstract int j()
    throws IOException;

  public abstract float k()
    throws IOException;

  public abstract long l()
    throws IOException;

  public abstract double m()
    throws IOException;

  public abstract BigInteger n()
    throws IOException;

  public abstract BigDecimal o()
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.d.f
 * JD-Core Version:    0.6.2
 */
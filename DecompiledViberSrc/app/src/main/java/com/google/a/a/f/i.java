package com.google.a.a.f;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class i
{
  public static final Boolean a = new Boolean(true);
  public static final String b = new String();
  public static final Character c = new Character('\000');
  public static final Byte d = new Byte((byte)0);
  public static final Short e = new Short((short)0);
  public static final Integer f = new Integer(0);
  public static final Float g = new Float(0.0F);
  public static final Long h = new Long(0L);
  public static final Double i = new Double(0.0D);
  public static final BigInteger j = new BigInteger("0");
  public static final BigDecimal k = new BigDecimal("0");
  public static final k l = new k(0L);
  private static final ConcurrentHashMap<Class<?>, Object> m = new ConcurrentHashMap();

  static
  {
    m.put(Boolean.class, a);
    m.put(String.class, b);
    m.put(Character.class, c);
    m.put(Byte.class, d);
    m.put(Short.class, e);
    m.put(Integer.class, f);
    m.put(Float.class, g);
    m.put(Long.class, h);
    m.put(Double.class, i);
    m.put(BigInteger.class, j);
    m.put(BigDecimal.class, k);
    m.put(k.class, l);
  }

  public static <T> T a(Class<?> paramClass)
  {
    int n = 0;
    Object localObject1 = m.get(paramClass);
    if (localObject1 == null)
      synchronized (m)
      {
        Object localObject3 = m.get(paramClass);
        Object localObject4;
        if (localObject3 == null)
        {
          if (!paramClass.isArray())
            break label87;
          localObject4 = paramClass;
          do
          {
            localObject4 = ((Class)localObject4).getComponentType();
            n++;
          }
          while (((Class)localObject4).isArray());
        }
        label87: m localm;
        for (localObject3 = Array.newInstance((Class)localObject4, new int[n]); ; localObject3 = localm.g())
        {
          m.put(paramClass, localObject3);
          return localObject3;
          if (!paramClass.isEnum())
            break;
          localm = h.a(paramClass).a(null);
          z.a(localm, "enum missing constant with @NullValue annotation: %s", new Object[] { paramClass });
        }
        localObject3 = ag.a(paramClass);
      }
    return localObject1;
  }

  public static Object a(Type paramType, String paramString)
  {
    Class localClass;
    if ((paramType instanceof Class))
    {
      localClass = (Class)paramType;
      if ((paramType != null) && (localClass == null))
        break label310;
      if (localClass != Void.class)
        break label35;
      paramString = null;
    }
    label35: 
    while ((paramString == null) || (localClass == null) || (localClass.isAssignableFrom(String.class)))
    {
      return paramString;
      localClass = null;
      break;
    }
    if ((localClass == Character.class) || (localClass == Character.TYPE))
    {
      if (paramString.length() != 1)
      {
        String str1 = String.valueOf(String.valueOf(localClass));
        throw new IllegalArgumentException(37 + str1.length() + "expected type Character/char but got " + str1);
      }
      return Character.valueOf(paramString.charAt(0));
    }
    if ((localClass == Boolean.class) || (localClass == Boolean.TYPE))
      return Boolean.valueOf(paramString);
    if ((localClass == Byte.class) || (localClass == Byte.TYPE))
      return Byte.valueOf(paramString);
    if ((localClass == Short.class) || (localClass == Short.TYPE))
      return Short.valueOf(paramString);
    if ((localClass == Integer.class) || (localClass == Integer.TYPE))
      return Integer.valueOf(paramString);
    if ((localClass == Long.class) || (localClass == Long.TYPE))
      return Long.valueOf(paramString);
    if ((localClass == Float.class) || (localClass == Float.TYPE))
      return Float.valueOf(paramString);
    if ((localClass == Double.class) || (localClass == Double.TYPE))
      return Double.valueOf(paramString);
    if (localClass == k.class)
      return k.a(paramString);
    if (localClass == BigInteger.class)
      return new BigInteger(paramString);
    if (localClass == BigDecimal.class)
      return new BigDecimal(paramString);
    if (localClass.isEnum())
      return h.a(localClass).a(paramString).g();
    label310: String str2 = String.valueOf(String.valueOf(paramType));
    throw new IllegalArgumentException(35 + str2.length() + "expected primitive class, but got: " + str2);
  }

  public static Type a(List<Type> paramList, Type paramType)
  {
    Object localObject1;
    if ((paramType instanceof WildcardType))
      localObject1 = ag.a((WildcardType)paramType);
    while (true)
    {
      Object localObject2;
      if ((localObject1 instanceof TypeVariable))
      {
        localObject2 = ag.a(paramList, (TypeVariable)localObject1);
        if (localObject2 == null)
          break label64;
      }
      while (true)
      {
        if ((localObject2 instanceof TypeVariable))
        {
          localObject1 = ((TypeVariable)localObject2).getBounds()[0];
          break;
          return localObject1;
        }
        localObject1 = localObject2;
        break;
        label64: localObject2 = localObject1;
      }
      localObject1 = paramType;
    }
  }

  public static void a(Object paramObject1, Object paramObject2)
  {
    boolean bool1 = true;
    int n = 0;
    Class localClass = paramObject1.getClass();
    boolean bool2;
    if (localClass == paramObject2.getClass())
    {
      bool2 = bool1;
      z.a(bool2);
      if (!localClass.isArray())
        break label112;
      if (Array.getLength(paramObject1) != Array.getLength(paramObject2))
        break label107;
    }
    while (true)
    {
      z.a(bool1);
      Iterator localIterator4 = ag.a(paramObject1).iterator();
      while (localIterator4.hasNext())
      {
        Object localObject2 = localIterator4.next();
        int i2 = n + 1;
        Array.set(paramObject2, n, c(localObject2));
        n = i2;
      }
      bool2 = false;
      break;
      label107: bool1 = false;
    }
    label112: if (Collection.class.isAssignableFrom(localClass))
    {
      Collection localCollection1 = (Collection)paramObject1;
      if (ArrayList.class.isAssignableFrom(localClass))
        ((ArrayList)paramObject2).ensureCapacity(localCollection1.size());
      Collection localCollection2 = (Collection)paramObject2;
      Iterator localIterator3 = localCollection1.iterator();
      while (localIterator3.hasNext())
        localCollection2.add(c(localIterator3.next()));
    }
    boolean bool3 = n.class.isAssignableFrom(localClass);
    if ((bool3) || (!Map.class.isAssignableFrom(localClass)))
    {
      if (bool3);
      for (h localh = ((n)paramObject1).b; ; localh = h.a(localClass))
      {
        Iterator localIterator1 = localh.a.iterator();
        while (localIterator1.hasNext())
        {
          m localm = localh.a((String)localIterator1.next());
          if ((!localm.e()) && ((!bool3) || (!localm.f())))
          {
            Object localObject1 = localm.a(paramObject1);
            if (localObject1 != null)
              localm.a(paramObject2, c(localObject1));
          }
        }
      }
    }
    if (a.class.isAssignableFrom(localClass))
    {
      a locala1 = (a)paramObject2;
      a locala2 = (a)paramObject1;
      int i1 = locala2.size();
      while (n < i1)
      {
        locala1.a(n, c(locala2.b(n)));
        n++;
      }
    }
    Map localMap = (Map)paramObject2;
    Iterator localIterator2 = ((Map)paramObject1).entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator2.next();
      localMap.put(localEntry.getKey(), c(localEntry.getValue()));
    }
  }

  public static boolean a(Object paramObject)
  {
    return (paramObject != null) && (paramObject == m.get(paramObject.getClass()));
  }

  public static boolean a(Type paramType)
  {
    if ((paramType instanceof WildcardType));
    for (Type localType = ag.a((WildcardType)paramType); ; localType = paramType)
    {
      if (!(localType instanceof Class))
        return false;
      Class localClass = (Class)localType;
      if ((localClass.isPrimitive()) || (localClass == Character.class) || (localClass == String.class) || (localClass == Integer.class) || (localClass == Long.class) || (localClass == Short.class) || (localClass == Byte.class) || (localClass == Float.class) || (localClass == Double.class) || (localClass == BigInteger.class) || (localClass == BigDecimal.class) || (localClass == k.class) || (localClass == Boolean.class));
      for (boolean bool = true; ; bool = false)
        return bool;
    }
  }

  public static Collection<Object> b(Type paramType)
  {
    if ((paramType instanceof WildcardType));
    for (Type localType1 = ag.a((WildcardType)paramType); ; localType1 = paramType)
    {
      if ((localType1 instanceof ParameterizedType));
      for (Type localType2 = ((ParameterizedType)localType1).getRawType(); ; localType2 = localType1)
      {
        if ((localType2 instanceof Class));
        for (Class localClass = (Class)localType2; (localType2 == null) || ((localType2 instanceof GenericArrayType)) || ((localClass != null) && ((localClass.isArray()) || (localClass.isAssignableFrom(ArrayList.class)))); localClass = null)
          return new ArrayList();
        if (localClass == null)
        {
          String str = String.valueOf(String.valueOf(localType2));
          throw new IllegalArgumentException(39 + str.length() + "unable to create new instance of type: " + str);
        }
        if (localClass.isAssignableFrom(HashSet.class))
          return new HashSet();
        if (localClass.isAssignableFrom(TreeSet.class))
          return new TreeSet();
        return (Collection)ag.a(localClass);
      }
    }
  }

  public static Map<String, Object> b(Class<?> paramClass)
  {
    if ((paramClass == null) || (paramClass.isAssignableFrom(a.class)))
      return a.a();
    if (paramClass.isAssignableFrom(TreeMap.class))
      return new TreeMap();
    return (Map)ag.a(paramClass);
  }

  public static Map<String, Object> b(Object paramObject)
  {
    if ((paramObject == null) || (a(paramObject)))
      return Collections.emptyMap();
    if ((paramObject instanceof Map))
      return (Map)paramObject;
    return new j(paramObject, false);
  }

  public static <T> T c(T paramT)
  {
    if ((paramT == null) || (a(paramT.getClass())))
      return paramT;
    if ((paramT instanceof n))
      return ((n)paramT).c();
    Class localClass = paramT.getClass();
    Object localObject;
    if (localClass.isArray())
      localObject = Array.newInstance(localClass.getComponentType(), Array.getLength(paramT));
    while (true)
    {
      a(paramT, localObject);
      return localObject;
      if ((paramT instanceof a))
      {
        localObject = ((a)paramT).b();
      }
      else
      {
        if ("java.util.Arrays$ArrayList".equals(localClass.getName()))
        {
          Object[] arrayOfObject = ((List)paramT).toArray();
          a(arrayOfObject, arrayOfObject);
          return Arrays.asList(arrayOfObject);
        }
        localObject = ag.a(localClass);
      }
    }
  }

  public static boolean d(Object paramObject)
  {
    return (paramObject == null) || (a(paramObject.getClass()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.i
 * JD-Core Version:    0.6.2
 */
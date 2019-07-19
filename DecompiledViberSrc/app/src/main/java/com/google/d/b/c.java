package com.google.d.b;

import com.google.d.c.a;
import com.google.d.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class c
{
  private final Map<Type, com.google.d.h<?>> a;

  public c(Map<Type, com.google.d.h<?>> paramMap)
  {
    this.a = paramMap;
  }

  private <T> h<T> a(Class<? super T> paramClass)
  {
    try
    {
      final Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[0]);
      if (!localConstructor.isAccessible())
        localConstructor.setAccessible(true);
      h local8 = new h()
      {
        public T a()
        {
          try
          {
            Object localObject = localConstructor.newInstance(null);
            return localObject;
          }
          catch (InstantiationException localInstantiationException)
          {
            throw new RuntimeException("Failed to invoke " + localConstructor + " with no args", localInstantiationException);
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            throw new RuntimeException("Failed to invoke " + localConstructor + " with no args", localInvocationTargetException.getTargetException());
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            throw new AssertionError(localIllegalAccessException);
          }
        }
      };
      return local8;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    return null;
  }

  private <T> h<T> a(final Type paramType, Class<? super T> paramClass)
  {
    if (Collection.class.isAssignableFrom(paramClass))
    {
      if (SortedSet.class.isAssignableFrom(paramClass))
        return new h()
        {
          public T a()
          {
            return new TreeSet();
          }
        };
      if (EnumSet.class.isAssignableFrom(paramClass))
        return new h()
        {
          public T a()
          {
            if ((paramType instanceof ParameterizedType))
            {
              Type localType = ((ParameterizedType)paramType).getActualTypeArguments()[0];
              if ((localType instanceof Class))
                return EnumSet.noneOf((Class)localType);
              throw new m("Invalid EnumSet type: " + paramType.toString());
            }
            throw new m("Invalid EnumSet type: " + paramType.toString());
          }
        };
      if (Set.class.isAssignableFrom(paramClass))
        return new h()
        {
          public T a()
          {
            return new LinkedHashSet();
          }
        };
      if (Queue.class.isAssignableFrom(paramClass))
        return new h()
        {
          public T a()
          {
            return new ArrayDeque();
          }
        };
      return new h()
      {
        public T a()
        {
          return new ArrayList();
        }
      };
    }
    if (Map.class.isAssignableFrom(paramClass))
    {
      if (ConcurrentNavigableMap.class.isAssignableFrom(paramClass))
        return new h()
        {
          public T a()
          {
            return new ConcurrentSkipListMap();
          }
        };
      if (ConcurrentMap.class.isAssignableFrom(paramClass))
        return new h()
        {
          public T a()
          {
            return new ConcurrentHashMap();
          }
        };
      if (SortedMap.class.isAssignableFrom(paramClass))
        return new h()
        {
          public T a()
          {
            return new TreeMap();
          }
        };
      if (((paramType instanceof ParameterizedType)) && (!String.class.isAssignableFrom(a.get(((ParameterizedType)paramType).getActualTypeArguments()[0]).getRawType())))
        return new h()
        {
          public T a()
          {
            return new LinkedHashMap();
          }
        };
      return new h()
      {
        public T a()
        {
          return new g();
        }
      };
    }
    return null;
  }

  private <T> h<T> b(final Type paramType, final Class<? super T> paramClass)
  {
    return new h()
    {
      private final k d = k.a();

      public T a()
      {
        try
        {
          Object localObject = this.d.a(paramClass);
          return localObject;
        }
        catch (Exception localException)
        {
          throw new RuntimeException("Unable to invoke no-args constructor for " + paramType + ". Register an InstanceCreator with Gson for this type may fix this problem.", localException);
        }
      }
    };
  }

  public <T> h<T> a(a<T> parama)
  {
    final Type localType = parama.getType();
    Class localClass = parama.getRawType();
    final com.google.d.h localh1 = (com.google.d.h)this.a.get(localType);
    Object localObject;
    if (localh1 != null)
      localObject = new h()
      {
        public T a()
        {
          return localh1.a(localType);
        }
      };
    do
    {
      do
      {
        return localObject;
        final com.google.d.h localh2 = (com.google.d.h)this.a.get(localClass);
        if (localh2 != null)
          return new h()
          {
            public T a()
            {
              return localh2.a(localType);
            }
          };
        localObject = a(localClass);
      }
      while (localObject != null);
      localObject = a(localType, localClass);
    }
    while (localObject != null);
    return b(localType, localClass);
  }

  public String toString()
  {
    return this.a.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.c
 * JD-Core Version:    0.6.2
 */
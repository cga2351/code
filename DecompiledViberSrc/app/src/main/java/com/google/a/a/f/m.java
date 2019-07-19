package com.google.a.a.f;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

public class m
{
  private static final Map<Field, m> a = new WeakHashMap();
  private final boolean b;
  private final Field c;
  private final String d;

  m(Field paramField, String paramString)
  {
    this.c = paramField;
    if (paramString == null);
    for (String str = null; ; str = paramString.intern())
    {
      this.d = str;
      this.b = i.a(c());
      return;
    }
  }

  public static m a(Enum<?> paramEnum)
  {
    boolean bool = true;
    try
    {
      m localm = a(paramEnum.getClass().getField(paramEnum.name()));
      if (localm != null);
      while (true)
      {
        z.a(bool, "enum constant missing @Value or @NullValue annotation: %s", new Object[] { paramEnum });
        return localm;
        bool = false;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new RuntimeException(localNoSuchFieldException);
    }
  }

  public static m a(Field paramField)
  {
    if (paramField == null)
      return null;
    while (true)
    {
      m localm1;
      String str1;
      String str2;
      m localm2;
      synchronized (a)
      {
        localm1 = (m)a.get(paramField);
        boolean bool = paramField.isEnumConstant();
        if ((localm1 != null) || ((!bool) && (Modifier.isStatic(paramField.getModifiers()))))
          break label200;
        if (!bool)
          break label156;
        ah localah = (ah)paramField.getAnnotation(ah.class);
        if (localah != null)
        {
          str1 = localah.a();
          if (!"##default".equals(str1))
            break label193;
          str2 = paramField.getName();
          m localm3 = new m(paramField, str2);
          a.put(paramField, localm3);
          localm2 = localm3;
          return localm2;
        }
      }
      if ((w)paramField.getAnnotation(w.class) != null)
      {
        str1 = null;
      }
      else
      {
        return null;
        label156: q localq = (q)paramField.getAnnotation(q.class);
        if (localq == null)
          return null;
        str1 = localq.a();
        paramField.setAccessible(true);
        continue;
        label193: str2 = str1;
        continue;
        label200: localm2 = localm1;
      }
    }
  }

  public static Object a(Field paramField, Object paramObject)
  {
    try
    {
      Object localObject = paramField.get(paramObject);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new IllegalArgumentException(localIllegalAccessException);
    }
  }

  public static void a(Field paramField, Object paramObject1, Object paramObject2)
  {
    if (Modifier.isFinal(paramField.getModifiers()))
    {
      Object localObject = a(paramField, paramObject1);
      if (paramObject2 == null)
      {
        if (localObject == null);
      }
      else
        while (!paramObject2.equals(localObject))
        {
          String str1 = String.valueOf(String.valueOf(localObject));
          String str2 = String.valueOf(String.valueOf(paramObject2));
          String str3 = String.valueOf(String.valueOf(paramField.getName()));
          String str4 = String.valueOf(String.valueOf(paramObject1.getClass().getName()));
          throw new IllegalArgumentException(48 + str1.length() + str2.length() + str3.length() + str4.length() + "expected final value <" + str1 + "> but was <" + str2 + "> on " + str3 + " field in " + str4);
        }
      return;
    }
    try
    {
      paramField.set(paramObject1, paramObject2);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      throw new IllegalArgumentException(localSecurityException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new IllegalArgumentException(localIllegalAccessException);
    }
  }

  public Object a(Object paramObject)
  {
    return a(this.c, paramObject);
  }

  public Field a()
  {
    return this.c;
  }

  public void a(Object paramObject1, Object paramObject2)
  {
    a(this.c, paramObject1, paramObject2);
  }

  public String b()
  {
    return this.d;
  }

  public Class<?> c()
  {
    return this.c.getType();
  }

  public Type d()
  {
    return this.c.getGenericType();
  }

  public boolean e()
  {
    return Modifier.isFinal(this.c.getModifiers());
  }

  public boolean f()
  {
    return this.b;
  }

  public <T extends Enum<T>> T g()
  {
    return Enum.valueOf(this.c.getDeclaringClass(), this.c.getName());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.f.m
 * JD-Core Version:    0.6.2
 */
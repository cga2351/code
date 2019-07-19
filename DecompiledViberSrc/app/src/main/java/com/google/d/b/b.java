package com.google.d.b;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class b
{
  static final Type[] a = new Type[0];

  static int a(Object paramObject)
  {
    if (paramObject != null)
      return paramObject.hashCode();
    return 0;
  }

  private static int a(Object[] paramArrayOfObject, Object paramObject)
  {
    for (int i = 0; i < paramArrayOfObject.length; i++)
      if (paramObject.equals(paramArrayOfObject[i]))
        return i;
    throw new NoSuchElementException();
  }

  private static Class<?> a(TypeVariable<?> paramTypeVariable)
  {
    GenericDeclaration localGenericDeclaration = paramTypeVariable.getGenericDeclaration();
    if ((localGenericDeclaration instanceof Class))
      return (Class)localGenericDeclaration;
    return null;
  }

  public static GenericArrayType a(Type paramType)
  {
    return new a(paramType);
  }

  public static ParameterizedType a(Type paramType1, Type paramType2, Type[] paramArrayOfType)
  {
    return new b(paramType1, paramType2, paramArrayOfType);
  }

  public static Type a(Type paramType, Class<?> paramClass)
  {
    Type localType = b(paramType, paramClass, Collection.class);
    if ((localType instanceof WildcardType))
      localType = ((WildcardType)localType).getUpperBounds()[0];
    if ((localType instanceof ParameterizedType))
      return ((ParameterizedType)localType).getActualTypeArguments()[0];
    return Object.class;
  }

  static Type a(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2 == paramClass1)
      return paramType;
    if (paramClass2.isInterface())
    {
      Class[] arrayOfClass = paramClass1.getInterfaces();
      int i = 0;
      int j = arrayOfClass.length;
      while (i < j)
      {
        if (arrayOfClass[i] == paramClass2)
          return paramClass1.getGenericInterfaces()[i];
        if (paramClass2.isAssignableFrom(arrayOfClass[i]))
          return a(paramClass1.getGenericInterfaces()[i], arrayOfClass[i], paramClass2);
        i++;
      }
    }
    if (!paramClass1.isInterface())
      while (paramClass1 != Object.class)
      {
        Class localClass = paramClass1.getSuperclass();
        if (localClass == paramClass2)
          return paramClass1.getGenericSuperclass();
        if (paramClass2.isAssignableFrom(localClass))
          return a(paramClass1.getGenericSuperclass(), localClass, paramClass2);
        paramClass1 = localClass;
      }
    return paramClass2;
  }

  public static Type a(Type paramType1, Class<?> paramClass, Type paramType2)
  {
    Object localObject = paramType2;
    Type localType9;
    if ((localObject instanceof TypeVariable))
    {
      TypeVariable localTypeVariable = (TypeVariable)localObject;
      localType9 = a(paramType1, paramClass, localTypeVariable);
      if (localType9 == localTypeVariable)
        localObject = localType9;
    }
    label92: Type[] arrayOfType2;
    label134: label282: label343: Type localType1;
    do
    {
      do
      {
        Type[] arrayOfType1;
        Type localType2;
        do
        {
          do
          {
            Type localType4;
            int k;
            Type[] arrayOfType4;
            do
            {
              Type localType6;
              Type localType7;
              do
              {
                Class localClass;
                Type localType8;
                do
                {
                  return localObject;
                  localObject = localType9;
                  break;
                  if ((!(localObject instanceof Class)) || (!((Class)localObject).isArray()))
                    break label92;
                  localObject = (Class)localObject;
                  localClass = ((Class)localObject).getComponentType();
                  localType8 = a(paramType1, paramClass, localClass);
                }
                while (localClass == localType8);
                return a(localType8);
                if (!(localObject instanceof GenericArrayType))
                  break label134;
                localObject = (GenericArrayType)localObject;
                localType6 = ((GenericArrayType)localObject).getGenericComponentType();
                localType7 = a(paramType1, paramClass, localType6);
              }
              while (localType6 == localType7);
              return a(localType7);
              if (!(localObject instanceof ParameterizedType))
                break label282;
              localObject = (ParameterizedType)localObject;
              Type localType3 = ((ParameterizedType)localObject).getOwnerType();
              localType4 = a(paramType1, paramClass, localType3);
              if (localType4 != localType3);
              for (int i = 1; ; i = 0)
              {
                Type[] arrayOfType3 = ((ParameterizedType)localObject).getActualTypeArguments();
                int j = arrayOfType3.length;
                k = i;
                arrayOfType4 = arrayOfType3;
                for (int m = 0; m < j; m++)
                {
                  Type localType5 = a(paramType1, paramClass, arrayOfType4[m]);
                  if (localType5 != arrayOfType4[m])
                  {
                    if (k == 0)
                    {
                      arrayOfType4 = (Type[])arrayOfType4.clone();
                      k = 1;
                    }
                    arrayOfType4[m] = localType5;
                  }
                }
              }
            }
            while (k == 0);
            return a(localType4, ((ParameterizedType)localObject).getRawType(), arrayOfType4);
          }
          while (!(localObject instanceof WildcardType));
          localObject = (WildcardType)localObject;
          arrayOfType1 = ((WildcardType)localObject).getLowerBounds();
          arrayOfType2 = ((WildcardType)localObject).getUpperBounds();
          if (arrayOfType1.length != 1)
            break label343;
          localType2 = a(paramType1, paramClass, arrayOfType1[0]);
        }
        while (localType2 == arrayOfType1[0]);
        return c(localType2);
      }
      while (arrayOfType2.length != 1);
      localType1 = a(paramType1, paramClass, arrayOfType2[0]);
    }
    while (localType1 == arrayOfType2[0]);
    return b(localType1);
  }

  static Type a(Type paramType, Class<?> paramClass, TypeVariable<?> paramTypeVariable)
  {
    Class localClass = a(paramTypeVariable);
    if (localClass == null);
    Type localType;
    do
    {
      return paramTypeVariable;
      localType = a(paramType, paramClass, localClass);
    }
    while (!(localType instanceof ParameterizedType));
    int i = a(localClass.getTypeParameters(), paramTypeVariable);
    return ((ParameterizedType)localType).getActualTypeArguments()[i];
  }

  static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public static boolean a(Type paramType1, Type paramType2)
  {
    boolean bool1 = true;
    boolean bool3;
    if (paramType1 == paramType2)
      bool3 = bool1;
    boolean bool4;
    do
    {
      boolean bool2;
      do
      {
        boolean bool5;
        do
        {
          boolean bool6;
          do
          {
            boolean bool7;
            do
            {
              return bool3;
              if ((paramType1 instanceof Class))
                return paramType1.equals(paramType2);
              if (!(paramType1 instanceof ParameterizedType))
                break;
              bool7 = paramType2 instanceof ParameterizedType;
              bool3 = false;
            }
            while (!bool7);
            ParameterizedType localParameterizedType1 = (ParameterizedType)paramType1;
            ParameterizedType localParameterizedType2 = (ParameterizedType)paramType2;
            if ((a(localParameterizedType1.getOwnerType(), localParameterizedType2.getOwnerType())) && (localParameterizedType1.getRawType().equals(localParameterizedType2.getRawType())) && (Arrays.equals(localParameterizedType1.getActualTypeArguments(), localParameterizedType2.getActualTypeArguments())));
            while (true)
            {
              return bool1;
              bool1 = false;
            }
            if (!(paramType1 instanceof GenericArrayType))
              break;
            bool6 = paramType2 instanceof GenericArrayType;
            bool3 = false;
          }
          while (!bool6);
          GenericArrayType localGenericArrayType1 = (GenericArrayType)paramType1;
          GenericArrayType localGenericArrayType2 = (GenericArrayType)paramType2;
          return a(localGenericArrayType1.getGenericComponentType(), localGenericArrayType2.getGenericComponentType());
          if (!(paramType1 instanceof WildcardType))
            break;
          bool5 = paramType2 instanceof WildcardType;
          bool3 = false;
        }
        while (!bool5);
        WildcardType localWildcardType1 = (WildcardType)paramType1;
        WildcardType localWildcardType2 = (WildcardType)paramType2;
        if ((Arrays.equals(localWildcardType1.getUpperBounds(), localWildcardType2.getUpperBounds())) && (Arrays.equals(localWildcardType1.getLowerBounds(), localWildcardType2.getLowerBounds())));
        while (true)
        {
          return bool1;
          bool1 = false;
        }
        bool2 = paramType1 instanceof TypeVariable;
        bool3 = false;
      }
      while (!bool2);
      bool4 = paramType2 instanceof TypeVariable;
      bool3 = false;
    }
    while (!bool4);
    TypeVariable localTypeVariable1 = (TypeVariable)paramType1;
    TypeVariable localTypeVariable2 = (TypeVariable)paramType2;
    if ((localTypeVariable1.getGenericDeclaration() == localTypeVariable2.getGenericDeclaration()) && (localTypeVariable1.getName().equals(localTypeVariable2.getName())));
    while (true)
    {
      return bool1;
      bool1 = false;
    }
  }

  static Type b(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    a.a(paramClass2.isAssignableFrom(paramClass1));
    return a(paramType, paramClass1, a(paramType, paramClass1, paramClass2));
  }

  public static WildcardType b(Type paramType)
  {
    return new c(new Type[] { paramType }, a);
  }

  public static Type[] b(Type paramType, Class<?> paramClass)
  {
    if (paramType == Properties.class)
      return new Type[] { String.class, String.class };
    Type localType = b(paramType, paramClass, Map.class);
    if ((localType instanceof ParameterizedType))
      return ((ParameterizedType)localType).getActualTypeArguments();
    return new Type[] { Object.class, Object.class };
  }

  public static WildcardType c(Type paramType)
  {
    return new c(new Type[] { Object.class }, new Type[] { paramType });
  }

  public static Type d(Type paramType)
  {
    if ((paramType instanceof Class))
    {
      Class localClass = (Class)paramType;
      if (localClass.isArray());
      for (Object localObject = new a(d(localClass.getComponentType())); ; localObject = localClass)
        return (Type)localObject;
    }
    if ((paramType instanceof ParameterizedType))
    {
      ParameterizedType localParameterizedType = (ParameterizedType)paramType;
      return new b(localParameterizedType.getOwnerType(), localParameterizedType.getRawType(), localParameterizedType.getActualTypeArguments());
    }
    if ((paramType instanceof GenericArrayType))
      return new a(((GenericArrayType)paramType).getGenericComponentType());
    if ((paramType instanceof WildcardType))
    {
      WildcardType localWildcardType = (WildcardType)paramType;
      return new c(localWildcardType.getUpperBounds(), localWildcardType.getLowerBounds());
    }
    return paramType;
  }

  public static Class<?> e(Type paramType)
  {
    if ((paramType instanceof Class))
      return (Class)paramType;
    if ((paramType instanceof ParameterizedType))
    {
      Type localType = ((ParameterizedType)paramType).getRawType();
      a.a(localType instanceof Class);
      return (Class)localType;
    }
    if ((paramType instanceof GenericArrayType))
      return Array.newInstance(e(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
    if ((paramType instanceof TypeVariable))
      return Object.class;
    if ((paramType instanceof WildcardType))
      return e(((WildcardType)paramType).getUpperBounds()[0]);
    if (paramType == null);
    for (String str = "null"; ; str = paramType.getClass().getName())
      throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + paramType + "> is of type " + str);
  }

  public static String f(Type paramType)
  {
    if ((paramType instanceof Class))
      return ((Class)paramType).getName();
    return paramType.toString();
  }

  public static Type g(Type paramType)
  {
    if ((paramType instanceof GenericArrayType))
      return ((GenericArrayType)paramType).getGenericComponentType();
    return ((Class)paramType).getComponentType();
  }

  static void h(Type paramType)
  {
    if ((!(paramType instanceof Class)) || (!((Class)paramType).isPrimitive()));
    for (boolean bool = true; ; bool = false)
    {
      a.a(bool);
      return;
    }
  }

  private static final class a
    implements Serializable, GenericArrayType
  {
    private final Type a;

    public a(Type paramType)
    {
      this.a = b.d(paramType);
    }

    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof GenericArrayType)) && (b.a(this, (GenericArrayType)paramObject));
    }

    public Type getGenericComponentType()
    {
      return this.a;
    }

    public int hashCode()
    {
      return this.a.hashCode();
    }

    public String toString()
    {
      return b.f(this.a) + "[]";
    }
  }

  private static final class b
    implements Serializable, ParameterizedType
  {
    private final Type a;
    private final Type b;
    private final Type[] c;

    public b(Type paramType1, Type paramType2, Type[] paramArrayOfType)
    {
      int j;
      boolean bool;
      if ((paramType2 instanceof Class))
      {
        Class localClass = (Class)paramType2;
        if ((Modifier.isStatic(localClass.getModifiers())) || (localClass.getEnclosingClass() == null))
        {
          j = 1;
          if ((paramType1 == null) && (j == 0))
            break label151;
          bool = true;
          label54: a.a(bool);
        }
      }
      else
      {
        if (paramType1 != null)
          break label157;
      }
      label151: label157: for (Type localType = null; ; localType = b.d(paramType1))
      {
        this.a = localType;
        this.b = b.d(paramType2);
        this.c = ((Type[])paramArrayOfType.clone());
        while (i < this.c.length)
        {
          a.a(this.c[i]);
          b.h(this.c[i]);
          this.c[i] = b.d(this.c[i]);
          i++;
        }
        j = 0;
        break;
        bool = false;
        break label54;
      }
    }

    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof ParameterizedType)) && (b.a(this, (ParameterizedType)paramObject));
    }

    public Type[] getActualTypeArguments()
    {
      return (Type[])this.c.clone();
    }

    public Type getOwnerType()
    {
      return this.a;
    }

    public Type getRawType()
    {
      return this.b;
    }

    public int hashCode()
    {
      return Arrays.hashCode(this.c) ^ this.b.hashCode() ^ b.a(this.a);
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(30 * (1 + this.c.length));
      localStringBuilder.append(b.f(this.b));
      if (this.c.length == 0)
        return localStringBuilder.toString();
      localStringBuilder.append("<").append(b.f(this.c[0]));
      for (int i = 1; i < this.c.length; i++)
        localStringBuilder.append(", ").append(b.f(this.c[i]));
      return ">";
    }
  }

  private static final class c
    implements Serializable, WildcardType
  {
    private final Type a;
    private final Type b;

    public c(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
    {
      if (paramArrayOfType2.length <= i)
      {
        int k = i;
        a.a(k);
        if (paramArrayOfType1.length != i)
          break label88;
        int n = i;
        label29: a.a(n);
        if (paramArrayOfType2.length != i)
          break label99;
        a.a(paramArrayOfType2[0]);
        b.h(paramArrayOfType2[0]);
        if (paramArrayOfType1[0] != Object.class)
          break label94;
      }
      while (true)
      {
        a.a(i);
        this.b = b.d(paramArrayOfType2[0]);
        this.a = Object.class;
        return;
        int m = 0;
        break;
        label88: int i1 = 0;
        break label29;
        label94: int j = 0;
      }
      label99: a.a(paramArrayOfType1[0]);
      b.h(paramArrayOfType1[0]);
      this.b = null;
      this.a = b.d(paramArrayOfType1[0]);
    }

    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof WildcardType)) && (b.a(this, (WildcardType)paramObject));
    }

    public Type[] getLowerBounds()
    {
      if (this.b != null)
      {
        Type[] arrayOfType = new Type[1];
        arrayOfType[0] = this.b;
        return arrayOfType;
      }
      return b.a;
    }

    public Type[] getUpperBounds()
    {
      Type[] arrayOfType = new Type[1];
      arrayOfType[0] = this.a;
      return arrayOfType;
    }

    public int hashCode()
    {
      if (this.b != null);
      for (int i = 31 + this.b.hashCode(); ; i = 1)
        return i ^ 31 + this.a.hashCode();
    }

    public String toString()
    {
      if (this.b != null)
        return "? super " + b.f(this.b);
      if (this.a == Object.class)
        return "?";
      return "? extends " + b.f(this.a);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.b
 * JD-Core Version:    0.6.2
 */
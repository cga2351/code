package g;

import f.c;
import f.e;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;

final class o
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

  static Class<?> a(Type paramType)
  {
    a(paramType, "type == null");
    if ((paramType instanceof Class))
      return (Class)paramType;
    if ((paramType instanceof ParameterizedType))
    {
      Type localType = ((ParameterizedType)paramType).getRawType();
      if (!(localType instanceof Class))
        throw new IllegalArgumentException();
      return (Class)localType;
    }
    if ((paramType instanceof GenericArrayType))
      return Array.newInstance(a(((GenericArrayType)paramType).getGenericComponentType()), 0).getClass();
    if ((paramType instanceof TypeVariable))
      return Object.class;
    if ((paramType instanceof WildcardType))
      return a(((WildcardType)paramType).getUpperBounds()[0]);
    throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + paramType + "> is of type " + paramType.getClass().getName());
  }

  private static Class<?> a(TypeVariable<?> paramTypeVariable)
  {
    GenericDeclaration localGenericDeclaration = paramTypeVariable.getGenericDeclaration();
    if ((localGenericDeclaration instanceof Class))
      return (Class)localGenericDeclaration;
    return null;
  }

  static <T> T a(@Nullable T paramT, String paramString)
  {
    if (paramT == null)
      throw new NullPointerException(paramString);
    return paramT;
  }

  static Type a(int paramInt, ParameterizedType paramParameterizedType)
  {
    Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
    if ((paramInt < 0) || (paramInt >= arrayOfType.length))
      throw new IllegalArgumentException("Index " + paramInt + " not in range [0," + arrayOfType.length + ") for " + paramParameterizedType);
    Type localType = arrayOfType[paramInt];
    if ((localType instanceof WildcardType))
      localType = ((WildcardType)localType).getUpperBounds()[0];
    return localType;
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

  static Type a(Type paramType1, Class<?> paramClass, Type paramType2)
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
    label96: Type[] arrayOfType2;
    label142: label294: label375: Type localType1;
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
                    break label96;
                  localObject = (Class)localObject;
                  localClass = ((Class)localObject).getComponentType();
                  localType8 = a(paramType1, paramClass, localClass);
                }
                while (localClass == localType8);
                return new a(localType8);
                if (!(localObject instanceof GenericArrayType))
                  break label142;
                localObject = (GenericArrayType)localObject;
                localType6 = ((GenericArrayType)localObject).getGenericComponentType();
                localType7 = a(paramType1, paramClass, localType6);
              }
              while (localType6 == localType7);
              return new a(localType7);
              if (!(localObject instanceof ParameterizedType))
                break label294;
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
            return new b(localType4, ((ParameterizedType)localObject).getRawType(), arrayOfType4);
          }
          while (!(localObject instanceof WildcardType));
          localObject = (WildcardType)localObject;
          arrayOfType1 = ((WildcardType)localObject).getLowerBounds();
          arrayOfType2 = ((WildcardType)localObject).getUpperBounds();
          if (arrayOfType1.length != 1)
            break label375;
          localType2 = a(paramType1, paramClass, arrayOfType1[0]);
        }
        while (localType2 == arrayOfType1[0]);
        return new c(new Type[] { Object.class }, new Type[] { localType2 });
      }
      while (arrayOfType2.length != 1);
      localType1 = a(paramType1, paramClass, arrayOfType2[0]);
    }
    while (localType1 == arrayOfType2[0]);
    return new c(new Type[] { localType1 }, a);
  }

  private static Type a(Type paramType, Class<?> paramClass, TypeVariable<?> paramTypeVariable)
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

  static ResponseBody a(ResponseBody paramResponseBody)
    throws IOException
  {
    c localc = new c();
    paramResponseBody.source().a(localc);
    return ResponseBody.create(paramResponseBody.contentType(), paramResponseBody.contentLength(), localc);
  }

  static <T> void a(Class<T> paramClass)
  {
    if (!paramClass.isInterface())
      throw new IllegalArgumentException("API declarations must be interfaces.");
    if (paramClass.getInterfaces().length > 0)
      throw new IllegalArgumentException("API interfaces must not extend other interfaces.");
  }

  private static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  static boolean a(Type paramType1, Type paramType2)
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

  static boolean a(Annotation[] paramArrayOfAnnotation, Class<? extends Annotation> paramClass)
  {
    int i = paramArrayOfAnnotation.length;
    for (int j = 0; ; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        if (paramClass.isInstance(paramArrayOfAnnotation[j]))
          bool = true;
      }
      else
        return bool;
    }
  }

  static String b(Type paramType)
  {
    if ((paramType instanceof Class))
      return ((Class)paramType).getName();
    return paramType.toString();
  }

  static Type b(Type paramType, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (!paramClass2.isAssignableFrom(paramClass1))
      throw new IllegalArgumentException();
    return a(paramType, paramClass1, a(paramType, paramClass1, paramClass2));
  }

  static void c(Type paramType)
  {
    if (((paramType instanceof Class)) && (((Class)paramType).isPrimitive()))
      throw new IllegalArgumentException();
  }

  static boolean d(Type paramType)
  {
    if ((paramType instanceof Class));
    while (true)
    {
      return false;
      if (!(paramType instanceof ParameterizedType))
        break;
      Type[] arrayOfType = ((ParameterizedType)paramType).getActualTypeArguments();
      int i = arrayOfType.length;
      for (int j = 0; j < i; j++)
        if (d(arrayOfType[j]))
          return true;
    }
    if ((paramType instanceof GenericArrayType))
      return d(((GenericArrayType)paramType).getGenericComponentType());
    if ((paramType instanceof TypeVariable))
      return true;
    if ((paramType instanceof WildcardType))
      return true;
    if (paramType == null);
    for (String str = "null"; ; str = paramType.getClass().getName())
      throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + paramType + "> is of type " + str);
  }

  static Type e(Type paramType)
  {
    if (!(paramType instanceof ParameterizedType))
      throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    return a(0, (ParameterizedType)paramType);
  }

  private static final class a
    implements GenericArrayType
  {
    private final Type a;

    a(Type paramType)
    {
      this.a = paramType;
    }

    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof GenericArrayType)) && (o.a(this, (GenericArrayType)paramObject));
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
      return o.b(this.a) + "[]";
    }
  }

  private static final class b
    implements ParameterizedType
  {
    private final Type a;
    private final Type b;
    private final Type[] c;

    b(Type paramType1, Type paramType2, Type[] paramArrayOfType)
    {
      if ((paramType2 instanceof Class))
      {
        int m;
        if (paramType1 == null)
        {
          m = i;
          if (((Class)paramType2).getEnclosingClass() != null)
            break label56;
        }
        while (true)
        {
          if (m == i)
            break label62;
          throw new IllegalArgumentException();
          m = 0;
          break;
          label56: i = 0;
        }
      }
      label62: int k = paramArrayOfType.length;
      while (j < k)
      {
        Type localType = paramArrayOfType[j];
        o.a(localType, "typeArgument == null");
        o.c(localType);
        j++;
      }
      this.a = paramType1;
      this.b = paramType2;
      this.c = ((Type[])paramArrayOfType.clone());
    }

    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof ParameterizedType)) && (o.a(this, (ParameterizedType)paramObject));
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
      return Arrays.hashCode(this.c) ^ this.b.hashCode() ^ o.a(this.a);
    }

    public String toString()
    {
      if (this.c.length == 0)
        return o.b(this.b);
      StringBuilder localStringBuilder = new StringBuilder(30 * (1 + this.c.length));
      localStringBuilder.append(o.b(this.b));
      localStringBuilder.append("<").append(o.b(this.c[0]));
      for (int i = 1; i < this.c.length; i++)
        localStringBuilder.append(", ").append(o.b(this.c[i]));
      return ">";
    }
  }

  private static final class c
    implements WildcardType
  {
    private final Type a;
    private final Type b;

    c(Type[] paramArrayOfType1, Type[] paramArrayOfType2)
    {
      if (paramArrayOfType2.length > 1)
        throw new IllegalArgumentException();
      if (paramArrayOfType1.length != 1)
        throw new IllegalArgumentException();
      if (paramArrayOfType2.length == 1)
      {
        if (paramArrayOfType2[0] == null)
          throw new NullPointerException();
        o.c(paramArrayOfType2[0]);
        if (paramArrayOfType1[0] != Object.class)
          throw new IllegalArgumentException();
        this.b = paramArrayOfType2[0];
        this.a = Object.class;
        return;
      }
      if (paramArrayOfType1[0] == null)
        throw new NullPointerException();
      o.c(paramArrayOfType1[0]);
      this.b = null;
      this.a = paramArrayOfType1[0];
    }

    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof WildcardType)) && (o.a(this, (WildcardType)paramObject));
    }

    public Type[] getLowerBounds()
    {
      if (this.b != null)
      {
        Type[] arrayOfType = new Type[1];
        arrayOfType[0] = this.b;
        return arrayOfType;
      }
      return o.a;
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
        return "? super " + o.b(this.b);
      if (this.a == Object.class)
        return "?";
      return "? extends " + o.b(this.a);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     g.o
 * JD-Core Version:    0.6.2
 */
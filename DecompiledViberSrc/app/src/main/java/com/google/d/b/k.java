package com.google.d.b;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class k
{
  public static k a()
  {
    try
    {
      Class localClass = Class.forName("sun.misc.Unsafe");
      Field localField = localClass.getDeclaredField("theUnsafe");
      localField.setAccessible(true);
      final Object localObject = localField.get(null);
      k local1 = new k()
      {
        public <T> T a(Class<T> paramAnonymousClass)
          throws Exception
        {
          k.b(paramAnonymousClass);
          return this.a.invoke(localObject, new Object[] { paramAnonymousClass });
        }
      };
      return local1;
    }
    catch (Exception localException1)
    {
      try
      {
        Method localMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
        localMethod2.setAccessible(true);
        final int i = ((Integer)localMethod2.invoke(null, new Object[] { Object.class })).intValue();
        Class[] arrayOfClass = new Class[2];
        arrayOfClass[0] = Class.class;
        arrayOfClass[1] = Integer.TYPE;
        Method localMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", arrayOfClass);
        localMethod3.setAccessible(true);
        k local2 = new k()
        {
          public <T> T a(Class<T> paramAnonymousClass)
            throws Exception
          {
            k.b(paramAnonymousClass);
            Method localMethod = this.a;
            Object[] arrayOfObject = new Object[2];
            arrayOfObject[0] = paramAnonymousClass;
            arrayOfObject[1] = Integer.valueOf(i);
            return localMethod.invoke(null, arrayOfObject);
          }
        };
        return local2;
      }
      catch (Exception localException2)
      {
        try
        {
          Method localMethod1 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
          localMethod1.setAccessible(true);
          k local3 = new k()
          {
            public <T> T a(Class<T> paramAnonymousClass)
              throws Exception
            {
              k.b(paramAnonymousClass);
              return this.a.invoke(null, new Object[] { paramAnonymousClass, Object.class });
            }
          };
          return local3;
        }
        catch (Exception localException3)
        {
        }
      }
    }
    return new k()
    {
      public <T> T a(Class<T> paramAnonymousClass)
      {
        throw new UnsupportedOperationException("Cannot allocate " + paramAnonymousClass);
      }
    };
  }

  private static void c(Class<?> paramClass)
  {
    int i = paramClass.getModifiers();
    if (Modifier.isInterface(i))
      throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + paramClass.getName());
    if (Modifier.isAbstract(i))
      throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + paramClass.getName());
  }

  public abstract <T> T a(Class<T> paramClass)
    throws Exception;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.d.b.k
 * JD-Core Version:    0.6.2
 */
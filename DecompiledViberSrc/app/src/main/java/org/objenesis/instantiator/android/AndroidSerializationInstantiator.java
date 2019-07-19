package org.objenesis.instantiator.android;

import java.io.ObjectStreamClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;

public class AndroidSerializationInstantiator<T>
  implements ObjectInstantiator<T>
{
  private final Method newInstanceMethod;
  private final ObjectStreamClass objectStreamClass;
  private final Class<T> type;

  // ERROR //
  public AndroidSerializationInstantiator(Class<T> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 25	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 27	org/objenesis/instantiator/android/AndroidSerializationInstantiator:type	Ljava/lang/Class;
    //   9: aload_0
    //   10: invokestatic 31	org/objenesis/instantiator/android/AndroidSerializationInstantiator:getNewInstanceMethod	()Ljava/lang/reflect/Method;
    //   13: putfield 33	org/objenesis/instantiator/android/AndroidSerializationInstantiator:newInstanceMethod	Ljava/lang/reflect/Method;
    //   16: ldc 35
    //   18: ldc 37
    //   20: iconst_1
    //   21: anewarray 39	java/lang/Class
    //   24: dup
    //   25: iconst_0
    //   26: ldc 39
    //   28: aastore
    //   29: invokevirtual 43	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   32: astore_3
    //   33: aload_0
    //   34: aload_3
    //   35: aconst_null
    //   36: iconst_1
    //   37: anewarray 5	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: aload_1
    //   43: aastore
    //   44: invokevirtual 49	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   47: checkcast 35	java/io/ObjectStreamClass
    //   50: putfield 51	org/objenesis/instantiator/android/AndroidSerializationInstantiator:objectStreamClass	Ljava/io/ObjectStreamClass;
    //   53: return
    //   54: astore_2
    //   55: new 53	org/objenesis/ObjenesisException
    //   58: dup
    //   59: aload_2
    //   60: invokespecial 56	org/objenesis/ObjenesisException:<init>	(Ljava/lang/Throwable;)V
    //   63: athrow
    //   64: astore 5
    //   66: new 53	org/objenesis/ObjenesisException
    //   69: dup
    //   70: aload 5
    //   72: invokespecial 56	org/objenesis/ObjenesisException:<init>	(Ljava/lang/Throwable;)V
    //   75: athrow
    //   76: astore 4
    //   78: new 53	org/objenesis/ObjenesisException
    //   81: dup
    //   82: aload 4
    //   84: invokespecial 56	org/objenesis/ObjenesisException:<init>	(Ljava/lang/Throwable;)V
    //   87: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   16	33	54	java/lang/NoSuchMethodException
    //   33	53	64	java/lang/IllegalAccessException
    //   33	53	76	java/lang/reflect/InvocationTargetException
  }

  private static Method getNewInstanceMethod()
  {
    try
    {
      Method localMethod = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[] { Class.class });
      localMethod.setAccessible(true);
      return localMethod;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw new ObjenesisException(localRuntimeException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new ObjenesisException(localNoSuchMethodException);
    }
  }

  public T newInstance()
  {
    try
    {
      Class localClass = this.type;
      Method localMethod = this.newInstanceMethod;
      ObjectStreamClass localObjectStreamClass = this.objectStreamClass;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.type;
      Object localObject = localClass.cast(localMethod.invoke(localObjectStreamClass, arrayOfObject));
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new ObjenesisException(localIllegalAccessException);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new ObjenesisException(localIllegalArgumentException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new ObjenesisException(localInvocationTargetException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.android.AndroidSerializationInstantiator
 * JD-Core Version:    0.6.2
 */
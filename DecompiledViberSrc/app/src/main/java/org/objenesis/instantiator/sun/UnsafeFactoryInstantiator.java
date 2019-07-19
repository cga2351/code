package org.objenesis.instantiator.sun;

import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import sun.misc.Unsafe;

public class UnsafeFactoryInstantiator<T>
  implements ObjectInstantiator<T>
{
  private static Unsafe unsafe;
  private final Class<T> type;

  // ERROR //
  public UnsafeFactoryInstantiator(Class<T> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 21	java/lang/Object:<init>	()V
    //   4: getstatic 23	org/objenesis/instantiator/sun/UnsafeFactoryInstantiator:unsafe	Lsun/misc/Unsafe;
    //   7: ifnonnull +27 -> 34
    //   10: ldc 25
    //   12: ldc 27
    //   14: invokevirtual 33	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   17: astore_3
    //   18: aload_3
    //   19: iconst_1
    //   20: invokevirtual 39	java/lang/reflect/Field:setAccessible	(Z)V
    //   23: aload_3
    //   24: aconst_null
    //   25: invokevirtual 43	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast 25	sun/misc/Unsafe
    //   31: putstatic 23	org/objenesis/instantiator/sun/UnsafeFactoryInstantiator:unsafe	Lsun/misc/Unsafe;
    //   34: aload_0
    //   35: aload_1
    //   36: putfield 45	org/objenesis/instantiator/sun/UnsafeFactoryInstantiator:type	Ljava/lang/Class;
    //   39: return
    //   40: astore_2
    //   41: new 47	org/objenesis/ObjenesisException
    //   44: dup
    //   45: aload_2
    //   46: invokespecial 50	org/objenesis/ObjenesisException:<init>	(Ljava/lang/Throwable;)V
    //   49: athrow
    //   50: astore 4
    //   52: new 47	org/objenesis/ObjenesisException
    //   55: dup
    //   56: aload 4
    //   58: invokespecial 50	org/objenesis/ObjenesisException:<init>	(Ljava/lang/Throwable;)V
    //   61: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   10	18	40	java/lang/NoSuchFieldException
    //   23	34	50	java/lang/IllegalAccessException
  }

  public T newInstance()
  {
    try
    {
      Object localObject = this.type.cast(unsafe.allocateInstance(this.type));
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new ObjenesisException(localInstantiationException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.objenesis.instantiator.sun.UnsafeFactoryInstantiator
 * JD-Core Version:    0.6.2
 */
package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class OptionalMethod<T>
{
  private final String methodName;
  private final Class[] methodParams;
  private final Class<?> returnType;

  OptionalMethod(Class<?> paramClass, String paramString, Class[] paramArrayOfClass)
  {
    this.returnType = paramClass;
    this.methodName = paramString;
    this.methodParams = paramArrayOfClass;
  }

  private Method getMethod(Class<?> paramClass)
  {
    Method localMethod;
    if (this.methodName != null)
    {
      localMethod = getPublicMethod(paramClass, this.methodName, this.methodParams);
      if ((localMethod == null) || (this.returnType == null) || (this.returnType.isAssignableFrom(localMethod.getReturnType())));
    }
    else
    {
      return null;
    }
    return localMethod;
  }

  // ERROR //
  private static Method getPublicMethod(Class<?> paramClass, String paramString, Class[] paramArrayOfClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokevirtual 46	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   6: astore 4
    //   8: aload 4
    //   10: invokevirtual 50	java/lang/reflect/Method:getModifiers	()I
    //   13: istore 6
    //   15: iload 6
    //   17: iconst_1
    //   18: iand
    //   19: ifne +13 -> 32
    //   22: aconst_null
    //   23: areturn
    //   24: astore_3
    //   25: aconst_null
    //   26: areturn
    //   27: astore 5
    //   29: aload 4
    //   31: areturn
    //   32: aload 4
    //   34: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	24	java/lang/NoSuchMethodException
    //   8	15	27	java/lang/NoSuchMethodException
  }

  public Object invoke(T paramT, Object[] paramArrayOfObject)
    throws InvocationTargetException
  {
    Method localMethod = getMethod(paramT.getClass());
    if (localMethod == null)
      throw new AssertionError("Method " + this.methodName + " not supported for object " + paramT);
    try
    {
      Object localObject = localMethod.invoke(paramT, paramArrayOfObject);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      AssertionError localAssertionError = new AssertionError("Unexpectedly could not call: " + localMethod);
      localAssertionError.initCause(localIllegalAccessException);
      throw localAssertionError;
    }
  }

  public Object invokeOptional(T paramT, Object[] paramArrayOfObject)
    throws InvocationTargetException
  {
    Method localMethod = getMethod(paramT.getClass());
    if (localMethod == null)
      return null;
    try
    {
      Object localObject = localMethod.invoke(paramT, paramArrayOfObject);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
    return null;
  }

  public Object invokeOptionalWithoutCheckedException(T paramT, Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject = invokeOptional(paramT, paramArrayOfObject);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getTargetException();
      if ((localThrowable instanceof RuntimeException))
        throw ((RuntimeException)localThrowable);
      AssertionError localAssertionError = new AssertionError("Unexpected exception");
      localAssertionError.initCause(localThrowable);
      throw localAssertionError;
    }
  }

  public Object invokeWithoutCheckedException(T paramT, Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject = invoke(paramT, paramArrayOfObject);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getTargetException();
      if ((localThrowable instanceof RuntimeException))
        throw ((RuntimeException)localThrowable);
      AssertionError localAssertionError = new AssertionError("Unexpected exception");
      localAssertionError.initCause(localThrowable);
      throw localAssertionError;
    }
  }

  public boolean isSupported(T paramT)
  {
    return getMethod(paramT.getClass()) != null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.platform.OptionalMethod
 * JD-Core Version:    0.6.2
 */
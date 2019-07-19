package e.a.a;

import java.lang.reflect.Method;

class i extends ClassLoader
{
  private static final String a = d.class.getName();
  private static final Class<?>[] b = arrayOfClass;

  static
  {
    Class[] arrayOfClass = new Class[4];
    arrayOfClass[0] = String.class;
    arrayOfClass[1] = [B.class;
    arrayOfClass[2] = Integer.TYPE;
    arrayOfClass[3] = Integer.TYPE;
  }

  i(ClassLoader paramClassLoader)
  {
    super(paramClassLoader);
  }

  Class<?> a(String paramString, byte[] paramArrayOfByte)
    throws ClassFormatError
  {
    try
    {
      Method localMethod = ClassLoader.class.getDeclaredMethod("defineClass", b);
      localMethod.setAccessible(true);
      ClassLoader localClassLoader = getParent();
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = paramArrayOfByte;
      arrayOfObject[2] = Integer.valueOf(0);
      arrayOfObject[3] = Integer.valueOf(paramArrayOfByte.length);
      Class localClass = (Class)localMethod.invoke(localClassLoader, arrayOfObject);
      return localClass;
    }
    catch (Exception localException)
    {
    }
    return defineClass(paramString, paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  protected Class<?> loadClass(String paramString, boolean paramBoolean)
    throws ClassNotFoundException
  {
    try
    {
      if (paramString.equals(a));
      Class localClass;
      for (Object localObject2 = d.class; ; localObject2 = localClass)
      {
        return localObject2;
        localClass = super.loadClass(paramString, paramBoolean);
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     e.a.a.i
 * JD-Core Version:    0.6.2
 */
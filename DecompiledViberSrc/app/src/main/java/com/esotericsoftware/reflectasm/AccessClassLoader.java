package com.esotericsoftware.reflectasm;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.util.WeakHashMap;

class AccessClassLoader extends ClassLoader
{
  private static final WeakHashMap<ClassLoader, WeakReference<AccessClassLoader>> accessClassLoaders = new WeakHashMap();
  private static volatile AccessClassLoader selfContextAccessClassLoader = new AccessClassLoader(selfContextParentClassLoader);
  private static final ClassLoader selfContextParentClassLoader = getParentClassLoader(AccessClassLoader.class);

  private AccessClassLoader(ClassLoader paramClassLoader)
  {
    super(paramClassLoader);
  }

  public static int activeAccessClassLoaders()
  {
    int i = accessClassLoaders.size();
    if (selfContextAccessClassLoader != null)
      i++;
    return i;
  }

  static AccessClassLoader get(Class paramClass)
  {
    ClassLoader localClassLoader = getParentClassLoader(paramClass);
    if (selfContextParentClassLoader.equals(localClassLoader))
    {
      if (selfContextAccessClassLoader == null);
      synchronized (accessClassLoaders)
      {
        if (selfContextAccessClassLoader == null)
          selfContextAccessClassLoader = new AccessClassLoader(selfContextParentClassLoader);
        return selfContextAccessClassLoader;
      }
    }
    synchronized (accessClassLoaders)
    {
      WeakReference localWeakReference = (WeakReference)accessClassLoaders.get(localClassLoader);
      if (localWeakReference == null)
        break label119;
      AccessClassLoader localAccessClassLoader1 = (AccessClassLoader)localWeakReference.get();
      if (localAccessClassLoader1 != null)
        return localAccessClassLoader1;
    }
    accessClassLoaders.remove(localClassLoader);
    label119: AccessClassLoader localAccessClassLoader2 = new AccessClassLoader(localClassLoader);
    accessClassLoaders.put(localClassLoader, new WeakReference(localAccessClassLoader2));
    return localAccessClassLoader2;
  }

  private static ClassLoader getParentClassLoader(Class paramClass)
  {
    ClassLoader localClassLoader = paramClass.getClassLoader();
    if (localClassLoader == null)
      localClassLoader = ClassLoader.getSystemClassLoader();
    return localClassLoader;
  }

  public static void remove(ClassLoader paramClassLoader)
  {
    if (selfContextParentClassLoader.equals(paramClassLoader))
    {
      selfContextAccessClassLoader = null;
      return;
    }
    synchronized (accessClassLoaders)
    {
      accessClassLoaders.remove(paramClassLoader);
      return;
    }
  }

  Class<?> defineClass(String paramString, byte[] paramArrayOfByte)
    throws ClassFormatError
  {
    try
    {
      Class[] arrayOfClass = new Class[5];
      arrayOfClass[0] = String.class;
      arrayOfClass[1] = [B.class;
      arrayOfClass[2] = Integer.TYPE;
      arrayOfClass[3] = Integer.TYPE;
      arrayOfClass[4] = ProtectionDomain.class;
      Method localMethod = ClassLoader.class.getDeclaredMethod("defineClass", arrayOfClass);
      if (!localMethod.isAccessible())
        localMethod.setAccessible(true);
      ClassLoader localClassLoader = getParent();
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = paramArrayOfByte;
      arrayOfObject[2] = Integer.valueOf(0);
      arrayOfObject[3] = Integer.valueOf(paramArrayOfByte.length);
      arrayOfObject[4] = getClass().getProtectionDomain();
      Class localClass = (Class)localMethod.invoke(localClassLoader, arrayOfObject);
      return localClass;
    }
    catch (Exception localException)
    {
    }
    return defineClass(paramString, paramArrayOfByte, 0, paramArrayOfByte.length, getClass().getProtectionDomain());
  }

  protected Class<?> loadClass(String paramString, boolean paramBoolean)
    throws ClassNotFoundException
  {
    try
    {
      Object localObject2;
      if (paramString.equals(FieldAccess.class.getName()))
        localObject2 = FieldAccess.class;
      while (true)
      {
        return localObject2;
        if (paramString.equals(MethodAccess.class.getName()))
        {
          localObject2 = MethodAccess.class;
        }
        else if (paramString.equals(ConstructorAccess.class.getName()))
        {
          localObject2 = ConstructorAccess.class;
        }
        else
        {
          Class localClass = super.loadClass(paramString, paramBoolean);
          localObject2 = localClass;
        }
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.esotericsoftware.reflectasm.AccessClassLoader
 * JD-Core Version:    0.6.2
 */
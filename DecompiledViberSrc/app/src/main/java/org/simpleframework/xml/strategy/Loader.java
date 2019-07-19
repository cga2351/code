package org.simpleframework.xml.strategy;

class Loader
{
  private static ClassLoader getCallerClassLoader()
    throws Exception
  {
    return Loader.class.getClassLoader();
  }

  private static ClassLoader getClassLoader()
    throws Exception
  {
    return Thread.currentThread().getContextClassLoader();
  }

  public Class load(String paramString)
    throws Exception
  {
    ClassLoader localClassLoader = getClassLoader();
    if (localClassLoader == null)
      localClassLoader = getCallerClassLoader();
    return localClassLoader.loadClass(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.Loader
 * JD-Core Version:    0.6.2
 */
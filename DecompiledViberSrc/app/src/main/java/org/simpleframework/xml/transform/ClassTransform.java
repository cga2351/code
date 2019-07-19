package org.simpleframework.xml.transform;

class ClassTransform
  implements Transform<Class>
{
  private static final String BOOLEAN = "boolean";
  private static final String BYTE = "byte";
  private static final String CHARACTER = "char";
  private static final String DOUBLE = "double";
  private static final String FLOAT = "float";
  private static final String INTEGER = "int";
  private static final String LONG = "long";
  private static final String SHORT = "short";
  private static final String VOID = "void";

  private ClassLoader getCallerClassLoader()
  {
    return getClass().getClassLoader();
  }

  private static ClassLoader getClassLoader()
  {
    return Thread.currentThread().getContextClassLoader();
  }

  private Class readPrimitive(String paramString)
    throws Exception
  {
    if (paramString.equals("byte"))
      return Byte.TYPE;
    if (paramString.equals("short"))
      return Short.TYPE;
    if (paramString.equals("int"))
      return Integer.TYPE;
    if (paramString.equals("long"))
      return Long.TYPE;
    if (paramString.equals("char"))
      return Character.TYPE;
    if (paramString.equals("float"))
      return Float.TYPE;
    if (paramString.equals("double"))
      return Double.TYPE;
    if (paramString.equals("boolean"))
      return Boolean.TYPE;
    if (paramString.equals("void"))
      return Void.TYPE;
    return null;
  }

  public Class read(String paramString)
    throws Exception
  {
    Class localClass = readPrimitive(paramString);
    if (localClass == null)
    {
      ClassLoader localClassLoader = getClassLoader();
      if (localClassLoader == null)
        localClassLoader = getCallerClassLoader();
      localClass = localClassLoader.loadClass(paramString);
    }
    return localClass;
  }

  public String write(Class paramClass)
    throws Exception
  {
    return paramClass.getName();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.ClassTransform
 * JD-Core Version:    0.6.2
 */
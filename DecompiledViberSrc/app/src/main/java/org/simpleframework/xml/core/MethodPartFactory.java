package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class MethodPartFactory
{
  private final AnnotationFactory factory;

  public MethodPartFactory(Detail paramDetail, Support paramSupport)
  {
    this.factory = new AnnotationFactory(paramDetail, paramSupport);
  }

  private Annotation getAnnotation(Method paramMethod)
    throws Exception
  {
    Class[] arrayOfClass = getDependents(paramMethod);
    Class localClass = getType(paramMethod);
    if (localClass != null)
      return this.factory.getInstance(localClass, arrayOfClass);
    return null;
  }

  private Class[] getDependents(Method paramMethod)
    throws Exception
  {
    MethodType localMethodType = getMethodType(paramMethod);
    if (localMethodType == MethodType.SET)
      return Reflector.getParameterDependents(paramMethod, 0);
    if (localMethodType == MethodType.GET)
      return Reflector.getReturnDependents(paramMethod);
    if (localMethodType == MethodType.IS)
      return Reflector.getReturnDependents(paramMethod);
    return null;
  }

  private MethodType getMethodType(Method paramMethod)
  {
    String str = paramMethod.getName();
    if (str.startsWith("get"))
      return MethodType.GET;
    if (str.startsWith("is"))
      return MethodType.IS;
    if (str.startsWith("set"))
      return MethodType.SET;
    return MethodType.NONE;
  }

  private MethodName getName(Method paramMethod, Annotation paramAnnotation)
    throws Exception
  {
    MethodType localMethodType = getMethodType(paramMethod);
    if (localMethodType == MethodType.GET)
      return getRead(paramMethod, localMethodType);
    if (localMethodType == MethodType.IS)
      return getRead(paramMethod, localMethodType);
    if (localMethodType == MethodType.SET)
      return getWrite(paramMethod, localMethodType);
    throw new MethodException("Annotation %s must mark a set or get method", new Object[] { paramAnnotation });
  }

  private Class getParameterType(Method paramMethod)
    throws Exception
  {
    if (paramMethod.getParameterTypes().length == 1)
      return paramMethod.getParameterTypes()[0];
    return null;
  }

  private MethodName getRead(Method paramMethod, MethodType paramMethodType)
    throws Exception
  {
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    String str1 = paramMethod.getName();
    if (arrayOfClass.length != 0)
      throw new MethodException("Get method %s is not a valid property", new Object[] { paramMethod });
    String str2 = getTypeName(str1, paramMethodType);
    if (str2 == null)
      throw new MethodException("Could not get name for %s", new Object[] { paramMethod });
    return new MethodName(paramMethod, paramMethodType, str2);
  }

  private Class getReturnType(Method paramMethod)
    throws Exception
  {
    if (paramMethod.getParameterTypes().length == 0)
      return paramMethod.getReturnType();
    return null;
  }

  private String getTypeName(String paramString, MethodType paramMethodType)
  {
    int i = paramMethodType.getPrefix();
    int j = paramString.length();
    if (j > i)
      paramString = paramString.substring(i, j);
    return Reflector.getName(paramString);
  }

  private MethodName getWrite(Method paramMethod, MethodType paramMethodType)
    throws Exception
  {
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    String str1 = paramMethod.getName();
    if (arrayOfClass.length != 1)
      throw new MethodException("Set method %s is not a valid property", new Object[] { paramMethod });
    String str2 = getTypeName(str1, paramMethodType);
    if (str2 == null)
      throw new MethodException("Could not get name for %s", new Object[] { paramMethod });
    return new MethodName(paramMethod, paramMethodType, str2);
  }

  public MethodPart getInstance(Method paramMethod, Annotation paramAnnotation, Annotation[] paramArrayOfAnnotation)
    throws Exception
  {
    MethodName localMethodName = getName(paramMethod, paramAnnotation);
    if (localMethodName.getType() == MethodType.SET)
      return new SetPart(localMethodName, paramAnnotation, paramArrayOfAnnotation);
    return new GetPart(localMethodName, paramAnnotation, paramArrayOfAnnotation);
  }

  public MethodPart getInstance(Method paramMethod, Annotation[] paramArrayOfAnnotation)
    throws Exception
  {
    Annotation localAnnotation = getAnnotation(paramMethod);
    if (localAnnotation != null)
      return getInstance(paramMethod, localAnnotation, paramArrayOfAnnotation);
    return null;
  }

  public Class getType(Method paramMethod)
    throws Exception
  {
    MethodType localMethodType = getMethodType(paramMethod);
    if (localMethodType == MethodType.SET)
      return getParameterType(paramMethod);
    if (localMethodType == MethodType.GET)
      return getReturnType(paramMethod);
    if (localMethodType == MethodType.IS)
      return getReturnType(paramMethod);
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.MethodPartFactory
 * JD-Core Version:    0.6.2
 */
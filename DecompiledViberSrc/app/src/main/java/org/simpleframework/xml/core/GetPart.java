package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class GetPart
  implements MethodPart
{
  private final Cache<Annotation> cache = new ConcurrentCache();
  private final Annotation label;
  private final Annotation[] list;
  private final Method method;
  private final String name;
  private final MethodType type;

  public GetPart(MethodName paramMethodName, Annotation paramAnnotation, Annotation[] paramArrayOfAnnotation)
  {
    this.method = paramMethodName.getMethod();
    this.name = paramMethodName.getName();
    this.type = paramMethodName.getType();
    this.label = paramAnnotation;
    this.list = paramArrayOfAnnotation;
  }

  public Annotation getAnnotation()
  {
    return this.label;
  }

  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    if (this.cache.isEmpty())
      for (Annotation localAnnotation : this.list)
      {
        Class localClass = localAnnotation.annotationType();
        this.cache.cache(localClass, localAnnotation);
      }
    return (Annotation)this.cache.fetch(paramClass);
  }

  public Class getDeclaringClass()
  {
    return this.method.getDeclaringClass();
  }

  public Class getDependent()
  {
    return Reflector.getReturnDependent(this.method);
  }

  public Class[] getDependents()
  {
    return Reflector.getReturnDependents(this.method);
  }

  public Method getMethod()
  {
    if (!this.method.isAccessible())
      this.method.setAccessible(true);
    return this.method;
  }

  public MethodType getMethodType()
  {
    return this.type;
  }

  public String getName()
  {
    return this.name;
  }

  public Class getType()
  {
    return this.method.getReturnType();
  }

  public String toString()
  {
    return this.method.toGenericString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.GetPart
 * JD-Core Version:    0.6.2
 */
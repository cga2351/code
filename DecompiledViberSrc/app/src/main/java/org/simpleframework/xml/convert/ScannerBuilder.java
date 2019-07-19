package org.simpleframework.xml.convert;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.util.ConcurrentCache;

class ScannerBuilder extends ConcurrentCache<Scanner>
{
  public Scanner build(Class<?> paramClass)
  {
    Object localObject = (Scanner)get(paramClass);
    if (localObject == null)
    {
      localObject = new Entry(paramClass);
      put(paramClass, localObject);
    }
    return localObject;
  }

  private static class Entry extends ConcurrentCache<Annotation>
    implements Scanner
  {
    private final Class root;

    public Entry(Class paramClass)
    {
      this.root = paramClass;
    }

    private <T extends Annotation> T find(Class<T> paramClass)
    {
      for (Class localClass = this.root; localClass != null; localClass = localClass.getSuperclass())
      {
        Annotation localAnnotation = localClass.getAnnotation(paramClass);
        if (localAnnotation != null)
          return localAnnotation;
      }
      return null;
    }

    public <T extends Annotation> T scan(Class<T> paramClass)
    {
      if (!contains(paramClass))
      {
        Annotation localAnnotation = find(paramClass);
        if ((paramClass != null) && (localAnnotation != null))
          put(paramClass, localAnnotation);
      }
      return (Annotation)get(paramClass);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.ScannerBuilder
 * JD-Core Version:    0.6.2
 */
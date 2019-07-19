package org.simpleframework.xml.transform;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

public class RegistryMatcher
  implements Matcher
{
  private final Cache<Transform> transforms = new ConcurrentCache();
  private final Cache<Class> types = new ConcurrentCache();

  private Transform create(Class paramClass)
    throws Exception
  {
    Class localClass = (Class)this.types.fetch(paramClass);
    if (localClass != null)
      return create(paramClass, localClass);
    return null;
  }

  private Transform create(Class paramClass1, Class paramClass2)
    throws Exception
  {
    Transform localTransform = (Transform)paramClass2.newInstance();
    if (localTransform != null)
      this.transforms.cache(paramClass1, localTransform);
    return localTransform;
  }

  public void bind(Class paramClass1, Class paramClass2)
  {
    this.types.cache(paramClass1, paramClass2);
  }

  public void bind(Class paramClass, Transform paramTransform)
  {
    this.transforms.cache(paramClass, paramTransform);
  }

  public Transform match(Class paramClass)
    throws Exception
  {
    Transform localTransform = (Transform)this.transforms.fetch(paramClass);
    if (localTransform == null)
      localTransform = create(paramClass);
    return localTransform;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.RegistryMatcher
 * JD-Core Version:    0.6.2
 */
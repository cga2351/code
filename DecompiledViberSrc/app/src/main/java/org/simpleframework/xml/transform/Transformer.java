package org.simpleframework.xml.transform;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

public class Transformer
{
  private final Cache<Transform> cache = new ConcurrentCache();
  private final Cache<Object> error = new ConcurrentCache();
  private final Matcher matcher;

  public Transformer(Matcher paramMatcher)
  {
    this.matcher = new DefaultMatcher(paramMatcher);
  }

  private Transform lookup(Class paramClass)
    throws Exception
  {
    if (!this.error.contains(paramClass))
    {
      Transform localTransform = (Transform)this.cache.fetch(paramClass);
      if (localTransform != null)
        return localTransform;
      return match(paramClass);
    }
    return null;
  }

  private Transform match(Class paramClass)
    throws Exception
  {
    Transform localTransform = this.matcher.match(paramClass);
    if (localTransform != null)
    {
      this.cache.cache(paramClass, localTransform);
      return localTransform;
    }
    this.error.cache(paramClass, this);
    return localTransform;
  }

  public Object read(String paramString, Class paramClass)
    throws Exception
  {
    Transform localTransform = lookup(paramClass);
    if (localTransform == null)
      throw new TransformException("Transform of %s not supported", new Object[] { paramClass });
    return localTransform.read(paramString);
  }

  public boolean valid(Class paramClass)
    throws Exception
  {
    return lookup(paramClass) != null;
  }

  public String write(Object paramObject, Class paramClass)
    throws Exception
  {
    Transform localTransform = lookup(paramClass);
    if (localTransform == null)
      throw new TransformException("Transform of %s not supported", new Object[] { paramClass });
    return localTransform.write(paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.Transformer
 * JD-Core Version:    0.6.2
 */
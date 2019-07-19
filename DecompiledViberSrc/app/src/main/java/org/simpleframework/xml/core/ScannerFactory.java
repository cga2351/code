package org.simpleframework.xml.core;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class ScannerFactory
{
  private final Cache<Scanner> cache = new ConcurrentCache();
  private final Support support;

  public ScannerFactory(Support paramSupport)
  {
    this.support = paramSupport;
  }

  public Scanner getInstance(Class paramClass)
    throws Exception
  {
    Object localObject = (Scanner)this.cache.fetch(paramClass);
    Detail localDetail;
    if (localObject == null)
    {
      localDetail = this.support.getDetail(paramClass);
      if (!this.support.isPrimitive(paramClass))
        break label60;
    }
    for (localObject = new PrimitiveScanner(localDetail); ; localObject = new DefaultScanner(localDetail, this.support))
      label60: 
      do
      {
        this.cache.cache(paramClass, localObject);
        return localObject;
        localObject = new ObjectScanner(localDetail, this.support);
      }
      while ((!((Scanner)localObject).isPrimitive()) || (this.support.isContainer(paramClass)));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ScannerFactory
 * JD-Core Version:    0.6.2
 */
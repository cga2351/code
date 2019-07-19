package org.simpleframework.xml.core;

import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class DetailExtractor
{
  private final Cache<Detail> details = new ConcurrentCache();
  private final Cache<ContactList> fields = new ConcurrentCache();
  private final Cache<ContactList> methods = new ConcurrentCache();
  private final DefaultType override;
  private final Support support;

  public DetailExtractor(Support paramSupport)
  {
    this(paramSupport, null);
  }

  public DetailExtractor(Support paramSupport, DefaultType paramDefaultType)
  {
    this.override = paramDefaultType;
    this.support = paramSupport;
  }

  private ContactList getFields(Class paramClass, Detail paramDetail)
    throws Exception
  {
    FieldScanner localFieldScanner = new FieldScanner(paramDetail, this.support);
    if (paramDetail != null)
      this.fields.cache(paramClass, localFieldScanner);
    return localFieldScanner;
  }

  private ContactList getMethods(Class paramClass, Detail paramDetail)
    throws Exception
  {
    MethodScanner localMethodScanner = new MethodScanner(paramDetail, this.support);
    if (paramDetail != null)
      this.methods.cache(paramClass, localMethodScanner);
    return localMethodScanner;
  }

  public Detail getDetail(Class paramClass)
  {
    Object localObject = (Detail)this.details.fetch(paramClass);
    if (localObject == null)
    {
      localObject = new DetailScanner(paramClass, this.override);
      this.details.cache(paramClass, localObject);
    }
    return localObject;
  }

  public ContactList getFields(Class paramClass)
    throws Exception
  {
    ContactList localContactList = (ContactList)this.fields.fetch(paramClass);
    if (localContactList == null)
    {
      Detail localDetail = getDetail(paramClass);
      if (localDetail != null)
        localContactList = getFields(paramClass, localDetail);
    }
    return localContactList;
  }

  public ContactList getMethods(Class paramClass)
    throws Exception
  {
    ContactList localContactList = (ContactList)this.methods.fetch(paramClass);
    if (localContactList == null)
    {
      Detail localDetail = getDetail(paramClass);
      if (localDetail != null)
        localContactList = getMethods(paramClass, localDetail);
    }
    return localContactList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.DetailExtractor
 * JD-Core Version:    0.6.2
 */
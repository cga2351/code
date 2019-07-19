package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.Transient;
import org.simpleframework.xml.Version;

class MethodScanner extends ContactList
{
  private final Detail detail;
  private final MethodPartFactory factory;
  private final PartMap read;
  private final Support support;
  private final PartMap write;

  public MethodScanner(Detail paramDetail, Support paramSupport)
    throws Exception
  {
    this.factory = new MethodPartFactory(paramDetail, paramSupport);
    this.write = new PartMap(null);
    this.read = new PartMap(null);
    this.support = paramSupport;
    this.detail = paramDetail;
    scan(paramDetail);
  }

  private void build()
    throws Exception
  {
    Iterator localIterator = this.read.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      MethodPart localMethodPart = (MethodPart)this.read.get(str);
      if (localMethodPart != null)
        build(localMethodPart, str);
    }
  }

  private void build(MethodPart paramMethodPart)
    throws Exception
  {
    add(new MethodContact(paramMethodPart));
  }

  private void build(MethodPart paramMethodPart, String paramString)
    throws Exception
  {
    MethodPart localMethodPart = this.write.take(paramString);
    if (localMethodPart != null)
    {
      build(paramMethodPart, localMethodPart);
      return;
    }
    build(paramMethodPart);
  }

  private void build(MethodPart paramMethodPart1, MethodPart paramMethodPart2)
    throws Exception
  {
    Annotation localAnnotation = paramMethodPart1.getAnnotation();
    String str = paramMethodPart1.getName();
    if (!paramMethodPart2.getAnnotation().equals(localAnnotation))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = str;
      arrayOfObject[1] = this.detail;
      throw new MethodException("Annotations do not match for '%s' in %s", arrayOfObject);
    }
    Class localClass = paramMethodPart1.getType();
    if (localClass != paramMethodPart2.getType())
      throw new MethodException("Method types do not match for %s in %s", new Object[] { str, localClass });
    add(new MethodContact(paramMethodPart1, paramMethodPart2));
  }

  private void extend(Class paramClass, DefaultType paramDefaultType)
    throws Exception
  {
    Iterator localIterator = this.support.getMethods(paramClass, paramDefaultType).iterator();
    while (localIterator.hasNext())
      process((MethodContact)localIterator.next());
  }

  private void extract(Detail paramDetail)
    throws Exception
  {
    Iterator localIterator = paramDetail.getMethods().iterator();
    while (localIterator.hasNext())
    {
      MethodDetail localMethodDetail = (MethodDetail)localIterator.next();
      Annotation[] arrayOfAnnotation = localMethodDetail.getAnnotations();
      Method localMethod = localMethodDetail.getMethod();
      int i = arrayOfAnnotation.length;
      for (int j = 0; j < i; j++)
        scan(localMethod, arrayOfAnnotation[j], arrayOfAnnotation);
    }
  }

  private void extract(Detail paramDetail, DefaultType paramDefaultType)
    throws Exception
  {
    List localList = paramDetail.getMethods();
    if (paramDefaultType == DefaultType.PROPERTY)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        MethodDetail localMethodDetail = (MethodDetail)localIterator.next();
        Annotation[] arrayOfAnnotation = localMethodDetail.getAnnotations();
        Method localMethod = localMethodDetail.getMethod();
        if (this.factory.getType(localMethod) != null)
          process(localMethod, arrayOfAnnotation);
      }
    }
  }

  private void insert(MethodPart paramMethodPart, PartMap paramPartMap)
  {
    String str = paramMethodPart.getName();
    MethodPart localMethodPart = (MethodPart)paramPartMap.remove(str);
    if ((localMethodPart != null) && (isText(paramMethodPart)))
      paramMethodPart = localMethodPart;
    paramPartMap.put(str, paramMethodPart);
  }

  private boolean isText(MethodPart paramMethodPart)
  {
    return (paramMethodPart.getAnnotation() instanceof Text);
  }

  private void process(Method paramMethod, Annotation paramAnnotation, Annotation[] paramArrayOfAnnotation)
    throws Exception
  {
    MethodPart localMethodPart = this.factory.getInstance(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    MethodType localMethodType = localMethodPart.getMethodType();
    if (localMethodType == MethodType.GET)
      process(localMethodPart, this.read);
    if (localMethodType == MethodType.IS)
      process(localMethodPart, this.read);
    if (localMethodType == MethodType.SET)
      process(localMethodPart, this.write);
  }

  private void process(Method paramMethod, Annotation[] paramArrayOfAnnotation)
    throws Exception
  {
    MethodPart localMethodPart = this.factory.getInstance(paramMethod, paramArrayOfAnnotation);
    MethodType localMethodType = localMethodPart.getMethodType();
    if (localMethodType == MethodType.GET)
      process(localMethodPart, this.read);
    if (localMethodType == MethodType.IS)
      process(localMethodPart, this.read);
    if (localMethodType == MethodType.SET)
      process(localMethodPart, this.write);
  }

  private void process(MethodContact paramMethodContact)
  {
    MethodPart localMethodPart1 = paramMethodContact.getRead();
    MethodPart localMethodPart2 = paramMethodContact.getWrite();
    if (localMethodPart2 != null)
      insert(localMethodPart2, this.write);
    insert(localMethodPart1, this.read);
  }

  private void process(MethodPart paramMethodPart, PartMap paramPartMap)
  {
    String str = paramMethodPart.getName();
    if (str != null)
      paramPartMap.put(str, paramMethodPart);
  }

  private void remove(Method paramMethod, Annotation paramAnnotation, Annotation[] paramArrayOfAnnotation)
    throws Exception
  {
    MethodPart localMethodPart = this.factory.getInstance(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    MethodType localMethodType = localMethodPart.getMethodType();
    if (localMethodType == MethodType.GET)
      remove(localMethodPart, this.read);
    if (localMethodType == MethodType.IS)
      remove(localMethodPart, this.read);
    if (localMethodType == MethodType.SET)
      remove(localMethodPart, this.write);
  }

  private void remove(MethodPart paramMethodPart, PartMap paramPartMap)
    throws Exception
  {
    String str = paramMethodPart.getName();
    if (str != null)
      paramPartMap.remove(str);
  }

  private void scan(Method paramMethod, Annotation paramAnnotation, Annotation[] paramArrayOfAnnotation)
    throws Exception
  {
    if ((paramAnnotation instanceof Attribute))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementUnion))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementListUnion))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementMapUnion))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementList))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementArray))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementMap))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof Element))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof Version))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof Text))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof Transient))
      remove(paramMethod, paramAnnotation, paramArrayOfAnnotation);
  }

  private void scan(Detail paramDetail)
    throws Exception
  {
    DefaultType localDefaultType1 = paramDetail.getOverride();
    DefaultType localDefaultType2 = paramDetail.getAccess();
    Class localClass = paramDetail.getSuper();
    if (localClass != null)
      extend(localClass, localDefaultType1);
    extract(paramDetail, localDefaultType2);
    extract(paramDetail);
    build();
    validate();
  }

  private void validate()
    throws Exception
  {
    Iterator localIterator = this.write.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      MethodPart localMethodPart = (MethodPart)this.write.get(str);
      if (localMethodPart != null)
        validate(localMethodPart, str);
    }
  }

  private void validate(MethodPart paramMethodPart, String paramString)
    throws Exception
  {
    MethodPart localMethodPart = this.read.take(paramString);
    Method localMethod = paramMethodPart.getMethod();
    if (localMethodPart == null)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localMethod;
      arrayOfObject[1] = this.detail;
      throw new MethodException("No matching get method for %s in %s", arrayOfObject);
    }
  }

  private static class PartMap extends LinkedHashMap<String, MethodPart>
    implements Iterable<String>
  {
    public Iterator<String> iterator()
    {
      return keySet().iterator();
    }

    public MethodPart take(String paramString)
    {
      return (MethodPart)remove(paramString);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.MethodScanner
 * JD-Core Version:    0.6.2
 */
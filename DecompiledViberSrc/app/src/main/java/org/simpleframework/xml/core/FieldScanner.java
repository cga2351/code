package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
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

class FieldScanner extends ContactList
{
  private final ContactMap done;
  private final AnnotationFactory factory;
  private final Support support;

  public FieldScanner(Detail paramDetail, Support paramSupport)
    throws Exception
  {
    this.factory = new AnnotationFactory(paramDetail, paramSupport);
    this.done = new ContactMap();
    this.support = paramSupport;
    scan(paramDetail);
  }

  private void build()
  {
    Iterator localIterator = this.done.iterator();
    while (localIterator.hasNext())
      add((Contact)localIterator.next());
  }

  private void extend(Class paramClass, DefaultType paramDefaultType)
    throws Exception
  {
    ContactList localContactList = this.support.getFields(paramClass, paramDefaultType);
    if (localContactList != null)
      addAll(localContactList);
  }

  private void extract(Detail paramDetail)
  {
    Iterator localIterator = paramDetail.getFields().iterator();
    while (localIterator.hasNext())
    {
      FieldDetail localFieldDetail = (FieldDetail)localIterator.next();
      Annotation[] arrayOfAnnotation = localFieldDetail.getAnnotations();
      Field localField = localFieldDetail.getField();
      int i = arrayOfAnnotation.length;
      for (int j = 0; j < i; j++)
        scan(localField, arrayOfAnnotation[j], arrayOfAnnotation);
    }
  }

  private void extract(Detail paramDetail, DefaultType paramDefaultType)
    throws Exception
  {
    List localList = paramDetail.getFields();
    if (paramDefaultType == DefaultType.FIELD)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        FieldDetail localFieldDetail = (FieldDetail)localIterator.next();
        Annotation[] arrayOfAnnotation = localFieldDetail.getAnnotations();
        Field localField = localFieldDetail.getField();
        Class localClass = localField.getType();
        if ((!isStatic(localField)) && (!isTransient(localField)))
          process(localField, localClass, arrayOfAnnotation);
      }
    }
  }

  private void insert(Object paramObject, Contact paramContact)
  {
    Contact localContact = (Contact)this.done.remove(paramObject);
    if ((localContact != null) && (isText(paramContact)))
      paramContact = localContact;
    this.done.put(paramObject, paramContact);
  }

  private boolean isStatic(Field paramField)
  {
    return Modifier.isStatic(paramField.getModifiers());
  }

  private boolean isText(Contact paramContact)
  {
    return (paramContact.getAnnotation() instanceof Text);
  }

  private boolean isTransient(Field paramField)
  {
    return Modifier.isTransient(paramField.getModifiers());
  }

  private void process(Field paramField, Class paramClass, Annotation[] paramArrayOfAnnotation)
    throws Exception
  {
    Class[] arrayOfClass = Reflector.getDependents(paramField);
    Annotation localAnnotation = this.factory.getInstance(paramClass, arrayOfClass);
    if (localAnnotation != null)
      process(paramField, localAnnotation, paramArrayOfAnnotation);
  }

  private void process(Field paramField, Annotation paramAnnotation, Annotation[] paramArrayOfAnnotation)
  {
    FieldContact localFieldContact = new FieldContact(paramField, paramAnnotation, paramArrayOfAnnotation);
    FieldKey localFieldKey = new FieldKey(paramField);
    if (!paramField.isAccessible())
      paramField.setAccessible(true);
    insert(localFieldKey, localFieldContact);
  }

  private void remove(Field paramField, Annotation paramAnnotation)
  {
    this.done.remove(new FieldKey(paramField));
  }

  private void scan(Field paramField, Annotation paramAnnotation, Annotation[] paramArrayOfAnnotation)
  {
    if ((paramAnnotation instanceof Attribute))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementUnion))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementListUnion))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementMapUnion))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementList))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementArray))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementMap))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof Element))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof Version))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof Text))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof Transient))
      remove(paramField, paramAnnotation);
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
  }

  private static class FieldKey
  {
    private final String name;
    private final Class type;

    public FieldKey(Field paramField)
    {
      this.type = paramField.getDeclaringClass();
      this.name = paramField.getName();
    }

    private boolean equals(FieldKey paramFieldKey)
    {
      if (paramFieldKey.type != this.type)
        return false;
      return paramFieldKey.name.equals(this.name);
    }

    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof FieldKey))
        return equals((FieldKey)paramObject);
      return false;
    }

    public int hashCode()
    {
      return this.name.hashCode();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.FieldScanner
 * JD-Core Version:    0.6.2
 */
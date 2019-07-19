package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.stream.Format;

class ExtractorFactory
{
  private final Contact contact;
  private final Format format;
  private final Annotation label;

  public ExtractorFactory(Contact paramContact, Annotation paramAnnotation, Format paramFormat)
  {
    this.contact = paramContact;
    this.format = paramFormat;
    this.label = paramAnnotation;
  }

  private ExtractorBuilder getBuilder(Annotation paramAnnotation)
    throws Exception
  {
    if ((paramAnnotation instanceof ElementUnion))
      return new ExtractorBuilder(ElementUnion.class, ElementExtractor.class);
    if ((paramAnnotation instanceof ElementListUnion))
      return new ExtractorBuilder(ElementListUnion.class, ElementListExtractor.class);
    if ((paramAnnotation instanceof ElementMapUnion))
      return new ExtractorBuilder(ElementMapUnion.class, ElementMapExtractor.class);
    throw new PersistenceException("Annotation %s is not a union", new Object[] { paramAnnotation });
  }

  private Object getInstance(Annotation paramAnnotation)
    throws Exception
  {
    Constructor localConstructor = getBuilder(paramAnnotation).getConstructor();
    if (!localConstructor.isAccessible())
      localConstructor.setAccessible(true);
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.contact;
    arrayOfObject[1] = paramAnnotation;
    arrayOfObject[2] = this.format;
    return localConstructor.newInstance(arrayOfObject);
  }

  public Extractor getInstance()
    throws Exception
  {
    return (Extractor)getInstance(this.label);
  }

  private static class ElementExtractor
    implements Extractor<Element>
  {
    private final Contact contact;
    private final Format format;
    private final ElementUnion union;

    public ElementExtractor(Contact paramContact, ElementUnion paramElementUnion, Format paramFormat)
      throws Exception
    {
      this.contact = paramContact;
      this.format = paramFormat;
      this.union = paramElementUnion;
    }

    public Element[] getAnnotations()
    {
      return this.union.value();
    }

    public Label getLabel(Element paramElement)
    {
      return new ElementLabel(this.contact, paramElement, this.format);
    }

    public Class getType(Element paramElement)
    {
      Class localClass = paramElement.type();
      if (localClass == Void.TYPE)
        localClass = this.contact.getType();
      return localClass;
    }
  }

  private static class ElementListExtractor
    implements Extractor<ElementList>
  {
    private final Contact contact;
    private final Format format;
    private final ElementListUnion union;

    public ElementListExtractor(Contact paramContact, ElementListUnion paramElementListUnion, Format paramFormat)
      throws Exception
    {
      this.contact = paramContact;
      this.format = paramFormat;
      this.union = paramElementListUnion;
    }

    public ElementList[] getAnnotations()
    {
      return this.union.value();
    }

    public Label getLabel(ElementList paramElementList)
    {
      return new ElementListLabel(this.contact, paramElementList, this.format);
    }

    public Class getType(ElementList paramElementList)
    {
      return paramElementList.type();
    }
  }

  private static class ElementMapExtractor
    implements Extractor<ElementMap>
  {
    private final Contact contact;
    private final Format format;
    private final ElementMapUnion union;

    public ElementMapExtractor(Contact paramContact, ElementMapUnion paramElementMapUnion, Format paramFormat)
      throws Exception
    {
      this.contact = paramContact;
      this.format = paramFormat;
      this.union = paramElementMapUnion;
    }

    public ElementMap[] getAnnotations()
    {
      return this.union.value();
    }

    public Label getLabel(ElementMap paramElementMap)
    {
      return new ElementMapLabel(this.contact, paramElementMap, this.format);
    }

    public Class getType(ElementMap paramElementMap)
    {
      return paramElementMap.valueType();
    }
  }

  private static class ExtractorBuilder
  {
    private final Class label;
    private final Class type;

    public ExtractorBuilder(Class paramClass1, Class paramClass2)
    {
      this.label = paramClass1;
      this.type = paramClass2;
    }

    private Constructor getConstructor()
      throws Exception
    {
      Class localClass = this.type;
      Class[] arrayOfClass = new Class[3];
      arrayOfClass[0] = Contact.class;
      arrayOfClass[1] = this.label;
      arrayOfClass[2] = Format.class;
      return localClass.getConstructor(arrayOfClass);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ExtractorFactory
 * JD-Core Version:    0.6.2
 */
package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;

class ElementListUnionLabel extends TemplateLabel
{
  private Contact contact;
  private GroupExtractor extractor;
  private Label label;
  private Expression path;

  public ElementListUnionLabel(Contact paramContact, ElementListUnion paramElementListUnion, ElementList paramElementList, Format paramFormat)
    throws Exception
  {
    this.label = new ElementListLabel(paramContact, paramElementList, paramFormat);
    this.extractor = new GroupExtractor(paramContact, paramElementListUnion, paramFormat);
    this.contact = paramContact;
  }

  public Annotation getAnnotation()
  {
    return this.label.getAnnotation();
  }

  public Contact getContact()
  {
    return this.contact;
  }

  public Converter getConverter(Context paramContext)
    throws Exception
  {
    Expression localExpression = getExpression();
    Contact localContact = getContact();
    if (localContact == null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.label;
      throw new UnionException("Union %s was not declared on a field or method", arrayOfObject);
    }
    return new CompositeListUnion(paramContext, this.extractor, localExpression, localContact);
  }

  public Decorator getDecorator()
    throws Exception
  {
    return this.label.getDecorator();
  }

  public Type getDependent()
    throws Exception
  {
    return this.label.getDependent();
  }

  public Object getEmpty(Context paramContext)
    throws Exception
  {
    return this.label.getEmpty(paramContext);
  }

  public String getEntry()
    throws Exception
  {
    return this.label.getEntry();
  }

  public Expression getExpression()
    throws Exception
  {
    if (this.path == null)
      this.path = this.label.getExpression();
    return this.path;
  }

  public Label getLabel(Class paramClass)
  {
    return this;
  }

  public String getName()
    throws Exception
  {
    return this.label.getName();
  }

  public String[] getNames()
    throws Exception
  {
    return this.extractor.getNames();
  }

  public String getOverride()
  {
    return this.label.getOverride();
  }

  public String getPath()
    throws Exception
  {
    return this.label.getPath();
  }

  public String[] getPaths()
    throws Exception
  {
    return this.extractor.getPaths();
  }

  public Class getType()
  {
    return this.label.getType();
  }

  public Type getType(Class paramClass)
  {
    return getContact();
  }

  public boolean isCollection()
  {
    return this.label.isCollection();
  }

  public boolean isData()
  {
    return this.label.isData();
  }

  public boolean isInline()
  {
    return this.label.isInline();
  }

  public boolean isRequired()
  {
    return this.label.isRequired();
  }

  public boolean isTextList()
  {
    return this.extractor.isTextList();
  }

  public boolean isUnion()
  {
    return true;
  }

  public String toString()
  {
    return this.label.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ElementListUnionLabel
 * JD-Core Version:    0.6.2
 */
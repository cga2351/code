package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

class ElementLabel extends TemplateLabel
{
  private Expression cache;
  private boolean data;
  private Decorator decorator;
  private Introspector detail;
  private Class expect;
  private Format format;
  private Element label;
  private String name;
  private String override;
  private String path;
  private boolean required;
  private Class type;

  public ElementLabel(Contact paramContact, Element paramElement, Format paramFormat)
  {
    this.detail = new Introspector(paramContact, this, paramFormat);
    this.decorator = new Qualifier(paramContact);
    this.required = paramElement.required();
    this.type = paramContact.getType();
    this.override = paramElement.name();
    this.expect = paramElement.type();
    this.data = paramElement.data();
    this.format = paramFormat;
    this.label = paramElement;
  }

  public Annotation getAnnotation()
  {
    return this.label;
  }

  public Contact getContact()
  {
    return this.detail.getContact();
  }

  public Converter getConverter(Context paramContext)
    throws Exception
  {
    Contact localContact = getContact();
    if (paramContext.isPrimitive(localContact))
      return new Primitive(paramContext, localContact);
    if (this.expect == Void.TYPE)
      return new Composite(paramContext, localContact);
    return new Composite(paramContext, localContact, this.expect);
  }

  public Decorator getDecorator()
    throws Exception
  {
    return this.decorator;
  }

  public Object getEmpty(Context paramContext)
  {
    return null;
  }

  public Expression getExpression()
    throws Exception
  {
    if (this.cache == null)
      this.cache = this.detail.getExpression();
    return this.cache;
  }

  public String getName()
    throws Exception
  {
    if (this.name == null)
      this.name = this.format.getStyle().getElement(this.detail.getName());
    return this.name;
  }

  public String getOverride()
  {
    return this.override;
  }

  public String getPath()
    throws Exception
  {
    if (this.path == null)
      this.path = getExpression().getElement(getName());
    return this.path;
  }

  public Class getType()
  {
    if (this.expect == Void.TYPE)
      return this.type;
    return this.expect;
  }

  public Type getType(Class paramClass)
  {
    Contact localContact = getContact();
    if (this.expect == Void.TYPE)
      return localContact;
    return new OverrideType(localContact, this.expect);
  }

  public boolean isData()
  {
    return this.data;
  }

  public boolean isRequired()
  {
    return this.required;
  }

  public String toString()
  {
    return this.detail.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ElementLabel
 * JD-Core Version:    0.6.2
 */
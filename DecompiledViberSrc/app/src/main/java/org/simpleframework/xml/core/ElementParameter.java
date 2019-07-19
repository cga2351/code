package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.stream.Format;

class ElementParameter extends TemplateParameter
{
  private final Contact contact;
  private final Expression expression;
  private final int index;
  private final Object key;
  private final Label label;
  private final String name;
  private final String path;
  private final Class type;

  public ElementParameter(Constructor paramConstructor, Element paramElement, Format paramFormat, int paramInt)
    throws Exception
  {
    this.contact = new Contact(paramElement, paramConstructor, paramInt);
    this.label = new ElementLabel(this.contact, paramElement, paramFormat);
    this.expression = this.label.getExpression();
    this.path = this.label.getPath();
    this.type = this.label.getType();
    this.name = this.label.getName();
    this.key = this.label.getKey();
    this.index = paramInt;
  }

  public Annotation getAnnotation()
  {
    return this.contact.getAnnotation();
  }

  public Expression getExpression()
  {
    return this.expression;
  }

  public int getIndex()
  {
    return this.index;
  }

  public Object getKey()
  {
    return this.key;
  }

  public String getName()
  {
    return this.name;
  }

  public String getPath()
  {
    return this.path;
  }

  public Class getType()
  {
    return this.type;
  }

  public boolean isPrimitive()
  {
    return this.type.isPrimitive();
  }

  public boolean isRequired()
  {
    return this.label.isRequired();
  }

  public String toString()
  {
    return this.contact.toString();
  }

  private static class Contact extends ParameterContact<Element>
  {
    public Contact(Element paramElement, Constructor paramConstructor, int paramInt)
    {
      super(paramConstructor, paramInt);
    }

    public String getName()
    {
      return ((Element)this.label).name();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ElementParameter
 * JD-Core Version:    0.6.2
 */
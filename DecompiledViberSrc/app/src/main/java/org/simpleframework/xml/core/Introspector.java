package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;

class Introspector
{
  private final Contact contact;
  private final Format format;
  private final Label label;
  private final Annotation marker;

  public Introspector(Contact paramContact, Label paramLabel, Format paramFormat)
  {
    this.marker = paramContact.getAnnotation();
    this.contact = paramContact;
    this.format = paramFormat;
    this.label = paramLabel;
  }

  private String getDefault()
    throws Exception
  {
    String str = this.label.getOverride();
    if (!isEmpty(str))
      return str;
    return this.contact.getName();
  }

  private String getName(Class paramClass)
    throws Exception
  {
    String str = getRoot(paramClass);
    if (str != null)
      return str;
    return Reflector.getName(paramClass.getSimpleName());
  }

  private String getRoot(Class paramClass)
  {
    for (Class localClass = paramClass; localClass != null; localClass = localClass.getSuperclass())
    {
      String str = getRoot(paramClass, localClass);
      if (str != null)
        return str;
    }
    return null;
  }

  private String getRoot(Class<?> paramClass1, Class<?> paramClass2)
  {
    String str1 = paramClass2.getSimpleName();
    Root localRoot = (Root)paramClass2.getAnnotation(Root.class);
    if (localRoot != null)
    {
      String str2 = localRoot.name();
      if (!isEmpty(str2))
        return str2;
      return Reflector.getName(str1);
    }
    return null;
  }

  public Contact getContact()
  {
    return this.contact;
  }

  public Type getDependent()
    throws Exception
  {
    return this.label.getDependent();
  }

  public String getEntry()
    throws Exception
  {
    Class localClass = getDependent().getType();
    if (localClass.isArray())
      localClass = localClass.getComponentType();
    return getName(localClass);
  }

  public Expression getExpression()
    throws Exception
  {
    String str = getPath();
    if (str != null)
      return new PathParser(str, this.contact, this.format);
    return new EmptyExpression(this.format);
  }

  public String getName()
    throws Exception
  {
    String str = this.label.getEntry();
    if (!this.label.isInline())
      str = getDefault();
    return str;
  }

  public String getPath()
    throws Exception
  {
    Path localPath = (Path)this.contact.getAnnotation(Path.class);
    if (localPath == null)
      return null;
    return localPath.value();
  }

  public boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.marker;
    arrayOfObject[1] = this.contact;
    return String.format("%s on %s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Introspector
 * JD-Core Version:    0.6.2
 */
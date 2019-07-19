package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class PrimitiveValue
  implements Converter
{
  private final Context context;
  private final Entry entry;
  private final PrimitiveFactory factory;
  private final Primitive root;
  private final Style style;
  private final Type type;

  public PrimitiveValue(Context paramContext, Entry paramEntry, Type paramType)
  {
    this.factory = new PrimitiveFactory(paramContext, paramType);
    this.root = new Primitive(paramContext, paramType);
    this.style = paramContext.getStyle();
    this.context = paramContext;
    this.entry = paramEntry;
    this.type = paramType;
  }

  private boolean isOverridden(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    return this.factory.setOverride(this.type, paramObject, paramOutputNode);
  }

  private Object readAttribute(InputNode paramInputNode, String paramString)
    throws Exception
  {
    if (paramString != null)
      paramInputNode = paramInputNode.getAttribute(this.style.getAttribute(paramString));
    if (paramInputNode == null)
      return null;
    return this.root.read(paramInputNode);
  }

  private Object readElement(InputNode paramInputNode, String paramString)
    throws Exception
  {
    InputNode localInputNode = paramInputNode.getNext(this.style.getAttribute(paramString));
    if (localInputNode == null)
      return null;
    return this.root.read(localInputNode);
  }

  private boolean validateAttribute(InputNode paramInputNode, String paramString)
    throws Exception
  {
    if (paramString != null)
      paramInputNode = paramInputNode.getNext(this.style.getAttribute(paramString));
    if (paramInputNode == null)
      return true;
    return this.root.validate(paramInputNode);
  }

  private boolean validateElement(InputNode paramInputNode, String paramString)
    throws Exception
  {
    if (paramInputNode.getNext(this.style.getAttribute(paramString)) == null)
      return true;
    return this.root.validate(paramInputNode);
  }

  private void writeAttribute(OutputNode paramOutputNode, Object paramObject, String paramString)
    throws Exception
  {
    if (paramObject != null)
    {
      if (paramString != null)
        paramOutputNode = paramOutputNode.setAttribute(this.style.getAttribute(paramString), null);
      this.root.write(paramOutputNode, paramObject);
    }
  }

  private void writeElement(OutputNode paramOutputNode, Object paramObject, String paramString)
    throws Exception
  {
    OutputNode localOutputNode = paramOutputNode.getChild(this.style.getAttribute(paramString));
    if ((paramObject != null) && (!isOverridden(localOutputNode, paramObject)))
      this.root.write(localOutputNode, paramObject);
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    Class localClass = this.type.getType();
    String str = this.entry.getValue();
    if (!this.entry.isInline())
    {
      if (str == null)
        str = this.context.getName(localClass);
      return readElement(paramInputNode, str);
    }
    return readAttribute(paramInputNode, str);
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Class localClass = this.type.getType();
    if (paramObject != null)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localClass;
      arrayOfObject[1] = this.entry;
      throw new PersistenceException("Can not read value of %s for %s", arrayOfObject);
    }
    return read(paramInputNode);
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    Class localClass = this.type.getType();
    String str = this.entry.getValue();
    if (!this.entry.isInline())
    {
      if (str == null)
        str = this.context.getName(localClass);
      return validateElement(paramInputNode, str);
    }
    return validateAttribute(paramInputNode, str);
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Class localClass = this.type.getType();
    String str = this.entry.getValue();
    if (!this.entry.isInline())
    {
      if (str == null)
        str = this.context.getName(localClass);
      writeElement(paramOutputNode, paramObject, str);
      return;
    }
    writeAttribute(paramOutputNode, paramObject, str);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.PrimitiveValue
 * JD-Core Version:    0.6.2
 */
package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class PrimitiveKey
  implements Converter
{
  private final Context context;
  private final Entry entry;
  private final PrimitiveFactory factory;
  private final Primitive root;
  private final Style style;
  private final Type type;

  public PrimitiveKey(Context paramContext, Entry paramEntry, Type paramType)
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
    InputNode localInputNode = paramInputNode.getAttribute(this.style.getAttribute(paramString));
    if (localInputNode == null)
      return null;
    return this.root.read(localInputNode);
  }

  private Object readElement(InputNode paramInputNode, String paramString)
    throws Exception
  {
    InputNode localInputNode = paramInputNode.getNext(this.style.getElement(paramString));
    if (localInputNode == null)
      return null;
    return this.root.read(localInputNode);
  }

  private boolean validateAttribute(InputNode paramInputNode, String paramString)
    throws Exception
  {
    InputNode localInputNode = paramInputNode.getAttribute(this.style.getElement(paramString));
    if (localInputNode == null)
      return true;
    return this.root.validate(localInputNode);
  }

  private boolean validateElement(InputNode paramInputNode, String paramString)
    throws Exception
  {
    InputNode localInputNode = paramInputNode.getNext(this.style.getElement(paramString));
    if (localInputNode == null)
      return true;
    return this.root.validate(localInputNode);
  }

  private void writeAttribute(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Class localClass = this.type.getType();
    String str1 = this.factory.getText(paramObject);
    String str2 = this.entry.getKey();
    if (str2 == null)
      str2 = this.context.getName(localClass);
    String str3 = this.style.getAttribute(str2);
    if (str1 != null)
      paramOutputNode.setAttribute(str3, str1);
  }

  private void writeElement(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Class localClass = this.type.getType();
    String str = this.entry.getKey();
    if (str == null)
      str = this.context.getName(localClass);
    OutputNode localOutputNode = paramOutputNode.getChild(this.style.getElement(str));
    if ((paramObject != null) && (!isOverridden(localOutputNode, paramObject)))
      this.root.write(localOutputNode, paramObject);
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    Class localClass = this.type.getType();
    String str = this.entry.getKey();
    if (str == null)
      str = this.context.getName(localClass);
    if (!this.entry.isAttribute())
      return readElement(paramInputNode, str);
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
      throw new PersistenceException("Can not read key of %s for %s", arrayOfObject);
    }
    return read(paramInputNode);
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    Class localClass = this.type.getType();
    String str = this.entry.getKey();
    if (str == null)
      str = this.context.getName(localClass);
    if (!this.entry.isAttribute())
      return validateElement(paramInputNode, str);
    return validateAttribute(paramInputNode, str);
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    if (!this.entry.isAttribute())
      writeElement(paramOutputNode, paramObject);
    while (paramObject == null)
      return;
    writeAttribute(paramOutputNode, paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.PrimitiveKey
 * JD-Core Version:    0.6.2
 */
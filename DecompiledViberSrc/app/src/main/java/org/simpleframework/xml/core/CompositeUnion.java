package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

class CompositeUnion
  implements Converter
{
  private final Context context;
  private final LabelMap elements;
  private final Group group;
  private final Expression path;
  private final Type type;

  public CompositeUnion(Context paramContext, Group paramGroup, Expression paramExpression, Type paramType)
    throws Exception
  {
    this.elements = paramGroup.getElements();
    this.context = paramContext;
    this.group = paramGroup;
    this.type = paramType;
    this.path = paramExpression;
  }

  private void write(OutputNode paramOutputNode, Object paramObject, Label paramLabel)
    throws Exception
  {
    paramLabel.getConverter(this.context).write(paramOutputNode, paramObject);
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    String str1 = paramInputNode.getName();
    String str2 = this.path.getElement(str1);
    return ((Label)this.elements.get(str2)).getConverter(this.context).read(paramInputNode);
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    String str1 = paramInputNode.getName();
    String str2 = this.path.getElement(str1);
    return ((Label)this.elements.get(str2)).getConverter(this.context).read(paramInputNode, paramObject);
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    String str1 = paramInputNode.getName();
    String str2 = this.path.getElement(str1);
    return ((Label)this.elements.get(str2)).getConverter(this.context).validate(paramInputNode);
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Class localClass = paramObject.getClass();
    Label localLabel = this.group.getLabel(localClass);
    if (localLabel == null)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = localClass;
      arrayOfObject[1] = this.type;
      arrayOfObject[2] = this.group;
      throw new UnionException("Value of %s not declared in %s with annotation %s", arrayOfObject);
    }
    write(paramOutputNode, paramObject, localLabel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.CompositeUnion
 * JD-Core Version:    0.6.2
 */
package org.simpleframework.xml.core;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class CompositeMapUnion
  implements Repeater
{
  private final Context context;
  private final LabelMap elements;
  private final Group group;
  private final Expression path;
  private final Style style;
  private final Type type;

  public CompositeMapUnion(Context paramContext, Group paramGroup, Expression paramExpression, Type paramType)
    throws Exception
  {
    this.elements = paramGroup.getElements();
    this.style = paramContext.getStyle();
    this.context = paramContext;
    this.group = paramGroup;
    this.type = paramType;
    this.path = paramExpression;
  }

  private void write(OutputNode paramOutputNode, Object paramObject1, Object paramObject2, Label paramLabel)
    throws Exception
  {
    Converter localConverter = paramLabel.getConverter(this.context);
    Map localMap = Collections.singletonMap(paramObject1, paramObject2);
    if (!paramLabel.isInline())
    {
      String str1 = paramLabel.getName();
      String str2 = this.style.getElement(str1);
      if (!paramOutputNode.isCommitted())
        paramOutputNode.setName(str2);
    }
    localConverter.write(paramOutputNode, localMap);
  }

  private void write(OutputNode paramOutputNode, Map paramMap)
    throws Exception
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramMap.get(localObject1);
      if (localObject2 != null)
      {
        Class localClass = localObject2.getClass();
        Label localLabel = this.group.getLabel(localClass);
        if (localLabel == null)
        {
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = localClass;
          arrayOfObject[1] = this.type;
          arrayOfObject[2] = this.group;
          throw new UnionException("Value of %s not declared in %s with annotation %s", arrayOfObject);
        }
        write(paramOutputNode, localObject1, localObject2, localLabel);
      }
    }
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
    Map localMap = (Map)paramObject;
    if (this.group.isInline())
    {
      if (!localMap.isEmpty())
        write(paramOutputNode, localMap);
      while (paramOutputNode.isCommitted())
        return;
      paramOutputNode.remove();
      return;
    }
    write(paramOutputNode, localMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.CompositeMapUnion
 * JD-Core Version:    0.6.2
 */
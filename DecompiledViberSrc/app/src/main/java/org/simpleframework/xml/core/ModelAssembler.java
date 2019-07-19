package org.simpleframework.xml.core;

import org.simpleframework.xml.Order;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

class ModelAssembler
{
  private final ExpressionBuilder builder;
  private final Detail detail;
  private final Format format;

  public ModelAssembler(ExpressionBuilder paramExpressionBuilder, Detail paramDetail, Support paramSupport)
    throws Exception
  {
    this.format = paramSupport.getFormat();
    this.builder = paramExpressionBuilder;
    this.detail = paramDetail;
  }

  private void assembleAttributes(Model paramModel, Order paramOrder)
    throws Exception
  {
    String[] arrayOfString = paramOrder.attributes();
    int i = arrayOfString.length;
    int j = 0;
    if (j < i)
    {
      String str = arrayOfString[j];
      Expression localExpression = this.builder.build(str);
      if ((!localExpression.isAttribute()) && (localExpression.isPath()))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localExpression;
        arrayOfObject[1] = this.detail;
        throw new PathException("Ordered attribute '%s' references an element in %s", arrayOfObject);
      }
      if (!localExpression.isPath())
        paramModel.registerAttribute(this.format.getStyle().getAttribute(str));
      while (true)
      {
        j++;
        break;
        registerAttributes(paramModel, localExpression);
      }
    }
  }

  private void assembleElements(Model paramModel, Order paramOrder)
    throws Exception
  {
    for (String str : paramOrder.elements())
    {
      Expression localExpression = this.builder.build(str);
      if (localExpression.isAttribute())
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localExpression;
        arrayOfObject[1] = this.detail;
        throw new PathException("Ordered element '%s' references an attribute in %s", arrayOfObject);
      }
      registerElements(paramModel, localExpression);
    }
  }

  private void registerAttribute(Model paramModel, Expression paramExpression)
    throws Exception
  {
    String str = paramExpression.getFirst();
    if (str != null)
      paramModel.registerAttribute(str);
  }

  private void registerAttributes(Model paramModel, Expression paramExpression)
    throws Exception
  {
    String str1 = paramExpression.getPrefix();
    String str2 = paramExpression.getFirst();
    int i = paramExpression.getIndex();
    if (paramExpression.isPath())
    {
      Model localModel = paramModel.register(str2, str1, i);
      Expression localExpression = paramExpression.getPath(1);
      if (localModel == null)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str2;
        arrayOfObject[1] = this.detail;
        throw new PathException("Element '%s' does not exist in %s", arrayOfObject);
      }
      registerAttributes(localModel, localExpression);
      return;
    }
    registerAttribute(paramModel, paramExpression);
  }

  private void registerElement(Model paramModel, Expression paramExpression)
    throws Exception
  {
    String str1 = paramExpression.getPrefix();
    String str2 = paramExpression.getFirst();
    int i = paramExpression.getIndex();
    if ((i > 1) && (paramModel.lookup(str2, i - 1) == null))
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = str2;
      arrayOfObject[1] = paramExpression;
      arrayOfObject[2] = this.detail;
      throw new PathException("Ordered element '%s' in path '%s' is out of sequence for %s", arrayOfObject);
    }
    paramModel.register(str2, str1, i);
  }

  private void registerElements(Model paramModel, Expression paramExpression)
    throws Exception
  {
    String str1 = paramExpression.getPrefix();
    String str2 = paramExpression.getFirst();
    int i = paramExpression.getIndex();
    if (str2 != null)
    {
      Model localModel = paramModel.register(str2, str1, i);
      Expression localExpression = paramExpression.getPath(1);
      if (paramExpression.isPath())
        registerElements(localModel, localExpression);
    }
    registerElement(paramModel, paramExpression);
  }

  public void assemble(Model paramModel, Order paramOrder)
    throws Exception
  {
    assembleElements(paramModel, paramOrder);
    assembleAttributes(paramModel, paramOrder);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ModelAssembler
 * JD-Core Version:    0.6.2
 */
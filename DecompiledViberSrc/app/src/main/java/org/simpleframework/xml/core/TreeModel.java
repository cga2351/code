package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class TreeModel
  implements Model
{
  private LabelMap attributes;
  private Detail detail;
  private LabelMap elements;
  private Expression expression;
  private int index;
  private Label list;
  private ModelMap models;
  private String name;
  private OrderList order;
  private Policy policy;
  private String prefix;
  private Label text;

  public TreeModel(Policy paramPolicy, Detail paramDetail)
  {
    this(paramPolicy, paramDetail, null, null, 1);
  }

  public TreeModel(Policy paramPolicy, Detail paramDetail, String paramString1, String paramString2, int paramInt)
  {
    this.attributes = new LabelMap(paramPolicy);
    this.elements = new LabelMap(paramPolicy);
    this.models = new ModelMap(paramDetail);
    this.order = new OrderList();
    this.detail = paramDetail;
    this.policy = paramPolicy;
    this.prefix = paramString2;
    this.index = paramInt;
    this.name = paramString1;
  }

  private Model create(String paramString1, String paramString2, int paramInt)
    throws Exception
  {
    TreeModel localTreeModel = new TreeModel(this.policy, this.detail, paramString1, paramString2, paramInt);
    if (paramString1 != null)
    {
      this.models.register(paramString1, localTreeModel);
      this.order.add(paramString1);
    }
    return localTreeModel;
  }

  private void validateAttributes(Class paramClass)
    throws Exception
  {
    Iterator localIterator = this.attributes.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((Label)this.attributes.get(str) == null)
        throw new AttributeException("Ordered attribute '%s' does not exist in %s", new Object[] { str, paramClass });
      if (this.expression != null)
        this.expression.getAttribute(str);
    }
  }

  private void validateElements(Class paramClass)
    throws Exception
  {
    Iterator localIterator = this.elements.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ModelList localModelList = (ModelList)this.models.get(str);
      Label localLabel = (Label)this.elements.get(str);
      if ((localModelList == null) && (localLabel == null))
        throw new ElementException("Ordered element '%s' does not exist in %s", new Object[] { str, paramClass });
      if ((localModelList != null) && (localLabel != null) && (!localModelList.isEmpty()))
        throw new ElementException("Element '%s' is also a path name in %s", new Object[] { str, paramClass });
      if (this.expression != null)
        this.expression.getElement(str);
    }
  }

  private void validateExpression(Label paramLabel)
    throws Exception
  {
    Expression localExpression = paramLabel.getExpression();
    if (this.expression != null)
    {
      String str1 = this.expression.getPath();
      String str2 = localExpression.getPath();
      if (!str1.equals(str2))
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = str1;
        arrayOfObject[1] = str2;
        arrayOfObject[2] = this.detail;
        throw new PathException("Path '%s' does not match '%s' in %s", arrayOfObject);
      }
    }
    else
    {
      this.expression = localExpression;
    }
  }

  private void validateExpressions(Class paramClass)
    throws Exception
  {
    Iterator localIterator1 = this.elements.iterator();
    while (localIterator1.hasNext())
    {
      Label localLabel2 = (Label)localIterator1.next();
      if (localLabel2 != null)
        validateExpression(localLabel2);
    }
    Iterator localIterator2 = this.attributes.iterator();
    while (localIterator2.hasNext())
    {
      Label localLabel1 = (Label)localIterator2.next();
      if (localLabel1 != null)
        validateExpression(localLabel1);
    }
    if (this.text != null)
      validateExpression(this.text);
  }

  private void validateModels(Class paramClass)
    throws Exception
  {
    Iterator localIterator1 = this.models.iterator();
    int i;
    label33: int m;
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ModelList)localIterator1.next()).iterator();
      i = 1;
      if (localIterator2.hasNext())
      {
        Model localModel = (Model)localIterator2.next();
        if (localModel == null)
          break label147;
        String str = localModel.getName();
        int k = localModel.getIndex();
        m = i + 1;
        if (k != i)
        {
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = str;
          arrayOfObject[1] = Integer.valueOf(k);
          arrayOfObject[2] = paramClass;
          throw new ElementException("Path section '%s[%s]' is out of sequence in %s", arrayOfObject);
        }
        localModel.validate(paramClass);
      }
    }
    label147: for (int j = m; ; j = i)
    {
      i = j;
      break label33;
      break;
      return;
    }
  }

  private void validateText(Class paramClass)
    throws Exception
  {
    if (this.text != null)
    {
      if (!this.elements.isEmpty())
      {
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = this.text;
        arrayOfObject2[1] = paramClass;
        throw new TextException("Text annotation %s used with elements in %s", arrayOfObject2);
      }
      if (isComposite())
      {
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = this.text;
        arrayOfObject1[1] = paramClass;
        throw new TextException("Text annotation %s can not be used with paths in %s", arrayOfObject1);
      }
    }
  }

  public LabelMap getAttributes()
    throws Exception
  {
    return this.attributes.getLabels();
  }

  public LabelMap getElements()
    throws Exception
  {
    return this.elements.getLabels();
  }

  public Expression getExpression()
  {
    return this.expression;
  }

  public int getIndex()
  {
    return this.index;
  }

  public ModelMap getModels()
    throws Exception
  {
    return this.models.getModels();
  }

  public String getName()
  {
    return this.name;
  }

  public String getPrefix()
  {
    return this.prefix;
  }

  public Label getText()
  {
    if (this.list != null)
      return this.list;
    return this.text;
  }

  public boolean isAttribute(String paramString)
  {
    return this.attributes.containsKey(paramString);
  }

  public boolean isComposite()
  {
    Model localModel;
    do
    {
      Iterator localIterator1 = this.models.iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext())
          break;
        localIterator2 = ((ModelList)localIterator1.next()).iterator();
      }
      localModel = (Model)localIterator2.next();
    }
    while ((localModel == null) || (localModel.isEmpty()));
    return true;
    if (!this.models.isEmpty());
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean isElement(String paramString)
  {
    return this.elements.containsKey(paramString);
  }

  public boolean isEmpty()
  {
    if (this.text != null);
    while ((!this.elements.isEmpty()) || (!this.attributes.isEmpty()) || (isComposite()))
      return false;
    return true;
  }

  public boolean isModel(String paramString)
  {
    return this.models.containsKey(paramString);
  }

  public Iterator<String> iterator()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.order.iterator();
    while (localIterator.hasNext())
      localArrayList.add((String)localIterator.next());
    return localArrayList.iterator();
  }

  public Model lookup(String paramString, int paramInt)
  {
    return this.models.lookup(paramString, paramInt);
  }

  public Model lookup(Expression paramExpression)
  {
    Model localModel = lookup(paramExpression.getFirst(), paramExpression.getIndex());
    if (paramExpression.isPath())
    {
      Expression localExpression = paramExpression.getPath(1, 0);
      if (localModel != null)
        localModel = localModel.lookup(localExpression);
    }
    return localModel;
  }

  public Model register(String paramString1, String paramString2, int paramInt)
    throws Exception
  {
    Model localModel = this.models.lookup(paramString1, paramInt);
    if (localModel == null)
      localModel = create(paramString1, paramString2, paramInt);
    return localModel;
  }

  public void register(Label paramLabel)
    throws Exception
  {
    if (paramLabel.isAttribute())
    {
      registerAttribute(paramLabel);
      return;
    }
    if (paramLabel.isText())
    {
      registerText(paramLabel);
      return;
    }
    registerElement(paramLabel);
  }

  public void registerAttribute(String paramString)
    throws Exception
  {
    this.attributes.put(paramString, null);
  }

  public void registerAttribute(Label paramLabel)
    throws Exception
  {
    String str = paramLabel.getName();
    if (this.attributes.get(str) != null)
      throw new AttributeException("Duplicate annotation of name '%s' on %s", new Object[] { str, paramLabel });
    this.attributes.put(str, paramLabel);
  }

  public void registerElement(String paramString)
    throws Exception
  {
    if (!this.order.contains(paramString))
      this.order.add(paramString);
    this.elements.put(paramString, null);
  }

  public void registerElement(Label paramLabel)
    throws Exception
  {
    String str = paramLabel.getName();
    if (this.elements.get(str) != null)
      throw new ElementException("Duplicate annotation of name '%s' on %s", new Object[] { str, paramLabel });
    if (!this.order.contains(str))
      this.order.add(str);
    if (paramLabel.isTextList())
      this.list = paramLabel;
    this.elements.put(str, paramLabel);
  }

  public void registerText(Label paramLabel)
    throws Exception
  {
    if (this.text != null)
      throw new TextException("Duplicate text annotation on %s", new Object[] { paramLabel });
    this.text = paramLabel;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.name;
    arrayOfObject[1] = Integer.valueOf(this.index);
    return String.format("model '%s[%s]'", arrayOfObject);
  }

  public void validate(Class paramClass)
    throws Exception
  {
    validateExpressions(paramClass);
    validateAttributes(paramClass);
    validateElements(paramClass);
    validateModels(paramClass);
    validateText(paramClass);
  }

  private static class OrderList extends ArrayList<String>
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.TreeModel
 * JD-Core Version:    0.6.2
 */
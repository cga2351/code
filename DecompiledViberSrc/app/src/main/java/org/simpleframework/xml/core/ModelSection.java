package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ModelSection
  implements Section
{
  private LabelMap attributes;
  private LabelMap elements;
  private Model model;
  private ModelMap models;

  public ModelSection(Model paramModel)
  {
    this.model = paramModel;
  }

  public String getAttribute(String paramString)
    throws Exception
  {
    Expression localExpression = this.model.getExpression();
    if (localExpression == null)
      return paramString;
    return localExpression.getAttribute(paramString);
  }

  public LabelMap getAttributes()
    throws Exception
  {
    if (this.attributes == null)
      this.attributes = this.model.getAttributes();
    return this.attributes;
  }

  public Label getElement(String paramString)
    throws Exception
  {
    return getElements().getLabel(paramString);
  }

  public LabelMap getElements()
    throws Exception
  {
    if (this.elements == null)
      this.elements = this.model.getElements();
    return this.elements;
  }

  public ModelMap getModels()
    throws Exception
  {
    if (this.models == null)
      this.models = this.model.getModels();
    return this.models;
  }

  public String getName()
  {
    return this.model.getName();
  }

  public String getPath(String paramString)
    throws Exception
  {
    Expression localExpression = this.model.getExpression();
    if (localExpression == null)
      return paramString;
    return localExpression.getElement(paramString);
  }

  public String getPrefix()
  {
    return this.model.getPrefix();
  }

  public Section getSection(String paramString)
    throws Exception
  {
    ModelList localModelList = (ModelList)getModels().get(paramString);
    if (localModelList != null)
    {
      Model localModel = localModelList.take();
      if (localModel != null)
        return new ModelSection(localModel);
    }
    return null;
  }

  public Label getText()
    throws Exception
  {
    return this.model.getText();
  }

  public boolean isSection(String paramString)
    throws Exception
  {
    return getModels().get(paramString) != null;
  }

  public Iterator<String> iterator()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.model.iterator();
    while (localIterator.hasNext())
      localArrayList.add((String)localIterator.next());
    return localArrayList.iterator();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ModelSection
 * JD-Core Version:    0.6.2
 */
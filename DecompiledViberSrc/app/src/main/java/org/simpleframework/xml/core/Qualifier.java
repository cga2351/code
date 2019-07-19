package org.simpleframework.xml.core;

import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.stream.OutputNode;

class Qualifier
  implements Decorator
{
  private NamespaceDecorator decorator = new NamespaceDecorator();

  public Qualifier(Contact paramContact)
  {
    scan(paramContact);
  }

  private void namespace(Contact paramContact)
  {
    Namespace localNamespace = (Namespace)paramContact.getAnnotation(Namespace.class);
    if (localNamespace != null)
    {
      this.decorator.set(localNamespace);
      this.decorator.add(localNamespace);
    }
  }

  private void scan(Contact paramContact)
  {
    namespace(paramContact);
    scope(paramContact);
  }

  private void scope(Contact paramContact)
  {
    NamespaceList localNamespaceList = (NamespaceList)paramContact.getAnnotation(NamespaceList.class);
    if (localNamespaceList != null)
      for (Namespace localNamespace : localNamespaceList.value())
        this.decorator.add(localNamespace);
  }

  public void decorate(OutputNode paramOutputNode)
  {
    this.decorator.decorate(paramOutputNode);
  }

  public void decorate(OutputNode paramOutputNode, Decorator paramDecorator)
  {
    this.decorator.decorate(paramOutputNode, paramDecorator);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Qualifier
 * JD-Core Version:    0.6.2
 */
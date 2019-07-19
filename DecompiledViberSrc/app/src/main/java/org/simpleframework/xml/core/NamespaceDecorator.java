package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.stream.NamespaceMap;
import org.simpleframework.xml.stream.OutputNode;

class NamespaceDecorator
  implements Decorator
{
  private Namespace primary;
  private List<Namespace> scope = new ArrayList();

  private void namespace(OutputNode paramOutputNode)
  {
    if (this.primary != null)
      paramOutputNode.setReference(this.primary.reference());
  }

  private void scope(OutputNode paramOutputNode)
  {
    NamespaceMap localNamespaceMap = paramOutputNode.getNamespaces();
    Iterator localIterator = this.scope.iterator();
    while (localIterator.hasNext())
    {
      Namespace localNamespace = (Namespace)localIterator.next();
      localNamespaceMap.setReference(localNamespace.reference(), localNamespace.prefix());
    }
  }

  public void add(Namespace paramNamespace)
  {
    this.scope.add(paramNamespace);
  }

  public void decorate(OutputNode paramOutputNode)
  {
    decorate(paramOutputNode, null);
  }

  public void decorate(OutputNode paramOutputNode, Decorator paramDecorator)
  {
    if (paramDecorator != null)
      paramDecorator.decorate(paramOutputNode);
    scope(paramOutputNode);
    namespace(paramOutputNode);
  }

  public void set(Namespace paramNamespace)
  {
    if (paramNamespace != null)
      add(paramNamespace);
    this.primary = paramNamespace;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.NamespaceDecorator
 * JD-Core Version:    0.6.2
 */
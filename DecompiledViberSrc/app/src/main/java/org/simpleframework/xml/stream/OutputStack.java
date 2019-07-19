package org.simpleframework.xml.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

class OutputStack extends ArrayList<OutputNode>
{
  private final Set active;

  public OutputStack(Set paramSet)
  {
    this.active = paramSet;
  }

  public OutputNode bottom()
  {
    if (size() <= 0)
      return null;
    return (OutputNode)get(0);
  }

  public Iterator<OutputNode> iterator()
  {
    return new Sequence();
  }

  public OutputNode pop()
  {
    int i = size();
    if (i <= 0)
      return null;
    return purge(i - 1);
  }

  public OutputNode purge(int paramInt)
  {
    OutputNode localOutputNode = (OutputNode)remove(paramInt);
    if (localOutputNode != null)
      this.active.remove(localOutputNode);
    return localOutputNode;
  }

  public OutputNode push(OutputNode paramOutputNode)
  {
    this.active.add(paramOutputNode);
    add(paramOutputNode);
    return paramOutputNode;
  }

  public OutputNode top()
  {
    int i = size();
    if (i <= 0)
      return null;
    return (OutputNode)get(i - 1);
  }

  private class Sequence
    implements Iterator<OutputNode>
  {
    private int cursor = OutputStack.this.size();

    public Sequence()
    {
    }

    public boolean hasNext()
    {
      return this.cursor > 0;
    }

    public OutputNode next()
    {
      if (hasNext())
      {
        OutputStack localOutputStack = OutputStack.this;
        int i = -1 + this.cursor;
        this.cursor = i;
        return (OutputNode)localOutputStack.get(i);
      }
      return null;
    }

    public void remove()
    {
      OutputStack.this.purge(this.cursor);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.OutputStack
 * JD-Core Version:    0.6.2
 */
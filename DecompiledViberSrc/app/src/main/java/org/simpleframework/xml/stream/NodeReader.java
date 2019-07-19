package org.simpleframework.xml.stream;

class NodeReader
{
  private final EventReader reader;
  private final InputStack stack = new InputStack();
  private final StringBuilder text = new StringBuilder();

  public NodeReader(EventReader paramEventReader)
  {
    this.reader = paramEventReader;
  }

  private void fillText(InputNode paramInputNode)
    throws Exception
  {
    EventNode localEventNode = this.reader.peek();
    if (localEventNode.isText())
    {
      String str = localEventNode.getValue();
      this.text.append(str);
    }
  }

  private boolean isName(EventNode paramEventNode, String paramString)
  {
    String str = paramEventNode.getName();
    if (str == null)
      return false;
    return str.equals(paramString);
  }

  private String readBuffer(InputNode paramInputNode)
    throws Exception
  {
    if (this.text.length() > 0)
    {
      String str = this.text.toString();
      this.text.setLength(0);
      return str;
    }
    return null;
  }

  private InputNode readStart(InputNode paramInputNode, EventNode paramEventNode)
    throws Exception
  {
    Object localObject = new InputElement(paramInputNode, this, paramEventNode);
    if (this.text.length() > 0)
      this.text.setLength(0);
    if (paramEventNode.isStart())
      localObject = (InputNode)this.stack.push(localObject);
    return localObject;
  }

  private String readText(InputNode paramInputNode)
    throws Exception
  {
    for (EventNode localEventNode = this.reader.peek(); (this.stack.top() == paramInputNode) && (localEventNode.isText()); localEventNode = this.reader.peek())
    {
      fillText(paramInputNode);
      this.reader.next();
    }
    return readBuffer(paramInputNode);
  }

  public boolean isEmpty(InputNode paramInputNode)
    throws Exception
  {
    return (this.stack.top() == paramInputNode) && (this.reader.peek().isEnd());
  }

  public boolean isRoot(InputNode paramInputNode)
  {
    return this.stack.bottom() == paramInputNode;
  }

  public InputNode readElement(InputNode paramInputNode)
    throws Exception
  {
    if (!this.stack.isRelevant(paramInputNode));
    EventNode localEventNode;
    label23: 
    do
    {
      return null;
      localEventNode = this.reader.next();
      if (localEventNode == null)
        break;
      if (!localEventNode.isEnd())
        break label60;
    }
    while (this.stack.pop() == paramInputNode);
    label60: 
    while (!localEventNode.isStart())
    {
      localEventNode = this.reader.next();
      break label23;
      break;
    }
    return readStart(paramInputNode, localEventNode);
  }

  public InputNode readElement(InputNode paramInputNode, String paramString)
    throws Exception
  {
    if (!this.stack.isRelevant(paramInputNode));
    EventNode localEventNode;
    label23: label64: label95: 
    do
    {
      return null;
      localEventNode = this.reader.peek();
      if (localEventNode != null)
      {
        if (!localEventNode.isText())
          break label64;
        fillText(paramInputNode);
      }
      do
        while (true)
        {
          this.reader.next();
          localEventNode = this.reader.peek();
          break label23;
          break;
          if (!localEventNode.isEnd())
            break label95;
          if (this.stack.top() == paramInputNode)
            break;
          this.stack.pop();
        }
      while (!localEventNode.isStart());
    }
    while (!isName(localEventNode, paramString));
    return readElement(paramInputNode);
  }

  public InputNode readRoot()
    throws Exception
  {
    boolean bool = this.stack.isEmpty();
    InputNode localInputNode = null;
    if (bool)
    {
      localInputNode = readElement(null);
      if (localInputNode == null)
        throw new NodeException("Document has no root element");
    }
    return localInputNode;
  }

  public String readValue(InputNode paramInputNode)
    throws Exception
  {
    if (!this.stack.isRelevant(paramInputNode));
    do
    {
      return null;
      if ((this.text.length() > 0) || (!this.reader.peek().isEnd()))
        break;
    }
    while (this.stack.top() == paramInputNode);
    this.stack.pop();
    this.reader.next();
    return readText(paramInputNode);
  }

  public void skipElement(InputNode paramInputNode)
    throws Exception
  {
    while (readElement(paramInputNode) != null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.NodeReader
 * JD-Core Version:    0.6.2
 */
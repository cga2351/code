package org.simpleframework.xml.stream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

class DocumentReader
  implements EventReader
{
  private static final String RESERVED = "xml";
  private EventNode peek;
  private NodeExtractor queue;
  private NodeStack stack;

  public DocumentReader(Document paramDocument)
  {
    this.queue = new NodeExtractor(paramDocument);
    this.stack = new NodeStack();
    this.stack.push(paramDocument);
  }

  private Entry attribute(Node paramNode)
  {
    return new Entry(paramNode);
  }

  private Start build(Start paramStart)
  {
    NamedNodeMap localNamedNodeMap = paramStart.getAttributes();
    int i = localNamedNodeMap.getLength();
    for (int j = 0; j < i; j++)
    {
      Entry localEntry = attribute(localNamedNodeMap.item(j));
      if (!localEntry.isReserved())
        paramStart.add(localEntry);
    }
    return paramStart;
  }

  private EventNode convert(Node paramNode)
    throws Exception
  {
    if (paramNode.getNodeType() == 1)
    {
      if (paramNode != null)
        this.stack.push(paramNode);
      return start(paramNode);
    }
    return text(paramNode);
  }

  private End end()
  {
    return new End(null);
  }

  private EventNode read()
    throws Exception
  {
    Node localNode = (Node)this.queue.peek();
    if (localNode == null)
      return end();
    return read(localNode);
  }

  private EventNode read(Node paramNode)
    throws Exception
  {
    Node localNode1 = paramNode.getParentNode();
    Node localNode2 = (Node)this.stack.top();
    if (localNode1 != localNode2)
    {
      if (localNode2 != null)
        this.stack.pop();
      return end();
    }
    if (paramNode != null)
      this.queue.poll();
    return convert(paramNode);
  }

  private Start start(Node paramNode)
  {
    Start localStart = new Start(paramNode);
    if (localStart.isEmpty())
      localStart = build(localStart);
    return localStart;
  }

  private Text text(Node paramNode)
  {
    return new Text(paramNode);
  }

  public EventNode next()
    throws Exception
  {
    EventNode localEventNode = this.peek;
    if (localEventNode == null)
      return read();
    this.peek = null;
    return localEventNode;
  }

  public EventNode peek()
    throws Exception
  {
    if (this.peek == null)
      this.peek = next();
    return this.peek;
  }

  private static class End extends EventToken
  {
    public boolean isEnd()
    {
      return true;
    }
  }

  private static class Entry extends EventAttribute
  {
    private final Node node;

    public Entry(Node paramNode)
    {
      this.node = paramNode;
    }

    public String getName()
    {
      return this.node.getLocalName();
    }

    public String getPrefix()
    {
      return this.node.getPrefix();
    }

    public String getReference()
    {
      return this.node.getNamespaceURI();
    }

    public Object getSource()
    {
      return this.node;
    }

    public String getValue()
    {
      return this.node.getNodeValue();
    }

    public boolean isReserved()
    {
      String str1 = getPrefix();
      String str2 = getName();
      if (str1 != null)
        return str1.startsWith("xml");
      return str2.startsWith("xml");
    }
  }

  private static class Start extends EventElement
  {
    private final Element element;

    public Start(Node paramNode)
    {
      this.element = ((Element)paramNode);
    }

    public NamedNodeMap getAttributes()
    {
      return this.element.getAttributes();
    }

    public String getName()
    {
      return this.element.getLocalName();
    }

    public String getPrefix()
    {
      return this.element.getPrefix();
    }

    public String getReference()
    {
      return this.element.getNamespaceURI();
    }

    public Object getSource()
    {
      return this.element;
    }
  }

  private static class Text extends EventToken
  {
    private final Node node;

    public Text(Node paramNode)
    {
      this.node = paramNode;
    }

    public Object getSource()
    {
      return this.node;
    }

    public String getValue()
    {
      return this.node.getNodeValue();
    }

    public boolean isText()
    {
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.DocumentReader
 * JD-Core Version:    0.6.2
 */
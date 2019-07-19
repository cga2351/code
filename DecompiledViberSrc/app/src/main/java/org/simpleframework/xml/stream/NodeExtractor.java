package org.simpleframework.xml.stream;

import java.util.LinkedList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class NodeExtractor extends LinkedList<Node>
{
  public NodeExtractor(Document paramDocument)
  {
    extract(paramDocument);
  }

  private void extract(Document paramDocument)
  {
    Element localElement = paramDocument.getDocumentElement();
    if (localElement != null)
    {
      offer(localElement);
      extract(localElement);
    }
  }

  private void extract(Node paramNode)
  {
    NodeList localNodeList = paramNode.getChildNodes();
    int i = localNodeList.getLength();
    for (int j = 0; j < i; j++)
    {
      Node localNode = localNodeList.item(j);
      if (localNode.getNodeType() != 8)
      {
        offer(localNode);
        extract(localNode);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.NodeExtractor
 * JD-Core Version:    0.6.2
 */
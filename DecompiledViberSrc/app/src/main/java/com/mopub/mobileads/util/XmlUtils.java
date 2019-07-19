package com.mopub.mobileads.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtils
{
  public static String getAttributeValue(Node paramNode, String paramString)
  {
    if ((paramNode == null) || (paramString == null));
    Node localNode;
    do
    {
      return null;
      localNode = paramNode.getAttributes().getNamedItem(paramString);
    }
    while (localNode == null);
    return localNode.getNodeValue();
  }

  public static Integer getAttributeValueAsInt(Node paramNode, String paramString)
  {
    if ((paramNode == null) || (paramString == null))
      return null;
    try
    {
      Integer localInteger = Integer.valueOf(Integer.parseInt(getAttributeValue(paramNode, paramString)));
      return localInteger;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return null;
  }

  public static <T> T getFirstMatchFromDocument(Document paramDocument, String paramString1, String paramString2, String paramString3, NodeProcessor<T> paramNodeProcessor)
  {
    int i = 0;
    if (paramDocument == null);
    while (true)
    {
      return null;
      NodeList localNodeList = paramDocument.getElementsByTagName(paramString1);
      if (localNodeList != null)
      {
        List localList;
        if (paramString3 == null)
          localList = null;
        while (i < localNodeList.getLength())
        {
          Node localNode = localNodeList.item(i);
          if ((localNode != null) && (nodeMatchesAttributeFilter(localNode, paramString2, localList)))
          {
            Object localObject = paramNodeProcessor.process(localNode);
            if (localObject != null)
            {
              return localObject;
              localList = Arrays.asList(new String[] { paramString3 });
              i = 0;
            }
          }
          else
          {
            i++;
          }
        }
      }
    }
  }

  public static Node getFirstMatchingChildNode(Node paramNode, String paramString)
  {
    return getFirstMatchingChildNode(paramNode, paramString, null, null);
  }

  public static Node getFirstMatchingChildNode(Node paramNode, String paramString1, String paramString2, List<String> paramList)
  {
    if ((paramNode == null) || (paramString1 == null));
    List localList;
    do
    {
      return null;
      localList = getMatchingChildNodes(paramNode, paramString1, paramString2, paramList);
    }
    while ((localList == null) || (localList.isEmpty()));
    return (Node)localList.get(0);
  }

  public static String getFirstMatchingStringData(Document paramDocument, String paramString)
  {
    return getFirstMatchingStringData(paramDocument, paramString, null, null);
  }

  public static String getFirstMatchingStringData(Document paramDocument, String paramString1, String paramString2, String paramString3)
  {
    return (String)getFirstMatchFromDocument(paramDocument, paramString1, paramString2, paramString3, new NodeProcessor()
    {
      public String process(Node paramAnonymousNode)
      {
        return XmlUtils.getNodeValue(paramAnonymousNode);
      }
    });
  }

  public static <T> List<T> getListFromDocument(Document paramDocument, String paramString1, String paramString2, String paramString3, NodeProcessor<T> paramNodeProcessor)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    if (paramDocument == null)
      return localArrayList;
    NodeList localNodeList = paramDocument.getElementsByTagName(paramString1);
    if (localNodeList == null)
      return localArrayList;
    List localList;
    if (paramString3 == null)
      localList = null;
    while (i < localNodeList.getLength())
    {
      Node localNode = localNodeList.item(i);
      if ((localNode != null) && (nodeMatchesAttributeFilter(localNode, paramString2, localList)))
      {
        Object localObject = paramNodeProcessor.process(localNode);
        if (localObject != null)
          localArrayList.add(localObject);
      }
      i++;
      continue;
      localList = Arrays.asList(new String[] { paramString3 });
      i = 0;
    }
    return localArrayList;
  }

  public static List<Node> getMatchingChildNodes(Node paramNode, String paramString)
  {
    return getMatchingChildNodes(paramNode, paramString, null, null);
  }

  public static List<Node> getMatchingChildNodes(Node paramNode, String paramString1, String paramString2, List<String> paramList)
  {
    if ((paramNode == null) || (paramString1 == null))
      return null;
    ArrayList localArrayList = new ArrayList();
    NodeList localNodeList = paramNode.getChildNodes();
    for (int i = 0; i < localNodeList.getLength(); i++)
    {
      Node localNode = localNodeList.item(i);
      if ((localNode.getNodeName().equals(paramString1)) && (nodeMatchesAttributeFilter(localNode, paramString2, paramList)))
        localArrayList.add(localNode);
    }
    return localArrayList;
  }

  public static String getNodeValue(Node paramNode)
  {
    if ((paramNode != null) && (paramNode.getFirstChild() != null) && (paramNode.getFirstChild().getNodeValue() != null))
      return paramNode.getFirstChild().getNodeValue().trim();
    return null;
  }

  public static List<Node> getNodesWithElementAndAttribute(Document paramDocument, String paramString1, String paramString2, String paramString3)
  {
    return getListFromDocument(paramDocument, paramString1, paramString2, paramString3, new NodeProcessor()
    {
      public Node process(Node paramAnonymousNode)
      {
        return paramAnonymousNode;
      }
    });
  }

  public static List<String> getStringDataAsList(Document paramDocument, String paramString)
  {
    return getStringDataAsList(paramDocument, paramString, null, null);
  }

  public static List<String> getStringDataAsList(Document paramDocument, String paramString1, String paramString2, String paramString3)
  {
    return getListFromDocument(paramDocument, paramString1, paramString2, paramString3, new NodeProcessor()
    {
      public String process(Node paramAnonymousNode)
      {
        return XmlUtils.getNodeValue(paramAnonymousNode);
      }
    });
  }

  public static boolean nodeMatchesAttributeFilter(Node paramNode, String paramString, List<String> paramList)
  {
    if ((paramString == null) || (paramList == null));
    Node localNode;
    do
    {
      return true;
      NamedNodeMap localNamedNodeMap = paramNode.getAttributes();
      if (localNamedNodeMap == null)
        break;
      localNode = localNamedNodeMap.getNamedItem(paramString);
    }
    while ((localNode != null) && (paramList.contains(localNode.getNodeValue())));
    return false;
  }

  public static abstract interface NodeProcessor<T>
  {
    public abstract T process(Node paramNode);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.util.XmlUtils
 * JD-Core Version:    0.6.2
 */
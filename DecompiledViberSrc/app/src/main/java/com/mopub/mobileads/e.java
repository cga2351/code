package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.w3c.dom.Node;

class e
{
  private final List<Node> a;

  e(List<Node> paramList)
  {
    Preconditions.checkNotNull(paramList);
    this.a = paramList;
  }

  private String a(Node paramNode)
  {
    if ((paramNode == null) || (!paramNode.hasAttributes()))
      return null;
    String str1 = XmlUtils.getAttributeValue(paramNode, "id");
    String str2 = XmlUtils.getNodeValue(paramNode);
    return String.format(Locale.US, "<ViewableImpression id=\"%s\"><![CDATA[%s]]</ViewableImpression>", new Object[] { str1, str2 });
  }

  Set<String> a()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Node localNode = (Node)localIterator.next();
      if (localNode != null)
      {
        String str = a(XmlUtils.getFirstMatchingChildNode(localNode, "ViewableImpression"));
        if (str != null)
          localHashSet.add(str);
      }
    }
    return localHashSet;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.e
 * JD-Core Version:    0.6.2
 */
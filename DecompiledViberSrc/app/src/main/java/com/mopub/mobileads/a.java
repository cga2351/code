package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.w3c.dom.Node;

class a
{
  private final Node a;

  a(Node paramNode)
  {
    Preconditions.checkNotNull(paramNode);
    this.a = paramNode;
  }

  Set<String> a()
  {
    HashSet localHashSet = new HashSet();
    Node localNode1 = XmlUtils.getFirstMatchingChildNode(this.a, "AdVerifications");
    if (localNode1 == null)
      return localHashSet;
    List localList = XmlUtils.getMatchingChildNodes(localNode1, "Verification");
    if (localList == null)
      return localHashSet;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      Node localNode2 = XmlUtils.getFirstMatchingChildNode((Node)localIterator.next(), "JavaScriptResource");
      if (localNode2 != null)
        localHashSet.add(XmlUtils.getNodeValue(localNode2));
    }
    return localHashSet;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.a
 * JD-Core Version:    0.6.2
 */
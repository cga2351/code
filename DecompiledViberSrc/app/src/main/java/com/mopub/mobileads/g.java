package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;

abstract class g
{
  protected final Node a;

  g(Node paramNode)
  {
    Preconditions.checkNotNull(paramNode);
    this.a = paramNode;
  }

  List<VastTracker> a()
  {
    List localList = XmlUtils.getMatchingChildNodes(this.a, "Impression");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      String str = XmlUtils.getNodeValue((Node)localIterator.next());
      if (!TextUtils.isEmpty(str))
        localArrayList.add(new VastTracker(str));
    }
    return localArrayList;
  }

  List<VastTracker> b()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = XmlUtils.getMatchingChildNodes(this.a, "Error");
    if (localList == null)
      return localArrayList;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      String str = XmlUtils.getNodeValue((Node)localIterator.next());
      if (!TextUtils.isEmpty(str))
        localArrayList.add(new VastTracker(str, true));
    }
    return localArrayList;
  }

  List<k> c()
  {
    ArrayList localArrayList = new ArrayList();
    Node localNode1 = XmlUtils.getFirstMatchingChildNode(this.a, "Creatives");
    if (localNode1 == null)
      return localArrayList;
    List localList = XmlUtils.getMatchingChildNodes(localNode1, "Creative");
    if (localList == null)
      return localArrayList;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      Node localNode2 = XmlUtils.getFirstMatchingChildNode((Node)localIterator.next(), "Linear");
      if (localNode2 != null)
        localArrayList.add(new k(localNode2));
    }
    return localArrayList;
  }

  List<h> d()
  {
    ArrayList localArrayList = new ArrayList();
    Node localNode1 = XmlUtils.getFirstMatchingChildNode(this.a, "Creatives");
    if (localNode1 == null)
      return localArrayList;
    List localList1 = XmlUtils.getMatchingChildNodes(localNode1, "Creative");
    if (localList1 == null)
      return localArrayList;
    Iterator localIterator1 = localList1.iterator();
    while (localIterator1.hasNext())
    {
      Node localNode2 = XmlUtils.getFirstMatchingChildNode((Node)localIterator1.next(), "CompanionAds");
      if (localNode2 != null)
      {
        List localList2 = XmlUtils.getMatchingChildNodes(localNode2, "Companion");
        if (localList2 != null)
        {
          Iterator localIterator2 = localList2.iterator();
          while (localIterator2.hasNext())
            localArrayList.add(new h((Node)localIterator2.next()));
        }
      }
    }
    return localArrayList;
  }

  VastExtensionParentXmlManager e()
  {
    Node localNode = XmlUtils.getFirstMatchingChildNode(this.a, "Extensions");
    if (localNode == null)
      return null;
    return new VastExtensionParentXmlManager(localNode);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.g
 * JD-Core Version:    0.6.2
 */
package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;

class h
{
  private final Node a;
  private final VastResourceXmlManager b;

  h(Node paramNode)
  {
    Preconditions.checkNotNull(paramNode, "companionNode cannot be null");
    this.a = paramNode;
    this.b = new VastResourceXmlManager(paramNode);
  }

  Integer a()
  {
    return XmlUtils.getAttributeValueAsInt(this.a, "width");
  }

  Integer b()
  {
    return XmlUtils.getAttributeValueAsInt(this.a, "height");
  }

  String c()
  {
    return XmlUtils.getAttributeValue(this.a, "adSlotID");
  }

  VastResourceXmlManager d()
  {
    return this.b;
  }

  String e()
  {
    return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.a, "CompanionClickThrough"));
  }

  List<VastTracker> f()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = XmlUtils.getMatchingChildNodes(this.a, "CompanionClickTracking");
    if (localList == null)
      return localArrayList;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      String str = XmlUtils.getNodeValue((Node)localIterator.next());
      if (!TextUtils.isEmpty(str))
        localArrayList.add(new VastTracker(str));
    }
    return localArrayList;
  }

  List<VastTracker> g()
  {
    ArrayList localArrayList = new ArrayList();
    Node localNode = XmlUtils.getFirstMatchingChildNode(this.a, "TrackingEvents");
    if (localNode == null)
      return localArrayList;
    Iterator localIterator = XmlUtils.getMatchingChildNodes(localNode, "Tracking", "event", Collections.singletonList("creativeView")).iterator();
    while (localIterator.hasNext())
    {
      String str = XmlUtils.getNodeValue((Node)localIterator.next());
      if (str != null)
        localArrayList.add(new VastTracker(str));
    }
    return localArrayList;
  }

  boolean h()
  {
    return (!TextUtils.isEmpty(this.b.a())) || (!TextUtils.isEmpty(this.b.d())) || (!TextUtils.isEmpty(this.b.c()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.h
 * JD-Core Version:    0.6.2
 */
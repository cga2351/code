package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

class f
{
  private final Node a;

  f(Node paramNode)
  {
    Preconditions.checkNotNull(paramNode);
    this.a = paramNode;
  }

  j a()
  {
    Node localNode = XmlUtils.getFirstMatchingChildNode(this.a, "InLine");
    j localj = null;
    if (localNode != null)
      localj = new j(localNode);
    return localj;
  }

  p b()
  {
    Node localNode = XmlUtils.getFirstMatchingChildNode(this.a, "Wrapper");
    p localp = null;
    if (localNode != null)
      localp = new p(localNode);
    return localp;
  }

  String c()
  {
    return XmlUtils.getAttributeValue(this.a, "sequence");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.f
 * JD-Core Version:    0.6.2
 */
package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

class p extends g
{
  p(Node paramNode)
  {
    super(paramNode);
    Preconditions.checkNotNull(paramNode);
  }

  String f()
  {
    return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.a, "VASTAdTagURI"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.p
 * JD-Core Version:    0.6.2
 */
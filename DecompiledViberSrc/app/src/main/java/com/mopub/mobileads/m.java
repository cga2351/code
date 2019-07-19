package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

class m
{
  private final Node a;

  m(Node paramNode)
  {
    Preconditions.checkNotNull(paramNode, "mediaNode cannot be null");
    this.a = paramNode;
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
    return XmlUtils.getAttributeValue(this.a, "type");
  }

  String d()
  {
    return XmlUtils.getNodeValue(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.m
 * JD-Core Version:    0.6.2
 */
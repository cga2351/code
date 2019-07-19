package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import org.w3c.dom.Node;

public class VastResourceXmlManager
{
  public static final String CREATIVE_TYPE = "creativeType";
  public static final String HTML_RESOURCE = "HTMLResource";
  public static final String IFRAME_RESOURCE = "IFrameResource";
  public static final String STATIC_RESOURCE = "StaticResource";
  private final Node a;

  VastResourceXmlManager(Node paramNode)
  {
    Preconditions.checkNotNull(paramNode);
    this.a = paramNode;
  }

  String a()
  {
    return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.a, "StaticResource"));
  }

  String b()
  {
    String str = XmlUtils.getAttributeValue(XmlUtils.getFirstMatchingChildNode(this.a, "StaticResource"), "creativeType");
    if (str != null)
      return str.toLowerCase();
    return null;
  }

  String c()
  {
    return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.a, "IFrameResource"));
  }

  String d()
  {
    return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.a, "HTMLResource"));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastResourceXmlManager
 * JD-Core Version:    0.6.2
 */
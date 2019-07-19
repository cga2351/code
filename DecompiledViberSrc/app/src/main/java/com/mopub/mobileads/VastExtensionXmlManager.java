package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.w3c.dom.Node;

public class VastExtensionXmlManager
{
  public static final String AD_VERIFICATIONS = "AdVerifications";
  public static final String AVID = "AVID";
  public static final String ID = "id";
  public static final String MOAT = "Moat";
  public static final String TYPE = "type";
  public static final String VENDOR = "vendor";
  public static final String VERIFICATION = "Verification";
  public static final String VIDEO_VIEWABILITY_TRACKER = "MoPubViewabilityTracker";
  private final Node a;

  public VastExtensionXmlManager(Node paramNode)
  {
    Preconditions.checkNotNull(paramNode);
    this.a = paramNode;
  }

  VideoViewabilityTracker a()
  {
    Node localNode = XmlUtils.getFirstMatchingChildNode(this.a, "MoPubViewabilityTracker");
    if (localNode == null);
    Integer localInteger1;
    Integer localInteger2;
    String str;
    do
    {
      return null;
      VideoViewabilityTrackerXmlManager localVideoViewabilityTrackerXmlManager = new VideoViewabilityTrackerXmlManager(localNode);
      localInteger1 = localVideoViewabilityTrackerXmlManager.a();
      localInteger2 = localVideoViewabilityTrackerXmlManager.b();
      str = localVideoViewabilityTrackerXmlManager.c();
    }
    while ((localInteger1 == null) || (localInteger2 == null) || (TextUtils.isEmpty(str)));
    return new VideoViewabilityTracker(localInteger1.intValue(), localInteger2.intValue(), str);
  }

  Set<String> b()
  {
    Node localNode = XmlUtils.getFirstMatchingChildNode(this.a, "AVID");
    if (localNode == null)
      return null;
    return new a(localNode).a();
  }

  Set<String> c()
  {
    Node localNode = XmlUtils.getFirstMatchingChildNode(this.a, "AdVerifications");
    if (localNode == null);
    List localList;
    do
    {
      return null;
      localList = XmlUtils.getMatchingChildNodes(localNode, "Verification", "vendor", Collections.singletonList("Moat"));
    }
    while ((localList == null) || (localList.isEmpty()));
    return new e(localList).a();
  }

  String d()
  {
    return XmlUtils.getAttributeValue(this.a, "type");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastExtensionXmlManager
 * JD-Core Version:    0.6.2
 */
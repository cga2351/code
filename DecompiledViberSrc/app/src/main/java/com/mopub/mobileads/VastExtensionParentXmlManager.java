package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import com.mopub.mobileads.util.XmlUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.w3c.dom.Node;

public class VastExtensionParentXmlManager
{
  private final Node a;

  VastExtensionParentXmlManager(Node paramNode)
  {
    Preconditions.checkNotNull(paramNode);
    this.a = paramNode;
  }

  List<VastExtensionXmlManager> a()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = XmlUtils.getMatchingChildNodes(this.a, "Extension");
    if (localList == null)
      return localArrayList;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(new VastExtensionXmlManager((Node)localIterator.next()));
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastExtensionParentXmlManager
 * JD-Core Version:    0.6.2
 */
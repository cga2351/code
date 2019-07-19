package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.UIImplementation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class PropsAnimatedNode extends AnimatedNode
{
  private int mConnectedViewTag = -1;
  private final ReactStylesDiffMap mDiffMap;
  private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
  private final JavaOnlyMap mPropMap;
  private final Map<String, Integer> mPropNodeMapping;
  private final UIImplementation mUIImplementation;

  PropsAnimatedNode(ReadableMap paramReadableMap, NativeAnimatedNodesManager paramNativeAnimatedNodesManager, UIImplementation paramUIImplementation)
  {
    ReadableMap localReadableMap = paramReadableMap.getMap("props");
    ReadableMapKeySetIterator localReadableMapKeySetIterator = localReadableMap.keySetIterator();
    this.mPropNodeMapping = new HashMap();
    while (localReadableMapKeySetIterator.hasNextKey())
    {
      String str = localReadableMapKeySetIterator.nextKey();
      int i = localReadableMap.getInt(str);
      this.mPropNodeMapping.put(str, Integer.valueOf(i));
    }
    this.mPropMap = new JavaOnlyMap();
    this.mDiffMap = new ReactStylesDiffMap(this.mPropMap);
    this.mNativeAnimatedNodesManager = paramNativeAnimatedNodesManager;
    this.mUIImplementation = paramUIImplementation;
  }

  public void connectToView(int paramInt)
  {
    if (this.mConnectedViewTag != -1)
      throw new JSApplicationIllegalArgumentException("Animated node " + this.mTag + " is already attached to a view");
    this.mConnectedViewTag = paramInt;
  }

  public void disconnectFromView(int paramInt)
  {
    if (this.mConnectedViewTag != paramInt)
      throw new JSApplicationIllegalArgumentException("Attempting to disconnect view that has not been connected with the given animated node");
    this.mConnectedViewTag = -1;
  }

  public void restoreDefaultValues()
  {
    ReadableMapKeySetIterator localReadableMapKeySetIterator = this.mPropMap.keySetIterator();
    while (localReadableMapKeySetIterator.hasNextKey())
      this.mPropMap.putNull(localReadableMapKeySetIterator.nextKey());
    this.mUIImplementation.synchronouslyUpdateViewOnUIThread(this.mConnectedViewTag, this.mDiffMap);
  }

  public final void updateView()
  {
    if (this.mConnectedViewTag == -1)
      return;
    Iterator localIterator = this.mPropNodeMapping.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      AnimatedNode localAnimatedNode = this.mNativeAnimatedNodesManager.getNodeById(((Integer)localEntry.getValue()).intValue());
      if (localAnimatedNode == null)
        throw new IllegalArgumentException("Mapped property node does not exists");
      if ((localAnimatedNode instanceof StyleAnimatedNode))
        ((StyleAnimatedNode)localAnimatedNode).collectViewUpdates(this.mPropMap);
      else if ((localAnimatedNode instanceof ValueAnimatedNode))
        this.mPropMap.putDouble((String)localEntry.getKey(), ((ValueAnimatedNode)localAnimatedNode).getValue());
      else
        throw new IllegalArgumentException("Unsupported type of node used in property node " + localAnimatedNode.getClass());
    }
    this.mUIImplementation.synchronouslyUpdateViewOnUIThread(this.mConnectedViewTag, this.mDiffMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.PropsAnimatedNode
 * JD-Core Version:    0.6.2
 */
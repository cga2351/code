package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StyleAnimatedNode extends AnimatedNode
{
  private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
  private final Map<String, Integer> mPropMapping;

  StyleAnimatedNode(ReadableMap paramReadableMap, NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
  {
    ReadableMap localReadableMap = paramReadableMap.getMap("style");
    ReadableMapKeySetIterator localReadableMapKeySetIterator = localReadableMap.keySetIterator();
    this.mPropMapping = new HashMap();
    while (localReadableMapKeySetIterator.hasNextKey())
    {
      String str = localReadableMapKeySetIterator.nextKey();
      int i = localReadableMap.getInt(str);
      this.mPropMapping.put(str, Integer.valueOf(i));
    }
    this.mNativeAnimatedNodesManager = paramNativeAnimatedNodesManager;
  }

  public void collectViewUpdates(JavaOnlyMap paramJavaOnlyMap)
  {
    Iterator localIterator = this.mPropMapping.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      AnimatedNode localAnimatedNode = this.mNativeAnimatedNodesManager.getNodeById(((Integer)localEntry.getValue()).intValue());
      if (localAnimatedNode == null)
        throw new IllegalArgumentException("Mapped style node does not exists");
      if ((localAnimatedNode instanceof TransformAnimatedNode))
        ((TransformAnimatedNode)localAnimatedNode).collectViewUpdates(paramJavaOnlyMap);
      else if ((localAnimatedNode instanceof ValueAnimatedNode))
        paramJavaOnlyMap.putDouble((String)localEntry.getKey(), ((ValueAnimatedNode)localAnimatedNode).getValue());
      else
        throw new IllegalArgumentException("Unsupported type of node used in property node " + localAnimatedNode.getClass());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.StyleAnimatedNode
 * JD-Core Version:    0.6.2
 */
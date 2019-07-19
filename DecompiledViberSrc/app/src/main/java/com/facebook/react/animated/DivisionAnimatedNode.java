package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

class DivisionAnimatedNode extends ValueAnimatedNode
{
  private final int[] mInputNodes;
  private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;

  public DivisionAnimatedNode(ReadableMap paramReadableMap, NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
  {
    this.mNativeAnimatedNodesManager = paramNativeAnimatedNodesManager;
    ReadableArray localReadableArray = paramReadableMap.getArray("input");
    this.mInputNodes = new int[localReadableArray.size()];
    for (int i = 0; i < this.mInputNodes.length; i++)
      this.mInputNodes[i] = localReadableArray.getInt(i);
  }

  public void update()
  {
    int i = 0;
    if (i < this.mInputNodes.length)
    {
      AnimatedNode localAnimatedNode = this.mNativeAnimatedNodesManager.getNodeById(this.mInputNodes[i]);
      if ((localAnimatedNode != null) && ((localAnimatedNode instanceof ValueAnimatedNode)))
      {
        double d = ((ValueAnimatedNode)localAnimatedNode).getValue();
        if (i == 0);
        for (this.mValue = d; ; this.mValue /= d)
        {
          i++;
          break;
          if (d == 0.0D)
            throw new JSApplicationCausedNativeException("Detected a division by zero in Animated.divide node");
        }
      }
      throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.divide node");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.DivisionAnimatedNode
 * JD-Core Version:    0.6.2
 */
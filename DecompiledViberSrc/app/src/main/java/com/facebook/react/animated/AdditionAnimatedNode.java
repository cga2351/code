package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

class AdditionAnimatedNode extends ValueAnimatedNode
{
  private final int[] mInputNodes;
  private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;

  public AdditionAnimatedNode(ReadableMap paramReadableMap, NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
  {
    this.mNativeAnimatedNodesManager = paramNativeAnimatedNodesManager;
    ReadableArray localReadableArray = paramReadableMap.getArray("input");
    this.mInputNodes = new int[localReadableArray.size()];
    for (int i = 0; i < this.mInputNodes.length; i++)
      this.mInputNodes[i] = localReadableArray.getInt(i);
  }

  public void update()
  {
    this.mValue = 0.0D;
    int i = 0;
    while (i < this.mInputNodes.length)
    {
      AnimatedNode localAnimatedNode = this.mNativeAnimatedNodesManager.getNodeById(this.mInputNodes[i]);
      if ((localAnimatedNode != null) && ((localAnimatedNode instanceof ValueAnimatedNode)))
      {
        this.mValue += ((ValueAnimatedNode)localAnimatedNode).getValue();
        i++;
      }
      else
      {
        throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.Add node");
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.AdditionAnimatedNode
 * JD-Core Version:    0.6.2
 */
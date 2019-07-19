package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;

class ModulusAnimatedNode extends ValueAnimatedNode
{
  private final int mInputNode;
  private final double mModulus;
  private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;

  public ModulusAnimatedNode(ReadableMap paramReadableMap, NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
  {
    this.mNativeAnimatedNodesManager = paramNativeAnimatedNodesManager;
    this.mInputNode = paramReadableMap.getInt("input");
    this.mModulus = paramReadableMap.getDouble("modulus");
  }

  public void update()
  {
    AnimatedNode localAnimatedNode = this.mNativeAnimatedNodesManager.getNodeById(this.mInputNode);
    if ((localAnimatedNode != null) && ((localAnimatedNode instanceof ValueAnimatedNode)))
    {
      this.mValue = (((ValueAnimatedNode)localAnimatedNode).getValue() % this.mModulus);
      return;
    }
    throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.modulus node");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.ModulusAnimatedNode
 * JD-Core Version:    0.6.2
 */
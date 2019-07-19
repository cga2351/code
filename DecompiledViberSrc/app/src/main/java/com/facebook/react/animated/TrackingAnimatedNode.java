package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;

class TrackingAnimatedNode extends AnimatedNode
{
  private final JavaOnlyMap mAnimationConfig;
  private final int mAnimationId;
  private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
  private final int mToValueNode;
  private final int mValueNode;

  TrackingAnimatedNode(ReadableMap paramReadableMap, NativeAnimatedNodesManager paramNativeAnimatedNodesManager)
  {
    this.mNativeAnimatedNodesManager = paramNativeAnimatedNodesManager;
    this.mAnimationId = paramReadableMap.getInt("animationId");
    this.mToValueNode = paramReadableMap.getInt("toValue");
    this.mValueNode = paramReadableMap.getInt("value");
    this.mAnimationConfig = JavaOnlyMap.deepClone(paramReadableMap.getMap("animationConfig"));
  }

  public void update()
  {
    AnimatedNode localAnimatedNode = this.mNativeAnimatedNodesManager.getNodeById(this.mToValueNode);
    this.mAnimationConfig.putDouble("toValue", ((ValueAnimatedNode)localAnimatedNode).getValue());
    this.mNativeAnimatedNodesManager.startAnimatingNode(this.mAnimationId, this.mValueNode, this.mAnimationConfig, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.TrackingAnimatedNode
 * JD-Core Version:    0.6.2
 */
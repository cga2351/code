package com.facebook.react.animated;

import com.facebook.infer.annotation.Assertions;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

abstract class AnimatedNode
{
  private static final int DEFAULT_ANIMATED_NODE_CHILD_COUNT = 1;
  public static final int INITIAL_BFS_COLOR;
  int mActiveIncomingNodes = 0;
  int mBFSColor = 0;

  @Nullable
  List<AnimatedNode> mChildren;
  int mTag = -1;

  public final void addChild(AnimatedNode paramAnimatedNode)
  {
    if (this.mChildren == null)
      this.mChildren = new ArrayList(1);
    ((List)Assertions.assertNotNull(this.mChildren)).add(paramAnimatedNode);
    paramAnimatedNode.onAttachedToNode(this);
  }

  public void onAttachedToNode(AnimatedNode paramAnimatedNode)
  {
  }

  public void onDetachedFromNode(AnimatedNode paramAnimatedNode)
  {
  }

  public final void removeChild(AnimatedNode paramAnimatedNode)
  {
    if (this.mChildren == null)
      return;
    paramAnimatedNode.onDetachedFromNode(this);
    this.mChildren.remove(paramAnimatedNode);
  }

  public void update()
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.animated.AnimatedNode
 * JD-Core Version:    0.6.2
 */
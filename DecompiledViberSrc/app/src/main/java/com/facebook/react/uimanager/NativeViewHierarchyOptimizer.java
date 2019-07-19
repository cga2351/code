package com.facebook.react.uimanager;

import android.util.SparseBooleanArray;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import javax.annotation.Nullable;

public class NativeViewHierarchyOptimizer
{
  private static final boolean ENABLED = true;
  private final ShadowNodeRegistry mShadowNodeRegistry;
  private final SparseBooleanArray mTagsWithLayoutVisited = new SparseBooleanArray();
  private final UIViewOperationQueue mUIViewOperationQueue;

  public NativeViewHierarchyOptimizer(UIViewOperationQueue paramUIViewOperationQueue, ShadowNodeRegistry paramShadowNodeRegistry)
  {
    this.mUIViewOperationQueue = paramUIViewOperationQueue;
    this.mShadowNodeRegistry = paramShadowNodeRegistry;
  }

  private void addGrandchildren(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2, int paramInt)
  {
    boolean bool1;
    int i;
    label20: ReactShadowNode localReactShadowNode;
    boolean bool2;
    if (!paramReactShadowNode1.isLayoutOnly())
    {
      bool1 = true;
      Assertions.assertCondition(bool1);
      i = 0;
      if (i >= paramReactShadowNode2.getChildCount())
        return;
      localReactShadowNode = paramReactShadowNode2.getChildAt(i);
      if (localReactShadowNode.getNativeParent() != null)
        break label109;
      bool2 = true;
      label54: Assertions.assertCondition(bool2);
      if (!localReactShadowNode.isLayoutOnly())
        break label115;
      int j = paramReactShadowNode1.getNativeChildCount();
      addLayoutOnlyNode(paramReactShadowNode1, localReactShadowNode, paramInt);
      paramInt += paramReactShadowNode1.getNativeChildCount() - j;
    }
    while (true)
    {
      i++;
      break label20;
      bool1 = false;
      break;
      label109: bool2 = false;
      break label54;
      label115: addNonLayoutNode(paramReactShadowNode1, localReactShadowNode, paramInt);
      paramInt++;
    }
  }

  private void addLayoutOnlyNode(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2, int paramInt)
  {
    addGrandchildren(paramReactShadowNode1, paramReactShadowNode2, paramInt);
  }

  private void addNodeToNode(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2, int paramInt)
  {
    int i = paramReactShadowNode1.getNativeOffsetForChild(paramReactShadowNode1.getChildAt(paramInt));
    if (paramReactShadowNode1.isLayoutOnly())
    {
      NodeIndexPair localNodeIndexPair = walkUpUntilNonLayoutOnly(paramReactShadowNode1, i);
      if (localNodeIndexPair == null)
        return;
      paramReactShadowNode1 = localNodeIndexPair.node;
      i = localNodeIndexPair.index;
    }
    if (!paramReactShadowNode2.isLayoutOnly())
    {
      addNonLayoutNode(paramReactShadowNode1, paramReactShadowNode2, i);
      return;
    }
    addLayoutOnlyNode(paramReactShadowNode1, paramReactShadowNode2, i);
  }

  private void addNonLayoutNode(ReactShadowNode paramReactShadowNode1, ReactShadowNode paramReactShadowNode2, int paramInt)
  {
    paramReactShadowNode1.addNativeChildAt(paramReactShadowNode2, paramInt);
    UIViewOperationQueue localUIViewOperationQueue = this.mUIViewOperationQueue;
    int i = paramReactShadowNode1.getReactTag();
    ViewAtIndex[] arrayOfViewAtIndex = new ViewAtIndex[1];
    arrayOfViewAtIndex[0] = new ViewAtIndex(paramReactShadowNode2.getReactTag(), paramInt);
    localUIViewOperationQueue.enqueueManageChildren(i, null, arrayOfViewAtIndex, null);
  }

  private void applyLayoutBase(ReactShadowNode paramReactShadowNode)
  {
    int i = paramReactShadowNode.getReactTag();
    if (this.mTagsWithLayoutVisited.get(i))
      return;
    this.mTagsWithLayoutVisited.put(i, true);
    ReactShadowNode localReactShadowNode = paramReactShadowNode.getParent();
    int j = paramReactShadowNode.getScreenX();
    int k = paramReactShadowNode.getScreenY();
    while ((localReactShadowNode != null) && (localReactShadowNode.isLayoutOnly()))
    {
      j += Math.round(localReactShadowNode.getLayoutX());
      k += Math.round(localReactShadowNode.getLayoutY());
      localReactShadowNode = localReactShadowNode.getParent();
    }
    applyLayoutRecursive(paramReactShadowNode, j, k);
  }

  private void applyLayoutRecursive(ReactShadowNode paramReactShadowNode, int paramInt1, int paramInt2)
  {
    if ((!paramReactShadowNode.isLayoutOnly()) && (paramReactShadowNode.getNativeParent() != null))
    {
      int n = paramReactShadowNode.getReactTag();
      this.mUIViewOperationQueue.enqueueUpdateLayout(paramReactShadowNode.getNativeParent().getReactTag(), n, paramInt1, paramInt2, paramReactShadowNode.getScreenWidth(), paramReactShadowNode.getScreenHeight());
      return;
    }
    int i = 0;
    label64: ReactShadowNode localReactShadowNode;
    int j;
    if (i < paramReactShadowNode.getChildCount())
    {
      localReactShadowNode = paramReactShadowNode.getChildAt(i);
      j = localReactShadowNode.getReactTag();
      if (!this.mTagsWithLayoutVisited.get(j))
        break label112;
    }
    while (true)
    {
      i++;
      break label64;
      break;
      label112: this.mTagsWithLayoutVisited.put(j, true);
      int k = localReactShadowNode.getScreenX();
      int m = localReactShadowNode.getScreenY();
      applyLayoutRecursive(localReactShadowNode, k + paramInt1, m + paramInt2);
    }
  }

  public static void handleRemoveNode(ReactShadowNode paramReactShadowNode)
  {
    paramReactShadowNode.removeAllNativeChildren();
  }

  private static boolean isLayoutOnlyAndCollapsable(@Nullable ReactStylesDiffMap paramReactStylesDiffMap)
  {
    if (paramReactStylesDiffMap == null);
    ReadableMapKeySetIterator localReadableMapKeySetIterator;
    do
      while (!localReadableMapKeySetIterator.hasNextKey())
      {
        return true;
        if ((paramReactStylesDiffMap.hasKey("collapsable")) && (!paramReactStylesDiffMap.getBoolean("collapsable", true)))
          return false;
        localReadableMapKeySetIterator = paramReactStylesDiffMap.mBackingMap.keySetIterator();
      }
    while (ViewProps.isLayoutOnly(paramReactStylesDiffMap.mBackingMap, localReadableMapKeySetIterator.nextKey()));
    return false;
  }

  private void removeNodeFromParent(ReactShadowNode paramReactShadowNode, boolean paramBoolean)
  {
    ReactShadowNode localReactShadowNode = paramReactShadowNode.getNativeParent();
    int[] arrayOfInt2;
    if (localReactShadowNode != null)
    {
      int j = localReactShadowNode.indexOfNativeChild(paramReactShadowNode);
      localReactShadowNode.removeNativeChildAt(j);
      UIViewOperationQueue localUIViewOperationQueue = this.mUIViewOperationQueue;
      int k = localReactShadowNode.getReactTag();
      int[] arrayOfInt1 = { j };
      if (paramBoolean)
      {
        arrayOfInt2 = new int[1];
        arrayOfInt2[0] = paramReactShadowNode.getReactTag();
        localUIViewOperationQueue.enqueueManageChildren(k, arrayOfInt1, null, arrayOfInt2);
      }
    }
    while (true)
    {
      return;
      arrayOfInt2 = null;
      break;
      for (int i = -1 + paramReactShadowNode.getChildCount(); i >= 0; i--)
        removeNodeFromParent(paramReactShadowNode.getChildAt(i), paramBoolean);
    }
  }

  private void transitionLayoutOnlyViewToNativeView(ReactShadowNode paramReactShadowNode, @Nullable ReactStylesDiffMap paramReactStylesDiffMap)
  {
    int i = 0;
    ReactShadowNode localReactShadowNode = paramReactShadowNode.getParent();
    if (localReactShadowNode == null)
    {
      paramReactShadowNode.setIsLayoutOnly(false);
      return;
    }
    int j = localReactShadowNode.indexOf(paramReactShadowNode);
    localReactShadowNode.removeChildAt(j);
    removeNodeFromParent(paramReactShadowNode, false);
    paramReactShadowNode.setIsLayoutOnly(false);
    this.mUIViewOperationQueue.enqueueCreateView(paramReactShadowNode.getThemedContext(), paramReactShadowNode.getReactTag(), paramReactShadowNode.getViewClass(), paramReactStylesDiffMap);
    localReactShadowNode.addChildAt(paramReactShadowNode, j);
    addNodeToNode(localReactShadowNode, paramReactShadowNode, j);
    for (int k = 0; k < paramReactShadowNode.getChildCount(); k++)
      addNodeToNode(paramReactShadowNode, paramReactShadowNode.getChildAt(k), k);
    if (this.mTagsWithLayoutVisited.size() == 0);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool);
      applyLayoutBase(paramReactShadowNode);
      while (i < paramReactShadowNode.getChildCount())
      {
        applyLayoutBase(paramReactShadowNode.getChildAt(i));
        i++;
      }
    }
    this.mTagsWithLayoutVisited.clear();
  }

  private NodeIndexPair walkUpUntilNonLayoutOnly(ReactShadowNode paramReactShadowNode, int paramInt)
  {
    while (paramReactShadowNode.isLayoutOnly())
    {
      ReactShadowNode localReactShadowNode = paramReactShadowNode.getParent();
      if (localReactShadowNode == null)
        return null;
      paramInt += localReactShadowNode.getNativeOffsetForChild(paramReactShadowNode);
      paramReactShadowNode = localReactShadowNode;
    }
    return new NodeIndexPair(paramReactShadowNode, paramInt);
  }

  public void handleCreateView(ReactShadowNode paramReactShadowNode, ThemedReactContext paramThemedReactContext, @Nullable ReactStylesDiffMap paramReactStylesDiffMap)
  {
    if ((paramReactShadowNode.getViewClass().equals("RCTView")) && (isLayoutOnlyAndCollapsable(paramReactStylesDiffMap)));
    for (boolean bool = true; ; bool = false)
    {
      paramReactShadowNode.setIsLayoutOnly(bool);
      if (!bool)
        this.mUIViewOperationQueue.enqueueCreateView(paramThemedReactContext, paramReactShadowNode.getReactTag(), paramReactShadowNode.getViewClass(), paramReactStylesDiffMap);
      return;
    }
  }

  public void handleManageChildren(ReactShadowNode paramReactShadowNode, int[] paramArrayOfInt1, int[] paramArrayOfInt2, ViewAtIndex[] paramArrayOfViewAtIndex, int[] paramArrayOfInt3)
  {
    int i = 0;
    int j = paramArrayOfInt2.length;
    int k = 0;
    int m;
    int n;
    if (i < j)
    {
      m = paramArrayOfInt2[i];
      n = 0;
      label26: if (n >= paramArrayOfInt3.length)
        break label118;
      if (paramArrayOfInt3[n] != m);
    }
    label118: for (boolean bool = true; ; bool = false)
    {
      removeNodeFromParent(this.mShadowNodeRegistry.getNode(m), bool);
      i++;
      break;
      n++;
      break label26;
      while (k < paramArrayOfViewAtIndex.length)
      {
        ViewAtIndex localViewAtIndex = paramArrayOfViewAtIndex[k];
        addNodeToNode(paramReactShadowNode, this.mShadowNodeRegistry.getNode(localViewAtIndex.mTag), localViewAtIndex.mIndex);
        k++;
      }
      return;
    }
  }

  public void handleSetChildren(ReactShadowNode paramReactShadowNode, ReadableArray paramReadableArray)
  {
    for (int i = 0; i < paramReadableArray.size(); i++)
      addNodeToNode(paramReactShadowNode, this.mShadowNodeRegistry.getNode(paramReadableArray.getInt(i)), i);
  }

  public void handleUpdateLayout(ReactShadowNode paramReactShadowNode)
  {
    applyLayoutBase(paramReactShadowNode);
  }

  public void handleUpdateView(ReactShadowNode paramReactShadowNode, String paramString, ReactStylesDiffMap paramReactStylesDiffMap)
  {
    int i;
    if ((paramReactShadowNode.isLayoutOnly()) && (!isLayoutOnlyAndCollapsable(paramReactStylesDiffMap)))
    {
      i = 1;
      if (i == 0)
        break label37;
      transitionLayoutOnlyViewToNativeView(paramReactShadowNode, paramReactStylesDiffMap);
    }
    label37: 
    while (paramReactShadowNode.isLayoutOnly())
    {
      return;
      i = 0;
      break;
    }
    this.mUIViewOperationQueue.enqueueUpdateProperties(paramReactShadowNode.getReactTag(), paramString, paramReactStylesDiffMap);
  }

  public void onBatchComplete()
  {
    this.mTagsWithLayoutVisited.clear();
  }

  private static class NodeIndexPair
  {
    public final int index;
    public final ReactShadowNode node;

    NodeIndexPair(ReactShadowNode paramReactShadowNode, int paramInt)
    {
      this.node = paramReactShadowNode;
      this.index = paramInt;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.NativeViewHierarchyOptimizer
 * JD-Core Version:    0.6.2
 */
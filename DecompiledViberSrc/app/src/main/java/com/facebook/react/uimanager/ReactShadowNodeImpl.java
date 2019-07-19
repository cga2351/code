package com.facebook.react.uimanager;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.ClearableSynchronizedPool;
import com.facebook.react.uimanager.annotations.ReactPropertyHolder;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaBaselineFunction;
import com.facebook.yoga.YogaConfig;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaValue;
import com.facebook.yoga.YogaWrap;
import java.util.ArrayList;
import java.util.Arrays;
import javax.annotation.Nullable;

@ReactPropertyHolder
public class ReactShadowNodeImpl
  implements ReactShadowNode<ReactShadowNodeImpl>
{
  private static final YogaConfig sYogaConfig = ReactYogaConfigProvider.get();

  @Nullable
  private ArrayList<ReactShadowNodeImpl> mChildren;
  private final Spacing mDefaultPadding = new Spacing(0.0F);
  private boolean mIsLayoutOnly;

  @Nullable
  private ArrayList<ReactShadowNodeImpl> mNativeChildren;

  @Nullable
  private ReactShadowNodeImpl mNativeParent;
  private boolean mNodeUpdated = true;
  private final float[] mPadding = new float[9];
  private final boolean[] mPaddingIsPercent = new boolean[9];

  @Nullable
  private ReactShadowNodeImpl mParent;
  private int mReactTag;
  private int mRootTag;
  private int mScreenHeight;
  private int mScreenWidth;
  private int mScreenX;
  private int mScreenY;
  private boolean mShouldNotifyOnLayout;

  @Nullable
  private ThemedReactContext mThemedContext;
  private int mTotalNativeChildren = 0;

  @Nullable
  private String mViewClassName;
  private YogaNode mYogaNode;

  public ReactShadowNodeImpl()
  {
    if (!isVirtual())
    {
      YogaNode localYogaNode = (YogaNode)YogaNodePool.get().acquire();
      if (localYogaNode == null)
        localYogaNode = new YogaNode(sYogaConfig);
      this.mYogaNode = localYogaNode;
      this.mYogaNode.setData(this);
      Arrays.fill(this.mPadding, (0.0F / 0.0F));
      return;
    }
    this.mYogaNode = null;
  }

  private void getHierarchyInfoWithIndentation(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < paramInt; i++)
      paramStringBuilder.append("  ");
    paramStringBuilder.append("<").append(getClass().getSimpleName()).append(" view='").append(getViewClass()).append("' tag=").append(getReactTag());
    int k;
    if (this.mYogaNode != null)
    {
      paramStringBuilder.append(" layout='x:").append(getScreenX()).append(" y:").append(getScreenY()).append(" w:").append(getLayoutWidth()).append(" h:").append(getLayoutHeight()).append("'");
      paramStringBuilder.append(">\n");
      int j = getChildCount();
      k = 0;
      if (j != 0)
        break label155;
    }
    while (true)
    {
      return;
      paramStringBuilder.append("(virtual node)");
      break;
      label155: 
      while (k < getChildCount())
      {
        getChildAt(k).getHierarchyInfoWithIndentation(paramStringBuilder, paramInt + 1);
        k++;
      }
    }
  }

  private void updateNativeChildrenCountInParent(int paramInt)
  {
    if (this.mIsLayoutOnly);
    for (ReactShadowNodeImpl localReactShadowNodeImpl = getParent(); ; localReactShadowNodeImpl = localReactShadowNodeImpl.getParent())
      if (localReactShadowNodeImpl != null)
      {
        localReactShadowNodeImpl.mTotalNativeChildren = (paramInt + localReactShadowNodeImpl.mTotalNativeChildren);
        if (localReactShadowNodeImpl.isLayoutOnly());
      }
      else
      {
        return;
      }
  }

  private void updatePadding()
  {
    int i = 0;
    if (i <= 8)
    {
      if ((i == 0) || (i == 2) || (i == 4) || (i == 5))
      {
        if ((!YogaConstants.isUndefined(this.mPadding[i])) || (!YogaConstants.isUndefined(this.mPadding[6])) || (!YogaConstants.isUndefined(this.mPadding[8])))
          break label194;
        this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mDefaultPadding.getRaw(i));
      }
      while (true)
      {
        i++;
        break;
        if ((i == 1) || (i == 3))
        {
          if ((YogaConstants.isUndefined(this.mPadding[i])) && (YogaConstants.isUndefined(this.mPadding[7])) && (YogaConstants.isUndefined(this.mPadding[8])))
            this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mDefaultPadding.getRaw(i));
        }
        else if (YogaConstants.isUndefined(this.mPadding[i]))
          this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mDefaultPadding.getRaw(i));
        else
          label194: if (this.mPaddingIsPercent[i] != 0)
            this.mYogaNode.setPaddingPercent(YogaEdge.fromInt(i), this.mPadding[i]);
          else
            this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mPadding[i]);
      }
    }
  }

  public void addChildAt(ReactShadowNodeImpl paramReactShadowNodeImpl, int paramInt)
  {
    if (this.mChildren == null)
      this.mChildren = new ArrayList(4);
    this.mChildren.add(paramInt, paramReactShadowNodeImpl);
    paramReactShadowNodeImpl.mParent = this;
    if ((this.mYogaNode != null) && (!isYogaLeafNode()))
    {
      YogaNode localYogaNode = paramReactShadowNodeImpl.mYogaNode;
      if (localYogaNode == null)
        throw new RuntimeException("Cannot add a child that doesn't have a YogaNode to a parent without a measure function! (Trying to add a '" + paramReactShadowNodeImpl.toString() + "' to a '" + toString() + "')");
      this.mYogaNode.addChildAt(localYogaNode, paramInt);
    }
    markUpdated();
    if (paramReactShadowNodeImpl.isLayoutOnly());
    for (int i = paramReactShadowNodeImpl.getTotalNativeChildren(); ; i = 1)
    {
      this.mTotalNativeChildren = (i + this.mTotalNativeChildren);
      updateNativeChildrenCountInParent(i);
      return;
    }
  }

  public final void addNativeChildAt(ReactShadowNodeImpl paramReactShadowNodeImpl, int paramInt)
  {
    boolean bool1 = true;
    boolean bool2;
    if (!this.mIsLayoutOnly)
    {
      bool2 = bool1;
      Assertions.assertCondition(bool2);
      if (paramReactShadowNodeImpl.mIsLayoutOnly)
        break label68;
    }
    while (true)
    {
      Assertions.assertCondition(bool1);
      if (this.mNativeChildren == null)
        this.mNativeChildren = new ArrayList(4);
      this.mNativeChildren.add(paramInt, paramReactShadowNodeImpl);
      paramReactShadowNodeImpl.mNativeParent = this;
      return;
      bool2 = false;
      break;
      label68: bool1 = false;
    }
  }

  public void calculateLayout()
  {
    this.mYogaNode.calculateLayout((0.0F / 0.0F), (0.0F / 0.0F));
  }

  public void dirty()
  {
    if (!isVirtual())
      this.mYogaNode.dirty();
  }

  public boolean dispatchUpdates(float paramFloat1, float paramFloat2, UIViewOperationQueue paramUIViewOperationQueue, @Nullable NativeViewHierarchyOptimizer paramNativeViewHierarchyOptimizer)
  {
    if (this.mNodeUpdated)
      onCollectExtraUpdates(paramUIViewOperationQueue);
    if (hasNewLayout())
    {
      float f1 = getLayoutX();
      float f2 = getLayoutY();
      int i = Math.round(paramFloat1 + f1);
      int j = Math.round(paramFloat2 + f2);
      int k = Math.round(paramFloat1 + f1 + getLayoutWidth());
      int m = Math.round(paramFloat2 + f2 + getLayoutHeight());
      int n = Math.round(f1);
      int i1 = Math.round(f2);
      int i2 = k - i;
      int i3 = m - j;
      if ((n != this.mScreenX) || (i1 != this.mScreenY) || (i2 != this.mScreenWidth) || (i3 != this.mScreenHeight));
      for (boolean bool = true; ; bool = false)
      {
        this.mScreenX = n;
        this.mScreenY = i1;
        this.mScreenWidth = i2;
        this.mScreenHeight = i3;
        if (bool)
        {
          if (paramNativeViewHierarchyOptimizer == null)
            break;
          paramNativeViewHierarchyOptimizer.handleUpdateLayout(this);
        }
        return bool;
      }
      paramUIViewOperationQueue.enqueueUpdateLayout(getParent().getReactTag(), getReactTag(), getScreenX(), getScreenY(), getScreenWidth(), getScreenHeight());
      return bool;
    }
    return false;
  }

  public void dispose()
  {
    if (this.mYogaNode != null)
    {
      this.mYogaNode.reset();
      YogaNodePool.get().release(this.mYogaNode);
    }
  }

  public final ReactShadowNodeImpl getChildAt(int paramInt)
  {
    if (this.mChildren == null)
      throw new ArrayIndexOutOfBoundsException("Index " + paramInt + " out of bounds: node has no children");
    return (ReactShadowNodeImpl)this.mChildren.get(paramInt);
  }

  public final int getChildCount()
  {
    if (this.mChildren == null)
      return 0;
    return this.mChildren.size();
  }

  public String getHierarchyInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    getHierarchyInfoWithIndentation(localStringBuilder, 0);
    return localStringBuilder.toString();
  }

  public final YogaDirection getLayoutDirection()
  {
    return this.mYogaNode.getLayoutDirection();
  }

  public final float getLayoutHeight()
  {
    return this.mYogaNode.getLayoutHeight();
  }

  public final float getLayoutWidth()
  {
    return this.mYogaNode.getLayoutWidth();
  }

  public final float getLayoutX()
  {
    return this.mYogaNode.getLayoutX();
  }

  public final float getLayoutY()
  {
    return this.mYogaNode.getLayoutY();
  }

  public final int getNativeChildCount()
  {
    if (this.mNativeChildren == null)
      return 0;
    return this.mNativeChildren.size();
  }

  public final int getNativeOffsetForChild(ReactShadowNodeImpl paramReactShadowNodeImpl)
  {
    int i = 1;
    int j = 0;
    int k = 0;
    ReactShadowNodeImpl localReactShadowNodeImpl;
    if (j < getChildCount())
    {
      localReactShadowNodeImpl = getChildAt(j);
      if (paramReactShadowNodeImpl != localReactShadowNodeImpl);
    }
    while (true)
    {
      if (i == 0)
      {
        throw new RuntimeException("Child " + paramReactShadowNodeImpl.getReactTag() + " was not a child of " + this.mReactTag);
        if (localReactShadowNodeImpl.isLayoutOnly());
        for (int m = localReactShadowNodeImpl.getTotalNativeChildren(); ; m = i)
        {
          k += m;
          j++;
          break;
        }
      }
      return k;
      i = 0;
    }
  }

  @Nullable
  public final ReactShadowNodeImpl getNativeParent()
  {
    return this.mNativeParent;
  }

  public final float getPadding(int paramInt)
  {
    return this.mYogaNode.getLayoutPadding(YogaEdge.fromInt(paramInt));
  }

  @Nullable
  public final ReactShadowNodeImpl getParent()
  {
    return this.mParent;
  }

  public final int getReactTag()
  {
    return this.mReactTag;
  }

  public final int getRootTag()
  {
    if (this.mRootTag != 0);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool);
      return this.mRootTag;
    }
  }

  public int getScreenHeight()
  {
    return this.mScreenHeight;
  }

  public int getScreenWidth()
  {
    return this.mScreenWidth;
  }

  public int getScreenX()
  {
    return this.mScreenX;
  }

  public int getScreenY()
  {
    return this.mScreenY;
  }

  public final YogaValue getStyleHeight()
  {
    return this.mYogaNode.getHeight();
  }

  public final YogaValue getStylePadding(int paramInt)
  {
    return this.mYogaNode.getPadding(YogaEdge.fromInt(paramInt));
  }

  public final YogaValue getStyleWidth()
  {
    return this.mYogaNode.getWidth();
  }

  public final ThemedReactContext getThemedContext()
  {
    return (ThemedReactContext)Assertions.assertNotNull(this.mThemedContext);
  }

  public final int getTotalNativeChildren()
  {
    return this.mTotalNativeChildren;
  }

  public final String getViewClass()
  {
    return (String)Assertions.assertNotNull(this.mViewClassName);
  }

  public final boolean hasNewLayout()
  {
    return (this.mYogaNode != null) && (this.mYogaNode.hasNewLayout());
  }

  public final boolean hasUnseenUpdates()
  {
    return this.mNodeUpdated;
  }

  public final boolean hasUpdates()
  {
    return (this.mNodeUpdated) || (hasNewLayout()) || (isDirty());
  }

  public final int indexOf(ReactShadowNodeImpl paramReactShadowNodeImpl)
  {
    if (this.mChildren == null)
      return -1;
    return this.mChildren.indexOf(paramReactShadowNodeImpl);
  }

  public final int indexOfNativeChild(ReactShadowNodeImpl paramReactShadowNodeImpl)
  {
    Assertions.assertNotNull(this.mNativeChildren);
    return this.mNativeChildren.indexOf(paramReactShadowNodeImpl);
  }

  public boolean isDescendantOf(ReactShadowNodeImpl paramReactShadowNodeImpl)
  {
    for (ReactShadowNodeImpl localReactShadowNodeImpl = getParent(); ; localReactShadowNodeImpl = localReactShadowNodeImpl.getParent())
    {
      boolean bool = false;
      if (localReactShadowNodeImpl != null)
      {
        if (localReactShadowNodeImpl == paramReactShadowNodeImpl)
          bool = true;
      }
      else
        return bool;
    }
  }

  public final boolean isDirty()
  {
    return (this.mYogaNode != null) && (this.mYogaNode.isDirty());
  }

  public final boolean isLayoutOnly()
  {
    return this.mIsLayoutOnly;
  }

  public boolean isMeasureDefined()
  {
    return this.mYogaNode.isMeasureDefined();
  }

  public boolean isVirtual()
  {
    return false;
  }

  public boolean isVirtualAnchor()
  {
    return false;
  }

  public boolean isYogaLeafNode()
  {
    return isMeasureDefined();
  }

  public final void markLayoutSeen()
  {
    if (this.mYogaNode != null)
      this.mYogaNode.markLayoutSeen();
  }

  public final void markUpdateSeen()
  {
    this.mNodeUpdated = false;
    if (hasNewLayout())
      markLayoutSeen();
  }

  public void markUpdated()
  {
    if (this.mNodeUpdated);
    ReactShadowNodeImpl localReactShadowNodeImpl;
    do
    {
      return;
      this.mNodeUpdated = true;
      localReactShadowNodeImpl = getParent();
    }
    while (localReactShadowNodeImpl == null);
    localReactShadowNodeImpl.markUpdated();
  }

  public void onAfterUpdateTransaction()
  {
  }

  public void onBeforeLayout()
  {
  }

  public void onCollectExtraUpdates(UIViewOperationQueue paramUIViewOperationQueue)
  {
  }

  public final void removeAllNativeChildren()
  {
    if (this.mNativeChildren != null)
    {
      for (int i = -1 + this.mNativeChildren.size(); i >= 0; i--)
        ((ReactShadowNodeImpl)this.mNativeChildren.get(i)).mNativeParent = null;
      this.mNativeChildren.clear();
    }
  }

  public void removeAndDisposeAllChildren()
  {
    if (getChildCount() == 0)
      return;
    int i = -1 + getChildCount();
    int j = 0;
    int k = i;
    if (k >= 0)
    {
      if ((this.mYogaNode != null) && (!isYogaLeafNode()))
        this.mYogaNode.removeChildAt(k);
      ReactShadowNodeImpl localReactShadowNodeImpl = getChildAt(k);
      localReactShadowNodeImpl.mParent = null;
      localReactShadowNodeImpl.dispose();
      if (localReactShadowNodeImpl.isLayoutOnly());
      for (int m = localReactShadowNodeImpl.getTotalNativeChildren(); ; m = 1)
      {
        j += m;
        k--;
        break;
      }
    }
    ((ArrayList)Assertions.assertNotNull(this.mChildren)).clear();
    markUpdated();
    this.mTotalNativeChildren -= j;
    updateNativeChildrenCountInParent(-j);
  }

  public ReactShadowNodeImpl removeChildAt(int paramInt)
  {
    if (this.mChildren == null)
      throw new ArrayIndexOutOfBoundsException("Index " + paramInt + " out of bounds: node has no children");
    ReactShadowNodeImpl localReactShadowNodeImpl = (ReactShadowNodeImpl)this.mChildren.remove(paramInt);
    localReactShadowNodeImpl.mParent = null;
    if ((this.mYogaNode != null) && (!isYogaLeafNode()))
      this.mYogaNode.removeChildAt(paramInt);
    markUpdated();
    if (localReactShadowNodeImpl.isLayoutOnly());
    for (int i = localReactShadowNodeImpl.getTotalNativeChildren(); ; i = 1)
    {
      this.mTotalNativeChildren -= i;
      updateNativeChildrenCountInParent(-i);
      return localReactShadowNodeImpl;
    }
  }

  public final ReactShadowNodeImpl removeNativeChildAt(int paramInt)
  {
    Assertions.assertNotNull(this.mNativeChildren);
    ReactShadowNodeImpl localReactShadowNodeImpl = (ReactShadowNodeImpl)this.mNativeChildren.remove(paramInt);
    localReactShadowNodeImpl.mNativeParent = null;
    return localReactShadowNodeImpl;
  }

  public void setAlignContent(YogaAlign paramYogaAlign)
  {
    this.mYogaNode.setAlignContent(paramYogaAlign);
  }

  public void setAlignItems(YogaAlign paramYogaAlign)
  {
    this.mYogaNode.setAlignItems(paramYogaAlign);
  }

  public void setAlignSelf(YogaAlign paramYogaAlign)
  {
    this.mYogaNode.setAlignSelf(paramYogaAlign);
  }

  public void setBaselineFunction(YogaBaselineFunction paramYogaBaselineFunction)
  {
    this.mYogaNode.setBaselineFunction(paramYogaBaselineFunction);
  }

  public void setBorder(int paramInt, float paramFloat)
  {
    this.mYogaNode.setBorder(YogaEdge.fromInt(paramInt), paramFloat);
  }

  public void setDefaultPadding(int paramInt, float paramFloat)
  {
    this.mDefaultPadding.set(paramInt, paramFloat);
    updatePadding();
  }

  public void setDisplay(YogaDisplay paramYogaDisplay)
  {
    this.mYogaNode.setDisplay(paramYogaDisplay);
  }

  public void setFlex(float paramFloat)
  {
    this.mYogaNode.setFlex(paramFloat);
  }

  public void setFlexBasis(float paramFloat)
  {
    this.mYogaNode.setFlexBasis(paramFloat);
  }

  public void setFlexBasisAuto()
  {
    this.mYogaNode.setFlexBasisAuto();
  }

  public void setFlexBasisPercent(float paramFloat)
  {
    this.mYogaNode.setFlexBasisPercent(paramFloat);
  }

  public void setFlexDirection(YogaFlexDirection paramYogaFlexDirection)
  {
    this.mYogaNode.setFlexDirection(paramYogaFlexDirection);
  }

  public void setFlexGrow(float paramFloat)
  {
    this.mYogaNode.setFlexGrow(paramFloat);
  }

  public void setFlexShrink(float paramFloat)
  {
    this.mYogaNode.setFlexShrink(paramFloat);
  }

  public void setFlexWrap(YogaWrap paramYogaWrap)
  {
    this.mYogaNode.setWrap(paramYogaWrap);
  }

  public final void setIsLayoutOnly(boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    if (getParent() == null)
    {
      bool2 = bool1;
      Assertions.assertCondition(bool2, "Must remove from no opt parent first");
      if (this.mNativeParent != null)
        break label61;
      bool3 = bool1;
      label28: Assertions.assertCondition(bool3, "Must remove from native parent first");
      if (getNativeChildCount() != 0)
        break label67;
    }
    while (true)
    {
      Assertions.assertCondition(bool1, "Must remove all native children first");
      this.mIsLayoutOnly = paramBoolean;
      return;
      bool2 = false;
      break;
      label61: bool3 = false;
      break label28;
      label67: bool1 = false;
    }
  }

  public void setJustifyContent(YogaJustify paramYogaJustify)
  {
    this.mYogaNode.setJustifyContent(paramYogaJustify);
  }

  public void setLayoutDirection(YogaDirection paramYogaDirection)
  {
    this.mYogaNode.setDirection(paramYogaDirection);
  }

  public void setLocalData(Object paramObject)
  {
  }

  public void setMargin(int paramInt, float paramFloat)
  {
    this.mYogaNode.setMargin(YogaEdge.fromInt(paramInt), paramFloat);
  }

  public void setMarginAuto(int paramInt)
  {
    this.mYogaNode.setMarginAuto(YogaEdge.fromInt(paramInt));
  }

  public void setMarginPercent(int paramInt, float paramFloat)
  {
    this.mYogaNode.setMarginPercent(YogaEdge.fromInt(paramInt), paramFloat);
  }

  public void setMeasureFunction(YogaMeasureFunction paramYogaMeasureFunction)
  {
    this.mYogaNode.setMeasureFunction(paramYogaMeasureFunction);
  }

  public void setOverflow(YogaOverflow paramYogaOverflow)
  {
    this.mYogaNode.setOverflow(paramYogaOverflow);
  }

  public void setPadding(int paramInt, float paramFloat)
  {
    this.mPadding[paramInt] = paramFloat;
    this.mPaddingIsPercent[paramInt] = false;
    updatePadding();
  }

  public void setPaddingPercent(int paramInt, float paramFloat)
  {
    this.mPadding[paramInt] = paramFloat;
    boolean[] arrayOfBoolean = this.mPaddingIsPercent;
    if (!YogaConstants.isUndefined(paramFloat));
    for (int i = 1; ; i = 0)
    {
      arrayOfBoolean[paramInt] = i;
      updatePadding();
      return;
    }
  }

  public void setPosition(int paramInt, float paramFloat)
  {
    this.mYogaNode.setPosition(YogaEdge.fromInt(paramInt), paramFloat);
  }

  public void setPositionPercent(int paramInt, float paramFloat)
  {
    this.mYogaNode.setPositionPercent(YogaEdge.fromInt(paramInt), paramFloat);
  }

  public void setPositionType(YogaPositionType paramYogaPositionType)
  {
    this.mYogaNode.setPositionType(paramYogaPositionType);
  }

  public void setReactTag(int paramInt)
  {
    this.mReactTag = paramInt;
  }

  public final void setRootTag(int paramInt)
  {
    this.mRootTag = paramInt;
  }

  public void setShouldNotifyOnLayout(boolean paramBoolean)
  {
    this.mShouldNotifyOnLayout = paramBoolean;
  }

  public void setStyleAspectRatio(float paramFloat)
  {
    this.mYogaNode.setAspectRatio(paramFloat);
  }

  public void setStyleHeight(float paramFloat)
  {
    this.mYogaNode.setHeight(paramFloat);
  }

  public void setStyleHeightAuto()
  {
    this.mYogaNode.setHeightAuto();
  }

  public void setStyleHeightPercent(float paramFloat)
  {
    this.mYogaNode.setHeightPercent(paramFloat);
  }

  public void setStyleMaxHeight(float paramFloat)
  {
    this.mYogaNode.setMaxHeight(paramFloat);
  }

  public void setStyleMaxHeightPercent(float paramFloat)
  {
    this.mYogaNode.setMaxHeightPercent(paramFloat);
  }

  public void setStyleMaxWidth(float paramFloat)
  {
    this.mYogaNode.setMaxWidth(paramFloat);
  }

  public void setStyleMaxWidthPercent(float paramFloat)
  {
    this.mYogaNode.setMaxWidthPercent(paramFloat);
  }

  public void setStyleMinHeight(float paramFloat)
  {
    this.mYogaNode.setMinHeight(paramFloat);
  }

  public void setStyleMinHeightPercent(float paramFloat)
  {
    this.mYogaNode.setMinHeightPercent(paramFloat);
  }

  public void setStyleMinWidth(float paramFloat)
  {
    this.mYogaNode.setMinWidth(paramFloat);
  }

  public void setStyleMinWidthPercent(float paramFloat)
  {
    this.mYogaNode.setMinWidthPercent(paramFloat);
  }

  public void setStyleWidth(float paramFloat)
  {
    this.mYogaNode.setWidth(paramFloat);
  }

  public void setStyleWidthAuto()
  {
    this.mYogaNode.setWidthAuto();
  }

  public void setStyleWidthPercent(float paramFloat)
  {
    this.mYogaNode.setWidthPercent(paramFloat);
  }

  public void setThemedContext(ThemedReactContext paramThemedReactContext)
  {
    this.mThemedContext = paramThemedReactContext;
  }

  public final void setViewClassName(String paramString)
  {
    this.mViewClassName = paramString;
  }

  public final boolean shouldNotifyOnLayout()
  {
    return this.mShouldNotifyOnLayout;
  }

  public String toString()
  {
    return "[" + this.mViewClassName + " " + getReactTag() + "]";
  }

  public final void updateProperties(ReactStylesDiffMap paramReactStylesDiffMap)
  {
    ViewManagerPropertyUpdater.updateProps(this, paramReactStylesDiffMap);
    onAfterUpdateTransaction();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ReactShadowNodeImpl
 * JD-Core Version:    0.6.2
 */
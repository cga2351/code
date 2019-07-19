package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

@DoNotStrip
public class YogaNode
  implements Cloneable
{
  private static final int BORDER = 4;
  private static final int MARGIN = 1;
  private static final int PADDING = 2;
  private YogaBaselineFunction mBaselineFunction;

  @DoNotStrip
  private float mBorderBottom = 0.0F;

  @DoNotStrip
  private float mBorderLeft = 0.0F;

  @DoNotStrip
  private float mBorderRight = 0.0F;

  @DoNotStrip
  private float mBorderTop = 0.0F;

  @Nullable
  private List<YogaNode> mChildren;
  private Object mData;

  @DoNotStrip
  private boolean mDoesLegacyStretchFlagAffectsLayout = false;

  @DoNotStrip
  private int mEdgeSetFlag = 0;

  @DoNotStrip
  private boolean mHasNewLayout = true;
  private boolean mHasSetPosition = false;

  @DoNotStrip
  private float mHeight = (0.0F / 0.0F);

  @DoNotStrip
  private int mLayoutDirection = 0;

  @DoNotStrip
  private float mLeft = (0.0F / 0.0F);

  @DoNotStrip
  private float mMarginBottom = 0.0F;

  @DoNotStrip
  private float mMarginLeft = 0.0F;

  @DoNotStrip
  private float mMarginRight = 0.0F;

  @DoNotStrip
  private float mMarginTop = 0.0F;
  private YogaMeasureFunction mMeasureFunction;
  private long mNativePointer;
  private YogaNode mOwner;

  @DoNotStrip
  private float mPaddingBottom = 0.0F;

  @DoNotStrip
  private float mPaddingLeft = 0.0F;

  @DoNotStrip
  private float mPaddingRight = 0.0F;

  @DoNotStrip
  private float mPaddingTop = 0.0F;

  @DoNotStrip
  private float mTop = (0.0F / 0.0F);

  @DoNotStrip
  private float mWidth = (0.0F / 0.0F);

  static
  {
    SoLoader.loadLibrary("yoga");
  }

  public YogaNode()
  {
    this.mNativePointer = jni_YGNodeNew();
    if (this.mNativePointer == 0L)
      throw new IllegalStateException("Failed to allocate native memory");
  }

  public YogaNode(YogaConfig paramYogaConfig)
  {
    this.mNativePointer = jni_YGNodeNewWithConfig(paramYogaConfig.mNativePointer);
    if (this.mNativePointer == 0L)
      throw new IllegalStateException("Failed to allocate native memory");
  }

  private void clearChildren()
  {
    this.mChildren = null;
    jni_YGNodeClearChildren(this.mNativePointer);
  }

  private static native void jni_YGNodeCalculateLayout(long paramLong, float paramFloat1, float paramFloat2);

  private static native void jni_YGNodeClearChildren(long paramLong);

  private native long jni_YGNodeClone(long paramLong, Object paramObject);

  private static native void jni_YGNodeCopyStyle(long paramLong1, long paramLong2);

  private static native void jni_YGNodeFree(long paramLong);

  static native int jni_YGNodeGetInstanceCount();

  private static native void jni_YGNodeInsertChild(long paramLong1, long paramLong2, int paramInt);

  private static native boolean jni_YGNodeIsDirty(long paramLong);

  private static native boolean jni_YGNodeIsReferenceBaseline(long paramLong);

  private static native void jni_YGNodeMarkDirty(long paramLong);

  private static native void jni_YGNodeMarkDirtyAndPropogateToDescendants(long paramLong);

  private native long jni_YGNodeNew();

  private native long jni_YGNodeNewWithConfig(long paramLong);

  private static native void jni_YGNodePrint(long paramLong);

  private static native void jni_YGNodeRemoveChild(long paramLong1, long paramLong2);

  private static native void jni_YGNodeReset(long paramLong);

  private static native void jni_YGNodeSetHasBaselineFunc(long paramLong, boolean paramBoolean);

  private static native void jni_YGNodeSetHasMeasureFunc(long paramLong, boolean paramBoolean);

  private static native void jni_YGNodeSetIsReferenceBaseline(long paramLong, boolean paramBoolean);

  private static native void jni_YGNodeSetOwner(long paramLong1, long paramLong2);

  private static native int jni_YGNodeStyleGetAlignContent(long paramLong);

  private static native int jni_YGNodeStyleGetAlignItems(long paramLong);

  private static native int jni_YGNodeStyleGetAlignSelf(long paramLong);

  private static native float jni_YGNodeStyleGetAspectRatio(long paramLong);

  private static native float jni_YGNodeStyleGetBorder(long paramLong, int paramInt);

  private static native int jni_YGNodeStyleGetDirection(long paramLong);

  private static native int jni_YGNodeStyleGetDisplay(long paramLong);

  private static native Object jni_YGNodeStyleGetFlexBasis(long paramLong);

  private static native int jni_YGNodeStyleGetFlexDirection(long paramLong);

  private static native float jni_YGNodeStyleGetFlexGrow(long paramLong);

  private static native float jni_YGNodeStyleGetFlexShrink(long paramLong);

  private static native Object jni_YGNodeStyleGetHeight(long paramLong);

  private static native int jni_YGNodeStyleGetJustifyContent(long paramLong);

  private static native Object jni_YGNodeStyleGetMargin(long paramLong, int paramInt);

  private static native Object jni_YGNodeStyleGetMaxHeight(long paramLong);

  private static native Object jni_YGNodeStyleGetMaxWidth(long paramLong);

  private static native Object jni_YGNodeStyleGetMinHeight(long paramLong);

  private static native Object jni_YGNodeStyleGetMinWidth(long paramLong);

  private static native int jni_YGNodeStyleGetOverflow(long paramLong);

  private static native Object jni_YGNodeStyleGetPadding(long paramLong, int paramInt);

  private static native Object jni_YGNodeStyleGetPosition(long paramLong, int paramInt);

  private static native int jni_YGNodeStyleGetPositionType(long paramLong);

  private static native Object jni_YGNodeStyleGetWidth(long paramLong);

  private static native void jni_YGNodeStyleSetAlignContent(long paramLong, int paramInt);

  private static native void jni_YGNodeStyleSetAlignItems(long paramLong, int paramInt);

  private static native void jni_YGNodeStyleSetAlignSelf(long paramLong, int paramInt);

  private static native void jni_YGNodeStyleSetAspectRatio(long paramLong, float paramFloat);

  private static native void jni_YGNodeStyleSetBorder(long paramLong, int paramInt, float paramFloat);

  private static native void jni_YGNodeStyleSetDirection(long paramLong, int paramInt);

  private static native void jni_YGNodeStyleSetDisplay(long paramLong, int paramInt);

  private static native void jni_YGNodeStyleSetFlex(long paramLong, float paramFloat);

  private static native void jni_YGNodeStyleSetFlexBasis(long paramLong, float paramFloat);

  private static native void jni_YGNodeStyleSetFlexBasisAuto(long paramLong);

  private static native void jni_YGNodeStyleSetFlexBasisPercent(long paramLong, float paramFloat);

  private static native void jni_YGNodeStyleSetFlexDirection(long paramLong, int paramInt);

  private static native void jni_YGNodeStyleSetFlexGrow(long paramLong, float paramFloat);

  private static native void jni_YGNodeStyleSetFlexShrink(long paramLong, float paramFloat);

  private static native void jni_YGNodeStyleSetFlexWrap(long paramLong, int paramInt);

  private static native void jni_YGNodeStyleSetHeight(long paramLong, float paramFloat);

  private static native void jni_YGNodeStyleSetHeightAuto(long paramLong);

  private static native void jni_YGNodeStyleSetHeightPercent(long paramLong, float paramFloat);

  private static native void jni_YGNodeStyleSetJustifyContent(long paramLong, int paramInt);

  private static native void jni_YGNodeStyleSetMargin(long paramLong, int paramInt, float paramFloat);

  private static native void jni_YGNodeStyleSetMarginAuto(long paramLong, int paramInt);

  private static native void jni_YGNodeStyleSetMarginPercent(long paramLong, int paramInt, float paramFloat);

  private static native void jni_YGNodeStyleSetMaxHeight(long paramLong, float paramFloat);

  private static native void jni_YGNodeStyleSetMaxHeightPercent(long paramLong, float paramFloat);

  private static native void jni_YGNodeStyleSetMaxWidth(long paramLong, float paramFloat);

  private static native void jni_YGNodeStyleSetMaxWidthPercent(long paramLong, float paramFloat);

  private static native void jni_YGNodeStyleSetMinHeight(long paramLong, float paramFloat);

  private static native void jni_YGNodeStyleSetMinHeightPercent(long paramLong, float paramFloat);

  private static native void jni_YGNodeStyleSetMinWidth(long paramLong, float paramFloat);

  private static native void jni_YGNodeStyleSetMinWidthPercent(long paramLong, float paramFloat);

  private static native void jni_YGNodeStyleSetOverflow(long paramLong, int paramInt);

  private static native void jni_YGNodeStyleSetPadding(long paramLong, int paramInt, float paramFloat);

  private static native void jni_YGNodeStyleSetPaddingPercent(long paramLong, int paramInt, float paramFloat);

  private static native void jni_YGNodeStyleSetPosition(long paramLong, int paramInt, float paramFloat);

  private static native void jni_YGNodeStyleSetPositionPercent(long paramLong, int paramInt, float paramFloat);

  private static native void jni_YGNodeStyleSetPositionType(long paramLong, int paramInt);

  private static native void jni_YGNodeStyleSetWidth(long paramLong, float paramFloat);

  private static native void jni_YGNodeStyleSetWidthAuto(long paramLong);

  private static native void jni_YGNodeStyleSetWidthPercent(long paramLong, float paramFloat);

  @DoNotStrip
  private final long replaceChild(YogaNode paramYogaNode, int paramInt)
  {
    if (this.mChildren == null)
      throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
    this.mChildren.remove(paramInt);
    this.mChildren.add(paramInt, paramYogaNode);
    paramYogaNode.mOwner = this;
    return paramYogaNode.mNativePointer;
  }

  public void addChildAt(YogaNode paramYogaNode, int paramInt)
  {
    if (paramYogaNode.mOwner != null)
      throw new IllegalStateException("Child already has a parent, it must be removed first.");
    if (this.mChildren == null)
      this.mChildren = new ArrayList(4);
    this.mChildren.add(paramInt, paramYogaNode);
    paramYogaNode.mOwner = this;
    jni_YGNodeInsertChild(this.mNativePointer, paramYogaNode.mNativePointer, paramInt);
  }

  @DoNotStrip
  public final float baseline(float paramFloat1, float paramFloat2)
  {
    return this.mBaselineFunction.baseline(this, paramFloat1, paramFloat2);
  }

  public void calculateLayout(float paramFloat1, float paramFloat2)
  {
    jni_YGNodeCalculateLayout(this.mNativePointer, paramFloat1, paramFloat2);
  }

  public YogaNode clone()
  {
    YogaNode localYogaNode1;
    long l;
    try
    {
      localYogaNode1 = (YogaNode)super.clone();
      l = jni_YGNodeClone(this.mNativePointer, localYogaNode1);
      if (this.mChildren != null)
      {
        Iterator localIterator2 = this.mChildren.iterator();
        while (localIterator2.hasNext())
        {
          YogaNode localYogaNode2 = (YogaNode)localIterator2.next();
          jni_YGNodeSetOwner(localYogaNode2.mNativePointer, 0L);
          localYogaNode2.mOwner = null;
        }
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
    localYogaNode1.mNativePointer = l;
    localYogaNode1.mOwner = null;
    if (this.mChildren != null);
    for (List localList = (List)((ArrayList)this.mChildren).clone(); ; localList = null)
    {
      localYogaNode1.mChildren = localList;
      if (localYogaNode1.mChildren == null)
        break;
      Iterator localIterator1 = localYogaNode1.mChildren.iterator();
      while (localIterator1.hasNext())
        ((YogaNode)localIterator1.next()).mOwner = null;
    }
    return localYogaNode1;
  }

  public YogaNode cloneWithNewChildren()
  {
    try
    {
      YogaNode localYogaNode = (YogaNode)super.clone();
      long l = jni_YGNodeClone(this.mNativePointer, localYogaNode);
      localYogaNode.mOwner = null;
      localYogaNode.mNativePointer = l;
      localYogaNode.clearChildren();
      return localYogaNode;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }

  public void copyStyle(YogaNode paramYogaNode)
  {
    jni_YGNodeCopyStyle(this.mNativePointer, paramYogaNode.mNativePointer);
  }

  public void dirty()
  {
    jni_YGNodeMarkDirty(this.mNativePointer);
  }

  public void dirtyAllDescendants()
  {
    jni_YGNodeMarkDirtyAndPropogateToDescendants(this.mNativePointer);
  }

  protected void finalize()
    throws Throwable
  {
    try
    {
      freeNatives();
      return;
    }
    finally
    {
      super.finalize();
    }
  }

  public void freeNatives()
  {
    if (this.mNativePointer > 0L)
    {
      long l = this.mNativePointer;
      this.mNativePointer = 0L;
      jni_YGNodeFree(l);
    }
  }

  public YogaAlign getAlignContent()
  {
    return YogaAlign.fromInt(jni_YGNodeStyleGetAlignContent(this.mNativePointer));
  }

  public YogaAlign getAlignItems()
  {
    return YogaAlign.fromInt(jni_YGNodeStyleGetAlignItems(this.mNativePointer));
  }

  public YogaAlign getAlignSelf()
  {
    return YogaAlign.fromInt(jni_YGNodeStyleGetAlignSelf(this.mNativePointer));
  }

  public float getAspectRatio()
  {
    return jni_YGNodeStyleGetAspectRatio(this.mNativePointer);
  }

  public float getBorder(YogaEdge paramYogaEdge)
  {
    if ((0x4 & this.mEdgeSetFlag) != 4)
      return (0.0F / 0.0F);
    return jni_YGNodeStyleGetBorder(this.mNativePointer, paramYogaEdge.intValue());
  }

  public YogaNode getChildAt(int paramInt)
  {
    if (this.mChildren == null)
      throw new IllegalStateException("YogaNode does not have children");
    return (YogaNode)this.mChildren.get(paramInt);
  }

  public int getChildCount()
  {
    if (this.mChildren == null)
      return 0;
    return this.mChildren.size();
  }

  public Object getData()
  {
    return this.mData;
  }

  public YogaDisplay getDisplay()
  {
    return YogaDisplay.fromInt(jni_YGNodeStyleGetDisplay(this.mNativePointer));
  }

  public boolean getDoesLegacyStretchFlagAffectsLayout()
  {
    return this.mDoesLegacyStretchFlagAffectsLayout;
  }

  public YogaValue getFlexBasis()
  {
    return (YogaValue)jni_YGNodeStyleGetFlexBasis(this.mNativePointer);
  }

  public YogaFlexDirection getFlexDirection()
  {
    return YogaFlexDirection.fromInt(jni_YGNodeStyleGetFlexDirection(this.mNativePointer));
  }

  public float getFlexGrow()
  {
    return jni_YGNodeStyleGetFlexGrow(this.mNativePointer);
  }

  public float getFlexShrink()
  {
    return jni_YGNodeStyleGetFlexShrink(this.mNativePointer);
  }

  public YogaValue getHeight()
  {
    return (YogaValue)jni_YGNodeStyleGetHeight(this.mNativePointer);
  }

  public YogaJustify getJustifyContent()
  {
    return YogaJustify.fromInt(jni_YGNodeStyleGetJustifyContent(this.mNativePointer));
  }

  public float getLayoutBorder(YogaEdge paramYogaEdge)
  {
    switch (1.$SwitchMap$com$facebook$yoga$YogaEdge[paramYogaEdge.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Cannot get layout border of multi-edge shorthands");
    case 1:
      return this.mBorderLeft;
    case 2:
      return this.mBorderTop;
    case 3:
      return this.mBorderRight;
    case 4:
      return this.mBorderBottom;
    case 5:
      if (getLayoutDirection() == YogaDirection.RTL)
        return this.mBorderRight;
      return this.mBorderLeft;
    case 6:
    }
    if (getLayoutDirection() == YogaDirection.RTL)
      return this.mBorderLeft;
    return this.mBorderRight;
  }

  public YogaDirection getLayoutDirection()
  {
    return YogaDirection.fromInt(this.mLayoutDirection);
  }

  public float getLayoutHeight()
  {
    return this.mHeight;
  }

  public float getLayoutMargin(YogaEdge paramYogaEdge)
  {
    switch (1.$SwitchMap$com$facebook$yoga$YogaEdge[paramYogaEdge.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Cannot get layout margins of multi-edge shorthands");
    case 1:
      return this.mMarginLeft;
    case 2:
      return this.mMarginTop;
    case 3:
      return this.mMarginRight;
    case 4:
      return this.mMarginBottom;
    case 5:
      if (getLayoutDirection() == YogaDirection.RTL)
        return this.mMarginRight;
      return this.mMarginLeft;
    case 6:
    }
    if (getLayoutDirection() == YogaDirection.RTL)
      return this.mMarginLeft;
    return this.mMarginRight;
  }

  public float getLayoutPadding(YogaEdge paramYogaEdge)
  {
    switch (1.$SwitchMap$com$facebook$yoga$YogaEdge[paramYogaEdge.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
    case 1:
      return this.mPaddingLeft;
    case 2:
      return this.mPaddingTop;
    case 3:
      return this.mPaddingRight;
    case 4:
      return this.mPaddingBottom;
    case 5:
      if (getLayoutDirection() == YogaDirection.RTL)
        return this.mPaddingRight;
      return this.mPaddingLeft;
    case 6:
    }
    if (getLayoutDirection() == YogaDirection.RTL)
      return this.mPaddingLeft;
    return this.mPaddingRight;
  }

  public float getLayoutWidth()
  {
    return this.mWidth;
  }

  public float getLayoutX()
  {
    return this.mLeft;
  }

  public float getLayoutY()
  {
    return this.mTop;
  }

  public YogaValue getMargin(YogaEdge paramYogaEdge)
  {
    if ((0x1 & this.mEdgeSetFlag) != 1)
      return YogaValue.UNDEFINED;
    return (YogaValue)jni_YGNodeStyleGetMargin(this.mNativePointer, paramYogaEdge.intValue());
  }

  public YogaValue getMaxHeight()
  {
    return (YogaValue)jni_YGNodeStyleGetMaxHeight(this.mNativePointer);
  }

  public YogaValue getMaxWidth()
  {
    return (YogaValue)jni_YGNodeStyleGetMaxWidth(this.mNativePointer);
  }

  public YogaValue getMinHeight()
  {
    return (YogaValue)jni_YGNodeStyleGetMinHeight(this.mNativePointer);
  }

  public YogaValue getMinWidth()
  {
    return (YogaValue)jni_YGNodeStyleGetMinWidth(this.mNativePointer);
  }

  public YogaOverflow getOverflow()
  {
    return YogaOverflow.fromInt(jni_YGNodeStyleGetOverflow(this.mNativePointer));
  }

  @Nullable
  public YogaNode getOwner()
  {
    return this.mOwner;
  }

  public YogaValue getPadding(YogaEdge paramYogaEdge)
  {
    if ((0x2 & this.mEdgeSetFlag) != 2)
      return YogaValue.UNDEFINED;
    return (YogaValue)jni_YGNodeStyleGetPadding(this.mNativePointer, paramYogaEdge.intValue());
  }

  @Deprecated
  @Nullable
  public YogaNode getParent()
  {
    return getOwner();
  }

  public YogaValue getPosition(YogaEdge paramYogaEdge)
  {
    if (!this.mHasSetPosition)
      return YogaValue.UNDEFINED;
    return (YogaValue)jni_YGNodeStyleGetPosition(this.mNativePointer, paramYogaEdge.intValue());
  }

  public YogaPositionType getPositionType()
  {
    return YogaPositionType.fromInt(jni_YGNodeStyleGetPositionType(this.mNativePointer));
  }

  public YogaDirection getStyleDirection()
  {
    return YogaDirection.fromInt(jni_YGNodeStyleGetDirection(this.mNativePointer));
  }

  public YogaValue getWidth()
  {
    return (YogaValue)jni_YGNodeStyleGetWidth(this.mNativePointer);
  }

  public boolean hasNewLayout()
  {
    return this.mHasNewLayout;
  }

  public int indexOf(YogaNode paramYogaNode)
  {
    if (this.mChildren == null)
      return -1;
    return this.mChildren.indexOf(paramYogaNode);
  }

  public boolean isDirty()
  {
    return jni_YGNodeIsDirty(this.mNativePointer);
  }

  public boolean isMeasureDefined()
  {
    return this.mMeasureFunction != null;
  }

  public boolean isReferenceBaseline()
  {
    return jni_YGNodeIsReferenceBaseline(this.mNativePointer);
  }

  public void markLayoutSeen()
  {
    this.mHasNewLayout = false;
  }

  @DoNotStrip
  public final long measure(float paramFloat1, int paramInt1, float paramFloat2, int paramInt2)
  {
    if (!isMeasureDefined())
      throw new RuntimeException("Measure function isn't defined!");
    return this.mMeasureFunction.measure(this, paramFloat1, YogaMeasureMode.fromInt(paramInt1), paramFloat2, YogaMeasureMode.fromInt(paramInt2));
  }

  public void print()
  {
    jni_YGNodePrint(this.mNativePointer);
  }

  public YogaNode removeChildAt(int paramInt)
  {
    if (this.mChildren == null)
      throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
    YogaNode localYogaNode = (YogaNode)this.mChildren.remove(paramInt);
    localYogaNode.mOwner = null;
    jni_YGNodeRemoveChild(this.mNativePointer, localYogaNode.mNativePointer);
    return localYogaNode;
  }

  public void reset()
  {
    this.mEdgeSetFlag = 0;
    this.mHasSetPosition = false;
    this.mHasNewLayout = true;
    this.mWidth = (0.0F / 0.0F);
    this.mHeight = (0.0F / 0.0F);
    this.mTop = (0.0F / 0.0F);
    this.mLeft = (0.0F / 0.0F);
    this.mMarginLeft = 0.0F;
    this.mMarginTop = 0.0F;
    this.mMarginRight = 0.0F;
    this.mMarginBottom = 0.0F;
    this.mPaddingLeft = 0.0F;
    this.mPaddingTop = 0.0F;
    this.mPaddingRight = 0.0F;
    this.mPaddingBottom = 0.0F;
    this.mBorderLeft = 0.0F;
    this.mBorderTop = 0.0F;
    this.mBorderRight = 0.0F;
    this.mBorderBottom = 0.0F;
    this.mLayoutDirection = 0;
    this.mMeasureFunction = null;
    this.mBaselineFunction = null;
    this.mData = null;
    this.mDoesLegacyStretchFlagAffectsLayout = false;
    jni_YGNodeReset(this.mNativePointer);
  }

  public void setAlignContent(YogaAlign paramYogaAlign)
  {
    jni_YGNodeStyleSetAlignContent(this.mNativePointer, paramYogaAlign.intValue());
  }

  public void setAlignItems(YogaAlign paramYogaAlign)
  {
    jni_YGNodeStyleSetAlignItems(this.mNativePointer, paramYogaAlign.intValue());
  }

  public void setAlignSelf(YogaAlign paramYogaAlign)
  {
    jni_YGNodeStyleSetAlignSelf(this.mNativePointer, paramYogaAlign.intValue());
  }

  public void setAspectRatio(float paramFloat)
  {
    jni_YGNodeStyleSetAspectRatio(this.mNativePointer, paramFloat);
  }

  public void setBaselineFunction(YogaBaselineFunction paramYogaBaselineFunction)
  {
    this.mBaselineFunction = paramYogaBaselineFunction;
    long l = this.mNativePointer;
    if (paramYogaBaselineFunction != null);
    for (boolean bool = true; ; bool = false)
    {
      jni_YGNodeSetHasBaselineFunc(l, bool);
      return;
    }
  }

  public void setBorder(YogaEdge paramYogaEdge, float paramFloat)
  {
    this.mEdgeSetFlag = (0x4 | this.mEdgeSetFlag);
    jni_YGNodeStyleSetBorder(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
  }

  public void setData(Object paramObject)
  {
    this.mData = paramObject;
  }

  public void setDirection(YogaDirection paramYogaDirection)
  {
    jni_YGNodeStyleSetDirection(this.mNativePointer, paramYogaDirection.intValue());
  }

  public void setDisplay(YogaDisplay paramYogaDisplay)
  {
    jni_YGNodeStyleSetDisplay(this.mNativePointer, paramYogaDisplay.intValue());
  }

  public void setFlex(float paramFloat)
  {
    jni_YGNodeStyleSetFlex(this.mNativePointer, paramFloat);
  }

  public void setFlexBasis(float paramFloat)
  {
    jni_YGNodeStyleSetFlexBasis(this.mNativePointer, paramFloat);
  }

  public void setFlexBasisAuto()
  {
    jni_YGNodeStyleSetFlexBasisAuto(this.mNativePointer);
  }

  public void setFlexBasisPercent(float paramFloat)
  {
    jni_YGNodeStyleSetFlexBasisPercent(this.mNativePointer, paramFloat);
  }

  public void setFlexDirection(YogaFlexDirection paramYogaFlexDirection)
  {
    jni_YGNodeStyleSetFlexDirection(this.mNativePointer, paramYogaFlexDirection.intValue());
  }

  public void setFlexGrow(float paramFloat)
  {
    jni_YGNodeStyleSetFlexGrow(this.mNativePointer, paramFloat);
  }

  public void setFlexShrink(float paramFloat)
  {
    jni_YGNodeStyleSetFlexShrink(this.mNativePointer, paramFloat);
  }

  public void setHeight(float paramFloat)
  {
    jni_YGNodeStyleSetHeight(this.mNativePointer, paramFloat);
  }

  public void setHeightAuto()
  {
    jni_YGNodeStyleSetHeightAuto(this.mNativePointer);
  }

  public void setHeightPercent(float paramFloat)
  {
    jni_YGNodeStyleSetHeightPercent(this.mNativePointer, paramFloat);
  }

  public void setIsReferenceBaseline(boolean paramBoolean)
  {
    jni_YGNodeSetIsReferenceBaseline(this.mNativePointer, paramBoolean);
  }

  public void setJustifyContent(YogaJustify paramYogaJustify)
  {
    jni_YGNodeStyleSetJustifyContent(this.mNativePointer, paramYogaJustify.intValue());
  }

  public void setMargin(YogaEdge paramYogaEdge, float paramFloat)
  {
    this.mEdgeSetFlag = (0x1 | this.mEdgeSetFlag);
    jni_YGNodeStyleSetMargin(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
  }

  public void setMarginAuto(YogaEdge paramYogaEdge)
  {
    this.mEdgeSetFlag = (0x1 | this.mEdgeSetFlag);
    jni_YGNodeStyleSetMarginAuto(this.mNativePointer, paramYogaEdge.intValue());
  }

  public void setMarginPercent(YogaEdge paramYogaEdge, float paramFloat)
  {
    this.mEdgeSetFlag = (0x1 | this.mEdgeSetFlag);
    jni_YGNodeStyleSetMarginPercent(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
  }

  public void setMaxHeight(float paramFloat)
  {
    jni_YGNodeStyleSetMaxHeight(this.mNativePointer, paramFloat);
  }

  public void setMaxHeightPercent(float paramFloat)
  {
    jni_YGNodeStyleSetMaxHeightPercent(this.mNativePointer, paramFloat);
  }

  public void setMaxWidth(float paramFloat)
  {
    jni_YGNodeStyleSetMaxWidth(this.mNativePointer, paramFloat);
  }

  public void setMaxWidthPercent(float paramFloat)
  {
    jni_YGNodeStyleSetMaxWidthPercent(this.mNativePointer, paramFloat);
  }

  public void setMeasureFunction(YogaMeasureFunction paramYogaMeasureFunction)
  {
    this.mMeasureFunction = paramYogaMeasureFunction;
    long l = this.mNativePointer;
    if (paramYogaMeasureFunction != null);
    for (boolean bool = true; ; bool = false)
    {
      jni_YGNodeSetHasMeasureFunc(l, bool);
      return;
    }
  }

  public void setMinHeight(float paramFloat)
  {
    jni_YGNodeStyleSetMinHeight(this.mNativePointer, paramFloat);
  }

  public void setMinHeightPercent(float paramFloat)
  {
    jni_YGNodeStyleSetMinHeightPercent(this.mNativePointer, paramFloat);
  }

  public void setMinWidth(float paramFloat)
  {
    jni_YGNodeStyleSetMinWidth(this.mNativePointer, paramFloat);
  }

  public void setMinWidthPercent(float paramFloat)
  {
    jni_YGNodeStyleSetMinWidthPercent(this.mNativePointer, paramFloat);
  }

  public void setOverflow(YogaOverflow paramYogaOverflow)
  {
    jni_YGNodeStyleSetOverflow(this.mNativePointer, paramYogaOverflow.intValue());
  }

  public void setPadding(YogaEdge paramYogaEdge, float paramFloat)
  {
    this.mEdgeSetFlag = (0x2 | this.mEdgeSetFlag);
    jni_YGNodeStyleSetPadding(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
  }

  public void setPaddingPercent(YogaEdge paramYogaEdge, float paramFloat)
  {
    this.mEdgeSetFlag = (0x2 | this.mEdgeSetFlag);
    jni_YGNodeStyleSetPaddingPercent(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
  }

  public void setPosition(YogaEdge paramYogaEdge, float paramFloat)
  {
    this.mHasSetPosition = true;
    jni_YGNodeStyleSetPosition(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
  }

  public void setPositionPercent(YogaEdge paramYogaEdge, float paramFloat)
  {
    this.mHasSetPosition = true;
    jni_YGNodeStyleSetPositionPercent(this.mNativePointer, paramYogaEdge.intValue(), paramFloat);
  }

  public void setPositionType(YogaPositionType paramYogaPositionType)
  {
    jni_YGNodeStyleSetPositionType(this.mNativePointer, paramYogaPositionType.intValue());
  }

  public void setWidth(float paramFloat)
  {
    jni_YGNodeStyleSetWidth(this.mNativePointer, paramFloat);
  }

  public void setWidthAuto()
  {
    jni_YGNodeStyleSetWidthAuto(this.mNativePointer);
  }

  public void setWidthPercent(float paramFloat)
  {
    jni_YGNodeStyleSetWidthPercent(this.mNativePointer, paramFloat);
  }

  public void setWrap(YogaWrap paramYogaWrap)
  {
    jni_YGNodeStyleSetFlexWrap(this.mNativePointer, paramYogaWrap.intValue());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.yoga.YogaNode
 * JD-Core Version:    0.6.2
 */
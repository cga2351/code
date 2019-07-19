package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.touch.ReactHitSlopView;
import javax.annotation.Nullable;

public class TouchTargetHelper
{
  private static final float[] mEventCoords = new float[2];
  private static final Matrix mInverseMatrix = new Matrix();
  private static final float[] mMatrixTransformCoords;
  private static final PointF mTempPoint = new PointF();

  static
  {
    mMatrixTransformCoords = new float[2];
  }

  private static View findClosestReactAncestor(View paramView)
  {
    while ((paramView != null) && (paramView.getId() <= 0))
      paramView = (View)paramView.getParent();
    return paramView;
  }

  public static int findTargetTagAndCoordinatesForTouch(float paramFloat1, float paramFloat2, ViewGroup paramViewGroup, float[] paramArrayOfFloat, @Nullable int[] paramArrayOfInt)
  {
    UiThreadUtil.assertOnUiThread();
    int i = paramViewGroup.getId();
    paramArrayOfFloat[0] = paramFloat1;
    paramArrayOfFloat[1] = paramFloat2;
    View localView1 = findTouchTargetView(paramArrayOfFloat, paramViewGroup);
    if (localView1 != null)
    {
      View localView2 = findClosestReactAncestor(localView1);
      if (localView2 != null)
      {
        if (paramArrayOfInt != null)
          paramArrayOfInt[0] = localView2.getId();
        i = getTouchTargetForView(localView2, paramArrayOfFloat[0], paramArrayOfFloat[1]);
      }
    }
    return i;
  }

  public static int findTargetTagForTouch(float paramFloat1, float paramFloat2, ViewGroup paramViewGroup)
  {
    return findTargetTagAndCoordinatesForTouch(paramFloat1, paramFloat2, paramViewGroup, mEventCoords, null);
  }

  public static int findTargetTagForTouch(float paramFloat1, float paramFloat2, ViewGroup paramViewGroup, @Nullable int[] paramArrayOfInt)
  {
    return findTargetTagAndCoordinatesForTouch(paramFloat1, paramFloat2, paramViewGroup, mEventCoords, paramArrayOfInt);
  }

  private static View findTouchTargetView(float[] paramArrayOfFloat, ViewGroup paramViewGroup)
  {
    int i = paramViewGroup.getChildCount();
    ReactZIndexedViewGroup localReactZIndexedViewGroup;
    if ((paramViewGroup instanceof ReactZIndexedViewGroup))
      localReactZIndexedViewGroup = (ReactZIndexedViewGroup)paramViewGroup;
    label137: for (int j = i - 1; ; j--)
    {
      if (j >= 0)
        if (localReactZIndexedViewGroup == null)
          break label120;
      float f1;
      float f2;
      label120: for (int k = localReactZIndexedViewGroup.getZIndexMappedChildIndex(j); ; k = j)
      {
        View localView1 = paramViewGroup.getChildAt(k);
        PointF localPointF = mTempPoint;
        if (!isTransformedTouchPointInView(paramArrayOfFloat[0], paramArrayOfFloat[1], paramViewGroup, localView1, localPointF))
          break label137;
        f1 = paramArrayOfFloat[0];
        f2 = paramArrayOfFloat[1];
        paramArrayOfFloat[0] = localPointF.x;
        paramArrayOfFloat[1] = localPointF.y;
        View localView2 = findTouchTargetViewWithPointerEvents(paramArrayOfFloat, localView1);
        if (localView2 == null)
          break label127;
        paramViewGroup = localView2;
        return paramViewGroup;
        localReactZIndexedViewGroup = null;
        break;
      }
      label127: paramArrayOfFloat[0] = f1;
      paramArrayOfFloat[1] = f2;
    }
  }

  @Nullable
  private static View findTouchTargetViewWithPointerEvents(float[] paramArrayOfFloat, View paramView)
  {
    PointerEvents localPointerEvents;
    if ((paramView instanceof ReactPointerEventsView))
    {
      localPointerEvents = ((ReactPointerEventsView)paramView).getPointerEvents();
      if (!paramView.isEnabled())
      {
        if (localPointerEvents != PointerEvents.AUTO)
          break label53;
        localPointerEvents = PointerEvents.BOX_NONE;
      }
      label35: if (localPointerEvents != PointerEvents.NONE)
        break label67;
      paramView = null;
    }
    label53: label67: 
    do
    {
      do
      {
        do
        {
          return paramView;
          localPointerEvents = PointerEvents.AUTO;
          break;
          if (localPointerEvents != PointerEvents.BOX_ONLY)
            break label35;
          localPointerEvents = PointerEvents.NONE;
          break label35;
        }
        while (localPointerEvents == PointerEvents.BOX_ONLY);
        if (localPointerEvents != PointerEvents.BOX_NONE)
          break label135;
        if (!(paramView instanceof ViewGroup))
          break label133;
        View localView = findTouchTargetView(paramArrayOfFloat, (ViewGroup)paramView);
        if (localView != paramView)
          return localView;
      }
      while (((paramView instanceof ReactCompoundView)) && (((ReactCompoundView)paramView).reactTagForTouch(paramArrayOfFloat[0], paramArrayOfFloat[1]) != paramView.getId()));
      return null;
      if (localPointerEvents != PointerEvents.AUTO)
        break label183;
    }
    while ((((paramView instanceof ReactCompoundViewGroup)) && (((ReactCompoundViewGroup)paramView).interceptsTouchEvent(paramArrayOfFloat[0], paramArrayOfFloat[1]))) || (!(paramView instanceof ViewGroup)));
    label133: label135: return findTouchTargetView(paramArrayOfFloat, (ViewGroup)paramView);
    label183: throw new JSApplicationIllegalArgumentException("Unknown pointer event type: " + localPointerEvents.toString());
  }

  private static int getTouchTargetForView(View paramView, float paramFloat1, float paramFloat2)
  {
    if ((paramView instanceof ReactCompoundView))
      return ((ReactCompoundView)paramView).reactTagForTouch(paramFloat1, paramFloat2);
    return paramView.getId();
  }

  private static boolean isTransformedTouchPointInView(float paramFloat1, float paramFloat2, ViewGroup paramViewGroup, View paramView, PointF paramPointF)
  {
    float f1 = paramFloat1 + paramViewGroup.getScrollX() - paramView.getLeft();
    float f2 = paramFloat2 + paramViewGroup.getScrollY() - paramView.getTop();
    Matrix localMatrix1 = paramView.getMatrix();
    float f6;
    float f3;
    if (!localMatrix1.isIdentity())
    {
      float[] arrayOfFloat = mMatrixTransformCoords;
      arrayOfFloat[0] = f1;
      arrayOfFloat[1] = f2;
      Matrix localMatrix2 = mInverseMatrix;
      localMatrix1.invert(localMatrix2);
      localMatrix2.mapPoints(arrayOfFloat);
      float f5 = arrayOfFloat[0];
      f6 = arrayOfFloat[1];
      f3 = f5;
    }
    for (float f4 = f6; ; f4 = f2)
    {
      if (((paramView instanceof ReactHitSlopView)) && (((ReactHitSlopView)paramView).getHitSlopRect() != null))
      {
        Rect localRect = ((ReactHitSlopView)paramView).getHitSlopRect();
        if ((f3 >= -localRect.left) && (f3 < paramView.getRight() - paramView.getLeft() + localRect.right) && (f4 >= -localRect.top) && (f4 < paramView.getBottom() - paramView.getTop() + localRect.bottom))
        {
          paramPointF.set(f3, f4);
          return true;
        }
        return false;
      }
      if ((f3 >= 0.0F) && (f3 < paramView.getRight() - paramView.getLeft()) && (f4 >= 0.0F) && (f4 < paramView.getBottom() - paramView.getTop()))
      {
        paramPointF.set(f3, f4);
        return true;
      }
      return false;
      f3 = f1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.TouchTargetHelper
 * JD-Core Version:    0.6.2
 */
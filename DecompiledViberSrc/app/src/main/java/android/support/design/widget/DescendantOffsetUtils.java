package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class DescendantOffsetUtils
{
  private static final ThreadLocal<Matrix> matrix = new ThreadLocal();
  private static final ThreadLocal<RectF> rectF = new ThreadLocal();

  public static void getDescendantRect(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
    offsetDescendantRect(paramViewGroup, paramView, paramRect);
  }

  private static void offsetDescendantMatrix(ViewParent paramViewParent, View paramView, Matrix paramMatrix)
  {
    ViewParent localViewParent = paramView.getParent();
    if (((localViewParent instanceof View)) && (localViewParent != paramViewParent))
    {
      View localView = (View)localViewParent;
      offsetDescendantMatrix(paramViewParent, localView, paramMatrix);
      paramMatrix.preTranslate(-localView.getScrollX(), -localView.getScrollY());
    }
    paramMatrix.preTranslate(paramView.getLeft(), paramView.getTop());
    if (!paramView.getMatrix().isIdentity())
      paramMatrix.preConcat(paramView.getMatrix());
  }

  public static void offsetDescendantRect(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    Matrix localMatrix1 = (Matrix)matrix.get();
    Matrix localMatrix2;
    if (localMatrix1 == null)
    {
      localMatrix2 = new Matrix();
      matrix.set(localMatrix2);
    }
    for (Matrix localMatrix3 = localMatrix2; ; localMatrix3 = localMatrix1)
    {
      offsetDescendantMatrix(paramViewGroup, paramView, localMatrix3);
      RectF localRectF = (RectF)rectF.get();
      if (localRectF == null)
      {
        localRectF = new RectF();
        rectF.set(localRectF);
      }
      localRectF.set(paramRect);
      localMatrix3.mapRect(localRectF);
      paramRect.set((int)(0.5F + localRectF.left), (int)(0.5F + localRectF.top), (int)(0.5F + localRectF.right), (int)(0.5F + localRectF.bottom));
      return;
      localMatrix1.reset();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.DescendantOffsetUtils
 * JD-Core Version:    0.6.2
 */
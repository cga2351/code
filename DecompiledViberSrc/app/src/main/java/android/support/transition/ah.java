package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;

class ah
{
  public float a(View paramView)
  {
    Float localFloat = (Float)paramView.getTag(R.id.save_non_transition_alpha);
    if (localFloat != null)
      return paramView.getAlpha() / localFloat.floatValue();
    return paramView.getAlpha();
  }

  public void a(View paramView, float paramFloat)
  {
    Float localFloat = (Float)paramView.getTag(R.id.save_non_transition_alpha);
    if (localFloat != null)
    {
      paramView.setAlpha(paramFloat * localFloat.floatValue());
      return;
    }
    paramView.setAlpha(paramFloat);
  }

  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.setLeft(paramInt1);
    paramView.setTop(paramInt2);
    paramView.setRight(paramInt3);
    paramView.setBottom(paramInt4);
  }

  public void a(View paramView, Matrix paramMatrix)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent instanceof View))
    {
      View localView = (View)localViewParent;
      a(localView, paramMatrix);
      paramMatrix.preTranslate(-localView.getScrollX(), -localView.getScrollY());
    }
    paramMatrix.preTranslate(paramView.getLeft(), paramView.getTop());
    Matrix localMatrix = paramView.getMatrix();
    if (!localMatrix.isIdentity())
      paramMatrix.preConcat(localMatrix);
  }

  public void b(View paramView)
  {
    if (paramView.getTag(R.id.save_non_transition_alpha) == null)
      paramView.setTag(R.id.save_non_transition_alpha, Float.valueOf(paramView.getAlpha()));
  }

  public void b(View paramView, Matrix paramMatrix)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent instanceof View))
    {
      View localView = (View)localViewParent;
      b(localView, paramMatrix);
      paramMatrix.postTranslate(localView.getScrollX(), localView.getScrollY());
    }
    paramMatrix.postTranslate(paramView.getLeft(), paramView.getTop());
    Matrix localMatrix1 = paramView.getMatrix();
    if (!localMatrix1.isIdentity())
    {
      Matrix localMatrix2 = new Matrix();
      if (localMatrix1.invert(localMatrix2))
        paramMatrix.postConcat(localMatrix2);
    }
  }

  public void c(View paramView)
  {
    if (paramView.getVisibility() == 0)
      paramView.setTag(R.id.save_non_transition_alpha, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.ah
 * JD-Core Version:    0.6.2
 */
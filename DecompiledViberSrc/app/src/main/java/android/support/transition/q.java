package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

class q
{
  private static final boolean a;
  private static final boolean b;
  private static final boolean c;

  static
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool2 = bool1;
      a = bool2;
      if (Build.VERSION.SDK_INT < 18)
        break label48;
      bool3 = bool1;
      label26: b = bool3;
      if (Build.VERSION.SDK_INT < 28)
        break label53;
    }
    while (true)
    {
      c = bool1;
      return;
      bool2 = false;
      break;
      label48: bool3 = false;
      break label26;
      label53: bool1 = false;
    }
  }

  static Animator a(Animator paramAnimator1, Animator paramAnimator2)
  {
    if (paramAnimator1 == null)
      return paramAnimator2;
    if (paramAnimator2 == null)
      return paramAnimator1;
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { paramAnimator1, paramAnimator2 });
    return localAnimatorSet;
  }

  private static Bitmap a(View paramView, Matrix paramMatrix, RectF paramRectF, ViewGroup paramViewGroup)
  {
    int i;
    boolean bool;
    if (a)
      if (!paramView.isAttachedToWindow())
      {
        i = 1;
        if (paramViewGroup != null)
          break label51;
        bool = false;
      }
    Bitmap localBitmap;
    label51: ViewGroup localViewGroup;
    int j;
    while (true)
      if ((b) && (i != 0))
      {
        localBitmap = null;
        if (!bool)
        {
          return localBitmap;
          i = 0;
          break;
          bool = paramViewGroup.isAttachedToWindow();
          continue;
          bool = false;
          i = 0;
          continue;
        }
        localViewGroup = (ViewGroup)paramView.getParent();
        j = localViewGroup.indexOfChild(paramView);
        paramViewGroup.getOverlay().add(paramView);
      }
    while (true)
    {
      int k = Math.round(paramRectF.width());
      int m = Math.round(paramRectF.height());
      localBitmap = null;
      int n;
      int i1;
      if (k > 0)
      {
        localBitmap = null;
        if (m > 0)
        {
          float f = Math.min(1.0F, 1048576.0F / (k * m));
          n = Math.round(f * k);
          i1 = Math.round(f * m);
          paramMatrix.postTranslate(-paramRectF.left, -paramRectF.top);
          paramMatrix.postScale(f, f);
          if (!c)
            break label269;
          Picture localPicture = new Picture();
          Canvas localCanvas1 = localPicture.beginRecording(n, i1);
          localCanvas1.concat(paramMatrix);
          paramView.draw(localCanvas1);
          localPicture.endRecording();
          localBitmap = Bitmap.createBitmap(localPicture);
        }
      }
      while ((b) && (i != 0))
      {
        paramViewGroup.getOverlay().remove(paramView);
        localViewGroup.addView(paramView, j);
        return localBitmap;
        label269: localBitmap = Bitmap.createBitmap(n, i1, Bitmap.Config.ARGB_8888);
        Canvas localCanvas2 = new Canvas(localBitmap);
        localCanvas2.concat(paramMatrix);
        paramView.draw(localCanvas2);
      }
      break;
      localViewGroup = null;
      j = 0;
    }
  }

  static View a(ViewGroup paramViewGroup, View paramView1, View paramView2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setTranslate(-paramView2.getScrollX(), -paramView2.getScrollY());
    ad.a(paramView1, localMatrix);
    ad.b(paramViewGroup, localMatrix);
    RectF localRectF = new RectF(0.0F, 0.0F, paramView1.getWidth(), paramView1.getHeight());
    localMatrix.mapRect(localRectF);
    int i = Math.round(localRectF.left);
    int j = Math.round(localRectF.top);
    int k = Math.round(localRectF.right);
    int m = Math.round(localRectF.bottom);
    ImageView localImageView = new ImageView(paramView1.getContext());
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    Bitmap localBitmap = a(paramView1, localMatrix, localRectF, paramViewGroup);
    if (localBitmap != null)
      localImageView.setImageBitmap(localBitmap);
    localImageView.measure(View.MeasureSpec.makeMeasureSpec(k - i, 1073741824), View.MeasureSpec.makeMeasureSpec(m - j, 1073741824));
    localImageView.layout(i, j, k, m);
    return localImageView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.q
 * JD-Core Version:    0.6.2
 */
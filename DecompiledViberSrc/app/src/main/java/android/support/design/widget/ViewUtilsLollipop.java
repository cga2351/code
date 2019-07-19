package android.support.design.widget;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.R.attr;
import android.support.design.R.integer;
import android.support.design.internal.j;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;

class ViewUtilsLollipop
{
  private static final int[] STATE_LIST_ANIM_ATTRS = { 16843848 };

  static void setBoundsViewOutlineProvider(View paramView)
  {
    paramView.setOutlineProvider(ViewOutlineProvider.BOUNDS);
  }

  static void setDefaultAppBarLayoutStateListAnimator(View paramView, float paramFloat)
  {
    int i = paramView.getResources().getInteger(R.integer.app_bar_elevation_anim_duration);
    StateListAnimator localStateListAnimator = new StateListAnimator();
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = 16842766;
    arrayOfInt[1] = R.attr.state_liftable;
    arrayOfInt[2] = (-R.attr.state_lifted);
    localStateListAnimator.addState(arrayOfInt, ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F }).setDuration(i));
    localStateListAnimator.addState(new int[] { 16842766 }, ObjectAnimator.ofFloat(paramView, "elevation", new float[] { paramFloat }).setDuration(i));
    localStateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(paramView, "elevation", new float[] { 0.0F }).setDuration(0L));
    paramView.setStateListAnimator(localStateListAnimator);
  }

  static void setStateListAnimatorFromAttrs(View paramView, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    Context localContext = paramView.getContext();
    TypedArray localTypedArray = j.a(localContext, paramAttributeSet, STATE_LIST_ANIM_ATTRS, paramInt1, paramInt2, new int[0]);
    try
    {
      if (localTypedArray.hasValue(0))
        paramView.setStateListAnimator(AnimatorInflater.loadStateListAnimator(localContext, localTypedArray.getResourceId(0, 0)));
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.ViewUtilsLollipop
 * JD-Core Version:    0.6.2
 */
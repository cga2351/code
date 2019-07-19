package android.support.design.transformation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.design.a.b;
import android.support.design.a.i;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior
{
  public static final long COLLAPSE_DELAY = 0L;
  public static final long COLLAPSE_DURATION = 150L;
  public static final long EXPAND_DELAY = 75L;
  public static final long EXPAND_DURATION = 150L;
  private final i collapseTiming = new i(0L, 150L);
  private final i expandTiming = new i(75L, 150L);

  public FabTransformationScrimBehavior()
  {
  }

  public FabTransformationScrimBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void createScrimAnimation(View paramView, boolean paramBoolean1, boolean paramBoolean2, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    i locali;
    if (paramBoolean1)
    {
      locali = this.expandTiming;
      if (!paramBoolean1)
        break label66;
      if (!paramBoolean2)
        paramView.setAlpha(0.0F);
    }
    label66: for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 1.0F }); ; localObjectAnimator = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 0.0F }))
    {
      locali.a(localObjectAnimator);
      paramList.add(localObjectAnimator);
      return;
      locali = this.collapseTiming;
      break;
    }
  }

  public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    return paramView2 instanceof FloatingActionButton;
  }

  protected AnimatorSet onCreateExpandedStateChangeAnimation(View paramView1, final View paramView2, final boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    createScrimAnimation(paramView2, paramBoolean1, paramBoolean2, localArrayList, new ArrayList());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    b.a(localAnimatorSet, localArrayList);
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (!paramBoolean1)
          paramView2.setVisibility(4);
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        if (paramBoolean1)
          paramView2.setVisibility(0);
      }
    });
    return localAnimatorSet;
  }

  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, View paramView, MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramCoordinatorLayout, paramView, paramMotionEvent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.transformation.FabTransformationScrimBehavior
 * JD-Core Version:    0.6.2
 */
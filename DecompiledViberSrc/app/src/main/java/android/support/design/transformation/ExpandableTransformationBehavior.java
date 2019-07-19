package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public abstract class ExpandableTransformationBehavior extends ExpandableBehavior
{
  private AnimatorSet currentAnimation;

  public ExpandableTransformationBehavior()
  {
  }

  public ExpandableTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  protected abstract AnimatorSet onCreateExpandedStateChangeAnimation(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);

  protected boolean onExpandedStateChange(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.currentAnimation != null);
    for (boolean bool = true; ; bool = false)
    {
      if (bool)
        this.currentAnimation.cancel();
      this.currentAnimation = onCreateExpandedStateChangeAnimation(paramView1, paramView2, paramBoolean1, bool);
      this.currentAnimation.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          ExpandableTransformationBehavior.access$002(ExpandableTransformationBehavior.this, null);
        }
      });
      this.currentAnimation.start();
      if (!paramBoolean2)
        this.currentAnimation.end();
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.transformation.ExpandableTransformationBehavior
 * JD-Core Version:    0.6.2
 */
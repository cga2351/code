package android.support.design.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.behavior.HideBottomViewOnScrollBehavior;
import android.support.design.g.c;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.AttachedBehavior;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BottomAppBar extends Toolbar
  implements CoordinatorLayout.AttachedBehavior
{
  AnimatorListenerAdapter a;
  private final int b;
  private final c c;
  private final a d;
  private Animator e;
  private Animator f;
  private Animator g;
  private int h;
  private boolean i;
  private boolean j;

  private float a(boolean paramBoolean)
  {
    FloatingActionButton localFloatingActionButton = a();
    if (localFloatingActionButton == null)
      return 0.0F;
    Rect localRect = new Rect();
    localFloatingActionButton.getContentRect(localRect);
    float f1 = localRect.height();
    if (f1 == 0.0F)
      f1 = localFloatingActionButton.getMeasuredHeight();
    float f2 = localFloatingActionButton.getHeight() - localRect.bottom;
    float f3 = localFloatingActionButton.getHeight() - localRect.height();
    float f4 = f2 + (-getCradleVerticalOffset() + f1 / 2.0F);
    float f5 = f3 - localFloatingActionButton.getPaddingBottom();
    float f6 = -getMeasuredHeight();
    if (paramBoolean);
    while (true)
    {
      return f4 + f6;
      f4 = f5;
    }
  }

  private FloatingActionButton a()
  {
    if (!(getParent() instanceof CoordinatorLayout))
      return null;
    Iterator localIterator = ((CoordinatorLayout)getParent()).getDependents(this).iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if ((localView instanceof FloatingActionButton))
        return (FloatingActionButton)localView;
    }
    return null;
  }

  private void a(int paramInt)
  {
    if ((this.h == paramInt) || (!ViewCompat.isLaidOut(this)))
      return;
    if (this.f != null)
      this.f.cancel();
    ArrayList localArrayList = new ArrayList();
    a(paramInt, localArrayList);
    b(paramInt, localArrayList);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(localArrayList);
    this.f = localAnimatorSet;
    this.f.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        BottomAppBar.a(BottomAppBar.this, null);
      }
    });
    this.f.start();
  }

  private void a(int paramInt, List<Animator> paramList)
  {
    if (!this.j)
      return;
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = this.d.a();
    arrayOfFloat[1] = b(paramInt);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(arrayOfFloat);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        BottomAppBar.a(BottomAppBar.this).a(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
        BottomAppBar.b(BottomAppBar.this).invalidateSelf();
      }
    });
    localValueAnimator.setDuration(300L);
    paramList.add(localValueAnimator);
  }

  private void a(int paramInt, boolean paramBoolean)
  {
    int k = 0;
    if (!ViewCompat.isLaidOut(this))
      return;
    if (this.g != null)
      this.g.cancel();
    ArrayList localArrayList = new ArrayList();
    if (!b())
      paramBoolean = false;
    while (true)
    {
      a(k, paramBoolean, localArrayList);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(localArrayList);
      this.g = localAnimatorSet;
      this.g.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          BottomAppBar.b(BottomAppBar.this, null);
        }
      });
      this.g.start();
      return;
      k = paramInt;
    }
  }

  private void a(final int paramInt, final boolean paramBoolean, List<Animator> paramList)
  {
    final ActionMenuView localActionMenuView = getActionMenuView();
    if (localActionMenuView == null);
    ObjectAnimator localObjectAnimator1;
    do
    {
      return;
      localObjectAnimator1 = ObjectAnimator.ofFloat(localActionMenuView, "alpha", new float[] { 1.0F });
      if (((this.j) || ((paramBoolean) && (b()))) && ((this.h == 1) || (paramInt == 1)))
      {
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localActionMenuView, "alpha", new float[] { 0.0F });
        localObjectAnimator2.addListener(new AnimatorListenerAdapter()
        {
          public boolean a;

          public void onAnimationCancel(Animator paramAnonymousAnimator)
          {
            this.a = true;
          }

          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            if (!this.a)
              BottomAppBar.a(BottomAppBar.this, localActionMenuView, paramInt, paramBoolean);
          }
        });
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.setDuration(150L);
        localAnimatorSet.playSequentially(new Animator[] { localObjectAnimator2, localObjectAnimator1 });
        paramList.add(localAnimatorSet);
        return;
      }
    }
    while (localActionMenuView.getAlpha() >= 1.0F);
    paramList.add(localObjectAnimator1);
  }

  private void a(FloatingActionButton paramFloatingActionButton)
  {
    b(paramFloatingActionButton);
    paramFloatingActionButton.addOnHideAnimationListener(this.a);
    paramFloatingActionButton.addOnShowAnimationListener(this.a);
  }

  private void a(ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean)
  {
    int k;
    int m;
    int n;
    label17: View localView;
    int i3;
    if (ViewCompat.getLayoutDirection(this) == 1)
    {
      k = 1;
      m = 0;
      n = 0;
      if (m >= getChildCount())
        break label121;
      localView = getChildAt(m);
      if ((!(localView.getLayoutParams() instanceof Toolbar.LayoutParams)) || ((0x800007 & ((Toolbar.LayoutParams)localView.getLayoutParams()).gravity) != 8388611))
        break label105;
      i3 = 1;
      label67: if (i3 != 0)
        if (k == 0)
          break label111;
    }
    label105: label111: for (int i4 = localView.getLeft(); ; i4 = localView.getRight())
    {
      n = Math.max(n, i4);
      m++;
      break label17;
      k = 0;
      break;
      i3 = 0;
      break label67;
    }
    label121: int i1;
    int i2;
    if (k != 0)
    {
      i1 = paramActionMenuView.getRight();
      i2 = n - i1;
      if ((paramInt != 1) || (!paramBoolean))
        break label169;
    }
    label169: for (float f1 = i2; ; f1 = 0.0F)
    {
      paramActionMenuView.setTranslationX(f1);
      return;
      i1 = paramActionMenuView.getLeft();
      break;
    }
  }

  private int b(int paramInt)
  {
    int k = 1;
    if (ViewCompat.getLayoutDirection(this) == k);
    for (int m = k; paramInt == k; m = 0)
    {
      int n = getMeasuredWidth() / 2 - this.b;
      if (m != 0)
        k = -1;
      return k * n;
    }
    return 0;
  }

  private void b(int paramInt, List<Animator> paramList)
  {
    FloatingActionButton localFloatingActionButton = a();
    float[] arrayOfFloat = new float[1];
    arrayOfFloat[0] = b(paramInt);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localFloatingActionButton, "translationX", arrayOfFloat);
    localObjectAnimator.setDuration(300L);
    paramList.add(localObjectAnimator);
  }

  private void b(FloatingActionButton paramFloatingActionButton)
  {
    paramFloatingActionButton.removeOnHideAnimationListener(this.a);
    paramFloatingActionButton.removeOnShowAnimationListener(this.a);
  }

  private boolean b()
  {
    FloatingActionButton localFloatingActionButton = a();
    return (localFloatingActionButton != null) && (localFloatingActionButton.isOrWillBeShown());
  }

  private void c()
  {
    if (this.e != null)
      this.e.cancel();
    if (this.g != null)
      this.g.cancel();
    if (this.f != null)
      this.f.cancel();
  }

  private boolean d()
  {
    return ((this.e != null) && (this.e.isRunning())) || ((this.g != null) && (this.g.isRunning())) || ((this.f != null) && (this.f.isRunning()));
  }

  private void e()
  {
    this.d.a(getFabTranslationX());
    FloatingActionButton localFloatingActionButton = a();
    c localc = this.c;
    if ((this.j) && (b()));
    ActionMenuView localActionMenuView;
    for (float f1 = 1.0F; ; f1 = 0.0F)
    {
      localc.a(f1);
      if (localFloatingActionButton != null)
      {
        localFloatingActionButton.setTranslationY(getFabTranslationY());
        localFloatingActionButton.setTranslationX(getFabTranslationX());
      }
      localActionMenuView = getActionMenuView();
      if (localActionMenuView != null)
      {
        localActionMenuView.setAlpha(1.0F);
        if (b())
          break;
        a(localActionMenuView, 0, false);
      }
      return;
    }
    a(localActionMenuView, this.h, this.j);
  }

  private ActionMenuView getActionMenuView()
  {
    for (int k = 0; k < getChildCount(); k++)
    {
      View localView = getChildAt(k);
      if ((localView instanceof ActionMenuView))
        return (ActionMenuView)localView;
    }
    return null;
  }

  private float getFabTranslationX()
  {
    return b(this.h);
  }

  private float getFabTranslationY()
  {
    return a(this.j);
  }

  public ColorStateList getBackgroundTint()
  {
    return this.c.a();
  }

  public CoordinatorLayout.Behavior<BottomAppBar> getBehavior()
  {
    return new Behavior();
  }

  public float getCradleVerticalOffset()
  {
    return this.d.b();
  }

  public int getFabAlignmentMode()
  {
    return this.h;
  }

  public float getFabCradleMargin()
  {
    return this.d.d();
  }

  public float getFabCradleRoundedCornerRadius()
  {
    return this.d.e();
  }

  public boolean getHideOnScroll()
  {
    return this.i;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    c();
    e();
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    this.h = localSavedState.fabAlignmentMode;
    this.j = localSavedState.fabAttached;
  }

  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.fabAlignmentMode = this.h;
    localSavedState.fabAttached = this.j;
    return localSavedState;
  }

  public void setBackgroundTint(ColorStateList paramColorStateList)
  {
    DrawableCompat.setTintList(this.c, paramColorStateList);
  }

  public void setCradleVerticalOffset(float paramFloat)
  {
    if (paramFloat != getCradleVerticalOffset())
    {
      this.d.b(paramFloat);
      this.c.invalidateSelf();
    }
  }

  public void setFabAlignmentMode(int paramInt)
  {
    a(paramInt);
    a(paramInt, this.j);
    this.h = paramInt;
  }

  public void setFabCradleMargin(float paramFloat)
  {
    if (paramFloat != getFabCradleMargin())
    {
      this.d.d(paramFloat);
      this.c.invalidateSelf();
    }
  }

  public void setFabCradleRoundedCornerRadius(float paramFloat)
  {
    if (paramFloat != getFabCradleRoundedCornerRadius())
    {
      this.d.e(paramFloat);
      this.c.invalidateSelf();
    }
  }

  void setFabDiameter(int paramInt)
  {
    if (paramInt != this.d.c())
    {
      this.d.c(paramInt);
      this.c.invalidateSelf();
    }
  }

  public void setHideOnScroll(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public void setSubtitle(CharSequence paramCharSequence)
  {
  }

  public void setTitle(CharSequence paramCharSequence)
  {
  }

  public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar>
  {
    private final Rect fabContentRect = new Rect();

    public Behavior()
    {
    }

    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }

    private boolean updateFabPositionAndVisibility(FloatingActionButton paramFloatingActionButton, BottomAppBar paramBottomAppBar)
    {
      ((CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams()).anchorGravity = 17;
      BottomAppBar.a(paramBottomAppBar, paramFloatingActionButton);
      return true;
    }

    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, BottomAppBar paramBottomAppBar, int paramInt)
    {
      FloatingActionButton localFloatingActionButton = BottomAppBar.c(paramBottomAppBar);
      if (localFloatingActionButton != null)
      {
        updateFabPositionAndVisibility(localFloatingActionButton, paramBottomAppBar);
        localFloatingActionButton.getMeasuredContentRect(this.fabContentRect);
        paramBottomAppBar.setFabDiameter(this.fabContentRect.height());
      }
      if (!BottomAppBar.d(paramBottomAppBar))
        BottomAppBar.e(paramBottomAppBar);
      paramCoordinatorLayout.onLayoutChild(paramBottomAppBar, paramInt);
      return super.onLayoutChild(paramCoordinatorLayout, paramBottomAppBar, paramInt);
    }

    public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, BottomAppBar paramBottomAppBar, View paramView1, View paramView2, int paramInt1, int paramInt2)
    {
      return (paramBottomAppBar.getHideOnScroll()) && (super.onStartNestedScroll(paramCoordinatorLayout, paramBottomAppBar, paramView1, paramView2, paramInt1, paramInt2));
    }

    protected void slideDown(BottomAppBar paramBottomAppBar)
    {
      super.slideDown(paramBottomAppBar);
      FloatingActionButton localFloatingActionButton = BottomAppBar.c(paramBottomAppBar);
      if (localFloatingActionButton != null)
      {
        localFloatingActionButton.getContentRect(this.fabContentRect);
        float f = localFloatingActionButton.getMeasuredHeight() - this.fabContentRect.height();
        localFloatingActionButton.clearAnimation();
        localFloatingActionButton.animate().translationY(f + -localFloatingActionButton.getPaddingBottom()).setInterpolator(android.support.design.a.a.c).setDuration(175L);
      }
    }

    protected void slideUp(BottomAppBar paramBottomAppBar)
    {
      super.slideUp(paramBottomAppBar);
      FloatingActionButton localFloatingActionButton = BottomAppBar.c(paramBottomAppBar);
      if (localFloatingActionButton != null)
      {
        localFloatingActionButton.clearAnimation();
        localFloatingActionButton.animate().translationY(BottomAppBar.f(paramBottomAppBar)).setInterpolator(android.support.design.a.a.d).setDuration(225L);
      }
    }
  }

  static class SavedState extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public BottomAppBar.SavedState a(Parcel paramAnonymousParcel)
      {
        return new BottomAppBar.SavedState(paramAnonymousParcel, null);
      }

      public BottomAppBar.SavedState a(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new BottomAppBar.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }

      public BottomAppBar.SavedState[] a(int paramAnonymousInt)
      {
        return new BottomAppBar.SavedState[paramAnonymousInt];
      }
    };
    int fabAlignmentMode;
    boolean fabAttached;

    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.fabAlignmentMode = paramParcel.readInt();
      if (paramParcel.readInt() != 0);
      for (boolean bool = true; ; bool = false)
      {
        this.fabAttached = bool;
        return;
      }
    }

    public SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.fabAlignmentMode);
      if (this.fabAttached);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeInt(i);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.bottomappbar.BottomAppBar
 * JD-Core Version:    0.6.2
 */
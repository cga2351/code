package android.support.design.transformation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.R.id;
import android.support.design.a.e;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.design.a.j;
import android.support.design.c.d.c;
import android.support.design.c.d.d;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.MathUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior
{
  private final int[] tmpArray = new int[2];
  private final Rect tmpRect = new Rect();
  private final RectF tmpRectF1 = new RectF();
  private final RectF tmpRectF2 = new RectF();

  public FabTransformationBehavior()
  {
  }

  public FabTransformationBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private ViewGroup calculateChildContentContainer(View paramView)
  {
    View localView = paramView.findViewById(R.id.mtrl_child_content_container);
    if (localView != null)
      return toViewGroupOrNull(localView);
    if (((paramView instanceof b)) || ((paramView instanceof a)))
      return toViewGroupOrNull(((ViewGroup)paramView).getChildAt(0));
    return toViewGroupOrNull(paramView);
  }

  private void calculateChildVisibleBoundsAtEndOfExpansion(View paramView, a parama, i parami1, i parami2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, RectF paramRectF)
  {
    float f1 = calculateValueOfAnimationAtEndOfExpansion(parama, parami1, paramFloat1, paramFloat3);
    float f2 = calculateValueOfAnimationAtEndOfExpansion(parama, parami2, paramFloat2, paramFloat4);
    Rect localRect = this.tmpRect;
    paramView.getWindowVisibleDisplayFrame(localRect);
    RectF localRectF1 = this.tmpRectF1;
    localRectF1.set(localRect);
    RectF localRectF2 = this.tmpRectF2;
    calculateWindowBounds(paramView, localRectF2);
    localRectF2.offset(f1, f2);
    localRectF2.intersect(localRectF1);
    paramRectF.set(localRectF2);
  }

  private float calculateRevealCenterX(View paramView1, View paramView2, j paramj)
  {
    RectF localRectF1 = this.tmpRectF1;
    RectF localRectF2 = this.tmpRectF2;
    calculateWindowBounds(paramView1, localRectF1);
    calculateWindowBounds(paramView2, localRectF2);
    localRectF2.offset(-calculateTranslationX(paramView1, paramView2, paramj), 0.0F);
    return localRectF1.centerX() - localRectF2.left;
  }

  private float calculateRevealCenterY(View paramView1, View paramView2, j paramj)
  {
    RectF localRectF1 = this.tmpRectF1;
    RectF localRectF2 = this.tmpRectF2;
    calculateWindowBounds(paramView1, localRectF1);
    calculateWindowBounds(paramView2, localRectF2);
    localRectF2.offset(0.0F, -calculateTranslationY(paramView1, paramView2, paramj));
    return localRectF1.centerY() - localRectF2.top;
  }

  private float calculateTranslationX(View paramView1, View paramView2, j paramj)
  {
    RectF localRectF1 = this.tmpRectF1;
    RectF localRectF2 = this.tmpRectF2;
    calculateWindowBounds(paramView1, localRectF1);
    calculateWindowBounds(paramView2, localRectF2);
    int i = 0x7 & paramj.a;
    float f = 0.0F;
    switch (i)
    {
    case 2:
    case 4:
    default:
    case 3:
    case 1:
    case 5:
    }
    while (true)
    {
      return f + paramj.b;
      f = localRectF2.left - localRectF1.left;
      continue;
      f = localRectF2.centerX() - localRectF1.centerX();
      continue;
      f = localRectF2.right - localRectF1.right;
    }
  }

  private float calculateTranslationY(View paramView1, View paramView2, j paramj)
  {
    RectF localRectF1 = this.tmpRectF1;
    RectF localRectF2 = this.tmpRectF2;
    calculateWindowBounds(paramView1, localRectF1);
    calculateWindowBounds(paramView2, localRectF2);
    int i = 0x70 & paramj.a;
    float f = 0.0F;
    switch (i)
    {
    default:
    case 48:
    case 16:
    case 80:
    }
    while (true)
    {
      return f + paramj.c;
      f = localRectF2.top - localRectF1.top;
      continue;
      f = localRectF2.centerY() - localRectF1.centerY();
      continue;
      f = localRectF2.bottom - localRectF1.bottom;
    }
  }

  private float calculateValueOfAnimationAtEndOfExpansion(a parama, i parami, float paramFloat1, float paramFloat2)
  {
    long l1 = parami.a();
    long l2 = parami.b();
    i locali = parama.a.b("expansion");
    float f = (float)(17L + (locali.a() + locali.b()) - l1) / (float)l2;
    return android.support.design.a.a.a(paramFloat1, paramFloat2, parami.c().getInterpolation(f));
  }

  private void calculateWindowBounds(View paramView, RectF paramRectF)
  {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    int[] arrayOfInt = this.tmpArray;
    paramView.getLocationInWindow(arrayOfInt);
    paramRectF.offsetTo(arrayOfInt[0], arrayOfInt[1]);
    paramRectF.offset((int)-paramView.getTranslationX(), (int)-paramView.getTranslationY());
  }

  private void createChildrenFadeAnimation(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, a parama, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    if (!(paramView2 instanceof ViewGroup));
    ViewGroup localViewGroup;
    do
    {
      do
        return;
      while (((paramView2 instanceof android.support.design.c.d)) && (android.support.design.c.c.a == 0));
      localViewGroup = calculateChildContentContainer(paramView2);
    }
    while (localViewGroup == null);
    if (paramBoolean1)
      if (!paramBoolean2)
        android.support.design.a.d.a.set(localViewGroup, Float.valueOf(0.0F));
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localViewGroup, android.support.design.a.d.a, new float[] { 1.0F }); ; localObjectAnimator = ObjectAnimator.ofFloat(localViewGroup, android.support.design.a.d.a, new float[] { 0.0F }))
    {
      parama.a.b("contentFade").a(localObjectAnimator);
      paramList.add(localObjectAnimator);
      return;
    }
  }

  private void createColorAnimation(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, a parama, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    if (!(paramView2 instanceof android.support.design.c.d))
      return;
    android.support.design.c.d locald = (android.support.design.c.d)paramView2;
    int i = getBackgroundTint(paramView1);
    int j = 0xFFFFFF & i;
    if (paramBoolean1)
      if (!paramBoolean2)
        locald.setCircularRevealScrimColor(i);
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(locald, d.c.a, new int[] { j }); ; localObjectAnimator = ObjectAnimator.ofInt(locald, d.c.a, new int[] { i }))
    {
      localObjectAnimator.setEvaluator(android.support.design.a.c.a());
      parama.a.b("color").a(localObjectAnimator);
      paramList.add(localObjectAnimator);
      return;
    }
  }

  @TargetApi(21)
  private void createElevationAnimation(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, a parama, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    float f = ViewCompat.getElevation(paramView2) - ViewCompat.getElevation(paramView1);
    if (paramBoolean1)
      if (!paramBoolean2)
        paramView2.setTranslationZ(-f);
    Property localProperty;
    float[] arrayOfFloat;
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Z, new float[] { 0.0F }); ; localObjectAnimator = ObjectAnimator.ofFloat(paramView2, localProperty, arrayOfFloat))
    {
      parama.a.b("elevation").a(localObjectAnimator);
      paramList.add(localObjectAnimator);
      return;
      localProperty = View.TRANSLATION_Z;
      arrayOfFloat = new float[1];
      arrayOfFloat[0] = (-f);
    }
  }

  private void createExpansionAnimation(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, a parama, float paramFloat1, float paramFloat2, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    if (!(paramView2 instanceof android.support.design.c.d))
      return;
    final android.support.design.c.d locald = (android.support.design.c.d)paramView2;
    float f1 = calculateRevealCenterX(paramView1, paramView2, parama.b);
    float f2 = calculateRevealCenterY(paramView1, paramView2, parama.b);
    ((FloatingActionButton)paramView1).getContentRect(this.tmpRect);
    float f3 = this.tmpRect.width() / 2.0F;
    i locali = parama.a.b("expansion");
    float f5;
    Animator localAnimator2;
    if (paramBoolean1)
    {
      if (!paramBoolean2)
        locald.setRevealInfo(new d.d(f1, f2, f3));
      if (paramBoolean2)
      {
        f5 = locald.getRevealInfo().c;
        localAnimator2 = android.support.design.c.a.a(locald, f1, f2, MathUtils.distanceToFurthestCorner(f1, f2, 0.0F, 0.0F, paramFloat1, paramFloat2));
        localAnimator2.addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            d.d locald = locald.getRevealInfo();
            locald.c = 3.4028235E+38F;
            locald.setRevealInfo(locald);
          }
        });
        createPreFillRadialExpansion(paramView2, locali.a(), (int)f1, (int)f2, f5, paramList);
      }
    }
    Animator localAnimator1;
    for (Object localObject = localAnimator2; ; localObject = localAnimator1)
    {
      locali.a((Animator)localObject);
      paramList.add(localObject);
      paramList1.add(android.support.design.c.a.a(locald));
      return;
      f5 = f3;
      break;
      float f4 = locald.getRevealInfo().c;
      localAnimator1 = android.support.design.c.a.a(locald, f1, f2, f3);
      createPreFillRadialExpansion(paramView2, locali.a(), (int)f1, (int)f2, f4, paramList);
      createPostFillRadialExpansion(paramView2, locali.a(), locali.b(), parama.a.a(), (int)f1, (int)f2, f3, paramList);
    }
  }

  private void createIconFadeAnimation(View paramView1, final View paramView2, boolean paramBoolean1, boolean paramBoolean2, a parama, List<Animator> paramList, List<Animator.AnimatorListener> paramList1)
  {
    if ((!(paramView2 instanceof android.support.design.c.d)) || (!(paramView1 instanceof ImageView)));
    final android.support.design.c.d locald;
    final Drawable localDrawable;
    do
    {
      return;
      locald = (android.support.design.c.d)paramView2;
      localDrawable = ((ImageView)paramView1).getDrawable();
    }
    while (localDrawable == null);
    localDrawable.mutate();
    if (paramBoolean1)
      if (!paramBoolean2)
        localDrawable.setAlpha(255);
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(localDrawable, e.a, new int[] { 0 }); ; localObjectAnimator = ObjectAnimator.ofInt(localDrawable, e.a, new int[] { 255 }))
    {
      localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          paramView2.invalidate();
        }
      });
      parama.a.b("iconFade").a(localObjectAnimator);
      paramList.add(localObjectAnimator);
      paramList1.add(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          locald.setCircularRevealOverlayDrawable(null);
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          locald.setCircularRevealOverlayDrawable(localDrawable);
        }
      });
      return;
    }
  }

  private void createPostFillRadialExpansion(View paramView, long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, float paramFloat, List<Animator> paramList)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (paramLong1 + paramLong2 < paramLong3))
    {
      Animator localAnimator = ViewAnimationUtils.createCircularReveal(paramView, paramInt1, paramInt2, paramFloat, paramFloat);
      localAnimator.setStartDelay(paramLong1 + paramLong2);
      localAnimator.setDuration(paramLong3 - (paramLong1 + paramLong2));
      paramList.add(localAnimator);
    }
  }

  private void createPreFillRadialExpansion(View paramView, long paramLong, int paramInt1, int paramInt2, float paramFloat, List<Animator> paramList)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (paramLong > 0L))
    {
      Animator localAnimator = ViewAnimationUtils.createCircularReveal(paramView, paramInt1, paramInt2, paramFloat, paramFloat);
      localAnimator.setStartDelay(0L);
      localAnimator.setDuration(paramLong);
      paramList.add(localAnimator);
    }
  }

  private void createTranslationAnimation(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2, a parama, List<Animator> paramList, List<Animator.AnimatorListener> paramList1, RectF paramRectF)
  {
    float f1 = calculateTranslationX(paramView1, paramView2, parama.b);
    float f2 = calculateTranslationY(paramView1, paramView2, parama.b);
    i locali1;
    i locali2;
    ObjectAnimator localObjectAnimator2;
    ObjectAnimator localObjectAnimator1;
    if ((f1 == 0.0F) || (f2 == 0.0F))
    {
      locali1 = parama.a.b("translationXLinear");
      locali2 = parama.a.b("translationYLinear");
      if (!paramBoolean1)
        break label265;
      if (!paramBoolean2)
      {
        paramView2.setTranslationX(-f1);
        paramView2.setTranslationY(-f2);
      }
      ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_X, new float[] { 0.0F });
      ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(paramView2, View.TRANSLATION_Y, new float[] { 0.0F });
      calculateChildVisibleBoundsAtEndOfExpansion(paramView2, parama, locali1, locali2, -f1, -f2, 0.0F, 0.0F, paramRectF);
      localObjectAnimator2 = localObjectAnimator4;
      localObjectAnimator1 = localObjectAnimator3;
    }
    while (true)
    {
      locali1.a(localObjectAnimator1);
      locali2.a(localObjectAnimator2);
      paramList.add(localObjectAnimator1);
      paramList.add(localObjectAnimator2);
      return;
      if (((paramBoolean1) && (f2 < 0.0F)) || ((!paramBoolean1) && (f2 > 0.0F)))
      {
        locali1 = parama.a.b("translationXCurveUpwards");
        locali2 = parama.a.b("translationYCurveUpwards");
        break;
      }
      locali1 = parama.a.b("translationXCurveDownwards");
      locali2 = parama.a.b("translationYCurveDownwards");
      break;
      label265: Property localProperty1 = View.TRANSLATION_X;
      float[] arrayOfFloat1 = new float[1];
      arrayOfFloat1[0] = (-f1);
      localObjectAnimator1 = ObjectAnimator.ofFloat(paramView2, localProperty1, arrayOfFloat1);
      Property localProperty2 = View.TRANSLATION_Y;
      float[] arrayOfFloat2 = new float[1];
      arrayOfFloat2[0] = (-f2);
      localObjectAnimator2 = ObjectAnimator.ofFloat(paramView2, localProperty2, arrayOfFloat2);
    }
  }

  private int getBackgroundTint(View paramView)
  {
    ColorStateList localColorStateList = ViewCompat.getBackgroundTintList(paramView);
    if (localColorStateList != null)
      return localColorStateList.getColorForState(paramView.getDrawableState(), localColorStateList.getDefaultColor());
    return 0;
  }

  private ViewGroup toViewGroupOrNull(View paramView)
  {
    if ((paramView instanceof ViewGroup))
      return (ViewGroup)paramView;
    return null;
  }

  public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    if (paramView1.getVisibility() == 8)
      throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    boolean bool1 = paramView2 instanceof FloatingActionButton;
    boolean bool2 = false;
    if (bool1)
    {
      int i = ((FloatingActionButton)paramView2).getExpandedComponentIdHint();
      if (i != 0)
      {
        int j = paramView1.getId();
        bool2 = false;
        if (i != j);
      }
      else
      {
        bool2 = true;
      }
    }
    return bool2;
  }

  public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams.dodgeInsetEdges == 0)
      paramLayoutParams.dodgeInsetEdges = 80;
  }

  protected AnimatorSet onCreateExpandedStateChangeAnimation(final View paramView1, final View paramView2, final boolean paramBoolean1, boolean paramBoolean2)
  {
    a locala = onCreateMotionSpec(paramView2.getContext(), paramBoolean1);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (Build.VERSION.SDK_INT >= 21)
      createElevationAnimation(paramView1, paramView2, paramBoolean1, paramBoolean2, locala, localArrayList1, localArrayList2);
    RectF localRectF = this.tmpRectF1;
    createTranslationAnimation(paramView1, paramView2, paramBoolean1, paramBoolean2, locala, localArrayList1, localArrayList2, localRectF);
    float f1 = localRectF.width();
    float f2 = localRectF.height();
    createIconFadeAnimation(paramView1, paramView2, paramBoolean1, paramBoolean2, locala, localArrayList1, localArrayList2);
    createExpansionAnimation(paramView1, paramView2, paramBoolean1, paramBoolean2, locala, f1, f2, localArrayList1, localArrayList2);
    createColorAnimation(paramView1, paramView2, paramBoolean1, paramBoolean2, locala, localArrayList1, localArrayList2);
    createChildrenFadeAnimation(paramView1, paramView2, paramBoolean1, paramBoolean2, locala, localArrayList1, localArrayList2);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    android.support.design.a.b.a(localAnimatorSet, localArrayList1);
    localAnimatorSet.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (!paramBoolean1)
        {
          paramView2.setVisibility(4);
          paramView1.setAlpha(1.0F);
          paramView1.setVisibility(0);
        }
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        if (paramBoolean1)
        {
          paramView2.setVisibility(0);
          paramView1.setAlpha(0.0F);
          paramView1.setVisibility(4);
        }
      }
    });
    int i = localArrayList2.size();
    for (int j = 0; j < i; j++)
      localAnimatorSet.addListener((Animator.AnimatorListener)localArrayList2.get(j));
    return localAnimatorSet;
  }

  protected abstract a onCreateMotionSpec(Context paramContext, boolean paramBoolean);

  protected static class a
  {
    public h a;
    public j b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.transformation.FabTransformationBehavior
 * JD-Core Version:    0.6.2
 */
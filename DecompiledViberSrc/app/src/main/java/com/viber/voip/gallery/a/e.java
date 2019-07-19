package com.viber.voip.gallery.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class e
  implements View.OnTouchListener
{
  private static final Logger a = ViberEnv.getLogger();
  private Context b;
  private c c;
  private VelocityTracker d;
  private a e = a.a;
  private a f;
  private boolean g = false;
  private float h;
  private int i = -1;
  private int j = -1;
  private long k = 0L;
  private boolean l;
  private Rect m;

  public e(Context paramContext, c paramc, a parama, int paramInt)
  {
    this.b = paramContext;
    this.c = paramc;
    if (parama != null)
      this.e = parama;
    this.j = paramInt;
    if ((this.j > 100) || (this.j < 0))
      this.j = 50;
  }

  private void a(View paramView, boolean paramBoolean)
  {
    if (this.l)
      paramView.setPressed(paramBoolean);
  }

  private void b(View paramView)
  {
    this.k = 0L;
    a(paramView, false);
    paramView.setAlpha(1.0F);
    paramView.setTranslationY(0.0F);
    this.g = false;
    ((ViewGroup)paramView.getParent()).requestDisallowInterceptTouchEvent(false);
  }

  public void a(final View paramView)
  {
    this.g = true;
    paramView.setAlpha(0.0F);
    if ((this.e == a.a) || ((this.f != null) && (this.f == a.a)));
    for (float f1 = -paramView.getHeight(); ; f1 = paramView.getHeight())
    {
      paramView.setTranslationY(f1);
      paramView.setVisibility(0);
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F }).setDuration(250L);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F }).setDuration(250L);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
        }

        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          paramView.setAlpha(1.0F);
          paramView.setTranslationY(0.0F);
          paramView.clearAnimation();
          if (e.a(e.this) != null)
            e.a(e.this).d(paramView);
          e.a(e.this, false);
        }

        public void onAnimationRepeat(Animator paramAnonymousAnimator)
        {
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
        }
      });
      localAnimatorSet.start();
      return;
    }
  }

  public boolean onTouch(final View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1)
    {
      paramMotionEvent.setAction(3);
      return true;
    }
    if (this.i < 0)
      this.i = ViewConfiguration.get(this.b).getScaledTouchSlop();
    switch (paramMotionEvent.getAction())
    {
    default:
      return false;
    case 0:
      if (this.g)
        return false;
      if (this.c != null)
        this.c.b(paramView);
      this.k = System.currentTimeMillis();
      a(paramView, true);
      this.h = paramMotionEvent.getRawY();
      if (this.d == null)
        this.d = VelocityTracker.obtain();
      ((ViewGroup)paramView.getParent()).requestDisallowInterceptTouchEvent(false);
    case 3:
    case 2:
      float f11;
      float f12;
      while (true)
      {
        return true;
        b(paramView);
        continue;
        if (this.l)
        {
          paramView.getDrawingRect(this.m);
          if (!this.m.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
            a(paramView, false);
        }
        f11 = paramMotionEvent.getRawY() - this.h;
        f12 = Math.abs(f11);
        if ((!this.g) && (f12 > this.i))
        {
          ((ViewGroup)paramView.getParent()).requestDisallowInterceptTouchEvent(true);
          this.g = true;
          this.k = 0L;
          if (this.c != null)
            this.c.a(paramView);
        }
        if (this.g)
        {
          if (((f11 < 0.0F) || (this.e != a.a)) && ((f11 > 0.0F) || (this.e != a.b)))
            break;
          paramView.setTranslationY(0.0F);
          paramView.setAlpha(1.0F);
          this.g = false;
        }
      }
      if (f12 >= paramView.getHeight());
      for (float f13 = 0.0F; ; f13 = 1.0F - f12 / paramView.getHeight())
      {
        paramView.setAlpha(f13);
        paramView.setTranslationY(f11);
        this.d.addMovement(paramMotionEvent);
        break;
      }
    case 1:
    }
    float f1;
    float f2;
    float f9;
    label459: final boolean bool1;
    float f4;
    float f3;
    float f5;
    label477: float f6;
    if (this.g)
    {
      ((ViewGroup)paramView.getParent()).requestDisallowInterceptTouchEvent(false);
      f1 = paramMotionEvent.getRawY() - this.h;
      f2 = Math.abs(f1);
      if (f2 > paramView.getHeight() * this.j / 100.0F)
      {
        float f8 = f2 / paramView.getHeight();
        if (f1 < 0.0F)
        {
          f9 = -paramView.getHeight();
          bool1 = true;
          f4 = 0.0F;
          float f10 = f9;
          f3 = f8;
          f5 = f10;
          if (f3 > 1.0F)
            f3 = 1.0F;
          this.d.computeCurrentVelocity(1000);
          int n = Math.abs((int)this.d.getYVelocity());
          this.d.clear();
          if (n <= 30)
            break label704;
          f6 = 250.0F * (1.0F - f3);
          label533: long l1 = (int)f6;
          if (this.e != a.a)
            break label711;
          boolean bool2 = f1 < 0.0F;
          float f7 = 0.0F;
          if (!bool2)
            f7 = f5;
          f5 = f7;
          label570: ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { f5 }).setDuration(l1);
          ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { f4 }).setDuration(l1);
          AnimatorSet localAnimatorSet = new AnimatorSet();
          localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
          localAnimatorSet.addListener(new Animator.AnimatorListener()
          {
            public void onAnimationCancel(Animator paramAnonymousAnimator)
            {
            }

            public void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              paramView.setAlpha(1.0F);
              paramView.setTranslationY(0.0F);
              if (bool1)
                paramView.setVisibility(4);
              while (e.a(e.this) != null)
              {
                e.a(e.this).a(paramView, bool1, new e.b()
                {
                  public void a()
                  {
                    e.a(e.this, false);
                  }
                });
                return;
                paramView.setVisibility(0);
              }
              e.a(e.this, false);
            }

            public void onAnimationRepeat(Animator paramAnonymousAnimator)
            {
            }

            public void onAnimationStart(Animator paramAnonymousAnimator)
            {
            }
          });
          localAnimatorSet.start();
        }
      }
    }
    while (true)
    {
      a(paramView, false);
      break;
      f9 = paramView.getHeight();
      break label459;
      f3 = 1.0F - f2 / paramView.getHeight();
      f4 = 1.0F;
      f5 = 0.0F;
      bool1 = false;
      break label477;
      label704: f6 = 150.0F;
      break label533;
      label711: if (this.e == a.b)
      {
        if (f1 >= 0.0F)
          break label570;
        f5 = 0.0F;
        break label570;
      }
      if (f5 > 0.0F);
      for (a locala = a.b; ; locala = a.a)
      {
        this.f = locala;
        break;
      }
      if (paramView.getTranslationY() != 0.0F)
        b(paramView);
      this.g = false;
      this.k = (System.currentTimeMillis() - this.k);
      if ((this.k > 0L) && (this.k <= 250L) && (this.c != null))
        this.c.c(paramView);
    }
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }

  public static abstract interface b
  {
    public abstract void a();
  }

  public static abstract interface c
  {
    public abstract void a(View paramView);

    public abstract void a(View paramView, boolean paramBoolean, e.b paramb);

    public abstract void b(View paramView);

    public abstract void c(View paramView);

    public abstract void d(View paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.a.e
 * JD-Core Version:    0.6.2
 */
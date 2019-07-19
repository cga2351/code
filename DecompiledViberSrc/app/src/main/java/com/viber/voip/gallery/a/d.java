package com.viber.voip.gallery.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.ui.view.ViewPagerWithPagingEnable;
import com.viber.voip.util.dj;

public class d extends PagerAdapter
  implements ViewPager.OnPageChangeListener, e.c
{
  private static final Logger a = ViberEnv.getLogger();
  private final LayoutInflater b;
  private int c;
  private ViewPagerWithPagingEnable d;
  private c e = null;
  private View f = null;
  private View g = null;
  private View h;
  private e i;
  private a j;
  private b k;
  private ViewPager.OnPageChangeListener l;
  private View.OnClickListener m;
  private final View.OnClickListener n = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (d.a(d.this) != null)
        d.a(d.this).onClick(paramAnonymousView);
    }
  };
  private Runnable o;
  private boolean p;

  public d(c paramc, ViewPagerWithPagingEnable paramViewPagerWithPagingEnable, LayoutInflater paramLayoutInflater)
  {
    Context localContext = paramViewPagerWithPagingEnable.getContext();
    this.b = paramLayoutInflater;
    this.d = paramViewPagerWithPagingEnable;
    this.e = paramc;
    a(localContext.getApplicationContext());
  }

  @SuppressLint({"NewApi"})
  private View a(final View paramView, int paramInt, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.b.inflate(R.layout.undo_photo_remove_view, null);
    View localView1 = localRelativeLayout.findViewById(R.id.undo_btn);
    View localView2 = localRelativeLayout.findViewById(R.id.undo_text);
    View localView3 = localRelativeLayout.findViewById(R.id.backgroung);
    if (paramBoolean)
    {
      localView1.setVisibility(0);
      localView2.setVisibility(0);
      localView3.setVisibility(0);
      paramView.setVisibility(4);
      localView1.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          d.b(d.this).a(paramView);
          if (d.c(d.this) != null)
          {
            d.c(d.this).removeCallbacks(d.d(d.this));
            d.a(d.this, null);
          }
          d.a(d.this, null);
        }
      });
      localRelativeLayout.setOnTouchListener(this.i);
    }
    while (true)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      localRelativeLayout.addView(paramView, localLayoutParams);
      localRelativeLayout.setTag(R.id.swipe_page_tag_id, Integer.valueOf(paramInt));
      paramView.setTag(R.id.swipe_page_tag_id, Integer.valueOf(paramInt));
      dj.a(localRelativeLayout);
      return localRelativeLayout;
      localView1.setVisibility(8);
      localView2.setVisibility(8);
      localView3.setVisibility(8);
    }
  }

  private void a()
  {
    View localView;
    int i1;
    if (this.g != null)
    {
      localView = e(this.g);
      i1 = ((Integer)localView.getTag(R.id.swipe_page_tag_id)).intValue();
      if (i1 != this.d.getCurrentItem())
        break label42;
    }
    label42: 
    do
    {
      return;
      if (this.o != null)
      {
        this.g.removeCallbacks(this.o);
        this.o = null;
      }
      int i2 = this.d.getCurrentItem();
      this.g.setAlpha(0.0F);
      this.d.setAdapter(null);
      if (!this.p)
        d(i1);
      this.e.c(i1, localView);
      this.g = null;
      this.d.setAdapter(this);
      if (getCount() > 0)
      {
        ViewPagerWithPagingEnable localViewPagerWithPagingEnable = this.d;
        if (i2 > i1)
          i2--;
        localViewPagerWithPagingEnable.setCurrentItem(i2);
      }
      if (i1 == 0)
        onPageSelected(i1);
    }
    while (this.p);
    e(i1);
  }

  private void a(Context paramContext)
  {
    this.e.registerDataSetObserver(new DataSetObserver()
    {
      public void onChanged()
      {
        d.this.notifyDataSetChanged();
      }
    });
    this.d.setOnPageChangeListener(this);
    this.i = new e(paramContext, this, e.a.c, 40);
    this.h = this.b.inflate(R.layout.add_more_photo_view, this.d, false);
    this.h.findViewById(R.id.add_more).setOnClickListener(this.n);
  }

  private void a(View paramView, final e.b paramb, boolean paramBoolean)
  {
    this.d.setPagingEnabled(false);
    if (this.g != null)
    {
      this.g.removeCallbacks(this.o);
      this.o = null;
    }
    final int i1 = ((Integer)paramView.getTag(R.id.swipe_page_tag_id)).intValue();
    final View localView1 = e(paramView);
    int i2;
    int i3;
    label71: ViewPagerWithPagingEnable localViewPagerWithPagingEnable;
    if (i1 != -1 + getCount())
    {
      i2 = 1;
      i3 = 0;
      if (i3 < this.d.getChildCount())
      {
        View localView3 = this.d.getChildAt(i3);
        int i6 = ((Integer)localView3.getTag(R.id.swipe_page_tag_id)).intValue();
        int i7 = i1 + i2;
        if ((localView3 == null) || (((i2 >= 0) || (i6 != i7)) && ((i2 <= 0) || (i6 != i7))))
          break label281;
        this.f = localView3;
      }
      if (this.f != null)
        break label294;
      this.d.setAdapter(null);
      if (!this.p)
        d(i1);
      this.e.c(i1, localView1);
      this.d.setAdapter(this);
      if (getCount() > 0)
      {
        localViewPagerWithPagingEnable = this.d;
        if (i1 != -1 + this.c)
          break label287;
      }
    }
    label281: label287: for (int i5 = i1 - 1; ; i5 = i1)
    {
      localViewPagerWithPagingEnable.setCurrentItem(i5);
      paramb.a();
      this.d.setPagingEnabled(true);
      if (i1 == 0)
        onPageSelected(i1);
      if (!this.p)
        e(i1);
      return;
      i2 = -1;
      break;
      i3++;
      break label71;
    }
    label294: this.f.setOnTouchListener(null);
    if (i1 == -1 + getCount());
    ObjectAnimator localObjectAnimator1;
    for (int i4 = this.g.getLeft() - this.f.getLeft(); ; i4 = -(this.f.getRight() - this.g.getRight()))
    {
      View localView2 = this.f;
      float[] arrayOfFloat = new float[1];
      arrayOfFloat[0] = i4;
      localObjectAnimator1 = ObjectAnimator.ofFloat(localView2, "translationX", arrayOfFloat).setDuration(300L);
      if (!paramBoolean)
        break;
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F }).setDuration(300L);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator2, localObjectAnimator1 });
      localAnimatorSet.addListener(new Animator.AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
        }

        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          d.e(d.this).setAdapter(null);
          if (!d.f(d.this))
            d.a(d.this, i1);
          d.g(d.this).c(i1, localView1);
          d.a(d.this, null);
          d.h(d.this).setTranslationX(0.0F);
          if (d.h(d.this) != d.i(d.this))
          {
            View localView = d.b(d.this, d.h(d.this));
            if (localView.getVisibility() == 0)
              localView.setOnTouchListener(d.b(d.this));
          }
          d.e(d.this).setAdapter(d.this);
          ViewPagerWithPagingEnable localViewPagerWithPagingEnable;
          if (d.this.getCount() > 0)
          {
            localViewPagerWithPagingEnable = d.e(d.this);
            if (i1 != -1 + d.j(d.this))
              break label245;
          }
          label245: for (int i = -1 + i1; ; i = i1)
          {
            localViewPagerWithPagingEnable.setCurrentItem(i);
            paramb.a();
            d.e(d.this).setPagingEnabled(true);
            if (i1 == 0)
              d.this.onPageSelected(i1);
            if (!d.f(d.this))
              d.b(d.this, i1);
            return;
          }
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
    localObjectAnimator1.setStartDelay(100L);
    localObjectAnimator1.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        d.e(d.this).setAdapter(null);
        if (!d.f(d.this))
          d.a(d.this, i1);
        d.g(d.this).c(i1, localView1);
        d.a(d.this, null);
        d.h(d.this).setTranslationX(0.0F);
        if (d.h(d.this) != d.i(d.this))
        {
          View localView = d.b(d.this, d.h(d.this));
          if (localView.getVisibility() == 0)
            localView.setOnTouchListener(d.b(d.this));
        }
        d.e(d.this).setAdapter(d.this);
        ViewPagerWithPagingEnable localViewPagerWithPagingEnable;
        if (d.this.getCount() > 0)
        {
          localViewPagerWithPagingEnable = d.e(d.this);
          if (i1 != -1 + d.j(d.this))
            break label245;
        }
        label245: for (int i = -1 + i1; ; i = i1)
        {
          localViewPagerWithPagingEnable.setCurrentItem(i);
          paramb.a();
          d.e(d.this).setPagingEnabled(true);
          if (i1 == 0)
            d.this.onPageSelected(i1);
          if (!d.f(d.this))
            d.b(d.this, i1);
          return;
        }
      }

      public void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
      }
    });
    localObjectAnimator1.start();
  }

  private int b()
  {
    return this.e.getCount();
  }

  private void b(int paramInt)
  {
    if (this.j != null)
      this.j.a(this.g, null, paramInt);
  }

  private void c()
  {
    if (this.g != null)
    {
      this.g.removeCallbacks(this.o);
      this.o = null;
    }
  }

  private void c(int paramInt)
  {
    if (this.j != null)
      this.j.a(this.g, paramInt);
  }

  private void d(int paramInt)
  {
    if (this.k != null)
      this.k.b(this.g, null, paramInt);
  }

  private View e(View paramView)
  {
    if (!this.p)
      return paramView;
    ViewGroup localViewGroup = (ViewGroup)paramView;
    int i1 = localViewGroup.getChildCount();
    for (int i2 = 0; ; i2++)
    {
      View localView = null;
      if (i2 < i1)
      {
        int i3 = localViewGroup.getChildAt(i2).getId();
        if ((i3 != R.id.undo_btn) && (i3 != R.id.undo_text) && (i3 != R.id.backgroung))
          localView = localViewGroup.getChildAt(i2);
      }
      else
      {
        return localView;
      }
    }
  }

  private void e(int paramInt)
  {
    if (this.k != null)
      this.k.c(this.g, null, paramInt);
  }

  private boolean f(int paramInt)
  {
    int i1 = b();
    return (this.c > 0) && (i1 < this.c) && (paramInt == i1);
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
  }

  public void a(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.l = paramOnPageChangeListener;
  }

  public void a(View.OnClickListener paramOnClickListener)
  {
    this.m = paramOnClickListener;
  }

  public void a(View paramView)
  {
    int i1 = ((Integer)paramView.getTag(R.id.swipe_page_tag_id)).intValue();
    this.e.a(paramView, i1, true, false);
  }

  public void a(final View paramView, final e.b paramb)
  {
    if ((!this.p) || (paramView.getId() == R.id.undo_parent))
    {
      if (!this.p)
        this.g = paramView;
      a(paramView, paramb, false);
      return;
    }
    this.d.requestDisallowInterceptTouchEvent(true);
    this.d.setPagingEnabled(false);
    this.g = ((View)paramView.getParent());
    int i1 = ((Integer)paramView.getTag(R.id.swipe_page_tag_id)).intValue();
    d(i1);
    this.e.b(i1, paramView);
    e(i1);
    final View localView1 = this.g.findViewById(R.id.undo_btn);
    final View localView2 = this.g.findViewById(R.id.undo_text);
    final View localView3 = this.g.findViewById(R.id.backgroung);
    localView1.setAlpha(0.0F);
    localView2.setAlpha(0.0F);
    localView3.setAlpha(0.0F);
    localView1.setVisibility(0);
    localView2.setVisibility(0);
    localView3.setVisibility(0);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localView1, "alpha", new float[] { 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localView2, "alpha", new float[] { 1.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(localView3, "alpha", new float[] { 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setStartDelay(150L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3 });
    localAnimatorSet.setDuration(250L);
    localAnimatorSet.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        localView1.setAlpha(1.0F);
        localView2.setAlpha(1.0F);
        localView3.setAlpha(1.0F);
        localView1.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            d.b(d.this).a(d.3.this.d);
            if (d.c(d.this) != null)
            {
              d.c(d.this).removeCallbacks(d.d(d.this));
              d.a(d.this, null);
            }
            d.a(d.this, null);
          }
        });
        paramb.a();
        d.a(d.this, new Runnable()
        {
          public void run()
          {
            if (d.d(d.this) != null)
              d.a(d.this, d.c(d.this), d.3.this.e, true);
          }
        });
        d.e(d.this).requestDisallowInterceptTouchEvent(false);
        d.e(d.this).setPagingEnabled(true);
        d.c(d.this).postDelayed(d.d(d.this), 3000L);
        d.c(d.this).setOnTouchListener(d.b(d.this));
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

  public void a(View paramView, boolean paramBoolean, e.b paramb)
  {
    int i1 = ((Integer)paramView.getTag(R.id.swipe_page_tag_id)).intValue();
    this.e.a(paramView, i1, false, paramBoolean);
    if (paramBoolean)
    {
      a(paramView, paramb);
      return;
    }
    paramb.a();
  }

  public void a(a parama)
  {
    this.j = parama;
  }

  public void a(b paramb)
  {
    this.k = paramb;
  }

  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  public void b(View paramView)
  {
    c();
  }

  public void c(View paramView)
  {
  }

  public void d(View paramView)
  {
    View localView1 = (View)paramView.getParent();
    localView1.setOnTouchListener(null);
    int i1 = ((Integer)paramView.getTag(R.id.swipe_page_tag_id)).intValue();
    this.e.a(i1, paramView);
    b(i1);
    View localView2 = localView1.findViewById(R.id.undo_btn);
    View localView3 = localView1.findViewById(R.id.undo_text);
    View localView4 = localView1.findViewById(R.id.backgroung);
    localView2.setOnClickListener(null);
    localView2.setVisibility(8);
    localView3.setVisibility(8);
    localView4.setVisibility(8);
    paramView.setOnTouchListener(this.i);
  }

  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    View localView = (View)paramObject;
    c localc;
    if (!f(paramInt))
    {
      localView.setOnTouchListener(null);
      localc = this.e;
      if (!this.p)
        break label61;
    }
    label61: for (ViewGroup localViewGroup = (ViewGroup)localView; ; localViewGroup = paramViewGroup)
    {
      localc.destroyItem(localViewGroup, paramInt, e(localView));
      paramViewGroup.removeView(localView);
      return;
    }
  }

  public void finishUpdate(ViewGroup paramViewGroup)
  {
    this.e.finishUpdate(paramViewGroup);
  }

  public int getCount()
  {
    int i1 = b();
    if ((this.c > 0) && (i1 < this.c))
      i1++;
    return i1;
  }

  public int getItemPosition(Object paramObject)
  {
    return -2;
  }

  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (f(paramInt))
    {
      this.h.setTag(R.id.swipe_page_tag_id, Integer.valueOf(paramInt));
      paramViewGroup.addView(this.h);
      return this.h;
    }
    View localView1 = (View)this.e.instantiateItem(paramViewGroup, paramInt);
    if (localView1.getVisibility() == 0)
      localView1.setOnTouchListener(this.i);
    if (this.p)
    {
      localView1.setTag(R.id.swipe_page_tag_id, Integer.valueOf(paramInt));
      if (localView1.getParent() == null)
      {
        boolean bool;
        View localView3;
        if (this.g != null)
          if (paramInt == ((Integer)this.g.getTag(R.id.swipe_page_tag_id)).intValue())
          {
            bool = true;
            localView3 = a(localView1, paramInt, bool);
            if (bool)
              this.g = localView3;
          }
        while (true)
        {
          paramViewGroup.addView(localView3);
          return localView3;
          bool = false;
          break;
          localView3 = a(localView1, paramInt, false);
        }
      }
      View localView2 = (View)localView1.getParent();
      paramViewGroup.addView(localView2);
      localView2.setTag(R.id.swipe_page_tag_id, Integer.valueOf(paramInt));
      return localView2;
    }
    localView1.setTag(R.id.swipe_page_tag_id, Integer.valueOf(paramInt));
    paramViewGroup.addView(localView1);
    return localView1;
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return this.e.isViewFromObject(paramView, paramObject);
  }

  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0)
      a();
    if (this.l != null)
      this.l.onPageScrollStateChanged(paramInt);
  }

  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    c();
    if (this.l != null)
      this.l.onPageScrolled(paramInt1, paramFloat, paramInt2);
  }

  public void onPageSelected(int paramInt)
  {
    if (this.g != null)
      c(((Integer)this.g.getTag(R.id.swipe_page_tag_id)).intValue());
    if (this.l != null)
      this.l.onPageSelected(paramInt);
  }

  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    this.e.restoreState(paramParcelable, paramClassLoader);
  }

  public Parcelable saveState()
  {
    return this.e.saveState();
  }

  public void startUpdate(ViewGroup paramViewGroup)
  {
    this.e.startUpdate(paramViewGroup);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gallery.a.d
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.ui.popup.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import com.viber.voip.R.id;
import com.viber.voip.messages.ui.popup.a.e;
import com.viber.voip.messages.ui.popup.a.g;
import com.viber.voip.ui.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PopupViewPagerRoot extends bd
{
  final ViewPager.OnPageChangeListener a = new ViewPager.OnPageChangeListener()
  {
    public void onPageScrollStateChanged(final int paramAnonymousInt)
    {
      int i = (int)(PopupViewPagerRoot.this.getScrollX() % PopupViewPagerRoot.b(PopupViewPagerRoot.this));
      PopupViewPagerRoot.b(PopupViewPagerRoot.this, PopupViewPagerRoot.this.getCurrentItem());
      if ((PopupViewPagerRoot.d(PopupViewPagerRoot.this) == -1 + PopupViewPagerRoot.this.getAdapter().getCount()) || (PopupViewPagerRoot.d(PopupViewPagerRoot.this) == 0));
      for (int j = 1; ; j = 0)
      {
        if ((j != 0) && (!PopupViewPagerRoot.c(PopupViewPagerRoot.this)))
          PopupViewPagerRoot.this.postDelayed(new Runnable()
          {
            public void run()
            {
              PopupViewPagerRoot.a(PopupViewPagerRoot.this, true);
              PopupViewPagerRoot.1.this.onPageScrollStateChanged(paramAnonymousInt);
            }
          }
          , 500L);
        if ((i == 0) && ((PopupViewPagerRoot.c(PopupViewPagerRoot.this)) || (j != 0)))
          PopupViewPagerRoot.c(PopupViewPagerRoot.this, PopupViewPagerRoot.d(PopupViewPagerRoot.this));
        PopupViewPagerRoot.this.a(true);
        return;
      }
    }

    public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
    {
      if (PopupViewPagerRoot.a(PopupViewPagerRoot.this).size() > 0)
      {
        if ((PopupViewPagerRoot.b(PopupViewPagerRoot.this) == -1.0F) && (paramAnonymousFloat != 0.0F))
        {
          ViewPager localViewPager = (ViewPager)PopupViewPagerRoot.a(PopupViewPagerRoot.this).get(0);
          PopupViewPagerRoot.a(PopupViewPagerRoot.this, paramAnonymousInt2 / paramAnonymousFloat);
          PopupViewPagerRoot.a(PopupViewPagerRoot.this, PopupViewPagerRoot.this.getWidth() - localViewPager.getWidth() + PopupViewPagerRoot.this.getPageMargin() - localViewPager.getPageMargin());
        }
        if (PopupViewPagerRoot.c(PopupViewPagerRoot.this))
        {
          PopupViewPagerRoot.a(PopupViewPagerRoot.this, paramAnonymousInt1, paramAnonymousFloat);
          PopupViewPagerRoot.a(PopupViewPagerRoot.this, paramAnonymousInt1, paramAnonymousFloat, paramAnonymousInt2);
        }
      }
    }

    public void onPageSelected(int paramAnonymousInt)
    {
    }
  };
  private List<ViewPager> b = new ArrayList();
  private a c;
  private int d;
  private int e;
  private int f;
  private boolean g;
  private boolean h = true;
  private int i;
  private float j = -1.0F;

  public PopupViewPagerRoot(Context paramContext)
  {
    super(paramContext);
    d();
    e();
  }

  public PopupViewPagerRoot(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
    e();
  }

  private void a(int paramInt)
  {
    this.h = false;
    b(paramInt);
    super.setCurrentItem(paramInt);
  }

  private void a(int paramInt, float paramFloat)
  {
    if (paramFloat != 0.0F)
    {
      int k;
      if (paramInt < this.d)
      {
        int m = paramInt + 1;
        k = paramInt;
        paramInt = m;
      }
      while (true)
      {
        if ((this.e != paramInt) || (this.f != k))
        {
          this.e = paramInt;
          this.f = k;
          a(this.e, this.f);
        }
        return;
        k = paramInt + 1;
      }
    }
    this.d = paramInt;
    a(true);
  }

  private void a(int paramInt1, float paramFloat, int paramInt2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      ViewPager localViewPager = (ViewPager)localIterator.next();
      e locale = (e)localViewPager.getAdapter();
      if ((localViewPager.getTag(R.id.scroll) != null) && (localViewPager.getTag(R.id.scroll).equals(Boolean.valueOf(true))))
      {
        int k = locale.a().b(paramInt1);
        if ((paramInt2 != 0) && (paramInt2 > this.i));
        for (float f1 = k * (this.j - this.i) + paramInt2 - this.i; ; f1 = k * (this.j - this.i))
        {
          localViewPager.scrollTo((int)f1, getScrollY());
          break;
        }
      }
    }
  }

  private void a(int paramInt1, int paramInt2)
  {
    if (this.c != null)
      this.c.a(paramInt1, paramInt2);
    Iterator localIterator = this.b.iterator();
    if (localIterator.hasNext())
    {
      ViewPager localViewPager = (ViewPager)localIterator.next();
      if (!((e)localViewPager.getAdapter()).a().a(paramInt1, paramInt2));
      for (boolean bool = true; ; bool = false)
      {
        localViewPager.setTag(R.id.scroll, Boolean.valueOf(bool));
        break;
      }
    }
  }

  private void b(int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    while (true)
    {
      ViewPager localViewPager;
      e locale;
      if (localIterator.hasNext())
      {
        localViewPager = (ViewPager)localIterator.next();
        locale = (e)localViewPager.getAdapter();
      }
      try
      {
        locale.notifyDataSetChanged();
        localViewPager.setCurrentItem(locale.a().c(paramInt));
      }
      catch (NullPointerException localNullPointerException)
      {
        continue;
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
      }
    }
  }

  private void d()
  {
    setOffscreenPageLimit(3);
    setHorizontalFadingEdgeEnabled(true);
    setFadingEdgeLength(15);
  }

  private void e()
  {
    setOnPageChangeListener(this.a);
  }

  public void a()
  {
    if (getCurrentItem() < -1 + getAdapter().getCount())
      super.setCurrentItem(1 + getCurrentItem());
  }

  public void a(ViewPager paramViewPager)
  {
    if (this.b == null)
      this.b = new ArrayList();
    this.b.add(paramViewPager);
  }

  void a(boolean paramBoolean)
  {
    if (this.c != null)
      this.c.a(this.d);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)((ViewPager)localIterator.next()).getAdapter();
      try
      {
        locale.a().a(this.d, paramBoolean);
      }
      catch (NullPointerException localNullPointerException)
      {
      }
    }
  }

  public void addView(View paramView, int paramInt)
  {
    if ((!this.g) && (this.c != null) && (paramInt == 0))
      this.c.a(paramInt);
    super.addView(paramView, paramInt);
  }

  public void b()
  {
    if (getCurrentItem() > 0)
      super.setCurrentItem(-1 + getCurrentItem());
  }

  public void c()
  {
    a(-1 + getAdapter().getCount());
  }

  public int getSetedPosition()
  {
    return this.d;
  }

  public void setChildViewPager(List<ViewPager> paramList)
  {
    this.b = paramList;
  }

  public void setCurrentItem(int paramInt)
  {
    throw new RuntimeException("not implement correct swipe to position");
  }

  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    throw new RuntimeException("not implement correct swipe to position");
  }

  public void setOnPagerChangingListener(a parama)
  {
    this.c = parama;
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);

    public abstract void a(int paramInt1, int paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.popup.view.PopupViewPagerRoot
 * JD-Core Version:    0.6.2
 */
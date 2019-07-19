package com.viber.voip.messages.ui.popup.a;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class e extends PagerAdapter
{
  private g a;

  public e(g paramg)
  {
    this.a = paramg;
  }

  public g a()
  {
    return this.a;
  }

  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewPager)paramView).removeView((View)paramObject);
  }

  public void finishUpdate(View paramView)
  {
  }

  public int getCount()
  {
    return this.a.b();
  }

  public int getItemPosition(Object paramObject)
  {
    return -2;
  }

  public Object instantiateItem(View paramView, int paramInt)
  {
    View localView = this.a.a(paramView, paramInt);
    ((ViewPager)paramView).addView(localView, 0);
    return localView;
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == (View)paramObject;
  }

  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
  }

  public Parcelable saveState()
  {
    return null;
  }

  public void startUpdate(View paramView)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.popup.a.e
 * JD-Core Version:    0.6.2
 */
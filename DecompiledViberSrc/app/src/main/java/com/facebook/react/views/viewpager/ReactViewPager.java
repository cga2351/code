package com.facebook.react.views.viewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.NativeGestureUtil;
import java.util.ArrayList;
import java.util.List;

public class ReactViewPager extends ViewPager
{
  private final EventDispatcher mEventDispatcher;
  private boolean mIsCurrentItemFromJs;
  private boolean mScrollEnabled = true;
  private final Runnable measureAndLayout = new Runnable()
  {
    public void run()
    {
      ReactViewPager.this.measure(View.MeasureSpec.makeMeasureSpec(ReactViewPager.this.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(ReactViewPager.this.getHeight(), 1073741824));
      ReactViewPager.this.layout(ReactViewPager.this.getLeft(), ReactViewPager.this.getTop(), ReactViewPager.this.getRight(), ReactViewPager.this.getBottom());
    }
  };

  public ReactViewPager(ReactContext paramReactContext)
  {
    super(paramReactContext);
    this.mEventDispatcher = ((UIManagerModule)paramReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
    this.mIsCurrentItemFromJs = false;
    setOnPageChangeListener(new PageChangeListener(null));
    setAdapter(new Adapter(null));
  }

  void addViewToAdapter(View paramView, int paramInt)
  {
    getAdapter().addView(paramView, paramInt);
  }

  public Adapter getAdapter()
  {
    return (Adapter)super.getAdapter();
  }

  int getViewCountInAdapter()
  {
    return getAdapter().getCount();
  }

  View getViewFromAdapter(int paramInt)
  {
    return getAdapter().getViewAt(paramInt);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    requestLayout();
    post(this.measureAndLayout);
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mScrollEnabled);
    while (true)
    {
      return false;
      try
      {
        if (super.onInterceptTouchEvent(paramMotionEvent))
        {
          NativeGestureUtil.notifyNativeGestureStarted(this, paramMotionEvent);
          return true;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        FLog.w("ReactNative", "Error intercepting touch event.", localIllegalArgumentException);
      }
    }
    return false;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mScrollEnabled)
      return false;
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      FLog.w("ReactNative", "Error handling touch event.", localIllegalArgumentException);
    }
    return false;
  }

  public void removeAllViewsFromAdapter()
  {
    getAdapter().removeAllViewsFromAdapter(this);
  }

  void removeViewFromAdapter(int paramInt)
  {
    getAdapter().removeViewAt(paramInt);
  }

  public void setCurrentItemFromJs(int paramInt, boolean paramBoolean)
  {
    this.mIsCurrentItemFromJs = true;
    setCurrentItem(paramInt, paramBoolean);
    this.mIsCurrentItemFromJs = false;
  }

  public void setScrollEnabled(boolean paramBoolean)
  {
    this.mScrollEnabled = paramBoolean;
  }

  public void setViews(List<View> paramList)
  {
    getAdapter().setViews(paramList);
  }

  private class Adapter extends PagerAdapter
  {
    private boolean mIsViewPagerInIntentionallyInconsistentState = false;
    private final List<View> mViews = new ArrayList();

    private Adapter()
    {
    }

    void addView(View paramView, int paramInt)
    {
      this.mViews.add(paramInt, paramView);
      notifyDataSetChanged();
      ReactViewPager.this.setOffscreenPageLimit(this.mViews.size());
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
    }

    public int getCount()
    {
      return this.mViews.size();
    }

    public int getItemPosition(Object paramObject)
    {
      if ((this.mIsViewPagerInIntentionallyInconsistentState) || (!this.mViews.contains(paramObject)))
        return -2;
      return this.mViews.indexOf(paramObject);
    }

    View getViewAt(int paramInt)
    {
      return (View)this.mViews.get(paramInt);
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      View localView = (View)this.mViews.get(paramInt);
      paramViewGroup.addView(localView, 0, ReactViewPager.this.generateDefaultLayoutParams());
      return localView;
    }

    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }

    void removeAllViewsFromAdapter(ViewPager paramViewPager)
    {
      this.mViews.clear();
      paramViewPager.removeAllViews();
      this.mIsViewPagerInIntentionallyInconsistentState = true;
    }

    void removeViewAt(int paramInt)
    {
      this.mViews.remove(paramInt);
      notifyDataSetChanged();
      ReactViewPager.this.setOffscreenPageLimit(this.mViews.size());
    }

    void setViews(List<View> paramList)
    {
      this.mViews.clear();
      this.mViews.addAll(paramList);
      notifyDataSetChanged();
      this.mIsViewPagerInIntentionallyInconsistentState = false;
    }
  }

  private class PageChangeListener
    implements ViewPager.OnPageChangeListener
  {
    private PageChangeListener()
    {
    }

    public void onPageScrollStateChanged(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default:
        throw new IllegalStateException("Unsupported pageScrollState");
      case 0:
        str = "idle";
      case 1:
      case 2:
      }
      while (true)
      {
        ReactViewPager.this.mEventDispatcher.dispatchEvent(new PageScrollStateChangedEvent(ReactViewPager.this.getId(), str));
        return;
        str = "dragging";
        continue;
        str = "settling";
      }
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      ReactViewPager.this.mEventDispatcher.dispatchEvent(new PageScrollEvent(ReactViewPager.this.getId(), paramInt1, paramFloat));
    }

    public void onPageSelected(int paramInt)
    {
      if (!ReactViewPager.this.mIsCurrentItemFromJs)
        ReactViewPager.this.mEventDispatcher.dispatchEvent(new PageSelectedEvent(ReactViewPager.this.getId(), paramInt));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.viewpager.ReactViewPager
 * JD-Core Version:    0.6.2
 */
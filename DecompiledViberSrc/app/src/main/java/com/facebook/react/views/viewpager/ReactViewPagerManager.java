package com.facebook.react.views.viewpager;

import android.view.View;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="AndroidViewPager")
public class ReactViewPagerManager extends ViewGroupManager<ReactViewPager>
{
  public static final int COMMAND_SET_PAGE = 1;
  public static final int COMMAND_SET_PAGE_WITHOUT_ANIMATION = 2;
  public static final String REACT_CLASS = "AndroidViewPager";

  public void addView(ReactViewPager paramReactViewPager, View paramView, int paramInt)
  {
    paramReactViewPager.addViewToAdapter(paramView, paramInt);
  }

  protected ReactViewPager createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactViewPager(paramThemedReactContext);
  }

  public View getChildAt(ReactViewPager paramReactViewPager, int paramInt)
  {
    return paramReactViewPager.getViewFromAdapter(paramInt);
  }

  public int getChildCount(ReactViewPager paramReactViewPager)
  {
    return paramReactViewPager.getViewCountInAdapter();
  }

  public Map<String, Integer> getCommandsMap()
  {
    return MapBuilder.of("setPage", Integer.valueOf(1), "setPageWithoutAnimation", Integer.valueOf(2));
  }

  public Map getExportedCustomDirectEventTypeConstants()
  {
    return MapBuilder.of("topPageScroll", MapBuilder.of("registrationName", "onPageScroll"), "topPageScrollStateChanged", MapBuilder.of("registrationName", "onPageScrollStateChanged"), "topPageSelected", MapBuilder.of("registrationName", "onPageSelected"));
  }

  public String getName()
  {
    return "AndroidViewPager";
  }

  public boolean needsCustomLayoutForChildren()
  {
    return true;
  }

  public void receiveCommand(ReactViewPager paramReactViewPager, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    Assertions.assertNotNull(paramReactViewPager);
    Assertions.assertNotNull(paramReadableArray);
    switch (paramInt)
    {
    default:
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      arrayOfObject[1] = getClass().getSimpleName();
      throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", arrayOfObject));
    case 1:
      paramReactViewPager.setCurrentItemFromJs(paramReadableArray.getInt(0), true);
      return;
    case 2:
    }
    paramReactViewPager.setCurrentItemFromJs(paramReadableArray.getInt(0), false);
  }

  public void removeViewAt(ReactViewPager paramReactViewPager, int paramInt)
  {
    paramReactViewPager.removeViewFromAdapter(paramInt);
  }

  @ReactProp(defaultFloat=0.0F, name="pageMargin")
  public void setPageMargin(ReactViewPager paramReactViewPager, float paramFloat)
  {
    paramReactViewPager.setPageMargin((int)PixelUtil.toPixelFromDIP(paramFloat));
  }

  @ReactProp(defaultBoolean=false, name="peekEnabled")
  public void setPeekEnabled(ReactViewPager paramReactViewPager, boolean paramBoolean)
  {
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      paramReactViewPager.setClipToPadding(bool);
      return;
    }
  }

  @ReactProp(defaultBoolean=true, name="scrollEnabled")
  public void setScrollEnabled(ReactViewPager paramReactViewPager, boolean paramBoolean)
  {
    paramReactViewPager.setScrollEnabled(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.viewpager.ReactViewPagerManager
 * JD-Core Version:    0.6.2
 */
package com.facebook.react.views.swiperefresh;

import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.MapBuilder.Builder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="AndroidSwipeRefreshLayout")
public class SwipeRefreshLayoutManager extends ViewGroupManager<ReactSwipeRefreshLayout>
{
  public static final String REACT_CLASS = "AndroidSwipeRefreshLayout";

  protected void addEventEmitters(final ThemedReactContext paramThemedReactContext, final ReactSwipeRefreshLayout paramReactSwipeRefreshLayout)
  {
    paramReactSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
    {
      public void onRefresh()
      {
        ((UIManagerModule)paramThemedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new RefreshEvent(paramReactSwipeRefreshLayout.getId()));
      }
    });
  }

  protected ReactSwipeRefreshLayout createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactSwipeRefreshLayout(paramThemedReactContext);
  }

  public Map<String, Object> getExportedCustomDirectEventTypeConstants()
  {
    return MapBuilder.builder().put("topRefresh", MapBuilder.of("registrationName", "onRefresh")).build();
  }

  @Nullable
  public Map<String, Object> getExportedViewConstants()
  {
    return MapBuilder.of("SIZE", MapBuilder.of("DEFAULT", Integer.valueOf(1), "LARGE", Integer.valueOf(0)));
  }

  public String getName()
  {
    return "AndroidSwipeRefreshLayout";
  }

  @ReactProp(customType="ColorArray", name="colors")
  public void setColors(ReactSwipeRefreshLayout paramReactSwipeRefreshLayout, @Nullable ReadableArray paramReadableArray)
  {
    int i = 0;
    if (paramReadableArray != null)
    {
      int[] arrayOfInt = new int[paramReadableArray.size()];
      while (i < paramReadableArray.size())
      {
        arrayOfInt[i] = paramReadableArray.getInt(i);
        i++;
      }
      paramReactSwipeRefreshLayout.setColorSchemeColors(arrayOfInt);
      return;
    }
    paramReactSwipeRefreshLayout.setColorSchemeColors(new int[0]);
  }

  @ReactProp(defaultBoolean=true, name="enabled")
  public void setEnabled(ReactSwipeRefreshLayout paramReactSwipeRefreshLayout, boolean paramBoolean)
  {
    paramReactSwipeRefreshLayout.setEnabled(paramBoolean);
  }

  @ReactProp(customType="Color", defaultInt=0, name="progressBackgroundColor")
  public void setProgressBackgroundColor(ReactSwipeRefreshLayout paramReactSwipeRefreshLayout, int paramInt)
  {
    paramReactSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(paramInt);
  }

  @ReactProp(defaultFloat=0.0F, name="progressViewOffset")
  public void setProgressViewOffset(ReactSwipeRefreshLayout paramReactSwipeRefreshLayout, float paramFloat)
  {
    paramReactSwipeRefreshLayout.setProgressViewOffset(paramFloat);
  }

  @ReactProp(name="refreshing")
  public void setRefreshing(ReactSwipeRefreshLayout paramReactSwipeRefreshLayout, boolean paramBoolean)
  {
    paramReactSwipeRefreshLayout.setRefreshing(paramBoolean);
  }

  @ReactProp(defaultInt=1, name="size")
  public void setSize(ReactSwipeRefreshLayout paramReactSwipeRefreshLayout, int paramInt)
  {
    paramReactSwipeRefreshLayout.setSize(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager
 * JD-Core Version:    0.6.2
 */
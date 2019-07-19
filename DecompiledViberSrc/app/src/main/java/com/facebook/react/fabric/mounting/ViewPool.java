package com.facebook.react.fabric.mounting;

import android.view.View;
import com.facebook.react.common.ClearableSynchronizedPool;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import java.util.HashMap;
import java.util.Map;

public final class ViewPool
{
  private static final int POOL_SIZE = 512;
  private final ViewManagerRegistry mViewManagerRegistry;
  private final Map<String, ClearableSynchronizedPool<View>> mViewPool = new HashMap();

  ViewPool(ViewManagerRegistry paramViewManagerRegistry)
  {
    this.mViewManagerRegistry = paramViewManagerRegistry;
  }

  private ClearableSynchronizedPool<View> getViewPoolForComponent(String paramString)
  {
    ClearableSynchronizedPool localClearableSynchronizedPool = (ClearableSynchronizedPool)this.mViewPool.get(paramString);
    if (localClearableSynchronizedPool == null)
    {
      localClearableSynchronizedPool = new ClearableSynchronizedPool(512);
      this.mViewPool.put(paramString, localClearableSynchronizedPool);
    }
    return localClearableSynchronizedPool;
  }

  void createView(String paramString, ThemedReactContext paramThemedReactContext)
  {
    getViewPoolForComponent(paramString).release(this.mViewManagerRegistry.get(paramString).createView(paramThemedReactContext, null));
  }

  View getOrCreateView(String paramString, ThemedReactContext paramThemedReactContext)
  {
    ClearableSynchronizedPool localClearableSynchronizedPool = getViewPoolForComponent(paramString);
    View localView = (View)localClearableSynchronizedPool.acquire();
    if (localView == null)
    {
      createView(paramString, paramThemedReactContext);
      localView = (View)localClearableSynchronizedPool.acquire();
    }
    return localView;
  }

  void returnToPool(String paramString, View paramView)
  {
    ClearableSynchronizedPool localClearableSynchronizedPool = (ClearableSynchronizedPool)this.mViewPool.get(paramString);
    if (localClearableSynchronizedPool != null)
      localClearableSynchronizedPool.release(paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.mounting.ViewPool
 * JD-Core Version:    0.6.2
 */
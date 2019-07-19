package com.facebook.react.uimanager;

import com.facebook.react.common.MapBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public final class ViewManagerRegistry
{

  @Nullable
  private final UIManagerModule.ViewManagerResolver mViewManagerResolver;
  private final Map<String, ViewManager> mViewManagers;

  public ViewManagerRegistry(UIManagerModule.ViewManagerResolver paramViewManagerResolver)
  {
    this.mViewManagers = MapBuilder.newHashMap();
    this.mViewManagerResolver = paramViewManagerResolver;
  }

  public ViewManagerRegistry(List<ViewManager> paramList)
  {
    HashMap localHashMap = MapBuilder.newHashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      ViewManager localViewManager = (ViewManager)localIterator.next();
      localHashMap.put(localViewManager.getName(), localViewManager);
    }
    this.mViewManagers = localHashMap;
    this.mViewManagerResolver = null;
  }

  public ViewManagerRegistry(Map<String, ViewManager> paramMap)
  {
    if (paramMap != null);
    while (true)
    {
      this.mViewManagers = paramMap;
      this.mViewManagerResolver = null;
      return;
      paramMap = MapBuilder.newHashMap();
    }
  }

  public ViewManager get(String paramString)
  {
    ViewManager localViewManager1 = (ViewManager)this.mViewManagers.get(paramString);
    if (localViewManager1 != null)
      return localViewManager1;
    if (this.mViewManagerResolver != null)
    {
      ViewManager localViewManager2 = this.mViewManagerResolver.getViewManager(paramString);
      if (localViewManager2 != null)
      {
        this.mViewManagers.put(paramString, localViewManager2);
        return localViewManager2;
      }
    }
    throw new IllegalViewOperationException("No ViewManager defined for class " + paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ViewManagerRegistry
 * JD-Core Version:    0.6.2
 */
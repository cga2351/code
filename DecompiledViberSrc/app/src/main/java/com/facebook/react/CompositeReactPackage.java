package com.facebook.react;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public class CompositeReactPackage
  implements ReactPackage, ViewManagerOnDemandReactPackage
{
  private final List<ReactPackage> mChildReactPackages = new ArrayList();

  public CompositeReactPackage(ReactPackage paramReactPackage1, ReactPackage paramReactPackage2, ReactPackage[] paramArrayOfReactPackage)
  {
    this.mChildReactPackages.add(paramReactPackage1);
    this.mChildReactPackages.add(paramReactPackage2);
    Collections.addAll(this.mChildReactPackages, paramArrayOfReactPackage);
  }

  public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.mChildReactPackages.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ViewManagerOnDemandReactPackage)localIterator1.next()).createNativeModules(paramReactApplicationContext).iterator();
      while (localIterator2.hasNext())
      {
        NativeModule localNativeModule = (NativeModule)localIterator2.next();
        localHashMap.put(localNativeModule.getName(), localNativeModule);
      }
    }
    return new ArrayList(localHashMap.values());
  }

  @Nullable
  public ViewManager createViewManager(ReactApplicationContext paramReactApplicationContext, String paramString)
  {
    ListIterator localListIterator = this.mChildReactPackages.listIterator(this.mChildReactPackages.size());
    while (localListIterator.hasPrevious())
    {
      ReactPackage localReactPackage = (ViewManagerOnDemandReactPackage)localListIterator.previous();
      if ((localReactPackage instanceof ViewManagerOnDemandReactPackage))
      {
        ViewManager localViewManager = ((ViewManagerOnDemandReactPackage)localReactPackage).createViewManager(paramReactApplicationContext, paramString);
        if (localViewManager != null)
          return localViewManager;
      }
    }
    return null;
  }

  public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = this.mChildReactPackages.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ViewManagerOnDemandReactPackage)localIterator1.next()).createViewManagers(paramReactApplicationContext).iterator();
      while (localIterator2.hasNext())
      {
        ViewManager localViewManager = (ViewManager)localIterator2.next();
        localHashMap.put(localViewManager.getName(), localViewManager);
      }
    }
    return new ArrayList(localHashMap.values());
  }

  public List<String> getViewManagerNames(ReactApplicationContext paramReactApplicationContext)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.mChildReactPackages.iterator();
    while (localIterator.hasNext())
    {
      ReactPackage localReactPackage = (ViewManagerOnDemandReactPackage)localIterator.next();
      if ((localReactPackage instanceof ViewManagerOnDemandReactPackage))
      {
        List localList = ((ViewManagerOnDemandReactPackage)localReactPackage).getViewManagerNames(paramReactApplicationContext);
        if (localList != null)
          localHashSet.addAll(localList);
      }
    }
    return new ArrayList(localHashSet);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.CompositeReactPackage
 * JD-Core Version:    0.6.2
 */
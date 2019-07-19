package com.facebook.react.uimanager;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class UIManagerModuleConstantsHelper
{
  private static final String BUBBLING_EVENTS_KEY = "bubblingEventTypes";
  private static final String DIRECT_EVENTS_KEY = "directEventTypes";

  static Map<String, Object> createConstants(UIManagerModule.ViewManagerResolver paramViewManagerResolver)
  {
    Map localMap = UIManagerModuleConstants.getConstants();
    if (!ReactFeatureFlags.lazilyLoadViewManagers)
      localMap.put("ViewManagerNames", paramViewManagerResolver.getViewManagerNames());
    localMap.put("LazyViewManagersEnabled", Boolean.valueOf(true));
    return localMap;
  }

  static Map<String, Object> createConstants(List<ViewManager> paramList, @Nullable Map<String, Object> paramMap1, @Nullable Map<String, Object> paramMap2)
  {
    Map localMap1 = UIManagerModuleConstants.getConstants();
    Map localMap2 = UIManagerModuleConstants.getBubblingEventTypeConstants();
    Map localMap3 = UIManagerModuleConstants.getDirectEventTypeConstants();
    if (paramMap1 != null)
      paramMap1.putAll(localMap2);
    if (paramMap2 != null)
      paramMap2.putAll(localMap3);
    Iterator localIterator = paramList.iterator();
    while (true)
    {
      ViewManager localViewManager;
      String str;
      if (localIterator.hasNext())
      {
        localViewManager = (ViewManager)localIterator.next();
        str = localViewManager.getName();
        SystraceMessage.beginSection(0L, "UIManagerModuleConstantsHelper.createConstants").arg("ViewManager", str).arg("Lazy", Boolean.valueOf(false)).flush();
      }
      try
      {
        Map localMap4 = createConstantsForViewManager(localViewManager, null, null, paramMap1, paramMap2);
        if (!localMap4.isEmpty())
          localMap1.put(str, localMap4);
        SystraceMessage.endSection(0L);
      }
      finally
      {
        SystraceMessage.endSection(0L);
      }
    }
    localMap1.put("genericDirectEventTypes", localMap3);
    return localMap1;
  }

  static Map<String, Object> createConstantsForViewManager(ViewManager paramViewManager, @Nullable Map paramMap1, @Nullable Map paramMap2, @Nullable Map paramMap3, @Nullable Map paramMap4)
  {
    HashMap localHashMap = MapBuilder.newHashMap();
    Map localMap1 = paramViewManager.getExportedCustomBubblingEventTypeConstants();
    if (localMap1 != null)
    {
      recursiveMerge(paramMap3, localMap1);
      recursiveMerge(localMap1, paramMap1);
      localHashMap.put("bubblingEventTypes", localMap1);
      Map localMap2 = paramViewManager.getExportedCustomDirectEventTypeConstants();
      if (localMap2 == null)
        break label171;
      recursiveMerge(paramMap4, localMap2);
      recursiveMerge(localMap2, paramMap2);
      localHashMap.put("directEventTypes", localMap2);
    }
    while (true)
    {
      Map localMap3 = paramViewManager.getExportedViewConstants();
      if (localMap3 != null)
        localHashMap.put("Constants", localMap3);
      Map localMap4 = paramViewManager.getCommandsMap();
      if (localMap4 != null)
        localHashMap.put("Commands", localMap4);
      Map localMap5 = paramViewManager.getNativeProps();
      if (!localMap5.isEmpty())
        localHashMap.put("NativeProps", localMap5);
      return localHashMap;
      if (paramMap1 == null)
        break;
      localHashMap.put("bubblingEventTypes", paramMap1);
      break;
      label171: if (paramMap2 != null)
        localHashMap.put("directEventTypes", paramMap2);
    }
  }

  static Map<String, Object> getDefaultExportableEventTypes()
  {
    return MapBuilder.of("bubblingEventTypes", UIManagerModuleConstants.getBubblingEventTypeConstants(), "directEventTypes", UIManagerModuleConstants.getDirectEventTypeConstants());
  }

  private static void recursiveMerge(@Nullable Map paramMap1, @Nullable Map paramMap2)
  {
    if ((paramMap1 == null) || (paramMap2 == null) || (paramMap2.isEmpty()));
    while (true)
    {
      return;
      Iterator localIterator = paramMap2.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        Object localObject2 = paramMap2.get(localObject1);
        Object localObject3 = paramMap1.get(localObject1);
        if ((localObject3 != null) && ((localObject2 instanceof Map)) && ((localObject3 instanceof Map)))
          recursiveMerge((Map)localObject3, (Map)localObject2);
        else
          paramMap1.put(localObject1, localObject2);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.UIManagerModuleConstantsHelper
 * JD-Core Version:    0.6.2
 */
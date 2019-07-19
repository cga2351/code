package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Provider;

public abstract class TurboReactPackage
  implements ReactPackage
{
  public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    throw new UnsupportedOperationException("In case of TurboModules, createNativeModules is not supported. NativeModuleRegistry should instead use getModuleList or getModule method");
  }

  public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    List localList = getViewManagers(paramReactApplicationContext);
    if ((localList == null) || (localList.isEmpty()))
      return Collections.emptyList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      localArrayList.add((ViewManager)((ModuleSpec)localIterator.next()).getProvider().get());
    return localArrayList;
  }

  public abstract NativeModule getModule(String paramString, ReactApplicationContext paramReactApplicationContext);

  public Iterable<ModuleHolder> getNativeModuleIterator(final ReactApplicationContext paramReactApplicationContext)
  {
    return new Iterable()
    {
      public Iterator<ModuleHolder> iterator()
      {
        return new Iterator()
        {
          public boolean hasNext()
          {
            return TurboReactPackage.1.this.val$entrySetIterator.hasNext();
          }

          public ModuleHolder next()
          {
            Map.Entry localEntry = (Map.Entry)TurboReactPackage.1.this.val$entrySetIterator.next();
            String str = (String)localEntry.getKey();
            return new ModuleHolder((ReactModuleInfo)localEntry.getValue(), new TurboReactPackage.ModuleHolderProvider(TurboReactPackage.this, str, TurboReactPackage.1.this.val$reactContext));
          }

          public void remove()
          {
            throw new UnsupportedOperationException("Cannot remove native modules from the list");
          }
        };
      }
    };
  }

  public abstract ReactModuleInfoProvider getReactModuleInfoProvider();

  protected List<ModuleSpec> getViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    return Collections.emptyList();
  }

  private class ModuleHolderProvider
    implements Provider<NativeModule>
  {
    private final String mName;
    private final ReactApplicationContext mReactContext;

    public ModuleHolderProvider(String paramReactApplicationContext, ReactApplicationContext arg3)
    {
      this.mName = paramReactApplicationContext;
      Object localObject;
      this.mReactContext = localObject;
    }

    public NativeModule get()
    {
      return TurboReactPackage.this.getModule(this.mName, this.mReactContext);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.TurboReactPackage
 * JD-Core Version:    0.6.2
 */
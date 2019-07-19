package com.facebook.react;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.Iterator;
import java.util.List;

public class ReactPackageHelper
{
  public static Iterable<ModuleHolder> getNativeModuleIterator(ReactPackage paramReactPackage, ReactApplicationContext paramReactApplicationContext, ReactInstanceManager paramReactInstanceManager)
  {
    FLog.d("ReactNative", paramReactPackage.getClass().getSimpleName() + " is not a LazyReactPackage, falling back to old version.");
    if ((paramReactPackage instanceof ReactInstancePackage));
    for (List localList = ((ReactInstancePackage)paramReactPackage).createNativeModules(paramReactApplicationContext, paramReactInstanceManager); ; localList = paramReactPackage.createNativeModules(paramReactApplicationContext))
      return new Iterable()
      {
        public Iterator<ModuleHolder> iterator()
        {
          return new Iterator()
          {
            int position = 0;

            public boolean hasNext()
            {
              return this.position < ReactPackageHelper.1.this.val$nativeModules.size();
            }

            public ModuleHolder next()
            {
              List localList = ReactPackageHelper.1.this.val$nativeModules;
              int i = this.position;
              this.position = (i + 1);
              return new ModuleHolder((NativeModule)localList.get(i));
            }

            public void remove()
            {
              throw new UnsupportedOperationException("Cannot remove methods ");
            }
          };
        }
      };
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.ReactPackageHelper
 * JD-Core Version:    0.6.2
 */
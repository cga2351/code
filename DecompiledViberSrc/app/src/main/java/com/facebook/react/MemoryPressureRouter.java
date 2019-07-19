package com.facebook.react;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.facebook.react.bridge.MemoryPressureListener;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class MemoryPressureRouter
  implements ComponentCallbacks2
{
  private final Set<MemoryPressureListener> mListeners = Collections.synchronizedSet(new LinkedHashSet());

  MemoryPressureRouter(Context paramContext)
  {
    paramContext.getApplicationContext().registerComponentCallbacks(this);
  }

  private void dispatchMemoryPressure(int paramInt)
  {
    MemoryPressureListener[] arrayOfMemoryPressureListener = (MemoryPressureListener[])this.mListeners.toArray(new MemoryPressureListener[this.mListeners.size()]);
    int i = arrayOfMemoryPressureListener.length;
    for (int j = 0; j < i; j++)
      arrayOfMemoryPressureListener[j].handleMemoryPressure(paramInt);
  }

  public void addMemoryPressureListener(MemoryPressureListener paramMemoryPressureListener)
  {
    this.mListeners.add(paramMemoryPressureListener);
  }

  public void destroy(Context paramContext)
  {
    paramContext.getApplicationContext().unregisterComponentCallbacks(this);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
  }

  public void onLowMemory()
  {
  }

  public void onTrimMemory(int paramInt)
  {
    dispatchMemoryPressure(paramInt);
  }

  public void removeMemoryPressureListener(MemoryPressureListener paramMemoryPressureListener)
  {
    this.mListeners.remove(paramMemoryPressureListener);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.MemoryPressureRouter
 * JD-Core Version:    0.6.2
 */
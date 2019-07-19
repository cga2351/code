package com.facebook.react.jstasks;

import android.os.Handler;
import android.util.SparseArray;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.appregistry.AppRegistry;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class HeadlessJsTaskContext
{
  private static final WeakHashMap<ReactContext, HeadlessJsTaskContext> INSTANCES = new WeakHashMap();
  private final Set<Integer> mActiveTasks = new CopyOnWriteArraySet();
  private final Handler mHandler = new Handler();
  private final Set<HeadlessJsTaskEventListener> mHeadlessJsTaskEventListeners = new CopyOnWriteArraySet();
  private final AtomicInteger mLastTaskId = new AtomicInteger(0);
  private final WeakReference<ReactContext> mReactContext;
  private final SparseArray<Runnable> mTaskTimeouts = new SparseArray();

  private HeadlessJsTaskContext(ReactContext paramReactContext)
  {
    this.mReactContext = new WeakReference(paramReactContext);
  }

  public static HeadlessJsTaskContext getInstance(ReactContext paramReactContext)
  {
    HeadlessJsTaskContext localHeadlessJsTaskContext = (HeadlessJsTaskContext)INSTANCES.get(paramReactContext);
    if (localHeadlessJsTaskContext == null)
    {
      localHeadlessJsTaskContext = new HeadlessJsTaskContext(paramReactContext);
      INSTANCES.put(paramReactContext, localHeadlessJsTaskContext);
    }
    return localHeadlessJsTaskContext;
  }

  private void scheduleTaskTimeout(final int paramInt, long paramLong)
  {
    Runnable local2 = new Runnable()
    {
      public void run()
      {
        HeadlessJsTaskContext.this.finishTask(paramInt);
      }
    };
    this.mTaskTimeouts.append(paramInt, local2);
    this.mHandler.postDelayed(local2, paramLong);
  }

  public void addTaskEventListener(HeadlessJsTaskEventListener paramHeadlessJsTaskEventListener)
  {
    this.mHeadlessJsTaskEventListeners.add(paramHeadlessJsTaskEventListener);
  }

  public void finishTask(final int paramInt)
  {
    try
    {
      Assertions.assertCondition(this.mActiveTasks.remove(Integer.valueOf(paramInt)), "Tried to finish non-existent task with id " + paramInt + ".");
      Runnable localRunnable = (Runnable)this.mTaskTimeouts.get(paramInt);
      if (localRunnable != null)
      {
        this.mHandler.removeCallbacks(localRunnable);
        this.mTaskTimeouts.remove(paramInt);
      }
      UiThreadUtil.runOnUiThread(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = HeadlessJsTaskContext.this.mHeadlessJsTaskEventListeners.iterator();
          while (localIterator.hasNext())
            ((HeadlessJsTaskEventListener)localIterator.next()).onHeadlessJsTaskFinish(paramInt);
        }
      });
      return;
    }
    finally
    {
    }
  }

  public boolean hasActiveTasks()
  {
    return this.mActiveTasks.size() > 0;
  }

  public boolean isTaskRunning(int paramInt)
  {
    try
    {
      boolean bool = this.mActiveTasks.contains(Integer.valueOf(paramInt));
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void removeTaskEventListener(HeadlessJsTaskEventListener paramHeadlessJsTaskEventListener)
  {
    this.mHeadlessJsTaskEventListeners.remove(paramHeadlessJsTaskEventListener);
  }

  public int startTask(HeadlessJsTaskConfig paramHeadlessJsTaskConfig)
  {
    ReactContext localReactContext;
    try
    {
      UiThreadUtil.assertOnUiThread();
      localReactContext = (ReactContext)Assertions.assertNotNull(this.mReactContext.get(), "Tried to start a task on a react context that has already been destroyed");
      if ((localReactContext.getLifecycleState() == LifecycleState.RESUMED) && (!paramHeadlessJsTaskConfig.isAllowedInForeground()))
        throw new IllegalStateException("Tried to start task " + paramHeadlessJsTaskConfig.getTaskKey() + " while in foreground, but this is not allowed.");
    }
    finally
    {
    }
    int i = this.mLastTaskId.incrementAndGet();
    this.mActiveTasks.add(Integer.valueOf(i));
    ((AppRegistry)localReactContext.getJSModule(AppRegistry.class)).startHeadlessTask(i, paramHeadlessJsTaskConfig.getTaskKey(), paramHeadlessJsTaskConfig.getData());
    if (paramHeadlessJsTaskConfig.getTimeout() > 0L)
      scheduleTaskTimeout(i, paramHeadlessJsTaskConfig.getTimeout());
    Iterator localIterator = this.mHeadlessJsTaskEventListeners.iterator();
    while (localIterator.hasNext())
      ((HeadlessJsTaskEventListener)localIterator.next()).onHeadlessJsTaskStart(i);
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.jstasks.HeadlessJsTaskContext
 * JD-Core Version:    0.6.2
 */
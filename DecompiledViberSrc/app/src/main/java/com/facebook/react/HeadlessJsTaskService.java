package com.facebook.react;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

public abstract class HeadlessJsTaskService extends Service
  implements HeadlessJsTaskEventListener
{

  @Nullable
  private static PowerManager.WakeLock sWakeLock;
  private final Set<Integer> mActiveTasks = new CopyOnWriteArraySet();

  @SuppressLint({"WakelockTimeout"})
  public static void acquireWakeLockNow(Context paramContext)
  {
    if ((sWakeLock == null) || (!sWakeLock.isHeld()))
    {
      sWakeLock = ((PowerManager)Assertions.assertNotNull((PowerManager)paramContext.getSystemService("power"))).newWakeLock(1, HeadlessJsTaskService.class.getSimpleName());
      sWakeLock.setReferenceCounted(false);
      sWakeLock.acquire();
    }
  }

  private void invokeStartTask(ReactContext paramReactContext, final HeadlessJsTaskConfig paramHeadlessJsTaskConfig)
  {
    final HeadlessJsTaskContext localHeadlessJsTaskContext = HeadlessJsTaskContext.getInstance(paramReactContext);
    localHeadlessJsTaskContext.addTaskEventListener(this);
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        int i = localHeadlessJsTaskContext.startTask(paramHeadlessJsTaskConfig);
        HeadlessJsTaskService.this.mActiveTasks.add(Integer.valueOf(i));
      }
    });
  }

  protected ReactNativeHost getReactNativeHost()
  {
    return ((ReactApplication)getApplication()).getReactNativeHost();
  }

  @Nullable
  protected HeadlessJsTaskConfig getTaskConfig(Intent paramIntent)
  {
    return null;
  }

  @Nullable
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (getReactNativeHost().hasInstance())
    {
      ReactContext localReactContext = getReactNativeHost().getReactInstanceManager().getCurrentReactContext();
      if (localReactContext != null)
        HeadlessJsTaskContext.getInstance(localReactContext).removeTaskEventListener(this);
    }
    if (sWakeLock != null)
      sWakeLock.release();
  }

  public void onHeadlessJsTaskFinish(int paramInt)
  {
    this.mActiveTasks.remove(Integer.valueOf(paramInt));
    if (this.mActiveTasks.size() == 0)
      stopSelf();
  }

  public void onHeadlessJsTaskStart(int paramInt)
  {
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    HeadlessJsTaskConfig localHeadlessJsTaskConfig = getTaskConfig(paramIntent);
    if (localHeadlessJsTaskConfig != null)
    {
      startTask(localHeadlessJsTaskConfig);
      return 3;
    }
    return 2;
  }

  protected void startTask(final HeadlessJsTaskConfig paramHeadlessJsTaskConfig)
  {
    UiThreadUtil.assertOnUiThread();
    acquireWakeLockNow(this);
    final ReactInstanceManager localReactInstanceManager = getReactNativeHost().getReactInstanceManager();
    ReactContext localReactContext = localReactInstanceManager.getCurrentReactContext();
    if (localReactContext == null)
    {
      localReactInstanceManager.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener()
      {
        public void onReactContextInitialized(ReactContext paramAnonymousReactContext)
        {
          HeadlessJsTaskService.this.invokeStartTask(paramAnonymousReactContext, paramHeadlessJsTaskConfig);
          localReactInstanceManager.removeReactInstanceEventListener(this);
        }
      });
      if (!localReactInstanceManager.hasStartedCreatingInitialContext())
        localReactInstanceManager.createReactContextInBackground();
      return;
    }
    invokeStartTask(localReactContext, paramHeadlessJsTaskConfig);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.HeadlessJsTaskService
 * JD-Core Version:    0.6.2
 */
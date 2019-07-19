package com.facebook.react.bridge;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.common.LifecycleState;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

public class ReactContext extends ContextWrapper
{
  private static final String EARLY_JS_ACCESS_EXCEPTION_MESSAGE = "Tried to access a JS module before the React instance was fully set up. Calls to ReactContext#getJSModule should only happen once initialize() has been called on your native module.";
  private final CopyOnWriteArraySet<ActivityEventListener> mActivityEventListeners = new CopyOnWriteArraySet();

  @Nullable
  private CatalystInstance mCatalystInstance;

  @Nullable
  private WeakReference<Activity> mCurrentActivity;

  @Nullable
  private LayoutInflater mInflater;

  @Nullable
  private MessageQueueThread mJSMessageQueueThread;
  private final CopyOnWriteArraySet<LifecycleEventListener> mLifecycleEventListeners = new CopyOnWriteArraySet();
  private LifecycleState mLifecycleState = LifecycleState.BEFORE_CREATE;

  @Nullable
  private NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;

  @Nullable
  private MessageQueueThread mNativeModulesMessageQueueThread;

  @Nullable
  private MessageQueueThread mUiMessageQueueThread;

  public ReactContext(Context paramContext)
  {
    super(paramContext);
  }

  public void addActivityEventListener(ActivityEventListener paramActivityEventListener)
  {
    this.mActivityEventListeners.add(paramActivityEventListener);
  }

  public void addLifecycleEventListener(final LifecycleEventListener paramLifecycleEventListener)
  {
    this.mLifecycleEventListeners.add(paramLifecycleEventListener);
    if (hasActiveCatalystInstance())
      switch (2.$SwitchMap$com$facebook$react$common$LifecycleState[this.mLifecycleState.ordinal()])
      {
      default:
        throw new RuntimeException("Unhandled lifecycle state.");
      case 3:
        runOnUiQueueThread(new Runnable()
        {
          public void run()
          {
            if (!ReactContext.this.mLifecycleEventListeners.contains(paramLifecycleEventListener))
              return;
            try
            {
              paramLifecycleEventListener.onHostResume();
              return;
            }
            catch (RuntimeException localRuntimeException)
            {
              ReactContext.this.handleException(localRuntimeException);
            }
          }
        });
      case 1:
      case 2:
      }
  }

  public void assertOnJSQueueThread()
  {
    ((MessageQueueThread)Assertions.assertNotNull(this.mJSMessageQueueThread)).assertIsOnThread();
  }

  public void assertOnNativeModulesQueueThread()
  {
    ((MessageQueueThread)Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).assertIsOnThread();
  }

  public void assertOnNativeModulesQueueThread(String paramString)
  {
    ((MessageQueueThread)Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).assertIsOnThread(paramString);
  }

  public void assertOnUiQueueThread()
  {
    ((MessageQueueThread)Assertions.assertNotNull(this.mUiMessageQueueThread)).assertIsOnThread();
  }

  public void destroy()
  {
    UiThreadUtil.assertOnUiThread();
    if (this.mCatalystInstance != null)
      this.mCatalystInstance.destroy();
  }

  public CatalystInstance getCatalystInstance()
  {
    return (CatalystInstance)Assertions.assertNotNull(this.mCatalystInstance);
  }

  @Nullable
  public Activity getCurrentActivity()
  {
    if (this.mCurrentActivity == null)
      return null;
    return (Activity)this.mCurrentActivity.get();
  }

  public <T extends JavaScriptModule> T getJSModule(Class<T> paramClass)
  {
    if (this.mCatalystInstance == null)
      throw new RuntimeException("Tried to access a JS module before the React instance was fully set up. Calls to ReactContext#getJSModule should only happen once initialize() has been called on your native module.");
    return this.mCatalystInstance.getJSModule(paramClass);
  }

  public JavaScriptContextHolder getJavaScriptContextHolder()
  {
    return this.mCatalystInstance.getJavaScriptContextHolder();
  }

  public LifecycleState getLifecycleState()
  {
    return this.mLifecycleState;
  }

  public <T extends NativeModule> T getNativeModule(Class<T> paramClass)
  {
    if (this.mCatalystInstance == null)
      throw new RuntimeException("Trying to call native module before CatalystInstance has been set!");
    return this.mCatalystInstance.getNativeModule(paramClass);
  }

  public Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.mInflater == null)
        this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      return this.mInflater;
    }
    return getBaseContext().getSystemService(paramString);
  }

  public void handleException(Exception paramException)
  {
    if ((this.mCatalystInstance != null) && (!this.mCatalystInstance.isDestroyed()) && (this.mNativeModuleCallExceptionHandler != null))
    {
      this.mNativeModuleCallExceptionHandler.handleException(paramException);
      return;
    }
    throw new RuntimeException(paramException);
  }

  public boolean hasActiveCatalystInstance()
  {
    return (this.mCatalystInstance != null) && (!this.mCatalystInstance.isDestroyed());
  }

  public boolean hasCurrentActivity()
  {
    return (this.mCurrentActivity != null) && (this.mCurrentActivity.get() != null);
  }

  public <T extends NativeModule> boolean hasNativeModule(Class<T> paramClass)
  {
    if (this.mCatalystInstance == null)
      throw new RuntimeException("Trying to call native module before CatalystInstance has been set!");
    return this.mCatalystInstance.hasNativeModule(paramClass);
  }

  public void initializeWithInstance(CatalystInstance paramCatalystInstance)
  {
    if (paramCatalystInstance == null)
      throw new IllegalArgumentException("CatalystInstance cannot be null.");
    if (this.mCatalystInstance != null)
      throw new IllegalStateException("ReactContext has been already initialized");
    this.mCatalystInstance = paramCatalystInstance;
    ReactQueueConfiguration localReactQueueConfiguration = paramCatalystInstance.getReactQueueConfiguration();
    this.mUiMessageQueueThread = localReactQueueConfiguration.getUIQueueThread();
    this.mNativeModulesMessageQueueThread = localReactQueueConfiguration.getNativeModulesQueueThread();
    this.mJSMessageQueueThread = localReactQueueConfiguration.getJSQueueThread();
  }

  public boolean isOnJSQueueThread()
  {
    return ((MessageQueueThread)Assertions.assertNotNull(this.mJSMessageQueueThread)).isOnThread();
  }

  public boolean isOnNativeModulesQueueThread()
  {
    return ((MessageQueueThread)Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).isOnThread();
  }

  public boolean isOnUiQueueThread()
  {
    return ((MessageQueueThread)Assertions.assertNotNull(this.mUiMessageQueueThread)).isOnThread();
  }

  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.mActivityEventListeners.iterator();
    while (localIterator.hasNext())
    {
      ActivityEventListener localActivityEventListener = (ActivityEventListener)localIterator.next();
      try
      {
        localActivityEventListener.onActivityResult(paramActivity, paramInt1, paramInt2, paramIntent);
      }
      catch (RuntimeException localRuntimeException)
      {
        handleException(localRuntimeException);
      }
    }
  }

  public void onHostDestroy()
  {
    UiThreadUtil.assertOnUiThread();
    this.mLifecycleState = LifecycleState.BEFORE_CREATE;
    Iterator localIterator = this.mLifecycleEventListeners.iterator();
    while (localIterator.hasNext())
    {
      LifecycleEventListener localLifecycleEventListener = (LifecycleEventListener)localIterator.next();
      try
      {
        localLifecycleEventListener.onHostDestroy();
      }
      catch (RuntimeException localRuntimeException)
      {
        handleException(localRuntimeException);
      }
    }
    this.mCurrentActivity = null;
  }

  public void onHostPause()
  {
    this.mLifecycleState = LifecycleState.BEFORE_RESUME;
    ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_PAUSE_START);
    Iterator localIterator = this.mLifecycleEventListeners.iterator();
    while (localIterator.hasNext())
    {
      LifecycleEventListener localLifecycleEventListener = (LifecycleEventListener)localIterator.next();
      try
      {
        localLifecycleEventListener.onHostPause();
      }
      catch (RuntimeException localRuntimeException)
      {
        handleException(localRuntimeException);
      }
    }
    ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_PAUSE_END);
  }

  public void onHostResume(@Nullable Activity paramActivity)
  {
    this.mLifecycleState = LifecycleState.RESUMED;
    this.mCurrentActivity = new WeakReference(paramActivity);
    ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_RESUME_START);
    Iterator localIterator = this.mLifecycleEventListeners.iterator();
    while (localIterator.hasNext())
    {
      LifecycleEventListener localLifecycleEventListener = (LifecycleEventListener)localIterator.next();
      try
      {
        localLifecycleEventListener.onHostResume();
      }
      catch (RuntimeException localRuntimeException)
      {
        handleException(localRuntimeException);
      }
    }
    ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_RESUME_END);
  }

  public void onNewIntent(@Nullable Activity paramActivity, Intent paramIntent)
  {
    UiThreadUtil.assertOnUiThread();
    this.mCurrentActivity = new WeakReference(paramActivity);
    Iterator localIterator = this.mActivityEventListeners.iterator();
    while (localIterator.hasNext())
    {
      ActivityEventListener localActivityEventListener = (ActivityEventListener)localIterator.next();
      try
      {
        localActivityEventListener.onNewIntent(paramIntent);
      }
      catch (RuntimeException localRuntimeException)
      {
        handleException(localRuntimeException);
      }
    }
  }

  public void removeActivityEventListener(ActivityEventListener paramActivityEventListener)
  {
    this.mActivityEventListeners.remove(paramActivityEventListener);
  }

  public void removeLifecycleEventListener(LifecycleEventListener paramLifecycleEventListener)
  {
    this.mLifecycleEventListeners.remove(paramLifecycleEventListener);
  }

  public void resetPerfStats()
  {
    if (this.mNativeModulesMessageQueueThread != null)
      this.mNativeModulesMessageQueueThread.resetPerfStats();
    if (this.mJSMessageQueueThread != null)
      this.mJSMessageQueueThread.resetPerfStats();
  }

  public void runOnJSQueueThread(Runnable paramRunnable)
  {
    ((MessageQueueThread)Assertions.assertNotNull(this.mJSMessageQueueThread)).runOnQueue(paramRunnable);
  }

  public void runOnNativeModulesQueueThread(Runnable paramRunnable)
  {
    ((MessageQueueThread)Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).runOnQueue(paramRunnable);
  }

  public void runOnUiQueueThread(Runnable paramRunnable)
  {
    ((MessageQueueThread)Assertions.assertNotNull(this.mUiMessageQueueThread)).runOnQueue(paramRunnable);
  }

  public void setNativeModuleCallExceptionHandler(@Nullable NativeModuleCallExceptionHandler paramNativeModuleCallExceptionHandler)
  {
    this.mNativeModuleCallExceptionHandler = paramNativeModuleCallExceptionHandler;
  }

  public boolean startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    Activity localActivity = getCurrentActivity();
    Assertions.assertNotNull(localActivity);
    localActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReactContext
 * JD-Core Version:    0.6.2
 */
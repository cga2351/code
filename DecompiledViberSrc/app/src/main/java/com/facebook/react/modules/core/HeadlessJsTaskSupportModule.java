package com.facebook.react.modules.core;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name="HeadlessJsTaskSupport")
public class HeadlessJsTaskSupportModule extends ReactContextBaseJavaModule
{
  public static final String NAME = "HeadlessJsTaskSupport";

  public HeadlessJsTaskSupportModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  public String getName()
  {
    return "HeadlessJsTaskSupport";
  }

  @ReactMethod
  public void notifyTaskFinished(int paramInt)
  {
    HeadlessJsTaskContext localHeadlessJsTaskContext = HeadlessJsTaskContext.getInstance(getReactApplicationContext());
    if (localHeadlessJsTaskContext.isTaskRunning(paramInt))
    {
      localHeadlessJsTaskContext.finishTask(paramInt);
      return;
    }
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    FLog.w(HeadlessJsTaskSupportModule.class, "Tried to finish non-active task with id %d. Did it time out?", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.core.HeadlessJsTaskSupportModule
 * JD-Core Version:    0.6.2
 */
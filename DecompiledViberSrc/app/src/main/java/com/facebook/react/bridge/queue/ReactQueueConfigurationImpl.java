package com.facebook.react.bridge.queue;

import android.os.Looper;
import com.facebook.react.common.MapBuilder;
import java.util.HashMap;
import java.util.Map;

public class ReactQueueConfigurationImpl
  implements ReactQueueConfiguration
{
  private final MessageQueueThreadImpl mJSQueueThread;
  private final MessageQueueThreadImpl mNativeModulesQueueThread;
  private final MessageQueueThreadImpl mUIQueueThread;

  private ReactQueueConfigurationImpl(MessageQueueThreadImpl paramMessageQueueThreadImpl1, MessageQueueThreadImpl paramMessageQueueThreadImpl2, MessageQueueThreadImpl paramMessageQueueThreadImpl3)
  {
    this.mUIQueueThread = paramMessageQueueThreadImpl1;
    this.mNativeModulesQueueThread = paramMessageQueueThreadImpl2;
    this.mJSQueueThread = paramMessageQueueThreadImpl3;
  }

  public static ReactQueueConfigurationImpl create(ReactQueueConfigurationSpec paramReactQueueConfigurationSpec, QueueThreadExceptionHandler paramQueueThreadExceptionHandler)
  {
    HashMap localHashMap = MapBuilder.newHashMap();
    MessageQueueThreadSpec localMessageQueueThreadSpec = MessageQueueThreadSpec.mainThreadSpec();
    MessageQueueThreadImpl localMessageQueueThreadImpl1 = MessageQueueThreadImpl.create(localMessageQueueThreadSpec, paramQueueThreadExceptionHandler);
    localHashMap.put(localMessageQueueThreadSpec, localMessageQueueThreadImpl1);
    MessageQueueThreadImpl localMessageQueueThreadImpl2 = (MessageQueueThreadImpl)localHashMap.get(paramReactQueueConfigurationSpec.getJSQueueThreadSpec());
    if (localMessageQueueThreadImpl2 == null);
    for (MessageQueueThreadImpl localMessageQueueThreadImpl3 = MessageQueueThreadImpl.create(paramReactQueueConfigurationSpec.getJSQueueThreadSpec(), paramQueueThreadExceptionHandler); ; localMessageQueueThreadImpl3 = localMessageQueueThreadImpl2)
    {
      MessageQueueThreadImpl localMessageQueueThreadImpl4 = (MessageQueueThreadImpl)localHashMap.get(paramReactQueueConfigurationSpec.getNativeModulesQueueThreadSpec());
      if (localMessageQueueThreadImpl4 == null)
        localMessageQueueThreadImpl4 = MessageQueueThreadImpl.create(paramReactQueueConfigurationSpec.getNativeModulesQueueThreadSpec(), paramQueueThreadExceptionHandler);
      return new ReactQueueConfigurationImpl(localMessageQueueThreadImpl1, localMessageQueueThreadImpl4, localMessageQueueThreadImpl3);
    }
  }

  public void destroy()
  {
    if (this.mNativeModulesQueueThread.getLooper() != Looper.getMainLooper())
      this.mNativeModulesQueueThread.quitSynchronous();
    if (this.mJSQueueThread.getLooper() != Looper.getMainLooper())
      this.mJSQueueThread.quitSynchronous();
  }

  public MessageQueueThread getJSQueueThread()
  {
    return this.mJSQueueThread;
  }

  public MessageQueueThread getNativeModulesQueueThread()
  {
    return this.mNativeModulesQueueThread;
  }

  public MessageQueueThread getUIQueueThread()
  {
    return this.mUIQueueThread;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.queue.ReactQueueConfigurationImpl
 * JD-Core Version:    0.6.2
 */
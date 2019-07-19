package com.facebook.react.bridge.queue;

import android.os.Build.VERSION;
import com.facebook.infer.annotation.Assertions;
import javax.annotation.Nullable;

public class ReactQueueConfigurationSpec
{
  private static final long LEGACY_STACK_SIZE_BYTES = 2000000L;
  private final MessageQueueThreadSpec mJSQueueThreadSpec;
  private final MessageQueueThreadSpec mNativeModulesQueueThreadSpec;

  private ReactQueueConfigurationSpec(MessageQueueThreadSpec paramMessageQueueThreadSpec1, MessageQueueThreadSpec paramMessageQueueThreadSpec2)
  {
    this.mNativeModulesQueueThreadSpec = paramMessageQueueThreadSpec1;
    this.mJSQueueThreadSpec = paramMessageQueueThreadSpec2;
  }

  public static Builder builder()
  {
    return new Builder();
  }

  public static ReactQueueConfigurationSpec createDefault()
  {
    if (Build.VERSION.SDK_INT < 21);
    for (MessageQueueThreadSpec localMessageQueueThreadSpec = MessageQueueThreadSpec.newBackgroundThreadSpec("native_modules", 2000000L); ; localMessageQueueThreadSpec = MessageQueueThreadSpec.newBackgroundThreadSpec("native_modules"))
      return builder().setJSQueueThreadSpec(MessageQueueThreadSpec.newBackgroundThreadSpec("js")).setNativeModulesQueueThreadSpec(localMessageQueueThreadSpec).build();
  }

  public MessageQueueThreadSpec getJSQueueThreadSpec()
  {
    return this.mJSQueueThreadSpec;
  }

  public MessageQueueThreadSpec getNativeModulesQueueThreadSpec()
  {
    return this.mNativeModulesQueueThreadSpec;
  }

  public static class Builder
  {

    @Nullable
    private MessageQueueThreadSpec mJSQueueSpec;

    @Nullable
    private MessageQueueThreadSpec mNativeModulesQueueSpec;

    public ReactQueueConfigurationSpec build()
    {
      return new ReactQueueConfigurationSpec((MessageQueueThreadSpec)Assertions.assertNotNull(this.mNativeModulesQueueSpec), (MessageQueueThreadSpec)Assertions.assertNotNull(this.mJSQueueSpec), null);
    }

    public Builder setJSQueueThreadSpec(MessageQueueThreadSpec paramMessageQueueThreadSpec)
    {
      if (this.mJSQueueSpec == null);
      for (boolean bool = true; ; bool = false)
      {
        Assertions.assertCondition(bool, "Setting JS queue multiple times!");
        this.mJSQueueSpec = paramMessageQueueThreadSpec;
        return this;
      }
    }

    public Builder setNativeModulesQueueThreadSpec(MessageQueueThreadSpec paramMessageQueueThreadSpec)
    {
      if (this.mNativeModulesQueueSpec == null);
      for (boolean bool = true; ; bool = false)
      {
        Assertions.assertCondition(bool, "Setting native modules queue spec multiple times!");
        this.mNativeModulesQueueSpec = paramMessageQueueThreadSpec;
        return this;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.queue.ReactQueueConfigurationSpec
 * JD-Core Version:    0.6.2
 */
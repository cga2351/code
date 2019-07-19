package com.facebook.react.bridge.queue;

public class MessageQueueThreadSpec
{
  public static final long DEFAULT_STACK_SIZE_BYTES;
  private static final MessageQueueThreadSpec MAIN_UI_SPEC = new MessageQueueThreadSpec(ThreadType.MAIN_UI, "main_ui");
  private final String mName;
  private final long mStackSize;
  private final ThreadType mThreadType;

  private MessageQueueThreadSpec(ThreadType paramThreadType, String paramString)
  {
    this(paramThreadType, paramString, 0L);
  }

  private MessageQueueThreadSpec(ThreadType paramThreadType, String paramString, long paramLong)
  {
    this.mThreadType = paramThreadType;
    this.mName = paramString;
    this.mStackSize = paramLong;
  }

  public static MessageQueueThreadSpec mainThreadSpec()
  {
    return MAIN_UI_SPEC;
  }

  public static MessageQueueThreadSpec newBackgroundThreadSpec(String paramString)
  {
    return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, paramString);
  }

  public static MessageQueueThreadSpec newBackgroundThreadSpec(String paramString, long paramLong)
  {
    return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, paramString, paramLong);
  }

  public static MessageQueueThreadSpec newUIBackgroundTreadSpec(String paramString)
  {
    return new MessageQueueThreadSpec(ThreadType.NEW_BACKGROUND, paramString);
  }

  public String getName()
  {
    return this.mName;
  }

  public long getStackSize()
  {
    return this.mStackSize;
  }

  public ThreadType getThreadType()
  {
    return this.mThreadType;
  }

  protected static enum ThreadType
  {
    static
    {
      ThreadType[] arrayOfThreadType = new ThreadType[2];
      arrayOfThreadType[0] = MAIN_UI;
      arrayOfThreadType[1] = NEW_BACKGROUND;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.queue.MessageQueueThreadSpec
 * JD-Core Version:    0.6.2
 */
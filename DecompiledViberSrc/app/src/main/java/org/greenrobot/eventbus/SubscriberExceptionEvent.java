package org.greenrobot.eventbus;

public final class SubscriberExceptionEvent
{
  public final Object causingEvent;
  public final Object causingSubscriber;
  public final EventBus eventBus;
  public final Throwable throwable;

  public SubscriberExceptionEvent(EventBus paramEventBus, Throwable paramThrowable, Object paramObject1, Object paramObject2)
  {
    this.eventBus = paramEventBus;
    this.throwable = paramThrowable;
    this.causingEvent = paramObject1;
    this.causingSubscriber = paramObject2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.SubscriberExceptionEvent
 * JD-Core Version:    0.6.2
 */
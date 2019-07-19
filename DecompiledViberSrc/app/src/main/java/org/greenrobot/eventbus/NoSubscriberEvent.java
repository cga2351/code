package org.greenrobot.eventbus;

public final class NoSubscriberEvent
{
  public final EventBus eventBus;
  public final Object originalEvent;

  public NoSubscriberEvent(EventBus paramEventBus, Object paramObject)
  {
    this.eventBus = paramEventBus;
    this.originalEvent = paramObject;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.NoSubscriberEvent
 * JD-Core Version:    0.6.2
 */
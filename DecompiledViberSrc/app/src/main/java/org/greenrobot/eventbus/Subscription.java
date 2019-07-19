package org.greenrobot.eventbus;

final class Subscription
{
  volatile boolean active;
  final Object subscriber;
  final SubscriberMethod subscriberMethod;

  Subscription(Object paramObject, SubscriberMethod paramSubscriberMethod)
  {
    this.subscriber = paramObject;
    this.subscriberMethod = paramSubscriberMethod;
    this.active = true;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof Subscription;
    boolean bool2 = false;
    if (bool1)
    {
      Subscription localSubscription = (Subscription)paramObject;
      Object localObject1 = this.subscriber;
      Object localObject2 = localSubscription.subscriber;
      bool2 = false;
      if (localObject1 == localObject2)
      {
        boolean bool3 = this.subscriberMethod.equals(localSubscription.subscriberMethod);
        bool2 = false;
        if (bool3)
          bool2 = true;
      }
    }
    return bool2;
  }

  public int hashCode()
  {
    return this.subscriber.hashCode() + this.subscriberMethod.methodString.hashCode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.Subscription
 * JD-Core Version:    0.6.2
 */
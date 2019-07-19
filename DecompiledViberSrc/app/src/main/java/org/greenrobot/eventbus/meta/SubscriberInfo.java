package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.SubscriberMethod;

public abstract interface SubscriberInfo
{
  public abstract Class<?> getSubscriberClass();

  public abstract SubscriberMethod[] getSubscriberMethods();

  public abstract SubscriberInfo getSuperSubscriberInfo();

  public abstract boolean shouldCheckSuperclass();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.meta.SubscriberInfo
 * JD-Core Version:    0.6.2
 */
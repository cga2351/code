package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.ThreadMode;

public abstract class AbstractSubscriberInfo
  implements SubscriberInfo
{
  private final boolean shouldCheckSuperclass;
  private final Class subscriberClass;
  private final Class<? extends SubscriberInfo> superSubscriberInfoClass;

  protected AbstractSubscriberInfo(Class paramClass, Class<? extends SubscriberInfo> paramClass1, boolean paramBoolean)
  {
    this.subscriberClass = paramClass;
    this.superSubscriberInfoClass = paramClass1;
    this.shouldCheckSuperclass = paramBoolean;
  }

  protected SubscriberMethod createSubscriberMethod(String paramString, Class<?> paramClass)
  {
    return createSubscriberMethod(paramString, paramClass, ThreadMode.POSTING, 0, false);
  }

  protected SubscriberMethod createSubscriberMethod(String paramString, Class<?> paramClass, ThreadMode paramThreadMode)
  {
    return createSubscriberMethod(paramString, paramClass, paramThreadMode, 0, false);
  }

  protected SubscriberMethod createSubscriberMethod(String paramString, Class<?> paramClass, ThreadMode paramThreadMode, int paramInt, boolean paramBoolean)
  {
    try
    {
      SubscriberMethod localSubscriberMethod = new SubscriberMethod(this.subscriberClass.getDeclaredMethod(paramString, new Class[] { paramClass }), paramClass, paramThreadMode, paramInt, paramBoolean);
      return localSubscriberMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new EventBusException("Could not find subscriber method in " + this.subscriberClass + ". Maybe a missing ProGuard rule?", localNoSuchMethodException);
    }
  }

  public Class getSubscriberClass()
  {
    return this.subscriberClass;
  }

  public SubscriberInfo getSuperSubscriberInfo()
  {
    if (this.superSubscriberInfoClass == null)
      return null;
    try
    {
      SubscriberInfo localSubscriberInfo = (SubscriberInfo)this.superSubscriberInfoClass.newInstance();
      return localSubscriberInfo;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException(localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
  }

  public boolean shouldCheckSuperclass()
  {
    return this.shouldCheckSuperclass;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.meta.AbstractSubscriberInfo
 * JD-Core Version:    0.6.2
 */
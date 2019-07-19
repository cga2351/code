package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.ThreadMode;

public class SubscriberMethodInfo
{
  final Class<?> eventType;
  final String methodName;
  final int priority;
  final boolean sticky;
  final ThreadMode threadMode;

  public SubscriberMethodInfo(String paramString, Class<?> paramClass)
  {
    this(paramString, paramClass, ThreadMode.POSTING, 0, false);
  }

  public SubscriberMethodInfo(String paramString, Class<?> paramClass, ThreadMode paramThreadMode)
  {
    this(paramString, paramClass, paramThreadMode, 0, false);
  }

  public SubscriberMethodInfo(String paramString, Class<?> paramClass, ThreadMode paramThreadMode, int paramInt, boolean paramBoolean)
  {
    this.methodName = paramString;
    this.threadMode = paramThreadMode;
    this.eventType = paramClass;
    this.priority = paramInt;
    this.sticky = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.meta.SubscriberMethodInfo
 * JD-Core Version:    0.6.2
 */
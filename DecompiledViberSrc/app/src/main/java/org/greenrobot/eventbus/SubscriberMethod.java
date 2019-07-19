package org.greenrobot.eventbus;

import java.lang.reflect.Method;

public class SubscriberMethod
{
  final Class<?> eventType;
  final Method method;
  String methodString;
  final int priority;
  final boolean sticky;
  final ThreadMode threadMode;

  public SubscriberMethod(Method paramMethod, Class<?> paramClass, ThreadMode paramThreadMode, int paramInt, boolean paramBoolean)
  {
    this.method = paramMethod;
    this.threadMode = paramThreadMode;
    this.eventType = paramClass;
    this.priority = paramInt;
    this.sticky = paramBoolean;
  }

  private void checkMethodString()
  {
    try
    {
      if (this.methodString == null)
      {
        StringBuilder localStringBuilder = new StringBuilder(64);
        localStringBuilder.append(this.method.getDeclaringClass().getName());
        localStringBuilder.append('#').append(this.method.getName());
        localStringBuilder.append('(').append(this.eventType.getName());
        this.methodString = localStringBuilder.toString();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if ((paramObject instanceof SubscriberMethod))
    {
      checkMethodString();
      SubscriberMethod localSubscriberMethod = (SubscriberMethod)paramObject;
      localSubscriberMethod.checkMethodString();
      return this.methodString.equals(localSubscriberMethod.methodString);
    }
    return false;
  }

  public int hashCode()
  {
    return this.method.hashCode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.SubscriberMethod
 * JD-Core Version:    0.6.2
 */
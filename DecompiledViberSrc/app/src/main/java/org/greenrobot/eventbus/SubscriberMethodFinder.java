package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

class SubscriberMethodFinder
{
  private static final int BRIDGE = 64;
  private static final FindState[] FIND_STATE_POOL = new FindState[4];
  private static final Map<Class<?>, List<SubscriberMethod>> METHOD_CACHE = new ConcurrentHashMap();
  private static final int MODIFIERS_IGNORE = 5192;
  private static final int POOL_SIZE = 4;
  private static final int SYNTHETIC = 4096;
  private final boolean ignoreGeneratedIndex;
  private final boolean strictMethodVerification;
  private List<SubscriberInfoIndex> subscriberInfoIndexes;

  SubscriberMethodFinder(List<SubscriberInfoIndex> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.subscriberInfoIndexes = paramList;
    this.strictMethodVerification = paramBoolean1;
    this.ignoreGeneratedIndex = paramBoolean2;
  }

  static void clearCaches()
  {
    METHOD_CACHE.clear();
  }

  private List<SubscriberMethod> findUsingInfo(Class<?> paramClass)
  {
    FindState localFindState = prepareFindState();
    localFindState.initForSubscriber(paramClass);
    while (localFindState.clazz != null)
    {
      localFindState.subscriberInfo = getSubscriberInfo(localFindState);
      if (localFindState.subscriberInfo != null)
        for (SubscriberMethod localSubscriberMethod : localFindState.subscriberInfo.getSubscriberMethods())
          if (localFindState.checkAdd(localSubscriberMethod.method, localSubscriberMethod.eventType))
            localFindState.subscriberMethods.add(localSubscriberMethod);
      findUsingReflectionInSingleClass(localFindState);
      localFindState.moveToSuperclass();
    }
    return getMethodsAndRelease(localFindState);
  }

  private List<SubscriberMethod> findUsingReflection(Class<?> paramClass)
  {
    FindState localFindState = prepareFindState();
    localFindState.initForSubscriber(paramClass);
    while (localFindState.clazz != null)
    {
      findUsingReflectionInSingleClass(localFindState);
      localFindState.moveToSuperclass();
    }
    return getMethodsAndRelease(localFindState);
  }

  private void findUsingReflectionInSingleClass(FindState paramFindState)
  {
    while (true)
    {
      Method localMethod;
      try
      {
        Method[] arrayOfMethod2 = paramFindState.clazz.getDeclaredMethods();
        localObject = arrayOfMethod2;
        int i = localObject.length;
        int j = 0;
        if (j >= i)
          break;
        localMethod = localObject[j];
        int k = localMethod.getModifiers();
        if (((k & 0x1) != 0) && ((k & 0x1448) == 0))
        {
          arrayOfClass = localMethod.getParameterTypes();
          if (arrayOfClass.length == 1)
          {
            Subscribe localSubscribe = (Subscribe)localMethod.getAnnotation(Subscribe.class);
            if (localSubscribe != null)
            {
              Class localClass = arrayOfClass[0];
              if (paramFindState.checkAdd(localMethod, localClass))
              {
                ThreadMode localThreadMode = localSubscribe.threadMode();
                paramFindState.subscriberMethods.add(new SubscriberMethod(localMethod, localClass, localThreadMode, localSubscribe.priority(), localSubscribe.sticky()));
              }
            }
            j++;
            continue;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Class[] arrayOfClass;
        Method[] arrayOfMethod1 = paramFindState.clazz.getMethods();
        paramFindState.skipSuperClasses = true;
        Object localObject = arrayOfMethod1;
        continue;
        if ((!this.strictMethodVerification) || (!localMethod.isAnnotationPresent(Subscribe.class)))
          continue;
        String str2 = localMethod.getDeclaringClass().getName() + "." + localMethod.getName();
        throw new EventBusException("@Subscribe method " + str2 + "must have exactly 1 parameter but has " + arrayOfClass.length);
      }
      if ((this.strictMethodVerification) && (localMethod.isAnnotationPresent(Subscribe.class)))
      {
        String str1 = localMethod.getDeclaringClass().getName() + "." + localMethod.getName();
        throw new EventBusException(str1 + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
      }
    }
  }

  private List<SubscriberMethod> getMethodsAndRelease(FindState paramFindState)
  {
    ArrayList localArrayList = new ArrayList(paramFindState.subscriberMethods);
    paramFindState.recycle();
    FindState[] arrayOfFindState = FIND_STATE_POOL;
    for (int i = 0; ; i++)
    {
      if (i < 4);
      try
      {
        if (FIND_STATE_POOL[i] == null)
        {
          FIND_STATE_POOL[i] = paramFindState;
          return localArrayList;
        }
      }
      finally
      {
      }
    }
  }

  private SubscriberInfo getSubscriberInfo(FindState paramFindState)
  {
    if ((paramFindState.subscriberInfo != null) && (paramFindState.subscriberInfo.getSuperSubscriberInfo() != null))
    {
      SubscriberInfo localSubscriberInfo2 = paramFindState.subscriberInfo.getSuperSubscriberInfo();
      if (paramFindState.clazz == localSubscriberInfo2.getSubscriberClass())
        return localSubscriberInfo2;
    }
    if (this.subscriberInfoIndexes != null)
    {
      Iterator localIterator = this.subscriberInfoIndexes.iterator();
      while (localIterator.hasNext())
      {
        SubscriberInfo localSubscriberInfo1 = ((SubscriberInfoIndex)localIterator.next()).getSubscriberInfo(paramFindState.clazz);
        if (localSubscriberInfo1 != null)
          return localSubscriberInfo1;
      }
    }
    return null;
  }

  private FindState prepareFindState()
  {
    FindState[] arrayOfFindState = FIND_STATE_POOL;
    for (int i = 0; ; i++)
    {
      if (i < 4);
      try
      {
        FindState localFindState = FIND_STATE_POOL[i];
        if (localFindState != null)
        {
          FIND_STATE_POOL[i] = null;
          return localFindState;
          return new FindState();
        }
      }
      finally
      {
      }
    }
  }

  List<SubscriberMethod> findSubscriberMethods(Class<?> paramClass)
  {
    List localList1 = (List)METHOD_CACHE.get(paramClass);
    if (localList1 != null)
      return localList1;
    if (this.ignoreGeneratedIndex);
    for (List localList2 = findUsingReflection(paramClass); localList2.isEmpty(); localList2 = findUsingInfo(paramClass))
      throw new EventBusException("Subscriber " + paramClass + " and its super classes have no public methods with the @Subscribe annotation");
    METHOD_CACHE.put(paramClass, localList2);
    return localList2;
  }

  static class FindState
  {
    final Map<Class, Object> anyMethodByEventType = new HashMap();
    Class<?> clazz;
    final StringBuilder methodKeyBuilder = new StringBuilder(128);
    boolean skipSuperClasses;
    Class<?> subscriberClass;
    final Map<String, Class> subscriberClassByMethodKey = new HashMap();
    SubscriberInfo subscriberInfo;
    final List<SubscriberMethod> subscriberMethods = new ArrayList();

    private boolean checkAddWithMethodSignature(Method paramMethod, Class<?> paramClass)
    {
      this.methodKeyBuilder.setLength(0);
      this.methodKeyBuilder.append(paramMethod.getName());
      this.methodKeyBuilder.append('>').append(paramClass.getName());
      String str = this.methodKeyBuilder.toString();
      Class localClass1 = paramMethod.getDeclaringClass();
      Class localClass2 = (Class)this.subscriberClassByMethodKey.put(str, localClass1);
      if ((localClass2 == null) || (localClass2.isAssignableFrom(localClass1)))
        return true;
      this.subscriberClassByMethodKey.put(str, localClass2);
      return false;
    }

    boolean checkAdd(Method paramMethod, Class<?> paramClass)
    {
      Object localObject = this.anyMethodByEventType.put(paramClass, paramMethod);
      if (localObject == null)
        return true;
      if ((localObject instanceof Method))
      {
        if (!checkAddWithMethodSignature((Method)localObject, paramClass))
          throw new IllegalStateException();
        this.anyMethodByEventType.put(paramClass, this);
      }
      return checkAddWithMethodSignature(paramMethod, paramClass);
    }

    void initForSubscriber(Class<?> paramClass)
    {
      this.clazz = paramClass;
      this.subscriberClass = paramClass;
      this.skipSuperClasses = false;
      this.subscriberInfo = null;
    }

    void moveToSuperclass()
    {
      if (this.skipSuperClasses)
        this.clazz = null;
      String str;
      do
      {
        return;
        this.clazz = this.clazz.getSuperclass();
        str = this.clazz.getName();
      }
      while ((!str.startsWith("java.")) && (!str.startsWith("javax.")) && (!str.startsWith("android.")));
      this.clazz = null;
    }

    void recycle()
    {
      this.subscriberMethods.clear();
      this.anyMethodByEventType.clear();
      this.subscriberClassByMethodKey.clear();
      this.methodKeyBuilder.setLength(0);
      this.subscriberClass = null;
      this.clazz = null;
      this.skipSuperClasses = false;
      this.subscriberInfo = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.SubscriberMethodFinder
 * JD-Core Version:    0.6.2
 */
package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

public class EventBus
{
  private static final EventBusBuilder DEFAULT_BUILDER = new EventBusBuilder();
  public static String TAG = "EventBus";
  static volatile EventBus defaultInstance;
  private static final Map<Class<?>, List<Class<?>>> eventTypesCache = new HashMap();
  private final AsyncPoster asyncPoster;
  private final BackgroundPoster backgroundPoster;
  private final ThreadLocal<PostingThreadState> currentPostingThreadState = new ThreadLocal()
  {
    protected EventBus.PostingThreadState initialValue()
    {
      return new EventBus.PostingThreadState();
    }
  };
  private final boolean eventInheritance;
  private final ExecutorService executorService;
  private final int indexCount;
  private final boolean logNoSubscriberMessages;
  private final boolean logSubscriberExceptions;
  private final Logger logger;
  private final Poster mainThreadPoster;
  private final MainThreadSupport mainThreadSupport;
  private final boolean sendNoSubscriberEvent;
  private final boolean sendSubscriberExceptionEvent;
  private final Map<Class<?>, Object> stickyEvents;
  private final SubscriberMethodFinder subscriberMethodFinder;
  private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType;
  private final boolean throwSubscriberException;
  private final Map<Object, List<Class<?>>> typesBySubscriber;

  public EventBus()
  {
    this(DEFAULT_BUILDER);
  }

  EventBus(EventBusBuilder paramEventBusBuilder)
  {
    this.logger = paramEventBusBuilder.getLogger();
    this.subscriptionsByEventType = new HashMap();
    this.typesBySubscriber = new HashMap();
    this.stickyEvents = new ConcurrentHashMap();
    this.mainThreadSupport = paramEventBusBuilder.getMainThreadSupport();
    Poster localPoster;
    if (this.mainThreadSupport != null)
    {
      localPoster = this.mainThreadSupport.createPoster(this);
      this.mainThreadPoster = localPoster;
      this.backgroundPoster = new BackgroundPoster(this);
      this.asyncPoster = new AsyncPoster(this);
      if (paramEventBusBuilder.subscriberInfoIndexes == null)
        break label219;
    }
    label219: for (int i = paramEventBusBuilder.subscriberInfoIndexes.size(); ; i = 0)
    {
      this.indexCount = i;
      this.subscriberMethodFinder = new SubscriberMethodFinder(paramEventBusBuilder.subscriberInfoIndexes, paramEventBusBuilder.strictMethodVerification, paramEventBusBuilder.ignoreGeneratedIndex);
      this.logSubscriberExceptions = paramEventBusBuilder.logSubscriberExceptions;
      this.logNoSubscriberMessages = paramEventBusBuilder.logNoSubscriberMessages;
      this.sendSubscriberExceptionEvent = paramEventBusBuilder.sendSubscriberExceptionEvent;
      this.sendNoSubscriberEvent = paramEventBusBuilder.sendNoSubscriberEvent;
      this.throwSubscriberException = paramEventBusBuilder.throwSubscriberException;
      this.eventInheritance = paramEventBusBuilder.eventInheritance;
      this.executorService = paramEventBusBuilder.executorService;
      return;
      localPoster = null;
      break;
    }
  }

  static void addInterfaces(List<Class<?>> paramList, Class<?>[] paramArrayOfClass)
  {
    int i = paramArrayOfClass.length;
    for (int j = 0; j < i; j++)
    {
      Class<?> localClass = paramArrayOfClass[j];
      if (!paramList.contains(localClass))
      {
        paramList.add(localClass);
        addInterfaces(paramList, localClass.getInterfaces());
      }
    }
  }

  public static EventBusBuilder builder()
  {
    return new EventBusBuilder();
  }

  private void checkPostStickyEventToSubscription(Subscription paramSubscription, Object paramObject)
  {
    if (paramObject != null)
      postToSubscription(paramSubscription, paramObject, isMainThread());
  }

  public static void clearCaches()
  {
    SubscriberMethodFinder.clearCaches();
    eventTypesCache.clear();
  }

  public static EventBus getDefault()
  {
    if (defaultInstance == null);
    try
    {
      if (defaultInstance == null)
        defaultInstance = new EventBus();
      return defaultInstance;
    }
    finally
    {
    }
  }

  private void handleSubscriberException(Subscription paramSubscription, Object paramObject, Throwable paramThrowable)
  {
    if ((paramObject instanceof SubscriberExceptionEvent))
      if (this.logSubscriberExceptions)
      {
        this.logger.log(Level.SEVERE, "SubscriberExceptionEvent subscriber " + paramSubscription.subscriber.getClass() + " threw an exception", paramThrowable);
        SubscriberExceptionEvent localSubscriberExceptionEvent = (SubscriberExceptionEvent)paramObject;
        this.logger.log(Level.SEVERE, "Initial event " + localSubscriberExceptionEvent.causingEvent + " caused exception in " + localSubscriberExceptionEvent.causingSubscriber, localSubscriberExceptionEvent.throwable);
      }
    do
    {
      return;
      if (this.throwSubscriberException)
        throw new EventBusException("Invoking subscriber failed", paramThrowable);
      if (this.logSubscriberExceptions)
        this.logger.log(Level.SEVERE, "Could not dispatch event: " + paramObject.getClass() + " to subscribing class " + paramSubscription.subscriber.getClass(), paramThrowable);
    }
    while (!this.sendSubscriberExceptionEvent);
    post(new SubscriberExceptionEvent(this, paramThrowable, paramObject, paramSubscription.subscriber));
  }

  private boolean isMainThread()
  {
    if (this.mainThreadSupport != null)
      return this.mainThreadSupport.isMainThread();
    return true;
  }

  private static List<Class<?>> lookupAllEventTypes(Class<?> paramClass)
  {
    synchronized (eventTypesCache)
    {
      Object localObject2 = (List)eventTypesCache.get(paramClass);
      if (localObject2 == null)
      {
        localObject2 = new ArrayList();
        for (Object localObject3 = paramClass; localObject3 != null; localObject3 = ((Class)localObject3).getSuperclass())
        {
          ((List)localObject2).add(localObject3);
          addInterfaces((List)localObject2, ((Class)localObject3).getInterfaces());
        }
        eventTypesCache.put(paramClass, localObject2);
      }
      return localObject2;
    }
  }

  private void postSingleEvent(Object paramObject, PostingThreadState paramPostingThreadState)
    throws Error
  {
    Class localClass = paramObject.getClass();
    boolean bool2;
    if (this.eventInheritance)
    {
      List localList = lookupAllEventTypes(localClass);
      int i = localList.size();
      int j = 0;
      bool2 = false;
      while (j < i)
      {
        bool2 |= postSingleEventForEventType(paramObject, paramPostingThreadState, (Class)localList.get(j));
        j++;
      }
    }
    for (boolean bool1 = bool2; ; bool1 = postSingleEventForEventType(paramObject, paramPostingThreadState, localClass))
    {
      if (!bool1)
      {
        if (this.logNoSubscriberMessages)
          this.logger.log(Level.FINE, "No subscribers registered for event " + localClass);
        if ((this.sendNoSubscriberEvent) && (localClass != NoSubscriberEvent.class) && (localClass != SubscriberExceptionEvent.class))
          post(new NoSubscriberEvent(this, paramObject));
      }
      return;
    }
  }

  // ERROR //
  private boolean postSingleEventForEventType(Object paramObject, PostingThreadState paramPostingThreadState, Class<?> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 82	org/greenrobot/eventbus/EventBus:subscriptionsByEventType	Ljava/util/Map;
    //   6: aload_3
    //   7: invokeinterface 284 2 0
    //   12: checkcast 322	java/util/concurrent/CopyOnWriteArrayList
    //   15: astore 5
    //   17: aload_0
    //   18: monitorexit
    //   19: aload 5
    //   21: ifnull +117 -> 138
    //   24: aload 5
    //   26: invokevirtual 325	java/util/concurrent/CopyOnWriteArrayList:isEmpty	()Z
    //   29: ifne +109 -> 138
    //   32: aload 5
    //   34: invokevirtual 329	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   37: astore 6
    //   39: aload 6
    //   41: invokeinterface 334 1 0
    //   46: ifeq +63 -> 109
    //   49: aload 6
    //   51: invokeinterface 338 1 0
    //   56: checkcast 222	org/greenrobot/eventbus/Subscription
    //   59: astore 7
    //   61: aload_2
    //   62: aload_1
    //   63: putfield 343	org/greenrobot/eventbus/EventBus$PostingThreadState:event	Ljava/lang/Object;
    //   66: aload_2
    //   67: aload 7
    //   69: putfield 347	org/greenrobot/eventbus/EventBus$PostingThreadState:subscription	Lorg/greenrobot/eventbus/Subscription;
    //   72: aload_0
    //   73: aload 7
    //   75: aload_1
    //   76: aload_2
    //   77: getfield 349	org/greenrobot/eventbus/EventBus$PostingThreadState:isMainThread	Z
    //   80: invokespecial 188	org/greenrobot/eventbus/EventBus:postToSubscription	(Lorg/greenrobot/eventbus/Subscription;Ljava/lang/Object;Z)V
    //   83: aload_2
    //   84: getfield 352	org/greenrobot/eventbus/EventBus$PostingThreadState:canceled	Z
    //   87: istore 9
    //   89: aload_2
    //   90: aconst_null
    //   91: putfield 343	org/greenrobot/eventbus/EventBus$PostingThreadState:event	Ljava/lang/Object;
    //   94: aload_2
    //   95: aconst_null
    //   96: putfield 347	org/greenrobot/eventbus/EventBus$PostingThreadState:subscription	Lorg/greenrobot/eventbus/Subscription;
    //   99: aload_2
    //   100: iconst_0
    //   101: putfield 352	org/greenrobot/eventbus/EventBus$PostingThreadState:canceled	Z
    //   104: iload 9
    //   106: ifeq -67 -> 39
    //   109: iconst_1
    //   110: ireturn
    //   111: astore 4
    //   113: aload_0
    //   114: monitorexit
    //   115: aload 4
    //   117: athrow
    //   118: astore 8
    //   120: aload_2
    //   121: aconst_null
    //   122: putfield 343	org/greenrobot/eventbus/EventBus$PostingThreadState:event	Ljava/lang/Object;
    //   125: aload_2
    //   126: aconst_null
    //   127: putfield 347	org/greenrobot/eventbus/EventBus$PostingThreadState:subscription	Lorg/greenrobot/eventbus/Subscription;
    //   130: aload_2
    //   131: iconst_0
    //   132: putfield 352	org/greenrobot/eventbus/EventBus$PostingThreadState:canceled	Z
    //   135: aload 8
    //   137: athrow
    //   138: iconst_0
    //   139: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   2	19	111	finally
    //   113	115	111	finally
    //   72	89	118	finally
  }

  private void postToSubscription(Subscription paramSubscription, Object paramObject, boolean paramBoolean)
  {
    switch (2.$SwitchMap$org$greenrobot$eventbus$ThreadMode[paramSubscription.subscriberMethod.threadMode.ordinal()])
    {
    default:
      throw new IllegalStateException("Unknown thread mode: " + paramSubscription.subscriberMethod.threadMode);
    case 1:
      invokeSubscriber(paramSubscription, paramObject);
      return;
    case 2:
      if (paramBoolean)
      {
        invokeSubscriber(paramSubscription, paramObject);
        return;
      }
      this.mainThreadPoster.enqueue(paramSubscription, paramObject);
      return;
    case 3:
      if (this.mainThreadPoster != null)
      {
        this.mainThreadPoster.enqueue(paramSubscription, paramObject);
        return;
      }
      invokeSubscriber(paramSubscription, paramObject);
      return;
    case 4:
      if (paramBoolean)
      {
        this.backgroundPoster.enqueue(paramSubscription, paramObject);
        return;
      }
      invokeSubscriber(paramSubscription, paramObject);
      return;
    case 5:
    }
    this.asyncPoster.enqueue(paramSubscription, paramObject);
  }

  private void subscribe(Object paramObject, SubscriberMethod paramSubscriberMethod)
  {
    Class localClass = paramSubscriberMethod.eventType;
    Subscription localSubscription = new Subscription(paramObject, paramSubscriberMethod);
    CopyOnWriteArrayList localCopyOnWriteArrayList1 = (CopyOnWriteArrayList)this.subscriptionsByEventType.get(localClass);
    CopyOnWriteArrayList localCopyOnWriteArrayList2;
    if (localCopyOnWriteArrayList1 == null)
    {
      localCopyOnWriteArrayList2 = new CopyOnWriteArrayList();
      this.subscriptionsByEventType.put(localClass, localCopyOnWriteArrayList2);
    }
    label327: label328: for (CopyOnWriteArrayList localCopyOnWriteArrayList3 = localCopyOnWriteArrayList2; ; localCopyOnWriteArrayList3 = localCopyOnWriteArrayList1)
    {
      int i = localCopyOnWriteArrayList3.size();
      for (int j = 0; ; j++)
        if (j <= i)
        {
          if ((j == i) || (paramSubscriberMethod.priority > ((Subscription)localCopyOnWriteArrayList3.get(j)).subscriberMethod.priority))
            localCopyOnWriteArrayList3.add(j, localSubscription);
        }
        else
        {
          Object localObject = (List)this.typesBySubscriber.get(paramObject);
          if (localObject == null)
          {
            localObject = new ArrayList();
            this.typesBySubscriber.put(paramObject, localObject);
          }
          ((List)localObject).add(localClass);
          if (!paramSubscriberMethod.sticky)
            break label327;
          if (!this.eventInheritance)
            break;
          Iterator localIterator = this.stickyEvents.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            if (localClass.isAssignableFrom((Class)localEntry.getKey()))
              checkPostStickyEventToSubscription(localSubscription, localEntry.getValue());
          }
          if (!localCopyOnWriteArrayList1.contains(localSubscription))
            break label328;
          throw new EventBusException("Subscriber " + paramObject.getClass() + " already registered to event " + localClass);
        }
      checkPostStickyEventToSubscription(localSubscription, this.stickyEvents.get(localClass));
      return;
    }
  }

  private void unsubscribeByEventType(Object paramObject, Class<?> paramClass)
  {
    List localList = (List)this.subscriptionsByEventType.get(paramClass);
    int i;
    int j;
    int k;
    if (localList != null)
    {
      i = localList.size();
      j = 0;
      if (j < i)
      {
        Subscription localSubscription = (Subscription)localList.get(j);
        if (localSubscription.subscriber != paramObject)
          break label103;
        localSubscription.active = false;
        localList.remove(j);
        k = j - 1;
      }
    }
    for (int m = i - 1; ; m = i)
    {
      int n = k + 1;
      i = m;
      j = n;
      break;
      return;
      label103: k = j;
    }
  }

  public void cancelEventDelivery(Object paramObject)
  {
    PostingThreadState localPostingThreadState = (PostingThreadState)this.currentPostingThreadState.get();
    if (!localPostingThreadState.isPosting)
      throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
    if (paramObject == null)
      throw new EventBusException("Event may not be null");
    if (localPostingThreadState.event != paramObject)
      throw new EventBusException("Only the currently handled event may be aborted");
    if (localPostingThreadState.subscription.subscriberMethod.threadMode != ThreadMode.POSTING)
      throw new EventBusException(" event handlers may only abort the incoming event");
    localPostingThreadState.canceled = true;
  }

  ExecutorService getExecutorService()
  {
    return this.executorService;
  }

  public Logger getLogger()
  {
    return this.logger;
  }

  public <T> T getStickyEvent(Class<T> paramClass)
  {
    synchronized (this.stickyEvents)
    {
      Object localObject2 = paramClass.cast(this.stickyEvents.get(paramClass));
      return localObject2;
    }
  }

  public boolean hasSubscriberForEvent(Class<?> paramClass)
  {
    List localList = lookupAllEventTypes(paramClass);
    if (localList != null)
    {
      int i = localList.size();
      for (int j = 0; j < i; j++)
      {
        Class localClass = (Class)localList.get(j);
        try
        {
          CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.subscriptionsByEventType.get(localClass);
          if ((localCopyOnWriteArrayList != null) && (!localCopyOnWriteArrayList.isEmpty()))
            return true;
        }
        finally
        {
        }
      }
    }
    return false;
  }

  void invokeSubscriber(PendingPost paramPendingPost)
  {
    Object localObject = paramPendingPost.event;
    Subscription localSubscription = paramPendingPost.subscription;
    PendingPost.releasePendingPost(paramPendingPost);
    if (localSubscription.active)
      invokeSubscriber(localSubscription, localObject);
  }

  void invokeSubscriber(Subscription paramSubscription, Object paramObject)
  {
    try
    {
      paramSubscription.subscriberMethod.method.invoke(paramSubscription.subscriber, new Object[] { paramObject });
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      handleSubscriberException(paramSubscription, paramObject, localInvocationTargetException.getCause());
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new IllegalStateException("Unexpected exception", localIllegalAccessException);
    }
  }

  public boolean isRegistered(Object paramObject)
  {
    try
    {
      boolean bool = this.typesBySubscriber.containsKey(paramObject);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void post(Object paramObject)
  {
    PostingThreadState localPostingThreadState = (PostingThreadState)this.currentPostingThreadState.get();
    List localList = localPostingThreadState.eventQueue;
    localList.add(paramObject);
    if (!localPostingThreadState.isPosting)
    {
      localPostingThreadState.isMainThread = isMainThread();
      localPostingThreadState.isPosting = true;
      if (localPostingThreadState.canceled)
        throw new EventBusException("Internal error. Abort state was not reset");
      try
      {
        if (!localList.isEmpty())
          postSingleEvent(localList.remove(0), localPostingThreadState);
      }
      finally
      {
        localPostingThreadState.isPosting = false;
        localPostingThreadState.isMainThread = false;
      }
    }
  }

  public void postSticky(Object paramObject)
  {
    synchronized (this.stickyEvents)
    {
      this.stickyEvents.put(paramObject.getClass(), paramObject);
      post(paramObject);
      return;
    }
  }

  public void register(Object paramObject)
  {
    Class localClass = paramObject.getClass();
    List localList = this.subscriberMethodFinder.findSubscriberMethods(localClass);
    try
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
        subscribe(paramObject, (SubscriberMethod)localIterator.next());
    }
    finally
    {
    }
  }

  public void removeAllStickyEvents()
  {
    synchronized (this.stickyEvents)
    {
      this.stickyEvents.clear();
      return;
    }
  }

  public <T> T removeStickyEvent(Class<T> paramClass)
  {
    synchronized (this.stickyEvents)
    {
      Object localObject2 = paramClass.cast(this.stickyEvents.remove(paramClass));
      return localObject2;
    }
  }

  public boolean removeStickyEvent(Object paramObject)
  {
    synchronized (this.stickyEvents)
    {
      Class localClass = paramObject.getClass();
      if (paramObject.equals(this.stickyEvents.get(localClass)))
      {
        this.stickyEvents.remove(localClass);
        return true;
      }
      return false;
    }
  }

  public String toString()
  {
    return "EventBus[indexCount=" + this.indexCount + ", eventInheritance=" + this.eventInheritance + "]";
  }

  public void unregister(Object paramObject)
  {
    try
    {
      List localList = (List)this.typesBySubscriber.get(paramObject);
      if (localList == null)
        break label75;
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
        unsubscribeByEventType(paramObject, (Class)localIterator.next());
    }
    finally
    {
    }
    this.typesBySubscriber.remove(paramObject);
    while (true)
    {
      return;
      label75: this.logger.log(Level.WARNING, "Subscriber to unregister was not registered before: " + paramObject.getClass());
    }
  }

  static abstract interface PostCallback
  {
    public abstract void onPostCompleted(List<SubscriberExceptionEvent> paramList);
  }

  static final class PostingThreadState
  {
    boolean canceled;
    Object event;
    final List<Object> eventQueue = new ArrayList();
    boolean isMainThread;
    boolean isPosting;
    Subscription subscription;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.EventBus
 * JD-Core Version:    0.6.2
 */
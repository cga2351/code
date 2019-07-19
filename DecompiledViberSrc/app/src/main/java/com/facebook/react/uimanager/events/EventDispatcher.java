package com.facebook.react.uimanager.events;

import android.util.LongSparseArray;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import com.facebook.systrace.Systrace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EventDispatcher
  implements LifecycleEventListener
{
  private static final Comparator<Event> EVENT_COMPARATOR = new Comparator()
  {
    public int compare(Event paramAnonymousEvent1, Event paramAnonymousEvent2)
    {
      if ((paramAnonymousEvent1 == null) && (paramAnonymousEvent2 == null));
      long l;
      do
      {
        return 0;
        if (paramAnonymousEvent1 == null)
          return -1;
        if (paramAnonymousEvent2 == null)
          return 1;
        l = paramAnonymousEvent1.getTimestampMs() - paramAnonymousEvent2.getTimestampMs();
      }
      while (l == 0L);
      if (l < 0L)
        return -1;
      return 1;
    }
  };
  private final ScheduleDispatchFrameCallback mCurrentFrameCallback = new ScheduleDispatchFrameCallback(null);
  private final DispatchEventsRunnable mDispatchEventsRunnable = new DispatchEventsRunnable(null);
  private final LongSparseArray<Integer> mEventCookieToLastEventIdx = new LongSparseArray();
  private final Map<String, Short> mEventNameToEventId = MapBuilder.newHashMap();
  private final ArrayList<Event> mEventStaging = new ArrayList();
  private final Object mEventsStagingLock = new Object();
  private Event[] mEventsToDispatch = new Event[16];
  private final Object mEventsToDispatchLock = new Object();
  private int mEventsToDispatchSize = 0;
  private volatile boolean mHasDispatchScheduled = false;
  private final AtomicInteger mHasDispatchScheduledCount = new AtomicInteger();
  private final ArrayList<EventDispatcherListener> mListeners = new ArrayList();
  private short mNextEventTypeId = 0;
  private final List<BatchEventDispatchedListener> mPostEventDispatchListeners = new ArrayList();
  private final ReactApplicationContext mReactContext;
  private volatile ReactEventEmitter mReactEventEmitter;

  public EventDispatcher(ReactApplicationContext paramReactApplicationContext)
  {
    this.mReactContext = paramReactApplicationContext;
    this.mReactContext.addLifecycleEventListener(this);
    this.mReactEventEmitter = new ReactEventEmitter(this.mReactContext);
  }

  private void addEventToEventsToDispatch(Event paramEvent)
  {
    if (this.mEventsToDispatchSize == this.mEventsToDispatch.length)
      this.mEventsToDispatch = ((Event[])Arrays.copyOf(this.mEventsToDispatch, 2 * this.mEventsToDispatch.length));
    Event[] arrayOfEvent = this.mEventsToDispatch;
    int i = this.mEventsToDispatchSize;
    this.mEventsToDispatchSize = (i + 1);
    arrayOfEvent[i] = paramEvent;
  }

  private void clearEventsToDispatch()
  {
    Arrays.fill(this.mEventsToDispatch, 0, this.mEventsToDispatchSize, null);
    this.mEventsToDispatchSize = 0;
  }

  private long getEventCookie(int paramInt, String paramString, short paramShort)
  {
    Short localShort = (Short)this.mEventNameToEventId.get(paramString);
    short s;
    if (localShort != null)
      s = localShort.shortValue();
    while (true)
    {
      return getEventCookie(paramInt, s, paramShort);
      s = this.mNextEventTypeId;
      this.mNextEventTypeId = ((short)(s + 1));
      this.mEventNameToEventId.put(paramString, Short.valueOf(s));
    }
  }

  private static long getEventCookie(int paramInt, short paramShort1, short paramShort2)
  {
    return paramInt | (0xFFFF & paramShort1) << 32 | (0xFFFF & paramShort2) << 48;
  }

  private void maybePostFrameCallbackFromNonUI()
  {
    if (this.mReactEventEmitter != null)
      this.mCurrentFrameCallback.maybePostFromNonUI();
  }

  private void moveStagedEventsToDispatchQueue()
  {
    while (true)
    {
      Object localObject3;
      int i;
      Object localObject5;
      long l;
      Integer localInteger;
      Object localObject6;
      synchronized (this.mEventsStagingLock)
      {
        localObject3 = this.mEventsToDispatchLock;
        i = 0;
        try
        {
          if (i >= this.mEventStaging.size())
            break label225;
          localObject5 = (Event)this.mEventStaging.get(i);
          if (!((Event)localObject5).canCoalesce())
          {
            addEventToEventsToDispatch((Event)localObject5);
          }
          else
          {
            l = getEventCookie(((Event)localObject5).getViewTag(), ((Event)localObject5).getEventName(), ((Event)localObject5).getCoalescingKey());
            localInteger = (Integer)this.mEventCookieToLastEventIdx.get(l);
            if (localInteger == null)
            {
              this.mEventCookieToLastEventIdx.put(l, Integer.valueOf(this.mEventsToDispatchSize));
              localObject6 = localObject5;
              localObject5 = null;
              if (localObject6 != null)
                addEventToEventsToDispatch(localObject6);
              if (localObject5 == null)
                break label237;
              ((Event)localObject5).dispose();
            }
          }
        }
        finally
        {
        }
      }
      Event localEvent1 = this.mEventsToDispatch[localInteger.intValue()];
      Event localEvent2 = ((Event)localObject5).coalesce(localEvent1);
      if (localEvent2 != localEvent1)
      {
        this.mEventCookieToLastEventIdx.put(l, Integer.valueOf(this.mEventsToDispatchSize));
        this.mEventsToDispatch[localInteger.intValue()] = null;
        localObject5 = localEvent1;
        localObject6 = localEvent2;
        continue;
        label225: this.mEventStaging.clear();
        return;
        label237: i++;
      }
      else
      {
        localObject6 = null;
      }
    }
  }

  private void stopFrameCallback()
  {
    UiThreadUtil.assertOnUiThread();
    this.mCurrentFrameCallback.stop();
  }

  public void addBatchEventDispatchedListener(BatchEventDispatchedListener paramBatchEventDispatchedListener)
  {
    this.mPostEventDispatchListeners.add(paramBatchEventDispatchedListener);
  }

  public void addListener(EventDispatcherListener paramEventDispatcherListener)
  {
    this.mListeners.add(paramEventDispatcherListener);
  }

  public void dispatchAllEvents()
  {
    maybePostFrameCallbackFromNonUI();
  }

  public void dispatchEvent(Event paramEvent)
  {
    Assertions.assertCondition(paramEvent.isInitialized(), "Dispatched event hasn't been initialized");
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((EventDispatcherListener)localIterator.next()).onEventDispatch(paramEvent);
    synchronized (this.mEventsStagingLock)
    {
      this.mEventStaging.add(paramEvent);
      Systrace.startAsyncFlow(0L, paramEvent.getEventName(), paramEvent.getUniqueID());
      maybePostFrameCallbackFromNonUI();
      return;
    }
  }

  public void onCatalystInstanceDestroyed()
  {
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        EventDispatcher.this.stopFrameCallback();
      }
    });
  }

  public void onHostDestroy()
  {
    stopFrameCallback();
  }

  public void onHostPause()
  {
    stopFrameCallback();
  }

  public void onHostResume()
  {
    this.mCurrentFrameCallback.maybePostFromNonUI();
  }

  public void registerEventEmitter(int paramInt, RCTEventEmitter paramRCTEventEmitter)
  {
    this.mReactEventEmitter.register(paramInt, paramRCTEventEmitter);
  }

  public void removeBatchEventDispatchedListener(BatchEventDispatchedListener paramBatchEventDispatchedListener)
  {
    this.mPostEventDispatchListeners.remove(paramBatchEventDispatchedListener);
  }

  public void removeListener(EventDispatcherListener paramEventDispatcherListener)
  {
    this.mListeners.remove(paramEventDispatcherListener);
  }

  public void unregisterEventEmitter(int paramInt)
  {
    this.mReactEventEmitter.unregister(paramInt);
  }

  private class DispatchEventsRunnable
    implements Runnable
  {
    private DispatchEventsRunnable()
    {
    }

    public void run()
    {
      Systrace.beginSection(0L, "DispatchEventsRunnable");
      while (true)
      {
        int j;
        try
        {
          Systrace.endAsyncFlow(0L, "ScheduleDispatchFrameCallback", EventDispatcher.this.mHasDispatchScheduledCount.getAndIncrement());
          EventDispatcher.access$402(EventDispatcher.this, false);
          Assertions.assertNotNull(EventDispatcher.this.mReactEventEmitter);
          synchronized (EventDispatcher.this.mEventsToDispatchLock)
          {
            if (EventDispatcher.this.mEventsToDispatchSize <= 0)
              break label201;
            int i = EventDispatcher.this.mEventsToDispatchSize;
            j = 0;
            if (i > 1)
              Arrays.sort(EventDispatcher.this.mEventsToDispatch, 0, EventDispatcher.this.mEventsToDispatchSize, EventDispatcher.EVENT_COMPARATOR);
            if (j < EventDispatcher.this.mEventsToDispatchSize)
            {
              Event localEvent = EventDispatcher.this.mEventsToDispatch[j];
              if (localEvent == null)
                break label251;
              Systrace.endAsyncFlow(0L, localEvent.getEventName(), localEvent.getUniqueID());
              localEvent.dispatch(EventDispatcher.this.mReactEventEmitter);
              localEvent.dispose();
            }
          }
        }
        finally
        {
          Systrace.endSection(0L);
        }
        EventDispatcher.this.clearEventsToDispatch();
        EventDispatcher.this.mEventCookieToLastEventIdx.clear();
        label201: Iterator localIterator = EventDispatcher.this.mPostEventDispatchListeners.iterator();
        while (localIterator.hasNext())
          ((BatchEventDispatchedListener)localIterator.next()).onBatchEventDispatched();
        Systrace.endSection(0L);
        return;
        label251: j++;
      }
    }
  }

  private class ScheduleDispatchFrameCallback extends ChoreographerCompat.FrameCallback
  {
    private volatile boolean mIsPosted = false;
    private boolean mShouldStop = false;

    private ScheduleDispatchFrameCallback()
    {
    }

    private void post()
    {
      ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, EventDispatcher.this.mCurrentFrameCallback);
    }

    public void doFrame(long paramLong)
    {
      UiThreadUtil.assertOnUiThread();
      if (this.mShouldStop)
        this.mIsPosted = false;
      while (true)
      {
        Systrace.beginSection(0L, "ScheduleDispatchFrameCallback");
        try
        {
          EventDispatcher.this.moveStagedEventsToDispatchQueue();
          if (!EventDispatcher.this.mHasDispatchScheduled)
          {
            EventDispatcher.access$402(EventDispatcher.this, true);
            Systrace.startAsyncFlow(0L, "ScheduleDispatchFrameCallback", EventDispatcher.this.mHasDispatchScheduledCount.get());
            EventDispatcher.this.mReactContext.runOnJSQueueThread(EventDispatcher.this.mDispatchEventsRunnable);
          }
          return;
          post();
        }
        finally
        {
          Systrace.endSection(0L);
        }
      }
    }

    public void maybePost()
    {
      if (!this.mIsPosted)
      {
        this.mIsPosted = true;
        post();
      }
    }

    public void maybePostFromNonUI()
    {
      if (this.mIsPosted)
        return;
      if (EventDispatcher.this.mReactContext.isOnUiQueueThread())
      {
        maybePost();
        return;
      }
      EventDispatcher.this.mReactContext.runOnUiQueueThread(new Runnable()
      {
        public void run()
        {
          EventDispatcher.ScheduleDispatchFrameCallback.this.maybePost();
        }
      });
    }

    public void stop()
    {
      this.mShouldStop = true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.events.EventDispatcher
 * JD-Core Version:    0.6.2
 */
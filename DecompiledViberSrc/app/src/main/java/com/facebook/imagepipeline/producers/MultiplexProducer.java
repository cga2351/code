package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.common.Priority;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class MultiplexProducer<K, T extends Closeable>
  implements Producer<T>
{
  private final Producer<T> mInputProducer;

  @VisibleForTesting
  @GuardedBy("this")
  final Map<K, MultiplexProducer<K, T>.Multiplexer> mMultiplexers;

  protected MultiplexProducer(Producer<T> paramProducer)
  {
    this.mInputProducer = paramProducer;
    this.mMultiplexers = new HashMap();
  }

  private MultiplexProducer<K, T>.Multiplexer createAndPutNewMultiplexer(K paramK)
  {
    try
    {
      Multiplexer localMultiplexer = new Multiplexer(paramK);
      this.mMultiplexers.put(paramK, localMultiplexer);
      return localMultiplexer;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private MultiplexProducer<K, T>.Multiplexer getExistingMultiplexer(K paramK)
  {
    try
    {
      Multiplexer localMultiplexer = (Multiplexer)this.mMultiplexers.get(paramK);
      return localMultiplexer;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void removeMultiplexer(K paramK, MultiplexProducer<K, T>.Multiplexer paramMultiplexProducer)
  {
    try
    {
      if (this.mMultiplexers.get(paramK) == paramMultiplexProducer)
        this.mMultiplexers.remove(paramK);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected abstract T cloneOrNull(T paramT);

  protected abstract K getKey(ProducerContext paramProducerContext);

  public void produceResults(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
  {
    Object localObject1 = getKey(paramProducerContext);
    while (true)
      try
      {
        Multiplexer localMultiplexer = getExistingMultiplexer(localObject1);
        int i = 0;
        if (localMultiplexer == null)
        {
          localMultiplexer = createAndPutNewMultiplexer(localObject1);
          i = 1;
        }
        if (!localMultiplexer.addNewConsumer(paramConsumer, paramProducerContext))
          continue;
        if (i != 0)
          localMultiplexer.startInputProducerIfHasAttachedConsumers();
        return;
      }
      finally
      {
      }
  }

  @VisibleForTesting
  class Multiplexer
  {
    private final CopyOnWriteArraySet<Pair<Consumer<T>, ProducerContext>> mConsumerContextPairs = Sets.newCopyOnWriteArraySet();

    @Nullable
    @GuardedBy("Multiplexer.this")
    private MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer mForwardingConsumer;
    private final K mKey;

    @Nullable
    @GuardedBy("Multiplexer.this")
    private T mLastIntermediateResult;

    @GuardedBy("Multiplexer.this")
    private float mLastProgress;

    @GuardedBy("Multiplexer.this")
    private int mLastStatus;

    @Nullable
    @GuardedBy("Multiplexer.this")
    private BaseProducerContext mMultiplexProducerContext;

    public Multiplexer()
    {
      Object localObject;
      this.mKey = localObject;
    }

    private void addCallbacks(final Pair<Consumer<T>, ProducerContext> paramPair, ProducerContext paramProducerContext)
    {
      paramProducerContext.addCallbacks(new BaseProducerContextCallbacks()
      {
        public void onCancellationRequested()
        {
          Object localObject1 = null;
          while (true)
          {
            synchronized (MultiplexProducer.Multiplexer.this)
            {
              boolean bool = MultiplexProducer.Multiplexer.this.mConsumerContextPairs.remove(paramPair);
              if (bool)
              {
                if (MultiplexProducer.Multiplexer.this.mConsumerContextPairs.isEmpty())
                {
                  BaseProducerContext localBaseProducerContext2 = MultiplexProducer.Multiplexer.this.mMultiplexProducerContext;
                  localObject4 = null;
                  localBaseProducerContext1 = localBaseProducerContext2;
                  localObject3 = null;
                  BaseProducerContext.callOnIsPrefetchChanged((List)localObject4);
                  BaseProducerContext.callOnPriorityChanged((List)localObject3);
                  BaseProducerContext.callOnIsIntermediateResultExpectedChanged((List)localObject1);
                  if (localBaseProducerContext1 != null)
                    localBaseProducerContext1.cancel();
                  if (bool)
                    ((Consumer)paramPair.first).onCancellation();
                  return;
                }
                List localList1 = MultiplexProducer.Multiplexer.this.updateIsPrefetch();
                List localList2 = MultiplexProducer.Multiplexer.this.updatePriority();
                List localList3 = MultiplexProducer.Multiplexer.this.updateIsIntermediateResultExpected();
                localObject3 = localList2;
                localObject4 = localList1;
                localObject1 = localList3;
                localBaseProducerContext1 = null;
              }
            }
            localObject1 = null;
            Object localObject3 = null;
            Object localObject4 = null;
            BaseProducerContext localBaseProducerContext1 = null;
          }
        }

        public void onIsIntermediateResultExpectedChanged()
        {
          BaseProducerContext.callOnIsIntermediateResultExpectedChanged(MultiplexProducer.Multiplexer.this.updateIsIntermediateResultExpected());
        }

        public void onIsPrefetchChanged()
        {
          BaseProducerContext.callOnIsPrefetchChanged(MultiplexProducer.Multiplexer.this.updateIsPrefetch());
        }

        public void onPriorityChanged()
        {
          BaseProducerContext.callOnPriorityChanged(MultiplexProducer.Multiplexer.this.updatePriority());
        }
      });
    }

    private void closeSafely(Closeable paramCloseable)
    {
      if (paramCloseable != null);
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException(localIOException);
      }
    }

    private boolean computeIsIntermediateResultExpected()
    {
      try
      {
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        boolean bool2;
        do
        {
          if (!localIterator.hasNext())
            break;
          bool2 = ((ProducerContext)((Pair)localIterator.next()).second).isIntermediateResultExpected();
        }
        while (!bool2);
        for (boolean bool1 = true; ; bool1 = false)
          return bool1;
      }
      finally
      {
      }
    }

    private boolean computeIsPrefetch()
    {
      try
      {
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        boolean bool2;
        do
        {
          if (!localIterator.hasNext())
            break;
          bool2 = ((ProducerContext)((Pair)localIterator.next()).second).isPrefetch();
        }
        while (bool2);
        for (boolean bool1 = false; ; bool1 = true)
          return bool1;
      }
      finally
      {
      }
    }

    private Priority computePriority()
    {
      try
      {
        Priority localPriority1 = Priority.LOW;
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        Priority localPriority2;
        for (Object localObject2 = localPriority1; localIterator.hasNext(); localObject2 = localPriority2)
          localPriority2 = Priority.getHigherPriority((Priority)localObject2, ((ProducerContext)((Pair)localIterator.next()).second).getPriority());
        return localObject2;
      }
      finally
      {
      }
    }

    private void startInputProducerIfHasAttachedConsumers()
    {
      boolean bool1 = true;
      while (true)
      {
        try
        {
          if (this.mMultiplexProducerContext == null)
          {
            bool2 = bool1;
            Preconditions.checkArgument(bool2);
            if (this.mForwardingConsumer != null)
              break label188;
            Preconditions.checkArgument(bool1);
            if (this.mConsumerContextPairs.isEmpty())
            {
              MultiplexProducer.this.removeMultiplexer(this.mKey, this);
              return;
            }
            ProducerContext localProducerContext = (ProducerContext)((Pair)this.mConsumerContextPairs.iterator().next()).second;
            this.mMultiplexProducerContext = new BaseProducerContext(localProducerContext.getImageRequest(), localProducerContext.getId(), localProducerContext.getListener(), localProducerContext.getCallerContext(), localProducerContext.getLowestPermittedRequestLevel(), computeIsPrefetch(), computeIsIntermediateResultExpected(), computePriority());
            this.mForwardingConsumer = new ForwardingConsumer(null);
            BaseProducerContext localBaseProducerContext = this.mMultiplexProducerContext;
            ForwardingConsumer localForwardingConsumer = this.mForwardingConsumer;
            MultiplexProducer.this.mInputProducer.produceResults(localForwardingConsumer, localBaseProducerContext);
            return;
          }
        }
        finally
        {
        }
        boolean bool2 = false;
        continue;
        label188: bool1 = false;
      }
    }

    @Nullable
    private List<ProducerContextCallbacks> updateIsIntermediateResultExpected()
    {
      try
      {
        BaseProducerContext localBaseProducerContext = this.mMultiplexProducerContext;
        if (localBaseProducerContext == null);
        List localList;
        for (Object localObject2 = null; ; localObject2 = localList)
        {
          return localObject2;
          localList = this.mMultiplexProducerContext.setIsIntermediateResultExpectedNoCallbacks(computeIsIntermediateResultExpected());
        }
      }
      finally
      {
      }
    }

    @Nullable
    private List<ProducerContextCallbacks> updateIsPrefetch()
    {
      try
      {
        BaseProducerContext localBaseProducerContext = this.mMultiplexProducerContext;
        if (localBaseProducerContext == null);
        List localList;
        for (Object localObject2 = null; ; localObject2 = localList)
        {
          return localObject2;
          localList = this.mMultiplexProducerContext.setIsPrefetchNoCallbacks(computeIsPrefetch());
        }
      }
      finally
      {
      }
    }

    @Nullable
    private List<ProducerContextCallbacks> updatePriority()
    {
      try
      {
        BaseProducerContext localBaseProducerContext = this.mMultiplexProducerContext;
        if (localBaseProducerContext == null);
        List localList;
        for (Object localObject2 = null; ; localObject2 = localList)
        {
          return localObject2;
          localList = this.mMultiplexProducerContext.setPriorityNoCallbacks(computePriority());
        }
      }
      finally
      {
      }
    }

    // ERROR //
    public boolean addNewConsumer(Consumer<T> paramConsumer, ProducerContext paramProducerContext)
    {
      // Byte code:
      //   0: aload_1
      //   1: aload_2
      //   2: invokestatic 220	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
      //   5: astore_3
      //   6: aload_0
      //   7: monitorenter
      //   8: aload_0
      //   9: getfield 33	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:this$0	Lcom/facebook/imagepipeline/producers/MultiplexProducer;
      //   12: aload_0
      //   13: getfield 46	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mKey	Ljava/lang/Object;
      //   16: invokestatic 224	com/facebook/imagepipeline/producers/MultiplexProducer:access$100	(Lcom/facebook/imagepipeline/producers/MultiplexProducer;Ljava/lang/Object;)Lcom/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer;
      //   19: aload_0
      //   20: if_acmpeq +7 -> 27
      //   23: aload_0
      //   24: monitorexit
      //   25: iconst_0
      //   26: ireturn
      //   27: aload_0
      //   28: getfield 44	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mConsumerContextPairs	Ljava/util/concurrent/CopyOnWriteArraySet;
      //   31: aload_3
      //   32: invokevirtual 228	java/util/concurrent/CopyOnWriteArraySet:add	(Ljava/lang/Object;)Z
      //   35: pop
      //   36: aload_0
      //   37: invokespecial 63	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:updateIsPrefetch	()Ljava/util/List;
      //   40: astore 6
      //   42: aload_0
      //   43: invokespecial 67	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:updatePriority	()Ljava/util/List;
      //   46: astore 7
      //   48: aload_0
      //   49: invokespecial 71	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:updateIsIntermediateResultExpected	()Ljava/util/List;
      //   52: astore 8
      //   54: aload_0
      //   55: getfield 230	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mLastIntermediateResult	Ljava/io/Closeable;
      //   58: astore 9
      //   60: aload_0
      //   61: getfield 232	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mLastProgress	F
      //   64: fstore 10
      //   66: aload_0
      //   67: getfield 234	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mLastStatus	I
      //   70: istore 11
      //   72: aload_0
      //   73: monitorexit
      //   74: aload 6
      //   76: invokestatic 238	com/facebook/imagepipeline/producers/BaseProducerContext:callOnIsPrefetchChanged	(Ljava/util/List;)V
      //   79: aload 7
      //   81: invokestatic 241	com/facebook/imagepipeline/producers/BaseProducerContext:callOnPriorityChanged	(Ljava/util/List;)V
      //   84: aload 8
      //   86: invokestatic 244	com/facebook/imagepipeline/producers/BaseProducerContext:callOnIsIntermediateResultExpectedChanged	(Ljava/util/List;)V
      //   89: aload_3
      //   90: monitorenter
      //   91: aload_0
      //   92: monitorenter
      //   93: aload 9
      //   95: aload_0
      //   96: getfield 230	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:mLastIntermediateResult	Ljava/io/Closeable;
      //   99: if_acmpeq +61 -> 160
      //   102: aconst_null
      //   103: astore 9
      //   105: aload_0
      //   106: monitorexit
      //   107: aload 9
      //   109: ifnull +34 -> 143
      //   112: fload 10
      //   114: fconst_0
      //   115: fcmpl
      //   116: ifle +11 -> 127
      //   119: aload_1
      //   120: fload 10
      //   122: invokeinterface 250 2 0
      //   127: aload_1
      //   128: aload 9
      //   130: iload 11
      //   132: invokeinterface 254 3 0
      //   137: aload_0
      //   138: aload 9
      //   140: invokespecial 256	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:closeSafely	(Ljava/io/Closeable;)V
      //   143: aload_3
      //   144: monitorexit
      //   145: aload_0
      //   146: aload_3
      //   147: aload_2
      //   148: invokespecial 258	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:addCallbacks	(Landroid/util/Pair;Lcom/facebook/imagepipeline/producers/ProducerContext;)V
      //   151: iconst_1
      //   152: ireturn
      //   153: astore 4
      //   155: aload_0
      //   156: monitorexit
      //   157: aload 4
      //   159: athrow
      //   160: aload 9
      //   162: ifnull -57 -> 105
      //   165: aload_0
      //   166: getfield 33	com/facebook/imagepipeline/producers/MultiplexProducer$Multiplexer:this$0	Lcom/facebook/imagepipeline/producers/MultiplexProducer;
      //   169: aload 9
      //   171: invokevirtual 262	com/facebook/imagepipeline/producers/MultiplexProducer:cloneOrNull	(Ljava/io/Closeable;)Ljava/io/Closeable;
      //   174: astore 9
      //   176: goto -71 -> 105
      //   179: astore 13
      //   181: aload_0
      //   182: monitorexit
      //   183: aload 13
      //   185: athrow
      //   186: astore 12
      //   188: aload_3
      //   189: monitorexit
      //   190: aload 12
      //   192: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   8	25	153	finally
      //   27	74	153	finally
      //   155	157	153	finally
      //   93	102	179	finally
      //   105	107	179	finally
      //   165	176	179	finally
      //   181	183	179	finally
      //   91	93	186	finally
      //   119	127	186	finally
      //   127	143	186	finally
      //   143	145	186	finally
      //   183	186	186	finally
      //   188	190	186	finally
    }

    public void onCancelled(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer paramMultiplexProducer)
    {
      try
      {
        if (this.mForwardingConsumer != paramMultiplexProducer)
          return;
        this.mForwardingConsumer = null;
        this.mMultiplexProducerContext = null;
        closeSafely(this.mLastIntermediateResult);
        this.mLastIntermediateResult = null;
        startInputProducerIfHasAttachedConsumers();
        return;
      }
      finally
      {
      }
    }

    public void onFailure(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer paramMultiplexProducer, Throwable paramThrowable)
    {
      try
      {
        if (this.mForwardingConsumer != paramMultiplexProducer)
          return;
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        this.mConsumerContextPairs.clear();
        MultiplexProducer.this.removeMultiplexer(this.mKey, this);
        closeSafely(this.mLastIntermediateResult);
        this.mLastIntermediateResult = null;
        while (localIterator.hasNext())
          synchronized ((Pair)localIterator.next())
          {
            ((Consumer)???.first).onFailure(paramThrowable);
          }
      }
      finally
      {
      }
    }

    public void onNextResult(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer paramMultiplexProducer, T paramT, int paramInt)
    {
      try
      {
        if (this.mForwardingConsumer != paramMultiplexProducer)
          return;
        closeSafely(this.mLastIntermediateResult);
        this.mLastIntermediateResult = null;
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        if (BaseConsumer.isNotLast(paramInt))
        {
          this.mLastIntermediateResult = MultiplexProducer.this.cloneOrNull(paramT);
          this.mLastStatus = paramInt;
        }
        while (true)
        {
          while (localIterator.hasNext())
            synchronized ((Pair)localIterator.next())
            {
              ((Consumer)???.first).onNewResult(paramT, paramInt);
            }
          this.mConsumerContextPairs.clear();
          MultiplexProducer.this.removeMultiplexer(this.mKey, this);
        }
      }
      finally
      {
      }
    }

    public void onProgressUpdate(MultiplexProducer<K, T>.Multiplexer.ForwardingConsumer paramMultiplexProducer, float paramFloat)
    {
      try
      {
        if (this.mForwardingConsumer != paramMultiplexProducer)
          return;
        this.mLastProgress = paramFloat;
        Iterator localIterator = this.mConsumerContextPairs.iterator();
        while (localIterator.hasNext())
          synchronized ((Pair)localIterator.next())
          {
            ((Consumer)???.first).onProgressUpdate(paramFloat);
          }
      }
      finally
      {
      }
    }

    private class ForwardingConsumer extends BaseConsumer<T>
    {
      private ForwardingConsumer()
      {
      }

      protected void onCancellationImpl()
      {
        MultiplexProducer.Multiplexer.this.onCancelled(this);
      }

      protected void onFailureImpl(Throwable paramThrowable)
      {
        MultiplexProducer.Multiplexer.this.onFailure(this, paramThrowable);
      }

      protected void onNewResultImpl(T paramT, int paramInt)
      {
        MultiplexProducer.Multiplexer.this.onNextResult(this, paramT, paramInt);
      }

      protected void onProgressUpdateImpl(float paramFloat)
      {
        MultiplexProducer.Multiplexer.this.onProgressUpdate(this, paramFloat);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.MultiplexProducer
 * JD-Core Version:    0.6.2
 */
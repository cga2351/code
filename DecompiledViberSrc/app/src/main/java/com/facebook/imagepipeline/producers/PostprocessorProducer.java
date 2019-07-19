package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class PostprocessorProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  public static final String NAME = "PostprocessorProducer";

  @VisibleForTesting
  static final String POSTPROCESSOR = "Postprocessor";
  private final PlatformBitmapFactory mBitmapFactory;
  private final Executor mExecutor;
  private final Producer<CloseableReference<CloseableImage>> mInputProducer;

  public PostprocessorProducer(Producer<CloseableReference<CloseableImage>> paramProducer, PlatformBitmapFactory paramPlatformBitmapFactory, Executor paramExecutor)
  {
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mBitmapFactory = paramPlatformBitmapFactory;
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
  }

  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    ProducerListener localProducerListener = paramProducerContext.getListener();
    Postprocessor localPostprocessor = paramProducerContext.getImageRequest().getPostprocessor();
    PostprocessorConsumer localPostprocessorConsumer = new PostprocessorConsumer(paramConsumer, localProducerListener, paramProducerContext.getId(), localPostprocessor, paramProducerContext);
    if ((localPostprocessor instanceof RepeatedPostprocessor));
    for (Object localObject = new RepeatedPostprocessorConsumer(localPostprocessorConsumer, (RepeatedPostprocessor)localPostprocessor, paramProducerContext, null); ; localObject = new SingleUsePostprocessorConsumer(localPostprocessorConsumer, null))
    {
      this.mInputProducer.produceResults((Consumer)localObject, paramProducerContext);
      return;
    }
  }

  private class PostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>
  {

    @GuardedBy("PostprocessorConsumer.this")
    private boolean mIsClosed;

    @GuardedBy("PostprocessorConsumer.this")
    private boolean mIsDirty = false;

    @GuardedBy("PostprocessorConsumer.this")
    private boolean mIsPostProcessingRunning = false;
    private final ProducerListener mListener;
    private final Postprocessor mPostprocessor;
    private final String mRequestId;

    @Nullable
    @GuardedBy("PostprocessorConsumer.this")
    private CloseableReference<CloseableImage> mSourceImageRef = null;

    @GuardedBy("PostprocessorConsumer.this")
    private int mStatus = 0;

    public PostprocessorConsumer(ProducerListener paramString, String paramPostprocessor, Postprocessor paramProducerContext, ProducerContext arg5)
    {
      super();
      this.mListener = paramPostprocessor;
      this.mRequestId = paramProducerContext;
      Object localObject1;
      this.mPostprocessor = localObject1;
      Object localObject2;
      localObject2.addCallbacks(new BaseProducerContextCallbacks()
      {
        public void onCancellationRequested()
        {
          PostprocessorProducer.PostprocessorConsumer.this.maybeNotifyOnCancellation();
        }
      });
    }

    private void clearRunningAndStartIfDirty()
    {
      try
      {
        this.mIsPostProcessingRunning = false;
        boolean bool = setRunningIfDirtyAndNotRunning();
        if (bool)
          submitPostprocessing();
        return;
      }
      finally
      {
      }
    }

    private boolean close()
    {
      try
      {
        if (this.mIsClosed)
          return false;
        CloseableReference localCloseableReference = this.mSourceImageRef;
        this.mSourceImageRef = null;
        this.mIsClosed = true;
        CloseableReference.closeSafely(localCloseableReference);
        return true;
      }
      finally
      {
      }
    }

    private void doPostprocessing(CloseableReference<CloseableImage> paramCloseableReference, int paramInt)
    {
      Preconditions.checkArgument(CloseableReference.isValid(paramCloseableReference));
      if (!shouldPostprocess((CloseableImage)paramCloseableReference.get()))
      {
        maybeNotifyOnNewResult(paramCloseableReference, paramInt);
        return;
      }
      this.mListener.onProducerStart(this.mRequestId, "PostprocessorProducer");
      Object localObject1 = null;
      try
      {
        CloseableReference localCloseableReference = postprocessInternal((CloseableImage)paramCloseableReference.get());
        localObject1 = localCloseableReference;
        this.mListener.onProducerFinishWithSuccess(this.mRequestId, "PostprocessorProducer", getExtraMap(this.mListener, this.mRequestId, this.mPostprocessor));
        maybeNotifyOnNewResult(localObject1, paramInt);
        return;
      }
      catch (Exception localException)
      {
        this.mListener.onProducerFinishWithFailure(this.mRequestId, "PostprocessorProducer", localException, getExtraMap(this.mListener, this.mRequestId, this.mPostprocessor));
        maybeNotifyOnFailure(localException);
        CloseableReference.closeSafely(null);
        return;
      }
      finally
      {
        CloseableReference.closeSafely(localObject1);
      }
    }

    private Map<String, String> getExtraMap(ProducerListener paramProducerListener, String paramString, Postprocessor paramPostprocessor)
    {
      if (!paramProducerListener.requiresExtraMap(paramString))
        return null;
      return ImmutableMap.of("Postprocessor", paramPostprocessor.getName());
    }

    private boolean isClosed()
    {
      try
      {
        boolean bool = this.mIsClosed;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    private void maybeNotifyOnCancellation()
    {
      if (close())
        getConsumer().onCancellation();
    }

    private void maybeNotifyOnFailure(Throwable paramThrowable)
    {
      if (close())
        getConsumer().onFailure(paramThrowable);
    }

    private void maybeNotifyOnNewResult(CloseableReference<CloseableImage> paramCloseableReference, int paramInt)
    {
      boolean bool = isLast(paramInt);
      if (((!bool) && (!isClosed())) || ((bool) && (close())))
        getConsumer().onNewResult(paramCloseableReference, paramInt);
    }

    private CloseableReference<CloseableImage> postprocessInternal(CloseableImage paramCloseableImage)
    {
      CloseableStaticBitmap localCloseableStaticBitmap = (CloseableStaticBitmap)paramCloseableImage;
      Bitmap localBitmap = localCloseableStaticBitmap.getUnderlyingBitmap();
      CloseableReference localCloseableReference1 = this.mPostprocessor.process(localBitmap, PostprocessorProducer.this.mBitmapFactory);
      int i = localCloseableStaticBitmap.getRotationAngle();
      int j = localCloseableStaticBitmap.getExifOrientation();
      try
      {
        CloseableReference localCloseableReference2 = CloseableReference.of(new CloseableStaticBitmap(localCloseableReference1, paramCloseableImage.getQualityInfo(), i, j));
        return localCloseableReference2;
      }
      finally
      {
        CloseableReference.closeSafely(localCloseableReference1);
      }
    }

    private boolean setRunningIfDirtyAndNotRunning()
    {
      boolean bool = true;
      try
      {
        if ((!this.mIsClosed) && (this.mIsDirty) && (!this.mIsPostProcessingRunning) && (CloseableReference.isValid(this.mSourceImageRef)))
        {
          this.mIsPostProcessingRunning = true;
          return bool;
        }
        bool = false;
      }
      finally
      {
      }
    }

    private boolean shouldPostprocess(CloseableImage paramCloseableImage)
    {
      return paramCloseableImage instanceof CloseableStaticBitmap;
    }

    private void submitPostprocessing()
    {
      PostprocessorProducer.this.mExecutor.execute(new Runnable()
      {
        public void run()
        {
          CloseableReference localCloseableReference;
          int i;
          synchronized (PostprocessorProducer.PostprocessorConsumer.this)
          {
            localCloseableReference = PostprocessorProducer.PostprocessorConsumer.this.mSourceImageRef;
            i = PostprocessorProducer.PostprocessorConsumer.this.mStatus;
            PostprocessorProducer.PostprocessorConsumer.access$302(PostprocessorProducer.PostprocessorConsumer.this, null);
            PostprocessorProducer.PostprocessorConsumer.access$502(PostprocessorProducer.PostprocessorConsumer.this, false);
            if (!CloseableReference.isValid(localCloseableReference));
          }
          try
          {
            PostprocessorProducer.PostprocessorConsumer.this.doPostprocessing(localCloseableReference, i);
            CloseableReference.closeSafely(localCloseableReference);
            PostprocessorProducer.PostprocessorConsumer.this.clearRunningAndStartIfDirty();
            return;
            localObject1 = finally;
            throw localObject1;
          }
          finally
          {
            CloseableReference.closeSafely(localCloseableReference);
          }
        }
      });
    }

    private void updateSourceImageRef(@Nullable CloseableReference<CloseableImage> paramCloseableReference, int paramInt)
    {
      try
      {
        if (this.mIsClosed)
          return;
        CloseableReference localCloseableReference = this.mSourceImageRef;
        this.mSourceImageRef = CloseableReference.cloneOrNull(paramCloseableReference);
        this.mStatus = paramInt;
        this.mIsDirty = true;
        boolean bool = setRunningIfDirtyAndNotRunning();
        CloseableReference.closeSafely(localCloseableReference);
        if (bool)
        {
          submitPostprocessing();
          return;
        }
      }
      finally
      {
      }
    }

    protected void onCancellationImpl()
    {
      maybeNotifyOnCancellation();
    }

    protected void onFailureImpl(Throwable paramThrowable)
    {
      maybeNotifyOnFailure(paramThrowable);
    }

    protected void onNewResultImpl(CloseableReference<CloseableImage> paramCloseableReference, int paramInt)
    {
      if (!CloseableReference.isValid(paramCloseableReference))
      {
        if (isLast(paramInt))
          maybeNotifyOnNewResult(null, paramInt);
        return;
      }
      updateSourceImageRef(paramCloseableReference, paramInt);
    }
  }

  class RepeatedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>
    implements RepeatedPostprocessorRunner
  {

    @GuardedBy("RepeatedPostprocessorConsumer.this")
    private boolean mIsClosed = false;

    @Nullable
    @GuardedBy("RepeatedPostprocessorConsumer.this")
    private CloseableReference<CloseableImage> mSourceImageRef = null;

    private RepeatedPostprocessorConsumer(PostprocessorProducer.PostprocessorConsumer paramRepeatedPostprocessor, RepeatedPostprocessor paramProducerContext, ProducerContext arg4)
    {
      super();
      paramProducerContext.setCallback(this);
      Object localObject;
      localObject.addCallbacks(new BaseProducerContextCallbacks()
      {
        public void onCancellationRequested()
        {
          if (PostprocessorProducer.RepeatedPostprocessorConsumer.this.close())
            PostprocessorProducer.RepeatedPostprocessorConsumer.this.getConsumer().onCancellation();
        }
      });
    }

    private boolean close()
    {
      try
      {
        if (this.mIsClosed)
          return false;
        CloseableReference localCloseableReference = this.mSourceImageRef;
        this.mSourceImageRef = null;
        this.mIsClosed = true;
        CloseableReference.closeSafely(localCloseableReference);
        return true;
      }
      finally
      {
      }
    }

    private void setSourceImageRef(CloseableReference<CloseableImage> paramCloseableReference)
    {
      try
      {
        if (this.mIsClosed)
          return;
        CloseableReference localCloseableReference = this.mSourceImageRef;
        this.mSourceImageRef = CloseableReference.cloneOrNull(paramCloseableReference);
        CloseableReference.closeSafely(localCloseableReference);
        return;
      }
      finally
      {
      }
    }

    // ERROR //
    private void updateInternal()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 27	com/facebook/imagepipeline/producers/PostprocessorProducer$RepeatedPostprocessorConsumer:mIsClosed	Z
      //   6: ifeq +6 -> 12
      //   9: aload_0
      //   10: monitorexit
      //   11: return
      //   12: aload_0
      //   13: getfield 29	com/facebook/imagepipeline/producers/PostprocessorProducer$RepeatedPostprocessorConsumer:mSourceImageRef	Lcom/facebook/common/references/CloseableReference;
      //   16: invokestatic 66	com/facebook/common/references/CloseableReference:cloneOrNull	(Lcom/facebook/common/references/CloseableReference;)Lcom/facebook/common/references/CloseableReference;
      //   19: astore_2
      //   20: aload_0
      //   21: monitorexit
      //   22: aload_0
      //   23: invokevirtual 72	com/facebook/imagepipeline/producers/PostprocessorProducer$RepeatedPostprocessorConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   26: aload_2
      //   27: iconst_0
      //   28: invokeinterface 78 3 0
      //   33: aload_2
      //   34: invokestatic 61	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   37: return
      //   38: astore_1
      //   39: aload_0
      //   40: monitorexit
      //   41: aload_1
      //   42: athrow
      //   43: astore_3
      //   44: aload_2
      //   45: invokestatic 61	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   48: aload_3
      //   49: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   2	11	38	finally
      //   12	22	38	finally
      //   39	41	38	finally
      //   22	33	43	finally
    }

    protected void onCancellationImpl()
    {
      if (close())
        getConsumer().onCancellation();
    }

    protected void onFailureImpl(Throwable paramThrowable)
    {
      if (close())
        getConsumer().onFailure(paramThrowable);
    }

    protected void onNewResultImpl(CloseableReference<CloseableImage> paramCloseableReference, int paramInt)
    {
      if (isNotLast(paramInt))
        return;
      setSourceImageRef(paramCloseableReference);
      updateInternal();
    }

    public void update()
    {
      try
      {
        updateInternal();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }

  class SingleUsePostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>
  {
    private SingleUsePostprocessorConsumer(PostprocessorProducer.PostprocessorConsumer arg2)
    {
      super();
    }

    protected void onNewResultImpl(CloseableReference<CloseableImage> paramCloseableReference, int paramInt)
    {
      if (isNotLast(paramInt))
        return;
      getConsumer().onNewResult(paramCloseableReference, paramInt);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.PostprocessorProducer
 * JD-Core Version:    0.6.2
 */
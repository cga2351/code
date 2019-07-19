package com.facebook.react.modules.image;

import android.net.Uri;
import android.util.SparseArray;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import javax.annotation.Nullable;

@ReactModule(name="ImageLoader")
public class ImageLoaderModule extends ReactContextBaseJavaModule
  implements LifecycleEventListener
{
  private static final String ERROR_GET_SIZE_FAILURE = "E_GET_SIZE_FAILURE";
  private static final String ERROR_INVALID_URI = "E_INVALID_URI";
  private static final String ERROR_PREFETCH_FAILURE = "E_PREFETCH_FAILURE";
  public static final String NAME = "ImageLoader";
  private final Object mCallerContext;
  private final Object mEnqueuedRequestMonitor = new Object();
  private final SparseArray<DataSource<Void>> mEnqueuedRequests = new SparseArray();

  public ImageLoaderModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    this.mCallerContext = this;
  }

  public ImageLoaderModule(ReactApplicationContext paramReactApplicationContext, Object paramObject)
  {
    super(paramReactApplicationContext);
    this.mCallerContext = paramObject;
  }

  private void registerRequest(int paramInt, DataSource<Void> paramDataSource)
  {
    synchronized (this.mEnqueuedRequestMonitor)
    {
      this.mEnqueuedRequests.put(paramInt, paramDataSource);
      return;
    }
  }

  @Nullable
  private DataSource<Void> removeRequest(int paramInt)
  {
    synchronized (this.mEnqueuedRequestMonitor)
    {
      DataSource localDataSource = (DataSource)this.mEnqueuedRequests.get(paramInt);
      this.mEnqueuedRequests.remove(paramInt);
      return localDataSource;
    }
  }

  @ReactMethod
  public void abortRequest(int paramInt)
  {
    DataSource localDataSource = removeRequest(paramInt);
    if (localDataSource != null)
      localDataSource.close();
  }

  public String getName()
  {
    return "ImageLoader";
  }

  @ReactMethod
  public void getSize(String paramString, final Promise paramPromise)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramPromise.reject("E_INVALID_URI", "Cannot get the size of an image for an empty URI");
      return;
    }
    ImageRequest localImageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(paramString)).build();
    Fresco.getImagePipeline().fetchDecodedImage(localImageRequest, this.mCallerContext).subscribe(new BaseDataSubscriber()
    {
      protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> paramAnonymousDataSource)
      {
        paramPromise.reject("E_GET_SIZE_FAILURE", paramAnonymousDataSource.getFailureCause());
      }

      protected void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> paramAnonymousDataSource)
      {
        if (!paramAnonymousDataSource.isFinished())
          return;
        CloseableReference localCloseableReference = (CloseableReference)paramAnonymousDataSource.getResult();
        if (localCloseableReference != null)
          try
          {
            CloseableImage localCloseableImage = (CloseableImage)localCloseableReference.get();
            WritableMap localWritableMap = Arguments.createMap();
            localWritableMap.putInt("width", localCloseableImage.getWidth());
            localWritableMap.putInt("height", localCloseableImage.getHeight());
            paramPromise.resolve(localWritableMap);
            return;
          }
          catch (Exception localException)
          {
            paramPromise.reject("E_GET_SIZE_FAILURE", localException);
            return;
          }
          finally
          {
            CloseableReference.closeSafely(localCloseableReference);
          }
        paramPromise.reject("E_GET_SIZE_FAILURE");
      }
    }
    , CallerThreadExecutor.getInstance());
  }

  public void onHostDestroy()
  {
    while (true)
    {
      int j;
      synchronized (this.mEnqueuedRequestMonitor)
      {
        int i = this.mEnqueuedRequests.size();
        j = 0;
        if (j < i)
        {
          DataSource localDataSource = (DataSource)this.mEnqueuedRequests.valueAt(j);
          if (localDataSource != null)
            localDataSource.close();
        }
        else
        {
          this.mEnqueuedRequests.clear();
          return;
        }
      }
      j++;
    }
  }

  public void onHostPause()
  {
  }

  public void onHostResume()
  {
  }

  @ReactMethod
  public void prefetchImage(String paramString, final int paramInt, final Promise paramPromise)
  {
    if ((paramString == null) || (paramString.isEmpty()))
    {
      paramPromise.reject("E_INVALID_URI", "Cannot prefetch an image for an empty URI");
      return;
    }
    ImageRequest localImageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(paramString)).build();
    DataSource localDataSource = Fresco.getImagePipeline().prefetchToDiskCache(localImageRequest, this.mCallerContext);
    BaseDataSubscriber local2 = new BaseDataSubscriber()
    {
      protected void onFailureImpl(DataSource<Void> paramAnonymousDataSource)
      {
        try
        {
          ImageLoaderModule.this.removeRequest(paramInt);
          paramPromise.reject("E_PREFETCH_FAILURE", paramAnonymousDataSource.getFailureCause());
          return;
        }
        finally
        {
          paramAnonymousDataSource.close();
        }
      }

      protected void onNewResultImpl(DataSource<Void> paramAnonymousDataSource)
      {
        if (!paramAnonymousDataSource.isFinished())
          return;
        try
        {
          ImageLoaderModule.this.removeRequest(paramInt);
          paramPromise.resolve(Boolean.valueOf(true));
          return;
        }
        finally
        {
          paramAnonymousDataSource.close();
        }
      }
    };
    registerRequest(paramInt, localDataSource);
    localDataSource.subscribe(local2, CallerThreadExecutor.getInstance());
  }

  @ReactMethod
  public void queryCache(final ReadableArray paramReadableArray, final Promise paramPromise)
  {
    new GuardedAsyncTask(getReactApplicationContext())
    {
      protected void doInBackgroundGuarded(Void[] paramAnonymousArrayOfVoid)
      {
        WritableMap localWritableMap = Arguments.createMap();
        ImagePipeline localImagePipeline = Fresco.getImagePipeline();
        int i = 0;
        if (i < paramReadableArray.size())
        {
          String str = paramReadableArray.getString(i);
          Uri localUri = Uri.parse(str);
          if (localImagePipeline.isInBitmapMemoryCache(localUri))
            localWritableMap.putString(str, "memory");
          while (true)
          {
            i++;
            break;
            if (localImagePipeline.isInDiskCacheSync(localUri))
              localWritableMap.putString(str, "disk");
          }
        }
        paramPromise.resolve(localWritableMap);
      }
    }
    .executeOnExecutor(GuardedAsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.image.ImageLoaderModule
 * JD-Core Version:    0.6.2
 */
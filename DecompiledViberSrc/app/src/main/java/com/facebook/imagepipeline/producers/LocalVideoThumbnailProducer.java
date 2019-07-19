package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Video.Media;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;

public class LocalVideoThumbnailProducer
  implements Producer<CloseableReference<CloseableImage>>
{

  @VisibleForTesting
  static final String CREATED_THUMBNAIL = "createdThumbnail";
  public static final String PRODUCER_NAME = "VideoThumbnailProducer";
  private final ContentResolver mContentResolver;
  private final Executor mExecutor;

  public LocalVideoThumbnailProducer(Executor paramExecutor, ContentResolver paramContentResolver)
  {
    this.mExecutor = paramExecutor;
    this.mContentResolver = paramContentResolver;
  }

  private static int calculateKind(ImageRequest paramImageRequest)
  {
    if ((paramImageRequest.getPreferredWidth() > 96) || (paramImageRequest.getPreferredHeight() > 96))
      return 1;
    return 3;
  }

  private String getLocalFilePath(ImageRequest paramImageRequest)
  {
    Uri localUri = paramImageRequest.getSourceUri();
    Object localObject1;
    if (UriUtil.isLocalFileUri(localUri))
      localObject1 = paramImageRequest.getSourceFile().getPath();
    boolean bool;
    do
    {
      return localObject1;
      bool = UriUtil.isLocalContentUri(localUri);
      localObject1 = null;
    }
    while (!bool);
    String str1;
    String[] arrayOfString;
    if ((Build.VERSION.SDK_INT >= 19) && ("com.android.providers.media.documents".equals(localUri.getAuthority())))
    {
      String str3 = DocumentsContract.getDocumentId(localUri);
      localUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
      str1 = "_id=?";
      arrayOfString = new String[1];
      arrayOfString[0] = str3.split(":")[1];
    }
    while (true)
    {
      while (true)
      {
        Cursor localCursor = this.mContentResolver.query(localUri, new String[] { "_data" }, str1, arrayOfString, null);
        if (localCursor != null);
        try
        {
          if (localCursor.moveToFirst())
          {
            String str2 = localCursor.getString(localCursor.getColumnIndexOrThrow("_data"));
            localObject1 = str2;
            return localObject1;
          }
          localObject1 = null;
          return null;
        }
        finally
        {
          if (localCursor != null)
            localCursor.close();
        }
      }
      str1 = null;
      arrayOfString = null;
    }
  }

  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    final ProducerListener localProducerListener = paramProducerContext.getListener();
    final String str = paramProducerContext.getId();
    final StatefulProducerRunnable local1 = new StatefulProducerRunnable(paramConsumer, localProducerListener, "VideoThumbnailProducer", str)
    {
      protected void disposeResult(CloseableReference<CloseableImage> paramAnonymousCloseableReference)
      {
        CloseableReference.closeSafely(paramAnonymousCloseableReference);
      }

      protected Map<String, String> getExtraMapOnSuccess(CloseableReference<CloseableImage> paramAnonymousCloseableReference)
      {
        if (paramAnonymousCloseableReference != null);
        for (boolean bool = true; ; bool = false)
          return ImmutableMap.of("createdThumbnail", String.valueOf(bool));
      }

      protected CloseableReference<CloseableImage> getResult()
        throws Exception
      {
        String str = LocalVideoThumbnailProducer.this.getLocalFilePath(this.val$imageRequest);
        if (str == null);
        Bitmap localBitmap;
        do
        {
          return null;
          localBitmap = ThumbnailUtils.createVideoThumbnail(str, LocalVideoThumbnailProducer.calculateKind(this.val$imageRequest));
        }
        while (localBitmap == null);
        return CloseableReference.of(new CloseableStaticBitmap(localBitmap, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0));
      }

      protected void onFailure(Exception paramAnonymousException)
      {
        super.onFailure(paramAnonymousException);
        localProducerListener.onUltimateProducerReached(str, "VideoThumbnailProducer", false);
      }

      protected void onSuccess(CloseableReference<CloseableImage> paramAnonymousCloseableReference)
      {
        super.onSuccess(paramAnonymousCloseableReference);
        ProducerListener localProducerListener = localProducerListener;
        String str = str;
        if (paramAnonymousCloseableReference != null);
        for (boolean bool = true; ; bool = false)
        {
          localProducerListener.onUltimateProducerReached(str, "VideoThumbnailProducer", bool);
          return;
        }
      }
    };
    paramProducerContext.addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        local1.cancel();
      }
    });
    this.mExecutor.execute(local1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer
 * JD-Core Version:    0.6.2
 */
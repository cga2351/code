package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.net.Uri;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

public class QualifiedResourceFetchProducer extends LocalFetchProducer
{
  public static final String PRODUCER_NAME = "QualifiedResourceFetchProducer";
  private final ContentResolver mContentResolver;

  public QualifiedResourceFetchProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, ContentResolver paramContentResolver)
  {
    super(paramExecutor, paramPooledByteBufferFactory);
    this.mContentResolver = paramContentResolver;
  }

  protected EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException
  {
    Uri localUri = paramImageRequest.getSourceUri();
    return getEncodedImage(this.mContentResolver.openInputStream(localUri), -1);
  }

  protected String getProducerName()
  {
    return "QualifiedResourceFetchProducer";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer
 * JD-Core Version:    0.6.2
 */
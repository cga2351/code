package com.facebook.imagepipeline.producers;

import android.content.res.AssetManager;
import android.net.Uri;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

public class LocalAssetFetchProducer extends LocalFetchProducer
{
  public static final String PRODUCER_NAME = "LocalAssetFetchProducer";
  private final AssetManager mAssetManager;

  public LocalAssetFetchProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, AssetManager paramAssetManager)
  {
    super(paramExecutor, paramPooledByteBufferFactory);
    this.mAssetManager = paramAssetManager;
  }

  private static String getAssetName(ImageRequest paramImageRequest)
  {
    return paramImageRequest.getSourceUri().getPath().substring(1);
  }

  // ERROR //
  private int getLength(ImageRequest paramImageRequest)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/facebook/imagepipeline/producers/LocalAssetFetchProducer:mAssetManager	Landroid/content/res/AssetManager;
    //   4: aload_1
    //   5: invokestatic 43	com/facebook/imagepipeline/producers/LocalAssetFetchProducer:getAssetName	(Lcom/facebook/imagepipeline/request/ImageRequest;)Ljava/lang/String;
    //   8: invokevirtual 49	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   11: astore 9
    //   13: aload 9
    //   15: astore_3
    //   16: aload_3
    //   17: invokevirtual 54	android/content/res/AssetFileDescriptor:getLength	()J
    //   20: lstore 11
    //   22: lload 11
    //   24: l2i
    //   25: istore 7
    //   27: aload_3
    //   28: ifnull +7 -> 35
    //   31: aload_3
    //   32: invokevirtual 58	android/content/res/AssetFileDescriptor:close	()V
    //   35: iload 7
    //   37: ireturn
    //   38: astore 6
    //   40: aconst_null
    //   41: astore_3
    //   42: iconst_m1
    //   43: istore 7
    //   45: aload_3
    //   46: ifnull -11 -> 35
    //   49: aload_3
    //   50: invokevirtual 58	android/content/res/AssetFileDescriptor:close	()V
    //   53: iload 7
    //   55: ireturn
    //   56: astore 8
    //   58: iload 7
    //   60: ireturn
    //   61: astore_2
    //   62: aconst_null
    //   63: astore_3
    //   64: aload_2
    //   65: astore 4
    //   67: aload_3
    //   68: ifnull +7 -> 75
    //   71: aload_3
    //   72: invokevirtual 58	android/content/res/AssetFileDescriptor:close	()V
    //   75: aload 4
    //   77: athrow
    //   78: astore 13
    //   80: iload 7
    //   82: ireturn
    //   83: astore 5
    //   85: goto -10 -> 75
    //   88: astore 4
    //   90: goto -23 -> 67
    //   93: astore 10
    //   95: goto -53 -> 42
    //
    // Exception table:
    //   from	to	target	type
    //   0	13	38	java/io/IOException
    //   49	53	56	java/io/IOException
    //   0	13	61	finally
    //   31	35	78	java/io/IOException
    //   71	75	83	java/io/IOException
    //   16	22	88	finally
    //   16	22	93	java/io/IOException
  }

  protected EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException
  {
    return getEncodedImage(this.mAssetManager.open(getAssetName(paramImageRequest), 2), getLength(paramImageRequest));
  }

  protected String getProducerName()
  {
    return "LocalAssetFetchProducer";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.LocalAssetFetchProducer
 * JD-Core Version:    0.6.2
 */
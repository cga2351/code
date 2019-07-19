package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.PoolFactory;

public class HoneycombBitmapCreator
  implements BitmapCreator
{
  private final FlexByteArrayPool mFlexByteArrayPool;
  private final EmptyJpegGenerator mJpegGenerator;

  public HoneycombBitmapCreator(PoolFactory paramPoolFactory)
  {
    this.mFlexByteArrayPool = paramPoolFactory.getFlexByteArrayPool();
    this.mJpegGenerator = new EmptyJpegGenerator(paramPoolFactory.getPooledByteBufferFactory());
  }

  private static BitmapFactory.Options getBitmapFactoryOptions(int paramInt, Bitmap.Config paramConfig)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDither = true;
    localOptions.inPreferredConfig = paramConfig;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    localOptions.inSampleSize = paramInt;
    if (Build.VERSION.SDK_INT >= 11)
      localOptions.inMutable = true;
    return localOptions;
  }

  // ERROR //
  @android.annotation.TargetApi(12)
  public android.graphics.Bitmap createNakedBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: getfield 34	com/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator:mJpegGenerator	Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;
    //   7: iload_1
    //   8: i2s
    //   9: iload_2
    //   10: i2s
    //   11: invokevirtual 74	com/facebook/imagepipeline/bitmaps/EmptyJpegGenerator:generate	(SS)Lcom/facebook/common/references/CloseableReference;
    //   14: astore 5
    //   16: new 76	com/facebook/imagepipeline/image/EncodedImage
    //   19: dup
    //   20: aload 5
    //   22: invokespecial 79	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
    //   25: astore 6
    //   27: aload 6
    //   29: getstatic 85	com/facebook/imageformat/DefaultImageFormats:JPEG	Lcom/facebook/imageformat/ImageFormat;
    //   32: invokevirtual 89	com/facebook/imagepipeline/image/EncodedImage:setImageFormat	(Lcom/facebook/imageformat/ImageFormat;)V
    //   35: aload 6
    //   37: invokevirtual 93	com/facebook/imagepipeline/image/EncodedImage:getSampleSize	()I
    //   40: aload_3
    //   41: invokestatic 95	com/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator:getBitmapFactoryOptions	(ILandroid/graphics/Bitmap$Config;)Landroid/graphics/BitmapFactory$Options;
    //   44: astore 9
    //   46: aload 5
    //   48: invokevirtual 101	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   51: checkcast 103	com/facebook/common/memory/PooledByteBuffer
    //   54: invokeinterface 106 1 0
    //   59: istore 10
    //   61: aload 5
    //   63: invokevirtual 101	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   66: checkcast 103	com/facebook/common/memory/PooledByteBuffer
    //   69: astore 11
    //   71: aload_0
    //   72: getfield 23	com/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator:mFlexByteArrayPool	Lcom/facebook/imagepipeline/memory/FlexByteArrayPool;
    //   75: iload 10
    //   77: iconst_2
    //   78: iadd
    //   79: invokevirtual 111	com/facebook/imagepipeline/memory/FlexByteArrayPool:get	(I)Lcom/facebook/common/references/CloseableReference;
    //   82: astore 12
    //   84: aload 12
    //   86: invokevirtual 101	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   89: checkcast 113	[B
    //   92: astore 13
    //   94: aload 11
    //   96: iconst_0
    //   97: aload 13
    //   99: iconst_0
    //   100: iload 10
    //   102: invokeinterface 117 5 0
    //   107: pop
    //   108: aload 13
    //   110: iconst_0
    //   111: iload 10
    //   113: aload 9
    //   115: invokestatic 123	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   118: astore 15
    //   120: aload 15
    //   122: iconst_1
    //   123: invokevirtual 129	android/graphics/Bitmap:setHasAlpha	(Z)V
    //   126: aload 15
    //   128: iconst_0
    //   129: invokevirtual 133	android/graphics/Bitmap:eraseColor	(I)V
    //   132: aload 12
    //   134: invokestatic 136	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   137: aload 6
    //   139: invokestatic 139	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   142: aload 5
    //   144: invokestatic 136	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   147: aload 15
    //   149: areturn
    //   150: astore 7
    //   152: aconst_null
    //   153: astore 8
    //   155: aload 4
    //   157: invokestatic 136	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   160: aload 8
    //   162: invokestatic 139	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   165: aload 5
    //   167: invokestatic 136	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   170: aload 7
    //   172: athrow
    //   173: astore 7
    //   175: aload 6
    //   177: astore 8
    //   179: aconst_null
    //   180: astore 4
    //   182: goto -27 -> 155
    //   185: astore 7
    //   187: aload 12
    //   189: astore 4
    //   191: aload 6
    //   193: astore 8
    //   195: goto -40 -> 155
    //
    // Exception table:
    //   from	to	target	type
    //   16	27	150	finally
    //   27	84	173	finally
    //   84	132	185	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.bitmaps.HoneycombBitmapCreator
 * JD-Core Version:    0.6.2
 */
package com.facebook.react.views.image;

import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MultiPostprocessor
  implements Postprocessor
{
  private final List<Postprocessor> mPostprocessors;

  private MultiPostprocessor(List<Postprocessor> paramList)
  {
    this.mPostprocessors = new LinkedList(paramList);
  }

  public static Postprocessor from(List<Postprocessor> paramList)
  {
    switch (paramList.size())
    {
    default:
      return new MultiPostprocessor(paramList);
    case 0:
      return null;
    case 1:
    }
    return (Postprocessor)paramList.get(0);
  }

  public String getName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.mPostprocessors.iterator();
    while (localIterator.hasNext())
    {
      Postprocessor localPostprocessor = (Postprocessor)localIterator.next();
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(",");
      localStringBuilder.append(localPostprocessor.getName());
    }
    localStringBuilder.insert(0, "MultiPostProcessor (");
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }

  public CacheKey getPostprocessorCacheKey()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.mPostprocessors.iterator();
    while (localIterator.hasNext())
      localLinkedList.push(((Postprocessor)localIterator.next()).getPostprocessorCacheKey());
    return new MultiCacheKey(localLinkedList);
  }

  // ERROR //
  public com.facebook.common.references.CloseableReference<android.graphics.Bitmap> process(android.graphics.Bitmap paramBitmap, com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory paramPlatformBitmapFactory)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 21	com/facebook/react/views/image/MultiPostprocessor:mPostprocessors	Ljava/util/List;
    //   6: invokeinterface 44 1 0
    //   11: astore 5
    //   13: aconst_null
    //   14: astore 6
    //   16: aconst_null
    //   17: astore 7
    //   19: aload 5
    //   21: invokeinterface 50 1 0
    //   26: ifeq +72 -> 98
    //   29: aload 5
    //   31: invokeinterface 54 1 0
    //   36: checkcast 6	com/facebook/imagepipeline/request/Postprocessor
    //   39: astore 9
    //   41: aload 7
    //   43: ifnull +49 -> 92
    //   46: aload 7
    //   48: invokevirtual 94	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   51: checkcast 96	android/graphics/Bitmap
    //   54: astore 10
    //   56: aload 9
    //   58: aload 10
    //   60: aload_2
    //   61: invokeinterface 98 3 0
    //   66: astore 11
    //   68: aload 11
    //   70: astore_3
    //   71: aload 7
    //   73: invokestatic 102	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   76: aload_3
    //   77: invokevirtual 106	com/facebook/common/references/CloseableReference:clone	()Lcom/facebook/common/references/CloseableReference;
    //   80: astore 12
    //   82: aload_3
    //   83: astore 6
    //   85: aload 12
    //   87: astore 7
    //   89: goto -70 -> 19
    //   92: aload_1
    //   93: astore 10
    //   95: goto -39 -> 56
    //   98: aload 6
    //   100: invokevirtual 106	com/facebook/common/references/CloseableReference:clone	()Lcom/facebook/common/references/CloseableReference;
    //   103: astore 8
    //   105: aload 6
    //   107: invokestatic 102	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   110: aload 8
    //   112: areturn
    //   113: astore 4
    //   115: aload_3
    //   116: invokestatic 102	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   119: aload 4
    //   121: athrow
    //   122: astore 4
    //   124: aload 6
    //   126: astore_3
    //   127: goto -12 -> 115
    //
    // Exception table:
    //   from	to	target	type
    //   2	13	113	finally
    //   71	82	113	finally
    //   19	41	122	finally
    //   46	56	122	finally
    //   56	68	122	finally
    //   98	105	122	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.image.MultiPostprocessor
 * JD-Core Version:    0.6.2
 */
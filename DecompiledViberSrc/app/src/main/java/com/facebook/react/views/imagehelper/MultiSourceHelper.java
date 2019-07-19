package com.facebook.react.views.imagehelper;

import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class MultiSourceHelper
{
  public static MultiSourceResult getBestSourceForSize(int paramInt1, int paramInt2, List<ImageSource> paramList)
  {
    return getBestSourceForSize(paramInt1, paramInt2, paramList, 1.0D);
  }

  public static MultiSourceResult getBestSourceForSize(int paramInt1, int paramInt2, List<ImageSource> paramList, double paramDouble)
  {
    if (paramList.isEmpty())
      return new MultiSourceResult(null, null, null);
    if (paramList.size() == 1)
      return new MultiSourceResult((ImageSource)paramList.get(0), null, null);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
      return new MultiSourceResult(null, null, null);
    ImagePipeline localImagePipeline = ImagePipelineFactory.getInstance().getImagePipeline();
    double d1 = paramDouble * (paramInt1 * paramInt2);
    double d2 = 1.7976931348623157E+308D;
    Iterator localIterator = paramList.iterator();
    double d3 = 1.7976931348623157E+308D;
    Object localObject1 = null;
    Object localObject2 = null;
    double d4;
    Object localObject3;
    if (localIterator.hasNext())
    {
      ImageSource localImageSource = (ImageSource)localIterator.next();
      d4 = Math.abs(1.0D - localImageSource.getSize() / d1);
      if (d4 < d3)
      {
        d3 = d4;
        localObject1 = localImageSource;
      }
      if ((d4 >= d2) || ((!localImagePipeline.isInBitmapMemoryCache(localImageSource.getUri())) && (!localImagePipeline.isInDiskCacheSync(localImageSource.getUri()))))
        break label261;
      localObject3 = localImageSource;
    }
    label261: double d5;
    for (double d6 = d4; ; d6 = d5)
    {
      double d7 = d6;
      localObject2 = localObject3;
      d2 = d7;
      break;
      if ((localObject2 != null) && (localObject1 != null) && (localObject2.getSource().equals(localObject1.getSource())))
        localObject2 = null;
      return new MultiSourceResult(localObject1, localObject2, null);
      d5 = d2;
      localObject3 = localObject2;
    }
  }

  public static class MultiSourceResult
  {

    @Nullable
    private final ImageSource bestResult;

    @Nullable
    private final ImageSource bestResultInCache;

    private MultiSourceResult(@Nullable ImageSource paramImageSource1, @Nullable ImageSource paramImageSource2)
    {
      this.bestResult = paramImageSource1;
      this.bestResultInCache = paramImageSource2;
    }

    @Nullable
    public ImageSource getBestResult()
    {
      return this.bestResult;
    }

    @Nullable
    public ImageSource getBestResultInCache()
    {
      return this.bestResultInCache;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.imagehelper.MultiSourceHelper
 * JD-Core Version:    0.6.2
 */
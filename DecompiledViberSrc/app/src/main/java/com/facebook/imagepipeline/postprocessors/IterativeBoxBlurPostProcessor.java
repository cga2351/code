package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import java.util.Locale;
import javax.annotation.Nullable;

public class IterativeBoxBlurPostProcessor extends BasePostprocessor
{
  private static final int DEFAULT_ITERATIONS = 3;
  private final int mBlurRadius;
  private CacheKey mCacheKey;
  private final int mIterations;

  public IterativeBoxBlurPostProcessor(int paramInt)
  {
    this(3, paramInt);
  }

  public IterativeBoxBlurPostProcessor(int paramInt1, int paramInt2)
  {
    boolean bool2;
    if (paramInt1 > 0)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (paramInt2 <= 0)
        break label43;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      this.mIterations = paramInt1;
      this.mBlurRadius = paramInt2;
      return;
      bool2 = false;
      break;
      label43: bool1 = false;
    }
  }

  @Nullable
  public CacheKey getPostprocessorCacheKey()
  {
    if (this.mCacheKey == null)
    {
      Locale localLocale = (Locale)null;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(this.mIterations);
      arrayOfObject[1] = Integer.valueOf(this.mBlurRadius);
      this.mCacheKey = new SimpleCacheKey(String.format(localLocale, "i%dr%d", arrayOfObject));
    }
    return this.mCacheKey;
  }

  public void process(Bitmap paramBitmap)
  {
    NativeBlurFilter.iterativeBoxBlur(paramBitmap, this.mIterations, this.mBlurRadius);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor
 * JD-Core Version:    0.6.2
 */
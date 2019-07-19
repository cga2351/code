package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.nativecode.NativeRoundingFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;

public class RoundAsCirclePostprocessor extends BasePostprocessor
{

  @Nullable
  private CacheKey mCacheKey;

  @Nullable
  public CacheKey getPostprocessorCacheKey()
  {
    if (this.mCacheKey == null)
      this.mCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor");
    return this.mCacheKey;
  }

  public void process(Bitmap paramBitmap)
  {
    NativeRoundingFilter.toCircle(paramBitmap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.postprocessors.RoundAsCirclePostprocessor
 * JD-Core Version:    0.6.2
 */
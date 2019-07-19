package com.facebook.imagepipeline.animated.factory;

import android.content.Context;
import android.graphics.Bitmap.Config;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public abstract interface AnimatedFactory
{
  @Nullable
  public abstract DrawableFactory getAnimatedDrawableFactory(Context paramContext);

  @Nullable
  public abstract ImageDecoder getGifDecoder(Bitmap.Config paramConfig);

  @Nullable
  public abstract ImageDecoder getWebPDecoder(Bitmap.Config paramConfig);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.animated.factory.AnimatedFactory
 * JD-Core Version:    0.6.2
 */
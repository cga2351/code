package com.facebook.drawee.backends.pipeline.info;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ImageOrigin
{
  public static final int DISK = 1;
  public static final int MEMORY_BITMAP = 3;
  public static final int MEMORY_ENCODED = 2;
  public static final int NETWORK = 0;
  public static final int UNKNOWN = -1;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.info.ImageOrigin
 * JD-Core Version:    0.6.2
 */
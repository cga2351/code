package com.facebook.imagepipeline.producers;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract interface Consumer<T>
{
  public static final int DO_NOT_CACHE_ENCODED = 2;
  public static final int IS_LAST = 1;
  public static final int IS_PARTIAL_RESULT = 8;
  public static final int IS_PLACEHOLDER = 4;
  public static final int IS_RESIZING_DONE = 16;
  public static final int NO_FLAGS;

  public abstract void onCancellation();

  public abstract void onFailure(Throwable paramThrowable);

  public abstract void onNewResult(T paramT, int paramInt);

  public abstract void onProgressUpdate(float paramFloat);

  @Retention(RetentionPolicy.SOURCE)
  public static @interface Status
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.producers.Consumer
 * JD-Core Version:    0.6.2
 */
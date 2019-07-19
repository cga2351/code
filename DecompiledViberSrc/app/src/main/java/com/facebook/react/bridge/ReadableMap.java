package com.facebook.react.bridge;

import java.util.HashMap;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract interface ReadableMap
{
  @Nullable
  public abstract ReadableArray getArray(@Nonnull String paramString);

  public abstract boolean getBoolean(@Nonnull String paramString);

  public abstract double getDouble(@Nonnull String paramString);

  @Nonnull
  public abstract Dynamic getDynamic(@Nonnull String paramString);

  public abstract int getInt(@Nonnull String paramString);

  @Nullable
  public abstract ReadableMap getMap(@Nonnull String paramString);

  @Nullable
  public abstract String getString(@Nonnull String paramString);

  @Nonnull
  public abstract ReadableType getType(@Nonnull String paramString);

  public abstract boolean hasKey(@Nonnull String paramString);

  public abstract boolean isNull(@Nonnull String paramString);

  @Nonnull
  public abstract ReadableMapKeySetIterator keySetIterator();

  @Nonnull
  public abstract HashMap<String, Object> toHashMap();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReadableMap
 * JD-Core Version:    0.6.2
 */
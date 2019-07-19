package com.facebook.react.bridge;

import java.util.ArrayList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract interface ReadableArray
{
  @Nullable
  public abstract ReadableArray getArray(int paramInt);

  public abstract boolean getBoolean(int paramInt);

  public abstract double getDouble(int paramInt);

  @Nonnull
  public abstract Dynamic getDynamic(int paramInt);

  public abstract int getInt(int paramInt);

  @Nullable
  public abstract ReadableMap getMap(int paramInt);

  @Nullable
  public abstract String getString(int paramInt);

  @Nonnull
  public abstract ReadableType getType(int paramInt);

  public abstract boolean isNull(int paramInt);

  public abstract int size();

  @Nonnull
  public abstract ArrayList<Object> toArrayList();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReadableArray
 * JD-Core Version:    0.6.2
 */
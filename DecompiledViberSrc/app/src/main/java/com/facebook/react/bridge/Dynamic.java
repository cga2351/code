package com.facebook.react.bridge;

public abstract interface Dynamic
{
  public abstract ReadableArray asArray();

  public abstract boolean asBoolean();

  public abstract double asDouble();

  public abstract int asInt();

  public abstract ReadableMap asMap();

  public abstract String asString();

  public abstract ReadableType getType();

  public abstract boolean isNull();

  public abstract void recycle();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.Dynamic
 * JD-Core Version:    0.6.2
 */
package com.facebook.react.packagerconnection;

import javax.annotation.Nullable;

public abstract interface RequestHandler
{
  public abstract void onNotification(@Nullable Object paramObject);

  public abstract void onRequest(@Nullable Object paramObject, Responder paramResponder);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.packagerconnection.RequestHandler
 * JD-Core Version:    0.6.2
 */
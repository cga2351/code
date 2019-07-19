package com.facebook.react.modules.network;

import okhttp3.Interceptor;

public abstract interface NetworkInterceptorCreator
{
  public abstract Interceptor create();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.NetworkInterceptorCreator
 * JD-Core Version:    0.6.2
 */
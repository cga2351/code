package com.viber.jni.connection;

public abstract interface ConnectionDelegate
{
  public abstract void onConnect();

  public abstract void onConnectionStateChange(int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.connection.ConnectionDelegate
 * JD-Core Version:    0.6.2
 */
package org.webrtc;

public abstract interface RefCounted
{
  public abstract void release();

  public abstract void retain();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.RefCounted
 * JD-Core Version:    0.6.2
 */
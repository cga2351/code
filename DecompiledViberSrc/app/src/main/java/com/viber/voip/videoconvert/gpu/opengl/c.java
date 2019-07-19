package com.viber.voip.videoconvert.gpu.opengl;

import java.nio.ByteBuffer;

public abstract interface c
{
  public abstract void doneCurrent();

  public abstract int getDataType();

  public abstract String getExtensions();

  public abstract int getPixelFormat();

  public abstract String getRenderer();

  public abstract String getVendor();

  public abstract void init();

  public abstract boolean isExtensionSupported(String paramString);

  public abstract void makeCurrent();

  public abstract void optimize();

  public abstract void readPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, ByteBuffer paramByteBuffer);

  public abstract void release(boolean paramBoolean);

  public abstract boolean swapBuffers();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.opengl.c
 * JD-Core Version:    0.6.2
 */
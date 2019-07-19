package org.webrtc;

import android.opengl.GLES20;

public class GlTextureFrameBuffer
{
  private int frameBufferId;
  private int height;
  private final int pixelFormat;
  private int textureId;
  private int width;

  public GlTextureFrameBuffer(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Invalid pixel format: " + paramInt);
    case 6407:
    case 6408:
    case 6409:
    }
    this.pixelFormat = paramInt;
    this.width = 0;
    this.height = 0;
  }

  public int getFrameBufferId()
  {
    return this.frameBufferId;
  }

  public int getHeight()
  {
    return this.height;
  }

  public int getTextureId()
  {
    return this.textureId;
  }

  public int getWidth()
  {
    return this.width;
  }

  public void release()
  {
    int[] arrayOfInt1 = new int[1];
    arrayOfInt1[0] = this.textureId;
    GLES20.glDeleteTextures(1, arrayOfInt1, 0);
    this.textureId = 0;
    int[] arrayOfInt2 = new int[1];
    arrayOfInt2[0] = this.frameBufferId;
    GLES20.glDeleteFramebuffers(1, arrayOfInt2, 0);
    this.frameBufferId = 0;
    this.width = 0;
    this.height = 0;
  }

  public void setSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
      throw new IllegalArgumentException("Invalid size: " + paramInt1 + "x" + paramInt2);
    if ((paramInt1 == this.width) && (paramInt2 == this.height))
      return;
    this.width = paramInt1;
    this.height = paramInt2;
    if (this.textureId == 0)
      this.textureId = GlUtil.generateTexture(3553);
    if (this.frameBufferId == 0)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      this.frameBufferId = arrayOfInt[0];
    }
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.textureId);
    GLES20.glTexImage2D(3553, 0, this.pixelFormat, paramInt1, paramInt2, 0, this.pixelFormat, 5121, null);
    GLES20.glBindTexture(3553, 0);
    GlUtil.checkNoGLES2Error("GlTextureFrameBuffer setSize");
    GLES20.glBindFramebuffer(36160, this.frameBufferId);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.textureId, 0);
    int i = GLES20.glCheckFramebufferStatus(36160);
    if (i != 36053)
      throw new IllegalStateException("Framebuffer not complete, status: " + i);
    GLES20.glBindFramebuffer(36160, 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.GlTextureFrameBuffer
 * JD-Core Version:    0.6.2
 */
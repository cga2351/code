package org.webrtc;

import android.graphics.Matrix;
import android.os.Handler;
import javax.annotation.Nullable;

public class TextureBufferImpl
  implements VideoFrame.TextureBuffer
{
  private final int height;
  private final int id;
  private final RefCountDelegate refCountDelegate;
  private final Handler toI420Handler;
  private final Matrix transformMatrix;
  private final VideoFrame.TextureBuffer.Type type;
  private final int width;
  private final YuvConverter yuvConverter;

  public TextureBufferImpl(int paramInt1, int paramInt2, VideoFrame.TextureBuffer.Type paramType, int paramInt3, Matrix paramMatrix, Handler paramHandler, YuvConverter paramYuvConverter, @Nullable Runnable paramRunnable)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.type = paramType;
    this.id = paramInt3;
    this.transformMatrix = paramMatrix;
    this.toI420Handler = paramHandler;
    this.yuvConverter = paramYuvConverter;
    this.refCountDelegate = new RefCountDelegate(paramRunnable);
  }

  public TextureBufferImpl applyTransformMatrix(Matrix paramMatrix, int paramInt1, int paramInt2)
  {
    Matrix localMatrix = new Matrix(this.transformMatrix);
    localMatrix.preConcat(paramMatrix);
    retain();
    return new TextureBufferImpl(paramInt1, paramInt2, this.type, this.id, localMatrix, this.toI420Handler, this.yuvConverter, new TextureBufferImpl..Lambda.1(this));
  }

  public VideoFrame.Buffer cropAndScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Matrix localMatrix = new Matrix();
    int i = this.height - (paramInt2 + paramInt4);
    localMatrix.preTranslate(paramInt1 / this.width, i / this.height);
    localMatrix.preScale(paramInt3 / this.width, paramInt4 / this.height);
    return applyTransformMatrix(localMatrix, paramInt5, paramInt6);
  }

  public int getHeight()
  {
    return this.height;
  }

  public int getTextureId()
  {
    return this.id;
  }

  public Matrix getTransformMatrix()
  {
    return this.transformMatrix;
  }

  public VideoFrame.TextureBuffer.Type getType()
  {
    return this.type;
  }

  public int getWidth()
  {
    return this.width;
  }

  public void release()
  {
    this.refCountDelegate.release();
  }

  public void retain()
  {
    this.refCountDelegate.retain();
  }

  public VideoFrame.I420Buffer toI420()
  {
    return (VideoFrame.I420Buffer)ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new TextureBufferImpl..Lambda.0(this));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.TextureBufferImpl
 * JD-Core Version:    0.6.2
 */
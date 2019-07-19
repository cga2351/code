package org.webrtc;

import android.graphics.Matrix;
import android.graphics.Point;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public class VideoFrameDrawer
{
  static final float[] srcPoints = { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F };
  private final float[] dstPoints = new float[6];

  @Nullable
  private VideoFrame lastI420Frame;
  private int renderHeight;
  private final Matrix renderMatrix = new Matrix();
  private final Point renderSize = new Point();
  private int renderWidth;
  private final YuvUploader yuvUploader = new YuvUploader(null);

  private void calculateTransformedRenderSize(int paramInt1, int paramInt2, @Nullable Matrix paramMatrix)
  {
    if (paramMatrix == null)
    {
      this.renderWidth = paramInt1;
      this.renderHeight = paramInt2;
      return;
    }
    paramMatrix.mapPoints(this.dstPoints, srcPoints);
    for (int i = 0; i < 3; i++)
    {
      float[] arrayOfFloat1 = this.dstPoints;
      int j = 0 + i * 2;
      arrayOfFloat1[j] *= paramInt1;
      float[] arrayOfFloat2 = this.dstPoints;
      int k = 1 + i * 2;
      arrayOfFloat2[k] *= paramInt2;
    }
    this.renderWidth = distance(this.dstPoints[0], this.dstPoints[1], this.dstPoints[2], this.dstPoints[3]);
    this.renderHeight = distance(this.dstPoints[0], this.dstPoints[1], this.dstPoints[4], this.dstPoints[5]);
  }

  private static int distance(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (int)Math.round(Math.hypot(paramFloat3 - paramFloat1, paramFloat4 - paramFloat2));
  }

  static void drawTexture(RendererCommon.GlDrawer paramGlDrawer, VideoFrame.TextureBuffer paramTextureBuffer, Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Matrix localMatrix = new Matrix(paramTextureBuffer.getTransformMatrix());
    localMatrix.preConcat(paramMatrix);
    float[] arrayOfFloat = RendererCommon.convertMatrixFromAndroidGraphicsMatrix(localMatrix);
    switch (1.$SwitchMap$org$webrtc$VideoFrame$TextureBuffer$Type[paramTextureBuffer.getType().ordinal()])
    {
    default:
      throw new RuntimeException("Unknown texture type.");
    case 1:
      paramGlDrawer.drawOes(paramTextureBuffer.getTextureId(), arrayOfFloat, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
      return;
    case 2:
    }
    paramGlDrawer.drawRgb(paramTextureBuffer.getTextureId(), arrayOfFloat, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }

  public void drawFrame(VideoFrame paramVideoFrame, RendererCommon.GlDrawer paramGlDrawer)
  {
    drawFrame(paramVideoFrame, paramGlDrawer, null);
  }

  public void drawFrame(VideoFrame paramVideoFrame, RendererCommon.GlDrawer paramGlDrawer, Matrix paramMatrix)
  {
    drawFrame(paramVideoFrame, paramGlDrawer, paramMatrix, 0, 0, paramVideoFrame.getRotatedWidth(), paramVideoFrame.getRotatedHeight());
  }

  public void drawFrame(VideoFrame paramVideoFrame, RendererCommon.GlDrawer paramGlDrawer, @Nullable Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    calculateTransformedRenderSize(paramVideoFrame.getRotatedWidth(), paramVideoFrame.getRotatedHeight(), paramMatrix);
    boolean bool = paramVideoFrame.getBuffer() instanceof VideoFrame.TextureBuffer;
    this.renderMatrix.reset();
    this.renderMatrix.preTranslate(0.5F, 0.5F);
    if (!bool)
      this.renderMatrix.preScale(1.0F, -1.0F);
    this.renderMatrix.preRotate(paramVideoFrame.getRotation());
    this.renderMatrix.preTranslate(-0.5F, -0.5F);
    if (paramMatrix != null)
      this.renderMatrix.preConcat(paramMatrix);
    if (bool)
    {
      this.lastI420Frame = null;
      drawTexture(paramGlDrawer, (VideoFrame.TextureBuffer)paramVideoFrame.getBuffer(), this.renderMatrix, this.renderWidth, this.renderHeight, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    if (paramVideoFrame != this.lastI420Frame)
    {
      this.lastI420Frame = paramVideoFrame;
      VideoFrame.I420Buffer localI420Buffer = paramVideoFrame.getBuffer().toI420();
      this.yuvUploader.uploadFromBuffer(localI420Buffer);
      localI420Buffer.release();
    }
    paramGlDrawer.drawYuv(this.yuvUploader.getYuvTextures(), RendererCommon.convertMatrixFromAndroidGraphicsMatrix(this.renderMatrix), this.renderWidth, this.renderHeight, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void release()
  {
    this.yuvUploader.release();
    this.lastI420Frame = null;
  }

  private static class YuvUploader
  {

    @Nullable
    private ByteBuffer copyBuffer;

    @Nullable
    private int[] yuvTextures;

    @Nullable
    public int[] getYuvTextures()
    {
      return this.yuvTextures;
    }

    public void release()
    {
      this.copyBuffer = null;
      if (this.yuvTextures != null)
      {
        GLES20.glDeleteTextures(3, this.yuvTextures, 0);
        this.yuvTextures = null;
      }
    }

    @Nullable
    public int[] uploadFromBuffer(VideoFrame.I420Buffer paramI420Buffer)
    {
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = paramI420Buffer.getStrideY();
      arrayOfInt[1] = paramI420Buffer.getStrideU();
      arrayOfInt[2] = paramI420Buffer.getStrideV();
      ByteBuffer[] arrayOfByteBuffer = new ByteBuffer[3];
      arrayOfByteBuffer[0] = paramI420Buffer.getDataY();
      arrayOfByteBuffer[1] = paramI420Buffer.getDataU();
      arrayOfByteBuffer[2] = paramI420Buffer.getDataV();
      return uploadYuvData(paramI420Buffer.getWidth(), paramI420Buffer.getHeight(), arrayOfInt, arrayOfByteBuffer);
    }

    @Nullable
    public int[] uploadYuvData(int paramInt1, int paramInt2, int[] paramArrayOfInt, ByteBuffer[] paramArrayOfByteBuffer)
    {
      int[] arrayOfInt1 = new int[3];
      arrayOfInt1[0] = paramInt1;
      arrayOfInt1[1] = (paramInt1 / 2);
      arrayOfInt1[2] = (paramInt1 / 2);
      int[] arrayOfInt2 = new int[3];
      arrayOfInt2[0] = paramInt2;
      arrayOfInt2[1] = (paramInt2 / 2);
      arrayOfInt2[2] = (paramInt2 / 2);
      int i = 0;
      for (int j = 0; j < 3; j++)
        if (paramArrayOfInt[j] > arrayOfInt1[j])
          i = Math.max(i, arrayOfInt1[j] * arrayOfInt2[j]);
      if ((i > 0) && ((this.copyBuffer == null) || (this.copyBuffer.capacity() < i)))
        this.copyBuffer = ByteBuffer.allocateDirect(i);
      if (this.yuvTextures == null)
      {
        this.yuvTextures = new int[3];
        for (int m = 0; m < 3; m++)
          this.yuvTextures[m] = GlUtil.generateTexture(3553);
      }
      int k = 0;
      if (k < 3)
      {
        GLES20.glActiveTexture(33984 + k);
        GLES20.glBindTexture(3553, this.yuvTextures[k]);
        if (paramArrayOfInt[k] == arrayOfInt1[k]);
        for (ByteBuffer localByteBuffer = paramArrayOfByteBuffer[k]; ; localByteBuffer = this.copyBuffer)
        {
          GLES20.glTexImage2D(3553, 0, 6409, arrayOfInt1[k], arrayOfInt2[k], 0, 6409, 5121, localByteBuffer);
          k++;
          break;
          YuvHelper.copyPlane(paramArrayOfByteBuffer[k], paramArrayOfInt[k], this.copyBuffer, arrayOfInt1[k], arrayOfInt1[k], arrayOfInt2[k]);
        }
      }
      return this.yuvTextures;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VideoFrameDrawer
 * JD-Core Version:    0.6.2
 */
package org.webrtc;

import android.graphics.Matrix;
import android.opengl.GLES20;
import java.nio.ByteBuffer;

public class YuvConverter
{
  private static final String FRAGMENT_SHADER = "uniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 1.5 * xUnit).rgb);\n}\n";
  private final GlGenericDrawer drawer = new GlGenericDrawer("uniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 1.5 * xUnit).rgb);\n}\n", this.shaderCallbacks);
  private final GlTextureFrameBuffer i420TextureFrameBuffer = new GlTextureFrameBuffer(6408);
  private final ShaderCallbacks shaderCallbacks = new ShaderCallbacks(null);
  private final ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();

  public YuvConverter()
  {
    this.threadChecker.detachThread();
  }

  public VideoFrame.I420Buffer convert(VideoFrame.TextureBuffer paramTextureBuffer)
  {
    this.threadChecker.checkIsOnValidThread();
    int i = paramTextureBuffer.getWidth();
    int j = paramTextureBuffer.getHeight();
    int k = 8 * ((i + 7) / 8);
    int m = (j + 1) / 2;
    int n = j + m;
    ByteBuffer localByteBuffer1 = JniCommon.nativeAllocateByteBuffer(k * n);
    int i1 = k / 4;
    Matrix localMatrix = new Matrix();
    localMatrix.preTranslate(0.5F, 0.5F);
    localMatrix.preScale(1.0F, -1.0F);
    localMatrix.preTranslate(-0.5F, -0.5F);
    this.i420TextureFrameBuffer.setSize(i1, n);
    GLES20.glBindFramebuffer(36160, this.i420TextureFrameBuffer.getFrameBufferId());
    GlUtil.checkNoGLES2Error("glBindFramebuffer");
    this.shaderCallbacks.setPlaneY();
    VideoFrameDrawer.drawTexture(this.drawer, paramTextureBuffer, localMatrix, i, j, 0, 0, i1, j);
    this.shaderCallbacks.setPlaneU();
    VideoFrameDrawer.drawTexture(this.drawer, paramTextureBuffer, localMatrix, i, j, 0, j, i1 / 2, m);
    this.shaderCallbacks.setPlaneV();
    VideoFrameDrawer.drawTexture(this.drawer, paramTextureBuffer, localMatrix, i, j, i1 / 2, j, i1 / 2, m);
    GLES20.glReadPixels(0, 0, this.i420TextureFrameBuffer.getWidth(), this.i420TextureFrameBuffer.getHeight(), 6408, 5121, localByteBuffer1);
    GlUtil.checkNoGLES2Error("YuvConverter.convert");
    GLES20.glBindFramebuffer(36160, 0);
    int i2 = 0 + k * j;
    int i3 = i2 + k / 2;
    localByteBuffer1.position(0);
    localByteBuffer1.limit(0 + k * j);
    ByteBuffer localByteBuffer2 = localByteBuffer1.slice();
    localByteBuffer1.position(i2);
    int i4 = k * (m - 1) + k / 2;
    localByteBuffer1.limit(i2 + i4);
    ByteBuffer localByteBuffer3 = localByteBuffer1.slice();
    localByteBuffer1.position(i3);
    localByteBuffer1.limit(i3 + i4);
    return JavaI420Buffer.wrap(i, j, localByteBuffer2, k, localByteBuffer3, k, localByteBuffer1.slice(), k, new YuvConverter..Lambda.0(localByteBuffer1));
  }

  public void release()
  {
    this.threadChecker.checkIsOnValidThread();
    this.drawer.release();
    this.i420TextureFrameBuffer.release();
    this.threadChecker.detachThread();
  }

  private static class ShaderCallbacks
    implements GlGenericDrawer.ShaderCallbacks
  {
    private static final float[] uCoeffs = { -0.1688054F, -0.3317F, 0.5005057F, 0.5F };
    private static final float[] vCoeffs = { 0.4997964F, -0.4184672F, -0.0813292F, 0.5F };
    private static final float[] yCoeffs = { 0.298786F, 0.5871095F, 0.114105F, 0.0F };
    private float[] coeffs;
    private int coeffsLoc;
    private float stepSize;
    private int xUnitLoc;

    public void onNewShader(GlShader paramGlShader)
    {
      this.xUnitLoc = paramGlShader.getUniformLocation("xUnit");
      this.coeffsLoc = paramGlShader.getUniformLocation("coeffs");
    }

    public void onPrepareShader(GlShader paramGlShader, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      GLES20.glUniform4fv(this.coeffsLoc, 1, this.coeffs, 0);
      GLES20.glUniform2f(this.xUnitLoc, this.stepSize * paramArrayOfFloat[0] / paramInt1, this.stepSize * paramArrayOfFloat[1] / paramInt1);
    }

    public void setPlaneU()
    {
      this.coeffs = uCoeffs;
      this.stepSize = 2.0F;
    }

    public void setPlaneV()
    {
      this.coeffs = vCoeffs;
      this.stepSize = 2.0F;
    }

    public void setPlaneY()
    {
      this.coeffs = yCoeffs;
      this.stepSize = 1.0F;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.YuvConverter
 * JD-Core Version:    0.6.2
 */
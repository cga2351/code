package org.webrtc;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GlUtil
{
  public static void checkNoGLES2Error(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
      throw new RuntimeException(paramString + ": GLES20 error: " + i);
  }

  public static FloatBuffer createFloatBuffer(float[] paramArrayOfFloat)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(4 * paramArrayOfFloat.length);
    localByteBuffer.order(ByteOrder.nativeOrder());
    FloatBuffer localFloatBuffer = localByteBuffer.asFloatBuffer();
    localFloatBuffer.put(paramArrayOfFloat);
    localFloatBuffer.position(0);
    return localFloatBuffer;
  }

  public static int generateTexture(int paramInt)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    GLES20.glBindTexture(paramInt, i);
    GLES20.glTexParameterf(paramInt, 10241, 9729.0F);
    GLES20.glTexParameterf(paramInt, 10240, 9729.0F);
    GLES20.glTexParameterf(paramInt, 10242, 33071.0F);
    GLES20.glTexParameterf(paramInt, 10243, 33071.0F);
    checkNoGLES2Error("generateTexture");
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.GlUtil
 * JD-Core Version:    0.6.2
 */
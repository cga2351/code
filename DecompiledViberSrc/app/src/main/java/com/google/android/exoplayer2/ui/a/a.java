package com.google.android.exoplayer2.ui.a;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.text.TextUtils;
import com.google.android.exoplayer2.g.l;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

final class a
{
  public static int a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    a();
    int i = GLES20.glCreateShader(35633);
    GLES20.glShaderSource(i, TextUtils.join("\n", paramArrayOfString1));
    GLES20.glCompileShader(i);
    a();
    int j = GLES20.glCreateShader(35632);
    GLES20.glShaderSource(j, TextUtils.join("\n", paramArrayOfString2));
    GLES20.glCompileShader(j);
    a();
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    int[] arrayOfInt = new int[1];
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] != 1)
      l.d("Spherical.Utils", "Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(k));
    a();
    return k;
  }

  public static FloatBuffer a(float[] paramArrayOfFloat)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(4 * paramArrayOfFloat.length);
    localByteBuffer.order(ByteOrder.nativeOrder());
    FloatBuffer localFloatBuffer = localByteBuffer.asFloatBuffer();
    localFloatBuffer.put(paramArrayOfFloat);
    localFloatBuffer.position(0);
    return localFloatBuffer;
  }

  public static void a()
  {
    int i = GLES20.glGetError();
    if (i != 0)
      do
      {
        l.d("Spherical.Utils", "glError " + GLU.gluErrorString(i));
        i = GLES20.glGetError();
      }
      while (i != 0);
  }

  @TargetApi(15)
  public static int b()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, IntBuffer.wrap(arrayOfInt));
    GLES20.glBindTexture(36197, arrayOfInt[0]);
    GLES20.glTexParameteri(36197, 10241, 9729);
    GLES20.glTexParameteri(36197, 10240, 9729);
    GLES20.glTexParameteri(36197, 10242, 33071);
    GLES20.glTexParameteri(36197, 10243, 33071);
    a();
    return arrayOfInt[0];
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ui.a.a
 * JD-Core Version:    0.6.2
 */
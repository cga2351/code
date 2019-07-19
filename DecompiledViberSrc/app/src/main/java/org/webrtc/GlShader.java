package org.webrtc;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class GlShader
{
  private static final String TAG = "GlShader";
  private int program;

  public GlShader(String paramString1, String paramString2)
  {
    int i = compileShader(35633, paramString1);
    int j = compileShader(35632, paramString2);
    this.program = GLES20.glCreateProgram();
    if (this.program == 0)
      throw new RuntimeException("glCreateProgram() failed. GLES20 error: " + GLES20.glGetError());
    GLES20.glAttachShader(this.program, i);
    GLES20.glAttachShader(this.program, j);
    GLES20.glLinkProgram(this.program);
    int[] arrayOfInt = { 0 };
    GLES20.glGetProgramiv(this.program, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] != 1)
    {
      Logging.e("GlShader", "Could not link program: " + GLES20.glGetProgramInfoLog(this.program));
      throw new RuntimeException(GLES20.glGetProgramInfoLog(this.program));
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    GlUtil.checkNoGLES2Error("Creating GlShader");
  }

  private static int compileShader(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    if (i == 0)
      throw new RuntimeException("glCreateShader() failed. GLES20 error: " + GLES20.glGetError());
    GLES20.glShaderSource(i, paramString);
    GLES20.glCompileShader(i);
    int[] arrayOfInt = { 0 };
    GLES20.glGetShaderiv(i, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] != 1)
    {
      Logging.e("GlShader", "Compile error " + GLES20.glGetShaderInfoLog(i) + " in shader:\n" + paramString);
      throw new RuntimeException(GLES20.glGetShaderInfoLog(i));
    }
    GlUtil.checkNoGLES2Error("compileShader");
    return i;
  }

  public int getAttribLocation(String paramString)
  {
    if (this.program == -1)
      throw new RuntimeException("The program has been released");
    int i = GLES20.glGetAttribLocation(this.program, paramString);
    if (i < 0)
      throw new RuntimeException("Could not locate '" + paramString + "' in program");
    return i;
  }

  public int getUniformLocation(String paramString)
  {
    if (this.program == -1)
      throw new RuntimeException("The program has been released");
    int i = GLES20.glGetUniformLocation(this.program, paramString);
    if (i < 0)
      throw new RuntimeException("Could not locate uniform '" + paramString + "' in program");
    return i;
  }

  public void release()
  {
    Logging.d("GlShader", "Deleting shader.");
    if (this.program != -1)
    {
      GLES20.glDeleteProgram(this.program);
      this.program = -1;
    }
  }

  public void setVertexAttribArray(String paramString, int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer)
  {
    if (this.program == -1)
      throw new RuntimeException("The program has been released");
    int i = getAttribLocation(paramString);
    GLES20.glEnableVertexAttribArray(i);
    GLES20.glVertexAttribPointer(i, paramInt1, 5126, false, paramInt2, paramFloatBuffer);
    GlUtil.checkNoGLES2Error("setVertexAttribArray");
  }

  public void setVertexAttribArray(String paramString, int paramInt, FloatBuffer paramFloatBuffer)
  {
    setVertexAttribArray(paramString, paramInt, 0, paramFloatBuffer);
  }

  public void useProgram()
  {
    if (this.program == -1)
      throw new RuntimeException("The program has been released");
    GLES20.glUseProgram(this.program);
    GlUtil.checkNoGLES2Error("glUseProgram");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.GlShader
 * JD-Core Version:    0.6.2
 */
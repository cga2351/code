package com.viber.voip.videoconvert.gpu.opengl;

import android.opengl.GLES20;
import com.viber.voip.videoconvert.e;

public class b
{
  private int a = 0;
  private int b = 0;
  private int c = 0;

  public b(String paramString1, String paramString2)
  {
    if (this.c == 0)
    {
      e.a().a("could not create program");
      throw new RuntimeException("could not create program");
    }
    GLES20.glAttachShader(this.c, this.a);
    c("glAttachShader");
    GLES20.glAttachShader(this.c, this.b);
    c("glAttachShader");
    GLES20.glLinkProgram(this.c);
    int[] arrayOfInt = new int[1];
    GLES20.glGetProgramiv(this.c, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] != 1)
    {
      e.a().a("could not link program: ");
      e.a().a(GLES20.glGetProgramInfoLog(this.c));
      GLES20.glDeleteProgram(this.c);
      this.c = 0;
      throw new RuntimeException("could not create program");
    }
  }

  public static void a(int paramInt, String paramString)
  {
    if (paramInt < 0)
      throw new RuntimeException("Unable to locate '" + paramString + "' in program");
  }

  private int b(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    c("glCreateShader type=" + paramInt);
    GLES20.glShaderSource(i, paramString);
    GLES20.glCompileShader(i);
    int[] arrayOfInt = new int[1];
    GLES20.glGetShaderiv(i, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      e.a().a("Could not compile shader " + paramInt + ":");
      e.a().a(" " + GLES20.glGetShaderInfoLog(i));
      GLES20.glDeleteShader(i);
      throw new RuntimeException("could not compile shader");
    }
    return i;
  }

  public int a(String paramString)
  {
    int i = GLES20.glGetAttribLocation(this.c, paramString);
    a(i, paramString);
    return i;
  }

  public void a()
  {
    if (this.a != 0)
    {
      GLES20.glDetachShader(this.c, this.a);
      c("glDetachShader(mVertexShader)");
      GLES20.glDeleteShader(this.a);
      c("glDeleteShader(mVertexShader)");
    }
    if (this.b != 0)
    {
      GLES20.glDetachShader(this.c, this.b);
      c("glDetachShader(mFragmentShader)");
      GLES20.glDeleteShader(this.b);
      c("glDeleteShader(mFragmentShader)");
    }
    if (this.c != 0)
    {
      GLES20.glDeleteProgram(this.c);
      c("glDeleteProgram(mProgramHandle)");
    }
  }

  public int b(String paramString)
  {
    int i = GLES20.glGetUniformLocation(this.c, paramString);
    a(i, paramString);
    return i;
  }

  public void b()
  {
    GLES20.glUseProgram(this.c);
    c("glUseProgram");
  }

  public void c()
  {
    GLES20.glUseProgram(0);
    c("glUseProgram");
  }

  public void c(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      e.a().a(paramString + ": glError " + i);
      throw new RuntimeException(paramString + ": glError " + i);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.opengl.b
 * JD-Core Version:    0.6.2
 */
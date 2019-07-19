package org.webrtc;

import android.opengl.GLES20;
import java.nio.FloatBuffer;
import javax.annotation.Nullable;

class GlGenericDrawer
  implements RendererCommon.GlDrawer
{
  private static final String DEFAULT_VERTEX_SHADER_STRING = "varying vec2 tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\nuniform mat4 tex_mat;\nvoid main() {\n  gl_Position = in_pos;\n  tc = (tex_mat * in_tc).xy;\n}\n";
  private static final FloatBuffer FULL_RECTANGLE_BUFFER = GlUtil.createFloatBuffer(new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F });
  private static final FloatBuffer FULL_RECTANGLE_TEXTURE_BUFFER = GlUtil.createFloatBuffer(new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F });
  private static final String INPUT_TEXTURE_COORDINATE_NAME = "in_tc";
  private static final String INPUT_VERTEX_COORDINATE_NAME = "in_pos";
  private static final String TEXTURE_MATRIX_NAME = "tex_mat";

  @Nullable
  private GlShader currentShader;

  @Nullable
  private ShaderType currentShaderType;
  private final String genericFragmentSource;
  private int inPosLocation;
  private int inTcLocation;
  private final ShaderCallbacks shaderCallbacks;
  private int texMatrixLocation;
  private final String vertexShader;

  public GlGenericDrawer(String paramString1, String paramString2, ShaderCallbacks paramShaderCallbacks)
  {
    this.vertexShader = paramString1;
    this.genericFragmentSource = paramString2;
    this.shaderCallbacks = paramShaderCallbacks;
  }

  public GlGenericDrawer(String paramString, ShaderCallbacks paramShaderCallbacks)
  {
    this("varying vec2 tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\nuniform mat4 tex_mat;\nvoid main() {\n  gl_Position = in_pos;\n  tc = (tex_mat * in_tc).xy;\n}\n", paramString, paramShaderCallbacks);
  }

  static String createFragmentShaderString(String paramString, ShaderType paramShaderType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramShaderType == ShaderType.OES)
      localStringBuilder.append("#extension GL_OES_EGL_image_external : require\n");
    localStringBuilder.append("precision mediump float;\n");
    localStringBuilder.append("varying vec2 tc;\n");
    if (paramShaderType == ShaderType.YUV)
    {
      localStringBuilder.append("uniform sampler2D y_tex;\n");
      localStringBuilder.append("uniform sampler2D u_tex;\n");
      localStringBuilder.append("uniform sampler2D v_tex;\n");
      localStringBuilder.append("vec4 sample(vec2 p) {\n");
      localStringBuilder.append("  float y = texture2D(y_tex, p).r;\n");
      localStringBuilder.append("  float u = texture2D(u_tex, p).r - 0.5;\n");
      localStringBuilder.append("  float v = texture2D(v_tex, p).r - 0.5;\n");
      localStringBuilder.append("  return vec4(y + 1.403 * v, y - 0.344 * u - 0.714 * v, y + 1.77 * u, 1);\n");
      localStringBuilder.append("}\n");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    if (paramShaderType == ShaderType.OES);
    for (String str = "samplerExternalOES"; ; str = "sampler2D")
    {
      localStringBuilder.append("uniform ").append(str).append(" tex;\n");
      localStringBuilder.append(paramString.replace("sample(", "texture2D(tex, "));
      break;
    }
  }

  private void prepareShader(ShaderType paramShaderType, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject;
    if (paramShaderType.equals(this.currentShaderType))
    {
      localObject = this.currentShader;
      ((GlShader)localObject).useProgram();
      GLES20.glEnableVertexAttribArray(this.inPosLocation);
      GLES20.glVertexAttribPointer(this.inPosLocation, 2, 5126, false, 0, FULL_RECTANGLE_BUFFER);
      GLES20.glEnableVertexAttribArray(this.inTcLocation);
      GLES20.glVertexAttribPointer(this.inTcLocation, 2, 5126, false, 0, FULL_RECTANGLE_TEXTURE_BUFFER);
      GLES20.glUniformMatrix4fv(this.texMatrixLocation, 1, false, paramArrayOfFloat, 0);
      this.shaderCallbacks.onPrepareShader((GlShader)localObject, paramArrayOfFloat, paramInt1, paramInt2, paramInt3, paramInt4);
      GlUtil.checkNoGLES2Error("Prepare shader");
      return;
    }
    this.currentShaderType = paramShaderType;
    if (this.currentShader != null)
      this.currentShader.release();
    GlShader localGlShader = createShader(paramShaderType);
    this.currentShader = localGlShader;
    localGlShader.useProgram();
    if (paramShaderType == ShaderType.YUV)
    {
      GLES20.glUniform1i(localGlShader.getUniformLocation("y_tex"), 0);
      GLES20.glUniform1i(localGlShader.getUniformLocation("u_tex"), 1);
      GLES20.glUniform1i(localGlShader.getUniformLocation("v_tex"), 2);
    }
    while (true)
    {
      GlUtil.checkNoGLES2Error("Create shader");
      this.shaderCallbacks.onNewShader(localGlShader);
      this.texMatrixLocation = localGlShader.getUniformLocation("tex_mat");
      this.inPosLocation = localGlShader.getAttribLocation("in_pos");
      this.inTcLocation = localGlShader.getAttribLocation("in_tc");
      localObject = localGlShader;
      break;
      GLES20.glUniform1i(localGlShader.getUniformLocation("tex"), 0);
    }
  }

  GlShader createShader(ShaderType paramShaderType)
  {
    return new GlShader(this.vertexShader, createFragmentShaderString(this.genericFragmentSource, paramShaderType));
  }

  public void drawOes(int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    prepareShader(ShaderType.OES, paramArrayOfFloat, paramInt2, paramInt3, paramInt6, paramInt7);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, paramInt1);
    GLES20.glViewport(paramInt4, paramInt5, paramInt6, paramInt7);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindTexture(36197, 0);
  }

  public void drawRgb(int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    prepareShader(ShaderType.RGB, paramArrayOfFloat, paramInt2, paramInt3, paramInt6, paramInt7);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glViewport(paramInt4, paramInt5, paramInt6, paramInt7);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindTexture(3553, 0);
  }

  public void drawYuv(int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    prepareShader(ShaderType.YUV, paramArrayOfFloat, paramInt1, paramInt2, paramInt5, paramInt6);
    for (int i = 0; i < 3; i++)
    {
      GLES20.glActiveTexture(33984 + i);
      GLES20.glBindTexture(3553, paramArrayOfInt[i]);
    }
    GLES20.glViewport(paramInt3, paramInt4, paramInt5, paramInt6);
    GLES20.glDrawArrays(5, 0, 4);
    for (int j = 0; j < 3; j++)
    {
      GLES20.glActiveTexture(33984 + j);
      GLES20.glBindTexture(3553, 0);
    }
  }

  public void release()
  {
    if (this.currentShader != null)
    {
      this.currentShader.release();
      this.currentShader = null;
      this.currentShaderType = null;
    }
  }

  public static abstract interface ShaderCallbacks
  {
    public abstract void onNewShader(GlShader paramGlShader);

    public abstract void onPrepareShader(GlShader paramGlShader, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }

  public static enum ShaderType
  {
    static
    {
      ShaderType[] arrayOfShaderType = new ShaderType[3];
      arrayOfShaderType[0] = OES;
      arrayOfShaderType[1] = RGB;
      arrayOfShaderType[2] = YUV;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.GlGenericDrawer
 * JD-Core Version:    0.6.2
 */
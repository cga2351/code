package com.viber.svg.jni;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.Stack;

public class OpenGLPictureRenderer extends BitmapPictureRenderer
{
  private static final String LOG_TAG = OpenGLPictureRenderer.class.getSimpleName();
  private static final String fragmentShaderSource = "precision mediump float;\nvarying vec2 v_texCoord;\nuniform sampler2D s_texture;\nvoid main() {\n  gl_FragColor = texture2D(s_texture, v_texCoord);\n}\n";
  private static final float[] texCoords = { 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  private static final short[] vertexIndices = { 0, 1, 2, 0, 2, 3 };
  private static final String vertexShaderSource = "uniform mat4 uMVPMatrix;\nattribute vec4 vPosition;\nattribute vec2 a_texCoord;\nvarying vec2 v_texCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * vPosition;\n  v_texCoord = a_texCoord;\n}\n";
  private int[] texNameArray = new int[1];

  public OpenGLPictureRenderer(int paramInt)
  {
    super(paramInt);
  }

  protected BitmapPictureRenderer.Delegate getRasterizationStage(BitmapPictureRenderer.PictureRasterizationInfo[] paramArrayOfPictureRasterizationInfo)
  {
    return new OpenGLRasterizePicturesStage(paramArrayOfPictureRasterizationInfo);
  }

  private class OpenGLFinalStage extends BitmapPictureRenderer.Delegate
  {
    private static final int COORDS_PER_VERTEX = 2;
    private static final int COORDS_STRIDE = 8;
    private static final int TEX_COORDS_PER_VERTEX = 2;
    private static final int TEX_COORDS_STRIDE = 8;
    private android.graphics.Matrix curMatrix = new android.graphics.Matrix();
    private float[] elementMatrix = new float[16];
    private final ShortBuffer indexBuffer;
    private android.graphics.Matrix matrix = new android.graphics.Matrix();
    private Stack<android.graphics.Matrix> matrixStack = new Stack();
    private int matrixUniformHandle;
    private float[] mvpMatrix = new float[16];
    private boolean openGLInitialized = false;
    private OpenGLPictureRenderer.OpenGLPicture[] pictures;
    private int programHandle;
    private float[] projectionMatrix = new float[16];
    private long renderBitmapNanos;
    private int renderCountBitmaps;
    private int renderCountPixels;
    private long renderStartMillis;
    private final FloatBuffer texBuffer;
    private int texCoordHandle;
    private int texUniformHandle;
    private final FloatBuffer vertexBuffer;
    private int vertexCoordHandle;
    private final float[] vertexCoords = new float[8];
    private float[] viewMatrix = new float[16];
    private float[] workMatrix = new float[16];

    OpenGLFinalStage(OpenGLPictureRenderer.OpenGLPicture[] arg2)
    {
      super();
      android.opengl.Matrix.setIdentityM(this.elementMatrix, 0);
      ByteBuffer localByteBuffer1 = ByteBuffer.allocateDirect(4 * this.vertexCoords.length);
      localByteBuffer1.order(ByteOrder.nativeOrder());
      this.vertexBuffer = localByteBuffer1.asFloatBuffer();
      this.vertexBuffer.put(this.vertexCoords);
      this.vertexBuffer.position(0);
      ByteBuffer localByteBuffer2 = ByteBuffer.allocateDirect(4 * OpenGLPictureRenderer.texCoords.length);
      localByteBuffer2.order(ByteOrder.nativeOrder());
      this.texBuffer = localByteBuffer2.asFloatBuffer();
      this.texBuffer.put(OpenGLPictureRenderer.texCoords);
      this.texBuffer.position(0);
      ByteBuffer localByteBuffer3 = ByteBuffer.allocateDirect(2 * OpenGLPictureRenderer.vertexIndices.length);
      localByteBuffer3.order(ByteOrder.nativeOrder());
      this.indexBuffer = localByteBuffer3.asShortBuffer();
      this.indexBuffer.put(OpenGLPictureRenderer.vertexIndices);
      this.indexBuffer.position(0);
      Object localObject;
      this.pictures = localObject;
    }

    private void checkHandle(String paramString, int paramInt)
    {
      switch (paramInt)
      {
      default:
        return;
      case 1282:
        OpenGLPictureRenderer.this.L.debug("GL_INVALID_OPERATION for handle: " + paramString);
        return;
      case 1281:
        OpenGLPictureRenderer.this.L.debug("GL_INVALID_VALUE for handle: " + paramString);
        return;
      case -1:
      }
      OpenGLPictureRenderer.this.L.debug("-1 (name issue) for handle: " + paramString);
    }

    private void convertMatrix(android.graphics.Matrix paramMatrix, float[] paramArrayOfFloat)
    {
      paramMatrix.getValues(OpenGLPictureRenderer.this.matrixData);
      paramArrayOfFloat[0] = OpenGLPictureRenderer.this.matrixData[0];
      paramArrayOfFloat[4] = OpenGLPictureRenderer.this.matrixData[1];
      paramArrayOfFloat[12] = OpenGLPictureRenderer.this.matrixData[2];
      paramArrayOfFloat[1] = OpenGLPictureRenderer.this.matrixData[3];
      paramArrayOfFloat[5] = OpenGLPictureRenderer.this.matrixData[4];
      paramArrayOfFloat[13] = OpenGLPictureRenderer.this.matrixData[5];
    }

    private void doRenderPicture(OpenGLPictureRenderer.OpenGLPicture paramOpenGLPicture, android.graphics.Matrix paramMatrix)
    {
      this.vertexCoords[0] = 0.0F;
      this.vertexCoords[1] = 0.0F;
      this.vertexCoords[2] = paramOpenGLPicture.width;
      this.vertexCoords[3] = 0.0F;
      this.vertexCoords[4] = paramOpenGLPicture.width;
      this.vertexCoords[5] = paramOpenGLPicture.height;
      this.vertexCoords[6] = 0.0F;
      this.vertexCoords[7] = paramOpenGLPicture.height;
      this.vertexBuffer.position(0);
      this.vertexBuffer.put(this.vertexCoords);
      this.vertexBuffer.position(0);
      this.texBuffer.position(0);
      this.indexBuffer.position(0);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramOpenGLPicture.texName);
      GLES20.glUniform1i(this.texUniformHandle, 0);
      GLES20.glEnableVertexAttribArray(this.vertexCoordHandle);
      GLES20.glVertexAttribPointer(this.vertexCoordHandle, 2, 5126, false, 8, this.vertexBuffer);
      GLES20.glEnableVertexAttribArray(this.texCoordHandle);
      GLES20.glVertexAttribPointer(this.texCoordHandle, 2, 5126, false, 8, this.texBuffer);
      prepareMatrix(paramMatrix, this.workMatrix);
      GLES20.glUniformMatrix4fv(this.matrixUniformHandle, 1, false, this.workMatrix, 0);
      GLES20.glDrawElements(4, OpenGLPictureRenderer.vertexIndices.length, 5123, this.indexBuffer);
      GLES20.glDisableVertexAttribArray(this.vertexCoordHandle);
      GLES20.glDisableVertexAttribArray(this.texCoordHandle);
    }

    private void initOpenGL()
    {
      if (!this.openGLInitialized)
      {
        this.programHandle = createProgram("uniform mat4 uMVPMatrix;\nattribute vec4 vPosition;\nattribute vec2 a_texCoord;\nvarying vec2 v_texCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * vPosition;\n  v_texCoord = a_texCoord;\n}\n", "precision mediump float;\nvarying vec2 v_texCoord;\nuniform sampler2D s_texture;\nvoid main() {\n  gl_FragColor = texture2D(s_texture, v_texCoord);\n}\n");
        this.openGLInitialized = true;
      }
    }

    private int loadShader(int paramInt, String paramString)
    {
      int i = GLES20.glCreateShader(paramInt);
      if (i != 0)
      {
        GLES20.glShaderSource(i, paramString);
        GLES20.glCompileShader(i);
        int[] arrayOfInt = new int[1];
        GLES20.glGetShaderiv(i, 35713, arrayOfInt, 0);
        if (arrayOfInt[0] == 0)
        {
          OpenGLPictureRenderer.this.L.debug("Could not compile shader " + paramInt + ": " + GLES20.glGetShaderInfoLog(i));
          GLES20.glDeleteShader(i);
          return 0;
        }
      }
      return i;
    }

    private void prepareMatrix(android.graphics.Matrix paramMatrix, float[] paramArrayOfFloat)
    {
      android.opengl.Matrix.setLookAtM(this.viewMatrix, 0, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
      android.opengl.Matrix.orthoM(this.projectionMatrix, 0, 0.0F, -OpenGLPictureRenderer.this.renderWidth, OpenGLPictureRenderer.this.renderHeight, 0.0F, -1000.0F, 1000.0F);
      android.opengl.Matrix.multiplyMM(this.mvpMatrix, 0, this.projectionMatrix, 0, this.viewMatrix, 0);
      convertMatrix(paramMatrix, this.elementMatrix);
      android.opengl.Matrix.multiplyMM(paramArrayOfFloat, 0, this.mvpMatrix, 0, this.elementMatrix, 0);
    }

    void beginElement(double paramDouble)
    {
      super.beginElement(paramDouble);
      this.matrixStack.push(this.curMatrix);
      this.curMatrix = new android.graphics.Matrix(this.curMatrix);
    }

    void beginRender()
    {
      this.renderStartMillis = System.currentTimeMillis();
      this.renderBitmapNanos = 0L;
      this.renderCountBitmaps = 0;
      this.renderCountPixels = 0;
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
      GLES20.glUseProgram(this.programHandle);
      this.matrixUniformHandle = GLES20.glGetUniformLocation(this.programHandle, "uMVPMatrix");
      checkHandle("matrixUniformHandle", this.matrixUniformHandle);
      this.vertexCoordHandle = GLES20.glGetAttribLocation(this.programHandle, "vPosition");
      checkHandle("vertexCoordHandle", this.vertexCoordHandle);
      this.texUniformHandle = GLES20.glGetUniformLocation(this.programHandle, "s_texture");
      checkHandle("texUniformHandle", this.texUniformHandle);
      this.texCoordHandle = GLES20.glGetAttribLocation(this.programHandle, "a_texCoord");
      checkHandle("texCoordHandle", this.texCoordHandle);
    }

    void concatMatrix(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
    {
      OpenGLPictureRenderer.this.matrixData[0] = ((float)paramDouble1);
      OpenGLPictureRenderer.this.matrixData[1] = ((float)paramDouble3);
      OpenGLPictureRenderer.this.matrixData[2] = ((float)paramDouble5);
      OpenGLPictureRenderer.this.matrixData[3] = ((float)paramDouble2);
      OpenGLPictureRenderer.this.matrixData[4] = ((float)paramDouble4);
      OpenGLPictureRenderer.this.matrixData[5] = ((float)paramDouble6);
      OpenGLPictureRenderer.this.tmpMatrix.setValues(OpenGLPictureRenderer.this.matrixData);
      this.curMatrix.preConcat(OpenGLPictureRenderer.this.tmpMatrix);
    }

    public int createProgram(String paramString1, String paramString2)
    {
      int i = loadShader(35633, paramString1);
      int j = loadShader(35632, paramString2);
      int k = GLES20.glCreateProgram();
      if (k != 0)
      {
        GLES20.glAttachShader(k, i);
        GLES20.glAttachShader(k, j);
        GLES20.glLinkProgram(k);
        int[] arrayOfInt = new int[1];
        GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
        if (arrayOfInt[0] != 1)
        {
          OpenGLPictureRenderer.this.L.debug("Could not link program: " + GLES20.glGetProgramInfoLog(k));
          GLES20.glDeleteProgram(k);
          return 0;
        }
      }
      else
      {
        OpenGLPictureRenderer.this.L.debug("glCreateProgram() returned 0");
      }
      return k;
    }

    void endElement()
    {
      super.endElement();
      this.curMatrix = ((android.graphics.Matrix)this.matrixStack.pop());
    }

    void endRender()
    {
    }

    void renderPicture(int paramInt)
    {
      initOpenGL();
      OpenGLPictureRenderer.OpenGLPicture localOpenGLPicture = this.pictures[paramInt];
      if (localOpenGLPicture != null)
      {
        this.matrix.set(this.curMatrix);
        this.matrix.preConcat(localOpenGLPicture.matrix);
        long l = System.nanoTime();
        doRenderPicture(localOpenGLPicture, this.matrix);
        this.renderBitmapNanos = (System.nanoTime() - l + this.renderBitmapNanos);
        this.renderCountBitmaps = (1 + this.renderCountBitmaps);
        this.renderCountPixels += 4 * (localOpenGLPicture.width * localOpenGLPicture.height);
      }
    }
  }

  private class OpenGLPicture
  {
    int height;
    android.graphics.Matrix matrix;
    int texName;
    int width;

    OpenGLPicture(int paramMatrix, android.graphics.Matrix paramInt1, int paramInt2, int arg5)
    {
      this.texName = paramMatrix;
      this.matrix = paramInt1;
      this.width = paramInt2;
      int i;
      this.height = i;
    }
  }

  private class OpenGLRasterizePicturesStage extends BitmapPictureRenderer.Delegate
  {
    int curPictureIndex = 0;
    private Canvas dummyCanvas = new Canvas(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888));
    private Canvas origCanvas;
    private BitmapPictureRenderer.PictureRasterizationInfo[] pictureRasterizationInfos;
    private OpenGLPictureRenderer.OpenGLPicture[] pictures;
    long start;
    private Bitmap texBitmap;
    int totalBytes;
    int totalPixels;

    public OpenGLRasterizePicturesStage(BitmapPictureRenderer.PictureRasterizationInfo[] arg2)
    {
      super();
      Object localObject;
      this.pictureRasterizationInfos = localObject;
      this.pictures = new OpenGLPictureRenderer.OpenGLPicture[localObject.length];
    }

    private void glCheckError(String paramString)
    {
      int i = GLES20.glGetError();
      if (i != 0)
        OpenGLPictureRenderer.this.L.debug("glGetError: " + i);
    }

    void beginPicture()
    {
      BitmapPictureRenderer.PictureRasterizationInfo localPictureRasterizationInfo = this.pictureRasterizationInfos[this.curPictureIndex];
      this.origCanvas = OpenGLPictureRenderer.this.canvas;
      if (localPictureRasterizationInfo != null)
      {
        this.texBitmap = Bitmap.createBitmap(localPictureRasterizationInfo.bitmapWidth, localPictureRasterizationInfo.bitmapHeight, Bitmap.Config.ARGB_8888);
        GLES20.glGenTextures(1, OpenGLPictureRenderer.this.texNameArray, 0);
        glCheckError("genTextures");
        OpenGLPictureRenderer.this.L.debug("genTextures returned " + OpenGLPictureRenderer.this.texNameArray[0]);
        OpenGLPictureRenderer.OpenGLPicture localOpenGLPicture = new OpenGLPictureRenderer.OpenGLPicture(OpenGLPictureRenderer.this, OpenGLPictureRenderer.this.texNameArray[0], localPictureRasterizationInfo.renderMatrix, localPictureRasterizationInfo.bitmapWidth, localPictureRasterizationInfo.bitmapHeight);
        this.pictures[this.curPictureIndex] = localOpenGLPicture;
        OpenGLPictureRenderer.this.canvas = new Canvas(this.texBitmap);
        OpenGLPictureRenderer.this.canvas.concat(localPictureRasterizationInfo.rasterizeMatrix);
        return;
      }
      OpenGLPictureRenderer.this.canvas = this.dummyCanvas;
    }

    void beginPictures()
    {
      this.start = System.currentTimeMillis();
    }

    void endPicture()
    {
      if (this.pictureRasterizationInfos[this.curPictureIndex] != null)
      {
        OpenGLPictureRenderer.OpenGLPicture localOpenGLPicture = this.pictures[this.curPictureIndex];
        this.totalBytes = (4 * (this.texBitmap.getWidth() * this.texBitmap.getHeight()) + this.totalBytes);
        GLES20.glBindTexture(3553, localOpenGLPicture.texName);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, this.texBitmap, 0);
        this.texBitmap.recycle();
        this.texBitmap = null;
      }
      OpenGLPictureRenderer.this.canvas = this.origCanvas;
      this.curPictureIndex = (1 + this.curPictureIndex);
    }

    void endPictures()
    {
      long l = System.currentTimeMillis() - this.start;
      OpenGLPictureRenderer.this.L.debug("Total bytes after rasterization: " + this.totalBytes + ", rasterized in " + l + "ms");
      OpenGLPictureRenderer.this.curDelegate = new OpenGLPictureRenderer.OpenGLFinalStage(OpenGLPictureRenderer.this, this.pictures);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.OpenGLPictureRenderer
 * JD-Core Version:    0.6.2
 */
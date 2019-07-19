package com.viber.svg.jni;

import java.io.IOException;

public class SvgObject
{
  private static final int DEFAULT_FLAGS = 0;
  public static final int FLAG_ANDROID_INHERITANCE_RESPECTING_PICTURIZATION = 1048576;
  public static final int FLAG_ANDROID_RASTERIZE_ENABLED = 65536;
  public static final int FLAG_ANDROID_RASTERIZE_MODE_BITMAP = 262144;
  public static final int FLAG_ANDROID_RASTERIZE_MODE_OPENGL = 524288;
  public static final int FLAG_ANDROID_RASTERIZE_ROTATE_ENABLED = 131072;
  public static final int FLAG_MASK_FIRST = 32;
  public static final int FLAG_PICTURIZE_CONTENTS_ONLY = 4;
  public static final int FLAG_PICTURIZE_LEAVES_ONLY = 2;
  public static final int FLAG_STYLE_COMPLETE_PICTURES = 8;
  public static final int FLAG_USE_AUTOLOOP = 16;
  public static final int FLAG_USE_PICTURES = 1;
  protected long id;
  private boolean isParsed;
  private boolean isPrepared;
  protected SvgRenderer renderer;
  protected String svgId;

  public SvgObject()
  {
    this(null, 0);
  }

  public SvgObject(String paramString, int paramInt)
  {
    this.renderer = createRenderer(paramInt);
    this.id = nativeCreate(paramInt);
    this.svgId = paramString;
    nativeSetBatchArrays(this.id, this.renderer.bytes, this.renderer.ints, this.renderer.doubles, this.renderer.floats);
  }

  private void ensureAlive()
  {
    if (this.id == 0L)
      throw new RuntimeException("SvgObject access after destruction.");
  }

  private void ensureNotParsed()
  {
    if (this.isParsed)
      throw new RuntimeException("SvgObject has already parsed an svg!");
  }

  private void ensureNotPrepared()
  {
    if (this.isPrepared)
      throw new RuntimeException("SvgObject already prepared!");
  }

  private void ensureParsed()
  {
    if (!this.isParsed)
      throw new RuntimeException("SvgObject has not yet parsed any svg!");
  }

  private void ensurePrepared()
  {
    if (!this.isPrepared)
      throw new RuntimeException("SvgObject not prepared!");
  }

  @Deprecated
  public static native void nativeCrashLibrary();

  private static native long nativeCreate(int paramInt);

  private static native void nativeDestroy(long paramLong);

  private static native int nativeGetHeight(long paramLong);

  private static native double nativeGetMaxTime(long paramLong);

  private static native int nativeGetWidth(long paramLong);

  private static native int nativeParseBuffer(long paramLong, String paramString);

  private static native int nativeParseFile(long paramLong, String paramString);

  private static native int nativePrepare(long paramLong, int paramInt1, int paramInt2, SvgRenderer paramSvgRenderer, int paramInt3);

  private static native int nativeRenderToArea(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, SvgRenderer paramSvgRenderer);

  private static native int nativeSetBatchArrays(long paramLong, byte[] paramArrayOfByte, int[] paramArrayOfInt, double[] paramArrayOfDouble, float[] paramArrayOfFloat);

  private static native int nativeUnsetBatchArrays(long paramLong);

  protected SvgRenderer createRenderer(int paramInt)
  {
    return new SvgRenderer(paramInt);
  }

  public void destroy()
  {
    if (this.id != 0L)
    {
      nativeUnsetBatchArrays(this.id);
      nativeDestroy(this.id);
      this.id = 0L;
    }
  }

  public void finalize()
  {
    destroy();
  }

  public int getHeight()
  {
    ensureAlive();
    ensureParsed();
    return nativeGetHeight(this.id);
  }

  public double getMaxTime()
  {
    ensureAlive();
    ensureParsed();
    double d = nativeGetMaxTime(this.id);
    if (d > 0.0D)
      d -= 1.E-005D;
    return d;
  }

  public String getSvgId()
  {
    ensureAlive();
    return this.svgId;
  }

  public int getWidth()
  {
    ensureAlive();
    ensureParsed();
    return nativeGetWidth(this.id);
  }

  public void parseBuffer(String paramString)
    throws IOException
  {
    ensureAlive();
    ensureNotParsed();
    this.isParsed = true;
    int i = nativeParseBuffer(this.id, paramString);
    if (i != 0)
      throw new IOException("parseBuffer returned " + i);
  }

  public void parseFile(String paramString)
    throws IOException
  {
    ensureAlive();
    ensureNotParsed();
    this.isParsed = true;
    int i = nativeParseFile(this.id, paramString);
    if (i != 0)
      throw new IOException("parseFile returned " + i + " for " + paramString);
  }

  public void prepare(int paramInt1, int paramInt2)
  {
    ensureAlive();
    ensureParsed();
    ensureNotPrepared();
    this.renderer.setPrepareViewportSize(paramInt1, paramInt2);
    int i = this.renderer.getPrepareFlags(this.svgId);
    nativePrepare(this.id, paramInt1, paramInt2, this.renderer, i);
    this.isPrepared = true;
  }

  public void renderToArea(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble)
  {
    ensureAlive();
    if (this.isPrepared)
      nativeRenderToArea(this.id, paramInt1, paramInt2, paramInt3, paramInt4, paramDouble, this.renderer);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.SvgObject
 * JD-Core Version:    0.6.2
 */
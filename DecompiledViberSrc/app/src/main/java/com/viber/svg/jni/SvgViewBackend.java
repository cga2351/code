package com.viber.svg.jni;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class SvgViewBackend
{
  private static final int BUF_SIZE = 4096;
  private final Logger L = Logger.create(getClass().getSimpleName());
  private TimeAware.Clock clock = TimeAware.fallbackClock;
  private int intrinsicHeight;
  private int intrinsicWidth;
  private long lastRenderTime = 0L;
  private boolean mIsReady;
  private double maxTime;
  private AndroidSvgObject svgObject;

  private void doLoadFromAsset(Context paramContext, String paramString1, String paramString2, int paramInt)
    throws IOException
  {
    if (this.svgObject != null)
      this.svgObject.destroy();
    this.svgObject = new AndroidSvgObject(paramString2, paramInt);
    long l1 = System.currentTimeMillis();
    this.svgObject.parseBuffer(streamToString(paramContext.getAssets().open(paramString1)));
    long l2 = System.currentTimeMillis() - l1;
    this.L.debug("loadFromAsset for " + paramString2 + " took " + l2 + "ms");
  }

  private void loadFromFile(String paramString1, String paramString2, int paramInt)
    throws IOException
  {
    if (this.svgObject != null)
      this.svgObject.destroy();
    this.svgObject = new AndroidSvgObject(paramString2, paramInt);
    long l1 = System.currentTimeMillis();
    this.svgObject.parseFile(paramString1);
    long l2 = System.currentTimeMillis() - l1;
    this.L.debug("loadFromFile for " + paramString2 + " took " + l2 + "ms");
  }

  private void prepare()
  {
    long l1 = System.currentTimeMillis();
    this.svgObject.prepare(1, 1);
    long l2 = System.currentTimeMillis() - l1;
    this.L.debug("prepare for " + this.svgObject.getSvgId() + " took " + l2 + "ms");
    this.intrinsicWidth = this.svgObject.getWidth();
    this.intrinsicHeight = this.svgObject.getHeight();
    this.maxTime = this.svgObject.getMaxTime();
  }

  private String streamToString(InputStream paramInputStream)
    throws IOException
  {
    StringWriter localStringWriter = new StringWriter();
    InputStreamReader localInputStreamReader = new InputStreamReader(paramInputStream);
    char[] arrayOfChar = new char[4096];
    try
    {
      while (true)
      {
        int i = localInputStreamReader.read(arrayOfChar);
        if (i <= 0)
          break;
        localStringWriter.write(arrayOfChar, 0, i);
      }
    }
    finally
    {
      localInputStreamReader.close();
      localStringWriter.close();
    }
    localInputStreamReader.close();
    localStringWriter.close();
    return localStringWriter.toString();
  }

  public TimeAware.Clock getClock()
  {
    return this.clock;
  }

  public int getIntrinsicHeight()
  {
    return this.intrinsicHeight;
  }

  public int getIntrinsicWidth()
  {
    return this.intrinsicWidth;
  }

  public double getMaxTime()
  {
    return this.maxTime;
  }

  public boolean isReady()
  {
    return this.mIsReady;
  }

  public void load(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      loadFromFile(paramString1, paramString2, paramInt);
      prepare();
      this.mIsReady = true;
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        this.L.warn("Error parsing " + paramString1, localIOException);
        this.mIsReady = false;
      }
    }
    finally
    {
    }
  }

  public void loadFromAsset(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    try
    {
      doLoadFromAsset(paramContext, paramString1, paramString2, paramInt);
      prepare();
      this.mIsReady = true;
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        this.L.warn("Error parsing " + paramString1, localIOException);
        this.mIsReady = false;
      }
    }
    finally
    {
    }
  }

  public void renderToCanvas(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    while (true)
    {
      long l4;
      try
      {
        long l1 = System.currentTimeMillis();
        if (this.svgObject == null)
        {
          this.L.warn("svgObject is null");
          return;
        }
        double d = this.clock.getCurrentTime();
        this.svgObject.renderToArea(paramCanvas, 0, 0, paramInt1, paramInt2, d);
        long l2 = System.currentTimeMillis();
        long l3 = l2 - l1;
        l4 = l2 - this.lastRenderTime;
        this.lastRenderTime = l2;
        if (l4 == 0L)
        {
          i = 0;
          this.L.debug("renderToCanvas, curTime: " + d + ", renderToArea duration:" + l3 + ", FPS: " + i);
          continue;
        }
      }
      finally
      {
      }
      long l5 = 1000L / l4;
      int i = (int)l5;
    }
  }

  public void reset()
  {
    if (this.svgObject != null)
    {
      this.svgObject.destroy();
      this.svgObject = null;
    }
  }

  public void setClock(TimeAware.Clock paramClock)
  {
    this.clock = paramClock;
  }

  public void setCurrentColor(int paramInt)
  {
    if (this.svgObject != null)
      this.svgObject.setCurrentColor(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.SvgViewBackend
 * JD-Core Version:    0.6.2
 */
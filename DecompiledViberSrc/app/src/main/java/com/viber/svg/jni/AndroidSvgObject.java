package com.viber.svg.jni;

import android.graphics.Canvas;
import java.lang.reflect.Method;

public class AndroidSvgObject extends SvgObject
{
  static
  {
    try
    {
      Class localClass = Class.forName("com.viber.common.jni.NativeLibraryLoader");
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = String.class;
      arrayOfClass[1] = Boolean.TYPE;
      Method localMethod = localClass.getMethod("loadLibrary", arrayOfClass);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = "svg";
      arrayOfObject[1] = Boolean.valueOf(true);
      localMethod.invoke(null, arrayOfObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      System.loadLibrary("svg");
    }
  }

  public AndroidSvgObject(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }

  protected SvgRenderer createRenderer(int paramInt)
  {
    if ((paramInt & 0x1) != 0)
    {
      if ((0x10000 & paramInt) != 0)
      {
        if ((0x40000 & paramInt) != 0)
          return new BitmapPictureRenderer(paramInt);
        if ((0x80000 & paramInt) != 0)
          return new OpenGLPictureRenderer(paramInt);
        throw new IllegalArgumentException("No rasterization mode specified");
      }
      if ((0x100000 & paramInt) != 0)
        return new InheritanceRespectingPictureRenderer(paramInt);
      return new PictureRenderer(paramInt);
    }
    return new AndroidSvgRenderer(paramInt);
  }

  public void renderToArea(Canvas paramCanvas, double paramDouble1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble2)
  {
    ((AndroidSvgRenderer)this.renderer).setCanvas(paramCanvas, paramInt3, paramInt4);
    ((AndroidSvgRenderer)this.renderer).beginElement(paramDouble1);
    renderToArea(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble2);
    ((AndroidSvgRenderer)this.renderer).endElement();
    ((AndroidSvgRenderer)this.renderer).setCanvas(null, paramInt3, paramInt4);
  }

  public void renderToArea(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble)
  {
    renderToArea(paramCanvas, 1.0D, paramInt1, paramInt2, paramInt3, paramInt4, paramDouble);
  }

  public void setCurrentColor(int paramInt)
  {
    ((AndroidSvgRenderer)this.renderer).setCurrentColor(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.AndroidSvgObject
 * JD-Core Version:    0.6.2
 */
package com.viber.svg.jni;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

public class SvgSurfaceView extends SurfaceView
  implements SvgViewCommon
{
  private static final String LOG_TAG = SvgSurfaceView.class.getSimpleName();
  private SvgViewBackend backend;

  public SvgSurfaceView(Context paramContext)
  {
    super(paramContext);
    init();
  }

  public SvgSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SvgSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }

  private void init()
  {
    this.backend = new SvgViewBackend();
  }

  public View asView()
  {
    return this;
  }

  public void draw(Canvas paramCanvas)
  {
    new Exception().printStackTrace();
    this.backend.renderToCanvas(paramCanvas, getWidth(), getHeight());
  }

  public SvgViewBackend getBackend()
  {
    return this.backend;
  }

  public void load(String paramString1, String paramString2, int paramInt)
  {
    this.backend.load(paramString1, paramString2, paramInt);
  }

  public void loadFromAsset(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    this.backend.loadFromAsset(paramContext, paramString1, paramString2, paramInt);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }

  public void setBackend(SvgViewBackend paramSvgViewBackend)
  {
    this.backend = paramSvgViewBackend;
  }

  public void setClock(TimeAware.Clock paramClock)
  {
    this.backend.setClock(paramClock);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.SvgSurfaceView
 * JD-Core Version:    0.6.2
 */
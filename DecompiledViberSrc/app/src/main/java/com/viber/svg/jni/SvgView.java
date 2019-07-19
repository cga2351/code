package com.viber.svg.jni;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class SvgView extends View
  implements SvgViewCommon
{
  private SvgViewBackend backend;

  public SvgView(Context paramContext)
  {
    super(paramContext);
    init();
  }

  public SvgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SvgView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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

  public SvgViewBackend getBackend()
  {
    return this.backend;
  }

  public void load(String paramString1, String paramString2, int paramInt)
  {
    this.backend.load(paramString1, paramString2, paramInt);
  }

  @Deprecated
  public void load(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.backend.load(paramString1, paramString2, paramInt1);
  }

  public void loadFromAsset(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    this.backend.loadFromAsset(paramContext, paramString1, paramString2, paramInt);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.backend.renderToCanvas(paramCanvas, getWidth(), getHeight());
    if (!this.backend.getClock().isTimeFrozen())
      invalidate();
  }

  protected void reset()
  {
    this.backend.reset();
  }

  public void setBackend(SvgViewBackend paramSvgViewBackend)
  {
    this.backend = paramSvgViewBackend;
  }

  public void setClock(TimeAware.Clock paramClock)
  {
    this.backend.setClock(paramClock);
    invalidate();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.SvgView
 * JD-Core Version:    0.6.2
 */
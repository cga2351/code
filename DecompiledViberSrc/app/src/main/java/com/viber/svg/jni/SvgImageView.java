package com.viber.svg.jni;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class SvgImageView extends ImageView
  implements SvgViewCommon
{
  private SvgViewBackend mBackend;
  private boolean mSvgEnabled;

  public SvgImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }

  public SvgImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SvgImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }

  private void init()
  {
    this.mBackend = new SvgViewBackend();
    setWillNotDraw(false);
  }

  public View asView()
  {
    return this;
  }

  public void draw(Canvas paramCanvas)
  {
    if ((this.mSvgEnabled) && (this.mBackend.isReady()))
    {
      this.mBackend.renderToCanvas(paramCanvas, getWidth(), getHeight());
      if ((this.mBackend.getClock() != null) && (!this.mBackend.getClock().isTimeFrozen()))
        invalidate();
    }
    while (this.mSvgEnabled)
      return;
    super.draw(paramCanvas);
  }

  public SvgViewBackend getBackend()
  {
    return this.mBackend;
  }

  public double getDuration()
  {
    return this.mBackend.getMaxTime();
  }

  public boolean isSvgEnabled()
  {
    return this.mSvgEnabled;
  }

  public void load(String paramString1, String paramString2, int paramInt)
  {
    this.mBackend.load(paramString1, paramString2, paramInt);
  }

  public void loadFromAsset(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    this.mBackend.loadFromAsset(paramContext, paramString1, paramString2, paramInt);
  }

  public void setBackend(SvgViewBackend paramSvgViewBackend)
  {
    this.mBackend = paramSvgViewBackend;
  }

  public void setClock(TimeAware.Clock paramClock)
  {
    this.mBackend.setClock(paramClock);
    invalidate();
  }

  public void setCurrentColor(int paramInt)
  {
    this.mBackend.setCurrentColor(paramInt);
  }

  public void setSvgEnabled(boolean paramBoolean)
  {
    this.mSvgEnabled = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.SvgImageView
 * JD-Core Version:    0.6.2
 */
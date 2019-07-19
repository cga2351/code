package com.viber.svg.jni;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class BitmapBackedSvgView extends ImageView
  implements SvgViewCommon
{
  private SvgViewBackend backend;
  private Bitmap bitmap;
  private Canvas bitmapCanvas;

  public BitmapBackedSvgView(Context paramContext)
  {
    super(paramContext);
    init();
  }

  public BitmapBackedSvgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public BitmapBackedSvgView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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

  public void initBuffer(int paramInt1, int paramInt2)
  {
    this.bitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    this.bitmapCanvas = new Canvas(this.bitmap);
    setImageBitmap(this.bitmap);
  }

  public void load(String paramString1, String paramString2, int paramInt)
  {
    this.backend.load(paramString1, paramString2, paramInt);
  }

  public void loadFromAsset(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    this.backend.loadFromAsset(paramContext, paramString1, paramString2, paramInt);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.bitmapCanvas != null) && (this.bitmap != null))
      this.backend.renderToCanvas(this.bitmapCanvas, this.bitmap.getWidth(), this.bitmap.getHeight());
    super.onDraw(paramCanvas);
    if (!this.backend.getClock().isTimeFrozen())
      invalidate();
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
 * Qualified Name:     com.viber.svg.jni.BitmapBackedSvgView
 * JD-Core Version:    0.6.2
 */
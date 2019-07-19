package com.viber.voip.stickers.f;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.PictureDrawable;
import com.viber.voip.ViberApplication;
import com.viber.voip.stickers.ui.f;

public class b extends PictureDrawable
{
  private static final Paint b = new Paint(7);
  protected boolean a = ViberApplication.isTablet(null);
  private boolean c = false;
  private boolean d = false;
  private int e;
  private int f;

  static
  {
    b.setColorFilter(new PorterDuffColorFilter(f.a, PorterDuff.Mode.SRC_ATOP));
  }

  public b(Picture paramPicture, int paramInt1, int paramInt2)
  {
    this(paramPicture, false, paramInt1, paramInt2);
  }

  public b(Picture paramPicture, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramPicture);
    this.e = paramInt1;
    this.f = paramInt2;
    a(paramBoolean);
  }

  private void a(Canvas paramCanvas)
  {
    Picture localPicture = getPicture();
    int i;
    if (localPicture != null)
    {
      Rect localRect = getBounds();
      paramCanvas.save();
      paramCanvas.clipRect(localRect);
      paramCanvas.translate(localRect.left, localRect.top);
      if (localRect == null)
        break label94;
      i = localRect.width();
      if (i == this.e)
        break label94;
    }
    label94: for (float f1 = i / this.e; ; f1 = 1.0F)
    {
      if (f1 != 1.0F)
        paramCanvas.scale(f1, f1);
      paramCanvas.drawPicture(localPicture);
      paramCanvas.restore();
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.d)
      paramCanvas.saveLayer(null, b, 31);
    a(paramCanvas);
    if (this.d)
      paramCanvas.restore();
  }

  public boolean isStateful()
  {
    return true;
  }

  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    int j = 0;
    if (j < i)
    {
      int k = paramArrayOfInt[j];
      if (16842910 == k);
      while (true)
      {
        j++;
        break;
        if ((16842919 == k) || (16842908 != k));
      }
    }
    return super.onStateChange(paramArrayOfInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.f.b
 * JD-Core Version:    0.6.2
 */
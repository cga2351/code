package com.viber.voip.messages.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.widget.ImageView.ScaleType;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import java.util.Objects;

public class ad extends AppCompatImageView
  implements bw
{
  private Drawable a;
  private int b;
  private int c;
  private boolean d;

  public ad(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  protected void a(Context paramContext)
  {
    setScaleType(ImageView.ScaleType.FIT_START);
    Resources localResources = paramContext.getResources();
    int i = localResources.getDimensionPixelSize(R.dimen.menu_item_promotion_badge_size);
    this.b = localResources.getDimensionPixelOffset(R.dimen.menu_item_promotion_badge_horizontal_padding);
    this.a = ((Drawable)Objects.requireNonNull(ContextCompat.getDrawable(paramContext, R.drawable.ic_new_blue_badge)));
    this.a.setBounds(0, 0, i, i);
  }

  public void a(boolean paramBoolean)
  {
    if (this.d == paramBoolean)
      return;
    this.d = paramBoolean;
    invalidate();
  }

  public boolean b()
  {
    return this.d;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.d)
    {
      int i = paramCanvas.save();
      paramCanvas.translate(this.c, 0.0F);
      this.a.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.c = (paramInt1 - this.a.getIntrinsicWidth() - this.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.ad
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.ui.doodle.scene;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class SceneView extends ImageView
  implements View.OnTouchListener
{
  private static final Logger a = ViberEnv.getLogger();
  private a b;
  private RectF c = new RectF();
  private float d = 1.0F;
  private boolean e = true;
  private View.OnTouchListener f;

  public SceneView(Context paramContext)
  {
    super(paramContext);
  }

  public SceneView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public SceneView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private boolean a(Drawable paramDrawable)
  {
    Rect localRect = paramDrawable.getBounds();
    return (this.c.left != localRect.left) || (this.c.top != localRect.top) || (this.c.right != localRect.right) || (this.c.bottom != localRect.bottom);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.c.isEmpty())
      paramCanvas.clipRect(this.c);
    if (this.b != null)
    {
      paramCanvas.save();
      paramCanvas.translate(this.c.left, this.c.top);
      paramCanvas.scale(this.d, this.d);
      this.b.a(paramCanvas);
      paramCanvas.restore();
    }
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return (this.e) && ((paramMotionEvent.getAction() != 0) || (this.c.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))) && (this.f != null) && (this.f.onTouch(paramView, paramMotionEvent));
  }

  public void setDrawDelegate(a parama)
  {
    this.b = parama;
  }

  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable localDrawable = getDrawable();
    if ((localDrawable != null) && ((bool) || (a(localDrawable))))
    {
      this.c = new RectF(localDrawable.getBounds());
      getImageMatrix().mapRect(this.c);
      this.d = (this.c.width() / localDrawable.getIntrinsicWidth());
      if (this.b != null)
      {
        float f1 = localDrawable.getIntrinsicWidth() / this.c.width();
        float f2 = localDrawable.getIntrinsicHeight() / this.c.height();
        this.b.a(new SceneConfig(this.d, this.c, f1, f2));
      }
    }
    return bool;
  }

  public void setInteractionsEnabled(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }

  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.f = paramOnTouchListener;
    super.setOnTouchListener(this);
  }

  static abstract interface a
  {
    public abstract void a(Canvas paramCanvas);

    public abstract void a(SceneConfig paramSceneConfig);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.scene.SceneView
 * JD-Core Version:    0.6.2
 */
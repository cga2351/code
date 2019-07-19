package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class h extends FrameLayout
{
  Drawable insetForeground;
  Rect insets;
  private Rect tempRect = new Rect();

  public h(Context paramContext)
  {
    this(paramContext, null);
  }

  public h(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public h(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = j.a(paramContext, paramAttributeSet, R.styleable.ScrimInsetsFrameLayout, paramInt, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
    this.insetForeground = localTypedArray.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
    localTypedArray.recycle();
    setWillNotDraw(true);
    ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener()
    {
      public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
      {
        if (h.this.insets == null)
          h.this.insets = new Rect();
        h.this.insets.set(paramAnonymousWindowInsetsCompat.getSystemWindowInsetLeft(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetTop(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetRight(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetBottom());
        h.this.onInsetsChanged(paramAnonymousWindowInsetsCompat);
        h localh = h.this;
        if ((!paramAnonymousWindowInsetsCompat.hasSystemWindowInsets()) || (h.this.insetForeground == null));
        for (boolean bool = true; ; bool = false)
        {
          localh.setWillNotDraw(bool);
          ViewCompat.postInvalidateOnAnimation(h.this);
          return paramAnonymousWindowInsetsCompat.consumeSystemWindowInsets();
        }
      }
    });
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if ((this.insets != null) && (this.insetForeground != null))
    {
      int k = paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.tempRect.set(0, 0, i, this.insets.top);
      this.insetForeground.setBounds(this.tempRect);
      this.insetForeground.draw(paramCanvas);
      this.tempRect.set(0, j - this.insets.bottom, i, j);
      this.insetForeground.setBounds(this.tempRect);
      this.insetForeground.draw(paramCanvas);
      this.tempRect.set(0, this.insets.top, this.insets.left, j - this.insets.bottom);
      this.insetForeground.setBounds(this.tempRect);
      this.insetForeground.draw(paramCanvas);
      this.tempRect.set(i - this.insets.right, this.insets.top, i, j - this.insets.bottom);
      this.insetForeground.setBounds(this.tempRect);
      this.insetForeground.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.insetForeground != null)
      this.insetForeground.setCallback(this);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.insetForeground != null)
      this.insetForeground.setCallback(null);
  }

  protected void onInsetsChanged(WindowInsetsCompat paramWindowInsetsCompat)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.internal.h
 * JD-Core Version:    0.6.2
 */
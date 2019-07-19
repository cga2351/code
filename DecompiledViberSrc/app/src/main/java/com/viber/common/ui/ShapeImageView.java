package com.viber.common.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.viber.common.R.styleable;
import com.viber.common.a.e;
import com.viber.common.a.f;

public class ShapeImageView extends TintableImageView
{
  private static e d = f.a();
  protected b.b a;
  protected int b = 15;
  protected float c;
  private int e;
  private ImageView.ScaleType f;
  private Drawable g;
  private Drawable h;
  private Rect i;

  public ShapeImageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public ShapeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public ShapeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private Drawable a()
  {
    Resources localResources = getResources();
    if (localResources == null)
      return null;
    int j = this.e;
    Object localObject = null;
    if (j != 0);
    try
    {
      Drawable localDrawable = localResources.getDrawable(this.e);
      localObject = localDrawable;
      return a(localObject, getContext());
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      while (true)
      {
        this.e = 0;
        localObject = null;
      }
    }
  }

  private static b a(Bitmap paramBitmap, Context paramContext)
  {
    if (paramBitmap != null)
      return new b(paramContext.getResources(), paramBitmap);
    return null;
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ShapeImageView);
    try
    {
      int j = localTypedArray.getInt(R.styleable.ShapeImageView_shape, b.b.a.ordinal());
      this.a = b.b.values()[j];
      this.c = localTypedArray.getDimension(R.styleable.ShapeImageView_cornerRadius, 0.0F);
      Drawable localDrawable = localTypedArray.getDrawable(R.styleable.ShapeImageView_selectorDrawable);
      if (localDrawable != null)
        setSelector(localDrawable);
      localTypedArray.recycle();
      this.i = new Rect();
      a(getDrawable());
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  private void a(Canvas paramCanvas, Drawable paramDrawable)
  {
    if (paramDrawable == null)
      return;
    this.i.set(0, 0, getWidth(), getHeight());
    paramDrawable.setBounds(this.i);
    paramDrawable.draw(paramCanvas);
  }

  private void a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null)
    {
      paramDrawable1.setCallback(null);
      unscheduleDrawable(paramDrawable1);
    }
    if (paramDrawable2 != null)
      paramDrawable2.setCallback(this);
  }

  private static Bitmap b(Drawable paramDrawable)
  {
    int j = Math.max(paramDrawable.getIntrinsicWidth(), 1);
    int k = Math.max(paramDrawable.getIntrinsicHeight(), 1);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
    }
    return null;
  }

  private boolean b()
  {
    return (!isInTouchMode()) || (isPressed());
  }

  private void c()
  {
    Drawable localDrawable = this.g;
    boolean bool = false;
    if (localDrawable != null)
      if (!b())
        break label39;
    label39: for (bool = this.g.setState(getDrawableState()); ; bool = this.g.setState(new int[] { 0 }))
    {
      if (bool)
        invalidate();
      return;
    }
  }

  protected Drawable a(Drawable paramDrawable, Context paramContext)
  {
    if (paramDrawable == null)
      paramDrawable = null;
    while (true)
    {
      return paramDrawable;
      if (!(paramDrawable instanceof b))
      {
        if ((paramDrawable instanceof BitmapDrawable))
          return a(((BitmapDrawable)paramDrawable).getBitmap(), paramContext);
        if (!(paramDrawable instanceof LayerDrawable))
          break;
        paramDrawable = (LayerDrawable)paramDrawable;
        int j = 0;
        int k = paramDrawable.getNumberOfLayers();
        while (j < k)
        {
          paramDrawable.setDrawableByLayerId(paramDrawable.getId(j), a(paramDrawable.getDrawable(j), paramContext));
          j++;
        }
      }
    }
    return a(b(paramDrawable), paramContext);
  }

  protected void a(Canvas paramCanvas)
  {
    a(paramCanvas, this.g);
  }

  protected void a(Drawable paramDrawable)
  {
    if (paramDrawable == null);
    while (true)
    {
      return;
      if ((paramDrawable instanceof b))
      {
        b localb = (b)paramDrawable;
        localb.a(this.f);
        localb.a(this.a);
        if (this.c > 0.0F)
        {
          localb.a(this.b);
          localb.a(this.c);
        }
      }
      else if ((paramDrawable instanceof LayerDrawable))
      {
        LayerDrawable localLayerDrawable = (LayerDrawable)paramDrawable;
        int j = 0;
        int k = localLayerDrawable.getNumberOfLayers();
        while (j < k)
        {
          a(localLayerDrawable.getDrawable(j));
          j++;
        }
      }
    }
  }

  protected void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.h);
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    c();
  }

  public float getCornerRadius()
  {
    if (this.c == 0.0F)
    {
      Drawable localDrawable = getDrawable();
      if ((localDrawable instanceof b))
        return ((b)localDrawable).e();
    }
    return this.c;
  }

  public Drawable getForegroundDrawable()
  {
    return this.h;
  }

  public Drawable getSelector()
  {
    return this.g;
  }

  public b.b getShape()
  {
    return this.a;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    b(paramCanvas);
    a(paramCanvas);
  }

  public void setCornerRadius(float paramFloat)
  {
    if (this.c == paramFloat)
      return;
    this.c = paramFloat;
    a(getDrawable());
    invalidate();
  }

  public void setForegroundDrawable(int paramInt)
  {
    setForegroundDrawable(getResources().getDrawable(paramInt));
  }

  public void setForegroundDrawable(Drawable paramDrawable)
  {
    if (this.h == paramDrawable)
      return;
    Drawable localDrawable = this.h;
    this.h = paramDrawable;
    a(localDrawable, paramDrawable);
    invalidate();
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.e = 0;
    b localb = a(paramBitmap, getContext());
    a(localb);
    super.setImageDrawable(localb);
  }

  public void setImageDrawable(Drawable paramDrawable)
  {
    this.e = 0;
    Drawable localDrawable = a(paramDrawable, getContext());
    a(localDrawable);
    super.setImageDrawable(localDrawable);
  }

  public void setImageResource(int paramInt)
  {
    if (this.e == paramInt)
      return;
    this.e = paramInt;
    Drawable localDrawable = a();
    a(localDrawable);
    super.setImageDrawable(localDrawable);
  }

  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    setImageDrawable(getDrawable());
  }

  public void setRoundedCornerMask(int paramInt)
  {
    if (this.b == paramInt)
      return;
    this.b = paramInt;
    a(getDrawable());
    invalidate();
  }

  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (this.f == paramScaleType)
      return;
    this.f = paramScaleType;
    switch (1.a[paramScaleType.ordinal()])
    {
    default:
      super.setScaleType(paramScaleType);
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      a(getDrawable());
      invalidate();
      return;
      super.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }

  public void setSelector(int paramInt)
  {
    setSelector(getResources().getDrawable(paramInt));
  }

  public void setSelector(Drawable paramDrawable)
  {
    if (this.g == paramDrawable)
      return;
    Drawable localDrawable = this.g;
    this.g = paramDrawable;
    a(localDrawable, paramDrawable);
  }

  public void setShape(b.b paramb)
  {
    if (this.a == paramb)
      return;
    this.a = paramb;
    a(getDrawable());
    invalidate();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.ui.ShapeImageView
 * JD-Core Version:    0.6.2
 */
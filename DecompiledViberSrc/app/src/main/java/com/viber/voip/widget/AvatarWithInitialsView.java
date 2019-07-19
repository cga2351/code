package com.viber.voip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import com.viber.common.ui.ShapeImageView;
import com.viber.common.ui.a.d;
import com.viber.common.ui.b;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.styleable;
import com.viber.voip.util.da;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.j;
import java.util.HashMap;
import java.util.Map;

public class AvatarWithInitialsView extends ShapeImageView
{
  private static Map<String, Paint> d = new HashMap();
  private Paint e;
  private boolean f;
  private boolean g;
  private String h;
  private Drawable i;
  private Rect j = new Rect(0, 0, 0, 0);
  private Rect k = new Rect();
  private float[] l = { -1.0F, -1.0F };
  private boolean m;

  public AvatarWithInitialsView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public AvatarWithInitialsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public AvatarWithInitialsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private Paint a(Context paramContext, Resources paramResources, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AvatarWithInitialsView);
    try
    {
      int n = localTypedArray.getInt(R.styleable.AvatarWithInitialsView_initialsTextColor, dc.d(paramContext, R.attr.contactInitialsTextColor));
      float f1 = localTypedArray.getDimension(R.styleable.AvatarWithInitialsView_initialsTextSize, paramResources.getDimension(R.dimen.initals_text_size_default));
      this.i = new ShapeDrawable(new d(localTypedArray.getColor(R.styleable.AvatarWithInitialsView_initialsBackgroundTint, dc.d(paramContext, R.attr.contactInitialsBackgroundTint))));
      localTypedArray.recycle();
      String str = String.valueOf(n) + "/" + String.valueOf(f1);
      Paint localPaint = (Paint)d.get(str);
      if (localPaint == null)
      {
        localPaint = new Paint(1);
        localPaint.setColor(n);
        localPaint.setTextSize(f1);
        localPaint.setTypeface(Typeface.create("sans-serif-light", 0));
        d.put(str, localPaint);
      }
      return localPaint;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (isInEditMode())
      return;
    this.e = a(paramContext, getResources(), paramAttributeSet);
  }

  private void setShowInitials(boolean paramBoolean)
  {
    if (this.f != paramBoolean)
      this.f = paramBoolean;
  }

  public void a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof b))
      this.g = ((b)paramDrawable).f();
    super.a(paramDrawable);
  }

  public void a(String paramString, boolean paramBoolean)
  {
    if ((this.f != paramBoolean) || (da.a(this.h)) || (!this.h.equals(paramString)))
    {
      setShowInitials(paramBoolean);
      this.h = paramString;
      if ((!this.f) || (da.a(this.h)) || (!this.g))
        break label96;
      this.l = j.a(this.l, this.h, this.e, this.k);
    }
    label96: for (this.m = true; ; this.m = false)
    {
      invalidate();
      return;
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.f) && (!da.a(this.h)) && (this.g))
    {
      if (!this.m)
        break label75;
      j.a(paramCanvas, this.h, this.l[0], this.l[1], this.j, this.e, this.i);
    }
    while (true)
    {
      a(paramCanvas);
      return;
      label75: j.a(paramCanvas, this.h, this.j, this.e, this.i, this.k);
    }
  }

  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.j.set(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.AvatarWithInitialsView
 * JD-Core Version:    0.6.2
 */
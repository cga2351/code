package com.viber.voip.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.viber.common.d.c;
import com.viber.common.ui.ShapeImageView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.styleable;
import com.viber.voip.util.e.j;

public class AvatarWithCaptionView extends ShapeImageView
{
  private Drawable d;
  private Paint e;
  private int f;
  private float g;
  private ColorStateList h;
  private boolean i;
  private boolean j;
  private boolean k;
  private String l;
  private String[] m;
  private float n;
  private Rect o;

  public AvatarWithCaptionView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public AvatarWithCaptionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public AvatarWithCaptionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a()
  {
    this.m = this.l.split(" ");
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AvatarWithCaptionView);
    float f1 = getResources().getDimension(R.dimen.default_caption_text_size);
    while (true)
    {
      try
      {
        this.l = localTypedArray.getString(R.styleable.AvatarWithCaptionView_caption);
        a();
        this.i = localTypedArray.getBoolean(R.styleable.AvatarWithCaptionView_captionVisible, false);
        this.g = localTypedArray.getDimension(R.styleable.AvatarWithCaptionView_captionTextSize, f1);
        this.h = localTypedArray.getColorStateList(R.styleable.AvatarWithCaptionView_captionTextColor);
        this.j = localTypedArray.getBoolean(R.styleable.AvatarWithCaptionView_mandatory, false);
        localTypedArray.recycle();
        this.n = j.a(paramContext, 5.0F);
        this.k = c.a();
        ColorStateList localColorStateList = this.h;
        i1 = 0;
        if (localColorStateList == null)
        {
          this.f = i1;
          this.e = new Paint(1);
          this.e.setTextSize(this.g);
          this.e.setTextAlign(Paint.Align.CENTER);
          this.d = getResources().getDrawable(R.drawable.transparent_bitmap);
          return;
        }
      }
      finally
      {
        localTypedArray.recycle();
      }
      int i1 = this.h.getDefaultColor();
    }
  }

  private void b()
  {
    int i1 = 0;
    Drawable localDrawable = getDrawable();
    if (localDrawable == null)
      return;
    Drawable[] arrayOfDrawable = new Drawable[2];
    arrayOfDrawable[0] = localDrawable;
    arrayOfDrawable[1] = this.d;
    LayerDrawable localLayerDrawable = new LayerDrawable(arrayOfDrawable);
    while (i1 < localLayerDrawable.getNumberOfLayers())
    {
      localLayerDrawable.setId(i1, i1);
      i1++;
    }
    setImageDrawable(localLayerDrawable);
  }

  private void c(Canvas paramCanvas)
  {
    int i1 = 1;
    int i2 = 0;
    this.e.setColor(this.f);
    String[] arrayOfString = this.m;
    int i3 = arrayOfString.length;
    Object localObject1 = "";
    int i4 = arrayOfString.length;
    int i5 = 0;
    Object localObject2;
    if (i5 < i4)
    {
      localObject2 = arrayOfString[i5];
      if (((String)localObject1).length() >= ((String)localObject2).length())
        break label466;
    }
    while (true)
    {
      i5++;
      localObject1 = localObject2;
      break;
      if ((i3 == i1) || (((String)localObject1).equals(arrayOfString[(i3 - 1)])));
      for (int i6 = i1; ; i6 = 0)
      {
        if ((this.j) && (i6 != 0))
          localObject1 = (String)localObject1 + " *";
        int i7 = j.a(1.0F);
        while (this.e.measureText((String)localObject1) > this.o.width())
        {
          this.g -= i7;
          this.e.setTextSize(this.g);
        }
      }
      int i8;
      label225: float f2;
      float f3;
      if (i3 % 2 == 0)
      {
        i8 = i1;
        float f1 = this.o.height() / 2;
        int i9 = i3 / 2;
        if (i8 == 0)
          break label350;
        f2 = f1 - (i9 - i1) * (this.g + this.n) - (this.e.descent() + this.e.ascent() / 2.0F);
        if (i8 == 0)
          break label457;
        f3 = f2 - (this.g / 2.0F + this.n / 2.0F);
      }
      while (true)
      {
        if (i2 < i3)
        {
          paramCanvas.drawText(arrayOfString[i2], this.o.width() / 2, f3, this.e);
          if (i2 < i3 - 1)
            f3 += this.g + this.n;
          i2++;
          continue;
          i8 = 0;
          break;
          label350: i1 = 0;
          break label225;
        }
        float f4;
        float f6;
        if (this.j)
        {
          String str = arrayOfString[(i3 - 1)];
          f4 = this.e.measureText(str);
          if (!this.k)
            break label437;
          f6 = this.e.measureText(" *");
        }
        label437: for (float f5 = this.o.width() / 2 - f4 / 2.0F - f6 / 2.0F; ; f5 = this.o.width() / 2 + f4 / 2.0F)
        {
          paramCanvas.drawText(" *", f5, f3, this.e);
          return;
        }
        label457: f3 = f2;
        i2 = 0;
      }
      label466: localObject2 = localObject1;
    }
  }

  public String getCaption()
  {
    return this.l;
  }

  public int getCaptionTextColor()
  {
    return this.f;
  }

  public float getCaptionTextSize()
  {
    return this.g;
  }

  public boolean getCaptionVisibility()
  {
    return this.i;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.i) && (!TextUtils.isEmpty(getCaption())))
      c(paramCanvas);
  }

  public void setCaption(String paramString)
  {
    if ((this.l != null) && (!this.l.equals(paramString)))
    {
      this.l = paramString;
      a();
      invalidate();
    }
  }

  public void setCaptionTextColor(int paramInt)
  {
    this.h = null;
    this.f = paramInt;
  }

  public void setCaptionTextColor(ColorStateList paramColorStateList)
  {
    this.h = paramColorStateList;
    this.f = this.h.getDefaultColor();
  }

  public void setCaptionTextSize(float paramFloat)
  {
    this.g = paramFloat;
  }

  public void setCaptionVisibility(boolean paramBoolean)
  {
    if (this.i != paramBoolean)
    {
      this.i = paramBoolean;
      invalidate();
    }
  }

  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.o = new Rect(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setIsMandatory(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  public void setOverlayDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.d = paramDrawable;
      b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.AvatarWithCaptionView
 * JD-Core Version:    0.6.2
 */
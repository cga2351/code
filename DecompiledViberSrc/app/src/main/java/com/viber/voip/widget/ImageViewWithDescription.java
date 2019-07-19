package com.viber.voip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Space;
import com.viber.common.ui.b.b;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.styleable;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.j;

public class ImageViewWithDescription extends ViewWithDescription
{
  private RelativeLayout e;
  private RelativeLayout.LayoutParams f;
  private RelativeLayout.LayoutParams g;
  private RelativeLayout.LayoutParams h;
  private RelativeLayout.LayoutParams i;
  private AvatarWithInitialsView j;
  private ViberTextView k;
  private b.b l;
  private float m;
  private float n;
  private float o;
  private float p;
  private e q;
  private f r;
  private Drawable s;

  public ImageViewWithDescription(Context paramContext)
  {
    super(paramContext);
  }

  public ImageViewWithDescription(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ImageViewWithDescription(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    if (!isInEditMode())
    {
      this.q = e.a(paramContext);
      this.r = f.b(paramContext);
    }
  }

  protected View b(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ImageViewWithDescription);
    while (true)
    {
      try
      {
        int i1 = localTypedArray.getInt(R.styleable.ImageViewWithDescription_imageShape, b.b.a.ordinal());
        this.l = b.b.values()[i1];
        this.m = localTypedArray.getDimension(R.styleable.ImageViewWithDescription_imageCornerRadius, 0.0F);
        this.n = localTypedArray.getDimension(R.styleable.ImageViewWithDescription_imageBottomMargin, 0.0F);
        this.o = localTypedArray.getDimension(R.styleable.ImageViewWithDescription_imageLeftMargin, 0.0F);
        this.p = localTypedArray.getDimension(R.styleable.ImageViewWithDescription_imageSize, paramContext.getResources().getDimension(R.dimen.image_with_description_default_image_size));
        this.s = localTypedArray.getDrawable(R.styleable.ImageViewWithDescription_bgRes);
        localTypedArray.recycle();
        this.f = new RelativeLayout.LayoutParams(-1, -2);
        this.g = new RelativeLayout.LayoutParams((int)this.p, (int)this.p);
        this.i = new RelativeLayout.LayoutParams(-1, (int)this.n);
        if (b())
        {
          this.g.rightMargin = ((int)this.o);
          this.h = new RelativeLayout.LayoutParams(-2, -2);
          this.h.addRule(15);
          RelativeLayout.LayoutParams localLayoutParams = this.h;
          if (!b())
            break label524;
          i2 = 0;
          localLayoutParams.addRule(i2, R.id.body_image);
          this.i.addRule(3, R.id.body_image);
          this.e = new RelativeLayout(paramContext);
          this.e.setLayoutParams(this.f);
          RelativeLayout localRelativeLayout = this.e;
          if (this.s != null)
            break label530;
          localDrawable = paramContext.getResources().getDrawable(R.drawable.edit_text_underline_1px);
          dj.a(localRelativeLayout, localDrawable);
          this.j = new AvatarWithInitialsView(paramContext);
          this.j.setLayoutParams(this.g);
          this.j.setShape(this.l);
          this.j.setCornerRadius(this.m);
          this.j.setId(R.id.body_image);
          this.k = new ViberTextView(paramContext);
          this.k.setLayoutParams(this.h);
          this.k.setTextColor(paramContext.getResources().getColor(R.color.main_text));
          this.k.setTextSize(1, 16.0F);
          if (!b())
            break label539;
          i3 = 0;
          if (!b())
            break label550;
          i4 = j.a(paramContext, 10.0F);
          this.k.setPadding(i3, 0, i4, 0);
          Space localSpace = new Space(paramContext);
          localSpace.setLayoutParams(this.i);
          this.e.addView(this.j);
          this.e.addView(this.k);
          this.e.addView(localSpace);
          this.e.setGravity(16);
          return this.e;
        }
      }
      finally
      {
        localTypedArray.recycle();
      }
      this.g.leftMargin = ((int)this.o);
      continue;
      label524: int i2 = 1;
      continue;
      label530: Drawable localDrawable = this.s;
      continue;
      label539: int i3 = j.a(paramContext, 10.0F);
      continue;
      label550: int i4 = 0;
    }
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.j.setImageBitmap(paramBitmap);
    invalidate();
  }

  public void setImageShape(b.b paramb)
  {
    this.j.setShape(paramb);
  }

  public void setImageUri(Uri paramUri)
  {
    this.q.a(paramUri, this.j, this.r);
  }

  public void setText(String paramString)
  {
    this.k.setText(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ImageViewWithDescription
 * JD-Core Version:    0.6.2
 */
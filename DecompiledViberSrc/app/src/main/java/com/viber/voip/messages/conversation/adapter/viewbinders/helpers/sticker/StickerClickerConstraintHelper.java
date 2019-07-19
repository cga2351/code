package com.viber.voip.messages.conversation.adapter.viewbinders.helpers.sticker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.a;
import android.support.constraint.a.a.c.c;
import android.support.constraint.a.a.d;
import android.util.AttributeSet;
import android.view.View;
import com.viber.voip.R.dimen;
import com.viber.voip.R.styleable;
import com.viber.voip.stickers.entity.Sticker;

public class StickerClickerConstraintHelper extends a
{
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;

  public StickerClickerConstraintHelper(Context paramContext)
  {
    super(paramContext);
    setup(null);
  }

  public StickerClickerConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setup(paramAttributeSet);
  }

  public StickerClickerConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setup(paramAttributeSet);
  }

  private void a(d paramd1, d paramd2, d paramd3)
  {
    paramd1.G();
    paramd1.a(c.c.c, paramd3, c.c.c);
    paramd1.a(c.c.e, paramd3, c.c.e);
    if (this.i == 1)
    {
      paramd1.a(c.c.d, paramd2, c.c.b, this.l);
      return;
    }
    paramd1.a(c.c.b, paramd2, c.c.d, this.l);
  }

  private void b(d paramd1, d paramd2, d paramd3)
  {
    paramd2.G();
    paramd2.a(c.c.e, paramd1, c.c.e, this.k);
    if (this.i == 1)
    {
      paramd2.a(c.c.d, paramd3, c.c.b, this.j);
      return;
    }
    paramd2.a(c.c.b, paramd3, c.c.d, this.j);
  }

  private boolean b()
  {
    return (this.f != -1) && (this.g != -1) && (this.h != -1);
  }

  private void setup(AttributeSet paramAttributeSet)
  {
    Context localContext = getContext();
    TypedArray localTypedArray = localContext.obtainStyledAttributes(paramAttributeSet, R.styleable.StickerClickerConstraintHelper);
    try
    {
      this.f = localTypedArray.getResourceId(R.styleable.StickerClickerConstraintHelper_offerClickerViewId, -1);
      this.g = localTypedArray.getResourceId(R.styleable.StickerClickerConstraintHelper_likeViewId, -1);
      this.h = localTypedArray.getResourceId(R.styleable.StickerClickerConstraintHelper_stickerViewId, -1);
      this.i = localTypedArray.getInt(R.styleable.StickerClickerConstraintHelper_messageType, 0);
      localTypedArray.recycle();
      Resources localResources = localContext.getResources();
      this.j = localResources.getDimensionPixelOffset(R.dimen.clicker_for_big_sticker_horizontal_padding);
      this.k = localResources.getDimensionPixelOffset(R.dimen.clicker_for_big_sticker_bottom_padding);
      this.l = localResources.getDimensionPixelOffset(R.dimen.clicker_for_small_sticker_horizontal_padding);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public void c(ConstraintLayout paramConstraintLayout)
  {
    super.c(paramConstraintLayout);
    if (!b())
      return;
    Sticker localSticker = (Sticker)getTag();
    if ((localSticker != null) && ((localSticker.getRowSpan() <= 1) || (localSticker.getColSpan() <= 1)));
    d locald1;
    d locald3;
    for (int m = 1; ; m = 0)
    {
      View localView1 = paramConstraintLayout.a(this.f);
      View localView2 = paramConstraintLayout.a(this.g);
      View localView3 = paramConstraintLayout.a(this.h);
      locald1 = paramConstraintLayout.a(localView1);
      d locald2 = paramConstraintLayout.a(localView2);
      locald3 = paramConstraintLayout.a(localView3);
      if (m == 0)
        break;
      a(locald1, locald2, locald3);
      return;
    }
    b(paramConstraintLayout.a(paramConstraintLayout), locald1, locald3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.viewbinders.helpers.sticker.StickerClickerConstraintHelper
 * JD-Core Version:    0.6.2
 */
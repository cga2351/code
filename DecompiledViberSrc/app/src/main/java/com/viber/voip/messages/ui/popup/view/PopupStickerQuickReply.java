package com.viber.voip.messages.ui.popup.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;

public class PopupStickerQuickReply extends LinearLayout
  implements View.OnClickListener
{
  private static final Integer[] a;
  private static final Integer[] b = arrayOfInteger2;
  private a c;

  static
  {
    Integer[] arrayOfInteger1 = new Integer[5];
    arrayOfInteger1[0] = Integer.valueOf(R.drawable.sticker_hi);
    arrayOfInteger1[1] = Integer.valueOf(R.drawable.sticker_bye);
    arrayOfInteger1[2] = Integer.valueOf(R.drawable.sticker_yes);
    arrayOfInteger1[3] = Integer.valueOf(R.drawable.sticker_no);
    arrayOfInteger1[4] = Integer.valueOf(R.drawable.sticker_ok);
    a = arrayOfInteger1;
    Integer[] arrayOfInteger2 = new Integer[5];
    arrayOfInteger2[0] = Integer.valueOf(404);
    arrayOfInteger2[1] = Integer.valueOf(437);
    arrayOfInteger2[2] = Integer.valueOf(423);
    arrayOfInteger2[3] = Integer.valueOf(420);
    arrayOfInteger2[4] = Integer.valueOf(407);
  }

  public PopupStickerQuickReply(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public PopupStickerQuickReply(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  private View a(int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0F);
    localLayoutParams.gravity = 17;
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    localFrameLayout.setLayoutParams(localLayoutParams);
    ImageView localImageView = new ImageView(getContext());
    localImageView.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.pop_up_sticker_height), getResources().getDimensionPixelOffset(R.dimen.pop_up_sticker_height)));
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    if (paramInt1 != 0)
      localImageView.setImageResource(paramInt1);
    while (true)
    {
      localImageView.setTag(Integer.valueOf(paramInt2));
      localImageView.setOnClickListener(this);
      localFrameLayout.addView(localImageView);
      return localFrameLayout;
      localImageView.setImageDrawable(null);
    }
  }

  private void a()
  {
    if (isInEditMode());
    while (true)
    {
      return;
      setWeightSum(a.length);
      for (int i = 0; i < a.length; i++)
        addView(a(a[i].intValue(), b[i].intValue()));
    }
  }

  public void onClick(View paramView)
  {
    if (this.c != null)
      this.c.a(((Integer)paramView.getTag()).intValue());
  }

  public void setStickerSelectListener(a parama)
  {
    this.c = parama;
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.popup.view.PopupStickerQuickReply
 * JD-Core Version:    0.6.2
 */
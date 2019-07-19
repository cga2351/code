package com.viber.voip.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.styleable;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.ViberTextView;

public class TextWithDescriptionAndActionView extends ViewWithDescription
  implements View.OnClickListener
{
  private static final Logger e = ViberEnv.getLogger();
  private int f;
  private TextView g;
  private TextView h;
  private View.OnClickListener i;

  public TextWithDescriptionAndActionView(Context paramContext)
  {
    super(paramContext);
  }

  public TextWithDescriptionAndActionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public TextWithDescriptionAndActionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected TextView a()
  {
    return null;
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    if (!b())
      this.g.setGravity(3);
  }

  public void a(ViewWithDescription.a parama, CharSequence paramCharSequence)
  {
  }

  protected View b(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.g = new ViberTextView(paramContext);
    int j;
    if (b())
      j = this.c[2];
    while (true)
    {
      int k;
      label41: TypedArray localTypedArray;
      if (b())
      {
        k = this.c[0];
        this.g.setPadding(j, this.c[1], k, this.c[3]);
        localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TextWithDescriptionAndActionView);
        if (localTypedArray == null);
      }
      try
      {
        this.g.setText(localTypedArray.getString(R.styleable.TextWithDescriptionAndActionView_android_text));
        this.g.setTextSize(0, localTypedArray.getDimensionPixelSize(R.styleable.TextWithDescriptionAndActionView_android_textSize, 0));
        ColorStateList localColorStateList = localTypedArray.getColorStateList(R.styleable.TextWithDescriptionAndActionView_android_textColor);
        if (localColorStateList != null)
          this.g.setTextColor(localColorStateList);
        return this.g;
        j = this.c[0];
        continue;
        k = this.c[2];
        break label41;
      }
      finally
      {
        localTypedArray.recycle();
      }
    }
  }

  protected TextView c(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray;
    if (this.h == null)
    {
      this.h = new ViberTextView(paramContext);
      this.h.setId(R.id.view_with_description_action_view_id);
      this.h.setAllCaps(true);
      this.h.setOnClickListener(this);
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TextWithDescriptionAndActionView);
      if (localTypedArray == null);
    }
    try
    {
      this.h.setText(localTypedArray.getString(R.styleable.TextWithDescriptionAndActionView_actionText));
      this.h.setTextSize(0, localTypedArray.getDimensionPixelSize(R.styleable.TextWithDescriptionAndActionView_actionTextSize, 0));
      ColorStateList localColorStateList = localTypedArray.getColorStateList(R.styleable.TextWithDescriptionAndActionView_actionTextColor);
      if (localColorStateList != null)
        this.h.setTextColor(localColorStateList);
      int j = localTypedArray.getDimensionPixelSize(R.styleable.TextWithDescriptionAndActionView_actionLeftPadding, 0);
      int k;
      if (j > 0)
      {
        if (!b())
          break label199;
        k = 0;
        if (!b())
          break label206;
      }
      while (true)
      {
        this.h.setPadding(k, 0, j, 0);
        this.f = localTypedArray.getInt(R.styleable.TextWithDescriptionAndActionView_actionVerticalPosition, 1);
        int m = localTypedArray.getResourceId(R.styleable.TextWithDescriptionAndActionView_actionId, 0);
        if (m != 0)
          setActionId(m);
        return this.h;
        label199: k = j;
        break;
        label206: j = 0;
      }
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  protected int getActionViewVerticalGravity()
  {
    switch (this.f)
    {
    case 1:
    default:
      return 15;
    case 0:
      return 10;
    case 2:
    }
    return 12;
  }

  public void onClick(View paramView)
  {
    if (this.i != null)
      this.i.onClick(this.h);
  }

  public void setActionClickListener(View.OnClickListener paramOnClickListener)
  {
    this.i = paramOnClickListener;
  }

  public void setActionId(int paramInt)
  {
    this.h.setTag(R.id.action_view_tag_id, Integer.valueOf(paramInt));
  }

  public void setActionText(int paramInt)
  {
    this.h.setText(paramInt);
  }

  public void setGravity(int paramInt)
  {
    this.g.setGravity(paramInt);
  }

  public void setText(int paramInt)
  {
    this.g.setText(paramInt);
  }

  public void setText(CharSequence paramCharSequence)
  {
    this.g.setText(paramCharSequence);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.TextWithDescriptionAndActionView
 * JD-Core Version:    0.6.2
 */
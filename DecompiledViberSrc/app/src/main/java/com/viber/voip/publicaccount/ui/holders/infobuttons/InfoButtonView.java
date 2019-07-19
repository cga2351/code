package com.viber.voip.publicaccount.ui.holders.infobuttons;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.viber.voip.R.color;
import com.viber.voip.R.id;
import com.viber.voip.R.integer;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

public class InfoButtonView extends LinearLayout
{
  private ImageView a;
  private TextView b;

  public InfoButtonView(Context paramContext)
  {
    super(paramContext);
  }

  public InfoButtonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public InfoButtonView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    localMarginLayoutParams.leftMargin = paramInt1;
    localMarginLayoutParams.topMargin = paramInt2;
    localMarginLayoutParams.rightMargin = paramInt3;
    localMarginLayoutParams.bottomMargin = paramInt4;
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(this.a, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void a(Uri paramUri, e parame, f paramf)
  {
    parame.a(paramUri, this.a, paramf);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(this.b, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ImageView)findViewById(R.id.icon));
    this.b = ((TextView)findViewById(R.id.text));
  }

  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    ImageView localImageView = this.a;
    Resources localResources1 = getResources();
    int i;
    TextView localTextView;
    Resources localResources2;
    if (paramBoolean)
    {
      i = R.integer.not_transparent_color;
      dj.a(localImageView, localResources1.getInteger(i));
      localTextView = this.b;
      localResources2 = getResources();
      if (!paramBoolean)
        break label76;
    }
    label76: for (int j = R.color.sub_text; ; j = R.color.sub_text_50)
    {
      localTextView.setTextColor(localResources2.getColor(j));
      return;
      i = R.integer.semi_transparent_color;
      break;
    }
  }

  public void setIcon(int paramInt)
  {
    this.a.setImageResource(paramInt);
  }

  public void setText(int paramInt)
  {
    this.b.setText(paramInt);
  }

  public void setText(String paramString)
  {
    this.b.setText(paramString);
  }

  public void setTextColor(int paramInt)
  {
    this.b.setTextColor(paramInt);
  }

  public void setTextSize(float paramFloat)
  {
    this.b.setTextSize(0, paramFloat);
  }

  public void setTextUnderlined(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setPaintFlags(0x8 | this.b.getPaintFlags());
      return;
    }
    this.b.setPaintFlags(0xFFFFFFF7 & this.b.getPaintFlags());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.infobuttons.InfoButtonView
 * JD-Core Version:    0.6.2
 */
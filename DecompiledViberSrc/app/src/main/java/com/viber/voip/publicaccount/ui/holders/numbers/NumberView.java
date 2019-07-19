package com.viber.voip.publicaccount.ui.holders.numbers;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

public class NumberView extends RelativeLayout
{
  private ImageView a;
  private TextView b;

  public NumberView(Context paramContext)
  {
    super(paramContext);
  }

  public NumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public NumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void a(Uri paramUri, e parame, f paramf)
  {
    parame.a(paramUri, this.a, paramf);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.a = ((ImageView)findViewById(R.id.icon));
    this.b = ((TextView)findViewById(R.id.text));
  }

  public void setIcon(int paramInt)
  {
    this.a.setImageResource(paramInt);
  }

  public void setText(String paramString)
  {
    this.b.setText(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.numbers.NumberView
 * JD-Core Version:    0.6.2
 */
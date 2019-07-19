package com.viber.voip.widget;

import android.content.res.ColorStateList;
import android.support.v4.widget.ImageViewCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.id;

public class aj
{
  private View a;
  private ImageView b;
  private TextView c;

  public aj(View paramView)
  {
    this.a = paramView.findViewById(R.id.toolbar_action);
    this.b = ((ImageView)paramView.findViewById(R.id.toolbar_action_icon));
    this.c = ((TextView)paramView.findViewById(R.id.toolbar_action_title));
  }

  public void a(int paramInt)
  {
    this.b.setImageResource(paramInt);
  }

  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }

  public void a(String paramString)
  {
    this.c.setText(paramString);
  }

  public void a(boolean paramBoolean)
  {
    this.a.setEnabled(paramBoolean);
    this.a.setClickable(paramBoolean);
    this.b.setEnabled(paramBoolean);
    this.c.setEnabled(paramBoolean);
  }

  public void b(int paramInt)
  {
    ImageViewCompat.setImageTintList(this.b, ColorStateList.valueOf(paramInt));
  }

  public void c(int paramInt)
  {
    this.c.setText(paramInt);
  }

  public void d(int paramInt)
  {
    this.c.setTextColor(paramInt);
  }

  public void e(int paramInt)
  {
    this.c.setTypeface(null, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.aj
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.viber.voip.R.id;

public abstract class c extends RelativeLayout
{
  protected ImageView a;
  protected TextView b;
  protected TextView c;

  public c(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public c(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  protected void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(getLayoutId(), this, true);
    this.a = ((ImageView)findViewById(R.id.image));
    this.b = ((TextView)findViewById(R.id.text));
    this.c = ((TextView)findViewById(R.id.subtext));
  }

  protected abstract int getLayoutId();

  public void setImage(Drawable paramDrawable)
  {
    this.a.setImageDrawable(paramDrawable);
  }

  public abstract void setNew(boolean paramBoolean);

  public void setSubtext(CharSequence paramCharSequence)
  {
    this.c.setText(paramCharSequence);
  }

  public void setText(CharSequence paramCharSequence)
  {
    this.b.setText(paramCharSequence);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.c
 * JD-Core Version:    0.6.2
 */
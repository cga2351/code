package com.viber.voip.messages.extras.map;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;

public class BalloonView extends LinearLayout
{
  private View a;
  private TextView b;
  private TextView c;
  private ProgressBar d;

  public BalloonView(Context paramContext)
  {
    super(paramContext);
    setupView(paramContext);
  }

  public BalloonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setupView(paramContext);
  }

  public BalloonView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setupView(paramContext);
  }

  public BalloonView a(b.f paramf)
  {
    if (!TextUtils.isEmpty(paramf.f()))
    {
      this.b.setText(paramf.f());
      this.b.setVisibility(0);
      this.d.setVisibility(4);
      if (!TextUtils.isEmpty(paramf.e()))
      {
        this.c.setText(paramf.e());
        this.c.setVisibility(0);
        return this;
      }
      this.c.setVisibility(8);
      return this;
    }
    this.b.setVisibility(4);
    this.d.setVisibility(0);
    return this;
  }

  protected void setupView(Context paramContext)
  {
    this.a = LayoutInflater.from(paramContext).inflate(R.layout.balloon_overlay, this, false);
    this.a.setPadding(0, 0, 0, 0);
    this.b = ((TextView)this.a.findViewById(R.id.balloon_item_title));
    this.c = ((TextView)this.a.findViewById(R.id.balloon_item_snippet));
    this.d = ((ProgressBar)this.a.findViewById(R.id.balloon_loading));
    addView(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extras.map.BalloonView
 * JD-Core Version:    0.6.2
 */
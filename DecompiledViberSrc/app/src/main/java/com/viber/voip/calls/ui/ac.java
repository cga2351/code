package com.viber.voip.calls.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.ui.h.f;
import com.viber.voip.util.dj;

public abstract class ac<M, I extends View> extends f<M>
  implements View.OnClickListener
{
  private a<M> a;
  private String b;
  private boolean c;
  public final View d;
  public final I e;
  public final TextView f;
  public final ImageButton g;
  public final ImageButton h;

  public ac(View paramView)
  {
    super(paramView);
    this.d = paramView.findViewById(R.id.root);
    this.e = paramView.findViewById(R.id.iconView);
    this.e.setTag(this);
    this.f = ((TextView)paramView.findViewById(R.id.nameView));
    this.g = ((ImageButton)paramView.findViewById(R.id.callButtonView));
    this.g.setTag(this);
    this.g.setOnClickListener(this);
    this.h = ((ImageButton)paramView.findViewById(R.id.videoCallButtonView));
    if (this.h != null)
    {
      this.h.setTag(this);
      this.h.setOnClickListener(this);
    }
    Resources localResources = paramView.getResources();
    dj.a(this.g, localResources.getDimensionPixelOffset(R.dimen.small_button_touch_area));
  }

  public void a(a<M> parama)
  {
    this.a = parama;
  }

  protected void b(String paramString)
  {
    this.b = paramString;
  }

  protected void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public String c()
  {
    return this.b;
  }

  public void c(boolean paramBoolean)
  {
    if (this.g != null)
      this.g.setEnabled(paramBoolean);
  }

  public void d(boolean paramBoolean)
  {
    if (this.h != null)
      dj.b(this.h, paramBoolean);
  }

  public boolean d()
  {
    return this.c;
  }

  public void onClick(View paramView)
  {
    if (R.id.callButtonView == paramView.getId())
      this.a.b(paramView, e());
    while (R.id.videoCallButtonView != paramView.getId())
      return;
    this.a.a(paramView, e());
  }

  public static abstract interface a<M>
  {
    public abstract void a(View paramView, M paramM);

    public abstract void b(View paramView, M paramM);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.ac
 * JD-Core Version:    0.6.2
 */
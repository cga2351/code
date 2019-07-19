package com.viber.voip.contacts.ui;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.model.c;
import com.viber.voip.widget.AvatarWithInitialsView;

public class m
{
  private c a;
  public final View q;
  public final AvatarWithInitialsView r;
  public final TextView s;

  public m(View paramView)
  {
    this.q = paramView;
    this.r = ((AvatarWithInitialsView)this.q.findViewById(R.id.icon));
    this.s = ((TextView)this.q.findViewById(R.id.name));
  }

  public c a()
  {
    return this.a;
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.q.getLayoutParams();
    localMarginLayoutParams.width = paramInt1;
    localMarginLayoutParams.height = paramInt1;
    localMarginLayoutParams.setMargins(paramInt2, paramInt3, paramInt2, paramInt3);
    this.q.setLayoutParams(localMarginLayoutParams);
    this.s.setTextSize(0, paramInt4);
  }

  public void a(c paramc)
  {
    this.a = paramc;
  }

  public String toString()
  {
    return "ContactWrapper{contact=" + this.a + ", contactBadge=" + this.r + ", name=" + this.s + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.m
 * JD-Core Version:    0.6.2
 */
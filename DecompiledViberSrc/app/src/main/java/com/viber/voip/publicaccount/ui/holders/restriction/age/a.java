package com.viber.voip.publicaccount.ui.holders.restriction.age;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder;

public class a extends PublicAccountEditUIHolder<AgeRestrictionData, b>
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private final boolean c;

  public a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  private void a(boolean paramBoolean)
  {
    if (((AgeRestrictionData)this.a).mIsAgeRestricted != paramBoolean)
    {
      ((AgeRestrictionData)this.a).mIsAgeRestricted = paramBoolean;
      ((b)this.b).a(paramBoolean);
    }
  }

  protected void a(AgeRestrictionData paramAgeRestrictionData, b paramb)
  {
  }

  protected void a(b paramb, AgeRestrictionData paramAgeRestrictionData)
  {
    ((b)this.b).a(paramAgeRestrictionData.mIsAgeRestricted);
  }

  protected Class<b> b()
  {
    return b.class;
  }

  protected b c(View paramView)
  {
    c localc = new c(paramView);
    if (this.c)
      localc.a(this, this);
    return localc;
  }

  protected AgeRestrictionData e()
  {
    return new AgeRestrictionData();
  }

  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    a(paramBoolean);
  }

  public void onClick(View paramView)
  {
    if (!((AgeRestrictionData)this.a).mIsAgeRestricted);
    for (boolean bool = true; ; bool = false)
    {
      a(bool);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.restriction.age.a
 * JD-Core Version:    0.6.2
 */
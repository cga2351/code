package com.viber.voip.publicaccount.ui.holders.numbers;

import android.view.View;
import com.viber.voip.publicaccount.d.d;

public class a extends com.viber.voip.publicaccount.ui.holders.b<NumbersData, b>
{
  protected void a(b paramb, NumbersData paramNumbersData)
  {
    boolean bool1 = d.q.a(((NumbersData)this.a).mRole, ((NumbersData)this.a).mPublicGroupType);
    boolean bool2 = d.r.a(((NumbersData)this.a).mRole, ((NumbersData)this.a).mPublicGroupType);
    if (bool1)
      ((b)this.b).a(((NumbersData)this.a).mFollowersCount);
    if (bool2)
      ((b)this.b).b(((NumbersData)this.a).mSubscribersCount);
    boolean bool3 = d.A.a(((NumbersData)this.a).mRole, ((NumbersData)this.a).mPublicGroupType);
    b localb = (b)this.b;
    if ((bool3) && (paramNumbersData.mHasMedia));
    for (boolean bool4 = true; ; bool4 = false)
    {
      localb.a(bool1, bool2, bool4);
      return;
    }
  }

  protected Class<b> b()
  {
    return b.class;
  }

  protected b c(View paramView)
  {
    return new c(paramView);
  }

  protected NumbersData e()
  {
    return new NumbersData();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.numbers.a
 * JD-Core Version:    0.6.2
 */
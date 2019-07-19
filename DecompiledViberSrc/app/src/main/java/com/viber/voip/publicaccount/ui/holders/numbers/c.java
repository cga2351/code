package com.viber.voip.publicaccount.ui.holders.numbers;

import android.content.res.Resources;
import android.view.View;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.util.dj;
import java.text.NumberFormat;

class c
  implements b
{
  private final NumberView a;
  private final NumberView b;
  private final View c;
  private final View d;

  public c(View paramView)
  {
    this.a = ((NumberView)paramView.findViewById(R.id.followers_number));
    this.a.setIcon(R.drawable.ic_pa_info_followers_number);
    this.b = ((NumberView)paramView.findViewById(R.id.subscribers_number));
    this.b.setIcon(R.drawable.ic_pa_info_subscribers_number);
    this.c = paramView.findViewById(R.id.numbers_divider);
    this.d = paramView.findViewById(R.id.shadow_divider);
  }

  public void a()
  {
  }

  public void a(int paramInt)
  {
    Resources localResources = this.a.getResources();
    if (paramInt > 0)
    {
      String str = NumberFormat.getIntegerInstance().format(paramInt);
      NumberView localNumberView = this.a;
      if (paramInt == 1);
      for (int i = R.string.public_account_info_followers_count_1; ; i = R.string.public_account_info_followers_count_n)
      {
        localNumberView.setText(localResources.getString(i, new Object[] { str }));
        return;
      }
    }
    this.a.setText(localResources.getString(R.string.public_account_info_followers_count_0));
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool1 = true;
    dj.b(this.a, paramBoolean1);
    dj.b(this.b, paramBoolean2);
    View localView1 = this.c;
    boolean bool2;
    View localView2;
    if ((paramBoolean1) && (paramBoolean2))
    {
      bool2 = bool1;
      dj.b(localView1, bool2);
      localView2 = this.d;
      if (paramBoolean3)
        break label99;
      View[] arrayOfView = new View[2];
      arrayOfView[0] = this.a;
      arrayOfView[bool1] = this.b;
      if (!dj.a(arrayOfView))
        break label99;
    }
    while (true)
    {
      dj.b(localView2, bool1);
      return;
      bool2 = false;
      break;
      label99: bool1 = false;
    }
  }

  public void b(int paramInt)
  {
    Resources localResources = this.b.getResources();
    if (paramInt > 0)
    {
      String str = NumberFormat.getIntegerInstance().format(paramInt);
      NumberView localNumberView = this.b;
      if (paramInt == 1);
      for (int i = R.string.public_account_info_subscribers_count_1; ; i = R.string.public_account_info_subscribers_count_n)
      {
        localNumberView.setText(localResources.getString(i, new Object[] { str }));
        return;
      }
    }
    this.b.setText(localResources.getString(R.string.public_account_info_subscribers_count_0));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.numbers.c
 * JD-Core Version:    0.6.2
 */
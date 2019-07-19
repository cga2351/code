package com.viber.voip.publicaccount.ui.holders.storage;

import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.id;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.a;

class b
  implements PublicAccountEditUIHolder.a
{
  private final View a;

  public b(View paramView, View.OnClickListener paramOnClickListener)
  {
    this.a = paramView.findViewById(R.id.manage_storage_btn);
    this.a.setOnClickListener(paramOnClickListener);
  }

  public void a()
  {
    this.a.setOnClickListener(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.storage.b
 * JD-Core Version:    0.6.2
 */
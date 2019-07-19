package com.viber.voip.contacts.ui.list;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.viber.voip.R.id;
import com.viber.voip.util.dj;
import com.viber.voip.widget.ProgressBar;

class ad extends RecyclerView.ViewHolder
{
  public ProgressBar a;

  public ad(View paramView)
  {
    super(paramView);
    this.a = ((ProgressBar)paramView.findViewById(R.id.progress));
  }

  public void a(boolean paramBoolean)
  {
    dj.b(this.a, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.ad
 * JD-Core Version:    0.6.2
 */
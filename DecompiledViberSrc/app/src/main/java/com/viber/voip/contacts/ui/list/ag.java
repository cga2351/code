package com.viber.voip.contacts.ui.list;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;

class ag extends RecyclerView.ViewHolder
{
  TextView a;

  ag(View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView.findViewById(R.id.text));
  }

  void a(int paramInt)
  {
    TextView localTextView = this.a;
    Resources localResources = this.a.getResources();
    int i = R.string.members_count;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    localTextView.setText(localResources.getString(i, arrayOfObject));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.ag
 * JD-Core Version:    0.6.2
 */
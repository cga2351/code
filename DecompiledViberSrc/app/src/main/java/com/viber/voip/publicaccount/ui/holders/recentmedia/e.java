package com.viber.voip.publicaccount.ui.holders.recentmedia;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.g;
import com.viber.voip.widget.a.c;

class e
  implements View.OnClickListener, d
{
  private final View a;
  private c.a b;
  private a c;
  private View d;

  e(Context paramContext, View paramView, g paramg, b paramb, c.a parama, LayoutInflater paramLayoutInflater)
  {
    this.b = parama;
    this.a = paramView.findViewById(R.id.recent_media_root_view);
    this.d = paramView.findViewById(R.id.shadow_gallery_divider);
    this.a.findViewById(R.id.view_all_text).setOnClickListener(this);
    RecyclerView localRecyclerView = (RecyclerView)this.a.findViewById(R.id.recent_media_recycler_view);
    localRecyclerView.setNestedScrollingEnabled(false);
    this.c = new a(paramContext, paramb, paramg, paramContext.getResources().getDimensionPixelSize(R.dimen.public_account_info_recent_media_image_size), this.b, paramLayoutInflater);
    localRecyclerView.setAdapter(this.c);
    localRecyclerView.addItemDecoration(new c(paramContext.getResources().getDimensionPixelSize(R.dimen.public_account_info_recent_media_divider_size), false));
  }

  public void a()
  {
  }

  public void a(boolean paramBoolean)
  {
    dj.b(this.a, paramBoolean);
    dj.b(this.d, paramBoolean);
  }

  public void b()
  {
    this.c.notifyDataSetChanged();
  }

  public void onClick(View paramView)
  {
    if (R.id.view_all_text == paramView.getId())
      this.b.i();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.recentmedia.e
 * JD-Core Version:    0.6.2
 */
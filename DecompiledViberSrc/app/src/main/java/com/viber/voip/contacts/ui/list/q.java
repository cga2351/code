package com.viber.voip.contacts.ui.list;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.id;
import com.viber.voip.i.c.g;
import com.viber.voip.ui.h.g;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import java.util.List;

public class q extends c<GroupCallStartParticipantsPresenter>
  implements View.OnClickListener, p
{
  private e b;
  private RecyclerView c;
  private g d;
  private k e;
  private LayoutInflater f;

  protected q(GroupCallStartParticipantsPresenter paramGroupCallStartParticipantsPresenter, View paramView, Fragment paramFragment, e parame, com.viber.common.permission.c paramc)
  {
    super(paramGroupCallStartParticipantsPresenter, paramView, paramFragment, paramc, 144);
    this.b = parame;
    this.f = paramFragment.getLayoutInflater();
    View localView = paramView.findViewById(R.id.start_group_call_btn);
    localView.setOnClickListener(this);
    dj.b(localView, c.g.a.e());
    this.c = ((RecyclerView)paramView.findViewById(R.id.recycler_view));
    b();
  }

  private void b()
  {
    this.d = new g(this.f);
    this.e = new k();
    j localj = new j(this.mRootView.getContext(), this.e);
    com.viber.voip.util.e.f localf = com.viber.voip.util.e.f.b(this.mRootView.getContext());
    this.d.a(new o(localj, this.b, localf));
    this.d.a(this.e);
    this.c.setAdapter(this.d);
    this.c.addItemDecoration(new com.viber.voip.ui.h.c(this.d));
  }

  public void a(List<n> paramList)
  {
    this.e.a(paramList);
    this.d.notifyDataSetChanged();
  }

  public void onClick(View paramView)
  {
    if (R.id.start_group_call_btn == paramView.getId())
      a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.q
 * JD-Core Version:    0.6.2
 */
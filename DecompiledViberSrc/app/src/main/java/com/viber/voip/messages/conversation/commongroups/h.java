package com.viber.voip.messages.conversation.commongroups;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.viber.voip.R.id;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.m;
import com.viber.voip.mvp.core.d;
import com.viber.voip.util.e.e;
import dagger.a;

public class h extends d<CommonGroupsPresenter>
  implements b.b, g
{
  private final Activity a;
  private final b b;

  public h(CommonGroupsPresenter paramCommonGroupsPresenter, j paramj, a<com.viber.voip.messages.d.b> parama, e parame, Activity paramActivity, View paramView)
  {
    super(paramCommonGroupsPresenter, paramView);
    this.a = paramActivity;
    this.b = new b(paramActivity, paramj, parama, parame, paramActivity.getLayoutInflater(), this);
    ((RecyclerView)paramView.findViewById(R.id.common_groups_list)).setAdapter(this.b);
  }

  public void a()
  {
    this.b.notifyDataSetChanged();
  }

  public void a(f paramf)
  {
    ((CommonGroupsPresenter)this.mPresenter).a(paramf);
  }

  public void a(ConversationData paramConversationData)
  {
    Intent localIntent = m.a(paramConversationData, false);
    this.a.startActivity(localIntent);
    this.a.finish();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.commongroups.h
 * JD-Core Version:    0.6.2
 */
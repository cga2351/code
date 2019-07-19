package com.viber.voip.messages.conversation.community.c;

import android.app.Activity;
import android.view.View;
import com.viber.common.dialogs.i.a;
import com.viber.common.dialogs.m;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.view.b.a;
import com.viber.voip.report.community.CommunityReportPresenter;
import com.viber.voip.report.community.d;

public class c extends a<CommunityReportPresenter>
  implements com.viber.voip.report.community.c
{
  private final d a;

  public c(CommunityReportPresenter paramCommunityReportPresenter, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean)
  {
    super(paramCommunityReportPresenter, paramActivity, paramConversationFragment, paramView, paramBoolean);
    this.a = new d(paramConversationFragment, paramCommunityReportPresenter, paramView);
  }

  public void a()
  {
    this.a.a();
  }

  public void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }

  public void b()
  {
    this.a.b();
  }

  public void c()
  {
    this.a.c();
  }

  public void d()
  {
    this.a.d();
  }

  public boolean onDialogAction(m paramm, int paramInt)
  {
    return this.a.onDialogAction(paramm, paramInt);
  }

  public void onDialogDataListAction(m paramm, int paramInt, Object paramObject)
  {
    this.a.onDialogDataListAction(paramm, paramInt, paramObject);
  }

  public void onDialogDataListBind(m paramm, i.a parama)
  {
    this.a.onDialogDataListBind(paramm, parama);
  }

  public void onDialogShow(m paramm)
  {
    this.a.onDialogShow(paramm);
  }

  public void onPrepareDialogView(m paramm, View paramView, int paramInt)
  {
    this.a.onPrepareDialogView(paramm, paramView, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.community.c.c
 * JD-Core Version:    0.6.2
 */
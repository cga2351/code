package com.viber.voip.publicaccount.ui.holders.chatsolution.edit;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.z;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.s;
import com.viber.voip.messages.controller.publicaccount.d;
import com.viber.voip.publicaccount.entity.CrmItem;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;

public class a extends PublicAccountEditUIHolder<ChatSolutionData, b>
  implements View.OnClickListener, m.c, bv.s
{
  private Fragment c;
  private d d;
  private bv e;

  public a(Fragment paramFragment, d paramd, bv parambv)
  {
    this.c = paramFragment;
    this.d = paramd;
    this.e = parambv;
  }

  private void a(Context paramContext)
  {
    ViberActionRunner.aq.a(paramContext, ((ChatSolutionData)this.a).mPublicAccountId);
  }

  private void b(Context paramContext)
  {
    da.a(paramContext, ((ChatSolutionData)this.a).mAppKey, paramContext.getString(R.string.public_account_edit_copy_to_clipboard_toast_message));
  }

  private void f()
  {
    if ((((ChatSolutionData)this.a).mPublicAccountId != null) && (cj.a(true)))
    {
      this.d.e(((ChatSolutionData)this.a).mPublicAccountId);
      g();
    }
  }

  private void g()
  {
    ad.b().b(this.c);
    ((ChatSolutionData)this.a).mIsNewAppKeyPending = true;
  }

  private void h()
  {
    z.a(this.c, DialogCode.D_PROGRESS);
    ((ChatSolutionData)this.a).mIsNewAppKeyPending = false;
  }

  public void T_()
  {
    h();
  }

  public void a()
  {
    super.a();
    this.e.b(this);
  }

  public void a(View paramView)
  {
    super.a(paramView);
    this.e.a(this);
  }

  protected void a(ChatSolutionData paramChatSolutionData, b paramb)
  {
  }

  protected void a(b paramb, ChatSolutionData paramChatSolutionData)
  {
    if (((ChatSolutionData)this.a).mCrm == null)
      ((b)this.b).b();
    while (true)
    {
      ((b)this.b).a(((ChatSolutionData)this.a).mAppKey);
      if (((ChatSolutionData)this.a).mIsNewAppKeyPending)
      {
        if ((((ChatSolutionData)this.a).mPublicAccountId == null) || (!this.d.f(((ChatSolutionData)this.a).mPublicAccountId)))
          break;
        g();
      }
      return;
      ((b)this.b).a(((ChatSolutionData)this.a).mCrm.getName(), ((ChatSolutionData)this.a).mAppKey);
    }
    h();
  }

  protected Class<b> b()
  {
    return b.class;
  }

  protected b c(View paramView)
  {
    c localc = new c(paramView);
    localc.a(this);
    return localc;
  }

  protected boolean c()
  {
    return true;
  }

  protected ChatSolutionData e()
  {
    return new ChatSolutionData();
  }

  public void onClick(View paramView)
  {
    Context localContext;
    int i;
    if (paramView.getTag(R.id.action_view_tag_id) != null)
    {
      localContext = paramView.getContext();
      i = ((Integer)paramView.getTag(R.id.action_view_tag_id)).intValue();
      if ((i != R.id.public_account_chat_solution_action_connect) && (i != R.id.public_account_chat_solution_action_change))
        break label49;
      a(localContext);
    }
    label49: 
    do
    {
      return;
      if (i == R.id.public_account_app_key_action_copy)
      {
        b(localContext);
        return;
      }
    }
    while (i != R.id.public_account_chat_solution_action_disconnect);
    r.v().a(this.c).b(this.c);
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D2106)) && (-1 == paramInt))
      f();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.chatsolution.edit.a
 * JD-Core Version:    0.6.2
 */
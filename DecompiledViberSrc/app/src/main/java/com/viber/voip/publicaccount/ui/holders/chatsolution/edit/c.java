package com.viber.voip.publicaccount.ui.holders.chatsolution.edit;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.widget.TextWithDescriptionAndActionView;

class c
  implements b
{
  private final TextWithDescriptionAndActionView a;
  private final View b;
  private final TextWithDescriptionAndActionView c;

  public c(View paramView)
  {
    this.a = ((TextWithDescriptionAndActionView)paramView.findViewById(R.id.public_account_your_chat_solution_view));
    this.a.setGravity(3);
    this.c = ((TextWithDescriptionAndActionView)paramView.findViewById(R.id.public_account_app_key_view));
    this.b = paramView.findViewById(R.id.disconnect_inbox);
    this.b.setTag(R.id.action_view_tag_id, Integer.valueOf(R.id.public_account_chat_solution_action_disconnect));
  }

  public void a()
  {
    a(null);
  }

  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a.setActionClickListener(paramOnClickListener);
    this.c.setActionClickListener(paramOnClickListener);
    this.b.setOnClickListener(paramOnClickListener);
  }

  public void a(String paramString)
  {
    this.c.setText(paramString);
  }

  public void a(String paramString1, String paramString2)
  {
    Context localContext = this.a.getContext();
    if ((da.a(paramString1)) && (!da.a(paramString2)))
      paramString1 = localContext.getString(R.string.crm_name_chat_api);
    this.a.setText(localContext.getString(R.string.public_account_edit_your_chat_solution_text_change, new Object[] { paramString1 }));
    this.a.setActionText(R.string.public_account_edit_your_chat_solution_action_change);
    this.a.setActionId(R.id.public_account_chat_solution_action_change);
    dj.b(this.b, true);
  }

  public void b()
  {
    this.a.setText(R.string.public_account_edit_your_chat_solution_text_connect);
    this.a.setActionText(R.string.public_account_edit_your_chat_solution_action_connect);
    this.a.setActionId(R.id.public_account_chat_solution_action_connect);
    dj.b(this.b, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.chatsolution.edit.c
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.conversation.ui.banner;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.util.dj;

public class z extends aa
  implements View.OnClickListener
{
  private TextView d = (TextView)this.layout.findViewById(R.id.report_btn);
  private TextView e;
  private int f;
  private int g;
  private int h;
  private int i;

  public z(ViewGroup paramViewGroup, aa.a parama, LayoutInflater paramLayoutInflater)
  {
    super(R.layout.spam_alertbaner_layout, paramViewGroup, parama, paramLayoutInflater);
    this.d.setOnClickListener(this);
    this.e = ((TextView)this.layout.findViewById(R.id.add_to_contacts_btn));
    this.e.setOnClickListener(this);
    this.f = this.resources.getDimensionPixelSize(R.dimen.conversation_spam_banner_height);
    this.g = this.resources.getDimensionPixelSize(R.dimen.conversation_spam_banner_with_one_option_height);
    this.h = this.resources.getDimensionPixelSize(R.dimen.conversation_spam_banner_collapsed_height);
    this.i = this.resources.getDimensionPixelSize(R.dimen.conversation_group_spam_banner_collapsed_height);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    boolean bool1 = dj.c(this.layout.getContext());
    int j;
    if (paramBoolean)
      if ((!bool1) && (paramConversationItemLoaderEntity.isGroupBehavior()))
      {
        j = this.i;
        if (j != this.layout.getLayoutParams().height)
        {
          this.layout.getLayoutParams().height = j;
          this.layout.requestLayout();
          if (paramBoolean)
            break label114;
        }
      }
    label114: for (boolean bool2 = true; ; bool2 = false)
    {
      a(bool2);
      return;
      j = this.h;
      break;
      if (paramConversationItemLoaderEntity.showInviteBanner())
      {
        j = this.g;
        break;
      }
      j = this.f;
      break;
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean1, boolean paramBoolean2)
  {
    TextView localTextView1 = this.b;
    Context localContext1 = this.layout.getContext();
    int j;
    int k;
    if (paramConversationItemLoaderEntity.isGroupBehavior())
    {
      j = R.string.spam_banner_text_groups;
      localTextView1.setText(localContext1.getString(j));
      TextView localTextView2 = this.c;
      Context localContext2 = this.layout.getContext();
      if (!paramBoolean1)
        break label152;
      k = R.string.unblock;
      label63: localTextView2.setText(localContext2.getString(k));
      if (paramBoolean2)
      {
        if (!paramConversationItemLoaderEntity.showInviteBanner())
          break label175;
        this.c.setVisibility(8);
        this.d.setVisibility(8);
      }
    }
    for (int m = this.g; ; m = this.f)
    {
      ViewGroup.LayoutParams localLayoutParams = this.layout.getLayoutParams();
      if (localLayoutParams.height != m)
      {
        localLayoutParams.height = m;
        this.layout.requestLayout();
      }
      return;
      j = R.string.spam_banner_text_1on1;
      break;
      label152: if (paramConversationItemLoaderEntity.isGroupBehavior())
      {
        k = R.string.spam_banner_block_btn;
        break label63;
      }
      k = R.string.block;
      break label63;
      label175: this.c.setVisibility(0);
      this.d.setVisibility(0);
    }
  }

  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    dj.b(this.d, paramBoolean);
    dj.b(this.e, paramBoolean);
  }

  public void onClick(View paramView)
  {
    if (R.id.report_btn == paramView.getId())
    {
      this.a.h();
      return;
    }
    super.onClick(paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.z
 * JD-Core Version:    0.6.2
 */
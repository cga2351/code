package com.viber.voip.messages.conversation.ui.banner;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.integer;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.util.dj;

public class d extends aa
  implements View.OnClickListener
{
  private final int d = this.resources.getInteger(R.integer.anonymous_spam_banner_expanded_title_max_lines);
  private final int e = this.resources.getInteger(R.integer.anonymous_spam_banner_collapsed_title_max_lines);
  private final View f = this.layout.findViewById(R.id.block_icon);

  public d(ViewGroup paramViewGroup, aa.a parama, LayoutInflater paramLayoutInflater)
  {
    super(R.layout.anonymous_spam_banner, paramViewGroup, parama, paramLayoutInflater);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = this.e;
      if (i != this.b.getMaxLines())
      {
        this.b.setMaxLines(i);
        if (paramBoolean)
          break label50;
      }
    }
    label50: for (boolean bool = true; ; bool = false)
    {
      a(bool);
      return;
      i = this.d;
      break;
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean1, boolean paramBoolean2)
  {
    Context localContext = this.layout.getContext();
    TextView localTextView1 = this.b;
    int i = R.string.spam_banner_text_anonymous;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramConversationItemLoaderEntity.getParticipantName();
    localTextView1.setText(localContext.getString(i, arrayOfObject));
    TextView localTextView2 = this.c;
    if (paramBoolean1);
    for (int j = R.string.unblock; ; j = R.string.block)
    {
      localTextView2.setText(localContext.getString(j));
      return;
    }
  }

  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    dj.b(this.f, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.d
 * JD-Core Version:    0.6.2
 */
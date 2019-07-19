package com.viber.voip.messages.conversation.ui.spam.b;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.m;
import com.viber.voip.ui.doodle.pickers.b;
import com.viber.voip.util.br;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.widget.ProgressBar;
import com.viber.voip.widget.a.c;
import java.util.List;

public class a extends d
{
  private View k;
  private ProgressBar l;
  private RecyclerView m;
  private com.viber.voip.messages.conversation.ui.spam.a.a n;

  public a(Context paramContext, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramViewGroup, paramOnClickListener);
  }

  private void g()
  {
    if ((this.c == null) || (this.m != null))
      return;
    this.l = ((ProgressBar)this.f.findViewById(R.id.loading_animation));
    this.m = ((RecyclerView)this.f.findViewById(R.id.community_container));
    this.m.addItemDecoration(new c(this.c.getResources().getDimensionPixelOffset(R.dimen.anonymous_chat_spam_overlay_community_item_padding)));
    this.m.setHasFixedSize(true);
    this.n = new com.viber.voip.messages.conversation.ui.spam.a.a();
    this.m.setAdapter(this.n);
    this.m.setLayoutManager(new LinearLayoutManager(this.c, 0, false));
  }

  public void a()
  {
    if (this.g != null)
      this.g.setText(this.g.getContext().getResources().getString(R.string.anonymous_chat_spam_banner_description_without_common_communities));
    dj.b(this.l, false);
    dj.b(this.m, false);
    if ((br.a.a()) && (this.k != null))
      this.k.requestLayout();
  }

  public void a(List<h> paramList)
  {
    if (this.n != null)
    {
      this.n.a(paramList);
      if (this.g != null)
        this.g.setText(this.g.getContext().getResources().getString(R.string.anonymous_chat_spam_banner_description_with_common_communities));
      dj.b(this.l, false);
      dj.b(this.m, true);
    }
  }

  public void b()
  {
    if ((this.c == null) || (this.a == null) || (this.b == null))
      return;
    if (this.k == null)
    {
      this.k = this.f.findViewById(R.id.content_container);
      this.g = ((TextView)this.f.findViewById(R.id.overlay_message));
      this.h = ((ImageView)this.f.findViewById(R.id.photo));
      this.i = ((TextView)this.f.findViewById(R.id.overlay_viber_name));
    }
    Resources localResources = this.h.getResources();
    int i = localResources.getDimensionPixelSize(R.dimen.anonymous_chat_spam_overlay_avatar_size);
    int j = localResources.getDimensionPixelSize(R.dimen.anonymous_chat_spam_overlay_avatar_inner_size);
    this.h.setBackground(new b(i, j, dc.d(this.h.getContext(), R.attr.conversationSpamOverlayBackground)));
    e.a(this.c).a(null, this.b.p(), this.h, f.b(this.c).f().a(true).c());
    TextView localTextView;
    Context localContext;
    int i1;
    if (!TextUtils.isEmpty(this.b.getViberName()))
    {
      this.i.setText(this.b.getViberName());
      dj.b(this.i, true);
      this.g.setText(this.g.getContext().getString(R.string.anonymous_chat_spam_banner_description_without_common_communities));
      localTextView = this.j;
      localContext = this.g.getContext();
      if (!this.e)
        break label296;
      i1 = R.string.spam_banner_delete_and_close_btn;
    }
    while (true)
    {
      localTextView.setText(localContext.getString(i1));
      g();
      return;
      dj.b(this.i, false);
      break;
      label296: if (this.a.isGroupBehavior())
        i1 = R.string.spam_banner_block_btn;
      else
        i1 = R.string.block;
    }
  }

  protected int c()
  {
    return R.layout.anonymous_chat_spam_overlay_layout;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.spam.b.a
 * JD-Core Version:    0.6.2
 */
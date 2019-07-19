package com.viber.voip.messages.conversation.ui.banner;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.adapter.k;
import com.viber.voip.messages.conversation.adapter.k.b;
import com.viber.voip.messages.conversation.adapter.k.b.a;
import com.viber.voip.messages.conversation.adapter.l;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.at;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.util.dc;

public class m
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final LayoutInflater c;
  private final View.OnClickListener d = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      GenericWebViewActivity.a(m.a(m.this), ap.c().aj, m.a(m.this).getString(R.string.learn_more));
    }
  };
  private a e;

  public m(ConversationFragment paramConversationFragment)
  {
    this.b = paramConversationFragment.getContext();
    this.c = paramConversationFragment.getLayoutInflater();
  }

  private a a()
  {
    if (this.e == null)
      this.e = new a(this.b, this.d, this.c);
    return this.e;
  }

  private void a(k paramk)
  {
    paramk.a(a());
  }

  private void b(k paramk)
  {
    if (this.e != null)
    {
      paramk.b(this.e);
      this.e.d();
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean, k paramk)
  {
    if ((paramConversationItemLoaderEntity.isGroupType()) || ((paramConversationItemLoaderEntity.isConversation1on1()) && (!paramConversationItemLoaderEntity.isOneToOneWithPublicAccount())));
    for (int i = 1; (paramBoolean) && (i != 0) && (paramConversationItemLoaderEntity.isSecure()) && (!paramConversationItemLoaderEntity.isSecret()) && (!paramConversationItemLoaderEntity.isVlnConversation()); i = 0)
    {
      a(paramk);
      return;
    }
    b(paramk);
  }

  private static class a
    implements k.b
  {
    private final Context a;
    private final LayoutInflater b;
    private final View.OnClickListener c;
    private View d;

    public a(Context paramContext, View.OnClickListener paramOnClickListener, LayoutInflater paramLayoutInflater)
    {
      this.a = paramContext;
      this.b = paramLayoutInflater;
      this.c = paramOnClickListener;
    }

    private View a(ViewGroup paramViewGroup)
    {
      View localView = this.b.inflate(R.layout.encrypted_conversation_banner_layout, paramViewGroup, false);
      TextView localTextView = (TextView)localView.findViewById(R.id.description);
      localTextView.setText(a(paramViewGroup.getContext()));
      localTextView.setOnClickListener(this.c);
      return localView;
    }

    private CharSequence a(Context paramContext)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
      localSpannableStringBuilder.setSpan(new ImageSpan(this.a, dc.a(paramContext, R.attr.conversationEncryptedBannerIcon), 1), 0, 1, 17);
      localSpannableStringBuilder.append(paramContext.getString(R.string.secure_messages_tooltip_unverified_1on1)).append(" ");
      SpannableString localSpannableString = new SpannableString(paramContext.getString(R.string.learn_more) + ".");
      localSpannableString.setSpan(new StyleSpan(1), 0, localSpannableString.length(), 17);
      localSpannableString.setSpan(new ClickableSpan()
      {
        public void onClick(View paramAnonymousView)
        {
        }
      }
      , 0, localSpannableString.length(), 17);
      localSpannableStringBuilder.append(localSpannableString);
      return localSpannableStringBuilder;
    }

    public View a()
    {
      return this.d;
    }

    public View a(ViewGroup paramViewGroup, View paramView)
    {
      if (paramView != null);
      while (true)
      {
        this.d = paramView;
        return paramView;
        paramView = a(paramViewGroup);
      }
    }

    public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, at paramat)
    {
    }

    public k.b.a b()
    {
      return k.b.a.c;
    }

    public int c()
    {
      return l.a(this);
    }

    public void d()
    {
      this.d = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.m
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.conversation.ui.banner;

import android.content.Context;
import android.net.Uri;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.adapter.d;
import com.viber.voip.messages.conversation.adapter.d.ae;
import com.viber.voip.messages.conversation.adapter.k;
import com.viber.voip.messages.conversation.adapter.k.b;
import com.viber.voip.messages.conversation.adapter.k.b.a;
import com.viber.voip.messages.conversation.adapter.l;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.at;
import com.viber.voip.util.da;
import com.viber.voip.util.dc;
import com.viber.voip.util.dg;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.widget.AvatarWithInitialsView;

public class h
{
  private static final Logger a = ViberEnv.getLogger();
  private ConversationItemLoaderEntity b;
  private final Context c;
  private d d;
  private LayoutInflater e;
  private ae f;

  public h(ConversationFragment paramConversationFragment, ae paramae)
  {
    this.c = paramConversationFragment.getContext();
    this.e = paramConversationFragment.getLayoutInflater();
    this.f = paramae;
  }

  private int a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    return ((PublicGroupConversationItemLoaderEntity)paramConversationItemLoaderEntity).getLastServerMsgId();
  }

  private d a(k paramk, a parama)
  {
    if ((this.d == null) || (this.d.e() != parama))
    {
      if (this.d != null)
        a(paramk);
      switch (1.a[parama.ordinal()])
      {
      default:
      case 1:
      }
    }
    for (this.d = new b(this.c, this.b, this.e); ; this.d = new c(this.c, (PublicGroupConversationItemLoaderEntity)this.b, this.e, this.f))
      return this.d;
  }

  private void a(k paramk)
  {
    if (this.d != null)
    {
      paramk.b(this.d);
      this.d.d();
    }
  }

  private void b(k paramk, a parama)
  {
    paramk.a(a(paramk, parama));
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, k paramk)
  {
    this.b = paramConversationItemLoaderEntity;
    a locala;
    if (this.b.isNotJoinedCommunity())
    {
      locala = a.b;
      if ((!this.b.isCommunityType()) || (((paramk.a().getCount() != 0) || (a(paramConversationItemLoaderEntity) > 0)) && ((paramk.a().getCount() <= 0) || (paramk.a().a() > 1))))
        break label115;
      b(paramk, locala);
    }
    while (true)
    {
      if ((this.d != null) && ((this.b instanceof PublicGroupConversationItemLoaderEntity)))
        this.d.a((PublicGroupConversationItemLoaderEntity)this.b);
      return;
      locala = a.a;
      break;
      label115: a(paramk);
    }
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }
  }

  private static class b
    implements h.d
  {
    private final Context a;
    private final LayoutInflater b;
    private View c;
    private TextView d;
    private AvatarWithInitialsView e;
    private Uri f;
    private f g;
    private ConversationItemLoaderEntity h;

    public b(Context paramContext, ConversationItemLoaderEntity paramConversationItemLoaderEntity, LayoutInflater paramLayoutInflater)
    {
      this.a = paramContext;
      this.h = paramConversationItemLoaderEntity;
      this.b = paramLayoutInflater;
    }

    private View a(ViewGroup paramViewGroup)
    {
      View localView = this.b.inflate(R.layout.conversation_welcome_blurb, paramViewGroup, false);
      this.d = ((TextView)localView.findViewById(R.id.title));
      this.e = ((AvatarWithInitialsView)localView.findViewById(R.id.avatar));
      this.e.a(null, false);
      TextView localTextView = (TextView)localView.findViewById(R.id.learn_more_text);
      localTextView.setText(Html.fromHtml(this.a.getString(R.string.community_blurb_learn_more_gdpr)));
      localTextView.setMovementMethod(LinkMovementMethod.getInstance());
      localTextView.setHighlightColor(0);
      int i = dc.a(this.a, R.attr.conversationsListItemDefaultCommunityImage);
      this.g = f.c(i).f().a(Integer.valueOf(i)).b(Integer.valueOf(i)).c();
      ViewStub localViewStub = (ViewStub)localView.findViewById(R.id.empty_banner_options_stub);
      localViewStub.setLayoutResource(R.layout.community_welcome_blurb_options);
      localViewStub.inflate();
      return localView;
    }

    public View a()
    {
      return this.c;
    }

    public View a(ViewGroup paramViewGroup, View paramView)
    {
      if (paramView != null);
      while (true)
      {
        this.c = paramView;
        return paramView;
        paramView = a(paramViewGroup);
      }
    }

    public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, at paramat)
    {
      if ((this.h != null) && (this.d != null) && (this.e != null))
      {
        Context localContext = this.a;
        int i = R.string.community_blurb_title;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = dg.b(this.h);
        String str = localContext.getString(i, arrayOfObject);
        if (!da.a(String.valueOf(this.d.getText()), str))
          this.d.setText(str);
        this.f = this.h.getIconUri();
        e.a(this.a).a(this.f, this.e, this.g);
      }
    }

    public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
    {
      this.h = paramPublicGroupConversationItemLoaderEntity;
    }

    public k.b.a b()
    {
      return k.b.a.b;
    }

    public int c()
    {
      return l.a(this);
    }

    public void d()
    {
      this.c = null;
    }

    public h.a e()
    {
      return h.a.a;
    }
  }

  private static class c
    implements h.d
  {
    private final Context a;
    private final LayoutInflater b;
    private View c;
    private TextView d;
    private AvatarWithInitialsView e;
    private View f;
    private Uri g;
    private f h;
    private PublicGroupConversationItemLoaderEntity i;
    private final ae j;

    public c(Context paramContext, PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, LayoutInflater paramLayoutInflater, ae paramae)
    {
      this.a = paramContext;
      this.i = paramPublicGroupConversationItemLoaderEntity;
      this.b = paramLayoutInflater;
      this.j = paramae;
    }

    private View a(ViewGroup paramViewGroup)
    {
      View localView = this.b.inflate(R.layout.welcome_not_joined_community_blurb, paramViewGroup, false);
      this.f = localView.findViewById(R.id.join);
      this.d = ((TextView)localView.findViewById(R.id.description));
      this.e = ((AvatarWithInitialsView)localView.findViewById(R.id.avatar));
      this.e.a(null, false);
      this.f.setOnClickListener(new i(this));
      int k = dc.a(this.a, R.attr.conversationsListItemDefaultCommunityImage);
      this.h = f.c(k).f().a(Integer.valueOf(k)).b(Integer.valueOf(k)).c();
      return localView;
    }

    public View a()
    {
      return this.c;
    }

    public View a(ViewGroup paramViewGroup, View paramView)
    {
      if (paramView != null);
      while (true)
      {
        this.c = paramView;
        return paramView;
        paramView = a(paramViewGroup);
      }
    }

    public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, at paramat)
    {
      if ((this.i != null) && (this.d != null) && (this.e != null))
      {
        String str = paramConversationItemLoaderEntity.getPublicAccountTagsLine();
        if (da.a(str))
          str = this.a.getString(R.string.dialog_follow_community_welcome_without_name);
        if (!da.a(String.valueOf(this.d.getText()), str))
          this.d.setText(str);
        this.g = this.i.getIconUri();
        e.a(this.a).a(this.g, this.e, this.h);
      }
    }

    public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
    {
      this.i = paramPublicGroupConversationItemLoaderEntity;
    }

    public k.b.a b()
    {
      return k.b.a.b;
    }

    public int c()
    {
      return l.a(this);
    }

    public void d()
    {
      this.c = null;
    }

    public h.a e()
    {
      return h.a.b;
    }
  }

  private static abstract interface d extends k.b
  {
    public abstract void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity);

    public abstract void d();

    public abstract h.a e();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.h
 * JD-Core Version:    0.6.2
 */
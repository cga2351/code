package com.viber.voip.messages.conversation.ui.banner;

import android.content.Context;
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
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.adapter.k;
import com.viber.voip.messages.conversation.adapter.k.b;
import com.viber.voip.messages.conversation.adapter.k.b.a;
import com.viber.voip.messages.conversation.adapter.l;
import com.viber.voip.messages.conversation.ui.at;
import com.viber.voip.messages.d.b;
import com.viber.voip.model.entity.m;
import com.viber.voip.user.PublicGroupParticipantDetailsActivity;
import com.viber.voip.util.dc;
import com.viber.voip.util.dg;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.widget.AvatarWithInitialsView;

public class c
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final b c;
  private a d;

  public c(Context paramContext, b paramb)
  {
    this.b = paramContext;
    this.c = paramb;
  }

  private a a()
  {
    if (this.d == null)
      this.d = new a(this.b, this.c);
    return this.d;
  }

  private void a(k paramk)
  {
    paramk.a(a());
  }

  private void b(k paramk)
  {
    if (this.d != null)
    {
      paramk.b(this.d);
      this.d.d();
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean, k paramk)
  {
    if ((paramConversationItemLoaderEntity.isAnonymous()) && (paramConversationItemLoaderEntity.showM2MBlurb()) && (paramBoolean))
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
    private final b b;
    private final LayoutInflater c;
    private final f d;
    private View e;
    private TextView f;
    private AvatarWithInitialsView g;
    private ConversationItemLoaderEntity h;
    private final View.OnClickListener i = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (c.a.a(c.a.this) == null);
        m localm;
        do
        {
          return;
          localm = c.a.b(c.a.this).b(c.a.a(c.a.this).getParticipantInfoId());
        }
        while (localm == null);
        c.a.c(c.a.this).startActivity(PublicGroupParticipantDetailsActivity.buildIntentForSingleShowing(c.a.c(c.a.this), localm.p(), c.a.a(c.a.this).getParticipantName()));
      }
    };

    a(Context paramContext, b paramb)
    {
      this.a = paramContext;
      this.b = paramb;
      this.c = LayoutInflater.from(paramContext);
      int j = dc.a(this.a, R.attr.contactDefaultPhotoMedium);
      this.d = f.c(j).f().a(Integer.valueOf(j)).b(Integer.valueOf(j)).c();
    }

    private View a(ViewGroup paramViewGroup)
    {
      View localView = this.c.inflate(R.layout.anonymous_chat_blurb, paramViewGroup, false);
      this.f = ((TextView)localView.findViewById(R.id.description));
      this.g = ((AvatarWithInitialsView)localView.findViewById(R.id.avatar));
      this.g.setOnClickListener(this.i);
      return localView;
    }

    public View a()
    {
      return this.e;
    }

    public View a(ViewGroup paramViewGroup, View paramView)
    {
      if (paramView != null);
      while (true)
      {
        this.e = paramView;
        return this.e;
        paramView = a(paramViewGroup);
      }
    }

    public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, at paramat)
    {
      this.h = paramConversationItemLoaderEntity;
      if (paramConversationItemLoaderEntity != null)
      {
        if (this.f != null)
        {
          TextView localTextView = this.f;
          Context localContext = this.a;
          int j = R.string.anonymous_chat_blurb_description;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = dg.a(paramConversationItemLoaderEntity);
          localTextView.setText(localContext.getString(j, arrayOfObject));
        }
        if (this.g != null)
        {
          m localm = this.b.b(paramConversationItemLoaderEntity.getParticipantInfoId());
          if (localm != null)
            e.a(this.a).a(localm.p(), this.g, this.d);
        }
      }
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
      this.e = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.banner.c
 * JD-Core Version:    0.6.2
 */
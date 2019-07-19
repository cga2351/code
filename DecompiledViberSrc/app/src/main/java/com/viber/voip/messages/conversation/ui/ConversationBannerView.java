package com.viber.voip.messages.conversation.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.viber.common.ui.ShapeImageView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.k;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.m;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.h.a;

public class ConversationBannerView extends FrameLayout
{
  private View a;
  private View b;
  private View c;
  private View d;
  private View e;
  private boolean f;
  private at g;
  private final h.a h = new h.a()
  {
    public void onLoadComplete(Uri paramAnonymousUri, Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
    {
      if (ConversationBannerView.a(ConversationBannerView.this) != null)
      {
        View localView = ConversationBannerView.a(ConversationBannerView.this).findViewById(R.id.public_group_share_banner_icon);
        if (localView != null)
          ((ShapeImageView)localView).setImageBitmap(paramAnonymousBitmap);
        dj.c(ConversationBannerView.a(ConversationBannerView.this), 0);
      }
    }
  };

  public ConversationBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ConversationBannerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void a(View paramView)
  {
    if (this.g != null)
    {
      View localView = ((ViewGroup)paramView).getChildAt(0);
      if (localView != null)
        localView.setBackgroundColor(this.g.k());
    }
  }

  private void a(boolean paramBoolean)
  {
    View localView;
    if (this.g != null)
    {
      localView = ((ViewGroup)this.b).getChildAt(0);
      if (localView != null)
        if (!paramBoolean)
          break label44;
    }
    label44: for (int i = getResources().getDimensionPixelOffset(R.dimen.admin_confirmation_banner_info_min_height); ; i = getResources().getDimensionPixelOffset(R.dimen.admin_confirmation_banner_conversation_min_height))
    {
      localView.setMinimumHeight(i);
      return;
    }
  }

  private void b(int paramInt)
  {
    if (this.a == null)
    {
      e();
      this.a = inflate(getContext(), R.layout.group_banner_removed_participant, this);
      ((TextView)this.a.findViewById(R.id.label)).setText(paramInt);
    }
    a(this.a);
    dj.c(this.a, 0);
    dj.c(this);
  }

  private void b(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    e.a(ViberApplication.getApplication()).a(paramPublicGroupConversationItemLoaderEntity.getIconUri(), f.a(), this.h);
  }

  private void e()
  {
    removeAllViews();
    this.d = null;
    this.a = null;
    this.b = null;
    this.c = null;
    this.e = null;
    if (this.f)
      f();
  }

  private void f()
  {
    this.f = false;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    localLayoutParams.addRule(2, 0);
    localLayoutParams.addRule(12, -1);
    setLayoutParams(localLayoutParams);
  }

  private void g()
  {
    this.f = true;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    localLayoutParams.addRule(2, R.id.message_composer);
    localLayoutParams.addRule(12, 0);
    setLayoutParams(localLayoutParams);
  }

  private void setShareBannerListeners(View.OnClickListener paramOnClickListener)
  {
    if (this.c != null)
    {
      this.c.findViewById(R.id.public_group_share_banner_area).setOnClickListener(paramOnClickListener);
      this.c.findViewById(R.id.public_group_share_banner_icon).setOnClickListener(paramOnClickListener);
      this.c.findViewById(R.id.public_group_share_banner_close_action).setOnClickListener(paramOnClickListener);
    }
  }

  public void a()
  {
    dj.c(this.a, 8);
  }

  public void a(int paramInt)
  {
    if (m.b(paramInt))
    {
      b(R.string.community_not_member_banner_text);
      return;
    }
    b(R.string.group_banner_remove_participant);
  }

  public void a(final long paramLong, final a parama)
  {
    if (this.e == null)
    {
      e();
      this.e = inflate(getContext(), R.layout.group_banner_no_privileges, this);
      this.e.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
        }
      });
    }
    this.e.findViewById(R.id.close_button).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ConversationBannerView.this.d();
        parama.a(paramLong);
      }
    });
    this.e.setVisibility(0);
  }

  public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    if ((this.c != null) && (this.c.getVisibility() == 0))
      b(paramPublicGroupConversationItemLoaderEntity);
  }

  public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    if (this.b == null)
    {
      e();
      this.b = inflate(getContext(), R.layout.public_group_admin_confirmation, this);
    }
    if (this.b != null)
    {
      a(this.b);
      a(paramBoolean);
      ((TextView)this.b.findViewById(R.id.message)).setText(da.c(com.viber.voip.messages.d.c.c().a(paramPublicGroupConversationItemLoaderEntity.getInviter(), paramPublicGroupConversationItemLoaderEntity.getConversationType(), paramPublicGroupConversationItemLoaderEntity.getGroupRole()), paramPublicGroupConversationItemLoaderEntity.getGroupName()));
      this.b.findViewById(R.id.decline).setOnClickListener(paramOnClickListener);
      this.b.findViewById(R.id.accept).setOnClickListener(paramOnClickListener);
      this.b.setVisibility(0);
    }
  }

  public void a(at paramat)
  {
    this.g = paramat;
  }

  public void a(String paramString)
  {
    if (this.d == null)
    {
      e();
      this.d = inflate(getContext(), R.layout.disabled_public_account_banner, this);
    }
    if (this.d != null)
    {
      this.d.setVisibility(0);
      int i = getResources().getDimensionPixelOffset(R.dimen.msg_edit_text_height_one_line);
      ((ViewGroup)getParent()).findViewById(R.id.swipe_refresh_layout).setPadding(0, 0, 0, i);
      String str = com.viber.common.d.c.a(getResources(), R.string.public_account_disabled_messaging_hint, new Object[] { paramString });
      ((TextView)this.d.findViewById(R.id.text)).setText(str);
    }
  }

  public void a(boolean paramBoolean, PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity)
  {
    if (this.c != null)
    {
      this.c.setVisibility(8);
      if ((paramBoolean) && (paramPublicGroupConversationItemLoaderEntity != null))
        k.a().a(paramPublicGroupConversationItemLoaderEntity, 1010);
    }
  }

  public boolean a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, View.OnClickListener paramOnClickListener)
  {
    if ((this.b != null) && (this.b.getVisibility() == 0));
    do
    {
      do
        return false;
      while (paramPublicGroupConversationItemLoaderEntity == null);
      if (this.c == null)
      {
        e();
        g();
        this.c = inflate(getContext(), R.layout.public_group_share_banner, this);
      }
    }
    while (this.c == null);
    a(this.c);
    setShareBannerListeners(paramOnClickListener);
    b(paramPublicGroupConversationItemLoaderEntity);
    return true;
  }

  public void b()
  {
    dj.c(this.b, 8);
  }

  public void c()
  {
    if (this.d != null)
    {
      ((ViewGroup)getParent()).findViewById(R.id.swipe_refresh_layout).setPadding(0, 0, 0, 0);
      this.d.setVisibility(8);
    }
  }

  public void d()
  {
    dj.c(this.e, 8);
  }

  public static abstract interface a
  {
    public abstract void a(long paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.ConversationBannerView
 * JD-Core Version:    0.6.2
 */
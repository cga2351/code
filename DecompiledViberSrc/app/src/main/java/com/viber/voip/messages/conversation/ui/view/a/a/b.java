package com.viber.voip.messages.conversation.ui.view.a.a;

import android.app.Activity;
import android.view.View;
import com.viber.voip.messages.conversation.ui.ConversationBannerView;
import com.viber.voip.messages.conversation.ui.ConversationBannerView.a;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.bd;
import com.viber.voip.messages.conversation.ui.presenter.banners.bottom.BottomBannerPresenter;

public class b<P extends BottomBannerPresenter> extends com.viber.voip.messages.conversation.ui.view.b.a<P>
  implements a
{
  protected final ConversationBannerView a;
  private final bd b;

  public b(P paramP, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean, ConversationBannerView paramConversationBannerView, bd parambd)
  {
    super(paramP, paramActivity, paramConversationFragment, paramView, paramBoolean);
    this.b = parambd;
    this.a = paramConversationBannerView;
  }

  public void a()
  {
    this.a.a();
  }

  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }

  public void a(long paramLong, ConversationBannerView.a parama)
  {
    this.a.a(paramLong, parama);
  }

  public void a(String paramString)
  {
    this.a.a(paramString);
  }

  public void b()
  {
    this.a.c();
  }

  public void c()
  {
    this.a.d();
  }

  public void onStart()
  {
    this.b.a();
  }

  public void onStop()
  {
    this.b.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.a.a.b
 * JD-Core Version:    0.6.2
 */
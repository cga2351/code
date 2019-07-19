package com.viber.voip.messages.conversation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.messages.conversation.ui.presenter.ShareScreenshotPresenter;
import com.viber.voip.messages.conversation.ui.view.ScreenshotConversationData;
import com.viber.voip.messages.conversation.ui.view.b.w;
import com.viber.voip.messages.k;
import com.viber.voip.mvp.core.DefaultMvpActivity;
import com.viber.voip.mvp.core.d;
import com.viber.voip.user.UserManager;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;

public class ShareScreenshotActivity extends DefaultMvpActivity<d>
{

  @Inject
  k a;

  @Inject
  UserManager b;

  @Inject
  Handler c;

  @Inject
  com.viber.voip.analytics.story.g.a d;

  @Inject
  EventBus e;
  private ScreenshotConversationData f;

  protected void a(Bundle paramBundle)
  {
    this.f = ((ScreenshotConversationData)getIntent().getParcelableExtra("screenshot_data_extra"));
  }

  protected void b(Bundle paramBundle)
  {
    ShareScreenshotPresenter localShareScreenshotPresenter = new ShareScreenshotPresenter(this.f, this.e, this.c, this.a.u(), this.b.getRegistrationValues(), this.d);
    a(new w(localShareScreenshotPresenter, findViewById(R.id.container), this), localShareScreenshotPresenter, paramBundle);
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    setContentView(R.layout.share_screenshot_layout);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.ShareScreenshotActivity
 * JD-Core Version:    0.6.2
 */
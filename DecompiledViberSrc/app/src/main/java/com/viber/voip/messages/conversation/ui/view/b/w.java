package com.viber.voip.messages.conversation.ui.view.b;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.camrecorder.preview.DoodleActivity;
import com.viber.voip.camrecorder.preview.DoodleActivity.a;
import com.viber.voip.messages.conversation.ui.bv;
import com.viber.voip.messages.conversation.ui.presenter.ShareScreenshotPresenter;
import com.viber.voip.messages.conversation.ui.view.ScreenshotConversationData;
import com.viber.voip.messages.conversation.ui.view.p;
import com.viber.voip.mvp.core.d;
import com.viber.voip.util.ViberActionRunner.az;
import com.viber.voip.util.ViberActionRunner.u;
import com.viber.voip.util.dj;
import com.viber.voip.util.dv;

public class w extends d<ShareScreenshotPresenter>
  implements p
{
  private ImageView a;
  private ImageView b;
  private FrameLayout.LayoutParams c;
  private Activity d;
  private LinearLayout e;

  public w(ShareScreenshotPresenter paramShareScreenshotPresenter, View paramView, Activity paramActivity)
  {
    super(paramShareScreenshotPresenter, paramView);
    this.d = paramActivity;
    c();
  }

  private void a(float paramFloat)
  {
    this.c.height = ((int)(paramFloat * this.a.getWidth()));
    this.a.setLayoutParams(this.c);
  }

  private void c()
  {
    this.a = ((ImageView)this.mRootView.findViewById(R.id.screenshotView));
    this.e = ((LinearLayout)this.mRootView.findViewById(R.id.shareButtonsContainer));
    this.b = ((ImageView)this.mRootView.findViewById(R.id.backgroundView));
    this.mRootView.findViewById(R.id.closeView).setOnClickListener(new x(this));
    this.mRootView.findViewById(R.id.settingsView).setOnClickListener(new y(this));
    this.mRootView.findViewById(R.id.customizeView).setOnClickListener(new z(this));
    this.c = ((FrameLayout.LayoutParams)this.a.getLayoutParams());
  }

  public void a()
  {
    this.e.removeAllViews();
  }

  public void a(int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    bv localbv = new bv(this.d);
    localbv.a(paramInt1, paramInt2);
    localbv.setOnClickListener(paramOnClickListener);
    this.e.addView(localbv);
  }

  public void a(int paramInt, String paramString1, ScreenshotConversationData paramScreenshotConversationData, String paramString2)
  {
    Resources localResources;
    Object[] arrayOfObject;
    if (paramScreenshotConversationData.hasNameAndLink())
    {
      localResources = this.d.getResources();
      arrayOfObject = new Object[2];
      arrayOfObject[0] = paramScreenshotConversationData.getCommunityName();
      arrayOfObject[1] = paramScreenshotConversationData.getCommunityShareLink();
    }
    for (String str = localResources.getString(paramInt, arrayOfObject); ; str = this.d.getResources().getString(paramInt, new Object[] { paramString2 }))
    {
      ViberActionRunner.az.a(this.d, 1, 0L, paramString1, "", "", "", str, null, false, null, new aa(str), null);
      return;
    }
  }

  public void a(String paramString)
  {
    this.b.setImageURI(Uri.parse(paramString));
  }

  public void a(String paramString, final float paramFloat)
  {
    this.a.setImageURI(Uri.parse(paramString));
    dj.a(this.a, new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        w.a(w.this, paramFloat);
        dj.b(w.a(w.this), this);
      }
    });
  }

  public void a(String paramString, ScreenshotConversationData paramScreenshotConversationData)
  {
    Intent localIntent = ViberActionRunner.u.a(Uri.parse(paramString));
    localIntent.putExtra("need_description", false);
    localIntent.putExtra("extra_community_screenshot_data", paramScreenshotConversationData);
    this.d.startActivity(localIntent);
    this.d.finish();
  }

  public void a(String paramString1, String paramString2)
  {
    DoodleActivity.a(this.d, dv.h.c(this.d, paramString2), Uri.parse(paramString1), 800, DoodleActivity.a.b, null);
  }

  public void b()
  {
    Intent localIntent = new Intent("com.viber.voip.action.SETTINGS");
    localIntent.putExtra("selected_item", R.string.pref_category_general_key);
    localIntent.putExtra("single_screen", true);
    this.d.startActivity(localIntent);
  }

  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramIntent == null)
      return false;
    switch (paramInt1)
    {
    default:
    case 800:
    }
    while (true)
    {
      return true;
      this.a.setImageURI(null);
      ((ShareScreenshotPresenter)this.mPresenter).a(true);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.b.w
 * JD-Core Version:    0.6.2
 */
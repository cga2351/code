package com.viber.voip.user.more;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.settings.a.a.a;
import com.viber.voip.settings.a.a.d;
import com.viber.voip.user.more.listitems.providers.ProfileBannerProvider;
import com.viber.voip.util.dj;

class MoreNotificationBanner
{
  private Button mButtonView;
  private final MorePreferenceAdapter mMorePreferenceAdapter;
  private final View mNotificationView;
  private final ProfileBannerProvider mProfileBannerProvider;
  private TextView mTitleView;

  MoreNotificationBanner(View paramView, MorePreferenceAdapter paramMorePreferenceAdapter, ProfileBannerProvider paramProfileBannerProvider)
  {
    this.mNotificationView = paramView;
    this.mMorePreferenceAdapter = paramMorePreferenceAdapter;
    this.mProfileBannerProvider = paramProfileBannerProvider;
  }

  private void bindBannerFields()
  {
    getTitleView().setText(this.mProfileBannerProvider.getTitleProvider().getText());
    getButtonView().setText(this.mProfileBannerProvider.getButtonProvider().getText());
    this.mMorePreferenceAdapter.updateVisibleItem(R.id.profile_banner);
  }

  private Button getButtonView()
  {
    if (this.mButtonView == null)
      this.mButtonView = ((Button)this.mNotificationView.findViewById(R.id.buttonView));
    return this.mButtonView;
  }

  private TextView getTitleView()
  {
    if (this.mTitleView == null)
      this.mTitleView = ((TextView)this.mNotificationView.findViewById(R.id.titleView));
    return this.mTitleView;
  }

  void bind()
  {
    int i = this.mNotificationView.getVisibility();
    if (this.mProfileBannerProvider.getVisibilityProvider().get())
    {
      dj.c(this.mNotificationView, 0);
      bindBannerFields();
    }
    while (true)
    {
      if (i != this.mNotificationView.getVisibility())
        this.mMorePreferenceAdapter.updateVisibleItems();
      return;
      dj.c(this.mNotificationView, 8);
    }
  }

  void setClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mNotificationView.setOnClickListener(paramOnClickListener);
    getButtonView().setOnClickListener(paramOnClickListener);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreNotificationBanner
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.user.more;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.style;
import com.viber.voip.ViberApplication;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.widget.ObservableCollapsingToolbarLayout;
import com.viber.voip.widget.ViberAppBarLayout;
import com.viber.voip.widget.toolbar.ToolbarCustomView;
import com.viber.voip.z;

class MoreHeaderImpl
  implements MoreHeader
{
  private android.support.v7.app.a mActionBar;
  private ViberAppBarLayout mAppBarLayout;
  private ObservableCollapsingToolbarLayout mCollapsingToolbarLayout;
  private final CoordinatorLayout mCoordinatorLayout;
  private final f mFetcherConfig;
  private Fragment mFragment;
  private final com.viber.voip.util.e.e mImageFetcher;
  private View mMarker;
  private final MorePresenter mMorePresenter;
  private final MoreScreenConfig mMoreScreenConfig;
  private final RecyclerView mRecyclerView;
  private final View mRootView;
  private Toolbar mToolbar;
  private ToolbarCustomView mToolbarCustomView;
  private MoreToolbarScrollController mToolbarScrollController;
  private com.viber.voip.widget.e mToolbarScrollListener;
  private ImageView mUserPhotoView;

  MoreHeaderImpl(Fragment paramFragment, MorePresenter paramMorePresenter, View paramView, RecyclerView paramRecyclerView, com.viber.voip.util.e.e parame, MoreScreenConfig paramMoreScreenConfig)
  {
    this.mFragment = paramFragment;
    this.mMorePresenter = paramMorePresenter;
    this.mRootView = paramView;
    this.mRecyclerView = paramRecyclerView;
    this.mCoordinatorLayout = ((CoordinatorLayout)paramView.findViewById(com.viber.voip.R.id.coordinator));
    this.mUserPhotoView = ((ImageView)paramView.findViewById(com.viber.voip.R.id.photo));
    this.mUserPhotoView.setOnClickListener(new MoreHeaderImpl..Lambda.0(paramMorePresenter));
    dj.b(this.mUserPhotoView, true);
    this.mImageFetcher = parame;
    this.mFetcherConfig = new f.a().a(true).b(Integer.valueOf(dc.a(paramView.getContext(), R.attr.moreDefaultPhoto))).a(com.viber.voip.b.a.j).c();
    this.mMoreScreenConfig = paramMoreScreenConfig;
    this.mToolbar = ((Toolbar)paramView.findViewById(com.viber.voip.R.id.toolbar));
    this.mToolbarCustomView = ((ToolbarCustomView)paramView.findViewById(com.viber.voip.R.id.toolbar_custom));
  }

  private android.support.v7.app.a getActionBar()
  {
    if (this.mActionBar == null)
    {
      FragmentActivity localFragmentActivity = this.mFragment.getActivity();
      if (localFragmentActivity != null)
        this.mActionBar = ((AppCompatActivity)localFragmentActivity).getSupportActionBar();
    }
    return this.mActionBar;
  }

  private View getActionBarView(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null)
      return null;
    View localView = paramActivity.getWindow().getDecorView();
    if (paramBoolean);
    for (int i = android.support.design.R.id.action_bar; ; i = com.viber.voip.R.id.toolbar)
      return localView.findViewById(i);
  }

  private boolean isFragmentVisible()
  {
    return (this.mFragment.isAdded()) && (!this.mFragment.isHidden());
  }

  public void adjustTopBar()
  {
    if (this.mFragment.getActivity() == null);
    do
    {
      do
      {
        return;
        if (this.mToolbar != null)
          ((AppCompatActivity)this.mFragment.getActivity()).setSupportActionBar(this.mToolbar);
        RecyclerView.LayoutManager localLayoutManager = this.mRecyclerView.getLayoutManager();
        if (localLayoutManager != null)
          localLayoutManager.scrollToPosition(0);
      }
      while (this.mAppBarLayout == null);
      this.mAppBarLayout.setExpanded(true, false);
    }
    while (this.mCoordinatorLayout == null);
    if (this.mAppBarLayout.getHeight() > 0)
    {
      CoordinatorLayout localCoordinatorLayout2 = this.mCoordinatorLayout;
      CoordinatorLayout localCoordinatorLayout3 = this.mCoordinatorLayout;
      localCoordinatorLayout3.getClass();
      localCoordinatorLayout2.post(MoreHeaderImpl..Lambda.4.get$Lambda(localCoordinatorLayout3));
      return;
    }
    ViberAppBarLayout localViberAppBarLayout = this.mAppBarLayout;
    CoordinatorLayout localCoordinatorLayout1 = this.mCoordinatorLayout;
    localCoordinatorLayout1.getClass();
    dj.a(localViberAppBarLayout, MoreHeaderImpl..Lambda.5.get$Lambda(localCoordinatorLayout1));
  }

  public void destroy()
  {
    if (this.mCollapsingToolbarLayout != null)
      this.mCollapsingToolbarLayout.setOnScrollListener(null);
    if (this.mAppBarLayout != null)
      this.mAppBarLayout.removeOnOffsetChangedListener(this.mToolbarScrollController);
  }

  public void init()
  {
    if (this.mToolbar != null)
    {
      this.mMarker = this.mToolbar.findViewById(com.viber.voip.R.id.place_marker);
      this.mToolbar.setTitleTextAppearance(this.mToolbar.getContext(), R.style.TextAppearance_Viber_Widget_ActionBar_Title_Light_Home);
      if (this.mToolbarCustomView != null)
      {
        this.mToolbarCustomView.b.setOnClickListener(new MoreHeaderImpl..Lambda.2(this));
        this.mToolbarCustomView.c.setOnClickListener(new MoreHeaderImpl..Lambda.3(this));
        this.mAppBarLayout = ((ViberAppBarLayout)this.mRootView.findViewById(com.viber.voip.R.id.app_bar_layout));
        if ((this.mAppBarLayout != null) && (this.mMarker != null))
        {
          this.mAppBarLayout.setBackgroundColor(dc.d(this.mAppBarLayout.getContext(), R.attr.mainBackgroundColor));
          ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mUserPhotoView.getLayoutParams();
          int i = localMarginLayoutParams.height + localMarginLayoutParams.topMargin + this.mRootView.getResources().getDimensionPixelSize(R.dimen.more_expanded_appbar_title_top_margin);
          this.mToolbarScrollController = new MoreToolbarScrollController(this.mToolbar, this.mToolbarCustomView, this.mMarker, i, this.mRootView.getResources().getDimensionPixelSize(R.dimen.more_item_left_padding), this.mRootView.getResources().getDimensionPixelSize(R.dimen.more_toolbar_collapsed_title_text_size));
          if (this.mToolbar.getWidth() != 0)
            break label416;
          dj.a(this.mToolbar, new ViewTreeObserver.OnGlobalLayoutListener()
          {
            public void onGlobalLayout()
            {
              if (MoreHeaderImpl.this.mToolbar.getWidth() != 0)
              {
                dj.b(MoreHeaderImpl.this.mToolbar, this);
                MoreHeaderImpl.this.mToolbarScrollController.init();
              }
            }
          });
        }
      }
    }
    while (true)
    {
      this.mAppBarLayout.addOnOffsetChangedListener(this.mToolbarScrollController);
      View localView2 = this.mRootView.findViewById(com.viber.voip.R.id.overlay);
      if (localView2 != null)
        this.mToolbarScrollListener = new MoreCollapsingOnScrollListener(dc.g(this.mRootView.getContext(), R.attr.toolbarBackground), localView2, (MoreToolbar)this.mToolbar);
      this.mCollapsingToolbarLayout = ((ObservableCollapsingToolbarLayout)this.mRootView.findViewById(com.viber.voip.R.id.collapsing_toolbar_layout));
      if (this.mCollapsingToolbarLayout != null)
        this.mCollapsingToolbarLayout.setOnScrollListener(this.mToolbarScrollListener);
      if ((this.mToolbar != null) && ((this.mFragment.getContext() instanceof z)))
        this.mToolbar.setNavigationIcon(null);
      return;
      View localView1 = getActionBarView(this.mFragment.getActivity(), this.mMoreScreenConfig.isDialog());
      if (localView1 == null)
        break;
      TextView localTextView = dj.f(localView1);
      if (localTextView == null)
        break;
      localTextView.setOnClickListener(new MoreHeaderImpl..Lambda.1(this));
      break;
      label416: this.mToolbarScrollController.init();
    }
  }

  public void setUserName(CharSequence paramCharSequence)
  {
    if (!isFragmentVisible());
    do
    {
      android.support.v7.app.a locala;
      do
      {
        return;
        if ((!this.mMoreScreenConfig.isLandscape()) && (!this.mMoreScreenConfig.isDialog()))
          break;
        locala = getActionBar();
      }
      while (locala == null);
      locala.a(paramCharSequence);
      return;
    }
    while (this.mToolbarCustomView == null);
    this.mToolbarCustomView.setTitle(paramCharSequence);
  }

  public void setUserPhoneNumber(CharSequence paramCharSequence)
  {
    if (!isFragmentVisible());
    do
    {
      android.support.v7.app.a locala;
      do
      {
        return;
        if ((!this.mMoreScreenConfig.isLandscape()) && (!this.mMoreScreenConfig.isDialog()))
          break;
        if (this.mToolbar != null)
        {
          this.mToolbar.setSubtitle(paramCharSequence);
          return;
        }
        locala = getActionBar();
      }
      while (locala == null);
      locala.b(paramCharSequence);
      return;
    }
    while (this.mToolbarCustomView == null);
    this.mToolbarCustomView.a(paramCharSequence, false);
  }

  public void setUserPhoto(Uri paramUri)
  {
    if ((isFragmentVisible()) && (ViberApplication.externalStorageMounted(this.mUserPhotoView.getContext(), false)))
      this.mImageFetcher.a(null, paramUri, this.mUserPhotoView, this.mFetcherConfig);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreHeaderImpl
 * JD-Core Version:    0.6.2
 */
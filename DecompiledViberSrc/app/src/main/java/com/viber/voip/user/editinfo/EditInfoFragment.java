package com.viber.voip.user.editinfo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Dialog;
import android.arch.lifecycle.e.b;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.OnScrollChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.e.a;
import com.viber.common.dialogs.i.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.a;
import com.viber.common.dialogs.m.b;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.m.d;
import com.viber.common.dialogs.m.e;
import com.viber.common.dialogs.z;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.o;
import com.viber.voip.av.e;
import com.viber.voip.i.c.j;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.k;
import com.viber.voip.permissions.n;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.settings.d.v;
import com.viber.voip.ui.ad;
import com.viber.voip.ui.aq;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.a.c.a;
import com.viber.voip.ui.dialogs.ae;
import com.viber.voip.ui.dialogs.j;
import com.viber.voip.ui.dialogs.t;
import com.viber.voip.user.UserDataEditHelper;
import com.viber.voip.user.UserDataEditHelper.Config;
import com.viber.voip.user.UserDataEditHelper.Listener;
import com.viber.voip.user.UserDataEditHelper.Listener..CC;
import com.viber.voip.user.UserManager;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.util.ParcelableInt;
import com.viber.voip.util.da;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.h.a;
import javax.inject.Inject;

public class EditInfoFragment extends aq
  implements View.OnClickListener, m.b, m.c, m.d, m.e, UserDataEditHelper.Listener, EditInfoView
{
  private static final int FADE_DURATION = 250;
  private static final int HIDE_KEYBOARD_SCROLL_THRESHOLD = 10;
  private static final Logger L = ViberEnv.getLogger();
  public static final int UPDATE_AVATAR_STATE_DELAY = 500;
  private ImageView mAvatar;
  private final m.a mBaseAgeKindSelectorDialogHandler = new c.a();
  private TextView mBirthDateBtn;
  private View mBirthDateTopDivider;
  private View mChangeAvatarBtn;
  private ConstraintLayout mConstraintLayout;

  @Inject
  com.viber.voip.app.b mDeviceConfiguration;
  private EditInfoArguments mEditInfoArguments;
  private EditInfoPresenter mEditInfoPresenter;
  private com.viber.voip.util.e.f mFetcherConfig;
  private TextView mGdprInfo;

  @Inject
  com.viber.voip.util.e.e mImageFetcher;
  private View mImportFromVkBtn;
  private TextView mInitials;
  private NestedScrollView mNestedScrollView;
  private final NestedScrollView.OnScrollChangeListener mNestedScrollViewListener = new EditInfoFragment..Lambda.1(this);
  private final h.a mOnAvatarLoadedListener = new EditInfoFragment..Lambda.0(this);
  private com.viber.common.permission.b mPermissionListener;

  @Inject
  c mPermissionManager;
  private View mPhoneNumberTopDividerView;
  private TextView mPhoneNumberView;
  private ViewStub mRakutenInfoStub;
  private View mRakutenView;
  private ViewStub mShadowLeftStub;
  private View mShadowLeftView;
  private ViewStub mShadowRightStub;
  private View mShadowRightView;
  private View mShadowStatusBar;
  private Toolbar mToolbar;
  private UserDataEditHelper mUserEditHelper;
  private TextView mUserEditName;
  private final TextWatcher mUserEditNameTextWatcher = new ad()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      EditInfoFragment.this.mEditInfoPresenter.onEditNameTextChanged(paramAnonymousEditable.toString());
    }
  };

  private void adjustSizes()
  {
    Resources localResources = getResources();
    int i = localResources.getDimensionPixelSize(R.dimen.edit_info_avatar_height);
    if (this.mAvatar.getLayoutParams() != null)
      this.mAvatar.getLayoutParams().height = i;
    if (isPhoneMode());
    for (int j = localResources.getDimensionPixelSize(R.dimen.edit_info_layout_in_phone_mode_width); ; j = localResources.getDimensionPixelSize(R.dimen.edit_info_layout_width))
    {
      if (this.mConstraintLayout.getLayoutParams() != null)
        this.mConstraintLayout.getLayoutParams().width = j;
      return;
    }
  }

  private void expandItemView(View paramView)
  {
    Resources localResources = getResources();
    com.viber.voip.ui.b.a.a(paramView, localResources.getDimensionPixelSize(R.dimen.edit_info_user_details_editable_item_height), true, localResources.getInteger(17694721)).start();
  }

  private boolean isPhoneMode()
  {
    FragmentActivity localFragmentActivity = requireActivity();
    return ((localFragmentActivity instanceof EditInfoPageDisplayState)) && (((EditInfoPageDisplayState)localFragmentActivity).isEditInfoPageInPhoneMode());
  }

  public static Fragment newInstance(int paramInt)
  {
    return newInstance(paramInt, 0);
  }

  public static Fragment newInstance(int paramInt1, int paramInt2)
  {
    EditInfoFragment localEditInfoFragment = new EditInfoFragment();
    Bundle localBundle = new Bundle(1);
    localBundle.putInt("details_mode_extra_key", paramInt1);
    localBundle.putInt("action_extra_key", paramInt2);
    localEditInfoFragment.setArguments(localBundle);
    return localEditInfoFragment;
  }

  private void reloadConfiguration()
  {
    adjustSizes();
    if ((this.mIsTablet) && (!isPhoneMode()) && (this.mDeviceConfiguration.a()));
    for (boolean bool = true; ; bool = false)
    {
      showShadows(bool);
      return;
    }
  }

  private void renderAvatarBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.mAvatar.setImageBitmap(paramBitmap);
      return;
    }
    this.mAvatar.setImageDrawable(null);
  }

  private void setupActionBar()
  {
    if ((this.mToolbar != null) && ((!this.mIsTablet) || (this.mEditInfoArguments.getAction() == 2)));
    for (boolean bool = true; ; bool = false)
    {
      if (bool)
      {
        AppCompatActivity localAppCompatActivity = (AppCompatActivity)requireActivity();
        localAppCompatActivity.setSupportActionBar(this.mToolbar);
        localAppCompatActivity.getSupportActionBar().b(true);
        localAppCompatActivity.getSupportActionBar().a(true);
        localAppCompatActivity.getSupportActionBar().c(false);
        if (this.mEditInfoArguments.getAction() == 2)
          this.mToolbar.setFitsSystemWindows(false);
      }
      dj.b(this.mToolbar, bool);
      return;
    }
  }

  private void showPhoneNumberView(boolean paramBoolean)
  {
    dj.b(this.mPhoneNumberTopDividerView, paramBoolean);
    dj.b(this.mPhoneNumberView, paramBoolean);
  }

  com.viber.voip.permissions.e createPermissionListener()
  {
    Pair[] arrayOfPair = new Pair[2];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(22);
    arrayOfPair[1] = com.viber.voip.permissions.m.a(142);
    return new com.viber.voip.permissions.e(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 22:
          EditInfoFragment.this.mUserEditHelper.takePhoto();
          return;
        case 142:
        }
        EditInfoFragment.this.mUserEditHelper.pickFromGallery();
      }
    };
  }

  public void hideBirthDate()
  {
    dj.b(this.mBirthDateBtn, false);
    dj.b(this.mBirthDateTopDivider, false);
  }

  public void hideImportFromVkButton()
  {
    dj.b(this.mImportFromVkBtn, false);
    this.mImportFromVkBtn.setOnClickListener(null);
  }

  public void hideRakutenAccountInfo()
  {
    dj.b(this.mRakutenView, false);
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.mUserEditHelper.setFragment(this);
    this.mUserEditHelper.setListener(this);
    this.mUserEditHelper.onRestoreInstanceState(paramBundle);
    if (paramBundle == null);
    for (Parcelable localParcelable = null; ; localParcelable = paramBundle.getParcelable("edit_info_parcel"))
    {
      this.mEditInfoPresenter.attachView(this, localParcelable);
      return;
    }
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.mUserEditHelper.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
  }

  public boolean onBackPressed()
  {
    this.mEditInfoPresenter.onBackPressed();
    return super.onBackPressed();
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.changeAvatarButton)
      this.mEditInfoPresenter.onChangePhotoClicked();
    while (true)
    {
      dj.a(this.mUserEditName, true);
      return;
      if (i == R.id.birthDateView)
        this.mEditInfoPresenter.onBirthDateClicked();
      else if (i == R.id.importFromFbButton)
        this.mEditInfoPresenter.onImportFromFacebook();
      else if (i == R.id.importFromVkButton)
        this.mEditInfoPresenter.onImportFromVK();
      else if (i == R.id.emailTextView)
        this.mEditInfoPresenter.onEmailClicked();
      else if (i == R.id.changePasswordView)
        this.mEditInfoPresenter.onPasswordClicked();
      else if (i == R.id.continueButtonView)
        this.mEditInfoPresenter.onContinueClicked();
      else if (i == R.id.avatarView)
        this.mEditInfoPresenter.onAvatarViewClicked();
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    reloadConfiguration();
    this.mEditInfoPresenter.onConfigurationChanged();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mFetcherConfig = new com.viber.voip.util.e.f.a().a(true).b(Integer.valueOf(R.drawable.transparent_view)).a(com.viber.voip.b.a.j).c();
    final ViberApplication localViberApplication = ViberApplication.getInstance();
    UserManager localUserManager = UserManager.from(requireActivity());
    UserInfoRepository localUserInfoRepository = new UserInfoRepository(localUserManager, new com.viber.voip.g.b.b()
    {
      protected ci initInstance()
      {
        return localViberApplication.getMessagesManager().e();
      }
    });
    com.viber.voip.g.b.b local3 = new com.viber.voip.g.b.b()
    {
      protected ActivationController initInstance()
      {
        return localViberApplication.getActivationController();
      }
    };
    this.mUserEditHelper = new UserDataEditHelper(requireActivity(), UserDataEditHelper.Config.YOU);
    this.mEditInfoArguments = EditInfoArguments.extract(getArguments(), requireActivity().getIntent().getExtras());
    Context localContext = requireContext();
    this.mEditInfoPresenter = new EditInfoPresenter(localUserInfoRepository, localUserInfoRepository, localUserInfoRepository, av.e.a.a(), new VkHelperImpl(), ViberApplication.getInstance().getEngine(false).getCdrController(), localUserManager.getUserData(), localUserManager.getProfileNotification(), new Router(requireActivity()), new MountedDriveCheckerImpl(localContext), com.viber.voip.h.a.b(), localViberApplication.getViberIdController().getEventBus(), c.j.a, c.j.b, c.j.c, d.v.i, d.v.h, com.viber.voip.gdpr.f.a(localContext), ViberApplication.getInstance().getLocaleDataCache().b(), g.a().c().b(), g.a().c().j(), this.mEditInfoArguments, local3, this.mUserEditHelper);
    this.mPermissionListener = createPermissionListener();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.fragment_edit_info, paramViewGroup, false);
    this.mToolbar = ((Toolbar)localView.findViewById(R.id.toolbar));
    setupActionBar();
    this.mConstraintLayout = ((ConstraintLayout)localView.findViewById(R.id.constraintLayout));
    this.mShadowLeftStub = ((ViewStub)localView.findViewById(R.id.leftShadowStubView));
    this.mShadowRightStub = ((ViewStub)localView.findViewById(R.id.rightShadowStubView));
    this.mShadowStatusBar = localView.findViewById(R.id.statusBarShadow);
    this.mAvatar = ((ImageView)localView.findViewById(R.id.avatarView));
    this.mAvatar.setOnClickListener(this);
    this.mInitials = ((TextView)localView.findViewById(R.id.initials));
    this.mNestedScrollView = ((NestedScrollView)localView.findViewById(R.id.nestedScrollView));
    this.mNestedScrollView.setOnScrollChangeListener(this.mNestedScrollViewListener);
    this.mUserEditName = ((TextView)localView.findViewById(R.id.nameView));
    this.mUserEditName.addTextChangedListener(this.mUserEditNameTextWatcher);
    this.mUserEditName.setOnFocusChangeListener(new EditInfoFragment..Lambda.2(this));
    this.mPhoneNumberTopDividerView = localView.findViewById(R.id.phoneNumberTopDividerView);
    this.mPhoneNumberView = ((TextView)localView.findViewById(R.id.phoneNumberView));
    this.mChangeAvatarBtn = localView.findViewById(R.id.changeAvatarButton);
    this.mChangeAvatarBtn.setOnClickListener(this);
    this.mBirthDateTopDivider = localView.findViewById(R.id.birthDateTopDividerView);
    this.mBirthDateBtn = ((TextView)localView.findViewById(R.id.birthDateView));
    this.mBirthDateBtn.setOnClickListener(this);
    this.mBirthDateBtn.setVisibility(0);
    localView.findViewById(R.id.importFromFbButton).setOnClickListener(this);
    this.mImportFromVkBtn = localView.findViewById(R.id.importFromVkButton);
    this.mRakutenInfoStub = ((ViewStub)localView.findViewById(R.id.rakutenAccountStubView));
    this.mRakutenView = null;
    this.mGdprInfo = ((TextView)localView.findViewById(R.id.gdprInfoView));
    this.mGdprInfo.setHighlightColor(0);
    this.mGdprInfo.setText(dg.a(Html.fromHtml(getResources().getString(R.string.edit_your_details_gdpr_info))));
    this.mGdprInfo.setMovementMethod(LinkMovementMethod.getInstance());
    reloadConfiguration();
    return localView;
  }

  public void onDateSet(com.viber.common.dialogs.m paramm, DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramm.a(DialogCode.D_USER_BIRTH_DATE))
      this.mEditInfoPresenter.onBirthDateSelected(paramInt3, paramInt2, paramInt1);
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.mEditInfoPresenter.detachView();
    this.mNestedScrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener)null);
    this.mUserEditHelper.setListener(null);
    this.mUserEditHelper.setFragment(null);
    this.mUserEditName.removeTextChangedListener(this.mUserEditNameTextWatcher);
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (paramInt == -1)
    {
      if (!paramm.a(DialogCode.D442a))
        break label23;
      this.mEditInfoPresenter.importFromFacebookConfirmed();
    }
    label23: 
    while (!paramm.a(DialogCode.D442b))
      return;
    this.mEditInfoPresenter.importFromVkConfirmed();
  }

  public void onDialogDataListAction(com.viber.common.dialogs.m paramm, int paramInt, Object paramObject)
  {
    int i;
    if (paramm.a(DialogCode.D460a))
    {
      i = ((ParcelableInt)paramObject).getValue();
      if (-2 != i)
        break label35;
      this.mEditInfoPresenter.onContinueWithAgeKindSelected(1);
    }
    label35: 
    while (-1 != i)
      return;
    this.mEditInfoPresenter.onContinueWithAgeKindSelected(2);
  }

  public void onDialogDataListBind(com.viber.common.dialogs.m paramm, i.a parama)
  {
    this.mBaseAgeKindSelectorDialogHandler.onDialogDataListBind(paramm, parama);
  }

  public void onError(int paramInt)
  {
    this.mEditInfoPresenter.onEditUserDetailsError(paramInt);
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    super.onFragmentVisibilityChanged(paramBoolean);
    if (!paramBoolean)
    {
      FragmentActivity localFragmentActivity = getActivity();
      if ((localFragmentActivity != null) && (localFragmentActivity.getLifecycle().a().a(e.b.c)))
        this.mEditInfoPresenter.onPageBecomeInvisible();
    }
  }

  public void onFromFacebookImported(String paramString, Uri paramUri)
  {
    this.mEditInfoPresenter.onEditNameImported(paramString);
    this.mEditInfoPresenter.updateUserAvatar(paramUri);
    this.mEditInfoPresenter.onFromFacebookImported();
  }

  public void onFromVKImported(String paramString, Uri paramUri)
  {
    this.mEditInfoPresenter.onEditNameImported(paramString);
    this.mEditInfoPresenter.updateUserAvatar(paramUri);
  }

  public void onGalleryPermissionRequested()
  {
    this.mPermissionManager.a(this, 142, n.m);
  }

  public void onImportFromSocialNetwork(@EditInfoView.SocialNetworkType int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
      this.mUserEditHelper.importFromFacebook();
      return;
    case 2:
    }
    this.mUserEditHelper.importFromVK();
  }

  public void onNameEdited(String paramString)
  {
    UserDataEditHelper.Listener..CC.onNameEdited(this, paramString);
  }

  public void onPhotoCropped(Uri paramUri)
  {
    this.mEditInfoPresenter.updateUserAvatar(paramUri);
  }

  public void onPhotoRemoved()
  {
    this.mEditInfoPresenter.removeUserAvatar();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.mUserEditHelper.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("edit_info_parcel", this.mEditInfoPresenter.getState());
  }

  public void onStart()
  {
    super.onStart();
    this.mPermissionManager.a(this.mPermissionListener);
  }

  public void onStop()
  {
    super.onStop();
    this.mPermissionManager.b(this.mPermissionListener);
    this.mEditInfoPresenter.onPageBecomeInvisible();
  }

  public void onTakePhotoPermissionRequested()
  {
    this.mPermissionManager.a(this, 22, n.c);
  }

  public void renderAvatar(Uri paramUri)
  {
    this.mImageFetcher.a(null, paramUri, null, this.mFetcherConfig, this.mOnAvatarLoadedListener);
  }

  public void renderChangePhotoState()
  {
    ae.i().a(new m.a()
    {
      public void onDialogShow(com.viber.common.dialogs.m paramAnonymousm)
      {
        EditInfoFragment.this.mEditInfoPresenter.onShowPhotoPickerDialog();
      }
    }).a(false).c(true).b(this);
  }

  public void renderDefaultAvatar(boolean paramBoolean)
  {
    if (this.mEditInfoPresenter.isDefaultAvatar())
      return;
    final Drawable localDrawable1 = dc.g(getActivity(), R.attr.editProfileDefaultAvatarDrawable);
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19))
    {
      Drawable localDrawable2 = this.mAvatar.getDrawable();
      PropertyValuesHolder[] arrayOfPropertyValuesHolder = new PropertyValuesHolder[1];
      arrayOfPropertyValuesHolder[0] = PropertyValuesHolder.ofInt("alpha", new int[] { 255, 0 });
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(localDrawable2, arrayOfPropertyValuesHolder);
      localObjectAnimator.setDuration(250L);
      localObjectAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          super.onAnimationEnd(paramAnonymousAnimator);
          EditInfoFragment.this.mAvatar.setImageDrawable(localDrawable1);
          Drawable localDrawable = localDrawable1;
          PropertyValuesHolder[] arrayOfPropertyValuesHolder = new PropertyValuesHolder[1];
          arrayOfPropertyValuesHolder[0] = PropertyValuesHolder.ofInt("alpha", new int[] { 0, 255 });
          ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(localDrawable, arrayOfPropertyValuesHolder);
          localObjectAnimator.setDuration(250L);
          localObjectAnimator.start();
        }
      });
      localObjectAnimator.start();
      return;
    }
    this.mAvatar.setImageDrawable(localDrawable1);
  }

  public void renderEmptyNameAvatar(boolean paramBoolean)
  {
    if (this.mEditInfoPresenter.isEmptyNameAvatar())
      return;
    int i = dc.d(getActivity(), R.attr.editProfileEmptyNameAvatarTint);
    final Drawable localDrawable1 = df.a(ContextCompat.getDrawable(getActivity(), R.drawable.edit_profile_empty_name_avatar_placeholder), i, true);
    if (paramBoolean)
    {
      Drawable localDrawable2 = this.mAvatar.getDrawable();
      PropertyValuesHolder[] arrayOfPropertyValuesHolder = new PropertyValuesHolder[1];
      arrayOfPropertyValuesHolder[0] = PropertyValuesHolder.ofInt("alpha", new int[] { 255, 0 });
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(localDrawable2, arrayOfPropertyValuesHolder);
      localObjectAnimator.setDuration(250L);
      localObjectAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          super.onAnimationEnd(paramAnonymousAnimator);
          EditInfoFragment.this.mAvatar.setImageDrawable(localDrawable1);
          Drawable localDrawable = localDrawable1;
          PropertyValuesHolder[] arrayOfPropertyValuesHolder = new PropertyValuesHolder[1];
          arrayOfPropertyValuesHolder[0] = PropertyValuesHolder.ofInt("alpha", new int[] { 0, 255 });
          ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(localDrawable, arrayOfPropertyValuesHolder);
          localObjectAnimator.setDuration(250L);
          localObjectAnimator.start();
        }
      });
      localObjectAnimator.start();
      return;
    }
    this.mAvatar.setImageDrawable(localDrawable1);
  }

  public void renderPhoneNumber(String paramString)
  {
    this.mPhoneNumberView.setText(paramString);
  }

  public void renderPhotoPickerDialog(boolean paramBoolean)
  {
    com.viber.common.dialogs.m localm = z.c(getFragmentManager(), DialogCode.D4010);
    View localView;
    if (localm != null)
    {
      Dialog localDialog = localm.getDialog();
      localDialog.findViewById(R.id.select_from_gallery).setOnClickListener(new EditInfoFragment..Lambda.4(this, localm));
      localDialog.findViewById(R.id.take_new_photo).setOnClickListener(new EditInfoFragment..Lambda.5(this, localm));
      localView = localDialog.findViewById(R.id.remove_photo);
      if (paramBoolean)
        localView.setOnClickListener(new EditInfoFragment..Lambda.6(this, localm));
    }
    else
    {
      return;
    }
    dj.b(localView, false);
  }

  public void renderRakutenAccountInfo(String paramString)
  {
    if (this.mRakutenView == null)
      this.mRakutenView = this.mRakutenInfoStub.inflate();
    dj.b(this.mRakutenView, true);
    TextView localTextView = (TextView)this.mRakutenView.findViewById(R.id.emailTextView);
    localTextView.setText(paramString);
    localTextView.setOnClickListener(this);
    this.mRakutenView.findViewById(R.id.changePasswordView).setOnClickListener(this);
  }

  public void renderRegistrationMode()
  {
    View localView = dj.e(getView(), R.id.continueButtonContainerView);
    dj.b(localView, true);
    localView.findViewById(R.id.continueButtonView).setOnClickListener(this);
    int i = getResources().getDimensionPixelOffset(R.dimen.edit_info_bottom_virtual_space);
    ((ViewGroup.MarginLayoutParams)this.mGdprInfo.getLayoutParams()).bottomMargin = i;
    this.mGdprInfo.setLayoutParams(this.mGdprInfo.getLayoutParams());
  }

  public void renderUserName(String paramString)
  {
    this.mUserEditName.setText(paramString);
  }

  public void showAgeKindSelector()
  {
    j.g().a(this).b(true).b(this);
  }

  public void showBirthDateSelector(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    j.a(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2).a(this).b(this);
  }

  public void showConnectToSocialNetworkDialog(@EditInfoView.SocialNetworkType int paramInt)
  {
    l.a locala = null;
    switch (paramInt)
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      if (locala != null)
        locala.a(this).b(this);
      return;
      locala = t.o();
      continue;
      locala = t.p();
    }
  }

  public void showExactBirthDate(String paramString)
  {
    dj.b(this.mBirthDateTopDivider, true);
    expandItemView(this.mBirthDateBtn);
    this.mBirthDateBtn.setText(paramString);
  }

  public void showFbImportError()
  {
    ViberApplication.getInstance().showToast(R.string.facebook_details_import_failed);
  }

  public void showImportFromVkButton()
  {
    dj.b(this.mImportFromVkBtn, true);
    this.mImportFromVkBtn.setOnClickListener(this);
  }

  public void showInexactBirthDate(int paramInt)
  {
    dj.b(this.mBirthDateTopDivider, true);
    expandItemView(this.mBirthDateBtn);
    switch (paramInt)
    {
    default:
      return;
    case 2:
      this.mBirthDateBtn.setText(R.string.grown_up_user_age);
      return;
    case 1:
    }
    this.mBirthDateBtn.setText(R.string.minor_user_age);
  }

  public void showInitials(String paramString, boolean paramBoolean)
  {
    if (this.mInitials.getText().equals(paramString))
      return;
    if (paramBoolean)
    {
      if (da.a(this.mInitials.getText()))
      {
        this.mInitials.setAlpha(0.0F);
        this.mInitials.setText(paramString);
        this.mInitials.animate().alpha(1.0F).setDuration(250L).setStartDelay(250L).start();
        return;
      }
      if (!da.a(paramString))
      {
        this.mInitials.animate().alpha(0.0F).setDuration(250L).withEndAction(new EditInfoFragment..Lambda.3(this, paramString)).start();
        return;
      }
      this.mInitials.setText(paramString);
      this.mInitials.animate().alpha(0.0F).setDuration(250L).start();
      return;
    }
    this.mInitials.setText(paramString);
  }

  public void showShadows(boolean paramBoolean)
  {
    if ((this.mShadowLeftView == null) && (paramBoolean) && (this.mShadowLeftStub != null))
      this.mShadowLeftView = this.mShadowLeftStub.inflate();
    if ((this.mShadowRightView == null) && (paramBoolean) && (this.mShadowRightStub != null))
      this.mShadowRightView = this.mShadowRightStub.inflate();
    dj.b(this.mShadowRightView, paramBoolean);
    dj.b(this.mShadowLeftView, paramBoolean);
  }

  public void showStatusBarShadow(boolean paramBoolean)
  {
    View localView = this.mShadowStatusBar;
    if ((!this.mIsTablet) && (paramBoolean));
    for (boolean bool = true; ; bool = false)
    {
      dj.b(localView, bool);
      return;
    }
  }

  public void showVkImportError()
  {
    ViberApplication.getInstance().showToast(R.string.vk_details_import_failed);
  }

  public void updatePhoneNumberVisibility(boolean paramBoolean)
  {
    if ((this.mIsTablet) && (paramBoolean));
    for (boolean bool = true; ; bool = false)
    {
      showPhoneNumberView(bool);
      return;
    }
  }

  public static abstract interface EditInfoPageDisplayState
  {
    public abstract boolean isEditInfoPageInPhoneMode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.EditInfoFragment
 * JD-Core Version:    0.6.2
 */
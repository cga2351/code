package com.viber.voip.user.editinfo;

import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.common.b.b;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.analytics.story.i.c;
import com.viber.voip.i.f.a;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.settings.d.a;
import com.viber.voip.settings.d.al;
import com.viber.voip.user.ProfileNotification;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserData.OwnerChangedEvent;
import com.viber.voip.user.UserDataEditHelper;
import com.viber.voip.user.viberid.ViberIdEvents.ViberIdInfoChangedEvent;
import com.viber.voip.user.viberid.ViberIdInfo;
import com.viber.voip.util.cl;
import com.viber.voip.util.da;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.DateFormat;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EditInfoPresenter
{
  public static final String PARCEL_KEY = "edit_info_parcel";
  private static final EditInfoView STUB_VIEW = (EditInfoView)cl.b(EditInfoView.class);
  private final dagger.a<ActivationController> mActivationController;
  private final EditInfoArguments mArguments;
  private int mAvatarState = 0;
  private final SharedPreferences.OnSharedPreferenceChangeListener mBirthdateChangeListener;
  private final ICdrController mCdrController;
  private final DateFormat mDateFormat;
  private final MountedDriveChecker mDriveChecker;
  private final EventBus mEventBus;
  private final com.viber.voip.i.f mGdprFeatureSwitcher;
  private final f.a mGdprPrimaryOnlyFeatureListener = new EditInfoPresenter..Lambda.1(this);
  private final com.viber.voip.i.f mGdprPrimaryOnlyFeatureSwitcher;
  private final com.viber.voip.i.f mGlobalGdprFeatureSwitcher;
  private final ProfileImageRepository mImageRepository;
  private Runnable mNameChangedCallback = new EditInfoPresenter..Lambda.0(this);
  private final ProfileNameRepository mNameRepository;
  private final com.viber.voip.analytics.story.f.d mOnboardingTracker;
  private final ProfileNotification mProfileNotification;
  private final ProfileNumberRepository mProfileNumberRepository;
  private final c mProfileTracker;
  private final EditInfoRouter mRouter;
  private State mState;
  private Handler mUiHandler;
  private final com.viber.common.b.d mUserAgeKind;
  private final com.viber.common.b.e mUserBirthDateGmtMillis;
  private final com.viber.voip.gdpr.f mUserBirthdateAgeSynchronizer;
  private final UserData mUserData;
  private UserDataEditHelper mUserEditHelper;
  private final EventBus mViberIdControllerEventBus;
  private EditInfoView mView = STUB_VIEW;
  private final VkHelper mVkHelper;

  public EditInfoPresenter(ProfileNameRepository paramProfileNameRepository, ProfileNumberRepository paramProfileNumberRepository, ProfileImageRepository paramProfileImageRepository, Handler paramHandler, VkHelper paramVkHelper, ICdrController paramICdrController, UserData paramUserData, ProfileNotification paramProfileNotification, EditInfoRouter paramEditInfoRouter, MountedDriveChecker paramMountedDriveChecker, EventBus paramEventBus1, EventBus paramEventBus2, com.viber.voip.i.f paramf1, com.viber.voip.i.f paramf2, com.viber.voip.i.f paramf3, com.viber.common.b.e parame, com.viber.common.b.d paramd, com.viber.voip.gdpr.f paramf, DateFormat paramDateFormat, com.viber.voip.analytics.story.f.d paramd1, c paramc, EditInfoArguments paramEditInfoArguments, dagger.a<ActivationController> parama, UserDataEditHelper paramUserDataEditHelper)
  {
    this.mNameRepository = paramProfileNameRepository;
    this.mImageRepository = paramProfileImageRepository;
    this.mProfileNumberRepository = paramProfileNumberRepository;
    this.mVkHelper = paramVkHelper;
    this.mCdrController = paramICdrController;
    this.mUserData = paramUserData;
    this.mProfileNotification = paramProfileNotification;
    this.mRouter = paramEditInfoRouter;
    this.mDriveChecker = paramMountedDriveChecker;
    this.mEventBus = paramEventBus1;
    this.mViberIdControllerEventBus = paramEventBus2;
    this.mGdprFeatureSwitcher = paramf1;
    this.mGlobalGdprFeatureSwitcher = paramf2;
    this.mGdprPrimaryOnlyFeatureSwitcher = paramf3;
    this.mUserBirthDateGmtMillis = parame;
    this.mUserAgeKind = paramd;
    this.mUserBirthdateAgeSynchronizer = paramf;
    this.mDateFormat = paramDateFormat;
    this.mOnboardingTracker = paramd1;
    this.mProfileTracker = paramc;
    this.mArguments = paramEditInfoArguments;
    this.mActivationController = parama;
    this.mUiHandler = paramHandler;
    this.mUserEditHelper = paramUserDataEditHelper;
    this.mBirthdateChangeListener = new d.al(paramHandler, new com.viber.common.b.a[] { parame })
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        EditInfoPresenter.this.renderBirthDate();
      }
    };
  }

  private void commitTemporaryChanges()
  {
    if (this.mState.mIsPhotoChangedByUser)
    {
      this.mImageRepository.updateAvatar(this.mState.getAvatarUri());
      this.mProfileTracker.b("Photo");
    }
    if ((this.mState.mIsNameChangedByUser) && ((!da.a(this.mState.getName())) || (d.a.j.d())))
    {
      this.mNameRepository.changeName(this.mState.getName());
      this.mProfileTracker.b("Name");
    }
    renderCurrentStateName();
    this.mState = copyState(this.mState.getName(), this.mState.getAvatarUri(), false, false);
  }

  private void completeRegistration()
  {
    commitTemporaryChanges();
    this.mOnboardingTracker.b(this.mState.isFacebookImported());
    ((ActivationController)this.mActivationController.get()).setStep(18, true);
  }

  private State copyState(Uri paramUri, boolean paramBoolean)
  {
    boolean bool = this.mDriveChecker.checkIsMounted(false);
    Uri localUri = null;
    if (bool)
      localUri = paramUri;
    return new State(this.mState.getName(), localUri, this.mState.isFacebookImported(), this.mState.getNumber(), this.mState.mIsNameChangedByUser, paramBoolean);
  }

  private State copyState(String paramString, Uri paramUri, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = this.mDriveChecker.checkIsMounted(false);
    Uri localUri = null;
    if (bool)
      localUri = paramUri;
    return new State(paramString, localUri, this.mState.isFacebookImported(), this.mState.getNumber(), paramBoolean1, paramBoolean2);
  }

  private State createState(String paramString1, Uri paramUri, String paramString2)
  {
    boolean bool = this.mDriveChecker.checkIsMounted(false);
    Uri localUri = null;
    if (bool)
      localUri = paramUri;
    return new State(paramString1, localUri, false, paramString2, false, false);
  }

  private void initState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof State))
    {
      this.mState = ((State)paramParcelable);
      return;
    }
    this.mState = createState(this.mNameRepository.getName(), this.mImageRepository.getImageUri(), this.mProfileNumberRepository.getPhoneNumberWithPlus());
  }

  private void onContinueRegistrationClicked()
  {
    if ((this.mGdprPrimaryOnlyFeatureSwitcher.e()) && (this.mUserAgeKind.d() == 0))
    {
      this.mView.showAgeKindSelector();
      return;
    }
    completeRegistration();
  }

  private void processAction()
  {
    if (1 == this.mArguments.getAction())
      this.mView.renderChangePhotoState();
  }

  private void renderBirthDate()
  {
    if (this.mGdprPrimaryOnlyFeatureSwitcher.e())
    {
      long l = this.mUserBirthDateGmtMillis.d();
      if (l == this.mUserBirthDateGmtMillis.f())
      {
        this.mView.showInexactBirthDate(this.mUserAgeKind.d());
        return;
      }
      this.mView.showExactBirthDate(com.viber.voip.gdpr.e.a(l).a(this.mDateFormat));
      return;
    }
    this.mView.hideBirthDate();
  }

  private void renderCurrentState()
  {
    renderCurrentStateName();
    renderCurrentStateAvatar(false);
    this.mView.renderPhoneNumber(this.mState.mNumber);
  }

  private void renderCurrentStateAvatar(boolean paramBoolean)
  {
    int i = 1;
    Uri localUri = this.mState.getAvatarUri();
    String str = da.g(this.mState.getName());
    int j;
    if (localUri != null)
    {
      this.mView.renderAvatar(localUri);
      this.mView.showInitials("", paramBoolean);
      EditInfoView localEditInfoView = this.mView;
      if (i != this.mArguments.getDetailsMode());
      while (true)
      {
        localEditInfoView.showStatusBarShadow(i);
        this.mAvatarState = 3;
        return;
        j = 0;
      }
    }
    if (da.a(str))
    {
      this.mView.renderEmptyNameAvatar(paramBoolean);
      this.mView.showInitials("", paramBoolean);
    }
    for (this.mAvatarState = j; ; this.mAvatarState = 2)
    {
      this.mView.showStatusBarShadow(false);
      return;
      this.mView.renderDefaultAvatar(paramBoolean);
      this.mView.showInitials(str, paramBoolean);
    }
  }

  private void renderCurrentStateName()
  {
    if (da.a(this.mState.getName()))
    {
      this.mView.renderUserName("");
      return;
    }
    this.mView.renderUserName(this.mState.getName());
  }

  private void renderRakutenAccountInfo()
  {
    if (1 == this.mArguments.getDetailsMode())
    {
      this.mView.hideRakutenAccountInfo();
      return;
    }
    ViberIdInfo localViberIdInfo = this.mUserData.getViberIdInfo();
    if ((localViberIdInfo.isAccountExist()) && (localViberIdInfo.isRegisteredOnCurrentDevice()))
    {
      this.mView.renderRakutenAccountInfo(localViberIdInfo.getEmail());
      return;
    }
    this.mView.hideRakutenAccountInfo();
  }

  private void renderVKAvailability()
  {
    if (this.mVkHelper.isVKEnabled())
    {
      this.mView.showImportFromVkButton();
      return;
    }
    this.mView.hideImportFromVkButton();
  }

  private void updatePhoneNumberVisibility()
  {
    EditInfoView localEditInfoView = this.mView;
    if (this.mArguments.getDetailsMode() == 0);
    for (boolean bool = true; ; bool = false)
    {
      localEditInfoView.updatePhoneNumberVisibility(bool);
      return;
    }
  }

  public void attachView(EditInfoView paramEditInfoView, Parcelable paramParcelable)
  {
    int i = 1;
    this.mView = paramEditInfoView;
    initState(paramParcelable);
    this.mEventBus.register(this);
    if (!this.mViberIdControllerEventBus.isRegistered(this))
      this.mViberIdControllerEventBus.register(this);
    com.viber.voip.settings.d.a(this.mBirthdateChangeListener);
    this.mGdprPrimaryOnlyFeatureSwitcher.a(this.mGdprPrimaryOnlyFeatureListener);
    renderCurrentState();
    renderBirthDate();
    renderVKAvailability();
    renderRakutenAccountInfo();
    this.mProfileNotification.clear();
    if (i == this.mArguments.getDetailsMode())
    {
      this.mView.renderRegistrationMode();
      if (paramParcelable == null)
        this.mOnboardingTracker.a();
    }
    updatePhoneNumberVisibility();
    processAction();
    c localc;
    String str;
    int k;
    int n;
    if (this.mArguments.getMixpanelEntryPoint() != null)
    {
      localc = this.mProfileTracker;
      str = this.mArguments.getMixpanelEntryPoint();
      if (da.a(this.mState.mName))
        break label227;
      k = i;
      if (this.mUserBirthDateGmtMillis.f() == this.mUserBirthDateGmtMillis.d())
        break label233;
      n = i;
      label183: if (this.mState.getAvatarUri() == null)
        break label239;
    }
    while (true)
    {
      localc.a(str, k, n, i);
      this.mCdrController.handleReportScreenDisplay(9, this.mArguments.getCdrEntryPoint());
      return;
      label227: int m = 0;
      break;
      label233: int i1 = 0;
      break label183;
      label239: int j = 0;
    }
  }

  public void detachView()
  {
    this.mView = STUB_VIEW;
    this.mEventBus.unregister(this);
    if (this.mViberIdControllerEventBus.isRegistered(this))
      this.mViberIdControllerEventBus.unregister(this);
    com.viber.voip.settings.d.b(this.mBirthdateChangeListener);
    this.mGdprPrimaryOnlyFeatureSwitcher.b(this.mGdprPrimaryOnlyFeatureListener);
  }

  public State getState()
  {
    return this.mState;
  }

  public void importFromFacebookConfirmed()
  {
    this.mView.onImportFromSocialNetwork(1);
  }

  public void importFromVkConfirmed()
  {
    this.mView.onImportFromSocialNetwork(2);
  }

  public boolean isDefaultAvatar()
  {
    return this.mAvatarState == 2;
  }

  public boolean isEmptyNameAvatar()
  {
    return this.mAvatarState == 1;
  }

  public void onAvatarViewClicked()
  {
    this.mView.renderChangePhotoState();
    this.mProfileTracker.a("Tap on Image");
  }

  public void onBackPressed()
  {
    commitTemporaryChanges();
  }

  public void onBirthDateClicked()
  {
    long l = this.mUserBirthDateGmtMillis.d();
    int i;
    int j;
    if (l == this.mUserBirthDateGmtMillis.f())
    {
      i = com.viber.voip.gdpr.d.e;
      j = com.viber.voip.gdpr.d.d;
    }
    com.viber.voip.gdpr.e locale;
    for (int k = com.viber.voip.gdpr.d.c; ; k = locale.d())
    {
      this.mView.showBirthDateSelector(i, j, k, com.viber.voip.gdpr.d.d(), com.viber.voip.gdpr.d.e());
      this.mProfileTracker.a("Birth Date");
      return;
      locale = com.viber.voip.gdpr.e.a(l);
      i = locale.f();
      j = locale.e();
    }
  }

  public void onBirthDateSelected(int paramInt1, int paramInt2, int paramInt3)
  {
    com.viber.voip.gdpr.e locale = com.viber.voip.gdpr.e.a(paramInt1, paramInt2, paramInt3);
    this.mUserBirthdateAgeSynchronizer.a(locale.b());
    this.mProfileTracker.b("Birth Date");
  }

  public void onChangePhotoClicked()
  {
    this.mView.renderChangePhotoState();
    this.mProfileTracker.a("Camera icon");
  }

  public void onConfigurationChanged()
  {
    renderCurrentStateAvatar(false);
    updatePhoneNumberVisibility();
  }

  public void onContinueClicked()
  {
    if (1 == this.mArguments.getDetailsMode())
      onContinueRegistrationClicked();
  }

  public void onContinueWithAgeKindSelected(int paramInt)
  {
    this.mUserBirthdateAgeSynchronizer.a(paramInt);
    completeRegistration();
  }

  public void onEditNameImported(String paramString)
  {
    this.mState = this.mState.copyWith(da.d(paramString), true);
    renderCurrentStateName();
  }

  public void onEditNameTextChanged(String paramString)
  {
    this.mUiHandler.removeCallbacks(this.mNameChangedCallback);
    if (paramString.equals(this.mState.getName()))
    {
      this.mUiHandler.postDelayed(this.mNameChangedCallback, 500L);
      return;
    }
    if ((da.b(paramString)) && (!d.a.j.d()));
    for (this.mState = this.mState.copyWith("", false); ; this.mState = this.mState.copyWith(da.d(paramString), true))
    {
      this.mUiHandler.postDelayed(this.mNameChangedCallback, 500L);
      return;
    }
  }

  public void onEditUserDetailsError(int paramInt)
  {
    if (1 == paramInt)
      this.mView.showFbImportError();
    while (true)
    {
      if ((1 == paramInt) || (3 == paramInt))
        this.mCdrController.handleReportFacebookStatistics("", "", 99);
      return;
      if (3 == paramInt)
        this.mView.showVkImportError();
    }
  }

  public void onEmailClicked()
  {
    this.mRouter.goToChangeEmailScreen();
  }

  public void onFromFacebookImported()
  {
    this.mState = new State(this.mState.getName(), this.mState.getAvatarUri(), true, this.mState.getNumber(), true, true);
  }

  public void onImportFromFacebook()
  {
    if ((this.mGdprFeatureSwitcher.e()) || (this.mGlobalGdprFeatureSwitcher.e()))
      this.mView.showConnectToSocialNetworkDialog(1);
    while (true)
    {
      this.mProfileTracker.a("Facebook Connect");
      return;
      this.mView.onImportFromSocialNetwork(1);
    }
  }

  public void onImportFromVK()
  {
    if ((this.mGdprFeatureSwitcher.e()) || (this.mGlobalGdprFeatureSwitcher.e()))
      this.mView.showConnectToSocialNetworkDialog(2);
    while (true)
    {
      this.mProfileTracker.a("VK Connect");
      return;
      this.mView.onImportFromSocialNetwork(2);
    }
  }

  public void onNameClicked()
  {
    this.mProfileTracker.a("Name");
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onOwnerChanged(UserData.OwnerChangedEvent paramOwnerChangedEvent)
  {
    String str = this.mNameRepository.getName();
    if (!this.mState.mIsNameChangedByUser)
    {
      this.mState = copyState(str, this.mState.getAvatarUri(), false, this.mState.mIsPhotoChangedByUser);
      renderCurrentStateName();
    }
    Uri localUri = this.mImageRepository.getImageUri();
    if (!this.mState.mIsPhotoChangedByUser)
    {
      this.mState = copyState(this.mState.getName(), localUri, this.mState.mIsNameChangedByUser, false);
      renderCurrentStateAvatar(false);
    }
  }

  public void onPageBecomeInvisible()
  {
    commitTemporaryChanges();
  }

  public void onPasswordClicked()
  {
    this.mRouter.goToChangePasswordScreen();
  }

  public void onPickFromGalleryClicked()
  {
    this.mUserEditHelper.pickFromGallery();
  }

  public void onRemovePhotoClicked()
  {
    this.mUserEditHelper.removePhoto();
  }

  public void onShowPhotoPickerDialog()
  {
    EditInfoView localEditInfoView = this.mView;
    if (this.mState.mAvatarUri != null);
    for (boolean bool = true; ; bool = false)
    {
      localEditInfoView.renderPhotoPickerDialog(bool);
      return;
    }
  }

  public void onTakePhotoClicked()
  {
    this.mUserEditHelper.takePhoto();
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onViberIdInfoChanged(ViberIdEvents.ViberIdInfoChangedEvent paramViberIdInfoChangedEvent)
  {
    renderRakutenAccountInfo();
  }

  public void removeUserAvatar()
  {
    this.mState = copyState(null, true);
    renderCurrentStateAvatar(false);
  }

  public void updateUserAvatar(Uri paramUri)
  {
    if (paramUri == null)
      return;
    this.mState = copyState(paramUri, true);
    renderCurrentStateAvatar(false);
  }

  @Retention(RetentionPolicy.SOURCE)
  public static @interface AvatarState
  {
    public static final int DEFAULT_AVATAR = 2;
    public static final int EMPTY_NAME_AVATAR = 1;
    public static final int NONE = 0;
    public static final int USER_PHOTO = 3;
  }

  public static final class State
    implements Parcelable
  {
    public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator()
    {
      public EditInfoPresenter.State createFromParcel(Parcel paramAnonymousParcel)
      {
        return new EditInfoPresenter.State(paramAnonymousParcel);
      }

      public EditInfoPresenter.State[] newArray(int paramAnonymousInt)
      {
        return new EditInfoPresenter.State[paramAnonymousInt];
      }
    };
    private final Uri mAvatarUri;
    private final boolean mIsFacebookImported;
    private final boolean mIsNameChangedByUser;
    private final boolean mIsPhotoChangedByUser;
    private final String mName;
    private final String mNumber;

    protected State(Parcel paramParcel)
    {
      this.mName = paramParcel.readString();
      this.mAvatarUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
      boolean bool2;
      boolean bool3;
      if (paramParcel.readByte() != 0)
      {
        bool2 = bool1;
        this.mIsFacebookImported = bool2;
        this.mNumber = paramParcel.readString();
        if (paramParcel.readByte() == 0)
          break label86;
        bool3 = bool1;
        label62: this.mIsNameChangedByUser = bool3;
        if (paramParcel.readByte() == 0)
          break label92;
      }
      while (true)
      {
        this.mIsPhotoChangedByUser = bool1;
        return;
        bool2 = false;
        break;
        label86: bool3 = false;
        break label62;
        label92: bool1 = false;
      }
    }

    public State(String paramString1, Uri paramUri, boolean paramBoolean1, String paramString2, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.mName = paramString1;
      this.mAvatarUri = paramUri;
      this.mIsFacebookImported = paramBoolean1;
      this.mNumber = paramString2;
      this.mIsNameChangedByUser = paramBoolean2;
      this.mIsPhotoChangedByUser = paramBoolean3;
    }

    private State copyWith(String paramString, boolean paramBoolean)
    {
      return new State(paramString, this.mAvatarUri, this.mIsFacebookImported, this.mNumber, paramBoolean, this.mIsPhotoChangedByUser);
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool1 = true;
      boolean bool2;
      if (this == paramObject)
        bool2 = bool1;
      State localState;
      boolean bool5;
      do
      {
        boolean bool6;
        do
        {
          boolean bool3;
          boolean bool4;
          do
          {
            Class localClass1;
            Class localClass2;
            do
            {
              do
              {
                return bool2;
                bool2 = false;
              }
              while (paramObject == null);
              localClass1 = getClass();
              localClass2 = paramObject.getClass();
              bool2 = false;
            }
            while (localClass1 != localClass2);
            localState = (State)paramObject;
            bool3 = this.mIsFacebookImported;
            bool4 = localState.mIsFacebookImported;
            bool2 = false;
          }
          while (bool3 != bool4);
          if (this.mName == null)
            break;
          bool6 = this.mName.equals(localState.mName);
          bool2 = false;
        }
        while (!bool6);
        if (this.mAvatarUri == null)
          break label154;
        bool5 = this.mAvatarUri.equals(localState.mAvatarUri);
        bool2 = false;
      }
      while (!bool5);
      label122: if (this.mNumber != null)
        bool1 = this.mNumber.equals(localState.mNumber);
      while (true)
      {
        return bool1;
        if (localState.mName == null)
          break;
        return false;
        label154: if (localState.mAvatarUri == null)
          break label122;
        return false;
        if (localState.mNumber != null)
          bool1 = false;
      }
    }

    public Uri getAvatarUri()
    {
      return this.mAvatarUri;
    }

    public String getName()
    {
      return this.mName;
    }

    public String getNumber()
    {
      return this.mNumber;
    }

    public int hashCode()
    {
      int i = 1;
      int j;
      int m;
      label38: int i1;
      label57: int i3;
      label83: int i5;
      label103: int i6;
      if (this.mName != null)
      {
        j = this.mName.hashCode();
        int k = j * 31;
        if (this.mAvatarUri == null)
          break label130;
        m = this.mAvatarUri.hashCode();
        int n = 31 * (m + k);
        if (!this.mIsFacebookImported)
          break label136;
        i1 = i;
        int i2 = 31 * (i1 + n);
        if (this.mNumber == null)
          break label142;
        i3 = this.mNumber.hashCode();
        int i4 = 31 * (i3 + i2);
        if (!this.mIsNameChangedByUser)
          break label148;
        i5 = i;
        i6 = 31 * (i5 + i4);
        if (!this.mIsPhotoChangedByUser)
          break label154;
      }
      while (true)
      {
        return i6 + i;
        j = 0;
        break;
        label130: m = 0;
        break label38;
        label136: i1 = 0;
        break label57;
        label142: i3 = 0;
        break label83;
        label148: i5 = 0;
        break label103;
        label154: i = 0;
      }
    }

    public boolean isFacebookImported()
    {
      return this.mIsFacebookImported;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      paramParcel.writeString(this.mName);
      paramParcel.writeParcelable(this.mAvatarUri, paramInt);
      int j;
      int k;
      if (this.mIsFacebookImported)
      {
        j = i;
        paramParcel.writeByte((byte)j);
        paramParcel.writeString(this.mNumber);
        if (!this.mIsNameChangedByUser)
          break label81;
        k = i;
        label54: paramParcel.writeByte((byte)k);
        if (!this.mIsPhotoChangedByUser)
          break label87;
      }
      while (true)
      {
        paramParcel.writeByte((byte)i);
        return;
        j = 0;
        break;
        label81: k = 0;
        break label54;
        label87: i = 0;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.EditInfoPresenter
 * JD-Core Version:    0.6.2
 */
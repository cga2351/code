package com.viber.voip.user;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.common.permission.b;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.k;
import com.viber.voip.permissions.n;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f.a;

public class PhotoSelectionActivity extends ViberFragmentActivity
  implements m.c, UserDataEditHelper.Listener
{
  public static final int ACTION_CHOOSE_PHOTO = 103;
  public static final int ACTION_EDIT_NAME = 101;
  public static final int ACTION_GET_FACEBOOK_DETAILS = 100;
  public static final int ACTION_GET_VK_DETAILS = 105;
  public static final String ACTION_NAME = "action";
  public static final String ACTION_OPEN = "com.viber.voip.user.OPEN_PHOTO_SELECTION_SCREEN";
  public static final int ACTION_REMOVE_PHOTO = 104;
  public static final int ACTION_TAKE_PHOTO = 102;
  private static final int BACKDROP_FADEOUT_DURATION = 100;
  public static final String EXPAND_PHOTO = "expand_photo";
  private static final String KEY_CURRENT_PHOTO_FILE = "currentphotofile";
  private static final String KEY_SUB_ACTIVITY_IN_PROGRESS = "subinprogress";
  private static final Logger L = ViberEnv.getLogger();
  public static final String MODE = "mode";
  public static final int MODE_CONTACT_PHOTO = 1;
  public static final int MODE_GROUP_ICON = 2;
  public static final int MODE_VIEW_YOU_PHOTO = 3;
  public static final int MODE_YOU_PHOTO = 0;
  private static final int PHOTO_CONTRACT_DURATION = 50;
  private static final int PHOTO_EXPAND_DURATION = 100;
  public static final String PHOTO_URI = "photo_uri";
  public static final int REQUEST_CODE_ACTIONS_FROM_POPUP_MENU = 1233;
  private AnimatorListenerAdapter mAnimationListener;
  private boolean mAnimationPending;
  private View mBackdrop;
  private boolean mCloseActivityWhenCameBackFromSubActivity;
  private String mCurrentPhotoFile;
  private boolean mExpandPhoto;
  private int mExpandedPhotoSize;
  private com.viber.voip.util.e.f mFetcherConfig;
  private int mHeightOffset;
  private e mImageFetcher;
  protected k mMessagesManager;
  private int mMode;
  Rect mOriginalPos = new Rect();
  private PendingPhotoResult mPendingPhotoResult;
  private final b mPermissionListener;
  private c mPermissionManager;
  private ObjectAnimator mPhotoAnimator;
  private ViewGroup.MarginLayoutParams mPhotoEndParams;
  private PhotoHandler mPhotoHandler;
  private ViewGroup.MarginLayoutParams mPhotoStartParams;
  private Uri mPhotoUri;
  private ImageView mPhotoView;
  private Rect mSourceBounds;
  private boolean mSubActivityInProgress;
  private TextView mTextViewOnPic;
  private UserDataEditHelper mUserDataEditHelper;

  public PhotoSelectionActivity()
  {
    Pair[] arrayOfPair = new Pair[2];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(18);
    arrayOfPair[1] = com.viber.voip.permissions.m.a(120);
    this.mPermissionListener = new com.viber.voip.permissions.f(this, arrayOfPair)
    {
      public void onCustomDialogAction(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        if (DialogCode.D_EXPLAIN_PERMISSION.code().equals(paramAnonymousString))
          if (paramAnonymousInt2 != -1)
            PhotoSelectionActivity.this.finishImmediatelyWithNoAnimation();
        while (!DialogCode.D_ASK_PERMISSION.code().equals(paramAnonymousString))
          return;
        PhotoSelectionActivity.this.finishImmediatelyWithNoAnimation();
      }

      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 18:
          PhotoSelectionActivity.this.mUserDataEditHelper.takePhoto();
          return;
        case 120:
        }
        PhotoSelectionActivity.this.mUserDataEditHelper.pickFromGallery();
      }
    };
  }

  private void animateAwayBackground()
  {
    ObjectAnimator.ofFloat(this.mBackdrop, "alpha", new float[] { 0.0F }).setDuration(100L).start();
  }

  private void animateInBackground()
  {
    ObjectAnimator.ofFloat(this.mBackdrop, "alpha", new float[] { 0.0F, 0.5F }).setDuration(100L).start();
  }

  private void animatePhoto(FrameLayout.LayoutParams paramLayoutParams)
  {
    if (this.mPhotoAnimator != null)
      this.mPhotoAnimator.cancel();
    this.mPhotoView.setLayoutParams(paramLayoutParams);
    this.mAnimationPending = true;
    this.mPhotoView.requestLayout();
  }

  private void animatePhotoOpen()
  {
    this.mAnimationListener = new AnimatorListenerAdapter()
    {
      private void capturePhotoPos()
      {
        PhotoSelectionActivity.this.mPhotoView.requestLayout();
        PhotoSelectionActivity.this.mOriginalPos.left = PhotoSelectionActivity.this.mPhotoView.getLeft();
        PhotoSelectionActivity.this.mOriginalPos.top = PhotoSelectionActivity.this.mPhotoView.getTop();
        PhotoSelectionActivity.this.mOriginalPos.right = PhotoSelectionActivity.this.mPhotoView.getRight();
        PhotoSelectionActivity.this.mOriginalPos.bottom = PhotoSelectionActivity.this.mPhotoView.getBottom();
      }

      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        capturePhotoPos();
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        capturePhotoPos();
        if ((PhotoSelectionActivity.this.mPhotoHandler != null) && (PhotoSelectionActivity.this.mMode != 1))
          PhotoSelectionActivity.this.mPhotoHandler.onClick(PhotoSelectionActivity.this.mPhotoView);
      }
    };
    animatePhoto(new FrameLayout.LayoutParams(getPhotoEndParams()));
  }

  private void attachPhotoHandler()
  {
    switch (this.mMode)
    {
    default:
      if (this.mPhotoUri != null)
        break;
    case 3:
    case 2:
    }
    for (int j = 180; ; j = 182)
    {
      int i = j;
      while (true)
      {
        this.mPhotoHandler = new PhotoHandler(this, this.mPhotoView, i, null);
        if (this.mPendingPhotoResult == null)
          break;
        this.mSubActivityInProgress = this.mUserDataEditHelper.onActivityResult(this.mPendingPhotoResult.mRequestCode, this.mPendingPhotoResult.mResultCode, this.mPendingPhotoResult.mData);
        this.mPendingPhotoResult = null;
        return;
        i = 0;
        continue;
        i = 72;
      }
    }
    dj.a(this.mBackdrop, new Runnable()
    {
      public void run()
      {
        PhotoSelectionActivity.this.animatePhotoOpen();
      }
    });
  }

  public static Intent buildIntent(Uri paramUri, View paramView, int paramInt, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    localRect.left = ((int)(0.5F + 1.0F * arrayOfInt[0]));
    localRect.top = ((int)(0.5F + 1.0F * arrayOfInt[1]));
    localRect.right = ((int)(0.5F + 1.0F * (arrayOfInt[0] + paramView.getWidth())));
    localRect.bottom = ((int)(0.5F + 1.0F * (arrayOfInt[1] + paramView.getHeight())));
    Intent localIntent = new Intent("com.viber.voip.user.OPEN_PHOTO_SELECTION_SCREEN");
    if (paramUri != null)
      localIntent.putExtra("photo_uri", paramUri);
    localIntent.setSourceBounds(localRect);
    localIntent.putExtra("mode", paramInt);
    localIntent.putExtra("expand_photo", paramBoolean);
    return localIntent;
  }

  private void closePhotoAndFinish(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mPhotoUri != null))
    {
      this.mPhotoUri = null;
      this.mPhotoView.invalidate();
      this.mPhotoView.setImageBitmap(null);
      this.mMessagesManager.e().a(this.mPhotoUri);
    }
    finishImmediatelyWithNoAnimation();
  }

  private void displayPhoto()
  {
    int[] arrayOfInt = new int[2];
    this.mBackdrop.getLocationOnScreen(arrayOfInt);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(this.mSourceBounds.width(), this.mSourceBounds.height());
    this.mOriginalPos.left = (this.mSourceBounds.left - arrayOfInt[0]);
    this.mOriginalPos.top = (this.mSourceBounds.top - arrayOfInt[1]);
    this.mOriginalPos.right = (this.mOriginalPos.left + this.mSourceBounds.width());
    this.mOriginalPos.bottom = (this.mOriginalPos.top + this.mSourceBounds.height());
    localMarginLayoutParams.setMargins(this.mOriginalPos.left, this.mOriginalPos.top, this.mOriginalPos.right, this.mOriginalPos.bottom);
    this.mPhotoStartParams = localMarginLayoutParams;
    this.mPhotoView.setLayoutParams(new FrameLayout.LayoutParams(localMarginLayoutParams));
    this.mPhotoView.requestLayout();
    this.mImageFetcher.a(null, this.mPhotoUri, this.mPhotoView, this.mFetcherConfig);
    this.mPhotoView.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        if (PhotoSelectionActivity.this.mAnimationPending)
        {
          PhotoSelectionActivity.access$302(PhotoSelectionActivity.this, false);
          int[] arrayOfInt1 = new int[2];
          arrayOfInt1[0] = PhotoSelectionActivity.this.mOriginalPos.left;
          arrayOfInt1[1] = paramAnonymousInt1;
          PropertyValuesHolder localPropertyValuesHolder1 = PropertyValuesHolder.ofInt("left", arrayOfInt1);
          int[] arrayOfInt2 = new int[2];
          arrayOfInt2[0] = PhotoSelectionActivity.this.mOriginalPos.top;
          arrayOfInt2[1] = paramAnonymousInt2;
          PropertyValuesHolder localPropertyValuesHolder2 = PropertyValuesHolder.ofInt("top", arrayOfInt2);
          int[] arrayOfInt3 = new int[2];
          arrayOfInt3[0] = PhotoSelectionActivity.this.mOriginalPos.right;
          arrayOfInt3[1] = paramAnonymousInt3;
          PropertyValuesHolder localPropertyValuesHolder3 = PropertyValuesHolder.ofInt("right", arrayOfInt3);
          int[] arrayOfInt4 = new int[2];
          arrayOfInt4[0] = PhotoSelectionActivity.this.mOriginalPos.bottom;
          arrayOfInt4[1] = paramAnonymousInt4;
          PropertyValuesHolder localPropertyValuesHolder4 = PropertyValuesHolder.ofInt("bottom", arrayOfInt4);
          ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(PhotoSelectionActivity.this.mPhotoView, new PropertyValuesHolder[] { localPropertyValuesHolder1, localPropertyValuesHolder2, localPropertyValuesHolder3, localPropertyValuesHolder4 }).setDuration(100L);
          if (PhotoSelectionActivity.this.mAnimationListener != null)
            localObjectAnimator.addListener(PhotoSelectionActivity.this.mAnimationListener);
          localObjectAnimator.start();
        }
      }
    });
    attachPhotoHandler();
  }

  private void finishImmediatelyWithNoAnimation()
  {
    finish();
  }

  private int getAdditionalLeftMargin()
  {
    Application localApplication = ViberApplication.getApplication();
    if ((ViberApplication.isTablet(this)) && (dj.c(localApplication)))
    {
      Resources localResources = localApplication.getResources();
      return (int)(localResources.getDisplayMetrics().widthPixels * dj.a(localResources));
    }
    return 0;
  }

  private int getAdjustedExpandedPhotoSize(View paramView, int paramInt)
  {
    Rect localRect = new Rect();
    paramView.getDrawingRect(localRect);
    int i = localRect.width();
    int j = localRect.height() - paramInt;
    if (ViberApplication.isTablet(this))
      return this.mExpandedPhotoSize;
    float f = Math.min(j / this.mExpandedPhotoSize, i / this.mExpandedPhotoSize);
    if (f < 1.0F)
      return (int)(f * this.mExpandedPhotoSize);
    return this.mExpandedPhotoSize;
  }

  private ViewGroup.MarginLayoutParams getPhotoEndParams()
  {
    int i;
    if (this.mPhotoEndParams == null)
    {
      if ((!ViberApplication.isTablet(this)) || (!dj.c(this)))
        break label248;
      this.mPhotoEndParams = new ViewGroup.MarginLayoutParams(this.mPhotoStartParams);
      switch (this.mMode)
      {
      default:
        i = 0;
        label66: if (this.mExpandPhoto)
        {
          int j = getAdjustedExpandedPhotoSize(this.mBackdrop, this.mHeightOffset);
          int k = j - this.mPhotoStartParams.width;
          int m = j - this.mPhotoStartParams.height;
          if (k >= 1)
          {
            this.mPhotoEndParams.width = j;
            if ((!ViberApplication.isTablet(this)) || (dj.c(this)))
              break label304;
            this.mPhotoEndParams.leftMargin = this.mPhotoStartParams.leftMargin;
            this.mPhotoEndParams.rightMargin = 0;
          }
          if (m >= 1)
          {
            this.mPhotoEndParams.height = j;
            switch (this.mMode)
            {
            default:
            case 2:
            case 1:
            }
          }
        }
        label148: break;
      case 0:
      case 1:
      }
    }
    while (true)
    {
      if ((!ViberApplication.isTablet(this)) || (dj.c(this)))
        break label342;
      for (this.mPhotoEndParams.topMargin = (this.mPhotoStartParams.topMargin - getResources().getDimensionPixelOffset(R.dimen.expanded_you_photo_margin)); ; this.mPhotoEndParams.topMargin = dj.c())
      {
        this.mPhotoEndParams.bottomMargin = 0;
        return this.mPhotoEndParams;
        label248: this.mPhotoEndParams = new FrameLayout.LayoutParams(this.mPhotoStartParams.width, this.mPhotoStartParams.height);
        break;
        i = getResources().getDimensionPixelOffset(R.dimen.expanded_you_photo_margin);
        break label66;
        i = getResources().getDimensionPixelOffset(R.dimen.expanded_contact_photo_margin);
        break label66;
        label304: this.mPhotoEndParams.leftMargin = (i + getAdditionalLeftMargin());
        break label148;
      }
      i += dj.c();
    }
    label342: ViewGroup.MarginLayoutParams localMarginLayoutParams = this.mPhotoEndParams;
    if (dj.c(this));
    while (true)
    {
      localMarginLayoutParams.topMargin = i;
      break;
      i = 0;
    }
  }

  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.mPhotoHandler != null)
    {
      if (this.mUserDataEditHelper.onActivityResult(paramInt1, paramInt2, paramIntent))
      {
        this.mPendingPhotoResult = null;
        this.mSubActivityInProgress = true;
        return;
      }
      this.mSubActivityInProgress = false;
      if (this.mCloseActivityWhenCameBackFromSubActivity)
      {
        finishImmediatelyWithNoAnimation();
        return;
      }
      this.mPhotoHandler.onClick(this.mPhotoView);
      return;
    }
    this.mPendingPhotoResult = new PendingPhotoResult(paramInt1, paramInt2, paramIntent, null);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (!this.mSubActivityInProgress)
    {
      finishImmediatelyWithNoAnimation();
      return;
    }
    this.mCloseActivityWhenCameBackFromSubActivity = true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.photoselection_activity);
    if (paramBundle != null)
    {
      this.mCurrentPhotoFile = paramBundle.getString("currentphotofile");
      this.mSubActivityInProgress = paramBundle.getBoolean("subinprogress");
    }
    this.mPermissionManager = c.a(this);
    Intent localIntent = getIntent();
    this.mPhotoUri = ((Uri)localIntent.getParcelableExtra("photo_uri"));
    this.mMode = localIntent.getIntExtra("mode", 1);
    this.mExpandPhoto = localIntent.getBooleanExtra("expand_photo", false);
    this.mExpandedPhotoSize = getResources().getDimensionPixelSize(R.dimen.detail_contact_photo_expanded_size);
    this.mHeightOffset = getResources().getDimensionPixelOffset(R.dimen.expanded_photo_height_offset);
    this.mBackdrop = findViewById(R.id.backdrop);
    this.mPhotoView = ((ImageView)findViewById(R.id.photo));
    this.mTextViewOnPic = ((TextView)findViewById(R.id.user_add_pic_text_view));
    this.mTextViewOnPic.setVisibility(4);
    this.mSourceBounds = localIntent.getSourceBounds();
    this.mMessagesManager = ViberApplication.getInstance().getMessagesManager();
    this.mImageFetcher = e.a(this);
    this.mFetcherConfig = com.viber.voip.util.e.f.e(dc.a(this, R.attr.contactDetailsDefaultPhoto)).f().a().c();
    animateInBackground();
    getResources();
    this.mUserDataEditHelper = new UserDataEditHelper(this, UserDataEditHelper.Config.YOU).setListener(this);
    if (paramBundle != null)
      this.mUserDataEditHelper.onRestoreInstanceState(paramBundle);
    this.mBackdrop.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PhotoSelectionActivity.this.finish();
      }
    });
    dj.a(this.mBackdrop, new Runnable()
    {
      public void run()
      {
        PhotoSelectionActivity.this.displayPhoto();
      }
    });
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.mPhotoAnimator != null)
    {
      this.mPhotoAnimator.cancel();
      this.mPhotoAnimator = null;
    }
    if (this.mPhotoHandler != null)
    {
      this.mPhotoHandler.destroy();
      this.mPhotoHandler = null;
    }
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.DC22));
    switch (paramInt)
    {
    default:
      return;
    case -1:
      closePhotoAndFinish(true);
      return;
    case -2:
    }
    closePhotoAndFinish(false);
  }

  public void onError(int paramInt)
  {
  }

  public void onFromFacebookImported(String paramString, Uri paramUri)
  {
  }

  public void onFromVKImported(String paramString, Uri paramUri)
  {
  }

  public void onGalleryPermissionRequested()
  {
    this.mPermissionManager.a(this, 120, n.m);
  }

  public void onNameEdited(String paramString)
  {
  }

  public void onPhotoCropped(Uri paramUri)
  {
    this.mImageFetcher.b(paramUri, com.viber.voip.util.e.f.b(this));
    this.mMessagesManager.e().a(paramUri);
    finish();
  }

  public void onPhotoRemoved()
  {
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.mUserDataEditHelper.onSaveInstanceState(paramBundle);
    paramBundle.putString("currentphotofile", this.mCurrentPhotoFile);
    paramBundle.putBoolean("subinprogress", this.mSubActivityInProgress);
  }

  protected void onStart()
  {
    super.onStart();
    this.mPermissionManager.a(this.mPermissionListener);
  }

  protected void onStop()
  {
    super.onStop();
    this.mPermissionManager.b(this.mPermissionListener);
  }

  public void onTakePhotoPermissionRequested()
  {
    this.mPermissionManager.a(this, 18, n.c);
  }

  private static class PendingPhotoResult
  {
    private final Intent mData;
    private final int mRequestCode;
    private final int mResultCode;

    private PendingPhotoResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      this.mRequestCode = paramInt1;
      this.mResultCode = paramInt2;
      this.mData = paramIntent;
    }
  }

  private final class PhotoHandler extends PhotoSelectionHandler
  {
    private final PhotoSelectionHandler.PhotoActionListener mListener = new PhotoListener(null);

    private PhotoHandler(Context paramView, View paramInt, int arg4)
    {
      super(paramInt, i);
    }

    public PhotoSelectionHandler.PhotoActionListener getListener()
    {
      return this.mListener;
    }

    private final class PhotoListener extends PhotoSelectionHandler.PhotoActionListener
    {
      private PhotoListener()
      {
        super();
      }

      public void onChoosePhoto()
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("action", 103);
        PhotoSelectionActivity.this.setResult(-1, localIntent);
        PhotoSelectionActivity.this.finish();
      }

      public void onEditName()
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("action", 101);
        PhotoSelectionActivity.this.setResult(-1, localIntent);
        PhotoSelectionActivity.this.finish();
      }

      public void onImportFromFB()
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("action", 100);
        PhotoSelectionActivity.this.setResult(-1, localIntent);
        PhotoSelectionActivity.this.finish();
      }

      public void onImportFromVK()
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("action", 105);
        PhotoSelectionActivity.this.setResult(-1, localIntent);
        PhotoSelectionActivity.this.finish();
      }

      public void onPhotoSelectionDismissed()
      {
        if (!PhotoSelectionActivity.this.mSubActivityInProgress)
          PhotoSelectionActivity.this.finish();
      }

      public void onPickFromGalleryChosen()
      {
        PhotoSelectionActivity.this.mUserDataEditHelper.pickFromGallery();
        PhotoSelectionActivity.access$1502(PhotoSelectionActivity.this, true);
      }

      public void onRemovePhoto()
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("action", 104);
        PhotoSelectionActivity.this.setResult(-1, localIntent);
        PhotoSelectionActivity.this.finish();
      }

      public void onRemovePictureChosen()
      {
        PhotoSelectionActivity.access$1502(PhotoSelectionActivity.this, true);
        ad.g().a(PhotoSelectionActivity.this).a(PhotoSelectionActivity.this);
      }

      public void onTakePhoto()
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("action", 102);
        PhotoSelectionActivity.this.setResult(-1, localIntent);
        PhotoSelectionActivity.this.finish();
      }

      public void onTakePhotoChosen()
      {
        PhotoSelectionActivity.this.mUserDataEditHelper.takePhoto();
        PhotoSelectionActivity.access$1502(PhotoSelectionActivity.this, true);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.PhotoSelectionActivity
 * JD-Core Version:    0.6.2
 */
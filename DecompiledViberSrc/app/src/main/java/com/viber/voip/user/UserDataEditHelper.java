package com.viber.voip.user;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.c.a;
import android.text.TextUtils;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.extras.a.e;
import com.viber.voip.messages.extras.a.e.a;
import com.viber.voip.messages.extras.a.e.d;
import com.viber.voip.messages.extras.c.a;
import com.viber.voip.messages.extras.image.b;
import com.viber.voip.permissions.n;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.bt;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.at;
import com.viber.voip.util.cj;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.j;
import com.viber.voip.util.q;
import com.viber.voip.util.upload.o;
import com.vk.sdk.api.VKResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserDataEditHelper
{
  public static final int ERROR_CODE_FACEBOOK = 1;
  public static final int ERROR_CODE_UNSUPPORTED_FILE = 2;
  public static final int ERROR_CODE_VK = 3;
  private static final int ITEM_EDIT_NAME = 0;
  private static final int ITEM_IMPORT_FROM_FACEBOOK = 1;
  private static final int ITEM_IMPORT_FROM_VK = 5;
  private static final int ITEM_PICK_FROM_GALLERY = 3;
  private static final int ITEM_REMOVE_PHOTO = 4;
  private static final int ITEM_TAKE_PHOTO = 2;
  private static final String KEY_TEMP_PHOTO_URI = "temp_photo_uri";
  private static final Logger L = ViberEnv.getLogger();
  private static final int REQUEST_CODE_CROP_PHOTO = 652;
  private static final int REQUEST_CODE_PICK_FROM_GALLERY = 650;
  private static final int REQUEST_CODE_TAKE_PHOTO = 651;
  private Activity mActivity;
  private Config mConfig;
  private FacebookDetailsListener mFacebookDetailsListener = new FacebookDetailsListener()
  {
    public void onLoaded(SocialUserDetails paramAnonymousSocialUserDetails)
    {
      String str = paramAnonymousSocialUserDetails.getUserName();
      Uri localUri = j.a(paramAnonymousSocialUserDetails.getUserPhoto(), dv.s);
      UserDataEditHelper.this.mListener.onFromFacebookImported(str, localUri);
    }

    public void onLoadingCanceled()
    {
    }

    public void onLoadingError(String paramAnonymousString)
    {
      if (paramAnonymousString.contains("Error validating access token"))
      {
        UserDataEditHelper.this.importFromFacebook();
        return;
      }
      UserDataEditHelper.this.mListener.onError(1);
    }
  };
  private Fragment mFragment;
  private boolean mIsCroppingPhoto;
  private Listener mListener;
  private com.viber.common.permission.c mPermissionManager;
  private Uri mPhoto;
  private UserManager mUserManager;
  private com.viber.voip.messages.extras.c.a.a mVKAuthListener = new com.viber.voip.messages.extras.c.a.a()
  {
    public void onAuthComplete()
    {
      UserDataEditHelper.this.loadVKDetails();
    }

    public void onAuthError()
    {
      UserDataEditHelper.this.mListener.onError(3);
    }

    public void onGetUserDetails(SocialUserDetails paramAnonymousSocialUserDetails)
    {
      UserDataEditHelper.this.mVKDetailsListener.onLoaded(paramAnonymousSocialUserDetails);
    }

    public void onUserDetailsReady(VKResponse paramAnonymousVKResponse)
    {
      LoadVKDetailsTask localLoadVKDetailsTask = new LoadVKDetailsTask(UserDataEditHelper.this.mActivity, this);
      a[] arrayOfa = new a[1];
      arrayOfa[0] = ViberApplication.getInstance().getVKManager();
      localLoadVKDetailsTask.execute(arrayOfa);
    }
  };
  private FacebookDetailsListener mVKDetailsListener = new FacebookDetailsListener()
  {
    public void onLoaded(SocialUserDetails paramAnonymousSocialUserDetails)
    {
      String str = paramAnonymousSocialUserDetails.getUserName();
      Uri localUri = j.a(paramAnonymousSocialUserDetails.getUserPhoto(), dv.s);
      UserDataEditHelper.this.mListener.onFromVKImported(str, localUri);
    }

    public void onLoadingCanceled()
    {
    }

    public void onLoadingError(String paramAnonymousString)
    {
      UserDataEditHelper.this.mListener.onError(1);
    }
  };

  public UserDataEditHelper(Activity paramActivity, Config paramConfig)
  {
    this.mActivity = paramActivity;
    this.mConfig = paramConfig;
    this.mUserManager = UserManager.from(this.mActivity);
    this.mPermissionManager = com.viber.common.permission.c.a(this.mActivity);
  }

  private void deleteFile(final Context paramContext, final Uri paramUri)
  {
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        at.d(paramContext, paramUri);
      }
    });
  }

  private void loadFacebookDetails()
  {
    if (cj.c(this.mActivity))
    {
      if (this.mActivity.isFinishing())
        return;
      LoadFacebookDetailsTask localLoadFacebookDetailsTask = new LoadFacebookDetailsTask(this.mActivity, this.mFacebookDetailsListener);
      e[] arrayOfe = new e[1];
      arrayOfe[0] = ViberApplication.getInstance().getFacebookManager();
      localLoadFacebookDetailsTask.execute(arrayOfe);
      return;
    }
    this.mListener.onError(1);
  }

  private void loadVKDetails()
  {
    if (cj.c(this.mActivity))
    {
      if (this.mActivity.isFinishing())
        return;
      ViberApplication.getInstance().getVKManager().b();
      return;
    }
    this.mListener.onError(3);
  }

  private void pickFromGalleryInternal()
  {
    this.mIsCroppingPhoto = false;
    this.mPhoto = null;
    if ((o.b(true)) && (o.a(true)))
      startActivityForResult(ViberActionRunner.a(new Intent().setType("image/*").setAction("android.intent.action.GET_CONTENT"), this.mActivity.getString(R.string.msg_options_take_photo), new Intent[0]), 650);
  }

  private void showEditNameDialog(boolean paramBoolean)
  {
    ad.a(this.mListener, paramBoolean).a(this.mActivity);
  }

  private void showRemovePhotoDialog(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ad.g().a(new ViberDialogHandlers.bt(this.mListener)).a(false).a(this.mActivity);
      return;
    }
    this.mListener.onPhotoRemoved();
  }

  private void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (this.mFragment != null)
    {
      this.mFragment.startActivityForResult(paramIntent, paramInt);
      return;
    }
    this.mActivity.startActivityForResult(paramIntent, paramInt);
  }

  private void takePhotoInternal()
  {
    this.mIsCroppingPhoto = false;
    this.mPhoto = dv.h.a(this.mActivity, null, true);
    if (this.mPhoto != null)
    {
      if (this.mFragment != null)
        ViberActionRunner.a(this.mFragment, this.mPhoto, 651);
    }
    else
      return;
    ViberActionRunner.a(this.mActivity, this.mPhoto, 651);
  }

  public void importFromFacebook()
  {
    e locale = ViberApplication.getInstance().getFacebookManager();
    e.d locald = locale.b();
    if ((locald == e.d.d) || (locald == e.d.a))
    {
      locale.a(this.mActivity, new e.a()
      {
        public void onFacebookProfileStored()
        {
          UserDataEditHelper.this.loadFacebookDetails();
        }
      });
      return;
    }
    loadFacebookDetails();
  }

  public void importFromVK()
  {
    ViberApplication.getInstance().getVKManager().a(this.mActivity, this.mVKAuthListener);
  }

  public boolean isCroppingPhoto()
  {
    return this.mIsCroppingPhoto;
  }

  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool;
    final Uri localUri2;
    if (650 == paramInt1)
    {
      bool = false;
      if (-1 == paramInt2)
      {
        bool = false;
        if (paramIntent != null)
        {
          Uri localUri1 = paramIntent.getData();
          bool = false;
          if (localUri1 != null)
          {
            String str = at.g(paramIntent.getData());
            if ((!"image".equals(str)) && (!"image/gif".equals(str)))
              break label157;
            localUri2 = j.a(this.mActivity, paramIntent.getData(), str);
            if (localUri2 != null)
              break label103;
            this.mListener.onError(2);
            bool = true;
          }
        }
      }
    }
    label103: 
    do
    {
      return bool;
      if (!j.b(localUri2))
      {
        startActivityForResult(b.c(this.mActivity, localUri2), 652);
        this.mIsCroppingPhoto = true;
      }
      while (true)
      {
        return true;
        av.a(av.e.f).post(new Runnable()
        {
          public void run()
          {
            UserDataEditHelper.this.startActivityForResult(b.c(UserDataEditHelper.this.mActivity, j.c(localUri2)), 652);
            UserDataEditHelper.access$602(UserDataEditHelper.this, true);
          }
        });
        continue;
        this.mListener.onError(2);
      }
      if (651 == paramInt1)
      {
        if (-1 == paramInt2)
        {
          startActivityForResult(b.c(this.mActivity, this.mPhoto), 652);
          this.mIsCroppingPhoto = true;
          av.a(av.e.f).post(new Runnable()
          {
            public void run()
            {
              o.b(UserDataEditHelper.this.mPhoto);
            }
          });
          return true;
        }
        deleteFile(this.mActivity, this.mPhoto);
        return false;
      }
      bool = false;
    }
    while (652 != paramInt1);
    label157: if (-1 == paramInt2)
    {
      if (paramIntent != null)
      {
        Uri localUri3 = Uri.parse(paramIntent.getAction());
        Uri localUri4 = (Uri)paramIntent.getParcelableExtra("originalUri");
        if (dv.a(localUri4, dv.g, this.mActivity))
          deleteFile(this.mActivity, localUri4);
        this.mListener.onPhotoCropped(localUri3);
        return true;
      }
    }
    else if (this.mPhoto != null)
      deleteFile(this.mActivity, this.mPhoto);
    this.mIsCroppingPhoto = false;
    return false;
  }

  public void onRestoreInstanceState(Bundle paramBundle)
  {
    if (paramBundle == null)
      return;
    this.mPhoto = ((Uri)paramBundle.getParcelable("temp_photo_uri"));
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("temp_photo_uri", this.mPhoto);
  }

  public void pickFromGallery()
  {
    if (this.mPermissionManager.a(n.m))
    {
      pickFromGalleryInternal();
      return;
    }
    this.mListener.onGalleryPermissionRequested();
  }

  public void removePhoto()
  {
    if (this.mConfig != Config.REGISTRATION);
    for (boolean bool = true; ; bool = false)
    {
      showRemovePhotoDialog(bool);
      return;
    }
  }

  public UserDataEditHelper setFragment(Fragment paramFragment)
  {
    this.mFragment = paramFragment;
    return this;
  }

  public UserDataEditHelper setListener(Listener paramListener)
  {
    this.mListener = paramListener;
    return this;
  }

  public void showEditDialog()
  {
    int i;
    final boolean bool;
    label24: c.a locala;
    HashMap localHashMap;
    UserData localUserData;
    int m;
    label86: int k;
    label180: Integer localInteger1;
    Activity localActivity1;
    if (this.mConfig == Config.REGISTRATION)
    {
      i = 1;
      if (this.mConfig != Config.PROFILE_PREVIEW)
        break label350;
      bool = true;
      locala = new c.a(this.mActivity);
      localHashMap = new HashMap();
      localUserData = this.mUserManager.getUserData();
      if (i == 0)
      {
        Integer localInteger3 = Integer.valueOf(0);
        Activity localActivity3 = this.mActivity;
        if (TextUtils.isEmpty(localUserData.getViberName()))
          break label355;
        m = R.string.menu_edit_your_name;
        localHashMap.put(localInteger3, localActivity3.getText(m));
        localHashMap.put(Integer.valueOf(1), this.mActivity.getText(R.string.btn_import_from_facebook));
        if (a.d())
          localHashMap.put(Integer.valueOf(5), this.mActivity.getText(R.string.btn_import_from_vk));
      }
      if (q.a())
      {
        Integer localInteger2 = Integer.valueOf(2);
        Activity localActivity2 = this.mActivity;
        if (i == 0)
          break label363;
        k = R.string.user_menu_take_pic;
        localHashMap.put(localInteger2, localActivity2.getText(k));
      }
      localInteger1 = Integer.valueOf(3);
      localActivity1 = this.mActivity;
      if (i == 0)
        break label371;
    }
    label350: label355: label363: label371: for (int j = R.string.user_menu_select_pic; ; j = R.string.user_menu_pick_new_photo)
    {
      localHashMap.put(localInteger1, localActivity1.getText(j));
      if ((localUserData.getImage() != null) && (!bool))
        localHashMap.put(Integer.valueOf(4), this.mActivity.getText(R.string.user_menu_remove_pic));
      final Integer[] arrayOfInteger = (Integer[])localHashMap.keySet().toArray(new Integer[localHashMap.size()]);
      locala.a((CharSequence[])localHashMap.values().toArray(new CharSequence[localHashMap.size()]), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          switch (arrayOfInteger[paramAnonymousInt].intValue())
          {
          default:
            return;
          case 0:
            UserDataEditHelper localUserDataEditHelper = UserDataEditHelper.this;
            if (!bool);
            for (boolean bool = true; ; bool = false)
            {
              localUserDataEditHelper.showEditNameDialog(bool);
              return;
            }
          case 1:
            UserDataEditHelper.this.importFromFacebook();
            return;
          case 5:
            UserDataEditHelper.this.importFromVK();
            return;
          case 2:
            UserDataEditHelper.this.takePhoto();
            return;
          case 3:
            UserDataEditHelper.this.pickFromGallery();
            return;
          case 4:
          }
          UserDataEditHelper.this.removePhoto();
        }
      });
      locala.b().show();
      return;
      i = 0;
      break;
      bool = false;
      break label24;
      m = R.string.menu_add_your_name;
      break label86;
      k = R.string.user_menu_take_new_pic;
      break label180;
    }
  }

  public void takePhoto()
  {
    if (this.mPermissionManager.a(n.c))
    {
      takePhotoInternal();
      return;
    }
    this.mListener.onTakePhotoPermissionRequested();
  }

  public static enum Config
  {
    static
    {
      PROFILE_PREVIEW = new Config("PROFILE_PREVIEW", 1);
      YOU = new Config("YOU", 2);
      Config[] arrayOfConfig = new Config[3];
      arrayOfConfig[0] = REGISTRATION;
      arrayOfConfig[1] = PROFILE_PREVIEW;
      arrayOfConfig[2] = YOU;
    }
  }

  public static abstract interface Listener
  {
    public abstract void onError(int paramInt);

    public abstract void onFromFacebookImported(String paramString, Uri paramUri);

    public abstract void onFromVKImported(String paramString, Uri paramUri);

    public abstract void onGalleryPermissionRequested();

    public abstract void onNameEdited(String paramString);

    public abstract void onPhotoCropped(Uri paramUri);

    public abstract void onPhotoRemoved();

    public abstract void onTakePhotoPermissionRequested();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.UserDataEditHelper
 * JD-Core Version:    0.6.2
 */
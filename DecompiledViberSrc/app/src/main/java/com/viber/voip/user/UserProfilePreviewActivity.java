package com.viber.voip.user;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.viber.common.permission.c;
import com.viber.common.ui.ShapeImageView;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.color;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.messages.controller.bv.n;
import com.viber.voip.messages.controller.bv.n.a;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.k;
import com.viber.voip.permissions.n;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.ap;
import com.viber.voip.ui.aq;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class UserProfilePreviewActivity extends ViberFragmentActivity
{
  private static final float LAND_HEIGHT_PERCENT = 0.8F;
  private static final float LAND_WIDTH_PERCENT = 0.4F;
  private static final float PORT_HEIGHT_PERCENT = 0.55F;
  private static final float PORT_WIDTH_PERCENT = 0.6F;
  public static final int REQUEST_CODE = 900;

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ViberApplication.getInstance().getFacebookManager().a(this, paramInt1, paramInt2, paramIntent);
    ViberApplication.getInstance().getVKManager().a(paramInt1, paramInt2, paramIntent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    if (ViberApplication.isTablet(this))
      dj.a(this, 0.6F, 0.55F, 0.4F, 0.8F, false);
    while (true)
    {
      super.onCreate(paramBundle);
      if (paramBundle == null)
        getSupportFragmentManager().beginTransaction().add(16908290, new UserProfilePreviewFragment()).commit();
      return;
      if (!com.viber.common.d.a.m())
        com.viber.voip.n.a.d(this);
      getWindow().setBackgroundDrawableResource(R.color.solid_40);
    }
  }

  public static class UserProfilePreviewFragment extends aq
    implements View.OnClickListener, bv.n, UserDataEditHelper.Listener
  {
    private f mFetcherConfig;
    private com.viber.voip.util.e.e mImageFetcher;
    private TextView mNameView;
    private final com.viber.common.permission.b mPermissionListener;
    private c mPermissionManager;
    private ShapeImageView mPhotoView;
    private ci mUserDataController;
    private UserDataEditHelper mUserDataEditHelper;
    private UserManager mUserManager;

    public UserProfilePreviewFragment()
    {
      Pair[] arrayOfPair = new Pair[2];
      arrayOfPair[0] = com.viber.voip.permissions.m.a(16);
      arrayOfPair[1] = com.viber.voip.permissions.m.a(121);
      this.mPermissionListener = new com.viber.voip.permissions.e(this, arrayOfPair)
      {
        public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
        {
          switch (paramAnonymousInt)
          {
          default:
            return;
          case 16:
            UserProfilePreviewActivity.UserProfilePreviewFragment.this.mUserDataEditHelper.takePhoto();
            return;
          case 121:
          }
          UserProfilePreviewActivity.UserProfilePreviewFragment.this.mUserDataEditHelper.pickFromGallery();
        }
      };
    }

    private void makeClickableGuidelines(TextView paramTextView)
    {
      String str1 = ap.c().h();
      String str2 = getString(R.string.user_profile_preview_agree_2_text, new Object[] { str1 });
      paramTextView.setHighlightColor(0);
      paramTextView.setText(Html.fromHtml(str2), TextView.BufferType.SPANNABLE);
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void updateName(String paramString)
    {
      this.mNameView.setText(paramString);
    }

    private void updatePhoto(Uri paramUri)
    {
      this.mImageFetcher.a(null, paramUri, this.mPhotoView, this.mFetcherConfig);
    }

    public void onActivityCreated(Bundle paramBundle)
    {
      super.onActivityCreated(paramBundle);
      this.mUserDataEditHelper = new UserDataEditHelper(getActivity(), UserDataEditHelper.Config.PROFILE_PREVIEW).setFragment(this).setListener(this);
      if (paramBundle != null)
        this.mUserDataEditHelper.onRestoreInstanceState(paramBundle);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      this.mUserDataEditHelper.onActivityResult(paramInt1, paramInt2, paramIntent);
    }

    public void onChange(Set<Long> paramSet, Set<String> paramSet1, boolean paramBoolean)
    {
    }

    public void onClick(View paramView)
    {
      int i = paramView.getId();
      if ((i == R.id.photo) || (i == R.id.edit))
        this.mUserDataEditHelper.showEditDialog();
      do
      {
        return;
        if (i == R.id.agree)
        {
          d.ad.r.a(true);
          d.ap.c.a(false);
          getActivity().setResult(-1);
          getActivity().finish();
          return;
        }
      }
      while (i != R.id.cancel);
      getActivity().finish();
    }

    public void onContactStatusChanged(Map<Long, bv.n.a> paramMap)
    {
    }

    public void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      this.mPermissionManager = c.a(getActivity());
      this.mImageFetcher = com.viber.voip.util.e.e.a(getActivity());
      this.mFetcherConfig = f.b(getActivity()).f().c();
      this.mUserManager = UserManager.from(getActivity());
      this.mUserDataController = ViberApplication.getInstance().getMessagesManager().e();
      o.a().a(this);
    }

    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      View localView1 = paramLayoutInflater.inflate(R.layout.fragment_user_profile_preview, paramViewGroup, false);
      this.mPhotoView = ((ShapeImageView)localView1.findViewById(R.id.photo));
      this.mPhotoView.setOnClickListener(this);
      this.mNameView = ((TextView)localView1.findViewById(R.id.name));
      localView1.findViewById(R.id.edit).setOnClickListener(this);
      localView1.findViewById(R.id.agree).setOnClickListener(this);
      localView1.findViewById(R.id.cancel).setOnClickListener(this);
      boolean bool = d.ap.c.d();
      View localView2 = localView1.findViewById(R.id.guidelines_item);
      if (localView2 == null);
      for (View localView3 = localView1.findViewById(R.id.agree_2_text); ; localView3 = localView2)
      {
        if (bool);
        for (int i = 0; ; i = 8)
        {
          localView3.setVisibility(i);
          makeClickableGuidelines((TextView)localView1.findViewById(R.id.agree_2_text));
          UserData localUserData = this.mUserManager.getUserData();
          updatePhoto(localUserData.getImage());
          updateName(localUserData.getViberName());
          return localView1;
        }
      }
    }

    public void onDestroy()
    {
      super.onDestroy();
      o.a().b(this);
    }

    public void onError(int paramInt)
    {
      if ((1 == paramInt) || (3 == paramInt))
        ViberApplication.getInstance().getEngine(false).getCdrController().handleReportFacebookStatistics("", "", 99);
    }

    public void onFromFacebookImported(String paramString, Uri paramUri)
    {
      this.mUserDataController.a(paramString);
      if (paramUri != null)
        this.mUserDataController.a(paramUri);
    }

    public void onFromVKImported(String paramString, Uri paramUri)
    {
      this.mUserDataController.a(paramString);
      if (paramUri != null)
        this.mUserDataController.a(paramUri);
    }

    public void onGalleryPermissionRequested()
    {
      this.mPermissionManager.a(this, 121, n.m);
    }

    public void onInitCache()
    {
    }

    public void onNameEdited(String paramString)
    {
      this.mUserDataController.a(paramString);
    }

    public void onNewInfo(List<com.viber.voip.model.entity.m> paramList, boolean paramBoolean)
    {
    }

    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onOwnerChanged(UserData.OwnerChangedEvent paramOwnerChangedEvent)
    {
      UserData localUserData = this.mUserManager.getUserData();
      updatePhoto(localUserData.getImage());
      updateName(localUserData.getViberName());
    }

    public void onParticipantDeleted(com.viber.voip.model.entity.m paramm)
    {
    }

    public void onPhotoCropped(Uri paramUri)
    {
      this.mUserDataController.a(paramUri);
    }

    public void onPhotoRemoved()
    {
      this.mUserDataController.a(null);
    }

    public void onSaveInstanceState(Bundle paramBundle)
    {
      super.onSaveInstanceState(paramBundle);
      this.mUserDataEditHelper.onSaveInstanceState(paramBundle);
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
    }

    public void onTakePhotoPermissionRequested()
    {
      this.mPermissionManager.a(this, 16, n.c);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.UserProfilePreviewActivity
 * JD-Core Version:    0.6.2
 */
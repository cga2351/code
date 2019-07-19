package com.viber.voip.user;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;

public class PublicGroupParticipantDetailsActivity extends ViberFragmentActivity
{
  public static final String ACTION_INTENT = "action_intent";
  private static final Logger L = ViberEnv.getLogger();
  public static final String NAME_TEXT = "name_text";
  public static final String PHOTO_URI = "photo_uri";
  public static final String SHOW_ADMIN_INDICATOR = "show_admin_indicator";
  private ImageView mAdminIndicatorView;
  private f mFetcherConfig;
  private e mImageFetcher;
  private TextView mParticipantNameView;
  private Uri mPhotoUri;
  private ImageView mPhotoView;

  private void assignAction(Intent paramIntent)
  {
    final Intent localIntent = (Intent)paramIntent.getParcelableExtra("action_intent");
    if (localIntent != null)
    {
      View.OnClickListener local2 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          PublicGroupParticipantDetailsActivity.this.startActivity(localIntent);
        }
      };
      this.mPhotoView.setOnClickListener(local2);
      this.mParticipantNameView.setOnClickListener(local2);
    }
  }

  public static Intent buildIntent(Context paramContext, Uri paramUri, String paramString)
  {
    return buildIntent(paramContext, paramUri, paramString, false);
  }

  public static Intent buildIntent(Context paramContext, Uri paramUri, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, PublicGroupParticipantDetailsActivity.class);
    if (paramUri != null)
      localIntent.putExtra("photo_uri", paramUri);
    localIntent.putExtra("show_admin_indicator", paramBoolean);
    localIntent.putExtra("name_text", paramString);
    return localIntent;
  }

  public static Intent buildIntentForSingleShowing(Context paramContext, Uri paramUri, String paramString)
  {
    return buildIntentForSingleShowing(paramContext, paramUri, paramString, false);
  }

  public static Intent buildIntentForSingleShowing(Context paramContext, Uri paramUri, String paramString, boolean paramBoolean)
  {
    return buildIntent(paramContext, paramUri, paramString, paramBoolean).addFlags(536870912);
  }

  private void displayPhoto()
  {
    this.mImageFetcher.a(null, this.mPhotoUri, this.mPhotoView, this.mFetcherConfig);
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.public_conversation_admin_details_control);
    Intent localIntent = getIntent();
    this.mPhotoUri = ((Uri)localIntent.getParcelableExtra("photo_uri"));
    String str = localIntent.getStringExtra("name_text");
    this.mPhotoView = ((ImageView)findViewById(R.id.admin_photo));
    this.mParticipantNameView = ((TextView)findViewById(R.id.admin_name));
    this.mAdminIndicatorView = ((ImageView)findViewById(R.id.adminIndicatorView));
    dj.b(this.mAdminIndicatorView, localIntent.getBooleanExtra("show_admin_indicator", false));
    View localView = findViewById(R.id.admin_details);
    this.mImageFetcher = e.a(this);
    this.mFetcherConfig = f.b().f().c();
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PublicGroupParticipantDetailsActivity.this.finish();
      }
    });
    this.mParticipantNameView.setText(str);
    displayPhoto();
    assignAction(localIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.PublicGroupParticipantDetailsActivity
 * JD-Core Version:    0.6.2
 */
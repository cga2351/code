package com.viber.voip.camrecorder.preview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.provider.d.a;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.messages.adapters.g;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.messages.extras.wink.WinkDescription;
import com.viber.voip.messages.ui.media.SendMediaDataContainer;
import com.viber.voip.permissions.m;
import com.viber.voip.ui.an;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.widget.AvatarWithInitialsView;
import com.viber.voip.widget.GroupIconView;

public class MediaPreviewActivity extends ViberFragmentActivity
  implements d.a, f.a
{
  private static final Logger a = ViberEnv.getLogger();
  private an b;
  private com.viber.voip.ui.g.b<com.viber.voip.messages.adapters.a.a, com.viber.voip.messages.adapters.a.c.a> c;
  private com.viber.voip.messages.adapters.a.c.a d;
  private j e;
  private RegularConversationLoaderEntity f;
  private long g;
  private Toolbar h;
  private c i;
  private com.viber.common.permission.b j;

  public MediaPreviewActivity()
  {
    Pair[] arrayOfPair = new Pair[1];
    arrayOfPair[0] = m.a(124);
    this.j = new com.viber.voip.permissions.f(this, arrayOfPair)
    {
      public void onCustomDialogAction(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        if (((DialogCode.D_EXPLAIN_PERMISSION.code().equals(paramAnonymousString)) || (DialogCode.D_ASK_PERMISSION.code().equals(paramAnonymousString))) && (paramAnonymousInt2 != -1))
          MediaPreviewActivity.this.finish();
      }

      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        MediaPreviewActivity.a(MediaPreviewActivity.this).l();
      }
    };
  }

  private static Intent a(Context paramContext, long paramLong, String paramString, Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, MediaPreviewActivity.class);
    localIntent.putExtra("com.viber.voip.custom_cam_media_preview_conversation_id", paramLong);
    localIntent.putExtra("com.viber.voip.custom_cam_media_preview_file_path", paramString);
    if (paramBoolean2);
    for (String str = "video/*"; ; str = "image/*")
    {
      localIntent.setDataAndType(paramUri, str);
      localIntent.putExtra("options", paramBundle);
      localIntent.putExtra("com.viber.voip.custom_cam_media_preview_can_send_time_bomd", paramBoolean1);
      return localIntent;
    }
  }

  public static void a(Activity paramActivity, long paramLong, String paramString, Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, Bundle paramBundle)
  {
    Intent localIntent = a(paramActivity, paramLong, paramString, paramUri, paramBoolean1, paramBoolean2, paramBundle);
    localIntent.putExtra("com.viber.voip.custom_cam_media_preview_from_camera", paramBoolean3);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }

  public static void a(Context paramContext, String paramString, Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    Intent localIntent = a(paramContext, -1L, paramString, paramUri, paramBoolean1, paramBoolean2, paramBundle);
    if (!(paramContext instanceof Activity))
      localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }

  public static void a(Fragment paramFragment, long paramLong, String paramString, Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, int paramInt, Bundle paramBundle)
  {
    paramFragment.startActivityForResult(a(paramFragment.getActivity(), paramLong, paramString, paramUri, paramBoolean2, paramBoolean1, paramBundle), paramInt);
  }

  private void a(RegularConversationLoaderEntity paramRegularConversationLoaderEntity)
  {
    AvatarWithInitialsView localAvatarWithInitialsView;
    GroupIconView localGroupIconView;
    com.viber.voip.util.e.e locale;
    if (paramRegularConversationLoaderEntity != null)
    {
      this.f = paramRegularConversationLoaderEntity;
      if (this.c == null)
      {
        ViewGroup localViewGroup = (ViewGroup)getSupportActionBar().a();
        localAvatarWithInitialsView = (AvatarWithInitialsView)localViewGroup.findViewById(R.id.icon);
        localGroupIconView = (GroupIconView)localViewGroup.findViewById(R.id.group_icon);
        locale = com.viber.voip.util.e.e.a(this);
        if (!this.f.isConversation1on1())
          break label166;
        dj.b(localGroupIconView, false);
      }
    }
    while (true)
    {
      this.d = new com.viber.voip.messages.adapters.a.c.a(this, null, false, ViberApplication.isTablet(this), false);
      com.viber.voip.ui.g.d[] arrayOfd = new com.viber.voip.ui.g.d[2];
      arrayOfd[0] = new com.viber.voip.messages.adapters.a.b.f(this, localAvatarWithInitialsView, locale);
      arrayOfd[1] = new com.viber.voip.messages.adapters.a.b.j(this, localGroupIconView, locale);
      this.c = new com.viber.voip.ui.g.b(arrayOfd);
      this.c.a(new g(this.f, false, false), this.d);
      return;
      label166: dj.b(localAvatarWithInitialsView, false);
    }
  }

  private void h()
  {
    this.h = ((Toolbar)findViewById(R.id.custom_cam_preview_media_toolbar));
    setSupportActionBar(this.h);
    getSupportActionBar().b(true);
    getSupportActionBar().a(true);
    getSupportActionBar().c(false);
    getSupportActionBar().d(true);
    View localView = getLayoutInflater().inflate(R.layout.media_preview_actionbar_logo, this.h, false);
    getSupportActionBar().a(localView);
  }

  private void i()
  {
    if (-1L == this.g)
      return;
    this.e = new j(this, getSupportLoaderManager(), ViberApplication.getInstance().getLazyMessagesManager(), this, this.g, com.viber.voip.h.a.b());
    this.e.p();
    this.e.i();
  }

  private long j()
  {
    long l = -1L;
    if (getIntent() != null)
      l = getIntent().getLongExtra("com.viber.voip.custom_cam_media_preview_conversation_id", l);
    return l;
  }

  private boolean k()
  {
    return (getIntent() != null) && (getIntent().getType().startsWith("video"));
  }

  protected void a()
  {
    if (k());
    for (Object localObject = new n(); ; localObject = new e())
    {
      ((f)localObject).a(e(), d(), c(), f(), g());
      getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, (Fragment)localObject, "preview_fragment_tag").commit();
      return;
    }
  }

  public void a(Uri paramUri, int paramInt, String paramString, WinkDescription paramWinkDescription, DoodleDataContainer paramDoodleDataContainer)
  {
    dj.d(this);
    Intent localIntent = new Intent();
    localIntent.putExtra("com.viber.voip.custom_cam_media_preview_conversation_id", this.g);
    localIntent.putExtra("com.viber.voip.custom_cam_media_preview_doodle_data", paramDoodleDataContainer);
    localIntent.putExtra("com.viber.voip.custom_cam_media_preview_media_data", new SendMediaDataContainer(this, paramUri, paramInt, paramString, paramWinkDescription, paramDoodleDataContainer));
    localIntent.putExtra("options", (Bundle)getIntent().getParcelableExtra("options"));
    setResult(-1, localIntent);
    finish();
  }

  public View b()
  {
    return this.h;
  }

  protected boolean c()
  {
    Intent localIntent = getIntent();
    boolean bool1 = false;
    if (localIntent != null)
    {
      boolean bool2 = getIntent().getBooleanExtra("com.viber.voip.custom_cam_media_preview_can_send_time_bomd", false);
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    return bool1;
  }

  protected String d()
  {
    if (getIntent() != null)
      return getIntent().getStringExtra("com.viber.voip.custom_cam_media_preview_file_path");
    return null;
  }

  protected Uri e()
  {
    if (getIntent() != null)
      return getIntent().getData();
    return null;
  }

  protected boolean f()
  {
    Intent localIntent = getIntent();
    boolean bool1 = false;
    if (localIntent != null)
    {
      boolean bool2 = getIntent().getBooleanExtra("com.viber.voip.custom_cam_media_preview_from_camera", false);
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    return bool1;
  }

  protected DoodleActivity.a g()
  {
    if (getIntent() != null)
      return DoodleActivity.a.values()[getIntent().getIntExtra("com.viber.voip.custom_cam_media_preview_view_mode", DoodleActivity.a.a.ordinal())];
    return DoodleActivity.a.a;
  }

  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.b.b();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    dc.a(this);
    dj.c(this, false);
    this.g = j();
    this.i = c.a(this);
    setContentView(R.layout.activity_customcam_preview);
    h();
    if (paramBundle == null)
      a();
    while (true)
    {
      i();
      this.b = new an(this);
      this.b.a();
      if (!this.i.a(com.viber.voip.permissions.n.m))
        this.i.a(this, 124, com.viber.voip.permissions.n.m);
      return;
      a((RegularConversationLoaderEntity)paramBundle.getParcelable("com.viber.voip.custom_cam_entity"));
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.e != null)
      this.e.q();
  }

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.b.c();
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    if (paramd.getCount() == 0)
      return;
    a((RegularConversationLoaderEntity)this.e.e(0));
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332:
    }
    dj.d(this);
    onBackPressed();
    return true;
  }

  protected void onResume()
  {
    super.onResume();
    this.b.d();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.f != null)
      paramBundle.putParcelable("com.viber.voip.custom_cam_entity", this.f);
    super.onSaveInstanceState(paramBundle);
  }

  protected void onStart()
  {
    super.onStart();
    this.i.a(this.j);
  }

  protected void onStop()
  {
    super.onStop();
    this.i.b(this.j);
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.b.a(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.preview.MediaPreviewActivity
 * JD-Core Version:    0.6.2
 */
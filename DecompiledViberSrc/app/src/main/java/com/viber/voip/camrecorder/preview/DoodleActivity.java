package com.viber.voip.camrecorder.preview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.viber.voip.R.id;

public class DoodleActivity extends MediaPreviewActivity
{
  public static long a = -1L;

  protected static Intent a(Context paramContext, long paramLong, String paramString, Uri paramUri, boolean paramBoolean, a parama, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramContext, DoodleActivity.class);
    localIntent.putExtra("com.viber.voip.custom_cam_media_preview_conversation_id", paramLong);
    localIntent.putExtra("com.viber.voip.custom_cam_media_preview_file_path", paramString);
    localIntent.setDataAndType(paramUri, "image/*");
    localIntent.putExtra("options", paramBundle);
    localIntent.putExtra("com.viber.voip.custom_cam_media_preview_can_send_time_bomd", paramBoolean);
    localIntent.putExtra("com.viber.voip.custom_cam_media_preview_view_mode", parama.ordinal());
    return localIntent;
  }

  public static void a(Activity paramActivity, long paramLong, String paramString, Uri paramUri, int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramActivity.startActivityForResult(a(paramActivity, paramLong, paramString, paramUri, paramBoolean, a.a, paramBundle), paramInt);
  }

  public static void a(Activity paramActivity, String paramString, Uri paramUri, int paramInt, a parama, Bundle paramBundle)
  {
    paramActivity.startActivityForResult(a(paramActivity, a, paramString, paramUri, false, parama, paramBundle), paramInt);
  }

  public static void a(Fragment paramFragment, long paramLong, String paramString, Uri paramUri, int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramFragment.startActivityForResult(a(paramFragment.getContext(), paramLong, paramString, paramUri, paramBoolean, a.a, paramBundle), paramInt);
  }

  protected void a()
  {
    b localb = new b();
    localb.a(e(), d(), c(), f(), g());
    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, localb, "preview_fragment_tag").commit();
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camrecorder.preview.DoodleActivity
 * JD-Core Version:    0.6.2
 */
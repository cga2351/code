package com.viber.voip.backgrounds.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.ViberEnv;
import com.viber.voip.backgrounds.a.a;
import com.viber.voip.backgrounds.p;

public class SelectBackgroundForVibeActivity extends BackgroundGalleryActivity
{
  private static final Logger g = ViberEnv.getLogger();

  protected void a(Uri paramUri, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("backgroundUri", paramUri.toString());
    localBundle.putString("image_change_type", paramString);
    setResult(-1, new Intent().putExtras(localBundle));
    finish();
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView.setBackgroundResource(R.drawable.bg_background_gallery_item);
    p localp = this.b.a(paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putInt("backgroundId", localp.a);
    localBundle.putBoolean("is_tile", localp.b());
    setResult(-1, new Intent().putExtras(localBundle));
    finish();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.ui.SelectBackgroundForVibeActivity
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.settings.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.viber.common.app.a;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;

public class DebugVideoAdActivity extends AppCompatActivity
{
  public static void a(Context paramContext)
  {
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.layout_video_ad);
    findViewById(R.id.you_can_close_label).setVisibility(0);
  }

  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    a.a(new h(this, paramArrayOfIntent, paramBundle), paramArrayOfIntent);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    a.a(new f(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    a.a(new g(this, paramIntent, paramInt), new Intent[] { paramIntent });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.DebugVideoAdActivity
 * JD-Core Version:    0.6.2
 */
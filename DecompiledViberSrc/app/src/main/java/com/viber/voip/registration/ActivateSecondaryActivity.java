package com.viber.voip.registration;

import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.sound.tones.SampleTone;

public class ActivateSecondaryActivity extends ViberFragmentActivity
  implements View.OnTouchListener
{
  private IRingtonePlayer a;
  private boolean b;

  private void a()
  {
    this.a.playSample(SampleTone.ACTIVATE_SECONDARY);
  }

  private void a(Intent paramIntent)
  {
    if ((paramIntent.hasExtra("code")) && (paramIntent.hasExtra("code")))
    {
      Window localWindow = getWindow();
      localWindow.addFlags(4718592);
      PowerManager localPowerManager = (PowerManager)getSystemService("power");
      KeyguardManager localKeyguardManager = (KeyguardManager)getSystemService("keyguard");
      if (!localPowerManager.isScreenOn())
      {
        localWindow.addFlags(2097152);
        this.b = true;
      }
      while (true)
      {
        localWindow.getDecorView().setOnTouchListener(this);
        this.a = ViberApplication.getInstance().getRingtonePlayer();
        a();
        String str1 = paramIntent.getStringExtra("device_type");
        String str2 = paramIntent.getStringExtra("code");
        TextView localTextView1 = (TextView)findViewById(R.id.device_top);
        TextView localTextView2 = (TextView)findViewById(R.id.device_bottom);
        TextView localTextView3 = (TextView)findViewById(R.id.code);
        TextView localTextView4 = (TextView)findViewById(R.id.click_here);
        localTextView1.setText(getString(R.string.activate_secondary_device, new Object[] { str1 }));
        localTextView2.setText(getString(R.string.activate_secondary_enter, new Object[] { str1 }));
        localTextView3.setText(str2);
        localTextView4.setText(getString(R.string.activate_secondary_ignore_this, new Object[] { str1 }));
        return;
        if (localKeyguardManager.inKeyguardRestrictedInputMode())
          this.b = true;
      }
    }
    finish();
  }

  private void b()
  {
    this.a.stopSample(SampleTone.ACTIVATE_SECONDARY);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_activate_secondary);
    a(getIntent());
  }

  protected void onDestroy()
  {
    b();
    super.onDestroy();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }

  protected void onStop()
  {
    if (this.b)
      this.b = false;
    while (true)
    {
      super.onStop();
      return;
      b();
      finish();
    }
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    b();
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.ActivateSecondaryActivity
 * JD-Core Version:    0.6.2
 */
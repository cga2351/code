package com.facebook.react.bridge;

import android.app.Activity;
import android.content.Intent;

public abstract interface ActivityEventListener
{
  public abstract void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);

  public abstract void onNewIntent(Intent paramIntent);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ActivityEventListener
 * JD-Core Version:    0.6.2
 */
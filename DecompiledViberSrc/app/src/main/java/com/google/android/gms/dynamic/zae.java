package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

final class zae
  implements View.OnClickListener
{
  zae(Context paramContext, Intent paramIntent)
  {
  }

  public final void onClick(View paramView)
  {
    try
    {
      this.val$context.startActivity(this.zarn);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", localActivityNotFoundException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.zae
 * JD-Core Version:    0.6.2
 */
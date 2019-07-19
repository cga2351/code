package com.appboy.ui.actions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.appboy.b.e;
import com.appboy.f.c;
import com.appboy.ui.activities.AppboyFeedActivity;

public class NewsfeedAction
  implements IAction
{
  private final e mChannel;
  private final Bundle mExtras;

  public NewsfeedAction(Bundle paramBundle, e parame)
  {
    this.mExtras = paramBundle;
    this.mChannel = parame;
  }

  public void execute(Context paramContext)
  {
    try
    {
      Intent localIntent = new Intent(paramContext, AppboyFeedActivity.class);
      if (this.mExtras != null)
        localIntent.putExtras(this.mExtras);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      c.d("ContentValues", "AppboyFeedActivity was not opened successfully.", localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.actions.NewsfeedAction
 * JD-Core Version:    0.6.2
 */
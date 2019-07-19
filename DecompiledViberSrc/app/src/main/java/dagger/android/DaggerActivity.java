package dagger.android;

import android.app.Activity;
import android.os.Bundle;

public abstract class DaggerActivity extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    a.a(this);
    super.onCreate(paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     dagger.android.DaggerActivity
 * JD-Core Version:    0.6.2
 */
package dagger.android.support;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import dagger.android.a;

public abstract class DaggerAppCompatActivity extends AppCompatActivity
  implements b
{
  protected void onCreate(Bundle paramBundle)
  {
    a.a(this);
    super.onCreate(paramBundle);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     dagger.android.support.DaggerAppCompatActivity
 * JD-Core Version:    0.6.2
 */
package com.my.target.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MyTargetActivity extends Activity
{
  public static a a;
  private a b;
  private FrameLayout c;

  public void onBackPressed()
  {
    if ((this.b == null) || (this.b.f()))
      super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    this.b = a;
    a = null;
    if ((this.b != null) && (localIntent != null))
    {
      this.c = new FrameLayout(this);
      this.b.a(this, localIntent, this.c);
      setContentView(this.c);
      return;
    }
    finish();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.b != null)
      this.b.e();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((this.b != null) && (this.b.a(paramMenuItem)))
      return true;
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected void onPause()
  {
    super.onPause();
    if (this.b != null)
      this.b.c();
  }

  protected void onResume()
  {
    super.onResume();
    if (this.b != null)
      this.b.d();
  }

  protected void onStart()
  {
    super.onStart();
    if (this.b != null)
      this.b.k_();
  }

  protected void onStop()
  {
    super.onStop();
    if (this.b != null)
      this.b.b();
  }

  public static abstract interface a
  {
    public abstract void a(MyTargetActivity paramMyTargetActivity, Intent paramIntent, FrameLayout paramFrameLayout);

    public abstract boolean a(MenuItem paramMenuItem);

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract boolean f();

    public abstract void k_();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.common.MyTargetActivity
 * JD-Core Version:    0.6.2
 */
package android.support.v7.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.app.TaskStackBuilder.SupportParentable;
import android.support.v7.view.b;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.VectorEnabledTintResources;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public class AppCompatActivity extends FragmentActivity
  implements TaskStackBuilder.SupportParentable, d
{
  private e mDelegate;
  private Resources mResources;
  private int mThemeId = 0;

  private boolean performMenuItemShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((Build.VERSION.SDK_INT < 26) && (!paramKeyEvent.isCtrlPressed()) && (!KeyEvent.metaStateHasNoModifiers(paramKeyEvent.getMetaState())) && (paramKeyEvent.getRepeatCount() == 0) && (!KeyEvent.isModifierKey(paramKeyEvent.getKeyCode())))
    {
      Window localWindow = getWindow();
      if ((localWindow != null) && (localWindow.getDecorView() != null) && (localWindow.getDecorView().dispatchKeyShortcutEvent(paramKeyEvent)))
        return true;
    }
    return false;
  }

  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().b(paramView, paramLayoutParams);
  }

  public void closeOptionsMenu()
  {
    a locala = getSupportActionBar();
    if ((getWindow().hasFeature(0)) && ((locala == null) || (!locala.l())))
      super.closeOptionsMenu();
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    a locala = getSupportActionBar();
    if ((i == 82) && (locala != null) && (locala.a(paramKeyEvent)))
      return true;
    return super.dispatchKeyEvent(paramKeyEvent);
  }

  public <T extends View> T findViewById(int paramInt)
  {
    return getDelegate().a(paramInt);
  }

  public e getDelegate()
  {
    if (this.mDelegate == null)
      this.mDelegate = e.a(this, this);
    return this.mDelegate;
  }

  public b.a getDrawerToggleDelegate()
  {
    return getDelegate().h();
  }

  public MenuInflater getMenuInflater()
  {
    return getDelegate().b();
  }

  public Resources getResources()
  {
    if ((this.mResources == null) && (VectorEnabledTintResources.shouldBeUsed()))
      this.mResources = new VectorEnabledTintResources(this, super.getResources());
    if (this.mResources == null)
      return super.getResources();
    return this.mResources;
  }

  public a getSupportActionBar()
  {
    return getDelegate().a();
  }

  public Intent getSupportParentActivityIntent()
  {
    return NavUtils.getParentActivityIntent(this);
  }

  public void invalidateOptionsMenu()
  {
    getDelegate().f();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getDelegate().a(paramConfiguration);
    if (this.mResources != null)
    {
      DisplayMetrics localDisplayMetrics = super.getResources().getDisplayMetrics();
      this.mResources.updateConfiguration(paramConfiguration, localDisplayMetrics);
    }
  }

  public void onContentChanged()
  {
    onSupportContentChanged();
  }

  protected void onCreate(Bundle paramBundle)
  {
    e locale = getDelegate();
    locale.i();
    locale.a(paramBundle);
    if ((locale.j()) && (this.mThemeId != 0))
    {
      if (Build.VERSION.SDK_INT < 23)
        break label55;
      onApplyThemeResource(getTheme(), this.mThemeId, false);
    }
    while (true)
    {
      super.onCreate(paramBundle);
      return;
      label55: setTheme(this.mThemeId);
    }
  }

  public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder paramTaskStackBuilder)
  {
    paramTaskStackBuilder.addParentStack(this);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    getDelegate().g();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (performMenuItemShortcut(paramInt, paramKeyEvent))
      return true;
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem))
      return true;
    a locala = getSupportActionBar();
    if ((paramMenuItem.getItemId() == 16908332) && (locala != null) && ((0x4 & locala.d()) != 0))
      return onSupportNavigateUp();
    return false;
  }

  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return super.onMenuOpened(paramInt, paramMenu);
  }

  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    getDelegate().b(paramBundle);
  }

  protected void onPostResume()
  {
    super.onPostResume();
    getDelegate().e();
  }

  public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder paramTaskStackBuilder)
  {
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    getDelegate().c(paramBundle);
  }

  protected void onStart()
  {
    super.onStart();
    getDelegate().c();
  }

  protected void onStop()
  {
    super.onStop();
    getDelegate().d();
  }

  public void onSupportActionModeFinished(b paramb)
  {
  }

  public void onSupportActionModeStarted(b paramb)
  {
  }

  @Deprecated
  public void onSupportContentChanged()
  {
  }

  public boolean onSupportNavigateUp()
  {
    Intent localIntent = getSupportParentActivityIntent();
    if (localIntent != null)
    {
      if (supportShouldUpRecreateTask(localIntent))
      {
        TaskStackBuilder localTaskStackBuilder = TaskStackBuilder.create(this);
        onCreateSupportNavigateUpTaskStack(localTaskStackBuilder);
        onPrepareSupportNavigateUpTaskStack(localTaskStackBuilder);
        localTaskStackBuilder.startActivities();
      }
      while (true)
      {
        try
        {
          ActivityCompat.finishAffinity(this);
          return true;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          finish();
          continue;
        }
        supportNavigateUpTo(localIntent);
      }
    }
    return false;
  }

  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    getDelegate().a(paramCharSequence);
  }

  public b onWindowStartingSupportActionMode(android.support.v7.view.b.a parama)
  {
    return null;
  }

  public void openOptionsMenu()
  {
    a locala = getSupportActionBar();
    if ((getWindow().hasFeature(0)) && ((locala == null) || (!locala.k())))
      super.openOptionsMenu();
  }

  public void setContentView(int paramInt)
  {
    getDelegate().b(paramInt);
  }

  public void setContentView(View paramView)
  {
    getDelegate().a(paramView);
  }

  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().a(paramView, paramLayoutParams);
  }

  public void setSupportActionBar(Toolbar paramToolbar)
  {
    getDelegate().a(paramToolbar);
  }

  @Deprecated
  public void setSupportProgress(int paramInt)
  {
  }

  @Deprecated
  public void setSupportProgressBarIndeterminate(boolean paramBoolean)
  {
  }

  @Deprecated
  public void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean)
  {
  }

  @Deprecated
  public void setSupportProgressBarVisibility(boolean paramBoolean)
  {
  }

  public void setTheme(int paramInt)
  {
    super.setTheme(paramInt);
    this.mThemeId = paramInt;
  }

  public b startSupportActionMode(android.support.v7.view.b.a parama)
  {
    return getDelegate().a(parama);
  }

  public void supportInvalidateOptionsMenu()
  {
    getDelegate().f();
  }

  public void supportNavigateUpTo(Intent paramIntent)
  {
    NavUtils.navigateUpTo(this, paramIntent);
  }

  public boolean supportRequestWindowFeature(int paramInt)
  {
    return getDelegate().c(paramInt);
  }

  public boolean supportShouldUpRecreateTask(Intent paramIntent)
  {
    return NavUtils.shouldUpRecreateTask(this, paramIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.app.AppCompatActivity
 * JD-Core Version:    0.6.2
 */
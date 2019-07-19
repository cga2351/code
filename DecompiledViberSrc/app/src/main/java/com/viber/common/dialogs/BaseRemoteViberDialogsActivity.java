package com.viber.common.dialogs;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.viber.common.R.anim;
import com.viber.common.a.e;
import com.viber.common.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BaseRemoteViberDialogsActivity extends AppCompatActivity
{
  private static e a = f.b();
  private static IntentFilter b = new IntentFilter();
  private boolean c;
  private LinkedList<Bundle> d = new LinkedList();
  private boolean e = false;
  private final BroadcastReceiver f = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ("com.viber.action.HIDE_DIALOG".equals(paramAnonymousIntent.getAction()))
        BaseRemoteViberDialogsActivity.a(BaseRemoteViberDialogsActivity.this, (DialogCodeProvider)paramAnonymousIntent.getSerializableExtra("com.viber.extra.DIALOG_CODE"));
    }
  };

  static
  {
    b.addAction("com.viber.action.HIDE_DIALOG");
  }

  public static Intent a(String paramString)
  {
    return a("com.viber.voip.action.SYSTEM_DIALOG", paramString);
  }

  public static Intent a(String paramString1, String paramString2)
  {
    return new Intent(paramString1).putExtra("com.viber.extra.TYPE", paramString2);
  }

  private void a()
  {
    if (!this.e)
    {
      registerReceiver(this.f, b);
      this.e = true;
    }
  }

  private void a(DialogCodeProvider paramDialogCodeProvider)
  {
    e locale = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramDialogCodeProvider.code();
    locale.a("Hide dialog, code: ?", arrayOfObject);
    z.a(getSupportFragmentManager(), paramDialogCodeProvider);
  }

  private void b()
  {
    if (this.e);
    try
    {
      unregisterReceiver(this.f);
      label15: this.e = false;
      return;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }

  protected boolean a(Intent paramIntent, boolean paramBoolean)
  {
    setIntent(paramIntent);
    boolean bool1 = "REMOTE_DIALOG".equals(paramIntent.getStringExtra("com.viber.extra.TYPE"));
    boolean bool2 = false;
    Bundle localBundle;
    a locala;
    if (bool1)
    {
      e locale = a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      locale.a("New incoming dialog, new: ?", arrayOfObject);
      if ((!paramBoolean) && (!this.d.isEmpty()))
        break label249;
      localBundle = paramIntent.getExtras();
      locala = m.d(localBundle);
      if (locala == null)
        bool2 = true;
    }
    else
    {
      return bool2;
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
      if (locala.equals(m.d((Bundle)localIterator.next())))
      {
        a.a("Skip dialog: ?", new Object[] { locala });
        return true;
      }
    a.a("Add pending dialog: ?", new Object[] { locala });
    int i;
    if (locala.h() == 1)
    {
      i = 1;
      if (i == 0)
        break label237;
      this.d.addFirst(localBundle);
    }
    while (true)
    {
      if ((1 == this.d.size()) || (i != 0))
        m.a(this, (Bundle)this.d.getFirst());
      return true;
      i = 0;
      break;
      label237: this.d.addLast(localBundle);
      continue;
      label249: i = 0;
    }
  }

  public void finish()
  {
    if (!this.d.isEmpty())
      this.d.removeFirst();
    if (!this.d.isEmpty())
    {
      if (!z.a(this))
        m.a(this, (Bundle)this.d.getFirst());
      return;
    }
    super.finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
    if (paramBundle != null)
    {
      this.c = true;
      if (paramBundle.containsKey("save_state_pending_dialogs"))
        this.d = new LinkedList((ArrayList)paramBundle.getSerializable("save_state_pending_dialogs"));
    }
  }

  protected void onDestroy()
  {
    b();
    super.onDestroy();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    a(paramIntent, true);
    super.onNewIntent(paramIntent);
  }

  protected void onPause()
  {
    super.onPause();
    if (isFinishing())
      overridePendingTransition(0, R.anim.non_flickering_sleep);
  }

  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    com.viber.common.permission.c.a(this).a(this, paramInt, paramArrayOfString, paramArrayOfInt);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (!this.d.isEmpty())
      paramBundle.putSerializable("save_state_pending_dialogs", this.d);
  }

  protected void onStart()
  {
    super.onStart();
    if (!this.c)
      a(getIntent(), false);
    this.c = false;
  }

  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new d(this, paramArrayOfIntent, paramBundle), paramArrayOfIntent);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    com.viber.common.app.a.a(new b(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    com.viber.common.app.a.a(new c(this, paramIntent, paramInt), new Intent[] { paramIntent });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.dialogs.BaseRemoteViberDialogsActivity
 * JD-Core Version:    0.6.2
 */
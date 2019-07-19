package com.viber.voip;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.viber.common.dialogs.h.a;
import com.viber.common.permission.b;
import com.viber.dexshared.Logger;
import com.viber.voip.permissions.m;
import com.viber.voip.permissions.n;
import com.viber.voip.util.ViberActionRunner.aw;
import com.viber.voip.util.ViberActionRunner.c;
import com.viber.voip.util.ViberActionRunner.o;
import com.viber.voip.util.dj;
import com.viber.voip.util.q;

public class AddFriendActivity extends BaseAddFriendActivity
  implements BaseAddFriendActivity.b
{
  static final Logger a = ViberEnv.getLogger();
  private EditText b;
  private Button c;
  private String d;
  private com.viber.common.permission.c e;
  private final b f;

  public AddFriendActivity()
  {
    Pair[] arrayOfPair = new Pair[2];
    arrayOfPair[0] = m.a(2);
    arrayOfPair[1] = m.a(75);
    this.f = new com.viber.voip.permissions.f(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 2:
          AddFriendActivity.this.a();
          return;
        case 75:
        }
        AddFriendActivity.a(AddFriendActivity.this);
      }
    };
  }

  private void e()
  {
    if (this.e.a(n.k))
    {
      f();
      return;
    }
    this.e.a(this, 75, n.k);
  }

  private void f()
  {
    i();
    a(null, h(), true, this);
  }

  private void g()
  {
    if (this.e.a(n.a))
    {
      a();
      return;
    }
    this.e.a(this, 2, n.a);
  }

  private String h()
  {
    return this.b.getText().toString().trim();
  }

  private void i()
  {
    dj.c(this.b);
  }

  void a()
  {
    i();
    ViberActionRunner.aw.a(true, this, "Contacts", null);
    finish();
  }

  public void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 3:
    default:
      com.viber.voip.ui.dialogs.a.a().a(this);
      return;
    case 1:
    case 5:
    case 6:
    case 7:
      ViberActionRunner.c.a(this, paramString, "Manual", this.d);
      finish();
      return;
    case 4:
      com.viber.voip.ui.dialogs.f.b().d();
      return;
    case 2:
    }
    com.viber.voip.ui.dialogs.f.d().a(this);
  }

  public void a(BaseAddFriendActivity.ContactDetails paramContactDetails, boolean paramBoolean)
  {
    if (paramBoolean)
      ViberActionRunner.o.a(this, ViberApplication.isTablet(this), paramContactDetails.getContactId(), paramContactDetails.getDisplayName(), paramContactDetails.getLookupKey(), paramContactDetails.getPhotoUri());
    while (true)
    {
      finish();
      return;
      ViberActionRunner.c.a(this, paramContactDetails.getPhoneNumber(), paramContactDetails, "Manual", this.d);
    }
  }

  public void b()
  {
  }

  public void finish()
  {
    i();
    super.finish();
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    super.onCreate(paramBundle);
    setContentView(R.layout.add_friend_activity);
    setActionBarTitle(R.string.add_friend_title);
    this.e = com.viber.common.permission.c.a(this);
    android.support.v7.app.a locala = getSupportActionBar();
    if (locala != null)
      locala.b(bool);
    Intent localIntent = getIntent();
    this.d = localIntent.getStringExtra("entry_point");
    this.b = ((EditText)findViewById(R.id.phone_number));
    this.c = ((Button)findViewById(R.id.continue_btn));
    Button localButton1 = (Button)findViewById(R.id.scan_code);
    TextView localTextView1 = (TextView)findViewById(R.id.or_label);
    TextView localTextView2 = (TextView)findViewById(R.id.scan_code_help_text);
    if (paramBundle == null)
    {
      this.b.setText(localIntent.getStringExtra("phone_number"));
      Editable localEditable = this.b.getText();
      if (!TextUtils.isEmpty(localEditable))
        this.b.setSelection(localEditable.length());
    }
    Button localButton2 = this.c;
    if (h().length() > 0);
    while (true)
    {
      localButton2.setEnabled(bool);
      this.b.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
        }

        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
        }

        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          Button localButton = AddFriendActivity.b(AddFriendActivity.this);
          if (paramAnonymousCharSequence.toString().trim().length() > 0);
          for (boolean bool = true; ; bool = false)
          {
            localButton.setEnabled(bool);
            return;
          }
        }
      });
      this.b.setOnEditorActionListener(new c(this));
      this.c.setOnClickListener(new d(this));
      localButton1.setOnClickListener(new e(this));
      if (!q.a())
        break;
      localButton1.setVisibility(0);
      localTextView1.setVisibility(0);
      localTextView2.setVisibility(0);
      return;
      bool = false;
    }
    localButton1.setVisibility(8);
    localTextView1.setVisibility(8);
    localTextView2.setVisibility(8);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332:
    }
    onBackPressed();
    return true;
  }

  protected void onStart()
  {
    super.onStart();
    this.e.a(this.f);
  }

  protected void onStop()
  {
    this.e.b(this.f);
    super.onStop();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.AddFriendActivity
 * JD-Core Version:    0.6.2
 */
package com.viber.voip.messages.conversation.community;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.m.g;
import com.viber.common.dialogs.z;
import com.viber.common.permission.c;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.g;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.GroupController.GroupMember;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.conversation.community.a.d;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.util.ay;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.j;
import java.util.Arrays;

public class CreateCommunityActivity extends ViberFragmentActivity
  implements m.g
{
  private c a;
  private a b;
  private f c;
  private CreateCommunityPresenter d;

  protected void a(android.support.v7.app.a parama)
  {
    parama.e(true);
    parama.b(true);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.b.a(paramInt1, paramInt2, paramIntent);
  }

  public void onBackPressed()
  {
    this.b.f();
  }

  protected void onCreate(Bundle paramBundle)
  {
    if (ViberApplication.isTablet(this))
    {
      dj.b(this);
      getWindow().setSoftInputMode(36);
    }
    GroupController.GroupMember[] arrayOfGroupMember;
    while (true)
    {
      super.onCreate(paramBundle);
      setContentView(R.layout.create_community_layout);
      a(getSupportActionBar());
      this.a = c.a(this);
      this.b = new a(this, e.a(this), this.a, getSupportFragmentManager());
      Parcelable[] arrayOfParcelable = getIntent().getParcelableArrayExtra("members_extra");
      arrayOfGroupMember = new GroupController.GroupMember[arrayOfParcelable.length];
      for (int i = 0; i < arrayOfParcelable.length; i++)
        arrayOfGroupMember[i] = ((GroupController.GroupMember)arrayOfParcelable[i]);
      com.viber.voip.n.a.d(this);
    }
    this.c = new f(this);
    com.viber.voip.messages.conversation.community.a.b localb = new com.viber.voip.messages.conversation.community.a.b(this, Arrays.asList(arrayOfGroupMember), new b(null));
    g localg = g.a();
    this.d = new CreateCommunityPresenter(av.a(av.e.a), arrayOfGroupMember, com.viber.voip.messages.controller.manager.o.a(), ViberApplication.getInstance().getMessagesManager().d(), this.c, localb, this.a, localg, localg.c().g(), ViberApplication.getInstance().getMessagesManager().c(), com.viber.voip.h.a.b(), ab.a());
    CreateCommunityPresenter localCreateCommunityPresenter = this.d;
    a locala = this.b;
    if (paramBundle != null);
    for (Parcelable localParcelable = paramBundle.getParcelable("presenter_state"); ; localParcelable = getIntent().getParcelableExtra("presenter_state"))
    {
      localCreateCommunityPresenter.a(locala, localParcelable);
      setActionBarTitle(R.string.community_intro_btn);
      return;
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_pa_edit, paramMenu);
    this.b.a(paramMenu.findItem(R.id.menu_save));
    return true;
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.d.a();
  }

  public void onDialogListAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.DC19))
    {
      if (paramInt != 0)
        break label22;
      this.d.c();
    }
    label22: 
    do
    {
      return;
      if (1 == paramInt)
      {
        this.d.d();
        return;
      }
    }
    while (2 != paramInt);
    this.d.a(null);
    this.b.a(null);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return false;
    case 16908332:
    }
    this.b.f();
    return true;
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("presenter_state", this.d.b());
  }

  public void onStart()
  {
    super.onStart();
    this.b.d();
  }

  public void onStop()
  {
    super.onStop();
    this.b.e();
  }

  public final class a
    implements TextWatcher, MenuItem.OnMenuItemClickListener, View.OnClickListener, TextView.OnEditorActionListener, a
  {
    private final Activity b;
    private final FragmentManager c;
    private c d;
    private final e e;
    private final EditText f;
    private final EditText g;
    private final ImageView h;
    private final ImageView i;
    private final Button j;
    private final View k;
    private final com.viber.common.permission.b l;
    private MenuItem m;

    public a(Activity parame, e paramc, c paramFragmentManager, FragmentManager arg5)
    {
      this.b = parame;
      this.e = paramc;
      Object localObject;
      this.c = localObject;
      this.d = paramFragmentManager;
      this.g = ((EditText)parame.findViewById(R.id.community_description));
      this.f = ((EditText)parame.findViewById(R.id.community_name));
      this.i = ((ImageView)parame.findViewById(R.id.community_icon));
      this.j = ((Button)parame.findViewById(R.id.community_edit_icon));
      this.h = ((ImageView)parame.findViewById(R.id.camera_icon));
      this.k = parame.findViewById(R.id.community_icon_clickable_area);
      this.k.setOnClickListener(this);
      this.j.setOnClickListener(this);
      this.f.setOnClickListener(this);
      this.f.addTextChangedListener(this);
      this.f.setOnEditorActionListener(this);
      if (com.viber.common.d.a.n())
        this.f.requestFocus();
      this.g.setOnEditorActionListener(this);
      this.g.setImeOptions(6);
      this.g.setRawInputType(1);
      TextView localTextView = (TextView)parame.findViewById(R.id.learn_more_text);
      localTextView.setText(Html.fromHtml(CreateCommunityActivity.this.getString(R.string.group2_creation_learn_more_gdpr)));
      localTextView.setMovementMethod(LinkMovementMethod.getInstance());
      localTextView.setHighlightColor(0);
      Activity localActivity = this.b;
      Pair[] arrayOfPair = new Pair[2];
      arrayOfPair[0] = com.viber.voip.permissions.m.a(9);
      arrayOfPair[1] = com.viber.voip.permissions.m.a(127);
      this.l = new com.viber.voip.permissions.f(localActivity, arrayOfPair)
      {
        public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
        {
          CreateCommunityActivity.a(CreateCommunityActivity.this).a(paramAnonymousInt, paramAnonymousArrayOfString, paramAnonymousObject);
        }
      };
    }

    private void a(int paramInt)
    {
      MenuItem localMenuItem;
      if (this.m != null)
      {
        localMenuItem = this.m;
        if (paramInt <= 0)
          break label27;
      }
      label27: for (boolean bool = true; ; bool = false)
      {
        localMenuItem.setVisible(bool);
        return;
      }
    }

    private void g()
    {
      if (CreateCommunityActivity.a(CreateCommunityActivity.this).e() != null);
      for (boolean bool = true; ; bool = false)
      {
        ay.a(this.b, bool);
        return;
      }
    }

    public void a()
    {
      ad.b().a(this.b);
    }

    protected void a(int paramInt1, int paramInt2, Intent paramIntent)
    {
      if (paramInt2 == -1)
        switch (paramInt1)
        {
        default:
        case 100:
        case 101:
        case 102:
        }
      while (paramInt2 != 0)
      {
        return;
        CreateCommunityActivity.b(CreateCommunityActivity.this).a(paramIntent, CreateCommunityActivity.a(CreateCommunityActivity.this).e(), 102);
        CreateCommunityActivity.a(CreateCommunityActivity.this).a(null);
        return;
        j.a(this.b, paramIntent.getData(), "image");
        CreateCommunityActivity.b(CreateCommunityActivity.this).a(paramIntent, CreateCommunityActivity.a(CreateCommunityActivity.this).e(), 102);
        return;
        Uri localUri = Uri.parse(paramIntent.getAction());
        CreateCommunityActivity.a(CreateCommunityActivity.this).a(localUri);
        CreateCommunityActivity.c(CreateCommunityActivity.this).a(localUri);
        return;
      }
      CreateCommunityActivity.a(CreateCommunityActivity.this).a(null);
    }

    public void a(int paramInt, String[] paramArrayOfString)
    {
      this.d.a(this.b, paramInt, paramArrayOfString);
    }

    public void a(Uri paramUri)
    {
      boolean bool1 = true;
      Button localButton = this.j;
      boolean bool2;
      ImageView localImageView;
      if (paramUri != null)
      {
        bool2 = bool1;
        dj.b(localButton, bool2);
        localImageView = this.h;
        if (paramUri != null)
          break label58;
      }
      while (true)
      {
        dj.b(localImageView, bool1);
        this.e.a(paramUri, this.i, com.viber.voip.util.e.f.a());
        return;
        bool2 = false;
        break;
        label58: bool1 = false;
      }
    }

    public void a(MenuItem paramMenuItem)
    {
      this.m = paramMenuItem;
      this.m.setOnMenuItemClickListener(this);
      a(this.f.getText().length());
    }

    public void a(String paramString)
    {
      this.f.setText(paramString);
    }

    public void afterTextChanged(Editable paramEditable)
    {
    }

    public void b()
    {
      h.a locala = com.viber.voip.ui.dialogs.k.n();
      int n = R.string.dialog_339_message_with_reason;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.b.getString(R.string.dialog_339_reason_create_group);
      locala.b(n, arrayOfObject).a(this.b);
    }

    public void b(String paramString)
    {
      this.g.setText(paramString);
    }

    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
    }

    public void c()
    {
      if (!this.b.isFinishing())
        z.b(this.c, DialogCode.D_PROGRESS);
    }

    public void d()
    {
      this.d.a(this.l);
    }

    public void e()
    {
      this.d.b(this.l);
    }

    public void f()
    {
      CreateCommunityActivity.a(CreateCommunityActivity.this).a(this.f.getText().toString(), this.g.getText().toString());
    }

    public void onClick(View paramView)
    {
      int n = paramView.getId();
      if ((n == R.id.community_icon_clickable_area) || (n == R.id.community_edit_icon))
        g();
    }

    public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      switch (paramInt)
      {
      default:
        return false;
      case 5:
        this.g.requestFocus();
        return true;
      case 6:
      }
      if (!da.a(this.f.getText()))
      {
        onMenuItemClick(this.m);
        return true;
      }
      this.f.requestFocus();
      return true;
    }

    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      if (cj.a(true))
      {
        dj.d(this.b);
        CreateCommunityActivity.a(CreateCommunityActivity.this).b(this.f.getText().toString().trim(), this.g.getText().toString().trim());
        return true;
      }
      return false;
    }

    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      a(paramCharSequence.toString().trim().length());
    }
  }

  private final class b extends d
  {
    private b()
    {
    }

    public void a(int paramInt)
    {
      CreateCommunityActivity.a(CreateCommunityActivity.this).a(paramInt);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.community.CreateCommunityActivity
 * JD-Core Version:    0.6.2
 */
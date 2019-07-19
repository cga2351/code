package com.viber.voip;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentProviderResult;
import android.content.Context;
import android.content.Intent;
import android.content.OperationApplicationException;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.spam.UnknownNumberReportController;
import com.viber.voip.contacts.c.d.g.f;
import com.viber.voip.contacts.c.d.g.h;
import com.viber.voip.contacts.c.d.m.b;
import com.viber.voip.contacts.ui.aj;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.ai.e;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.permissions.n;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.p;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.o;
import com.viber.voip.util.ViberActionRunner.q;
import com.viber.voip.util.ae;
import com.viber.voip.util.at;
import com.viber.voip.util.bp;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;
import com.viber.voip.util.dv;
import com.viber.voip.util.q;
import com.viber.voip.util.upload.ObjectId;
import com.viber.voip.widget.SpinnerWithDescription;
import com.viber.voip.widget.TextViewWithDescription;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

public class AddFriendPreviewActivity extends BaseAddFriendActivity
  implements View.OnClickListener, m.c, BaseAddFriendActivity.b, g.f
{
  private static final Logger c = ViberEnv.getLogger();
  private boolean A;
  private boolean B;
  private boolean C;
  private ColorFilter D;
  private String E;
  private String F;
  private boolean G;
  private String H;
  private String I;
  private com.viber.common.permission.c J;
  private com.viber.voip.contacts.c.d.g K;
  private final Handler L = av.e.h.a();
  private final Handler M = av.e.a.a();
  private final Runnable N = new b(this, null);
  private long O;
  private final com.viber.common.permission.b P;
  private View.OnClickListener Q;
  private TextView.OnEditorActionListener R;
  private com.viber.voip.util.e.h.a S;
  private PopupWindow T;

  @Inject
  com.viber.voip.analytics.g a;

  @Inject
  com.viber.voip.analytics.story.d.c b;
  private MenuItem d;
  private View e;
  private View f;
  private ImageView g;
  private a h;
  private SpinnerWithDescription i;
  private TextViewWithDescription j;
  private TextViewWithDescription k;
  private TextViewWithDescription l;
  private ImageView m;
  private ImageView n;
  private ImageView o;
  private int p;
  private int q;
  private Drawable r;
  private Drawable s;
  private com.viber.voip.util.e.e t;
  private com.viber.voip.util.e.f u;
  private Uri v;
  private Bitmap w;
  private Uri x;
  private boolean y;
  private boolean z;

  public AddFriendPreviewActivity()
  {
    Pair[] arrayOfPair = new Pair[3];
    arrayOfPair[0] = com.viber.voip.permissions.m.a(11);
    arrayOfPair[1] = com.viber.voip.permissions.m.a(75);
    arrayOfPair[2] = com.viber.voip.permissions.m.a(128);
    this.P = new com.viber.voip.permissions.f(this, arrayOfPair)
    {
      public void onCustomDialogAction(int paramAnonymousInt1, String paramAnonymousString, int paramAnonymousInt2)
      {
        switch (paramAnonymousInt1)
        {
        default:
        case 75:
        }
        do
          return;
        while ((!DialogCode.D_ASK_PERMISSION.code().equals(paramAnonymousString)) && ((!DialogCode.D_EXPLAIN_PERMISSION.code().equals(paramAnonymousString)) || (-2 != paramAnonymousInt2)));
        AddFriendPreviewActivity.this.finish();
      }

      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 11:
          AddFriendPreviewActivity.b(AddFriendPreviewActivity.this);
          return;
        case 75:
          AddFriendPreviewActivity.c(AddFriendPreviewActivity.this);
          return;
        case 128:
        }
        AddFriendPreviewActivity.d(AddFriendPreviewActivity.this);
      }
    };
    this.Q = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AddFriendPreviewActivity.e(AddFriendPreviewActivity.this);
      }
    };
    this.R = new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        switch (paramAnonymousInt)
        {
        default:
          return false;
        case 6:
        }
        if (AddFriendPreviewActivity.f(AddFriendPreviewActivity.this).isEnabled())
          AddFriendPreviewActivity.e(AddFriendPreviewActivity.this);
        return true;
      }
    };
    this.S = new com.viber.voip.util.e.h.a()
    {
      public void onLoadComplete(Uri paramAnonymousUri, Bitmap paramAnonymousBitmap, boolean paramAnonymousBoolean)
      {
        boolean bool;
        if ((AddFriendPreviewActivity.g(AddFriendPreviewActivity.this).getDrawable() instanceof com.viber.common.ui.b))
        {
          paramAnonymousBitmap = ((com.viber.common.ui.b)AddFriendPreviewActivity.g(AddFriendPreviewActivity.this).getDrawable()).b();
          if (com.viber.voip.util.e.e.a(AddFriendPreviewActivity.h(AddFriendPreviewActivity.this)) == paramAnonymousBitmap)
            bool = true;
        }
        while (true)
        {
          if (!bool)
            AddFriendPreviewActivity.a(AddFriendPreviewActivity.this, paramAnonymousBitmap);
          if ((paramAnonymousUri != null) && (bool))
          {
            String str = paramAnonymousUri.getScheme();
            if ((str != null) && (str.startsWith("http")))
              AddFriendPreviewActivity.a(AddFriendPreviewActivity.this, null);
          }
          AddFriendPreviewActivity.a(AddFriendPreviewActivity.this, true);
          AddFriendPreviewActivity.b(AddFriendPreviewActivity.this, true);
          if (bool)
            AddFriendPreviewActivity.c(AddFriendPreviewActivity.this, true);
          if ((ViberApplication.isTablet(AddFriendPreviewActivity.this)) && (AddFriendPreviewActivity.i(AddFriendPreviewActivity.this)))
          {
            AddFriendPreviewActivity.j(AddFriendPreviewActivity.this).setVisibility(0);
            AddFriendPreviewActivity.g(AddFriendPreviewActivity.this).setOnClickListener(AddFriendPreviewActivity.this);
            AddFriendPreviewActivity.j(AddFriendPreviewActivity.this).setOnClickListener(AddFriendPreviewActivity.this);
          }
          if (((bool) || (AddFriendPreviewActivity.i(AddFriendPreviewActivity.this))) && (!ViberApplication.isTablet(AddFriendPreviewActivity.this)))
            AddFriendPreviewActivity.k(AddFriendPreviewActivity.this).setVisibility(0);
          if ((!bool) && (AddFriendPreviewActivity.i(AddFriendPreviewActivity.this)) && (!ViberApplication.isTablet(AddFriendPreviewActivity.this)))
          {
            AddFriendPreviewActivity.g(AddFriendPreviewActivity.this).getDrawable().setColorFilter(AddFriendPreviewActivity.l(AddFriendPreviewActivity.this));
            DrawableCompat.setTint(AddFriendPreviewActivity.m(AddFriendPreviewActivity.this), AddFriendPreviewActivity.n(AddFriendPreviewActivity.this));
            DrawableCompat.setTint(AddFriendPreviewActivity.o(AddFriendPreviewActivity.this), AddFriendPreviewActivity.n(AddFriendPreviewActivity.this));
          }
          return;
          bool = false;
          continue;
          bool = paramAnonymousBoolean;
        }
      }
    };
  }

  private void a(Account paramAccount, String paramString)
  {
    String str1 = this.j.getText().toString().trim();
    String str2 = this.k.getText().toString().trim();
    Intent localIntent = new Intent("android.intent.action.INSERT_OR_EDIT");
    localIntent.setType("vnd.android.cursor.item/contact");
    localIntent.putExtra("phone", paramString);
    if (!TextUtils.isEmpty(str1))
      localIntent.putExtra("name", str1);
    if (!TextUtils.isEmpty(str2))
      localIntent.putExtra("phonetic_name", str2);
    localIntent.putExtra("finishActivityOnSaveCompleted", true);
    if ((paramAccount != null) && (com.viber.common.d.a.j()))
      localIntent.putExtra("android.provider.extra.ACCOUNT", paramAccount);
    List localList = getPackageManager().queryIntentActivities(localIntent, 65536);
    if ((localList != null) && (localList.size() > 0))
    {
      startActivity(localIntent);
      finish();
      return;
    }
    k();
  }

  private void a(final Bitmap paramBitmap, final boolean paramBoolean)
  {
    final Account localAccount = (Account)this.i.getSelectedItem();
    final String str1 = this.l.getText().toString().trim();
    String str2 = this.j.getText().toString().trim();
    String str3 = this.k.getText().toString().trim();
    this.K.a(localAccount, str1, str2, str3, paramBitmap, new g.h()
    {
      public void a(Exception paramAnonymousException)
      {
        if ((paramAnonymousException instanceof OperationApplicationException))
        {
          AddFriendPreviewActivity.p(AddFriendPreviewActivity.this).post(new i(this, localAccount, str1));
          return;
        }
        AddFriendPreviewActivity.p(AddFriendPreviewActivity.this).post(new j(AddFriendPreviewActivity.this));
      }

      public void a(ContentProviderResult[] paramAnonymousArrayOfContentProviderResult)
      {
        AddFriendPreviewActivity.p(AddFriendPreviewActivity.this).post(new h(this, paramAnonymousArrayOfContentProviderResult, localAccount, str1, paramBitmap, paramBoolean));
      }
    });
  }

  private void a(String paramString)
  {
    this.K.c().a(paramString, new m.b()
    {
      public void a(String paramAnonymousString, final Set<com.viber.voip.model.a> paramAnonymousSet)
      {
        AddFriendPreviewActivity.p(AddFriendPreviewActivity.this).post(new Runnable()
        {
          public void run()
          {
            if (paramAnonymousSet.isEmpty())
              return;
            BaseAddFriendActivity.ContactDetails localContactDetails = new BaseAddFriendActivity.ContactDetails((com.viber.voip.model.a)paramAnonymousSet.iterator().next());
            AddFriendPreviewActivity.this.a(localContactDetails);
          }
        });
      }
    });
  }

  private void a(String paramString, BaseAddFriendActivity.ContactDetails paramContactDetails, Bundle paramBundle)
  {
    boolean bool1 = a(this);
    boolean bool2;
    String str3;
    label88: int i2;
    if (paramBundle == null)
    {
      this.l.setText(paramString);
      this.l.setEditable(TextUtils.isEmpty(paramString));
      if (paramContactDetails != null)
      {
        this.v = paramContactDetails.getPhotoUri();
        this.F = paramContactDetails.getMemberId();
        if ((this.v == null) || (!paramContactDetails.isViberPhoto()))
        {
          bool2 = true;
          this.z = bool2;
          if (TextUtils.isEmpty(this.E))
            break label254;
          str3 = this.E;
          this.j.setText(str3);
          TextViewWithDescription localTextViewWithDescription2 = this.k;
          i2 = 0;
          if (!bool1)
          {
            boolean bool3 = com.viber.voip.util.a.e.m(str3);
            i2 = 0;
            if (!bool3)
              break label263;
          }
          label126: localTextViewWithDescription2.setVisibility(i2);
          this.G = paramContactDetails.isViber();
          label141: if ((this.k.getVisibility() == 0) || (this.l.ah_()))
            break label441;
          this.j.setImeOptions(6);
          this.j.setOnEditorActionListener(this.R);
          label181: if (!this.l.ah_())
            break label452;
          this.k.setImeOptions(5);
          this.l.setImeOptions(6);
          this.l.setOnEditorActionListener(this.R);
        }
      }
    }
    while (true)
    {
      this.t.a(null, this.v, this.g, this.u, this.S);
      h();
      return;
      bool2 = false;
      break;
      label254: str3 = paramContactDetails.getDisplayName();
      break label88;
      label263: i2 = 8;
      break label126;
      TextViewWithDescription localTextViewWithDescription1 = this.k;
      int i1 = 0;
      if (bool1);
      while (true)
      {
        localTextViewWithDescription1.setVisibility(i1);
        if (TextUtils.isEmpty(this.E))
          break;
        this.j.setText(this.E);
        break;
        i1 = 8;
      }
      this.v = ((Uri)paramBundle.getParcelable("photo_uri"));
      this.F = paramBundle.getString("member_id");
      this.z = paramBundle.getBoolean("can_change_photo");
      this.A = paramBundle.getBoolean("is_loaded_photo");
      this.G = paramBundle.getBoolean("is_viber");
      String str1 = paramBundle.getString("display_name");
      String str2 = paramBundle.getString("phonetic_name");
      if ((bool1) || (com.viber.voip.util.a.e.m(str1)) || (!TextUtils.isEmpty(str2)))
      {
        this.k.setVisibility(0);
        break label141;
      }
      this.k.setVisibility(8);
      break label141;
      label441: this.j.setImeOptions(5);
      break label181;
      label452: this.k.setImeOptions(6);
      this.k.setOnEditorActionListener(this.R);
    }
  }

  private void a(String paramString1, String paramString2)
  {
    com.viber.voip.messages.m.a(new com.viber.voip.messages.controller.c.b(0L, paramString1, 0, 0).a(4, ObjectId.fromLong(411L), 0), paramString2, new ai.e()
    {
      public void a(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
      {
        AddFriendPreviewActivity.this.startActivity(com.viber.voip.messages.m.a(paramAnonymousConversationItemLoaderEntity.getId(), 0, false, paramAnonymousConversationItemLoaderEntity.isInBusinessInbox(), paramAnonymousConversationItemLoaderEntity.isVlnConversation(), false));
      }
    });
  }

  private void a(boolean paramBoolean)
  {
    this.e.setEnabled(paramBoolean);
    if (this.d != null)
      this.d.setVisible(paramBoolean);
  }

  private void a(ContentProviderResult[] paramArrayOfContentProviderResult, Account paramAccount, String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramArrayOfContentProviderResult.length > 0)
    {
      if (paramAccount != null)
        d.p.j.a(paramAccount.name);
      if (this.y)
      {
        a(this.F, paramString);
        finish();
      }
      if ((paramBitmap == null) && (paramBoolean))
        Toast.makeText(this, R.string.add_friend_unable_to_save_photo, 1).show();
      return;
    }
    if (paramBitmap != null)
    {
      a(null, true);
      return;
    }
    k();
  }

  private static boolean a(Context paramContext)
  {
    Locale localLocale = bp.a(paramContext.getResources());
    return (Locale.JAPAN.equals(localLocale)) || (Locale.JAPANESE.equals(localLocale)) || (UserManager.from(paramContext).getRegistrationValues().p());
  }

  private void b(String paramString)
  {
    ad.b(paramString).a(this).a(this);
  }

  private void e()
  {
    View localView = getLayoutInflater().inflate(R.layout.add_friend_popup_menu, null, false);
    localView.findViewById(R.id.open_camera).setOnClickListener(this);
    localView.findViewById(R.id.open_gallery).setOnClickListener(this);
    this.T = new PopupWindow(localView, getResources().getDimensionPixelOffset(R.dimen.add_friend_preview_dialog_width), -2);
    this.T.setTouchable(true);
    this.T.setOutsideTouchable(true);
    this.T.setFocusable(true);
    this.T.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(this, R.color.transparent)));
  }

  private void f()
  {
    if (!this.T.isShowing())
    {
      int[] arrayOfInt = new int[2];
      this.o.getLocationOnScreen(arrayOfInt);
      int i1 = getResources().getDimensionPixelOffset(R.dimen.info_popup_maring) + (arrayOfInt[0] + this.o.getMeasuredWidth());
      int i2 = arrayOfInt[1];
      this.T.showAtLocation(this.o, 0, i1, i2);
    }
  }

  private void g()
  {
    if ((this.T != null) && (this.T.isShowing()))
      this.T.dismiss();
  }

  private void h()
  {
    if (this.J.a(n.k))
    {
      i();
      return;
    }
    this.J.a(this, 75, n.k);
  }

  private void i()
  {
    Account[] arrayOfAccount = ((AccountManager)getSystemService("account")).getAccountsByType("com.google");
    this.h = new a(arrayOfAccount, getLayoutInflater());
    this.i.setAdapter(this.h);
    String str = d.p.j.d();
    if (arrayOfAccount.length == 0)
      this.i.setVisibility(8);
    int i2;
    do
    {
      int i3;
      do
      {
        return;
        if (arrayOfAccount.length == 1)
        {
          this.i.setSelection(0);
          return;
        }
        if (!TextUtils.isEmpty(str))
          break;
        i3 = this.h.a();
      }
      while (i3 == -1);
      this.i.setSelection(i3);
      return;
      int i1 = this.h.a(str);
      if (i1 != -1)
      {
        this.i.setSelection(i1);
        return;
      }
      i2 = this.h.a();
    }
    while (i2 == -1);
    this.i.setSelection(i2);
  }

  private void j()
  {
    if (this.C)
      return;
    this.O = System.currentTimeMillis();
    this.C = true;
    l();
    a(this.w, false);
  }

  private void k()
  {
    m();
    com.viber.common.dialogs.h.a locala = k.n();
    int i1 = R.string.dialog_339_message_with_reason;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = getString(R.string.dialog_339_reason_contacts_screen);
    locala.b(i1, arrayOfObject).a(this);
    this.C = false;
  }

  private void l()
  {
    this.M.postDelayed(this.N, 60000L);
    c();
  }

  private void m()
  {
    this.M.removeCallbacks(this.N);
    d();
  }

  private void n()
  {
    if (!q.a())
    {
      Toast.makeText(this, R.string.photo_no_camera, 0).show();
      return;
    }
    if (this.J.a(n.c))
    {
      o();
      return;
    }
    this.J.a(this, 11, n.c);
  }

  private void o()
  {
    if ((com.viber.voip.util.upload.o.b(true)) && (com.viber.voip.util.upload.o.a(true)))
    {
      this.x = dv.h.a(this, null, true);
      if (this.x != null)
        ViberActionRunner.a(this, this.x, 10);
    }
  }

  private void p()
  {
    if (this.J.a(n.m))
    {
      q();
      return;
    }
    this.J.a(this, 128, n.m);
  }

  private void q()
  {
    if ((com.viber.voip.util.upload.o.b(true)) && (com.viber.voip.util.upload.o.a(true)))
      startActivityForResult(ViberActionRunner.a(new Intent().setType("image/*").setAction("android.intent.action.GET_CONTENT"), getString(R.string.msg_options_take_photo), new Intent[0]), 20);
  }

  public void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 3:
    default:
      a(null, null, null);
      com.viber.voip.ui.dialogs.a.a().a(this);
    case 1:
    case 5:
    case 6:
    case 7:
      do
      {
        return;
        a(paramString, null, null);
      }
      while (!this.B);
      b(paramString);
      return;
    case 4:
      a(paramString, null, null);
      com.viber.voip.ui.dialogs.f.b().d();
      return;
    case 2:
    }
    a(paramString, null, null);
    com.viber.voip.ui.dialogs.f.d().a(this);
  }

  protected void a(long paramLong)
  {
    ViberActionRunner.o.a(this, ViberApplication.isTablet(this), paramLong, this.E, null, this.v);
    finish();
  }

  protected void a(BaseAddFriendActivity.ContactDetails paramContactDetails)
  {
    ViberActionRunner.o.a(this, ViberApplication.isTablet(this), paramContactDetails.getContactId(), paramContactDetails.getDisplayName(), paramContactDetails.getLookupKey(), paramContactDetails.getPhotoUri());
    finish();
  }

  public void a(BaseAddFriendActivity.ContactDetails paramContactDetails, boolean paramBoolean)
  {
    getIntent().removeExtra("member_id");
    if (paramBoolean)
    {
      a(paramContactDetails);
      return;
    }
    a(paramContactDetails.getPhoneNumber(), paramContactDetails, null);
  }

  public void a(Map<String, Long> paramMap)
  {
    if (!this.C);
    String str;
    do
    {
      return;
      str = this.l.getText().toString().trim();
    }
    while (!paramMap.containsKey(str));
    this.M.post(new f(this));
    this.K.b(this);
    if (this.G)
    {
      Member localMember = new Member(this.F, str, this.v, this.E, null);
      this.K.a(localMember);
      ViberApplication.getInstance().getEngine(false).getUnknownNumberReportController().handleSendContactSavedNotification(str, 0);
    }
    if ((this.H != null) && (this.I != null))
      this.b.a(this.H, this.I, ae.b());
    Long localLong = (Long)paramMap.get(str);
    this.M.post(new g(this, localLong));
  }

  public void b()
  {
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
      switch (paramInt1)
      {
      default:
      case 10:
      case 20:
      case 30:
      case 40:
      }
    while ((paramInt2 != 0) || (this.x == null))
    {
      String str;
      do
      {
        do
        {
          Uri localUri;
          do
          {
            do
            {
              return;
              startActivityForResult(com.viber.voip.messages.extras.image.b.c(this, this.x), 30);
              return;
            }
            while ((paramIntent == null) || (paramIntent.getData() == null));
            localUri = paramIntent.getData();
            if ((!"image".equals(at.g(localUri))) || (com.viber.voip.util.e.j.b(localUri)))
              break;
          }
          while ((!com.viber.voip.util.upload.o.b(true)) || (!com.viber.voip.util.upload.o.a(true)));
          startActivityForResult(com.viber.voip.messages.extras.image.b.c(this, localUri), 30);
          return;
          com.viber.voip.ui.dialogs.o.c().b(this);
          return;
        }
        while (paramIntent == null);
        if (this.x != null)
          at.d(getApplicationContext(), this.x);
        this.v = Uri.parse(paramIntent.getAction());
        if (!ViberApplication.isTablet(this))
        {
          DrawableCompat.setTint(this.s, this.p);
          DrawableCompat.setTint(this.r, this.p);
        }
        this.t.a(this.v, this.g, this.u, this.S);
        return;
        str = paramIntent.getStringExtra("authAccount");
      }
      while (this.h == null);
      int i1 = this.h.a(str);
      this.i.setSelection(i1);
      return;
    }
    at.d(this, this.x);
    this.x = null;
  }

  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == R.id.open_camera)
    {
      n();
      g();
    }
    do
    {
      return;
      if (i1 == R.id.open_gallery)
      {
        p();
        g();
        return;
      }
    }
    while ((i1 != R.id.edit) && (i1 != R.id.photo));
    f();
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    setContentView(R.layout.add_friend_preview_activity);
    setActionBarTitle(R.string.add_friend_title);
    this.K = ViberApplication.getInstance().getContactManager();
    this.J = com.viber.common.permission.c.a(this);
    android.support.v7.app.a locala = getSupportActionBar();
    if (locala != null)
      locala.b(true);
    this.t = com.viber.voip.util.e.e.a(this);
    this.u = com.viber.voip.util.e.f.f(dc.a(this, R.attr.contactDetailsDefaultPhoto));
    this.D = new PorterDuffColorFilter(ContextCompat.getColor(this, R.color.solid_55), PorterDuff.Mode.SRC_ATOP);
    Intent localIntent = getIntent();
    this.y = localIntent.getBooleanExtra("send_boomerang", false);
    this.B = localIntent.getBooleanExtra("invite_not_viber", false);
    String str1 = localIntent.getStringExtra("member_id");
    String str2 = localIntent.getStringExtra("phone_number");
    BaseAddFriendActivity.ContactDetails localContactDetails = (BaseAddFriendActivity.ContactDetails)localIntent.getParcelableExtra("contact_details");
    this.E = localIntent.getStringExtra("contact_name");
    this.H = localIntent.getStringExtra("analytics_add_type");
    this.I = localIntent.getStringExtra("entry_point");
    this.e = findViewById(R.id.done);
    this.f = findViewById(R.id.button_container);
    this.g = ((ImageView)findViewById(R.id.photo));
    this.i = ((SpinnerWithDescription)findViewById(R.id.account));
    this.j = ((TextViewWithDescription)findViewById(R.id.display_name));
    this.k = ((TextViewWithDescription)findViewById(R.id.phonetic_name));
    this.l = ((TextViewWithDescription)findViewById(R.id.phone_number));
    if (!ViberApplication.isTablet(this))
    {
      this.n = ((ImageView)findViewById(R.id.open_camera));
      this.m = ((ImageView)findViewById(R.id.open_gallery));
      this.q = dc.d(this, R.attr.addContactPhotoPickerColor);
      this.p = dc.d(this, R.attr.addContactEmptyPhotoPickerColor);
      this.r = df.a(ContextCompat.getDrawable(this, R.drawable.camera_icon_white), this.p, true);
      this.s = df.a(ContextCompat.getDrawable(this, R.drawable.gallery_icon_white), this.p, true);
      this.n.setImageDrawable(this.r);
      this.m.setImageDrawable(this.s);
      this.n.setOnClickListener(this);
      this.m.setOnClickListener(this);
      this.e.setOnClickListener(this.Q);
      if ((this.B) || (localContactDetails != null) || (paramBundle != null))
        break label576;
      a(str1, str2, true, this);
    }
    while (true)
    {
      if (!this.y)
      {
        if (paramBundle != null)
        {
          this.O = paramBundle.getLong("save_contact_start_time");
          this.C = paramBundle.getBoolean("saving_in_progress");
        }
        this.K.a(this);
        if (this.C)
        {
          long l1 = 60000L - (System.currentTimeMillis() - this.O);
          this.M.postDelayed(this.N, l1);
          a(str2);
        }
      }
      if (paramBundle != null)
        this.x = ((Uri)paramBundle.getParcelable("temp_uri"));
      return;
      e();
      this.o = ((ImageView)findViewById(R.id.edit));
      break;
      label576: a(str2, localContactDetails, paramBundle);
      if ((this.B) && (paramBundle == null))
        b(str2);
    }
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_edit_options, paramMenu);
    this.d = paramMenu.findItem(R.id.menu_done);
    a(this.A);
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.K.b(this);
  }

  public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.DC16)) && (-1 == paramInt))
      if ((paramm.d() instanceof String))
        aj.a(this, (String)paramm.d(), true);
    do
    {
      return;
      if (((paramm.a(DialogCode.D_ASK_PERMISSION)) || (paramm.a(DialogCode.D_EXPLAIN_PERMISSION))) && (-2 == paramInt))
      {
        finish();
        return;
      }
      if ((paramm.a(DialogCode.D_ASK_PERMISSION)) && (paramInt == -1))
      {
        startActivity(ViberActionRunner.q.b(this));
        return;
      }
      if ((paramm.a(DialogCode.D_EXPLAIN_PERMISSION)) && (paramInt == -1))
      {
        this.J.a(this, 75, n.k);
        return;
      }
    }
    while ((!paramm.a(DialogCode.D_PROGRESS_OVERLAY)) || (-1000 != paramInt));
    finish();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i1 = paramMenuItem.getItemId();
    if (i1 == 16908332)
    {
      onBackPressed();
      return true;
    }
    if (i1 == R.id.menu_done)
    {
      j();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putParcelable("photo_uri", this.v);
    paramBundle.putBoolean("can_change_photo", this.z);
    paramBundle.putBoolean("is_loaded_photo", this.A);
    paramBundle.putString("display_name", this.j.getText().toString());
    paramBundle.putString("phonetic_name", this.k.getText().toString());
    paramBundle.putString("member_id", this.F);
    paramBundle.putBoolean("is_viber", this.G);
    paramBundle.putBoolean("saving_in_progress", this.C);
    paramBundle.putLong("save_contact_start_time", this.O);
    if (this.x != null)
      paramBundle.putParcelable("temp_uri", this.x);
    super.onSaveInstanceState(paramBundle);
  }

  protected void onStart()
  {
    super.onStart();
    this.J.a(this.P);
  }

  protected void onStop()
  {
    this.J.b(this.P);
    super.onStop();
  }

  private static class a extends BaseAdapter
  {
    static final Pattern a = Pattern.compile("^.+@gmail.com$", 2);
    private final Account[] b;
    private final LayoutInflater c;

    public a(Account[] paramArrayOfAccount, LayoutInflater paramLayoutInflater)
    {
      this.b = paramArrayOfAccount;
      this.c = paramLayoutInflater;
    }

    int a()
    {
      int i = 0;
      int j = this.b.length;
      int k = -1;
      while (i < j)
      {
        String str = this.b[i].name;
        if (a.matcher(str).matches())
        {
          if (k == -1)
            k = i;
        }
        else
        {
          i++;
          continue;
        }
        k = -1;
      }
      return k;
    }

    int a(String paramString)
    {
      int i = 0;
      int j = this.b.length;
      while (i < j)
      {
        if (this.b[i].name.equals(paramString))
          return i;
        i++;
      }
      return -1;
    }

    public Account a(int paramInt)
    {
      return this.b[paramInt];
    }

    public int getCount()
    {
      return this.b.length;
    }

    public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null);
      for (TextView localTextView = (TextView)this.c.inflate(17367049, paramViewGroup, false); ; localTextView = (TextView)paramView)
      {
        localTextView.setText(a(paramInt).name);
        return localTextView;
      }
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null);
      for (TextView localTextView = (TextView)this.c.inflate(17367048, paramViewGroup, false); ; localTextView = (TextView)paramView)
      {
        localTextView.setText(a(paramInt).name);
        return localTextView;
      }
    }
  }

  private static class b extends com.viber.voip.d.b<AddFriendPreviewActivity>
  {
    private b(AddFriendPreviewActivity paramAddFriendPreviewActivity)
    {
      super();
    }

    public void a(AddFriendPreviewActivity paramAddFriendPreviewActivity)
    {
      AddFriendPreviewActivity.a(paramAddFriendPreviewActivity);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.AddFriendPreviewActivity
 * JD-Core Version:    0.6.2
 */
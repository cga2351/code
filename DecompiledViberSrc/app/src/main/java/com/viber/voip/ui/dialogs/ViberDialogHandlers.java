package com.viber.voip.ui.dialogs;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.viber.common.dialogs.DialogCodeProvider;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.dialer.DialerController;
import com.viber.jni.im2.CMessageReceivedMsg;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.jni.im2.Im2Receiver;
import com.viber.jni.im2.Location;
import com.viber.jni.secure.TrustPeerController;
import com.viber.jni.settings.SettingsController;
import com.viber.svg.jni.SvgImageView;
import com.viber.svg.jni.clock.CyclicClock;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.integer;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.StoryConstants.g.a;
import com.viber.voip.analytics.story.n;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.av.e;
import com.viber.voip.banner.RemoteSplashActivity;
import com.viber.voip.block.g.a;
import com.viber.voip.contacts.model.ExtraActionAfterContactIsAdded;
import com.viber.voip.contacts.ui.ContactDetailsFragment;
import com.viber.voip.contacts.ui.s.a;
import com.viber.voip.flatbuffers.model.msginfo.GroupReferralInfo;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.invitelinks.CommunityFollowerData;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.a.c.b;
import com.viber.voip.messages.a.f.a;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ai.e;
import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage;
import com.viber.voip.messages.controller.manager.BotFavoriteLinksCommunicator.SaveLinkActionMessage.a;
import com.viber.voip.messages.controller.manager.au;
import com.viber.voip.messages.controller.publicaccount.BotReplyRequest;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationData;
import com.viber.voip.messages.conversation.ui.az.a;
import com.viber.voip.messages.k;
import com.viber.voip.messages.o.a;
import com.viber.voip.messages.orm.entity.json.action.MessageOpenUrlAction;
import com.viber.voip.messages.orm.entity.json.action.OpenUrlAction;
import com.viber.voip.messages.ui.MessageComposerView;
import com.viber.voip.messages.ui.MessagesFragmentModeManager.b;
import com.viber.voip.messages.ui.MessagesFragmentModeManager.c;
import com.viber.voip.messages.ui.PinDialogLayout;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.pixie.PixieControllerNativeImpl;
import com.viber.voip.pixie.ProxySettings;
import com.viber.voip.pixie.ProxySettingsHolder;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.settings.d.aj;
import com.viber.voip.settings.d.ap;
import com.viber.voip.settings.d.bf;
import com.viber.voip.settings.d.bl;
import com.viber.voip.settings.d.l;
import com.viber.voip.settings.d.r;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.p;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.user.UserData;
import com.viber.voip.user.UserDataEditHelper.Listener;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.ParcelableInt;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.ae;
import com.viber.voip.util.ViberActionRunner.af;
import com.viber.voip.util.ViberActionRunner.an;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.ViberActionRunner.ay;
import com.viber.voip.util.ViberActionRunner.bf;
import com.viber.voip.util.ViberActionRunner.bk;
import com.viber.voip.util.ViberActionRunner.bl;
import com.viber.voip.util.ViberActionRunner.bt;
import com.viber.voip.util.ViberActionRunner.h;
import com.viber.voip.util.ViberActionRunner.o;
import com.viber.voip.util.ViberActionRunner.q;
import com.viber.voip.util.by;
import com.viber.voip.util.cg;
import com.viber.voip.util.cj;
import com.viber.voip.util.dc;
import com.viber.voip.util.df;
import com.viber.voip.util.dj;
import com.viber.voip.util.dz;
import com.viber.voip.util.e.f;
import com.viber.voip.util.u;
import com.viber.voip.viberout.ui.TermsAndConditionsActivity;
import com.viber.voip.viberout.ui.TermsAndConditionsActivity.a;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

public final class ViberDialogHandlers
{
  private static final Logger a = ViberEnv.getLogger();

  private static Resources b()
  {
    return ViberApplication.getLocalizedResources();
  }

  private static void b(EditText paramEditText)
  {
    try
    {
      Field localField = TextView.class.getDeclaredField("mCursorDrawableRes");
      localField.setAccessible(true);
      localField.set(paramEditText, Integer.valueOf(0));
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private static void b(com.viber.common.dialogs.m paramm, EditText paramEditText)
  {
    dj.a(paramEditText, ContextCompat.getDrawable(paramm.getActivity(), R.drawable.abc_textfield_default_mtrl_alpha));
  }

  public static class D1400b extends m.a
  {
    private final boolean a;
    private final boolean b;
    private final Member c;

    public D1400b(boolean paramBoolean1, boolean paramBoolean2, Member paramMember)
    {
      this.a = paramBoolean1;
      this.b = paramBoolean2;
      this.c = paramMember;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      MessageOpenUrlAction localMessageOpenUrlAction;
      if (paramm.a(DialogCode.D1400b))
      {
        localMessageOpenUrlAction = (MessageOpenUrlAction)paramm.d();
        if (paramm.getContext() == null)
          break label61;
      }
      label61: for (Object localObject = paramm.getContext(); ; localObject = ViberApplication.getApplication())
        switch (paramInt)
        {
        default:
          return;
        case -1:
        case -3:
        case -2:
        }
      boolean bool1 = this.b;
      String str1 = this.c.getPhoneNumber();
      String str2 = this.c.getViberName();
      Uri localUri = this.c.getPhotoUri();
      if (!cg.c(this.c.getPhoneNumber()));
      for (boolean bool2 = true; ; bool2 = false)
      {
        ViberActionRunner.o.a((Context)localObject, bool1, str1, str2, localUri, bool2, this.c.getId(), new OpenUrlAfterContactIsAddedAction(localMessageOpenUrlAction, null));
        return;
      }
      new OpenUrlAfterContactIsAddedAction(localMessageOpenUrlAction, null).openUrl((Context)localObject);
      return;
      ViberApplication.getInstance().getMessagesManager().c().a(Collections.singleton(Long.valueOf(localMessageOpenUrlAction.getConversationId())), localMessageOpenUrlAction.getConversationType());
      com.viber.voip.av.a(av.e.a).postDelayed(new x(this), 500L);
    }

    public void onDialogShow(com.viber.common.dialogs.m paramm)
    {
      if (this.a)
      {
        Window localWindow = paramm.getDialog().getWindow();
        if (localWindow != null)
        {
          localWindow.setBackgroundDrawable(new ColorDrawable(0));
          localWindow.setLayout(-1, -2);
        }
      }
    }

    public void onPrepareDialogView(com.viber.common.dialogs.m paramm, View paramView, int paramInt)
    {
      paramView.findViewById(com.viber.voip.R.id.btn_close).setOnClickListener(new w(paramm));
    }

    private static class OpenUrlAfterContactIsAddedAction
      implements ExtraActionAfterContactIsAdded
    {
      public static final Parcelable.Creator<OpenUrlAfterContactIsAddedAction> CREATOR = new Parcelable.Creator()
      {
        public ViberDialogHandlers.D1400b.OpenUrlAfterContactIsAddedAction a(Parcel paramAnonymousParcel)
        {
          return new ViberDialogHandlers.D1400b.OpenUrlAfterContactIsAddedAction(paramAnonymousParcel);
        }

        public ViberDialogHandlers.D1400b.OpenUrlAfterContactIsAddedAction[] a(int paramAnonymousInt)
        {
          return new ViberDialogHandlers.D1400b.OpenUrlAfterContactIsAddedAction[paramAnonymousInt];
        }
      };
      private final MessageOpenUrlAction mOpenUrlAction;

      protected OpenUrlAfterContactIsAddedAction(Parcel paramParcel)
      {
        this.mOpenUrlAction = ((MessageOpenUrlAction)paramParcel.readParcelable(MessageOpenUrlAction.class.getClassLoader()));
      }

      private OpenUrlAfterContactIsAddedAction(MessageOpenUrlAction paramMessageOpenUrlAction)
      {
        this.mOpenUrlAction = paramMessageOpenUrlAction;
      }

      public int describeContents()
      {
        return 0;
      }

      public void onContactAdded(Activity paramActivity)
      {
        if (!paramActivity.isFinishing())
          paramActivity.finish();
        openUrl(paramActivity);
      }

      public void openUrl(Context paramContext)
      {
        ViberApplication.getInstance().getMessagesManager().c().a(this.mOpenUrlAction.getConversationId(), false);
        ViberActionRunner.ae.a(paramContext, false, this.mOpenUrlAction);
      }

      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeParcelable(this.mOpenUrlAction, paramInt);
      }
    }
  }

  public static class DHandlePermissions extends m.a
    implements Parcelable
  {
    public static final Parcelable.Creator<DHandlePermissions> CREATOR = new Parcelable.Creator()
    {
      public ViberDialogHandlers.DHandlePermissions a(Parcel paramAnonymousParcel)
      {
        return new ViberDialogHandlers.DHandlePermissions(paramAnonymousParcel);
      }

      public ViberDialogHandlers.DHandlePermissions[] a(int paramAnonymousInt)
      {
        return new ViberDialogHandlers.DHandlePermissions[paramAnonymousInt];
      }
    };
    private static final String KEY_EXTRA = "extra";
    private Object mExtra;
    private String[] mPermissions;
    private int mRequestCode;

    public DHandlePermissions(int paramInt, String[] paramArrayOfString)
    {
      this(paramInt, paramArrayOfString, null);
    }

    public DHandlePermissions(int paramInt, String[] paramArrayOfString, Object paramObject)
    {
      this.mRequestCode = paramInt;
      this.mPermissions = paramArrayOfString;
      this.mExtra = paramObject;
    }

    protected DHandlePermissions(Parcel paramParcel)
    {
      this.mRequestCode = paramParcel.readInt();
      this.mPermissions = paramParcel.createStringArray();
      Bundle localBundle = paramParcel.readBundle(Bundle.class.getClassLoader());
      if (localBundle != null)
      {
        this.mExtra = localBundle.get("extra");
        return;
      }
      this.mExtra = null;
    }

    private static Bundle packageExtra(Object paramObject)
    {
      Bundle localBundle;
      if (paramObject == null)
        localBundle = null;
      do
      {
        return localBundle;
        localBundle = new Bundle();
        if ((paramObject instanceof Bundle))
        {
          localBundle.putBundle("extra", (Bundle)paramObject);
          return localBundle;
        }
        if ((paramObject instanceof Parcelable))
        {
          localBundle.putParcelable("extra", (Parcelable)paramObject);
          return localBundle;
        }
      }
      while (!(paramObject instanceof Serializable));
      localBundle.putSerializable("extra", (Serializable)paramObject);
      return localBundle;
    }

    public int describeContents()
    {
      return 0;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      com.viber.common.permission.c localc = com.viber.common.permission.c.a(paramm.getContext());
      localc.a(this.mRequestCode, paramm.c().code(), paramInt);
      if ((paramm.a(DialogCode.D_EXPLAIN_PERMISSION)) && (paramInt == -1))
        localc.a(paramm.getActivity(), this.mRequestCode, this.mPermissions, this.mExtra);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mRequestCode);
      paramParcel.writeStringArray(this.mPermissions);
      paramParcel.writeBundle(packageExtra(this.mExtra));
    }
  }

  static final class a extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D_APPROVE_SYNC_HISTORY_TO_DESKTOP))
        if (-1 != paramInt)
          break label85;
      label85: for (boolean bool = true; ; bool = false)
      {
        final com.viber.voip.messages.controller.manager.at localat = ViberApplication.getInstance().getMessagesManager().v().a();
        com.viber.voip.analytics.story.f.d locald = com.viber.voip.analytics.g.a().c().b();
        localat.a(bool);
        if (bool)
        {
          av.e.a.a().postDelayed(new Runnable()
          {
            public void run()
            {
              localat.a(4);
            }
          }
          , 300L);
          locald.c();
        }
        return;
      }
    }
  }

  public static class aa extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D305c));
      switch (paramInt)
      {
      default:
        return;
      case -1:
      }
      Intent localIntent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
      paramm.getActivity().startActivity(localIntent);
    }
  }

  public static class ab extends m.a
  {
    public long a;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      CheckBox localCheckBox = (CheckBox)paramm.getDialog().findViewById(com.viber.voip.R.id.checkboxNeverShow);
      k localk = ViberApplication.getInstance().getMessagesManager();
      if (paramm.a(DialogCode.D309));
      switch (paramInt)
      {
      default:
        return;
      case -1:
        if ((localCheckBox != null) && (localCheckBox.isChecked()))
          by.a();
        localk.f().b(this.a);
        return;
      case -2:
      }
      localk.c().d(this.a);
    }
  }

  public static class ac extends m.a
  {
    private void a(int paramInt, String paramString)
    {
      if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
        ViberApplication.getInstance().getEngine(true).getDialerController().handleDialogReply(paramInt, paramString);
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      String str2;
      if (paramm.a(DialogCode.D310))
      {
        Bundle localBundle = (Bundle)paramm.d();
        String str1 = localBundle.getString("context_member_id");
        str2 = localBundle.getString("context_number");
        if (-1 != paramInt)
          break label77;
        localIntent = com.viber.voip.messages.m.a(str1, str2, null, false, false, false, false);
        localIntent.setFlags(268435456);
        a(1, str2);
        ViberApplication.getApplication().startActivity(localIntent);
      }
      label77: 
      while (-2 != paramInt)
      {
        Intent localIntent;
        return;
      }
      a(2, str2);
    }
  }

  public static class ad extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D316c)) && (paramInt == -2))
      {
        Intent localIntent = new Intent("com.viber.voip.action.SETTINGS");
        localIntent.putExtra("selected_item", R.string.pref_category_calls_and_messages_key);
        paramm.getActivity().startActivity(localIntent);
      }
    }
  }

  public static class ae extends ViberDialogHandlers.cp
  {
    public ae()
    {
      super();
    }
  }

  public static class af extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D326)) && (paramInt == -1))
        paramm.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramm.getString(R.string.url_viber_desktop_webpage))));
    }
  }

  public static final class ag extends m.a
  {
    private final boolean a;
    private final String b;

    public ag(boolean paramBoolean, String paramString)
    {
      this.a = paramBoolean;
      this.b = paramString;
    }

    private void a(Context paramContext, String paramString)
    {
      Intent localIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramString));
      if (ViberActionRunner.a(localIntent, paramContext))
        paramContext.startActivity(localIntent);
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D335c)) && (paramInt == -1))
      {
        ContactDetailsFragment.a(this.a, 2, 0L);
        a(paramm.getActivity(), this.b);
      }
    }
  }

  public static class ah extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D339))
        ViberApplication.exit(paramm.getActivity(), true);
    }
  }

  public static class ai extends ViberDialogHandlers.e
  {
    public Map<Long, MessagesFragmentModeManager.b> b;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D343))
        switch (paramInt)
        {
        case -2:
        default:
        case -1:
        case -3:
        }
      while (true)
      {
        a(paramm, paramInt, this.b);
        return;
        if (this.a != null)
        {
          this.a.a(this.b);
          continue;
          if (this.a != null)
            this.a.b(this.b);
        }
      }
    }
  }

  public static class aj extends ViberDialogHandlers.e
  {
    public Map<Long, MessagesFragmentModeManager.b> b;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D343b))
        switch (paramInt)
        {
        case -2:
        default:
        case -1:
        case -3:
        }
      while (true)
      {
        a(paramm, paramInt, this.b);
        return;
        if (this.a != null)
        {
          this.a.a(this.b);
          continue;
          if (this.a != null)
            this.a.b(this.b);
        }
      }
    }
  }

  public static class ak extends ViberDialogHandlers.e
  {
    public Map<Long, MessagesFragmentModeManager.b> b;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D343c)) || (paramm.a(DialogCode.D343d)))
      {
        if ((paramInt == -1) && (this.a != null))
          this.a.a(this.b);
        a(paramm, paramInt, this.b);
      }
    }
  }

  public static class al extends ViberDialogHandlers.e
  {
    public Map<Long, MessagesFragmentModeManager.b> b;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D343e)) && (paramInt == -1) && (this.a != null))
        this.a.a(this.b);
    }
  }

  public static class am extends ViberDialogHandlers.e
  {
    public long b;
    public int c;
    public final String d;
    private final Integer e;

    public am(String paramString, Integer paramInteger)
    {
      this.d = paramString;
      this.e = paramInteger;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D343f));
      switch (paramInt)
      {
      default:
        return;
      case -1:
        if (this.a != null)
          this.a.a(this.b, this.c, false);
        a(a(), "Snooze", DialogCode.D343f.code(), this.d, this.e);
        return;
      case -3:
        if (this.a != null)
          this.a.a(this.b, this.c);
        a(a(), "Leave and Delete", DialogCode.D343f.code(), this.d, this.e);
        return;
      case -1000:
      case -2:
      }
      a(a(), "Cancel", DialogCode.D343f.code(), this.d, this.e);
    }
  }

  public static class an extends m.a
  {
    public String a;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D346e)) && (paramInt == -1))
        ViberApplication.getInstance().getEngine(true).getDialerController().handleDialogReply(2, this.a);
    }
  }

  public static class ao extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D374));
      switch (paramInt)
      {
      default:
        return;
      case -1:
      }
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.viber.voip"));
      paramm.getActivity().startActivity(localIntent);
    }
  }

  public static class ap extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D375))
        paramm.dismiss();
    }
  }

  public static class aq extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D381)) && (paramInt == -1))
        ViberApplication.exit(null, true);
    }
  }

  public static class ar extends ViberDialogHandlers.bc
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D385)) && (paramInt == -1))
        a(paramm);
    }
  }

  public static class as extends m.a
  {
    private final String a;

    public as(String paramString)
    {
      this.a = paramString;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D3903)) && (paramInt == -1))
      {
        com.viber.voip.analytics.g.a().c().k().f(this.a);
        ViberApplication.getInstance().getMessagesManager().c().a(y.a);
      }
    }
  }

  public static class at extends m.a
  {
    private void b(int paramInt)
    {
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D3905)) && (paramInt == -1))
      {
        ViberApplication.getInstance().getMessagesManager().c().a(new z(this));
        d.l.e.a(true);
      }
    }
  }

  public static class au extends m.a
  {
    private final String a;

    public au(String paramString)
    {
      this.a = paramString;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D3912)) && (paramInt == -1))
        ViberApplication.getInstance().getMessagesManager().c().a(this.a);
    }
  }

  public static class av extends m.a
  {
    private final String a;

    public av(String paramString)
    {
      this.a = paramString;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D3913)) && (paramInt == -1))
        ViberApplication.getInstance().getMessagesManager().c().a(this.a);
    }
  }

  public static class aw extends m.a
  {
    private final long a;
    private final int b;

    public aw(long paramLong, int paramInt)
    {
      this.a = paramLong;
      this.b = paramInt;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D3914)) && (paramInt == -1))
        ViberApplication.getInstance().getMessagesManager().c().a(Collections.singleton(Long.valueOf(this.a)), this.b);
    }
  }

  public static class ax extends m.a
  {
    public boolean a;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      int i = 1;
      SettingsController localSettingsController;
      if (((paramm.a(DialogCode.D411)) || (paramm.a(DialogCode.D411b))) && (paramInt == -1))
      {
        d.bf.g.a(System.currentTimeMillis());
        com.viber.common.b.b localb = d.bf.j;
        if (this.a)
          break label91;
        int k = i;
        localb.a(k);
        localSettingsController = ViberApplication.getInstance().getEngine(i).getSettingsController();
        if (this.a)
          break label97;
      }
      while (true)
      {
        localSettingsController.handleChangeLastOnlineSettings(i);
        paramm.dismiss();
        return;
        label91: int m = 0;
        break;
        label97: int j = 0;
      }
    }
  }

  public static class ay extends m.a
  {
    public g.a a;
    public Set<Member> b;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D424))
      {
        if (paramInt != -1)
          break label56;
        ViberApplication.getInstance().getContactManager().f().a(this.b);
        if (this.a != null)
          this.a.a(this.b);
      }
      label56: 
      while (this.a == null)
        return;
      this.a.a();
    }
  }

  public static class az extends ViberDialogHandlers.ay
  {
    public boolean c;
    public boolean d;
    public boolean e;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      super.onDialogAction(paramm, paramInt);
      if ((paramm.a(DialogCode.D424)) && (paramInt == -1) && (this.b != null))
      {
        CallHandler localCallHandler = ViberApplication.getInstance().getEngine(true).getCallHandler();
        localCallHandler.setNextCallIsFromSecretConversation(this.e);
        localCallHandler.handleDialWithoutCheck(((Member)this.b.iterator().next()).getPhoneNumber(), this.c, this.d);
      }
    }
  }

  public static abstract class b extends m.a
  {
    protected final String a;

    public b(String paramString)
    {
      this.a = paramString;
    }
  }

  public static class ba extends m.a
  {
    public Runnable a;
    public int b;
    public boolean c;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D424)) && (paramInt == -1))
      {
        if (this.c)
          com.viber.voip.block.b.a().b(this.b);
        if (!d.r.B.d())
          d.r.B.e();
        if (this.a != null)
          this.a.run();
      }
    }
  }

  public static class bb extends ViberDialogHandlers.cs
  {
    public bb(String paramString1, String paramString2)
    {
      super(paramString2);
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D435))
        super.onDialogAction(paramm, paramInt);
    }
  }

  public static class bc extends m.a
  {
    private static final Logger b = ViberEnv.getLogger();
    public String a;

    protected void a(com.viber.common.dialogs.m paramm)
    {
      ViberActionRunner.af.a(paramm.getActivity(), Collections.singletonList(this.a));
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D507c)) && (paramInt == -1))
        a(paramm);
    }
  }

  public static class bd extends ViberDialogHandlers.cm
  {
    private long c;
    private boolean d;
    private boolean e;

    public bd(String paramString)
    {
      super();
    }

    public bd(String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
      this.c = paramLong;
      this.d = paramBoolean1;
      this.e = paramBoolean2;
    }

    protected boolean a(CharSequence paramCharSequence)
    {
      return (super.a(paramCharSequence)) && (!TextUtils.isEmpty(paramCharSequence.toString().trim()));
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      EditText localEditText;
      PublicAccount localPublicAccount;
      if (paramm.a(DialogCode.D509))
      {
        localEditText = (EditText)paramm.getDialog().findViewById(com.viber.voip.R.id.user_edit_name);
        localPublicAccount = (PublicAccount)paramm.d();
        switch (paramInt)
        {
        default:
        case -1:
        }
      }
      label250: 
      while (true)
      {
        dj.c(localEditText);
        super.onDialogAction(paramm, paramInt);
        return;
        String str = localEditText.getText().toString().trim();
        if (localPublicAccount == null)
          com.viber.voip.analytics.g.a().c().c().a(com.viber.voip.util.ae.b(), 0, this.c, str, this.e, "Name", null);
        if (!this.a.equals(str))
        {
          int i = ViberApplication.getInstance().getEngine(true).getPhoneController().generateSequence();
          if (localPublicAccount == null)
            ViberApplication.getInstance().getMessagesManager().d().a(i, this.c, str);
          while (true)
          {
            if ((!ViberApplication.isTablet(paramm.getActivity())) || (!(paramm.getActivity() instanceof AppCompatActivity)) || (((AppCompatActivity)paramm.getActivity()).getSupportActionBar() == null))
              break label250;
            ((AppCompatActivity)paramm.getActivity()).getSupportActionBar().a(str);
            break;
            localPublicAccount.setName(str);
            ViberApplication.getInstance().getMessagesManager().d().a(i, 1, localPublicAccount);
          }
        }
      }
    }
  }

  public static class be extends ViberDialogHandlers.bd
  {
    private long c;

    public be(long paramLong, String paramString)
    {
      super();
      this.c = paramLong;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D509))
      {
        EditText localEditText = (EditText)paramm.getDialog().findViewById(com.viber.voip.R.id.user_edit_name);
        if (paramInt == -1)
        {
          String str = localEditText.getText().toString().trim();
          if (!this.a.equals(str))
            ViberApplication.getInstance().getMessagesManager().d().a(this.c, str);
        }
        dj.c(localEditText);
      }
      super.onDialogAction(paramm, paramInt);
    }
  }

  public static class bf extends ViberDialogHandlers.cq
  {
    public bf(boolean paramBoolean)
    {
      super();
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D604))
        super.onDialogAction(paramm, paramInt);
    }
  }

  public static class bg extends ViberDialogHandlers.cq
  {
    public bg(boolean paramBoolean)
    {
      super();
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D605))
        super.onDialogAction(paramm, paramInt);
    }
  }

  public static class bh extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D615))
      {
        com.viber.voip.banner.i locali = com.viber.voip.banner.i.a();
        com.viber.voip.banner.d.j[] arrayOfj = new com.viber.voip.banner.d.j[1];
        arrayOfj[0] = com.viber.voip.banner.d.j.h;
        locali.a(arrayOfj);
      }
    }
  }

  public static class bi extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D618a))
      {
        com.viber.voip.banner.i locali = com.viber.voip.banner.i.a();
        com.viber.voip.banner.d.j[] arrayOfj = new com.viber.voip.banner.d.j[1];
        arrayOfj[0] = com.viber.voip.banner.d.j.h;
        locali.a(arrayOfj);
      }
    }
  }

  public static class bj extends m.a
  {
    public String a;

    public void onPrepareDialogView(com.viber.common.dialogs.m paramm, View paramView, int paramInt)
    {
      if (paramInt == R.layout.dialog_content_inapp_error)
      {
        TextView localTextView = (TextView)paramView.findViewById(com.viber.voip.R.id.learn_more_text);
        localTextView.setText(Html.fromHtml(this.a));
        localTextView.setClickable(true);
        localTextView.setMovementMethod(LinkMovementMethod.getInstance());
      }
    }
  }

  public static class bk extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D624));
      switch (paramInt)
      {
      default:
        return;
      case -2:
        String str = com.viber.common.dialogs.y.a().getString(R.string.vo_block_user_learn_more);
        dz.a(com.viber.common.dialogs.y.a(), GenericWebViewActivity.b(com.viber.common.dialogs.y.a(), str, str));
        com.viber.voip.analytics.g.a().c().e().c("Learn More");
        return;
      case -1:
      }
      com.viber.voip.analytics.g.a().c().e().c("Ok");
    }
  }

  public static class bl extends m.a
  {
    public String a;
    public String b;
    public String c;

    private void a(int paramInt, String paramString)
    {
      if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
        ViberApplication.getInstance().getEngine(true).getDialerController().handleDialogReply(paramInt, paramString);
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D701a));
      switch (paramInt)
      {
      default:
        return;
      case -1:
        Intent localIntent = com.viber.voip.messages.m.a(this.a, this.b, this.c, false, false, false, false);
        a(1, this.b);
        paramm.startActivity(localIntent);
        return;
      case -2:
      }
      a(2, this.b);
    }
  }

  public static class bm extends m.a
  {
    public DialogInterface.OnClickListener a;
    public LinkedList<String> b;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (((paramm.a(DialogCode.D711)) || (paramm.a(DialogCode.D711b))) && (paramInt == -1))
      {
        if (this.b.isEmpty())
          break label137;
        localcn = new ViberDialogHandlers.cn();
        localcn.a = this.a;
        if (this.b.size() <= 1)
          break label121;
        str1 = (String)this.b.removeLast();
        str2 = TextUtils.join(", ", this.b);
        l.c().b(R.string.dialog_513_message_many, new Object[] { str2, str1 }).a(localcn).a(paramm.getActivity());
      }
      label121: 
      while (this.a == null)
      {
        ViberDialogHandlers.cn localcn;
        String str1;
        String str2;
        return;
        l.c().a(localcn).a(paramm.getActivity());
        return;
      }
      label137: this.a.onClick(paramm.getDialog(), -1);
    }
  }

  public static class bn extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D725)) && (-1 == paramInt))
      {
        ViberApplication.getInstance().getUpdateViberManager().i();
        ViberApplication.getInstance().getUpdateViberManager().a(paramm.getActivity());
      }
    }
  }

  public static class bo extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D726))
      {
        if (-1 != paramInt)
          break label38;
        ViberApplication.getInstance().getUpdateViberManager().i();
        ViberApplication.getInstance().getUpdateViberManager().a(paramm.getActivity());
      }
      label38: 
      while (-2 != paramInt)
        return;
      ViberApplication.getInstance().getUpdateViberManager().i();
    }
  }

  public static class bp extends ViberDialogHandlers.c
  {
    public bp(Queue<e.a> paramQueue)
    {
      super(ViberDialogHandlers.a().getString(R.string.file_message_upgrade_link));
    }

    protected void a()
    {
      e.a(this.b).d();
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D728))
        super.onDialogAction(paramm, paramInt);
    }
  }

  public static class bq extends m.a
  {
    private int a;

    public bq(int paramInt)
    {
      this.a = paramInt;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      com.viber.common.permission.c.a(paramm.getContext()).a(this.a, paramm.c().code(), paramInt);
      if ((paramm.a(DialogCode.D_ASK_PERMISSION)) && (paramInt == -1))
        paramm.getActivity().startActivity(ViberActionRunner.q.b(paramm.getActivity()));
    }
  }

  public static class br extends m.a
  {
    public az.a a;
    public LinkedList<Long> b;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D1028)) && (-1 == paramInt) && (this.a != null))
        this.a.a(this.b, false);
    }
  }

  public static class bs extends m.a
  {
    public long a;
    public com.viber.voip.messages.conversation.ui.j b;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.DC13)) && (-1 == paramInt) && (cj.a(true)))
        this.b.a(Collections.singletonList(Long.valueOf(this.a)), false);
    }
  }

  public static class bt extends m.a
  {
    private UserDataEditHelper.Listener a;

    public bt(UserDataEditHelper.Listener paramListener)
    {
      this.a = paramListener;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.DC22)) && (-1 == paramInt) && (this.a != null))
        this.a.onPhotoRemoved();
    }
  }

  public static class bu extends ViberDialogHandlers.cm
  {
    private static final Logger c = ViberEnv.getLogger();

    public bu()
    {
      this(null);
    }

    public bu(String paramString)
    {
      super();
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      EditText localEditText;
      if (paramm.a(DialogCode.DC25))
      {
        localEditText = (EditText)paramm.getDialog().findViewById(com.viber.voip.R.id.user_edit_name);
        switch (paramInt)
        {
        default:
        case -1:
        }
      }
      while (true)
      {
        dj.c(localEditText);
        super.onDialogAction(paramm, paramInt);
        return;
        if (!TextUtils.isEmpty(localEditText.getText()))
        {
          int i = Integer.parseInt(localEditText.getText().toString());
          com.viber.voip.stickers.i locali = com.viber.voip.stickers.i.a();
          if ((locali.k(i)) || (locali.j(i)) || (locali.i(i)))
          {
            Toast.makeText(paramm.getActivity(), "You already have this package ot it is being downloaded now", 0).show();
            return;
          }
          ad.b().a(com.viber.voip.R.id.message, "Checking the server").b(false).a(this).a(paramm.getActivity());
        }
      }
    }

    public void onDialogShow(final com.viber.common.dialogs.m paramm)
    {
      if (paramm.a(DialogCode.D_PROGRESS))
        com.viber.voip.av.a(av.e.g).post(new Runnable()
        {
          public void run()
          {
            try
            {
              int i = Integer.parseInt(ViberDialogHandlers.bu.this.b);
              String str;
              if (com.viber.voip.stickers.c.g.d(i, "SVG"))
              {
                str = "SVG";
                if (!com.viber.voip.stickers.c.g.d(i, str))
                  break label76;
                com.viber.voip.stickers.i.a().a(i, com.viber.voip.stickers.i.a.g);
              }
              while (true)
              {
                return;
                str = String.valueOf(p.a);
                break;
                label76: ViberApplication.getInstance().showToast("Package with this id doesn't exist");
              }
            }
            catch (Exception localException)
            {
            }
            finally
            {
              com.viber.common.dialogs.z.a(paramm.getActivity().getSupportFragmentManager(), DialogCode.D_PROGRESS);
            }
          }
        });
      super.onDialogShow(paramm);
    }

    public void onPrepareDialogView(com.viber.common.dialogs.m paramm, View paramView, int paramInt)
    {
      super.onPrepareDialogView(paramm, paramView, paramInt);
      if (paramInt == R.layout.dialog_content_edit_text)
      {
        EditText localEditText = (EditText)paramView.findViewById(com.viber.voip.R.id.user_edit_name);
        localEditText.setHint("Package id");
        localEditText.setInputType(2);
        InputFilter[] arrayOfInputFilter = new InputFilter[1];
        arrayOfInputFilter[0] = new InputFilter.LengthFilter(8);
        localEditText.setFilters(arrayOfInputFilter);
      }
    }
  }

  public static class bv extends ViberDialogHandlers.cm
  {
    private static final Logger c = ViberEnv.getLogger();
    private MessageComposerView d;

    public bv(String paramString, MessageComposerView paramMessageComposerView)
    {
      super();
      this.d = paramMessageComposerView;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      EditText localEditText;
      if (paramm.a(DialogCode.DC26))
      {
        localEditText = (EditText)paramm.getDialog().findViewById(com.viber.voip.R.id.user_edit_name);
        switch (paramInt)
        {
        default:
        case -1:
        }
      }
      while (true)
      {
        dj.c(localEditText);
        super.onDialogAction(paramm, paramInt);
        return;
        ad.b().c("Send custom sticker").b(false).a(false).a(com.viber.voip.R.id.message, "Checking the server").a(this).a(paramm.getActivity());
      }
    }

    public void onDialogShow(final com.viber.common.dialogs.m paramm)
    {
      if (paramm.a(DialogCode.D_PROGRESS))
        com.viber.voip.av.a(av.e.d).postAtFrontOfQueue(new Runnable()
        {
          public void run()
          {
            try
            {
              int i = Integer.parseInt(ViberDialogHandlers.bv.this.b);
              if (com.viber.voip.stickers.c.g.i(i))
              {
                Sticker localSticker = com.viber.voip.stickers.i.a().u(i);
                com.viber.voip.av.a(av.e.a).postAtFrontOfQueue(new aa(this, localSticker));
              }
              while (true)
              {
                return;
                Toast.makeText(paramm.getActivity(), "Sticker with id " + i + " doesn't exist", 0).show();
              }
            }
            catch (Exception localException)
            {
              FragmentActivity localFragmentActivity = paramm.getActivity();
              StringBuilder localStringBuilder = new StringBuilder().append("Error: ");
              if (TextUtils.isEmpty(localException.getMessage()));
              String str;
              for (Object localObject2 = " Unknown error, try again"; ; localObject2 = str)
              {
                Toast.makeText(localFragmentActivity, (String)localObject2, 1).show();
                return;
                str = localException.getMessage();
              }
            }
            finally
            {
              com.viber.common.dialogs.z.a(paramm.getActivity().getSupportFragmentManager(), DialogCode.D_PROGRESS);
            }
          }
        });
      super.onDialogShow(paramm);
    }

    public void onPrepareDialogView(com.viber.common.dialogs.m paramm, View paramView, int paramInt)
    {
      super.onPrepareDialogView(paramm, paramView, paramInt);
      EditText localEditText = (EditText)paramView.findViewById(com.viber.voip.R.id.user_edit_name);
      if (localEditText != null)
      {
        localEditText.setHint("Sticker id");
        localEditText.setInputType(2);
        InputFilter[] arrayOfInputFilter = new InputFilter[1];
        arrayOfInputFilter[0] = new InputFilter.LengthFilter(8);
        localEditText.setFilters(arrayOfInputFilter);
      }
    }
  }

  public static class bw extends ViberDialogHandlers.cm
  {
    private UserDataEditHelper.Listener c;
    private boolean d;

    public bw(String paramString, UserDataEditHelper.Listener paramListener, boolean paramBoolean)
    {
      super();
      this.c = paramListener;
      this.d = paramBoolean;
    }

    protected boolean a(CharSequence paramCharSequence)
    {
      return (super.a(paramCharSequence)) && ((this.d) || (!TextUtils.isEmpty(paramCharSequence.toString().trim())));
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.DC27)) && (paramInt == -1))
      {
        String str = ((EditText)paramm.getDialog().findViewById(com.viber.voip.R.id.user_edit_name)).getText().toString().trim();
        if (this.c != null)
          this.c.onNameEdited(str);
      }
      super.onDialogAction(paramm, paramInt);
    }
  }

  public static class bx extends m.a
  {
    public long a;
    public com.viber.voip.messages.conversation.ui.j b;
    public boolean c;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.DC28)) && (-1 == paramInt) && (cj.a(true)))
      {
        if (com.viber.voip.analytics.a.j.a(this.b.g()))
          com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.d(this.c));
        this.b.a(Collections.singletonList(Long.valueOf(this.a)), true);
      }
    }
  }

  public static class by extends m.a
  {
    public az.a a;
    public LinkedList<Long> b;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.DC29)) && (-1 == paramInt) && (this.a != null))
        this.a.a(this.b, false);
    }
  }

  public static class bz extends ViberDialogHandlers.cm
  {
    public bz()
    {
      super();
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      EditText localEditText;
      if ((paramm.a(DialogCode.DC30)) && (paramInt == -1))
        localEditText = (EditText)paramm.getDialog().findViewById(com.viber.voip.R.id.user_edit_name);
      try
      {
        int j = Integer.parseInt(localEditText.getText().toString().trim());
        i = j;
        ViberApplication.getInstance().getEngine(true).getExchanger().getIm2Receiver().onCMessageReceivedMsg(new CMessageReceivedMsg(com.viber.voip.messages.m.j(i), System.currentTimeMillis(), "Test service message", System.currentTimeMillis(), 1024, 0, new Location(0, 0), 0, "", "", null, com.viber.voip.messages.m.j(i), System.currentTimeMillis(), 0, 0, "Forwarding content message info", 0, 0, "", ""));
        super.onDialogAction(paramm, paramInt);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
        {
          localNumberFormatException.printStackTrace();
          int i = 0;
        }
      }
    }
  }

  public static abstract class c extends ViberDialogHandlers.b
  {
    protected Queue<e.a> b;

    public c(Queue<e.a> paramQueue, String paramString)
    {
      super();
      this.b = paramQueue;
    }

    protected abstract void a();

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      HashSet localHashSet = new HashSet();
      e.a locala1 = (e.a)this.b.poll();
      long l1 = -1L;
      boolean bool = locala1.f;
      int i = 0;
      if (bool)
      {
        i = 1;
        l1 = locala1.b;
      }
      localHashSet.add(Long.valueOf(locala1.c));
      final long l2 = l1;
      int j = i;
      Object localObject = locala1;
      e.a locala2;
      int k;
      long l3;
      if ((!this.b.isEmpty()) && (((e.a)this.b.peek()).b == ((e.a)localObject).b))
      {
        locala2 = (e.a)this.b.poll();
        if (!locala2.f)
          break label326;
        k = 1;
        l3 = locala2.b;
      }
      while (true)
      {
        localHashSet.add(Long.valueOf(locala2.c));
        l2 = l3;
        j = k;
        localObject = locala2;
        break;
        switch (paramInt)
        {
        default:
        case -1:
        }
        while (true)
        {
          ViberApplication.getInstance().getMessagesManager().c().a(localHashSet, false, null);
          if (j != 0)
            com.viber.voip.av.a(av.e.d).post(new Runnable()
            {
              public void run()
              {
                ViberApplication.getInstance().getMessagesManager().f().a(l2);
              }
            });
          if (this.b.size() > 0)
            a();
          return;
          String str = ViberDialogHandlers.a().getString(R.string.file_message_upgrade_link);
          MessageEntity localMessageEntity = new com.viber.voip.messages.controller.c.b(((e.a)localObject).b, ((e.a)localObject).a, 0, ((e.a)localObject).g).a(0, str, 0, null, 0);
          ViberApplication.getInstance().getMessagesManager().c().a(localMessageEntity, null);
        }
        label326: l3 = l2;
        k = j;
      }
    }
  }

  public static class ca extends ViberDialogHandlers.cm
  {
    public ca(String paramString)
    {
      super();
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.DC31)) && (paramInt == -1))
      {
        String str = ((EditText)paramm.getDialog().findViewById(com.viber.voip.R.id.user_edit_name)).getText().toString().trim();
        if (!TextUtils.isEmpty(str))
          RemoteSplashActivity.b("Debug", str, 0L, "debug");
      }
      super.onDialogAction(paramm, paramInt);
    }
  }

  static class cb extends m.a
  {
    private String a;
    private String b;
    private String c;
    private s.a d;

    cb(String paramString1, String paramString2, String paramString3, s.a parama)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = parama;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.DC44));
      switch (paramInt)
      {
      default:
        return;
      case -2:
      }
      com.viber.voip.messages.m.a(new com.viber.voip.messages.controller.c.b(0L, this.a, 0, 0).a(0, this.c, 0, null, 0), this.b, new ai.e()
      {
        public void a(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
        {
          Intent localIntent = com.viber.voip.messages.m.a(paramAnonymousConversationItemLoaderEntity.getId(), 0, false, paramAnonymousConversationItemLoaderEntity.isInBusinessInbox(), paramAnonymousConversationItemLoaderEntity.isVlnConversation(), false);
          localIntent.addFlags(335544320);
          if (ViberDialogHandlers.cb.a(ViberDialogHandlers.cb.this) != null)
            ViberDialogHandlers.cb.a(ViberDialogHandlers.cb.this).a(localIntent);
        }
      });
    }
  }

  public static class cc extends ViberDialogHandlers.cm
  {
    public cc()
    {
      super();
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      String str;
      if ((paramm.a(DialogCode.DC45)) && (paramInt == -1))
        str = ((EditText)paramm.getDialog().findViewById(com.viber.voip.R.id.user_edit_name)).getText().toString();
      try
      {
        int i = Integer.parseInt(str);
        if (i > 1)
          d.r.A.a(i);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }

    public void onPrepareDialogView(com.viber.common.dialogs.m paramm, View paramView, int paramInt)
    {
      super.onPrepareDialogView(paramm, paramView, paramInt);
      EditText localEditText = (EditText)paramView.findViewById(com.viber.voip.R.id.user_edit_name);
      localEditText.setInputType(2);
      InputFilter[] arrayOfInputFilter = new InputFilter[1];
      arrayOfInputFilter[0] = new InputFilter.LengthFilter(3);
      localEditText.setFilters(arrayOfInputFilter);
    }
  }

  public static class cd extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.DC46)) && (paramInt == -1))
        ViberApplication.exit(null, true);
    }
  }

  public static class ce extends ViberDialogHandlers.cm
  {
    public ce()
    {
      super();
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.DC47))
      {
        dj.c((EditText)paramm.getDialog().findViewById(com.viber.voip.R.id.user_edit_name));
        super.onDialogAction(paramm, paramInt);
      }
    }

    public void onPrepareDialogView(com.viber.common.dialogs.m paramm, View paramView, int paramInt)
    {
      if (paramm.a(DialogCode.DC47))
      {
        this.b = "";
        EditText localEditText = (EditText)paramView.findViewById(com.viber.voip.R.id.user_edit_name);
        localEditText.setSingleLine(false);
        localEditText.setInputType(131073);
        InputFilter[] arrayOfInputFilter = new InputFilter[1];
        arrayOfInputFilter[0] = new InputFilter.LengthFilter(1000);
        localEditText.setFilters(arrayOfInputFilter);
        localEditText.setHint(R.string.menu_report_community);
        localEditText.setMaxLines(5);
        super.onPrepareDialogView(paramm, paramView, paramInt);
      }
    }
  }

  public static class cf extends m.a
  {
    public static com.viber.voip.report.a.a.e a(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= com.viber.voip.report.a.a.e.values().length))
        return null;
      return com.viber.voip.report.a.a.e.values()[paramInt];
    }

    public void onDialogDataListBind(com.viber.common.dialogs.m paramm, com.viber.common.dialogs.i.a parama)
    {
      TextView localTextView;
      com.viber.voip.report.a.a.e locale;
      if (paramm.a(DialogCode.D_COMMUNITY_REPORT_REASONS))
      {
        localTextView = (TextView)parama.itemView;
        locale = a(((ParcelableInt)parama.a()).getValue());
        if (locale != null);
      }
      else
      {
        return;
      }
      switch (ViberDialogHandlers.1.b[locale.ordinal()])
      {
      default:
        return;
      case 1:
        localTextView.setText(R.string.report_community_promotes_violence_reason);
        return;
      case 2:
        localTextView.setText(R.string.report_community_offensive_content_reason);
        return;
      case 3:
        localTextView.setText(R.string.report_community_child_nudity_reason);
        return;
      case 4:
        localTextView.setText(R.string.report_community_copyright_reason);
        return;
      case 5:
        localTextView.setText(R.string.report_community_endangers_life_reason);
        return;
      case 6:
        localTextView.setText(R.string.report_community_want_to_leave_reason);
        return;
      case 7:
      }
      localTextView.setText(R.string.report_community_other_reason);
    }

    public void onDialogShow(com.viber.common.dialogs.m paramm)
    {
      if (paramm.a(DialogCode.D_COMMUNITY_REPORT_REASONS))
      {
        View localView = ((BottomSheetDialog)paramm.getDialog()).findViewById(android.support.design.R.id.design_bottom_sheet);
        if (localView != null)
          BottomSheetBehavior.from(localView).setPeekHeight(paramm.getResources().getDimensionPixelSize(R.dimen.report_community_reasons_dialog_peek_height));
      }
    }
  }

  public static class cg extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D_DRAW_OVER_OTHER_APPS_MINIMIZED_CALL));
      switch (paramInt)
      {
      default:
        return;
      case -1:
        ViberActionRunner.ay.c(paramm.getContext());
        return;
      case -2:
      }
      d.aj.a.h();
    }
  }

  public static final class ch extends m.a
  {
    private transient com.viber.voip.util.e.h.a a;

    private void a(com.viber.common.dialogs.m paramm)
    {
      if (!ViberApplication.isTablet(paramm.getContext()))
      {
        FragmentActivity localFragmentActivity = paramm.getActivity();
        if (localFragmentActivity != null)
          com.viber.voip.n.a.a(localFragmentActivity, dj.e(localFragmentActivity));
      }
      paramm.dismissAllowingStateLoss();
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      CommunityFollowerData localCommunityFollowerData;
      if (paramm.a(DialogCode.D_FOLLOW_COMMUNITY_WELCOME))
      {
        localCommunityFollowerData = (CommunityFollowerData)paramm.d();
        if (localCommunityFollowerData != null)
          break label28;
        a(paramm);
      }
      label28: com.viber.voip.analytics.g localg;
      do
      {
        return;
        localg = com.viber.voip.analytics.g.a();
        switch (paramInt)
        {
        default:
          return;
        case -1:
        }
      }
      while (!cj.a(true));
      Application localApplication = ViberApplication.getApplication();
      ViberApplication localViberApplication = ViberApplication.getInstance();
      if (TextUtils.isEmpty(UserManager.from(localApplication).getUserData().getViberName()))
      {
        d.i().g(1).a(new ViberDialogHandlers.ck()).d();
        return;
      }
      com.viber.voip.messages.controller.manager.o localo = com.viber.voip.messages.controller.manager.o.a();
      PhoneController localPhoneController = localViberApplication.getEngine(false).getPhoneController();
      GroupController localGroupController = localViberApplication.getMessagesManager().d();
      GroupReferralInfo localGroupReferralInfo = localCommunityFollowerData.groupReferralInfo;
      com.viber.voip.messages.controller.manager.ab localab = com.viber.voip.messages.controller.manager.ab.b();
      EventBus localEventBus = com.viber.voip.h.a.b();
      Handler localHandler = com.viber.voip.av.a(av.e.d);
      if (localGroupReferralInfo != null);
      for (Object localObject = new com.viber.voip.invitelinks.j(localApplication, localab, localHandler, com.viber.voip.av.a(av.e.a), localo, localPhoneController, localGroupController, localg, localCommunityFollowerData, localEventBus, ViberApplication.getInstance().getAppComponent().b()); ; localObject = new com.viber.voip.invitelinks.i(localApplication, localab, localHandler, localo, localPhoneController, localGroupController, localg, localCommunityFollowerData, localEventBus))
      {
        ((com.viber.voip.invitelinks.i)localObject).h();
        a(paramm);
        return;
      }
    }

    public void onDialogShow(com.viber.common.dialogs.m paramm)
    {
      Window localWindow = paramm.getDialog().getWindow();
      if (localWindow != null)
        localWindow.setLayout(paramm.getResources().getDimensionPixelSize(R.dimen.follower_welcome_dialog_width), -2);
      if ((!ViberApplication.isTablet(paramm.getContext())) && (paramm.getActivity() != null))
        com.viber.voip.n.a.d(paramm.getActivity());
    }

    public void onPrepareDialogView(com.viber.common.dialogs.m paramm, View paramView, int paramInt)
    {
      CommunityFollowerData localCommunityFollowerData = (CommunityFollowerData)paramm.d();
      if (localCommunityFollowerData == null)
        return;
      Resources localResources = paramm.getResources();
      TextView localTextView = (TextView)paramView.findViewById(com.viber.voip.R.id.group_name);
      float f;
      if (localCommunityFollowerData.groupName.length() > 28)
      {
        f = localResources.getDimension(R.dimen.follower_welcome_long_group_name_size);
        label56: localTextView.setTextSize(0, f);
        if (!com.viber.voip.util.av.d(localCommunityFollowerData.groupFlags, 1))
          break label174;
      }
      ImageView localImageView;
      label174: for (Drawable localDrawable1 = dc.g(paramm.getContext(), R.attr.conversationsListItemVerifiedAccountBadge); ; localDrawable1 = null)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable1, null);
        localImageView = (ImageView)paramView.findViewById(com.viber.voip.R.id.group_icon);
        if (localImageView == null)
          break;
        if (localCommunityFollowerData.iconUri == null)
          break label180;
        this.a = new ab(localImageView);
        com.viber.voip.util.e.e.a(paramm.getContext()).a(localCommunityFollowerData.iconUri, localImageView, f.a(), this.a);
        return;
        f = localResources.getDimension(R.dimen.follower_welcome_short_group_name_size);
        break label56;
      }
      label180: Context localContext = localImageView.getContext();
      Drawable localDrawable2 = ContextCompat.getDrawable(localContext, R.drawable.ic_follow_community_default);
      df.a(localDrawable2, dc.d(localContext, R.attr.dialogFollowCommunityIconTint), false);
      localImageView.setImageDrawable(localDrawable2);
    }
  }

  public static class ci extends m.a
  {
    private final long a;

    public ci(long paramLong)
    {
      this.a = paramLong;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D_PROGRESS)) && (-1000 == paramInt))
        com.viber.voip.h.a.b().post(new c.b(this.a));
    }
  }

  public static class cj extends m.a
  {
    public static void a(com.viber.common.dialogs.m paramm, Bundle paramBundle)
    {
      if (paramm.c().equals(DialogCode.D_PIN))
      {
        Bundle localBundle = (Bundle)paramm.d();
        if (localBundle != null)
        {
          com.viber.voip.messages.o localo = ((PinDialogLayout)paramm.getDialog().findViewById(com.viber.voip.R.id.pin_root)).getScreen();
          if (localo != null)
          {
            localBundle.putInt("screen_mode", localo.d().ordinal());
            localBundle.putString("extra_pin_string", localo.e());
            localBundle.putString("extra_pin_current_string", localo.p());
            paramm.a(localBundle);
          }
        }
      }
    }

    public static void a(com.viber.common.dialogs.m paramm, View paramView)
    {
      if (paramm.c().equals(DialogCode.D_PIN))
      {
        PinDialogLayout localPinDialogLayout = (PinDialogLayout)paramView;
        if (!ViberApplication.isTablet(paramView.getContext()))
          localPinDialogLayout.setOnDetachListener(new ac(paramm));
        Bundle localBundle = (Bundle)paramm.d();
        if (localBundle != null)
        {
          int i = localBundle.getInt("screen_mode", 0);
          String str = localBundle.getString("extra_pin_string", "");
          localPinDialogLayout.a(i, localBundle.getString("extra_pin_current_string", ""), str);
        }
      }
    }

    public void onDialogSaveState(com.viber.common.dialogs.m paramm, Bundle paramBundle)
    {
      a(paramm, paramBundle);
    }

    public void onPrepareDialogView(com.viber.common.dialogs.m paramm, View paramView, int paramInt)
    {
      a(paramm, paramView);
    }
  }

  public static class ck extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramInt == -1) && ((paramm.a(DialogCode.D1012c)) || (paramm.a(DialogCode.D1012d))))
        ViberActionRunner.bf.a(paramm.getActivity());
    }
  }

  public static class cl extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.DOWNLOAD_ALL_OWNED_STICKER_PACKS)) && (paramInt == -1))
      {
        com.viber.voip.stickers.i locali = com.viber.voip.stickers.i.a();
        Iterator localIterator = locali.h().iterator();
        while (localIterator.hasNext())
        {
          com.viber.voip.stickers.entity.a locala = (com.viber.voip.stickers.entity.a)localIterator.next();
          if ((!locala.h()) && (!locala.l()) && (!locala.g()))
            locali.o(locala.e());
        }
      }
    }
  }

  private static class cm extends m.a
  {
    protected String a = "";
    protected String b = "";

    public cm(String paramString)
    {
      if (paramString == null)
        paramString = "";
      this.a = paramString;
      this.b = this.a;
    }

    protected void a(EditText paramEditText)
    {
      paramEditText.setText(this.a);
      paramEditText.setSelection(paramEditText.length());
    }

    protected boolean a(CharSequence paramCharSequence)
    {
      return !this.a.equals(paramCharSequence.toString());
    }

    public void onDialogShow(com.viber.common.dialogs.m paramm)
    {
      if (paramm == null);
      while (!(paramm.getDialog() instanceof android.support.v7.app.c))
        return;
      ((android.support.v7.app.c)paramm.getDialog()).a(-1).setEnabled(a(this.b));
      dj.b(paramm.getDialog().findViewById(com.viber.voip.R.id.user_edit_name));
    }

    public void onPrepareDialogView(final com.viber.common.dialogs.m paramm, View paramView, int paramInt)
    {
      if (paramInt == R.layout.dialog_content_edit_text)
      {
        EditText localEditText = (EditText)paramView.findViewById(com.viber.voip.R.id.user_edit_name);
        a(localEditText);
        if (!com.viber.common.d.a.g())
          ViberDialogHandlers.a(localEditText);
        ViberDialogHandlers.a(paramm, localEditText);
        localEditText.addTextChangedListener(new TextWatcher()
        {
          public void afterTextChanged(Editable paramAnonymousEditable)
          {
          }

          public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
          }

          public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            ((android.support.v7.app.c)paramm.getDialog()).a(-1).setEnabled(ViberDialogHandlers.cm.this.a(paramAnonymousCharSequence));
            ViberDialogHandlers.cm.this.b = paramAnonymousCharSequence.toString();
          }
        });
      }
    }
  }

  public static class cn extends m.a
  {
    public DialogInterface.OnClickListener a;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramInt == -1) && (this.a != null))
        this.a.onClick(paramm.getDialog(), -1);
    }
  }

  public static class co extends m.a
  {
    public void onDateSet(com.viber.common.dialogs.m paramm, DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramm.a(DialogCode.D_SELECT_DATE))
      {
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.set(paramInt1, paramInt2, paramInt3);
        if (!com.viber.voip.util.ae.a(localCalendar.getTimeInMillis()))
        {
          localCalendar.set(11, 0);
          localCalendar.set(12, 0);
          localCalendar.set(13, 0);
        }
        d.bl.a.a(localCalendar.getTimeInMillis());
        long l = Long.parseLong(d.bl.c.d());
        d.bl.b.a(l + localCalendar.getTimeInMillis());
      }
    }
  }

  private static class cp extends m.a
  {
    private String a;

    public cp(String paramString)
    {
      this.a = paramString;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramInt == -2)
        paramm.getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.a)));
    }
  }

  public static class cq extends m.a
  {
    protected boolean a;

    public cq(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      Context localContext;
      if ((paramInt == -1001) && (this.a))
      {
        localContext = com.viber.common.dialogs.y.a();
        if (!paramm.a(DialogCode.D604))
          break label55;
      }
      label55: for (String str = "Dialog 604 (Payment Succeeded)"; ; str = "Dialog 605 (Payment Succeeded)")
      {
        Intent localIntent = ViberActionRunner.bk.a(localContext, str, null);
        com.viber.common.dialogs.y.a().startActivity(localIntent.addFlags(335544320));
        return;
      }
    }
  }

  public static class cr extends m.a
  {
    public com.viber.voip.messages.conversation.ui.j a;
    public Pin b;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (((paramm.a(DialogCode.D530)) || (paramm.a(DialogCode.D531))) && (-1 == paramInt))
        this.a.a(this.b);
    }
  }

  private static class cs extends m.a
  {
    protected final String a;
    protected final String b;

    public cs(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (-1 == paramInt)
        ViberActionRunner.h.a(paramm.getActivity(), this.a, this.b);
    }
  }

  static final class ct extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D_SYNCING_HISTORY_TO_DESKTOP))
      {
        ViberApplication.getInstance().getMessagesManager().v().a().a(3);
        if (!dj.e(paramm.getContext()))
          av.e.a.a().postDelayed(new Runnable()
          {
            public void run()
            {
              q.c().d();
            }
          }
          , 300L);
      }
    }

    public void onPrepareDialogView(com.viber.common.dialogs.m paramm, View paramView, int paramInt)
    {
      if (R.layout.syncing_history_to_desktop == paramInt)
      {
        SvgImageView localSvgImageView = (SvgImageView)dj.d(paramView, com.viber.voip.R.id.illustration_image);
        Context localContext = paramView.getContext();
        localSvgImageView.loadFromAsset(localContext, dc.c(localContext, R.attr.dialogSyncHistoryToDesktopSyncingAnimationPath), "", 0);
        localSvgImageView.setSvgEnabled(true);
        localSvgImageView.setClock(new CyclicClock(4.167D));
      }
    }
  }

  public static class cu extends m.a
  {
    final long a;
    private final boolean b;

    public cu(long paramLong, boolean paramBoolean)
    {
      this.a = paramLong;
      this.b = paramBoolean;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D377a)) || (paramm.a(DialogCode.D377d)))
      {
        if (-1 != paramInt)
          break label44;
        ViberApplication.getInstance().getMessagesManager().f().c(this.a);
      }
      label44: ai localai;
      do
      {
        return;
        localai = ViberApplication.getInstance().getMessagesManager().c();
        localai.a(Collections.singleton(Long.valueOf(this.a)), false, null);
      }
      while (!this.b);
      localai.c(this.a, null);
    }
  }

  public static class cv extends m.a
  {
    final File a;
    final long b;
    final int c;
    final boolean d;
    final boolean e;
    final boolean f;

    public cv(File paramFile, long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.a = paramFile;
      this.b = paramLong;
      this.c = paramInt;
      this.d = paramBoolean1;
      this.e = paramBoolean2;
      this.f = paramBoolean3;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D377d)) && (-1 == paramInt))
      {
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(Uri.fromFile(this.a));
        Intent localIntent = com.viber.voip.messages.m.a(this.b, this.c, this.d, this.e, this.f, false);
        localIntent.addFlags(67108864);
        localIntent.putParcelableArrayListExtra("share_files_uri", localArrayList);
        paramm.startActivity(localIntent);
      }
    }
  }

  public static abstract class d extends ViberDialogHandlers.b
  {
    protected final e.a b;

    public d(e.a parama, String paramString)
    {
      super();
      this.b = parama;
    }

    protected final void a()
    {
      ViberApplication.getInstance().getMessagesManager().c().a(Collections.singleton(Long.valueOf(this.b.c)), false, null);
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      ViberApplication localViberApplication = ViberApplication.getInstance();
      if (-1 == paramInt)
      {
        MessageEntity localMessageEntity = new com.viber.voip.messages.controller.c.b(this.b.b, this.b.a, 0, this.b.g).a(0, this.a, 0, null, 0);
        localViberApplication.getMessagesManager().c().a(localMessageEntity, null);
      }
    }
  }

  public static abstract class e extends m.a
  {
    public MessagesFragmentModeManager.c a;

    protected final com.viber.voip.analytics.story.e.c a()
    {
      return com.viber.voip.analytics.g.a().c().g();
    }

    protected final void a(com.viber.common.dialogs.m paramm, int paramInt, Map<Long, MessagesFragmentModeManager.b> paramMap)
    {
      String str = paramm.c().code();
      switch (paramInt)
      {
      default:
        return;
      case -1:
        a(paramMap, "Leave and Delete", str);
        return;
      case -3:
        a(paramMap, "Mute", str);
        return;
      case -1000:
      case -2:
      }
      a(paramMap, "Cancel", str);
    }

    protected final void a(com.viber.voip.analytics.story.e.c paramc, String paramString1, String paramString2, String paramString3, Integer paramInteger)
    {
      paramc.a(paramString1, paramString2, paramString3, paramInteger);
    }

    protected final void a(Map<Long, MessagesFragmentModeManager.b> paramMap, String paramString1, String paramString2)
    {
      if (!u.a(paramMap))
      {
        Iterator localIterator = paramMap.values().iterator();
        while (localIterator.hasNext())
        {
          MessagesFragmentModeManager.b localb = (MessagesFragmentModeManager.b)localIterator.next();
          if (!localb.e)
            a(a(), paramString1, paramString2, StoryConstants.g.a.a(localb), n.a(localb.f, localb.j));
        }
      }
    }
  }

  public static class f extends m.a
  {
    private final long a;
    private final long b;
    private final DialogInterface.OnClickListener c;

    public f(long paramLong1, long paramLong2, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a = paramLong1;
      this.b = paramLong2;
      this.c = paramOnClickListener;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramInt == -1) && (this.a >= 0L) && (this.b >= 0L))
        ViberActionRunner.an.a(paramm.getActivity(), this.a);
      if (this.c != null)
        this.c.onClick(paramm.getDialog(), -1);
    }
  }

  public static class g extends m.a
  {
    public DialogInterface.OnClickListener a;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D1004)) && (this.a != null))
        this.a.onClick(paramm.getDialog(), -1);
    }
  }

  public static class h extends ViberDialogHandlers.e
  {
    public Map<Long, MessagesFragmentModeManager.b> b;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D1009))
      {
        if ((-1 == paramInt) && (this.a != null))
          this.a.a(this.b);
        a(paramm, paramInt, this.b);
      }
    }
  }

  public static class i extends m.a
  {
    protected void a(Activity paramActivity)
    {
      ViberActionRunner.bt.d(paramActivity);
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D1019)) && (-1 == paramInt))
      {
        FragmentActivity localFragmentActivity = paramm.getActivity();
        if (localFragmentActivity != null)
          a(localFragmentActivity);
      }
    }
  }

  public static class j extends ViberDialogHandlers.i
  {
    protected void a(Activity paramActivity)
    {
      com.viber.voip.api.scheme.action.y.a(paramActivity, ViberActionRunner.bt.a(paramActivity));
    }
  }

  static class k extends m.a
  {
    public int a;
    public long b;
    public long c;
    public String d;
    public String e;
    public long f;
    public String g;
    public boolean h;
    public TermsAndConditionsActivity.a i;
    public String j;
    public String k;

    private PublicGroupConversationData a()
    {
      return new PublicGroupConversationData(this.b, this.c, this.e, null, this.d, 0, 0, this.f, this.g, this.k);
    }

    private void b()
    {
      com.viber.voip.messages.controller.manager.o.a().b(this.a, this.c, 2, -3);
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      PublicGroupConversationData localPublicGroupConversationData;
      com.viber.voip.messages.controller.publicaccount.ae localae;
      if ((paramm.a(DialogCode.D1021b)) || (paramm.a(DialogCode.D1022a)))
      {
        localPublicGroupConversationData = a();
        Bundle localBundle = (Bundle)paramm.d();
        localae = null;
        if (localBundle != null)
          localae = (com.viber.voip.messages.controller.publicaccount.ae)localBundle.getSerializable("follow_source");
        if (-1 != paramInt)
          break label351;
        d.ap.b.a(false);
        switch (ViberDialogHandlers.1.a[this.i.ordinal()])
        {
        default:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        }
      }
      do
      {
        return;
        ViberApplication.getInstance().getMessagesManager().d().a(this.a, localPublicGroupConversationData.groupId, localPublicGroupConversationData.publicGroupInfo.getGroupUri(), localPublicGroupConversationData.groupName, localPublicGroupConversationData.publicGroupInfo.getIcon(), localPublicGroupConversationData.invitationToken, localPublicGroupConversationData.invitationNumber, false, localae);
        return;
        ViberApplication.getInstance().getMessagesManager().d().a(this.a, localPublicGroupConversationData.groupId, localPublicGroupConversationData.publicGroupInfo.getGroupUri(), localPublicGroupConversationData.groupName, localPublicGroupConversationData.publicGroupInfo.getIcon(), localPublicGroupConversationData.invitationToken, localPublicGroupConversationData.invitationNumber, false, localae);
        paramm.getActivity().startActivity(ViberActionRunner.aq.a(com.viber.common.dialogs.y.a(), false, localPublicGroupConversationData.publicGroupInfo.hasPublicChat(), localPublicGroupConversationData));
        return;
        ViberActionRunner.aq.a(paramm.getActivity(), localPublicGroupConversationData);
        return;
        if (this.k != null)
          ViberApplication.getInstance().getMessagesManager().d().a(this.a, localPublicGroupConversationData.groupId, localPublicGroupConversationData.publicGroupInfo.getGroupUri(), localPublicGroupConversationData.groupName, localPublicGroupConversationData.publicGroupInfo.getIcon(), this.k, localPublicGroupConversationData.invitationToken, localPublicGroupConversationData.invitationNumber, false, localae);
      }
      while (this.j == null);
      paramm.getActivity().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.j)));
      return;
      label351: if (-3 == paramInt)
      {
        String str1 = ap.c().aJ;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Locale.getDefault().getLanguage();
        String str2 = String.format(str1, arrayOfObject);
        TermsAndConditionsActivity.b(paramm.getActivity(), str2, ViberDialogHandlers.a().getString(R.string.dialog_1021_title), this.j, localPublicGroupConversationData, this.i, localae);
        b();
        return;
      }
      b();
    }
  }

  public static class l extends m.a
  {
    public DialogInterface.OnClickListener a;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (((paramm.a(DialogCode.D1032)) || (paramm.a(DialogCode.D1032b)) || (paramm.a(DialogCode.D1032c)) || (paramm.a(DialogCode.D1032d)) || (paramm.a(DialogCode.D1032e)) || (paramm.a(DialogCode.D1032f)) || (paramm.a(DialogCode.D1032g)) || (paramm.a(DialogCode.D1032h))) && (this.a != null))
        this.a.onClick(paramm.getDialog(), -1);
    }
  }

  public static class m extends m.a
  {
    public void onPrepareDialogView(com.viber.common.dialogs.m paramm, View paramView, int paramInt)
    {
      if ((R.layout.dialog_105 == paramInt) || (R.layout.dialog_105e == paramInt))
      {
        TextView localTextView1 = (TextView)paramView.findViewById(com.viber.voip.R.id.header);
        localTextView1.setText(com.viber.common.d.c.b(localTextView1.getText().toString()));
        TextView localTextView2 = (TextView)paramView.findViewById(com.viber.voip.R.id.number);
        localTextView2.setText(com.viber.common.d.c.b(localTextView2.getText().toString()));
        if (R.layout.dialog_105 == paramInt)
        {
          TextView localTextView3 = (TextView)paramView.findViewById(com.viber.voip.R.id.header);
          localTextView3.setText(com.viber.common.d.c.b(localTextView3.getText().toString()));
        }
      }
    }
  }

  public static class n extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D137)) && (paramInt == -1))
      {
        Uri localUri = (Uri)paramm.d();
        if (localUri != null)
          com.viber.voip.api.scheme.i.a(localUri, "URL Schema");
      }
    }

    public void onDialogShow(com.viber.common.dialogs.m paramm)
    {
      android.support.v7.app.c localc = (android.support.v7.app.c)paramm.getDialog();
      CheckBox localCheckBox = (CheckBox)localc.findViewById(com.viber.voip.R.id.approve_check);
      if (localCheckBox != null)
        localc.a(-1).setEnabled(localCheckBox.isChecked());
    }

    public void onPrepareDialogView(final com.viber.common.dialogs.m paramm, View paramView, int paramInt)
    {
      if (paramInt != R.layout.dialog_approve_action)
        return;
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          this.a.toggle();
          ((android.support.v7.app.c)paramm.getDialog()).a(-1).setEnabled(this.a.isChecked());
        }
      });
    }
  }

  public static class o extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D138b)) && (paramInt == -1))
        ViberActionRunner.ay.c(com.viber.common.dialogs.y.a());
    }
  }

  public static class p extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D1400)) && (-1 == paramInt))
      {
        OpenUrlAction localOpenUrlAction = (OpenUrlAction)paramm.d();
        ViberActionRunner.ae.a(ViberApplication.getApplication(), false, localOpenUrlAction);
      }
    }
  }

  public static class q extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramInt != -1) && (paramInt != -1000))
        GenericWebViewActivity.a(paramm.getActivity(), ap.c().ai, paramm.getActivity().getString(R.string.learn_more));
    }
  }

  public static class r extends ViberDialogHandlers.q
  {
    private static final Logger a = ViberEnv.getLogger();
    private int b;
    private byte[] c;

    public r(int paramInt, byte[] paramArrayOfByte)
    {
      this.b = paramInt;
      this.c = paramArrayOfByte;
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D1503)) || (paramm.a(DialogCode.D1504)))
      {
        if (paramInt != -1)
          break label49;
        ViberApplication.getInstance().getEngine(true).getTrustPeerController().handleSecureCallVerified(this.b, this.c);
      }
      label49: 
      while (paramInt != -3)
        return;
      super.onDialogAction(paramm, paramInt);
    }
  }

  public static class s extends ViberDialogHandlers.d
  {
    public s(e.a parama)
    {
      super(ViberDialogHandlers.a().getString(R.string.wink_message_upgrade_link));
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      int i;
      if (paramm.a(DialogCode.D1601))
      {
        final Application localApplication = ViberApplication.getApplication();
        if (-3 != paramInt)
          break label112;
        if (1003 != this.b.e)
          break label106;
        i = 1;
        File localFile = com.viber.voip.util.upload.o.a(String.valueOf(System.currentTimeMillis() / 1000L), i, localApplication);
        if (localFile != null)
        {
          final Uri localUri1 = Uri.parse(this.b.d);
          final Uri localUri2 = Uri.fromFile(localFile);
          av.e.f.a().post(new Runnable()
          {
            public void run()
            {
              com.viber.voip.util.at.a(localUri1, localUri2);
              com.viber.voip.util.upload.o.a(localUri2.getPath());
              com.viber.voip.util.at.d(localApplication, localUri1);
            }
          });
        }
      }
      while (true)
      {
        a();
        return;
        label106: i = 3;
        break;
        label112: super.onDialogAction(paramm, paramInt);
      }
    }
  }

  public static class t extends ViberDialogHandlers.cm
  {
    public t(String paramString)
    {
      super();
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      EditText localEditText;
      PublicAccount localPublicAccount;
      if (paramm.a(DialogCode.D2002a))
      {
        localEditText = (EditText)paramm.getDialog().findViewById(com.viber.voip.R.id.user_edit_name);
        localPublicAccount = (PublicAccount)paramm.d();
        switch (paramInt)
        {
        default:
        case -1:
        }
      }
      while (true)
      {
        dj.c(localEditText);
        super.onDialogAction(paramm, paramInt);
        return;
        String str = localEditText.getText().toString().trim();
        if (!this.a.equals(str))
        {
          int i = ViberApplication.getInstance().getEngine(true).getPhoneController().generateSequence();
          localPublicAccount.setTagLines(str);
          ViberApplication.getInstance().getMessagesManager().d().a(i, 8, localPublicAccount);
        }
      }
    }

    public void onPrepareDialogView(com.viber.common.dialogs.m paramm, View paramView, int paramInt)
    {
      EditText localEditText = (EditText)paramView.findViewById(com.viber.voip.R.id.user_edit_name);
      int i = paramView.getContext().getResources().getInteger(R.integer.communities_about_max_chars);
      InputFilter[] arrayOfInputFilter = new InputFilter[1];
      arrayOfInputFilter[0] = new InputFilter.LengthFilter(i);
      localEditText.setFilters(arrayOfInputFilter);
      localEditText.setHint(R.string.dialog_2002a_hint);
      super.onPrepareDialogView(paramm, paramView, paramInt);
    }
  }

  public static class u extends m.a
  {
    public ProxySettings a;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D208)) && (-1 == paramInt))
      {
        ProxySettingsHolder.update(this.a);
        PixieControllerNativeImpl.getInstance().startProxy();
      }
    }
  }

  public static class v extends ViberDialogHandlers.e
  {
    public Map<Long, MessagesFragmentModeManager.b> b;

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D2108))
      {
        if ((-1 == paramInt) && (this.a != null))
          this.a.a(this.b);
        a(paramm, paramInt, this.b);
      }
    }
  }

  static final class w extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if ((paramm.a(DialogCode.D2116)) && (-1 == paramInt))
      {
        BotReplyRequest localBotReplyRequest = (BotReplyRequest)paramm.d();
        ViberApplication.getInstance().getMessagesManager().h().b(localBotReplyRequest);
      }
    }
  }

  public static final class x extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      BotFavoriteLinksCommunicator.SaveLinkActionMessage localSaveLinkActionMessage1;
      if (paramm.a(DialogCode.D3000))
        localSaveLinkActionMessage1 = (BotFavoriteLinksCommunicator.SaveLinkActionMessage)paramm.d();
      switch (paramInt)
      {
      default:
        return;
      case -1:
        BotFavoriteLinksCommunicator.SaveLinkActionMessage localSaveLinkActionMessage2 = localSaveLinkActionMessage1.buildUpon().a(true).a();
        ViberApplication.getInstance().getMessagesManager().t().a().a(localSaveLinkActionMessage2);
        return;
      case -2:
      }
      f.a.a(com.viber.voip.h.a.b(), localSaveLinkActionMessage1);
    }
  }

  public static class y extends m.a
  {
    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D3004))
      {
        if (-1 != paramInt)
          break label23;
        ViberActionRunner.bl.c(paramm.getActivity());
      }
      label23: 
      while (-2 != paramInt)
        return;
      ViberApplication.getInstance().getUpdateViberManager().a(false, true);
    }
  }

  public static class z extends m.a
  {
    public String a;

    private void a(int paramInt, String paramString)
    {
      if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
        ViberApplication.getInstance().getEngine(true).getDialerController().handleDialogReply(paramInt, paramString);
    }

    public void onDialogAction(com.viber.common.dialogs.m paramm, int paramInt)
    {
      if (paramm.a(DialogCode.D303));
      switch (paramInt)
      {
      default:
        return;
      case -1:
        a(1, this.a);
        return;
      case -2:
      }
      a(2, this.a);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.ViberDialogHandlers
 * JD-Core Version:    0.6.2
 */
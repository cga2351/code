package com.viber.voip.registration;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.viber.common.d.c;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.Engine.InitializedListener;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.secure.SecureActivationController;
import com.viber.jni.secure.SecureSecondaryActivationDelegate;
import com.viber.jni.secure.SecureSecondaryActivationListener;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.api.scheme.i;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.registration.c.d;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.a;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;

public class al extends j
  implements View.OnClickListener
{
  private boolean A;
  private boolean B;
  private String C;
  private String D;
  private boolean E;
  final SecureSecondaryActivationDelegate a = new SecureSecondaryActivationDelegate()
  {
    public void onSecondaryStartActivation(boolean paramAnonymousBoolean)
    {
    }

    public void onSecureActivationCodeReceived(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
    {
      al.b(al.this, new Runnable()
      {
        public void run()
        {
          al.this.b("activation_waiting_dialog");
        }
      });
      al.a(al.this, new f(paramAnonymousString1, new f.a()
      {
        public void a(String paramAnonymous2String, d paramAnonymous2d)
        {
          FragmentActivity localFragmentActivity = al.this.getActivity();
          if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()));
          label103: 
          while (true)
          {
            return;
            al.this.c("activation_waiting_dialog");
            if ((paramAnonymous2d != null) && (paramAnonymous2d.f()));
            for (int i = 1; ; i = 0)
            {
              if (i != 0)
                break label103;
              if (!cj.b(localFragmentActivity))
                break label105;
              if (al.i(al.this))
                break;
              a.j().a(al.this).b(al.this);
              return;
            }
          }
          label105: al.this.x();
        }
      }));
      al.j(al.this).execute(new String[0]);
    }

    public void onSecureSecondaryActivationFinished(int paramAnonymousInt)
    {
      ActivationController localActivationController = ViberApplication.getInstance().getActivationController();
      if (localActivationController.getStep() == 10)
        localActivationController.setStep(12, true);
    }
  };
  private final Logger b = ViberEnv.getLogger(getClass());
  private View c;
  private TextView d;
  private View n;
  private ImageView o;
  private View p;
  private View q;
  private TextView r;
  private PopupWindow s;
  private PopupWindow t;
  private int u;
  private int v;
  private int w;
  private long x;
  private f y;
  private CountDownTimer z;

  private void a(long paramLong)
  {
    b(false);
    this.z = new CountDownTimer(paramLong, 1000L)
    {
      public void onFinish()
      {
        al.a(al.this, new Runnable()
        {
          public void run()
          {
            al.b(al.this, 0L);
            al.b(al.this, true);
          }
        });
      }

      public void onTick(long paramAnonymousLong)
      {
        al.b(al.this, paramAnonymousLong);
      }
    };
    this.z.start();
  }

  private void a(final Bitmap paramBitmap)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        al.a(al.this, true);
        al.c(al.this).setVisibility(8);
        al.d(al.this).setImageBitmap(paramBitmap);
        if ((al.e(al.this)) && (!al.f(al.this)))
          ViberApplication.getInstance().getEngine(true).getSecureActivationController().handleInitiateSecureSyncWithPrimary();
        if (al.g(al.this) > 1L)
        {
          al.a(al.this, al.g(al.this));
          return;
        }
        al.b(al.this, true);
      }
    });
  }

  private PopupWindow b(int paramInt)
  {
    View localView = getLayoutInflater().inflate(paramInt, null, false);
    if (!j())
      localView.setBackgroundResource(R.drawable.info_popup_bg);
    PopupWindow localPopupWindow = new PopupWindow(localView, -2, -2);
    localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.u = localView.getMeasuredHeight();
    this.v = localView.getMeasuredWidth();
    localPopupWindow.setTouchable(true);
    localPopupWindow.setOutsideTouchable(true);
    localPopupWindow.setFocusable(true);
    localPopupWindow.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.transparent)));
    return localPopupWindow;
  }

  private void b(boolean paramBoolean)
  {
    this.p.setEnabled(paramBoolean);
    View localView = this.q;
    int i;
    TextView localTextView;
    int j;
    if (paramBoolean)
    {
      i = 8;
      localView.setVisibility(i);
      if (!j())
      {
        localTextView = this.d;
        j = 0;
        if (!paramBoolean)
          break label58;
      }
    }
    while (true)
    {
      localTextView.setVisibility(j);
      return;
      i = 0;
      break;
      label58: j = 8;
    }
  }

  private void e()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
    if (c.a())
    {
      localLayoutParams.leftMargin = com.viber.voip.util.e.j.a(getContext(), 5.0F);
      localLayoutParams.addRule(1, R.id.click_here);
      return;
    }
    localLayoutParams.rightMargin = com.viber.voip.util.e.j.a(getContext(), 5.0F);
    localLayoutParams.addRule(0, R.id.click_here);
  }

  private void f()
  {
    int i = R.drawable.tooltip_btn;
    if (c.a())
    {
      this.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, i, 0);
      return;
    }
    this.d.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
  }

  private boolean j()
  {
    return !(getActivity() instanceof RegistrationActivity);
  }

  private void k()
  {
    if (this.s != null)
      this.s.dismiss();
    if (this.t != null)
      this.t.dismiss();
    if (this.g != null)
      this.g.dismiss();
  }

  private void l()
  {
    this.s = b(R.layout.tooltip_auth_one);
    this.w = getResources().getDimensionPixelSize(R.dimen.tooltip_left_margin);
  }

  private void m()
  {
    this.t = b(R.layout.tooltip_auth_two);
    this.w = getResources().getDimensionPixelSize(R.dimen.tooltip_left_margin);
    TextView localTextView = (TextView)this.t.getContentView().findViewById(R.id.more);
    String str = localTextView.getText().toString();
    SpannableString localSpannableString = new SpannableString(str);
    localSpannableString.setSpan(new UnderlineSpan(), 0, str.length(), 33);
    localSpannableString.setSpan(new ClickableSpan()
    {
      public void onClick(View paramAnonymousView)
      {
        al.h(al.this).dismiss();
        al.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(al.this.getString(R.string.secure_more_info_link))));
      }
    }
    , 0, str.length(), 33);
    localSpannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.link_text)), 0, str.length(), 33);
    localTextView.setText(localSpannableString);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }

  private void n()
  {
    int[] arrayOfInt;
    int i;
    int j;
    if (!this.s.isShowing())
    {
      arrayOfInt = new int[2];
      this.d.getLocationOnScreen(arrayOfInt);
      if (j())
        break label118;
      if (!dj.c(getActivity()))
        break label82;
      i = arrayOfInt[0] - this.v - this.h;
      if (!dj.c(getActivity()))
        break label103;
      j = arrayOfInt[1];
    }
    while (true)
    {
      this.s.showAtLocation(this.d, 0, i, j);
      return;
      label82: i = arrayOfInt[0] - this.v / 2 + 2 * this.h;
      break;
      label103: j = arrayOfInt[1] + this.d.getMeasuredHeight();
      continue;
      label118: i = arrayOfInt[0] - this.w;
      j = arrayOfInt[1] - this.u;
    }
  }

  private void o()
  {
    if (!this.t.isShowing())
    {
      int[] arrayOfInt = new int[2];
      this.n.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[0] - this.w;
      int j = arrayOfInt[1] - this.u;
      this.t.showAtLocation(this.n, 0, i, j);
    }
  }

  protected int Z_()
  {
    return R.layout.info_popup_secondary;
  }

  protected void a()
  {
    a.h().a(this).b(this);
  }

  public long c()
  {
    return this.x;
  }

  public String d()
  {
    return this.C;
  }

  public boolean onBackPressed()
  {
    if (this.y != null)
      this.y.cancel(true);
    c("activation_waiting_dialog");
    ViberApplication.getInstance().getActivationController().setStep(0, true);
    return true;
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.btn_scan)
    {
      a(30000L);
      ViberApplication.getInstance().getEngine(true).getSecureActivationController().handleInitiateSecureSyncWithPrimary();
    }
    do
    {
      return;
      if (i == R.id.tooltip1)
      {
        n();
        return;
      }
      if (i == R.id.tooltip2)
      {
        o();
        return;
      }
      if (i == R.id.info_btn)
      {
        D();
        return;
      }
      if (i == R.id.learn_more_link)
      {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.secure_faq_more_info_link))));
        return;
      }
    }
    while ((i != R.id.camera_not_working) || (!this.E));
    if (j())
    {
      String str = o.a(21, getResources());
      a.a(this.C, str).a(this).b(this);
      return;
    }
    a.e(this.C).a(this).b(this);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    SecureSecondaryActivationListener localSecureSecondaryActivationListener = ViberApplication.getInstance().getEngine(false).getDelegatesManager().getSecureSecondaryActivationListener();
    SecureSecondaryActivationDelegate[] arrayOfSecureSecondaryActivationDelegate = new SecureSecondaryActivationDelegate[1];
    arrayOfSecureSecondaryActivationDelegate[0] = this.a;
    localSecureSecondaryActivationListener.registerDelegate(arrayOfSecureSecondaryActivationDelegate);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Object localObject;
    label200: Resources localResources;
    if (j())
    {
      View localView2 = paramLayoutInflater.inflate(R.layout.secure_activation_layout_dialog, paramViewGroup, false);
      this.n = localView2.findViewById(R.id.tooltip2);
      this.n.setOnClickListener(this);
      m();
      localObject = localView2;
      l();
      this.d = ((TextView)((View)localObject).findViewById(R.id.tooltip1));
      this.d.setOnClickListener(this);
      f();
      this.r = ((TextView)((View)localObject).findViewById(R.id.camera_not_working));
      this.r.setOnClickListener(this);
      SpannableString localSpannableString = new SpannableString(getString(R.string.camera_not_working));
      localSpannableString.setSpan(new UnderlineSpan(), 0, localSpannableString.length(), 17);
      this.r.setText(localSpannableString);
      this.o = ((ImageView)((View)localObject).findViewById(R.id.qrcode));
      this.c = ((View)localObject).findViewById(R.id.progress);
      this.p = ((View)localObject).findViewById(R.id.btn_scan);
      this.q = ((View)localObject).findViewById(R.id.text2);
      if (paramBundle == null)
        break label354;
      if (paramBundle != null)
      {
        this.x = paramBundle.getLong("delay_time", 0L);
        this.C = paramBundle.getString("secure_key_extra");
        this.A = true;
      }
      this.p.setOnClickListener(this);
      localResources = getResources();
      if (!j())
        break label362;
    }
    label354: label362: for (int i = R.dimen.activate_qrcode_dialog_size; ; i = R.dimen.activate_qrcode_size)
    {
      final int j = localResources.getDimensionPixelSize(i);
      av.a(av.e.g).post(new Runnable()
      {
        public void run()
        {
          Engine localEngine = ViberApplication.getInstance().getEngine(true);
          localEngine.initService();
          localEngine.addInitializedListener(new Engine.InitializedListener()
          {
            public void initialized(Engine paramAnonymous2Engine)
            {
              if (al.a(al.this) == null)
                al.a(al.this, paramAnonymous2Engine.getSecureActivationController().getSecureKeyforQR());
              al.b(al.this, ViberApplication.getInstance().getHardwareParameters().getUdid());
              boolean bool = ViberApplication.isActivated();
              Bitmap localBitmap = com.viber.voip.util.e.j.a(i.a(al.b(al.this), al.a(al.this), bool), al.1.this.a);
              al.a(al.this, localBitmap);
            }
          });
        }
      });
      return localObject;
      View localView1 = paramLayoutInflater.inflate(R.layout.secure_activation_layout, paramViewGroup, false);
      C();
      a(localView1);
      this.i = localView1.findViewById(R.id.info_btn);
      this.i.setOnClickListener(this);
      e();
      localView1.findViewById(R.id.learn_more_link).setOnClickListener(this);
      localObject = localView1;
      break;
      paramBundle = getArguments();
      break label200;
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    k();
    if (this.z != null)
      this.z.cancel();
    ViberApplication.getInstance().getEngine(false).getDelegatesManager().getSecureSecondaryActivationListener().removeDelegate(this.a);
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D128)) && (paramInt == -1))
    {
      ao.a(false);
      w().setCameFromSecondaryActivation(true);
      w().setStep(5, false);
      ViberApplication.exit(getActivity(), true);
    }
    do
    {
      return;
      if ((paramm.a(DialogCode.D132)) && (paramInt == -1))
      {
        this.B = true;
        ActivationController localActivationController = w();
        w().startRegistration(localActivationController.getCountryCode(), localActivationController.getRegNumber(), localActivationController.getKeyChainDeviceKey(), localActivationController.getKeyChainUDID(), true, this.m, this, localActivationController.getKeyChainDeviceKeySource());
        return;
      }
    }
    while (((!paramm.a(DialogCode.D135)) && (!paramm.a(DialogCode.D136))) || (paramInt != -1));
    if (j());
    for (String str1 = "1"; ; str1 = "0")
    {
      String str2 = ap.c().w;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = this.D;
      arrayOfObject[1] = this.C;
      arrayOfObject[2] = str1;
      String str3 = String.format(str2, arrayOfObject);
      da.a(getContext(), str3, getString(R.string.copied_to_clipboard));
      return;
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putLong("delay_time", this.x);
    paramBundle.putString("secure_key_extra", this.C);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.al
 * JD-Core Version:    0.6.2
 */
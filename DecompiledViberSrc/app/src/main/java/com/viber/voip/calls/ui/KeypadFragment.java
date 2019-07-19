package com.viber.voip.calls.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.Settings.System;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Space;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.Engine.InitializedListener;
import com.viber.jni.dialer.DialerController;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.voip.R.anim;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.menu;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.b.a.h;
import com.viber.voip.analytics.story.b.a.h.a;
import com.viber.voip.analytics.story.b.a.h.a.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.model.AggregatedCall;
import com.viber.voip.model.j;
import com.viber.voip.permissions.e;
import com.viber.voip.permissions.m;
import com.viber.voip.permissions.n;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallInitiationId;
import com.viber.voip.phone.call.InCallState;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.m;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.sound.tones.DtmfTone;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.ui.ViberListView;
import com.viber.voip.ui.b.a.a;
import com.viber.voip.ui.o.a;
import com.viber.voip.ui.r;
import com.viber.voip.util.ViberActionRunner.b;
import com.viber.voip.util.ViberActionRunner.o;
import com.viber.voip.util.ViberActionRunner.r;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.util.dr;
import com.viber.voip.util.dr.a;
import com.viber.voip.widget.PhoneTypeField;
import com.viber.voip.widget.PhoneTypeField.a;
import com.viber.voip.widget.PhoneTypeField.c;
import com.viber.voip.widget.ShiftableListView;
import java.io.Serializable;
import org.webrtc.videoengine.EngineDelegate;
import org.webrtc.videoengine.EngineDelegate.VideoEngineEventSubscriber;

public class KeypadFragment extends com.viber.voip.ui.o
  implements View.OnClickListener, View.OnTouchListener, AbsListView.OnScrollListener, Engine.InitializedListener, d.a, ac.a<AggregatedCall>, m.a, PhoneTypeField.a, PhoneTypeField.c
{
  private static b L = new b()
  {
    public void a(int paramAnonymousInt, Fragment paramAnonymousFragment)
    {
    }

    public void i(Intent paramAnonymousIntent)
    {
    }

    public void r()
    {
    }
  };
  private static final Logger d = ViberEnv.getLogger();
  private boolean A;
  private boolean B;
  private boolean C;
  private boolean D = false;
  private KeypadState E;
  private AnimatorSet F;
  private int G;
  private float H;
  private com.viber.common.permission.c I;
  private final com.viber.common.permission.b J;
  private dagger.a<h> K;
  private b M;
  private EngineDelegate.VideoEngineEventSubscriber T;
  private a U;
  Animation.AnimationListener a;
  Animation.AnimationListener b;
  d c;
  private int e;
  private com.b.a.a.a f;
  private o g;
  private v h;
  private com.viber.voip.calls.c i;
  private com.viber.voip.calls.g j;
  private View k;
  private r l;
  private c m;
  private PhoneTypeField n;
  private ImageView o;
  private FloatingActionButton p;
  private FloatingActionButton q;
  private TextWatcher r;
  private Space s;
  private View t;
  private TextView u;
  private IRingtonePlayer v;
  private boolean w;
  private boolean x;
  private Handler y = av.a(av.e.g);
  private boolean z;

  public KeypadFragment()
  {
    super(1);
    Pair[] arrayOfPair = new Pair[5];
    arrayOfPair[0] = m.a(32);
    arrayOfPair[1] = m.a(52);
    arrayOfPair[2] = m.a(41);
    arrayOfPair[3] = m.a(73);
    arrayOfPair[4] = m.a(55);
    this.J = new e(this, arrayOfPair)
    {
      public void onPermissionsGranted(int paramAnonymousInt, String[] paramAnonymousArrayOfString, Object paramAnonymousObject)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 32:
          KeypadFragment.a(KeypadFragment.this, (KeypadFragment.a)paramAnonymousObject, false, true);
          return;
        case 52:
          KeypadFragment.a(KeypadFragment.this, (KeypadFragment.a)paramAnonymousObject, false, false);
          return;
        case 41:
          KeypadFragment.a(KeypadFragment.this, (KeypadFragment.a)paramAnonymousObject, true, false);
          return;
        case 73:
          KeypadFragment.a(KeypadFragment.this, (String)paramAnonymousObject);
          return;
        case 55:
        }
        KeypadFragment.b(KeypadFragment.this, (String)paramAnonymousObject);
      }
    };
    this.M = L;
    this.T = new EngineDelegate.VideoEngineEventSubscriber()
    {
      public void onAvailableFeatures(boolean paramAnonymousBoolean1, final boolean paramAnonymousBoolean2, boolean paramAnonymousBoolean3, boolean paramAnonymousBoolean4)
      {
        KeypadFragment.a(KeypadFragment.this, new Runnable()
        {
          public void run()
          {
            if (KeypadFragment.a(KeypadFragment.this) != null)
            {
              KeypadFragment.a(KeypadFragment.this).a(paramAnonymousBoolean2);
              KeypadFragment.a(KeypadFragment.this).notifyDataSetChanged();
            }
            if (KeypadFragment.b(KeypadFragment.this) != null)
            {
              KeypadFragment.b(KeypadFragment.this).a(paramAnonymousBoolean2);
              KeypadFragment.b(KeypadFragment.this).notifyDataSetChanged();
            }
          }
        });
      }

      public void onFailure(int paramAnonymousInt)
      {
      }

      public void onStartRecvVideo(int paramAnonymousInt)
      {
      }

      public void onStartSendVideo()
      {
      }

      public void onStopRecvVideo(int paramAnonymousInt)
      {
      }

      public void onStopSendVideo()
      {
      }
    };
    this.a = new a.a()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        com.viber.voip.ui.b.a.a(KeypadFragment.c(KeypadFragment.this), 0);
      }
    };
    this.b = new a.a()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        if (TextUtils.isEmpty(KeypadFragment.d(KeypadFragment.this)))
          KeypadFragment.e(KeypadFragment.this);
      }
    };
    this.c = d.a;
  }

  private void a(int paramInt1, final int paramInt2)
  {
    final boolean bool;
    final ShiftableListView localShiftableListView;
    Object localObject;
    AnimatorSet localAnimatorSet;
    if (paramInt1 > paramInt2)
    {
      bool = true;
      this.F = new AnimatorSet();
      localShiftableListView = (ShiftableListView)getListView();
      if ((localShiftableListView.getCount() != 0) && ((!bool) || (!b(this.G))))
        break label186;
      localObject = com.viber.voip.ui.b.a.a(this.s, Math.abs(paramInt2), Math.abs(paramInt1));
      this.t.setTranslationY(paramInt1);
      View localView = this.t;
      float[] arrayOfFloat1 = new float[1];
      arrayOfFloat1[0] = paramInt2;
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(localView, "translationY", arrayOfFloat1);
      localObjectAnimator.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          KeypadFragment.n(KeypadFragment.this).setTranslationY(paramInt2);
          if (bool)
            KeypadFragment.n(KeypadFragment.this).setVisibility(8);
        }

        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (bool)
            KeypadFragment.n(KeypadFragment.this).setVisibility(8);
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          KeypadFragment.n(KeypadFragment.this).setVisibility(0);
        }
      });
      this.F.playTogether(new Animator[] { localObject, localObjectAnimator });
      localAnimatorSet = this.F;
      if (!bool)
        break label288;
    }
    label288: for (Interpolator localInterpolator = com.viber.voip.ui.b.c.d; ; localInterpolator = com.viber.voip.ui.b.c.c)
    {
      localAnimatorSet.setInterpolator(localInterpolator);
      this.F.setDuration(300L);
      this.F.start();
      return;
      bool = false;
      break;
      label186: final int i2;
      final int i1;
      if (bool)
      {
        i2 = -paramInt2;
        i1 = paramInt1;
      }
      while (true)
      {
        localShiftableListView.setShiftY(i2);
        float[] arrayOfFloat2 = new float[2];
        arrayOfFloat2[0] = i2;
        arrayOfFloat2[1] = i1;
        ValueAnimator localValueAnimator = ValueAnimator.ofFloat(arrayOfFloat2);
        c(0);
        localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            localShiftableListView.setShiftY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue());
          }
        });
        localValueAnimator.addListener(new AnimatorListenerAdapter()
        {
          private void a()
          {
            if (bool)
            {
              localShiftableListView.setShiftY(i1);
              KeypadFragment.a(KeypadFragment.this, i1);
              return;
            }
            localShiftableListView.setShiftY(i2);
            KeypadFragment.a(KeypadFragment.this, i1);
          }

          public void onAnimationCancel(Animator paramAnonymousAnimator)
          {
            a();
          }

          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            a();
          }
        });
        localObject = localValueAnimator;
        break;
        i1 = -paramInt1;
        i2 = paramInt2;
      }
    }
  }

  private void a(View paramView, Bundle paramBundle)
  {
    boolean bool;
    if (paramBundle == null)
    {
      bool = true;
      this.z = bool;
      this.G = getResources().getDimensionPixelOffset(R.dimen.search_bar_height);
      this.m = new c(paramView, this.a, this.b);
      this.n = ((PhoneTypeField)paramView.findViewById(R.id.type_field));
      this.n.requestFocus();
      this.n.setInputType(0);
      this.n.setOnClickListener(this);
      this.n.setContactLookupListener(this);
      this.n.setPhoneFieldTextChangeListener(this);
      if (com.viber.common.d.a.g())
        this.n.setShowSoftInputOnFocus(false);
      if (paramBundle == null)
        break label250;
    }
    label250: for (String str = paramBundle.getString("number"); ; str = null)
    {
      if (!TextUtils.isEmpty(str))
        this.n.setPhoneFieldText(str);
      this.l = new r();
      paramView.findViewById(R.id.searchBack).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          KeypadFragment.f(KeypadFragment.this);
          KeypadFragment.e(KeypadFragment.this);
        }
      });
      this.u = ((TextView)paramView.findViewById(R.id.search));
      this.u.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          KeypadFragment.this.f();
        }
      });
      paramView.findViewById(R.id.searchClear).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          KeypadFragment.g(KeypadFragment.this).setText("");
        }
      });
      this.s = ((Space)paramView.findViewById(R.id.spacer));
      this.t = paramView.findViewById(R.id.searchContainer);
      return;
      bool = false;
      break;
    }
  }

  private void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
      a(paramBoolean);
    this.E = KeypadState.CLOSED;
  }

  private void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    s();
    a(new a(paramString, paramBoolean3), paramBoolean1, paramBoolean2);
  }

  private void a(boolean paramBoolean)
  {
    if (this.C)
      return;
    if (paramBoolean)
      a(-this.G, 0);
    while (true)
    {
      this.C = true;
      return;
      this.t.setVisibility(0);
      this.t.setTranslationY(0.0F);
      ((ShiftableListView)getListView()).setShiftY(0.0F);
      c(this.G);
    }
  }

  private void b(View paramView, Bundle paramBundle)
  {
    if (paramBundle != null)
      this.E = ((KeypadState)paramBundle.getParcelable("keypad_opened"));
    PhoneKeypadButton localPhoneKeypadButton1 = (PhoneKeypadButton)paramView.findViewById(R.id.one);
    PhoneKeypadButton localPhoneKeypadButton2 = (PhoneKeypadButton)paramView.findViewById(R.id.two);
    PhoneKeypadButton localPhoneKeypadButton3 = (PhoneKeypadButton)paramView.findViewById(R.id.three);
    PhoneKeypadButton localPhoneKeypadButton4 = (PhoneKeypadButton)paramView.findViewById(R.id.four);
    PhoneKeypadButton localPhoneKeypadButton5 = (PhoneKeypadButton)paramView.findViewById(R.id.five);
    PhoneKeypadButton localPhoneKeypadButton6 = (PhoneKeypadButton)paramView.findViewById(R.id.six);
    PhoneKeypadButton localPhoneKeypadButton7 = (PhoneKeypadButton)paramView.findViewById(R.id.seven);
    PhoneKeypadButton localPhoneKeypadButton8 = (PhoneKeypadButton)paramView.findViewById(R.id.eight);
    PhoneKeypadButton localPhoneKeypadButton9 = (PhoneKeypadButton)paramView.findViewById(R.id.nine);
    PhoneKeypadButton localPhoneKeypadButton10 = (PhoneKeypadButton)paramView.findViewById(R.id.zero);
    PhoneKeypadButton localPhoneKeypadButton11 = (PhoneKeypadButton)paramView.findViewById(R.id.pound);
    PhoneKeypadButton localPhoneKeypadButton12 = (PhoneKeypadButton)paramView.findViewById(R.id.star);
    this.p = ((FloatingActionButton)paramView.findViewById(R.id.fab_dial));
    this.o = ((ImageView)paramView.findViewById(R.id.deleteButton));
    this.q = ((FloatingActionButton)paramView.findViewById(R.id.fab_keypad));
    this.H = j();
    if (this.E != KeypadState.OPENED)
      this.q.setTranslationY(-this.H);
    localPhoneKeypadButton1.setOnClickListener(new e("1", DtmfTone.ONE));
    localPhoneKeypadButton2.setOnClickListener(new e("2", DtmfTone.TWO));
    localPhoneKeypadButton3.setOnClickListener(new e("3", DtmfTone.THREE));
    localPhoneKeypadButton4.setOnClickListener(new e("4", DtmfTone.FOUR));
    localPhoneKeypadButton5.setOnClickListener(new e("5", DtmfTone.FIVE));
    localPhoneKeypadButton6.setOnClickListener(new e("6", DtmfTone.SIX));
    localPhoneKeypadButton7.setOnClickListener(new e("7", DtmfTone.SEVEN));
    localPhoneKeypadButton8.setOnClickListener(new e("8", DtmfTone.EIGHT));
    localPhoneKeypadButton9.setOnClickListener(new e("9", DtmfTone.NINE));
    localPhoneKeypadButton10.setOnClickListener(new e("0", DtmfTone.ZERO));
    localPhoneKeypadButton12.setOnClickListener(new e("*", DtmfTone.ASTERIX));
    localPhoneKeypadButton11.setOnClickListener(new e("#", DtmfTone.POUND));
    localPhoneKeypadButton10.setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        KeypadFragment.this.a(DtmfTone.ASTERIX);
        KeypadFragment.i(KeypadFragment.this);
        KeypadFragment.g(KeypadFragment.this).getPhoneFieldEditable().append("+");
        KeypadFragment.j(KeypadFragment.this);
        return true;
      }
    });
    this.o.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        KeypadFragment.i(KeypadFragment.this);
        Editable localEditable = KeypadFragment.g(KeypadFragment.this).getPhoneFieldEditable();
        int i = KeypadFragment.g(KeypadFragment.this).getPhoneFieldLength();
        int j = KeypadFragment.g(KeypadFragment.this).getSelectionStart();
        int k = KeypadFragment.g(KeypadFragment.this).getSelectionEnd();
        if (((j < 0) || (k < 0) || (k - j < 0)) && (i > 0))
          localEditable.replace(i - 1, i, "");
        while (true)
        {
          KeypadFragment.j(KeypadFragment.this);
          return;
          if (j < k)
            localEditable.replace(j, k, "");
          else if (j > 0)
            localEditable.replace(j - 1, k, "");
        }
      }
    });
    this.o.setOnLongClickListener(new View.OnLongClickListener()
    {
      public boolean onLongClick(View paramAnonymousView)
      {
        KeypadFragment.k(KeypadFragment.this);
        KeypadFragment.g(KeypadFragment.this).setPhoneFieldText("");
        KeypadFragment.l(KeypadFragment.this).setPressed(false);
        KeypadFragment.this.getActivity().getIntent().setData(null);
        KeypadFragment.j(KeypadFragment.this);
        return true;
      }
    });
    registerForContextMenu(this.p);
    this.p.setLongClickable(false);
    this.p.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.r = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
      }

      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        KeypadFragment.c(KeypadFragment.this, paramAnonymousCharSequence.toString().trim());
        ImageView localImageView = KeypadFragment.l(KeypadFragment.this);
        if (KeypadFragment.g(KeypadFragment.this).getPhoneFieldLength() != 0);
        for (boolean bool = true; ; bool = false)
        {
          localImageView.setEnabled(bool);
          KeypadFragment.m(KeypadFragment.this).setText(paramAnonymousCharSequence.toString().trim());
          return;
        }
      }
    };
    this.n.addTextChangedListener(this.r);
  }

  private void b(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1;
    String[] arrayOfString;
    if (paramBoolean1)
    {
      i1 = 41;
      arrayOfString = n.h;
    }
    while (this.I.a(arrayOfString))
    {
      c(parama, paramBoolean1, paramBoolean2);
      return;
      if (paramBoolean2)
      {
        i1 = 32;
        arrayOfString = n.g;
      }
      else
      {
        i1 = 52;
        arrayOfString = n.h;
      }
    }
    this.I.a(this, i1, arrayOfString, parama);
  }

  private void b(ConferenceInfo paramConferenceInfo)
  {
    startActivity(ViberActionRunner.r.a(requireActivity(), paramConferenceInfo, "Keypad"));
  }

  private void b(String paramString)
  {
    if (getView() != null)
      getListView().setSelection(0);
    this.P = paramString;
    String str = paramString.replaceFirst("[-.]*", "");
    if (PhoneNumberUtils.isGlobalPhoneNumber(str))
      str = dr.a(ViberApplication.getInstance(), str, str);
    if (TextUtils.isEmpty(paramString))
    {
      this.c = d.a;
      a(this.c);
      this.l.a(str);
    }
    while (true)
    {
      this.A = false;
      this.B = false;
      if (this.j != null)
        this.j.f(str);
      if (this.h != null)
        this.h.a(str);
      if (this.i != null)
        this.i.a(str, paramString);
      return;
      this.c = d.b;
    }
  }

  private void b(boolean paramBoolean)
  {
    if (!this.C)
      return;
    if (paramBoolean)
      a(0, -this.G);
    while (true)
    {
      this.C = false;
      return;
      this.t.setTranslationY(-this.G);
      this.t.setVisibility(8);
      ((ShiftableListView)getListView()).setShiftY(0.0F);
      if (this.F != null)
        this.F.cancel();
      c(0);
    }
  }

  private boolean b(int paramInt)
  {
    ShiftableListView localShiftableListView = (ShiftableListView)getListView();
    boolean bool1;
    if ((localShiftableListView.getCount() == 0) || (localShiftableListView.getChildAt(-1 + localShiftableListView.getChildCount()) == null))
      bool1 = true;
    int i1;
    int i2;
    do
    {
      return bool1;
      i1 = localShiftableListView.getLastVisiblePosition();
      i2 = -1 + localShiftableListView.getCount();
      bool1 = false;
    }
    while (i1 != i2);
    int i3 = localShiftableListView.getChildAt(-1 + localShiftableListView.getChildCount()).getBottom() - localShiftableListView.getBottom();
    if ((i3 >= 0) && (i3 <= paramInt));
    for (boolean bool2 = true; ; bool2 = false)
      return bool2;
  }

  private void c(int paramInt)
  {
    if ((!com.viber.common.d.a.d()) && (this.s.getHeight() == 0));
    for (int i1 = 1; ; i1 = 0)
    {
      dj.a(paramInt, this.s);
      if (i1 != 0)
        this.s.requestLayout();
      return;
    }
  }

  private void c(a parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((parama != null) && (!TextUtils.isEmpty(parama.a)))
    {
      CallInitiationId.noteNextCallInitiationAttemptId();
      h localh = (h)this.K.get();
      h.a.a locala1 = h.a.i();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = parama.a;
      h.a.a locala2 = locala1.a(arrayOfString).a("Keypad").a(paramBoolean1, paramBoolean2).b(paramBoolean1);
      boolean bool = false;
      if (!paramBoolean1)
        bool = true;
      localh.b(locala2.a(bool).a());
      if (paramBoolean1)
        ViberApplication.getInstance().getEngine(true).getDialerController().handleDialViberOut(parama.a);
    }
    else
    {
      return;
    }
    ViberApplication.getInstance().getEngine(true).getDialerController().handleDial(parama.a, paramBoolean2);
  }

  private void c(String paramString)
  {
    startActivity(new Intent("android.intent.action.CALL", Uri.fromParts("tel", paramString, null)));
  }

  private void c(boolean paramBoolean)
  {
    b(paramBoolean);
    this.E = KeypadState.OPENED;
  }

  private void d(String paramString)
  {
    if (this.I.a(n.k))
    {
      e(paramString);
      return;
    }
    this.I.a(this, 73, n.k, paramString);
  }

  private boolean d(boolean paramBoolean)
  {
    if ((getActivity() == null) || (this.m.a()))
      return false;
    this.n.requestFocus();
    if (paramBoolean)
    {
      this.p.setAlpha(0.0F);
      ObjectAnimator localObjectAnimator1 = com.viber.voip.ui.b.a.b(this.q, 100);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.q, "translationY", new float[] { 0.0F });
      localObjectAnimator2.setDuration(300L);
      localObjectAnimator2.setStartDelay(100L);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator2, localObjectAnimator1 });
      localAnimatorSet.start();
      this.m.a(true, true);
    }
    while (true)
    {
      c(paramBoolean);
      return true;
      this.q.setVisibility(8);
      this.m.a(true, false);
    }
  }

  private void e(String paramString)
  {
    ViberActionRunner.b.a(getActivity(), 10, paramString, "Keypad");
  }

  private boolean e(boolean paramBoolean)
  {
    if ((getActivity() == null) || (!this.m.a()))
      return false;
    if (paramBoolean)
    {
      this.D = true;
      com.viber.voip.ui.b.a.a(this.q, 200);
      this.m.a(false, true);
    }
    while (true)
    {
      a(this.n.getText().toString(), paramBoolean);
      return true;
      this.q.setVisibility(0);
      this.m.a(false, false);
    }
  }

  private void i()
  {
    AnimatorListenerAdapter local19 = new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        KeypadFragment.a(KeypadFragment.this, false);
        if (KeypadFragment.h(KeypadFragment.this) != null)
          KeypadFragment.h(KeypadFragment.this).r();
      }
    };
    FloatingActionButton localFloatingActionButton = this.q;
    float[] arrayOfFloat = new float[1];
    arrayOfFloat[0] = (-this.H);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localFloatingActionButton, "translationY", arrayOfFloat);
    if (!this.mIsTablet)
    {
      localObjectAnimator2 = ObjectAnimator.ofFloat(getView(), "alpha", new float[] { 0.0F });
      localObjectAnimator2.addListener(local19);
      localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      localAnimatorSet.setDuration(200L);
      localAnimatorSet.setInterpolator(com.viber.voip.ui.b.c.a);
      localAnimatorSet.start();
    }
    while (this.M == null)
    {
      ObjectAnimator localObjectAnimator2;
      AnimatorSet localAnimatorSet;
      return;
    }
    localObjectAnimator1.addListener(local19);
    localObjectAnimator1.start();
  }

  private int j()
  {
    TypedArray localTypedArray = null;
    try
    {
      Context localContext1 = getContext();
      localTypedArray = null;
      int i2;
      if (localContext1 != null)
      {
        Context localContext2 = getContext();
        int[] arrayOfInt = new int[1];
        arrayOfInt[0] = R.attr.actionBarSize;
        localTypedArray = localContext2.obtainStyledAttributes(arrayOfInt);
        int i1 = localTypedArray.getDimensionPixelSize(0, getResources().getDimensionPixelOffset(R.dimen.bottom_navigation_height));
        i2 = i1;
      }
      while (true)
      {
        return i2;
        int i3 = getResources().getDimensionPixelOffset(R.dimen.bottom_navigation_height);
        i2 = i3;
        localTypedArray = null;
      }
    }
    finally
    {
      if (localTypedArray != null)
        localTypedArray.recycle();
    }
  }

  private void k()
  {
    if (this.E == KeypadState.OPENED)
      d(false);
    if (this.E == KeypadState.CLOSED)
      a(false);
  }

  private void l()
  {
    this.e = dc.d(requireContext(), R.attr.mainBackgroundColor);
    this.f = new com.b.a.a.a();
    b();
    a(this.c);
    ((ViberListView)getListView()).a(this);
    getListView().setFastScrollEnabled(false);
    ListView localListView = getListView();
    int i1;
    if (this.mIsTablet)
    {
      i1 = 1;
      localListView.setChoiceMode(i1);
      if (this.mIsTablet)
        dj.a(getListView(), 1);
      if (com.viber.common.d.a.g())
        getListView().setNestedScrollingEnabled(true);
      this.f.notifyDataSetChanged();
      setListAdapter(this.f);
      if (!TextUtils.isEmpty(this.P))
        b(this.P);
      if (this.k != null)
      {
        this.q.setAlpha(1.0F);
        if (this.mIsTablet)
          break label284;
        if (!this.z)
          break label270;
        this.k.setAlpha(0.0F);
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.k, "alpha", new float[] { 1.0F });
        localObjectAnimator.setDuration(200L);
        localObjectAnimator.setInterpolator(com.viber.voip.ui.b.c.a);
        localObjectAnimator.addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationStart(Animator paramAnonymousAnimator)
          {
            KeypadFragment.p(KeypadFragment.this).setBackgroundColor(KeypadFragment.o(KeypadFragment.this));
          }
        });
        localObjectAnimator.start();
      }
    }
    while (true)
    {
      if (this.E == null)
        d(true);
      this.t.setVisibility(0);
      b(this.n.getText().toString());
      return;
      i1 = 0;
      break;
      label270: this.k.setBackgroundColor(this.e);
      continue;
      label284: this.k.setBackgroundColor(this.e);
    }
  }

  private void m()
  {
    if ((this.U != null) && (TextUtils.isEmpty(this.n.getPhoneTypeText())))
    {
      this.n.setPhoneFieldText(this.U.a);
      return;
    }
    a(PhoneNumberUtils.stripSeparators(this.n.getPhoneTypeText()), false, false, true);
  }

  private void n()
  {
    if (this.l.f())
      this.l.a(false, this.P);
  }

  private void p()
  {
    if (this.g != null)
    {
      this.g.notifyDataSetChanged();
      this.h.notifyDataSetChanged();
      if ((this.i != null) && (this.i.d()) && (this.l != null))
        this.l.a(this.i.r());
    }
    D();
  }

  private void q()
  {
    this.n.setText("");
    b(false);
  }

  private void r()
  {
    ImageView localImageView;
    if (this.o != null)
    {
      localImageView = this.o;
      if (this.n.getPhoneFieldLength() == 0)
        break label30;
    }
    label30: for (boolean bool = true; ; bool = false)
    {
      localImageView.setEnabled(bool);
      return;
    }
  }

  private void s()
  {
    if (this.x)
      w().vibrate(35);
  }

  private void v()
  {
    if (this.x)
      w().vibrate(200);
  }

  private IRingtonePlayer w()
  {
    if (this.v == null)
      this.v = ViberApplication.getInstance().getRingtonePlayer();
    return this.v;
  }

  protected int a(d paramd)
  {
    if ((this.f == null) || (isDetached()) || (!isAdded()))
      return 0;
    this.f.a(this.g, false);
    this.f.a(this.h, false);
    int i1 = 11.a[paramd.ordinal()];
    int i2 = 0;
    switch (i1)
    {
    case 1:
    default:
    case 2:
    }
    while (true)
    {
      this.f.notifyDataSetChanged();
      return i2;
      this.f.a(this.h, true);
      int i3 = 0 + this.h.getCount();
      this.f.a(this.g, true);
      i2 = i3 + this.g.getCount();
    }
  }

  protected void a(int paramInt)
  {
    this.M.a(paramInt, this);
  }

  public void a(Intent paramIntent)
  {
    if (paramIntent.hasExtra("open_keypad_number"))
    {
      String str = paramIntent.getStringExtra("open_keypad_number");
      if ((!TextUtils.isEmpty(str)) && (this.n != null))
      {
        this.n.setText(str);
        this.n.setSelection(str.length());
      }
      paramIntent.removeExtra("open_keypad_number");
    }
  }

  public void a(View paramView, AggregatedCall paramAggregatedCall)
  {
    m();
  }

  void a(a parama, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    String str = parama.a.replaceAll("[^*0-9]+", "");
    int i1;
    if ((str.length() == 3) || (PhoneNumberUtils.isEmergencyNumber(str)))
      i1 = 1;
    while (i1 != 0)
      if (this.I.a(n.q))
      {
        c(str);
        return;
        i1 = 0;
      }
      else
      {
        this.I.a(getActivity(), 55, n.q, str);
        return;
      }
    this.U = parama;
    dr.a(parama.a, new dr.a()
    {
      public void onCheckStatus(boolean paramAnonymousBoolean, int paramAnonymousInt, ParticipantSelector.Participant paramAnonymousParticipant, com.viber.voip.model.entity.g paramAnonymousg)
      {
        if ((paramAnonymousInt == 0) && (KeypadFragment.r(KeypadFragment.this).a()))
          if (!paramBoolean2)
            if (KeypadFragment.c(KeypadFragment.this) != null)
              KeypadFragment.c(KeypadFragment.this).showContextMenu();
        do
        {
          return;
          KeypadFragment.b(KeypadFragment.this, KeypadFragment.r(KeypadFragment.this), false, true);
          return;
          if (((1 == paramAnonymousInt) || (7 == paramAnonymousInt)) && (KeypadFragment.r(KeypadFragment.this).a()))
          {
            KeypadFragment.b(KeypadFragment.this, KeypadFragment.r(KeypadFragment.this), true, paramBoolean2);
            return;
          }
          if (6 == paramAnonymousInt)
          {
            KeypadFragment.b(KeypadFragment.this, KeypadFragment.r(KeypadFragment.this), true, paramBoolean2);
            return;
          }
        }
        while ((paramAnonymousInt != 0) && (1 != paramAnonymousInt) && (4 != paramAnonymousInt) && (7 != paramAnonymousInt) && (2 != paramAnonymousInt) && (-1 != paramAnonymousInt));
        KeypadFragment.b(KeypadFragment.this, KeypadFragment.r(KeypadFragment.this), paramBoolean1, paramBoolean2);
      }
    });
  }

  public void a(ConferenceInfo paramConferenceInfo)
  {
    s();
    b(paramConferenceInfo);
  }

  void a(DtmfTone paramDtmfTone)
  {
    if (!this.w)
      return;
    w().playDtmfTone(paramDtmfTone);
  }

  public void a(String paramString)
  {
  }

  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (((paramBoolean1) || ((paramBoolean3) && (!paramBoolean4))) && (!paramBoolean2))
    {
      a(paramString, true, false, true);
      return;
    }
    if (paramBoolean2)
    {
      a(paramString, false, true, true);
      return;
    }
    a(paramString, false, false, true);
  }

  protected boolean a()
  {
    return KeypadState.OPENED == this.E;
  }

  protected void b()
  {
    this.h = new v(getActivity(), this.j);
    this.h.a(this);
    this.g = new o(getActivity(), this.i, this.h, null, true);
    this.g.a(this);
    this.f.a(this.g);
    this.f.a(this.h);
  }

  public void b(View paramView, AggregatedCall paramAggregatedCall)
  {
  }

  public boolean c()
  {
    return (this.i != null) && (this.i.d());
  }

  public void d()
  {
  }

  protected void e()
  {
    if ((this.A) && (this.B))
    {
      this.l.a(this.P);
      n();
      return;
    }
    String str = this.n.getText().toString().trim();
    this.l.a(true, str);
  }

  public void f()
  {
    if (this.E == KeypadState.OPENED)
      return;
    d(true);
  }

  protected void h()
  {
    this.l.a(getView(), this, this, this, this);
    this.i.p();
    this.i.i();
    this.j.p();
    this.j.i();
    l();
  }

  public void initialized(Engine paramEngine)
  {
    ISoundService localISoundService = ViberApplication.getInstance().getSoundService();
    CallInfo localCallInfo = ViberApplication.getInstance().getEngine(false).getCurrentCall();
    if (localCallInfo != null)
      localISoundService.setSpeakerphoneOn(localCallInfo.getInCallState().isSpeakerEnabled());
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    this.i = new com.viber.voip.calls.c(getActivity(), getLoaderManager(), null, this);
    this.j = new com.viber.voip.calls.g(getActivity(), getLoaderManager(), this);
    if ((this.mIsTablet) && (getTag() != null))
      getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
    a(getActivity().getIntent());
    super.onActivityCreated(paramBundle);
    if ((paramBundle != null) && (paramBundle.getBoolean("key_close_keypad_animation_running")) && (this.M != null))
      this.M.r();
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10) && (paramInt2 == -1))
      this.n.a();
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (!(paramActivity instanceof b))
      throw new ClassCastException("Activity must implement fragment's callbacks.");
    this.M = ((b)paramActivity);
  }

  public boolean onBackPressed()
  {
    boolean bool = true;
    if (isHidden())
      bool = false;
    while (e(bool))
      return bool;
    q();
    i();
    return bool;
  }

  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((i1 == R.id.fab_dial) || (i1 == R.id.callButtonView))
      m();
    String str;
    do
    {
      do
      {
        return;
        if (i1 == R.id.fab_keypad)
        {
          d(true);
          return;
        }
      }
      while ((i1 != R.id.icon) && (i1 != R.id.root));
      if (ao.f())
      {
        m();
        return;
      }
      str = this.i.r();
    }
    while (TextUtils.isEmpty(str));
    d(str);
  }

  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    int i1 = paramMenuItem.getItemId();
    if (i1 == R.id.menu_call_viber_out)
    {
      b(this.U, true, false);
      return true;
    }
    if (i1 == R.id.menu_call_free)
    {
      b(this.U, false, false);
      return true;
    }
    return super.onContextItemSelected(paramMenuItem);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.I = com.viber.common.permission.c.a(getActivity());
    this.K = ViberApplication.getInstance().getLazyUserStartsCallEventCollector();
    setHasOptionsMenu(true);
  }

  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    getActivity().getMenuInflater().inflate(R.menu.context_menu_keypad, paramContextMenu);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.k = paramLayoutInflater.inflate(R.layout.fragment_keypad, paramViewGroup, false);
    ViewCompat.setElevation(this.k, R.dimen.bottom_navigation_elevation);
    a(this.k, paramBundle);
    b(this.k, paramBundle);
    return this.k;
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.g = null;
    this.h = null;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.i.q();
    this.i.j();
    this.j.q();
    this.j.j();
    if (this.g != null)
      this.g.a(null);
    if (this.h != null)
      this.h.a(null);
    if (this.n != null)
    {
      this.n.removeTextChangedListener(this.r);
      this.r = null;
    }
  }

  public void onDetach()
  {
    super.onDetach();
    this.M = L;
  }

  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    d(paramInt);
    Object localObject = getListAdapter().getItem(paramInt);
    if (localObject == null);
    while (true)
    {
      return;
      AggregatedCall localAggregatedCall;
      com.viber.voip.model.a locala2;
      Intent localIntent;
      if ((localObject instanceof AggregatedCall))
      {
        localAggregatedCall = (AggregatedCall)localObject;
        locala2 = localAggregatedCall.getContact();
        if ((localAggregatedCall.isTypeViberGroup()) && (localAggregatedCall.hasConferenceInfo()))
          localIntent = ViberActionRunner.r.a(requireActivity(), localAggregatedCall.getAggregatedHash(), localAggregatedCall.getConferenceInfo(), "Keypad");
      }
      while (localIntent != null)
      {
        this.M.i(localIntent);
        return;
        if (locala2 != null)
        {
          j localj2 = locala2.n();
          String str3;
          label138: String str4;
          label152: long l1;
          String str5;
          String str6;
          String str7;
          Uri localUri;
          if (localj2 != null)
          {
            str3 = localj2.c();
            if (localj2 == null)
              break label257;
            str4 = localj2.a();
            l1 = locala2.getId();
            str5 = locala2.q();
            str6 = localAggregatedCall.getCanonizedNumber();
            str7 = locala2.k();
            localUri = locala2.o();
            if ((!localAggregatedCall.isViberCall()) || (!locala2.p()))
              break label263;
          }
          label257: label263: for (boolean bool = true; ; bool = false)
          {
            localIntent = ViberActionRunner.o.a(l1, str5, str6, str3, str7, localUri, bool, localAggregatedCall.getAggregatedHash(), str4);
            break;
            str3 = null;
            break label138;
            str4 = null;
            break label152;
          }
        }
        localIntent = ViberActionRunner.o.a(localAggregatedCall.getCanonizedNumber(), localAggregatedCall.isViberCall(), localAggregatedCall.getAggregatedHash());
        continue;
        if ((localObject instanceof com.viber.voip.model.a))
        {
          com.viber.voip.model.a locala1 = (com.viber.voip.model.a)localObject;
          j localj1 = locala1.n();
          String str1;
          if (localj1 != null)
          {
            str1 = localj1.c();
            label336: if (localj1 == null)
              break label398;
          }
          label398: for (String str2 = localj1.a(); ; str2 = null)
          {
            localIntent = ViberActionRunner.o.a(false, locala1.getId(), locala1.k(), locala1.q(), locala1.o(), null, str1, str2);
            break;
            str1 = null;
            break label336;
          }
        }
        localIntent = null;
      }
    }
  }

  public void onLoadFinished(d paramd, boolean paramBoolean)
  {
    if ((isDetached()) || (!isAdded()))
      return;
    if ((paramd instanceof com.viber.voip.calls.c))
      this.A = true;
    if ((paramd instanceof com.viber.voip.calls.g))
      this.B = true;
    if ((this.A) && (this.B))
    {
      p();
      a(this.c);
      n();
    }
    e();
  }

  public void onLoaderReset(d paramd)
  {
  }

  public void onPause()
  {
    super.onPause();
    ViberApplication.getInstance().getEngine(false).removeInitializedListener(this);
    EngineDelegate.removeEventSubscriber(this.T);
  }

  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    super.onPrepareOptionsMenu(paramMenu);
    if (this.mIsTablet)
    {
      MenuItem localMenuItem = paramMenu.findItem(R.id.menu_search);
      if (localMenuItem != null)
        localMenuItem.setVisible(false);
    }
  }

  public void onResume()
  {
    int i1 = 1;
    super.onResume();
    ViberApplication.getInstance().getEngine(false).addInitializedListener(this);
    this.n.b();
    Uri localUri = getActivity().getIntent().getData();
    if ((localUri != null) && (localUri.getScheme() != null) && (localUri.getScheme().equals("tel")))
      this.n.setPhoneFieldText(localUri.getSchemeSpecificPart());
    if (Settings.System.getInt(getActivity().getContentResolver(), "dtmf_tone", i1) == i1);
    while (true)
    {
      this.w = i1;
      this.x = d.m.d.d();
      EngineDelegate.addEventSubscriber(this.T);
      return;
      i1 = 0;
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("number", this.n.getPhoneTypeText());
    paramBundle.putParcelable("keypad_opened", this.E);
    paramBundle.putBoolean("key_close_keypad_animation_running", this.D);
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
      e(true);
  }

  public void onStart()
  {
    super.onStart();
    this.I.a(this.J);
  }

  public void onStop()
  {
    this.I.b(this.J);
    super.onStop();
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
      e(true);
    return false;
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    k();
  }

  public void u_()
  {
    r();
  }

  static enum KeypadState
    implements Parcelable
  {
    public static final Parcelable.Creator<KeypadState> CREATOR = new Parcelable.Creator()
    {
      public KeypadFragment.KeypadState a(Parcel paramAnonymousParcel)
      {
        return KeypadFragment.KeypadState.values()[paramAnonymousParcel.readInt()];
      }

      public KeypadFragment.KeypadState[] a(int paramAnonymousInt)
      {
        return new KeypadFragment.KeypadState[paramAnonymousInt];
      }
    };

    static
    {
      CLOSED = new KeypadState("CLOSED", 1);
      KeypadState[] arrayOfKeypadState = new KeypadState[2];
      arrayOfKeypadState[0] = OPENED;
      arrayOfKeypadState[1] = CLOSED;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(ordinal());
    }
  }

  static class a
    implements Serializable
  {
    String a;
    final boolean b;

    a(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
    }

    boolean a()
    {
      return this.b;
    }

    public String toString()
    {
      return "CallData{mNumber='" + this.a + '\'' + ", mIsCallFromKeypad=" + this.b + '}';
    }
  }

  public static abstract interface b extends o.a
  {
    public abstract void i(Intent paramIntent);

    public abstract void r();
  }

  private static class c
  {
    private View a;
    private Animation b;
    private Animation c;

    public c(View paramView, Animation.AnimationListener paramAnimationListener1, Animation.AnimationListener paramAnimationListener2)
    {
      this.a = paramView.findViewById(R.id.keypad_container);
      Context localContext = this.a.getContext();
      if ((dj.c(localContext)) && (!ViberApplication.isTablet(localContext)))
        this.b = AnimationUtils.loadAnimation(localContext, R.anim.dialpad_slide_in_right);
      for (this.c = AnimationUtils.loadAnimation(localContext, R.anim.dialpad_slide_out_right); ; this.c = AnimationUtils.loadAnimation(localContext, R.anim.dialpad_slide_out_bottom))
      {
        this.b.setInterpolator(com.viber.voip.ui.b.c.c);
        this.c.setInterpolator(com.viber.voip.ui.b.c.d);
        this.b.setAnimationListener(paramAnimationListener1);
        this.c.setAnimationListener(paramAnimationListener2);
        return;
        this.b = AnimationUtils.loadAnimation(localContext, R.anim.dialpad_slide_in_bottom);
      }
    }

    public void a(boolean paramBoolean1, boolean paramBoolean2)
    {
      View localView;
      if (this.a != null)
      {
        localView = this.a;
        if (!paramBoolean1)
          break label45;
      }
      label45: for (int i = 0; ; i = 8)
      {
        localView.setVisibility(i);
        if (paramBoolean2)
        {
          if (!paramBoolean1)
            break;
          this.a.startAnimation(this.b);
        }
        return;
      }
      this.a.startAnimation(this.c);
    }

    public boolean a()
    {
      return (this.a != null) && (this.a.getVisibility() == 0);
    }
  }

  static enum d
  {
    static
    {
      d[] arrayOfd = new d[2];
      arrayOfd[0] = a;
      arrayOfd[1] = b;
    }
  }

  private class e
    implements View.OnClickListener
  {
    private final String c;
    private final DtmfTone d;
    private Runnable e = new Runnable()
    {
      public void run()
      {
        KeypadFragment.this.a(KeypadFragment.e.a(KeypadFragment.e.this));
        KeypadFragment.i(KeypadFragment.this);
      }
    };

    static
    {
      if (!KeypadFragment.class.desiredAssertionStatus());
      for (boolean bool = true; ; bool = false)
      {
        a = bool;
        return;
      }
    }

    public e(String paramDtmfTone, DtmfTone arg3)
    {
      if ((!a) && (paramDtmfTone == null))
        throw new AssertionError();
      this.c = paramDtmfTone;
      Object localObject;
      this.d = localObject;
    }

    public void onClick(View paramView)
    {
      int i = KeypadFragment.g(KeypadFragment.this).getSelectionStart();
      KeypadFragment.g(KeypadFragment.this).getPhoneFieldEditable().insert(i, this.c);
      KeypadFragment.j(KeypadFragment.this);
      KeypadFragment.g(KeypadFragment.this).requestFocus();
      KeypadFragment.q(KeypadFragment.this).removeCallbacks(this.e);
      KeypadFragment.q(KeypadFragment.this).postDelayed(this.e, 50L);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.KeypadFragment
 * JD-Core Version:    0.6.2
 */
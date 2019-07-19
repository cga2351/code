package com.appboy.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.appboy.a;
import com.appboy.f.c;
import com.appboy.f.i;
import com.appboy.f.j;

@Deprecated
public class AppboyFeedbackFragment extends Fragment
{
  private static final String TAG = c.a(AppboyFeedbackFragment.class);
  private Button mCancelButton;
  private View.OnClickListener mCancelListener;
  private EditText mEmailEditText;
  private boolean mErrorMessageShown;
  private IFeedbackFinishedListener mFeedbackFinishedListener;
  private CheckBox mIsBugCheckBox;
  private EditText mMessageEditText;
  private int mOriginalSoftInputMode;
  private Button mSendButton;
  private TextWatcher mSendButtonWatcher;
  private View.OnClickListener mSendListener;

  private void clearData()
  {
    this.mEmailEditText.setText("");
    this.mMessageEditText.setText("");
    this.mIsBugCheckBox.setChecked(false);
    this.mErrorMessageShown = false;
    this.mEmailEditText.setError(null);
    this.mMessageEditText.setError(null);
  }

  private void displayEmailTextError(int paramInt)
  {
    if (getActivity() != null)
    {
      this.mEmailEditText.setError(getResources().getString(paramInt));
      return;
    }
    c.d(TAG, "Activity is null. Cannot set feedback form email error message");
  }

  private void displayMessageTextError(int paramInt)
  {
    if (getActivity() != null)
    {
      this.mMessageEditText.setError(getResources().getString(paramInt));
      return;
    }
    c.d(TAG, "Activity is null. Cannot set feedback form message error.");
  }

  private boolean ensureSendButton()
  {
    return validatedMessage() & validatedEmail();
  }

  private void hideSoftKeyboard()
  {
    FragmentActivity localFragmentActivity = getActivity();
    localFragmentActivity.getWindow().setSoftInputMode(this.mOriginalSoftInputMode);
    if (localFragmentActivity.getCurrentFocus() != null)
      ((InputMethodManager)localFragmentActivity.getSystemService("input_method")).hideSoftInputFromWindow(localFragmentActivity.getCurrentFocus().getWindowToken(), 0);
  }

  private boolean validatedEmail()
  {
    boolean bool1 = true;
    boolean bool2;
    if ((this.mEmailEditText.getText() != null) && (!i.c(this.mEmailEditText.getText().toString())) && (j.a(this.mEmailEditText.getText().toString())))
    {
      bool2 = bool1;
      if ((this.mEmailEditText.getText() == null) || (!i.c(this.mEmailEditText.getText().toString())))
        break label91;
    }
    while (true)
    {
      if (!bool2)
        break label96;
      this.mEmailEditText.setError(null);
      return bool2;
      bool2 = false;
      break;
      label91: bool1 = false;
    }
    label96: if (bool1)
    {
      displayEmailTextError(R.string.com_appboy_feedback_form_empty_email);
      return bool2;
    }
    displayEmailTextError(R.string.com_appboy_feedback_form_invalid_email);
    return bool2;
  }

  private boolean validatedMessage()
  {
    if ((this.mMessageEditText.getText() != null) && (!i.c(this.mMessageEditText.getText().toString())));
    for (boolean bool = true; bool; bool = false)
    {
      this.mMessageEditText.setError(null);
      return bool;
    }
    displayMessageTextError(R.string.com_appboy_feedback_form_invalid_message);
    return bool;
  }

  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.mSendButtonWatcher = new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (AppboyFeedbackFragment.this.mErrorMessageShown)
          AppboyFeedbackFragment.this.ensureSendButton();
      }

      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }
    };
    this.mCancelListener = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppboyFeedbackFragment.this.hideSoftKeyboard();
        if (AppboyFeedbackFragment.this.mFeedbackFinishedListener != null)
          AppboyFeedbackFragment.this.mFeedbackFinishedListener.onFeedbackFinished(AppboyFeedbackFragment.FeedbackResult.CANCELLED);
        AppboyFeedbackFragment.this.clearData();
      }
    };
    this.mSendListener = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (AppboyFeedbackFragment.this.ensureSendButton())
        {
          AppboyFeedbackFragment.this.hideSoftKeyboard();
          boolean bool = AppboyFeedbackFragment.this.mIsBugCheckBox.isChecked();
          String str1 = AppboyFeedbackFragment.this.mMessageEditText.getText().toString();
          String str2 = AppboyFeedbackFragment.this.mEmailEditText.getText().toString();
          if (AppboyFeedbackFragment.this.mFeedbackFinishedListener != null)
            str1 = AppboyFeedbackFragment.this.mFeedbackFinishedListener.beforeFeedbackSubmitted(str1);
          a.a(AppboyFeedbackFragment.this.getActivity()).a(str2, str1, bool);
          if (AppboyFeedbackFragment.this.mFeedbackFinishedListener != null)
            AppboyFeedbackFragment.this.mFeedbackFinishedListener.onFeedbackFinished(AppboyFeedbackFragment.FeedbackResult.SUBMITTED);
          AppboyFeedbackFragment.this.clearData();
          return;
        }
        AppboyFeedbackFragment.access$002(AppboyFeedbackFragment.this, true);
      }
    };
    setRetainInstance(true);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.com_appboy_feedback, paramViewGroup, false);
    this.mCancelButton = ((Button)localView.findViewById(R.id.com_appboy_feedback_cancel));
    this.mSendButton = ((Button)localView.findViewById(R.id.com_appboy_feedback_send));
    this.mIsBugCheckBox = ((CheckBox)localView.findViewById(R.id.com_appboy_feedback_is_bug));
    this.mMessageEditText = ((EditText)localView.findViewById(R.id.com_appboy_feedback_message));
    this.mEmailEditText = ((EditText)localView.findViewById(R.id.com_appboy_feedback_email));
    this.mMessageEditText.addTextChangedListener(this.mSendButtonWatcher);
    this.mEmailEditText.addTextChangedListener(this.mSendButtonWatcher);
    this.mCancelButton.setOnClickListener(this.mCancelListener);
    this.mSendButton.setOnClickListener(this.mSendListener);
    return localView;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    this.mMessageEditText.removeTextChangedListener(this.mSendButtonWatcher);
    this.mEmailEditText.removeTextChangedListener(this.mSendButtonWatcher);
  }

  public void onResume()
  {
    super.onResume();
    a.a(getActivity()).c();
    FragmentActivity localFragmentActivity = getActivity();
    Window localWindow = localFragmentActivity.getWindow();
    this.mOriginalSoftInputMode = localWindow.getAttributes().softInputMode;
    localWindow.setSoftInputMode(16);
    a.a(localFragmentActivity).c();
  }

  @Deprecated
  public static enum FeedbackResult
  {
    static
    {
      CANCELLED = new FeedbackResult("CANCELLED", 1);
      FeedbackResult[] arrayOfFeedbackResult = new FeedbackResult[2];
      arrayOfFeedbackResult[0] = SUBMITTED;
      arrayOfFeedbackResult[1] = CANCELLED;
    }
  }

  @Deprecated
  public static abstract interface IFeedbackFinishedListener
  {
    public abstract String beforeFeedbackSubmitted(String paramString);

    public abstract void onFeedbackFinished(AppboyFeedbackFragment.FeedbackResult paramFeedbackResult);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.AppboyFeedbackFragment
 * JD-Core Version:    0.6.2
 */
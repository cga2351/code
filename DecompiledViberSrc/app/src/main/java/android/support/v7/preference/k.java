package android.support.v7.preference;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.view.View;

public class k extends RecyclerViewAccessibilityDelegate
{
  final RecyclerView a;
  final AccessibilityDelegateCompat b = super.getItemDelegate();
  final AccessibilityDelegateCompat c = new AccessibilityDelegateCompat()
  {
    public void onInitializeAccessibilityNodeInfo(View paramAnonymousView, AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat)
    {
      k.this.b.onInitializeAccessibilityNodeInfo(paramAnonymousView, paramAnonymousAccessibilityNodeInfoCompat);
      int i = k.this.a.getChildAdapterPosition(paramAnonymousView);
      RecyclerView.Adapter localAdapter = k.this.a.getAdapter();
      if (!(localAdapter instanceof h));
      Preference localPreference;
      do
      {
        return;
        localPreference = ((h)localAdapter).a(i);
      }
      while (localPreference == null);
      localPreference.a(paramAnonymousAccessibilityNodeInfoCompat);
    }

    public boolean performAccessibilityAction(View paramAnonymousView, int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      return k.this.b.performAccessibilityAction(paramAnonymousView, paramAnonymousInt, paramAnonymousBundle);
    }
  };

  public k(RecyclerView paramRecyclerView)
  {
    super(paramRecyclerView);
    this.a = paramRecyclerView;
  }

  public AccessibilityDelegateCompat getItemDelegate()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.k
 * JD-Core Version:    0.6.2
 */
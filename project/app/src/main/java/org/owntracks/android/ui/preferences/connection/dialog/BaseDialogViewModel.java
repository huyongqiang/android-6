package org.owntracks.android.ui.preferences.connection.dialog;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import org.owntracks.android.support.Preferences;

public abstract class BaseDialogViewModel extends BaseObservable implements MaterialDialog.SingleButtonCallback{
    protected Preferences preferences;
    BaseDialogViewModel(Preferences preferences) {
        this.preferences = preferences;
        load();
    }

    @Override
    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
        if(which == DialogAction.POSITIVE) {
            save();
        }
    }

    public abstract void onActivityResult(int requestCode, int resultCode, Intent data);
    abstract void load();
    abstract void save();
}

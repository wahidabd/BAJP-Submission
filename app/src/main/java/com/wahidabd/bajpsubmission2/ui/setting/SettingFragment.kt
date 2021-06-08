package com.wahidabd.bajpsubmission2.ui.setting

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.wahidabd.bajpsubmission2.R


class SettingFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.setting_xml, rootKey)
    }
}
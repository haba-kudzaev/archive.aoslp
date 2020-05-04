/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package o1310.rx1310.aoslp;

import android.app.Activity;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;

public class SettingsActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getFragmentManager().beginTransaction().replace(android.R.id.content, new LauncherSettingsFragment()).commit();
		
    }

    public static class LauncherSettingsFragment extends PreferenceFragment implements OnPreferenceChangeListener {

		private SwitchPreference prefAllowRotation;
		private Preference prefAppVersion;

        @Override
        public void onCreate(Bundle b) {
            super.onCreate(b);
			
            addPreferencesFromResource(R.xml.launcher_preferences);

           	prefAllowRotation = (SwitchPreference) findPreference(Utilities.ALLOW_ROTATION_PREFERENCE_KEY);
            prefAllowRotation.setPersistent(false);

			prefAppVersion = findPreference(Utilities.AOSLP_VERSION_PREFERENCE_KEY);
			prefAppVersion.setSummary(Utilities.getAppVersion(getContext()));
			
            Bundle bn = new Bundle();
            	   bn.putBoolean(LauncherSettings.Settings.EXTRA_DEFAULT_VALUE, false);
				   
            Bundle value = getActivity().getContentResolver().call(LauncherSettings.Settings.CONTENT_URI, LauncherSettings.Settings.METHOD_GET_BOOLEAN, Utilities.ALLOW_ROTATION_PREFERENCE_KEY, bn);
            
			prefAllowRotation.setChecked(value.getBoolean(LauncherSettings.Settings.EXTRA_VALUE));
            prefAllowRotation.setOnPreferenceChangeListener(this);
			
        }

        @Override
        public boolean onPreferenceChange(Preference p, Object o) {
			
            Bundle bn = new Bundle();
            	   bn.putBoolean(LauncherSettings.Settings.EXTRA_VALUE, (Boolean) o);
				   
            getActivity().getContentResolver().call(LauncherSettings.Settings.CONTENT_URI, LauncherSettings.Settings.METHOD_SET_BOOLEAN, p.getKey(), bn);
			
            return true;
			
        }
		
    }
	
}

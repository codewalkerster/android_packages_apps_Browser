/*
 * Copyright (C) 2011 The Android Open Source Project
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

package com.android.browser.preferences;

import android.content.Context;
import android.preference.SeekBarPreference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.KeyEvent;
import android.util.Log ;
import com.android.browser.BrowserSettings;
import com.android.browser.R;

public class ContrastSeekBarSummaryPreference  extends SeekBarSummaryPreference {

    public ContrastSeekBarSummaryPreference(
            Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ContrastSeekBarSummaryPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ContrastSeekBarSummaryPreference(Context context) {
        super(context);
    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() != KeyEvent.ACTION_UP) {
            if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
                int val = getProgress()-1 ;
                if (val >= 0 && val <=30) {
                    updateSummary(val);
                }
                return true;
            }

            if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
                int val = getProgress()+1 ;
                if (val >= 0 && val <=20) {
                    updateSummary(val);
                }
                return true;
            }
        }
        return false;
    }

    void updateSummary(int value){
        setProgress(value);
        int newValue = (10 + value)*10;
        super.setSummary(newValue + "%");
    }
}

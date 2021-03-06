/*
 * Copyright (C) 2017 Adrian Ulrich <adrian@blinkenlights.ch>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>. 
 */

package ch.blinkenlights.android.vanilla;

import android.app.Activity;
import android.os.Bundle;
import android.content.SharedPreferences;

import java.io.File;

public class FilebrowserStartActivity extends FolderPickerActivity {

	private SharedPreferences.Editor mPrefEditor;

	@Override  
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mPrefEditor = PlaybackService.getSettings(this).edit();

		// Make sure that we display the current selection
		File startPath = FileUtils.getFilesystemBrowseStart(this);
		setCurrentDirectory(startPath);
	}


	@Override
	public void onFolderSelected(File directory) {
		mPrefEditor.putString(PrefKeys.FILESYSTEM_BROWSE_START, directory.getAbsolutePath());
		mPrefEditor.commit();
		finish();
	}

}

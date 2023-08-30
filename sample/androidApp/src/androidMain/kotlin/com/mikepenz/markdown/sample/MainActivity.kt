package com.mikepenz.markdown.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import me.sujanpoudel.playdeals.common.PlayDealsAppAndroid

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      PlayDealsAppAndroid()
    }
  }
}

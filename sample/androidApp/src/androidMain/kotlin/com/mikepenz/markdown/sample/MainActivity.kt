package com.mikepenz.markdown.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mikepenz.markdown.sample.common.SampleMainAndroid

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      SampleMainAndroid()
    }
  }
}

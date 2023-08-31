package com.mikepenz.markdown.sample.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.mikepenz.markdown.compose.Markdown
import com.mikepenz.markdown.model.ImageTransformer
import io.kamel.core.Resource
import io.kamel.image.asyncPainterResource

object KamalImageLoader : ImageTransformer {

    @Composable
    override fun transform(link: String): Painter? {
        return when (val resource = asyncPainterResource(link)) {
            is Resource.Failure -> null
            is Resource.Loading -> null
            is Resource.Success -> resource.value
        }
    }
}


@Composable
fun SampleMainView() {
    SampleTheme {
        Scaffold {
            val markdown = """
            # Title 1
        
            To get started with this library, just provide some Markdown.
           
            Usually Markdown will contain different characters *or different styles*, which can **change** just as you ~write~ different text. 
           
            Sometimes it will even contain images within the text
            
            ![Image](https://avatars.githubusercontent.com/u/1476232?v=4)
            
            Images can be of different sizes
                        
            ![Image](https://placehold.co/100x100/png)
            
            ![Image](https://placehold.co/100x1200/png)

            ![Image](https://placehold.co/1200x100/png)
            
            After installing GPG Suite (or your preferred solution) first create a new key.
            
            Supports reference links:
            [Reference Link Test][1] 
            
            But can also be a auto link: https://mikepenz.dev
            
            Links with links as label are also handled:
            [https://mikepenz.dev](https://mikepenz.dev)
            
            Some `inline` code is also supported!
            
            ## Title 2
            
            ### Title 3
            
            [1]: https://mikepenz.dev/
            
            - [Text] Some text
            
            ```
            Code block test
            ```
        """.trimIndent()

            val scrollState = rememberScrollState()

            Markdown(
                markdown,
                imageTransformer = KamalImageLoader,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(16.dp)
                    .padding(bottom = 48.dp, top = 56.dp)
            )

        }
    }
}

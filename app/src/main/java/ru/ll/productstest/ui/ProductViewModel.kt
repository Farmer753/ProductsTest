package ru.ll.productstest.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import coil.compose.AsyncImage
import ru.ll.productstest.R

class ProductViewModel : ViewModel() {
    @Preview(widthDp = 180, heightDp = 200)
    @Composable
    fun ColumnSample() {
        Column {
            AsyncImage(
                model = "https://s3-alpha-sig.figma.com/img/6861/f5d0/b3bbfc363f115fdeba2e726f1f1a6c29?Expires=1714953600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=RlN19IwLYucTqPZ9RGgaIO5OZKMHiZoz9jqaBg7Gexp0DU~o3XA1dUx3-nn9t3QFUqjZMjXvkR1SRtNDZV-oRynBoG2ty4h9Y~qiC-15SU2im-zSG-6E9~YvLjhw~WNSXE0-pP9BHFmkEXqhLl8eSRQo9DrZlng-1ze0hjll79htaF6kKxDzyv6yNlWAEiqjcIL7CZQ6W4m1iq4~S~wRzda6odMpWdSSRVHkGeNxBMsCUpa9hALkPLIAWHSu8~qaOhfX8AcsCNFlrXM1xVErdVYerIEax1kHCKwOqqBmB0xb6gP8aJL0pq6lL8gmMJINfeBesU4i20-XAAN8BumXBA__",
                contentDescription = "test",
                placeholder = debugPlaceholder(R.drawable.ic_launcher_background),
                modifier = Modifier
                    .height(375.dp)
                    .width(375.dp)
            )
            TextExample()
        }
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Top,
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White),
//        ) {
//
//            repeat(5) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth(fraction = 0.9f)
//                        .height(36.dp)
//                        .clip(shape = RoundedCornerShape(6.dp))
//                        .background(Color.Gray)
//                ){
//                    AsyncImage(
//                        model = "https://s3-alpha-sig.figma.com/img/6861/f5d0/b3bbfc363f115fdeba2e726f1f1a6c29?Expires=1714953600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=RlN19IwLYucTqPZ9RGgaIO5OZKMHiZoz9jqaBg7Gexp0DU~o3XA1dUx3-nn9t3QFUqjZMjXvkR1SRtNDZV-oRynBoG2ty4h9Y~qiC-15SU2im-zSG-6E9~YvLjhw~WNSXE0-pP9BHFmkEXqhLl8eSRQo9DrZlng-1ze0hjll79htaF6kKxDzyv6yNlWAEiqjcIL7CZQ6W4m1iq4~S~wRzda6odMpWdSSRVHkGeNxBMsCUpa9hALkPLIAWHSu8~qaOhfX8AcsCNFlrXM1xVErdVYerIEax1kHCKwOqqBmB0xb6gP8aJL0pq6lL8gmMJINfeBesU4i20-XAAN8BumXBA__",
//                        contentDescription = "test",
//                        placeholder = debugPlaceholder(R.drawable.ic_launcher_background)
//                    )
//                }
//
//
//                Spacer(modifier = Modifier.height(4.dp))
//            }
    }

    @Composable
    fun TextExample() {
        Column(modifier = Modifier.padding(30.dp)) {

            Text(
                text = "Том Ям",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            Text(
                text = "Кокосовое молоко, кальмары, креветки,\n" +
                        "помидоры черри, грибы вешанки",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                )
            )
        }
    }
}

@Composable
fun debugPlaceholder(@DrawableRes debugPreview: Int) =
    if (LocalInspectionMode.current) {
        painterResource(id = debugPreview)
    } else {
        null
    }

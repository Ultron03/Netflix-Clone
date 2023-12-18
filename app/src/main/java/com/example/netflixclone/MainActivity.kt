package com.example.netflixclone

import android.os.Bundle
import android.text.method.SingleLineTransformationMethod
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixclone.ui.theme.NetflixCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .verticalScroll(rememberScrollState())
            ) {

                TopBarView()
                TopCategorySelector()
                FeaturedMovieSection()
                WatchItAgain("Watch it Again")
                WatchItAgain(title = "Drama Movie")
                WatchItAgain(title = "New Release")
                WatchItAgain(title = "Action Movie")
                WatchItAgain("Watch it Again")
                WatchItAgain(title = "Drama Movie")
                WatchItAgain(title = "New Release")
                WatchItAgain(title = "Action Movie")
            }

        }
    }
}

@Preview
@Composable
fun TopBarView(){
    Row (modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    )
    {
        Image(
            painter = painterResource(id = R.drawable.netflix_logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(80.dp)
                .padding(12.dp)

        )

        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                modifier = Modifier
                    .size(80.dp)
                    .padding(12.dp)


            )
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "User",
                modifier = Modifier
                    .size(80.dp)
                    .padding(12.dp)
            )
        }

    }
}

@Preview
@Composable
fun TopCategorySelector(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ){
        Text(
            text = "TV Shows",
            fontSize = 21.sp,
            color = Color.White
        )
        Text(
            text = "Moview",
            fontSize = 21.sp,
            color = Color.White
        )
        Row {
            Text(
                text = "Categories",
                fontSize = 21.sp,
                color = Color.White
            )
            Image(
                painter = painterResource(id = R.drawable.ic_dropdown),
                contentDescription ="DropDown",
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Preview
@Composable
fun FeaturedMovieSection(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.poster_1),
            contentDescription ="Poster1",
            modifier = Modifier
                .size(400.dp)
                .padding(30.dp),

        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 60.dp, end = 60.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Coming-of-age",
                color = Color.White,
                fontSize = 14.sp,

            )
            Text(
                text = "Period drama",
                color = Color.White,
                fontSize = 14.sp

            )
            Text(
                text = "Scott",
                color = Color.White,
                fontSize = 14.sp

            )
            Text(
                text = "Scott",
                color = Color.White,
                fontSize = 14.sp,

            )
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "Add to list",
                    )
                Text(
                    text = "My List",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
            val context = LocalContext.current
            Button(
                onClick = { Toast.makeText(context,"Play was Click" , Toast.LENGTH_SHORT).show() },
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(text = "Play", fontSize = 24.sp, color = Color.Black)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.ic_information),
                    contentDescription = "Add to list",
                )
                Text(
                    text = "Information",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Composable

fun WatchItAgain(title:String){
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            fontSize = 28.sp,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(top = 12.dp, start = 12.dp)

        )
        LazyRow(modifier = Modifier.padding(6.dp)){
            itemsIndexed(GetShuffle()){ index, item ->
                SingleImageManager(imageRes = item.image)
            }
        }
    }
}

fun GetShuffle() :List<MovieItemModel> {
    val listOfMoview = mutableListOf<MovieItemModel>()
    listOfMoview.add(MovieItemModel(R.drawable.poster_1))
    listOfMoview.add(MovieItemModel(R.drawable.poster_2))
    listOfMoview.add(MovieItemModel(R.drawable.poster_4))
    listOfMoview.add(MovieItemModel(R.drawable.poster_5))
    listOfMoview.add(MovieItemModel(R.drawable.poster_6))
    listOfMoview.add(MovieItemModel(R.drawable.poster_7))

    listOfMoview.shuffle()
    return listOfMoview
}

@Composable
fun SingleImageManager(
    imageRes:Int
){
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = "",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .height(180.dp)
            .width(150.dp)
            .padding(6.dp)
        )
}



data class MovieItemModel(
    val image:Int
)